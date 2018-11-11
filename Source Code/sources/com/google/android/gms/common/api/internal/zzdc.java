package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzdc extends Fragment implements zzcf {
    private static WeakHashMap<FragmentActivity, WeakReference<zzdc>> zzgan = new WeakHashMap();
    private int zzcfl = 0;
    private Map<String, LifecycleCallback> zzgao = new ArrayMap();
    private Bundle zzgap;

    public static zzdc zza(FragmentActivity fragmentActivity) {
        zzdc zzdc;
        WeakReference weakReference = (WeakReference) zzgan.get(fragmentActivity);
        if (weakReference != null) {
            zzdc = (zzdc) weakReference.get();
            if (zzdc != null) {
                return zzdc;
            }
        }
        try {
            zzdc = (zzdc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzdc == null || zzdc.isRemoving()) {
                zzdc = new zzdc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzdc, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzgan.put(fragmentActivity, new WeakReference(zzdc));
            return zzdc;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
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
            new Handler(Looper.getMainLooper()).post(new zzdd(this, lifecycleCallback, str));
        }
    }
}
