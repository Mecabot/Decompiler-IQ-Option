package com.pro100svitlo.creditCardNfcReader.a;

import com.pro100svitlo.creditCardNfcReader.model.enums.a;
import org.slf4j.b;

/* compiled from: EnumUtils */
public final class c {
    private static final b egK = org.slf4j.c.aa(c.class);

    public static <T extends a> T a(int i, Class<T> cls) {
        for (T t : (a[]) cls.getEnumConstants()) {
            if (t.getKey() == i) {
                return t;
            }
        }
        b bVar = egK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknow value:");
        stringBuilder.append(i);
        stringBuilder.append(" for Enum:");
        stringBuilder.append(cls.getName());
        bVar.error(stringBuilder.toString());
        return null;
    }

    private c() {
    }
}
