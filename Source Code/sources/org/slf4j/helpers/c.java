package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.a;
import org.slf4j.b;

/* compiled from: SubstituteLoggerFactory */
public class c implements a {
    final ConcurrentMap<String, b> fdt = new ConcurrentHashMap();

    public b nJ(String str) {
        b bVar = (b) this.fdt.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(str);
        b bVar3 = (b) this.fdt.putIfAbsent(str, bVar2);
        return bVar3 != null ? bVar3 : bVar2;
    }

    public List<b> bCg() {
        return new ArrayList(this.fdt.values());
    }

    public void clear() {
        this.fdt.clear();
    }
}
