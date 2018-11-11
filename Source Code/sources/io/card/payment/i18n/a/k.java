package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsIS */
public class k implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "is";
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

    public k() {
        elu.put(StringKey.CANCEL, "Hætta við");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Lokið");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Póstnúmer");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nafn Korthafa");
        elu.put(StringKey.ENTRY_EXPIRES, "Rennur út");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/ÁÁ");
        elu.put(StringKey.SCAN_GUIDE, "Haltu kortinu kyrru hér.\nÞað verður sjálvirkt skannað.");
        elu.put(StringKey.KEYBOARD, "Lyklaborð…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kortanúmar");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kortaupplýsingar");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Þetta tæki getur ekki notað myndavélina til að lesa af númer af kortinu.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Ekki næst samband við myndavélina.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Upp kom villa við að opna myndavélina..");
    }
}
