package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: TagToken */
public final class s extends Token {
    private final t fkq;

    public s(t tVar, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.fkq = tVar;
    }

    public t bFz() {
        return this.fkq;
    }

    public ID bFx() {
        return ID.Tag;
    }
}
