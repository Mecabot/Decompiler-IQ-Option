package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

/* compiled from: FragmentWrapper */
public class n {
    private Fragment DU;
    private android.app.Fragment DV;

    public n(Fragment fragment) {
        x.a((Object) fragment, "fragment");
        this.DU = fragment;
    }

    public n(android.app.Fragment fragment) {
        x.a((Object) fragment, "fragment");
        this.DV = fragment;
    }

    public android.app.Fragment getNativeFragment() {
        return this.DV;
    }

    public Fragment mb() {
        return this.DU;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.DU != null) {
            this.DU.startActivityForResult(intent, i);
        } else {
            this.DV.startActivityForResult(intent, i);
        }
    }

    public final Activity getActivity() {
        if (this.DU != null) {
            return this.DU.getActivity();
        }
        return this.DV.getActivity();
    }
}
