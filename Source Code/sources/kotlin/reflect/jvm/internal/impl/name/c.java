package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.a.b;

/* compiled from: FqNameUnsafe */
public final class c {
    private static final f eNf = f.mF("<root>");
    private static final Pattern eNg = Pattern.compile("\\.");
    private static final b<String, f> eNh = new b<String, f>() {
        /* renamed from: mB */
        public f invoke(String str) {
            return f.mG(str);
        }
    };
    private final String eNi;
    private transient b eNj;
    private transient c eNk;
    private transient f eNl;

    c(String str, b bVar) {
        this.eNi = str;
        this.eNj = bVar;
    }

    public c(String str) {
        this.eNi = str;
    }

    private c(String str, c cVar, f fVar) {
        this.eNi = str;
        this.eNk = cVar;
        this.eNl = fVar;
    }

    private void compute() {
        int lastIndexOf = this.eNi.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.eNl = f.mG(this.eNi.substring(lastIndexOf + 1));
            this.eNk = new c(this.eNi.substring(0, lastIndexOf));
            return;
        }
        this.eNl = f.mG(this.eNi);
        this.eNk = b.eNc.btL();
    }

    public String asString() {
        return this.eNi;
    }

    public boolean isSafe() {
        return this.eNj != null || asString().indexOf(60) < 0;
    }

    public b btP() {
        if (this.eNj != null) {
            return this.eNj;
        }
        this.eNj = new b(this);
        return this.eNj;
    }

    public boolean isRoot() {
        return this.eNi.isEmpty();
    }

    public c btQ() {
        if (this.eNk != null) {
            return this.eNk;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        compute();
        return this.eNk;
    }

    public c F(f fVar) {
        String asString;
        if (isRoot()) {
            asString = fVar.asString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.eNi);
            stringBuilder.append(".");
            stringBuilder.append(fVar.asString());
            asString = stringBuilder.toString();
        }
        return new c(asString, this, fVar);
    }

    public f btN() {
        if (this.eNl != null) {
            return this.eNl;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        compute();
        return this.eNl;
    }

    public f btO() {
        if (isRoot()) {
            return eNf;
        }
        return btN();
    }

    public List<f> pathSegments() {
        return isRoot() ? Collections.emptyList() : i.a((Object[]) eNg.split(this.eNi), eNh);
    }

    public boolean D(f fVar) {
        int indexOf = this.eNi.indexOf(46);
        if (isRoot()) {
            return false;
        }
        String str = this.eNi;
        String asString = fVar.asString();
        if (indexOf == -1) {
            indexOf = this.eNi.length();
        }
        return str.regionMatches(0, asString, 0, indexOf);
    }

    public static c G(f fVar) {
        return new c(fVar.asString(), b.eNc.btL(), fVar);
    }

    public String toString() {
        return isRoot() ? eNf.asString() : this.eNi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.eNi.equals(((c) obj).eNi);
    }

    public int hashCode() {
        return this.eNi.hashCode();
    }
}
