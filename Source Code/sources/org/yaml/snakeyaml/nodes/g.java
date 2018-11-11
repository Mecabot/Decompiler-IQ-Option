package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.error.Mark;

/* compiled from: SequenceNode */
public class g extends b<d> {
    private final List<d> fiK;

    public g(h hVar, boolean z, List<d> list, Mark mark, Mark mark2, FlowStyle flowStyle) {
        super(hVar, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.fiK = list;
        this.fiN = z;
    }

    public NodeId bEi() {
        return NodeId.sequence;
    }

    public List<d> bEj() {
        return this.fiK;
    }

    public void ag(Class<? extends Object> cls) {
        for (d af : this.fiK) {
            af.af(cls);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" (tag=");
        stringBuilder.append(bDJ());
        stringBuilder.append(", value=");
        stringBuilder.append(bEj());
        stringBuilder.append(")>");
        return stringBuilder.toString();
    }
}
