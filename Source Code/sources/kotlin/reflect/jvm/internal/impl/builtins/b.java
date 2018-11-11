package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.LazyThreadSafetyMode;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.a.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: BuiltInsLoader.kt */
public interface b {
    public static final a exf = a.exh;

    /* compiled from: BuiltInsLoader.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "Instance", "getInstance()Lorg/jetbrains/kotlin/builtins/BuiltInsLoader;"))};
        private static final d exg = g.a(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$Instance$2.exi);
        static final /* synthetic */ a exh = new a();

        public final b bay() {
            d dVar = exg;
            j jVar = apP[0];
            return (b) dVar.getValue();
        }

        private a() {
        }
    }

    y a(h hVar, u uVar, Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.a.b> iterable, c cVar, kotlin.reflect.jvm.internal.impl.descriptors.a.a aVar);
}
