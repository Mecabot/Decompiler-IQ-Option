package jumio.nv.nfc;

import java.io.Serializable;

/* compiled from: ReadResult */
public class o extends Throwable implements Serializable {
    private p a;
    private q b = q.SUCCESSFUL;
    private Throwable c = null;
    private Object d = null;

    public o(p pVar, q qVar) {
        this.a = pVar;
        this.b = qVar;
    }

    public o(p pVar) {
        this.a = pVar;
    }

    public o(p pVar, q qVar, Throwable th) {
        this.a = pVar;
        this.b = qVar;
        this.c = th;
    }

    public <T> o(p pVar, q qVar, T t) {
        a(pVar);
        a(qVar);
        a((Object) t);
    }

    public <T> o(o oVar) {
        this.a = oVar.a;
        this.b = oVar.b;
        this.d = oVar.d;
    }

    public p a() {
        return this.a;
    }

    public void a(p pVar) {
        this.a = pVar;
    }

    public q b() {
        return this.b;
    }

    public void a(q qVar) {
        a(qVar, null);
    }

    public void a(q qVar, Throwable th) {
        this.b = qVar;
        this.c = th;
    }

    public Throwable c() {
        return this.c;
    }

    public boolean d() {
        return this.b == q.SUCCESSFUL;
    }

    public boolean e() {
        return this.b == q.FAILED;
    }

    public boolean f() {
        return this.b == q.ERROR;
    }

    public <T> void a(T t) {
        this.d = t;
    }

    public <T> T g() {
        return this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(" -> ");
        stringBuilder.append(this.b.toString());
        return stringBuilder.toString();
    }

    public String h() {
        String oVar = toString();
        if (this.d == null) {
            return oVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(oVar);
        stringBuilder.append("    (data: ");
        stringBuilder.append(this.d.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
