package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.MarkedYAMLException;

public class ScannerException extends MarkedYAMLException {
    private static final long serialVersionUID = 4782293188600445954L;

    public ScannerException(String str, Mark mark, String str2, Mark mark2, String str3) {
        super(str, mark, str2, mark2, str3);
    }

    public ScannerException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null);
    }
}
