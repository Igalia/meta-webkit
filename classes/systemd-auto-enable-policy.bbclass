# Easily allow to disable specific systemd services at the distro level conf
python __anonymous() {
    if bb.utils.contains('DISTRO_FEATURES', 'systemd', True, False, d):
        packages_to_disable = d.getVar('SYSTEMD_AUTOSTART_DISABLE') or ''
        pn = d.getVar('PN')
        if pn in packages_to_disable.split():
            d.setVar('SYSTEMD_AUTO_ENABLE:%s' % pn, 'disable')
}
