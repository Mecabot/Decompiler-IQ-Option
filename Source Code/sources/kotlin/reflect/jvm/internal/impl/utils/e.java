package kotlin.reflect.jvm.internal.impl.utils;

import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

/* compiled from: Jsr305State.kt */
public final class e {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "getDescription()[Ljava/lang/String;"))};
    public static final e eXF = new e(ReportLevel.WARN, null, ad.emptyMap(), false, 8, null);
    public static final e eXG = new e(ReportLevel.IGNORE, ReportLevel.IGNORE, ad.emptyMap(), false, 8, null);
    public static final e eXH = new e(ReportLevel.STRICT, ReportLevel.STRICT, ad.emptyMap(), false, 8, null);
    public static final a eXI = new a();
    private final d eXA;
    private final ReportLevel eXB;
    private final ReportLevel eXC;
    private final Map<String, ReportLevel> eXD;
    private final boolean eXE;

    /* compiled from: Jsr305State.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (h.E(this.eXB, eVar.eXB) && h.E(this.eXC, eVar.eXC) && h.E(this.eXD, eVar.eXD)) {
                if ((this.eXE == eVar.eXE ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ReportLevel reportLevel = this.eXB;
        int i = 0;
        int hashCode = (reportLevel != null ? reportLevel.hashCode() : 0) * 31;
        ReportLevel reportLevel2 = this.eXC;
        hashCode = (hashCode + (reportLevel2 != null ? reportLevel2.hashCode() : 0)) * 31;
        Map map = this.eXD;
        if (map != null) {
            i = map.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.eXE;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Jsr305State(global=");
        stringBuilder.append(this.eXB);
        stringBuilder.append(", migration=");
        stringBuilder.append(this.eXC);
        stringBuilder.append(", user=");
        stringBuilder.append(this.eXD);
        stringBuilder.append(", enableCompatqualCheckerFrameworkAnnotations=");
        stringBuilder.append(this.eXE);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(ReportLevel reportLevel, ReportLevel reportLevel2, Map<String, ? extends ReportLevel> map, boolean z) {
        h.e(reportLevel, "global");
        h.e(map, "user");
        this.eXB = reportLevel;
        this.eXC = reportLevel2;
        this.eXD = map;
        this.eXE = z;
        this.eXA = g.f(new Jsr305State$description$2(this));
    }

    public final ReportLevel bzB() {
        return this.eXB;
    }

    public final ReportLevel bzC() {
        return this.eXC;
    }

    public final Map<String, ReportLevel> bzD() {
        return this.eXD;
    }

    public /* synthetic */ e(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, int i, f fVar) {
        if ((i & 8) != 0) {
            z = true;
        }
        this(reportLevel, reportLevel2, map, z);
    }

    public final boolean bzE() {
        return this.eXE;
    }

    public final boolean getDisabled() {
        return ((e) this) == eXG;
    }
}
