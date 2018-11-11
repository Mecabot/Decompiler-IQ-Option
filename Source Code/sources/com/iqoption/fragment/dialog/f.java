package com.iqoption.fragment.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.iqoption.analytics.c;
import com.iqoption.app.managers.feature.a;
import com.iqoption.d.il;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.text.DecimalFormat;

/* compiled from: DialogCongratOtnEmissionExecuted */
public class f extends b {
    public Builder adT;
    private double cAv;
    private final DecimalFormat cAw = l.aGc();
    private il cAx;
    private double commissionVolumeEnrolled;
    private double totalCommissionEnrolled;

    public static void a(FragmentActivity fragmentActivity, @IdRes int i, FragmentManager fragmentManager, double d, double d2, double d3) {
        if (a.HD() && a.HE()) {
            PopupViewModel.j(fragmentActivity).a(new g(fragmentManager, i, new g().e("arg.otn.change.value", d).e("arg.value.balance", d2).e("arg.total.value.balance", d3).toBundle()), "DialogCongratOtnEmissionExecuted");
        }
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle) {
        if (fragmentManager.findFragmentByTag("DialogCongratOtnEmissionExecuted") == null) {
            fragmentManager.beginTransaction().add(i, ac(bundle), "DialogCongratOtnEmissionExecuted").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("DialogCongratOtnEmissionExecuted").commitAllowingStateLoss();
        }
    }

    private static f ac(Bundle bundle) {
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cAx = (il) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_congrat_otn_emission_executed, viewGroup, false);
        this.cAx.a(this);
        Bundle arguments = getArguments();
        this.cAv = arguments.getDouble("arg.otn.change.value");
        this.commissionVolumeEnrolled = arguments.getDouble("arg.value.balance");
        this.totalCommissionEnrolled = arguments.getDouble("arg.total.value.balance");
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        ConversionCurrency eh = Cw.eh(Balance.getCurrency(Cw.cG(1)));
        String e = l.e(l.d(eh), l.d(Double.valueOf(this.commissionVolumeEnrolled), l.c(eh)));
        this.cAx.brU.setText(getString(R.string.you_receive_tokens_for_turnover, e));
        this.cAx.brV.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                f.this.onClose();
            }
        });
        this.cAx.bmW.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                s.a(f.this.getId(), f.this.getFragmentManager(), f.this.totalCommissionEnrolled, f.this.commissionVolumeEnrolled, f.this.cAv);
                c.Bk();
            }
        });
        this.cAx.bsc.kg("0.000000");
        this.cAx.brR.setLayoutTransition(bg.aGE());
        this.cAx.brT.setLayoutTransition(bg.aGE());
        this.cAx.brX.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                s.a(f.this.getId(), f.this.getFragmentManager(), f.this.totalCommissionEnrolled, f.this.commissionVolumeEnrolled, f.this.cAv);
                c.Bk();
            }
        });
        return this.cAx.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adT = c.Bl();
        com.iqoption.activity.b ajV = ajV();
        if (ajV != null && ajV.zN()) {
            am.a(zzakw(), this.cAx.getRoot());
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        c.a(this.adT, this.cAv, this.commissionVolumeEnrolled);
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("DialogCongratOtnEmissionExecuted");
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void ND() {
        this.cAx.brJ.setAlpha(0.0f);
        this.cAx.blV.setAlpha(0.0f);
        this.cAx.bsc.c(this.cAw.format(this.cAv), 0, 500);
        this.cAx.blV.setTranslationY((float) getResources().getDimensionPixelSize(R.dimen.dp48));
        this.cAx.brZ.setAlpha(0.0f);
        this.cAx.brZ.setScaleX(0.1f);
        this.cAx.brZ.setScaleY(0.1f);
        this.cAx.brY.setAlpha(0.0f);
        Animator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(0), Integer.valueOf(-1476395008)});
        ofObject.addUpdateListener(new com.iqoption.view.a.a.a(this.cAx.brJ));
        ofObject.setDuration(400);
        FrameLayout frameLayout = this.cAx.blV;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration(500);
        Animator ofFloat = ObjectAnimator.ofFloat(this.cAx.brY, View.ALPHA, new float[]{1.0f});
        ofFloat.setDuration(700);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.cAx.brY, View.ALPHA, new float[]{0.0f});
        ofFloat2.setDuration(300);
        ImageView imageView = this.cAx.brZ;
        r8 = new PropertyValuesHolder[4];
        r8[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        r8[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.7f, 1.0f});
        r8[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.7f, 1.0f});
        r8[3] = PropertyValuesHolder.ofFloat(View.ROTATION, new float[]{360.0f});
        Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, r8);
        ofPropertyValuesHolder2.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(d.dEM);
        animatorSet.play(ofObject).with(ofPropertyValuesHolder2).with(ofPropertyValuesHolder);
        animatorSet.play(ofFloat).before(ofFloat2);
        animatorSet.start();
        this.cAx.brJ.setAlpha(1.0f);
    }

    public void NE() {
        Animator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(-1476395008), Integer.valueOf(0)});
        ofObject.addUpdateListener(new com.iqoption.view.a.a.a(this.cAx.brJ));
        FrameLayout frameLayout = this.cAx.bsb;
        r3 = new PropertyValuesHolder[3];
        r3[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        r3[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.7f});
        r3[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.7f});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(d.dEM);
        com.iqoption.util.b.a(animatorSet, 300);
        animatorSet.play(ofObject).with(ofPropertyValuesHolder);
        animatorSet.start();
    }
}
