package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Formatter.LogFormatter;
import Log.LogSeverity.LogSeverity;

public class WarningLogger extends LogHandler {

    public WarningLogger(OutputAppender outputAppender,
                      LogFormatter logFormatter) {
        super(outputAppender, logFormatter, LogSeverity.WARNING);
    }

    @Override
    protected void write(String message) {
        System.out.println("WARN: " + message);
    }
}
