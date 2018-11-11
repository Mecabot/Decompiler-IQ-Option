package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

/* compiled from: FixedLengthValidator */
class e implements n {
    public int ekQ;
    private String value;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public e(int i) {
        this.ekQ = i;
    }

    public void afterTextChanged(Editable editable) {
        this.value = editable.toString();
    }

    public String getValue() {
        return this.value;
    }

    public boolean abl() {
        return isValid();
    }

    public boolean isValid() {
        return this.value != null && this.value.length() == this.ekQ;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return (i2 <= 0 || ((spanned.length() + i4) - i3) + i2 <= this.ekQ) ? null : "";
    }
}
