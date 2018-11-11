package d;

/* compiled from: Device */
public class b {
    public final String mk;

    public b(String str) {
        this.mk = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if ((this.mk == null || !this.mk.equals(bVar.mk)) && this.mk != bVar.mk) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.mk == null ? 0 : this.mk.hashCode();
    }

    public String toString() {
        String str;
        String str2 = "{\"family\": %s}";
        Object[] objArr = new Object[1];
        if (this.mk == null) {
            str = "\"\"";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(this.mk);
            stringBuilder.append('\"');
            str = stringBuilder.toString();
        }
        objArr[0] = str;
        return String.format(str2, objArr);
    }
}
