package com.iqoption.welcomeonboarding.a;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final /* synthetic */ class d implements OnEditorActionListener {
    private final b dLQ;

    d(b bVar) {
        this.dLQ = bVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.dLQ.a(textView, i, keyEvent);
    }
}
