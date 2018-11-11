package org.yaml.snakeyaml.representer;

import java.util.Collections;
import java.util.Map;
import org.yaml.snakeyaml.b;
import org.yaml.snakeyaml.introspector.g;

/* compiled from: Representer */
public class c extends d {
    protected Map<Class<? extends Object>, b> fhU = Collections.emptyMap();

    /* compiled from: Representer */
    protected class a implements b {
        protected a() {
        }
    }

    public c() {
        this.fjw.put(null, new a());
    }

    public void a(g gVar) {
        super.a(gVar);
        for (b a : this.fhU.values()) {
            a.a(gVar);
        }
    }
}
