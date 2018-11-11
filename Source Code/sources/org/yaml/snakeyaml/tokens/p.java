package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: ScalarToken */
public final class p extends Token {
    private final boolean fil;
    private final ScalarStyle fio;
    private final String value;

    public p(String str, Mark mark, Mark mark2, boolean z) {
        this(str, z, mark, mark2, ScalarStyle.PLAIN);
    }

    public p(String str, boolean z, Mark mark, Mark mark2, ScalarStyle scalarStyle) {
        super(mark, mark2);
        this.value = str;
        this.fil = z;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.fio = scalarStyle;
    }

    public boolean bFy() {
        return this.fil;
    }

    public String getValue() {
        return this.value;
    }

    public ScalarStyle bEf() {
        return this.fio;
    }

    public ID bFx() {
        return ID.Scalar;
    }
}
