package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: ScalarEvent */
public final class j extends i {
    private final ScalarStyle fio;
    private final f fip;
    private final String tag;
    private final String value;

    public j(String str, String str2, f fVar, String str3, Mark mark, Mark mark2, ScalarStyle scalarStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.fip = fVar;
        this.value = str3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.fio = scalarStyle;
    }

    public String getTag() {
        return this.tag;
    }

    public ScalarStyle bEf() {
        return this.fio;
    }

    public String getValue() {
        return this.value;
    }

    public f bEg() {
        return this.fip;
    }

    protected String bEa() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.bEa());
        stringBuilder.append(", tag=");
        stringBuilder.append(this.tag);
        stringBuilder.append(", ");
        stringBuilder.append(this.fip);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    public boolean a(ID id) {
        return ID.Scalar == id;
    }
}
