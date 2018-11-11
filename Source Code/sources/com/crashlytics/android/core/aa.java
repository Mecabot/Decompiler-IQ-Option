package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

/* compiled from: LogFileManager */
class aa {
    private static final b vu = new b();
    private final Context context;
    private final a vv;
    private y vw;

    /* compiled from: LogFileManager */
    public interface a {
        File hl();
    }

    /* compiled from: LogFileManager */
    private static final class b implements y {
        public void b(long j, String str) {
        }

        public d hO() {
            return null;
        }

        public byte[] hP() {
            return null;
        }

        public void hQ() {
        }

        public void hR() {
        }

        private b() {
        }
    }

    aa(Context context, a aVar) {
        this(context, aVar, null);
    }

    aa(Context context, a aVar, String str) {
        this.context = context;
        this.vv = aVar;
        this.vw = vu;
        bd(str);
    }

    final void bd(String str) {
        this.vw.hQ();
        this.vw = vu;
        if (str != null) {
            if (CommonUtils.b(this.context, "com.crashlytics.CollectCustomLogs", true)) {
                a(be(str), 65536);
            } else {
                c.aUg().d("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    void b(long j, String str) {
        this.vw.b(j, str);
    }

    d hU() {
        return this.vw.hO();
    }

    byte[] hV() {
        return this.vw.hP();
    }

    void hW() {
        this.vw.hR();
    }

    void c(Set<String> set) {
        File[] listFiles = this.vv.hl().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(h(file))) {
                    file.delete();
                }
            }
        }
    }

    void a(File file, int i) {
        this.vw = new am(file, i);
    }

    private File be(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("crashlytics-userlog-");
        stringBuilder.append(str);
        stringBuilder.append(".temp");
        return new File(this.vv.hl(), stringBuilder.toString());
    }

    private String h(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }
}
