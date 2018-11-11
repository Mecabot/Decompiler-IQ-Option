package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* compiled from: DefaultPlacement */
public class e {
    private final CharSequence abM;
    private final int abN;
    private final int abO;
    private final byte[] abP;

    public e(CharSequence charSequence, int i, int i2) {
        this.abM = charSequence;
        this.abO = i;
        this.abN = i2;
        this.abP = new byte[(i * i2)];
        Arrays.fill(this.abP, (byte) -1);
    }

    public final boolean Q(int i, int i2) {
        return this.abP[(i2 * this.abO) + i] == (byte) 1;
    }

    private void b(int i, int i2, boolean z) {
        this.abP[(i2 * this.abO) + i] = (byte) z;
    }

    private boolean R(int i, int i2) {
        return this.abP[(i2 * this.abO) + i] >= (byte) 0;
    }

    public final void yI() {
        int i = 4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4;
            if (i == this.abN && r2 == 0) {
                i4 = i3 + 1;
                bY(i3);
                i3 = i4;
            }
            if (i == this.abN - 2 && r2 == 0 && this.abO % 4 != 0) {
                i4 = i3 + 1;
                bZ(i3);
                i3 = i4;
            }
            if (i == this.abN - 2 && r2 == 0 && this.abO % 8 == 4) {
                i4 = i3 + 1;
                ca(i3);
                i3 = i4;
            }
            if (i == this.abN + 4 && r2 == 2 && this.abO % 8 == 0) {
                i4 = i3 + 1;
                cb(i3);
                i3 = i4;
            }
            do {
                if (i < this.abN && i2 >= 0 && !R(i2, i)) {
                    i4 = i3 + 1;
                    j(i, i2, i3);
                    i3 = i4;
                }
                i -= 2;
                i2 += 2;
                if (i < 0) {
                    break;
                }
            } while (i2 < this.abO);
            i++;
            i2 += 3;
            do {
                if (i >= 0 && i2 < this.abO && !R(i2, i)) {
                    i4 = i3 + 1;
                    j(i, i2, i3);
                    i3 = i4;
                }
                i += 2;
                i2 -= 2;
                if (i >= this.abN) {
                    break;
                }
            } while (i2 >= 0);
            i += 3;
            i2++;
            if (i >= this.abN && i2 >= this.abO) {
                break;
            }
        }
        if (!R(this.abO - 1, this.abN - 1)) {
            b(this.abO - 1, this.abN - 1, true);
            b(this.abO - 2, this.abN - 2, true);
        }
    }

    private void d(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += this.abN;
            i2 += 4 - ((this.abN + 4) % 8);
        }
        if (i2 < 0) {
            i2 += this.abO;
            i += 4 - ((this.abO + 4) % 8);
        }
        boolean z = true;
        if ((this.abM.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        b(i2, i, z);
    }

    private void j(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        d(i4, i5, i3, 1);
        int i6 = i2 - 1;
        d(i4, i6, i3, 2);
        i4 = i - 1;
        d(i4, i5, i3, 3);
        d(i4, i6, i3, 4);
        d(i4, i2, i3, 5);
        d(i, i5, i3, 6);
        d(i, i6, i3, 7);
        d(i, i2, i3, 8);
    }

    private void bY(int i) {
        d(this.abN - 1, 0, i, 1);
        d(this.abN - 1, 1, i, 2);
        d(this.abN - 1, 2, i, 3);
        d(0, this.abO - 2, i, 4);
        d(0, this.abO - 1, i, 5);
        d(1, this.abO - 1, i, 6);
        d(2, this.abO - 1, i, 7);
        d(3, this.abO - 1, i, 8);
    }

    private void bZ(int i) {
        d(this.abN - 3, 0, i, 1);
        d(this.abN - 2, 0, i, 2);
        d(this.abN - 1, 0, i, 3);
        d(0, this.abO - 4, i, 4);
        d(0, this.abO - 3, i, 5);
        d(0, this.abO - 2, i, 6);
        d(0, this.abO - 1, i, 7);
        d(1, this.abO - 1, i, 8);
    }

    private void ca(int i) {
        d(this.abN - 3, 0, i, 1);
        d(this.abN - 2, 0, i, 2);
        d(this.abN - 1, 0, i, 3);
        d(0, this.abO - 2, i, 4);
        d(0, this.abO - 1, i, 5);
        d(1, this.abO - 1, i, 6);
        d(2, this.abO - 1, i, 7);
        d(3, this.abO - 1, i, 8);
    }

    private void cb(int i) {
        d(this.abN - 1, 0, i, 1);
        d(this.abN - 1, this.abO - 1, i, 2);
        d(0, this.abO - 3, i, 3);
        d(0, this.abO - 2, i, 4);
        d(0, this.abO - 1, i, 5);
        d(1, this.abO - 3, i, 6);
        d(1, this.abO - 2, i, 7);
        d(1, this.abO - 1, i, 8);
    }
}
