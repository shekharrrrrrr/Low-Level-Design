package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Formatter.LogFormatter;
import Log.LogSeverity.LogSeverity;

public class ErrorLogger extends LogHandler {

    public ErrorLogger(OutputAppender outputAppender,
                       LogFormatter logFormatter) {
        super(outputAppender, logFormatter, LogSeverity.ERROR);
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
