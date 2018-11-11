package com.iqoption.util;

import java.util.Collection;
import java.util.List;

/* compiled from: CollectionUtils */
public class i {
    public static boolean H(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> void a(List<T> list, List<T> list2, int i) {
        if (i < list2.size()) {
            list.add(list2.get(i));
        }
    }

    public static <T> void a(int i, List<T> list, List<T>... listArr) {
        for (int i2 = 0; i2 < i && list.size() < i; i2++) {
            int i3 = 0;
            while (i3 < listArr.length) {
                a((List) list, listArr[i3], i2);
                if (list.size() != i) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
