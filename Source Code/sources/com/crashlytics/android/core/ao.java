package com.crashlytics.android.core;

import io.fabric.sdk.android.k;
import io.fabric.sdk.android.services.common.h;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportUploader */
class ao {
    static final Map<String, String> vQ = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final short[] vR = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final String sO;
    private final c tX;
    private final b tY;
    private final Object vS = new Object();
    private final t vT;
    private Thread vU;

    /* compiled from: ReportUploader */
    interface b {
        boolean hd();
    }

    /* compiled from: ReportUploader */
    interface c {
        File[] hn();

        File[] ho();

        File[] hp();
    }

    /* compiled from: ReportUploader */
    interface d {
        boolean hm();
    }

    /* compiled from: ReportUploader */
    static final class a implements d {
        public boolean hm() {
            return true;
        }

        a() {
        }
    }

    /* compiled from: ReportUploader */
    private class e extends h {
        private final float uX;
        private final d vV;

        e(float f, d dVar) {
            this.uX = f;
            this.vV = dVar;
        }

        public void id() {
            try {
                ie();
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ao.this.vU = null;
        }

        private void ie() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Starting report processing in ");
            stringBuilder.append(this.uX);
            stringBuilder.append(" second(s)...");
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            if (this.uX > 0.0f) {
                try {
                    Thread.sleep((long) (this.uX * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> ib = ao.this.ib();
            if (!ao.this.tY.hd()) {
                if (ib.isEmpty() || this.vV.hm()) {
                    int i = 0;
                    while (!ib.isEmpty() && !ao.this.tY.hd()) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Attempting to send ");
                        stringBuilder2.append(ib.size());
                        stringBuilder2.append(" report(s)");
                        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
                        for (Report a : ib) {
                            ao.this.a(a);
                        }
                        List ib2 = ao.this.ib();
                        if (!ib2.isEmpty()) {
                            int i2 = i + 1;
                            long j = (long) ao.vR[Math.min(i, ao.vR.length - 1)];
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Report submisson: scheduling delayed retry in ");
                            stringBuilder3.append(j);
                            stringBuilder3.append(" seconds");
                            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder3.toString());
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("User declined to send. Removing ");
                stringBuilder4.append(ib2.size());
                stringBuilder4.append(" Report(s).");
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder4.toString());
                for (Report remove : ib2) {
                    remove.remove();
                }
            }
        }
    }

    public ao(String str, t tVar, c cVar, b bVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.vT = tVar;
        this.sO = str;
        this.tX = cVar;
        this.tY = bVar;
    }

    public synchronized void a(float f, d dVar) {
        if (this.vU != null) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.vU = new Thread(new e(f, dVar), "Crashlytics Report Uploader");
        this.vU.start();
    }

    boolean a(Report report) {
        boolean z;
        synchronized (this.vS) {
            z = false;
            StringBuilder stringBuilder;
            try {
                boolean a = this.vT.a(new s(this.sO, report));
                k aUg = io.fabric.sdk.android.c.aUg();
                String str = "CrashlyticsCore";
                stringBuilder = new StringBuilder();
                stringBuilder.append("Crashlytics report upload ");
                stringBuilder.append(a ? "complete: " : "FAILED: ");
                stringBuilder.append(report.getIdentifier());
                aUg.i(str, stringBuilder.toString());
                if (a) {
                    report.remove();
                    z = true;
                }
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error occurred sending report ");
                stringBuilder.append(report);
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
            }
        }
        return z;
    }

    List<Report> ib() {
        File[] hn;
        File[] ho;
        File[] hp;
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.vS) {
            hn = this.tX.hn();
            ho = this.tX.ho();
            hp = this.tX.hp();
        }
        List<Report> linkedList = new LinkedList();
        if (hn != null) {
            for (File file : hn) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found crash report ");
                stringBuilder.append(file.getPath());
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
                linkedList.add(new aq(file));
            }
        }
        Map hashMap = new HashMap();
        if (ho != null) {
            for (File file2 : ho) {
                String e = j.e(file2);
                if (!hashMap.containsKey(e)) {
                    hashMap.put(e, new LinkedList());
                }
                ((List) hashMap.get(e)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Found invalid session: ");
            stringBuilder2.append(str);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
            List list = (List) hashMap.get(str);
            linkedList.add(new z(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (hp != null) {
            for (File ahVar : hp) {
                linkedList.add(new ah(ahVar));
            }
        }
        if (linkedList.isEmpty()) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
