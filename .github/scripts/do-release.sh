#!/usr/bin/env bash

usage() {
    local ret="${1:-0}"
    local program_name=$(basename "$0")

    cat<<FIN
Usage: $program_name

Updates WPEWebKit and WebKitGTK to a new release, if available.
Changes for each update are committed into new separated commits.

OPTIONS:
    --gtk               Do WebKitGTK release only.
    --wpe               Do WPEWebKit release only.
FIN

    exit "$ret"
}

fatal() {
    echo "Fatal: $@"
    exit 1
}

parse_args() {
    while [[ $# -gt 0 ]]; do
        arg="$1"; shift
        if [[ "$arg" == "--help" || "$arg" == "-h" ]]; then
            usage
        elif [[ "$arg" == "--gtk" ]]; then
            WEBKITGTK=1
        elif [[ "$arg" == "--wpe" ]]; then
            WPEWEBKIT=1
        fi
    done

    URL=$(git config --get remote.origin.url)
    if [[ $? -ne 0 ]]; then
        usage 1
    fi

    if [[ ! "$URL" =~ meta-webkit.git$ ]]; then
        fatal "Invalid repository: '$URL'"
    fi

    if [[ -z "$WEBKITGTK" && -z "$WPEWEBKIT" ]]; then
        WEBKITGTK=1
        WPEWEBKIT=1
    fi
}

TEMP=$(mktemp)

cleanup() {
    rm -f "$TEMP"
}

trap cleanup EXIT INT HUP

next_patch_version() {
    local version="$1"

    local major=$(echo "$version" | cut -d "." -f 1)
    local minor=$(echo "$version" | cut -d "." -f 2)
    local patch=$(echo "$version" | cut -d "." -f 3)

    echo "$major.$minor.$((patch + 1))"
}

next_minor_version() {
    local version="$1"

    local major=$(echo "$version" | cut -d "." -f 1)
    local minor=$(echo "$version" | cut -d "." -f 2)

    echo "$major.$((minor + 2)).0"
}

update_recipe() {
    local webkit_port="$1"

    local bb=$(ls recipes-browser/${webkit_port}/${webkit_port}_*.bb)

    local current_version=$(basename "$bb" | sed -r "s|${webkit_port}_(.+)\.bb$|\1|")
    local current_sha256sum=$(cat recipes-browser/${webkit_port}/${webkit_port}_${current_version}.bb | egrep "^SRC_URI\[tarball.sha256sum\]" | cut -d " " -f 3 | tr -d '"')

    local next_patch_version=$(next_patch_version "$current_version")
    local next_minor_version=$(next_minor_version "$current_version")

    local next_sha256sum next_version

    # Check whether new 'patch' version is available. In case not, check 'minor' version.
    for version in "$next_patch_version" "$next_minor_version"; do
        curl "https://${webkit_port}.org/releases/${webkit_port}-$version.tar.xz.sums" -o $TEMP 2>/dev/null
        if [[ "$?" -eq 0 ]]; then
            next_sha256sum=$(cat "$TEMP" | grep "sha256sum" | cut -d ":" -f 2 | tr -d " ")
            if [[ -n "$next_sha256sum" ]]; then
                next_version="$version"
                break
            fi
        fi
    done

    # Exit if new version was not found.
    if [[ -z "$next_version" ]]; then
        echo "${webkit_port}: New version not available. Current version: ${current_version}"
        return 1
    fi

    # Rename current version to new version.
    local current_version_recipe="recipes-browser/${webkit_port}/${webkit_port}_${current_version}.bb"
    local next_version_recipe="recipes-browser/${webkit_port}/${webkit_port}_${next_version}.bb"
    git mv "$current_version_recipe" "$next_version_recipe"

    # Update SHA256SUM.
    sed -i "s|$current_sha256sum|$next_sha256sum|" "$next_version_recipe"

    # Maybe update devupstream SHA?
    if [[ "$webkit_port" -eq "wpewebkit" ]]; then
        local current_class_devupstream=$(class_devupstream "$current_version")
        local next_class_devupstream=$(class_devupstream "$next_version")
        sed -i "s|$current_class_devupstream|$next_class_devupstream|" "$next_version_recipe"
    fi

    # Commit changes.
    git commit -a -m "${webkit_port}: Update to version $next_version"
    if [[ $? -eq 0 ]]; then
        git log -1
        echo ""
    fi
}

class_devupstream() {
    local webkit_git="https://github.com/WebKit/WebKit.git"
    local version="$1"

    git ls-remote "$webkit_git" "refs/tags/wpewebkit-$version*" | tail -1 | awk '{print $1}'
}

# Main.
parse_args "$@"

if [[ -n "$WEBKITGTK" ]]; then
    update_recipe "webkitgtk"
fi

if [[ -n "$WPEWEBKIT" ]]; then
    update_recipe "wpewebkit"
fi
