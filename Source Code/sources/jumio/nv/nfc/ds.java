package jumio.nv.nfc;

/* compiled from: MathUtil */
public class ds {
    public static int a(int i) {
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i);
            stringBuilder.append(" <= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i2 = -1;
        while (i > 0) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    public static final int a(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Cannot compute the GCD if one integer is negative.");
        }
        int i3;
        if (i > i2) {
            i3 = i2;
            i2 = i;
            i = i3;
        }
        if (i == 0) {
            return 0;
        }
        while (true) {
            i3 = i2;
            i2 = i;
            i = i3;
            if (i2 == 0) {
                return i;
            }
            i %= i2;
        }
    }
}
