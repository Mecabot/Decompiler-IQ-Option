package com.iqoption.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.common.util.concurrent.o;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.system.c.b;
import com.iqoption.util.am;
import com.iqoption.view.l;
import com.iqoption.welcomeonboarding.registration.f;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Tutorial */
public class z extends Dialog {
    private Builder adT = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "tutorial_close");
    private TextView bBa;
    private ViewPager bGy;
    private l cfJ;
    private TextView cfK;
    private TextView cfL;
    private TextView cfM;
    private View cfN;
    private View cfO;
    private View cfP;
    private View cfQ;
    private View cfR;
    private View cfS;
    private View cfT;
    private View cfU;
    private View cfV;
    private View cfW;
    private View cfX;
    private View cfY;
    private TradeRoomActivity cfy;
    private int dp100;
    private int dp200;
    private int dp300;
    private int dp400;
    private int dp500;
    private int dp700;

    /* compiled from: Tutorial */
    private static class a extends b<z, Boolean> {
        public a(z zVar) {
            super((Object) zVar);
        }

        /* renamed from: a */
        public void z(z zVar, Boolean bool) {
            zVar.cfy.zB();
        }

        /* renamed from: a */
        public void c(z zVar, Throwable th) {
            zVar.cfy.zB();
        }
    }

    public z(TradeRoomActivity tradeRoomActivity) {
        super(tradeRoomActivity, 16973840);
        ae.d(getContext(), 4096);
        com.iqoption.util.z zVar = new com.iqoption.util.z(getContext());
        zVar.L(700.0f);
        zVar.L(100.0f);
        zVar.L(200.0f);
        zVar.L(300.0f);
        zVar.L(400.0f);
        zVar.L(500.0f);
        this.cfy = tradeRoomActivity;
        setContentView(R.layout.tutorial);
        getWindow().setFlags(1024, 1024);
        aep();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                EventManager.Bm().a(z.this.adT.setValue(Double.valueOf((double) z.this.bGy.getCurrentItem())).calcDuration().build());
            }
        });
    }

    private void aep() {
        findViewById(R.id.backButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                z.this.dismiss();
            }
        });
        this.bGy = (ViewPager) findViewById(R.id.tutorialViewPager);
        this.cfJ = new l(aez());
        this.bGy.setAdapter(this.cfJ);
        this.bGy.setOffscreenPageLimit(4);
        this.bGy.setPageTransformer(false, new PageTransformer() {
            public void transformPage(View view, float f) {
                View c = z.this.cfK;
                if (view.getTag().equals(Integer.valueOf(2))) {
                    c = z.this.bBa;
                }
                if (view.getTag().equals(Integer.valueOf(3))) {
                    c = z.this.cfL;
                }
                if (view.getTag().equals(Integer.valueOf(4))) {
                    c = z.this.cfM;
                }
                float abs = 1.0f - (Math.abs(f) * 3.0f);
                c.setAlpha(abs > 0.0f ? abs : 0.0f);
                c.setTranslationX(((float) z.this.dp700) * f);
                if (view.getTag().equals(Integer.valueOf(1)) && f <= 0.0f) {
                    z.this.cfN.setAlpha(abs > 0.0f ? abs : 0.0f);
                    float f2 = f + 1.0f;
                    z.this.cfN.setScaleX(f2);
                    z.this.cfN.setScaleY(f2);
                    z.this.cfO.setAlpha(abs > 0.0f ? abs : 0.0f);
                    float f3 = 1.0f - f;
                    z.this.cfO.setScaleX(f3);
                    z.this.cfO.setScaleY(f3);
                }
                if (view.getTag().equals(Integer.valueOf(3)) && f > 0.0f) {
                    z.this.cfP.setTranslationX(((float) z.this.dp100) * f);
                    z.this.cfU.setAlpha(abs > 0.0f ? abs : 0.0f);
                    z.this.cfQ.setTranslationX(((float) z.this.dp200) * f);
                    z.this.cfV.setAlpha(abs > 0.0f ? abs : 0.0f);
                    z.this.cfR.setTranslationX(((float) z.this.dp300) * f);
                    z.this.cfW.setAlpha(abs > 0.0f ? abs : 0.0f);
                    z.this.cfS.setTranslationX(((float) z.this.dp400) * f);
                    z.this.cfX.setAlpha(abs > 0.0f ? abs : 0.0f);
                    z.this.cfT.setTranslationX(((float) z.this.dp500) * f);
                    view = z.this.cfY;
                    if (abs <= 0.0f) {
                        abs = 0.0f;
                    }
                    view.setAlpha(abs);
                }
            }
        });
    }

    private List<View> aez() {
        List<View> arrayList = new ArrayList();
        arrayList.add(aeA());
        arrayList.add(aeC());
        arrayList.add(aeB());
        arrayList.add(aeD());
        return arrayList;
    }

    private View aeA() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tutorial_page_1, null);
        OnClickListener anonymousClass4 = new OnClickListener() {
            public void onClick(View view) {
                z.this.bGy.setCurrentItem(1, true);
            }
        };
        this.cfN = inflate.findViewById(R.id.put);
        this.cfN.setOnClickListener(anonymousClass4);
        this.cfO = inflate.findViewById(R.id.call);
        this.cfO.setOnClickListener(anonymousClass4);
        this.cfK = (TextView) inflate.findViewById(R.id.title);
        CharSequence string = this.cfy.getString(R.string.will_the_eurusd_be_higher);
        String string2 = this.cfy.getString(R.string.higher);
        int indexOf = string.indexOf(string2);
        String string3 = this.cfy.getString(R.string.lower);
        int indexOf2 = string.indexOf(string3);
        if (indexOf == -1 || indexOf2 == -1) {
            this.cfK.setText(string);
            inflate.setTag(Integer.valueOf(1));
            return inflate;
        }
        CharSequence spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(this.cfy.getResources().getColor(R.color.higher_color)), indexOf, string2.length() + indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.cfy.getResources().getColor(R.color.lower_color)), indexOf2, string3.length() + indexOf2, 33);
        this.cfK.setText(spannableString);
        inflate.setTag(Integer.valueOf(1));
        return inflate;
    }

    private View aeB() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tutorial_page_3, null);
        this.cfL = (TextView) inflate.findViewById(R.id.title);
        this.cfP = inflate.findViewById(R.id.firstWhy);
        this.cfQ = inflate.findViewById(R.id.secondWhy);
        this.cfR = inflate.findViewById(R.id.thirdWhy);
        this.cfS = inflate.findViewById(R.id.fourthWhy);
        this.cfT = inflate.findViewById(R.id.fifthWhy);
        this.cfU = inflate.findViewById(R.id.firstMark);
        this.cfV = inflate.findViewById(R.id.secondMark);
        this.cfW = inflate.findViewById(R.id.thirdMark);
        this.cfX = inflate.findViewById(R.id.fourthMark);
        this.cfY = inflate.findViewById(R.id.fifthMark);
        inflate.setTag(Integer.valueOf(3));
        return inflate;
    }

    private View aeC() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tutorial_page_2, null);
        this.bBa = (TextView) inflate.findViewById(R.id.title);
        inflate.setTag(Integer.valueOf(2));
        return inflate;
    }

    private View aeD() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tutorial_page_4, null);
        this.cfM = (TextView) inflate.findViewById(R.id.title);
        Button button = (Button) inflate.findViewById(R.id.openRealAccount);
        Button button2 = (Button) inflate.findViewById(R.id.tryFreeDemo);
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        if (!aL.isAuthorized() || aL.CZ()) {
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    f.a(z.this.cfy, z.this.cfy.getSupportFragmentManager());
                    z.this.dismiss();
                }
            });
        } else {
            button.setText(this.cfy.getString(R.string.deposit));
            button.setBackgroundDrawable(this.cfy.getResources().getDrawable(R.drawable.call_button_state));
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    z.this.cfy.Aq();
                    z.this.dismiss();
                }
            });
        }
        if (aL.isAuthorized() || af.aR(getContext()).EC()) {
            button2.setVisibility(8);
        } else {
            button2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    z.this.cfy.zC();
                    o.a(com.iqoption.c.a.Jw().JA(), new a(z.this), com.iqoption.core.d.a.aSe);
                    z.this.dismiss();
                }
            });
        }
        inflate.setTag(Integer.valueOf(4));
        return inflate;
    }

    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        getWindow().clearFlags(8);
        am.bS(getWindow().getDecorView());
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Tutorial");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    public void dismiss() {
        super.dismiss();
    }
}
