package com.pro100svitlo.creditCardNfcReader.parser.apdu.impl;

import java.util.Date;
import org.slf4j.b;
import org.slf4j.c;

/* compiled from: DataFactory */
public final class a {
    public static final b egK = c.nJ(a.class.getName());

    private static Date a(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        if (aVar.aSb() == 1) {
            return aVar2.a(aVar.getSize(), aVar.getFormat(), true);
        }
        return aVar2.m(aVar.getSize(), aVar.getFormat());
    }

    private static int b(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        return aVar2.iJ(aVar.getSize());
    }

    public static Object c(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        Class type = aVar.getField().getType();
        if (type.equals(Integer.class)) {
            return Integer.valueOf(b(aVar, aVar2));
        }
        if (type.equals(Float.class)) {
            return d(aVar, aVar2);
        }
        if (type.equals(String.class)) {
            return f(aVar, aVar2);
        }
        if (type.equals(Date.class)) {
            return a(aVar, aVar2);
        }
        if (type.equals(Boolean.class)) {
            return Boolean.valueOf(aVar2.aTr());
        }
        return type.isEnum() ? e(aVar, aVar2) : null;
    }

    private static Float d(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        if ("BCD_Format".equals(aVar.getFormat())) {
            return Float.valueOf(Float.parseFloat(aVar2.iH(aVar.getSize())));
        }
        return Float.valueOf((float) b(aVar, aVar2));
    }

    private static com.pro100svitlo.creditCardNfcReader.model.enums.a e(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(aVar2.iH(aVar.getSize()), aVar.aSa() ? 16 : 10);
        } catch (NumberFormatException unused) {
            parseInt = 0;
        }
        return com.pro100svitlo.creditCardNfcReader.a.c.a(parseInt, aVar.getField().getType());
    }

    private static String f(com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar, b.a.a.a aVar2) {
        if (aVar.aSa()) {
            return aVar2.iH(aVar.getSize());
        }
        return aVar2.iK(aVar.getSize()).trim();
    }

    private a() {
    }
}
