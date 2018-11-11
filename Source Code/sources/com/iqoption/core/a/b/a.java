package com.iqoption.core.a.b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.iqoption.core.f;
import com.iqoption.core.i;

/* compiled from: TextChangedEventHelper */
public class a implements OnFocusChangeListener, OnEditorActionListener {
    private static final String TAG = "com.iqoption.core.a.b.a";
    private final EditText aMM;
    private String aMN = "";
    private final String sD;

    public a(EditText editText, String str) {
        this.aMM = editText;
        this.sD = str;
        editText.setOnEditorActionListener(this);
        editText.setOnFocusChangeListener(this);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            try {
                if (this.aMM.getText().toString().compareTo(this.aMN) != 0) {
                    i.v(TAG, this.sD);
                    RW();
                }
            } catch (Throwable e) {
                i.e(TAG, "onEditorAction error", e);
            }
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            try {
                this.aMN = this.aMM.getText().toString();
            } catch (Throwable e) {
                i.e(TAG, "onFocusChange error", e);
            }
        } else if (this.aMM.getText().toString().compareTo(this.aMN) != 0) {
            i.v(TAG, this.sD);
            RW();
        }
    }

    protected void RW() {
        f.RQ().Ds().dX(this.sD);
    }
}
