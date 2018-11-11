package com.iqoption.fragment.cashbox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.TransitionManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.d.gi;
import com.iqoption.d.gk;
import com.iqoption.d.gv;
import com.iqoption.d.gz;
import com.iqoption.d.hl;
import com.iqoption.deposit.old.PayMethodSelector;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.Feature;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.util.am;
import com.iqoption.util.be;
import com.iqoption.util.k;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DepositPageFragmentNoBonus */
public class j extends com.iqoption.fragment.base.f {
    private static final String ARG_CURRENCY;
    private static final String TAG = "com.iqoption.fragment.cashbox.j";
    private static final String cxr;
    private static final String cxs;
    private static final String cxt;
    @Nullable
    private com.iqoption.core.microservices.billing.response.deposit.b aTd;
    @Nullable
    private Long bVn;
    @Nullable
    private ArrayList<com.iqoption.core.c.c.a> cwM;
    private String cxA;
    private boolean cxB;
    private Builder cxf;
    private gz cxu;
    private gv cxv;
    private gk cxw;
    private gi cxx;
    @Nullable
    private f cxy;
    private boolean cxz;

    /* compiled from: DepositPageFragmentNoBonus */
    public interface f {
        s<Boolean> a(PayMethod payMethod, com.iqoption.core.microservices.billing.response.deposit.c cVar, Double d, boolean z);

        void aav();
    }

    /* compiled from: DepositPageFragmentNoBonus */
    private class e extends com.iqoption.view.d.b {
        private e() {
        }

        /* synthetic */ e(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void q(View view) {
            ConfirmButtonView confirmButtonView = (ConfirmButtonView) view.getParent();
            if (j.this.cxy != null) {
                com.iqoption.core.microservices.billing.response.deposit.c cVar;
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit-page_deposit").build());
                PayMethod selectedItem = j.this.cxv.bqt.getSelectedItem();
                if (j.this.aTd == null || j.this.aTd.Td().size() != 1) {
                    cVar = (com.iqoption.core.microservices.billing.response.deposit.c) j.this.cxw.bpj.getSelectedItem();
                } else {
                    cVar = (com.iqoption.core.microservices.billing.response.deposit.c) j.this.aTd.Td().get(0);
                }
                Double akf = j.this.cxy.akf();
                f a = j.this.akz();
                if (!(a == null || selectedItem == null || cVar == null || akf == null)) {
                    confirmButtonView.f(true, false);
                    o.a(a.a(selectedItem, cVar, akf, j.this.cxx.bpb.isChecked()), new d(j.this, confirmButtonView), com.iqoption.core.d.a.aSe);
                }
            }
        }
    }

    /* compiled from: DepositPageFragmentNoBonus */
    private static class a extends com.iqoption.system.c.b<j, com.iqoption.core.microservices.billing.response.deposit.b> {
        public a(j jVar) {
            super((Object) jVar);
        }

