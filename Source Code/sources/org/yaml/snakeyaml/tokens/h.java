package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: DocumentEndToken */
public final class h extends Token {
    public h(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public ID bFx() {
        return ID.DocumentEnd;
    }
}
