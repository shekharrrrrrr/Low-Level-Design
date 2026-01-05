package Log.Config;

import Log.LogSeverity.LogSeverity;

public class LogConfig {

    private LogSeverity logSeverity;
    private String format;
    private String appender;
    private String filePath;

    public LogConfig() {
        //default
        this.logSeverity = LogSeverity.INFO;
        this.format = "text";
        this.appender = "console";
        this.filePath = "src/resources/";
    }

    public LogSeverity getLogSeverity() {
        return logSeverity;
    }

    public void setLogSeverity(LogSeverity logSeverity) {
        this.logSeverity = logSeverity;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAppender() {
        return appender;
    }

    public void setAppender(String appender) {
        this.appender = appender;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
