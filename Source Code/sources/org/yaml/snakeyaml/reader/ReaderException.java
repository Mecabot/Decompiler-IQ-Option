package org.yaml.snakeyaml.reader;

import org.yaml.snakeyaml.error.YAMLException;

public class ReaderException extends YAMLException {
    private static final long serialVersionUID = 8710781187529689083L;
    private final int codePoint;
    private final String name;
    private final int position;

    public ReaderException(String str, int i, int i2, String str2) {
        super(str2);
        this.name = str;
        this.codePoint = i2;
        this.position = i;
    }

    public String toString() {
        String str = new String(Character.toChars(this.codePoint));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unacceptable code point '");
        stringBuilder.append(str);
        stringBuilder.append("' (0x");
        stringBuilder.append(Integer.toHexString(this.codePoint).toUpperCase());
        stringBuilder.append(") ");
        stringBuilder.append(getMessage());
        stringBuilder.append("\nin \"");
        stringBuilder.append(this.name);
        stringBuilder.append("\", position ");
        stringBuilder.append(this.position);
        return stringBuilder.toString();
    }
}
