package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {
    private final Kind eKq;
    private final g eKr;
    private final d eKs;
    private final String[] eKt;
    private final String[] eKu;
    private final String eKv;
    private final int eKw;
    private final String packageName;
    private final String[] strings;

    /* compiled from: KotlinClassHeader.kt */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final a Companion = null;
        private static final Map<Integer, Kind> entryById = null;
        private final int id;

        /* compiled from: KotlinClassHeader.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final Kind getById(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                return kind != null ? kind : Kind.UNKNOWN;
            }
        }

        public static final Kind getById(int i) {
            return Companion.getById(i);
        }

        protected Kind(int i) {
            this.id = i;
        }

        static {
            Companion = new a();
            Kind[] values = values();
            Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(values.length), 16));
            int length = values.length;
            int i;
            while (i < length) {
                Kind kind = values[i];
                linkedHashMap.put(Integer.valueOf(kind.id), kind);
                i++;
            }
            entryById = linkedHashMap;
        }
    }

    public KotlinClassHeader(Kind kind, g gVar, d dVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        h.e(kind, "kind");
        h.e(gVar, "metadataVersion");
        h.e(dVar, "bytecodeVersion");
        this.eKq = kind;
        this.eKr = gVar;
        this.eKs = dVar;
        this.eKt = strArr;
        this.eKu = strArr2;
        this.strings = strArr3;
        this.eKv = str;
        this.eKw = i;
        this.packageName = str2;
    }

    public final Kind biM() {
        return this.eKq;
    }

    public final g biN() {
        return this.eKr;
    }

    public final String[] biO() {
        return this.eKt;
    }

    public final String[] biP() {
        return this.eKu;
    }

    public final String[] biQ() {
        return this.strings;
    }

    public final String biJ() {
        return (this.eKq == Kind.MULTIFILE_CLASS_PART ? 1 : null) != null ? this.eKv : null;
    }

    public final List<String> biK() {
        Object[] objArr = this.eKt;
        List<String> list = null;
        if ((this.eKq == Kind.MULTIFILE_CLASS ? 1 : null) == null) {
            objArr = null;
        }
        if (objArr != null) {
            list = h.asList(objArr);
        }
        return list != null ? list : m.emptyList();
    }

    public final boolean biL() {
        return (this.eKw & 2) != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.eKq);
        stringBuilder.append(" version=");
        stringBuilder.append(this.eKr);
        return stringBuilder.toString();
    }
}
