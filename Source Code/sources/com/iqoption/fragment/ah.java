package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.b.e;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.k;
import com.iqoption.core.util.i;
import com.iqoption.d.bw;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.system.a.d;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: CfdExpirationFragment */
public class ah extends b {
    private Builder adT;
    private bw cod;
    private com.iqoption.a.a.a coe;
    private a cof = new a();

    /* compiled from: CfdExpirationFragment */
    private static class a extends d {
        private final WeakReference<ah> ckC;

        private a(ah ahVar) {
            this.ckC = new WeakReference(ahVar);
        }

        @e
        public void changeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            if ((this.ckC.get() != null || ((ah) this.ckC.get()).isAdded()) && aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        ah ahVar = (ah) a.this.ckC.get();
                        if (ahVar != null && ahVar.isAdded() && ahVar.coe != null) {
                            ahVar.coe.dataSetChanged();
                        }
                    }
                });
            }
        }
    }

    public static ah ahf() {
        return new ah();
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i) {
        if (fragmentManager.findFragmentByTag("ExpirationFragment") == null) {
            fragmentManager.beginTransaction().add(i, ahf(), "ExpirationFragment").addToBackStack("ExpirationFragment").commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cod = (bw) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.cfd_expiration_fragment, viewGroup, false);
        this.cod.a(this);
        return this.cod.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.coe = new com.iqoption.a.a.a(new ai(this));
        this.cod.blU.setHasFixedSize(true);
        this.cod.blU.setAdapter(this.coe);
        IQApp.Dn().aE(new k.d(true));
    }

    final /* synthetic */ void m(View view, int i) {
        com.iqoption.app.managers.tab.a.Il().d(this.coe.cz(i));
        aN();
    }

    public void onStart() {
        super.onStart();
        if (this.coe != null) {
            this.coe.onStart();
        }
        this.cof.register();
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "expiration-time").setParameters(i.ZZ().l("instrument_type", com.iqoption.app.managers.tab.a.Il().Iv()).aab());
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        if (this.coe != null) {
            this.coe.onStop();
        }
        this.cof.unregister();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        IQApp.Dn().aE(new k.d(false));
        return true;
    }

    public void ND() {
        this.cod.blV.setAlpha(0.0f);
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.cod.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.cod.blV.setTranslationY(f);
            this.cod.blU.setTranslationX(f2);
            this.cod.blU.setTranslationY(f);
            this.cod.blU.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cod.blV, this.cod.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cod.blV.getWidth(), (double) this.cod.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cod.blV;
            r6 = new PropertyValuesHolder[2];
            r6[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r6);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            RecyclerView recyclerView = this.cod.blU;
            r11 = new PropertyValuesHolder[3];
            r11[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r11[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            r11[2] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(recyclerView, r11);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            this.cod.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.cod.blV.setTranslationX(f);
        this.cod.blV.setTranslationY(f);
        this.cod.blV.setPivotX((float) (this.cod.blV.getWidth() - dimensionPixelOffset));
        this.cod.blV.setPivotY(1.0f);
        this.cod.blV.setScaleX(0.3f);
        this.cod.blV.setScaleY(0.3f);
        this.cod.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cod.blV.animate().alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
