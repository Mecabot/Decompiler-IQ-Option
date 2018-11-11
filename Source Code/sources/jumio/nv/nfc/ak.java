package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;

/* compiled from: PaletteBox */
public final class ak extends aj {
    private int a;
    private int b;
    private short[] c;
    private int[][] d;

    static {
        i = 1885564018;
    }

    public ak(df dfVar, int i) {
        super(dfVar, i);
        a();
    }

    void a() {
        int i;
        byte[] bArr = new byte[4];
        this.k.a(this.n);
        this.k.a(bArr, 0, 3);
        this.a = an.d(bArr, 0) & SupportMenu.USER_MASK;
        this.b = bArr[2] & SupportMenu.USER_MASK;
        this.c = new short[this.b];
        bArr = new byte[this.b];
        this.k.a(bArr, 0, this.b);
        for (i = 0; i < this.b; i++) {
            this.c[i] = (short) (bArr[i] & 4095);
        }
        this.d = new int[(this.a * this.b)][];
        bArr = new byte[2];
        for (i = 0; i < this.a; i++) {
            this.d[i] = new int[this.b];
            for (int i2 = 0; i2 < this.b; i2++) {
                int i3;
                short b = b(i2);
                boolean a = a(i2);
                switch (c(i2)) {
                    case 1:
                        this.k.a(bArr, 0, 1);
                        i3 = bArr[0];
                        break;
                    case 2:
                        this.k.a(bArr, 0, 2);
                        i3 = an.d(bArr, 0);
                        break;
                    default:
                        throw new z("palettes greater than 16 bits deep not supported");
                }
                if (!a) {
                    this.d[i][i2] = ((1 << b) - 1) & i3;
                } else if (((1 << (b - 1)) & i3) == 0) {
                    this.d[i][i2] = ((1 << b) - 1) & i3;
                } else {
                    this.d[i][i2] = (-1 << b) | i3;
                }
            }
        }
    }

    public int b() {
        return this.b;
    }

    public boolean a(int i) {
        return (this.c[i] & 128) != 0;
    }

    public short b(int i) {
        return (short) ((this.c[i] & 127) + 1);
    }

    public int a(int i, int i2) {
        return this.d[i2][i];
    }

    private int c(int i) {
        short b = b(i);
        return (b / 8) + (b % 8) == 0 ? 0 : 1;
    }
}
