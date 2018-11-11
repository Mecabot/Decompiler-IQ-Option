package jumio.nv.nfc;

/* compiled from: IntegerSpec */
public class bq extends br {
    protected static int a = Integer.MAX_VALUE;

    public bq(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public int a() {
        int intValue = ((Integer) this.f).intValue();
        int i = 0;
        while (i < this.c) {
            int i2 = intValue;
            for (intValue = 0; intValue < this.d; intValue++) {
                int intValue2 = ((Integer) b(i, intValue)).intValue();
                if (i2 > intValue2) {
                    i2 = intValue2;
                }
            }
            i++;
            intValue = i2;
        }
        return intValue;
    }

    public int a(int i) {
        int i2 = a;
        for (int i3 = 0; i3 < this.c; i3++) {
            int intValue = ((Integer) b(i3, i)).intValue();
            if (i2 > intValue) {
                i2 = intValue;
            }
        }
        return i2;
    }

    public int b(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.d; i3++) {
            int intValue = ((Integer) b(i, i3)).intValue();
            if (i2 < intValue) {
                i2 = intValue;
            }
        }
        return i2;
    }
}
