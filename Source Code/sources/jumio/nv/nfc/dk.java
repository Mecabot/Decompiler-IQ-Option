package jumio.nv.nfc;

/* compiled from: Dequantizer */
public abstract class dk extends ef implements dy {
    private static final String[][] f = ((String[][]) null);
    protected dj a;
    protected int[] b = null;
    protected int[] c = null;
    private ct g;
    private em h;

    public dk(dj djVar, int[] iArr, cg cgVar) {
        super(djVar);
        if (iArr.length != djVar.c()) {
            throw new IllegalArgumentException();
        }
        this.a = djVar;
        this.c = iArr;
        this.g = cgVar.k;
        this.h = cgVar.f;
    }

    public int g(int i) {
        return this.b[i];
    }

    public eg e(int i, int i2) {
        return this.a.e(i, i2);
    }

    public static String[][] a() {
        return f;
    }

    public void f(int i, int i2) {
        StringBuilder stringBuilder;
        this.a.f(i, i2);
        this.d = d();
        int i3 = 0;
        if (((Integer) this.g.d(this.d)).intValue() != 0) {
            int i4 = 0;
            while (i3 < (this.a.c() > 3 ? 3 : this.a.c())) {
                i4 += this.h.e(this.d, i3);
                i3++;
            }
            if (i4 == 3) {
                i3 = 1;
            } else if (i4 == 0) {
                i3 = 2;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wavelet transformation and component transformation not coherent in tile");
                stringBuilder.append(this.d);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        switch (i3) {
            case 0:
                this.b = this.c;
                return;
            case 1:
                this.b = db.a(this.c, 1, null);
                return;
            case 2:
                this.b = db.a(this.c, 2, null);
                return;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Non JPEG 2000 part I component transformation for tile: ");
                stringBuilder.append(this.d);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
