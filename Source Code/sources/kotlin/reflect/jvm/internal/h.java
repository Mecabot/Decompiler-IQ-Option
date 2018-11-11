package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.i;
import kotlin.reflect.jvm.internal.pcollections.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
/* compiled from: kClassCache.kt */
public final class h {
    private static b<String, Object> evt = b.bzK();

    public static final <T> i<T> H(Class<T> cls) {
        i<T> iVar;
        kotlin.jvm.internal.h.e(cls, "jClass");
        String name = cls.getName();
        Object obj = evt.get(name);
        Object obj2 = null;
        if (obj instanceof WeakReference) {
            iVar = (i) ((WeakReference) obj).get();
            if (iVar != null) {
                obj2 = iVar.aXV();
            }
            if (kotlin.jvm.internal.h.E(obj2, cls)) {
                return iVar;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                i<T> iVar2 = (i) weakReference.get();
                if (kotlin.jvm.internal.h.E(iVar2 != null ? iVar2.aXV() : null, cls)) {
                    return iVar2;
                }
            }
            int length = ((Object[]) obj).length;
            obj2 = new WeakReference[(length + 1)];
            System.arraycopy(obj, 0, obj2, 0, length);
            iVar = new i(cls);
            obj2[length] = new WeakReference(iVar);
            evt = evt.I(name, obj2);
            return iVar;
        }
        iVar = new i(cls);
        evt = evt.I(name, new WeakReference(iVar));
        return iVar;
    }
}
