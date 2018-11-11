package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsSV */
public class w implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "sv";
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

    public w() {
        elu.put(StringKey.CANCEL, "Avbryt");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Klart");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Postnummer");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Kortinnehavarens namn");
        elu.put(StringKey.ENTRY_EXPIRES, "Går ut");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        elu.put(StringKey.SCAN_GUIDE, "Håll kortet här.\nDet skannas automatiskt.");
        elu.put(StringKey.KEYBOARD, "Tangentbord …");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kortnummer");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kortinformation");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Den här enheten kan inte använda kameran till att läsa kortnummer.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Enhetens kamera är inte tillgänglig.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Ett oväntat fel uppstod när enheten skulle öppna kameran.");
    }
}
