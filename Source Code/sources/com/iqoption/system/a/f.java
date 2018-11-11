package com.iqoption.system.a;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;

/* compiled from: EventHandlerComposite */
public class f implements g {
    private final ImmutableList<g> drV;

    public f(g... gVarArr) {
        this.drV = ImmutableList.f(gVarArr);
    }

    public void register() {
        Iterator sI = this.drV.iterator();
        while (sI.hasNext()) {
            ((g) sI.next()).register();
        }
    }

    public void unregister() {
        Iterator sI = this.drV.iterator();
        while (sI.hasNext()) {
            ((g) sI.next()).unregister();
        }
    }
}
