package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SessionReport */
class aq implements Report {
    private final File file;
    private final File[] vs;
    private final Map<String, String> vt;

    public aq(File file) {
        this(file, Collections.emptyMap());
    }

    public aq(File file, Map<String, String> map) {
        this.file = file;
        this.vs = new File[]{file};
        this.vt = new HashMap(map);
        if (this.file.length() == 0) {
            this.vt.putAll(ao.vQ);
        }
    }

    public File getFile() {
        return this.file;
    }

    public File[] getFiles() {
        return this.vs;
    }

    public String getFileName() {
        return getFile().getName();
    }

    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public Map<String, String> hS() {
        return Collections.unmodifiableMap(this.vt);
    }

    public void remove() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removing report at ");
        stringBuilder.append(this.file.getPath());
        c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        this.file.delete();
    }

    public Type hT() {
        return Type.JAVA;
    }
}
