package Log.Formatter;

import Log.Config.LogConfig;
import Log.LogMessage.LogMessage;

public class FormatterContext {

    private final LogFormatter formatter;

    public FormatterContext(LogConfig config) {
        this.formatter = resolve(config);
    }

    private LogFormatter resolve(LogConfig config) {

        if ("json".equalsIgnoreCase(config.getFormat())) {
            return new JsonFormatter();
        }
        return new TextFormatter();
    }

    public String format(LogMessage message) {
        return formatter.format(message);
    }
    public LogFormatter getFormatter(){
        return this.formatter;
    }
}
