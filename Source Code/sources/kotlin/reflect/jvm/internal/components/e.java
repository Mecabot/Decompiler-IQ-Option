package kotlin.reflect.jvm.internal.components;

import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.d;
import kotlin.reflect.jvm.internal.structure.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, aXE = {"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "klass", "Ljava/lang/Class;", "classHeader", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/header/KotlinClassHeader;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;)V", "getClassHeader", "()Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "getKlass", "()Ljava/lang/Class;", "location", "", "getLocation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "loadClassAnnotations", "", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "cachedContents", "", "toString", "visitMembers", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "Factory", "descriptors.runtime"})
/* compiled from: ReflectKotlinClass.kt */
public final class e implements n {
    public static final a ewO = new a();
    private final Class<?> ewM;
    private final KotlinClassHeader ewN;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "klass", "Ljava/lang/Class;", "descriptors.runtime"})
    /* compiled from: ReflectKotlinClass.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final e M(Class<?> cls) {
            h.e(cls, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            b.ewL.a((Class) cls, (c) aVar);
            KotlinClassHeader biR = aVar.biR();
            return biR != null ? new e(cls, biR, null) : null;
        }
    }

    private e(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.ewM = cls;
        this.ewN = kotlinClassHeader;
    }

    public /* synthetic */ e(Class cls, KotlinClassHeader kotlinClassHeader, f fVar) {
        this(cls, kotlinClassHeader);
    }

    public final Class<?> bao() {
        return this.ewM;
    }

    public KotlinClassHeader bap() {
        return this.ewN;
    }

    public String getLocation() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = this.ewM.getName();
        h.d(name, "klass.name");
        stringBuilder.append(u.a(name, '.', '/', false, 4, null));
        stringBuilder.append(".class");
        return stringBuilder.toString();
    }

    public kotlin.reflect.jvm.internal.impl.name.a getClassId() {
        return b.S(this.ewM);
    }

    public void a(c cVar, byte[] bArr) {
        h.e(cVar, "visitor");
        b.ewL.a(this.ewM, cVar);
    }

    public void a(d dVar, byte[] bArr) {
        h.e(dVar, "visitor");
        b.ewL.a(this.ewM, dVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && h.E(this.ewM, ((e) obj).ewM);
    }

    public int hashCode() {
        return this.ewM.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.ewM);
        return stringBuilder.toString();
    }
}
