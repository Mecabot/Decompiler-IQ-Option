package com.neovisionaries.ws.client;

import java.nio.ByteBuffer;

/* compiled from: ByteArray */
class c {
    private ByteBuffer dZv;
    private int mLength = 0;

    public c(int i) {
        this.dZv = ByteBuffer.allocate(i);
    }

    public int length() {
        return this.mLength;
    }

    public byte get(int i) {
        if (i >= 0 && this.mLength > i) {
            return this.dZv.get(i);
        }
        throw new IndexOutOfBoundsException(String.format("Bad index: index=%d, length=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mLength)}));
    }

    private void ib(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        int position = this.dZv.position();
        this.dZv.position(0);
        allocate.put(this.dZv);
        allocate.position(position);
        this.dZv = allocate;
    }

    public void ic(int i) {
        if (this.dZv.capacity() < this.mLength + 1) {
            ib(this.mLength + 1024);
        }
        this.dZv.put((byte) i);
        this.mLength++;
    }

    public void s(byte[] bArr) {
        if (this.dZv.capacity() < this.mLength + bArr.length) {
            ib((this.mLength + bArr.length) + 1024);
        }
        this.dZv.put(bArr);
        this.mLength += bArr.length;
    }

    public void g(byte[] bArr, int i, int i2) {
        if (this.dZv.capacity() < this.mLength + i2) {
            ib((this.mLength + i2) + 1024);
        }
        this.dZv.put(bArr, i, i2);
        this.mLength += i2;
    }

    public void a(c cVar, int i, int i2) {
        g(cVar.dZv.array(), i, i2);
    }

    public byte[] id(int i) {
        return aH(i, length());
    }

    public byte[] aH(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0 || i < 0 || this.mLength < i2) {
            throw new IllegalArgumentException(String.format("Bad range: beginIndex=%d, endIndex=%d, length=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.mLength)}));
        }
        Object obj = new byte[i3];
        if (i3 != 0) {
            System.arraycopy(this.dZv.array(), i, obj, 0, i3);
        }
        return obj;
    }

    public void clear() {
        this.dZv.clear();
        this.dZv.position(0);
        this.mLength = 0;
    }

    public void ie(int i) {
        if (this.dZv.capacity() > i) {
            byte[] aH = aH(this.mLength - i, this.mLength);
            this.dZv = ByteBuffer.wrap(aH);
            this.dZv.position(aH.length);
            this.mLength = aH.length;
        }
    }

    public boolean getBit(int i) {
        return ((1 << (i % 8)) & get(i / 8)) != 0;
    }

    public int aI(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            if (getBit(i + i3)) {
                i4 += i5;
            }
            i3++;
            i5 *= 2;
        }
        return i4;
    }

    public int aJ(int i, int i2) {
        int i3 = 1;
        i2--;
        int i4 = 0;
        while (i2 >= 0) {
            if (getBit(i + i2)) {
                i4 += i3;
            }
            i2--;
            i3 *= 2;
        }
        return i4;
    }

    public boolean o(int[] iArr) {
        boolean bit = getBit(iArr[0]);
        iArr[0] = iArr[0] + 1;
        return bit;
    }

    public int c(int[] iArr, int i) {
        int aI = aI(iArr[0], i);
        iArr[0] = iArr[0] + i;
        return aI;
    }

    public void w(int i, boolean z) {
        int i2 = i / 8;
        i %= 8;
        byte b = get(i2);
        this.dZv.put(i2, (byte) (z ? (1 << i) | b : ((1 << i) ^ -1) & b));
    }

    public void if(int i) {
        w(i, false);
    }
}
