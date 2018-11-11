package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.load.java.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor */
public class a implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.c {
    private static final boolean eKx = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<kotlin.reflect.jvm.internal.impl.name.a, Kind> eKy = new HashMap();
    private g eKr = null;
    private d eKs = null;
    private String[] eKt = null;
    private String[] eKu = null;
    private String eKv = null;
    private int eKw = 0;
    private Kind eKz = null;
    private String packageName = null;
    private String[] strings = null;

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor */
    private static abstract class a implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.b {
        private final List<String> eKA = new ArrayList();

        public void b(kotlin.reflect.jvm.internal.impl.name.a aVar, f fVar) {
        }

        protected abstract void j(String[] strArr);

        public void cQ(Object obj) {
            if (obj instanceof String) {
                this.eKA.add((String) obj);
            }
        }

        public void visitEnd() {
            j((String[]) this.eKA.toArray(new String[this.eKA.size()]));
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor */
    private class b implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.a {
        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar) {
            return null;
        }

        public void a(f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar, f fVar2) {
        }

        public void visitEnd() {
        }

        private b() {
        }

        public void a(f fVar, Object obj) {
            if (fVar != null) {
                String asString = fVar.asString();
                if ("k".equals(asString)) {
                    if (obj instanceof Integer) {
                        a.this.eKz = Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(asString)) {
                    if (obj instanceof int[]) {
                        a.this.eKr = new g((int[]) obj);
                    }
                } else if ("bv".equals(asString)) {
                    if (obj instanceof int[]) {
                        a.this.eKs = new d((int[]) obj);
                    }
                } else if ("xs".equals(asString)) {
                    if (obj instanceof String) {
                        a.this.eKv = (String) obj;
                    }
                } else if ("xi".equals(asString)) {
                    if (obj instanceof Integer) {
                        a.this.eKw = ((Integer) obj).intValue();
                    }
                } else if ("pn".equals(asString) && (obj instanceof String)) {
                    a.this.packageName = (String) obj;
                }
            }
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.b A(f fVar) {
            String asString = fVar.asString();
            if ("d1".equals(asString)) {
                return biT();
            }
            return "d2".equals(asString) ? biU() : null;
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.n.b biT() {
            return new a() {
                protected void j(String[] strArr) {
                    a.this.eKt = strArr;
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.n.b biU() {
            return new a() {
                protected void j(String[] strArr) {
                    a.this.strings = strArr;
                }
            };
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor */
    private class c implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.a {
        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar) {
            return null;
        }

        public void a(f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar, f fVar2) {
        }

        public void visitEnd() {
        }

        private c() {
        }

        public void a(f fVar, Object obj) {
            if (fVar != null) {
                String asString = fVar.asString();
                if ("version".equals(asString)) {
                    if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        a.this.eKr = new g(iArr);
                        if (a.this.eKs == null) {
                            a.this.eKs = new d(iArr);
                        }
                    }
                } else if ("multifileClassName".equals(asString)) {
                    a.this.eKv = obj instanceof String ? (String) obj : null;
                }
            }
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.b A(f fVar) {
            String asString = fVar.asString();
            if ("data".equals(asString) || "filePartClassNames".equals(asString)) {
                return biT();
            }
            return "strings".equals(asString) ? biU() : null;
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.n.b biT() {
            return new a() {
                protected void j(String[] strArr) {
                    a.this.eKt = strArr;
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.n.b biU() {
            return new a() {
                protected void j(String[] strArr) {
                    a.this.strings = strArr;
                }
            };
        }
    }

    public void visitEnd() {
    }

    static {
        eKy.put(kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b("kotlin.jvm.internal.KotlinClass")), Kind.CLASS);
        eKy.put(kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b("kotlin.jvm.internal.KotlinFileFacade")), Kind.FILE_FACADE);
        eKy.put(kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b("kotlin.jvm.internal.KotlinMultifileClass")), Kind.MULTIFILE_CLASS);
        eKy.put(kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b("kotlin.jvm.internal.KotlinMultifileClassPart")), Kind.MULTIFILE_CLASS_PART);
        eKy.put(kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b("kotlin.jvm.internal.KotlinSyntheticClass")), Kind.SYNTHETIC_CLASS);
    }

    public KotlinClassHeader biR() {
        if (this.eKz == null) {
            return null;
        }
        if (!this.eKr.btC()) {
            this.eKu = this.eKt;
        }
        if (this.eKr == null || !this.eKr.btC()) {
            this.eKt = null;
        } else if (biS() && this.eKt == null) {
            return null;
        }
        return new KotlinClassHeader(this.eKz, this.eKr != null ? this.eKr : g.eMI, this.eKs != null ? this.eKs : d.eMD, this.eKt, this.eKu, this.strings, this.eKv, this.eKw, this.packageName);
    }

    private boolean biS() {
        return this.eKz == Kind.CLASS || this.eKz == Kind.FILE_FACADE || this.eKz == Kind.MULTIFILE_CLASS_PART;
    }

    public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar) {
        if (aVar.btK().equals(m.eFk)) {
            return new b();
        }
        if (eKx || this.eKz != null) {
            return null;
        }
        Kind kind = (Kind) eKy.get(aVar);
        if (kind == null) {
            return null;
        }
        this.eKz = kind;
        return new c();
    }
}
