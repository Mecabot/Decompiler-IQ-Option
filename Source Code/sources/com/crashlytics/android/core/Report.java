package com.crashlytics.android.core;

import java.io.File;
import java.util.Map;

interface Report {

    public enum Type {
        JAVA,
        NATIVE
    }

    File getFile();

    String getFileName();

    File[] getFiles();

    String getIdentifier();

    Map<String, String> hS();

    Type hT();

    void remove();
}
