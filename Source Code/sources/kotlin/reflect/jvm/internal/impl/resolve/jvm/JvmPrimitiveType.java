package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.iqoption.dto.entity.position.Position;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.b;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, Position.TYPE_SHORT, "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, Position.TYPE_LONG, "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = null;
    private static final Set<b> WRAPPERS_CLASS_NAMES = null;
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final b wrapperFqName;

    static {
        WRAPPERS_CLASS_NAMES = new HashSet();
        TYPE_BY_NAME = new HashMap();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
        JvmPrimitiveType[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i];
            WRAPPERS_CLASS_NAMES.add(jvmPrimitiveType.getWrapperFqName());
            TYPE_BY_NAME.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            TYPE_BY_PRIMITIVE_TYPE.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            i++;
        }
    }

    public static JvmPrimitiveType get(String str) {
        JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType) TYPE_BY_NAME.get(str);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Non-primitive type name passed: ");
        stringBuilder.append(str);
        throw new AssertionError(stringBuilder.toString());
    }

    public static JvmPrimitiveType get(PrimitiveType primitiveType) {
        return (JvmPrimitiveType) TYPE_BY_PRIMITIVE_TYPE.get(primitiveType);
    }

    private JvmPrimitiveType(PrimitiveType primitiveType, String str, String str2, String str3) {
        this.primitiveType = primitiveType;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new b(str3);
    }

    public PrimitiveType getPrimitiveType() {
        return this.primitiveType;
    }

    public String getJavaKeywordName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public b getWrapperFqName() {
        return this.wrapperFqName;
    }
}
