package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzcg extends Fragment implements zzcf {
    private static WeakHashMap<Activity, WeakReference<zzcg>> zzgan = new WeakHashMap();
    private int zzcfl = 0;
    private Map<String, LifecycleCallback> zzgao = new ArrayMap();
    private Bundle zzgap;

    public static zzcg zzp(Activity activity) {
        zzcg zzcg;
        WeakReference weakReference = (WeakReference) zzgan.get(activity);
        if (weakReference != null) {
            zzcg = (zzcg) weakReference.get();
            if (zzcg != null) {
                return zzcg;
            }
        }
        try {
            zzcg = (zzcg) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzcg == null || zzcg.isRemoving()) {
                zzcg = new zzcg();
                activity.getFragmentManager().beginTransaction().add(zzcg, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzgan.put(activity, new WeakReference(zzcg));
            return zzcg;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzgao.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzgao.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzcfl = 1;
        this.zzgap = bundle;
        for (Entry entry : this.zzgao.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzcfl = 5;
        for (LifecycleCallback onDestroy : this.zzgao.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzcfl = 3;
        for (LifecycleCallback onResume : this.zzgao.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.zzgao.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzcfl = 2;
        for (LifecycleCallback onStart : this.zzgao.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzcfl = 4;
        for (LifecycleCallback onStop : this.zzgao.values()) {
            onStop.onStop();
        }
    }

    public final <T extends LifecycleCallback> T zza(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzgao.get(str));
    }

    public final void zza(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (this.zzgao.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 59);
            stringBuilder.append("LifecycleCallback with tag ");
            stringBuilder.append(str);
            stringBuilder.append(" already added to this fragment.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.zzgao.put(str, lifecycleCallback);
        if (this.zzcfl > 0) {
            new Handler(Looper.getMainLooper()).post(new zzch(this, lifecycleCallback, str));
        }
    }

    public final Activity zzakw() {
        return getActivity();
    }
}
