package com.iqoption.welcomeonboarding.d;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final /* synthetic */ class c implements OnEditorActionListener {
    private final b dNM;

    c(b bVar) {
        this.dNM = bVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.dNM.c(textView, i, keyEvent);
    }
}
