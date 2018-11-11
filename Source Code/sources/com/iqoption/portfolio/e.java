package com.iqoption.portfolio;

import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import com.google.common.base.Predicates;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.util.d.b;
import java.util.Comparator;

/* compiled from: PendingPositionGroup */
public final class e {
    private static final Ordering<Order> ORDERING = new Ordering<Order>() {
        public int compare(Order order, Order order2) {
            return Longs.compare(order2.getCreateAt().longValue(), order.getCreateAt().longValue());
        }
    };
    private static final String TAG = "com.iqoption.portfolio.e";
    private static final d<Order, e> cYb = new d<Order, e>() {
        /* renamed from: p */
        public e apply(Order order) {
            if (order == null) {
                i.w(e.TAG, "Order is null");
                return null;
            }
            a a = com.iqoption.app.helpers.a.FI().a(order.getInstrumentActiveId(), order.getInstrumentType());
            if (a != null) {
                return new e(a, order);
            }
            String access$000 = e.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Active is null for order: ");
            stringBuilder.append(order);
            i.w(access$000, stringBuilder.toString());
            return null;
        }
    };
    private final a aiJ;
    private long cYi;
    private ImmutableList<Order> cYj;
    private boolean cYk;
    private final LongSparseArray<Order> cYl = new LongSparseArray();
    private final long id;

    public e(a aVar, Order order) {
        this.aiJ = aVar;
        this.id = (long) f.hashCode(order.getId());
        o(order);
    }

    public void o(Order order) {
        if (order != null) {
            this.cYl.put(order.getId().longValue(), order);
            long createTime = order.getCreateTime();
            if (this.cYi < createTime) {
                this.cYi = createTime;
            }
            this.cYk = true;
        }
    }

    public long getId() {
        return this.id;
    }

    @NonNull
    public a Jg() {
        return this.aiJ;
    }

    public ActiveType getActiveType() {
        return this.aiJ.getActiveType();
    }

    public long avV() {
        return this.cYi;
    }

    public ImmutableList<Order> Gm() {
        if (this.cYj == null || this.cYk) {
            this.cYj = com.google.common.collect.i.c(b.a(this.cYl)).a(ORDERING);
            this.cYk = false;
        }
        return this.cYj;
    }

    public int size() {
        return this.cYl.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PendingPositionGroup{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", orders=");
        stringBuilder.append(this.cYl);
        stringBuilder.append(", lastCreateTime=");
        stringBuilder.append(this.cYi);
        stringBuilder.append(", snapshot=");
        stringBuilder.append(this.cYj);
        stringBuilder.append(", snapshotDirty=");
        stringBuilder.append(this.cYk);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static ImmutableList<e> a(Iterable<Order> iterable, Ordering<e> ordering) {
        return com.google.common.collect.i.c((Iterable) iterable).b(cYb).c(Predicates.pS()).a((Comparator) ordering);
    }
}
