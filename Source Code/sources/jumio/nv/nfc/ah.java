package jumio.nv.nfc;

import java.util.Vector;

/* compiled from: ComponentMappingBox */
public final class ah extends aj {
    private int a;
    private Vector b = new Vector();

    static {
        i = 1668112752;
    }

    public ah(df dfVar, int i) {
        super(dfVar, i);
        a();
    }

    void a() {
        this.a = (this.m - this.n) / 4;
        this.k.a(this.n);
        for (int i = this.n; i < this.m; i += 4) {
            Object obj = new byte[4];
            this.k.a(obj, 0, 4);
            this.b.addElement(obj);
        }
    }
}
