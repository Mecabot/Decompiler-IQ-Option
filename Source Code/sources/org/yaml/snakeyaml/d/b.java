package org.yaml.snakeyaml.d;

/* compiled from: PlatformFeatureDetector */
public class b {
    private Boolean fkt = null;

    public boolean bFB() {
        if (this.fkt == null) {
            this.fkt = Boolean.valueOf(System.getProperty("java.runtime.name").startsWith("Android Runtime"));
        }
        return this.fkt.booleanValue();
    }
}
