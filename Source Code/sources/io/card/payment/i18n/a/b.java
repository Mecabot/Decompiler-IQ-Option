package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsDA */
public class b implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "da";
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

    public b() {
        elu.put(StringKey.CANCEL, "Annuller");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Udført");
        elu.put(StringKey.ENTRY_CVV, "Kontrolcifre");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Postnummer");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Kortindehaverens navn");
        elu.put(StringKey.ENTRY_EXPIRES, "Udløbsdato");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        elu.put(StringKey.SCAN_GUIDE, "Hold kortet her.\nDet scannes automatisk.");
        elu.put(StringKey.KEYBOARD, "Tastatur…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kortnummer");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kortoplysninger");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Denne enhed kan ikke anvende kameraet til at læse kortnumre.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Enhed kamera ikke er tilgængelig.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Enheden havde en uventet fejl under åbning af kamera.");
    }
}
