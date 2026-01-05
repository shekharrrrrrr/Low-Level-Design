package Log.LoggerApi;

import Log.Appender.AppenderContext;
import Log.Appender.OutputAppender;
import Log.Config.LogConfig;
import Log.Formatter.FormatterContext;
import Log.Handler.ChainOfResponsibility;
import Log.Handler.LogHandler;
import Log.LogSeverity.LogSeverity;

public class Logger {

    private LogHandler rootHandler;

    public Logger(LogConfig logConfig) {
       AppenderContext appenderContext = new AppenderContext(logConfig);
       FormatterContext formatterContext = new FormatterContext(logConfig);
        this.rootHandler = ChainOfResponsibility.getChainOfLoggers(appenderContext.getAppender(), formatterContext.getFormatter());
    }

    public synchronized void log(LogSeverity severity, String message) {
        if (rootHandler == null) return;
        rootHandler.logMessage(severity, message);
    }

    public synchronized void reconfigure(LogConfig newConfig) {
        this.rootHandler = ChainOfResponsibility.getChainOfLoggers(
                new AppenderContext(newConfig).getAppender(),
                new FormatterContext(newConfig).getFormatter()
        );
    }

    public void debug(String msg) {
        log(LogSeverity.DEBUG, msg);
    }

    public void info(String msg) {
        log(LogSeverity.INFO, msg);
    }

    public void warn(String msg) {
        log(LogSeverity.WARNING, msg);
    }

    public void error(String msg) {
        log(LogSeverity.ERROR, msg);
    }
}
