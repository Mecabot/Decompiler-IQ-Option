package jumio.nv.nfc;

/* compiled from: PrecInfo */
public class bx {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public bt[][][] j;
    public int[] k;

    public bx(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.i = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.a = i6;
        this.b = i7;
        this.c = i8;
        this.d = i9;
        if (i == 0) {
            this.j = new bt[1][][];
            this.k = new int[1];
            return;
        }
        this.j = new bt[4][][];
        this.k = new int[4];
    }
}
