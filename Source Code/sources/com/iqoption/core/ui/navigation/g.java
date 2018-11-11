package com.iqoption.core.ui.navigation;

import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/ui/navigation/FirstWinBackController;", "Lcom/iqoption/core/ui/navigation/CompositeBackController;", "()V", "onBackPressed", "", "core_release"})
/* compiled from: FirstWinBackController.kt */
public final class g extends f {
    public boolean onBackPressed() {
        Iterator iterator = getIterator();
        h.d(iterator, "iterator");
        while (iterator.hasNext()) {
            if (((b) iterator.next()).onBackPressed()) {
                return true;
            }
        }
        return false;
    }
}
