package jumio.nv.nfc;

/* compiled from: LookUpTableFPGamma */
public class ay extends ax {
    private static final String f = System.getProperty("line.separator");
    double e = -1.0d;

    public ay(be beVar, int i) {
        super(beVar, i);
        int i2 = 0;
        this.e = be.b(beVar.c(0));
        while (i2 < i) {
            this.d[i2] = (float) Math.pow(((double) i2) / ((double) (i - 1)), this.e);
            i2++;
        }
    }
}
