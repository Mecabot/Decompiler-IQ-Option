package com.crashlytics.android.core;

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.o;
import io.fabric.sdk.android.services.common.o.c;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: QueueFileLogStore */
class am implements y {
    private final File vJ;
    private final int vK;
    private o vL;

    /* compiled from: QueueFileLogStore */
    public class a {
        public final byte[] bytes;
        public final int offset;

        public a(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
        }
    }

    public am(File file, int i) {
        this.vJ = file;
        this.vK = i;
    }

    public void b(long j, String str) {
        ia();
        c(j, str);
    }

    public d hO() {
        a hZ = hZ();
        if (hZ == null) {
            return null;
        }
        return d.c(hZ.bytes, 0, hZ.offset);
    }

    public byte[] hP() {
        a hZ = hZ();
        if (hZ == null) {
            return null;
        }
        return hZ.bytes;
    }

    private a hZ() {
        if (!this.vJ.exists()) {
            return null;
        }
        ia();
        if (this.vL == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.vL.aUP()];
        try {
            this.vL.a(new c() {
                public void a(InputStream inputStream, int i) {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return new a(bArr, iArr[0]);
    }

    public void hQ() {
        CommonUtils.a(this.vL, "There was a problem closing the Crashlytics log file.");
        this.vL = null;
    }

    public void hR() {
        hQ();
        this.vJ.delete();
    }

    private void ia() {
        if (this.vL == null) {
            try {
                this.vL = new o(this.vJ);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not open log file: ");
                stringBuilder.append(this.vJ);
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
            }
        }
    }

    private void c(long j, String str) {
        if (this.vL != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i = this.vK / 4;
                if (str.length() > i) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("...");
                    stringBuilder.append(str.substring(str.length() - i));
                    str = stringBuilder.toString();
                }
                str = str.replaceAll("\r", " ").replaceAll("\n", " ");
                this.vL.aa(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str}).getBytes("UTF-8"));
                while (!this.vL.isEmpty() && this.vL.aUP() > this.vK) {
                    this.vL.remove();
                }
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
