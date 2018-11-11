package jumio.nv.nfc;

/* compiled from: CBlkInfo */
public class bz {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int[] f;
    public int[] g;
    public int[] h;
    public int i;
    public int[][] j;
    public int[] k;

    public bz(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.g = new int[i5];
        this.f = new int[i5];
        this.h = new int[i5];
        this.j = new int[i5][];
        this.k = new int[i5];
        for (i5--; i5 >= 0; i5--) {
            this.k[i5] = -1;
        }
    }

    public void a(int i, int i2) {
        this.h[i] = i2;
        i2 = 0;
        this.i = 0;
        while (i2 <= i) {
            this.i += this.h[i2];
            i2++;
        }
    }
}
