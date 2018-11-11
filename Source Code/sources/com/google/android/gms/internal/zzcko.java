package com.google.android.gms.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzz;
import com.google.android.gms.common.zzs;
import com.google.android.gms.common.zzt;

public final class zzcko extends zzcjc {
    private final zzckj zzjev;
    private Boolean zzjph;
    @Nullable
    private String zzjpi;

    public zzcko(zzckj zzckj) {
        this(zzckj, null);
    }

    private zzcko(zzckj zzckj, @Nullable String str) {
        zzbq.checkNotNull(zzckj);
        this.zzjev = zzckj;
        this.zzjpi = null;
    }

    @BinderThread
    private final void zzb(zzcif zzcif, boolean z) {
        zzbq.checkNotNull(zzcif);
        zzg(zzcif.packageName, false);
        this.zzjev.zzayl().zzkn(zzcif.zzjfl);
    }

    @BinderThread
    private final void zzg(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zzjev.zzayp().zzbau().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzjph == null) {
                    z = "com.google.android.gms".equals(this.zzjpi) || zzz.zze(this.zzjev.getContext(), Binder.getCallingUid()) || zzt.zzcj(this.zzjev.getContext()).zzbp(Binder.getCallingUid());
                    this.zzjph = Boolean.valueOf(z);
                }
                if (this.zzjph.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzjev.zzayp().zzbau().zzj("Measurement Service called with invalid calling package. appId", zzcjj.zzjs(str));
                throw e;
            }
        }
        if (this.zzjpi == null && zzs.zzb(this.zzjev.getContext(), Binder.getCallingUid(), str)) {
            this.zzjpi = str;
        }
        if (!str.equals(this.zzjpi)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A:{Splitter: B:1:0x0013, ExcHandler: java.lang.InterruptedException (r6_1 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:12:0x0046, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x0047, code:
            r4.zzjev.zzayp().zzbau().zze("Failed to get user attributes. appId", com.google.android.gms.internal.zzcjj.zzjs(r5.packageName), r6);
     */
    /* JADX WARNING: Missing block: B:14:0x005d, code:
            return null;
     */
    @android.support.annotation.BinderThread
    public final java.util.List<com.google.android.gms.internal.zzcnl> zza(com.google.android.gms.internal.zzcif r5, boolean r6) {
        /*
        r4 = this;
        r0 = 0;
        r4.zzb(r5, r0);
        r0 = r4.zzjev;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzcle;
        r1.<init>(r4, r5);
        r0 = r0.zzc(r1);
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = (java.util.List) r0;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1 = new java.util.ArrayList;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r2 = r0.size();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1.<init>(r2);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = r0.iterator();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
    L_0x0026:
        r2 = r0.hasNext();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r2 == 0) goto L_0x0045;
    L_0x002c:
        r2 = r0.next();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r2 = (com.google.android.gms.internal.zzcnn) r2;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r6 != 0) goto L_0x003c;
    L_0x0034:
        r3 = r2.name;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r3 = com.google.android.gms.internal.zzcno.zzkp(r3);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r3 != 0) goto L_0x0026;
    L_0x003c:
        r3 = new com.google.android.gms.internal.zzcnl;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r3.<init>(r2);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1.add(r3);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        goto L_0x0026;
    L_0x0045:
        return r1;
    L_0x0046:
        r6 = move-exception;
        r0 = r4.zzjev;
        r0 = r0.zzayp();
        r0 = r0.zzbau();
        r1 = "Failed to get user attributes. appId";
        r5 = r5.packageName;
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r5);
        r0.zze(r1, r5, r6);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zza(com.google.android.gms.internal.zzcif, boolean):java.util.List<com.google.android.gms.internal.zzcnl>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001a A:{Splitter: B:1:0x0013, ExcHandler: java.lang.InterruptedException (r3_4 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:4:0x001a, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x001b, code:
            r2.zzjev.zzayp().zzbau().zzj("Failed to get conditional user properties", r3);
     */
    /* JADX WARNING: Missing block: B:6:0x002e, code:
            return java.util.Collections.emptyList();
     */
    @android.support.annotation.BinderThread
    public final java.util.List<com.google.android.gms.internal.zzcii> zza(java.lang.String r3, java.lang.String r4, com.google.android.gms.internal.zzcif r5) {
        /*
        r2 = this;
        r0 = 0;
        r2.zzb(r5, r0);
        r0 = r2.zzjev;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzckw;
        r1.<init>(r2, r5, r3, r4);
        r3 = r0.zzc(r1);
        r3 = r3.get();	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r3 = (java.util.List) r3;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        return r3;
    L_0x001a:
        r3 = move-exception;
        r4 = r2.zzjev;
        r4 = r4.zzayp();
        r4 = r4.zzbau();
        r5 = "Failed to get conditional user properties";
        r4.zzj(r5, r3);
        r3 = java.util.Collections.emptyList();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zza(java.lang.String, java.lang.String, com.google.android.gms.internal.zzcif):java.util.List<com.google.android.gms.internal.zzcii>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A:{Splitter: B:1:0x0013, ExcHandler: java.lang.InterruptedException (r4_5 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:12:0x0046, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x0047, code:
            r2.zzjev.zzayp().zzbau().zze("Failed to get user attributes. appId", com.google.android.gms.internal.zzcjj.zzjs(r3), r4);
     */
    /* JADX WARNING: Missing block: B:14:0x005e, code:
            return java.util.Collections.emptyList();
     */
    @android.support.annotation.BinderThread
    public final java.util.List<com.google.android.gms.internal.zzcnl> zza(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
        r2 = this;
        r0 = 1;
        r2.zzg(r3, r0);
        r0 = r2.zzjev;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzckv;
        r1.<init>(r2, r3, r4, r5);
        r4 = r0.zzc(r1);
        r4 = r4.get();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r4 = (java.util.List) r4;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r5 = new java.util.ArrayList;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = r4.size();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r5.<init>(r0);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r4 = r4.iterator();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
    L_0x0026:
        r0 = r4.hasNext();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r0 == 0) goto L_0x0045;
    L_0x002c:
        r0 = r4.next();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = (com.google.android.gms.internal.zzcnn) r0;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r6 != 0) goto L_0x003c;
    L_0x0034:
        r1 = r0.name;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1 = com.google.android.gms.internal.zzcno.zzkp(r1);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r1 != 0) goto L_0x0026;
    L_0x003c:
        r1 = new com.google.android.gms.internal.zzcnl;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1.<init>(r0);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r5.add(r1);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        goto L_0x0026;
    L_0x0045:
        return r5;
    L_0x0046:
        r4 = move-exception;
        r5 = r2.zzjev;
        r5 = r5.zzayp();
        r5 = r5.zzbau();
        r6 = "Failed to get user attributes. appId";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r3);
        r5.zze(r6, r3, r4);
        r3 = java.util.Collections.emptyList();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.List<com.google.android.gms.internal.zzcnl>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A:{Splitter: B:1:0x0013, ExcHandler: java.lang.InterruptedException (r3_5 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:12:0x0046, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x0047, code:
            r2.zzjev.zzayp().zzbau().zze("Failed to get user attributes. appId", com.google.android.gms.internal.zzcjj.zzjs(r6.packageName), r3);
     */
    /* JADX WARNING: Missing block: B:14:0x0060, code:
            return java.util.Collections.emptyList();
     */
    @android.support.annotation.BinderThread
    public final java.util.List<com.google.android.gms.internal.zzcnl> zza(java.lang.String r3, java.lang.String r4, boolean r5, com.google.android.gms.internal.zzcif r6) {
        /*
        r2 = this;
        r0 = 0;
        r2.zzb(r6, r0);
        r0 = r2.zzjev;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzcku;
        r1.<init>(r2, r6, r3, r4);
        r3 = r0.zzc(r1);
        r3 = r3.get();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r3 = (java.util.List) r3;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r4 = new java.util.ArrayList;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = r3.size();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r4.<init>(r0);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r3 = r3.iterator();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
    L_0x0026:
        r0 = r3.hasNext();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r0 == 0) goto L_0x0045;
    L_0x002c:
        r0 = r3.next();	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r0 = (com.google.android.gms.internal.zzcnn) r0;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r5 != 0) goto L_0x003c;
    L_0x0034:
        r1 = r0.name;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1 = com.google.android.gms.internal.zzcno.zzkp(r1);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        if (r1 != 0) goto L_0x0026;
    L_0x003c:
        r1 = new com.google.android.gms.internal.zzcnl;	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r1.<init>(r0);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        r4.add(r1);	 Catch:{ InterruptedException -> 0x0046, InterruptedException -> 0x0046 }
        goto L_0x0026;
    L_0x0045:
        return r4;
    L_0x0046:
        r3 = move-exception;
        r4 = r2.zzjev;
        r4 = r4.zzayp();
        r4 = r4.zzbau();
        r5 = "Failed to get user attributes. appId";
        r6 = r6.packageName;
        r6 = com.google.android.gms.internal.zzcjj.zzjs(r6);
        r4.zze(r5, r6, r3);
        r3 = java.util.Collections.emptyList();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zza(java.lang.String, java.lang.String, boolean, com.google.android.gms.internal.zzcif):java.util.List<com.google.android.gms.internal.zzcnl>");
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        this.zzjev.zzayo().zzh(new zzclg(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(zzcif zzcif) {
        zzb(zzcif, false);
        Runnable zzclf = new zzclf(this, zzcif);
        if (this.zzjev.zzayo().zzbbk()) {
            zzclf.run();
        } else {
            this.zzjev.zzayo().zzh(zzclf);
        }
    }

    @BinderThread
    public final void zza(zzcii zzcii, zzcif zzcif) {
        zzcke zzayo;
        Runnable zzckq;
        zzbq.checkNotNull(zzcii);
        zzbq.checkNotNull(zzcii.zzjgn);
        zzb(zzcif, false);
        zzcii zzcii2 = new zzcii(zzcii);
        zzcii2.packageName = zzcif.packageName;
        if (zzcii.zzjgn.getValue() == null) {
            zzayo = this.zzjev.zzayo();
            zzckq = new zzckq(this, zzcii2, zzcif);
        } else {
            zzayo = this.zzjev.zzayo();
            zzckq = new zzckr(this, zzcii2, zzcif);
        }
        zzayo.zzh(zzckq);
    }

    @BinderThread
    public final void zza(zzcix zzcix, zzcif zzcif) {
        zzbq.checkNotNull(zzcix);
        zzb(zzcif, false);
        this.zzjev.zzayo().zzh(new zzckz(this, zzcix, zzcif));
    }

    @BinderThread
    public final void zza(zzcix zzcix, String str, String str2) {
        zzbq.checkNotNull(zzcix);
        zzbq.zzgv(str);
        zzg(str, true);
        this.zzjev.zzayo().zzh(new zzcla(this, zzcix, str));
    }

    @BinderThread
    public final void zza(zzcnl zzcnl, zzcif zzcif) {
        zzcke zzayo;
        Runnable zzclc;
        zzbq.checkNotNull(zzcnl);
        zzb(zzcif, false);
        if (zzcnl.getValue() == null) {
            zzayo = this.zzjev.zzayo();
            zzclc = new zzclc(this, zzcnl, zzcif);
        } else {
            zzayo = this.zzjev.zzayo();
            zzclc = new zzcld(this, zzcnl, zzcif);
        }
        zzayo.zzh(zzclc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0093 A:{Splitter: B:1:0x0042, ExcHandler: java.lang.InterruptedException (r0_9 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:7:0x0093, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x0094, code:
            r11.zzjev.zzayp().zzbau().zzd("Failed to log and bundle. appId, event, error", com.google.android.gms.internal.zzcjj.zzjs(r13), r11.zzjev.zzayk().zzjp(r12.name), r0);
     */
    /* JADX WARNING: Missing block: B:9:0x00b4, code:
            return null;
     */
    @android.support.annotation.BinderThread
    public final byte[] zza(com.google.android.gms.internal.zzcix r12, java.lang.String r13) {
        /*
        r11 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r13);
        com.google.android.gms.common.internal.zzbq.checkNotNull(r12);
        r0 = 1;
        r11.zzg(r13, r0);
        r0 = r11.zzjev;
        r0 = r0.zzayp();
        r0 = r0.zzbaz();
        r1 = "Log and bundle. event";
        r2 = r11.zzjev;
        r2 = r2.zzayk();
        r3 = r12.name;
        r2 = r2.zzjp(r3);
        r0.zzj(r1, r2);
        r0 = r11.zzjev;
        r0 = r0.zzxx();
        r0 = r0.nanoTime();
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r0 = r0 / r2;
        r4 = r11.zzjev;
        r4 = r4.zzayo();
        r5 = new com.google.android.gms.internal.zzclb;
        r5.<init>(r11, r12, r13);
        r4 = r4.zzd(r5);
        r4 = r4.get();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r4 = (byte[]) r4;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        if (r4 != 0) goto L_0x0060;
    L_0x004a:
        r4 = r11.zzjev;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r4 = r4.zzayp();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r4 = r4.zzbau();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r5 = "Log and bundle returned null. appId";
        r6 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r4.zzj(r5, r6);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r4 = 0;
        r4 = new byte[r4];	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
    L_0x0060:
        r5 = r11.zzjev;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r5 = r5.zzxx();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r5 = r5.nanoTime();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r5 = r5 / r2;
        r2 = r11.zzjev;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r2 = r2.zzayp();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r2 = r2.zzbaz();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r3 = "Log and bundle processed. event, size, time_ms";
        r7 = r11.zzjev;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r7 = r7.zzayk();	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r8 = r12.name;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r7 = r7.zzjp(r8);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r8 = r4.length;	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r9 = 0;
        r9 = r5 - r0;
        r0 = java.lang.Long.valueOf(r9);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        r2.zzd(r3, r7, r8, r0);	 Catch:{ InterruptedException -> 0x0093, InterruptedException -> 0x0093 }
        return r4;
    L_0x0093:
        r0 = move-exception;
        r1 = r11.zzjev;
        r1 = r1.zzayp();
        r1 = r1.zzbau();
        r2 = "Failed to log and bundle. appId, event, error";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r13);
        r3 = r11.zzjev;
        r3 = r3.zzayk();
        r12 = r12.name;
        r12 = r3.zzjp(r12);
        r1.zzd(r2, r13, r12, r0);
        r12 = 0;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zza(com.google.android.gms.internal.zzcix, java.lang.String):byte[]");
    }

    @BinderThread
    public final void zzb(zzcif zzcif) {
        zzb(zzcif, false);
        this.zzjev.zzayo().zzh(new zzckp(this, zzcif));
    }

    @BinderThread
    public final void zzb(zzcii zzcii) {
        zzcke zzayo;
        Runnable zzcks;
        zzbq.checkNotNull(zzcii);
        zzbq.checkNotNull(zzcii.zzjgn);
        zzg(zzcii.packageName, true);
        zzcii zzcii2 = new zzcii(zzcii);
        if (zzcii.zzjgn.getValue() == null) {
            zzayo = this.zzjev.zzayo();
            zzcks = new zzcks(this, zzcii2);
        } else {
            zzayo = this.zzjev.zzayo();
            zzcks = new zzckt(this, zzcii2);
        }
        zzayo.zzh(zzcks);
    }

    @BinderThread
    public final String zzc(zzcif zzcif) {
        zzb(zzcif, false);
        return this.zzjev.zzkf(zzcif.packageName);
    }

    @BinderThread
    public final void zzd(zzcif zzcif) {
        zzg(zzcif.packageName, false);
        this.zzjev.zzayo().zzh(new zzcky(this, zzcif));
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001a A:{Splitter: B:1:0x0013, ExcHandler: java.lang.InterruptedException (r3_4 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:4:0x001a, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x001b, code:
            r2.zzjev.zzayp().zzbau().zzj("Failed to get conditional user properties", r3);
     */
    /* JADX WARNING: Missing block: B:6:0x002e, code:
            return java.util.Collections.emptyList();
     */
    @android.support.annotation.BinderThread
    public final java.util.List<com.google.android.gms.internal.zzcii> zzk(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
        r2 = this;
        r0 = 1;
        r2.zzg(r3, r0);
        r0 = r2.zzjev;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzckx;
        r1.<init>(r2, r3, r4, r5);
        r3 = r0.zzc(r1);
        r3 = r3.get();	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        r3 = (java.util.List) r3;	 Catch:{ InterruptedException -> 0x001a, InterruptedException -> 0x001a }
        return r3;
    L_0x001a:
        r3 = move-exception;
        r4 = r2.zzjev;
        r4 = r4.zzayp();
        r4 = r4.zzbau();
        r5 = "Failed to get conditional user properties";
        r4.zzj(r5, r3);
        r3 = java.util.Collections.emptyList();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcko.zzk(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.zzcii>");
    }
}
