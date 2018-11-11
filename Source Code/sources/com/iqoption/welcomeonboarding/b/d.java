package com.iqoption.welcomeonboarding.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final /* synthetic */ class d implements OnEditorActionListener {
    private final c dLX;

    d(c cVar) {
        this.dLX = cVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.dLX.b(textView, i, keyEvent);
    }
}
