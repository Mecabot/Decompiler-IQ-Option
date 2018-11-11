package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsPT_BR */
public class u implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "pt_BR";
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

    public u() {
        elu.put(StringKey.CANCEL, "Cancelar");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "Concluído");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "CEP");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "Nome do titular do cartão");
        elu.put(StringKey.ENTRY_EXPIRES, "Vencimento");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
        elu.put(StringKey.SCAN_GUIDE, "Posicionar cartão aqui.\nEle será digitalizado automaticamente.");
        elu.put(StringKey.KEYBOARD, "Teclado…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "Número do Cartão");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "Dados do cartão");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode usar a câmera para ler números de cartão.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "A câmera do dispositivo não está disponível.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "O dispositivo sofreu um erro inesperado ao abrir a câmera.");
    }
}
