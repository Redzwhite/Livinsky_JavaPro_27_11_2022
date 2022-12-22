package logger;

public class FileLoggerConfiguration {
    String fileName;
    String logLvl;
    int maxFileSizeInBytes;
    String logFormat = "[%1$tF %1$tT] [%4$-7s] %5$s %n";

    public FileLoggerConfiguration(String fileName, String logLvl, int maxFileSizeInBytes, String logFormat) {
        this.fileName = fileName;
        this.logLvl = logLvl;
        this.maxFileSizeInBytes = maxFileSizeInBytes;
        this.logFormat = logFormat;
    }


}
