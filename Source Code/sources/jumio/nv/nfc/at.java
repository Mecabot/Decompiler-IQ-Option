package jumio.nv.nfc;

/* compiled from: RestrictedICCProfile */
public abstract class at {
    protected static final String a = System.getProperty("line.separator");
    public be[] b;
    public bk[] c;

    public abstract int a();

    public static at b(be beVar, be beVar2, be beVar3, bk bkVar, bk bkVar2, bk bkVar3) {
        return ar.a(beVar, beVar2, beVar3, bkVar, bkVar2, bkVar3);
    }

    public static at b(be beVar) {
        return as.a(beVar);
    }

    protected at(be beVar) {
        this.b = new be[1];
        this.c = null;
        this.b[0] = beVar;
    }

    protected at(be beVar, be beVar2, be beVar3, bk bkVar, bk bkVar2, bk bkVar3) {
        this.b = new be[3];
        this.c = new bk[3];
        this.b[0] = beVar;
        this.b[1] = beVar2;
        this.b[2] = beVar3;
        this.c[0] = bkVar;
        this.c[1] = bkVar2;
        this.c[2] = bkVar3;
    }
}
