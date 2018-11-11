package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzdkh;
import com.google.android.gms.internal.zzdks;
import com.google.android.gms.internal.zzdkt;
import com.google.android.gms.internal.zzdku;
import com.google.android.gms.internal.zzfls;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

final class zzes implements Runnable {
    private final Context mContext;
    private final String zzknc;
    private volatile String zzkoa;
    private final zzdkt zzkrz;
    private final String zzksa;
    private zzdi<zzbs> zzksb;
    private volatile zzal zzksc;
    private volatile String zzksd;

    private zzes(Context context, String str, zzdkt zzdkt, zzal zzal) {
        this.mContext = context;
        this.zzkrz = zzdkt;
        this.zzknc = str;
        this.zzksc = zzal;
        String valueOf = String.valueOf("/r?id=");
        str = String.valueOf(str);
        this.zzksa = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
        this.zzkoa = this.zzksa;
        this.zzksd = null;
    }

    public zzes(Context context, String str, zzal zzal) {
        this(context, str, new zzdkt(), zzal);
    }

    public final void run() {
        String str;
        String valueOf;
        StringBuilder stringBuilder;
        if (this.zzksb == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        Object obj;
        this.zzksb.zzbfu();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzdj.v("...no network connectivity");
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            this.zzksb.zzex(zzda.zzkqn);
            return;
        }
        zzdj.v("Start loading resource from network ...");
        String zzbgb = this.zzksc.zzbgb();
        String str2 = this.zzkoa;
        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(zzbgb).length() + 12) + String.valueOf(str2).length());
        stringBuilder2.append(zzbgb);
        stringBuilder2.append(str2);
        stringBuilder2.append("&v=a65833898");
        zzbgb = stringBuilder2.toString();
        if (!(this.zzksd == null || this.zzksd.trim().equals(""))) {
            zzbgb = String.valueOf(zzbgb);
            str2 = this.zzksd;
            stringBuilder2 = new StringBuilder((String.valueOf(zzbgb).length() + 4) + String.valueOf(str2).length());
            stringBuilder2.append(zzbgb);
            stringBuilder2.append("&pv=");
            stringBuilder2.append(str2);
            zzbgb = stringBuilder2.toString();
        }
        if (zzei.zzbhh().zzbhi().equals(zza.CONTAINER_DEBUG)) {
            zzbgb = String.valueOf(zzbgb);
            str2 = String.valueOf("&gtm_debug=x");
            zzbgb = str2.length() != 0 ? zzbgb.concat(str2) : new String(zzbgb);
        }
        zzdks zzblc = zzdkt.zzblc();
        InputStream inputStream = null;
        try {
            inputStream = zzblc.zzne(zzbgb);
        } catch (FileNotFoundException unused) {
            String str3 = this.zzknc;
            StringBuilder stringBuilder3 = new StringBuilder((String.valueOf(zzbgb).length() + 79) + String.valueOf(str3).length());
            stringBuilder3.append("No data is retrieved from the given url: ");
            stringBuilder3.append(zzbgb);
            stringBuilder3.append(". Make sure container_id: ");
            stringBuilder3.append(str3);
            stringBuilder3.append(" is correct.");
            zzdj.zzcz(stringBuilder3.toString());
            this.zzksb.zzex(zzda.zzkqp);
            zzblc.close();
            return;
        } catch (zzdku unused2) {
            str = "Error when loading resource for url: ";
            valueOf = String.valueOf(zzbgb);
            zzdj.zzcz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzksb.zzex(zzda.zzkqq);
        } catch (Throwable e) {
            str = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(zzbgb).length() + 40) + String.valueOf(str).length());
            stringBuilder.append("Error when loading resources from url: ");
            stringBuilder.append(zzbgb);
            stringBuilder.append(" ");
            stringBuilder.append(str);
            zzdj.zzc(stringBuilder.toString(), e);
            this.zzksb.zzex(zzda.zzkqo);
            zzblc.close();
            return;
        } catch (Throwable th) {
            zzblc.close();
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zzdkh.zzb(inputStream, byteArrayOutputStream);
            zzbs zzbs = (zzbs) zzfls.zza(new zzbs(), byteArrayOutputStream.toByteArray());
            str = String.valueOf(zzbs);
            stringBuilder = new StringBuilder(String.valueOf(str).length() + 43);
            stringBuilder.append("Successfully loaded supplemented resource: ");
            stringBuilder.append(str);
            zzdj.v(stringBuilder.toString());
            if (zzbs.zzyi == null && zzbs.zzyh.length == 0) {
                str = "No change for container: ";
                valueOf = String.valueOf(this.zzknc);
                zzdj.v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
            this.zzksb.onSuccess(zzbs);
            zzblc.close();
            zzdj.v("Load resource from network finished.");
        } catch (Throwable e2) {
            str = e2.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(zzbgb).length() + 51) + String.valueOf(str).length());
            stringBuilder.append("Error when parsing downloaded resources from url: ");
            stringBuilder.append(zzbgb);
            stringBuilder.append(" ");
            stringBuilder.append(str);
            zzdj.zzc(stringBuilder.toString(), e2);
            this.zzksb.zzex(zzda.zzkqp);
            zzblc.close();
        }
    }

    final void zza(zzdi<zzbs> zzdi) {
        this.zzksb = zzdi;
    }

    final void zzll(String str) {
        if (str == null) {
            str = this.zzksa;
        } else {
            String str2 = "Setting CTFE URL path: ";
            String valueOf = String.valueOf(str);
            zzdj.zzby(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        this.zzkoa = str;
    }

    final void zzmb(String str) {
        String str2 = "Setting previous container version: ";
        String valueOf = String.valueOf(str);
        zzdj.zzby(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzksd = str;
    }
}
