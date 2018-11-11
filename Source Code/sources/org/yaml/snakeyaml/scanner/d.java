package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.Mark;

/* compiled from: SimpleKey */
final class d {
    private int column;
    private int fkn;
    private Mark fko;
    private int index;
    private int line;
    private boolean required;

    public d(int i, boolean z, int i2, int i3, int i4, Mark mark) {
        this.fkn = i;
        this.required = z;
        this.index = i2;
        this.line = i3;
        this.column = i4;
        this.fko = mark;
    }

    public int bFw() {
        return this.fkn;
    }

    public int getColumn() {
        return this.column;
    }

    public Mark bEy() {
        return this.fko;
    }

    public int getIndex() {
        return this.index;
    }

    public int bDX() {
        return this.line;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SimpleKey - tokenNumber=");
        stringBuilder.append(this.fkn);
        stringBuilder.append(" required=");
        stringBuilder.append(this.required);
        stringBuilder.append(" index=");
        stringBuilder.append(this.index);
        stringBuilder.append(" line=");
        stringBuilder.append(this.line);
        stringBuilder.append(" column=");
        stringBuilder.append(this.column);
        return stringBuilder.toString();
    }
}
