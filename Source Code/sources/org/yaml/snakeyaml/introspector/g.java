package org.yaml.snakeyaml.introspector;

import java.beans.FeatureDescriptor;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.d.b;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: PropertyUtils */
public class g {
    private BeanAccess fhB;
    private boolean fhi;
    private final Map<Class<?>, Map<String, e>> fiE;
    private final Map<Class<?>, Set<e>> fiF;
    private boolean fiG;
    private b fiH;

    /* compiled from: PropertyUtils */
    /* renamed from: org.yaml.snakeyaml.introspector.g$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fiI = new int[BeanAccess.values().length];

        static {
            try {
                fiI[BeanAccess.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public g() {
        this(new b());
    }

    g(b bVar) {
        this.fiE = new HashMap();
        this.fiF = new HashMap();
        this.fhB = BeanAccess.DEFAULT;
        this.fhi = false;
        this.fiG = false;
        this.fiH = bVar;
        if (bVar.bFB()) {
            this.fhB = BeanAccess.FIELD;
        }
    }

    protected Map<String, e> a(Class<?> cls, BeanAccess beanAccess) {
        if (this.fiE.containsKey(cls)) {
            return (Map) this.fiE.get(cls);
        }
        Map<String, e> linkedHashMap = new LinkedHashMap();
        Object obj = null;
        Class cls2;
        if (AnonymousClass1.fiI[beanAccess.ordinal()] != 1) {
            try {
                for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if ((readMethod == null || !readMethod.getName().equals("getClass")) && !a(propertyDescriptor)) {
                        linkedHashMap.put(propertyDescriptor.getName(), new c(propertyDescriptor));
                    }
                }
                cls2 = cls;
                Object obj2 = null;
                while (cls2 != null) {
                    Object obj3 = obj2;
                    for (Field field : cls2.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (!(Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers))) {
                            if (Modifier.isPublic(modifiers)) {
                                linkedHashMap.put(field.getName(), new a(field));
                            } else {
                                obj3 = 1;
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                    obj2 = obj3;
                }
                obj = obj2;
            } catch (Throwable e) {
                throw new YAMLException(e);
            }
        }
        for (cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field field2 : cls2.getDeclaredFields()) {
                int modifiers2 = field2.getModifiers();
                if (!(Modifier.isStatic(modifiers2) || Modifier.isTransient(modifiers2) || linkedHashMap.containsKey(field2.getName()))) {
                    linkedHashMap.put(field2.getName(), new a(field2));
                }
            }
        }
        if (!linkedHashMap.isEmpty() || obj == null) {
            this.fiE.put(cls, linkedHashMap);
            return linkedHashMap;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No JavaBean properties found in ");
        stringBuilder.append(cls.getName());
        throw new YAMLException(stringBuilder.toString());
    }

    private boolean a(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue("transient"));
    }

    public e f(Class<? extends Object> cls, String str) {
        return a(cls, str, this.fhB);
    }

    public e a(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        e eVar = (e) a(cls, beanAccess).get(str);
        if (eVar == null && this.fiG) {
            eVar = new d(str);
        }
        if (eVar != null) {
            return eVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find property '");
        stringBuilder.append(str);
        stringBuilder.append("' on class: ");
        stringBuilder.append(cls.getName());
        throw new YAMLException(stringBuilder.toString());
    }

    public void hu(boolean z) {
        if (this.fhi != z) {
            this.fhi = z;
            this.fiF.clear();
        }
    }

    public boolean bDH() {
        return this.fhi;
    }
}
