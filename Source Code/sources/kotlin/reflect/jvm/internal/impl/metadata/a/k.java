package kotlin.reflect.jvm.internal.impl.metadata.a;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;

/* compiled from: VersionRequirement.kt */
public final class k {
    private static final k eMe = new k(m.emptyList());
    public static final a eMf = new a();
    private final List<VersionRequirement> eMd;

    /* compiled from: VersionRequirement.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final k bri() {
            return k.eMe;
        }

        public final k g(VersionRequirementTable versionRequirementTable) {
            h.e(versionRequirementTable, "table");
            if (versionRequirementTable.bqU() == 0) {
                return bri();
            }
            List bqT = versionRequirementTable.bqT();
            h.d(bqT, "table.requirementList");
            return new k(bqT, null);
        }
    }

    private k(List<VersionRequirement> list) {
        this.eMd = list;
    }

    public /* synthetic */ k(List list, f fVar) {
        this(list);
    }

    public final VersionRequirement li(int i) {
        return (VersionRequirement) u.h(this.eMd, i);
    }
}
