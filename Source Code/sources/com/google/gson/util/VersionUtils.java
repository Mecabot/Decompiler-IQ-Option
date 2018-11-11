package com.google.gson.util;

public class VersionUtils {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private static int determineMajorJavaVersion() {
        String[] split = System.getProperty("java.version").split("[._]");
        int parseInt = Integer.parseInt(split[0]);
        return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }
}
