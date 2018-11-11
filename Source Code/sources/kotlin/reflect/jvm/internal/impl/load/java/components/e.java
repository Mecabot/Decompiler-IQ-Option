package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.g;

/* compiled from: JavaAnnotationMapper.kt */
public final class e extends b {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final kotlin.reflect.jvm.internal.impl.storage.e eGh;

    public Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee() {
        return (Map) g.a(this.eGh, (Object) this, apP[0]);
    }

    public e(a aVar, h hVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        b bVar = kotlin.reflect.jvm.internal.impl.builtins.g.exC.eyg;
        kotlin.jvm.internal.h.d(bVar, "KotlinBuiltIns.FQ_NAMES.deprecated");
        super(hVar, aVar, bVar);
        this.eGh = hVar.baI().i(JavaDeprecatedAnnotationDescriptor$allValueArguments$2.eGi);
    }
}
