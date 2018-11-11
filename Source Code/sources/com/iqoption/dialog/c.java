package com.iqoption.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.activity.VideoActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.a;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.f;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.e;
import com.iqoption.util.am;
import com.iqoption.util.ax;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: EducationDialog */
public class c extends e {
    private Builder adT;
    private View bBs;
    private View ceO;
    private View ceP;
    private View ceQ;
    private View ceR;
    private View ceS;
    private View ceT;
    private boolean ceU;
    boolean ceV = false;

    public static boolean bk(Context context) {
        Object obj = (a.aL(context).CZ() || !b.HT().fg("video-tutorial-real")) ? null : 1;
        if (!af.aR(context).EI() || obj == null) {
            return false;
        }
        return true;
    }

    public static void d(Context context, boolean z) {
        af.aR(context).aY(z);
    }

    public static void a(Context context, FragmentManager fragmentManager) {
        aer().show(fragmentManager, "EducationDialog");
    }

    private static c aer() {
        c cVar = new c();
        cVar.setStyle(2, 16974065);
        Bundle bundle = new Bundle();
        bundle.putBoolean("welcome", true);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setFlags(8, 8);
        getDialog().setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                View c;
                c.this.getDialog().getWindow().clearFlags(8);
                am.bS(c.this.getDialog().getWindow().getDecorView());
                Tracker aP = IQApp.aP(c.this.getContext());
                aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) a.aL(c.this.getContext()).getUserId())).setCategory("Android").setAction("EducationPopup1Opened").setCustomDimension(2, aP.get("&cid"))).build());
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c.this.ceP, "alpha", new float[]{1.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                com.iqoption.util.b.a(animatorSet, 500);
                if (ax.dws) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(c.this.ceO, c.this.ceQ.getLeft(), c.this.ceQ.getTop() + (c.this.ceQ.getHeight() * 2), 0.0f, (float) Math.max(c.this.ceO.getWidth(), c.this.ceO.getHeight()));
                    animatorSet.playTogether(new Animator[]{ofFloat, createCircularReveal});
                } else {
                    c.this.ceO.setScaleX(0.0f);
                    c.this.ceO.setScaleY(0.0f);
                    ofFloat.setInterpolator(d.dEM);
                    c = c.this.ceO;
                    r10 = new PropertyValuesHolder[2];
                    r10[0] = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f});
                    r10[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f});
                    ObjectAnimator.ofPropertyValuesHolder(c, r10).setInterpolator(new OvershootInterpolator());
                    animatorSet.playTogether(new Animator[]{ofFloat, r3});
                }
                animatorSet.start();
                int dimensionPixelOffset = c.this.getResources().getDimensionPixelOffset(R.dimen.dp8);
                View d = c.this.ceR;
                r3 = new PropertyValuesHolder[2];
                r3[0] = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f});
                r3[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f});
                ObjectAnimator.ofPropertyValuesHolder(d, r3).setInterpolator(new OvershootInterpolator());
                c = c.this.bBs;
                r11 = new PropertyValuesHolder[3];
                r11[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
                r13 = new float[2];
                r13[0] = c.this.bBs.getTranslationY() - ((float) dimensionPixelOffset);
                r13[1] = c.this.bBs.getTranslationY();
                r11[1] = PropertyValuesHolder.ofFloat("translationY", r13);
                String str = "translationX";
                r13 = new float[2];
                r13[0] = c.this.bBs.getTranslationX() + ((float) (ax.dws ? dimensionPixelOffset : 0));
                r13[1] = c.this.bBs.getTranslationX();
                r11[2] = PropertyValuesHolder.ofFloat(str, r13);
                ObjectAnimator.ofPropertyValuesHolder(c, r11).setInterpolator(d.dEM);
                View f = c.this.ceS;
                r9 = new PropertyValuesHolder[3];
                r9[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
                r9[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{c.this.ceS.getTranslationY() - r15, c.this.ceS.getTranslationY()});
                String str2 = "translationX";
                float[] fArr = new float[2];
                float translationX = c.this.ceS.getTranslationX();
                if (!ax.dws) {
                    dimensionPixelOffset = 0;
                }
                fArr[0] = translationX + ((float) dimensionPixelOffset);
                fArr[1] = c.this.ceS.getTranslationX();
                r9[2] = PropertyValuesHolder.ofFloat(str2, fArr);
                ObjectAnimator.ofPropertyValuesHolder(f, r9).setInterpolator(d.dEM);
                f = c.this.ceT;
                r9 = new PropertyValuesHolder[2];
                r9[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
                r9[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{c.this.ceT.getTranslationY() + r15, c.this.ceT.getTranslationY()});
                ObjectAnimator.ofPropertyValuesHolder(f, r9).setInterpolator(d.dEM);
                AnimatorSet animatorSet2 = new AnimatorSet();
                com.iqoption.util.b.a(animatorSet2, 500);
                animatorSet2.setStartDelay((long) (ax.dws ? 200 : 500));
                animatorSet2.playTogether(new Animator[]{r2, r3, ofFloat, r6});
                animatorSet2.start();
            }
        });
        getDialog().setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                c.this.S(c.this.getView());
                return true;
            }
        });
        return layoutInflater.inflate(R.layout.education_dialog, viewGroup, true);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        EventManager.Bm().a(this.adT.calcDuration().build());
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z = false;
        if (getArguments() != null && getArguments().getBoolean("welcome", false)) {
            z = true;
        }
        this.ceV = z;
        this.bBs = view.findViewById(R.id.title);
        this.ceS = view.findViewById(R.id.text);
        this.ceT = view.findViewById(R.id.player);
        this.ceO = view.findViewById(R.id.contentContainer);
        this.ceP = view.findViewById(R.id.everything);
        this.ceP.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.S(view);
            }
        });
        this.ceQ = view.findViewById(R.id.closeBtn);
        this.ceQ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.S(view);
            }
        });
        this.ceR = view.findViewById(R.id.playButton);
        this.ceR.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.ceU = true;
                Tracker aP = IQApp.aP(c.this.getContext());
                aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) a.aL(c.this.getContext()).getUserId())).setCategory("Android").setAction("EducationPopup1Palyed").setCustomDimension(2, aP.get("&cid"))).build());
                ae.d(c.this.getContext(), 8);
                boolean equals = f.getLocale().equals("ru_RU");
                String str = equals ? "https://new.static.iqoption.com/video/how_to_trade_on_mobile_app_ru.mp4" : "https://new.static.iqoption.com/video/how_to_trade_on_mobile_app_en.mp4";
                String str2 = equals ? "NHxBZFdJnNA" : "OyafnjcVC-I";
                Bundle bundle = new Bundle();
                bundle.putString("path", str);
                bundle.putString("id", str2);
                bundle.putBoolean("IS_EDUCATION_VIDEO", true);
                Intent intent = new Intent(c.this.zzakw(), VideoActivity.class);
                intent.putExtra("params", bundle);
                c.this.zzakw().startActivityForResult(intent, 100);
                c.this.S(view);
            }
        });
        this.ceO.setDrawingCacheEnabled(true);
        this.ceP.setAlpha(0.0f);
        this.bBs.setAlpha(0.0f);
        this.ceS.setAlpha(0.0f);
        this.ceT.setAlpha(0.0f);
        this.ceR.setScaleX(0.0f);
        this.ceR.setScaleY(0.0f);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "video-tutorial");
    }

    private void S(View view) {
        a((Fragment) this, getTradeRoomActivity()).start();
        view.postDelayed(new Runnable() {
            public void run() {
                if (c.this.isAdded()) {
                    c.this.dismissAllowingStateLoss();
                }
            }
        }, 315);
    }

    @NonNull
    private static Animator a(Fragment fragment, @Nullable TradeRoomActivity tradeRoomActivity) {
        if (!fragment.isAdded() || fragment.zzakw() == null) {
            return null;
        }
        View view = fragment.getView();
        if (tradeRoomActivity != null && tradeRoomActivity.getTradeFragment() != null && tradeRoomActivity.getTradeFragment().isAdded()) {
            return ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        }
        r7 = new PropertyValuesHolder[3];
        r7[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{0.1f});
        r7[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.1f});
        r7[2] = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.1f});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, r7);
        ofPropertyValuesHolder.setDuration(300);
        return ofPropertyValuesHolder;
    }
}
