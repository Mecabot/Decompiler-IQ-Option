package com.iqoption.view.text;

import android.text.Editable;

/* compiled from: AddPlusSignTextWatcher */
public class a extends x {
    public void afterTextChanged(Editable editable) {
        if (editable.length() == 1 && editable.charAt(0) != '+') {
            editable.insert(0, "+");
        }
    }
}
