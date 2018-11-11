package kotlin.reflect.jvm.internal.impl.name;

/* compiled from: ClassId */
public final class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final b eNa;
    private final boolean eNb;
    private final b packageFqName;

    public static a t(b bVar) {
        return new a(bVar.btM(), bVar.btN());
    }

    public a(b bVar, b bVar2, boolean z) {
        this.packageFqName = bVar;
        this.eNa = bVar2;
        this.eNb = z;
    }

    public a(b bVar, f fVar) {
        this(bVar, b.E(fVar), false);
    }

    public b getPackageFqName() {
        return this.packageFqName;
    }

    public b btG() {
        return this.eNa;
    }

    public f btH() {
        return this.eNa.btN();
    }

    public boolean isLocal() {
        return this.eNb;
    }

    public a B(f fVar) {
        return new a(getPackageFqName(), this.eNa.C(fVar), this.eNb);
    }

    public a btI() {
        b btM = this.eNa.btM();
        return btM.isRoot() ? null : new a(getPackageFqName(), btM, this.eNb);
    }

    public boolean btJ() {
        return this.eNa.btM().isRoot() ^ 1;
    }

    public b btK() {
        if (this.packageFqName.isRoot()) {
            return this.eNa;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.packageFqName.asString());
        stringBuilder.append(".");
        stringBuilder.append(this.eNa.asString());
        return new b(stringBuilder.toString());
    }

    public static a mA(String str) {
        return y(str, false);
    }

    public static a y(String str, boolean z) {
        return new a(new b(v.c(str, '/', "").replace('/', '.')), new b(v.d(str, '/', str)), z);
    }

    public String asString() {
        if (this.packageFqName.isRoot()) {
            return this.eNa.asString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.packageFqName.asString().replace('.', '/'));
        stringBuilder.append("/");
        stringBuilder.append(this.eNa.asString());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!(this.packageFqName.equals(aVar.packageFqName) && this.eNa.equals(aVar.eNa) && this.eNb == aVar.eNb)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.eNa.hashCode()) * 31) + Boolean.valueOf(this.eNb).hashCode();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(asString());
        return stringBuilder.toString();
    }
}
