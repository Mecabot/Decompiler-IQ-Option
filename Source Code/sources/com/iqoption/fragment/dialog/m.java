package com.iqoption.fragment.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.ir;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.util.ac;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: MarginAddOnPositionDialog */
public final class m extends b {
    private static final String TAG = "com.iqoption.fragment.dialog.m";
    private Builder aFE;
    private ir cAD;

    public long getAnimationDuration() {
        return 250;
    }

    public static void a(FragmentManager fragmentManager, long j) {
        if (ac.d(fragmentManager, TAG)) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, bp(j), TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(TAG).commit();
        } else {
            i.w(TAG, "Fragment exists");
        }
    }

    private static m bp(long j) {
        m mVar = new m();
        mVar.setArguments(new g().j("arg.position.id", j).toBundle());
        return mVar;
    }

    public void ND() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.cAD.getRoot(), View.ALPHA, new float[]{0.0f, 1.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.cAD.bmb, View.TRANSLATION_Y, new float[]{(float) ef(R.dimen.dp24), 0.0f});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }

    public void NE() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.cAD.getRoot(), View.ALPHA, new float[]{1.0f, 0.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.cAD.bmb, View.TRANSLATION_Y, new float[]{0.0f, (float) ef(R.dimen.dp24)});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cAD = ir.w(layoutInflater, viewGroup, false);
        this.cAD.getRoot().setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                m.this.dk(false);
                m.this.onClose();
            }
        });
        final long j = getArguments().getLong("arg.position.id");
        this.cAD.brN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                m.this.dk(true);
                f.b(Long.valueOf(j), Boolean.valueOf(true));
                m.this.onClose();
            }
        });
        this.cAD.blE.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                m.this.dk(false);
                m.this.onClose();
            }
        });
        return this.cAD.getRoot();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.aFE = Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_margin-add-on-show");
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.aFE != null) {
            EventManager.Bm().a(this.aFE.calcDuration().build());
        }
    }

    private void dk(boolean z) {
        if (this.aFE != null) {
            this.aFE.setValue(Double.valueOf(z ? 0.0d : 1.0d));
        }
    }
}
