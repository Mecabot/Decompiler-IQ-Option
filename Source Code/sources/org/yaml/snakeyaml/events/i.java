package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* compiled from: NodeEvent */
public abstract class i extends Event {
    private final String fin;

    public i(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.fin = str;
    }

    public String bEe() {
        return this.fin;
    }

    protected String bEa() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("anchor=");
        stringBuilder.append(this.fin);
        return stringBuilder.toString();
    }
}
