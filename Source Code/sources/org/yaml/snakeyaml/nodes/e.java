package org.yaml.snakeyaml.nodes;

/* compiled from: NodeTuple */
public final class e {
    private d fiP;
    private d fiQ;

    public e(d dVar, d dVar2) {
        if (dVar == null || dVar2 == null) {
            throw new NullPointerException("Nodes must be provided.");
        }
        this.fiP = dVar;
        this.fiQ = dVar2;
    }

    public d bEn() {
        return this.fiP;
    }

    public d bEo() {
        return this.fiQ;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<NodeTuple keyNode=");
        stringBuilder.append(this.fiP.toString());
        stringBuilder.append("; valueNode=");
        stringBuilder.append(this.fiQ.toString());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
