package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.NoSuchElementException;

/* compiled from: LiteralByteString */
class m extends d {
    protected final byte[] bytes;
    private int hash = 0;

    /* compiled from: LiteralByteString */
    private class a implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {
        private final int limit;
        private int position;

        private a() {
            this.position = 0;
            this.limit = m.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            try {
                byte[] bArr = m.this.bytes;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected int btT() {
        return 0;
    }

    protected int btZ() {
        return 0;
    }

    protected boolean bua() {
        return true;
    }

    m(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte byteAt(int i) {
        return this.bytes[i];
    }

    public int size() {
        return this.bytes.length;
    }

    protected void b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    void b(OutputStream outputStream, int i, int i2) {
        outputStream.write(this.bytes, btT() + i, i2);
    }

    public String toString(String str) {
        return new String(this.bytes, btT(), size(), str);
    }

    public boolean btW() {
        int btT = btT();
        return u.n(this.bytes, btT, size() + btT);
    }

    protected int C(int i, int i2, int i3) {
        int btT = btT() + i2;
        return u.f(i, this.bytes, btT, i3 + btT);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof m) {
            return a((m) obj, 0, size());
        }
        if (obj instanceof r) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(String.valueOf(obj.getClass()));
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + 49);
        stringBuilder.append("Has a new type of ByteString been created? Found ");
        stringBuilder.append(valueOf);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    boolean a(m mVar, int i, int i2) {
        int size;
        if (i2 > mVar.size()) {
            i = size();
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i + i2 > mVar.size()) {
            size = mVar.size();
            StringBuilder stringBuilder2 = new StringBuilder(59);
            stringBuilder2.append("Ran off end of other: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(i2);
            stringBuilder2.append(", ");
            stringBuilder2.append(size);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            byte[] bArr = this.bytes;
            byte[] bArr2 = mVar.bytes;
            int btT = btT() + i2;
            i2 = btT();
            size = mVar.btT() + i;
            while (i2 < btT) {
                if (bArr[i2] != bArr2[size]) {
                    return false;
                }
                i2++;
                size++;
            }
            return true;
        }
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            i = size();
            i = D(i, 0, i);
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
        return e(i, this.bytes, btT() + i2, i3);
    }

    static int e(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    public e btX() {
        return e.a(this);
    }

    /* renamed from: btU */
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a iterator() {
        return new a();
    }
}
