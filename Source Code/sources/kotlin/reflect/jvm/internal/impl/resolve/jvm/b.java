package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.a;

/* compiled from: JvmClassName */
public class b {
    private kotlin.reflect.jvm.internal.impl.name.b eBM;
    private final String eJS;

    public static b mR(String str) {
        return new b(str);
    }

    public static b j(a aVar) {
        kotlin.reflect.jvm.internal.impl.name.b packageFqName = aVar.getPackageFqName();
        String replace = aVar.btG().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new b(replace);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageFqName.asString().replace('.', '/'));
        stringBuilder.append("/");
        stringBuilder.append(replace);
        return new b(stringBuilder.toString());
    }

    public static b u(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        b bVar2 = new b(bVar.asString().replace('.', '/'));
        bVar2.eBM = bVar;
        return bVar2;
    }

    private b(String str) {
        this.eJS = str;
    }

    public kotlin.reflect.jvm.internal.impl.name.b bwK() {
        return new kotlin.reflect.jvm.internal.impl.name.b(this.eJS.replace('/', '.'));
    }

    public kotlin.reflect.jvm.internal.impl.name.b getPackageFqName() {
        int lastIndexOf = this.eJS.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return kotlin.reflect.jvm.internal.impl.name.b.eNc;
        }
        return new kotlin.reflect.jvm.internal.impl.name.b(this.eJS.substring(0, lastIndexOf).replace('/', '.'));
    }

    public String getInternalName() {
        return this.eJS;
    }

    public String toString() {
        return this.eJS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj == null || getClass() != obj.getClass()) ? false : this.eJS.equals(((b) obj).eJS);
    }

    public int hashCode() {
        return this.eJS.hashCode();
    }
}
