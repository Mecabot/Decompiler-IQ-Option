package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/* compiled from: RopeByteString */
class r extends d {
    private static final int[] eOq;
    private final int eOr;
    private final d eOs;
    private final d eOt;
    private final int eOu;
    private final int eOv;
    private int hash;

    /* compiled from: RopeByteString */
    private static class a {
        private final Stack<d> eOw;

        private a() {
            this.eOw = new Stack();
        }

        private d c(d dVar, d dVar2) {
            h(dVar);
            h(dVar2);
            dVar = (d) this.eOw.pop();
            while (!this.eOw.isEmpty()) {
                dVar = new r((d) this.eOw.pop(), dVar);
            }
            return dVar;
        }

        private void h(d dVar) {
            if (dVar.bua()) {
                i(dVar);
            } else if (dVar instanceof r) {
                r rVar = (r) dVar;
                h(rVar.eOs);
                h(rVar.eOt);
            } else {
                String valueOf = String.valueOf(String.valueOf(dVar.getClass()));
                StringBuilder stringBuilder = new StringBuilder(valueOf.length() + 49);
                stringBuilder.append("Has a new type of ByteString been created? Found ");
                stringBuilder.append(valueOf);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        private void i(d dVar) {
            int lK = lK(dVar.size());
            int i = r.eOq[lK + 1];
            if (this.eOw.isEmpty() || ((d) this.eOw.peek()).size() >= i) {
                this.eOw.push(dVar);
                return;
            }
            lK = r.eOq[lK];
            d dVar2 = (d) this.eOw.pop();
            while (!this.eOw.isEmpty() && ((d) this.eOw.peek()).size() < lK) {
                dVar2 = new r((d) this.eOw.pop(), dVar2);
            }
            d rVar = new r(dVar2, dVar);
            while (!this.eOw.isEmpty()) {
                if (((d) this.eOw.peek()).size() >= r.eOq[lK(rVar.size()) + 1]) {
                    break;
                }
                rVar = new r((d) this.eOw.pop(), rVar);
            }
            this.eOw.push(rVar);
        }

        private int lK(int i) {
            i = Arrays.binarySearch(r.eOq, i);
            return i < 0 ? (-(i + 1)) - 1 : i;
        }
    }

    /* compiled from: RopeByteString */
    private static class b implements Iterator<m> {
        private final Stack<r> eOx;
        private m eOy;

        private b(d dVar) {
            this.eOx = new Stack();
            this.eOy = j(dVar);
        }

        private m j(d dVar) {
            while (dVar instanceof r) {
                r rVar = (r) dVar;
                this.eOx.push(rVar);
                dVar = rVar.eOs;
            }
            return (m) dVar;
        }

        private m bvk() {
            while (!this.eOx.isEmpty()) {
                m j = j(((r) this.eOx.pop()).eOt);
                if (!j.isEmpty()) {
                    return j;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.eOy != null;
        }

        /* renamed from: bvl */
        public m next() {
            if (this.eOy == null) {
                throw new NoSuchElementException();
            }
            m mVar = this.eOy;
            this.eOy = bvk();
            return mVar;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: RopeByteString */
    private class d extends InputStream {
        private b eOD;
        private m eOE;
        private int eOF;
        private int eOG;
        private int eOH;
        private int mark;

        public boolean markSupported() {
            return true;
        }

        public d() {
            initialize();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return m(bArr, i, i2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) m(null, 0, (int) j);
        }

        private int m(byte[] bArr, int i, int i2) {
            int i3 = i;
            i = i2;
            while (i > 0) {
                bvm();
                if (this.eOE == null) {
                    if (i == i2) {
                        return -1;
                    }
                    return i2 - i;
                }
                int min = Math.min(this.eOF - this.eOG, i);
                if (bArr != null) {
                    this.eOE.a(bArr, this.eOG, i3, min);
                    i3 += min;
                }
                this.eOG += min;
                i -= min;
            }
            return i2 - i;
        }

        public int read() {
            bvm();
            if (this.eOE == null) {
                return -1;
            }
            m mVar = this.eOE;
            int i = this.eOG;
            this.eOG = i + 1;
            return mVar.byteAt(i) & 255;
        }

        public int available() {
            return r.this.size() - (this.eOH + this.eOG);
        }

        public void mark(int i) {
            this.mark = this.eOH + this.eOG;
        }

        public synchronized void reset() {
            initialize();
            m(null, 0, this.mark);
        }

        private void initialize() {
            this.eOD = new b(r.this);
            this.eOE = this.eOD.next();
            this.eOF = this.eOE.size();
            this.eOG = 0;
            this.eOH = 0;
        }

        private void bvm() {
            if (this.eOE != null && this.eOG == this.eOF) {
                this.eOH += this.eOF;
                this.eOG = 0;
                if (this.eOD.hasNext()) {
                    this.eOE = this.eOD.next();
                    this.eOF = this.eOE.size();
                    return;
                }
                this.eOE = null;
                this.eOF = 0;
            }
        }
    }

    /* compiled from: RopeByteString */
    private class c implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {
        private kotlin.reflect.jvm.internal.impl.protobuf.d.a eOA;
        int eOB;
        private final b eOz;

        private c() {
            this.eOz = new b(r.this);
            this.eOA = this.eOz.next().iterator();
            this.eOB = r.this.size();
        }

        public boolean hasNext() {
            return this.eOB > 0;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (!this.eOA.hasNext()) {
                this.eOA = this.eOz.next().iterator();
            }
            this.eOB--;
            return this.eOA.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        List arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        eOq = new int[arrayList.size()];
        for (i = 0; i < eOq.length; i++) {
            eOq[i] = ((Integer) arrayList.get(i)).intValue();
        }
    }

    private r(d dVar, d dVar2) {
        this.hash = 0;
        this.eOs = dVar;
        this.eOt = dVar2;
        this.eOu = dVar.size();
        this.eOr = this.eOu + dVar2.size();
        this.eOv = Math.max(dVar.btZ(), dVar2.btZ()) + 1;
    }

    static d a(d dVar, d dVar2) {
        r rVar = dVar instanceof r ? (r) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return b(dVar, dVar2);
            }
            if (rVar != null && rVar.eOt.size() + dVar2.size() < 128) {
                dVar2 = new r(rVar.eOs, b(rVar.eOt, dVar2));
            } else if (rVar == null || rVar.eOs.btZ() <= rVar.eOt.btZ() || rVar.btZ() <= dVar2.btZ()) {
                if (size >= eOq[Math.max(dVar.btZ(), dVar2.btZ()) + 1]) {
                    return new r(dVar, dVar2);
                }
                return new a().c(dVar, dVar2);
            } else {
                dVar2 = new r(rVar.eOs, new r(rVar.eOt, dVar2));
            }
        }
        return dVar2;
    }

    private static m b(d dVar, d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[(size + size2)];
        dVar.a(bArr, 0, 0, size);
        dVar2.a(bArr, 0, size, size2);
        return new m(bArr);
    }

    public int size() {
        return this.eOr;
    }

    protected int btZ() {
        return this.eOv;
    }

    protected boolean bua() {
        return this.eOr >= eOq[this.eOv];
    }

    protected void b(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.eOu) {
            this.eOs.b(bArr, i, i2, i3);
        } else if (i >= this.eOu) {
            this.eOt.b(bArr, i - this.eOu, i2, i3);
        } else {
            int i4 = this.eOu - i;
            this.eOs.b(bArr, i, i2, i4);
            this.eOt.b(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    void b(OutputStream outputStream, int i, int i2) {
        if (i + i2 <= this.eOu) {
            this.eOs.b(outputStream, i, i2);
        } else if (i >= this.eOu) {
            this.eOt.b(outputStream, i - this.eOu, i2);
        } else {
            int i3 = this.eOu - i;
            this.eOs.b(outputStream, i, i3);
            this.eOt.b(outputStream, 0, i2 - i3);
        }
    }

    public String toString(String str) {
        return new String(toByteArray(), str);
    }

    public boolean btW() {
        if (this.eOt.C(this.eOs.C(0, 0, this.eOu), 0, this.eOt.size()) == 0) {
            return true;
        }
        return false;
    }

    protected int C(int i, int i2, int i3) {
        if (i2 + i3 <= this.eOu) {
            return this.eOs.C(i, i2, i3);
        }
        if (i2 >= this.eOu) {
            return this.eOt.C(i, i2 - this.eOu, i3);
        }
        int i4 = this.eOu - i2;
        return this.eOt.C(this.eOs.C(i, i2, i4), 0, i3 - i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.eOr != dVar.size()) {
            return false;
        }
        if (this.eOr == 0) {
            return true;
        }
        if (this.hash != 0) {
            int bub = dVar.bub();
            if (!(bub == 0 || this.hash == bub)) {
                return false;
            }
        }
        return g(dVar);
    }

    private boolean g(d dVar) {
        Iterator bVar = new b(this);
        m mVar = (m) bVar.next();
        Iterator bVar2 = new b(dVar);
        m mVar2 = (m) bVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = mVar.size() - i;
            int size2 = mVar2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? mVar.a(mVar2, i2, min) : mVar2.a(mVar, i, min))) {
                return false;
            }
            i3 += min;
            if (i3 < this.eOr) {
                if (min == size) {
                    mVar = (m) bVar.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    mVar2 = (m) bVar2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == this.eOr) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            i = D(this.eOr, 0, this.eOr);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    protected int bub() {
        return this.hash;
    }

    protected int D(int i, int i2, int i3) {
        if (i2 + i3 <= this.eOu) {
            return this.eOs.D(i, i2, i3);
        }
        if (i2 >= this.eOu) {
            return this.eOt.D(i, i2 - this.eOu, i3);
        }
        int i4 = this.eOu - i2;
        return this.eOt.D(this.eOs.D(i, i2, i4), 0, i3 - i4);
    }

    public e btX() {
        return e.m(new d());
    }

    /* renamed from: btU */
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a iterator() {
        return new c();
    }
}
