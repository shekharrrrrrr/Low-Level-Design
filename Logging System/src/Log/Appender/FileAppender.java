package Log.Appender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements OutputAppender {

    private final String filePath;

    public FileAppender(String fileName) {
        this.filePath = "src/Resources/" + fileName;
        createFileIfNotExists();
    }

    @Override
    public boolean write(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message);
            writer.write(System.lineSeparator());
            return true;
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
            return false;
        }
    }

    private void createFileIfNotExists() {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println(
                        "Log file not found. Created a new file at: " + filePath
                );
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to create log file", e);
        }
    }
}
