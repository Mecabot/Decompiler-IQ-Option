package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class k extends i {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final d eSf;
    private final e eSn;

    private final List<ah> bxj() {
        return (List) g.a(this.eSn, (Object) this, apP[0]);
    }

    public Void f(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return null;
    }

    public /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, b bVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) f(fVar, bVar);
    }

    public k(kotlin.reflect.jvm.internal.impl.storage.h hVar, d dVar) {
        h.e(hVar, "storageManager");
        h.e(dVar, "containingClass");
        this.eSf = dVar;
        Object obj = this.eSf.bbF() == ClassKind.ENUM_CLASS ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class should be an enum: ");
            stringBuilder.append(this.eSf);
            throw new AssertionError(stringBuilder.toString());
        }
        this.eSn = hVar.i(new StaticScopeForKotlinEnum$functions$2(this));
    }

    /* renamed from: f */
    public List<ah> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        return bxj();
    }

    /* renamed from: g */
    public ArrayList<ah> b(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList(1);
        for (Object next : bxj()) {
            if (h.E(((ah) next).bdc(), fVar)) {
                arrayList.add(next);
            }
        }
        return (ArrayList) arrayList;
    }
}
