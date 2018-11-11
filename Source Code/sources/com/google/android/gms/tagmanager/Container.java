package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdkh;
import com.google.android.gms.internal.zzdkl;
import com.google.android.gms.internal.zzdkp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzknc;
    private final DataLayer zzknd;
    private zzfc zzkne;
    private Map<String, FunctionCallMacroCallback> zzknf = new HashMap();
    private Map<String, FunctionCallTagCallback> zzkng = new HashMap();
    private volatile long zzknh;
    private volatile String zzkni = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    class zza implements zzan {
        private zza() {
        }

        /* synthetic */ zza(Container container, zzu zzu) {
            this();
        }

        public final Object zze(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzlh = Container.this.zzlh(str);
            return zzlh == null ? null : zzlh.getValue(str, map);
        }
    }

    class zzb implements zzan {
        private zzb() {
        }

        /* synthetic */ zzb(Container container, zzu zzu) {
            this();
        }

        public final Object zze(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzli = Container.this.zzli(str);
            if (zzli != null) {
                zzli.execute(str, map);
            }
            return zzgk.zzbik();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzbs zzbs) {
        this.mContext = context;
        this.zzknd = dataLayer;
        this.zzknc = str;
        this.zzknh = j;
        zzbp zzbp = zzbs.zzyi;
        if (zzbp == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzdkh.zza(zzbp));
        } catch (zzdkp e) {
            String valueOf = String.valueOf(zzbp);
            String zzdkp = e.toString();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 46) + String.valueOf(zzdkp).length());
            stringBuilder.append("Not loading resource: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" because it is invalid: ");
            stringBuilder.append(zzdkp);
            zzdj.e(stringBuilder.toString());
        }
        if (zzbs.zzyh != null) {
            zza(zzbs.zzyh);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzdkl zzdkl) {
        this.mContext = context;
        this.zzknd = dataLayer;
        this.zzknc = str;
        this.zzknh = 0;
        zza(zzdkl);
    }

    private final void zza(zzdkl zzdkl) {
        this.zzkni = zzdkl.getVersion();
        String str = this.zzkni;
        zzei.zzbhh().zzbhi().equals(zza.CONTAINER_DEBUG);
        zzdkl zzdkl2 = zzdkl;
        zza(new zzfc(this.mContext, zzdkl2, this.zzknd, new zza(this, null), new zzb(this, null), new zzdr()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzknd.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzknc));
        }
    }

    private final synchronized void zza(zzfc zzfc) {
        this.zzkne = zzfc;
    }

    private final void zza(zzbr[] zzbrArr) {
        List arrayList = new ArrayList();
        for (Object add : zzbrArr) {
            arrayList.add(add);
        }
        zzbfm().zzan(arrayList);
    }

    private final synchronized zzfc zzbfm() {
        return this.zzkne;
    }

    public boolean getBoolean(String str) {
        zzfc zzbfm = zzbfm();
        if (zzbfm == null) {
            str = "getBoolean called for closed container.";
        } else {
            try {
                return zzgk.zzh((zzbt) zzbfm.zzmc(str).getObject()).booleanValue();
            } catch (Exception e) {
                str = e.getMessage();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 66);
                stringBuilder.append("Calling getBoolean() threw an exception: ");
                stringBuilder.append(str);
                stringBuilder.append(" Returning default value.");
                str = stringBuilder.toString();
            }
        }
        zzdj.e(str);
        return zzgk.zzbii().booleanValue();
    }

    public String getContainerId() {
        return this.zzknc;
    }

    public double getDouble(String str) {
        zzfc zzbfm = zzbfm();
        if (zzbfm == null) {
            str = "getDouble called for closed container.";
        } else {
            try {
                return zzgk.zzg((zzbt) zzbfm.zzmc(str).getObject()).doubleValue();
            } catch (Exception e) {
                str = e.getMessage();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
                stringBuilder.append("Calling getDouble() threw an exception: ");
                stringBuilder.append(str);
                stringBuilder.append(" Returning default value.");
                str = stringBuilder.toString();
            }
        }
        zzdj.e(str);
        return zzgk.zzbih().doubleValue();
    }

    public long getLastRefreshTime() {
        return this.zzknh;
    }

    public long getLong(String str) {
        zzfc zzbfm = zzbfm();
        if (zzbfm == null) {
            str = "getLong called for closed container.";
        } else {
            try {
                return zzgk.zzf((zzbt) zzbfm.zzmc(str).getObject()).longValue();
            } catch (Exception e) {
                str = e.getMessage();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 63);
                stringBuilder.append("Calling getLong() threw an exception: ");
                stringBuilder.append(str);
                stringBuilder.append(" Returning default value.");
                str = stringBuilder.toString();
            }
        }
        zzdj.e(str);
        return zzgk.zzbig().longValue();
    }

    public String getString(String str) {
        zzfc zzbfm = zzbfm();
        if (zzbfm == null) {
            str = "getString called for closed container.";
        } else {
            try {
                return zzgk.zzd((zzbt) zzbfm.zzmc(str).getObject());
            } catch (Exception e) {
                str = e.getMessage();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
                stringBuilder.append("Calling getString() threw an exception: ");
                stringBuilder.append(str);
                stringBuilder.append(" Returning default value.");
                str = stringBuilder.toString();
            }
        }
        zzdj.e(str);
        return zzgk.zzbik();
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzknf) {
            this.zzknf.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzkng) {
            this.zzkng.put(str, functionCallTagCallback);
        }
    }

    final void release() {
        this.zzkne = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzknf) {
            this.zzknf.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzkng) {
            this.zzkng.remove(str);
        }
    }

    @Hide
    public final String zzbfl() {
        return this.zzkni;
    }

    final FunctionCallMacroCallback zzlh(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzknf) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzknf.get(str);
        }
        return functionCallMacroCallback;
    }

    @Hide
    public final FunctionCallTagCallback zzli(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzkng) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzkng.get(str);
        }
        return functionCallTagCallback;
    }

    @Hide
    public final void zzlj(String str) {
        zzbfm().zzlj(str);
    }
}
