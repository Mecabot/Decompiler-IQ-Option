package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsMS */
public class p implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "ms";
    }

    /* renamed from: b */
    public String a(StringKey stringKey, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringKey.toString());
        stringBuilder.append("|");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        if (elv.containsKey(str)) {
            return (String) elv.get(str);
        }
        return (String) elu.get(stringKey);
    }

    public p() {
        elu.put(StringKey.CANCEL, "Batal");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Selesai");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Poskod");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nama Pemegang Kad");
        elu.put(StringKey.ENTRY_EXPIRES, "Luput");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "BB/TT");
        elu.put(StringKey.SCAN_GUIDE, "Pegang kad di sini.\nIa akan mengimbas secara automatik.");
        elu.put(StringKey.KEYBOARD, "Papan Kekunci…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Nombor Kad");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Butiran Kad");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Peranti ini tidak dapat menggunakan kamera untuk membaca nombor kad.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Kamera peranti tidak tersedia.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Peranti mengalami ralat tidak dijangka semasa membuka kamera.");
    }
}
