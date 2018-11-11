package com.google.zxing.common;

import java.util.Arrays;

/* compiled from: BitMatrix */
public final class b implements Cloneable {
    private final int[] abt;
    private final int abu;
    private final int height;
    private final int width;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        this.abu = (i + 31) / 32;
        this.abt = new int[(this.abu * i2)];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.abu = i3;
        this.abt = iArr;
    }

    public boolean L(int i, int i2) {
        return ((this.abt[(i2 * this.abu) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void set(int i, int i2) {
        i2 = (i2 * this.abu) + (i / 32);
        int[] iArr = this.abt;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void clear() {
        int length = this.abt.length;
        for (int i = 0; i < length; i++) {
            this.abt[i] = 0;
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            i3 += i;
            i4 += i2;
            if (i4 > this.height || i3 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i4) {
                int i5 = this.abu * i2;
                for (int i6 = i; i6 < i3; i6++) {
                    int[] iArr = this.abt;
                    int i7 = (i6 / 32) + i5;
                    iArr[i7] = iArr[i7] | (1 << (i6 & 31));
                }
                i2++;
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.width == bVar.width && this.height == bVar.height && this.abu == bVar.abu && Arrays.equals(this.abt, bVar.abt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.abu) * 31) + Arrays.hashCode(this.abt);
    }

    public String toString() {
        return T("X ", "  ");
    }

    public String T(String str, String str2) {
        return g(str, str2, "\n");
    }

    private String g(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                stringBuilder.append(L(i2, i) ? str : str2);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    /* renamed from: yB */
    public b clone() {
        return new b(this.width, this.height, this.abu, (int[]) this.abt.clone());
    }
}
