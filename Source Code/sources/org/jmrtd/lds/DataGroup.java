package org.jmrtd.lds;

import java.io.InputStream;

public abstract class DataGroup extends AbstractTaggedLDSFile {
    private static final long serialVersionUID = -4761360877353069639L;

    protected DataGroup(int i, InputStream inputStream) {
        super(i, inputStream);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataGroup [");
        stringBuilder.append(Integer.toHexString(getTag()));
        stringBuilder.append(" (");
        stringBuilder.append(getLength());
        stringBuilder.append(")]");
        return stringBuilder.toString();
    }
}
