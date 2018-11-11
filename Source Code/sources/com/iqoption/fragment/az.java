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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.common.b.e;
import com.iqoption.a.a.c;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.d.kp;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.fragment.base.b;
import com.iqoption.system.a.d;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: ExpirationFragment */
public class az extends b {
    private Builder adT;
    private kp cpp;
    private c cpq;
    private c cpr;
    private a cps = new a(this, null);

    /* compiled from: ExpirationFragment */
    private static class a extends d {
        private final WeakReference<az> ckC;

        /* synthetic */ a(az azVar, AnonymousClass1 anonymousClass1) {
            this(azVar);
        }

        private a(az azVar) {
            this.ckC = new WeakReference(azVar);
        }

        @e
        public void changeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            if ((this.ckC.get() != null || ((az) this.ckC.get()).isAdded()) && aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        az azVar = (az) a.this.ckC.get();
                        if (azVar != null && azVar.isAdded()) {
                            if (azVar.cpr != null) {
                                azVar.cpr.dataSetChanged();
                            }
                            if (azVar.cpq != null) {
                                azVar.cpq.dataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    public long NF() {
        return 400;
    }

    public long NG() {
        return 250;
    }

    private static az ahx() {
        return new az();
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i) {
        fragmentManager.beginTransaction().add(i, ahx(), "ExpirationFragment").addToBackStack("ExpirationFragment").commit();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cpp = (kp) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.expiration_fragment, viewGroup, false);
        this.cpp.a(this);
        return this.cpp.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.cpp.blV.setOnTouchListener(ba.ckx);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setAutoMeasureEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.cpp.bvv.setLayoutManager(linearLayoutManager2);
        this.cpp.bvz.setLayoutManager(linearLayoutManager);
        int It = com.iqoption.app.managers.tab.a.Il().It();
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(It), InstrumentType.TURBO_INSTRUMENT);
        if (a == null || !a.ba(af.Hu().Hw())) {
            this.cpp.bvA.setText(R.string.n_a);
            this.cpp.bvz.setVisibility(8);
            this.cpp.bvy.setVisibility(8);
        } else {
            int intValue = 100 - a.Xi().intValue();
            TextView textView = this.cpp.bvA;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(intValue);
            stringBuilder.append("%");
            textView.setText(stringBuilder.toString());
            this.cpr = new c(InstrumentType.TURBO_INSTRUMENT, k.HB().c(a, Expiration.notInitilizedExpiration), new com.iqoption.a.b.a() {
                public void a(View view, int i) {
                    if (i >= 0 && i < az.this.cpr.getItemCount() && az.this.cpr.getItemCount() > 0) {
                        Expiration cz = az.this.cpr.cz(i);
                        if (com.iqoption.app.managers.tab.a.Il().Iv() == InstrumentType.TURBO_INSTRUMENT) {
                            com.iqoption.app.managers.tab.a.Il().d(cz);
                        } else {
                            com.iqoption.app.managers.tab.a.Il().d(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(com.iqoption.app.managers.tab.a.Il().It()), InstrumentType.TURBO_INSTRUMENT), cz);
                        }
                        az.this.aN();
                        if (az.this.adT != null) {
                            EventManager.Bm().a(az.this.adT.calcDuration().setValue(Double.valueOf((double) cz.expValue.longValue())).build());
                        }
                    }
                }
            });
            this.cpr.setHasStableIds(true);
            this.cpp.bvz.setAdapter(this.cpr);
        }
        com.iqoption.core.microservices.tradingengine.response.active.a a2 = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(It), InstrumentType.BINARY_INSTRUMENT);
        if (a2 == null || !a2.ba(af.Hu().Hw())) {
            this.cpp.bvw.setText(R.string.n_a);
            this.cpp.bvv.setVisibility(8);
            this.cpp.bvu.setVisibility(8);
        } else {
            int intValue2 = 100 - a2.Xi().intValue();
            TextView textView2 = this.cpp.bvw;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(intValue2);
            stringBuilder2.append("%");
            textView2.setText(stringBuilder2.toString());
            this.cpq = new c(InstrumentType.BINARY_INSTRUMENT, k.HB().c(a2, Expiration.notInitilizedExpiration), new com.iqoption.a.b.a() {
                public void a(View view, int i) {
                    if (i >= 0 && i < az.this.cpq.getItemCount() && az.this.cpq.getItemCount() > 0) {
                        Expiration cz = az.this.cpq.cz(i);
                        if (cz.expirationsInGroup != null) {
                            az.this.cpq.b(cz);
                            return;
                        }
                        if (com.iqoption.app.managers.tab.a.Il().Iv() == InstrumentType.BINARY_INSTRUMENT) {
                            com.iqoption.app.managers.tab.a.Il().d(cz);
                        } else {
                            com.iqoption.app.managers.tab.a.Il().d(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(com.iqoption.app.managers.tab.a.Il().It()), InstrumentType.BINARY_INSTRUMENT), cz);
                        }
                        az.this.aN();
                        if (az.this.adT != null) {
                            EventManager.Bm().a(az.this.adT.calcDuration().setValue(Double.valueOf((double) cz.expValue.longValue())).build());
                        }
                    }
                }
            });
            this.cpq.setHasStableIds(true);
            this.cpp.bvv.setAdapter(this.cpq);
        }
        IQApp.Dn().aE(new k.d(true));
    }

    public void onStart() {
        super.onStart();
        if (this.cpr != null) {
            this.cpr.onStart();
        }
        if (this.cpq != null) {
            this.cpq.onStart();
        }
        this.cps.register();
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "expiration-time").setParameters(i.ZZ().l("instrument_type", com.iqoption.app.managers.tab.a.Il().Iv()).aab());
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        if (this.cpr != null) {
            this.cpr.onStop();
        }
        if (this.cpq != null) {
            this.cpq.onStop();
        }
        this.cps.unregister();
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        IQApp.Dn().aE(new k.d(false));
        return true;
    }

    public void ND() {
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.cpp.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.cpp.blV.setTranslationY(f);
            this.cpp.bvv.setTranslationX(f2);
            this.cpp.bvv.setTranslationY(f);
            this.cpp.bvv.setAlpha(0.0f);
            this.cpp.bvz.setTranslationX(f2);
            this.cpp.bvz.setTranslationY(f);
            this.cpp.bvz.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpp.blV, this.cpp.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpp.blV.getWidth(), (double) this.cpp.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cpp.blV;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
            ofPropertyValuesHolder.setDuration(400).setInterpolator(timeInterpolator);
            RecyclerView recyclerView = this.cpp.bvv;
            propertyValuesHolderArr = new PropertyValuesHolder[3];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(recyclerView, propertyValuesHolderArr);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            RecyclerView recyclerView2 = this.cpp.bvz;
            r3 = new PropertyValuesHolder[3];
            r3[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            r3[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(recyclerView2, r3);
            ofPropertyValuesHolder3.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder3).with(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.cpp.blV.setTranslationX(f);
        this.cpp.blV.setTranslationY(f);
        this.cpp.blV.setPivotX((float) (this.cpp.blV.getWidth() - dimensionPixelOffset));
        this.cpp.blV.setPivotY(1.0f);
        this.cpp.blV.setScaleX(0.3f);
        this.cpp.blV.setScaleY(0.3f);
        this.cpp.blV.setAlpha(0.0f);
        this.cpp.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cpp.blV.animate().alpha(0.0f).setDuration(NG()).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
