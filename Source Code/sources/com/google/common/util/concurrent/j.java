package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.i;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/* compiled from: CollectionFuture */
abstract class j<V, C> extends e<V, C> {

    /* compiled from: CollectionFuture */
    abstract class a extends a {
        private List<Optional<V>> values;

        abstract C w(List<Optional<V>> list);

        a(ImmutableCollection<? extends s<? extends V>> immutableCollection, boolean z) {
            ImmutableList sL;
            super(immutableCollection, z, true);
            if (immutableCollection.isEmpty()) {
                sL = ImmutableList.sL();
            } else {
                sL = Lists.aY(immutableCollection.size());
            }
            this.values = sL;
            for (int i = 0; i < immutableCollection.size(); i++) {
                this.values.add(null);
            }
        }

        final void a(boolean z, int i, V v) {
            List list = this.values;
            if (list != null) {
                list.set(i, Optional.F(v));
                return;
            }
            z = z || j.this.isCancelled();
            i.a(z, "Future was done before all dependencies completed");
        }

        final void vO() {
            List list = this.values;
            if (list != null) {
                j.this.a(w(list));
            } else {
                i.checkState(j.this.isDone());
            }
        }

        void vN() {
            super.vN();
            this.values = null;
        }
    }

    /* compiled from: CollectionFuture */
    static final class b<V> extends j<V, List<V>> {

        /* compiled from: CollectionFuture */
        private final class a extends a {
            a(ImmutableCollection<? extends s<? extends V>> immutableCollection, boolean z) {
                super(immutableCollection, z);
            }

            /* renamed from: x */
            public List<V> w(List<Optional<V>> list) {
                List aY = Lists.aY(list.size());
                for (Optional optional : list) {
                    aY.add(optional != null ? optional.pq() : null);
                }
                return Collections.unmodifiableList(aY);
            }
        }

        b(ImmutableCollection<? extends s<? extends V>> immutableCollection, boolean z) {
            a(new a(immutableCollection, z));
        }
    }

    j() {
    }
}
