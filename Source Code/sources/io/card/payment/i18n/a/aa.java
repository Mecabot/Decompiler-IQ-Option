package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsZH_HANT */
public class aa implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "zh-Hant";
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

    public aa() {
        elu.put(StringKey.CANCEL, "取消");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "美國運通");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "完成");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "郵遞區號");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "持卡人名稱");
        elu.put(StringKey.ENTRY_EXPIRES, "到期日");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "月 / 年");
        elu.put(StringKey.SCAN_GUIDE, "將信用卡置於此處。\n裝置會自動掃描。");
        elu.put(StringKey.KEYBOARD, "鍵盤…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "卡號");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "信用卡詳細資料");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "此裝置無法使用相機讀取信用卡卡號。");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "無法使用裝置的相機。");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "此裝置啟動相機時發生意外錯誤。");
    }
}
