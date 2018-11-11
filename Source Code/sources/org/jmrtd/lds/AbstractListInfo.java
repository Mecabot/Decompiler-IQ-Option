package org.jmrtd.lds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractListInfo<R extends Serializable> extends AbstractLDSInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2970076896364365191L;
    private List<R> subRecords;

    protected List<R> bAC() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    protected void add(R r) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractListInfo)) {
            return false;
        }
        try {
            AbstractListInfo abstractListInfo = (AbstractListInfo) obj;
            List bAC = bAC();
            List bAC2 = abstractListInfo.bAC();
            int size = bAC.size();
            if (size != bAC2.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                Serializable serializable = (Serializable) bAC.get(i);
                Serializable serializable2 = (Serializable) bAC2.get(i);
                if (serializable == null) {
                    if (serializable2 != null) {
                        return false;
                    }
                } else if (!serializable.equals(serializable2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Wrong class", e);
            return false;
        }
    }

    public int hashCode() {
        int i = 1234567891;
        for (Serializable serializable : bAC()) {
            if (serializable == null) {
                i = (i * 3) + 5;
            } else {
                i = ((i + serializable.hashCode()) * 5) + 7;
            }
        }
        return (i * 7) + 11;
    }
}
