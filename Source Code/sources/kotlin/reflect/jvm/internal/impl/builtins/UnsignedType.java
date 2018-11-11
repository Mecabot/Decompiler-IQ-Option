package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(r3),
    USHORT(r3),
    UINT(r3),
    ULONG(r3);
    
    private final a arrayClassId;
    private final f arrayTypeName;
    private final a classId;
    private final f typeName;

    protected UnsignedType(a aVar) {
        h.e(aVar, "classId");
        this.classId = aVar;
        this.typeName = this.classId.btH();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.typeName.asString());
        stringBuilder.append("Array");
        this.arrayTypeName = f.mD(stringBuilder.toString());
        this.arrayClassId = new a(this.classId.getPackageFqName(), this.arrayTypeName);
    }

    public final a getClassId() {
        return this.classId;
    }

    public final f getTypeName() {
        return this.typeName;
    }

    public final a getArrayClassId() {
        return this.arrayClassId;
    }
}
