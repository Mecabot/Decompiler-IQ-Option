package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.answers.o;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.m;
import io.fabric.sdk.android.services.settings.p;
import io.fabric.sdk.android.services.settings.q;
import io.fabric.sdk.android.services.settings.s;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* compiled from: CrashlyticsController */
class j {
    static final FilenameFilter tI = new d("BeginSession") {
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };
    static final FilenameFilter tJ = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    };
    static final FileFilter tK = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };
    static final Comparator<File> tL = new Comparator<File>() {
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final Comparator<File> tM = new Comparator<File>() {
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    private static final Pattern tN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> tO = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] tP = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final io.fabric.sdk.android.services.c.a sc;
    private final io.fabric.sdk.android.services.network.c sp;
    private final AtomicInteger tQ = new AtomicInteger(0);
    private final k tR;
    private final i tS;
    private final aj tT;
    private final a tU;
    private final g tV;
    private final aa tW;
    private final c tX;
    private final b tY;
    private final w tZ;
    private final IdManager tl;
    private final as ua;
    private final String ub;
    private final b uc;
    private final o ud;
    private r ue;

    /* compiled from: CrashlyticsController */
    private static class a implements FilenameFilter {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean accept(File file, String str) {
            return !j.tJ.accept(file, str) && j.tN.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController */
    private interface b {
        void a(CodedOutputStream codedOutputStream);
    }

    /* compiled from: CrashlyticsController */
    static class d implements FilenameFilter {
        private final String string;

        public d(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController */
    private interface e {
        void a(FileOutputStream fileOutputStream);
    }

    /* compiled from: CrashlyticsController */
    static class f implements FilenameFilter {
        f() {
        }

        public boolean accept(File file, String str) {
            return f.tv.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController */
    private static final class k implements Runnable {
        private final Context context;
        private final Report uO;
        private final ao uP;

        public k(Context context, Report report, ao aoVar) {
            this.context = context;
            this.uO = report;
            this.uP = aoVar;
        }

        public void run() {
            if (CommonUtils.cR(this.context)) {
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.uP.a(this.uO);
            }
        }
    }

    /* compiled from: CrashlyticsController */
    static class l implements FilenameFilter {
        private final String uQ;

        public l(String str) {
            this.uQ = str;
        }

        public boolean accept(File file, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.uQ);
            stringBuilder.append(".cls");
            boolean z = false;
            if (str.equals(stringBuilder.toString())) {
                return false;
            }
            if (str.contains(this.uQ) && !str.endsWith(".cls_temp")) {
                z = true;
            }
            return z;
        }
    }

    /* compiled from: CrashlyticsController */
    private static final class c implements b {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public s hk() {
            return q.aVM().aVN();
        }
    }

    /* compiled from: CrashlyticsController */
    private static final class g implements com.crashlytics.android.core.aa.a {
        private final io.fabric.sdk.android.services.c.a uK;

        public g(io.fabric.sdk.android.services.c.a aVar) {
            this.uK = aVar;
        }

        public File hl() {
            File file = new File(this.uK.getFilesDir(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController */
    private static final class h implements d {
        private final io.fabric.sdk.android.h rR;
        private final aj tT;
        private final io.fabric.sdk.android.services.settings.o uL;

        public h(io.fabric.sdk.android.h hVar, aj ajVar, io.fabric.sdk.android.services.settings.o oVar) {
            this.rR = hVar;
            this.tT = ajVar;
            this.uL = oVar;
        }

        public boolean hm() {
            Activity currentActivity = this.rR.aUo().getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                return true;
            }
            final h a = h.a(currentActivity, this.uL, new a() {
                public void F(boolean z) {
                    h.this.tT.H(z);
                }
            });
            currentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    a.show();
                }
            });
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Waiting for user opt-in.");
            a.await();
            return a.gS();
        }
    }

    /* compiled from: CrashlyticsController */
    private final class i implements c {
        private i() {
        }

        /* synthetic */ i(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public File[] hn() {
            return j.this.gX();
        }

        public File[] ho() {
            return j.this.hg().listFiles();
        }

        public File[] hp() {
            return j.this.gY();
        }
    }

    /* compiled from: CrashlyticsController */
    private final class j implements b {
        private j() {
        }

        /* synthetic */ j(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean hd() {
            return j.this.hd();
        }
    }

    j(k kVar, i iVar, io.fabric.sdk.android.services.network.c cVar, IdManager idManager, aj ajVar, io.fabric.sdk.android.services.c.a aVar, a aVar2, au auVar, b bVar, o oVar) {
        this.tR = kVar;
        this.tS = iVar;
        this.sp = cVar;
        this.tl = idManager;
        this.tT = ajVar;
        this.sc = aVar;
        this.tU = aVar2;
        this.ub = auVar.hX();
        this.uc = bVar;
        this.ud = oVar;
        Context context = kVar.getContext();
        this.tV = new g(aVar);
        this.tW = new aa(context, this.tV);
        this.tX = new i(this, null);
        this.tY = new j(this, null);
        this.tZ = new w(context);
        this.ua = new ad(1024, new an(10));
    }

    void a(UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        gT();
        this.ue = new r(new a() {
            public void b(b bVar, Thread thread, Throwable th, boolean z) {
                j.this.a(bVar, thread, th, z);
            }
        }, new c(), z, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.ue);
    }

    synchronized void a(b bVar, Thread thread, Throwable th, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics is handling uncaught exception \"");
        stringBuilder.append(th);
        stringBuilder.append("\" from thread ");
        stringBuilder.append(thread.getName());
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        this.tZ.dispose();
        final Date date = new Date();
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final b bVar2 = bVar;
        final boolean z2 = z;
        this.tS.b(new Callable<Void>() {
            public Void call() {
                p pVar;
                m mVar;
                j.this.tR.hz();
                j.this.a(date, thread2, th2);
                s hk = bVar2.hk();
                if (hk != null) {
                    pVar = hk.epM;
                    mVar = hk.epN;
                } else {
                    pVar = null;
                    mVar = pVar;
                }
                Object obj = (mVar == null || mVar.ept) ? 1 : null;
                if (obj != null || z2) {
                    j.this.r(date.getTime());
                }
                j.this.b(pVar);
                j.this.gW();
                if (pVar != null) {
                    j.this.G(pVar.epG);
                }
                if (!j.this.b(hk)) {
                    j.this.c(hk);
                }
                return null;
            }
        });
    }

    void a(float f, s sVar) {
        if (sVar == null) {
            io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new ao(this.tU.sO, n(sVar.epL.epf, sVar.epL.epg), this.tX, this.tY).a(f, b(sVar) ? new h(this.tR, this.tT, sVar.uL) : new a());
    }

    void b(final long j, final String str) {
        this.tS.submit(new Callable<Void>() {
            public Void call() {
                if (!j.this.hd()) {
                    j.this.tW.b(j, str);
                }
                return null;
            }
        });
    }

    void a(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.tS.submit(new Runnable() {
            public void run() {
                if (!j.this.hd()) {
                    j.this.b(date, thread, th);
                }
            }
        });
    }

    void a(final String str, final String str2, final String str3) {
        this.tS.submit(new Callable<Void>() {
            public Void call() {
                new ac(j.this.getFilesDir()).a(j.this.gU(), new av(str, str2, str3));
                return null;
            }
        });
    }

    void gT() {
        this.tS.submit(new Callable<Void>() {
            public Void call() {
                j.this.gW();
                return null;
            }
        });
    }

    private String gU() {
        File[] ha = ha();
        return ha.length > 0 ? e(ha[0]) : null;
    }

    private String gV() {
        File[] ha = ha();
        return ha.length > 1 ? e(ha[1]) : null;
    }

    static String e(File file) {
        return file.getName().substring(0, 35);
    }

    boolean a(final p pVar) {
        return ((Boolean) this.tS.b(new Callable<Boolean>() {
            public Boolean call() {
                if (j.this.hd()) {
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Finalizing previously open sessions.");
                j.this.a(pVar, true);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void gW() {
        Date date = new Date();
        String eVar = new e(this.tl).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opening a new session with ID ");
        stringBuilder.append(eVar);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        a(eVar, date);
        aV(eVar);
        aW(eVar);
        aX(eVar);
        this.tW.bd(eVar);
    }

    void b(p pVar) {
        a(pVar, false);
    }

    private void a(p pVar, boolean z) {
        H(z + 8);
        File[] ha = ha();
        if (ha.length <= z) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        aY(e(ha[z]));
        if (pVar == null) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            a(ha, (int) z, pVar.epC);
        }
    }

    private void a(File[] fileArr, int i, int i2) {
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String e = e(file);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Closing session: ");
            stringBuilder.append(e);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            a(file, e, i2);
            i++;
        }
    }

    private void a(f fVar) {
        if (fVar != null) {
            try {
                fVar.gQ();
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void b(Set<File> set) {
        for (File f : set) {
            f(f);
        }
    }

    private void f(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                f(f);
            }
        }
        file.delete();
    }

    private void aT(String str) {
        for (File delete : aU(str)) {
            delete.delete();
        }
    }

    private File[] aU(String str) {
        return a(new l(str));
    }

    File[] gX() {
        List linkedList = new LinkedList();
        Collections.addAll(linkedList, a(he(), tJ));
        Collections.addAll(linkedList, a(hf(), tJ));
        Collections.addAll(linkedList, a(getFilesDir(), tJ));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] gY() {
        return a(tK);
    }

    File[] gZ() {
        return a(tI);
    }

    private File[] ha() {
        File[] gZ = gZ();
        Arrays.sort(gZ, tL);
        return gZ;
    }

    private File[] a(FileFilter fileFilter) {
        return a(getFilesDir().listFiles(fileFilter));
    }

    private File[] a(FilenameFilter filenameFilter) {
        return a(getFilesDir(), filenameFilter);
    }

    private File[] a(File file, FilenameFilter filenameFilter) {
        return a(file.listFiles(filenameFilter));
    }

    private File[] g(File file) {
        return a(file.listFiles());
    }

    private File[] a(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void k(String str, int i) {
        File filesDir = getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("SessionEvent");
        aw.a(filesDir, new d(stringBuilder.toString()), i, tM);
    }

    void G(int i) {
        i -= aw.a(he(), i, tM);
        aw.a(getFilesDir(), tJ, i - aw.a(hf(), i, tM), tM);
    }

    private void H(int i) {
        Set hashSet = new HashSet();
        File[] ha = ha();
        i = Math.min(i, ha.length);
        for (int i2 = 0; i2 < i; i2++) {
            hashSet.add(e(ha[i2]));
        }
        this.tW.c(hashSet);
        a(a(new a()), hashSet);
    }

    private void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = tN.matcher(name);
            StringBuilder stringBuilder;
            if (!matcher.matches()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Deleting unknown file: ");
                stringBuilder.append(name);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Trimming session file: ");
                stringBuilder.append(name);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
                file.delete();
            }
        }
    }

    private File[] a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        k(str, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("SessionEvent");
        return a(new d(stringBuilder.toString()));
    }

    void hb() {
        this.tS.submit(new Runnable() {
            public void run() {
                j.this.b(j.this.a(new f()));
            }
        });
    }

    void b(File[] fileArr) {
        final Set hashSet = new HashSet();
        for (File file : fileArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found invalid session part file: ");
            stringBuilder.append(file);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            hashSet.add(e(file));
        }
        if (!hashSet.isEmpty()) {
            File hg = hg();
            if (!hg.exists()) {
                hg.mkdir();
            }
            for (File file2 : a(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Moving session file: ");
                stringBuilder2.append(file2);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
                if (!file2.renameTo(new File(hg, file2.getName()))) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Could not move session file. Deleting ");
                    stringBuilder2.append(file2);
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
                    file2.delete();
                }
            }
            hc();
        }
    }

    private void hc() {
        File hg = hg();
        if (hg.exists()) {
            File[] a = a(hg, new f());
            Arrays.sort(a, Collections.reverseOrder());
            Set hashSet = new HashSet();
            for (int i = 0; i < a.length && hashSet.size() < 4; i++) {
                hashSet.add(e(a[i]));
            }
            a(g(hg), hashSet);
        }
    }

    private void a(Context context, File file, String str) {
        byte[] j = ag.j(file);
        byte[] l = ag.l(file);
        byte[] a = ag.a(file, context);
        if (j == null || j.length == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No minidump data found in directory ");
            stringBuilder.append(file);
            io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", stringBuilder.toString());
            return;
        }
        p(str, "<native-crash: minidump>");
        byte[] m = m(str, "BeginSession.json");
        byte[] m2 = m(str, "SessionApp.json");
        byte[] m3 = m(str, "SessionDevice.json");
        byte[] m4 = m(str, "SessionOS.json");
        byte[] i = ag.i(new ac(getFilesDir()).bg(str));
        aa aaVar = new aa(this.tR.getContext(), this.tV, str);
        byte[] hV = aaVar.hV();
        aaVar.hW();
        byte[] i2 = ag.i(new ac(getFilesDir()).bh(str));
        File file2 = new File(this.sc.getFilesDir(), str);
        if (file2.mkdir()) {
            a(j, new File(file2, "minidump"));
            a(l, new File(file2, "metadata"));
            a(a, new File(file2, "binaryImages"));
            a(m, new File(file2, "session"));
            a(m2, new File(file2, "app"));
            a(m3, new File(file2, "device"));
            a(m4, new File(file2, "os"));
            a(i, new File(file2, "user"));
            a(hV, new File(file2, "logs"));
            a(i2, new File(file2, "keys"));
            return;
        }
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Couldn't create native sessions directory");
    }

    boolean a(final o oVar) {
        return oVar == null ? true : ((Boolean) this.tS.b(new Callable<Boolean>() {
            public Boolean call() {
                Set set = oVar.vc;
                String e = j.this.gV();
                if (!(e == null || set.isEmpty())) {
                    File file = (File) set.first();
                    if (file != null) {
                        j.this.a(j.this.tR.getContext(), file, e);
                    }
                }
                j.this.b(set);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void a(byte[] bArr, File file) {
        if (bArr != null && bArr.length > 0) {
            b(bArr, file);
        }
    }

    private void b(byte[] bArr, File file) {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                CommonUtils.closeQuietly(gZIPOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeable = gZIPOutputStream;
                CommonUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeQuietly(closeable);
            throw th;
        }
    }

    private void a(Date date, Thread thread, Throwable th) {
        Throwable e;
        Flushable flushable = null;
        Closeable fVar;
        try {
            String gU = gU();
            if (gU == null) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.a(null, "Failed to flush to session begin file.");
                CommonUtils.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            p(gU, th.getClass().getName());
            File filesDir = getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(gU);
            stringBuilder.append("SessionCrash");
            fVar = new f(filesDir, stringBuilder.toString());
            try {
                Flushable a = CodedOutputStream.a((OutputStream) fVar);
                try {
                    a(a, date, thread, th, AppMeasurement.CRASH_ORIGIN, true);
                    CommonUtils.a(a, "Failed to flush to session begin file.");
                } catch (Exception e2) {
                    e = e2;
                    flushable = a;
                    try {
                        io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        e = th2;
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    flushable = a;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                CommonUtils.a(flushable, "Failed to flush to session begin file.");
                CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
            }
            CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
        } catch (Exception e4) {
            e = e4;
            fVar = null;
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            fVar = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(fVar, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void b(Date date, Thread thread, Throwable th) {
        Throwable e;
        String gU = gU();
        Flushable flushable = null;
        if (gU == null) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        Closeable fVar;
        o(gU, th.getClass().getName());
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crashlytics is logging non-fatal exception \"");
            stringBuilder.append(th);
            stringBuilder.append("\" from thread ");
            stringBuilder.append(thread.getName());
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            String iS = CommonUtils.iS(this.tQ.getAndIncrement());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(gU);
            stringBuilder2.append("SessionEvent");
            stringBuilder2.append(iS);
            fVar = new f(getFilesDir(), stringBuilder2.toString());
            try {
                Flushable a = CodedOutputStream.a((OutputStream) fVar);
                try {
                    a(a, date, thread, th, "error", false);
                    CommonUtils.a(a, "Failed to flush to non-fatal file.");
                } catch (Exception e2) {
                    e = e2;
                    flushable = a;
                    try {
                        io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
                        k(gU, 64);
                    } catch (Throwable th2) {
                        e = th2;
                        CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    flushable = a;
                    CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
                k(gU, 64);
            }
        } catch (Exception e4) {
            e = e4;
            fVar = null;
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
            CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
            k(gU, 64);
        } catch (Throwable th4) {
            e = th4;
            fVar = null;
            CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
            throw e;
        }
        CommonUtils.a(fVar, "Failed to close non-fatal file output stream.");
        try {
            k(gU, 64);
        } catch (Throwable e5) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e5);
        }
    }

    private void a(String str, String str2, b bVar) {
        Throwable th;
        StringBuilder stringBuilder;
        Flushable flushable = null;
        Closeable fVar;
        try {
            Flushable a;
            File filesDir = getFilesDir();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(str2);
            fVar = new f(filesDir, stringBuilder2.toString());
            try {
                a = CodedOutputStream.a((OutputStream) fVar);
            } catch (Throwable th2) {
                th = th2;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to flush to session ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(flushable, stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close session ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(fVar, stringBuilder.toString());
                throw th;
            }
            try {
                bVar.a(a);
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Failed to flush to session ");
                stringBuilder3.append(str2);
                stringBuilder3.append(" file.");
                CommonUtils.a(a, stringBuilder3.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close session ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(fVar, stringBuilder.toString());
            } catch (Throwable th3) {
                th = th3;
                flushable = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to flush to session ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(flushable, stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close session ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(fVar, stringBuilder.toString());
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fVar = null;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to flush to session ");
            stringBuilder.append(str2);
            stringBuilder.append(" file.");
            CommonUtils.a(flushable, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to close session ");
            stringBuilder.append(str2);
            stringBuilder.append(" file.");
            CommonUtils.a(fVar, stringBuilder.toString());
            throw th;
        }
    }

    private void a(String str, String str2, e eVar) {
        Throwable th;
        StringBuilder stringBuilder;
        Closeable closeable = null;
        try {
            File filesDir = getFilesDir();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(str2);
            Closeable fileOutputStream = new FileOutputStream(new File(filesDir, stringBuilder2.toString()));
            try {
                eVar.a(fileOutputStream);
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Failed to close ");
                stringBuilder3.append(str2);
                stringBuilder3.append(" file.");
                CommonUtils.a(fileOutputStream, stringBuilder3.toString());
            } catch (Throwable th2) {
                th = th2;
                closeable = fileOutputStream;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close ");
                stringBuilder.append(str2);
                stringBuilder.append(" file.");
                CommonUtils.a(closeable, stringBuilder.toString());
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to close ");
            stringBuilder.append(str2);
            stringBuilder.append(" file.");
            CommonUtils.a(closeable, stringBuilder.toString());
            throw th;
        }
    }

    private byte[] m(String str, String str2) {
        File filesDir = getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return ag.i(new File(filesDir, stringBuilder.toString()));
    }

    private void a(String str, Date date) {
        final String str2 = str;
        final String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.tR.getVersion()});
        final long time = date.getTime() / 1000;
        a(str, "BeginSession", new b() {
            public void a(CodedOutputStream codedOutputStream) {
                ap.a(codedOutputStream, str2, format, time);
            }
        });
        a(str, "BeginSession.json", new e() {
            public void a(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new CrashlyticsController$18$1(this)).toString().getBytes());
            }
        });
    }

    private void aV(String str) {
        String aUH = this.tl.aUH();
        String str2 = this.tU.tm;
        String str3 = this.tU.versionName;
        final String str4 = aUH;
        final String str5 = str2;
        final String str6 = str3;
        final String aUG = this.tl.aUG();
        final int id = DeliveryMechanism.determineFrom(this.tU.installerPackageName).getId();
        a(str, "SessionApp", new b() {
            public void a(CodedOutputStream codedOutputStream) {
                ap.a(codedOutputStream, str4, j.this.tU.sO, str5, str6, aUG, id, j.this.ub);
            }
        });
        a(str, "SessionApp.json", new e() {
            public void a(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new CrashlyticsController$20$1(this)).toString().getBytes());
            }
        });
    }

    private void aW(String str) {
        final boolean isRooted = CommonUtils.isRooted(this.tR.getContext());
        a(str, "SessionOS", new b() {
            public void a(CodedOutputStream codedOutputStream) {
                ap.a(codedOutputStream, VERSION.RELEASE, VERSION.CODENAME, isRooted);
            }
        });
        a(str, "SessionOS.json", new e() {
            public void a(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new CrashlyticsController$22$1(this)).toString().getBytes());
            }
        });
    }

    private void aX(String str) {
        String str2 = str;
        Context context = this.tR.getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int aUB = CommonUtils.aUB();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long aUC = CommonUtils.aUC();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean cK = CommonUtils.cK(context);
        final int i = aUB;
        final int i2 = availableProcessors;
        final long j = aUC;
        final long j2 = blockCount;
        final boolean z = cK;
        long j3 = aUC;
        b bVar = r0;
        final Map gN = this.tl.gN();
        int i3 = availableProcessors;
        final int cL = CommonUtils.cL(context);
        AnonymousClass15 anonymousClass15 = new b() {
            public void a(CodedOutputStream codedOutputStream) {
                ap.a(codedOutputStream, i, Build.MODEL, i2, j, j2, z, gN, cL, Build.MANUFACTURER, Build.PRODUCT);
            }
        };
        a(str2, "SessionDevice", bVar);
        i2 = i3;
        j = j3;
        a(str2, "SessionDevice.json", new e() {
            public void a(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new CrashlyticsController$24$1(this)).toString().getBytes());
            }
        });
    }

    private void aY(String str) {
        final av aZ = aZ(str);
        a(str, "SessionUser", new b() {
            public void a(CodedOutputStream codedOutputStream) {
                ap.a(codedOutputStream, aZ.id, aZ.name, aZ.email);
            }
        });
    }

    private void a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        boolean z2;
        Thread[] threadArr;
        TreeMap attributes;
        Map treeMap;
        at atVar = new at(th, this.ua);
        Context context = this.tR.getContext();
        long time = date.getTime() / 1000;
        Float cH = CommonUtils.cH(context);
        int f = CommonUtils.f(context, this.tZ.hK());
        boolean cI = CommonUtils.cI(context);
        int i = context.getResources().getConfiguration().orientation;
        long aUC = CommonUtils.aUC() - CommonUtils.cG(context);
        long lz = CommonUtils.lz(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo h = CommonUtils.h(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = atVar.wa;
        String str2 = this.tU.th;
        String aUH = this.tl.aUH();
        int i2 = 0;
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr2[i2] = (Thread) entry.getKey();
                linkedList.add(this.ua.a((StackTraceElement[]) entry.getValue()));
                i2++;
            }
            z2 = true;
            threadArr = threadArr2;
        } else {
            z2 = true;
            threadArr = new Thread[0];
        }
        if (CommonUtils.b(context, "com.crashlytics.CollectCustomKeys", z2)) {
            attributes = this.tR.getAttributes();
            if (attributes != null && attributes.size() > z2) {
                treeMap = new TreeMap(attributes);
                ap.a(codedOutputStream, time, str, atVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.tW, h, i, aUH, str2, cH, f, cI, aUC, lz);
            }
        }
        attributes = new TreeMap();
        treeMap = attributes;
        ap.a(codedOutputStream, time, str, atVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.tW, h, i, aUH, str2, cH, f, cI, aUC, lz);
    }

    private void a(File file, String str, int i) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Collecting session parts for ID ");
        stringBuilder2.append(str);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append("SessionCrash");
        File[] a = a(new d(stringBuilder3.toString()));
        boolean z = a != null && a.length > 0;
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str);
        stringBuilder4.append("SessionEvent");
        File[] a2 = a(new d(stringBuilder4.toString()));
        boolean z2 = a2 != null && a2.length > 0;
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (z || z2) {
            a(file, str, a(str, a2, i), z ? a[0] : null);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("No events present for session ID ");
            stringBuilder.append(str);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Removing session part files for ID ");
        stringBuilder.append(str);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        aT(str);
    }

    private void a(File file, String str, File[] fileArr, File file2) {
        Throwable e;
        StringBuilder stringBuilder;
        boolean z = file2 != null;
        File he = z ? he() : hf();
        if (!he.exists()) {
            he.mkdirs();
        }
        Flushable flushable = null;
        Closeable fVar;
        Flushable a;
        try {
            fVar = new f(he, str);
            try {
                a = CodedOutputStream.a((OutputStream) fVar);
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Collecting SessionStart data for session ID ");
                    stringBuilder2.append(str);
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
                    a((CodedOutputStream) a, file);
                    a.a(4, new Date().getTime() / 1000);
                    a.c(5, z);
                    a.j(11, 1);
                    a.k(12, 3);
                    a((CodedOutputStream) a, str);
                    a((CodedOutputStream) a, fileArr, str);
                    if (z) {
                        a((CodedOutputStream) a, file2);
                    }
                    CommonUtils.a(a, "Error flushing session file stream");
                    CommonUtils.a(fVar, "Failed to close CLS file");
                } catch (Exception e2) {
                    e = e2;
                    flushable = a;
                    try {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to write session file for session ID: ");
                        stringBuilder.append(str);
                        io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
                        CommonUtils.a(flushable, "Error flushing session file stream");
                        a((f) fVar);
                    } catch (Throwable th) {
                        e = th;
                        a = flushable;
                        CommonUtils.a(a, "Error flushing session file stream");
                        CommonUtils.a(fVar, "Failed to close CLS file");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.a(a, "Error flushing session file stream");
                    CommonUtils.a(fVar, "Failed to close CLS file");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to write session file for session ID: ");
                stringBuilder.append(str);
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
                CommonUtils.a(flushable, "Error flushing session file stream");
                a((f) fVar);
            }
        } catch (Exception e4) {
            e = e4;
            fVar = null;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to write session file for session ID: ");
            stringBuilder.append(str);
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
            CommonUtils.a(flushable, "Error flushing session file stream");
            a((f) fVar);
        } catch (Throwable th3) {
            e = th3;
            a = null;
            fVar = a;
            CommonUtils.a(a, "Error flushing session file stream");
            CommonUtils.a(fVar, "Failed to close CLS file");
            throw e;
        }
    }

    private static void a(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.emS);
        for (File name : fileArr) {
            try {
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                a(codedOutputStream, name);
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void a(CodedOutputStream codedOutputStream, String str) {
        for (String str2 : tP) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(".cls");
            File[] a = a(new d(stringBuilder.toString()));
            if (a.length == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Can't find ");
                stringBuilder2.append(str2);
                stringBuilder2.append(" data for session ID ");
                stringBuilder2.append(str);
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder2.toString(), null);
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Collecting ");
                stringBuilder3.append(str2);
                stringBuilder3.append(" data for session ID ");
                stringBuilder3.append(str);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder3.toString());
                a(codedOutputStream, a[0]);
            }
        }
    }

    private static void a(CodedOutputStream codedOutputStream, File file) {
        Throwable th;
        if (file.exists()) {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    a((InputStream) fileInputStream, codedOutputStream, (int) file.length());
                    CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to include a file that doesn't exist: ");
        stringBuilder.append(file.getName());
        io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), null);
    }

    private static void a(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.j(bArr);
    }

    private av aZ(String str) {
        if (hd()) {
            return new av(this.tR.hr(), this.tR.getUserName(), this.tR.hs());
        }
        return new ac(getFilesDir()).bf(str);
    }

    boolean hd() {
        return this.ue != null && this.ue.hd();
    }

    File getFilesDir() {
        return this.sc.getFilesDir();
    }

    File he() {
        return new File(getFilesDir(), "fatal-sessions");
    }

    File hf() {
        return new File(getFilesDir(), "nonfatal-sessions");
    }

    File hg() {
        return new File(getFilesDir(), "invalidClsFiles");
    }

    void a(s sVar) {
        if (sVar.epN.ept && this.uc.gO()) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Registered Firebase Analytics event listener");
        }
    }

    void hh() {
        this.tZ.initialize();
    }

    private boolean b(s sVar) {
        boolean z = false;
        if (sVar == null) {
            return false;
        }
        if (sVar.epN.epp && !this.tT.hY()) {
            z = true;
        }
        return z;
    }

    private t n(String str, String str2) {
        String I = CommonUtils.I(this.tR.getContext(), "com.crashlytics.ApiEndpoint");
        return new g(new v(this.tR, I, str, this.sp), new af(this.tR, I, str2, this.sp));
    }

    private void c(s sVar) {
        if (sVar == null) {
            io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.tR.getContext();
        ao aoVar = new ao(this.tU.sO, n(sVar.epL.epf, sVar.epL.epg), this.tX, this.tY);
        for (File aqVar : gX()) {
            this.tS.submit(new k(context, new aq(aqVar, tO), aoVar));
        }
    }

    private static void o(String str, String str2) {
        com.crashlytics.android.answers.b bVar = (com.crashlytics.android.answers.b) io.fabric.sdk.android.c.D(com.crashlytics.android.answers.b.class);
        if (bVar == null) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new io.fabric.sdk.android.services.common.i.b(str, str2));
        }
    }

    private static void p(String str, String str2) {
        com.crashlytics.android.answers.b bVar = (com.crashlytics.android.answers.b) io.fabric.sdk.android.c.D(com.crashlytics.android.answers.b.class);
        if (bVar == null) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new io.fabric.sdk.android.services.common.i.a(str, str2));
        }
    }

    private void r(long j) {
        if (hi()) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.ud != null) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Logging Crashlytics event to Firebase");
            Bundle bundle = new Bundle();
            bundle.putInt("_r", 1);
            bundle.putInt(Param.FATAL, 1);
            bundle.putLong(Param.TIMESTAMP, j);
            this.ud.a("clx", Event.APP_EXCEPTION, bundle);
        } else {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
        }
    }

    private boolean hi() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
