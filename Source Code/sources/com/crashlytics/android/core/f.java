package com.crashlytics.android.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: ClsFileOutputStream */
class f extends FileOutputStream {
    public static final FilenameFilter tv = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };
    private boolean closed = false;
    private final String ts;
    private File tt;
    private File tu;

    public f(File file, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".cls_temp");
        super(new File(file, stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(file);
        stringBuilder2.append(File.separator);
        stringBuilder2.append(str);
        this.ts = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.ts);
        stringBuilder3.append(".cls_temp");
        this.tt = new File(stringBuilder3.toString());
    }

    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.ts);
            stringBuilder.append(".cls");
            File file = new File(stringBuilder.toString());
            if (this.tt.renameTo(file)) {
                this.tt = null;
                this.tu = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.tt.exists()) {
                str = " (source does not exist)";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not rename temp file: ");
            stringBuilder2.append(this.tt);
            stringBuilder2.append(" -> ");
            stringBuilder2.append(file);
            stringBuilder2.append(str);
            throw new IOException(stringBuilder2.toString());
        }
    }

    public void gQ() {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
        }
    }
}
