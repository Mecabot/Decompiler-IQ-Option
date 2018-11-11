package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.analytics.i;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.pz;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.q;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.a.a.d;
import com.iqoption.view.d.c;
import com.iqoption.x.R;
import java.io.Serializable;

/* compiled from: PendingEditFragment */
public final class bx extends com.iqoption.fragment.base.b implements com.iqoption.view.a.b.a {
    private boolean cqr = true;
    private com.iqoption.core.microservices.tradingengine.response.active.a cqs;
    private double cqt = 0.0d;
    private boolean cqu;
    private final i cqv = new i();
    private pz cqw;

    /* compiled from: PendingEditFragment */
    public static class a {
        public final boolean cqy;
        public final Double value;

        public a(boolean z, Double d) {
            this.cqy = z;
            this.value = d;
        }
    }

    /* compiled from: PendingEditFragment */
    public static class b {
        public final boolean aos;
        public final Double value;

        public b(boolean z, Double d) {
            this.aos = z;
            this.value = d;
        }
    }

    private static bx a(@NonNull InstrumentType instrumentType, int i, Double d, boolean z, boolean z2) {
        bx bxVar = new bx();
        g v = new g().a("arg.activeType", (Serializable) instrumentType).O("arg.activeId", i).v("arg.mkt.on.open", z2).v("arg.disabled.reset.value", z);
        if (d != null) {
            v.e("arg.value", d.doubleValue());
        }
        bxVar.setArguments(v.toBundle());
        return bxVar;
    }

    public static void a(FragmentManager fragmentManager, @NonNull InstrumentType instrumentType, int i, Double d, boolean z) {
        fragmentManager.beginTransaction().add(R.id.fragment, a(instrumentType, i, d, z, true), "PendingEditFragment").addToBackStack("PendingEditFragment").commit();
    }

    public static void b(FragmentManager fragmentManager, @NonNull InstrumentType instrumentType, int i, Double d, boolean z) {
        fragmentManager.beginTransaction().add(R.id.fragment, a(instrumentType, i, d, z, false), "PendingEditFragment").addToBackStack("PendingEditFragment").commit();
    }

