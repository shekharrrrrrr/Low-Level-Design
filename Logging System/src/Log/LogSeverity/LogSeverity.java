package Log.LogSeverity;

public enum LogSeverity {
    DEBUG(0, "DEBUG"),
    INFO(1, "INFO"),
    WARNING(2, "WARNING"),
    ERROR(3, "ERROR"),
    FATAL(4, "FATAL");

    private final int severityLevel;
    private final String displayName;

    LogSeverity(int severityLevel, String displayName) {
        this.severityLevel = severityLevel;
        this.displayName = displayName;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public String getDisplayName() {
        return displayName;
    }
}
