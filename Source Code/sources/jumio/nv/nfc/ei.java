package jumio.nv.nfc;

/* compiled from: SynWTFilterFloat */
public abstract class ei extends eh {
    public int a() {
        return 4;
    }

    public abstract void a(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8);

    public abstract void b(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8);

    public void a(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        a((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, i6, (float[]) obj3, i7, i8);
    }

    public void b(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        b((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, i6, (float[]) obj3, i7, i8);
    }
}
