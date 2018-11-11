package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;

/* compiled from: JavaTypeResolver.kt */
public final class a {
    private final TypeUsage eIj;
    private final JavaTypeFlexibility eIk;
    private final boolean eIl;
    private final an eIm;

    public static /* bridge */ /* synthetic */ a a(a aVar, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, an anVar, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = aVar.eIj;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = aVar.eIk;
        }
        if ((i & 4) != 0) {
            z = aVar.eIl;
        }
        if ((i & 8) != 0) {
            anVar = aVar.eIm;
        }
        return aVar.a(typeUsage, javaTypeFlexibility, z, anVar);
    }

    public final a a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, an anVar) {
        h.e(typeUsage, "howThisTypeIsUsed");
        h.e(javaTypeFlexibility, "flexibility");
        return new a(typeUsage, javaTypeFlexibility, z, anVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.eIj, aVar.eIj) && h.E(this.eIk, aVar.eIk)) {
                return (this.eIl == aVar.eIl ? 1 : null) != null && h.E(this.eIm, aVar.eIm);
            }
        }
    }

    public int hashCode() {
        TypeUsage typeUsage = this.eIj;
        int i = 0;
        int hashCode = (typeUsage != null ? typeUsage.hashCode() : 0) * 31;
        JavaTypeFlexibility javaTypeFlexibility = this.eIk;
        hashCode = (hashCode + (javaTypeFlexibility != null ? javaTypeFlexibility.hashCode() : 0)) * 31;
        int i2 = this.eIl;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        an anVar = this.eIm;
        if (anVar != null) {
            i = anVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JavaTypeAttributes(howThisTypeIsUsed=");
        stringBuilder.append(this.eIj);
        stringBuilder.append(", flexibility=");
        stringBuilder.append(this.eIk);
        stringBuilder.append(", isForAnnotationParameter=");
        stringBuilder.append(this.eIl);
        stringBuilder.append(", upperBoundOfTypeParameter=");
        stringBuilder.append(this.eIm);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, an anVar) {
        h.e(typeUsage, "howThisTypeIsUsed");
        h.e(javaTypeFlexibility, "flexibility");
        this.eIj = typeUsage;
        this.eIk = javaTypeFlexibility;
        this.eIl = z;
        this.eIm = anVar;
    }

    public final TypeUsage bhc() {
        return this.eIj;
    }

    public /* synthetic */ a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, an anVar, int i, f fVar) {
        if ((i & 2) != 0) {
            javaTypeFlexibility = JavaTypeFlexibility.INFLEXIBLE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            anVar = (an) null;
        }
        this(typeUsage, javaTypeFlexibility, z, anVar);
    }

    public final JavaTypeFlexibility bhd() {
        return this.eIk;
    }

    public final boolean bhe() {
        return this.eIl;
    }

    public final an bhf() {
        return this.eIm;
    }

    public final a a(JavaTypeFlexibility javaTypeFlexibility) {
        h.e(javaTypeFlexibility, "flexibility");
        return a(this, null, javaTypeFlexibility, false, null, 13, null);
    }
}
