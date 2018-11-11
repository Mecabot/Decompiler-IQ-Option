package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.d;

/* compiled from: AbstractConstruct */
public abstract class a implements c {
    public void a(d dVar, Object obj) {
        if (dVar.bEl()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not Implemented in ");
            stringBuilder.append(getClass().getName());
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unexpected recursive structure for Node: ");
        stringBuilder2.append(dVar);
        throw new YAMLException(stringBuilder2.toString());
    }
}
