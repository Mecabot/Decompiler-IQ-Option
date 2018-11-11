package com.jumio.commons.log;

import android.os.Environment;
import com.jumio.commons.log.Log.LogLevel;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    protected static final String DEBUG_DIRECTORY = "/Debug/";
    protected static final String FILE_ANALYTICS_REQUESTS = "analytics.txt";
    protected static final String FILE_OCR_INFO = "OCRImageData.txt";
    protected static final String FILE_SERVER_REQUESTS = "requests.txt";
    public static final String NEW_LINE = "\r\n";
    protected static File logFolder;
    protected static File logFolderTemp;

    public static void init() {
        logFolder = null;
        if (Log.isFileLoggingActivated()) {
            logFolderTemp = getDebugFileRoot(new SimpleDateFormat(DATE_FORMAT).format(new Date()));
        }
    }

    public static void appendParameter(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder != null) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append("\r\n");
        }
    }

    public static void appendParameter(StringBuilder stringBuilder, String str, long j) {
        if (stringBuilder != null) {
            stringBuilder.append(str);
            stringBuilder.append(j);
            stringBuilder.append("\r\n");
        }
    }

    public static void appendParameter(StringBuilder stringBuilder, String str, Date date) {
        if (stringBuilder != null) {
            stringBuilder.append(str);
            stringBuilder.append(date);
            stringBuilder.append("\r\n");
        }
    }

    public static void appendParameter(StringBuilder stringBuilder, String str, char[] cArr) {
        if (stringBuilder != null) {
            stringBuilder.append(str);
            stringBuilder.append(cArr);
            stringBuilder.append("\r\n");
        }
    }

    public static void setSesssionLogFolderName(String str) {
        if (Log.isFileLoggingActivated()) {
            renameLogFolder(str);
            logFolder = getDebugFileRoot(str);
        }
    }

    public static File getDebugFileRoot(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DEBUG_DIRECTORY);
        stringBuilder.append(str);
        File file = new File(externalStorageDirectory, stringBuilder.toString());
        if (file.isDirectory()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static void logServerRequest(String str, String str2) {
        str = String.format("%s \r\nREQUEST: %s", new Object[]{str, str2});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\r\n");
        Log.i(stringBuilder.toString(), getLogFolder(), FILE_SERVER_REQUESTS);
    }

    public static void logServerResponse(String str, int i, long j, String str2) {
        str = String.format("%s (TIME: %d, STATUS: %d)\r\nRESPONSE: %s", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\r\n");
        Log.i(stringBuilder.toString(), getLogFolder(), FILE_SERVER_REQUESTS);
    }

    public static File getSubFolder(String str) {
        File file = null;
        if (!Log.isFileLoggingActivated()) {
            return null;
        }
        Object obj = logFolder != null ? logFolder : logFolderTemp;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj);
        stringBuilder.append("/");
        stringBuilder.append(str);
        File file2 = new File(stringBuilder.toString());
        if (!file2.exists() ? file2.mkdirs() : true) {
            file = file2;
        }
        return file;
    }

    protected static File getLogFolder() {
        return logFolder != null ? logFolder : logFolderTemp;
    }

    private static void renameLogFolder(String str) {
        if (!Log.getLogLevel().equals(LogLevel.OFF) && Log.isFileLoggingActivated()) {
            File debugFileRoot = getDebugFileRoot("");
            if (debugFileRoot != null) {
                File file = new File(debugFileRoot, getLogFolder().getName());
                File file2 = new File(debugFileRoot, str);
                if (file.exists() && !file2.exists()) {
                    file.renameTo(file2);
                }
            }
        }
    }
}
