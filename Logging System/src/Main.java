import Log.Config.LogConfig;
import Log.LoggerApi.Logger;
import Log.LogSeverity.LogSeverity;

public class Main {

  public static void main(String[] args) {

    LogConfig config = new LogConfig();
//    config.setAppender("console");
//    config.setFormat("text");
//    config.setLogSeverity(LogSeverity.DEBUG);
//    Logger logger = new Logger(config);
//    logger.debug("Debug message");
//    logger.info("Info message");
//    logger.warn("Warning message");
//    logger.error("Error message");

    config.setAppender("file");
    config.setFormat("json");
    config.setFilePath("test.txt");

    Logger logger = new Logger(config);

    logger.debug("Debug message");
    logger.info("Info message");
    logger.warn("Warning message");
    logger.error("Error message");
  }
}
