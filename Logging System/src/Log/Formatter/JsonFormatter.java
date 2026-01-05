package Log.Formatter;

import Log.LogMessage.LogMessage;

class JsonFormatter implements LogFormatter {

    @Override
    public String format(LogMessage msg) {
        return String.format(
                "{ \"time\": \"%s\", \"level\": \"%s\", \"message\": \"%s\", \"extraData\": %s }",
                msg.getTimestamp(),
                msg.getLogSeverity().getDisplayName(),
                msg.getMessage(),
                msg.getContextData()
        );
    }
}
