package com.iqoption.core.ui.navigation;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/ui/navigation/CompositeBackController;", "Lcom/iqoption/core/ui/navigation/BackController;", "Lcom/iqoption/core/ui/navigation/BackListener;", "()V", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "listeners", "Ljava/util/LinkedList;", "addListener", "", "listener", "removeListener", "core_release"})
/* compiled from: CompositeBackController.kt */
public abstract class f implements a, b {
    private final LinkedList<b> bbM = new LinkedList();

    protected final Iterator<b> getIterator() {
        return this.bbM.iterator();
    }

    public void a(b bVar) {
        h.e(bVar, "listener");
        this.bbM.push(bVar);
    }

    public void b(b bVar) {
        h.e(bVar, "listener");
        this.bbM.remove(bVar);
    }
}
