package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsNL */
public class r implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "nl";
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

    public r() {
        elu.put(StringKey.CANCEL, "Annuleren");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Gereed");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Postcode");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Naam kaarthouder");
        elu.put(StringKey.ENTRY_EXPIRES, "Vervaldatum");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/JJ");
        elu.put(StringKey.SCAN_GUIDE, "Houd uw kaart hier.\nScannen gaat automatisch.");
        elu.put(StringKey.KEYBOARD, "Toetsenbord…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Creditcardnummer");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kaartgegevens");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Met de camera van dit apparaat kunnen geen kaartnummers worden gelezen.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Camera apparaat niet beschikbaar.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Er is een onverwachte fout opgetreden bij het starten van de camera.");
    }
}
