package com.iqoption.core.g;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.f;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/resources/ResourceFileManager;", "", "()V", "RESOURCE_DIR", "", "baseResourceFileDir", "Ljava/io/File;", "processingResources", "", "fetchFileResource", "", "resId", "url", "force", "", "getResFile", "getResourceFile", "getResourceFilePath", "tryFetchResource", "file", "FetchFileTask", "core_release"})
/* compiled from: ResourceFileManager.kt */
public final class a {
    private static final File aZQ = new File(f.RR().getFilesDir(), "resource_files");
    private static final Set<String> aZR = new LinkedHashSet();
    public static final a aZS = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, aXE = {"Lcom/iqoption/core/resources/ResourceFileManager$FetchFileTask;", "Ljava/lang/Runnable;", "resId", "", "completeResultFile", "Ljava/io/File;", "fetchUrl", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V", "getResId", "()Ljava/lang/String;", "run", "", "core_release"})
    /* compiled from: ResourceFileManager.kt */
    public static final class a implements Runnable {
        private final String aZT;
        private final File aZU;
        private final String aZV;

        public a(String str, File file, String str2) {
            h.e(str, "resId");
            h.e(file, "completeResultFile");
            h.e(str2, "fetchUrl");
            this.aZT = str;
            this.aZU = file;
            this.aZV = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00ec A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00ec A:{SYNTHETIC} */
        public void run() {
            /*
            r8 = this;
            r0 = 0;
            r1 = r0;
            r1 = (okhttp3.Response) r1;
            r2 = r0;
            r2 = (okio.BufferedSink) r2;
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = r8.aZU;
            r4 = r4.getAbsolutePath();
            r3.append(r4);
            r4 = ".tmp";
            r3.append(r4);
            r3 = r3.toString();
            r4 = new java.io.File;
            r4.<init>(r3);
            r5 = new okhttp3.OkHttpClient$Builder;	 Catch:{ IOException -> 0x00a0 }
            r5.<init>();	 Catch:{ IOException -> 0x00a0 }
            r5 = r5.build();	 Catch:{ IOException -> 0x00a0 }
            r6 = new okhttp3.Request$Builder;	 Catch:{ IOException -> 0x00a0 }
            r6.<init>();	 Catch:{ IOException -> 0x00a0 }
            r7 = r8.aZV;	 Catch:{ IOException -> 0x00a0 }
            r6 = r6.url(r7);	 Catch:{ IOException -> 0x00a0 }
            r6 = r6.build();	 Catch:{ IOException -> 0x00a0 }
            r5 = r5.newCall(r6);	 Catch:{ IOException -> 0x00a0 }
            r5 = r5.execute();	 Catch:{ IOException -> 0x00a0 }
            r1 = r5.body();	 Catch:{ IOException -> 0x009b, all -> 0x0098 }
            if (r1 == 0) goto L_0x004d;
        L_0x0049:
            r0 = r1.source();	 Catch:{ IOException -> 0x009b, all -> 0x0098 }
        L_0x004d:
            if (r0 == 0) goto L_0x006e;
        L_0x004f:
            r1 = okio.Okio.sink(r4);	 Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r1 = okio.Okio.buffer(r1);	 Catch:{ IOException -> 0x009b, all -> 0x0098 }
            if (r1 != 0) goto L_0x0063;
        L_0x0059:
            kotlin.jvm.internal.h.aXZ();	 Catch:{ IOException -> 0x0060, all -> 0x005d }
            goto L_0x0063;
        L_0x005d:
            r0 = move-exception;
            r2 = r1;
            goto L_0x0099;
        L_0x0060:
            r0 = move-exception;
            r2 = r1;
            goto L_0x009c;
        L_0x0063:
            r0 = (okio.Source) r0;	 Catch:{ IOException -> 0x0060, all -> 0x005d }
            r1.writeAll(r0);	 Catch:{ IOException -> 0x0060, all -> 0x005d }
            r0 = r8.aZU;	 Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.renameTo(r0);	 Catch:{ IOException -> 0x0060, all -> 0x005d }
            goto L_0x006f;
        L_0x006e:
            r1 = r2;
        L_0x006f:
            if (r5 == 0) goto L_0x0074;
        L_0x0071:
            r5.close();
        L_0x0074:
            if (r1 == 0) goto L_0x0079;
        L_0x0076:
            r1.close();
        L_0x0079:
            r0 = new java.io.File;
            r0.<init>(r3);
            r0.delete();
            r0 = com.iqoption.core.g.a.aZS;
            r0 = com.iqoption.core.g.a.aZR;
            monitor-enter(r0);
            r1 = com.iqoption.core.g.a.aZS;	 Catch:{ all -> 0x0095 }
            r1 = com.iqoption.core.g.a.aZR;	 Catch:{ all -> 0x0095 }
            r2 = r8.aZT;	 Catch:{ all -> 0x0095 }
            r1.remove(r2);	 Catch:{ all -> 0x0095 }
        L_0x0093:
            monitor-exit(r0);
            goto L_0x00cf;
        L_0x0095:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
        L_0x0098:
            r0 = move-exception;
        L_0x0099:
            r1 = r5;
            goto L_0x00d3;
        L_0x009b:
            r0 = move-exception;
        L_0x009c:
            r1 = r5;
            goto L_0x00a1;
        L_0x009e:
            r0 = move-exception;
            goto L_0x00d3;
        L_0x00a0:
            r0 = move-exception;
        L_0x00a1:
            r4 = "javaClass";
            r0 = r0.toString();	 Catch:{ all -> 0x009e }
            com.iqoption.core.i.e(r4, r0);	 Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x00af;
        L_0x00ac:
            r1.close();
        L_0x00af:
            if (r2 == 0) goto L_0x00b4;
        L_0x00b1:
            r2.close();
        L_0x00b4:
            r0 = new java.io.File;
            r0.<init>(r3);
            r0.delete();
            r0 = com.iqoption.core.g.a.aZS;
            r0 = com.iqoption.core.g.a.aZR;
            monitor-enter(r0);
            r1 = com.iqoption.core.g.a.aZS;	 Catch:{ all -> 0x00d0 }
            r1 = com.iqoption.core.g.a.aZR;	 Catch:{ all -> 0x00d0 }
            r2 = r8.aZT;	 Catch:{ all -> 0x00d0 }
            r1.remove(r2);	 Catch:{ all -> 0x00d0 }
            goto L_0x0093;
        L_0x00cf:
            return;
        L_0x00d0:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
        L_0x00d3:
            if (r1 == 0) goto L_0x00d8;
        L_0x00d5:
            r1.close();
        L_0x00d8:
            if (r2 == 0) goto L_0x00dd;
        L_0x00da:
            r2.close();
        L_0x00dd:
            r1 = new java.io.File;
            r1.<init>(r3);
            r1.delete();
            r1 = com.iqoption.core.g.a.aZS;
            r1 = com.iqoption.core.g.a.aZR;
            monitor-enter(r1);
            r2 = com.iqoption.core.g.a.aZS;	 Catch:{ all -> 0x00f9 }
            r2 = com.iqoption.core.g.a.aZR;	 Catch:{ all -> 0x00f9 }
            r3 = r8.aZT;	 Catch:{ all -> 0x00f9 }
            r2.remove(r3);	 Catch:{ all -> 0x00f9 }
            monitor-exit(r1);
            throw r0;
        L_0x00f9:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.g.a.a.run():void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ResourceFileManager.kt */
    static final class b implements Runnable {
        final /* synthetic */ String aZW;
        final /* synthetic */ File aZX;
        final /* synthetic */ String aZY;

        b(String str, File file, String str2) {
            this.aZW = str;
            this.aZX = file;
            this.aZY = str2;
        }

        public final void run() {
            a aVar = new a(this.aZW, this.aZX, this.aZY);
        }
    }

    private a() {
    }

    public final void f(String str, String str2, boolean z) {
        h.e(str, "resId");
        h.e(str2, PlusShare.KEY_CALL_TO_ACTION_URL);
        File gQ = gQ(str);
        if (!gQ.exists() || z) {
            synchronized (aZR) {
                if (aZR.contains(str)) {
                    return;
                }
                aZR.add(str);
                com.iqoption.core.h.i.Yo().q(new b(str, gQ, str2));
            }
        }
    }

    private final File gQ(String str) {
        if (!aZQ.exists()) {
            aZQ.mkdirs();
        }
        return new File(aZQ, str);
    }
}
