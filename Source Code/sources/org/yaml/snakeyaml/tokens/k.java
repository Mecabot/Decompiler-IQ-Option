package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: FlowMappingEndToken */
public final class k extends Token {
    public k(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public ID bFx() {
        return ID.FlowMappingEnd;
    }
}
