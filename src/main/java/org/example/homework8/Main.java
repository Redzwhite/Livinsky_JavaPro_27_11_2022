package org.example.homework8;

import java.io.IOException;

import static org.example.homework8.LogLevel.DEBUG;
import static org.example.homework8.LogLevel.INFO;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration loggerConfig = new FileLoggerConfiguration("logger.log", INFO, ".", 1001);
        FileLogger.setUpLogger(loggerConfig);
        for (int i = 0; i < 1000; i++) {
            try {
                FileLogger.log("Log text");
            }
            catch (FileMaxSizeReachedException ex) {
                ex.printStackTrace();
                return;
            }
        }

    }
}
