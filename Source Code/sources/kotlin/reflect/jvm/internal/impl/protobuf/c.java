package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

/* compiled from: BoundedByteString */
class c extends m {
    private final int eNu;
    private final int eNv;

    /* compiled from: BoundedByteString */
    private class a implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {
        private final int limit;
        private int position;

        private a() {
            this.position = c.this.btT();
            this.limit = this.position + c.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (this.position >= this.limit) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.bytes;
            int i = this.position;
            this.position = i + 1;
            return bArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    c(byte[] bArr, int i, int i2) {
        super(bArr);
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder(29);
            stringBuilder.append("Offset too small: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 < 0) {
            stringBuilder = new StringBuilder(29);
            stringBuilder.append("Length too small: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            StringBuilder stringBuilder2 = new StringBuilder(48);
            stringBuilder2.append("Offset+Length too large: ");
            stringBuilder2.append(i);
            stringBuilder2.append("+");
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            this.eNu = i;
            this.eNv = i2;
        }
    }

    public byte byteAt(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Index too small: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        } else if (i < size()) {
            return this.bytes[this.eNu + i];
        } else {
            int size = size();
            StringBuilder stringBuilder2 = new StringBuilder(41);
            stringBuilder2.append("Index too large: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(size);
            throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
        }
    }

    public int size() {
        return this.eNv;
    }

    protected int btT() {
        return this.eNu;
    }

    protected void b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, btT() + i, bArr, i2, i3);
    }

    /* renamed from: btU */
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a iterator() {
        return new a();
    }
}
