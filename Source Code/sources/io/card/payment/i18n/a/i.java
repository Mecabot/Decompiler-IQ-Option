package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsFR */
public class i implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "fr";
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

    public i() {
        elu.put(StringKey.CANCEL, "Annuler");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "OK");
        elu.put(StringKey.ENTRY_CVV, "Crypto.");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Code postal");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nom du titulaire de la carte");
        elu.put(StringKey.ENTRY_EXPIRES, "Date d’expiration");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        elu.put(StringKey.SCAN_GUIDE, "Maintenez la carte à cet endroit.\nElle va être automatiquement scannée.");
        elu.put(StringKey.KEYBOARD, "Clavier…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Nº de carte");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Carte");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Cet appareil ne peut pas utiliser l’appareil photo pour lire les numéros de carte.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "L’appareil photo n’est pas disponible.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Une erreur s’est produite en ouvrant l’appareil photo.");
    }
}
