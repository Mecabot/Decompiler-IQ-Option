package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
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
import com.google.common.b.e;
import com.iqoption.app.managers.af;
import com.iqoption.d.or;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.mobbtech.connect.response.options.OptionEvents;
import com.iqoption.system.a.d;
import com.iqoption.util.ax;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.util.Objects;

/* compiled from: MarketOnOpenCreatedFragment */
public class bh extends b {
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private final com.iqoption.view.a.b.a clw = new bi(this);
    private or cpG;
    private Order cpH;
    private final a cpI = new a(this);

    /* compiled from: MarketOnOpenCreatedFragment */
    public static class a extends d {
        private final bh cpL;

        a(bh bhVar) {
            this.cpL = bhVar;
        }

        @e
        public void onDeferredOrderExecutedEvent(final OptionEvents.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    if (a.this.cpL != null && a.this.cpL.isAdded() && Order.ON_MKT_OPEN.equals(((Order) eVar.getValue()).getType()) && Objects.equals(a.this.cpL.cpH.getId(), ((Order) eVar.getValue()).getId())) {
                        a.this.cpL.onClose();
                    }
                }
            });
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpG = (or) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_mkt_on_open_created, viewGroup, false);
        this.cpH = (Order) getArguments().getParcelable("arg.order");
        this.aiJ = com.iqoption.app.helpers.a.FI().a(this.cpH.getInstrumentActiveId(), this.cpH.getInstrumentType());
        this.cpG.bxe.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
            }
        });
        this.cpG.brN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                com.iqoption.gl.b.aow().glchSetSelectedPosition(com.iqoption.app.managers.tab.a.Il().d(bh.this.cpH.getInstrumentActiveId().intValue(), bh.this.cpH.getInstrumentType()).IM(), Position.createPositionSplitId(bh.this.cpH.getInstrumentType(), bh.this.cpH.getInstrumentActiveId(), Long.valueOf(-1), bh.this.cpH.getPositionId()));
                bh.this.onClose();
            }
        });
        ahy();
        return this.cpG.getRoot();
    }

    public void ND() {
        this.cpG.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cpG.bxi.setTranslationX((float) dimensionPixelSize2);
            this.cpG.bxi.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpG.blV, this.cpG.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpG.blV.getWidth(), (double) this.cpG.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cpG.bxi;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cpG.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cpG.blV.setTranslationX(f);
        this.cpG.blV.setTranslationY(f);
        this.cpG.blV.setPivotX((float) (this.cpG.blV.getWidth() - dimensionPixelOffset));
        this.cpG.blV.setPivotY(1.0f);
        this.cpG.blV.setScaleX(0.3f);
        this.cpG.blV.setScaleY(0.3f);
        this.cpG.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void onStart() {
        super.onStart();
        this.cpI.register();
    }

    public void onStop() {
        this.cpI.unregister();
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        com.iqoption.view.a.b.aIK().a(this.clw);
    }

    public void onPause() {
        com.iqoption.view.a.b.aIK().b(this.clw);
        super.onPause();
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel j = PopupViewModel.j(requireActivity());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MarketOnOpenCreatedFragment");
        stringBuilder.append(getArguments().hashCode());
        j.hO(stringBuilder.toString());
        return true;
    }

    public void NE() {
        this.cpG.blV.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    private void ahy() {
        long Hw = af.Hu().Hw();
        long bb = this.aiJ.bb(Hw);
        if (bb == Long.MAX_VALUE) {
            this.cpG.bzd.setVisibility(0);
            this.cpG.bzc.setVisibility(0);
            this.cpG.bzd.setText(R.string.not_available);
        } else if (this.aiJ.ba(Hw)) {
            this.cpG.bzd.setVisibility(8);
            this.cpG.bzc.setVisibility(8);
        } else {
            this.cpG.bzd.setVisibility(0);
            this.cpG.bzc.setVisibility(0);
            this.cpG.bzd.setText(bf.u(Hw, bb));
        }
    }

    private static bh Z(Bundle bundle) {
        bh bhVar = new bh();
        bhVar.setArguments(bundle);
        return bhVar;
    }

    public static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i, Order order) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg.order", order);
        int hashCode = bundle.hashCode();
        Fragment Z = Z(bundle);
        PopupViewModel j = PopupViewModel.j(fragmentActivity);
        Runnable bjVar = new bj(fragmentManager, i, Z, hashCode);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MarketOnOpenCreatedFragment");
        stringBuilder.append(hashCode);
        j.a(bjVar, stringBuilder.toString());
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, Fragment fragment, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MarketOnOpenCreatedFragment");
        stringBuilder.append(i2);
        if (fragmentManager.findFragmentByTag(stringBuilder.toString()) == null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            stringBuilder = new StringBuilder();
            stringBuilder.append("MarketOnOpenCreatedFragment");
            stringBuilder.append(i2);
            beginTransaction = beginTransaction.add(i, fragment, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("MarketOnOpenCreatedFragment");
            stringBuilder2.append(i2);
            beginTransaction.addToBackStack(stringBuilder2.toString()).commitAllowingStateLoss();
        }
    }
}
