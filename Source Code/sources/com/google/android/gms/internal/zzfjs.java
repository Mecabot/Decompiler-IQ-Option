package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Stack;

final class zzfjs {
    private final Stack<zzfgs> zzprx;

    private zzfjs() {
        this.zzprx = new Stack();
    }

    private final void zzbb(zzfgs zzfgs) {
        while (!zzfgs.zzcxs()) {
            if (zzfgs instanceof zzfjq) {
                zzfjq zzfjq = (zzfjq) zzfgs;
                zzbb(zzfjq.zzprt);
                zzfgs = zzfjq.zzpru;
            } else {
                String valueOf = String.valueOf(zzfgs.getClass());
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 49);
                stringBuilder.append("Has a new type of ByteString been created? Found ");
                stringBuilder.append(valueOf);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        int zzmp = zzmp(zzfgs.size());
        int i = zzfjq.zzprr[zzmp + 1];
        if (this.zzprx.isEmpty() || ((zzfgs) this.zzprx.peek()).size() >= i) {
            this.zzprx.push(zzfgs);
            return;
        }
        zzmp = zzfjq.zzprr[zzmp];
        zzfgs zzfgs2 = (zzfgs) this.zzprx.pop();
        while (!this.zzprx.isEmpty() && ((zzfgs) this.zzprx.peek()).size() < zzmp) {
            zzfgs2 = new zzfjq((zzfgs) this.zzprx.pop(), zzfgs2, null);
        }
        zzfgs zzfjq2 = new zzfjq(zzfgs2, zzfgs, null);
        while (!this.zzprx.isEmpty()) {
            if (((zzfgs) this.zzprx.peek()).size() >= zzfjq.zzprr[zzmp(zzfjq2.size()) + 1]) {
                break;
            }
            zzfjq2 = new zzfjq((zzfgs) this.zzprx.pop(), zzfjq2, null);
        }
        this.zzprx.push(zzfjq2);
    }

    private final zzfgs zzc(zzfgs zzfgs, zzfgs zzfgs2) {
        zzbb(zzfgs);
        zzbb(zzfgs2);
        zzfgs = (zzfgs) this.zzprx.pop();
        while (!this.zzprx.isEmpty()) {
            zzfgs = new zzfjq((zzfgs) this.zzprx.pop(), zzfgs, null);
        }
        return zzfgs;
    }

    private static int zzmp(int i) {
        i = Arrays.binarySearch(zzfjq.zzprr, i);
        return i < 0 ? (-(i + 1)) - 1 : i;
    }
}
