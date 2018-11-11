package com.google.android.gms.common.images;

import com.iqoption.dto.ChartTimeInterval;

public final class Size {
    private final int zzalt;
    private final int zzalu;

    public Size(int i, int i2) {
        this.zzalt = i;
        this.zzalu = i2;
    }

    public static Size parseSize(String str) {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(ChartTimeInterval.CANDLE_2m);
        }
        if (indexOf < 0) {
            throw zzgm(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException unused) {
            throw zzgm(str);
        }
    }

    private static NumberFormatException zzgm(String str) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 16);
        stringBuilder.append("Invalid Size: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zzalt == size.zzalt && this.zzalu == size.zzalu;
        }
    }

    public final int getHeight() {
        return this.zzalu;
    }

    public final int getWidth() {
        return this.zzalt;
    }

    public final int hashCode() {
        return this.zzalu ^ ((this.zzalt << 16) | (this.zzalt >>> 16));
    }

    public final String toString() {
        int i = this.zzalt;
        int i2 = this.zzalu;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
