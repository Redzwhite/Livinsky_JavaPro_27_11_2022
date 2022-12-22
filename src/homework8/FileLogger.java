package homework8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static homework8.LogLevel.DEBUG;
import static homework8.LogLevel.INFO;


public class FileLogger {

    private static FileLoggerConfiguration loggerConfig;

    public static void setUpLogger(FileLoggerConfiguration config) {
        loggerConfig = config;
    }

    public static void log(String text) throws IOException {
        if (loggerConfig.getLevel() == LogLevel.DEBUG) {
            debug(text);
        } else {
            info(text);
        }
    }

    public static void info(String text) throws IOException {
        File file = new File(loggerConfig.logFilePath());
        if (file.exists() || file.isFile()) {
            if (file.length() >= loggerConfig.getFileSize()) {
                throw new FileMaxSizeReachedException("Maximum file size is " + loggerConfig.getFileSize() + " current file size is " + file.length() + " file path: " + loggerConfig.logFilePath());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(loggerConfig.logFilePath(), true))) {

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            writer.append("\n");
            writer.write(formattedDate + " [" + INFO + "] " + "Повідомлення: " + text);
        }
    }

    public static void debug(String text) throws IOException {
        File file = new File(loggerConfig.logFilePath());
        if (file.exists() || file.isFile()) {
            if (file.length() >= loggerConfig.getFileSize()) {
                throw new FileMaxSizeReachedException("Maximum file size is " + loggerConfig.getFileSize() + " current file size is " + file.length() + " file path: " + loggerConfig.logFilePath());
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(loggerConfig.logFilePath(), true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            writer.append("\n");
            writer.write(formattedDate + " [" + DEBUG + "] " + "Повідомлення: " + text);
        }
    }
}
