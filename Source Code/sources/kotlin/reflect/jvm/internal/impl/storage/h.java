package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.l;

/* compiled from: StorageManager.kt */
public interface h {
    <T> e<T> a(a<? extends T> aVar, T t);

    <T> e<T> a(a<? extends T> aVar, b<? super Boolean, ? extends T> bVar, b<? super T, l> bVar2);

    <K, V> a<K, V> byD();

    <T> e<T> i(a<? extends T> aVar);

    <T> f<T> j(a<? extends T> aVar);

    <K, V> b<K, V> o(b<? super K, ? extends V> bVar);

    <K, V> c<K, V> p(b<? super K, ? extends V> bVar);
}
