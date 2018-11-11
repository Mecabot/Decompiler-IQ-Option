package com.iqoption.protrader.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.jl;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.protrader.web.ProTraderWebActivity;
import com.iqoption.protrader.web.ProTraderWebType;
import com.iqoption.util.bg;
import com.iqoption.view.text.l;
import com.iqoption.view.text.o;
import com.iqoption.view.text.p;
import com.iqoption.view.text.q;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/protrader/dialog/ProTraderSelectedDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/DialogProTraderSelectedBinding;", "event", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "applyNow", "", "learnMore", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "prepareText", "reportClick", "", "showBouncing", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderSelectedDialog.kt */
public final class d extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.protrader.dialog.d";
    public static final a dei = new a();
    private Builder ajG;
    private HashMap atz;
    private jl deh;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/protrader/dialog/ProTraderSelectedDialog$Companion;", "", "()V", "TAG", "", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "", "fm", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderSelectedDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: ProTraderSelectedDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                a aVar = d.dei;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.p(fragmentManager);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void u(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            PopupViewModel j = PopupViewModel.cBp.j(fragmentActivity);
            if (!j.hP(d.TAG)) {
                j.a((Runnable) new a(supportFragmentManager), d.TAG);
            }
        }

        private final boolean p(FragmentManager fragmentManager) {
            fragmentManager.beginTransaction().replace(R.id.other_fragment, new d(), d.TAG).addToBackStack(d.TAG).commitAllowingStateLoss();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderSelectedDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ d dej;

        b(d dVar) {
            this.dej = dVar;
        }

        public final void onClick(View view) {
            this.dej.aey();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderSelectedDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ d dej;

        c(d dVar) {
            this.dej = dVar;
        }

        public final void onClick(View view) {
            this.dej.iX("pro-traders-eligibility_close");
            this.dej.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderSelectedDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ d dej;

        d(d dVar) {
            this.dej = dVar;
        }

        public final void onClick(View view) {
            this.dej.ayw();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderSelectedDialog.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ d dej;

        e(d dVar) {
            this.dej = dVar;
        }

        public final void onClick(View view) {
            this.dej.ayx();
        }
    }

    public static final void u(FragmentActivity fragmentActivity) {
        dei.u(fragmentActivity);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    static {
        if (d.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.deh = (jl) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_pro_trader_selected, viewGroup, false, 4, null);
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        return jlVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ayu();
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        jlVar.bjF.setOnClickListener(new b(this));
        jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        jlVar.btB.setOnClickListener(new c(this));
        jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        jlVar.btD.setOnClickListener(new d(this));
        jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        jlVar.btA.setOnClickListener(new e(this));
        this.ajG = Event.Builder(Event.CATEGORY_POPUP_SERVED, "pro-traders-eligibility_show");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.ajG;
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
        KH();
    }

    private final void ayu() {
        String string = getString(R.string.esma_measures);
        String string2 = getString(R.string.high_risk_options_instruments);
        String string3 = getString(R.string.up_to_xn1, String.valueOf(500));
        String string4 = getString(R.string.n1_are_coming_into_force_soon_n2_n3, string, string2, string3);
        CharSequence charSequence = string4;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        h.d(string4, "text");
        h.d(string2, "highRisk");
        int a = v.a(charSequence, string2, 0, false, 6, null);
        spannableStringBuilder.setSpan(new StyleSpan(1), a, string2.length() + a, 33);
        h.d(string3, "upTo");
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        string2 = string3;
        a = v.a(charSequence, string3, 0, false, 6, null);
        spannableStringBuilder2.setSpan(new StyleSpan(1), a, string2.length() + a, 33);
        h.d(string, "measures");
        l lVar = new l(string, q.o(com.iqoption.core.ext.a.m(this), R.string.blog_link_n1));
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        TextView textView = jlVar.btE;
        h.d(textView, "binding.proSelectedText");
        l[] lVarArr = new l[]{lVar};
        o.a(new p(lVarArr, textView, spannableStringBuilder2, 0, 0, null, 56, null));
    }

    private final void aey() {
        Context context = getContext();
        if (context == null) {
            h.aXZ();
        }
        int bQ = com.iqoption.util.b.bQ(context);
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        com.iqoption.util.b.o(jlVar.btC, bQ);
    }

    private final void ayw() {
        iX("pro-traders-eligibility_learn-more");
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.MOR_INFO);
    }

    private final void ayx() {
        iX("pro-traders-eligibility_check-now");
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.APPLY);
        onClose();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public void ND() {
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jlVar.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66));
        h.d(c, "background");
        c.setInterpolator(com.iqoption.view.a.a.d.dEM);
        jl jlVar2 = this.deh;
        if (jlVar2 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(jlVar2.btC, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator(2.5f));
        jl jlVar3 = this.deh;
        if (jlVar3 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jlVar3.btC, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        jl jlVar = this.deh;
        if (jlVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jlVar.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        jl jlVar2 = this.deh;
        if (jlVar2 == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = jlVar2.btC;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    private final void iX(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).build());
    }
}
