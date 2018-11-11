package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.b;
import kotlin.reflect.jvm.internal.impl.load.java.structure.m;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.i;

/* compiled from: JavaAnnotationMapper.kt */
public final class d {
    private static final Map<String, EnumSet<KotlinTarget>> eGd = ad.a(j.D("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), j.D("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), j.D("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), j.D("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), j.D("FIELD", EnumSet.of(KotlinTarget.FIELD)), j.D("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), j.D("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), j.D("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), j.D("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), j.D("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    private static final Map<String, KotlinRetention> eGe = ad.a(j.D("RUNTIME", KotlinRetention.RUNTIME), j.D("CLASS", KotlinRetention.BINARY), j.D("SOURCE", KotlinRetention.SOURCE));
    public static final d eGf = new d();

    private d() {
    }

    public final Set<KotlinTarget> mp(String str) {
        EnumSet enumSet = (EnumSet) eGd.get(str);
        return enumSet != null ? enumSet : aj.emptySet();
    }

    public final f<?> cg(List<? extends b> list) {
        kotlin.reflect.jvm.internal.impl.name.f bhB;
        h.e(list, "arguments");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof m) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (m mVar : (List) arrayList) {
            d dVar = eGf;
            bhB = mVar.bhB();
            r.a(arrayList2, (Iterable) dVar.mp(bhB != null ? bhB.asString() : null));
        }
        Iterable<KotlinTarget> iterable = (List) arrayList2;
        arrayList = new ArrayList(n.e(iterable, 10));
        for (KotlinTarget kotlinTarget : iterable) {
            a t = a.t(g.exC.eyn);
            h.d(t, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
            bhB = kotlin.reflect.jvm.internal.impl.name.f.mD(kotlinTarget.name());
            h.d(bhB, "Name.identifier(kotlinTarget.name)");
            arrayList.add(new i(t, bhB));
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b((List) arrayList, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.eGg);
    }

    public final f<?> a(b bVar) {
        i iVar = null;
        if (!(bVar instanceof m)) {
            bVar = null;
        }
        m mVar = (m) bVar;
        if (mVar != null) {
            Map map = eGe;
            kotlin.reflect.jvm.internal.impl.name.f bhB = mVar.bhB();
            KotlinRetention kotlinRetention = (KotlinRetention) map.get(bhB != null ? bhB.asString() : null);
            if (kotlinRetention != null) {
                a t = a.t(g.exC.eyo);
                h.d(t, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
                bhB = kotlin.reflect.jvm.internal.impl.name.f.mD(kotlinRetention.name());
                h.d(bhB, "Name.identifier(retention.name)");
                iVar = new i(t, bhB);
            }
        }
        return iVar;
    }
}
