package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.h;

/* compiled from: JvmMemberSignature.kt */
public abstract class f {

    /* compiled from: JvmMemberSignature.kt */
    public static final class a extends f {
        private final String desc;
        private final String name;

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        /* JADX WARNING: Missing block: B:6:0x0022, code:
            if (kotlin.jvm.internal.h.E(getDesc(), r3.getDesc()) != false) goto L_0x0027;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0027;
        L_0x0002:
            r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a;
            if (r0 == 0) goto L_0x0025;
        L_0x0006:
            r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a) r3;
            r0 = r2.getName();
            r1 = r3.getName();
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0025;
        L_0x0016:
            r0 = r2.getDesc();
            r3 = r3.getDesc();
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x0025;
        L_0x0024:
            goto L_0x0027;
        L_0x0025:
            r3 = 0;
            return r3;
        L_0x0027:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String name = getName();
            int i = 0;
            int hashCode = (name != null ? name.hashCode() : 0) * 31;
            String desc = getDesc();
            if (desc != null) {
                i = desc.hashCode();
            }
            return hashCode + i;
        }

        public a(String str, String str2) {
            h.e(str, "name");
            h.e(str2, "desc");
            super();
            this.name = str;
            this.desc = str2;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public String asString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getName());
            stringBuilder.append(':');
            stringBuilder.append(getDesc());
            return stringBuilder.toString();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class b extends f {
        private final String desc;
        private final String name;

        /* JADX WARNING: Missing block: B:6:0x0022, code:
            if (kotlin.jvm.internal.h.E(getDesc(), r3.getDesc()) != false) goto L_0x0027;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0027;
        L_0x0002:
            r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b;
            if (r0 == 0) goto L_0x0025;
        L_0x0006:
            r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b) r3;
            r0 = r2.getName();
            r1 = r3.getName();
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0025;
        L_0x0016:
            r0 = r2.getDesc();
            r3 = r3.getDesc();
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x0025;
        L_0x0024:
            goto L_0x0027;
        L_0x0025:
            r3 = 0;
            return r3;
        L_0x0027:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String name = getName();
            int i = 0;
            int hashCode = (name != null ? name.hashCode() : 0) * 31;
            String desc = getDesc();
            if (desc != null) {
                i = desc.hashCode();
            }
            return hashCode + i;
        }

        public b(String str, String str2) {
            h.e(str, "name");
            h.e(str2, "desc");
            super();
            this.name = str;
            this.desc = str2;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public String asString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getName());
            stringBuilder.append(getDesc());
            return stringBuilder.toString();
        }
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    private f() {
    }

    public /* synthetic */ f(f fVar) {
        this();
    }

    public final String toString() {
        return asString();
    }
}
