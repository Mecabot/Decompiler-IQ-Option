package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* compiled from: ReflectionToStringBuilder */
public class a extends b {
    private boolean fbA = false;
    protected String[] fbB;
    private Class<?> fbC = null;
    private boolean fbz = false;

    public static String toString(Object obj) {
        return a(obj, null, false, false, null);
    }

    public static <T> String a(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        return new a(t, toStringStyle, null, cls, z, z2).toString();
    }

    public <T> a(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(t, toStringStyle, stringBuffer);
        Z(cls);
        hl(z);
        hk(z2);
    }

    protected boolean f(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !bAo()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !bAn()) {
            return false;
        }
        if (this.fbB == null || Arrays.binarySearch(this.fbB, field.getName()) < 0) {
            return true;
        }
        return false;
    }

    protected void Y(Class<?> cls) {
        if (cls.isArray()) {
            dp(getObject());
            return;
        }
        AccessibleObject[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (f(field)) {
                try {
                    s(name, g(field));
                } catch (IllegalAccessException e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected IllegalAccessException: ");
                    stringBuilder.append(e.getMessage());
                    throw new InternalError(stringBuilder.toString());
                }
            }
        }
    }

    public Class<?> bAm() {
        return this.fbC;
    }

    protected Object g(Field field) {
        return field.get(getObject());
    }

    public boolean bAn() {
        return this.fbz;
    }

    public boolean bAo() {
        return this.fbA;
    }

    public a dp(Object obj) {
        bAr().d(bAq(), null, obj);
        return this;
    }

    public void hk(boolean z) {
        this.fbz = z;
    }

    public void hl(boolean z) {
        this.fbA = z;
    }

    public void Z(Class<?> cls) {
        if (cls != null) {
            Object object = getObject();
            if (!(object == null || cls.isInstance(object))) {
                throw new IllegalArgumentException("Specified class is not a superclass of the object");
            }
        }
        this.fbC = cls;
    }

    public String toString() {
        if (getObject() == null) {
            return bAr().bAu();
        }
        Class cls = getObject().getClass();
        Y(cls);
        while (cls.getSuperclass() != null && cls != bAm()) {
            cls = cls.getSuperclass();
            Y(cls);
        }
        return super.toString();
    }
}
