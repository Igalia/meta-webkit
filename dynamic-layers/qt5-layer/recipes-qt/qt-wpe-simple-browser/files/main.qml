import QtQuick 2.11
import QtQuick.Window 2.11
import org.wpewebkit.qtwpe 1.0

Window {
    visible: true
    width: 1920
    height: 1080
    title: qsTr("Hello WPE!")

    WPEView {
        url: initialUrl
        focus: true
        anchors.fill: parent
    }
}
