package kotlin.reflect.jvm.internal.components;

import kotlin.i;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.e;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.incremental.components.c;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.a.b;
import kotlin.reflect.jvm.internal.impl.load.java.components.g;
import kotlin.reflect.jvm.internal.impl.load.java.components.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.l;
import kotlin.reflect.jvm.internal.impl.load.kotlin.d;
import kotlin.reflect.jvm.internal.impl.load.kotlin.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.h;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "", "deserialization", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationComponents;", "packagePartProvider", "Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "(Lorg/jetbrains/kotlin/serialization/deserialization/DeserializationComponents;Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;)V", "getDeserialization", "()Lorg/jetbrains/kotlin/serialization/deserialization/DeserializationComponents;", "module", "Lkotlin/reflect/jvm/internal/impl/descriptors/ModuleDescriptor;", "getModule", "()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "getPackagePartProvider", "()Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Companion", "descriptors.runtime"})
/* compiled from: RuntimeModuleData.kt */
public final class j {
    public static final a ewT = new a();
    private final h ewR;
    private final k ewS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimeModuleData$Companion;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "classLoader", "Ljava/lang/ClassLoader;", "descriptors.runtime"})
    /* compiled from: RuntimeModuleData.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final j b(ClassLoader classLoader) {
            ClassLoader classLoader2 = classLoader;
            kotlin.jvm.internal.h.e(classLoader2, "classLoader");
            kotlin.reflect.jvm.internal.impl.storage.h lockBasedStorageManager = new LockBasedStorageManager();
            e eVar = new e(lockBasedStorageManager, false, 2, null);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<runtime module for ");
            stringBuilder.append(classLoader2);
            stringBuilder.append('>');
            f mF = f.mF(stringBuilder.toString());
            kotlin.jvm.internal.h.d(mF, "Name.special(\"<runtime module for $classLoader>\")");
            u uVar = new u(mF, lockBasedStorageManager, eVar, null, null, null, 56, null);
            f fVar = new f(classLoader2);
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar2 = new kotlin.reflect.jvm.internal.impl.load.kotlin.e();
            l lVar = new l();
            k kVar = new k(classLoader2);
            g gVar = g.eGk;
            kotlin.reflect.jvm.internal.impl.descriptors.u uVar2 = uVar;
            w wVar = new w(lockBasedStorageManager, uVar2);
            AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(lockBasedStorageManager, kotlin.reflect.jvm.internal.impl.utils.e.eXG);
            kotlin.reflect.jvm.internal.impl.load.java.g cVar = new c(classLoader2);
            m mVar = fVar;
            k kVar2 = k.eGm;
            kotlin.jvm.internal.h.d(kVar2, "SignaturePropagator.DO_NOTHING");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.l lVar2 = i.ewQ;
            kotlin.jvm.internal.h.d(gVar, "javaResolverCache");
            kotlin.reflect.jvm.internal.impl.load.java.components.f fVar2 = kotlin.reflect.jvm.internal.impl.load.java.components.f.a.eGj;
            kotlin.reflect.jvm.internal.impl.load.java.components.j jVar = kotlin.reflect.jvm.internal.impl.load.java.components.j.a.eGl;
            b bVar = l.ewY;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.j jVar2 = lVar;
            t tVar = kVar;
            al alVar = kotlin.reflect.jvm.internal.impl.descriptors.al.a.eAZ;
            c cVar2 = kotlin.reflect.jvm.internal.impl.incremental.components.c.a.eEs;
            e eVar3 = eVar;
            kotlin.reflect.jvm.internal.impl.builtins.h hVar = new kotlin.reflect.jvm.internal.impl.builtins.h(uVar2, wVar);
            k kVar3 = kVar2;
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar3 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j(annotationTypeQualifierResolver, kotlin.reflect.jvm.internal.impl.utils.e.eXG);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.b bVar2 = r3;
            AnnotationTypeQualifierResolver annotationTypeQualifierResolver2 = annotationTypeQualifierResolver;
            kotlin.reflect.jvm.internal.impl.load.java.g gVar2 = cVar;
            kotlin.reflect.jvm.internal.impl.descriptors.u uVar3 = uVar2;
            kotlin.reflect.jvm.internal.impl.storage.h hVar2 = lockBasedStorageManager;
            w wVar2 = wVar;
            g gVar3 = gVar;
            k kVar4 = kVar;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.l lVar3 = lVar2;
            l lVar4 = lVar;
            w wVar3 = wVar2;
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar4 = eVar2;
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar5 = eVar4;
            m mVar2 = mVar;
            l lVar5 = lVar4;
            u uVar4 = uVar;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.b bVar3 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.b(lockBasedStorageManager, gVar2, mVar, eVar2, kVar3, lVar3, gVar3, fVar2, jVar, bVar, jVar2, tVar, alVar, cVar2, uVar3, hVar, annotationTypeQualifierResolver2, jVar3, kotlin.reflect.jvm.internal.impl.load.java.h.a.eFd, kotlin.reflect.jvm.internal.impl.load.java.lazy.c.b.eGQ);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(bVar2);
            e eVar6 = eVar3;
            eVar6.a(uVar3, true);
            kotlin.reflect.jvm.internal.impl.resolve.jvm.a aVar = new kotlin.reflect.jvm.internal.impl.resolve.jvm.a(gVar4, gVar3);
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar7 = eVar5;
            kotlin.reflect.jvm.internal.impl.load.kotlin.f fVar3 = new kotlin.reflect.jvm.internal.impl.load.kotlin.f(mVar2, eVar7);
            kotlin.reflect.jvm.internal.impl.storage.h hVar3 = hVar2;
            w wVar4 = wVar3;
            kotlin.reflect.jvm.internal.impl.load.kotlin.c cVar3 = new kotlin.reflect.jvm.internal.impl.load.kotlin.c(uVar3, wVar4, hVar3, mVar2);
            kotlin.reflect.jvm.internal.impl.descriptors.u uVar5 = uVar3;
            kotlin.reflect.jvm.internal.impl.load.kotlin.e eVar8 = eVar7;
            d dVar = new d(hVar3, uVar5, kotlin.reflect.jvm.internal.impl.serialization.deserialization.i.a.eSX, fVar3, cVar3, gVar4, wVar4, i.ewQ, kotlin.reflect.jvm.internal.impl.incremental.components.c.a.eEs, kotlin.reflect.jvm.internal.impl.serialization.deserialization.g.eSI.bxs());
            lVar5.a(aVar);
            eVar8.a(dVar);
            r0 = new u[2];
            uVar = uVar4;
            r0[0] = uVar;
            u baJ = eVar6.baJ();
            kotlin.jvm.internal.h.d(baJ, "builtIns.builtInsModule");
            r0[1] = baJ;
            uVar.a(r0);
            uVar.a((y) aVar.bwJ());
            return new j(dVar.biq(), kVar4, null);
        }
    }

    private j(h hVar, k kVar) {
        this.ewR = hVar;
        this.ewS = kVar;
    }

    public /* synthetic */ j(h hVar, k kVar, f fVar) {
        this(hVar, kVar);
    }

    public final h bas() {
        return this.ewR;
    }

    public final k bat() {
        return this.ewS;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.u bar() {
        return this.ewR.bxu();
    }
}
