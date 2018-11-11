package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsTR */
public class y implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "tr";
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

    public y() {
        elu.put(StringKey.CANCEL, "İptal");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Bitti");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Posta Kodu");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Kart sahibinin adı");
        elu.put(StringKey.ENTRY_EXPIRES, "Son kullanma tarihi");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "AA/YY");
        elu.put(StringKey.SCAN_GUIDE, "Kartınızı buraya tutun.\nOtomatik olarak taranacaktır.");
        elu.put(StringKey.KEYBOARD, "Klavye…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Kart Numarası");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Kart Ayrıntıları");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Bu cihazın kamerası kart rakamlarını okuyamaz.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Cihaz kamerası kullanılamıyor.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Cihaz kamerayı açarken beklenmedik bir hata verdi.");
    }
}
