package org.yaml.snakeyaml.composer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.events.Event.ID;
import org.yaml.snakeyaml.events.i;
import org.yaml.snakeyaml.events.j;
import org.yaml.snakeyaml.events.l;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.c;
import org.yaml.snakeyaml.nodes.d;
import org.yaml.snakeyaml.nodes.e;
import org.yaml.snakeyaml.nodes.f;
import org.yaml.snakeyaml.nodes.g;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: Composer */
public class a {
    private final org.yaml.snakeyaml.b.a fhC;
    protected final org.yaml.snakeyaml.parser.a fhH;
    private final Map<String, d> fhI = new HashMap();
    private final Set<d> fhJ = new HashSet();

    public a(org.yaml.snakeyaml.parser.a aVar, org.yaml.snakeyaml.b.a aVar2) {
        this.fhH = aVar;
        this.fhC = aVar2;
    }

    public d bDL() {
        this.fhH.bEr();
        d bDM = !this.fhH.b(ID.StreamEnd) ? bDM() : null;
        if (this.fhH.b(ID.StreamEnd)) {
            this.fhH.bEr();
            return bDM;
        }
        throw new ComposerException("expected a single document in the stream", bDM.bEb(), "but found another document", this.fhH.bEr().bEb());
    }

    private d bDM() {
        this.fhH.bEr();
        d b = b(null);
        this.fhH.bEr();
        this.fhI.clear();
        this.fhJ.clear();
        return b;
    }

    private d b(d dVar) {
        d dVar2;
        this.fhJ.add(dVar);
        if (this.fhH.b(ID.Alias)) {
            org.yaml.snakeyaml.events.a aVar = (org.yaml.snakeyaml.events.a) this.fhH.bEr();
            String bEe = aVar.bEe();
            if (this.fhI.containsKey(bEe)) {
                dVar2 = (d) this.fhI.get(bEe);
                if (this.fhJ.remove(dVar2)) {
                    dVar2.hx(true);
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("found undefined alias ");
                stringBuilder.append(bEe);
                throw new ComposerException(null, null, stringBuilder.toString(), aVar.bEb());
            }
        }
        String bEe2 = ((i) this.fhH.bEq()).bEe();
        dVar2 = this.fhH.b(ID.Scalar) ? nW(bEe2) : this.fhH.b(ID.SequenceStart) ? nX(bEe2) : nY(bEe2);
        this.fhJ.remove(dVar);
        return dVar2;
    }

    protected d nW(String str) {
        h a;
        boolean z;
        j jVar = (j) this.fhH.bEr();
        String tag = jVar.getTag();
        if (tag == null || tag.equals("!")) {
            a = this.fhC.a(NodeId.scalar, jVar.getValue(), jVar.bEg().bEd());
            z = true;
        } else {
            a = new h(tag);
            z = false;
        }
        d fVar = new f(a, z, jVar.getValue(), jVar.bEb(), jVar.bEc(), jVar.bEf());
        if (str != null) {
            this.fhI.put(str, fVar);
        }
        return fVar;
    }

    protected d nX(String str) {
        h a;
        boolean z;
        l lVar = (l) this.fhH.bEr();
        String tag = lVar.getTag();
        if (tag == null || tag.equals("!")) {
            a = this.fhC.a(NodeId.sequence, null, lVar.bDY());
            z = true;
        } else {
            a = new h(tag);
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        d gVar = new g(a, z, arrayList, lVar.bEb(), null, lVar.bDZ());
        if (str != null) {
            this.fhI.put(str, gVar);
        }
        while (!this.fhH.b(ID.SequenceEnd)) {
            arrayList.add(b(gVar));
        }
        gVar.a(this.fhH.bEr().bEc());
        return gVar;
    }

    protected d nY(String str) {
        h a;
        boolean z;
        org.yaml.snakeyaml.events.h hVar = (org.yaml.snakeyaml.events.h) this.fhH.bEr();
        String tag = hVar.getTag();
        if (tag == null || tag.equals("!")) {
            a = this.fhC.a(NodeId.mapping, null, hVar.bDY());
            z = true;
        } else {
            a = new h(tag);
            z = false;
        }
        List arrayList = new ArrayList();
        d cVar = new c(a, z, arrayList, hVar.bEb(), null, hVar.bDZ());
        if (str != null) {
            this.fhI.put(str, cVar);
        }
        while (!this.fhH.b(ID.MappingEnd)) {
            a(arrayList, cVar);
        }
        cVar.a(this.fhH.bEr().bEc());
        return cVar;
    }

    protected void a(List<e> list, c cVar) {
        d a = a(cVar);
        if (a.bDJ().equals(h.fiS)) {
            cVar.hw(true);
        }
        list.add(new e(a, b(cVar)));
    }

    protected d a(c cVar) {
        return b((d) cVar);
    }

    protected d b(c cVar) {
        return b((d) cVar);
    }
}
