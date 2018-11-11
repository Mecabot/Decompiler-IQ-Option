package jumio.nv.nfc;

/* compiled from: LookUpTableFP */
public abstract class ax extends au {
    public final float[] d;

    public static ax a(be beVar, int i) {
        if (beVar.c == 1) {
            return new ay(beVar, i);
        }
        return new az(beVar, i);
    }

    protected ax(be beVar, int i) {
        super(beVar, i);
        this.d = new float[i];
    }
}
