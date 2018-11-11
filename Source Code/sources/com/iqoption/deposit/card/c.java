package com.iqoption.deposit.card;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import com.iqoption.core.util.a;
import com.iqoption.core.util.p;
import io.card.payment.CardType;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/* compiled from: CardNumberValidator */
public class c implements g {
    static final int[] bWa = new int[]{4, 11};
    static final int[] bWb = new int[]{4, 9, 14};
    private String bVZ;
    private int bWc;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.bVZ = p.v(editable.toString());
        CardType gV = a.gV(this.bVZ);
        if (gV == null) {
            gV = CardType.UNKNOWN;
        }
        int i = 0;
        if (this.bWc > 1) {
            int i2 = this.bWc;
            int i3 = this.bWc - 1;
            this.bWc = 0;
            if (i2 > i3) {
                editable.delete(i3, i2);
            }
        }
        while (i < editable.length()) {
            char charAt = editable.charAt(i);
            if ((gV.numberLength() == 15 && (i == 4 || i == 11)) || ((gV.numberLength() == 16 || gV.numberLength() == 14) && (i == 4 || i == 9 || i == 14))) {
                if (charAt != ' ') {
                    editable.insert(i, " ");
                }
            } else if (charAt == ' ') {
                editable.delete(i, i + 1);
                i--;
            }
            i++;
        }
    }

    public boolean abl() {
        boolean z = false;
        if (TextUtils.isEmpty(this.bVZ)) {
            return false;
        }
        CardType gV = a.gV(this.bVZ);
        if (gV == null || gV == CardType.UNKNOWN) {
            return true;
        }
        if (this.bVZ.length() == gV.numberLength()) {
            z = true;
        }
        return z;
    }

    public boolean isValid() {
        if (abl() && hc(this.bVZ)) {
            return true;
        }
        return false;
    }

    public static boolean hc(String str) {
        r0 = new int[2][];
        boolean z = false;
        r0[0] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        r0[1] = new int[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        CharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        char last = stringCharacterIterator.last();
        int i = 0;
        int i2 = 0;
        while (last != 65535) {
            if (!Character.isDigit(last)) {
                return false;
            }
            int i3 = i2 + 1;
            i += r0[i2 & 1][last - 48];
            last = stringCharacterIterator.previous();
            i2 = i3;
        }
        if (i % 10 == 0) {
            z = true;
        }
        return z;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String v = p.v(new SpannableStringBuilder(spanned).replace(i3, i4, charSequence, i, i2).toString());
        CardType gV = a.gV(v);
        if (gV == null) {
            gV = CardType.UNKNOWN;
        }
        int numberLength = gV.numberLength();
        if (v.length() > numberLength) {
            return "";
        }
        int[] iArr;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (numberLength == 15) {
            iArr = bWa;
        } else {
            iArr = bWb;
        }
        i4 -= i3;
        int i5 = 0;
        while (i5 < iArr.length) {
            if (charSequence.length() == 0 && i3 == iArr[i5] && spanned.charAt(i3) == ' ') {
                this.bWc = iArr[i5];
            }
            if (i3 - i4 <= iArr[i5] && (i3 + i2) - i4 >= iArr[i5]) {
                int i6 = iArr[i5] - i3;
                if (i6 == i2 || (i6 >= 0 && i6 < i2 && spannableStringBuilder.charAt(i6) != ' ')) {
                    spannableStringBuilder.insert(i6, " ");
                    i2++;
                }
            }
            i5++;
        }
        return spannableStringBuilder;
    }
}
