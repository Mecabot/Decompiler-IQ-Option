package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.h;

/* compiled from: DescriptorRenderer.kt */
public enum RenderingFormat {
    ;

    /* compiled from: DescriptorRenderer.kt */
    static final class HTML extends RenderingFormat {
        HTML(String str, int i) {
            super(str, i);
        }

        public String escape(String str) {
            h.e(str, "string");
            return u.a(u.a(str, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    static final class PLAIN extends RenderingFormat {
        public String escape(String str) {
            h.e(str, "string");
            return str;
        }

        PLAIN(String str, int i) {
            super(str, i);
        }
    }

    public abstract String escape(String str);
}
