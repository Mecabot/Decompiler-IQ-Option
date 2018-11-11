package org.yaml.snakeyaml.tokens;

import java.util.List;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.tokens.Token.ID;

/* compiled from: DirectiveToken */
public final class g<T> extends Token {
    private final List<T> fiK;
    private final String name;

    public g(String str, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.name = str;
        if (list == null || list.size() == 2) {
            this.fiK = list;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Two strings must be provided instead of ");
        stringBuilder.append(String.valueOf(list.size()));
        throw new YAMLException(stringBuilder.toString());
    }

    public String getName() {
        return this.name;
    }

    public List<T> bEj() {
        return this.fiK;
    }

    public ID bFx() {
        return ID.Directive;
    }
}
