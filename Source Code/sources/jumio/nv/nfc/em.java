package jumio.nv.nfc;

/* compiled from: SynWTFilterSpec */
public class em extends br {
    public em(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public eh[] c(int i, int i2) {
        return ((eh[][]) b(i, i2))[0];
    }

    public eh[] d(int i, int i2) {
        return ((eh[][]) b(i, i2))[1];
    }

    public boolean e(int i, int i2) {
        eh[] c = c(i, i2);
        eh[] d = d(i, i2);
        i2 = c.length - 1;
        while (i2 >= 0) {
            if (!c[i2].b() || !d[i2].b()) {
                return false;
            }
            i2--;
        }
        return true;
    }
}
