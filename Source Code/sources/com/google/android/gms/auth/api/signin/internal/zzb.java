package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzdb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbhf;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zzb implements Runnable {
    private static final zzbhf zzenl = new zzbhf("RevokeAccessOperation", new String[0]);
    private final String zzeia;
    private final zzdb zzenm = new zzdb(null);

    private zzb(String str) {
        zzbq.zzgv(str);
        this.zzeia = str;
    }

    public static PendingResult<Status> zzfd(String str) {
        if (str == null) {
            return PendingResults.zza(new Status(4), null);
        }
        Object zzb = new zzb(str);
        new Thread(zzb).start();
        return zzb.zzenm;
    }

    public final void run() {
        String valueOf;
        Result result = Status.zzfts;
        String valueOf2;
        zzbhf zzbhf;
        try {
            String valueOf3 = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            valueOf2 = String.valueOf(this.zzeia);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                result = Status.zzftq;
            } else {
                zzenl.zzc("Unable to revoke access!", new Object[0]);
            }
            zzbhf = zzenl;
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Response Code: ");
            stringBuilder.append(responseCode);
            zzbhf.zzb(stringBuilder.toString(), new Object[0]);
        } catch (IOException e) {
            zzbhf = zzenl;
            valueOf2 = "IOException when revoking access: ";
            valueOf = String.valueOf(e.toString());
            if (valueOf.length() == 0) {
                valueOf = new String(valueOf2);
                zzbhf.zzc(valueOf, new Object[0]);
                this.zzenm.setResult(result);
            }
            valueOf = valueOf2.concat(valueOf);
            zzbhf.zzc(valueOf, new Object[0]);
            this.zzenm.setResult(result);
        } catch (Exception e2) {
            zzbhf = zzenl;
            valueOf2 = "Exception when revoking access: ";
            valueOf = String.valueOf(e2.toString());
            if (valueOf.length() == 0) {
                valueOf = new String(valueOf2);
                zzbhf.zzc(valueOf, new Object[0]);
                this.zzenm.setResult(result);
            }
            valueOf = valueOf2.concat(valueOf);
            zzbhf.zzc(valueOf, new Object[0]);
            this.zzenm.setResult(result);
        }
        this.zzenm.setResult(result);
    }
}
