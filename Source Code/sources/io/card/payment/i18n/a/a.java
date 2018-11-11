package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsAR */
public class a implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "ar";
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

    public a() {
        elu.put(StringKey.CANCEL, "إلغاء");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express‏");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover‏");
        elu.put(StringKey.CARDTYPE_JCB, "JCB‏");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard‏");
        elu.put(StringKey.CARDTYPE_VISA, "Visa‏");
        elu.put(StringKey.DONE, "تم");
        elu.put(StringKey.ENTRY_CVV, "CVV‏");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "الرمز البريدي");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "اسم صاحب البطاقة");
        elu.put(StringKey.ENTRY_EXPIRES, "تاريخ انتهاء الصلاحية");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY‏");
        elu.put(StringKey.SCAN_GUIDE, "امسك البطاقة هنا.\n ستمسح تلقائيا.");
        elu.put(StringKey.KEYBOARD, "لوحة المفاتيح…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "رقم البطاقة");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "تفاصيل البطاقة");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "هذا الجهاز لا يمكنه استعمال الكاميرا لقراءة أرقام البطاقة.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "كاميرا الجهاز غير متاحة.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "الجهاز حدث به خطا غير متوقع عند فتح الكاميرا.");
    }
}
