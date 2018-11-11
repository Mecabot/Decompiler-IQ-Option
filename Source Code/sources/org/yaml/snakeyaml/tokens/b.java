package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: AnchorToken */
public final class b extends Token {
    private final String value;

    public b(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public ID bFx() {
        return ID.Anchor;
    }
}
