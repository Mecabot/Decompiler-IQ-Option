package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.Hide;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Hide
class zzei {
    private static zzei zzkrl;
    private volatile String zzknc = null;
    private volatile zza zzkrm = zza.NONE;
    private volatile String zzkrn = null;
    private volatile String zzkro = null;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzei() {
    }

    @Hide
    static zzei zzbhh() {
        zzei zzei;
        synchronized (zzei.class) {
            if (zzkrl == null) {
                zzkrl = new zzei();
            }
            zzei = zzkrl;
        }
        return zzei;
    }

    private static String zzma(String str) {
        return str.split("&")[0].split("=")[1];
    }

    final String getContainerId() {
        return this.zzknc;
    }

    final zza zzbhi() {
        return this.zzkrm;
    }

    final String zzbhj() {
        return this.zzkrn;
    }

    final synchronized boolean zzq(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            String str;
            String valueOf;
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                str = "Container preview url: ";
                String valueOf2 = String.valueOf(decode);
                zzdj.v(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                this.zzkrm = decode.matches(".*?&gtm_debug=x$") ? zza.CONTAINER_DEBUG : zza.CONTAINER;
                this.zzkro = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zzkrm == zza.CONTAINER || this.zzkrm == zza.CONTAINER_DEBUG) {
                    valueOf = String.valueOf("/r?");
                    str = String.valueOf(this.zzkro);
                    this.zzkrn = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                }
                this.zzknc = zzma(this.zzkro);
                return true;
            } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                valueOf = "Invalid preview uri: ";
                decode = String.valueOf(decode);
                zzdj.zzcz(decode.length() != 0 ? valueOf.concat(decode) : new String(valueOf));
                return false;
            } else if (!zzma(uri.getQuery()).equals(this.zzknc)) {
                return false;
            } else {
                valueOf = "Exit preview mode for container: ";
                str = String.valueOf(this.zzknc);
                zzdj.v(str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
                this.zzkrm = zza.NONE;
                this.zzkrn = null;
                return true;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }
}
