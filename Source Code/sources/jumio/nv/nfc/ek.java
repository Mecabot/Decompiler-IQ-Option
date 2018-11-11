package jumio.nv.nfc;

/* compiled from: SynWTFilterInt */
public abstract class ek extends eh {
    public int a() {
        return 3;
    }

    public abstract void a(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8);

    public abstract void b(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8);

    public void a(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        a((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, i6, (int[]) obj3, i7, i8);
    }

    public void b(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        b((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, i6, (int[]) obj3, i7, i8);
    }
}
