package kotlin.reflect.jvm;

import java.util.Arrays;
import kotlin.Pair;
import kotlin.c;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, aXE = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflect-api"})
/* compiled from: reflectLambda.kt */
public final class d {
    public static final <R> e<R> a(c<? extends R> cVar) {
        h.e(cVar, "$receiver");
        i iVar = (i) cVar.getClass().getAnnotation(i.class);
        if (iVar == null) {
            return null;
        }
        String[] aXD = iVar.aXD();
        if ((aXD.length == 0 ? 1 : null) != null) {
            aXD = null;
        }
        if (aXD == null) {
            return null;
        }
        Pair c = j.c(aXD, iVar.aXE());
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h hVar = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h) c.aXG();
        Function function = (Function) c.aXH();
        int[] aXC = iVar.aXC();
        g gVar = new g(Arrays.copyOf(aXC, aXC.length));
        Class cls = cVar.getClass();
        n nVar = function;
        kotlin.reflect.jvm.internal.impl.metadata.a.c cVar2 = hVar;
        TypeTable bkF = function.bkF();
        h.d(bkF, "proto.typeTable");
        ah ahVar = (ah) ae.a(cls, nVar, cVar2, new kotlin.reflect.jvm.internal.impl.metadata.a.h(bkF), gVar, ReflectLambdaKt$reflect$descriptor$1.euO);
        if (ahVar != null) {
            return new KFunctionImpl(b.euZ, ahVar);
        }
        return null;
    }
}
