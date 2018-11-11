package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.c;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

/* compiled from: specialBuiltinMembers.kt */
public final class q {
    private static final b b(b bVar, String str) {
        bVar = bVar.C(f.mD(str));
        h.d(bVar, "child(Name.identifier(name))");
        return bVar;
    }

    private static final b b(c cVar, String str) {
        b btP = cVar.F(f.mD(str)).btP();
        h.d(btP, "child(Name.identifier(name)).toSafe()");
        return btP;
    }

    private static final o d(String str, String str2, String str3, String str4) {
        f mD = f.mD(str2);
        h.d(mD, "Name.identifier(name)");
        u uVar = u.eJX;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('(');
        stringBuilder.append(str3);
        stringBuilder.append(')');
        stringBuilder.append(str4);
        return new o(mD, uVar.be(str, stringBuilder.toString()));
    }

    public static final <T extends CallableMemberDescriptor> T q(T t) {
        h.e(t, "$receiver");
        T t2 = null;
        if (!b.eEK.bfA().contains(t.bdc()) && !c.eEZ.bfB().contains(a.H(t).bdc())) {
            return null;
        }
        if ((t instanceof ad) || (t instanceof ac)) {
            t2 = a.a(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.eFK, 1, null);
        } else if (t instanceof ah) {
            t2 = a.a(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.eFL, 1, null);
        }
        return t2;
    }

    public static final boolean r(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        return q(callableMemberDescriptor) != null;
    }

    public static final <T extends CallableMemberDescriptor> T s(T t) {
        h.e(t, "$receiver");
        T q = q(t);
        if (q != null) {
            return q;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.eES;
        f bdc = t.bdc();
        h.d(bdc, "name");
        if (builtinMethodsWithSpecialGenericSignature.m(bdc)) {
            return a.a(t, false, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.eFM, 1, null);
        }
        return null;
    }

    public static final String t(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "callableMemberDescriptor");
        callableMemberDescriptor = u(callableMemberDescriptor);
        String str = null;
        if (callableMemberDescriptor != null) {
            callableMemberDescriptor = a.H(callableMemberDescriptor);
            if (callableMemberDescriptor != null) {
                if (callableMemberDescriptor instanceof ad) {
                    str = c.eEZ.o(callableMemberDescriptor);
                } else if (callableMemberDescriptor instanceof ah) {
                    f a = b.eEK.a((ah) callableMemberDescriptor);
                    if (a != null) {
                        str = a.asString();
                    }
                }
                return str;
            }
        }
        return null;
    }

    private static final CallableMemberDescriptor u(CallableMemberDescriptor callableMemberDescriptor) {
        return g.b((k) callableMemberDescriptor) ? q(callableMemberDescriptor) : null;
    }

    public static final boolean a(d dVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        h.e(dVar, "$receiver");
        h.e(aVar, "specialCallableDescriptor");
        k bbv = aVar.bbv();
        if (bbv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        kotlin.reflect.jvm.internal.impl.types.ad bdb = ((d) bbv).bdb();
        dVar = kotlin.reflect.jvm.internal.impl.resolve.c.I(dVar);
        while (true) {
            boolean z = false;
            if (dVar == null) {
                return false;
            }
            if (!(dVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.d)) {
                if (TypeCheckingProcedure.f(dVar.bdb(), bdb) != null) {
                    z = true;
                }
                if (z) {
                    return g.b((k) dVar) ^ true;
                }
            }
            dVar = kotlin.reflect.jvm.internal.impl.resolve.c.I(dVar);
        }
    }

    public static final boolean v(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        return a.H(callableMemberDescriptor).bbv() instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.d;
    }

    public static final boolean w(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        return v(callableMemberDescriptor) || g.b((k) callableMemberDescriptor);
    }
}
