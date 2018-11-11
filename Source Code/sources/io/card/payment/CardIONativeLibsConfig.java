package io.card.payment;

public class CardIONativeLibsConfig {
    private static String eka;

    public static void init(String str) {
        eka = str;
    }

    static String aTB() {
        return eka;
    }
}
