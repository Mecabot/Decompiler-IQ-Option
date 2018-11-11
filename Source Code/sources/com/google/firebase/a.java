package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzu;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class a {
    private static final List<String> Xp = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> Xq = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> Xr = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> Xs = Arrays.asList(new String[0]);
    private static final Set<String> Xt = Collections.emptySet();
    static final Map<String, a> Xu = new ArrayMap();
    private static final Object sLock = new Object();
    private final List<Object> XA = new CopyOnWriteArrayList();
    private b XB;
    private final b Xv;
    private final AtomicBoolean Xw = new AtomicBoolean(false);
    private final AtomicBoolean Xx = new AtomicBoolean();
    private final List<Object> Xy = new CopyOnWriteArrayList();
    private final List<a> Xz = new CopyOnWriteArrayList();
    private final Context mApplicationContext;
    private final String mName;

    @Hide
    public interface a {
        void zzbj(boolean z);
    }

    @Hide
    public interface b {
    }

    @Hide
    @TargetApi(24)
    static class c extends BroadcastReceiver {
        private static AtomicReference<c> XC = new AtomicReference();
        private final Context mApplicationContext;

        private c(Context context) {
            this.mApplicationContext = context;
        }

        private static void ay(Context context) {
            if (XC.get() == null) {
                BroadcastReceiver cVar = new c(context);
                if (XC.compareAndSet(null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (a.sLock) {
                for (a a : a.Xu.values()) {
                    a.wh();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    @Hide
    private a(Context context, String str, b bVar) {
        this.mApplicationContext = (Context) zzbq.checkNotNull(context);
        this.mName = zzbq.zzgv(str);
        this.Xv = (b) zzbq.checkNotNull(bVar);
        this.XB = new com.google.firebase.a.a();
    }

    public static a a(Context context, b bVar) {
        return a(context, bVar, "[DEFAULT]");
    }

    public static a a(Context context, b bVar, String str) {
        Object aVar;
        com.google.firebase.a.b.aC(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.zza((Application) context.getApplicationContext());
            zzk.zzaij().zza(new c());
        }
        str = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            boolean containsKey = Xu.containsKey(str) ^ 1;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 33);
            stringBuilder.append("FirebaseApp name ");
            stringBuilder.append(str);
            stringBuilder.append(" already exists!");
            zzbq.zza(containsKey, stringBuilder.toString());
            zzbq.checkNotNull(context, "Application context cannot be null.");
            aVar = new a(context, str, bVar);
            Xu.put(str, aVar);
        }
        com.google.firebase.a.b.c(aVar);
        aVar.a(a.class, aVar, Xp);
        if (aVar.wg()) {
            aVar.a(a.class, aVar, Xq);
            aVar.a(Context.class, aVar.getApplicationContext(), Xr);
        }
        return aVar;
    }

    private final <T> void a(Class<T> cls, T t, Iterable<String> iterable) {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.mApplicationContext);
        if (isDeviceProtectedStorage) {
            c.ay(this.mApplicationContext);
        }
        for (String str : iterable) {
            String str2;
            if (isDeviceProtectedStorage) {
                try {
                    if (!Xs.contains(str2)) {
                    }
                } catch (ClassNotFoundException unused) {
                    if (Xt.contains(str2)) {
                        throw new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(str2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e);
                } catch (Throwable e2) {
                    String str3 = "FirebaseApp";
                    String str4 = "Failed to initialize ";
                    str2 = String.valueOf(str2);
                    Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e2);
                }
            }
            Method method = Class.forName(str2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    private final void ag(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a zzbj : this.Xz) {
            zzbj.zzbj(z);
        }
    }

    @Nullable
    public static a ax(Context context) {
        synchronized (sLock) {
            a we;
            if (Xu.containsKey("[DEFAULT]")) {
                we = we();
                return we;
            }
            b aA = b.aA(context);
            if (aA == null) {
                return null;
            }
            we = a(context, aA);
            return we;
        }
    }

    @Nullable
    public static a we() {
        a aVar;
        synchronized (sLock) {
            aVar = (a) Xu.get("[DEFAULT]");
            if (aVar == null) {
                String zzany = zzu.zzany();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(zzany).length() + 116);
                stringBuilder.append("Default FirebaseApp is not initialized in this process ");
                stringBuilder.append(zzany);
                stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return aVar;
    }

    private final void wf() {
        zzbq.zza(this.Xx.get() ^ 1, (Object) "FirebaseApp was deleted");
    }

    private final void wh() {
        a(a.class, (Object) this, Xp);
        if (wg()) {
            a(a.class, (Object) this, Xq);
            a(Context.class, this.mApplicationContext, Xr);
        }
    }

    @Hide
    public static void zzbj(boolean z) {
        synchronized (sLock) {
            ArrayList arrayList = new ArrayList(Xu.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                a aVar = (a) obj;
                if (aVar.Xw.get()) {
                    aVar.ag(z);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof a) ? false : this.mName.equals(((a) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        wf();
        return this.mApplicationContext;
    }

    @NonNull
    public String getName() {
        wf();
        return this.mName;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return zzbg.zzx(this).zzg("name", this.mName).zzg("options", this.Xv).toString();
    }

    @NonNull
    public b wd() {
        wf();
        return this.Xv;
    }

    @Hide
    public final boolean wg() {
        return "[DEFAULT]".equals(getName());
    }
}
