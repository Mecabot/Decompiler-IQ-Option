package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: GenericProperty */
public abstract class b extends e {
    private Type fiv;
    private boolean fiw;
    private Class<?>[] fix;

    public b(String str, Class<?> cls, Type type) {
        super(str, cls);
        this.fiv = type;
        this.fiw = type == null;
    }

    public Class<?>[] bEh() {
        if (!this.fiw) {
            if (this.fiv instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) this.fiv).getActualTypeArguments();
                if (actualTypeArguments.length > 0) {
                    this.fix = new Class[actualTypeArguments.length];
                    for (int i = 0; i < actualTypeArguments.length; i++) {
                        if (!(actualTypeArguments[i] instanceof Class)) {
                            if (!(actualTypeArguments[i] instanceof ParameterizedType)) {
                                if (!(actualTypeArguments[i] instanceof GenericArrayType)) {
                                    this.fix = null;
                                    break;
                                }
                                Type genericComponentType = ((GenericArrayType) actualTypeArguments[i]).getGenericComponentType();
                                if (!(genericComponentType instanceof Class)) {
                                    this.fix = null;
                                    break;
                                }
                                this.fix[i] = Array.newInstance((Class) genericComponentType, 0).getClass();
                            } else {
                                this.fix[i] = (Class) ((ParameterizedType) actualTypeArguments[i]).getRawType();
                            }
                        } else {
                            this.fix[i] = (Class) actualTypeArguments[i];
                        }
                    }
                }
            } else if (this.fiv instanceof GenericArrayType) {
                if (((GenericArrayType) this.fiv).getGenericComponentType() instanceof Class) {
                    this.fix = new Class[]{(Class) ((GenericArrayType) this.fiv).getGenericComponentType()};
                }
            } else if ((this.fiv instanceof Class) && ((Class) this.fiv).isArray()) {
                this.fix = new Class[1];
                this.fix[0] = getType().getComponentType();
            }
            this.fiw = true;
        }
        return this.fix;
    }
}
