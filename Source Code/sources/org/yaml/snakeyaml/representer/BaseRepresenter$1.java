package org.yaml.snakeyaml.representer;

import java.util.IdentityHashMap;
import org.yaml.snakeyaml.nodes.a;
import org.yaml.snakeyaml.nodes.d;

class BaseRepresenter$1 extends IdentityHashMap<Object, d> {
    private static final long serialVersionUID = -5576159264232131854L;
    final /* synthetic */ a this$0;

    BaseRepresenter$1(a aVar) {
        this.this$0 = aVar;
    }

    /* renamed from: a */
    public d put(Object obj, d dVar) {
        return (d) super.put(obj, new a(dVar));
    }
}
