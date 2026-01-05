package Log.LogMessage;

import Log.LogSeverity.LogSeverity;

import java.time.Instant;
import java.util.Map;

public class LogMessage {

    private final String timestamp;
    private LogSeverity logSeverity;
    private String message;
    private Map<String, Object> contextData;

    public LogMessage(LogSeverity logSeverity, String message,
                      Map<String, Object> contextData) {
        this.timestamp = generateTimestamp();
        this.logSeverity = logSeverity;
        this.message = message;
        this.contextData = contextData;
    }

    private String generateTimestamp() {
        return Instant.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public LogSeverity getLogSeverity() {
        return logSeverity;
    }

    public void setLogSeverity(LogSeverity logSeverity) {
        this.logSeverity = logSeverity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getContextData() {
        return contextData;
    }

    public void setContextData(Map<String, Object> contextData) {
        this.contextData = contextData;
    }

    public void log() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return String.format(
                "[%s] [%s] %s %s",
                timestamp,
                logSeverity.getDisplayName(),
                message,
                contextData != null ? contextData : ""
        );
    }
}
