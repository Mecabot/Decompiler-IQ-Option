package com.iqoption.portfolio.a;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.bi;
import com.iqoption.fragment.base.a;

/* compiled from: MessageBottomSheet */
public final class g extends a {
    private final long dct = 3000;
    private Runnable dcu = new Runnable() {
        public void run() {
            g.this.aN();
        }
    };
    private bi dcv;

    public static void a(@IdRes int i, FragmentManager fragmentManager, String str) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("MessageBottomSheet");
        if (findFragmentByTag != null) {
            ((g) findFragmentByTag).aN();
        }
        findFragmentByTag = new g();
        findFragmentByTag.setArguments(new com.iqoption.util.g().aA(".arg.message.text", str).toBundle());
        fragmentManager.beginTransaction().add(i, findFragmentByTag, "MessageBottomSheet").addToBackStack("MessageBottomSheet").commit();
    }

    protected View aeO() {
        return this.dcv.bls;
    }

    protected View aeP() {
        return this.dcv.blp;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        CharSequence string = getArguments().getString(".arg.message.text");
        if (TextUtils.isEmpty(string)) {
            onClose();
        }
        this.dcv = bi.c(layoutInflater, viewGroup, false);
        this.dcv.bls.setText(string);
        this.dcv.getRoot().postDelayed(this.dcu, 3000);
        return this.dcv.getRoot();
    }

    protected void ajR() {
        this.dcv.getRoot().removeCallbacks(this.dcu);
        this.dcu = null;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
