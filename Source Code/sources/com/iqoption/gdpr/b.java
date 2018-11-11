package com.iqoption.gdpr;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.in;
import com.iqoption.dto.Event;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.popup.PopupPriority;
import com.iqoption.util.af;
import com.iqoption.util.bg;
import com.iqoption.view.a.a.d;
import com.iqoption.view.text.l;
import com.iqoption.view.text.o;
import com.iqoption.view.text.p;
import com.iqoption.view.text.q;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/gdpr/GdprWarningDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/DialogGdprWarningBinding;", "viewModel", "Lcom/iqoption/gdpr/GdprViewModel;", "acceptAgreement", "", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "reportAnalyticsButtonPressed", "eventName", "", "reportAnalyticsShown", "setConfirmButton", "setConfirmButtonState", "progress", "setMessage", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: GdprWarningDialog.kt */
public final class b extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.gdpr.b";
    public static final a cIk = new a();
    private HashMap atz;
    private in cIi;
    private GdprViewModel cIj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/gdpr/GdprWarningDialog$Companion;", "", "()V", "TAG", "", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "tryShow", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: GdprWarningDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: GdprWarningDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                a aVar = b.cIk;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.e(fragmentManager);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void n(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            PopupViewModel j = PopupViewModel.cBp.j(fragmentActivity);
            if (!j.hP(b.TAG)) {
                j.a((Runnable) new a(supportFragmentManager), b.TAG, PopupPriority.VERY_HIGH);
            }
        }

        private final void e(FragmentManager fragmentManager) {
            fragmentManager.beginTransaction().replace(R.id.other_fragment, new b(), b.TAG).addToBackStack(b.TAG).commitAllowingStateLoss();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: GdprWarningDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ b this$0;

        b(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            this.this$0.aom();
            this.this$0.hS("gdpr_update-terms-ok");
        }
    }

    public static final void n(FragmentActivity fragmentActivity) {
        cIk.n(fragmentActivity);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (b.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cIi = (in) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_gdpr_warning, viewGroup, false, 4, null);
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        return inVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        GdprViewModel m = GdprViewModel.cIh.m(com.iqoption.core.ext.a.n(this));
        h.d(m, "GdprViewModel.create(act)");
        this.cIj = m;
        aok();
        aol();
        if (bundle == null) {
            aon();
        }
    }

    private final void aok() {
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        TextView textView = inVar.bsl;
        String string = getString(R.string.terms_and_conditions);
        h.d(string, "getString(R.string.terms_and_conditions)");
        l lVar = new l(string, q.bZ(com.iqoption.core.ext.a.m(this)));
        String string2 = getString(R.string.privacy_policy);
        h.d(string2, "getString(R.string.privacy_policy)");
        l lVar2 = new l(string2, q.ca(com.iqoption.core.ext.a.m(this)));
        string2 = getString(R.string.update_of_terms_future_description_p1_p2, lVar.getText(), lVar2.getText());
        h.d(textView, "textView");
        h.d(string2, "text");
        l[] lVarArr = new l[]{lVar, lVar2};
        o.a(new p(lVarArr, textView, string2, 0, 0, null, 56, null));
    }

    private final void aol() {
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        inVar.bse.setOnClickListener(new b(this));
    }

    private final void aom() {
        dG(true);
        GdprViewModel gdprViewModel = this.cIj;
        if (gdprViewModel == null) {
            h.lS("viewModel");
        }
        af.a(gdprViewModel.b(new com.iqoption.core.microservices.busapi.response.b(Boolean.valueOf(true), null, null, null, null, 30, null)), new GdprWarningDialog$acceptAgreement$1(this), new GdprWarningDialog$acceptAgreement$2(this), null, 4, null);
    }

    private final void dG(boolean z) {
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        TextView textView = inVar.bse;
        h.d(textView, "binding.gdprConfirm");
        textView.setEnabled(z ^ 1);
        in inVar2;
        if (z) {
            inVar2 = this.cIi;
            if (inVar2 == null) {
                h.lS("binding");
            }
            inVar2.bsf.show();
            return;
        }
        inVar2 = this.cIi;
        if (inVar2 == null) {
            h.lS("binding");
        }
        inVar2.bsf.hide();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public void ND() {
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(inVar.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66));
        h.d(c, "background");
        c.setInterpolator(d.dEM);
        in inVar2 = this.cIi;
        if (inVar2 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(inVar2.bsg, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator(2.5f));
        in inVar3 = this.cIi;
        if (inVar3 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(inVar3.bsg, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        in inVar = this.cIi;
        if (inVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(inVar.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        in inVar2 = this.cIi;
        if (inVar2 == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = inVar2.bsg;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }

    private final void aon() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "gdpr_update-terms").build());
    }

    private final void hS(String str) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str).build());
    }
}
