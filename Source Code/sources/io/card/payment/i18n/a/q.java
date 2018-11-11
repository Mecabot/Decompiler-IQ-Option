package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsNB */
public class q implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "nb";
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

    public q() {
        elu.put(StringKey.CANCEL, "Avbryt");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Fullført");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Postnummer");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Kortinnehaverens navn");
        elu.put(StringKey.ENTRY_EXPIRES, "Utløper");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        elu.put(StringKey.SCAN_GUIDE, "Hold kortet her.\nDet skannes automatisk.");
        elu.put(StringKey.KEYBOARD, "Tastatur …");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kortnummer");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kortdetaljer");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Denne enheten kan ikke bruke kameraet til å lese kortnumre.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Kameraet er utilgjengelig.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Det oppstod en uventet feil ved kameraoppstart.");
    }
}
