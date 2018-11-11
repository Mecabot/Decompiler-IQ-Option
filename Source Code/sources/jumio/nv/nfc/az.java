package jumio.nv.nfc;

/* compiled from: LookUpTableFPInterp */
public class az extends ax {
    public az(be beVar, int i) {
        super(beVar, i);
        double d = ((double) (beVar.c - 1)) / ((double) (i - 1));
        for (int i2 = 0; i2 < i; i2++) {
            double d2 = ((double) i2) * d;
            double floor = Math.floor(d2);
            int i3 = (int) floor;
            int ceil = (int) Math.ceil(d2);
            if (i3 == ceil) {
                this.d[i2] = (float) be.a(beVar.c(i3));
            } else {
                double a = be.a(beVar.c(i3));
                this.d[i2] = (float) (a + ((be.a(beVar.c(ceil)) - a) * (d2 - floor)));
            }
        }
    }
}
