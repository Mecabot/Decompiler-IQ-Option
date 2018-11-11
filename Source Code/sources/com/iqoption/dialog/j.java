package com.iqoption.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.d.jp;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

/* compiled from: ReloadPracticeDialog */
public class j extends b {
    private Builder adT;
    private DecimalFormat cfo;
    private double cfp;
    private String cfq;
    private AnimatorSet cfr;
    private jp cfs;

    /* compiled from: ReloadPracticeDialog */
    private static class a implements Runnable {
        private static volatile a cfx;
        private final WeakReference<FragmentManager> cfv;
        private final WeakReference<FragmentActivity> cfw;

        public a(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
            this.cfw = new WeakReference(fragmentActivity);
            this.cfv = new WeakReference(fragmentManager);
        }

        public void run() {
            FragmentActivity fragmentActivity = (FragmentActivity) this.cfw.get();
            FragmentManager fragmentManager = (FragmentManager) this.cfv.get();
            if (fragmentActivity != null && fragmentManager != null) {
                j.a(fragmentActivity, fragmentManager);
            }
        }

        public static synchronized boolean aev() {
            boolean z;
            synchronized (a.class) {
                z = cfx == null;
            }
            return z;
        }

        public static synchronized a b(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
            a aVar;
            synchronized (a.class) {
                if (cfx == null) {
                    synchronized (a.class) {
                        if (cfx == null) {
                            cfx = new a(fragmentActivity, fragmentManager);
                        }
                    }
                }
                aVar = cfx;
            }
            return aVar;
        }
    }

    public long getAnimationDuration() {
        return 350;
    }

    private static j aes() {
        return new j();
    }

    public static void a(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager, com.iqoption.app.a aVar) {
        if (!af.eN("is_showed_reload_practice_dialog") && !aVar.CZ() && aVar.Cy() == 4 && aVar.Cx().doubleValue() < 1000.0d && a.aev()) {
            com.iqoption.core.d.a.aSe.postDelayed(a.b(fragmentActivity, fragmentManager), 5000);
        }
    }

    public static void a(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        PopupViewModel.j(fragmentActivity).a(new k(fragmentManager), "ReloadPracticeDialog");
    }

    private static void e(@NonNull FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("ReloadPracticeDialog") == null) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, aes(), "ReloadPracticeDialog").addToBackStack("ReloadPracticeDialog").commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cfs = (jp) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_reload_practice, viewGroup, false);
        af.i("is_showed_reload_practice_dialog", true);
        this.cfs.btH.setOnClickListener(new l(this));
        this.cfs.bjF.setOnClickListener(new m(this));
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        Balance cG = Cw.cG(4);
        ConversionCurrency eh = Cw.eh(Balance.getCurrency(cG));
        this.cfo = q.P("#", l.f(eh));
        this.cfp = Balance.getBalanceValue(cG);
        this.cfq = l.d(eh);
        this.cfs.btG.setText(l.a(this.cfq, Double.valueOf(this.cfp), this.cfo));
        this.cfs.btL.setOnClickListener(new n(this));
        return this.cfs.getRoot();
    }

    final /* synthetic */ void V(View view) {
        Requests.auA();
        aN();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "reload_practice_dialog");
        com.iqoption.core.d.a.aSe.postDelayed(new o(this), getAnimationDuration());
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.cfr != null) {
            this.cfr.removeAllListeners();
            this.cfr.cancel();
            this.cfr = null;
        }
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public boolean onClose() {
        if (this.cfr != null) {
            this.cfr.removeAllListeners();
            this.cfr.cancel();
            this.cfr = null;
        }
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("ReloadPracticeDialog");
        return true;
    }

    public void ND() {
        com.iqoption.view.a.a.a.c(this.cfs.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66)).setInterpolator(d.dEM);
        ObjectAnimator.ofPropertyValuesHolder(this.cfs.btI, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})}).setInterpolator(new OvershootInterpolator(2.5f));
        ObjectAnimator.ofFloat(this.cfs.btI, View.ALPHA, new float[]{0.0f, 1.0f}).setInterpolator(d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{r0, r1, r3});
        animatorSet.start();
    }

    public void NE() {
        Animator c = com.iqoption.view.a.a.a.c(this.cfs.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        FrameLayout frameLayout = this.cfs.btI;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }

    private void aet() {
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cfs.btK, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.5f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.5f, 1.0f})});
        ofPropertyValuesHolder.setDuration(500);
        ofPropertyValuesHolder.setInterpolator(d.dEM);
        Animator ofFloat = ObjectAnimator.ofFloat(this.cfs.btK, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(d.dEM);
        Animator ofObject = ValueAnimator.ofObject(new TypeEvaluator<Double>() {
            /* renamed from: a */
            public Double evaluate(float f, Double d, Double d2) {
                return Double.valueOf(d.doubleValue() + (((double) f) * (d2.doubleValue() - d.doubleValue())));
            }
        }, new Object[]{Double.valueOf(this.cfp), Double.valueOf(10000.0d)});
        ofObject.setDuration(500);
        ofObject.setInterpolator(d.dEM);
        ofObject.addUpdateListener(new p(this));
        Animator ofObject2 = ObjectAnimator.ofObject(this.cfs.btG, "textColor", new ArgbEvaluator(), new Object[]{Integer.valueOf(-1), Integer.valueOf(getColor(R.color.orange_practice))});
        ofObject2.setDuration(500);
        ofObject2.setInterpolator(d.dEM);
        Animator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(1000);
        this.cfr = new AnimatorSet();
        this.cfr.play(ofPropertyValuesHolder).after(500);
        this.cfr.play(ofFloat).after(ofPropertyValuesHolder).with(ofObject).with(ofObject2);
        this.cfr.play(ofFloat2).after(ofObject);
        this.cfr.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                j.this.cfs.btK.setAlpha(1.0f);
                j.this.cfs.btG.setTextColor(-1);
                j.this.cfs.btG.setText(l.a(j.this.cfq, Double.valueOf(j.this.cfp), j.this.cfo));
            }

            public void onAnimationEnd(Animator animator) {
                j.this.cfr.start();
            }
        });
        this.cfr.start();
    }
}
