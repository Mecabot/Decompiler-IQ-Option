package com.pro100svitlo.creditCardNfcReader.enums;

import com.pro100svitlo.creditCardNfcReader.a.a;
import java.util.regex.Pattern;
import org.apache.commons.lang3.c;

public enum EmvCardScheme {
    UNKNOWN("", "", new String[0]),
    VISA("VISA", "^4[0-9]{6,}$", "A0 00 00 00 03", "A0 00 00 00 03 10 10", "A0 00 00 00 98 08 48"),
    NAB_VISA("VISA", "^4[0-9]{6,}$", "A0 00 00 00 03", "A0 00 00 03", "A0 00 00 00 03 10 10", "A0 00 00 00 98 08 48"),
    MASTER_CARD("Master card", "^5[1-5][0-9]{5,}$", "A0 00 00 00 04", "A0 00 00 00 05"),
    AMERICAN_EXPRESS("American express", "^3[47][0-9]{5,}$", "A0 00 00 00 25"),
    CB("CB", null, "A0 00 00 00 42"),
    LINK("LINK", null, "A0 00 00 00 29"),
    JCB("JCB", "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$", "A0 00 00 00 65"),
    DANKORT("Dankort", null, "A0 00 00 01 21 10 10"),
    COGEBAN("CoGeBan", null, "A0 00 00 01 41 00 01"),
    DISCOVER("Discover", "(6011|65|64[4-9]|622)[0-9]*", "A0 00 00 01 52 30 10"),
    BANRISUL("Banrisul", null, "A0 00 00 01 54"),
    SPAN("Saudi Payments Network", null, "A0 00 00 02 28"),
    INTERAC("Interac", null, "A0 00 00 02 77"),
    ZIP("Discover Card", null, "A0 00 00 03 24"),
    UNIONPAY("UnionPay", "^62[0-9]{14,17}", "A0 00 00 03 33"),
    EAPS("Euro Alliance of Payment Schemes", null, "A0 00 00 03 59"),
    VERVE("Verve", null, "A0 00 00 03 71"),
    TENN("The Exchange Network ATM Network", null, "A0 00 00 04 39"),
    RUPAY("Rupay", null, "A0 00 00 05 24 10 10"),
    ПРО100("ПРО100", null, "A0 00 00 04 32 00 01"),
    ZKA("ZKA", null, "D2 76 00 00 25 45 50 01 00"),
    BANKAXEPT("Bankaxept", null, "D5 78 00 00 02 10 10"),
    BRADESCO("BRADESCO", null, "F0 00 00 00 03 00 01"),
    MIDLAND("Midland", null, "A0 00 00 00 24 01"),
    PBS("PBS", null, "A0 00 00 01 21 10 10"),
    ETRANZACT("eTranzact", null, "A0 00 00 04 54"),
    GOOGLE("Google", null, "A0 00 00 04 76 6C"),
    INTER_SWITCH("InterSwitch", null, "A0 00 00 03 71 00 01");
    
    private final String[] aids;
    private final byte[][] aidsByte;
    private final String name;
    private final Pattern pattern;

    private EmvCardScheme(String str, String str2, String... strArr) {
        this.aids = strArr;
        this.aidsByte = new byte[strArr.length][];
        for (int i = 0; i < this.aids.length; i++) {
            this.aidsByte[i] = a.lj(strArr[i]);
        }
        this.name = str;
        if (c.T(str2)) {
            this.pattern = Pattern.compile(str2);
        } else {
            this.pattern = null;
        }
    }

    public String[] getAid() {
        return this.aids;
    }

    public String getName() {
        return this.name;
    }

    public static EmvCardScheme getCardTypeByAid(String str) {
        EmvCardScheme emvCardScheme = UNKNOWN;
        if (str == null) {
            return emvCardScheme;
        }
        str = c.ni(str);
        EmvCardScheme emvCardScheme2 = emvCardScheme;
        for (EmvCardScheme emvCardScheme3 : values()) {
            for (String ni : emvCardScheme3.getAid()) {
                if (str.startsWith(c.ni(ni))) {
                    emvCardScheme2 = emvCardScheme3;
                    break;
                }
            }
        }
        return emvCardScheme2;
    }

    public static EmvCardScheme getCardTypeByCardNumber(String str) {
        EmvCardScheme emvCardScheme = UNKNOWN;
        if (str == null) {
            return emvCardScheme;
        }
        for (EmvCardScheme emvCardScheme2 : values()) {
            if (emvCardScheme2.pattern != null && emvCardScheme2.pattern.matcher(c.ni(str)).matches()) {
                return emvCardScheme2;
            }
        }
        return emvCardScheme;
    }

    public byte[][] getAidByte() {
        return this.aidsByte;
    }
}
