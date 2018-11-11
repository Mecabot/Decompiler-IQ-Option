package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsDE */
public class c implements io.card.payment.i18n.c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "de";
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

    public c() {
        elu.put(StringKey.CANCEL, "Abbrechen");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Fertig");
        elu.put(StringKey.ENTRY_CVV, "Prüfnr.");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "PLZ");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Karteninhaber");
        elu.put(StringKey.ENTRY_EXPIRES, "Gültig bis");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/JJ");
        elu.put(StringKey.SCAN_GUIDE, "Kreditkarte hierhin halten.\nSie wird automatisch gelesen.");
        elu.put(StringKey.KEYBOARD, "Tastatur…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kartennummer");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kreditkartendetails");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Dieses Gerät kann mit der Kamera keine Kreditkartennummern lesen.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Die Kamera ist nicht verfügbar.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Beim Öffnen der Kamera ist ein unerwarteter Fehler aufgetreten.");
    }
}
