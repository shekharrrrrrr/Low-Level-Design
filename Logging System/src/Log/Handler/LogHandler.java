package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Config.LogConfig;
import Log.Formatter.LogFormatter;
import Log.LogMessage.LogMessage;
import Log.LogSeverity.LogSeverity;

public abstract class LogHandler {

    private final LogSeverity handlerSeverity;
    private final OutputAppender outputAppender;
    private final LogFormatter logFormatter;
    private LogHandler nextHandler;

    public LogHandler(OutputAppender outputAppender,
                      LogFormatter logFormatter,
                      LogSeverity handlerSeverity) {
        this.outputAppender = outputAppender;
        this.logFormatter = logFormatter;
        this.handlerSeverity = handlerSeverity;
    }

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void logMessage(LogSeverity logSeverity, String message) {
        if (logSeverity.getSeverityLevel() >= handlerSeverity.getSeverityLevel()) {

            LogMessage logMessage =
                    new LogMessage(logSeverity, message, null);

            String output = logFormatter != null
                    ? logFormatter.format(logMessage)
                    : logMessage.toString();

            if (outputAppender != null) {
                outputAppender.write(output);
            }
            write(output);
        }

        if (nextHandler != null) {
            nextHandler.logMessage(logSeverity, message);
        }
    }

    abstract protected void write(String message);
}
