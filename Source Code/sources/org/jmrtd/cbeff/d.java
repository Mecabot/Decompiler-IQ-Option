package org.jmrtd.cbeff;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ComplexCBEFFInfo */
public class d implements c {
    private List<c> subRecords = new ArrayList();

    public List<c> bAC() {
        return new ArrayList(this.subRecords);
    }

    public void a(c cVar) {
        this.subRecords.add(cVar);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(d.class)) {
            return false;
        }
        return this.subRecords.equals(((d) obj).bAC());
    }

    public int hashCode() {
        return (this.subRecords.hashCode() * 7) + 11;
    }
}
