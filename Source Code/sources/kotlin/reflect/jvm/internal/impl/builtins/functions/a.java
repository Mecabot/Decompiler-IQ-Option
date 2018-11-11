package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
public final class a implements kotlin.reflect.jvm.internal.impl.descriptors.a.b {
    public static final a ezH = new a();
    private final h exB;
    private final u ezG;

    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final b a(String str, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            Kind a = Kind.Companion.a(bVar, str);
            if (a == null) {
                return null;
            }
            a aVar = this;
            int length = a.getClassNamePrefix().length();
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(length);
            kotlin.jvm.internal.h.d(str, "(this as java.lang.String).substring(startIndex)");
            Integer mj = aVar.mj(str);
            if (mj != null) {
                return new b(a, mj.intValue());
            }
            return null;
        }

        public final Kind b(String str, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            kotlin.jvm.internal.h.e(str, "className");
            kotlin.jvm.internal.h.e(bVar, "packageFqName");
            b a = a(str, bVar);
            return a != null ? a.bbr() : null;
        }

        private final Integer mj(String str) {
            if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
                return null;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int charAt = str.charAt(i2) - 48;
                if (charAt < 0 || 9 < charAt) {
                    return null;
                }
                i = (i * 10) + charAt;
            }
            return Integer.valueOf(i);
        }
    }

    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    private static final class b {
        private final int arity;
        private final Kind ezI;

        public final Kind bbs() {
            return this.ezI;
        }

        public final int bbt() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (kotlin.jvm.internal.h.E(this.ezI, bVar.ezI)) {
                    if ((this.arity == bVar.arity ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            Kind kind = this.ezI;
            return ((kind != null ? kind.hashCode() : 0) * 31) + this.arity;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("KindWithArity(kind=");
            stringBuilder.append(this.ezI);
            stringBuilder.append(", arity=");
            stringBuilder.append(this.arity);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(Kind kind, int i) {
            kotlin.jvm.internal.h.e(kind, "kind");
            this.ezI = kind;
            this.arity = i;
        }

        public final Kind bbr() {
            return this.ezI;
        }
    }

    public a(h hVar, u uVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(uVar, "module");
        this.exB = hVar;
        this.ezG = uVar;
    }

    public boolean a(kotlin.reflect.jvm.internal.impl.name.b bVar, f fVar) {
        kotlin.jvm.internal.h.e(bVar, "packageFqName");
        kotlin.jvm.internal.h.e(fVar, "name");
        String asString = fVar.asString();
        kotlin.jvm.internal.h.d(asString, "string");
        if ((u.a(asString, "Function", false, 2, null) || u.a(asString, "KFunction", false, 2, null) || u.a(asString, "SuspendFunction", false, 2, null) || u.a(asString, "KSuspendFunction", false, 2, null)) && ezH.a(asString, bVar) != null) {
            return true;
        }
        return false;
    }

    public d e(kotlin.reflect.jvm.internal.impl.name.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "classId");
        if (aVar.isLocal() || aVar.btJ()) {
            return null;
        }
        String asString = aVar.btG().asString();
        kotlin.jvm.internal.h.d(asString, "className");
        if (!v.b((CharSequence) asString, (CharSequence) "Function", false, 2, null)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.b packageFqName = aVar.getPackageFqName();
        a aVar2 = ezH;
        kotlin.jvm.internal.h.d(packageFqName, "packageFqName");
        b a = aVar2.a(asString, packageFqName);
        if (a == null) {
            return null;
        }
        Kind bbs = a.bbs();
        int bbt = a.bbt();
        Collection arrayList = new ArrayList();
        for (Object next : this.ezG.g(packageFqName).getFragments()) {
            if (next instanceof c) {
                arrayList.add(next);
            }
        }
        return new FunctionClassDescriptor(this.exB, (c) u.bU((List) arrayList), bbs, bbt);
    }

    public Collection<d> e(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.jvm.internal.h.e(bVar, "packageFqName");
        return aj.emptySet();
    }
}
