package com.iqoption.core.g;

import com.iqoption.core.f;
import com.squareup.picasso.Picasso;
import io.reactivex.c.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0019H\u0002J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/core/resources/ResourceManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "resolution", "resourceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "resourcesStorage", "Lcom/iqoption/core/resources/ResourcesStorage;", "getResUrlSync", "resourceId", "getResourceUrl", "resource", "Lcom/iqoption/core/microservices/resources/responses/ResourceElement;", "prefetchResources", "Lio/reactivex/Completable;", "processInitResources", "", "resourceList", "", "restorePersistent", "", "schedulePreFetch", "url", "reFetch", "", "core_release"})
/* compiled from: ResourceManager.kt */
public final class b {
    private static final CountDownLatch DX = new CountDownLatch(1);
    private static final String TAG = "b";
    private static final String aXn = com.iqoption.core.microservices.d.a.aXm.WA();
    private static final ConcurrentHashMap<String, String> aZZ = new ConcurrentHashMap();
    private static final c baa = new c();
    public static final b bab = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/core/microservices/resources/responses/ResourceElement;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ResourceManager.kt */
    static final class a<T> implements e<List<? extends com.iqoption.core.microservices.d.a.b>> {
        public static final a bac = new a();

        a() {
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.core.microservices.d.a.b> list) {
            b bVar = b.bab;
            h.d(list, "it");
            bVar.an(list);
            b.DX.countDown();
        }
    }

    private b() {
    }

    public final io.reactivex.a Ya() {
        io.reactivex.a aWi = com.iqoption.core.microservices.d.a.a(com.iqoption.core.microservices.d.a.aXm, null, null, 3, null).d(a.bac).aWi();
        h.d(aWi, "ResourceRequests.getReso…        }.toCompletable()");
        return aWi;
    }

    public final String gR(String str) {
        h.e(str, "resourceId");
        try {
            DX.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        String str2 = (String) aZZ.get(str);
        if (str2 != null) {
            return str2;
        }
        List list;
        List list2 = (List) null;
        try {
            list = (List) com.iqoption.core.microservices.d.a.aXm.ad(str, aXn).aWf();
        } catch (Throwable th) {
            com.iqoption.core.i.e(b.class.getSimpleName(), th.getMessage());
            list = list2;
        }
        if (list == null) {
            return null;
        }
        for (Object next : list) {
            if (h.E(((com.iqoption.core.microservices.d.a.b) next).getId(), str)) {
                break;
            }
        }
        Object next2 = null;
        com.iqoption.core.microservices.d.a.b bVar = (com.iqoption.core.microservices.d.a.b) next2;
        if (bVar == null) {
            return null;
        }
        str2 = a(bVar);
        if (str2 != null) {
            aZZ.put(str, str2);
        }
        return a(bVar);
    }

    private final void an(List<com.iqoption.core.microservices.d.a.b> list) {
        Map Yb = Yb();
        for (com.iqoption.core.microservices.d.a.b bVar : list) {
            String a = bab.a(bVar);
            if (a != null) {
                com.iqoption.core.microservices.d.a.b bVar2 = (com.iqoption.core.microservices.d.a.b) Yb.get(bVar.getId());
                boolean z = false;
                if (bVar2 != null && bVar2.WD() < bVar.WD()) {
                    z = true;
                }
                aZZ.put(bVar.getId(), a);
                bab.a(bVar, a, z);
            }
        }
        try {
            baa.ao(list);
        } catch (Throwable th) {
            com.iqoption.core.i.e(TAG, th.toString());
        }
    }

    private final Map<String, com.iqoption.core.microservices.d.a.b> Yb() {
        Map<String, com.iqoption.core.microservices.d.a.b> linkedHashMap = new LinkedHashMap();
        try {
            for (com.iqoption.core.microservices.d.a.b bVar : baa.Yc()) {
                String a = bab.a(bVar);
                if (a != null) {
                    aZZ.put(bVar.getId(), a);
                }
                linkedHashMap.put(bVar.getId(), bVar);
            }
        } catch (Throwable th) {
            com.iqoption.core.i.e(TAG, th.toString());
        }
        return linkedHashMap;
    }

    private final void a(com.iqoption.core.microservices.d.a.b bVar, String str, boolean z) {
        String type = bVar.getType();
        int hashCode = type.hashCode();
        if (hashCode != 3143036) {
            if (hashCode == 100313435 && type.equals("image")) {
                Picasso with = Picasso.with(f.RR());
                h.d(with, "Picasso.with(appContext)");
                com.iqoption.core.util.h.a(with, bVar.getId()).fetch();
            }
        } else if (type.equals("file")) {
            a.aZS.f(bVar.getId(), str, z);
        }
    }

    private final String a(com.iqoption.core.microservices.d.a.b bVar) {
        Object obj;
        String str;
        List WC = bVar.WC();
        Iterator it = WC.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
        } while (!h.E(aXn, ((com.iqoption.core.microservices.d.a.a) obj).WA()));
        com.iqoption.core.microservices.d.a.a aVar = (com.iqoption.core.microservices.d.a.a) obj;
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.d.a.a) u.bV(WC);
        }
        if (aVar == null) {
            return null;
        }
        if (h.E(bVar.getType(), "image")) {
            str = aVar.US();
        } else if (h.E(bVar.getType(), "file")) {
            str = aVar.WB();
        }
        return str;
    }
}
