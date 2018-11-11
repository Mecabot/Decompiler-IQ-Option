package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.error.Mark;

/* compiled from: Node */
public abstract class d {
    private h fhw;
    private boolean fiM = false;
    protected boolean fiN = true;
    protected Boolean fiO = null;
    private Mark fij;
    protected Mark fik;
    private Class<? extends Object> type = Object.class;

    public abstract NodeId bEi();

    public d(h hVar, Mark mark, Mark mark2) {
        a(hVar);
        this.fij = mark;
        this.fik = mark2;
    }

    public h bDJ() {
        return this.fhw;
    }

    public Mark bEc() {
        return this.fik;
    }

    public Mark bEb() {
        return this.fij;
    }

    public void a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.fhw = hVar;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    public void af(Class<? extends Object> cls) {
        if (!cls.isAssignableFrom(this.type)) {
            this.type = cls;
        }
    }

    public void hx(boolean z) {
        this.fiM = z;
    }

    public boolean bEl() {
        return this.fiM;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public boolean bEm() {
        if (this.fiO != null) {
            return this.fiO.booleanValue();
        }
        if ((this.fhw.bEp() || !this.fiN || Object.class.equals(this.type) || this.fhw.equals(h.fjb)) && !this.fhw.ah(getType())) {
            return false;
        }
        return true;
    }

    public void w(Boolean bool) {
        this.fiO = bool;
    }
}
