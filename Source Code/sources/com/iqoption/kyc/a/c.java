package com.iqoption.kyc.a;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: KycTextChangedEventHelper */
public class c implements OnFocusChangeListener, OnEditorActionListener {
    private static final String TAG = "com.iqoption.kyc.a.c";
    private final EditText aMM;
    private String aMN = "";
    private final boolean aMv;
    private final String cKs;
    private final String cKt;
    private final int fieldId;
    private final String fieldName;

    public c(EditText editText, String str, String str2, String str3, int i, boolean z) {
        this.aMM = editText;
        this.cKs = str;
        this.cKt = str2;
        this.fieldName = str3;
        this.fieldId = i;
        this.aMv = z;
        editText.setOnEditorActionListener(this);
        editText.setOnFocusChangeListener(this);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6 && this.aMM.getText().toString().compareTo(this.aMN) != 0) {
            a.a(this.aMM.getContext(), this.cKs, this.cKt, this.fieldName, this.fieldId, this.aMv);
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.aMN = this.aMM.getText().toString();
        } else if (this.aMM.getText().toString().compareTo(this.aMN) != 0) {
            a.a(this.aMM.getContext(), this.cKs, this.cKt, this.fieldName, this.fieldId, this.aMv);
        }
    }
}
