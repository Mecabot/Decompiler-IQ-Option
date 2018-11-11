package com.jumio.commons.utils;

import java.util.Locale;

public class StringCheck {
    private static final String DELIMITER = " ";
    private String stringToCompare;
    private String trueValue;

    public StringCheck(String str, String str2) {
        this.trueValue = trim(str);
        this.stringToCompare = str2;
    }

    private String trim(String str) {
        String[] split = str.trim().split(DELIMITER);
        if (split.length <= 1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(split[0].trim());
        stringBuilder.append(DELIMITER);
        stringBuilder.append(split[split.length - 1].trim());
        return stringBuilder.toString();
    }

    public int getLevenshteinDistance() {
        if (this.trueValue == null || this.stringToCompare == null) {
            return -1;
        }
        int i;
        this.trueValue = this.trueValue.toLowerCase(Locale.getDefault());
        this.stringToCompare = this.stringToCompare.toLowerCase(Locale.getDefault());
        int[] iArr = new int[(this.stringToCompare.length() + 1)];
        for (i = 0; i < iArr.length; i++) {
            iArr[i] = i;
        }
        for (i = 1; i <= this.trueValue.length(); i++) {
            iArr[0] = i;
            int i2 = i - 1;
            int i3 = i2;
            int i4 = 1;
            while (i4 <= this.stringToCompare.length()) {
                int i5 = i4 - 1;
                int min = Math.min(iArr[i4], iArr[i5]) + 1;
                if (this.trueValue.charAt(i2) != this.stringToCompare.charAt(i5)) {
                    i3++;
                }
                i3 = Math.min(min, i3);
                min = iArr[i4];
                iArr[i4] = i3;
                i4++;
                i3 = min;
            }
        }
        return iArr[this.stringToCompare.length()];
    }

    public boolean isSimilar() {
        boolean z = false;
        if (this.trueValue == null || this.stringToCompare == null) {
            return false;
        }
        if (Math.round(((float) Math.min(this.trueValue.length(), this.stringToCompare.length())) * 0.2f) >= getLevenshteinDistance()) {
            z = true;
        }
        return z;
    }
}
