package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AnnotationDescriptorImpl */
public class d implements c {
    private final w eBu;
    private final Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> eBv;
    private final ai eBw;

    public d(w wVar, Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> map, ai aiVar) {
        this.eBu = wVar;
        this.eBv = map;
        this.eBw = aiVar;
    }

    public w bai() {
        return this.eBu;
    }

    public b bdD() {
        return a.a(this);
    }

    public Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee() {
        return this.eBv;
    }

    public ai bbR() {
        return this.eBw;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.ePd.a(this, null);
    }
}
