package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.g;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.c;
import org.yaml.snakeyaml.nodes.d;
import org.yaml.snakeyaml.nodes.e;
import org.yaml.snakeyaml.nodes.f;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: BaseConstructor */
public abstract class b {
    protected final Map<NodeId, c> fhK = new EnumMap(NodeId.class);
    protected final Map<h, c> fhL = new HashMap();
    protected final Map<String, c> fhM = new HashMap();
    protected org.yaml.snakeyaml.composer.a fhN;
    final Map<d, Object> fhO = new HashMap();
    private final Set<d> fhP = new HashSet();
    private final ArrayList<a<Map<Object, Object>, a<Object, Object>>> fhQ = new ArrayList();
    private final ArrayList<a<Set<Object>, Object>> fhR = new ArrayList();
    protected h fhS = null;
    private boolean fhT = false;
    protected final Map<Class<? extends Object>, org.yaml.snakeyaml.b> fhU = new HashMap();
    protected final Map<h, Class<? extends Object>> fhV = new HashMap();
    private boolean fhu = true;
    private g fhx;

    /* compiled from: BaseConstructor */
    private static class a<T, K> {
        private final T fhW;
        private final K fhX;

        public a(T t, K k) {
            this.fhW = t;
            this.fhX = k;
        }

        public K bDS() {
            return this.fhX;
        }

        public T bDT() {
            return this.fhW;
        }
    }

    public b() {
        this.fhU.put(SortedMap.class, new org.yaml.snakeyaml.b(SortedMap.class, h.fiV, TreeMap.class));
        this.fhU.put(SortedSet.class, new org.yaml.snakeyaml.b(SortedSet.class, h.fiT, TreeSet.class));
    }

    public void a(org.yaml.snakeyaml.composer.a aVar) {
        this.fhN = aVar;
    }

    public Object ab(Class<?> cls) {
        d bDL = this.fhN.bDL();
        if (bDL == null || h.fjb.equals(bDL.bDJ())) {
            return null;
        }
        if (Object.class != cls) {
            bDL.a(new h((Class) cls));
        } else if (this.fhS != null) {
            bDL.a(this.fhS);
        }
        return c(bDL);
    }

    protected final Object c(d dVar) {
        Object d = d(dVar);
        bDN();
        this.fhO.clear();
        this.fhP.clear();
        return d;
    }

