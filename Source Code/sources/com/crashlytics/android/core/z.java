package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InvalidSessionReport */
class z implements Report {
    private final String identifier;
    private final File[] vs;
    private final Map<String, String> vt = new HashMap(ao.vQ);

    public z(String str, File[] fileArr) {
        this.vs = fileArr;
        this.identifier = str;
    }

    public String getFileName() {
        return this.vs[0].getName();
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public File getFile() {
        return this.vs[0];
    }

    public File[] getFiles() {
        return this.vs;
    }

    public Map<String, String> hS() {
        return Collections.unmodifiableMap(this.vt);
    }

    public void remove() {
        for (File file : this.vs) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing invalid report file at ");
            stringBuilder.append(file.getPath());
            c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            file.delete();
        }
    }

    public Type hT() {
        return Type.JAVA;
    }
}
