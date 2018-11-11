package kotlin.reflect.jvm.internal.impl.name;

/* compiled from: Name */
public final class f implements Comparable<f> {
    private final String name;
    private final boolean special;

    private f(String str, boolean z) {
        this.name = str;
        this.special = z;
    }

    public String asString() {
        return this.name;
    }

    public String getIdentifier() {
        if (!this.special) {
            return asString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not identifier: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean btR() {
        return this.special;
    }

    /* renamed from: H */
    public int compareTo(f fVar) {
        return this.name.compareTo(fVar.name);
    }

    public static f mD(String str) {
        return new f(str, false);
    }

    public static boolean mE(String str) {
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static f mF(String str) {
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("special name must start with '<': ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static f mG(String str) {
        if (str.startsWith("<")) {
            return mF(str);
        }
        return mD(str);
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.special == fVar.special && this.name.equals(fVar.name);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.special;
    }
}