    private void bDN() {
        Iterator it;
        a aVar;
        if (!this.fhQ.isEmpty()) {
            it = this.fhQ.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                a aVar2 = (a) aVar.bDS();
                ((Map) aVar.bDT()).put(aVar2.bDT(), aVar2.bDS());
            }
            this.fhQ.clear();
        }
        if (!this.fhR.isEmpty()) {
            it = this.fhR.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                ((Set) aVar.bDT()).add(aVar.bDS());
            }
            this.fhR.clear();
        }
    }

    protected Object d(d dVar) {
        if (this.fhO.containsKey(dVar)) {
            return this.fhO.get(dVar);
        }
        return e(dVar);
    }

    protected Object e(d dVar) {
        if (this.fhP.contains(dVar)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", dVar.bEb());
        }
        Object obj;
        this.fhP.add(dVar);
        c f = f(dVar);
        if (this.fhO.containsKey(dVar)) {
            obj = this.fhO.get(dVar);
        } else {
            obj = f.g(dVar);
        }
        b(dVar, obj);
        this.fhO.put(dVar, obj);
        this.fhP.remove(dVar);
        if (dVar.bEl()) {
            f.a(dVar, obj);
        }
        return obj;
    }

    protected c f(d dVar) {
        if (dVar.bEm()) {
            return (c) this.fhK.get(dVar.bEi());
        }
        c cVar = (c) this.fhL.get(dVar.bDJ());
        if (cVar != null) {
            return cVar;
        }
        for (String str : this.fhM.keySet()) {
            if (dVar.bDJ().startsWith(str)) {
                return (c) this.fhM.get(str);
            }
        }
        return (c) this.fhL.get(null);
    }

    protected Object a(f fVar) {
        return fVar.getValue();
    }

    protected List<Object> nn(int i) {
        return new ArrayList(i);
    }

    protected Set<Object> no(int i) {
        return new LinkedHashSet(i);
    }

    protected Map<Object, Object> bDO() {
        return new LinkedHashMap();
    }

    protected Set<Object> bDP() {
        return new LinkedHashSet();
    }

    protected Object b(Class<?> cls, int i) {
        return Array.newInstance(cls.getComponentType(), i);
    }

    protected Object b(d dVar, Object obj) {
        Class type = dVar.getType();
        return this.fhU.containsKey(type) ? ((org.yaml.snakeyaml.b) this.fhU.get(type)).ds(obj) : obj;
    }

    protected Object a(d dVar) {
        try {
            return a(Object.class, dVar);
        } catch (Throwable e) {
            throw new YAMLException(e);
        }
    }

    protected final Object a(Class<?> cls, d dVar) {
        return a(cls, dVar, true);
    }

    protected Object a(Class<?> cls, d dVar, boolean z) {
        Class type = dVar.getType();
        if (this.fhU.containsKey(type)) {
            Object a = ((org.yaml.snakeyaml.b) this.fhU.get(type)).a(dVar);
            if (a != null) {
                return a;
            }
        }
        if (z && cls.isAssignableFrom(type) && !Modifier.isAbstract(type.getModifiers())) {
            try {
                Constructor declaredConstructor = type.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (NoSuchMethodException e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NoSuchMethodException:");
                stringBuilder.append(e.getLocalizedMessage());
                throw new InstantiationException(stringBuilder.toString());
            } catch (Throwable e2) {
                throw new YAMLException(e2);
            }
        }
        throw new InstantiationException();
    }

    protected Set<Object> a(org.yaml.snakeyaml.nodes.b<?> bVar) {
        try {
            return (Set) a(Set.class, (d) bVar);
        } catch (InstantiationException unused) {
            return no(bVar.bEj().size());
        }
    }

    protected List<Object> a(org.yaml.snakeyaml.nodes.g gVar) {
        try {
            return (List) a(List.class, (d) gVar);
        } catch (InstantiationException unused) {
            return nn(gVar.bEj().size());
        }
    }

    protected Map<Object, Object> c(c cVar) {
        try {
            return (Map) a(Map.class, (d) cVar);
        } catch (InstantiationException unused) {
            return bDO();
        }
    }

    protected List<? extends Object> b(org.yaml.snakeyaml.nodes.g gVar) {
        Collection a = a(gVar);
        a(gVar, a);
        return a;
    }

    protected Set<? extends Object> c(org.yaml.snakeyaml.nodes.g gVar) {
        Collection a = a((org.yaml.snakeyaml.nodes.b) gVar);
        a(gVar, a);
        return a;
    }

    protected Object d(org.yaml.snakeyaml.nodes.g gVar) {
        return a(gVar, b(gVar.getType(), gVar.bEj().size()));
    }

    protected void a(org.yaml.snakeyaml.nodes.g gVar, Collection<Object> collection) {
        for (d d : gVar.bEj()) {
            collection.add(d(d));
        }
    }

    protected Object a(org.yaml.snakeyaml.nodes.g gVar, Object obj) {
        Class componentType = gVar.getType().getComponentType();
        int i = 0;
        for (d dVar : gVar.bEj()) {
            if (dVar.getType() == Object.class) {
                dVar.af(componentType);
            }
            Object d = d(dVar);
            if (!componentType.isPrimitive()) {
                Array.set(obj, i, d);
            } else if (d == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to construct element value for ");
                stringBuilder.append(dVar);
                throw new NullPointerException(stringBuilder.toString());
            } else if (Byte.TYPE.equals(componentType)) {
                Array.setByte(obj, i, ((Number) d).byteValue());
            } else if (Short.TYPE.equals(componentType)) {
                Array.setShort(obj, i, ((Number) d).shortValue());
            } else if (Integer.TYPE.equals(componentType)) {
                Array.setInt(obj, i, ((Number) d).intValue());
            } else if (Long.TYPE.equals(componentType)) {
                Array.setLong(obj, i, ((Number) d).longValue());
            } else if (Float.TYPE.equals(componentType)) {
                Array.setFloat(obj, i, ((Number) d).floatValue());
            } else if (Double.TYPE.equals(componentType)) {
                Array.setDouble(obj, i, ((Number) d).doubleValue());
            } else if (Character.TYPE.equals(componentType)) {
                Array.setChar(obj, i, ((Character) d).charValue());
            } else if (Boolean.TYPE.equals(componentType)) {
                Array.setBoolean(obj, i, ((Boolean) d).booleanValue());
            } else {
                throw new YAMLException("unexpected primitive type");
            }
            i++;
        }
        return obj;
    }

    protected Set<Object> d(c cVar) {
        Set a = a((org.yaml.snakeyaml.nodes.b) cVar);
        a(cVar, a);
        return a;
    }

    protected Map<Object, Object> e(c cVar) {
        Map c = c(cVar);
        a(cVar, c);
        return c;
    }

    protected void a(c cVar, Map<Object, Object> map) {
        for (e eVar : cVar.bEj()) {
            d bEn = eVar.bEn();
            d bEo = eVar.bEo();
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
            Object d2 = d(bEo);
            if (bEn.bEl()) {
                this.fhQ.add(0, new a(map, new a(d, d2)));
            } else {
                map.put(d, d2);
            }
        }
    }

    protected void a(c cVar, Set<Object> set) {
        for (e eVar : cVar.bEj()) {
            d bEn = eVar.bEn();
            Object d = d(bEn);
            if (d != null) {
                try {
                    d.hashCode();
                } catch (Throwable e) {
                    Mark bEb = cVar.bEb();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("found unacceptable key ");
                    stringBuilder.append(d);
                    throw new ConstructorException("while constructing a Set", bEb, stringBuilder.toString(), eVar.bEn().bEb(), e);
                }
            }
            if (bEn.bEl()) {
                this.fhR.add(0, new a(set, d));
            } else {
                set.add(d);
            }
        }
    }

    public void a(g gVar) {
        this.fhx = gVar;
        this.fhT = true;
        for (org.yaml.snakeyaml.b a : this.fhU.values()) {
            a.a(gVar);
        }
    }

    public final g bDQ() {
        if (this.fhx == null) {
            this.fhx = new g();
        }
        return this.fhx;
    }

    public org.yaml.snakeyaml.b a(org.yaml.snakeyaml.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.fhV.put(bVar.bDJ(), bVar.getType());
        bVar.a(bDQ());
        return (org.yaml.snakeyaml.b) this.fhU.put(bVar.getType(), bVar);
    }

    public final boolean bDR() {
        return this.fhT;
    }

    public boolean bDI() {
        return this.fhu;
    }

    public void hv(boolean z) {
        this.fhu = z;
    }
}
