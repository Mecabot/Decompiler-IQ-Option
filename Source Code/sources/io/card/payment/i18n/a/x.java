package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsTH */
public class x implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "th";
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

    public x() {
        elu.put(StringKey.CANCEL, "ยกเลิก");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover");
        elu.put(StringKey.CARDTYPE_JCB, "JCB");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
        elu.put(StringKey.CARDTYPE_VISA, "Visa");
        elu.put(StringKey.DONE, "เสร็จแล้ว");
        elu.put(StringKey.ENTRY_CVV, "CVV");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "รหัสไปรษณีย์");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "ชื่อผู้ถือบัตร");
        elu.put(StringKey.ENTRY_EXPIRES, "หมดอายุ");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "ดด/ปป");
        elu.put(StringKey.SCAN_GUIDE, "ถือบัตรไว้ตรงนี้\nเครื่องจะสแกนโดยอัตโนมัติ");
        elu.put(StringKey.KEYBOARD, "คีย์บอร์ด…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "หมายเลขบัตร");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "รายละเอียดบัตร");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "อุปกรณ์ไม่สามารถใช้กล้องเพื่ออ่านหมายเลขบัตรได้");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "กล้องของอุปกรณ์ไม่พร้อมใช้งาน");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "อุปกรณ์พบข้อผิดพลาดขณะเปิดกล้อง");
    }
}
