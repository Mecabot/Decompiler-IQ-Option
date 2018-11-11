package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
public class q {
    private final AtomicReference<s> epH;
    private final CountDownLatch epI;
    private r epJ;
    private boolean initialized;

    /* compiled from: Settings */
    static class a {
        private static final q epK = new q();
    }

    public static q aVM() {
        return a.epK;
    }

    private q() {
        this.epH = new AtomicReference();
        this.epI = new CountDownLatch(1);
        this.initialized = false;
    }

    /*  JADX ERROR: NullPointerException in pass: EliminatePhiNodes
        java.lang.NullPointerException
        	at jadx.core.utils.BlockUtils.getBlockByInsn(BlockUtils.java:172)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:90)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public synchronized io.fabric.sdk.android.services.settings.q a(io.fabric.sdk.android.h r23, io.fabric.sdk.android.services.common.IdManager r24, io.fabric.sdk.android.services.network.c r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
        r22 = this;
        r1 = r22;
        r3 = r23;
        monitor-enter(r22);
        r2 = r1.initialized;	 Catch:{ all -> 0x0095 }
        if (r2 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r22);
        return r1;
    L_0x000b:
        r2 = r1.epJ;	 Catch:{ all -> 0x0095 }
        r9 = 1;	 Catch:{ all -> 0x0095 }
        if (r2 != 0) goto L_0x0091;	 Catch:{ all -> 0x0095 }
    L_0x0010:
        r2 = r23.getContext();	 Catch:{ all -> 0x0095 }
        r4 = r24.aUH();	 Catch:{ all -> 0x0095 }
        r5 = new io.fabric.sdk.android.services.common.g;	 Catch:{ all -> 0x0095 }
        r5.<init>();	 Catch:{ all -> 0x0095 }
        r11 = r5.cA(r2);	 Catch:{ all -> 0x0095 }
        r5 = r24.getInstallerPackageName();	 Catch:{ all -> 0x0095 }
        r6 = new io.fabric.sdk.android.services.common.q;	 Catch:{ all -> 0x0095 }
        r6.<init>();	 Catch:{ all -> 0x0095 }
        r7 = new io.fabric.sdk.android.services.settings.k;	 Catch:{ all -> 0x0095 }
        r7.<init>();	 Catch:{ all -> 0x0095 }
        r8 = new io.fabric.sdk.android.services.settings.i;	 Catch:{ all -> 0x0095 }
        r8.<init>(r3);	 Catch:{ all -> 0x0095 }
        r20 = io.fabric.sdk.android.services.common.CommonUtils.cO(r2);	 Catch:{ all -> 0x0095 }
        r10 = java.util.Locale.US;	 Catch:{ all -> 0x0095 }
        r12 = "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings";	 Catch:{ all -> 0x0095 }
        r13 = new java.lang.Object[r9];	 Catch:{ all -> 0x0095 }
        r14 = 0;	 Catch:{ all -> 0x0095 }
        r13[r14] = r4;	 Catch:{ all -> 0x0095 }
        r4 = java.lang.String.format(r10, r12, r13);	 Catch:{ all -> 0x0095 }
        r15 = new io.fabric.sdk.android.services.settings.l;	 Catch:{ all -> 0x0095 }
        r10 = r25;	 Catch:{ all -> 0x0095 }
        r12 = r28;	 Catch:{ all -> 0x0095 }
        r15.<init>(r3, r12, r4, r10);	 Catch:{ all -> 0x0095 }
        r12 = r24.aUL();	 Catch:{ all -> 0x0095 }
        r13 = r24.aUK();	 Catch:{ all -> 0x0095 }
        r4 = r24.aUJ();	 Catch:{ all -> 0x0095 }
        r16 = r24.aUG();	 Catch:{ all -> 0x0095 }
        r10 = new java.lang.String[r9];	 Catch:{ all -> 0x0095 }
        r2 = io.fabric.sdk.android.services.common.CommonUtils.cQ(r2);	 Catch:{ all -> 0x0095 }
        r10[r14] = r2;	 Catch:{ all -> 0x0095 }
        r2 = io.fabric.sdk.android.services.common.CommonUtils.g(r10);	 Catch:{ all -> 0x0095 }
        r5 = io.fabric.sdk.android.services.common.DeliveryMechanism.determineFrom(r5);	 Catch:{ all -> 0x0095 }
        r19 = r5.getId();	 Catch:{ all -> 0x0095 }
        r5 = new io.fabric.sdk.android.services.settings.v;	 Catch:{ all -> 0x0095 }
        r10 = r5;	 Catch:{ all -> 0x0095 }
        r14 = r4;	 Catch:{ all -> 0x0095 }
        r21 = r15;	 Catch:{ all -> 0x0095 }
        r15 = r16;	 Catch:{ all -> 0x0095 }
        r16 = r2;	 Catch:{ all -> 0x0095 }
        r17 = r27;	 Catch:{ all -> 0x0095 }
        r18 = r26;	 Catch:{ all -> 0x0095 }
        r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ all -> 0x0095 }
        r10 = new io.fabric.sdk.android.services.settings.j;	 Catch:{ all -> 0x0095 }
        r2 = r10;	 Catch:{ all -> 0x0095 }
        r4 = r5;	 Catch:{ all -> 0x0095 }
        r5 = r6;	 Catch:{ all -> 0x0095 }
        r6 = r7;	 Catch:{ all -> 0x0095 }
        r7 = r8;	 Catch:{ all -> 0x0095 }
        r8 = r21;	 Catch:{ all -> 0x0095 }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0095 }
        r1.epJ = r10;	 Catch:{ all -> 0x0095 }
    L_0x0091:
        r1.initialized = r9;	 Catch:{ all -> 0x0095 }
        monitor-exit(r22);
        return r1;
    L_0x0095:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r22);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.q.a(io.fabric.sdk.android.h, io.fabric.sdk.android.services.common.IdManager, io.fabric.sdk.android.services.network.c, java.lang.String, java.lang.String, java.lang.String):io.fabric.sdk.android.services.settings.q");
    }

    public s aVN() {
        try {
            this.epI.await();
            return (s) this.epH.get();
        } catch (InterruptedException unused) {
            c.aUg().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean aVO() {
        s aVI;
        aVI = this.epJ.aVI();
        d(aVI);
        return aVI != null;
    }

    public synchronized boolean aVP() {
        s a;
        a = this.epJ.a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        d(a);
        if (a == null) {
            c.aUg().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void d(s sVar) {
        this.epH.set(sVar);
        this.epI.countDown();
    }
}
