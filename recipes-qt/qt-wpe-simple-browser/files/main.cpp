#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QUrl>
#include <QCommandLineOption>
#include <QCommandLineParser>
#include <QQmlContext>

int main(int argc, char *argv[])
{
    QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);

    QGuiApplication app(argc, argv);

    QCommandLineParser parser;
    QCoreApplication::setApplicationVersion("0.1");
    parser.setApplicationDescription(QGuiApplication::applicationDisplayName());
    parser.addHelpOption();
    parser.addVersionOption();
    parser.addPositionalArgument("initialUrl", "The URL to open.");
    QStringList arguments = app.arguments();
    parser.process(arguments);
    const QString initialUrl = parser.positionalArguments().isEmpty() ?
      QStringLiteral("https://wpewebkit.org") : parser.positionalArguments().first();

    QQmlApplicationEngine engine;
    QQmlContext* context = engine.rootContext();
    context->setContextProperty(QStringLiteral("initialUrl"), QUrl(initialUrl));

    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));
    if (engine.rootObjects().isEmpty())
        return -1;

    return app.exec();
}
