---
name: Bug report
about: Create a report to help us improve
title: ''
labels: bug
assignees: ''

---

**Bug description**
A clear and concise description of what the bug is.

**How To Reproduce**

1. Envars of the user during the execution of the command (`env`)
1. The `local.conf` and  the `bblayers.conf`
   * Attach the build directory environment dirlocal.conf if it is possible (`cd <build_dir> && tar --exclude='cache'  --exclude='workspace'  --exclude='tmp'  -zcvf ../builddir.tar.gz .`)
1. The hash references of each repository of each used layer
1. The local changes applied in the build environment
    * Local _devtool_ overrides on the `workspace` build directory
    * Local changes in layers 
1. The `bitbake` command causing the error
1. The error output

**Expected behavior**
A clear and concise description of what you expected to happen.

**Screenshots**
If applicable, add screenshots to help explain your problem.

**Environment (please complete the following information):**
 - yocto release: [e.g. scarthgap]
 - hardware target: [e.g. rpi4 64bits]

**Additional context**
Add any other context about the problem here.
