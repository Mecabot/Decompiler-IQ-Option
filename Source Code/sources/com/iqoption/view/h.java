package com.iqoption.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.vv;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.system.a.c;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.view.d.d;
import com.iqoption.view.drumview.recyclerviewpager.ScrolledToPositionInZoneLinearLayoutManager;
import com.iqoption.x.R;

/* compiled from: IQKeyboardFragment */
public class h extends com.iqoption.fragment.base.b {
    private Builder adT;
    private long dBO = 0;
    private boolean dBP = false;
    private vv dBQ;
    private com.iqoption.a.c.a dBR;
    private d dBS = new d();
    private boolean dBT = false;

    /* compiled from: IQKeyboardFragment */
    public static class a extends c<Double> {
    }

    /* compiled from: IQKeyboardFragment */
    public static class b extends c<Boolean> {
    }

    private static h K(double d) {
        h hVar = new h();
        hVar.setArguments(new g().e("arg.double.amount", d).toBundle());
        return hVar;
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, double d) {
        fragmentManager.beginTransaction().add(i, K(d), "IQKeyboardFragment").addToBackStack("IQKeyboardFragment").commit();
    }

    public static boolean b(FragmentManager fragmentManager, @IdRes int i, double d) {
        h hVar = (h) fragmentManager.findFragmentByTag("IQKeyboardFragment");
        if (hVar == null) {
            a(fragmentManager, i, d);
        } else {
            hVar.aN();
        }
        return hVar == null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dBQ = (vv) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.iqkeyboard_fragment, viewGroup, false);
        this.dBQ.a(this);
        return this.dBQ.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.dBQ.axh.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.dBQ.bIG.setLayoutTransition(new LayoutTransition());
        this.dBQ.bIu.setOnTouchListener(this.dBS);
        this.dBQ.bIL.setOnTouchListener(this.dBS);
        this.dBQ.bIW.setOnTouchListener(this.dBS);
        this.dBQ.bIK.setOnTouchListener(this.dBS);
        this.dBQ.bIV.setOnTouchListener(this.dBS);
        this.dBQ.bIS.setOnTouchListener(this.dBS);
        this.dBQ.bIC.setOnTouchListener(this.dBS);
        this.dBQ.bIB.setOnTouchListener(this.dBS);
        this.dBQ.bIQ.setOnTouchListener(this.dBS);
        this.dBQ.bIP.setOnTouchListener(this.dBS);
        this.dBQ.bIA.setOnTouchListener(this.dBS);
        this.dBQ.bIJ.setOnTouchListener(this.dBS);
        this.dBQ.bII.setOnTouchListener(this.dBS);
        this.dBQ.bIz.setOnTouchListener(this.dBS);
        af aR = af.aR(getContext());
        this.dBO = (long) (getArguments().getDouble("arg.double.amount") * 1000000.0d);
        this.dBQ.bIr.setText(l.q(Double.valueOf(((double) this.dBO) / 1000000.0d)));
        this.dBQ.bIr.setOnTouchListener(new OnTouchListener() {
            GestureDetector dBV = new GestureDetector(h.this.getContext(), new a());

            /* compiled from: IQKeyboardFragment */
            class a extends SimpleOnGestureListener {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return true;
                }

                a() {
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    h.this.fh(false);
                    h.this.fg(true);
                    return true;
                }
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.dBV.onTouchEvent(motionEvent);
                return true;
            }
        });
        this.dBQ.bIr.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.dBQ.bIr.setSelection(i3);
            }
        });
        fg(true);
        this.dBQ.bIy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                h.this.fg(false);
                h.this.fh(true);
            }
        });
        this.dBQ.bIx.setText(jW(aR.Fc()));
        this.dBQ.bIx.setOnTouchListener(new OnTouchListener() {
            GestureDetector dBV = new GestureDetector(h.this.getContext(), new a());

            /* compiled from: IQKeyboardFragment */
            class a extends SimpleOnGestureListener {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return true;
                }

                a() {
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    h.this.fg(false);
                    h.this.fh(true);
                    return true;
                }
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.dBV.onTouchEvent(motionEvent);
                return true;
            }
        });
        this.dBQ.bIx.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.dBQ.bIx.setSelection(i3);
            }
        });
        fh(false);
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        this.dBQ.bIw.setText(l.d(Cw.CD(), d(Cw)));
        OnTouchListener dVar = new d();
        this.dBQ.bIq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IQApp.Dn().aE(new a().setValue(h.this.d(com.iqoption.app.a.Cw())));
                h.this.aN();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_all-in").build());
            }
        });
        this.dBQ.bIq.setOnTouchListener(dVar);
        this.dBQ.bID.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                h.this.fi(view.isSelected() ^ 1);
            }
        });
        fi(aR.EZ());
        LinearLayoutManager scrolledToPositionInZoneLinearLayoutManager = new ScrolledToPositionInZoneLinearLayoutManager(getContext(), 1);
        LinearLayoutManager scrolledToPositionInZoneLinearLayoutManager2 = new ScrolledToPositionInZoneLinearLayoutManager(getContext(), 1);
        scrolledToPositionInZoneLinearLayoutManager.setAutoMeasureEnabled(true);
        scrolledToPositionInZoneLinearLayoutManager2.setAutoMeasureEnabled(true);
        this.dBR = new com.iqoption.a.c.a(getContext(), aR.Fd(), aIj(), new com.iqoption.a.b.a() {
            public void a(View view, int i) {
                String item = h.this.dBR.getItem(i);
                h.this.jV(item);
                try {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, h.this.dBR.Be() == 2000 ? "deal-keyboard_chose-presets" : "deal-keyboard_chose-last-ammounts").setValue(Double.valueOf(Double.parseDouble(item))).build());
                } catch (Exception unused) {
                    h.this.aN();
                }
            }
        });
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.dBQ.bIM.setLayoutManager(linearLayoutManager);
        this.dBQ.bIM.setAdapter(this.dBR);
        this.dBQ.bIO.setLayoutTransition(new LayoutTransition());
        if (this.dBR.Be() == 2000) {
            this.dBQ.bIN.setVisibility(8);
            this.dBQ.bIE.setVisibility(0);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_last-ammounts").build());
        } else {
            this.dBQ.bIE.setVisibility(8);
            this.dBQ.bIN.setVisibility(0);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_presets").build());
        }
        fj(true);
    }

    private Double d(com.iqoption.app.a aVar) {
        double doubleValue = aVar.Cx().doubleValue();
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null && com.iqoption.app.helpers.a.FI().h(Iw.getInstrumentType())) {
            double d;
            com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(Iw.getInstrumentType(), Integer.valueOf(Iw.getActiveId()));
            if (a == null) {
                d = 0.0d;
            } else {
                d = a.f(doubleValue, l.aGa().doubleValue());
            }
            if (!com.google.common.c.a.b(0.0d, d, 0.001d)) {
                Balance CA = aVar.CA();
                Object obj = null;
                Object obj2 = aVar.Cy() == 1 ? 1 : null;
                if (CA != null) {
                    obj = 1;
                }
                if (obj == null || obj2 == null || !com.iqoption.app.managers.feature.a.HD() || !af.eN("otn_commmision")) {
                    doubleValue -= d;
                } else {
                    double doubleValue2 = l.d(l.e(Double.valueOf(Balance.getBalanceValue(CA)), Double.valueOf(l.c(aVar.eh(Currencies.OTN_CURRENCY)).doubleValue())), Double.valueOf(l.c(aVar.CF()).doubleValue())).doubleValue() - d;
                    doubleValue = doubleValue2 < 0.0d ? doubleValue - Math.abs(doubleValue2) : doubleValue - d;
                }
            }
        }
        if (doubleValue < 0.0d) {
            doubleValue = aVar.Cx().doubleValue();
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    private InstrumentType aIj() {
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        return Iw != null ? Iw.instrumentType : null;
    }

    private void fg(boolean z) {
        if (z) {
            this.dBQ.bIr.setCursorVisible(true);
            int length = this.dBQ.bIr.getText().length();
            if (length > 0) {
                this.dBQ.bIr.setSelection(length);
                this.dBQ.bIr.postDelayed(new Runnable() {
                    public void run() {
                        if (h.this.isAdded()) {
                            h.this.dBQ.bIr.requestFocus();
                        }
                    }
                }, 100);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.dBQ.bIr.getText())) {
            this.dBQ.bIr.setText(l.q(Double.valueOf(((double) this.dBO) / 1000000.0d)));
        }
        this.dBQ.bIr.setCursorVisible(false);
        this.dBQ.bIr.clearFocus();
    }

    private void fh(boolean z) {
        if (z) {
            this.dBQ.bIx.setCursorVisible(true);
            int length = this.dBQ.bIx.getText().length();
            if (length > 0) {
                this.dBQ.bIx.setSelection(length);
                this.dBQ.bIx.postDelayed(new Runnable() {
                    public void run() {
                        if (h.this.isAdded()) {
                            h.this.dBQ.bIx.requestFocus();
                        }
                    }
                }, 100);
            }
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_TEXT_CHANGED, "deal-keyboard_change-coeficient").build());
            return;
        }
        if (TextUtils.isEmpty(this.dBQ.bIx.getText().toString())) {
            this.dBQ.bIx.setText(jW(af.aR(IQApp.Dk()).Fc()));
        }
        this.dBQ.bIx.setCursorVisible(false);
        this.dBQ.bIx.clearFocus();
    }

    public void bY(View view) {
        if (!TextUtils.isEmpty(this.dBQ.bIx.getText())) {
            try {
                Double valueOf = Double.valueOf(Double.parseDouble(this.dBQ.bIx.getText().toString()));
                if (valueOf != null && valueOf.doubleValue() != 0.0d) {
                    this.dBT = true;
                    if (this.dBO < 0) {
                        this.dBO = (long) (Double.parseDouble(aIl()) * 1000000.0d);
                    }
                    double doubleValue = ((double) this.dBO) / (valueOf.doubleValue() * 1000000.0d);
                    this.dBO = (long) (1000000.0d * doubleValue);
                    jV(l.v(Double.valueOf(doubleValue)));
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_divide").setValue(valueOf).build());
                }
            } catch (Exception unused) {
            }
        }
    }

    public void bZ(View view) {
        if (!TextUtils.isEmpty(this.dBQ.bIx.getText())) {
            try {
                this.dBT = true;
                if (this.dBO < 0) {
                    this.dBO = (long) (Double.parseDouble(aIl()) * 1000000.0d);
                }
                Double valueOf = Double.valueOf(Double.parseDouble(this.dBQ.bIx.getText().toString()));
                if (valueOf != null && valueOf.doubleValue() != 0.0d) {
                    double doubleValue = (((double) this.dBO) * valueOf.doubleValue()) / 1000000.0d;
                    this.dBO = (long) (1000000.0d * doubleValue);
                    jV(l.v(Double.valueOf(doubleValue)));
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_multiply").setValue(valueOf).build());
                }
            } catch (Exception unused) {
            }
        }
    }

    public void ca(View view) {
        try {
            this.dBT = false;
            this.dBO = -1;
            String string = getString();
            if (string.indexOf(".") < 0) {
                if (string.isEmpty()) {
                    string = "0.";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(".");
                    string = stringBuilder.toString();
                }
                setString(string);
            }
        } catch (Exception unused) {
        }
    }

    public void cb(View view) {
        try {
            this.dBT = false;
            this.dBO = -1;
            String string = getString();
            setString(string.substring(0, string.length() - 1));
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_number-button").setValue(Double.valueOf(-1.0d)).build());
        } catch (Exception unused) {
        }
    }

    public void cc(View view) {
        ae.d(getContext(), 32768);
        try {
            this.dBO = -1;
            String string = getString();
            if (this.dBT) {
                string = "";
                this.dBT = false;
            }
            if (string.length() == 0) {
                string = view.getTag().toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(view.getTag().toString());
                string = stringBuilder.toString();
            }
            setString(string);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_number-button").setValue(Double.valueOf(Double.parseDouble(view.getTag().toString()))).build());
        } catch (Exception unused) {
        }
    }

    public void cd(View view) {
        this.dBR.Bd();
        if (this.dBR.Be() == 2000) {
            this.dBQ.bIN.setVisibility(8);
            this.dBQ.bIE.setVisibility(0);
        } else {
            this.dBQ.bIE.setVisibility(8);
            this.dBQ.bIN.setVisibility(0);
        }
        af.aR(getContext()).cT(this.dBR.Be());
    }

    private void fi(boolean z) {
        this.dBQ.bID.setSelected(z);
        if (z) {
            this.dBQ.bIF.setVisibility(0);
        } else {
            this.dBQ.bIF.setVisibility(8);
        }
        af.aR(getContext()).bd(z);
    }

    private void fj(boolean z) {
        if (z) {
            this.dBT = true;
            this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "deal-keyboard");
        } else {
            double UO = ajW().UO();
            af.aR(getContext()).l(UO);
            if (this.adT != null) {
                EventManager.Bm().a(this.adT.calcDuration().setValue(Double.valueOf(UO)).build());
            }
        }
        IQApp.Dn().aE(new b().setValue(Boolean.valueOf(z)));
    }

    private String getString() {
        if (this.dBQ.bIx.isFocused()) {
            return aIk();
        }
        return aIl();
    }

    private String aIk() {
        if (this.dBQ.bIx == null || this.dBQ.bIx.getText() == null) {
            return "0";
        }
        try {
            return this.dBQ.bIx.getText().toString().replaceAll("[^\\d\\.]", "");
        } catch (Exception unused) {
            return "0";
        }
    }

    private String aIl() {
        if (this.dBQ.bIr == null || this.dBQ.bIr.getText() == null) {
            return "0";
        }
        try {
            return this.dBQ.bIr.getText().toString().replaceAll("[^\\d\\.]", "");
        } catch (Exception unused) {
            return "0";
        }
    }

    private void setString(String str) {
        if (this.dBQ.bIx.isFocused()) {
            jU(str);
        } else {
            jV(str);
        }
    }

    private void jU(String str) {
        this.dBQ.bIx.setText(str);
    }

    private void jV(String str) {
        Double cL = com.google.common.primitives.b.cL(str);
        IQApp.Dn().aE(new a().setValue(Double.valueOf(cL != null ? cL.doubleValue() : 0.0d)));
        this.dBQ.bIr.setText(str);
    }

    private void aIm() {
        af DX = af.DX();
        String obj = this.dBQ.bIx.getText().toString();
        Double cL = com.google.common.primitives.b.cL(this.dBQ.bIr.getText().toString());
        if (cL != null) {
            DX.k(cL.doubleValue());
        }
        DX.eH(obj);
    }

    public boolean onClose() {
        aIm();
        this.dBP = false;
        fj(false);
        getFragmentManager().popBackStack();
        return true;
    }

    private String jW(String str) {
        double parseDouble;
        try {
            parseDouble = Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            parseDouble = 2.0d;
        }
        return l.v(Double.valueOf(parseDouble));
    }

    public void ND() {
        this.dBP = true;
        this.dBQ.axh.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            float f = (float) dimensionPixelSize;
            this.dBQ.bIG.setTranslationX(f);
            this.dBQ.bIG.setTranslationY((float) (-dimensionPixelSize));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.dBQ.axh, this.dBQ.axh.getWidth() - dimensionPixelSize, dimensionPixelSize, f, (float) Math.hypot((double) this.dBQ.axh.getWidth(), (double) this.dBQ.axh.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            RelativeLayout relativeLayout = this.dBQ.bIG;
            r8 = new PropertyValuesHolder[2];
            r8[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r8[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(relativeLayout, r8);
            ofPropertyValuesHolder.setDuration(300).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.dBQ.axh.setAlpha(1.0f);
        } else {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
            float f2 = (float) (-dimensionPixelOffset);
            this.dBQ.axh.setTranslationX(f2);
            this.dBQ.axh.setTranslationY(f2);
            this.dBQ.axh.setPivotX((float) (this.dBQ.axh.getWidth() - dimensionPixelOffset));
            this.dBQ.axh.setPivotY(1.0f);
            this.dBQ.axh.setScaleX(0.3f);
            this.dBQ.axh.setScaleY(0.3f);
            this.dBQ.axh.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        }
        af aR = af.aR(getContext());
        if (aR.Fa()) {
            com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                public void run() {
                    h.this.fi(true);
                }
            }, 400);
            aR.Fb();
        }
    }

    public void NE() {
        this.dBQ.axh.setPivotX((float) this.dBQ.axh.getWidth());
        this.dBQ.axh.setPivotY(1.0f);
        this.dBQ.axh.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
