package androidx.work.impl.utils;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.work.Data.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.d;
import androidx.work.impl.e;
import androidx.work.impl.g;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: EnqueueRunnable */
public class b implements Runnable {
    private final e gW;

    public b(@NonNull e eVar) {
        this.gW = eVar;
    }

    public void run() {
        if (this.gW.bq()) {
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.gW}));
        } else if (cz()) {
            e.a(this.gW.bk().getApplicationContext(), RescheduleReceiver.class, true);
            cA();
        }
    }

    @VisibleForTesting
    public boolean cz() {
        WorkDatabase bA = this.gW.bk().bA();
        bA.beginTransaction();
        try {
            boolean b = b(this.gW);
            bA.setTransactionSuccessful();
            return b;
        } finally {
            bA.endTransaction();
        }
    }

    @VisibleForTesting
    public void cA() {
        g bk = this.gW.bk();
        d.a(bk.bB(), bk.bA(), bk.bC());
    }

    private static boolean b(@NonNull e eVar) {
        List<e> bp = eVar.bp();
        int i = 0;
        if (bp != null) {
            int i2 = 0;
            for (e eVar2 : bp) {
                if (eVar2.isEnqueued()) {
                    androidx.work.e.d("EnqueueRunnable", String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", eVar2.bn())}), new Throwable[0]);
                } else {
                    i2 |= b(eVar2);
                }
            }
            i = i2;
        }
        return c(eVar) | i;
    }

    private static boolean c(@NonNull e eVar) {
        boolean a = a(eVar.bk(), eVar.bm(), (String[]) e.a(eVar).toArray(new String[0]), eVar.getName(), eVar.bl());
        eVar.bo();
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x011a  */
    private static boolean a(androidx.work.impl.g r18, @android.support.annotation.NonNull java.util.List<? extends androidx.work.k> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r3 = java.lang.System.currentTimeMillis();
        r5 = r18.bA();
        r6 = 0;
        r7 = 1;
        if (r0 == 0) goto L_0x0017;
    L_0x0012:
        r8 = r0.length;
        if (r8 <= 0) goto L_0x0017;
    L_0x0015:
        r8 = 1;
        goto L_0x0018;
    L_0x0017:
        r8 = 0;
    L_0x0018:
        if (r8 == 0) goto L_0x0057;
    L_0x001a:
        r9 = r0.length;
        r10 = 0;
        r11 = 1;
        r12 = 0;
        r13 = 0;
    L_0x001f:
        if (r10 >= r9) goto L_0x005a;
    L_0x0021:
        r14 = r0[r10];
        r15 = r5.bu();
        r15 = r15.M(r14);
        if (r15 != 0) goto L_0x003f;
    L_0x002d:
        r0 = "EnqueueRunnable";
        r1 = "Prerequisite %s doesn't exist; not enqueuing";
        r2 = new java.lang.Object[r7];
        r2[r6] = r14;
        r1 = java.lang.String.format(r1, r2);
        r2 = new java.lang.Throwable[r6];
        androidx.work.e.e(r0, r1, r2);
        return r6;
    L_0x003f:
        r14 = r15.gn;
        r15 = androidx.work.State.SUCCEEDED;
        if (r14 != r15) goto L_0x0047;
    L_0x0045:
        r15 = 1;
        goto L_0x0048;
    L_0x0047:
        r15 = 0;
    L_0x0048:
        r11 = r11 & r15;
        r15 = androidx.work.State.FAILED;
        if (r14 != r15) goto L_0x004f;
    L_0x004d:
        r12 = 1;
        goto L_0x0054;
    L_0x004f:
        r15 = androidx.work.State.CANCELLED;
        if (r14 != r15) goto L_0x0054;
    L_0x0053:
        r13 = 1;
    L_0x0054:
        r10 = r10 + 1;
        goto L_0x001f;
    L_0x0057:
        r11 = 1;
        r12 = 0;
        r13 = 0;
    L_0x005a:
        r9 = android.text.TextUtils.isEmpty(r21);
        r9 = r9 ^ r7;
        if (r9 == 0) goto L_0x0065;
    L_0x0061:
        if (r8 != 0) goto L_0x0065;
    L_0x0063:
        r10 = 1;
        goto L_0x0066;
    L_0x0065:
        r10 = 0;
    L_0x0066:
        if (r10 == 0) goto L_0x010f;
    L_0x0068:
        r10 = r5.bu();
        r10 = r10.N(r1);
        r14 = r10.isEmpty();
        if (r14 != 0) goto L_0x010f;
    L_0x0076:
        r14 = androidx.work.ExistingWorkPolicy.APPEND;
        if (r2 != r14) goto L_0x00c9;
    L_0x007a:
        r2 = r5.bv();
        r8 = new java.util.ArrayList;
        r8.<init>();
        r10 = r10.iterator();
    L_0x0087:
        r14 = r10.hasNext();
        if (r14 == 0) goto L_0x00bc;
    L_0x008d:
        r14 = r10.next();
        r14 = (androidx.work.impl.b.j.a) r14;
        r15 = r14.id;
        r15 = r2.J(r15);
        if (r15 != 0) goto L_0x00ba;
    L_0x009b:
        r15 = r14.gn;
        r7 = androidx.work.State.SUCCEEDED;
        if (r15 != r7) goto L_0x00a3;
    L_0x00a1:
        r7 = 1;
        goto L_0x00a4;
    L_0x00a3:
        r7 = 0;
    L_0x00a4:
        r7 = r7 & r11;
        r11 = r14.gn;
        r15 = androidx.work.State.FAILED;
        if (r11 != r15) goto L_0x00ad;
    L_0x00ab:
        r12 = 1;
        goto L_0x00b4;
    L_0x00ad:
        r11 = r14.gn;
        r15 = androidx.work.State.CANCELLED;
        if (r11 != r15) goto L_0x00b4;
    L_0x00b3:
        r13 = 1;
    L_0x00b4:
        r11 = r14.id;
        r8.add(r11);
        r11 = r7;
    L_0x00ba:
        r7 = 1;
        goto L_0x0087;
    L_0x00bc:
        r0 = r8.toArray(r0);
        r0 = (java.lang.String[]) r0;
        r2 = r0.length;
        if (r2 <= 0) goto L_0x00c7;
    L_0x00c5:
        r8 = 1;
        goto L_0x010f;
    L_0x00c7:
        r8 = 0;
        goto L_0x010f;
    L_0x00c9:
        r7 = androidx.work.ExistingWorkPolicy.KEEP;
        if (r2 != r7) goto L_0x00ea;
    L_0x00cd:
        r2 = r10.iterator();
    L_0x00d1:
        r7 = r2.hasNext();
        if (r7 == 0) goto L_0x00ea;
    L_0x00d7:
        r7 = r2.next();
        r7 = (androidx.work.impl.b.j.a) r7;
        r14 = r7.gn;
        r15 = androidx.work.State.ENQUEUED;
        if (r14 == r15) goto L_0x00e9;
    L_0x00e3:
        r7 = r7.gn;
        r14 = androidx.work.State.RUNNING;
        if (r7 != r14) goto L_0x00d1;
    L_0x00e9:
        return r6;
    L_0x00ea:
        r2 = r18;
        r2 = androidx.work.impl.utils.a.a(r1, r2, r6);
        r2.run();
        r2 = r5.bu();
        r7 = r10.iterator();
    L_0x00fb:
        r10 = r7.hasNext();
        if (r10 == 0) goto L_0x010d;
    L_0x0101:
        r10 = r7.next();
        r10 = (androidx.work.impl.b.j.a) r10;
        r10 = r10.id;
        r2.delete(r10);
        goto L_0x00fb;
    L_0x010d:
        r2 = 1;
        goto L_0x0110;
    L_0x010f:
        r2 = 0;
    L_0x0110:
        r7 = r19.iterator();
    L_0x0114:
        r10 = r7.hasNext();
        if (r10 == 0) goto L_0x01bf;
    L_0x011a:
        r10 = r7.next();
        r10 = (androidx.work.k) r10;
        r14 = r10.bc();
        if (r8 == 0) goto L_0x013b;
    L_0x0126:
        if (r11 != 0) goto L_0x013b;
    L_0x0128:
        if (r12 == 0) goto L_0x012f;
    L_0x012a:
        r15 = androidx.work.State.FAILED;
        r14.gn = r15;
        goto L_0x013d;
    L_0x012f:
        if (r13 == 0) goto L_0x0136;
    L_0x0131:
        r15 = androidx.work.State.CANCELLED;
        r14.gn = r15;
        goto L_0x013d;
    L_0x0136:
        r15 = androidx.work.State.BLOCKED;
        r14.gn = r15;
        goto L_0x013d;
    L_0x013b:
        r14.gz = r3;
    L_0x013d:
        r15 = android.os.Build.VERSION.SDK_INT;
        r6 = 23;
        if (r15 < r6) goto L_0x014c;
    L_0x0143:
        r6 = android.os.Build.VERSION.SDK_INT;
        r15 = 25;
        if (r6 > r15) goto L_0x014c;
    L_0x0149:
        l(r14);
    L_0x014c:
        r6 = r14.gn;
        r15 = androidx.work.State.ENQUEUED;
        if (r6 != r15) goto L_0x0153;
    L_0x0152:
        r2 = 1;
    L_0x0153:
        r6 = r5.bu();
        r6.k(r14);
        if (r8 == 0) goto L_0x017d;
    L_0x015c:
        r6 = r0.length;
        r14 = 0;
    L_0x015e:
        if (r14 >= r6) goto L_0x017d;
    L_0x0160:
        r15 = r0[r14];
        r16 = r0;
        r0 = new androidx.work.impl.b.a;
        r17 = r2;
        r2 = r10.bb();
        r0.<init>(r2, r15);
        r2 = r5.bv();
        r2.a(r0);
        r14 = r14 + 1;
        r0 = r16;
        r2 = r17;
        goto L_0x015e;
    L_0x017d:
        r16 = r0;
        r17 = r2;
        r0 = r10.bd();
        r0 = r0.iterator();
    L_0x0189:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x01a6;
    L_0x018f:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        r6 = r5.bw();
        r14 = new androidx.work.impl.b.m;
        r15 = r10.bb();
        r14.<init>(r2, r15);
        r6.a(r14);
        goto L_0x0189;
    L_0x01a6:
        if (r9 == 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r5.by();
        r2 = new androidx.work.impl.b.g;
        r6 = r10.bb();
        r2.<init>(r1, r6);
        r0.a(r2);
    L_0x01b8:
        r0 = r16;
        r2 = r17;
        r6 = 0;
        goto L_0x0114;
    L_0x01bf:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.b.a(androidx.work.impl.g, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void l(j jVar) {
        androidx.work.b bVar = jVar.gv;
        if (bVar.aK() || bVar.aL()) {
            String str = jVar.go;
            a aVar = new a();
            aVar.b(jVar.gq).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            jVar.go = ConstraintTrackingWorker.class.getName();
            jVar.gq = aVar.aR();
        }
    }
}
