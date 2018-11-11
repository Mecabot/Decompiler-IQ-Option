package com.iqoption.fragment.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.microservices.popupserver.response.a;
import com.iqoption.core.util.a.d;
import com.iqoption.core.util.a.e;
import com.iqoption.d.yi;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.fb;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.x.R;

/* compiled from: LegalUpdate */
public class h extends b {
    private static final String TAG = "com.iqoption.fragment.dialog.h";
    private Builder ajG;
    private yi cAA;
    private PopupViewModel cAB;
    private a cjK;

    public static void a(FragmentActivity fragmentActivity, a aVar) {
        a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), aVar);
    }

    private static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, a aVar) {
        PopupViewModel.j(fragmentActivity).a(new i(fragmentManager, aVar), aVar);
    }

    private static void a(FragmentManager fragmentManager, a aVar) {
        Fragment hVar = new h();
        hVar.setArguments(new g().b("arg_popup_id", (Parcelable) aVar).toBundle());
        fragmentManager.beginTransaction().add(R.id.fragment, hVar, TAG).addToBackStack(TAG).commitAllowingStateLoss();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.cjK = (a) getArguments().getParcelable("arg_popup_id");
        this.cAB = PopupViewModel.j(requireActivity());
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cAA = (yi) DataBindingUtil.inflate(layoutInflater, R.layout.legal_update, viewGroup, false);
        this.cAA.bKH.setOnClickListener(new j(this));
        com.iqoption.core.util.a.a[] aVarArr = new com.iqoption.core.util.a.a[]{new com.iqoption.core.util.a.a(getString(R.string.legal_provisions), getString(R.string.we_ve_updated_some_legal_provisions))};
        d.a(new e(aVarArr, this.cAA.aip, getString(R.string.we_ve_updated_some_legal_provisions), R.color.white, R.color.white_60, false, new k(this)));
        this.cAA.getRoot().setOnClickListener(new l(this, com.iqoption.util.b.bQ(requireContext())));
        return this.cAA.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ajG = Event.Builder(Event.CATEGORY_POPUP_SERVED, "legal-update_show");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("legal-update-shown");
        stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
        af.i(stringBuilder.toString(), true);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.ajG != null) {
            EventManager.Bm().a(this.ajG.calcDuration().build());
        }
    }

    private void alb() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "legal-update_legal-provisions").build());
        requireFragmentManager().beginTransaction().add(R.id.other_fragment, fb.ab(new g().aA("EXTRA_URL", "https://iqoption.com/en/articles/new-terms-announce").toBundle()), "WebFragment").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("WebFragment").commitAllowingStateLoss();
    }

    /* renamed from: onClose */
    public boolean ba() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "legal-update_accept").build());
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
        this.cAB.i(this.cjK);
        return true;
    }

    public void ND() {
        this.cAA.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cAA.bKI.setTranslationX((float) dimensionPixelSize2);
            this.cAA.bKI.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cAA.blV, this.cAA.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cAA.blV.getWidth(), (double) this.cAA.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            ConstraintLayout constraintLayout = this.cAA.bKI;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(constraintLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cAA.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cAA.blV.setTranslationX(f);
        this.cAA.blV.setTranslationY(f);
        this.cAA.blV.setPivotX((float) (this.cAA.blV.getWidth() - dimensionPixelOffset));
        this.cAA.blV.setPivotY(1.0f);
        this.cAA.blV.setScaleX(0.3f);
        this.cAA.blV.setScaleY(0.3f);
        this.cAA.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cAA.blV.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
