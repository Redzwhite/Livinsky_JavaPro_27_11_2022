package org.example.homework8;


public class FileLoggerConfiguration {
    private String fileName;
    private LogLevel level;
    private String filePath;
    private int fileSize;


    public FileLoggerConfiguration(String fileName, LogLevel level, String filePath, int fileSize) {
        this.fileName = fileName;
        this.level = level;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String logFilePath() {
        return filePath + "/" + fileName;
    }
}