    public void onStart() {
        super.onStart();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this, Integer.valueOf(5));
    }

    public void onStop() {
        super.onStop();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cqw = (pz) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pending_chooser, viewGroup, false);
        this.cqw.a(this);
        this.cqw.bAj.setLayoutTransition(bg.aGE());
        this.cqw.bAl.setLayoutTransition(bg.aGE());
        Bundle arguments = getArguments();
        int i = arguments.getInt("arg.activeId");
        InstrumentType instrumentType = (InstrumentType) arguments.getSerializable("arg.activeType");
        this.cqu = arguments.getBoolean("arg.disabled.reset.value", true);
        this.cqs = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(i), instrumentType);
        int i2 = 6;
        this.cqt = Math.pow(10.0d, (double) (-(this.cqs == null ? 6 : this.cqs.getPrecision())));
        RobotoEditText robotoEditText = this.cqw.bAr;
        InputFilter[] inputFilterArr = new InputFilter[1];
        if (this.cqs != null) {
            i2 = this.cqs.getPrecision();
        }
        inputFilterArr[0] = new com.iqoption.view.text.i(i2);
        robotoEditText.setFilters(inputFilterArr);
        this.cqw.bAr.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        if (arguments.containsKey("arg.value")) {
            cR(false);
            setValue(arguments.getDouble("arg.value"));
        } else {
            cR(true);
            ahH();
        }
        if (arguments.getBoolean("arg.mkt.on.open", false)) {
            this.cqw.bAm.setText(R.string.market_on_open_order);
            this.cqw.bAn.setText(R.string.latest_price);
        }
        new com.iqoption.view.text.r.a().ck(this.cqw.bAq).a(new c()).a(new com.iqoption.view.text.r.b() {
            public void aQ(View view) {
                if (bx.this.cqr) {
                    bx.this.cR(false);
                }
                Double c = bx.this.ahG();
                if (c != null) {
                    bx.this.setValue(c.doubleValue() + bx.this.cqt);
                    bx.this.cqv.i(0.0d);
                    IQApp.Dn().aE(new a(true, Double.valueOf(c.doubleValue() + bx.this.cqt)));
                }
            }
        }).aJN();
        new com.iqoption.view.text.r.a().ck(this.cqw.bAo).a(new c()).a(new com.iqoption.view.text.r.b() {
            public void aQ(View view) {
                if (bx.this.cqr) {
                    bx.this.cR(false);
                }
                Double c = bx.this.ahG();
                if (c != null) {
                    bx.this.setValue(c.doubleValue() - bx.this.cqt);
                    bx.this.cqv.i(0.0d);
                    IQApp.Dn().aE(new a(true, Double.valueOf(c.doubleValue() + bx.this.cqt)));
                }
            }
        }).aJN();
        this.cqw.bAk.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                bx.this.cR(true);
                bx.this.cqv.i(2.0d);
                IQApp.Dn().aE(new a(true, null));
            }
        });
        this.cqw.bAp.setKeyListener(new com.iqoption.widget.SmallNumPad.b() {
            public void en(int i) {
                if (bx.this.cqr) {
                    bx.this.cR(false);
                }
                KeyEvent keyEvent = new KeyEvent(0, i);
                KeyEvent keyEvent2 = new KeyEvent(1, i);
                bx.this.cqw.bAr.dispatchKeyEvent(keyEvent);
                bx.this.cqw.bAr.dispatchKeyEvent(keyEvent2);
                bx.this.cqv.i(i == 67 ? 3.0d : 1.0d);
                Double c = bx.this.ahG();
                if (c != null) {
                    IQApp.Dn().aE(new a(false, c));
                }
            }
        });
        return this.cqw.getRoot();
    }

    private void cR(boolean z) {
        if (z && !this.cqr) {
            this.cqr = true;
            this.cqw.bAk.setVisibility(8);
            this.cqw.bAn.setVisibility(0);
            ahH();
            cS(true);
        } else if (!z && this.cqr) {
            this.cqr = false;
            this.cqw.bAk.setVisibility(0);
            this.cqw.bAn.setVisibility(8);
            cS(false);
        }
        if (!this.cqu) {
            this.cqw.bAk.setVisibility(8);
        }
    }

    private void cS(boolean z) {
        if (getArguments().getBoolean("arg.mkt.on.open", false)) {
            this.cqw.bAm.setText(z ? R.string.market_on_open_order : R.string.purchase_price);
        }
    }

    public void onTick(long j) {
        if (this.cqs != null && this.cqr) {
            ahH();
        }
    }

    @Nullable
    private Double ahG() {
        return com.google.common.primitives.b.cL(this.cqw.bAr.getText().toString().replaceAll("[^\\d\\.]", ""));
    }

    private void ahH() {
        if (this.cqs == null) {
            this.cqw.bAr.setText(R.string.n_a);
            return;
        }
        ActiveQuote da = com.iqoption.app.managers.c.Gn().da(this.cqs.getActiveId());
        if (da != null) {
            setValue(da.getVal());
        } else {
            this.cqw.bAr.setText(R.string.n_a);
        }
    }

    private void setValue(double d) {
        if (this.cqs != null) {
            Object format = q.dY(this.cqs.getPrecision()).format(d);
            this.cqw.bAr.setText(format);
            this.cqw.bAr.setSelection(format.length());
            this.cqw.bAr.requestFocus();
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aE(new b(true, this.cqr ? null : ahG()));
        this.cqv.onStart();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.cqv.onStop();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        IQApp.Dn().aE(new b(false, this.cqr ? null : ahG()));
        return true;
    }

    public void ND() {
        this.cqw.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            float f = (float) dimensionPixelSize;
            this.cqw.blV.setTranslationX(f);
            float f2 = (float) (-dimensionPixelSize);
            this.cqw.blV.setTranslationY(f2);
            this.cqw.avm.setTranslationX(f);
            this.cqw.avm.setTranslationY(f2);
            this.cqw.avm.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cqw.blV, this.cqw.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, f, (float) Math.hypot((double) this.cqw.blV.getWidth(), (double) this.cqw.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cqw.blV;
            r6 = new PropertyValuesHolder[2];
            r6[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r6);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cqw.avm;
            r11 = new PropertyValuesHolder[3];
            r11[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r11[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            r11[2] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r11);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            this.cqw.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f3 = (float) (-dimensionPixelOffset);
        this.cqw.blV.setTranslationX(f3);
        this.cqw.blV.setTranslationY(f3);
        this.cqw.blV.setPivotX((float) (this.cqw.blV.getWidth() - dimensionPixelOffset));
        this.cqw.blV.setPivotY(1.0f);
        this.cqw.blV.setScaleX(0.3f);
        this.cqw.blV.setScaleY(0.3f);
        this.cqw.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cqw.blV.setPivotX((float) this.cqw.blV.getWidth());
        this.cqw.blV.setPivotY(1.0f);
        this.cqw.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
