package com.iqoption.fragment.leftmenu;

import com.iqoption.fragment.leftmenu.content.a;
import java.util.Comparator;

final /* synthetic */ class c implements Comparator {
    static final Comparator $instance = new c();

    private c() {
    }

    public int compare(Object obj, Object obj2) {
        return Long.compare((long) ((a) obj).menuPriority(), (long) ((a) obj2).menuPriority());
    }
}
