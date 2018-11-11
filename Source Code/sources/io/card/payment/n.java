package io.card.payment;

import android.text.InputFilter;
import android.text.TextWatcher;

/* compiled from: Validator */
interface n extends InputFilter, TextWatcher {
    boolean abl();

    String getValue();

    boolean isValid();
}
