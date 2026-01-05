package Log.Formatter;

import Log.LogMessage.LogMessage;

class TextFormatter implements LogFormatter {
    @Override
    public String format(LogMessage msg) {
        return String.format(
                "[%s] [%s] %s %s",
                msg.getLogSeverity().getDisplayName(),
                msg.getTimestamp(),
                msg.getMessage(),
                msg.getContextData()
        );
    }
}