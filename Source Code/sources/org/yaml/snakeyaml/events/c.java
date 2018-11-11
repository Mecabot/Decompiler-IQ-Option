package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.error.Mark;

/* compiled from: CollectionStartEvent */
public abstract class c extends i {
    private final boolean fig;
    private final FlowStyle fih;
    private final String tag;

    public c(String str, String str2, boolean z, Mark mark, Mark mark2, FlowStyle flowStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.fig = z;
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.fih = flowStyle;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean bDY() {
        return this.fig;
    }

    public FlowStyle bDZ() {
        return this.fih;
    }

    protected String bEa() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.bEa());
        stringBuilder.append(", tag=");
        stringBuilder.append(this.tag);
        stringBuilder.append(", implicit=");
        stringBuilder.append(this.fig);
        return stringBuilder.toString();
    }
}
