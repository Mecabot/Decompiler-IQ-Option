package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

public abstract class Token {
    private final Mark fij;
    private final Mark fik;

    public enum ID {
        Alias,
        Anchor,
        BlockEnd,
        BlockEntry,
        BlockMappingStart,
        BlockSequenceStart,
        Directive,
        DocumentEnd,
        DocumentStart,
        FlowEntry,
        FlowMappingEnd,
        FlowMappingStart,
        FlowSequenceEnd,
        FlowSequenceStart,
        Key,
        Scalar,
        StreamEnd,
        StreamStart,
        Tag,
        Value,
        Whitespace,
        Comment,
        Error
    }

    public abstract ID bFx();

    public Token(Mark mark, Mark mark2) {
        if (mark == null || mark2 == null) {
            throw new YAMLException("Token requires marks.");
        }
        this.fij = mark;
        this.fik = mark2;
    }

    public Mark bEb() {
        return this.fij;
    }

    public Mark bEc() {
        return this.fik;
    }
}
