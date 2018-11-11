package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.c;
import java.io.File;
import java.util.Map;

/* compiled from: NativeSessionReport */
class ah implements Report {
    private final File vD;

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public Map<String, String> hS() {
        return null;
    }

    public ah(File file) {
        this.vD = file;
    }

    public void remove() {
        for (File file : getFiles()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing native report file at ");
            stringBuilder.append(file.getPath());
            c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            file.delete();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Removing native report directory at ");
        stringBuilder2.append(this.vD);
        c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
        this.vD.delete();
    }

    public String getIdentifier() {
        return this.vD.getName();
    }

    public File[] getFiles() {
        return this.vD.listFiles();
    }

    public Type hT() {
        return Type.NATIVE;
    }
}
