package d;

/* compiled from: OS */
public class d {
    public final String fle;
    public final String flf;
    public final String flg;
    public final String flh;
    public final String mk;

    public d(String str, String str2, String str3, String str4, String str5) {
        this.mk = str;
        this.fle = str2;
        this.flf = str3;
        this.flg = str4;
        this.flh = str5;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (((this.mk == null || !this.mk.equals(dVar.mk)) && this.mk != dVar.mk) || (((this.fle == null || !this.fle.equals(dVar.fle)) && this.fle != dVar.fle) || (((this.flf == null || !this.flf.equals(dVar.flf)) && this.flf != dVar.flf) || (((this.flg == null || !this.flg.equals(dVar.flg)) && this.flg != dVar.flg) || ((this.flh == null || !this.flh.equals(dVar.flh)) && this.flh != dVar.flh))))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.mk == null ? 0 : this.mk.hashCode()) + (this.fle == null ? 0 : this.fle.hashCode())) + (this.flf == null ? 0 : this.flf.hashCode())) + (this.flg == null ? 0 : this.flg.hashCode());
        if (this.flh != null) {
            i = this.flh.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder stringBuilder;
        String str3;
        String str4 = "{\"family\": %s, \"major\": %s, \"minor\": %s, \"patch\": %s, \"patch_minor\": %s}";
        Object[] objArr = new Object[5];
        if (this.mk == null) {
            str = "\"\"";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('\"');
            stringBuilder2.append(this.mk);
            stringBuilder2.append('\"');
            str = stringBuilder2.toString();
        }
        objArr[0] = str;
        if (this.fle == null) {
            str2 = "\"\"";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(this.fle);
            stringBuilder.append('\"');
            str2 = stringBuilder.toString();
        }
        objArr[1] = str2;
        if (this.flf == null) {
            str2 = "\"\"";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(this.flf);
            stringBuilder.append('\"');
            str2 = stringBuilder.toString();
        }
        objArr[2] = str2;
        if (this.flg == null) {
            str2 = "\"\"";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(this.flg);
            stringBuilder.append('\"');
            str2 = stringBuilder.toString();
        }
        objArr[3] = str2;
        if (this.flh == null) {
            str3 = "\"\"";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(this.flh);
            stringBuilder.append('\"');
            str3 = stringBuilder.toString();
        }
        objArr[4] = str3;
        return String.format(str4, objArr);
    }
}
