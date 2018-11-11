package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* compiled from: ModuleDescriptorImpl.kt */
final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements a<i> {
    final /* synthetic */ u this$0;

    ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(u uVar) {
        this.this$0 = uVar;
        super(0);
    }

    /* renamed from: beW */
    public final i invoke() {
        s b = this.this$0.eDH;
        StringBuilder stringBuilder;
        if (b != null) {
            List beP = b.beP();
            boolean contains = beP.contains(this.this$0);
            if (!m.etY || contains) {
                Iterable<u> iterable = beP;
                for (u uVar : iterable) {
                    boolean d = uVar.isInitialized();
                    if (m.etY && !d) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Dependency module ");
                        stringBuilder.append(uVar.getId());
                        stringBuilder.append(" was not initialized by the time contents of dependent module ");
                        stringBuilder.append(this.this$0.getId());
                        stringBuilder.append(" were queried");
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
                Collection arrayList = new ArrayList(n.e(iterable, 10));
                for (u uVar2 : iterable) {
                    y e = uVar2.eDI;
                    if (e == null) {
                        h.aXZ();
                    }
                    arrayList.add(e);
                }
                return new i((List) arrayList);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Module ");
            stringBuilder.append(this.this$0.getId());
            stringBuilder.append(" is not contained in his own dependencies, this is probably a misconfiguration");
            throw new AssertionError(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Dependencies of module ");
        stringBuilder.append(this.this$0.getId());
        stringBuilder.append(" were not set before querying module content");
        throw new AssertionError(stringBuilder.toString());
    }
}
