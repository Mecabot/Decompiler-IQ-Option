package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ByteString */
public abstract class d implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final d eNx = new m(new byte[0]);

    /* compiled from: ByteString */
    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    /* compiled from: ByteString */
    public static final class b extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private final int NW;
        private byte[] buffer;
        private int eNA;
        private final ArrayList<d> eNy;
        private int eNz;

        b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.NW = i;
            this.eNy = new ArrayList();
            this.buffer = new byte[i];
        }

        public synchronized void write(int i) {
            if (this.eNA == this.buffer.length) {
                ls(1);
            }
            byte[] bArr = this.buffer;
            int i2 = this.eNA;
            this.eNA = i2 + 1;
            bArr[i2] = (byte) i;
        }

        public synchronized void write(byte[] bArr, int i, int i2) {
            if (i2 <= this.buffer.length - this.eNA) {
                System.arraycopy(bArr, i, this.buffer, this.eNA, i2);
                this.eNA += i2;
            } else {
                int length = this.buffer.length - this.eNA;
                System.arraycopy(bArr, i, this.buffer, this.eNA, length);
                i += length;
                i2 -= length;
                ls(i2);
                System.arraycopy(bArr, i, this.buffer, 0, i2);
                this.eNA = i2;
            }
        }

        public synchronized d buc() {
            bud();
            return d.af(this.eNy);
        }

        private byte[] n(byte[] bArr, int i) {
            Object obj = new byte[i];
            System.arraycopy(bArr, 0, obj, 0, Math.min(bArr.length, i));
            return obj;
        }

        public synchronized int size() {
            return this.eNz + this.eNA;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        private void ls(int i) {
            this.eNy.add(new m(this.buffer));
            this.eNz += this.buffer.length;
            this.buffer = new byte[Math.max(this.NW, Math.max(i, this.eNz >>> 1))];
            this.eNA = 0;
        }

        private void bud() {
            if (this.eNA >= this.buffer.length) {
                this.eNy.add(new m(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (this.eNA > 0) {
                this.eNy.add(new m(n(this.buffer, this.eNA)));
            }
            this.eNz += this.eNA;
            this.eNA = 0;
        }
    }

    protected abstract int C(int i, int i2, int i3);

    protected abstract int D(int i, int i2, int i3);

    abstract void b(OutputStream outputStream, int i, int i2);

    protected abstract void b(byte[] bArr, int i, int i2, int i3);

    /* renamed from: btU */
    public abstract a iterator();

    public abstract boolean btW();

    public abstract e btX();

    protected abstract int btZ();

    protected abstract boolean bua();

    protected abstract int bub();

    public abstract int size();

    public abstract String toString(String str);

    d() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static d l(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new m(obj);
    }

    public static d ae(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static d mI(String str) {
        try {
            return new m(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public d a(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return r.a(this, dVar);
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("ByteString would be too long: ");
        stringBuilder.append(size);
        stringBuilder.append("+");
        stringBuilder.append(size2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static d af(Iterable<d> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            for (d add : iterable) {
                collection.add(add);
            }
        }
        if (collection.isEmpty()) {
            return eNx;
        }
        return d(collection.iterator(), collection.size());
    }

    private static d d(Iterator<d> it, int i) {
        if (i == 1) {
            return (d) it.next();
        }
        int i2 = i >>> 1;
        return d(it, i2).a(d(it, i - i2));
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        StringBuilder stringBuilder;
        if (i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder(30);
            stringBuilder2.append("Source offset < 0: ");
            stringBuilder2.append(i);
            throw new IndexOutOfBoundsException(stringBuilder2.toString());
        } else if (i2 < 0) {
            stringBuilder = new StringBuilder(30);
            stringBuilder.append("Target offset < 0: ");
            stringBuilder.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i3 < 0) {
            stringBuilder = new StringBuilder(23);
            stringBuilder.append("Length < 0: ");
            stringBuilder.append(i3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else {
            int i4 = i + i3;
            if (i4 > size()) {
                stringBuilder = new StringBuilder(34);
                stringBuilder.append("Source end offset < 0: ");
                stringBuilder.append(i4);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            i4 = i2 + i3;
            if (i4 > bArr.length) {
                stringBuilder = new StringBuilder(34);
                stringBuilder.append("Target end offset < 0: ");
                stringBuilder.append(i4);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            } else if (i3 > 0) {
                b(bArr, i, i2, i3);
            }
        }
    }

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return h.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        b(bArr, 0, 0, size);
        return bArr;
    }

    void a(OutputStream outputStream, int i, int i2) {
        StringBuilder stringBuilder;
        if (i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder(30);
            stringBuilder2.append("Source offset < 0: ");
            stringBuilder2.append(i);
            throw new IndexOutOfBoundsException(stringBuilder2.toString());
        } else if (i2 < 0) {
            stringBuilder = new StringBuilder(23);
            stringBuilder.append("Length < 0: ");
            stringBuilder.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else {
            int i3 = i + i2;
            if (i3 > size()) {
                stringBuilder = new StringBuilder(39);
                stringBuilder.append("Source end offset exceeded: ");
                stringBuilder.append(i3);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            } else if (i2 > 0) {
                b(outputStream, i, i2);
            }
        }
    }

    public String btV() {
        try {
            return toString("UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b btY() {
        return new b(128);
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
