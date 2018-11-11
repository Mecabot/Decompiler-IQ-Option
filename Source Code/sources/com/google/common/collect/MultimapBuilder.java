package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MultimapBuilder<K0, V0> {

    public static abstract class b<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> ux();

        b() {
        }

        public a<K0, Object> uB() {
            return bk(2);
        }

        public a<K0, Object> bk(final int i) {
            g.b(i, "expectedValuesPerKey");
            return new a<K0, Object>() {
                public <K extends K0, V> t<K, V> uA() {
                    return Multimaps.a(b.this.ux(), new ArrayListSupplier(i));
                }
            };
        }

        public c<K0, Object> uC() {
            return bl(2);
        }

        public c<K0, Object> bl(final int i) {
            g.b(i, "expectedValuesPerKey");
            return new c<K0, Object>() {
                public <K extends K0, V> ac<K, V> uD() {
                    return Multimaps.b(b.this.ux(), new HashSetSupplier(i));
                }
            };
        }
    }

    private static final class ArrayListSupplier<V> implements n<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i) {
            this.expectedValuesPerKey = g.b(i, "expectedValuesPerKey");
        }

        /* renamed from: uy */
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    private static final class HashSetSupplier<V> implements n<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        HashSetSupplier(int i) {
            this.expectedValuesPerKey = g.b(i, "expectedValuesPerKey");
        }

        /* renamed from: uz */
        public Set<V> get() {
            return Sets.bu(this.expectedValuesPerKey);
        }
    }

    public static abstract class a<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> t<K, V> uA();

        a() {
            super();
        }
    }

    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> ac<K, V> uD();

        c() {
            super();
        }
    }

    /* synthetic */ MultimapBuilder(AnonymousClass1 anonymousClass1) {
        this();
    }

    private MultimapBuilder() {
    }

    public static b<Object> uv() {
        return bi(8);
    }

    public static b<Object> bi(final int i) {
        g.b(i, "expectedKeys");
        return new b<Object>() {
            <K, V> Map<K, Collection<V>> ux() {
                return Maps.bf(i);
            }
        };
    }

    public static b<Object> uw() {
        return bj(8);
    }

    public static b<Object> bj(final int i) {
        g.b(i, "expectedKeys");
        return new b<Object>() {
            <K, V> Map<K, Collection<V>> ux() {
                return Maps.bh(i);
            }
        };
    }
}
