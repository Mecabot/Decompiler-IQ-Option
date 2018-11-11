package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsPT */
public class t implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "pt";
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

    public t() {
        elu.put(StringKey.CANCEL, "Cancelar");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Concluir");
        elu.put(StringKey.ENTRY_CVV, "CSC");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "Código postal");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nome do titular do cartão");
        elu.put(StringKey.ENTRY_EXPIRES, "Validade");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        elu.put(StringKey.SCAN_GUIDE, "Segure o cartão aqui.\nSerá lido automaticamente.");
        elu.put(StringKey.KEYBOARD, "Teclado…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Número do cartão");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Detalhes do cartão");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode utilizar a câmara para ler números de cartões.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "A câmara do dispositivo não está disponível.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Ocorreu um erro inesperado no dispositivo ao abrir a câmara.");
    }
}
