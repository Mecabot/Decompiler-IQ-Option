package com.iqoption.util;

import com.google.common.base.Suppliers;
import com.google.common.base.n;

/* compiled from: Caser */
public class h {
    private static n<a> duT = Suppliers.a(new n<a>() {
        /* renamed from: aFZ */
        public a get() {
            return new a(0.01d, null);
        }
    });

    /* compiled from: Caser */
    private static final class a {
        private final double value;

        /* synthetic */ a(double d, AnonymousClass1 anonymousClass1) {
            this(d);
        }

        private a(double d) {
            this.value = d;
        }

        void b(double d, b bVar) {
            if (d >= this.value) {
                bVar.f(d);
            } else if (d <= (-this.value)) {
                bVar.g(Math.abs(d));
            } else {
                bVar.h(d);
            }
        }
    }

    /* compiled from: Caser */
    public interface b {
        void f(double d);

        void g(double d);

        void h(double d);
    }

    public static void a(double d, b bVar) {
        ((a) duT.get()).b(d, bVar);
    }
}
