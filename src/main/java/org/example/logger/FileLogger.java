package org.example.logger;


import java.io.File;
import java.io.IOException;
import java.util.logging.*;


public class FileLogger {
    static Logger logger = Logger.getLogger(FileLogger.class.getName());

    public static void main(String[] args) throws IOException {
        debug("MISTAKE");
    }

    public static void debug(String message) throws IOException {

        logger.setLevel(Level.ALL);
        logger.addHandler(new ConsoleHandler());
        FileLoggerConfiguration conf = new FileLoggerConfiguration("/Users/livinskystas/logger.log", "DEBUG", 2, "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        File file = new File(conf.fileName);
        file.getParentFile().mkdirs(); // Will create parent directories if not exists
        file.createNewFile();
        try {
            //FileHandler file name with max size and number of log files limit
            Handler fileHandler = new FileHandler(conf.fileName, conf.maxFileSizeInBytes, 5);
            fileHandler.setFormatter(new SimpleFormatter());
            //setting custom filter for FileHandler
            logger.addHandler(fileHandler);

            for (int i = 0; i < 1000; i++) {
                //logging messages
                logger.log(Level.INFO, "Msg" + i);
            }
            logger.log(Level.CONFIG, "Config data");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void info(String message) {

    }
}





