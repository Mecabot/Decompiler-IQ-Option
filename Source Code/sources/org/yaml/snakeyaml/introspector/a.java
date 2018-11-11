package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Field;

/* compiled from: FieldProperty */
public class a extends b {
    private final Field field;

    public a(Field field) {
        super(field.getName(), field.getType(), field.getGenericType());
        this.field = field;
        field.setAccessible(true);
    }

    public void set(Object obj, Object obj2) {
        this.field.set(obj, obj2);
    }
}
