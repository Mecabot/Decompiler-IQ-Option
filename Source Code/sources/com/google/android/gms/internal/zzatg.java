package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzatg {
    private int zzedz;
    private ByteArrayOutputStream zzeea = new ByteArrayOutputStream();
    private /* synthetic */ zzatf zzeeb;

    public zzatg(zzatf zzatf) {
        this.zzeeb = zzatf;
    }

    public final byte[] getPayload() {
        return this.zzeea.toByteArray();
    }

    public final int zzaaz() {
        return this.zzedz;
    }

    public final boolean zze(zzasy zzasy) {
        zzbq.checkNotNull(zzasy);
        if (this.zzedz + 1 > zzasl.zzaaa()) {
            return false;
        }
        String zza = this.zzeeb.zza(zzasy, false);
        if (zza == null) {
            this.zzeeb.zzh().zza(zzasy, "Error formatting hit");
            return true;
        }
        byte[] bytes = zza.getBytes();
        int length = bytes.length;
        if (length > zzasl.zzzw()) {
            this.zzeeb.zzh().zza(zzasy, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.zzeea.size() > 0) {
            length++;
        }
        if (this.zzeea.size() + length > ((Integer) zzast.zzecl.get()).intValue()) {
            return false;
        }
        try {
            if (this.zzeea.size() > 0) {
                this.zzeea.write(zzatf.zzedy);
            }
            this.zzeea.write(bytes);
            this.zzedz++;
            return true;
        } catch (IOException e) {
            this.zzeeb.zze("Failed to write payload when batching hits", e);
            return true;
        }
    }
}
