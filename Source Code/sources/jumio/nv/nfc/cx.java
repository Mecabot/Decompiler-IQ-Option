package jumio.nv.nfc;

/* compiled from: DataBlkInt */
public class cx extends cv {
    public int[] h;

    public final int a() {
        return 3;
    }

    public cx(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = 0;
        this.f = i3;
        this.h = new int[(i3 * i4)];
    }

    public final Object b() {
        return this.h;
    }

    public final int[] c() {
        return this.h;
    }

    public final void a(Object obj) {
        this.h = (int[]) obj;
    }
}
