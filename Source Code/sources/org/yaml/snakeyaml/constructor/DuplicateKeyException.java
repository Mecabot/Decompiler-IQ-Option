package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;

public class DuplicateKeyException extends ConstructorException {
    protected DuplicateKeyException(Mark mark, Object obj, Mark mark2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("found duplicate key ");
        stringBuilder.append(obj.toString());
        super("while constructing a mapping", mark, stringBuilder.toString(), mark2);
    }
}
