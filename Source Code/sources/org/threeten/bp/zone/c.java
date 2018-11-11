package org.threeten.bp.zone;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.a.d;

/* compiled from: ZoneRulesProvider */
public abstract class c {
    private static final CopyOnWriteArrayList<c> fhd = new CopyOnWriteArrayList();
    private static final ConcurrentMap<String, c> fhe = new ConcurrentHashMap(512, 0.75f, 2);

    protected abstract ZoneRules D(String str, boolean z);

    protected abstract Set<String> provideZoneIds();

    static {
        b.initialize();
    }

    public static ZoneRules E(String str, boolean z) {
        d.requireNonNull(str, "zoneId");
        return nT(str).D(str, z);
    }

    private static c nT(String str) {
        c cVar = (c) fhe.get(str);
        if (cVar != null) {
            return cVar;
        }
        if (fhe.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown time-zone ID: ");
        stringBuilder.append(str);
        throw new ZoneRulesException(stringBuilder.toString());
    }

    public static void a(c cVar) {
        d.requireNonNull(cVar, "provider");
        b(cVar);
        fhd.add(cVar);
    }

    private static void b(c cVar) {
        for (String str : cVar.provideZoneIds()) {
            d.requireNonNull(str, "zoneId");
            if (((c) fhe.putIfAbsent(str, cVar)) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to register zone as one already registered with that ID: ");
                stringBuilder.append(str);
                stringBuilder.append(", currently loading from provider: ");
                stringBuilder.append(cVar);
                throw new ZoneRulesException(stringBuilder.toString());
            }
        }
    }

    protected c() {
    }
}
