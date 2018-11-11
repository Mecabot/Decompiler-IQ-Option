package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: ValueToken */
public final class u extends Token {
    public u(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public ID bFx() {
        return ID.Value;
    }
}
