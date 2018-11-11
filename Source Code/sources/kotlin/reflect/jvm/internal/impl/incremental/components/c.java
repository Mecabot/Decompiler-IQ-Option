package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.h;

/* compiled from: LookupTracker.kt */
public interface c {

    /* compiled from: LookupTracker.kt */
    public static final class a implements c {
        public static final a eEs = new a();

        public void a(String str, Position position, String str2, ScopeKind scopeKind, String str3) {
            h.e(str, "filePath");
            h.e(position, "position");
            h.e(str2, "scopeFqName");
            h.e(scopeKind, "scopeKind");
            h.e(str3, "name");
        }

        public boolean bft() {
            return false;
        }

        private a() {
        }
    }

    void a(String str, Position position, String str2, ScopeKind scopeKind, String str3);

    boolean bft();
}
