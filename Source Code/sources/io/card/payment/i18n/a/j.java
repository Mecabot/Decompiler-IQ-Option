package io.card.payment.i18n.a;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LocalizedStringsHE */
public class j implements c<StringKey> {
    private static Map<StringKey, String> elu = new HashMap();
    private static Map<String, String> elv = new HashMap();

    public String getName() {
        return "he";
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

    public j() {
        elu.put(StringKey.CANCEL, "ביטול");
        elu.put(StringKey.CARDTYPE_AMERICANEXPRESS, "אמריקן אקספרס");
        elu.put(StringKey.CARDTYPE_DISCOVER, "Discover‏");
        elu.put(StringKey.CARDTYPE_JCB, "JCB‏");
        elu.put(StringKey.CARDTYPE_MASTERCARD, "מאסטרקארד");
        elu.put(StringKey.CARDTYPE_VISA, "ויזה");
        elu.put(StringKey.DONE, "בוצע");
        elu.put(StringKey.ENTRY_CVV, "קוד אימות כרטיס");
        elu.put(StringKey.ENTRY_POSTAL_CODE, "מיקוד");
        elu.put(StringKey.ENTRY_CARDHOLDER_NAME, "שם בעל הכרטיס");
        elu.put(StringKey.ENTRY_EXPIRES, "תאריך תפוגה");
        elu.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY‏");
        elu.put(StringKey.SCAN_GUIDE, "החזק את הכרטיס כאן.\nהסריקה תתבצע באופן אוטומטי.");
        elu.put(StringKey.KEYBOARD, "מקלדת…");
        elu.put(StringKey.ENTRY_CARD_NUMBER, "מספר כרטיס");
        elu.put(StringKey.MANUAL_ENTRY_TITLE, "פרטי כרטיס");
        elu.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "המכשיר אינו מסוגל להשתמש במצלמה לקריאת מספרי כרטיס.");
        elu.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "מצלמת המכשיר אינה זמינה.");
        elu.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "המכשיר נתקל בשגיאה בלתי צפויה בזמן הפעלת המצלמה.");
    }
}
