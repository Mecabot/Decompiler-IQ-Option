package com.pro100svitlo.creditCardNfcReader.a;

import com.pro100svitlo.creditCardNfcReader.enums.SwEnum;
import java.util.Arrays;
import org.slf4j.b;
import org.slf4j.c;

/* compiled from: ResponseUtils */
public final class d {
    private static final b egK = c.aa(d.class);

    public static boolean U(byte[] bArr) {
        return a(bArr, SwEnum.SW_9000);
    }

    public static boolean a(byte[] bArr, SwEnum swEnum) {
        SwEnum sw = SwEnum.getSW(bArr);
        if (egK.isDebugEnabled() && bArr != null) {
            String Y = b.a.a.b.Y(Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length));
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Response Status <");
            stringBuilder.append(Y);
            stringBuilder.append("> : ");
            stringBuilder.append(sw != null ? sw.getDetail() : "Unknow");
            bVar.debug(stringBuilder.toString());
        }
        return sw != null && sw == swEnum;
    }

    private d() {
    }
}
