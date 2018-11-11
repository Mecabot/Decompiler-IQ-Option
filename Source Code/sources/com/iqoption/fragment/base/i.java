package com.iqoption.fragment.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.activity.b;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.ax;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.am;
import com.iqoption.view.a.a.a.a;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: IQSmartFragment */
public abstract class i extends b {
    private static final String TAG = "com.iqoption.fragment.base.i";
    protected Builder adT;
    private View cvP;
    private ax cvT;
    private View cvU;

    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    protected void aeG() {
    }

    @Nullable
    public JsonObject ajZ() {
        return null;
    }

    protected void aka() {
    }

    protected void akb() {
    }

    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public abstract String gF();

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cvT = (ax) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.base_smart_fragment, viewGroup, false);
        this.cvT.a(this);
        this.cvT.blc.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                b ajV = i.this.ajV();
                if (ajV != null && ajV.zN()) {
                    am.a(i.this.zzakw(), view);
                }
                return true;
            }
        });
        this.cvT.ble.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b ajV = i.this.ajV();
                if (ajV != null && ajV.zN()) {
                    am.a(i.this.zzakw(), view);
                }
            }
        });
        this.cvT.blg.aIQ();
        this.cvP = a(layoutInflater, this.cvT.blc, bundle);
        this.cvU = b(layoutInflater, this.cvT.ble, bundle);
        this.cvT.blc.addView(this.cvP);
        if (this.cvU != null) {
            this.cvT.ble.addView(this.cvU);
        }
        return this.cvT.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String gF = gF();
        if (gF != null) {
            this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, gF);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.adT != null) {
            JsonElement ajZ = ajZ();
            if (ajZ != null) {
                this.adT.setParameters(ajZ);
            }
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    private boolean ajY() {
        return ahd() == 0;
    }

    protected int ahd() {
        return getResources().getDimensionPixelSize(R.dimen.iq_smart_fragment_width);
    }

    public void NE() {
        float f = ajY() ? 1.0f : 1.7f;
        this.cvT.ble.animate().alpha(0.0f).scaleY(f).scaleX(f).setDuration(300).setInterpolator(d.dEM).setListener(a.c(new com.iqoption.view.a.a.a.b() {
            public void execute() {
                i.this.akb();
            }
        })).start();
    }

    public void ND() {
        this.cvT.ble.setAlpha(0.0f);
        this.cvT.blg.setAlpha(0.0f);
        this.cvP.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cvT.blg, "alpha", new float[]{1.0f});
        ofFloat.setInterpolator(d.dEM);
        ofFloat.setDuration(400);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.cvP, "alpha", new float[]{1.0f});
        ofFloat2.setInterpolator(d.dEM);
        ofFloat2.setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        if (ajY()) {
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.setInterpolator(d.dEM);
        } else {
            int width = this.cvT.ble.getWidth();
            int ahd = ahd();
            final LayoutParams layoutParams = this.cvT.blc.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{width, ahd});
            ofInt.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (i.this.isAdded()) {
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        i.this.cvT.blc.setLayoutParams(layoutParams);
                    }
                }
            });
            ofInt.setDuration(400);
            ofInt.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    i.this.aka();
                }
            });
            ofInt.setInterpolator(d.dEM);
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(0), Integer.valueOf(-1476395008)});
            ofObject.addUpdateListener(new com.iqoption.view.a.a.a(this.cvT.ble));
            ofObject.setInterpolator(d.dEM);
            ofObject.setDuration(400);
            animatorSet.playTogether(new Animator[]{ofObject, ofInt, ofFloat});
            animatorSet.play(ofFloat2).after(350);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                i.this.aeG();
            }
        });
        animatorSet.start();
        this.cvT.ble.setAlpha(1.0f);
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        return true;
    }
}
