package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsRU */
public class v implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "ru";
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

    public v() {
        elu.put(StringKey.CANCEL, "Отмена");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Готово");
        elu.put(StringKey.ENTRY_CVV, "Код безопасности");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Индекс");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Имя и фамилия владельца");
        elu.put(StringKey.ENTRY_EXPIRES, "Действ. до");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "ММ/ГГ");
        elu.put(StringKey.SCAN_GUIDE, "Держите карту внутри рамки.\nОна будет считана автоматически.");
        elu.put(StringKey.KEYBOARD, "Клавиатура…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Номер карты");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Ввести данные вручную");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "В данном устройстве нет опции считывания номера карты с помощью фотокамеры.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Фотокамера устройства недоступна.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Возникла незапланированная ошибка при открытии фотокамеры устройства.");
    }
}
