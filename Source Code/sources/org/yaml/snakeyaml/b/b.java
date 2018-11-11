package org.yaml.snakeyaml.b;

import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: ResolverTuple */
final class b {
    private final h fhw;
    private final Pattern fjP;

    public b(h hVar, Pattern pattern) {
        this.fhw = hVar;
        this.fjP = pattern;
    }

    public h bDJ() {
        return this.fhw;
    }

    public Pattern bEC() {
        return this.fjP;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tuple tag=");
        stringBuilder.append(this.fhw);
        stringBuilder.append(" regexp=");
        stringBuilder.append(this.fjP);
        return stringBuilder.toString();
    }
}
