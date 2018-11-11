package com.facebook.internal;

import android.app.Activity;

/* compiled from: FacebookDialogBase */
public abstract class f<CONTENT, RESULT> {
    protected static final Object Ci = new Object();
    private int Bz;
    private final Activity Cj;
    private final n Ck;

    protected f(Activity activity, int i) {
        x.a((Object) activity, "activity");
        this.Cj = activity;
        this.Ck = null;
        this.Bz = i;
    }

    protected f(n nVar, int i) {
        x.a((Object) nVar, "fragmentWrapper");
        this.Ck = nVar;
        this.Cj = null;
        this.Bz = i;
        if (nVar.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }
}
