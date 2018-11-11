package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.b;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001^B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010M\u001a\u00020%2\b\u0010N\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00132\u0006\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\b\u0012\u0004\u0012\u00020T0\u00132\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010X\u001a\u00020VH\u0016J\u0012\u0010Y\u001a\u00020%2\b\u0010Z\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020<H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R3\u0010\u001a\u001a$\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0016\u00108\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010A\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\bB\u00102R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\rR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0016\u0010I\u001a\u0004\u0018\u00010J8VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006_"}, aXE = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflect_api", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflect_api", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflect-api"})
/* compiled from: KClassImpl.kt */
public final class i<T> extends KDeclarationContainerImpl implements b<T> {
    private final Class<T> eus;
    private final y.b<a> evu = y.g(new KClassImpl$data$1(this));

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010K\u001a\u00020<2\n\u0010L\u001a\u0006\u0012\u0002\b\u00030MH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00128FX\u0002¢\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bE\u0010\u0015R!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00128FX\u0002¢\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bI\u0010\u0015¨\u0006N"}, aXE = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
    /* compiled from: KClassImpl.kt */
    public final class a extends KDeclarationContainerImpl.b {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "annotations", "getAnnotations()Ljava/util/List;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final kotlin.reflect.jvm.internal.y.a descriptor$delegate = y.h(new KClassImpl$Data$descriptor$2(this));
        private final y.b evA = y.g(new KClassImpl$Data$objectInstance$2(this));
        private final kotlin.reflect.jvm.internal.y.a evB = y.h(new KClassImpl$Data$typeParameters$2(this));
        private final kotlin.reflect.jvm.internal.y.a evC = y.h(new KClassImpl$Data$supertypes$2(this));
        private final kotlin.reflect.jvm.internal.y.a evD = y.h(new KClassImpl$Data$declaredNonStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evE = y.h(new KClassImpl$Data$declaredStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evF = y.h(new KClassImpl$Data$inheritedNonStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evG = y.h(new KClassImpl$Data$inheritedStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evH = y.h(new KClassImpl$Data$allNonStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evI = y.h(new KClassImpl$Data$allStaticMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evJ = y.h(new KClassImpl$Data$declaredMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evK = y.h(new KClassImpl$Data$allMembers$2(this));
        private final kotlin.reflect.jvm.internal.y.a evv = y.h(new KClassImpl$Data$annotations$2(this));
        private final kotlin.reflect.jvm.internal.y.a evw = y.h(new KClassImpl$Data$simpleName$2(this));
        private final kotlin.reflect.jvm.internal.y.a evx = y.h(new KClassImpl$Data$qualifiedName$2(this));
        private final kotlin.reflect.jvm.internal.y.a evy = y.h(new KClassImpl$Data$constructors$2(this));
        private final kotlin.reflect.jvm.internal.y.a evz = y.h(new KClassImpl$Data$nestedClasses$2(this));

        private final Collection<g<?>> aZc() {
            return (Collection) this.evE.G(this, apP[10]);
        }

        private final Collection<g<?>> aZd() {
            return (Collection) this.evF.G(this, apP[11]);
        }

        private final Collection<g<?>> aZe() {
            return (Collection) this.evG.G(this, apP[12]);
        }

        public final d aYX() {
            return (d) this.descriptor$delegate.G(this, apP[0]);
        }

        public final Collection<g<?>> aZb() {
            return (Collection) this.evD.G(this, apP[9]);
        }

        public final Collection<g<?>> aZf() {
            return (Collection) this.evH.G(this, apP[13]);
        }

        public final Collection<g<?>> aZg() {
            return (Collection) this.evI.G(this, apP[14]);
        }

        public final String getQualifiedName() {
            return (String) this.evx.G(this, apP[3]);
        }

        public a() {
            super();
        }

        private final String I(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                h.d(simpleName, "name");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(enclosingMethod.getName());
                stringBuilder.append("$");
                return v.b(simpleName, stringBuilder.toString(), null, 2, null);
            }
            Constructor enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                h.d(simpleName, "name");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(enclosingConstructor.getName());
                stringBuilder2.append("$");
                return v.b(simpleName, stringBuilder2.toString(), null, 2, null);
            }
            h.d(simpleName, "name");
            return v.b(simpleName, '$', null, 2, null);
        }
    }

    public i(Class<T> cls) {
        h.e(cls, "jClass");
        this.eus = cls;
    }

    public Class<T> aXV() {
        return this.eus;
    }

    public final y.b<a> aYW() {
        return this.evu;
    }

    public d aYX() {
        return ((a) this.evu.invoke()).aYX();
    }

    private final kotlin.reflect.jvm.internal.impl.name.a getClassId() {
        return ac.ewF.K(aXV());
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h aYY() {
        return aYX().bdb().bbk();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h aYZ() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx = aYX().bbx();
        h.d(bbx, "descriptor.staticScope");
        return bbx;
    }

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> aYt() {
        d aYX = aYX();
        if (aYX.bbF() == ClassKind.INTERFACE || aYX.bbF() == ClassKind.OBJECT) {
            return m.emptyList();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> bbE = aYX.bbE();
        h.d(bbE, "descriptor.constructors");
        return bbE;
    }

    public Collection<ad> a(f fVar) {
        h.e(fVar, "name");
        return u.b(aYY().a(fVar, NoLookupLocation.FROM_REFLECTION), (Iterable) aYZ().a(fVar, NoLookupLocation.FROM_REFLECTION));
    }

    public Collection<r> b(f fVar) {
        h.e(fVar, "name");
        return u.b(aYY().b(fVar, NoLookupLocation.FROM_REFLECTION), (Iterable) aYZ().b(fVar, NoLookupLocation.FROM_REFLECTION));
    }

    public ad jo(int i) {
        if (h.E(aXV().getSimpleName(), "DefaultImpls")) {
            Class declaringClass = aXV().getDeclaringClass();
            if (declaringClass != null && declaringClass.isInterface()) {
                b E = kotlin.jvm.a.E(declaringClass);
                if (E != null) {
                    return ((i) E).jo(i);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            }
        }
        d aYX = aYX();
        ad adVar = null;
        if (!(aYX instanceof e)) {
            aYX = null;
        }
        e eVar = (e) aYX;
        if (eVar != null) {
            ExtendableMessage byk = eVar.byk();
            GeneratedMessageLite.e eVar2 = JvmProtoBuf.eMr;
            h.d(eVar2, "JvmProtoBuf.classLocalVariable");
            Property property = (Property) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(byk, eVar2, i);
            if (property != null) {
                adVar = (ad) ae.a(aXV(), property, eVar.bxX().aYI(), eVar.bxX().aYJ(), eVar.byl(), KClassImpl$getLocalProperty$2$1$1.evM);
            }
        }
        return adVar;
    }

    public String getQualifiedName() {
        return ((a) this.evu.invoke()).getQualifiedName();
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.E(kotlin.jvm.a.c(this), kotlin.jvm.a.c((b) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.c(this).hashCode();
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("class ");
        kotlin.reflect.jvm.internal.impl.name.a classId = getClassId();
        kotlin.reflect.jvm.internal.impl.name.b packageFqName = classId.getPackageFqName();
        h.d(packageFqName, "packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(packageFqName.asString());
            stringBuilder.append(".");
            str = stringBuilder.toString();
        }
        String asString = classId.btG().asString();
        h.d(asString, "classId.relativeClassName.asString()");
        String a = u.a(asString, '.', '$', false, 4, null);
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    private final java.lang.Void aZa() {
        /*
        r4 = this;
        r0 = kotlin.reflect.jvm.internal.components.e.ewO;
        r1 = r4.aXV();
        r0 = r0.M(r1);
        if (r0 == 0) goto L_0x0017;
    L_0x000c:
        r0 = r0.bap();
        if (r0 == 0) goto L_0x0017;
    L_0x0012:
        r0 = r0.biM();
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        if (r0 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x002c;
    L_0x001b:
        r1 = kotlin.reflect.jvm.internal.j.aoS;
        r2 = r0.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0095;
            case 2: goto L_0x0095;
            case 3: goto L_0x0095;
            case 4: goto L_0x0073;
            case 5: goto L_0x0049;
            case 6: goto L_0x002c;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = new kotlin.NoWhenBranchMatchedException;
        r0.<init>();
        throw r0;
    L_0x002c:
        r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unresolved class: ";
        r1.append(r2);
        r2 = r4.aXV();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0049:
        r1 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unknown class: ";
        r2.append(r3);
        r3 = r4.aXV();
        r2.append(r3);
        r3 = " (kind = ";
        r2.append(r3);
        r2.append(r0);
        r0 = 41;
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x0073:
        r0 = new java.lang.UnsupportedOperationException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ";
        r1.append(r2);
        r2 = "library has no idea what declarations does it have. Please use Java reflection to inspect this class: ";
        r1.append(r2);
        r2 = r4.aXV();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0095:
        r0 = new java.lang.UnsupportedOperationException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Packages and file facades are not yet supported in Kotlin reflection. ";
        r1.append(r2);
        r2 = "Meanwhile please use Java reflection to inspect this class: ";
        r1.append(r2);
        r2 = r4.aXV();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.i.aZa():java.lang.Void");
    }
}
