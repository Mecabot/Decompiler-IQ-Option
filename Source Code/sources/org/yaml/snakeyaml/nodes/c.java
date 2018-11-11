package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.error.Mark;

/* compiled from: MappingNode */
public class c extends b<e> {
    private List<e> fiK;
    private boolean fiL = false;

    public c(h hVar, boolean z, List<e> list, Mark mark, Mark mark2, FlowStyle flowStyle) {
        super(hVar, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.fiK = list;
        this.fiN = z;
    }

    public NodeId bEi() {
        return NodeId.mapping;
    }

    public List<e> bEj() {
        return this.fiK;
    }

    public void cs(List<e> list) {
        this.fiK = list;
    }

    public void ae(Class<? extends Object> cls) {
        for (e bEn : this.fiK) {
            bEn.bEn().af(cls);
        }
    }

    public void b(Class<? extends Object> cls, Class<? extends Object> cls2) {
        for (e eVar : this.fiK) {
            eVar.bEo().af(cls2);
            eVar.bEn().af(cls);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (e eVar : bEj()) {
            stringBuilder.append("{ key=");
            stringBuilder.append(eVar.bEn());
            stringBuilder.append("; value=");
            if (eVar.bEo() instanceof b) {
                stringBuilder.append(System.identityHashCode(eVar.bEo()));
            } else {
                stringBuilder.append(eVar.toString());
            }
            stringBuilder.append(" }");
        }
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("<");
        stringBuilder3.append(getClass().getName());
        stringBuilder3.append(" (tag=");
        stringBuilder3.append(bDJ());
        stringBuilder3.append(", values=");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(")>");
        return stringBuilder3.toString();
    }

    public void hw(boolean z) {
        this.fiL = z;
    }

    public boolean bEk() {
        return this.fiL;
    }
}
