package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: ProtoEnumFlags.kt */
public final class s {
    public static final s eTk = new s();

    private s() {
    }

    public final Kind a(MemberKind memberKind) {
        if (memberKind != null) {
            switch (t.aoS[memberKind.ordinal()]) {
                case 1:
                    return Kind.DECLARATION;
                case 2:
                    return Kind.FAKE_OVERRIDE;
                case 3:
                    return Kind.DELEGATION;
                case 4:
                    return Kind.SYNTHESIZED;
            }
        }
        return Kind.DECLARATION;
    }

    public final Modality a(ProtoBuf.Modality modality) {
        if (modality != null) {
            switch (t.auV[modality.ordinal()]) {
                case 1:
                    return Modality.FINAL;
                case 2:
                    return Modality.OPEN;
                case 3:
                    return Modality.ABSTRACT;
                case 4:
                    return Modality.SEALED;
            }
        }
        return Modality.FINAL;
    }

    public final av a(Visibility visibility) {
        if (visibility != null) {
            switch (t.cCT[visibility.ordinal()]) {
                case 1:
                    return au.eBf;
                case 2:
                    return au.eBc;
                case 3:
                    return au.eBd;
                case 4:
                    return au.eBe;
                case 5:
                    return au.eBg;
                case 6:
                    return au.eBh;
            }
        }
        return au.eBc;
    }

    public final ClassKind a(Class.Kind kind) {
        if (kind != null) {
            switch (t.eTl[kind.ordinal()]) {
                case 1:
                    return ClassKind.CLASS;
                case 2:
                    return ClassKind.INTERFACE;
                case 3:
                    return ClassKind.ENUM_CLASS;
                case 4:
                    return ClassKind.ENUM_ENTRY;
                case 5:
                    return ClassKind.ANNOTATION_CLASS;
                case 6:
                case 7:
                    return ClassKind.OBJECT;
            }
        }
        return ClassKind.CLASS;
    }

    public final Variance b(TypeParameter.Variance variance) {
        h.e(variance, "variance");
        switch (t.eTn[variance.ordinal()]) {
            case 1:
                return Variance.IN_VARIANCE;
            case 2:
                return Variance.OUT_VARIANCE;
            case 3:
                return Variance.INVARIANT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Variance b(Projection projection) {
        h.e(projection, "projection");
        switch (t.eTo[projection.ordinal()]) {
            case 1:
                return Variance.IN_VARIANCE;
            case 2:
                return Variance.OUT_VARIANCE;
            case 3:
                return Variance.INVARIANT;
            case 4:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Only IN, OUT and INV are supported. Actual argument: ");
                stringBuilder.append(projection);
                throw new IllegalArgumentException(stringBuilder.toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
