package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: PropertySubstitute */
public class f extends e {
    private static final Logger log = Logger.getLogger(f.class.getPackage().getName());
    private final String fiA;
    private transient Method fiB;
    private e fiC;
    private boolean fiD;
    private Field field;
    protected Class<?> fiz;
    protected Class<?>[] parameters;

    public Class<?>[] bEh() {
        if (this.parameters != null || this.fiC == null) {
            return this.parameters;
        }
        return this.fiC.bEh();
    }

    public void set(Object obj, Object obj2) {
        if (this.fiB != null) {
            if (!this.fiD) {
                this.fiB.invoke(obj, new Object[]{obj2});
            } else if (obj2 == null) {
            } else {
                if (obj2 instanceof Collection) {
                    for (Object next : (Collection) obj2) {
                        this.fiB.invoke(obj, new Object[]{next});
                    }
                } else if (obj2 instanceof Map) {
                    for (Entry entry : ((Map) obj2).entrySet()) {
                        this.fiB.invoke(obj, new Object[]{entry.getKey(), entry.getValue()});
                    }
                } else if (obj2.getClass().isArray()) {
                    int length = Array.getLength(obj2);
                    for (int i = 0; i < length; i++) {
                        this.fiB.invoke(obj, new Object[]{Array.get(obj2, i)});
                    }
                }
            }
        } else if (this.field != null) {
            this.field.set(obj, obj2);
        } else if (this.fiC != null) {
            this.fiC.set(obj, obj2);
        } else {
            Logger logger = log;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No setter/delegate for '");
            stringBuilder.append(getName());
            stringBuilder.append("' on object ");
            stringBuilder.append(obj);
            logger.warning(stringBuilder.toString());
        }
    }

    private Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Class cls2;
        while (cls2 != null) {
            for (Method method : cls2.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != clsArr.length) {
                        continue;
                    } else {
                        Object obj = 1;
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (!parameterTypes[i].isAssignableFrom(clsArr[i])) {
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            method.setAccessible(true);
                            return method;
                        }
                    }
                }
            }
            cls2 = cls2.getSuperclass();
        }
        if (log.isLoggable(Level.FINE)) {
            log.fine(String.format("Failed to find [%s(%d args)] for %s.%s", new Object[]{str, Integer.valueOf(clsArr.length), this.fiz.getName(), getName()}));
        }
        return null;
    }

    public String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        return this.fiC != null ? this.fiC.getName() : null;
    }

    public Class<?> getType() {
        Class<?> type = super.getType();
        if (type != null) {
            return type;
        }
        return this.fiC != null ? this.fiC.getType() : null;
    }

    public boolean isWritable() {
        return (this.fiB == null && this.field == null && (this.fiC == null || !this.fiC.isWritable())) ? false : true;
    }

    public void b(e eVar) {
        this.fiC = eVar;
        if (this.fiA != null && this.fiB == null && !this.fiD) {
            this.fiD = true;
            this.fiB = c(this.fiz, this.fiA, bEh());
        }
    }
}
