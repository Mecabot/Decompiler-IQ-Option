package com.iqoption.core.data.repository;

import com.iqoption.core.h.d;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import org.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: BalanceRepository.kt */
final class BalanceRepository$balancesStream$2 extends Lambda implements kotlin.jvm.a.a<d<List<? extends com.iqoption.core.microservices.internalbilling.a.a>>> {
    public static final BalanceRepository$balancesStream$2 aOH = new BalanceRepository$balancesStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "it", "Lcom/iqoption/core/microservices/Event;", "apply"})
    /* compiled from: BalanceRepository.kt */
    static final class a<T, R> implements f<T, R> {
        final /* synthetic */ AtomicReference aOI;

        a(AtomicReference atomicReference) {
            this.aOI = atomicReference;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
        /* renamed from: a */
        public final java.util.List<com.iqoption.core.microservices.internalbilling.a.a> apply(com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a> r13) {
            /*
            r12 = this;
            r0 = "it";
            kotlin.jvm.internal.h.e(r13, r0);
            r0 = r12.aOI;
            r0 = r0.get();
            r1 = "list.get()";
            kotlin.jvm.internal.h.d(r0, r1);
            r0 = (java.util.Collection) r0;
            r0 = kotlin.collections.u.O(r0);
            r1 = r13.getType();
            r2 = -1;
            r3 = 1;
            r4 = 0;
            switch(r1) {
                case 1: goto L_0x0059;
                case 2: goto L_0x0022;
                default: goto L_0x0020;
            };
        L_0x0020:
            goto L_0x008f;
        L_0x0022:
            r13 = r13.getData();
            r13 = (com.iqoption.core.microservices.internalbilling.a.a) r13;
            r1 = r0.iterator();
            r5 = 0;
        L_0x002d:
            r6 = r1.hasNext();
            if (r6 == 0) goto L_0x004e;
        L_0x0033:
            r6 = r1.next();
            r6 = (com.iqoption.core.microservices.internalbilling.a.a) r6;
            r6 = r6.getId();
            r8 = r13.getId();
            r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r10 != 0) goto L_0x0047;
        L_0x0045:
            r6 = 1;
            goto L_0x0048;
        L_0x0047:
            r6 = 0;
        L_0x0048:
            if (r6 == 0) goto L_0x004b;
        L_0x004a:
            goto L_0x004f;
        L_0x004b:
            r5 = r5 + 1;
            goto L_0x002d;
        L_0x004e:
            r5 = -1;
        L_0x004f:
            if (r5 != r2) goto L_0x0055;
        L_0x0051:
            r0.add(r13);
            goto L_0x008f;
        L_0x0055:
            r0.set(r5, r13);
            goto L_0x008f;
        L_0x0059:
            r1 = r13.getData();
            r1 = (com.iqoption.core.microservices.internalbilling.a.a) r1;
            r5 = r0.iterator();
            r6 = 0;
        L_0x0064:
            r7 = r5.hasNext();
            if (r7 == 0) goto L_0x0085;
        L_0x006a:
            r7 = r5.next();
            r7 = (com.iqoption.core.microservices.internalbilling.a.a) r7;
            r7 = r7.getId();
            r9 = r1.getId();
            r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
            if (r11 != 0) goto L_0x007e;
        L_0x007c:
            r7 = 1;
            goto L_0x007f;
        L_0x007e:
            r7 = 0;
        L_0x007f:
            if (r7 == 0) goto L_0x0082;
        L_0x0081:
            goto L_0x0086;
        L_0x0082:
            r6 = r6 + 1;
            goto L_0x0064;
        L_0x0085:
            r6 = -1;
        L_0x0086:
            if (r6 != r2) goto L_0x008f;
        L_0x0088:
            r13 = r13.getData();
            r0.add(r13);
        L_0x008f:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.data.repository.BalanceRepository.balancesStream.2.a.a(com.iqoption.core.microservices.a):java.util.List<com.iqoption.core.microservices.internalbilling.a.a>");
        }
    }

    BalanceRepository$balancesStream$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<List<com.iqoption.core.microservices.internalbilling.a.a>> invoke() {
        final AtomicReference atomicReference = new AtomicReference(m.emptyList());
        e a = com.iqoption.core.microservices.internalbilling.a.aWi.VX().aWk().c((b) com.iqoption.core.microservices.internalbilling.a.aWi.VY().d((f) new a(atomicReference))).a((io.reactivex.c.e) new io.reactivex.c.e<List<? extends com.iqoption.core.microservices.internalbilling.a.a>>() {
            /* renamed from: C */
            public final void accept(List<com.iqoption.core.microservices.internalbilling.a.a> list) {
                atomicReference.set(list);
            }
        });
        h.d(a, "initial.concatWith(updat…doOnNext { list.set(it) }");
        return new d(a, 0, null, 6, null);
    }
}
