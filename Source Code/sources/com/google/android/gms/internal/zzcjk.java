package com.google.android.gms.internal;

final class zzcjk implements Runnable {
    private /* synthetic */ String val$message;
    private /* synthetic */ int zzjkr;
    private /* synthetic */ Object zzjks;
    private /* synthetic */ Object zzjkt;
    private /* synthetic */ Object zzjku;
    private /* synthetic */ zzcjj zzjkv;

    zzcjk(zzcjj zzcjj, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzjkv = zzcjj;
        this.zzjkr = i;
        this.val$message = str;
        this.zzjks = obj;
        this.zzjkt = obj2;
        this.zzjku = obj3;
    }

    public final void run() {
        zzcli zzayq = this.zzjkv.zzjev.zzayq();
        if (zzayq.isInitialized()) {
            char c;
            if (this.zzjkv.zzjkg == 0) {
                zzcjj zzcjj;
                if (this.zzjkv.zzayr().zzzu()) {
                    zzcjj = this.zzjkv;
                    c = 'C';
                } else {
                    zzcjj = this.zzjkv;
                    c = 'c';
                }
                zzcjj.zzjkg = c;
            }
            if (this.zzjkv.zzjft < 0) {
                this.zzjkv.zzjft = 12211;
            }
            char charAt = "01VDIWEA?".charAt(this.zzjkr);
            c = this.zzjkv.zzjkg;
            long zzb = this.zzjkv.zzjft;
            String zza = zzcjj.zza(true, this.val$message, this.zzjks, this.zzjkt, this.zzjku);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(zza).length() + 24);
            stringBuilder.append("2");
            stringBuilder.append(charAt);
            stringBuilder.append(c);
            stringBuilder.append(zzb);
            stringBuilder.append(":");
            stringBuilder.append(zza);
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 1024) {
                stringBuilder2 = this.val$message.substring(0, 1024);
            }
            zzayq.zzjlm.zzf(stringBuilder2, 1);
            return;
        }
        this.zzjkv.zzm(6, "Persisted config not initialized. Not logging error/warn");
    }
}
