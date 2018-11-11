package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzkuc;
    private final Context mContext;
    private final DataLayer zzknd;
    private final zzal zzksc;
    private final zza zzktz;
    private final zzfn zzkua;
    private final ConcurrentMap<String, zzv> zzkub;

    @Hide
    public interface zza {
        zzy zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzal zzal);
    }

    private TagManager(Context context, zza zza, DataLayer dataLayer, zzfn zzfn) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzkua = zzfn;
        this.zzktz = zza;
        this.zzkub = new ConcurrentHashMap();
        this.zzknd = dataLayer;
        this.zzknd.zza(new zzgb(this));
        this.zzknd.zza(new zzg(this.mContext));
        this.zzksc = new zzal();
        this.mContext.registerComponentCallbacks(new zzgd(this));
        zza.zzeg(this.mContext);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzkuc == null) {
                if (context == null) {
                    zzdj.e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzkuc = new TagManager(context, new zzgc(), new DataLayer(new zzat(context)), zzfo.zzbhz());
            }
            tagManager = zzkuc;
        }
        return tagManager;
    }

    private final void zzme(String str) {
        for (zzv zzlj : this.zzkub.values()) {
            zzlj.zzlj(str);
        }
    }

    public void dispatch() {
        this.zzkua.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzknd;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, @RawRes int i) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, null, str, i, this.zzksc);
        zza.zzbfq();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, handler.getLooper(), str, i, this.zzksc);
        zza.zzbfq();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, @RawRes int i) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, null, str, i, this.zzksc);
        zza.zzbfs();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, handler.getLooper(), str, i, this.zzksc);
        zza.zzbfs();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, @RawRes int i) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, null, str, i, this.zzksc);
        zza.zzbfr();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, @RawRes int i, Handler handler) {
        PendingResult zza = this.zzktz.zza(this.mContext, this, handler.getLooper(), str, i, this.zzksc);
        zza.zzbfr();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzdj.setLogLevel(z ? 2 : 5);
    }

    @Hide
    public final int zza(zzv zzv) {
        this.zzkub.put(zzv.getContainerId(), zzv);
        return this.zzkub.size();
    }

    @Hide
    public final boolean zzb(zzv zzv) {
        return this.zzkub.remove(zzv.getContainerId()) != null;
    }

    final synchronized boolean zzq(Uri uri) {
        boolean z;
        zzei zzbhh = zzei.zzbhh();
        if (zzbhh.zzq(uri)) {
            String containerId = zzbhh.getContainerId();
            switch (zzge.zzkue[zzbhh.zzbhi().ordinal()]) {
                case 1:
                    zzv zzv = (zzv) this.zzkub.get(containerId);
                    if (zzv != null) {
                        zzv.zzlk(null);
                        zzv.refresh();
                        break;
                    }
                    break;
                case 2:
                case 3:
                    for (String str : this.zzkub.keySet()) {
                        zzv zzv2 = (zzv) this.zzkub.get(str);
                        if (str.equals(containerId)) {
                            zzv2.zzlk(zzbhh.zzbhj());
                        } else if (zzv2.zzbfn() != null) {
                            zzv2.zzlk(null);
                        }
                        zzv2.refresh();
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
