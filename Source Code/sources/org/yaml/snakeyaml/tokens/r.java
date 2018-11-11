package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: StreamStartToken */
public final class r extends Token {
    public r(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public ID bFx() {
        return ID.StreamStart;
    }
}
