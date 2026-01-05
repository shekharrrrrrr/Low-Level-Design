package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Formatter.LogFormatter;
import Log.LogSeverity.LogSeverity;

public class DebugLogger extends LogHandler {

    public DebugLogger(OutputAppender outputAppender,
                       LogFormatter logFormatter) {
        super(outputAppender, logFormatter, LogSeverity.DEBUG);
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
