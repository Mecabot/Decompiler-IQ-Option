package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.Date;

/* compiled from: ExpiryValidator */
class d implements n {
    private static final String TAG = "d";
    private boolean ekP;
    public int month;
    public int year;

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public d(int i, int i2) {
        this.month = i;
        this.year = i2;
        boolean z = this.month > 0 && this.year > 0;
        this.ekP = z;
        if (this.year < 2000) {
            this.year += 2000;
        }
    }

    public void afterTextChanged(Editable editable) {
        this.ekP = editable.length() >= 5;
        String obj = editable.toString();
        if (obj != null) {
            Date lo = c.lo(obj);
            if (lo != null) {
                this.month = lo.getMonth() + 1;
                this.year = lo.getYear();
                if (this.year < 1900) {
                    this.year += 1900;
                }
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.month = 0;
        this.year = 0;
        this.ekP = false;
    }

    public String getValue() {
        return String.format("%02d/%02d", new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year % 100)});
    }

    public boolean abl() {
        return this.ekP;
    }

    public boolean isValid() {
        boolean z = false;
        if (this.month < 1 || 12 < this.month) {
            return false;
        }
        Date date = new Date();
        if (this.year > (date.getYear() + 1900) + 15) {
            return false;
        }
        if (this.year > date.getYear() + 1900 || (this.year == date.getYear() + 1900 && this.month >= date.getMonth() + 1)) {
            z = true;
        }
        return z;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (i3 == 0 && spannableStringBuilder.length() > 0 && '1' < spannableStringBuilder.charAt(0) && spannableStringBuilder.charAt(0) <= '9') {
            spannableStringBuilder.insert(0, "0");
            i2++;
        }
        int i5 = i4 - i3;
        if (i3 - i5 <= 2 && (i3 + i2) - i5 >= 2) {
            i5 = 2 - i3;
            if (i5 == i2 || (i5 >= 0 && i5 < i2 && spannableStringBuilder.charAt(i5) != '/')) {
                spannableStringBuilder.insert(i5, "/");
                i2++;
            }
        }
        String spannableStringBuilder2 = new SpannableStringBuilder(spanned).replace(i3, i4, spannableStringBuilder, i, i2).toString();
        if (spannableStringBuilder2.length() >= 1 && (spannableStringBuilder2.charAt(0) < '0' || '1' < spannableStringBuilder2.charAt(0))) {
            return "";
        }
        if (spannableStringBuilder2.length() >= 2) {
            if (spannableStringBuilder2.charAt(0) != '0' && spannableStringBuilder2.charAt(1) > '2') {
                return "";
            }
            if (spannableStringBuilder2.charAt(0) == '0' && spannableStringBuilder2.charAt(1) == '0') {
                return "";
            }
        }
        return spannableStringBuilder2.length() > 5 ? "" : spannableStringBuilder;
    }
}
