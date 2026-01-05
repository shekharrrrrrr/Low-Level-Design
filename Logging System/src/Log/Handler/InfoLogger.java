package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Formatter.LogFormatter;
import Log.LogSeverity.LogSeverity;

public class InfoLogger extends LogHandler {

    public InfoLogger(OutputAppender outputAppender,
                      LogFormatter logFormatter) {
        super(outputAppender, logFormatter, LogSeverity.INFO);
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
