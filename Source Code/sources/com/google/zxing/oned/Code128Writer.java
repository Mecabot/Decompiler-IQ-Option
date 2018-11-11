package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class Code128Writer extends n {

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_128, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            StringBuilder stringBuilder = new StringBuilder("Contents length should be between 1 and 80 characters, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("Bad character in input: ");
                    stringBuilder2.append(charAt);
                    throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int d = d(str, i3, i4);
                if (d == i4) {
                    d = 101;
                    switch (str.charAt(i3)) {
                        case 241:
                            d = 102;
                            break;
                        case 242:
                            d = 97;
                            break;
                        case 243:
                            d = 96;
                            break;
                        case 244:
                            if (i4 != 101) {
                                d = 100;
                                break;
                            }
                            break;
                        default:
                            switch (i4) {
                                case 100:
                                    d = str.charAt(i3) - 32;
                                    break;
                                case 101:
                                    d = str.charAt(i3) - 32;
                                    if (d < 0) {
                                        d += 96;
                                        break;
                                    }
                                    break;
                                default:
                                    d = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                            }
                    }
                    i3++;
                    i7 = d;
                } else {
                    if (i4 == 0) {
                        switch (d) {
                            case 100:
                                i7 = 104;
                                break;
                            case 101:
                                break;
                            default:
                                i7 = 105;
                                break;
                        }
                    }
                    i7 = d;
                    i4 = d;
                }
                arrayList.add(c.act[i7]);
                i5 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                arrayList.add(c.act[i5 % 103]);
                arrayList.add(c.act[106]);
                length = 0;
                for (int[] iArr : arrayList) {
                    i5 = length;
                    for (int i62 : (int[]) r11.next()) {
                        i5 += i62;
                    }
                    length = i5;
                }
                boolean[] zArr = new boolean[length];
                for (int[] a : arrayList) {
                    i += n.a(zArr, i, a, true);
                }
                return zArr;
            }
        }
    }

    private static CType e(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        i++;
        if (i >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int d(CharSequence charSequence, int i, int i2) {
        CType e = e(charSequence, i);
        if (e == CType.ONE_DIGIT) {
            return 100;
        }
        if (e == CType.UNCODABLE) {
            if (i < charSequence.length()) {
                char charAt = charSequence.charAt(i);
                if (charAt < ' ' || (i2 == 101 && charAt < '`')) {
                    return 101;
                }
            }
            return 100;
        } else if (i2 == 99) {
            return 99;
        } else {
            if (i2 != 100) {
                if (e == CType.FNC_1) {
                    e = e(charSequence, i + 1);
                }
                if (e == CType.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (e == CType.FNC_1) {
                return 100;
            } else {
                CType e2 = e(charSequence, i + 2);
                if (e2 == CType.UNCODABLE || e2 == CType.ONE_DIGIT) {
                    return 100;
                }
                if (e2 != CType.FNC_1) {
                    i += 4;
                    while (true) {
                        e2 = e(charSequence, i);
                        if (e2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i += 2;
                    }
                    if (e2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (e(charSequence, i + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }
}
