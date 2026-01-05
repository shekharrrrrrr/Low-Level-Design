package Log.Handler;

import Log.Appender.OutputAppender;
import Log.Formatter.LogFormatter;

public class ChainOfResponsibility {

    public static LogHandler getChainOfLoggers(OutputAppender outputAppender,
                                               LogFormatter logFormatter) {

        LogHandler debug = new DebugLogger(outputAppender, logFormatter);
        LogHandler info  = new InfoLogger(outputAppender, logFormatter);
        LogHandler warn  = new WarningLogger(outputAppender, logFormatter);
        LogHandler error = new ErrorLogger(outputAppender, logFormatter);
        LogHandler fatal = new FatalLogger(outputAppender, logFormatter);

        //Chaining
        debug.setNextHandler(info);
        info.setNextHandler(warn);
        warn.setNextHandler(error);
        error.setNextHandler(fatal);
        return debug;
    }
}
