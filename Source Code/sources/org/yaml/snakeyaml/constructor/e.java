package org.yaml.snakeyaml.constructor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.NodeId;

/* compiled from: SafeConstructor */
public class e extends b {
    public static final a fhZ = new a();
    private static final Map<String, Boolean> fia = new HashMap();
    private static final Pattern fib = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
    private static final Pattern fic = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");

    /* compiled from: SafeConstructor */
    public class f implements c {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            if (dVar.bEl()) {
                return e.this.bDO();
            }
            return e.this.e((org.yaml.snakeyaml.nodes.c) dVar);
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            if (dVar.bEl()) {
                e.this.a((org.yaml.snakeyaml.nodes.c) dVar, (Map) obj);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected recursive mapping structure. Node: ");
            stringBuilder.append(dVar);
            throw new YAMLException(stringBuilder.toString());
        }
    }

    /* compiled from: SafeConstructor */
    public class j implements c {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            org.yaml.snakeyaml.nodes.g gVar = (org.yaml.snakeyaml.nodes.g) dVar;
            if (dVar.bEl()) {
                return e.this.a(gVar);
            }
            return e.this.b(gVar);
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            if (dVar.bEl()) {
                e.this.a((org.yaml.snakeyaml.nodes.g) dVar, (Collection) (List) obj);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected recursive sequence structure. Node: ");
            stringBuilder.append(dVar);
            throw new YAMLException(stringBuilder.toString());
        }
    }

    /* compiled from: SafeConstructor */
    public class k implements c {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            if (!dVar.bEl()) {
                return e.this.d((org.yaml.snakeyaml.nodes.c) dVar);
            }
            Object obj;
            if (e.this.fhO.containsKey(dVar)) {
                obj = e.this.fhO.get(dVar);
            } else {
                obj = e.this.bDP();
            }
            return obj;
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            if (dVar.bEl()) {
                e.this.a((org.yaml.snakeyaml.nodes.c) dVar, (Set) obj);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected recursive set structure. Node: ");
            stringBuilder.append(dVar);
            throw new YAMLException(stringBuilder.toString());
        }
    }

