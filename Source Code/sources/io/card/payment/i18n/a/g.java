package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsES */
public class g implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "es";
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

    public g() {
        elu.put(StringKey.CANCEL, "Cancelar");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Hecho");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Código postal");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nombre del titular de la tarjeta");
        elu.put(StringKey.ENTRY_EXPIRES, "Vence");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        elu.put(StringKey.SCAN_GUIDE, "Mantén la tarjeta aquí.\nSe escaneará automáticamente.");
        elu.put(StringKey.KEYBOARD, "Teclado…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Número de tarjeta");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Detalles de la tarjeta");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo no puede usar la cámara para leer números de tarjeta.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "La cámara del dispositivo no está disponible.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Al abrir la cámara, el dispositivo ha experimentado un error inesperado.");
    }
}
