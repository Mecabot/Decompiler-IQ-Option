package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsJA */
public class m implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "ja";
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

    public m() {
        elu.put(StringKey.CANCEL, "キャンセル");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "完了");
        elu.put(StringKey.ENTRY_CVV, "カード確認コード");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "郵便番号");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "カード保有者の名前");
        elu.put(StringKey.ENTRY_EXPIRES, "有効期限");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY");
        elu.put(StringKey.SCAN_GUIDE, "ここでカードをお持ちください。\n自動的にスキャンされます。");
        elu.put(StringKey.KEYBOARD, "キーボード…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "カード番号");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "カードの詳細");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "この端末ではカード番号の読込にカメラを使えません。");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "端末のカメラを使用できません。");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "カメラを起動中に予期しないエラーが発生しました。");
    }
}
