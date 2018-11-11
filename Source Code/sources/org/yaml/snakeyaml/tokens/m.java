package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: FlowSequenceEndToken */
public final class m extends Token {
    public m(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public ID bFx() {
        return ID.FlowSequenceEnd;
    }
}
