package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: DescriptorRenderer.kt */
public interface f {

    /* compiled from: DescriptorRenderer.kt */
    public static final class a {
        public static boolean b(f fVar) {
            return fVar.bvF().getIncludeAnnotationArguments();
        }

        public static boolean c(f fVar) {
            return fVar.bvF().getIncludeEmptyAnnotationArguments();
        }
    }

    boolean HW();

    void a(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    void a(ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void a(RenderingFormat renderingFormat);

    void a(a aVar);

    AnnotationArgumentsRenderingPolicy bvF();

    boolean bvM();

    Set<b> bvO();

    void bx(boolean z);

    void gV(boolean z);

    void gW(boolean z);

    void gX(boolean z);

    void gY(boolean z);

    void gZ(boolean z);

    void ha(boolean z);

    void k(Set<b> set);

    void l(Set<? extends DescriptorRendererModifier> set);

    void setVerbose(boolean z);
}
