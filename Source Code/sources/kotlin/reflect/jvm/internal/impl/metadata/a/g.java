package kotlin.reflect.jvm.internal.impl.metadata.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;

/* compiled from: protoTypeTableUtil.kt */
public final class g {
    public static final List<Type> a(Class classR, h hVar) {
        h.e(classR, "$receiver");
        h.e(hVar, "typeTable");
        List<Type> bkp = classR.bkp();
        if ((bkp.isEmpty() ^ 1) == 0) {
            bkp = null;
        }
        if (bkp != null) {
            return bkp;
        }
        List bkr = classR.bkr();
        h.d(bkr, "supertypeIdList");
        Iterable<Integer> iterable = bkr;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Integer num : iterable) {
            h.d(num, "it");
            arrayList.add(hVar.lh(num.intValue()));
        }
        return (List) arrayList;
    }

    public static final Type a(Argument argument, h hVar) {
        h.e(argument, "$receiver");
        h.e(hVar, "typeTable");
        if (argument.hasType()) {
            return argument.boR();
        }
        return argument.boS() ? hVar.lh(argument.getTypeId()) : null;
    }

    public static final Type a(Type type, h hVar) {
        h.e(type, "$receiver");
        h.e(hVar, "typeTable");
        if (type.boq()) {
            return type.bor();
        }
        return type.bos() ? hVar.lh(type.bot()) : null;
    }

    public static final List<Type> a(TypeParameter typeParameter, h hVar) {
        h.e(typeParameter, "$receiver");
        h.e(hVar, "typeTable");
        List<Type> bpH = typeParameter.bpH();
        if ((bpH.isEmpty() ^ 1) == 0) {
            bpH = null;
        }
        if (bpH != null) {
            return bpH;
        }
        List bpJ = typeParameter.bpJ();
        h.d(bpJ, "upperBoundIdList");
        Iterable<Integer> iterable = bpJ;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Integer num : iterable) {
            h.d(num, "it");
            arrayList.add(hVar.lh(num.intValue()));
        }
        return (List) arrayList;
    }

    public static final Type a(Function function, h hVar) {
        h.e(function, "$receiver");
        h.e(hVar, "typeTable");
        if (function.bmF()) {
            Type bmG = function.bmG();
            h.d(bmG, "returnType");
            return bmG;
        } else if (function.bmH()) {
            return hVar.lh(function.bmI());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    public static final boolean g(Function function) {
        h.e(function, "$receiver");
        return function.bmJ() || function.bmL();
    }

    public static final Type b(Function function, h hVar) {
        h.e(function, "$receiver");
        h.e(hVar, "typeTable");
        if (function.bmJ()) {
            return function.bmK();
        }
        return function.bmL() ? hVar.lh(function.bmM()) : null;
    }

    public static final Type a(Property property, h hVar) {
        h.e(property, "$receiver");
        h.e(hVar, "typeTable");
        if (property.bmF()) {
            Type bmG = property.bmG();
            h.d(bmG, "returnType");
            return bmG;
        } else if (property.bmH()) {
            return hVar.lh(property.bmI());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    public static final boolean f(Property property) {
        h.e(property, "$receiver");
        return property.bmJ() || property.bmL();
    }

    public static final Type b(Property property, h hVar) {
        h.e(property, "$receiver");
        h.e(hVar, "typeTable");
        if (property.bmJ()) {
            return property.bmK();
        }
        return property.bmL() ? hVar.lh(property.bmM()) : null;
    }

    public static final Type a(ValueParameter valueParameter, h hVar) {
        h.e(valueParameter, "$receiver");
        h.e(hVar, "typeTable");
        if (valueParameter.hasType()) {
            Type boR = valueParameter.boR();
            h.d(boR, Param.TYPE);
            return boR;
        } else if (valueParameter.boS()) {
            return hVar.lh(valueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    public static final Type b(ValueParameter valueParameter, h hVar) {
        h.e(valueParameter, "$receiver");
        h.e(hVar, "typeTable");
        if (valueParameter.bql()) {
            return valueParameter.bqm();
        }
        return valueParameter.bqn() ? hVar.lh(valueParameter.bqo()) : null;
    }

    public static final Type b(Type type, h hVar) {
        h.e(type, "$receiver");
        h.e(hVar, "typeTable");
        if (type.boC()) {
            return type.boD();
        }
        return type.boE() ? hVar.lh(type.boF()) : null;
    }

    public static final Type c(Type type, h hVar) {
        h.e(type, "$receiver");
        h.e(hVar, "typeTable");
        if (type.boG()) {
            return type.boH();
        }
        return type.boI() ? hVar.lh(type.boJ()) : null;
    }

    public static final Type a(TypeAlias typeAlias, h hVar) {
        h.e(typeAlias, "$receiver");
        h.e(hVar, "typeTable");
        if (typeAlias.bpi()) {
            Type bpj = typeAlias.bpj();
            h.d(bpj, "underlyingType");
            return bpj;
        } else if (typeAlias.bpk()) {
            return hVar.lh(typeAlias.bpl());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    public static final Type b(TypeAlias typeAlias, h hVar) {
        h.e(typeAlias, "$receiver");
        h.e(hVar, "typeTable");
        if (typeAlias.bpm()) {
            Type bpn = typeAlias.bpn();
            h.d(bpn, "expandedType");
            return bpn;
        } else if (typeAlias.bpo()) {
            return hVar.lh(typeAlias.bpp());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }
}
