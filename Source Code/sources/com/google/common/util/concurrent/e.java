package com.google.common.util.concurrent;

import com.google.common.base.i;
import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/* compiled from: AggregateFuture */
abstract class e<InputT, OutputT> extends h<OutputT> {
    private static final Logger logger = Logger.getLogger(e.class.getName());
    private a Wu;

    /* compiled from: AggregateFuture */
    abstract class a extends f implements Runnable {
        private ImmutableCollection<? extends s<? extends InputT>> Wv;
        private final boolean Ww;
        private final boolean Wx;

        abstract void a(boolean z, int i, InputT inputT);

        void vD() {
        }

        abstract void vO();

        a(ImmutableCollection<? extends s<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.Wv = (ImmutableCollection) i.checkNotNull(immutableCollection);
            this.Ww = z;
            this.Wx = z2;
        }

        public final void run() {
            vL();
        }

        private void init() {
            if (this.Wv.isEmpty()) {
                vO();
                return;
            }
            if (this.Ww) {
                int i = 0;
                Iterator sI = this.Wv.iterator();
                while (sI.hasNext()) {
                    final s sVar = (s) sI.next();
                    int i2 = i + 1;
                    sVar.a(new Runnable() {
                        public void run() {
                            try {
                                a.this.a(i, sVar);
                            } finally {
                                a.this.vL();
                            }
                        }
                    }, MoreExecutors.vV());
                    i = i2;
                }
            } else {
                Iterator sI2 = this.Wv.iterator();
                while (sI2.hasNext()) {
                    ((s) sI2.next()).a(this, MoreExecutors.vV());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
        private void k(java.lang.Throwable r7) {
            /*
            r6 = this;
            com.google.common.base.i.checkNotNull(r7);
            r0 = r6.Ww;
            r1 = 1;
            r2 = 0;
            if (r0 == 0) goto L_0x001e;
        L_0x0009:
            r0 = com.google.common.util.concurrent.e.this;
            r0 = r0.a(r7);
            if (r0 == 0) goto L_0x0015;
        L_0x0011:
            r6.vN();
            goto L_0x001f;
        L_0x0015:
            r3 = r6.vP();
            r3 = com.google.common.util.concurrent.e.a(r3, r7);
            goto L_0x0020;
        L_0x001e:
            r0 = 0;
        L_0x001f:
            r3 = 1;
        L_0x0020:
            r4 = r7 instanceof java.lang.Error;
            r5 = r6.Ww;
            if (r0 != 0) goto L_0x0027;
        L_0x0026:
            goto L_0x0028;
        L_0x0027:
            r1 = 0;
        L_0x0028:
            r0 = r5 & r1;
            r0 = r0 & r3;
            r0 = r0 | r4;
            if (r0 == 0) goto L_0x003e;
        L_0x002e:
            if (r4 == 0) goto L_0x0033;
        L_0x0030:
            r0 = "Input Future failed with Error";
            goto L_0x0035;
        L_0x0033:
            r0 = "Got more than one input Future failure. Logging failures after the first";
        L_0x0035:
            r1 = com.google.common.util.concurrent.e.logger;
            r2 = java.util.logging.Level.SEVERE;
            r1.log(r2, r0, r7);
        L_0x003e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.e.a.k(java.lang.Throwable):void");
        }

        final void e(Set<Throwable> set) {
            if (!e.this.isCancelled()) {
                e.a((Set) set, e.this.vF());
            }
        }

        private void a(int i, Future<? extends InputT> future) {
            boolean z = this.Ww || !e.this.isDone() || e.this.isCancelled();
            i.a(z, "Future was done before all dependencies completed");
            try {
                i.a(future.isDone(), "Tried to set value from future which is not done");
                if (this.Ww) {
                    if (future.isCancelled()) {
                        e.this.Wu = null;
                        e.this.cancel(false);
                        return;
                    }
                    Object b = o.b((Future) future);
                    if (this.Wx) {
                        a(this.Ww, i, b);
                    }
                } else if (this.Wx && !future.isCancelled()) {
                    a(this.Ww, i, o.b((Future) future));
                }
            } catch (ExecutionException e) {
                k(e.getCause());
            } catch (Throwable th) {
                k(th);
            }
        }

        private void vL() {
            int vQ = vQ();
            i.a(vQ >= 0, "Less than 0 remaining futures");
            if (vQ == 0) {
                vM();
            }
        }

        private void vM() {
            if ((this.Wx & (this.Ww ^ 1)) != 0) {
                int i = 0;
                Iterator sI = this.Wv.iterator();
                while (sI.hasNext()) {
                    int i2 = i + 1;
                    a(i, (s) sI.next());
                    i = i2;
                }
            }
            vO();
        }

        void vN() {
            this.Wv = null;
        }
    }

    e() {
    }

    protected final void vC() {
        super.vC();
        a aVar = this.Wu;
        if (aVar != null) {
            this.Wu = null;
            ImmutableCollection b = aVar.Wv;
            boolean vE = vE();
            if (vE) {
                aVar.vD();
            }
            if ((isCancelled() & (b != null ? 1 : 0)) != 0) {
                Iterator sI = b.iterator();
                while (sI.hasNext()) {
                    ((s) sI.next()).cancel(vE);
                }
            }
        }
    }

    protected String vB() {
        a aVar = this.Wu;
        if (aVar == null) {
            return null;
        }
        ImmutableCollection b = aVar.Wv;
        if (b == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("futures=[");
        stringBuilder.append(b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    final void a(a aVar) {
        this.Wu = aVar;
        aVar.init();
    }

    private static boolean a(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
