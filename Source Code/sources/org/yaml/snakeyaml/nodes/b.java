package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.error.Mark;

/* compiled from: CollectionNode */
public abstract class b<T> extends d {
    private FlowStyle fih;

    public abstract List<T> bEj();

    public b(h hVar, Mark mark, Mark mark2, FlowStyle flowStyle) {
        super(hVar, mark, mark2);
        b(flowStyle);
    }

    public void b(FlowStyle flowStyle) {
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.fih = flowStyle;
    }

    public void a(Mark mark) {
        this.fik = mark;
    }
}
