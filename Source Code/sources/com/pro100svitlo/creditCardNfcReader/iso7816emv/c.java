package com.pro100svitlo.creditCardNfcReader.iso7816emv;

import com.pro100svitlo.creditCardNfcReader.a.a;
import com.pro100svitlo.creditCardNfcReader.model.enums.CountryCodeEnum;
import com.pro100svitlo.creditCardNfcReader.model.enums.CurrencyEnum;
import com.pro100svitlo.creditCardNfcReader.model.enums.TransactionTypeEnum;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: EmvTerminal */
public final class c {
    private static final SecureRandom egw = new SecureRandom();

    public static byte[] a(e eVar) {
        Object bytes;
        Object obj = new byte[eVar.getLength()];
        if (eVar.aRJ() == b.eeF) {
            f fVar = new f();
            fVar.fZ(true);
            fVar.ga(true);
            bytes = fVar.getBytes();
        } else if (eVar.aRJ() == b.edL) {
            bytes = a.lj(org.apache.commons.lang3.c.g(String.valueOf(CountryCodeEnum.FR.getNumeric()), eVar.getLength() * 2, "0"));
        } else if (eVar.aRJ() == b.edg) {
            bytes = a.lj(org.apache.commons.lang3.c.g(String.valueOf(CurrencyEnum.EUR.getISOCodeNumeric()), eVar.getLength() * 2, "0"));
        } else if (eVar.aRJ() == b.ecY) {
            bytes = a.lj(new SimpleDateFormat("yyMMdd").format(new Date()));
        } else if (eVar.aRJ() == b.eda) {
            bytes = new byte[]{(byte) TransactionTypeEnum.PURCHASE.getKey()};
        } else if (eVar.aRJ() == b.edq) {
            bytes = a.lj("00");
        } else if (eVar.aRJ() == b.eed) {
            bytes = new byte[]{(byte) 34};
        } else if (eVar.aRJ() == b.eeb) {
            bytes = new byte[]{(byte) -32, (byte) -96, (byte) 0};
        } else if (eVar.aRJ() == b.eem) {
            bytes = new byte[]{(byte) -114, (byte) 0, (byte) -80, (byte) 80, (byte) 5};
        } else if (eVar.aRJ() == b.eeU) {
            bytes = a.lj("7345123215904501");
        } else {
            if (eVar.aRJ() == b.eef) {
                egw.nextBytes(obj);
            }
            bytes = null;
        }
        if (bytes != null) {
            System.arraycopy(bytes, 0, obj, 0, Math.min(bytes.length, obj.length));
        }
        return obj;
    }
}
