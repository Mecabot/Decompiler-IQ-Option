package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzdkf;
import com.google.android.gms.internal.zzdkg;
import com.google.android.gms.internal.zzdkl;

@Hide
public final class zzy extends BasePendingResult<ContainerHolder> {
    private final Context mContext;
    private final Looper zzalj;
    private final zze zzata;
    private final String zzknc;
    private long zzknh;
    private final TagManager zzkno;
    private final zzaf zzknr;
    private final zzek zzkns;
    private final int zzknt;
    private final zzai zzknu;
    private zzah zzknv;
    private zzdkg zzknw;
    private volatile zzv zzknx;
    private volatile boolean zzkny;
    private zzbs zzknz;
    private String zzkoa;
    private zzag zzkob;
    private zzac zzkoc;

    private zzy(Context context, TagManager tagManager, Looper looper, String str, int i, zzah zzah, zzag zzag, zzdkg zzdkg, zze zze, zzek zzek, zzai zzai) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzkno = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzalj = looper;
        this.zzknc = str;
        this.zzknt = i;
        this.zzknv = zzah;
        this.zzkob = zzag;
        this.zzknw = zzdkg;
        this.zzknr = new zzaf(this, null);
        this.zzknz = new zzbs();
        this.zzata = zze;
        this.zzkns = zzek;
        this.zzknu = zzai;
        if (zzbft()) {
            zzlk(zzei.zzbhh().zzbhj());
        }
    }

    public zzy(Context context, TagManager tagManager, Looper looper, String str, int i, zzal zzal) {
        Context context2 = context;
        String str2 = str;
        this(context2, tagManager, looper, str2, i, new zzey(context2, str2), new zzet(context2, str2, zzal), new zzdkg(context2), zzi.zzanq(), new zzdh(1, 5, 900000, 5000, "refreshing", zzi.zzanq()), new zzai(context2, str2));
        this.zzknw.zznm(zzal.zzbgb());
    }

    private final synchronized void zza(zzbs zzbs) {
        if (this.zzknv != null) {
            zzdkf zzdkf = new zzdkf();
            zzdkf.zzldl = this.zzknh;
            zzdkf.zzyi = new zzbp();
            zzdkf.zzldm = zzbs;
            this.zzknv.zza(zzdkf);
        }
    }

    /* JADX WARNING: Missing block: B:22:0x0076, code:
            return;
     */
    private final synchronized void zza(com.google.android.gms.internal.zzbs r11, long r12, boolean r14) {
        /*
        r10 = this;
        monitor-enter(r10);
        if (r14 == 0) goto L_0x0008;
    L_0x0003:
        r14 = r10.zzkny;	 Catch:{ all -> 0x0006 }
        goto L_0x0008;
    L_0x0006:
        r11 = move-exception;
        goto L_0x0077;
    L_0x0008:
        r14 = r10.isReady();	 Catch:{ all -> 0x0006 }
        if (r14 == 0) goto L_0x0014;
    L_0x000e:
        r14 = r10.zzknx;	 Catch:{ all -> 0x0006 }
        if (r14 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r10);
        return;
    L_0x0014:
        r10.zzknz = r11;	 Catch:{ all -> 0x0006 }
        r10.zzknh = r12;	 Catch:{ all -> 0x0006 }
        r14 = r10.zzknu;	 Catch:{ all -> 0x0006 }
        r0 = r14.zzbfw();	 Catch:{ all -> 0x0006 }
        r2 = 0;
        r4 = r10.zzknh;	 Catch:{ all -> 0x0006 }
        r14 = 0;
        r6 = r4 + r0;
        r14 = r10.zzata;	 Catch:{ all -> 0x0006 }
        r4 = r14.currentTimeMillis();	 Catch:{ all -> 0x0006 }
        r14 = 0;
        r8 = r6 - r4;
        r0 = java.lang.Math.min(r0, r8);	 Catch:{ all -> 0x0006 }
        r0 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x0006 }
        r10.zzbg(r0);	 Catch:{ all -> 0x0006 }
        r14 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x0006 }
        r3 = r10.mContext;	 Catch:{ all -> 0x0006 }
        r0 = r10.zzkno;	 Catch:{ all -> 0x0006 }
        r4 = r0.getDataLayer();	 Catch:{ all -> 0x0006 }
        r5 = r10.zzknc;	 Catch:{ all -> 0x0006 }
        r2 = r14;
        r6 = r12;
        r8 = r11;
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x0006 }
        r11 = r10.zzknx;	 Catch:{ all -> 0x0006 }
        if (r11 != 0) goto L_0x005d;
    L_0x004f:
        r11 = new com.google.android.gms.tagmanager.zzv;	 Catch:{ all -> 0x0006 }
        r12 = r10.zzkno;	 Catch:{ all -> 0x0006 }
        r13 = r10.zzalj;	 Catch:{ all -> 0x0006 }
        r0 = r10.zzknr;	 Catch:{ all -> 0x0006 }
        r11.<init>(r12, r13, r14, r0);	 Catch:{ all -> 0x0006 }
        r10.zzknx = r11;	 Catch:{ all -> 0x0006 }
        goto L_0x0062;
    L_0x005d:
        r11 = r10.zzknx;	 Catch:{ all -> 0x0006 }
        r11.zza(r14);	 Catch:{ all -> 0x0006 }
    L_0x0062:
        r11 = r10.isReady();	 Catch:{ all -> 0x0006 }
        if (r11 != 0) goto L_0x0075;
    L_0x0068:
        r11 = r10.zzkoc;	 Catch:{ all -> 0x0006 }
        r11 = r11.zzb(r14);	 Catch:{ all -> 0x0006 }
        if (r11 == 0) goto L_0x0075;
    L_0x0070:
        r11 = r10.zzknx;	 Catch:{ all -> 0x0006 }
        r10.setResult(r11);	 Catch:{ all -> 0x0006 }
    L_0x0075:
        monitor-exit(r10);
        return;
    L_0x0077:
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzy.zza(com.google.android.gms.internal.zzbs, long, boolean):void");
    }

    private final boolean zzbft() {
        zzei zzbhh = zzei.zzbhh();
        return (zzbhh.zzbhi() == zza.CONTAINER || zzbhh.zzbhi() == zza.CONTAINER_DEBUG) && this.zzknc.equals(zzbhh.getContainerId());
    }

    private final synchronized void zzbg(long j) {
        if (this.zzkob == null) {
            zzdj.zzcz("Refresh requested, but no network load scheduler.");
        } else {
            this.zzkob.zza(j, this.zzknz.zzyj);
        }
    }

    private final void zzby(boolean z) {
        this.zzknv.zza(new zzad(this, null));
        this.zzkob.zza(new zzae(this, null));
        zzdkl zzey = this.zzknv.zzey(this.zzknt);
        if (zzey != null) {
            this.zzknx = new zzv(this.zzkno, this.zzalj, new Container(this.mContext, this.zzkno.getDataLayer(), this.zzknc, 0, zzey), this.zzknr);
        }
        this.zzkoc = new zzab(this, z);
        if (zzbft()) {
            this.zzkob.zza(0, "");
        } else {
            this.zzknv.zzbfv();
        }
    }

    /* renamed from: zzau */
    protected final ContainerHolder zzb(Status status) {
        if (this.zzknx != null) {
            return this.zzknx;
        }
        if (status == Status.zzftt) {
            zzdj.e("timer expired: setting result to failure");
        }
        return new zzv(status);
    }

    final synchronized String zzbfn() {
        return this.zzkoa;
    }

    public final void zzbfq() {
        zzdkl zzey = this.zzknv.zzey(this.zzknt);
        if (zzey != null) {
            setResult(new zzv(this.zzkno, this.zzalj, new Container(this.mContext, this.zzkno.getDataLayer(), this.zzknc, 0, zzey), new zzaa(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzdj.e(str);
            setResult(zzb(new Status(10, str, null)));
        }
        this.zzkob = null;
        this.zzknv = null;
    }

    public final void zzbfr() {
        zzby(false);
    }

    public final void zzbfs() {
        zzby(true);
    }

    final synchronized void zzlk(String str) {
        this.zzkoa = str;
        if (this.zzkob != null) {
            this.zzkob.zzll(str);
        }
    }
}
