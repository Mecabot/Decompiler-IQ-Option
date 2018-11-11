package com.iqoption.protrader.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.jj;
import com.iqoption.d.wv;
import com.iqoption.d.wx;
import com.iqoption.d.wz;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.protrader.web.ProTraderWebActivity;
import com.iqoption.protrader.web.ProTraderWebType;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/protrader/dialog/ProTraderBenefitsDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "avatarTransformation", "Lcom/iqoption/core/ui/picasso/CircleTransformation;", "binding", "Lcom/iqoption/databinding/DialogProTraderBenefitsBinding;", "bottomRow", "Lcom/iqoption/databinding/LayoutProTraderBenefitsBottomRowBinding;", "event", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "topRow", "Lcom/iqoption/databinding/LayoutProTraderBenefitsTopRowBinding;", "applyNow", "", "initAvatar", "initToolbar", "learnMore", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "reportClick", "", "showBouncing", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderBenefitsDialog.kt */
public final class a extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.protrader.dialog.a";
    public static final a ded = new a();
    private final com.iqoption.core.ui.picasso.a aDH = new com.iqoption.core.ui.picasso.a();
    private Builder ajG;
    private HashMap atz;
    private jj dea;
    private wz deb;
    private wx dec;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/protrader/dialog/ProTraderBenefitsDialog$Companion;", "", "()V", "TAG", "", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "", "fm", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderBenefitsDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: ProTraderBenefitsDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                a aVar = a.ded;
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
            if (!j.hP(a.TAG)) {
                j.a((Runnable) new a(supportFragmentManager), a.TAG);
            }
        }

        private final boolean p(FragmentManager fragmentManager) {
            fragmentManager.beginTransaction().replace(R.id.other_fragment, new a(), a.TAG).addToBackStack(a.TAG).commitAllowingStateLoss();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderBenefitsDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a dee;

        b(a aVar) {
            this.dee = aVar;
        }

        public final void onClick(View view) {
            this.dee.iX("pro-traders-intro_close");
            this.dee.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderBenefitsDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ a dee;

        c(a aVar) {
            this.dee = aVar;
        }

        public final void onClick(View view) {
            this.dee.aey();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderBenefitsDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ a dee;

        d(a aVar) {
            this.dee = aVar;
        }

        public final void onClick(View view) {
            this.dee.ayw();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderBenefitsDialog.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ a dee;

        e(a aVar) {
            this.dee = aVar;
        }

        public final void onClick(View view) {
            this.dee.ayx();
        }
    }

    public static final void u(FragmentActivity fragmentActivity) {
        ded.u(fragmentActivity);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dea = (jj) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_pro_trader_benefits, viewGroup, false, 4, null);
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        wz wzVar = jjVar.bty;
        h.d(wzVar, "binding.proBenefitsTopRow");
        this.deb = wzVar;
        jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        wx wxVar = jjVar.btv;
        h.d(wxVar, "binding.proBenefitsBottomRow");
        this.dec = wxVar;
        jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        return jjVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        view.setLayerType(1, null);
        apX();
        ayE();
        wz wzVar = this.deb;
        if (wzVar == null) {
            h.lS("topRow");
        }
        TextView textView = wzVar.bKb;
        h.d(textView, "topRow.proBenefitsCurrentType");
        textView.setText(getString(R.string.your_type_n1, getString(R.string.retail)));
        String string = getString(R.string.access_to_higher_leverages_n1, String.valueOf(500));
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        TextView textView2 = jjVar.btu;
        h.d(textView2, "binding.proBenefitsAccessToHigherLeverages");
        textView2.setText(string);
        jj jjVar2 = this.dea;
        if (jjVar2 == null) {
            h.lS("binding");
        }
        jjVar2.bjF.setOnClickListener(new c(this));
        wx wxVar = this.dec;
        if (wxVar == null) {
            h.lS("bottomRow");
        }
        wxVar.bJV.setOnClickListener(new d(this));
        wxVar = this.dec;
        if (wxVar == null) {
            h.lS("bottomRow");
        }
        wxVar.bJY.setOnClickListener(new e(this));
        this.ajG = Event.Builder(Event.CATEGORY_POPUP_SERVED, "pro-traders-intro_show");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.ajG;
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
        KH();
    }

    private final void apX() {
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        wv wvVar = jjVar.btx;
        wvVar.bJU.setText(R.string.introducing_account_categories);
        wvVar.bJT.setOnClickListener(new b(this));
    }

    private final void ayE() {
        com.iqoption.core.microservices.avatar.d ai;
        wz wzVar = this.deb;
        if (wzVar == null) {
            h.lS("topRow");
        }
        ImageView imageView = wzVar.bKa;
        com.iqoption.core.microservices.avatar.a avatar = com.iqoption.app.a.aL(com.iqoption.core.ext.a.m(this)).getAvatar();
        if (avatar != null) {
            h.d(imageView, "imageView");
            ai = avatar.ai(imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
        } else {
            ai = null;
        }
        if (ai != null) {
            RequestCreator load = Picasso.with(com.iqoption.core.ext.a.m(this)).load(ai.getUrl());
            Drawable drawable = AppCompatResources.getDrawable(com.iqoption.core.ext.a.m(this), R.drawable.ic_avatar_placeholder);
            if (drawable != null) {
                load.placeholder(drawable);
            }
            load.transform((Transformation) this.aDH).fit().into(imageView);
            return;
        }
        imageView.setImageResource(R.drawable.ic_avatar_placeholder);
    }

    private final void ayw() {
        iX("pro-traders-intro_learn-more");
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.MOR_INFO);
    }

    private final void ayx() {
        iX("pro-traders-intro_apply-now");
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.APPLY);
        onClose();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    private final void aey() {
        Context context = getContext();
        if (context == null) {
            h.aXZ();
        }
        int bQ = com.iqoption.util.b.bQ(context);
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        com.iqoption.util.b.o(jjVar.btw, bQ);
    }

    public void ND() {
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jjVar.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66));
        h.d(c, "background");
        c.setInterpolator(com.iqoption.view.a.a.d.dEM);
        jj jjVar2 = this.dea;
        if (jjVar2 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(jjVar2.btw, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator(2.5f));
        jj jjVar3 = this.dea;
        if (jjVar3 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jjVar3.btw, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        jj jjVar = this.dea;
        if (jjVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jjVar.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        jj jjVar2 = this.dea;
        if (jjVar2 == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = jjVar2.btw;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r2);
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
