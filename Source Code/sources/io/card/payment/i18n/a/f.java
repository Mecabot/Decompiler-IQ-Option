package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsEN_GB */
public class f implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "en_GB";
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

    public f() {
        elu.put(StringKey.CANCEL, "Cancel");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Done");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Postcode");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Cardholder Name");
        elu.put(StringKey.ENTRY_EXPIRES, "Expires");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY");
        elu.put(StringKey.SCAN_GUIDE, "Hold card here.\nIt will scan automatically.");
        elu.put(StringKey.KEYBOARD, "Keyboard…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Card Number");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Card Details");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "This device cannot use the camera to read card numbers.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Device camera is unavailable.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "The device had an unexpected error opening the camera.");
    }
}
