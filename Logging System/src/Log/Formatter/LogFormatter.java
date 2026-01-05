package Log.Formatter;

import Log.LogMessage.LogMessage;

public interface LogFormatter {
    String format(LogMessage event);
}
