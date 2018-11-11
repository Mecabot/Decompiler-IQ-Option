package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.error.Mark;

/* compiled from: ScalarNode */
public class f extends d {
    private ScalarStyle fio;
    private String value;

    public f(h hVar, boolean z, String str, Mark mark, Mark mark2, ScalarStyle scalarStyle) {
        super(hVar, mark, mark2);
        if (str == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = str;
        if (scalarStyle == null) {
            throw new NullPointerException("Scalar style must be provided.");
        }
        this.fio = scalarStyle;
        this.fiN = z;
    }

    public NodeId bEi() {
        return NodeId.scalar;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" (tag=");
        stringBuilder.append(bDJ());
        stringBuilder.append(", value=");
        stringBuilder.append(getValue());
        stringBuilder.append(")>");
        return stringBuilder.toString();
    }
}
