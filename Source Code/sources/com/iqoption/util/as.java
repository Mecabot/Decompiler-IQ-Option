package com.iqoption.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Util */
public class as {
    public static final String jM(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                while (toHexString.length() < 2) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("0");
                    stringBuilder2.append(toHexString);
                    toHexString = stringBuilder2.toString();
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
