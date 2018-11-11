package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsPL */
public class s implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "pl";
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

    public s() {
        elu.put(StringKey.CANCEL, "Anuluj");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Gotowe");
        elu.put(StringKey.ENTRY_CVV, "Kod CVV2/CVC2");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Kod pocztowy");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Imię i nazwisko posiadacza karty");
        elu.put(StringKey.ENTRY_EXPIRES, "Wygasa");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/RR");
        elu.put(StringKey.SCAN_GUIDE, "Przytrzymaj kartę tutaj.\nZostanie ona zeskanowana automatycznie.");
        elu.put(StringKey.KEYBOARD, "Klawiatura…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Numer karty");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Dane karty");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Na tym urządzeniu nie można odczytać numeru karty za pomocą aparatu.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Aparat na tym urządzeniu jest niedostepny.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Przy otwieraniu aparatu na tym urządzeniu wystąpił nieoczekiwany błąd.");
    }
}
