package org.yaml.snakeyaml.parser;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions.Version;

/* compiled from: VersionTagsTuple */
class d {
    private Map<String, String> aYH;
    private Version fhr;

    public d(Version version, Map<String, String> map) {
        this.fhr = version;
        this.aYH = map;
    }

    public Version bEw() {
        return this.fhr;
    }

    public Map<String, String> bEx() {
        return this.aYH;
    }

    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", new Object[]{this.fhr, this.aYH});
    }
}
