package com.iqoption.dialog.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.SwitchCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.p;
import com.iqoption.d.jr;
import com.iqoption.d.wn;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.i;
import com.iqoption.fragment.fa;
import com.iqoption.util.au;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.h;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: TpslDialog */
public final class b extends i {
    @ColorInt
    private int ahg;
    @ColorInt
    private int ahh;
    @ColorInt
    private int ahi;
    private a ckd;
    private volatile boolean cke = false;
    private boolean ckf = true;
    private boolean ckg = false;
    private boolean ckh = false;
    private boolean cki = false;
    private com.iqoption.view.drawable.a ckj;
    private com.iqoption.view.drawable.a ckk;
    private com.iqoption.view.drawable.a ckl;
    private jr ckm;
    private wn ckn;
    private ViewGroup cko;
    private double ckp;
    private double ckq;
    private AnimatorSet ckr = null;
    private Double cks = null;
    private Double ckt;
    private final com.iqoption.util.h.b cku = new com.iqoption.util.h.b() {
        public void f(double d) {
            b.this.ckm.buu.setText(p.b(d, "+"));
            b.this.ckm.buu.setTextColor(b.this.ahg);
        }

        public void g(double d) {
            b.this.ckm.buu.setText(p.b(d, "-"));
            b.this.ckm.buu.setTextColor(b.this.ahh);
        }

        public void h(double d) {
            b.this.ckm.buu.setText(p.o(0.0d));
            b.this.ckm.buu.setTextColor(b.this.ahi);
        }
    };
    private c ckv = new c(this, null);
    private int precision = 6;

    /* compiled from: TpslDialog */
    public static class a {
        public final Boolean cjX;
        public final Double ckA;
        public final Double ckB;
        public final Boolean cka;

        public a(Double d, Double d2, Boolean bool, Boolean bool2) {
            this.ckA = d;
            this.ckB = d2;
            this.cjX = bool;
            this.cka = bool2;
        }
    }

    /* compiled from: TpslDialog */
    private static class c implements com.iqoption.view.a.b.a {
        private final WeakReference<b> ckC;

        /* synthetic */ c(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        private c(b bVar) {
            this.ckC = new WeakReference(bVar);
        }

        public void onTick(long j) {
            b bVar = (b) this.ckC.get();
            if (bVar != null && bVar.isAdded()) {
                bVar.afo();
            }
        }
    }

    /* compiled from: TpslDialog */
    public static class b extends com.iqoption.system.a.c<Boolean> {
    }

    public String gF() {
        return "tpsl-limits_open-settings";
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i, Position position) {
        a(fragmentManager, i, new g().a("arg.position", (Parcelable) position).toBundle());
    }

