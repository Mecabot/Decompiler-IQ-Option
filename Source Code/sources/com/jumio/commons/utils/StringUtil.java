package com.jumio.commons.utils;

import java.util.regex.Pattern;

public class StringUtil {
    public static String trim(String str, int i) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static String trim(String str, int i, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        trim(str, i);
        return !Pattern.compile(str2).matcher(str).matches() ? null : str;
    }

    public static boolean nullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static String binToHex(byte[] bArr) {
        String str = new String("");
        for (int i = 0; i < bArr.length; i++) {
            str = str.concat(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return str;
    }

    public static byte[] hexToBin(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }
}
