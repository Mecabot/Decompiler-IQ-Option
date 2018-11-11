package org.yaml.snakeyaml.introspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: MethodProperty */
public class c extends b {
    private final PropertyDescriptor fiy;
    private final boolean readable;
    private final boolean writable;

    private static Type a(PropertyDescriptor propertyDescriptor) {
        Method readMethod = propertyDescriptor.getReadMethod();
        if (readMethod != null) {
            return readMethod.getGenericReturnType();
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod != null) {
            Type[] genericParameterTypes = writeMethod.getGenericParameterTypes();
            if (genericParameterTypes.length > 0) {
                return genericParameterTypes[0];
            }
        }
        return null;
    }

    public c(PropertyDescriptor propertyDescriptor) {
        super(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), a(propertyDescriptor));
        this.fiy = propertyDescriptor;
        boolean z = false;
        this.readable = propertyDescriptor.getReadMethod() != null;
        if (propertyDescriptor.getWriteMethod() != null) {
            z = true;
        }
        this.writable = z;
    }

    public void set(Object obj, Object obj2) {
        if (this.writable) {
            this.fiy.getWriteMethod().invoke(obj, new Object[]{obj2});
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No writable property '");
        stringBuilder.append(getName());
        stringBuilder.append("' on class: ");
        stringBuilder.append(obj.getClass().getName());
        throw new YAMLException(stringBuilder.toString());
    }

    public boolean isWritable() {
        return this.writable;
    }
}
