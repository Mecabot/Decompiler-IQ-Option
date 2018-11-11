package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;

public final /* synthetic */ class t {
    public static final /* synthetic */ int[] aoS = new int[MemberKind.values().length];
    public static final /* synthetic */ int[] auV = new int[Modality.values().length];
    public static final /* synthetic */ int[] auW = new int[kotlin.reflect.jvm.internal.impl.descriptors.Modality.values().length];
    public static final /* synthetic */ int[] auk = new int[Kind.values().length];
    public static final /* synthetic */ int[] cCT = new int[Visibility.values().length];
    public static final /* synthetic */ int[] eTl = new int[Class.Kind.values().length];
    public static final /* synthetic */ int[] eTm = new int[ClassKind.values().length];
    public static final /* synthetic */ int[] eTn = new int[Variance.values().length];
    public static final /* synthetic */ int[] eTo = new int[Projection.values().length];

    static {
        aoS[MemberKind.DECLARATION.ordinal()] = 1;
        aoS[MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
        aoS[MemberKind.DELEGATION.ordinal()] = 3;
        aoS[MemberKind.SYNTHESIZED.ordinal()] = 4;
        auk[Kind.DECLARATION.ordinal()] = 1;
        auk[Kind.FAKE_OVERRIDE.ordinal()] = 2;
        auk[Kind.DELEGATION.ordinal()] = 3;
        auk[Kind.SYNTHESIZED.ordinal()] = 4;
        auV[Modality.FINAL.ordinal()] = 1;
        auV[Modality.OPEN.ordinal()] = 2;
        auV[Modality.ABSTRACT.ordinal()] = 3;
        auV[Modality.SEALED.ordinal()] = 4;
        auW[kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL.ordinal()] = 1;
        auW[kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN.ordinal()] = 2;
        auW[kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT.ordinal()] = 3;
        auW[kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED.ordinal()] = 4;
        cCT[Visibility.INTERNAL.ordinal()] = 1;
        cCT[Visibility.PRIVATE.ordinal()] = 2;
        cCT[Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
        cCT[Visibility.PROTECTED.ordinal()] = 4;
        cCT[Visibility.PUBLIC.ordinal()] = 5;
        cCT[Visibility.LOCAL.ordinal()] = 6;
        eTl[Class.Kind.CLASS.ordinal()] = 1;
        eTl[Class.Kind.INTERFACE.ordinal()] = 2;
        eTl[Class.Kind.ENUM_CLASS.ordinal()] = 3;
        eTl[Class.Kind.ENUM_ENTRY.ordinal()] = 4;
        eTl[Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
        eTl[Class.Kind.OBJECT.ordinal()] = 6;
        eTl[Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
        eTm[ClassKind.CLASS.ordinal()] = 1;
        eTm[ClassKind.INTERFACE.ordinal()] = 2;
        eTm[ClassKind.ENUM_CLASS.ordinal()] = 3;
        eTm[ClassKind.ENUM_ENTRY.ordinal()] = 4;
        eTm[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
        eTm[ClassKind.OBJECT.ordinal()] = 6;
        eTn[Variance.IN.ordinal()] = 1;
        eTn[Variance.OUT.ordinal()] = 2;
        eTn[Variance.INV.ordinal()] = 3;
        eTo[Projection.IN.ordinal()] = 1;
        eTo[Projection.OUT.ordinal()] = 2;
        eTo[Projection.INV.ordinal()] = 3;
        eTo[Projection.STAR.ordinal()] = 4;
    }
}
