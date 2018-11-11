package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.j;
import kotlin.jvm.internal.h;

/* compiled from: KotlinTarget.kt */
public enum KotlinTarget {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    public static final a Companion = null;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    private static final HashMap<String, KotlinTarget> map = null;
    private final String description;
    private final boolean isDefault;

    /* compiled from: KotlinTarget.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    protected KotlinTarget(String str, boolean z) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.description = str;
        this.isDefault = z;
    }

    static {
        Companion = new a();
        map = new HashMap();
        for (KotlinTarget kotlinTarget : values()) {
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values = values();
        Collection arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values) {
            if (kotlinTarget2.isDefault) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = u.Y((List) arrayList);
        ALL_TARGET_SET = i.C(values());
        USE_SITE_MAPPING = ad.a(j.D(AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), j.D(AnnotationUseSiteTarget.FIELD, FIELD), j.D(AnnotationUseSiteTarget.PROPERTY, PROPERTY), j.D(AnnotationUseSiteTarget.FILE, FILE), j.D(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), j.D(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), j.D(AnnotationUseSiteTarget.RECEIVER, VALUE_PARAMETER), j.D(AnnotationUseSiteTarget.SETTER_PARAMETER, VALUE_PARAMETER), j.D(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, FIELD));
    }
}
