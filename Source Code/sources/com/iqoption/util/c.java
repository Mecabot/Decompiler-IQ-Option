package com.iqoption.util;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ArrayLists */
public final class c {
    public static <T> ArrayList<T> G(Collection<T> collection) {
        ArrayList<T> arrayList = new ArrayList();
        arrayList.addAll(collection);
        return arrayList;
    }
}
