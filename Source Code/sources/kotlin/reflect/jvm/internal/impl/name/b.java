package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;

/* compiled from: FqName */
public final class b {
    public static final b eNc = new b("");
    private final c eNd;
    private transient b eNe;

    public b(String str) {
        this.eNd = new c(str, this);
    }

    public b(c cVar) {
        this.eNd = cVar;
    }

    private b(c cVar, b bVar) {
        this.eNd = cVar;
        this.eNe = bVar;
    }

    public String asString() {
        return this.eNd.asString();
    }

    public c btL() {
        return this.eNd;
    }

    public boolean isRoot() {
        return this.eNd.isRoot();
    }

    public b btM() {
        if (this.eNe != null) {
            return this.eNe;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        this.eNe = new b(this.eNd.btQ());
        return this.eNe;
    }

    public b C(f fVar) {
        return new b(this.eNd.F(fVar), this);
    }

    public f btN() {
        return this.eNd.btN();
    }

    public f btO() {
        return this.eNd.btO();
    }

    public List<f> pathSegments() {
        return this.eNd.pathSegments();
    }

    public boolean D(f fVar) {
        return this.eNd.D(fVar);
    }

    public static b E(f fVar) {
        return new b(c.G(fVar));
    }

    public String toString() {
        return this.eNd.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.eNd.equals(((b) obj).eNd);
    }

    public int hashCode() {
        return this.eNd.hashCode();
    }
}
