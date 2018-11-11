package com.iqoption.core.f;

import android.support.v4.util.Pools.SynchronizedPool;
import com.iqoption.core.data.d.d;
import com.iqoption.core.util.o;
import io.reactivex.c.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0004J\u0010\u0010;\u001a\u0004\u0018\u00010\u00162\u0006\u0010<\u001a\u00020\u0004J\u001a\u0010;\u001a\u0004\u0018\u00010\u00162\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0015H\u0002J\u0018\u0010>\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0004J\u001a\u0010?\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020\u0015H\u0002J\u0018\u0010A\u001a\u00020&2\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u00020&J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ\b\u0010G\u001a\u000207H\u0002J\b\u0010H\u001a\u000207H\u0002J\b\u0010I\u001a\u000207H\u0002J\u001c\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00160\r2\u0006\u0010K\u001a\u00020\u0016H\u0002J\"\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00160\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R4\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00160\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'R,\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, aXE = {"Lcom/iqoption/core/manager/Toggles;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "PREF_KEY", "", "PREF_NAME", "cachedFeatures", "", "getCachedFeatures", "()Ljava/util/List;", "setCachedFeatures", "(Ljava/util/List;)V", "cachedStatuses", "", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "defaultFeatures", "Lkotlin/Function2;", "", "Lcom/iqoption/core/microservices/features/response/Feature;", "getDefaultFeatures", "()Lkotlin/jvm/functions/Function2;", "setDefaultFeatures", "(Lkotlin/jvm/functions/Function2;)V", "defaultVersions", "Lkotlin/Function1;", "getDefaultVersions", "()Lkotlin/jvm/functions/Function1;", "setDefaultVersions", "(Lkotlin/jvm/functions/Function1;)V", "features", "Lcom/iqoption/core/manager/Toggles$Key;", "identity", "getIdentity", "isDebugMode", "", "()Z", "isIgnored", "setIgnored", "keyPool", "Landroid/support/v4/util/Pools$SynchronizedPool;", "prefs", "Lcom/iqoption/core/data/prefs/Prefs;", "trackUpdates", "Lio/reactivex/disposables/Disposable;", "updateFeaturesListFunc", "Lio/reactivex/functions/Function;", "Lcom/iqoption/core/microservices/features/response/FeaturesResponse;", "Lio/reactivex/CompletableSource;", "updateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "clearOnLogout", "", "getCachedStatus", "featureName", "defStatus", "getFeature", "name", "version", "getStatus", "getVersion", "defVersion", "isEnabled", "defValue", "loadFromHttp", "Lio/reactivex/Completable;", "loadFromSocket", "save", "startTrackUpdates", "stopTrackUpdates", "updateCachedStatuses", "updateFeature", "feature", "updateFeatures", "Key", "core_release"})
/* compiled from: Toggles.kt */
public final class f implements com.iqoption.core.f.a.a {
    private static final com.iqoption.core.data.d.b aOy = com.iqoption.core.data.d.b.aOA.gm("features_manager_pref_name");
    private static Map<String, String> aSA = ad.emptyMap();
    private static final ReentrantReadWriteLock aSB = new ReentrantReadWriteLock();
    private static final io.reactivex.c.f<com.iqoption.core.microservices.features.a.b, io.reactivex.c> aSC = c.aSI;
    private static io.reactivex.disposables.b aSD = null;
    public static final f aSE;
    private static volatile kotlin.jvm.a.b<? super String, Integer> aSu = null;
    private static volatile m<? super String, ? super Integer, com.iqoption.core.microservices.features.a.a> aSv = null;
    private static volatile kotlin.jvm.a.b<? super String, Boolean> aSw = null;
    private static volatile List<String> aSx = null;
    private static final SynchronizedPool<a> aSy = new SynchronizedPool(10);
    private static Map<a, com.iqoption.core.microservices.features.a.a> aSz = ad.emptyMap();
    private static volatile String category = "android-app";
    private static final String identity = d.aOE.getIdentity();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, aXE = {"Lcom/iqoption/core/manager/Toggles$Key;", "Lcom/iqoption/core/util/Recyclable;", "n", "", "v", "", "(Ljava/lang/String;I)V", "<set-?>", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "version", "getVersion", "()I", "setVersion", "(I)V", "copy", "equals", "", "other", "", "hashCode", "recycle", "", "toString", "Companion", "core_release"})
    /* compiled from: Toggles.kt */
    private static final class a implements o {
        public static final a aSG = new a();
        private String name;
        private int version;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/core/manager/Toggles$Key$Companion;", "", "()V", "obtain", "Lcom/iqoption/core/manager/Toggles$Key;", "name", "", "version", "", "core_release"})
        /* compiled from: Toggles.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final a F(String str, int i) {
                h.e(str, "name");
                a aVar = (a) f.aSy.acquire();
                if (aVar != null) {
                    aVar.name = str;
                    aVar.version = i;
                    if (aVar != null) {
                        return aVar;
                    }
                }
                return new a(str, i);
            }
        }

        public a(String str, int i) {
            h.e(str, "n");
            this.name = str;
            this.version = i;
        }

        public void recycle() {
            f.aSy.release(this);
        }

        public final a Ul() {
            return new a(this.name, this.version);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
                return false;
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.manager.Toggles.Key");
            }
            a aVar = (a) obj;
            if ((h.E(this.name, aVar.name) ^ 1) == 0 && this.version == aVar.version) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.version;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key(name='");
            stringBuilder.append(this.name);
            stringBuilder.append("', version=");
            stringBuilder.append(this.version);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/features/response/Feature;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: Toggles.kt */
    static final class b<T> implements e<com.iqoption.core.microservices.features.a.a> {
        public static final b aSH = new b();

        b() {
        }

        /* renamed from: b */
        public final void accept(com.iqoption.core.microservices.features.a.a aVar) {
            if (!f.aSE.RP()) {
                ReentrantReadWriteLock b = f.aSB;
                ReadLock readLock = b.readLock();
                int i = 0;
                int readHoldCount = b.getWriteHoldCount() == 0 ? b.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                WriteLock writeLock = b.writeLock();
                writeLock.lock();
                try {
                    f fVar = f.aSE;
                    f fVar2 = f.aSE;
                    h.d(aVar, "it");
                    f.aSz = fVar2.a(aVar);
                    f.aSE.Uk();
                    l lVar = l.etX;
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                } catch (Throwable th) {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/core/microservices/features/response/FeaturesResponse;", "apply"})
    /* compiled from: Toggles.kt */
    static final class c<T, R> implements io.reactivex.c.f<com.iqoption.core.microservices.features.a.b, io.reactivex.c> {
        public static final c aSI = new c();

        c() {
        }

        /* renamed from: a */
        public final io.reactivex.a apply(com.iqoption.core.microservices.features.a.b bVar) {
            h.e(bVar, "it");
            d.aOE.setIdentity(bVar.getIdentity());
            com.iqoption.core.connect.http.b.aNM.So();
            if (!((bVar.getFeatures().isEmpty() ^ 1) == 0 || f.aSE.RP())) {
                ReentrantReadWriteLock b = f.aSB;
                ReadLock readLock = b.readLock();
                int i = 0;
                int readHoldCount = b.getWriteHoldCount() == 0 ? b.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                WriteLock writeLock = b.writeLock();
                writeLock.lock();
                try {
                    f.aSz = f.aSE.ak(bVar.getFeatures());
                    f.aSE.Uk();
                    l lVar = l.etX;
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                } catch (Throwable th) {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            return io.reactivex.a.aVR();
        }
    }

    static {
        f fVar = new f();
        aSE = fVar;
        a.a(fVar);
        d.aSr.Ug().c(com.iqoption.core.h.i.Yo()).d(com.iqoption.core.h.i.Yo()).c((e) AnonymousClass1.aSF);
    }

    private f() {
    }

    public final String getIdentity() {
        return identity;
    }

    private final void Ui() {
        io.reactivex.disposables.b bVar = aSD;
        if (bVar == null || bVar.isDisposed()) {
            aSD = com.iqoption.core.microservices.features.a.aVJ.VL().c(com.iqoption.core.h.i.Yo()).d(com.iqoption.core.h.i.Yo()).c((e) b.aSH);
        }
    }

    private final void Uj() {
        io.reactivex.disposables.b bVar = aSD;
        Object obj = (bVar == null || bVar.isDisposed()) ? 1 : null;
        if (obj == null) {
        }
    }

    public final boolean RP() {
        return com.iqoption.core.f.Dp().DJ() && com.iqoption.core.e.aMr.RP();
    }

    public void Js() {
        aSz = ad.emptyMap();
        aOy.clear();
    }

    private final void Uk() {
        Map linkedHashMap;
        List list = aSx;
        if (list != null) {
            Iterable<String> iterable = list;
            linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
            for (String str : iterable) {
                Pair D = j.D(str, a(aSE, str, null, 2, null));
                linkedHashMap.put(D.getFirst(), D.aXF());
            }
        } else {
            linkedHashMap = ad.emptyMap();
        }
        aSA = linkedHashMap;
    }

    private final Map<a, com.iqoption.core.microservices.features.a.a> a(com.iqoption.core.microservices.features.a.a aVar) {
        o F = a.aSG.F(aVar.getName(), aVar.getVersion());
        Object obj = (a) F;
        Map<a, com.iqoption.core.microservices.features.a.a> L = ad.L(aSz);
        if (!aSz.containsKey(obj)) {
            obj = obj.Ul();
        }
        L.put(obj, aVar);
        F.recycle();
        return L;
    }

    private final Map<a, com.iqoption.core.microservices.features.a.a> ak(List<com.iqoption.core.microservices.features.a.a> list) {
        Iterable<com.iqoption.core.microservices.features.a.a> iterable = list;
        Map<a, com.iqoption.core.microservices.features.a.a> linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
        for (com.iqoption.core.microservices.features.a.a aVar : iterable) {
            Pair D = j.D(new a(aVar.getName(), aVar.getVersion()), aVar);
            linkedHashMap.put(D.getFirst(), D.aXF());
        }
        return linkedHashMap;
    }

    private final com.iqoption.core.microservices.features.a.a D(String str, int i) {
        ReadLock readLock = aSB.readLock();
        readLock.lock();
        try {
            com.iqoption.core.microservices.features.a.a aVar = null;
            m mVar;
            if (aSz.isEmpty()) {
                mVar = aSv;
                if (mVar != null) {
                    aVar = (com.iqoption.core.microservices.features.a.a) mVar.B(str, Integer.valueOf(i));
                }
                readLock.unlock();
                return aVar;
            }
            a F = a.aSG.F(str, i);
            com.iqoption.core.microservices.features.a.a aVar2 = (com.iqoption.core.microservices.features.a.a) aSz.get(F);
            F.recycle();
            if (aVar2 != null) {
                aVar = aVar2;
            } else {
                mVar = aSv;
                if (mVar != null) {
                    aVar = (com.iqoption.core.microservices.features.a.a) mVar.B(str, Integer.valueOf(i));
                }
            }
            readLock.unlock();
            return aVar;
        } catch (Throwable th) {
            readLock.unlock();
        }
    }

    public final com.iqoption.core.microservices.features.a.a gv(String str) {
        h.e(str, "name");
        kotlin.jvm.a.b bVar = aSw;
        if (bVar == null || !((Boolean) bVar.invoke(str)).booleanValue()) {
            return D(str, a(this, str, 0, 2, null));
        }
        return null;
    }

    public final boolean o(String str, boolean z) {
        h.e(str, "featureName");
        com.iqoption.core.microservices.features.a.a gv = gv(str);
        return gv != null ? gv.isEnabled() : z;
    }

    public final String ac(String str, String str2) {
        h.e(str, "featureName");
        h.e(str2, "defStatus");
        com.iqoption.core.microservices.features.a.a gv = gv(str);
        if (gv != null) {
            str = gv.getStatus();
            if (str != null) {
                return str;
            }
        }
        return str2;
    }

    private final int E(String str, int i) {
        kotlin.jvm.a.b bVar = aSu;
        if (bVar == null) {
            return i;
        }
        Integer num = (Integer) bVar.invoke(str);
        return num != null ? num.intValue() : i;
    }
}
