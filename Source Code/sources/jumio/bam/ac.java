package jumio.bam;

import java.io.Serializable;

/* compiled from: CustomField */
public abstract class ac implements Serializable {
    protected String a = "";
    protected String b = "";

    public ac(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
