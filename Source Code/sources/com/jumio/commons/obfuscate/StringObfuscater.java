package com.jumio.commons.obfuscate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class StringObfuscater {
    public static String format(byte[] bArr, long j) {
        byte[] bArr2 = new byte[bArr.length];
        new Random(j).nextBytes(bArr2);
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i]);
        }
        try {
            return new String(bArr2, "UTF8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr2);
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length != 1) {
            System.out.println("Usage: StringFormatting in");
            return;
        }
        byte[] bytes = strArr[0].getBytes("UTF8");
        byte[] bArr = new byte[bytes.length];
        long nextLong = SecureRandom.getInstance("SHA1PRNG").nextLong();
        new Random(nextLong).nextBytes(bArr);
        for (int i = 0; i < bytes.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bytes[i]);
        }
        System.out.print("{ ");
        Object obj = 1;
        for (byte b : bArr) {
            if (obj != null) {
                obj = null;
            } else {
                System.out.print(", ");
            }
            System.out.print(b);
        }
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" }, ");
        stringBuilder.append(nextLong);
        stringBuilder.append("l");
        printStream.println(stringBuilder.toString());
    }
}
