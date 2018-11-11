package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.MarkedYAMLException;

public class ConstructorException extends MarkedYAMLException {
    private static final long serialVersionUID = -8816339931365239910L;

    protected ConstructorException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        super(str, mark, str2, mark2, th);
    }

    protected ConstructorException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null);
    }
}
