package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzclk extends zzcli {
    protected zzcly zzjpt;
    private EventInterceptor zzjpu;
    private final Set<OnEventListener> zzjpv = new CopyOnWriteArraySet();
    private boolean zzjpw;
    private final AtomicReference<String> zzjpx = new AtomicReference();

    protected zzclk(zzckj zzckj) {
        super(zzckj);
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzxx().currentTimeMillis();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgv(conditionalUserProperty.mName);
        zzbq.zzgv(conditionalUserProperty.mOrigin);
        zzbq.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzayl().zzkk(str) != 0) {
            zzayp().zzbau().zzj("Invalid conditional user property name", zzayk().zzjr(str));
        } else if (zzayl().zzl(str, obj) != 0) {
            zzayp().zzbau().zze("Invalid conditional user property value", zzayk().zzjr(str), obj);
        } else {
            Object zzm = zzayl().zzm(str, obj);
            if (zzm == null) {
                zzayp().zzbau().zze("Unable to normalize conditional user property value", zzayk().zzjr(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzm;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j > 15552000000L || j < 1) {
                    zzayp().zzbau().zze("Invalid conditional user property time to live", zzayk().zzjr(str), Long.valueOf(j));
                    return;
                } else {
                    zzayo().zzh(new zzclm(this, conditionalUserProperty));
                    return;
                }
            }
            zzayp().zzbau().zze("Invalid conditional user property timeout", zzayk().zzjr(str), Long.valueOf(j));
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str4 : bundle4.keySet()) {
                Object obj = bundle4.get(str4);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        zzayo().zzh(new zzcls(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzayo().zzh(new zzclt(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzxx().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    @WorkerThread
    private final void zza(String str, String str2, Object obj, long j) {
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzwj();
        zzyk();
        if (!this.zzjev.isEnabled()) {
            zzayp().zzbaz().log("User property not set since app measurement is disabled");
        } else if (this.zzjev.zzbbn()) {
            zzayp().zzbaz().zze("Setting user property (FE)", zzayk().zzjp(str2), obj);
            zzayg().zzb(new zzcnl(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzxx().currentTimeMillis();
        zzbq.zzgv(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzayo().zzh(new zzcln(this, conditionalUserProperty));
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzcjl zzbau;
        if (zzayo().zzbbk()) {
            zzbau = zzayp().zzbau();
            str2 = "Cannot get user properties from analytics worker thread";
        } else {
            zzayo();
            if (zzcke.zzas()) {
                zzbau = zzayp().zzbau();
                str2 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzjev.zzayo().zzh(new zzclp(this, atomicReference, str, str2, str3, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzayp().zzbaw().zzj("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzcnl> list = (List) atomicReference.get();
                if (list == null) {
                    zzbau = zzayp().zzbaw();
                    str2 = "Timed out waiting for get user properties";
                } else {
                    Map<String, Object> arrayMap = new ArrayMap(list.size());
                    for (zzcnl zzcnl : list) {
                        arrayMap.put(zzcnl.name, zzcnl.getValue());
                    }
                    return arrayMap;
                }
            }
        }
        zzbau.log(str2);
        return Collections.emptyMap();
    }

    @WorkerThread
    private final void zzb(ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzwj();
        zzyk();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgv(conditionalUserProperty2.mName);
        zzbq.zzgv(conditionalUserProperty2.mOrigin);
        zzbq.checkNotNull(conditionalUserProperty2.mValue);
        if (this.zzjev.isEnabled()) {
            zzcnl zzcnl = new zzcnl(conditionalUserProperty2.mName, conditionalUserProperty2.mTriggeredTimestamp, conditionalUserProperty2.mValue, conditionalUserProperty2.mOrigin);
            try {
                zzcix zza = zzayl().zza(conditionalUserProperty2.mTriggeredEventName, conditionalUserProperty2.mTriggeredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
                zzcix zza2 = zzayl().zza(conditionalUserProperty2.mTimedOutEventName, conditionalUserProperty2.mTimedOutEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
                zzcix zza3 = zzayl().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
                String str = conditionalUserProperty2.mAppId;
                String str2 = conditionalUserProperty2.mOrigin;
                long j = conditionalUserProperty2.mCreationTimestamp;
                String str3 = conditionalUserProperty2.mTriggerEventName;
                long j2 = conditionalUserProperty2.mTriggerTimeout;
                String str4 = str3;
                long j3 = conditionalUserProperty2.mTimeToLive;
                zzcii zzcii = r3;
                zzcii zzcii2 = new zzcii(str, str2, zzcnl, j, false, str4, zza2, j2, zza, j3, zza3);
                zzayg().zzf(zzcii);
            } catch (IllegalArgumentException unused) {
                return;
            }
        }
        zzayp().zzbaz().log("Conditional property not sent since Firebase Analytics is disabled");
    }

    @WorkerThread
    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4 = str;
        String str5 = str2;
        Bundle bundle2 = bundle;
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzbq.checkNotNull(bundle);
        zzwj();
        zzyk();
        if (this.zzjev.isEnabled()) {
            int i;
            zzclz zzclz = null;
            int i2 = 0;
            if (!this.zzjpw) {
                this.zzjpw = true;
                try {
                    try {
                        Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                    } catch (Exception e) {
                        zzayp().zzbaw().zzj("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzayp().zzbay().log("Tag Manager is not found and thus will not be used");
                }
            }
            if (z3 && !"_iap".equals(str5)) {
                zzcno zzayl = this.zzjev.zzayl();
                i = 2;
                if (zzayl.zzaq("event", str5)) {
                    if (!zzayl.zza("event", Event.zzjew, str5)) {
                        i = 13;
                    } else if (zzayl.zzb("event", 40, str5)) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    this.zzjev.zzayl();
                    String zza = zzcno.zza(str5, 40, true);
                    if (str5 != null) {
                        i2 = str2.length();
                    }
                    this.zzjev.zzayl().zza(i, "_ev", zza, i2);
                    return;
                }
            }
            zzclz zzbcg = zzayh().zzbcg();
            if (!(zzbcg == null || bundle2.containsKey("_sc"))) {
                zzbcg.zzjra = true;
            }
            boolean z4 = z && z3;
            zzcma.zza(zzbcg, bundle2, z4);
            boolean equals = "am".equals(str4);
            z4 = zzcno.zzkp(str2);
            if (z && this.zzjpu != null && !z4 && !equals) {
                zzayp().zzbaz().zze("Passing event to registered event handler (FE)", zzayk().zzjp(str5), zzayk().zzac(bundle2));
                this.zzjpu.interceptEvent(str4, str5, bundle2, j);
                return;
            } else if (this.zzjev.zzbbn()) {
                i = zzayl().zzki(str5);
                if (i != 0) {
                    zzayl();
                    this.zzjev.zzayl().zza(str3, i, "_ev", zzcno.zza(str5, 40, true), str5 != null ? str2.length() : 0);
                    return;
                }
                Bundle zza2;
                long j2;
                List unmodifiableList = Collections.unmodifiableList(Arrays.asList(new String[]{"_o", "_sn", "_sc", "_si"}));
                Bundle zza3 = zzayl().zza(str5, bundle2, unmodifiableList, z3, true);
                if (zza3 != null && zza3.containsKey("_sc") && zza3.containsKey("_si")) {
                    zzclz = new zzcmd(zza3.getString("_sn"), zza3.getString("_sc"), Long.valueOf(zza3.getLong("_si")).longValue());
                }
                if (zzclz == null) {
                    zzclz = zzbcg;
                }
                List arrayList = new ArrayList();
                arrayList.add(zza3);
                long nextLong = zzayl().zzbcr().nextLong();
                String[] strArr = (String[]) zza3.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    int i5;
                    int i6;
                    String[] strArr2;
                    String str6 = strArr[i4];
                    Object obj = zza3.get(str6);
                    zzayl();
                    Bundle[] zzaf = zzcno.zzaf(obj);
                    if (zzaf != null) {
                        int i7;
                        i5 = i3;
                        zza3.putInt(str6, zzaf.length);
                        int i8 = i4;
                        i3 = 0;
                        while (i3 < zzaf.length) {
                            Bundle bundle3 = zzaf[i3];
                            i6 = i3;
                            zzcma.zza(zzclz, bundle3, true);
                            i7 = i5;
                            int i9 = i6;
                            i5 = i8;
                            i6 = length;
                            long j3 = nextLong;
                            strArr2 = strArr;
                            bundle2 = zza3;
                            zza2 = zzayl().zza("_ep", bundle3, unmodifiableList, z3, false);
                            zza2.putString("_en", str5);
                            j2 = j3;
                            zza2.putLong("_eid", j2);
                            zza2.putString("_gn", str6);
                            zza2.putInt("_ll", zzaf.length);
                            i = i9;
                            zza2.putInt("_i", i);
                            arrayList.add(zza2);
                            i3 = i + 1;
                            nextLong = j2;
                            zza3 = bundle2;
                            i8 = i5;
                            length = i6;
                            i5 = i7;
                            strArr = strArr2;
                        }
                        i6 = length;
                        j2 = nextLong;
                        strArr2 = strArr;
                        i7 = i5;
                        i5 = i8;
                        bundle2 = zza3;
                        i3 = zzaf.length + i7;
                    } else {
                        i2 = i3;
                        i5 = i4;
                        i6 = length;
                        j2 = nextLong;
                        strArr2 = strArr;
                        bundle2 = zza3;
                    }
                    i4 = i5 + 1;
                    nextLong = j2;
                    zza3 = bundle2;
                    length = i6;
                    strArr = strArr2;
                }
                i2 = i3;
                j2 = nextLong;
                bundle2 = zza3;
                if (i2 != 0) {
                    bundle2.putLong("_eid", j2);
                    bundle2.putInt("_epc", i2);
                }
                int i10 = 0;
                while (i10 < arrayList.size()) {
                    zza2 = (Bundle) arrayList.get(i10);
                    String str7 = (i10 != 0 ? 1 : null) != null ? "_ep" : str5;
                    zza2.putString("_o", str4);
                    if (z2) {
                        zza2 = zzayl().zzad(zza2);
                    }
                    Bundle bundle4 = zza2;
                    zzayp().zzbaz().zze("Logging event (FE)", zzayk().zzjp(str5), zzayk().zzac(bundle4));
                    zzayg().zzc(new zzcix(str7, new zzciu(bundle4), str4, j), str3);
                    if (!equals) {
                        for (OnEventListener onEvent : this.zzjpv) {
                            onEvent.onEvent(str4, str5, new Bundle(bundle4), j);
                        }
                    }
                    i10++;
                }
                if (zzayh().zzbcg() != null && Event.APP_EXCEPTION.equals(str5)) {
                    zzayn().zzbx(true);
                }
                return;
            } else {
                return;
            }
        }
        zzayp().zzbaz().log("Event not sent since app measurement is disabled");
    }

    @WorkerThread
    private final void zzbu(boolean z) {
        zzwj();
        zzyk();
        zzayp().zzbaz().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzayq().setMeasurementEnabled(z);
        zzayg().zzbci();
    }

    @WorkerThread
    private final void zzc(ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzwj();
        zzyk();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgv(conditionalUserProperty2.mName);
        if (this.zzjev.isEnabled()) {
            zzcnl zzcnl = new zzcnl(conditionalUserProperty2.mName, 0, null, null);
            try {
                zzcix zza = zzayl().zza(conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, conditionalUserProperty2.mCreationTimestamp, true, false);
                String str = conditionalUserProperty2.mAppId;
                String str2 = conditionalUserProperty2.mOrigin;
                long j = conditionalUserProperty2.mCreationTimestamp;
                boolean z = conditionalUserProperty2.mActive;
                String str3 = conditionalUserProperty2.mTriggerEventName;
                long j2 = conditionalUserProperty2.mTriggerTimeout;
                long j3 = conditionalUserProperty2.mTimeToLive;
                zzcii zzcii = r3;
                zzcii zzcii2 = new zzcii(str, str2, zzcnl, j, z, str3, null, j2, null, j3, zza);
                zzayg().zzf(zzcii);
            } catch (IllegalArgumentException unused) {
                return;
            }
        }
        zzayp().zzbaz().log("Conditional property not cleared since Firebase Analytics is disabled");
    }

    private final List<ConditionalUserProperty> zzl(String str, String str2, String str3) {
        zzcjl zzbau;
        if (zzayo().zzbbk()) {
            zzbau = zzayp().zzbau();
            str2 = "Cannot get conditional user properties from analytics worker thread";
        } else {
            zzayo();
            if (zzcke.zzas()) {
                zzbau = zzayp().zzbau();
                str2 = "Cannot get conditional user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzjev.zzayo().zzh(new zzclo(this, atomicReference, str, str2, str3));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzayp().zzbaw().zze("Interrupted waiting for get conditional user properties", str, e);
                    }
                }
                List<zzcii> list = (List) atomicReference.get();
                if (list == null) {
                    zzayp().zzbaw().zzj("Timed out waiting for get conditional user properties", str);
                    return Collections.emptyList();
                }
                List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
                for (zzcii zzcii : list) {
                    ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                    conditionalUserProperty.mAppId = str;
                    conditionalUserProperty.mOrigin = str2;
                    conditionalUserProperty.mCreationTimestamp = zzcii.zzjgo;
                    conditionalUserProperty.mName = zzcii.zzjgn.name;
                    conditionalUserProperty.mValue = zzcii.zzjgn.getValue();
                    conditionalUserProperty.mActive = zzcii.zzjgp;
                    conditionalUserProperty.mTriggerEventName = zzcii.zzjgq;
                    if (zzcii.zzjgr != null) {
                        conditionalUserProperty.mTimedOutEventName = zzcii.zzjgr.name;
                        if (zzcii.zzjgr.zzjhr != null) {
                            conditionalUserProperty.mTimedOutEventParams = zzcii.zzjgr.zzjhr.zzbao();
                        }
                    }
                    conditionalUserProperty.mTriggerTimeout = zzcii.zzjgs;
                    if (zzcii.zzjgt != null) {
                        conditionalUserProperty.mTriggeredEventName = zzcii.zzjgt.name;
                        if (zzcii.zzjgt.zzjhr != null) {
                            conditionalUserProperty.mTriggeredEventParams = zzcii.zzjgt.zzjhr.zzbao();
                        }
                    }
                    conditionalUserProperty.mTriggeredTimestamp = zzcii.zzjgn.zzjsi;
                    conditionalUserProperty.mTimeToLive = zzcii.zzjgu;
                    if (zzcii.zzjgv != null) {
                        conditionalUserProperty.mExpiredEventName = zzcii.zzjgv.name;
                        if (zzcii.zzjgv.zzjhr != null) {
                            conditionalUserProperty.mExpiredEventParams = zzcii.zzjgv.zzjhr.zzbao();
                        }
                    }
                    arrayList.add(conditionalUserProperty);
                }
                return arrayList;
            }
        }
        zzbau.log(str2);
        return Collections.emptyList();
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza(null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzbq.zzgv(str);
        zzaxz();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzbbf = zzayq().zzbbf();
            return zzbbf != null ? Tasks.forResult(zzbbf) : Tasks.call(zzayo().zzbbl(), new zzclv(this));
        } catch (Exception e) {
            zzayp().zzbaw().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzl(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzbq.zzgv(str);
        zzaxz();
        return zzl(str, str2, str3);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzbq.zzgv(str);
        zzaxz();
        return zzb(str, str2, str3, z);
    }

    @Hide
    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzyk();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjpv.add(onEventListener)) {
            zzayp().zzbaw().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzayo().zzh(new zzclx(this));
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzayp().zzbaw().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgv(conditionalUserProperty.mAppId);
        zzaxz();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(EventInterceptor eventInterceptor) {
        zzwj();
        zzyk();
        if (!(eventInterceptor == null || eventInterceptor == this.zzjpu)) {
            zzbq.zza(this.zzjpu == null, (Object) "EventInterceptor already set.");
        }
        this.zzjpu = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzyk();
        zzayo().zzh(new zzcll(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzayo().zzh(new zzclq(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzayo().zzh(new zzclr(this, j));
    }

    @Hide
    public final void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        zzyk();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjpv.remove(onEventListener)) {
            zzayp().zzbaw().log("OnEventListener had not been registered");
        }
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        boolean z2 = this.zzjpu == null || zzcno.zzkp(str2);
        zza(str, str2, bundle, true, z2, true, null);
    }

    protected final boolean zzazq() {
        return false;
    }

    public final void zzb(String str, String str2, Object obj) {
        zzbq.zzgv(str);
        long currentTimeMillis = zzxx().currentTimeMillis();
        int zzkk = zzayl().zzkk(str2);
        int i = 0;
        if (zzkk != 0) {
            zzayl();
            str = zzcno.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzjev.zzayl().zza(zzkk, "_ev", str, i);
        } else if (obj != null) {
            zzkk = zzayl().zzl(str2, obj);
            if (zzkk != 0) {
                zzayl();
                str = zzcno.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzjev.zzayl().zza(zzkk, "_ev", str, i);
                return;
            }
            Object zzm = zzayl().zzm(str2, obj);
            if (zzm != null) {
                zza(str, str2, currentTimeMillis, zzm);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    @Nullable
    public final String zzbbf() {
        return (String) this.zzjpx.get();
    }

    /* JADX WARNING: Missing block: B:11:?, code:
            zzayp().zzbaw().log("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Missing block: B:13:0x002c, code:
            return null;
     */
    @android.support.annotation.Nullable
    final java.lang.String zzbd(long r4) {
        /*
        r3 = this;
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        monitor-enter(r0);
        r1 = r3.zzayo();	 Catch:{ all -> 0x002d }
        r2 = new com.google.android.gms.internal.zzclw;	 Catch:{ all -> 0x002d }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002d }
        r1.zzh(r2);	 Catch:{ all -> 0x002d }
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        r4 = r0.get();
        r4 = (java.lang.String) r4;
        return r4;
    L_0x001d:
        r4 = r3.zzayp();	 Catch:{ all -> 0x002d }
        r4 = r4.zzbaw();	 Catch:{ all -> 0x002d }
        r5 = "Interrupted waiting for app instance id";
        r4.log(r5);	 Catch:{ all -> 0x002d }
        r4 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        return r4;
    L_0x002d:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclk.zzbd(long):java.lang.String");
    }

    public final List<zzcnl> zzbv(boolean z) {
        zzcjl zzbau;
        String str;
        zzyk();
        zzayp().zzbaz().log("Fetching user attributes (FE)");
        if (zzayo().zzbbk()) {
            zzbau = zzayp().zzbau();
            str = "Cannot get all user properties from analytics worker thread";
        } else {
            zzayo();
            if (zzcke.zzas()) {
                zzbau = zzayp().zzbau();
                str = "Cannot get all user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzjev.zzayo().zzh(new zzclu(this, atomicReference, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzayp().zzbaw().zzj("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzcnl> list = (List) atomicReference.get();
                if (list != null) {
                    return list;
                }
                zzbau = zzayp().zzbaw();
                str = "Timed out waiting for get user properties";
            }
        }
        zzbau.log(str);
        return Collections.emptyList();
    }

    public final void zzd(String str, String str2, Bundle bundle) {
        boolean z = this.zzjpu == null || zzcno.zzkp(str2);
        zza(str, str2, bundle, true, z, false, null);
    }

    final void zzjx(@Nullable String str) {
        this.zzjpx.set(str);
    }
}
