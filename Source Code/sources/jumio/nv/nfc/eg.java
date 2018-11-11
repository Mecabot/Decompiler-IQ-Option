package jumio.nv.nfc;

/* compiled from: SubbandSyn */
public class eg extends dv {
    public eh p;
    public eh q;
    public int r = 0;
    private eg s;
    private eg t;
    private eg u;
    private eg v;
    private eg w;

    public eg(int i, int i2, int i3, int i4, int i5, dw[] dwVarArr, dw[] dwVarArr2) {
        super(i, i2, i3, i4, i5, dwVarArr, dwVarArr2);
    }

    public dv a() {
        return this.s;
    }

    public dv b() {
        return this.t;
    }

    public dv c() {
        return this.u;
    }

    public dv d() {
        return this.v;
    }

    public dv e() {
        return this.w;
    }

    protected dv a(dw dwVar, dw dwVar2) {
        if (this.a) {
            throw new IllegalArgumentException();
        }
        this.a = true;
        this.p = (eh) dwVar;
        this.q = (eh) dwVar2;
        this.t = new eg();
        this.v = new eg();
        this.u = new eg();
        this.w = new eg();
        this.t.s = this;
        this.u.s = this;
        this.v.s = this;
        this.w.s = this;
        f();
        return this.t;
    }

    public dw g() {
        return this.p;
    }

    public dw h() {
        return this.p;
    }
}
