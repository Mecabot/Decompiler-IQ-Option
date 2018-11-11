package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

/* compiled from: CardNumberValidator */
class b implements n {
    static final int[] bWa = new int[]{4, 11};
    static final int[] bWb = new int[]{4, 9, 14};
    private String bVZ;
    private int bWc;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public b(String str) {
        this.bVZ = str;
    }

    public void afterTextChanged(Editable editable) {
        this.bVZ = k.lq(editable.toString());
        CardType fromCardNumber = CardType.fromCardNumber(this.bVZ);
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
            if ((fromCardNumber.numberLength() == 15 && (i == 4 || i == 11)) || ((fromCardNumber.numberLength() == 16 || fromCardNumber.numberLength() == 14) && (i == 4 || i == 9 || i == 14))) {
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
        if (this.bVZ.length() == CardType.fromCardNumber(this.bVZ).numberLength()) {
            z = true;
        }
        return z;
    }

    public boolean isValid() {
        if (abl() && c.hc(this.bVZ)) {
            return true;
        }
        return false;
    }

    public String getValue() {
        return this.bVZ;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String lq = k.lq(new SpannableStringBuilder(spanned).replace(i3, i4, charSequence, i, i2).toString());
        int numberLength = CardType.fromCardNumber(lq).numberLength();
        if (lq.length() > numberLength) {
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
