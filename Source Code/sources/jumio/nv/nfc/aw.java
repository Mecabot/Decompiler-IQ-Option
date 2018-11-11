package jumio.nv.nfc;

/* compiled from: LookUpTable32LinearSRGBtoSRGB */
public class aw extends av {
    public static aw a(int i, int i2, double d, double d2, double d3, double d4, double d5) {
        return new aw(i, i2, d, d2, d3, d4, d5);
    }

    protected aw(int i, int i2, double d, double d2, double d3, double d4, double d5) {
        int i3 = i;
        int i4 = i2;
        aw avVar = new av(i3 + 1, i4);
        double d6 = (double) i3;
        double d7 = 1.0d / d6;
        int floor = (int) Math.floor(d6 * d);
        double d8 = (double) i4;
        double d9 = d2 * d8;
        i4 = (i4 + 1) / 2;
        int i5 = 0;
        while (i5 <= floor) {
            avVar.e[i5] = (int) (Math.floor(((((double) i5) * d7) * d9) + 0.5d) - ((double) i4));
            i5++;
        }
        d9 = d3 * d8;
        d8 *= d5;
        while (i5 <= i3) {
            avVar.e[i5] = (int) (Math.floor(((Math.pow(((double) i5) * d7, d4) * d9) - d8) + 0.5d) - ((double) i4));
            i5++;
            double d10 = 0.5d;
            avVar = this;
            i3 = i;
        }
    }
}
