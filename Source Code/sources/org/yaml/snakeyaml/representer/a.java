package org.yaml.snakeyaml.representer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.introspector.g;
import org.yaml.snakeyaml.nodes.d;

/* compiled from: BaseRepresenter */
public abstract class a {
    private boolean fhT = false;
    protected FlowStyle fhg = FlowStyle.AUTO;
    private g fhx;
    protected final Map<Object, d> fjA = new BaseRepresenter$1(this);
    protected final Map<Class<?>, b> fjw = new HashMap();
    protected b fjx;
    protected final Map<Class<?>, b> fjy = new LinkedHashMap();
    protected ScalarStyle fjz = null;

    public void a(ScalarStyle scalarStyle) {
        this.fjz = scalarStyle;
    }

    public ScalarStyle bDE() {
        if (this.fjz == null) {
            return ScalarStyle.PLAIN;
        }
        return this.fjz;
    }

    public void a(FlowStyle flowStyle) {
        this.fhg = flowStyle;
    }

    public FlowStyle bDG() {
        return this.fhg;
    }

    public void a(g gVar) {
        this.fhx = gVar;
        this.fhT = true;
    }

    public final g bDQ() {
        if (this.fhx == null) {
            this.fhx = new g();
        }
        return this.fhx;
    }

    public final boolean bDR() {
        return this.fhT;
    }
}
