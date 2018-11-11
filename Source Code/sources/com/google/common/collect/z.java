package com.google.common.collect;

import java.lang.reflect.Array;

/* compiled from: Platform */
final class z {
    static <T> T[] c(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    static u b(u uVar) {
        return uVar.tO();
    }
}
