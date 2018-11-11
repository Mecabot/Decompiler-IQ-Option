package com.iqoption.core.util;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0016J\u0014\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/util/KotlinGsonAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "classesCache", "Lcom/google/common/cache/Cache;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "", "create", "Lcom/google/gson/TypeAdapter;", "T", "", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "shouldCheckForNull", "clazz", "Adapter", "core_release"})
/* compiled from: KotlinGsonAdapterFactory.kt */
public final class KotlinGsonAdapterFactory implements TypeAdapterFactory {
    private final com.google.common.cache.b<Class<?>, Boolean> bgY = CacheBuilder.qh().b(3, TimeUnit.MINUTES).qw();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "T", "", "call"})
    /* compiled from: KotlinGsonAdapterFactory.kt */
    static final class b<V> implements Callable<Boolean> {
        final /* synthetic */ KotlinGsonAdapterFactory bhb;
        final /* synthetic */ Class bhc;

        b(KotlinGsonAdapterFactory kotlinGsonAdapterFactory, Class cls) {
            this.bhb = kotlinGsonAdapterFactory;
            this.bhc = cls;
        }

        public /* synthetic */ Object call() {
            return Boolean.valueOf(aaf());
        }

        public final boolean aaf() {
            KotlinGsonAdapterFactory kotlinGsonAdapterFactory = this.bhb;
            Class cls = this.bhc;
            h.d(cls, "rawType");
            return kotlinGsonAdapterFactory.z(cls);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/util/KotlinGsonAdapterFactory$Adapter;", "T", "", "Lcom/google/gson/TypeAdapter;", "factory", "Lcom/iqoption/core/util/KotlinGsonAdapterFactory;", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "kClass", "Lkotlin/reflect/KClass;", "(Lcom/iqoption/core/util/KotlinGsonAdapterFactory;Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;Lkotlin/reflect/KClass;)V", "delegate", "getDelegate", "()Lcom/google/gson/TypeAdapter;", "propertiesCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "checkForNull", "", "value", "(Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "out", "Lcom/google/gson/stream/JsonWriter;", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "core_release"})
    /* compiled from: KotlinGsonAdapterFactory.kt */
    public static final class a<T> extends TypeAdapter<T> {
        private final ConcurrentHashMap<kotlin.reflect.b<?>, Collection<?>> bgZ = new ConcurrentHashMap();
        private final kotlin.reflect.b<T> bha;
        private final TypeAdapter<T> delegate;

        public a(KotlinGsonAdapterFactory kotlinGsonAdapterFactory, Gson gson, TypeToken<T> typeToken, kotlin.reflect.b<T> bVar) {
            h.e(kotlinGsonAdapterFactory, "factory");
            h.e(gson, "gson");
            h.e(typeToken, Param.TYPE);
            h.e(bVar, "kClass");
            this.bha = bVar;
            TypeAdapter delegateAdapter = gson.getDelegateAdapter(kotlinGsonAdapterFactory, typeToken);
            h.d(delegateAdapter, "gson.getDelegateAdapter(factory, type)");
            this.delegate = delegateAdapter;
        }

        public void write(JsonWriter jsonWriter, T t) {
            h.e(jsonWriter, "out");
            h.e(t, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
            this.delegate.write(jsonWriter, t);
        }

        public T read(JsonReader jsonReader) {
            h.e(jsonReader, "input");
            T read = this.delegate.read(jsonReader);
            h.d(read, "this");
            bq(read);
            h.d(read, "delegate.read(input).app…rNull(this)\n            }");
            return read;
        }

        private final void bq(T t) {
            ConcurrentMap concurrentMap = this.bgZ;
            kotlin.reflect.b bVar = this.bha;
            Object obj = concurrentMap.get(bVar);
            if (obj == null) {
                obj = kotlin.reflect.full.a.d(this.bha);
                Object putIfAbsent = concurrentMap.putIfAbsent(bVar, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<kotlin.reflect.KProperty1<T, *>>");
            }
            for (l lVar : (Collection) obj) {
                kotlin.reflect.jvm.a.a(lVar, true);
                if (!lVar.aXT().aYp() && lVar.invoke(t) == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Field '");
                    stringBuilder.append(lVar.getName());
                    stringBuilder.append("' must be not null!");
                    throw new JsonParseException(stringBuilder.toString());
                }
            }
        }
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        h.e(gson, "gson");
        h.e(typeToken, Param.TYPE);
        Class rawType = typeToken.getRawType();
        if (!((Boolean) this.bgY.a(rawType, new b(this, rawType))).booleanValue()) {
            return null;
        }
        if (rawType == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
        }
        kotlin.reflect.b E = kotlin.jvm.a.E(rawType);
        if (E != null) {
            return new a(this, gson, typeToken, E);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<T>");
    }

    private final boolean z(Class<?> cls) {
        Annotation annotation;
        Annotation annotation2;
        Object declaredAnnotations = cls.getDeclaredAnnotations();
        h.d(declaredAnnotations, "clazz.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (true) {
            annotation = null;
            if (i >= length) {
                annotation2 = null;
                break;
            }
            annotation2 = declaredAnnotations[i];
            if (h.E(kotlin.jvm.a.a(kotlin.jvm.a.a(annotation2)).getName(), "kotlin.Metadata")) {
                break;
            }
            i++;
        }
        Object obj = annotation2 != null ? 1 : null;
        Object declaredAnnotations2 = cls.getDeclaredAnnotations();
        h.d(declaredAnnotations2, "clazz.declaredAnnotations");
        for (Annotation annotation3 : declaredAnnotations2) {
            if (h.E(kotlin.jvm.a.a(kotlin.jvm.a.a(annotation3)).getName(), "com.iqoption.util.GsonNullCheck")) {
                annotation = annotation3;
                break;
            }
        }
        declaredAnnotations2 = annotation != null ? 1 : null;
        if (obj == null || declaredAnnotations2 == null) {
            return false;
        }
        return true;
    }
}
