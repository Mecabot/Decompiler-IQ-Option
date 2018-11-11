package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

public abstract class Event {
    private final Mark fij;
    private final Mark fik;

    public enum ID {
        Alias,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    public abstract boolean a(ID id);

    protected String bEa() {
        return "";
    }

    public Event(Mark mark, Mark mark2) {
        this.fij = mark;
        this.fik = mark2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getName());
        stringBuilder.append("(");
        stringBuilder.append(bEa());
        stringBuilder.append(")>");
        return stringBuilder.toString();
    }

    public Mark bEb() {
        return this.fij;
    }

    public Mark bEc() {
        return this.fik;
    }

    public boolean equals(Object obj) {
        return obj instanceof Event ? toString().equals(obj.toString()) : false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
