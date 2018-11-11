package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.components.j;
import kotlin.reflect.jvm.internal.structure.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflect-api"})
/* compiled from: moduleByClassLoader.kt */
public final class x {
    private static final ConcurrentMap<ag, WeakReference<j>> ewx = new ConcurrentHashMap();

    public static final j J(Class<?> cls) {
        j jVar;
        h.e(cls, "$receiver");
        ClassLoader O = b.O(cls);
        ag agVar = new ag(O);
        WeakReference weakReference = (WeakReference) ewx.get(agVar);
        if (weakReference != null) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 != null) {
                h.d(jVar2, "it");
                return jVar2;
            }
            ewx.remove(agVar, weakReference);
        }
        j b = j.ewT.b(O);
        while (true) {
            try {
                WeakReference weakReference2 = (WeakReference) ewx.putIfAbsent(agVar, new WeakReference(b));
                if (weakReference2 != null) {
                    jVar = (j) weakReference2.get();
                    if (jVar != null) {
                        break;
                    }
                    jVar = ewx;
                    jVar.remove(agVar, weakReference2);
                } else {
                    agVar.a((ClassLoader) null);
                    return b;
                }
            } finally {
                agVar.a((ClassLoader) null);
            }
        }
        return jVar;
    }
}
