package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.e;

/* compiled from: JavaVisibilities */
public class k {
    public static final av eFf = new av("package", false) {
        public String getDisplayName() {
            return "public/*package*/";
        }

        public boolean b(e eVar, o oVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            return k.b(oVar, kVar);
        }

        protected Integer c(av avVar) {
            if (this == avVar) {
                return Integer.valueOf(0);
            }
            if (au.b(avVar)) {
                return Integer.valueOf(1);
            }
            return Integer.valueOf(-1);
        }

        public av bec() {
            return au.eBe;
        }
    };
    public static final av eFg = new av("protected_static", true) {
        public String getDisplayName() {
            return "protected/*protected static*/";
        }

        public boolean b(e eVar, o oVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            return k.c(eVar, oVar, kVar);
        }

        public av bec() {
            return au.eBe;
        }
    };
    public static final av eFh = new av("protected_and_package", true) {
        public String getDisplayName() {
            return "protected/*protected and package*/";
        }

        public boolean b(e eVar, o oVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            return k.c(eVar, oVar, kVar);
        }

        protected Integer c(av avVar) {
            if (this == avVar) {
                return Integer.valueOf(0);
            }
            if (avVar == au.eBf) {
                return null;
            }
            if (au.b(avVar)) {
                return Integer.valueOf(1);
            }
            return Integer.valueOf(-1);
        }

        public av bec() {
            return au.eBe;
        }
    };

    private static boolean c(e eVar, o oVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (b(c.a(oVar), kVar)) {
            return true;
        }
        return au.eBe.b(eVar, oVar, kVar);
    }

    private static boolean b(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        x xVar = (x) c.a(kVar, x.class, false);
        x xVar2 = (x) c.a(kVar2, x.class, false);
        if (xVar2 == null || xVar == null || !xVar.bdD().equals(xVar2.bdD())) {
            return false;
        }
        return true;
    }
}
