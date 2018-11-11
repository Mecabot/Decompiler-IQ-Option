package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: AnnotationUseSiteTarget.kt */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    public static final a Companion = null;
    private final String renderName;

    /* compiled from: AnnotationUseSiteTarget.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final AnnotationUseSiteTarget l(k kVar) {
            h.e(kVar, "descriptor");
            if (kVar instanceof ad) {
                return AnnotationUseSiteTarget.PROPERTY;
            }
            if (kVar instanceof aq) {
                return AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
            }
            if (kVar instanceof ae) {
                return AnnotationUseSiteTarget.PROPERTY_GETTER;
            }
            return kVar instanceof af ? AnnotationUseSiteTarget.PROPERTY_SETTER : null;
        }
    }

    protected AnnotationUseSiteTarget(String str) {
        if (str == null) {
            r1 = name();
            if (r1 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = r1.toLowerCase();
            h.d(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    static {
        Companion = new a();
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
