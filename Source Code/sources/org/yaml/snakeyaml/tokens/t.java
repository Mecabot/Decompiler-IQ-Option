package org.yaml.snakeyaml.tokens;

/* compiled from: TagTuple */
public final class t {
    private final String fkr;
    private final String suffix;

    public t(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("Suffix must be provided.");
        }
        this.fkr = str;
        this.suffix = str2;
    }

    public String bFA() {
        return this.fkr;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
