package org.yaml.snakeyaml.events;

/* compiled from: ImplicitTuple */
public class f {
    private final boolean fil;
    private final boolean fim;

    public f(boolean z, boolean z2) {
        this.fil = z;
        this.fim = z2;
    }

    public boolean bEd() {
        return this.fil;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("implicit=[");
        stringBuilder.append(this.fil);
        stringBuilder.append(", ");
        stringBuilder.append(this.fim);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
