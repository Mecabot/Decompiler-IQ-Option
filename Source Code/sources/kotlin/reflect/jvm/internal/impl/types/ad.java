package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.renderer.b;

/* compiled from: KotlinType.kt */
public abstract class ad extends ay {
    public abstract ad gQ(boolean z);

    public abstract ad h(g gVar);

    public ad() {
        super();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar : bbQ().bek()) {
            c beh = fVar.beh();
            AnnotationUseSiteTarget bei = fVar.bei();
            r.a(stringBuilder, "[", b.ePf.a(beh, bei), "] ");
        }
        stringBuilder.append(bwA());
        if (!bdF().isEmpty()) {
            u.a(bdF(), stringBuilder, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (aYp()) {
            stringBuilder.append("?");
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
