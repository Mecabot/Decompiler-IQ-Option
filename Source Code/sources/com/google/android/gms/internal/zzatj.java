package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import java.util.UUID;

public final class zzatj {
    private final String mName;
    private final long zzeeg;
    private /* synthetic */ zzath zzeeh;

    private zzatj(zzath zzath, String str, long j) {
        this.zzeeh = zzath;
        zzbq.zzgv(str);
        zzbq.checkArgument(j > 0);
        this.mName = str;
        this.zzeeg = j;
    }

    private final void zzabg() {
        long currentTimeMillis = this.zzeeh.zzxx().currentTimeMillis();
        Editor edit = this.zzeeh.zzeec.edit();
        edit.remove(zzabk());
        edit.remove(zzabl());
        edit.putLong(zzabj(), currentTimeMillis);
        edit.commit();
    }

    private final long zzabi() {
        return this.zzeeh.zzeec.getLong(zzabj(), 0);
    }

    private final String zzabj() {
        return String.valueOf(this.mName).concat(":start");
    }

    private final String zzabk() {
        return String.valueOf(this.mName).concat(":count");
    }

    private final String zzabl() {
        return String.valueOf(this.mName).concat(":value");
    }

    public final Pair<String, Long> zzabh() {
        long zzabi = zzabi();
        zzabi = zzabi == 0 ? 0 : Math.abs(zzabi - this.zzeeh.zzxx().currentTimeMillis());
        if (zzabi < this.zzeeg) {
            return null;
        }
        if (zzabi > (this.zzeeg << 1)) {
            zzabg();
            return null;
        }
        String string = this.zzeeh.zzeec.getString(zzabl(), null);
        long j = this.zzeeh.zzeec.getLong(zzabk(), 0);
        zzabg();
        return (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
    }

    public final void zzem(String str) {
        if (zzabi() == 0) {
            zzabg();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.zzeeh.zzeec.getLong(zzabk(), 0);
            if (j <= 0) {
                Editor edit = this.zzeeh.zzeec.edit();
                edit.putString(zzabl(), str);
                edit.putLong(zzabk(), 1);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j2 ? 1 : null;
            Editor edit2 = this.zzeeh.zzeec.edit();
            if (obj != null) {
                edit2.putString(zzabl(), str);
            }
            edit2.putLong(zzabk(), j2);
            edit2.apply();
        }
    }
}
