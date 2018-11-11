package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
final class JvmBuiltInClassDescriptorFactory$1 extends Lambda implements b<u, c> {
    public static final JvmBuiltInClassDescriptorFactory$1 eAn = new JvmBuiltInClassDescriptorFactory$1();

    JvmBuiltInClassDescriptorFactory$1() {
        super(1);
    }

    /* renamed from: c */
    public final c invoke(u uVar) {
        h.e(uVar, "module");
        kotlin.reflect.jvm.internal.impl.name.b bco = d.eAj;
        h.d(bco, "KOTLIN_FQ_NAME");
        Iterable fragments = uVar.g(bco).getFragments();
        Collection arrayList = new ArrayList();
        for (Object next : fragments) {
            if (next instanceof c) {
                arrayList.add(next);
            }
        }
        return (c) u.bU((List) arrayList);
    }
}
