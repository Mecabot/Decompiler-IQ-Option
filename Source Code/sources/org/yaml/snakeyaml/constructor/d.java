package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.yaml.snakeyaml.constructor.e.m;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.e;
import org.yaml.snakeyaml.nodes.f;
import org.yaml.snakeyaml.nodes.g;
import org.yaml.snakeyaml.nodes.h;

/* compiled from: Constructor */
public class d extends e {

    /* compiled from: Constructor */
    protected class a implements c {
        protected a() {
        }

        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            org.yaml.snakeyaml.nodes.c cVar = (org.yaml.snakeyaml.nodes.c) dVar;
            if (Map.class.isAssignableFrom(dVar.getType())) {
                if (dVar.bEl()) {
                    return d.this.c(cVar);
                }
                return d.this.e(cVar);
            } else if (!Collection.class.isAssignableFrom(dVar.getType())) {
                Object a = d.this.a((org.yaml.snakeyaml.nodes.d) cVar);
                if (dVar.bEl()) {
                    return a;
                }
                return a(cVar, a);
            } else if (dVar.bEl()) {
                return d.this.a((org.yaml.snakeyaml.nodes.b) cVar);
            } else {
                return d.this.d(cVar);
            }
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            if (Map.class.isAssignableFrom(dVar.getType())) {
                d.this.a((org.yaml.snakeyaml.nodes.c) dVar, (Map) obj);
            } else if (Set.class.isAssignableFrom(dVar.getType())) {
                d.this.a((org.yaml.snakeyaml.nodes.c) dVar, (Set) obj);
            } else {
                a((org.yaml.snakeyaml.nodes.c) dVar, obj);
            }
        }