    public static void a(FragmentManager fragmentManager, int i, InstrumentType instrumentType, boolean z, Double d, Double d2, Double d3, Boolean bool, int i2, double d4, Boolean bool2) {
        g e = new g().O("arg.active.id", i).a("arg.option.type", (Serializable) instrumentType).v("arg.is.long", z).O("arg.leverage", i2).e("arg.invest", d4);
        if (d != null) {
            e.e("arg.pending.value", d.doubleValue());
        }
        if (d2 != null) {
            e.e("arg.take.profit.percente", d2.doubleValue());
        }
        if (d3 != null) {
            e.e("arg.stop.lose.percente", d3.doubleValue());
        }
        if (bool != null) {
            e.v("arg.margin.call", bool.booleanValue());
        }
        if (bool2 != null) {
            e.v("arg.trailing.stop", bool2.booleanValue());
        }
        a(fragmentManager, (int) R.id.other_fragment, e.toBundle());
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle) {
        if (fragmentManager.findFragmentByTag("TpslDialog") == null) {
            fragmentManager.beginTransaction().add(i, X(bundle), "TpslDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("TpslDialog").commit();
        }
    }

    private static b X(Bundle bundle) {
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    private double q(double d) {
        return au.i(this.ckd.GN(), this.ckd.p(d));
    }

    private double r(double d) {
        return this.ckd.getTpslValue(au.j(this.ckd.GN(), d));
    }

    private void cI(boolean z) {
        if (z) {
            this.ckn.getRoot().setVisibility(0);
            this.ckn.bJN.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.appear_from_rigth_to_left_with_alpha_show));
            double p = this.ckm.btT.isSelected() ? this.ckf ? this.ckd.p(this.ckq) : q(this.ckq) : this.ckf ? this.ckd.p(this.ckp) : q(this.ckp);
            if (p > 0.0d) {
                if (this.ckn.bJO.getNextView().getId() == R.id.signPlus) {
                    this.ckn.bJO.showNext();
                }
            } else if (this.ckn.bJO.getNextView().getId() == R.id.signMinus) {
                this.ckn.bJO.showNext();
            }
            this.ckn.bxR.setSign((int) Math.signum(p));
            this.ckn.bIr.setHint(q.dX(this.ckf ? 1 : 2).format(Math.abs(p)));
            this.ckn.bIr.requestFocus();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.appear_from_rigth_to_left_with_alpha_hide);
        loadAnimation.setAnimationListener(com.iqoption.view.a.a.a.a.c(new com.iqoption.view.a.a.a.b() {
            public void execute() {
                if (b.this.isAdded()) {
                    b.this.ckn.bJN.clearAnimation();
                    b.this.ckn.getRoot().setVisibility(8);
                }
            }
        }));
        this.ckn.bJN.startAnimation(loadAnimation);
        this.ckn.bIr.setText("");
        this.ckm.btT.setSelected(false);
        this.ckm.buh.setSelected(false);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ckm = jr.y(layoutInflater, viewGroup, false);
        return this.ckm.getRoot();
    }

    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ckn = wn.N(layoutInflater, viewGroup, false);
        this.cko = viewGroup;
        View root = this.ckn.getRoot();
        root.setVisibility(8);
        return root;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(View view, Bundle bundle) {
        int leverage;
        Context context;
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments.containsKey("arg.position")) {
            this.ckd = new a((Position) arguments.getParcelable("arg.position"));
        } else {
            this.ckd = new a(arguments.getInt("arg.active.id"), (InstrumentType) arguments.getSerializable("arg.option.type"), arguments.getBoolean("arg.is.long"), arguments.getInt("arg.leverage"), arguments.getDouble("arg.invest"));
            InstrumentType instrumentType = this.ckd.getInstrumentType();
            leverage = this.ckd.getLeverage();
            if (arguments.containsKey("arg.pending.value")) {
                this.ckd.cH(true);
                this.ckd.e(Double.valueOf(arguments.getDouble("arg.pending.value")));
            } else {
                this.ckd.e(ActiveQuote.getCurrentOpenPriceEnrolled(this.ckd.afc(), this.ckd.isLong(), instrumentType, leverage));
                this.ckm.buc.setVisibility(8);
                this.ckm.buq.setVisibility(8);
            }
            if (arguments.containsKey("arg.margin.call")) {
                this.ckd.cG(arguments.getBoolean("arg.margin.call"));
            }
            if (arguments.containsKey("arg.take.profit.percente")) {
                this.ckd.g(Double.valueOf(this.ckd.getTpslValue(arguments.getDouble("arg.take.profit.percente"))));
            }
            if (arguments.containsKey("arg.stop.lose.percente")) {
                this.ckd.f(Double.valueOf(this.ckd.getTpslValue(arguments.getDouble("arg.stop.lose.percente"))));
            }
            if (arguments.containsKey("arg.trailing.stop")) {
                this.ckd.cE(arguments.getBoolean("arg.trailing.stop"));
            }
        }
        this.ckf = true;
        this.ahg = ContextCompat.getColor(getContext(), R.color.green);
        this.ahh = ContextCompat.getColor(getContext(), R.color.red);
        this.ahi = ContextCompat.getColor(getContext(), R.color.white);
        this.ckj = new com.iqoption.view.drawable.a(getContext(), R.color.green);
        this.ckk = new com.iqoption.view.drawable.a(getContext(), R.color.red);
        this.ckl = new com.iqoption.view.drawable.a(getContext(), R.color.white);
        com.iqoption.app.managers.feature.b HT = com.iqoption.app.managers.feature.b.HT();
        this.ckg = HT.ff("profit-loss-limits");
        this.ckh = HT.ff("margin-add-on");
        this.cki = HT.ff("trailing-stop");
        this.ckn.getRoot().setOnClickListener(new c(this));
        this.ckn.bIr.setOnTouchListener(d.ckx);
        RobotoEditText robotoEditText = this.ckn.bIr;
        InputFilter[] inputFilterArr = new InputFilter[1];
        boolean z = false;
        inputFilterArr[0] = new com.iqoption.charttools.c.a.a(0.1d, 9999999.9d);
        robotoEditText.setFilters(inputFilterArr);
        this.ckn.bJM.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Object replaceAll = b.this.ckn.bIr.getText().toString().replaceAll("[^\\d\\.]", "");
                boolean z = true;
                double d = 0.0d;
                if (!TextUtils.isEmpty(replaceAll)) {
                    try {
                        d = ((double) b.this.ckn.bxR.getSign()) * Double.parseDouble(replaceAll);
                        double tpslValue;
                        if (b.this.ckm.btT.isSelected()) {
                            tpslValue = b.this.ckf ? b.this.ckd.getTpslValue(d) : b.this.r(d);
                            b.this.s(tpslValue);
                            if (b.this.u(tpslValue)) {
                                b.this.ckq = tpslValue;
                                b.this.afn();
                            }
                        } else {
                            tpslValue = b.this.ckf ? b.this.ckd.getTpslValue(d) : b.this.r(d);
                            if (b.this.t(tpslValue)) {
                                b.this.ckp = tpslValue;
                                b.this.afm();
                            }
                        }
                        z = false;
                    } catch (NumberFormatException unused) {
                        if (z) {
                            com.iqoption.app.a.b.eO(b.this.getString(R.string.incorrect_value));
                            w.afx();
                        }
                        w.a(b.this.ckf ? "percentage" : "amount", z, d);
                        b.this.cI(false);
                    }
                }
            }
        });
        this.ckn.bxR.setKeyListener(new n(this));
        this.ckn.bxR.setChangeSignListener(new o(this));
        this.ckm.btS.setLayoutTransition(bg.aGE());
        this.ckm.bup.setOnClickListener(new p(this));
        this.ckm.bub.setOnClickListener(new q(this));
        this.ckm.bum.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (b.this.ckm.bup.getNextView().getId() == R.id.takeProfitAdd) {
                    b.this.ckm.bup.showNext();
                    w.afu();
                }
            }
        });
        this.ckm.btY.setOnClickListener(new r(this));
        String str = "";
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.ckd.afc()), this.ckd.getInstrumentType());
        if (a != null) {
            str = com.iqoption.util.e.a.s(a);
            this.precision = a.getPrecision();
        }
        RobotoTextView robotoTextView = this.ckm.btN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(l.r(Double.valueOf(this.ckd.GN())));
        robotoTextView.setText(stringBuilder.toString());
        TextView textView = this.ckm.btN;
        if (this.ckd.isLong()) {
            context = getContext();
            leverage = R.drawable.ic_call_position;
        } else {
            context = getContext();
            leverage = R.drawable.ic_put_position;
        }
        bg.setDrawableLeft(textView, AppCompatResources.getDrawable(context, leverage));
        OnClickListener anonymousClass4 = new com.iqoption.view.d.b() {
            public void q(View view) {
                Animator animatorSet;
                Point K;
                Animator a;
                Animator a2;
                Animator animatorSet2;
                if (b.this.ckr != null) {
                    b.this.ckr.cancel();
                }
                View findViewWithTag = b.this.cko.findViewWithTag("animationFrame");
                if (findViewWithTag != null) {
                    b.this.cko.removeView(findViewWithTag);
                }
                findViewWithTag = new FrameLayout(b.this.getContext());
                findViewWithTag.setTag("animationFrame");
                findViewWithTag.setLayoutParams(new LayoutParams(-1, -1));
                if (b.this.ckm.bup.getNextView().getId() == R.id.takeProfitAdd) {
                    b.this.ckm.bui.setAlpha(0.0f);
                    b.this.ckm.bun.setAlpha(0.0f);
                    animatorSet = new AnimatorSet();
                    Animator[] animatorArr = new Animator[2];
                    animatorArr[0] = ObjectAnimator.ofFloat(b.this.ckm.bui, View.ALPHA, new float[]{1.0f});
                    animatorArr[1] = ObjectAnimator.ofFloat(b.this.ckm.bun, View.ALPHA, new float[]{1.0f});
                    animatorSet.playTogether(animatorArr);
                    com.iqoption.util.b.a(animatorSet, 200);
                    K = bg.K(b.this.ckm.bui);
                    Point K2 = bg.K(b.this.ckm.bun);
                    View textView = new TextView(b.this.getContext());
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(b.this.ckm.bui.getLayoutParams());
                    layoutParams.setMargins(K.x, K.y, 0, 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(b.this.ckm.bui.getGravity());
                    textView.setMaxLines(b.this.ckm.bui.getMaxLines());
                    textView.setTextColor(b.this.ckm.bui.getTextColors());
                    textView.setTextSize(0, b.this.ckm.bui.getTextSize());
                    textView.setText(b.this.ckm.bui.getText());
                    View textView2 = new TextView(b.this.getContext());
                    layoutParams = new FrameLayout.LayoutParams(b.this.ckm.bun.getLayoutParams());
                    layoutParams.setMargins(K2.x, K2.y, 0, 0);
                    textView2.setLayoutParams(layoutParams);
                    textView2.setGravity(b.this.ckm.bun.getGravity());
                    textView2.setMaxLines(b.this.ckm.bun.getMaxLines());
                    textView2.setTextColor(b.this.ckm.bun.getTextColors());
                    textView2.setTextSize(0, b.this.ckm.bun.getTextSize());
                    textView2.setText(b.this.ckm.bun.getText());
                    findViewWithTag.addView(textView);
                    findViewWithTag.addView(textView2);
                    a = b.this.a(b.this.a(textView, K, K2), b.this.a(textView2, K2, K));
                } else {
                    animatorSet = null;
                    a = null;
                }
                if (b.this.ckm.bub.getNextView().getId() == R.id.stopLossAdd) {
                    b.this.ckm.btU.setAlpha(0.0f);
                    b.this.ckm.btZ.setAlpha(0.0f);
                    K = bg.K(b.this.ckm.btU);
                    Point K3 = bg.K(b.this.ckm.btZ);
                    View textView3 = new TextView(b.this.getContext());
                    LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.ckm.btU.getLayoutParams());
                    layoutParams2.setMargins(K.x, K.y, 0, 0);
                    textView3.setLayoutParams(layoutParams2);
                    textView3.setGravity(b.this.ckm.btU.getGravity());
                    textView3.setMaxLines(b.this.ckm.btU.getMaxLines());
                    textView3.setTextColor(b.this.ckm.btU.getTextColors());
                    textView3.setTextSize(0, b.this.ckm.btU.getTextSize());
                    textView3.setText(b.this.ckm.btU.getText());
                    View textView4 = new TextView(b.this.getContext());
                    LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b.this.ckm.btZ.getLayoutParams());
                    layoutParams3.setMargins(K3.x, K3.y, 0, 0);
                    textView4.setLayoutParams(layoutParams3);
                    textView4.setGravity(b.this.ckm.btZ.getGravity());
                    textView4.setMaxLines(b.this.ckm.btZ.getMaxLines());
                    textView4.setTextColor(b.this.ckm.btZ.getTextColors());
                    textView4.setTextSize(0, b.this.ckm.btZ.getTextSize());
                    textView4.setText(b.this.ckm.btZ.getText());
                    findViewWithTag.addView(textView3);
                    findViewWithTag.addView(textView4);
                    a2 = b.this.a(b.this.a(textView3, K, K3), b.this.a(textView4, K3, K));
                    animatorSet2 = new AnimatorSet();
                    Animator[] animatorArr2 = new Animator[2];
                    animatorArr2[0] = ObjectAnimator.ofFloat(b.this.ckm.btU, View.ALPHA, new float[]{1.0f});
                    animatorArr2[1] = ObjectAnimator.ofFloat(b.this.ckm.btZ, View.ALPHA, new float[]{1.0f});
                    animatorSet2.playTogether(animatorArr2);
                    com.iqoption.util.b.a(animatorSet2, 200);
                } else {
                    a2 = null;
                    animatorSet2 = null;
                }
                b.this.cko.addView(findViewWithTag);
                b.this.ckr = new AnimatorSet();
                b.this.ckr.setInterpolator(d.dEM);
                if (!(a2 == null || animatorSet2 == null)) {
                    b.this.ckr.play(a2);
                    b.this.ckr.play(animatorSet2).after(100);
                }
                if (!(a == null || animatorSet == null)) {
                    b.this.ckr.play(a);
                    b.this.ckr.play(animatorSet).after(100);
                }
                b.this.ckr.addListener(com.iqoption.view.a.a.a.a.c(new v(this)));
                b.this.ckr.start();
                b.this.ckf = b.this.ckf ^ true;
                b.this.afm();
                b.this.afn();
                w.afv();
            }

            final /* synthetic */ void afs() {
                if (b.this.isAdded()) {
                    View findViewWithTag = b.this.cko.findViewWithTag("animationFrame");
                    if (findViewWithTag != null) {
                        b.this.cko.removeView(findViewWithTag);
                    }
                }
            }
        };
        this.ckm.bua.setOnClickListener(anonymousClass4);
        this.ckm.buo.setOnClickListener(anonymousClass4);
        this.ckm.blw.setOnClickListener(new s(this));
        this.ckm.boc.setOnClickListener(new t(this));
        this.ckm.btQ.setOnClickListener(new u(this));
        this.ckm.btV.setOnClickListener(new e(this));
        this.ckm.btX.setOnClickListener(new f(this));
        this.ckm.btW.setOnClickListener(new g(this));
        this.ckm.buj.setOnClickListener(new h(this));
        this.ckm.bul.setOnClickListener(new i(this));
        this.ckm.buk.setOnClickListener(new j(this));
        boolean cF = this.ckd.cF(this.ckh);
        if (!this.ckh) {
            if (!this.ckd.afg()) {
                this.ckm.btP.setVisibility(8);
            } else if (!cF) {
                this.ckm.btP.setVisibility(8);
            }
        }
        this.ckm.btP.setChecked(cF);
        this.ckm.btP.setOnCheckedChangeListener(new k(this));
        this.ckt = this.ckd.afe();
        this.ckm.btO.setOnClickListener(new l(this));
        Double takeProfitValue = this.ckd.getTakeProfitValue();
        this.ckp = takeProfitValue == null ? this.ckd.getTpslValue(100.0d) : takeProfitValue.doubleValue();
        double d = 0.0d;
        this.ckp = this.ckp < 0.0d ? 0.0d : this.ckp;
        if (takeProfitValue == null) {
            if (this.ckm.bup.getNextView().getId() == R.id.takeProfitAdd) {
                this.ckm.bup.showNext();
            }
        } else if (this.ckm.bup.getNextView().getId() == R.id.takeProfitEdit) {
            this.ckm.bup.showNext();
        }
        takeProfitValue = this.ckd.getStopLoseValue();
        this.ckq = takeProfitValue == null ? this.ckd.getTpslValue(this.ckd.getStopOutThreshold()) : takeProfitValue.doubleValue();
        if (this.ckq >= 0.0d) {
            d = this.ckq;
        }
        this.ckq = d;
        if (takeProfitValue == null) {
            if (this.ckm.bub.getNextView().getId() == R.id.stopLossAdd) {
                this.ckm.bub.showNext();
            }
        } else if (this.ckm.bub.getNextView().getId() == R.id.stopLossEdit) {
            this.ckm.bub.showNext();
        }
        afm();
        afn();
        if (takeProfitValue != null) {
            z = true;
        }
        cJ(z);
        this.cke = true;
        afo();
        JsonElement jsonObject = new JsonObject();
        Long balanceId = com.iqoption.app.a.Cw().getBalanceId();
        jsonObject.add("instrument_type ", new JsonPrimitive(this.ckd.getInstrumentType().getServerValue()));
        jsonObject.add("instrument_direction", new JsonPrimitive(this.ckd.isLong() ? NotificationCompat.CATEGORY_CALL : "put"));
        jsonObject.add("balance_type_id", new JsonPrimitive(Long.valueOf(balanceId == null ? -1 : balanceId.longValue())));
        this.adT.setParameters(jsonObject);
    }

    final /* synthetic */ void ar(View view) {
        cI(false);
    }

    final /* synthetic */ void em(int i) {
        KeyEvent keyEvent = new KeyEvent(0, i);
        KeyEvent keyEvent2 = new KeyEvent(1, i);
        this.ckn.bIr.dispatchKeyEvent(keyEvent);
        this.ckn.bIr.dispatchKeyEvent(keyEvent2);
        if (i == 67) {
            w.afw();
        } else {
            w.hp(Character.toString((char) keyEvent2.getUnicodeChar()));
        }
    }

    final /* synthetic */ void el(int i) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ckn.bJO, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.6f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.6f})});
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.setInterpolator(d.aQW);
        ofPropertyValuesHolder.setRepeatMode(2);
        ofPropertyValuesHolder.setRepeatCount(1);
        ofPropertyValuesHolder.start();
        if (i > 0) {
            if (this.ckn.bJO.getNextView().getId() == R.id.signPlus) {
                this.ckn.bJO.showNext();
            }
        } else if (this.ckn.bJO.getNextView().getId() == R.id.signMinus) {
            this.ckn.bJO.showNext();
        }
    }

    final /* synthetic */ void aq(View view) {
        if (this.ckm.bup.getNextView().getId() == R.id.takeProfitEdit) {
            this.ckm.bup.showNext();
            afo();
            w.aft();
        }
    }

    final /* synthetic */ void ap(View view) {
        if (this.ckm.bub.getNextView().getId() == R.id.stopLossEdit) {
            if (this.ckh && this.ckd.afg() && !this.ckm.btP.isChecked() && Math.abs(this.ckd.p(this.ckq)) > Math.abs(this.ckd.getStopOutThreshold())) {
                this.ckm.btP.setChecked(true);
            }
            cJ(true);
            this.ckm.bub.showNext();
            afo();
        }
    }

    final /* synthetic */ void ao(View view) {
        if (this.ckm.bub.getNextView().getId() == R.id.stopLossAdd) {
            this.ckm.bub.showNext();
            cJ(false);
        }
    }

    final /* synthetic */ void am(View view) {
        w.afy();
        aN();
    }

    final /* synthetic */ void al(View view) {
        Double d = null;
        Double valueOf = this.ckm.bup.getNextView().getId() == R.id.takeProfitAdd ? Double.valueOf(this.ckp) : null;
        if (this.ckm.bub.getNextView().getId() == R.id.stopLossAdd) {
            d = Double.valueOf(this.ckq);
        }
        this.ckd.b(valueOf, d);
        w.afz();
        aN();
    }

    final /* synthetic */ void ai(View view) {
        this.ckm.btT.setSelected(true);
        cI(true);
        w.a("loose", 3, this.ckf ? "percentage" : "amount", false, this.ckq);
    }

    final /* synthetic */ void af(View view) {
        this.ckm.buh.setSelected(true);
        cI(true);
        w.a("profit", 3, this.ckf ? "percentage" : "amount", false, this.ckp);
    }

    final /* synthetic */ void ae(View view) {
        Point K = bg.K(view);
        fa.a(getFragmentManager(), getId(), K.x, K.y);
    }

    private void cJ(boolean z) {
        int i = 8;
        if (this.ckd.cD(this.cki)) {
            this.ckm.bus.setOnCheckedChangeListener(null);
            FrameLayout frameLayout = this.ckm.but;
            boolean z2 = false;
            if (z) {
                i = 0;
            }
            frameLayout.setVisibility(i);
            SwitchCompat switchCompat = this.ckm.bus;
            if (z) {
                z2 = this.ckd.afb();
            }
            switchCompat.setChecked(z2);
            this.ckm.bus.setOnCheckedChangeListener(new m(this));
            return;
        }
        this.ckm.but.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    private void afh() {
        /*
        r9 = this;
        r0 = r9.ckd;
        r1 = r9.ckp;
        r0 = r0.p(r1);
        r2 = 1;
        r3 = com.iqoption.util.q.dX(r2);
        r4 = java.lang.Math.abs(r0);
        r3 = r3.format(r4);
        r4 = ".";
        r3 = r3.contains(r4);
        r4 = r9.ckf;
        if (r4 == 0) goto L_0x0031;
    L_0x001f:
        if (r3 == 0) goto L_0x0031;
    L_0x0021:
        r2 = r9.ckd;
        r0 = java.lang.Math.floor(r0);
        r0 = r2.getTpslValue(r0);
        r9.ckp = r0;
        r9.afm();
        goto L_0x0043;
    L_0x0031:
        r0 = r9.ckp;
        r3 = r9.afj();
        r0 = r0 + r3;
        r3 = r9.t(r0);
        if (r3 == 0) goto L_0x0046;
    L_0x003e:
        r9.ckp = r0;
        r9.afm();
    L_0x0043:
        r2 = 0;
        r6 = 0;
        goto L_0x0054;
    L_0x0046:
        r0 = 2131821311; // 0x7f1102ff float:1.9275362E38 double:1.053259673E-314;
        r0 = r9.getString(r0);
        com.iqoption.app.a.b.eO(r0);
        com.iqoption.dialog.c.w.afx();
        r6 = 1;
    L_0x0054:
        r3 = "profit";
        r4 = 0;
        r0 = r9.ckf;
        if (r0 == 0) goto L_0x005f;
    L_0x005b:
        r0 = "percentage";
    L_0x005d:
        r5 = r0;
        goto L_0x0062;
    L_0x005f:
        r0 = "amount";
        goto L_0x005d;
    L_0x0062:
        r7 = r9.ckp;
        com.iqoption.dialog.c.w.a(r3, r4, r5, r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.afh():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    private void afi() {
        /*
        r9 = this;
        r0 = r9.ckd;
        r1 = r9.ckp;
        r0 = r0.p(r1);
        r2 = 1;
        r3 = com.iqoption.util.q.dX(r2);
        r4 = java.lang.Math.abs(r0);
        r3 = r3.format(r4);
        r4 = ".";
        r3 = r3.contains(r4);
        r4 = r9.ckf;
        if (r4 == 0) goto L_0x0031;
    L_0x001f:
        if (r3 == 0) goto L_0x0031;
    L_0x0021:
        r2 = r9.ckd;
        r0 = java.lang.Math.ceil(r0);
        r0 = r2.getTpslValue(r0);
        r9.ckp = r0;
        r9.afm();
        goto L_0x0043;
    L_0x0031:
        r0 = r9.ckp;
        r3 = r9.afj();
        r0 = r0 - r3;
        r3 = r9.t(r0);
        if (r3 == 0) goto L_0x0046;
    L_0x003e:
        r9.ckp = r0;
        r9.afm();
    L_0x0043:
        r2 = 0;
        r6 = 0;
        goto L_0x0054;
    L_0x0046:
        r0 = 2131821311; // 0x7f1102ff float:1.9275362E38 double:1.053259673E-314;
        r0 = r9.getString(r0);
        com.iqoption.app.a.b.eO(r0);
        com.iqoption.dialog.c.w.afx();
        r6 = 1;
    L_0x0054:
        r3 = "profit";
        r4 = 1;
        r0 = r9.ckf;
        if (r0 == 0) goto L_0x005f;
    L_0x005b:
        r0 = "percentage";
    L_0x005d:
        r5 = r0;
        goto L_0x0062;
    L_0x005f:
        r0 = "amount";
        goto L_0x005d;
    L_0x0062:
        r7 = r9.ckp;
        com.iqoption.dialog.c.w.a(r3, r4, r5, r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.afi():void");
    }

    private double afj() {
        if (this.cks == null) {
            this.cks = Double.valueOf(this.ckd.afd() - this.ckd.getTpslValue(1.0d));
        }
        return this.cks.doubleValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    private void afk() {
        /*
        r9 = this;
        r0 = r9.ckd;
        r1 = r9.ckq;
        r0 = r0.p(r1);
        r2 = 1;
        r3 = com.iqoption.util.q.dX(r2);
        r4 = java.lang.Math.abs(r0);
        r3 = r3.format(r4);
        r4 = ".";
        r3 = r3.contains(r4);
        r4 = r9.ckf;
        if (r4 == 0) goto L_0x0031;
    L_0x001f:
        if (r3 == 0) goto L_0x0031;
    L_0x0021:
        r2 = r9.ckd;
        r0 = java.lang.Math.ceil(r0);
        r0 = r2.getTpslValue(r0);
        r9.ckq = r0;
        r9.afn();
        goto L_0x0043;
    L_0x0031:
        r0 = r9.ckq;
        r3 = r9.afj();
        r0 = r0 - r3;
        r3 = r9.u(r0);
        if (r3 == 0) goto L_0x0046;
    L_0x003e:
        r9.ckq = r0;
        r9.afn();
    L_0x0043:
        r2 = 0;
        r6 = 0;
        goto L_0x0054;
    L_0x0046:
        r0 = 2131821311; // 0x7f1102ff float:1.9275362E38 double:1.053259673E-314;
        r0 = r9.getString(r0);
        com.iqoption.app.a.b.eO(r0);
        com.iqoption.dialog.c.w.afx();
        r6 = 1;
    L_0x0054:
        r3 = "loose";
        r4 = 0;
        r0 = r9.ckf;
        if (r0 == 0) goto L_0x005f;
    L_0x005b:
        r0 = "percentage";
    L_0x005d:
        r5 = r0;
        goto L_0x0062;
    L_0x005f:
        r0 = "amount";
        goto L_0x005d;
    L_0x0062:
        r7 = r9.ckq;
        com.iqoption.dialog.c.w.a(r3, r4, r5, r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.afk():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    private void afl() {
        /*
        r9 = this;
        r0 = r9.ckd;
        r1 = r9.ckq;
        r0 = r0.p(r1);
        r2 = 1;
        r3 = com.iqoption.util.q.dX(r2);
        r4 = java.lang.Math.abs(r0);
        r3 = r3.format(r4);
        r4 = ".";
        r3 = r3.contains(r4);
        r4 = r9.ckf;
        if (r4 == 0) goto L_0x0031;
    L_0x001f:
        if (r3 == 0) goto L_0x0031;
    L_0x0021:
        r2 = r9.ckd;
        r0 = java.lang.Math.floor(r0);
        r0 = r2.getTpslValue(r0);
        r9.ckq = r0;
        r9.afn();
        goto L_0x0046;
    L_0x0031:
        r0 = r9.ckq;
        r3 = r9.afj();
        r0 = r0 + r3;
        r9.s(r0);
        r3 = r9.u(r0);
        if (r3 == 0) goto L_0x0049;
    L_0x0041:
        r9.ckq = r0;
        r9.afn();
    L_0x0046:
        r2 = 0;
        r6 = 0;
        goto L_0x0057;
    L_0x0049:
        r0 = 2131821311; // 0x7f1102ff float:1.9275362E38 double:1.053259673E-314;
        r0 = r9.getString(r0);
        com.iqoption.app.a.b.eO(r0);
        com.iqoption.dialog.c.w.afx();
        r6 = 1;
    L_0x0057:
        r3 = "loose";
        r4 = 1;
        r0 = r9.ckf;
        if (r0 == 0) goto L_0x0062;
    L_0x005e:
        r0 = "percentage";
    L_0x0060:
        r5 = r0;
        goto L_0x0065;
    L_0x0062:
        r0 = "amount";
        goto L_0x0060;
    L_0x0065:
        r7 = r9.ckq;
        com.iqoption.dialog.c.w.a(r3, r4, r5, r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.afl():void");
    }

    /* JADX WARNING: Missing block: B:3:0x0026, code:
            if (com.google.common.c.a.c(r13, r12.ckd.getTpslValue(r12.ckd.getStopOutThreshold()), r10) > 0) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:6:0x003b, code:
            if (com.google.common.c.a.c(r13, r12.ckd.getTpslValue(r12.ckd.getStopOutThreshold()), r10) < 0) goto L_0x0028;
     */
    private void s(double r13) {
        /*
        r12 = this;
        r0 = r12.precision;
        r1 = 1;
        r0 = r0 + r1;
        r0 = -r0;
        r2 = (double) r0;
        r4 = 4621819117588971520; // 0x4024000000000000 float:0.0 double:10.0;
        r10 = java.lang.Math.pow(r4, r2);
        r0 = r12.ckd;
        r0 = r0.isLong();
        r2 = 0;
        if (r0 == 0) goto L_0x002a;
    L_0x0015:
        r0 = r12.ckd;
        r3 = r12.ckd;
        r3 = r3.getStopOutThreshold();
        r8 = r0.getTpslValue(r3);
        r6 = r13;
        r13 = com.google.common.c.a.c(r6, r8, r10);
        if (r13 <= 0) goto L_0x003e;
    L_0x0028:
        r2 = 1;
        goto L_0x003e;
    L_0x002a:
        r0 = r12.ckd;
        r3 = r12.ckd;
        r3 = r3.getStopOutThreshold();
        r8 = r0.getTpslValue(r3);
        r6 = r13;
        r13 = com.google.common.c.a.c(r6, r8, r10);
        if (r13 >= 0) goto L_0x003e;
    L_0x003d:
        goto L_0x0028;
    L_0x003e:
        if (r2 != 0) goto L_0x0055;
    L_0x0040:
        r13 = r12.ckm;
        r13 = r13.btP;
        r13 = r13.isChecked();
        if (r13 != 0) goto L_0x0055;
    L_0x004a:
        r13 = r12.ckh;
        if (r13 == 0) goto L_0x0055;
    L_0x004e:
        r13 = r12.ckm;
        r13 = r13.btP;
        r13.setChecked(r1);
    L_0x0055:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.s(double):void");
    }

    private void afm() {
        double p = this.ckd.p(this.ckp);
        CharSequence n = p.n(p);
        CharSequence p2 = l.p(Double.valueOf(au.i(this.ckd.GN(), p)));
        this.ckm.buq.setText(q.dY(this.precision).format(this.ckp));
        if (this.ckf) {
            this.ckm.bui.setText(n);
            this.ckm.bun.setText(p2);
        } else {
            this.ckm.bui.setText(p2);
            this.ckm.bun.setText(n);
        }
        if (p > 0.01d) {
            this.ckm.bun.setTextColor(this.ahg);
            bg.setBackground(this.ckm.bun, this.ckj);
        } else if (p < -0.01d) {
            this.ckm.bun.setTextColor(this.ahh);
            bg.setBackground(this.ckm.bun, this.ckk);
        } else {
            this.ckm.bun.setTextColor(this.ahi);
            bg.setBackground(this.ckm.bun, this.ckl);
        }
        if (t(this.ckp - afj())) {
            this.ckm.bul.setEnabled(true);
        } else {
            this.ckm.bul.setEnabled(false);
        }
        if (t(this.ckp + afj())) {
            this.ckm.buj.setEnabled(true);
        } else {
            this.ckm.buj.setEnabled(false);
        }
    }

    private void afn() {
        double p = this.ckd.p(this.ckq);
        CharSequence n = p.n(p);
        CharSequence p2 = l.p(Double.valueOf(au.i(this.ckd.GN(), p)));
        this.ckm.buc.setText(q.dY(this.precision).format(this.ckq));
        if (this.ckf) {
            this.ckm.btU.setText(n);
            this.ckm.btZ.setText(p2);
        } else {
            this.ckm.btU.setText(p2);
            this.ckm.btZ.setText(n);
        }
        if (p > 0.01d) {
            this.ckm.btZ.setTextColor(this.ahg);
            bg.setBackground(this.ckm.btZ, this.ckj);
        } else if (p < -0.01d) {
            this.ckm.btZ.setTextColor(this.ahh);
            bg.setBackground(this.ckm.btZ, this.ckk);
        } else {
            this.ckm.btZ.setTextColor(this.ahi);
            bg.setBackground(this.ckm.btZ, this.ckl);
        }
        if (u(this.ckq + afj())) {
            this.ckm.btX.setEnabled(true);
        } else {
            this.ckm.btX.setEnabled(false);
        }
        if (u(this.ckq - afj())) {
            this.ckm.btV.setEnabled(true);
        } else {
            this.ckm.btV.setEnabled(false);
        }
        Double afp = afp();
        if (afp != null) {
            a(true, afp.doubleValue());
        } else {
            a(false, 0.0d);
        }
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void onResume() {
        super.onResume();
        startTimer();
    }

    public void onPause() {
        super.onPause();
        afr();
    }

    private void afo() {
        if (this.cke) {
            this.ckt = this.ckd.afe();
            if (this.ckt != null) {
                this.ckm.buv.setText(q.dY(this.precision).format(this.ckt));
            }
            Double aff = this.ckd.aff();
            if (aff != null) {
                h.a(aff.doubleValue(), this.cku);
                v(aff.doubleValue());
            } else {
                this.ckm.buu.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Missing block: B:5:0x002d, code:
            if (com.google.common.c.a.c(r16, r0.ckt.doubleValue() + r1, r5) > 0) goto L_0x002f;
     */
    /* JADX WARNING: Missing block: B:7:0x0038, code:
            if (com.google.common.c.a.c(r16, 0.0d, r5) >= 0) goto L_0x003c;
     */
    /* JADX WARNING: Missing block: B:8:0x003b, code:
            r4 = false;
     */
    /* JADX WARNING: Missing block: B:9:0x003c, code:
            return r4;
     */
    /* JADX WARNING: Missing block: B:13:0x0050, code:
            if (com.google.common.c.a.c(r16, r0.ckt.doubleValue() + r1, r5) < 0) goto L_0x0052;
     */
    /* JADX WARNING: Missing block: B:15:0x005b, code:
            if (com.google.common.c.a.c(r16, 0.0d, r5) >= 0) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:16:0x005e, code:
            r4 = false;
     */
    /* JADX WARNING: Missing block: B:17:0x005f, code:
            return r4;
     */
    private boolean t(double r16) {
        /*
        r15 = this;
        r0 = r15;
        r1 = r0.getMin();
        r3 = r0.precision;
        r4 = 1;
        r3 = r3 + r4;
        r3 = -r3;
        r5 = (double) r3;
        r7 = 4621819117588971520; // 0x4024000000000000 float:0.0 double:10.0;
        r5 = java.lang.Math.pow(r7, r5);
        r3 = r0.ckd;
        r3 = r3.isLong();
        r7 = 0;
        if (r3 == 0) goto L_0x003d;
    L_0x001a:
        r3 = r0.ckt;
        if (r3 == 0) goto L_0x002f;
    L_0x001e:
        r3 = r0.ckt;
        r8 = r3.doubleValue();
        r11 = r8 + r1;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 <= 0) goto L_0x003b;
    L_0x002f:
        r11 = 0;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 < 0) goto L_0x003b;
    L_0x003a:
        goto L_0x003c;
    L_0x003b:
        r4 = 0;
    L_0x003c:
        return r4;
    L_0x003d:
        r3 = r0.ckt;
        if (r3 == 0) goto L_0x0052;
    L_0x0041:
        r3 = r0.ckt;
        r8 = r3.doubleValue();
        r11 = r8 + r1;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 >= 0) goto L_0x005e;
    L_0x0052:
        r11 = 0;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 < 0) goto L_0x005e;
    L_0x005d:
        goto L_0x005f;
    L_0x005e:
        r4 = 0;
    L_0x005f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.t(double):boolean");
    }

    /* JADX WARNING: Missing block: B:3:0x002d, code:
            if (com.google.common.c.a.c(r16, r0.ckd.getTpslValue(r0.ckd.getStopOutThreshold()), r5) >= 0) goto L_0x002f;
     */
    /* JADX WARNING: Missing block: B:5:0x0031, code:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:7:0x0046, code:
            if (com.google.common.c.a.c(r16, r0.ckd.getTpslValue(r0.ckd.getStopOutThreshold()), r5) <= 0) goto L_0x002f;
     */
    /* JADX WARNING: Missing block: B:16:0x006a, code:
            if (com.google.common.c.a.c(r16, r0.ckt.doubleValue() - r1, r5) < 0) goto L_0x006c;
     */
    /* JADX WARNING: Missing block: B:18:0x0075, code:
            if (com.google.common.c.a.c(r16, 0.0d, r5) >= 0) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:27:0x0093, code:
            if (com.google.common.c.a.c(r16, r0.ckt.doubleValue() - r1, r5) > 0) goto L_0x0095;
     */
    /* JADX WARNING: Missing block: B:29:0x009e, code:
            if (com.google.common.c.a.c(r16, 0.0d, r5) >= 0) goto L_0x00a2;
     */
    private boolean u(double r16) {
        /*
        r15 = this;
        r0 = r15;
        r1 = r0.getMin();
        r3 = r0.precision;
        r4 = 1;
        r3 = r3 + r4;
        r3 = -r3;
        r5 = (double) r3;
        r7 = 4621819117588971520; // 0x4024000000000000 float:0.0 double:10.0;
        r5 = java.lang.Math.pow(r7, r5);
        r3 = r0.ckd;
        r3 = r3.isLong();
        r7 = 0;
        if (r3 == 0) goto L_0x0033;
    L_0x001a:
        r3 = r0.ckd;
        r8 = r0.ckd;
        r8 = r8.getStopOutThreshold();
        r11 = r3.getTpslValue(r8);
        r9 = r16;
        r13 = r5;
        r3 = com.google.common.c.a.c(r9, r11, r13);
        if (r3 < 0) goto L_0x0031;
    L_0x002f:
        r3 = 1;
        goto L_0x0049;
    L_0x0031:
        r3 = 0;
        goto L_0x0049;
    L_0x0033:
        r3 = r0.ckd;
        r8 = r0.ckd;
        r8 = r8.getStopOutThreshold();
        r11 = r3.getTpslValue(r8);
        r9 = r16;
        r13 = r5;
        r3 = com.google.common.c.a.c(r9, r11, r13);
        if (r3 > 0) goto L_0x0031;
    L_0x0048:
        goto L_0x002f;
    L_0x0049:
        r8 = r0.ckd;
        r8 = r8.isLong();
        if (r8 == 0) goto L_0x007a;
    L_0x0051:
        r8 = r0.ckh;
        if (r8 != 0) goto L_0x0057;
    L_0x0055:
        if (r3 == 0) goto L_0x0078;
    L_0x0057:
        r3 = r0.ckt;
        if (r3 == 0) goto L_0x006c;
    L_0x005b:
        r3 = r0.ckt;
        r8 = r3.doubleValue();
        r11 = r8 - r1;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 >= 0) goto L_0x0078;
    L_0x006c:
        r11 = 0;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 < 0) goto L_0x0078;
    L_0x0077:
        goto L_0x0079;
    L_0x0078:
        r4 = 0;
    L_0x0079:
        return r4;
    L_0x007a:
        r8 = r0.ckh;
        if (r8 != 0) goto L_0x0080;
    L_0x007e:
        if (r3 == 0) goto L_0x00a1;
    L_0x0080:
        r3 = r0.ckt;
        if (r3 == 0) goto L_0x0095;
    L_0x0084:
        r3 = r0.ckt;
        r8 = r3.doubleValue();
        r11 = r8 - r1;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 <= 0) goto L_0x00a1;
    L_0x0095:
        r11 = 0;
        r9 = r16;
        r13 = r5;
        r1 = com.google.common.c.a.c(r9, r11, r13);
        if (r1 < 0) goto L_0x00a1;
    L_0x00a0:
        goto L_0x00a2;
    L_0x00a1:
        r4 = 0;
    L_0x00a2:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.c.b.u(double):boolean");
    }

    private double getMin() {
        if (this.ckg) {
            int i = this.ckd.isLong() ? 1 : -1;
            InstrumentType instrumentType = this.ckd.getInstrumentType();
            if (instrumentType == InstrumentType.FOREX_INSTRUMENT) {
                return ((double) i) * (30.0d / Math.pow(10.0d, (double) this.precision));
            }
            ActiveQuote da = com.iqoption.app.managers.c.Gn().da(this.ckd.afc());
            if (da != null) {
                return au.i(da.getSpread(instrumentType, this.ckd.getLeverage()) * ((double) i), 0.1d);
            }
        }
        return 0.0d;
    }

    private Double afp() {
        if (!(this.ckd.afg() || this.ckt == null)) {
            double p = this.ckd.p(this.ckt.doubleValue()) - afq();
            if (this.ckd.p(this.ckq) > p) {
                return Double.valueOf(p);
            }
        }
        return null;
    }

    private void a(boolean z, double d) {
        if (z) {
            this.ckm.bux.setText(getString(R.string.we_strongly_do_not_recommend, p.dZ((int) d)));
            this.ckm.bux.setVisibility(0);
            return;
        }
        this.ckm.bux.setVisibility(8);
    }

    private double afq() {
        int leverage = this.ckd.getLeverage();
        return leverage > 100 ? ((double) leverage) / 100.0d : (((double) leverage) / 100.0d) + 1.0d;
    }

    private void v(double d) {
        double signum;
        Double valueOf;
        if (this.ckm.bup.getNextView().getId() == R.id.takeProfitAdd && !t(this.ckp)) {
            signum = Math.signum(d);
            double f = f(Math.abs(d), 50);
            valueOf = Double.valueOf(this.ckd.getTpslValue(signum * f));
            while (!t(valueOf.doubleValue())) {
                f += 50.0d;
                valueOf = Double.valueOf(this.ckd.getTpslValue(signum * f));
            }
            this.ckp = valueOf.doubleValue();
            afm();
        }
        if (this.ckm.bub.getNextView().getId() == R.id.stopLossAdd && !u(this.ckq)) {
            signum = Math.signum(d);
            d = f(Math.abs(d), 50);
            valueOf = Double.valueOf(this.ckd.getTpslValue(signum * d));
            while (!u(valueOf.doubleValue())) {
                d += 50.0d;
                valueOf = Double.valueOf(this.ckd.getTpslValue(signum * d));
            }
            this.ckq = valueOf.doubleValue();
            afn();
        }
    }

    public static double f(double d, int i) {
        int floor = (int) Math.floor(d);
        floor += floor % i == 0 ? 1 : 0;
        if (floor % i != 0) {
            floor = ((floor / i) * i) + i;
        }
        return (double) floor;
    }

    private AnimatorSet a(ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, 300);
        animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2});
        return animatorSet;
    }

    private ObjectAnimator a(View view, Point point, Point point2) {
        r0 = new PropertyValuesHolder[3];
        r0[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        r0[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{(float) (point2.x - point.x)});
        r0[2] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) (point2.y - point.y)});
        return ObjectAnimator.ofPropertyValuesHolder(view, r0);
    }

    private void startTimer() {
        com.iqoption.view.a.b.aIK().a(this.ckv, Integer.valueOf(5));
    }

    private void afr() {
        com.iqoption.view.a.b.aIK().b(this.ckv);
    }
}
