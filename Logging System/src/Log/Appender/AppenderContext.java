package Log.Appender;

import Log.Config.LogConfig;

public class AppenderContext {

    private final OutputAppender appender;

    public AppenderContext(LogConfig config) {
        this.appender = this.resolve(config);
    }

    private OutputAppender resolve(LogConfig config) {

        if ("file".equalsIgnoreCase(config.getAppender())) {
            return new FileAppender(config.getFilePath());
        }

        return new ConsoleAppender();
    }

    public void append(String message) {
        appender.write(message);
    }

    public OutputAppender getAppender(){
        return this.appender;
    }
}
