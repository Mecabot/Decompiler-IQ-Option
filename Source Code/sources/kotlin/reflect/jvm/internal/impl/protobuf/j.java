package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: LazyFieldLite */
public class j {
    private d eOk;
    private f eOl;
    private volatile boolean eOm;
    protected volatile n eOn;

    public n h(n nVar) {
        j(nVar);
        return this.eOn;
    }

    public n i(n nVar) {
        n nVar2 = this.eOn;
        this.eOn = nVar;
        this.eOk = null;
        this.eOm = true;
        return nVar2;
    }

    public int bjb() {
        if (this.eOm) {
            return this.eOn.bjb();
        }
        return this.eOk.size();
    }

    protected void j(n nVar) {
        if (this.eOn == null) {
            synchronized (this) {
                if (this.eOn != null) {
                } else {
                    if (this.eOk != null) {
                        this.eOn = (n) nVar.biX().c(this.eOk, this.eOl);
                    } else {
                        this.eOn = nVar;
                    }
                    try {
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }
}
