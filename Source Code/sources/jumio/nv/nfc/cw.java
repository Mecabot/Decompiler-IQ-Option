package jumio.nv.nfc;

/* compiled from: DataBlkFloat */
public class cw extends cv {
    public float[] h;

    public final int a() {
        return 4;
    }

    public cw(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = 0;
        this.f = i3;
        this.h = new float[(i3 * i4)];
    }

    public final Object b() {
        return this.h;
    }

    public final float[] c() {
        return this.h;
    }

    public final void a(Object obj) {
        this.h = (float[]) obj;
    }
}
