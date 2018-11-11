package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1 extends Lambda implements b<h, Collection<? extends ad>> {
    final /* synthetic */ f $name;

    LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(f fVar) {
        this.$name = fVar;
        super(1);
    }

    /* renamed from: a */
    public final Collection<ad> invoke(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "it");
        return hVar.a(this.$name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }
}
