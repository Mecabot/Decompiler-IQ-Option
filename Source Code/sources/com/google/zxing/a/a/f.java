package com.google.zxing.a.a;

import android.support.v4.internal.view.SupportMenu;
import com.google.zxing.common.a;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: State */
final class f {
    static final f abn = new f(g.abr, 0, 0, 0);
    private final g abo;
    private final int abp;
    private final int abq;
    private final int mode;

    private f(g gVar, int i, int i2, int i3) {
        this.abo = gVar;
        this.mode = i;
        this.abp = i2;
        this.abq = i3;
    }

    int getMode() {
        return this.mode;
    }

    int yw() {
        return this.abp;
    }

    int yx() {
        return this.abq;
    }

    f G(int i, int i2) {
        int i3;
        int i4 = this.abq;
        g gVar = this.abo;
        if (i != this.mode) {
            i3 = d.abi[this.mode][i];
            int i5 = SupportMenu.USER_MASK & i3;
            i3 >>= 16;
            gVar = gVar.I(i5, i3);
            i4 += i3;
        }
        i3 = i == 2 ? 4 : 5;
        return new f(gVar.I(i2, i3), i, 0, i4 + i3);
    }

    f H(int i, int i2) {
        g gVar = this.abo;
        int i3 = this.mode == 2 ? 4 : 5;
        return new f(gVar.I(d.abk[this.mode][i], i3).I(i2, 5), this.mode, 0, (this.abq + i3) + 5);
    }

    f bP(int i) {
        int i2;
        g gVar = this.abo;
        int i3 = this.mode;
        int i4 = this.abq;
        if (this.mode == 4 || this.mode == 2) {
            i3 = d.abi[i3][0];
            i2 = SupportMenu.USER_MASK & i3;
            i3 >>= 16;
            gVar = gVar.I(i2, i3);
            i4 += i3;
            i3 = 0;
        }
        i2 = (this.abp == 0 || this.abp == 31) ? 18 : this.abp == 62 ? 9 : 8;
        f fVar = new f(gVar, i3, this.abp + 1, i4 + i2);
        return fVar.abp == 2078 ? fVar.bQ(i + 1) : fVar;
    }

    f bQ(int i) {
        if (this.abp == 0) {
            return this;
        }
        return new f(this.abo.J(i - this.abp, this.abp), this.mode, 0, this.abq);
    }

    boolean a(f fVar) {
        int i = this.abq + (d.abi[this.mode][fVar.mode] >> 16);
        if (fVar.abp > 0 && (this.abp == 0 || this.abp > fVar.abp)) {
            i += 10;
        }
        return i <= fVar.abq;
    }

    a o(byte[] bArr) {
        Deque<g> linkedList = new LinkedList();
        for (g gVar = bQ(bArr.length).abo; gVar != null; gVar = gVar.yy()) {
            linkedList.addFirst(gVar);
        }
        a aVar = new a();
        for (g a : linkedList) {
            a.a(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{d.abh[this.mode], Integer.valueOf(this.abq), Integer.valueOf(this.abp)});
    }
}
