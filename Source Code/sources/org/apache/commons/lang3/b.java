package org.apache.commons.lang3;

import com.iqoption.dto.entity.position.Position;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ClassUtils */
public class b {
    public static final String eZT = String.valueOf('.');
    public static final String eZU = String.valueOf('$');
    private static final Map<Class<?>, Class<?>> eZV = new HashMap();
    private static final Map<Class<?>, Class<?>> eZW = new HashMap();
    private static final Map<String, String> eZX = new HashMap();
    private static final Map<String, String> eZY = new HashMap();

    static {
        eZV.put(Boolean.TYPE, Boolean.class);
        eZV.put(Byte.TYPE, Byte.class);
        eZV.put(Character.TYPE, Character.class);
        eZV.put(Short.TYPE, Short.class);
        eZV.put(Integer.TYPE, Integer.class);
        eZV.put(Long.TYPE, Long.class);
        eZV.put(Double.TYPE, Double.class);
        eZV.put(Float.TYPE, Float.class);
        eZV.put(Void.TYPE, Void.TYPE);
        for (Class cls : eZV.keySet()) {
            Class cls2 = (Class) eZV.get(cls);
            if (!cls.equals(cls2)) {
                eZW.put(cls2, cls);
            }
        }
        bk("int", "I");
        bk("boolean", "Z");
        bk("float", "F");
        bk(Position.TYPE_LONG, "J");
        bk(Position.TYPE_SHORT, "S");
        bk("byte", "B");
        bk("double", "D");
        bk("char", "C");
    }

    private static void bk(String str, String str2) {
        eZX.put(str, str2);
        eZY.put(str2, str);
    }

    public static String X(Class<?> cls) {
        return cls == null ? "" : ng(cls.getName());
    }

    public static String ng(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                stringBuilder.append("[]");
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
        }
        if (eZY.containsKey(str)) {
            str = (String) eZY.get(str);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            i = lastIndexOf + 1;
        }
        i = str.indexOf(36, i);
        str = str.substring(lastIndexOf + 1);
        if (i != -1) {
            str = str.replace('$', '.');
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }
}
