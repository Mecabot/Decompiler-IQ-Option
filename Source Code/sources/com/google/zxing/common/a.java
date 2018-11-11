package com.google.zxing.common;

import java.util.Arrays;

/* compiled from: BitArray */
public final class a implements Cloneable {
    private int[] abt;
    private int size;

    public a() {
        this.size = 0;
        this.abt = new int[1];
    }

    a(int[] iArr, int i) {
        this.abt = iArr;
        this.size = i;
    }

    public int getSize() {
        return this.size;
    }

    public int yz() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i) {
        if (i > (this.abt.length << 5)) {
            Object bR = bR(i);
            System.arraycopy(this.abt, 0, bR, 0, this.abt.length);
            this.abt = bR;
        }
    }

    public boolean get(int i) {
        return ((1 << (i & 31)) & this.abt[i / 32]) != 0;
    }

    public void ao(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.abt;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
    }

    public void K(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            ao(z);
            i2--;
        }
    }

    public void a(a aVar) {
        int i = aVar.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            ao(aVar.get(i2));
        }
    }

    public void b(a aVar) {
        if (this.size != aVar.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.abt.length; i++) {
            int[] iArr = this.abt;
            iArr[i] = iArr[i] ^ aVar.abt[i];
        }
    }

    public void b(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        i = 0;
        while (i < i3) {
            int i5 = i4;
            int i6 = 0;
            for (i4 = 0; i4 < 8; i4++) {
                if (get(i5)) {
                    i6 |= 1 << (7 - i4);
                }
                i5++;
            }
            bArr[i2 + i] = (byte) i6;
            i++;
            i4 = i5;
        }
    }

    private static int[] bR(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.size == aVar.size && Arrays.equals(this.abt, aVar.abt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.abt);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }

    /* renamed from: yA */
    public a clone() {
        return new a((int[]) this.abt.clone(), this.size);
    }
}
