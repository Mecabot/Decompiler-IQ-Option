package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;

/* compiled from: ModuleDescriptorImpl.kt */
public final class t implements s {
    private final List<u> eDD;
    private final Set<u> eDE;
    private final List<u> eDF;

    public t(List<u> list, Set<u> set, List<u> list2) {
        h.e(list, "allDependencies");
        h.e(set, "modulesWhoseInternalsAreVisible");
        h.e(list2, "expectedByDependencies");
        this.eDD = list;
        this.eDE = set;
        this.eDF = list2;
    }

    public List<u> beP() {
        return this.eDD;
    }

    public Set<u> beQ() {
        return this.eDE;
    }

    public List<u> beR() {
        return this.eDF;
    }
}
