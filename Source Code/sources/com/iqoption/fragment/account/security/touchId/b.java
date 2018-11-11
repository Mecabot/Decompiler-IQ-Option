package com.iqoption.fragment.account.security.touchId;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.d.lb;
import com.iqoption.x.R;

/* compiled from: TouchIdFragment */
public class b extends Fragment implements com.iqoption.fragment.account.security.touchId.c.b {
    private static final String TAG = "com.iqoption.fragment.account.security.touchId.b";
    private lb cuo;
    private Object cvC;

    /* compiled from: TouchIdFragment */
    public interface a {
        void ajg();

        s<Long> db(boolean z);
    }

    public static b ajP() {
        b bVar = new b();
        bVar.setArguments(new Bundle());
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        this.cuo = (lb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_page, viewGroup, false);
        if (af.aR(getContext()).EP() >= 0) {
            z = true;
        }
        a(z, this.cuo.bwt);
        if (!(getParentFragment() instanceof a)) {
            i.e(TAG, "OnFragmentInteractionListener is not implemented by target fragment");
        }
        return this.cuo.getRoot();
    }

    public void onDestroyView() {
        if (this.cvC != null) {
            IQApp.Dn().unregister(this.cvC);
            this.cvC = null;
        }
        super.onDestroyView();
    }

    public void ajg() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof a) {
            ((a) parentFragment).ajg();
        }
    }

    public s<Long> db(boolean z) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof a) {
            return ((a) parentFragment).db(z);
        }
        return o.m(new UnsupportedOperationException());
    }

    @NonNull
    private View a(boolean z, ViewGroup viewGroup) {
        c a = c.a(getContext(), viewGroup, z, this);
        this.cvC = a.ajQ();
        IQApp.Dn().aD(this.cvC);
        return a.getView();
    }
}
