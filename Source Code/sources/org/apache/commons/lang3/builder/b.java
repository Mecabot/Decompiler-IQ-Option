package org.apache.commons.lang3.builder;

/* compiled from: ToStringBuilder */
public class b {
    private static volatile ToStringStyle fbD = ToStringStyle.fbG;
    private final StringBuffer fbE;
    private final ToStringStyle fbF;
    private final Object object;

    public static ToStringStyle bAp() {
        return fbD;
    }

    public static String dq(Object obj) {
        return a.toString(obj);
    }

    public b(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        if (toStringStyle == null) {
            toStringStyle = bAp();
        }
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer(512);
        }
        this.fbE = stringBuffer;
        this.fbF = toStringStyle;
        this.object = obj;
        toStringStyle.b(stringBuffer, obj);
    }

    public b s(String str, Object obj) {
        this.fbF.a(this.fbE, str, obj, null);
        return this;
    }

    public Object getObject() {
        return this.object;
    }

    public StringBuffer bAq() {
        return this.fbE;
    }

    public ToStringStyle bAr() {
        return this.fbF;
    }

    public String toString() {
        if (getObject() == null) {
            bAq().append(bAr().bAu());
        } else {
            this.fbF.c(bAq(), getObject());
        }
        return bAq().toString();
    }
}
