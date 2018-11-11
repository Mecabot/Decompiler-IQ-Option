package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.analytics.j;
import com.iqoption.app.managers.tab.a;
import com.iqoption.d.qb;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.q;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: PendingOrderExecutedFragment */
public final class by extends b {
    private int ID;
    private final Runnable cpw = new bz(this);
    private int cqA;
    private PendingOrderWrapper cqB;
    private final j cqC = new j();
    private qb cqz;
    private final Handler handler = new Handler();

    private static by aa(Bundle bundle) {
        by byVar = new by();
        byVar.setArguments(bundle);
        return byVar;
    }

    public static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i, Order order, int i2) {
        Bundle toBundle = new g().a("arg.order", (Parcelable) order).O("arg.order.view.type", i2).toBundle();
        a(fragmentActivity, fragmentManager, i, aa(toBundle), toBundle.hashCode());
    }

    private static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i, Fragment fragment, int i2) {
        PopupViewModel j = PopupViewModel.j(fragmentActivity);
        Runnable caVar = new ca(fragmentManager, i, fragment, i2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PendingOrderExecutedFragment");
        stringBuilder.append(i2);
        j.a(caVar, stringBuilder.toString());
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, Fragment fragment, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PendingOrderExecutedFragment");
        stringBuilder.append(i2);
        if (fragmentManager.findFragmentByTag(stringBuilder.toString()) == null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            stringBuilder = new StringBuilder();
            stringBuilder.append("PendingOrderExecutedFragment");
            stringBuilder.append(i2);
            beginTransaction = beginTransaction.add(i, fragment, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("PendingOrderExecutedFragment");
            stringBuilder2.append(i2);
            beginTransaction.addToBackStack(stringBuilder2.toString()).commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cqz = (qb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pending_order_executed, viewGroup, false);
        CharSequence charSequence = null;
        try {
            Bundle arguments = getArguments();
            this.ID = arguments.hashCode();
            this.cqB = new PendingOrderWrapper((Order) arguments.getParcelable("arg.order"));
            this.cqA = arguments.getInt("arg.order.view.type", 1);
            switch (this.cqA) {
                case 1:
                    this.cqz.bza.setText(R.string.order_was_executed);
                    this.cqz.byZ.setVisibility(0);
                    this.cqz.brN.setVisibility(0);
                    break;
                case 2:
                    this.cqz.bza.setMaxLines(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    this.cqz.bza.setText(R.string.mkt_on_open_order_has_been_executed);
                    this.cqz.byZ.setVisibility(0);
                    this.cqz.brN.setVisibility(0);
                    break;
                case 3:
                    this.cqz.bza.setText(R.string.order_was_created);
                    this.cqz.byZ.setVisibility(8);
                    this.cqz.brN.setVisibility(8);
                    this.cqz.blV.setOnClickListener(new com.iqoption.view.d.b() {
                        public void q(View view) {
                            by.this.onClose();
                        }
                    });
                    break;
            }
            this.cqz.bxe.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    by.this.onClose();
                }
            });
            this.cqz.brN.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    com.iqoption.gl.b.aow().glchSetSelectedPosition(a.Il().d(by.this.cqB.activeId, by.this.cqB.instrumentType).IM(), Position.createPositionSplitId(by.this.cqB.instrumentType, Integer.valueOf(by.this.cqB.activeId), Long.valueOf(-1), Long.valueOf(by.this.cqB.positionId)));
                    by.this.cqC.Bu();
                    by.this.onClose();
                }
            });
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.cqB.activeId), this.cqB.instrumentType);
            bg.f(this.cqz.bAu, this.cqB.isBuy ? R.drawable.ic_triangle_top_green_8 : R.drawable.ic_triangle_down_red_8);
            TextView textView = this.cqz.bAu;
            if (a != null) {
                charSequence = com.iqoption.util.e.a.s(a);
            }
            textView.setText(charSequence);
            this.cqz.bxj.setText(com.iqoption.util.e.a.O(this.cqB.instrumentType));
            this.cqz.bAv.setText(q.dY(a == null ? 6 : a.getPrecision()).format(this.cqB.price));
            return this.cqz.getRoot();
        } catch (Exception unused) {
            onClose();
            return null;
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        j jVar = this.cqC;
        boolean z = true;
        if (!(this.cqA == 1 || this.cqA == 2)) {
            z = false;
        }
        jVar.ax(z);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.cqC.onStop();
    }

    public boolean onClose() {
        this.handler.removeCallbacks(this.cpw);
        requireFragmentManager().popBackStack();
        PopupViewModel j = PopupViewModel.j(requireActivity());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PendingOrderExecutedFragment");
        stringBuilder.append(this.ID);
        j.hO(stringBuilder.toString());
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.cqA == 3) {
            this.handler.postDelayed(this.cpw, 4000);
        }
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.cpw);
    }

    public void ND() {
        this.cqz.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cqz.bxi.setTranslationX((float) dimensionPixelSize2);
            this.cqz.bxi.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cqz.blV, this.cqz.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cqz.blV.getWidth(), (double) this.cqz.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cqz.bxi;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cqz.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cqz.blV.setTranslationX(f);
        this.cqz.blV.setTranslationY(f);
        this.cqz.blV.setPivotX((float) (this.cqz.blV.getWidth() - dimensionPixelOffset));
        this.cqz.blV.setPivotY(1.0f);
        this.cqz.blV.setScaleX(0.3f);
        this.cqz.blV.setScaleY(0.3f);
        this.cqz.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cqz.blV.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
