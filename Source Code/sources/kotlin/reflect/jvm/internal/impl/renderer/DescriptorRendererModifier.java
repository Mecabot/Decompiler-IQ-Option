package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* compiled from: DescriptorRenderer.kt */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true);
    
    public static final Set<DescriptorRendererModifier> ALL = null;
    public static final a Companion = null;
    public static final Set<DescriptorRendererModifier> DEFAULTS = null;
    private final boolean includeByDefault;

    /* compiled from: DescriptorRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    protected DescriptorRendererModifier(boolean z) {
        this.includeByDefault = z;
    }

    static {
        Companion = new a();
        DescriptorRendererModifier[] values = values();
        Collection arrayList = new ArrayList();
        int length = values.length;
        int i;
        while (i < length) {
            DescriptorRendererModifier descriptorRendererModifier = values[i];
            if (descriptorRendererModifier.includeByDefault) {
                arrayList.add(descriptorRendererModifier);
            }
            i++;
        }
        DEFAULTS = u.Y((List) arrayList);
        ALL = i.C(values());
    }
}
