package com.iqoption.core.connect;

import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00040\bH&J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000bH&J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/connect/RequestBuilderFactory;", "", "create", "Lcom/iqoption/core/connect/RequestBuilder;", "T", "name", "", "parser", "Lkotlin/Function1;", "Lcom/google/gson/stream/JsonReader;", "cls", "Ljava/lang/Class;", "type", "Ljava/lang/reflect/Type;", "core_release"})
/* compiled from: RequestBuilderFactory.kt */
public interface l {
    <T> k<T> a(String str, Type type);

    <T> k<T> a(String str, b<? super JsonReader, ? extends T> bVar);

    <T> k<T> b(String str, Class<T> cls);
}