    /* compiled from: SafeConstructor */
    public static final class a extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("could not determine a constructor for the tag ");
            stringBuilder.append(dVar.bDJ());
            throw new ConstructorException(null, null, stringBuilder.toString(), dVar.bEb());
        }
    }

    /* compiled from: SafeConstructor */
    public class b extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            return org.yaml.snakeyaml.a.a.a.a.d(e.this.a((org.yaml.snakeyaml.nodes.f) dVar).toString().replaceAll("\\s", "").toCharArray());
        }
    }

    /* compiled from: SafeConstructor */
    public class c extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            return e.fia.get(((String) e.this.a((org.yaml.snakeyaml.nodes.f) dVar)).toLowerCase());
        }
    }

    /* compiled from: SafeConstructor */
    public class d extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            int i;
            String replaceAll = e.this.a((org.yaml.snakeyaml.nodes.f) dVar).toString().replaceAll("_", "");
            int i2 = 0;
            char charAt = replaceAll.charAt(0);
            if (charAt == '-') {
                replaceAll = replaceAll.substring(1);
                i = -1;
            } else {
                if (charAt == '+') {
                    replaceAll = replaceAll.substring(1);
                }
                i = 1;
            }
            String toLowerCase = replaceAll.toLowerCase();
            if (".inf".equals(toLowerCase)) {
                return Double.valueOf(i == -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            } else if (".nan".equals(toLowerCase)) {
                return Double.valueOf(Double.NaN);
            } else {
                if (replaceAll.indexOf(58) == -1) {
                    return Double.valueOf(Double.valueOf(replaceAll).doubleValue() * ((double) i));
                }
                String[] split = replaceAll.split(":");
                double d = 0.0d;
                int length = split.length;
                int i3 = 1;
                while (i2 < length) {
                    d += Double.parseDouble(split[(length - i2) - 1]) * ((double) i3);
                    i3 *= 60;
                    i2++;
                }
                return Double.valueOf(((double) i) * d);
            }
        }
    }

    /* compiled from: SafeConstructor */
    public class e extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            int i;
            String replaceAll = e.this.a((org.yaml.snakeyaml.nodes.f) dVar).toString().replaceAll("_", "");
            int i2 = 0;
            char charAt = replaceAll.charAt(0);
            if (charAt == '-') {
                replaceAll = replaceAll.substring(1);
                i = -1;
            } else {
                if (charAt == '+') {
                    replaceAll = replaceAll.substring(1);
                }
                i = 1;
            }
            if ("0".equals(replaceAll)) {
                return Integer.valueOf(0);
            }
            int i3 = 2;
            if (replaceAll.startsWith("0b")) {
                replaceAll = replaceAll.substring(2);
            } else if (replaceAll.startsWith("0x")) {
                replaceAll = replaceAll.substring(2);
                i3 = 16;
            } else if (replaceAll.startsWith("0")) {
                replaceAll = replaceAll.substring(1);
                i3 = 8;
            } else if (replaceAll.indexOf(58) == -1) {
                return e.this.b(i, replaceAll, 10);
            } else {
                String[] split = replaceAll.split(":");
                int length = split.length;
                int i4 = 0;
                int i5 = 1;
                while (i2 < length) {
                    i4 = (int) (((long) i4) + (Long.parseLong(split[(length - i2) - 1]) * ((long) i5)));
                    i5 *= 60;
                    i2++;
                }
                return e.this.b(i, String.valueOf(i4), 10);
            }
            return e.this.b(i, replaceAll, i3);
        }
    }

    /* compiled from: SafeConstructor */
    public class g extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            e.this.a((org.yaml.snakeyaml.nodes.f) dVar);
            return null;
        }
    }

    /* compiled from: SafeConstructor */
    public class h extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            Map linkedHashMap = new LinkedHashMap();
            StringBuilder stringBuilder;
            if (dVar instanceof org.yaml.snakeyaml.nodes.g) {
                for (org.yaml.snakeyaml.nodes.d dVar2 : ((org.yaml.snakeyaml.nodes.g) dVar).bEj()) {
                    Mark bEb;
                    if (dVar2 instanceof org.yaml.snakeyaml.nodes.c) {
                        org.yaml.snakeyaml.nodes.c cVar = (org.yaml.snakeyaml.nodes.c) dVar2;
                        if (cVar.bEj().size() != 1) {
                            bEb = dVar.bEb();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("expected a single mapping item, but found ");
                            stringBuilder.append(cVar.bEj().size());
                            stringBuilder.append(" items");
                            throw new ConstructorException("while constructing an ordered map", bEb, stringBuilder.toString(), cVar.bEb());
                        }
                        linkedHashMap.put(e.this.d(((org.yaml.snakeyaml.nodes.e) cVar.bEj().get(0)).bEn()), e.this.d(((org.yaml.snakeyaml.nodes.e) cVar.bEj().get(0)).bEo()));
                    } else {
                        bEb = dVar.bEb();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("expected a mapping of length 1, but found ");
                        stringBuilder.append(dVar2.bEi());
                        throw new ConstructorException("while constructing an ordered map", bEb, stringBuilder.toString(), dVar2.bEb());
                    }
                }
                return linkedHashMap;
            }
            Mark bEb2 = dVar.bEb();
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected a sequence, but found ");
            stringBuilder.append(dVar.bEi());
            throw new ConstructorException("while constructing an ordered map", bEb2, stringBuilder.toString(), dVar.bEb());
        }
    }

    /* compiled from: SafeConstructor */
    public class i extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            StringBuilder stringBuilder;
            if (dVar instanceof org.yaml.snakeyaml.nodes.g) {
                org.yaml.snakeyaml.nodes.g gVar = (org.yaml.snakeyaml.nodes.g) dVar;
                List arrayList = new ArrayList(gVar.bEj().size());
                for (org.yaml.snakeyaml.nodes.d dVar2 : gVar.bEj()) {
                    org.yaml.snakeyaml.nodes.d dVar22;
                    Mark bEb;
                    if (dVar22 instanceof org.yaml.snakeyaml.nodes.c) {
                        org.yaml.snakeyaml.nodes.c cVar = (org.yaml.snakeyaml.nodes.c) dVar22;
                        if (cVar.bEj().size() != 1) {
                            bEb = dVar.bEb();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("expected a single mapping item, but found ");
                            stringBuilder.append(cVar.bEj().size());
                            stringBuilder.append(" items");
                            throw new ConstructorException("while constructing pairs", bEb, stringBuilder.toString(), cVar.bEb());
                        }
                        org.yaml.snakeyaml.nodes.d bEn = ((org.yaml.snakeyaml.nodes.e) cVar.bEj().get(0)).bEn();
                        dVar22 = ((org.yaml.snakeyaml.nodes.e) cVar.bEj().get(0)).bEo();
                        Object d = e.this.d(bEn);
                        Object d2 = e.this.d(dVar22);
                        arrayList.add(new Object[]{d, d2});
                    } else {
                        bEb = dVar.bEb();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("expected a mapping of length 1, but found ");
                        stringBuilder.append(dVar22.bEi());
                        throw new ConstructorException("while constructingpairs", bEb, stringBuilder.toString(), dVar22.bEb());
                    }
                }
                return arrayList;
            }
            Mark bEb2 = dVar.bEb();
            stringBuilder = new StringBuilder();
            stringBuilder.append("expected a sequence, but found ");
            stringBuilder.append(dVar.bEi());
            throw new ConstructorException("while constructing pairs", bEb2, stringBuilder.toString(), dVar.bEb());
        }
    }

    /* compiled from: SafeConstructor */
    public class l extends a {
        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            return e.this.a((org.yaml.snakeyaml.nodes.f) dVar);
        }
    }

    /* compiled from: SafeConstructor */
    public static class m extends a {
        private Calendar calendar;

        public Calendar getCalendar() {
            return this.calendar;
        }

        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            Object value = ((org.yaml.snakeyaml.nodes.f) dVar).getValue();
            Matcher matcher = e.fic.matcher(value);
            String group;
            String group2;
            String group3;
            if (matcher.matches()) {
                group = matcher.group(1);
                group2 = matcher.group(2);
                group3 = matcher.group(3);
                this.calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                this.calendar.clear();
                this.calendar.set(1, Integer.parseInt(group));
                this.calendar.set(2, Integer.parseInt(group2) - 1);
                this.calendar.set(5, Integer.parseInt(group3));
                return this.calendar.getTime();
            }
            matcher = e.fib.matcher(value);
            if (matcher.matches()) {
                TimeZone timeZone;
                group = matcher.group(1);
                group2 = matcher.group(2);
                String group4 = matcher.group(3);
                String group5 = matcher.group(4);
                String group6 = matcher.group(5);
                String group7 = matcher.group(6);
                String group8 = matcher.group(7);
                if (group8 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(group7);
                    stringBuilder.append(".");
                    stringBuilder.append(group8);
                    group7 = stringBuilder.toString();
                }
                double parseDouble = Double.parseDouble(group7);
                int round = (int) Math.round(Math.floor(parseDouble));
                int round2 = (int) Math.round((parseDouble - ((double) round)) * 1000.0d);
                group8 = matcher.group(8);
                group3 = matcher.group(9);
                if (group8 != null) {
                    StringBuilder stringBuilder2;
                    if (group3 != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(":");
                        stringBuilder2.append(group3);
                        group3 = stringBuilder2.toString();
                    } else {
                        group3 = "00";
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("GMT");
                    stringBuilder2.append(group8);
                    stringBuilder2.append(group3);
                    timeZone = TimeZone.getTimeZone(stringBuilder2.toString());
                } else {
                    timeZone = TimeZone.getTimeZone("UTC");
                }
                this.calendar = Calendar.getInstance(timeZone);
                this.calendar.set(1, Integer.parseInt(group));
                this.calendar.set(2, Integer.parseInt(group2) - 1);
                this.calendar.set(5, Integer.parseInt(group4));
                this.calendar.set(11, Integer.parseInt(group5));
                this.calendar.set(12, Integer.parseInt(group6));
                this.calendar.set(13, round);
                this.calendar.set(14, round2);
                return this.calendar.getTime();
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Unexpected timestamp: ");
            stringBuilder3.append(value);
            throw new YAMLException(stringBuilder3.toString());
        }
    }

    static {
        fia.put("yes", Boolean.TRUE);
        fia.put("no", Boolean.FALSE);
        fia.put("true", Boolean.TRUE);
        fia.put("false", Boolean.FALSE);
        fia.put("on", Boolean.TRUE);
        fia.put("off", Boolean.FALSE);
    }

    public e() {
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fjb, new g());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fja, new c());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiX, new e());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiY, new d());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiW, new b());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiZ, new m());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiV, new h());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiU, new i());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fiT, new k());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fjc, new l());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fjd, new j());
        this.fhL.put(org.yaml.snakeyaml.nodes.h.fje, new f());
        this.fhL.put(null, fhZ);
        this.fhK.put(NodeId.scalar, fhZ);
        this.fhK.put(NodeId.sequence, fhZ);
        this.fhK.put(NodeId.mapping, fhZ);
    }

    protected void f(org.yaml.snakeyaml.nodes.c cVar) {
        g(cVar);
        if (cVar.bEk()) {
            cVar.cs(a(cVar, true, new HashMap(), new ArrayList()));
        }
    }

    protected void g(org.yaml.snakeyaml.nodes.c cVar) {
        List<org.yaml.snakeyaml.nodes.e> bEj = cVar.bEj();
        Map hashMap = new HashMap(bEj.size());
        TreeSet treeSet = new TreeSet();
        int i = 0;
        for (org.yaml.snakeyaml.nodes.e eVar : bEj) {
            org.yaml.snakeyaml.nodes.d bEn = eVar.bEn();
            if (!bEn.bDJ().equals(org.yaml.snakeyaml.nodes.h.fiS)) {
                Object d = d(bEn);
                if (d != null) {
                    try {
                        d.hashCode();
                    } catch (Throwable e) {
                        Mark bEb = cVar.bEb();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("found unacceptable key ");
                        stringBuilder.append(d);
                        throw new ConstructorException("while constructing a mapping", bEb, stringBuilder.toString(), eVar.bEn().bEb(), e);
                    }
                }
                Integer num = (Integer) hashMap.put(d, Integer.valueOf(i));
                if (num == null) {
                    continue;
                } else if (bDI()) {
                    treeSet.add(num);
                } else {
                    throw new DuplicateKeyException(cVar.bEb(), d, eVar.bEn().bEb());
                }
            }
            i++;
        }
        Iterator descendingIterator = treeSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            bEj.remove(((Integer) descendingIterator.next()).intValue());
        }
    }

    private List<org.yaml.snakeyaml.nodes.e> a(org.yaml.snakeyaml.nodes.c cVar, boolean z, Map<Object, Integer> map, List<org.yaml.snakeyaml.nodes.e> list) {
        Iterator it = cVar.bEj().iterator();
        while (it.hasNext()) {
            org.yaml.snakeyaml.nodes.e eVar = (org.yaml.snakeyaml.nodes.e) it.next();
            org.yaml.snakeyaml.nodes.d bEn = eVar.bEn();
            org.yaml.snakeyaml.nodes.d bEo = eVar.bEo();
            if (bEn.bDJ().equals(org.yaml.snakeyaml.nodes.h.fiS)) {
                it.remove();
                Mark bEb;
                StringBuilder stringBuilder;
                switch (bEo.bEi()) {
                    case mapping:
                        a((org.yaml.snakeyaml.nodes.c) bEo, false, (Map) map, (List) list);
                        break;
                    case sequence:
                        for (org.yaml.snakeyaml.nodes.d bEo2 : ((org.yaml.snakeyaml.nodes.g) bEo2).bEj()) {
                            if (bEo2 instanceof org.yaml.snakeyaml.nodes.c) {
                                a((org.yaml.snakeyaml.nodes.c) bEo2, false, (Map) map, (List) list);
                            } else {
                                bEb = cVar.bEb();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("expected a mapping for merging, but found ");
                                stringBuilder.append(bEo2.bEi());
                                throw new ConstructorException("while constructing a mapping", bEb, stringBuilder.toString(), bEo2.bEb());
                            }
                        }
                        continue;
                    default:
                        bEb = cVar.bEb();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("expected a mapping or list of mappings for merging, but found ");
                        stringBuilder.append(bEo2.bEi());
                        throw new ConstructorException("while constructing a mapping", bEb, stringBuilder.toString(), bEo2.bEb());
                }
            }
            Object d = d(bEn);
            if (!map.containsKey(d)) {
                list.add(eVar);
                map.put(d, Integer.valueOf(list.size() - 1));
            } else if (z) {
                list.set(((Integer) map.get(d)).intValue(), eVar);
            }
        }
        return list;
    }

    protected void a(org.yaml.snakeyaml.nodes.c cVar, Map<Object, Object> map) {
        f(cVar);
        super.a(cVar, (Map) map);
    }

    protected void a(org.yaml.snakeyaml.nodes.c cVar, Set<Object> set) {
        f(cVar);
        super.a(cVar, (Set) set);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:8:?, code:
            return java.lang.Integer.valueOf(r3, r4);
     */
    /* JADX WARNING: Missing block: B:9:?, code:
            return java.lang.Long.valueOf(r3, r4);
     */
    private java.lang.Number b(int r2, java.lang.String r3, int r4) {
        /*
        r1 = this;
        if (r2 >= 0) goto L_0x0013;
    L_0x0002:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = "-";
        r2.append(r0);
        r2.append(r3);
        r3 = r2.toString();
    L_0x0013:
        r2 = java.lang.Integer.valueOf(r3, r4);	 Catch:{ NumberFormatException -> 0x0018 }
        goto L_0x0022;
    L_0x0018:
        r2 = java.lang.Long.valueOf(r3, r4);	 Catch:{ NumberFormatException -> 0x001d }
        goto L_0x0022;
    L_0x001d:
        r2 = new java.math.BigInteger;
        r2.<init>(r3, r4);
    L_0x0022:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.e.b(int, java.lang.String, int):java.lang.Number");
    }
}
