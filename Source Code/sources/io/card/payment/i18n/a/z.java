package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsZH_HANS */
public class z implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "zh-Hans";
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

    public z() {
        elu.put(StringKey.CANCEL, "取消");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "完成");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "邮政编码");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "持卡人姓名");
        elu.put(StringKey.ENTRY_EXPIRES, "有效期限：");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY");
        elu.put(StringKey.SCAN_GUIDE, "持卡置于此处。\n设备会自动扫描卡。");
        elu.put(StringKey.KEYBOARD, "键盘…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "卡号");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "卡详细信息");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "此设备无法使用摄像头读取卡号。");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "设备摄像头不可用。");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "设备打开摄像头时出现意外错误。");
    }
}
