package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsIT */
public class l implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "it";
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

    public l() {
        elu.put(StringKey.CANCEL, "Annulla");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "OK");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "CAP");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Titolare della carta");
        elu.put(StringKey.ENTRY_EXPIRES, "Scadenza");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        elu.put(StringKey.SCAN_GUIDE, "Inquadra la carta.\nLa scansione è automatica.");
        elu.put(StringKey.KEYBOARD, "Tastiera…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Numero di carta");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Dati carta");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "La fotocamera non legge il numero di carta.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Fotocamera non disponibile.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Errore inatteso nell’apertura della fotocamera.");
    }
}