        /* renamed from: b */
        public void z(final j jVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            i.v(j.TAG, "initCurrencies. cashboxCounting data is loaded");
            if (jVar.isAdded()) {
                jVar.aTd = bVar;
                gv b = jVar.cxv;
                gk gkVar = b.bqq;
                Object obj = 1;
                if (bVar.Td().size() <= 1) {
                    obj = null;
                }
                if (obj != null) {
                    gkVar.bpo.setVisibility(8);
                    gkVar.bpj.setVisibility(0);
                    b.bqe.brc.setText(jVar.akA());
                    b.bqe.bra.setVisibility(af.DX().Dh() ? 0 : 8);
                    LayoutParams layoutParams = (LayoutParams) b.bqe.bra.getLayoutParams();
                    if (com.iqoption.app.managers.feature.a.eW("hide-deposit-check")) {
                        b.bqe.brb.setVisibility(8);
                        layoutParams.gravity = 17;
                        b.bqe.brc.setGravity(17);
                    } else {
                        b.bqe.brb.setVisibility(0);
                        layoutParams.gravity = GravityCompat.START;
                        b.bqe.brc.setGravity(GravityCompat.START);
                    }
                    b.bqe.bra.setLayoutParams(layoutParams);
                    b.bpI.setVisibility(0);
                    gkVar.bpk.setVisibility(0);
                    gkVar.bpi.setVisibility(0);
                    Spinner spinner = gkVar.bpj;
                    spinner.setMaxHeight((int) (jVar.getContext().getResources().getDimension(R.dimen.deposit_currency_item_height) * 5.5f));
                    final SpinnerAdapter dVar = new d(spinner.getContext(), bVar);
                    spinner.setAdapter(dVar);
                    String i = jVar.cxA;
                    com.iqoption.core.microservices.billing.response.deposit.c UI = bVar.UI();
                    if (TextUtils.isEmpty(i) && UI != null) {
                        i = UI.getName();
                    }
                    a(i, bVar, spinner, dVar);
                    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }

                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                            com.iqoption.core.microservices.billing.response.deposit.c eO = dVar.getItem(i);
                            EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-page_currency-changed").setValue(Double.valueOf((double) eO.getId())).build());
                            if (jVar.cxy != null) {
                                jVar.cxy.s(Long.valueOf(eO.getId()));
                            }
                        }
                    });
                    return;
                }
                gkVar.bpo.setVisibility(0);
                gkVar.bpj.setVisibility(8);
                b.bqe.bra.setVisibility(8);
                b.bpI.setVisibility(8);
                gkVar.bpk.setVisibility(8);
                gkVar.bpi.setVisibility(8);
            }
        }

        private void a(String str, com.iqoption.core.microservices.billing.response.deposit.b bVar, Spinner spinner, d dVar) {
            for (int i = 0; i < dVar.getCount(); i++) {
                com.iqoption.core.microservices.billing.response.deposit.c eO = dVar.getItem(i);
                if (str != null) {
                    if (com.google.common.base.f.equal(eO.getName(), str)) {
                        spinner.setSelection(i);
                        return;
                    }
                } else if (bVar.UI() != null && com.google.common.base.f.equal(Long.valueOf(eO.getId()), Long.valueOf(bVar.UI().getId()))) {
                    spinner.setSelection(i);
                    return;
                }
            }
        }

        public void l(Throwable th) {
            i.e(j.TAG, "error due init currencies", th);
        }
    }

    /* compiled from: DepositPageFragmentNoBonus */
    private static class b extends com.iqoption.system.c.b<j, com.iqoption.core.microservices.billing.response.deposit.b> {
        public b(j jVar) {
            super((Object) jVar);
        }

        /* renamed from: b */
        public void z(j jVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            j jVar2 = jVar;
            i.v(j.TAG, "initBonuses. cashboxCounting data is loaded");
            if (jVar.isAdded()) {
                gv b = jVar.cxv;
                gk gkVar = b.bqq;
                Context context = jVar.getContext();
                EditText editText = gkVar.bpl;
                RecyclerView recyclerView = b.bqm;
                hl hlVar = b.bqe;
                View view = b.bpI;
                View view2 = gkVar.bpo;
                TextView textView = b.bql;
                View view3 = gkVar.bpn;
                AmountFrameViewSwitcher amountFrameViewSwitcher = gkVar.bpg;
                ArrayList j = jVar.cwM;
                double UK = bVar.UK();
                double UL = bVar.UL();
                TextView textView2 = b.bqn;
                gv gvVar = b;
                f fVar = r3;
                f fVar2 = new f(context, bVar, editText, recyclerView, hlVar, view, view2, textView, view3, amountFrameViewSwitcher, j, UK, UL, textView2);
                jVar2.cxy = fVar;
                PayMethod selectedItem = gvVar.bqt.getSelectedItem();
                if (selectedItem != null) {
                    g a = jVar2.bn(selectedItem.UQ());
                    if (!(a == null || jVar.cxy == null)) {
                        jVar.cxy.a(a);
                    }
                }
                j.a(selectedItem, jVar2);
            }
        }

        /* renamed from: a */
        public void c(j jVar, Throwable th) {
            i.e(j.TAG, "error due init bonuses", th);
        }
    }

    /* compiled from: DepositPageFragmentNoBonus */
    private static class c extends com.iqoption.system.c.b<j, com.iqoption.core.microservices.billing.response.deposit.b> {
        @Nullable
        private final Long bVn;

        public c(j jVar, @Nullable Long l) {
            super((Object) jVar);
            this.bVn = l;
        }

        /* renamed from: b */
        public void z(final j jVar, com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            i.v(j.TAG, "initPaymentMethods. cashboxCounting data is loaded");
            if (jVar.isAdded()) {
                jVar.cxv.bpI.f(false, false);
                final PayMethodSelector payMethodSelector = jVar.cxv.bqt;
                payMethodSelector.setListener(new com.iqoption.deposit.old.d() {
                    public void b(com.iqoption.deposit.old.e eVar) {
                        PayMethod aaT = eVar.aaT();
                        if (jVar.cxy != null) {
                            jVar.cxy.a(jVar.bn(aaT.UQ()));
                        }
                        j.a(aaT, jVar);
                        EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "deposit-page_payment-method-changed").setValue(Double.valueOf((double) aaT.UQ())).build());
                    }

                    public void adU() {
                        jVar.cxu.bqI.setScrollable(false);
                        TransitionManager.beginDelayedTransition((ViewGroup) payMethodSelector.getParent());
                        Context context = jVar.getContext();
                        Point K = com.iqoption.core.ext.a.K(payMethodSelector);
                        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        int dimensionPixelOffset = jVar.getResources().getDimensionPixelOffset(R.dimen.dp12);
                        payMethodSelector.getLayoutParams().height = (displayMetrics.heightPixels - K.y) - dimensionPixelOffset;
                        payMethodSelector.requestLayout();
                    }

                    public void adV() {
                        jVar.cxu.bqI.setScrollable(true);
                        TransitionManager.beginDelayedTransition((ViewGroup) payMethodSelector.getParent());
                        payMethodSelector.getLayoutParams().height = -2;
                        payMethodSelector.requestLayout();
                    }
                });
                payMethodSelector.a(bVar, this.bVn);
            }
        }

        /* renamed from: a */
        public void c(j jVar, Throwable th) {
            super.c(jVar, th);
            if (jVar.isAdded()) {
                jVar.cxv.bpI.f(false, false);
                com.iqoption.app.a.b.aT(jVar.getContext());
            }
        }

        public void l(Throwable th) {
            i.e(j.TAG, "error due init payment methods (no bonus)", th);
            com.crashlytics.android.a.log("error due init payment methods (no bonus)");
            k.c(th);
        }
    }

    /* compiled from: DepositPageFragmentNoBonus */
    private static class d extends com.iqoption.system.c.b<j, Boolean> {
        private final ConfirmButtonView bpI;

        public d(j jVar, ConfirmButtonView confirmButtonView) {
            super((Object) jVar);
            this.bpI = confirmButtonView;
        }

        /* renamed from: a */
        public void z(j jVar, Boolean bool) {
            this.bpI.f(false, false);
        }

        /* renamed from: a */
        public void c(j jVar, Throwable th) {
            this.bpI.f(false, false);
            i.e(j.TAG, "processing error", th);
            MobbErrorException.D(th);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_DEFAULT_PRESET");
        cxr = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_CURRENCY");
        ARG_CURRENCY = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_IS_3DS_ONLY");
        cxs = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_PAYMENT_METHOD_ID");
        cxt = stringBuilder.toString();
    }

    public static j a(@Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, String str, boolean z, @Nullable Long l) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(cxr, arrayList);
        bundle.putString(ARG_CURRENCY, str);
        bundle.putBoolean(cxs, z);
        if (l != null) {
            bundle.putLong(cxt, l.longValue());
        }
        jVar.setArguments(bundle);
        return jVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cwM = bundle.getParcelableArrayList(cxr);
            this.cxA = bundle.getString(ARG_CURRENCY);
            this.cxz = bundle.getBoolean(cxs);
            if (bundle.containsKey(cxt)) {
                this.bVn = Long.valueOf(bundle.getLong(cxt));
            }
        }
        com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("experimental-deposit-page");
        boolean z = fd != null && "old-unfolded-page".equals(fd.status);
        this.cxB = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cxu = (gz) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_page_old, viewGroup, false);
        this.cxv = (gv) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_page_content_no_bonus_old, this.cxu.bqI, true);
        this.cxw = this.cxv.bqq;
        this.cxx = this.cxv.bqp;
        this.cxv.bpI.f(true, false);
        s iL = com.iqoption.mobbtech.connect.response.a.a.ava().iL("DepositPageFragmentNoBonus");
        g(iL);
        h(iL);
        i(iL);
        OnClickListener eVar = new e(this, null);
        this.cxv.bpI.setOnClickListener(eVar);
        this.cxv.bqq.bpo.setOnClickListener(eVar);
        this.cxu.boF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                com.iqoption.activity.b ajV = j.this.ajV();
                if (ajV == null || !ajV.zN()) {
                    f a = j.this.akz();
                    if (a != null) {
                        a.aav();
                    }
                    return;
                }
                am.a(j.this.zzakw(), view);
            }
        });
        this.cxv.bqe.brc.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                j.this.getFragmentManager().beginTransaction().add(R.id.fragment, com.iqoption.dialog.s.hm("terms-regulated"), "TermsDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("TermsDialog").commit();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deposit_terms").build());
            }
        });
        aky();
        return this.cxu.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cxv.bqt.cz(this.cxB);
    }

    public void aky() {
        OnClickListener anonymousClass3 = new OnClickListener() {
            public void onClick(View view) {
                PopupWindow a = j.this.c(j.this.getContext(), view);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                final View contentView = a.getContentView();
                i -= contentView.getMeasuredWidth();
                i2 = (int) (((double) i2) - ((((double) contentView.getMeasuredHeight()) * 0.5d) - (((double) view.getHeight()) * 0.5d)));
                contentView.setAlpha(0.0f);
                contentView.animate().alpha(1.0f);
                j.this.cxv.bqo.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        contentView.performClick();
                    }
                });
                j.this.cxv.bqo.setVisibility(0);
                a.showAtLocation(view, 0, i, i2);
            }
        };
        this.cxv.bqp.bpd.setOnClickListener(anonymousClass3);
        this.cxv.bqp.bpe.setOnClickListener(anonymousClass3);
    }

    private PopupWindow c(Context context, View view) {
        final PopupWindow popupWindow = new PopupWindow(context);
        if (!(view instanceof ViewGroup)) {
            view = view.getParent();
        }
        View inflate = getLayoutInflater().inflate(R.layout.deposit_card_3ds_description_popup, (ViewGroup) view, false);
        int dimension = (int) getResources().getDimension(R.dimen.deposit_3d_description_popup_width);
        inflate.measure(MeasureSpec.makeMeasureSpec(dimension, 1073741824), 0);
        inflate.setMinimumHeight(inflate.getMeasuredHeight());
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setHeight(-2);
        popupWindow.setWidth(dimension);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        popupWindow.dismiss();
                        j.this.cxv.bqo.setVisibility(8);
                    }
                });
            }
        });
        return popupWindow;
    }

    public void onResume() {
        super.onResume();
        this.cxf = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "deposit-page");
    }

    public void onPause() {
        super.onPause();
        EventManager.Bm().a(this.cxf.calcDuration().build());
    }

    private void g(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        o.a(sVar, new c(this, this.bVn), com.iqoption.core.d.a.aSe);
    }

    private void h(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        o.a(sVar, new a(this), com.iqoption.core.d.a.aSe);
    }

    private void i(s<com.iqoption.core.microservices.billing.response.deposit.b> sVar) {
        o.a(sVar, new b(this), com.iqoption.core.d.a.aSe);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private f akz() {
        if (getContext() instanceof f) {
            return (f) getContext();
        }
        return getTargetFragment() instanceof f ? (f) getTargetFragment() : null;
    }

    public void onDetach() {
        super.onDetach();
    }

    private g bn(long j) {
        if (this.aTd != null) {
            Iterator it = this.aTd.UH().iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.UQ() == j) {
                    return gVar;
                }
            }
        }
        return null;
    }

    private CharSequence akA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<u><font color=#6d6e70>");
        stringBuilder.append(getString(R.string.conditions_and_provisions));
        stringBuilder.append("</u>");
        String stringBuilder2 = stringBuilder.toString();
        return Html.fromHtml(getString(com.iqoption.app.managers.feature.a.eW("hide-deposit-check") ? R.string.by_clicking_deposit_you_confirm_n1 : R.string.i_hereby_accept, stringBuilder2));
    }

    private void g(boolean z, boolean z2) {
        if (z) {
            this.cxx.bpa.setVisibility(0);
            String bi = be.bi(getContext());
            if ("hdpi".equals(bi) || "mdpi".equals(bi)) {
                this.cxx.bpd.setVisibility(4);
                this.cxx.bpe.setVisibility(0);
            } else {
                this.cxx.bpe.setVisibility(4);
                this.cxx.bpd.setVisibility(0);
            }
            this.cxx.bpb.setChecked(z2);
            return;
        }
        this.cxx.bpa.setVisibility(8);
        this.cxx.bpb.setChecked(false);
        this.cxx.bpe.setVisibility(8);
        this.cxx.bpd.setVisibility(8);
    }

    private static void a(PayMethod payMethod, j jVar) {
        boolean z = false;
        if (payMethod == null || payMethod.UW() == -1) {
            jVar.g(false, false);
        } else if (jVar.cxz) {
            jVar.g(true, true);
        } else {
            boolean aOa = com.iqoption.withdrawal.crypto.a.aOa();
            if (payMethod.UV() || jVar.cxz) {
                z = true;
            }
            jVar.g(aOa, z);
        }
    }
}
