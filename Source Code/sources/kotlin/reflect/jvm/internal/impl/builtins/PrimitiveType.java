package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;

public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    private b arrayTypeFqName;
    private final f arrayTypeName;
    private b typeFqName;
    private final f typeName;

    static {
        NUMBER_TYPES = Collections.unmodifiableSet(EnumSet.of(CHAR, new PrimitiveType[]{BYTE, SHORT, INT, FLOAT, LONG, DOUBLE}));
    }

    private PrimitiveType(String str) {
        this.typeFqName = null;
        this.arrayTypeFqName = null;
        this.typeName = f.mD(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("Array");
        this.arrayTypeName = f.mD(stringBuilder.toString());
    }

    public f getTypeName() {
        return this.typeName;
    }

    public f getArrayTypeName() {
        return this.arrayTypeName;
    }
}