        protected Object a(org.yaml.snakeyaml.nodes.c cVar, Object obj) {
            d.this.f(cVar);
            Class type = cVar.getType();
            for (e eVar : cVar.bEj()) {
                if (eVar.bEn() instanceof f) {
                    f fVar = (f) eVar.bEn();
                    org.yaml.snakeyaml.nodes.d bEo = eVar.bEo();
                    fVar.af(String.class);
                    String str = (String) d.this.d((org.yaml.snakeyaml.nodes.d) fVar);
                    try {
                        org.yaml.snakeyaml.introspector.e f;
                        org.yaml.snakeyaml.b bVar = (org.yaml.snakeyaml.b) d.this.fhU.get(type);
                        if (bVar == null) {
                            f = f(type, str);
                        } else {
                            f = bVar.nV(str);
                        }
                        if (f.isWritable()) {
                            Object a;
                            bEo.af(f.getType());
                            if (!((bVar != null ? bVar.a(str, bEo) : false) || bEo.bEi() == NodeId.scalar)) {
                                Class[] bEh = f.bEh();
                                if (bEh != null && bEh.length > 0) {
                                    if (bEo.bEi() == NodeId.sequence) {
                                        ((g) bEo).ag(bEh[0]);
                                    } else if (Set.class.isAssignableFrom(bEo.getType())) {
                                        Class cls = bEh[0];
                                        org.yaml.snakeyaml.nodes.c cVar2 = (org.yaml.snakeyaml.nodes.c) bEo;
                                        cVar2.ae(cls);
                                        cVar2.w(Boolean.valueOf(true));
                                    } else if (Map.class.isAssignableFrom(bEo.getType())) {
                                        org.yaml.snakeyaml.nodes.c cVar3 = (org.yaml.snakeyaml.nodes.c) bEo;
                                        cVar3.b(bEh[0], bEh[1]);
                                        cVar3.w(Boolean.valueOf(true));
                                    }
                                }
                            }
                            if (bVar != null) {
                                a = a(bVar, str, bEo);
                            } else {
                                a = d.this.d(bEo);
                            }
                            if ((f.getType() == Float.TYPE || f.getType() == Float.class) && (a instanceof Double)) {
                                a = Float.valueOf(((Double) a).floatValue());
                            }
                            if (f.getType() == String.class && h.fiW.equals(bEo.bDJ()) && (a instanceof byte[])) {
                                a = new String((byte[]) a);
                            }
                            if (bVar == null || !bVar.a(obj, str, a)) {
                                f.set(obj, a);
                            }
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("No writable property '");
                            stringBuilder.append(str);
                            stringBuilder.append("' on class: ");
                            stringBuilder.append(type.getName());
                            throw new YAMLException(stringBuilder.toString());
                        }
                    } catch (DuplicateKeyException e) {
                        throw e;
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Cannot create property=");
                        stringBuilder2.append(str);
                        stringBuilder2.append(" for JavaBean=");
                        stringBuilder2.append(obj);
                        throw new ConstructorException(stringBuilder2.toString(), cVar.bEb(), th.getMessage(), bEo.bEb(), th);
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Keys must be scalars but found: ");
                stringBuilder3.append(eVar.bEn());
                throw new YAMLException(stringBuilder3.toString());
            }
            return obj;
        }

        private Object a(org.yaml.snakeyaml.b bVar, String str, org.yaml.snakeyaml.nodes.d dVar) {
            Object b = bVar.b(str, dVar);
            if (b == null) {
                return d.this.d(dVar);
            }
            d.this.fhO.put(dVar, b);
            return d.this.e(dVar);
        }

        protected org.yaml.snakeyaml.introspector.e f(Class<? extends Object> cls, String str) {
            return d.this.bDQ().f(cls, str);
        }
    }

    /* compiled from: Constructor */
    protected class c implements c {
        protected c() {
        }

        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            g gVar = (g) dVar;
            if (Set.class.isAssignableFrom(dVar.getType())) {
                if (!dVar.bEl()) {
                    return d.this.c(gVar);
                }
                throw new YAMLException("Set cannot be recursive.");
            } else if (Collection.class.isAssignableFrom(dVar.getType())) {
                if (dVar.bEl()) {
                    return d.this.a(gVar);
                }
                return d.this.b(gVar);
            } else if (!dVar.getType().isArray()) {
                int i;
                List<Constructor> arrayList = new ArrayList(gVar.bEj().size());
                int i2 = 0;
                for (Constructor constructor : dVar.getType().getDeclaredConstructors()) {
                    if (gVar.bEj().size() == constructor.getParameterTypes().length) {
                        arrayList.add(constructor);
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (arrayList.size() == 1) {
                        Object[] objArr = new Object[gVar.bEj().size()];
                        Constructor constructor2 = (Constructor) arrayList.get(0);
                        for (org.yaml.snakeyaml.nodes.d dVar2 : gVar.bEj()) {
                            dVar2.af(constructor2.getParameterTypes()[i2]);
                            i = i2 + 1;
                            objArr[i2] = d.this.d(dVar2);
                            i2 = i;
                        }
                        try {
                            constructor2.setAccessible(true);
                            return constructor2.newInstance(objArr);
                        } catch (Throwable e) {
                            throw new YAMLException(e);
                        }
                    }
                    List<Object> b = d.this.b(gVar);
                    Class[] clsArr = new Class[b.size()];
                    int i3 = 0;
                    for (Object obj : b) {
                        clsArr[i3] = obj.getClass();
                        i3++;
                    }
                    for (Constructor constructor3 : arrayList) {
                        Object obj2;
                        Class[] parameterTypes = constructor3.getParameterTypes();
                        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                            if (!ad(parameterTypes[i4]).isAssignableFrom(clsArr[i4])) {
                                obj2 = null;
                                continue;
                                break;
                            }
                        }
                        obj2 = 1;
                        continue;
                        if (obj2 != null) {
                            try {
                                constructor3.setAccessible(true);
                                return constructor3.newInstance(b.toArray());
                            } catch (Throwable e2) {
                                throw new YAMLException(e2);
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No suitable constructor with ");
                stringBuilder.append(String.valueOf(gVar.bEj().size()));
                stringBuilder.append(" arguments found for ");
                stringBuilder.append(dVar.getType());
                throw new YAMLException(stringBuilder.toString());
            } else if (dVar.bEl()) {
                return d.this.b(dVar.getType(), gVar.bEj().size());
            } else {
                return d.this.d(gVar);
            }
        }

        private final Class<? extends Object> ad(Class<?> cls) {
            if (!cls.isPrimitive()) {
                return cls;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected primitive ");
            stringBuilder.append(cls);
            throw new YAMLException(stringBuilder.toString());
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            g gVar = (g) dVar;
            if (List.class.isAssignableFrom(dVar.getType())) {
                d.this.a(gVar, (Collection) (List) obj);
            } else if (dVar.getType().isArray()) {
                d.this.a(gVar, obj);
            } else {
                throw new YAMLException("Immutable objects cannot be recursive.");
            }
        }
    }

    /* compiled from: Constructor */
    protected class d implements c {
        protected d() {
        }

        private c f(org.yaml.snakeyaml.nodes.d dVar) {
            dVar.af(d.this.h(dVar));
            return (c) d.this.fhK.get(dVar.bEi());
        }

        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            try {
                return f(dVar).g(dVar);
            } catch (ConstructorException e) {
                throw e;
            } catch (Throwable e2) {
                Throwable th = e2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't construct a java object for ");
                stringBuilder.append(dVar.bDJ());
                stringBuilder.append("; exception=");
                stringBuilder.append(th.getMessage());
                throw new ConstructorException(null, null, stringBuilder.toString(), dVar.bEb(), th);
            }
        }

        public void a(org.yaml.snakeyaml.nodes.d dVar, Object obj) {
            try {
                f(dVar).a(dVar, obj);
            } catch (Throwable e) {
                Throwable th = e;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't construct a second step for a java object for ");
                stringBuilder.append(dVar.bDJ());
                stringBuilder.append("; exception=");
                stringBuilder.append(th.getMessage());
                throw new ConstructorException(null, null, stringBuilder.toString(), dVar.bEb(), th);
            }
        }
    }

    /* compiled from: Constructor */
    protected class b extends a {
        protected b() {
        }

        public Object g(org.yaml.snakeyaml.nodes.d dVar) {
            Object a;
            StringBuilder stringBuilder;
            f fVar = (f) dVar;
            Class type = fVar.getType();
            try {
                return d.this.a(type, fVar, false);
            } catch (InstantiationException unused) {
                if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || h.fiW.equals(fVar.bDJ()) || Calendar.class.isAssignableFrom(type) || type == UUID.class) {
                    a = a(type, fVar);
                } else {
                    Constructor constructor = null;
                    int i = 0;
                    for (Constructor constructor2 : type.getDeclaredConstructors()) {
                        if (constructor2.getParameterTypes().length == 1) {
                            i++;
                            constructor = constructor2;
                        }
                    }
                    if (constructor == null) {
                        try {
                            return d.this.a(type, fVar, false);
                        } catch (InstantiationException e) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("No single argument constructor found for ");
                            stringBuilder.append(type);
                            stringBuilder.append(" : ");
                            stringBuilder.append(e.getMessage());
                            throw new YAMLException(stringBuilder.toString());
                        }
                    }
                    if (i == 1) {
                        a = a(constructor.getParameterTypes()[0], fVar);
                    } else {
                        Object a2 = d.this.a(fVar);
                        try {
                            constructor = type.getDeclaredConstructor(new Class[]{String.class});
                            a = a2;
                        } catch (Throwable e2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Can't construct a java object for scalar ");
                            stringBuilder.append(fVar.bDJ());
                            stringBuilder.append("; No String constructor found. Exception=");
                            stringBuilder.append(e2.getMessage());
                            throw new YAMLException(stringBuilder.toString(), e2);
                        }
                    }
                    try {
                        constructor.setAccessible(true);
                        a = constructor.newInstance(new Object[]{a});
                    } catch (Throwable e22) {
                        Throwable th = e22;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Can't construct a java object for scalar ");
                        stringBuilder2.append(fVar.bDJ());
                        stringBuilder2.append("; exception=");
                        stringBuilder2.append(th.getMessage());
                        throw new ConstructorException(null, null, stringBuilder2.toString(), fVar.bEb(), th);
                    }
                }
                return a;
            }
        }

        private Object a(Class cls, f fVar) {
            if (cls == String.class) {
                return ((c) d.this.fhL.get(h.fjc)).g(fVar);
            }
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return ((c) d.this.fhL.get(h.fja)).g(fVar);
            }
            StringBuilder stringBuilder;
            if (cls == Character.class || cls == Character.TYPE) {
                String str = (String) ((c) d.this.fhL.get(h.fjc)).g(fVar);
                if (str.length() == 0) {
                    return null;
                }
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid node Character: '");
                stringBuilder.append(str);
                stringBuilder.append("'; length: ");
                stringBuilder.append(str.length());
                throw new YAMLException(stringBuilder.toString());
            }
            Date date;
            if (Date.class.isAssignableFrom(cls)) {
                date = (Date) ((c) d.this.fhL.get(h.fiZ)).g(fVar);
                if (cls != Date.class) {
                    try {
                        date = cls.getConstructor(new Class[]{Long.TYPE}).newInstance(new Object[]{Long.valueOf(date.getTime())});
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Cannot construct: '");
                        stringBuilder.append(cls);
                        stringBuilder.append("'");
                        throw new YAMLException(stringBuilder.toString());
                    }
                }
            } else if (cls == Float.class || cls == Double.class || cls == Float.TYPE || cls == Double.TYPE || cls == BigDecimal.class) {
                if (cls == BigDecimal.class) {
                    return new BigDecimal(fVar.getValue());
                }
                date = ((c) d.this.fhL.get(h.fiY)).g(fVar);
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(((Double) date).floatValue());
                }
            } else if (cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == BigInteger.class || cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE) {
                Object g = ((c) d.this.fhL.get(h.fiX)).g(fVar);
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(g.toString());
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(g.toString());
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(Integer.parseInt(g.toString()));
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(g.toString());
                }
                return new BigInteger(g.toString());
            } else if (Enum.class.isAssignableFrom(cls)) {
                String value = fVar.getValue();
                try {
                    return Enum.valueOf(cls, value);
                } catch (Exception unused2) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Unable to find enum value '");
                    stringBuilder2.append(value);
                    stringBuilder2.append("' for enum class: ");
                    stringBuilder2.append(cls.getName());
                    throw new YAMLException(stringBuilder2.toString());
                }
            } else if (Calendar.class.isAssignableFrom(cls)) {
                m mVar = new m();
                mVar.g(fVar);
                return mVar.getCalendar();
            } else if (Number.class.isAssignableFrom(cls)) {
                return new org.yaml.snakeyaml.constructor.e.d().g(fVar);
            } else {
                if (UUID.class == cls) {
                    return UUID.fromString(fVar.getValue());
                }
                if (d.this.fhL.containsKey(fVar.bDJ())) {
                    return ((c) d.this.fhL.get(fVar.bDJ())).g(fVar);
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported class: ");
                stringBuilder.append(cls);
                throw new YAMLException(stringBuilder.toString());
            }
            return date;
        }
    }

    public d() {
        this(Object.class);
    }

    public d(Class<? extends Object> cls) {
        this(new org.yaml.snakeyaml.b(ac(cls)));
    }

    private static Class<? extends Object> ac(Class<? extends Object> cls) {
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("Root class must be provided.");
    }

    public d(org.yaml.snakeyaml.b bVar) {
        this(bVar, null);
    }

    public d(org.yaml.snakeyaml.b bVar, Collection<org.yaml.snakeyaml.b> collection) {
        if (bVar == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        this.fhL.put(null, new d());
        if (!Object.class.equals(bVar.getType())) {
            this.fhS = new h(bVar.getType());
        }
        this.fhK.put(NodeId.scalar, new b());
        this.fhK.put(NodeId.mapping, new a());
        this.fhK.put(NodeId.sequence, new c());
        a(bVar);
        if (collection != null) {
            for (org.yaml.snakeyaml.b a : collection) {
                a(a);
            }
        }
    }

    protected Class<?> h(org.yaml.snakeyaml.nodes.d dVar) {
        Class<?> cls = (Class) this.fhV.get(dVar.bDJ());
        if (cls != null) {
            return cls;
        }
        String className = dVar.bDJ().getClassName();
        try {
            Class<?> nZ = nZ(className);
            this.fhV.put(dVar.bDJ(), nZ);
            return nZ;
        } catch (ClassNotFoundException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class not found: ");
            stringBuilder.append(className);
            throw new YAMLException(stringBuilder.toString());
        }
    }

    protected Class<?> nZ(String str) {
        try {
            return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException unused) {
            return Class.forName(str);
        }
    }
}
