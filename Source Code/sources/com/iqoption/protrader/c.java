package com.iqoption.protrader;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.jh;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.protrader.web.ProTraderWebActivity;
import com.iqoption.protrader.web.ProTraderWebType;
import com.iqoption.util.at;
import com.iqoption.util.bg;
import com.iqoption.view.text.e;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, aXE = {"Lcom/iqoption/protrader/ProTraderApplicationStatusDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/DialogProApplicationStatusBinding;", "event", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "statusType", "Lcom/iqoption/microservice/regulators/response/StatusType;", "getStatusType", "()Lcom/iqoption/microservice/regulators/response/StatusType;", "statusType$delegate", "Lkotlin/Lazy;", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "prepareText", "prepareTitle", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderApplicationStatusDialog.kt */
public final class c extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.protrader.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "statusType", "getStatusType()Lcom/iqoption/microservice/regulators/response/StatusType;"))};
    public static final a ddO = new a();
    private Builder ajG;
    private HashMap atz;
    private final kotlin.d ddM = g.f(new ProTraderApplicationStatusDialog$statusType$2(this));
    private jh ddN;

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/protrader/ProTraderApplicationStatusDialog$Companion;", "", "()V", "ARG_STATUS_TYPE", "", "TAG", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "statusType", "Lcom/iqoption/microservice/regulators/response/StatusType;", "", "fm", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderApplicationStatusDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: ProTraderApplicationStatusDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;
            final /* synthetic */ StatusType cCV;

            a(FragmentManager fragmentManager, StatusType statusType) {
                this.cBh = fragmentManager;
                this.cCV = statusType;
            }

            public final void run() {
                a aVar = c.ddO;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.a(fragmentManager, this.cCV);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, StatusType statusType) {
            h.e(fragmentActivity, "activity");
            h.e(statusType, "statusType");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            PopupViewModel j = PopupViewModel.cBp.j(fragmentActivity);
            if (!j.hP(c.TAG)) {
                j.a((Runnable) new a(supportFragmentManager, statusType), c.TAG);
            }
        }

        private final boolean a(FragmentManager fragmentManager, StatusType statusType) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARG_STATUS_TYPE", statusType);
            cVar.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.other_fragment, cVar, c.TAG).addToBackStack(c.TAG).commitAllowingStateLoss();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderApplicationStatusDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ c this$0;

        b(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderApplicationStatusDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ c this$0;

        c(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderApplicationStatusDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ c this$0;

        d(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            if (this.this$0.ata() == StatusType.DECLINED) {
                ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this.this$0), ProTraderWebType.APPLY);
            } else {
                this.this$0.onClose();
            }
        }
    }

    public static final void a(FragmentActivity fragmentActivity, StatusType statusType) {
        ddO.a(fragmentActivity, statusType);
    }

    private final StatusType ata() {
        kotlin.d dVar = this.ddM;
        j jVar = apP[0];
        return (StatusType) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    static {
        if (c.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.ddN = (jh) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_pro_application_status, viewGroup, false, 4, null);
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        return jhVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ayt();
        ayu();
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        jhVar.bjF.setOnClickListener(new b(this));
        jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        jhVar.btr.setOnClickListener(new c(this));
        jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        jhVar.btr.setOnClickListener(new d(this));
        switch (ata()) {
            case APPROVED:
                str = "pro-traders-approved_show";
                break;
            case DECLINED:
                str = "pro-traders-declined_show";
                break;
            default:
                at.bJ(ata());
                throw null;
        }
        this.ajG = Event.Builder(Event.CATEGORY_POPUP_SERVED, str);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.ajG;
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
        KH();
    }

    private final void ayt() {
        CharSequence charSequence;
        switch (ata()) {
            case APPROVED:
                String string = getString(R.string.you_are_a);
                h.d(string, "getString(R.string.you_are_a)");
                if (string != null) {
                    string = string.toUpperCase();
                    h.d(string, "(this as java.lang.String).toUpperCase()");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    spannableStringBuilder.append("  ");
                    Drawable drawable = ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), R.drawable.ic_pro_badge);
                    if (drawable == null) {
                        h.aXZ();
                    }
                    h.d(drawable, "drawable");
                    e eVar = new e(drawable, getResources().getDimensionPixelSize(R.dimen.dp32), getResources().getDimensionPixelSize(R.dimen.dp14));
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.setSpan(eVar, length - 1, length, 17);
                    charSequence = spannableStringBuilder;
                    break;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            case DECLINED:
                String string2 = getString(R.string.application_declined);
                h.d(string2, "getString(R.string.application_declined)");
                charSequence = string2;
                break;
            default:
                at.bJ(ata());
                throw null;
        }
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        TextView textView = jhVar.btt;
        h.d(textView, "binding.proApplicationStatusTitle");
        textView.setText(charSequence);
    }

    private final void ayu() {
        CharSequence charSequence;
        String string;
        switch (ata()) {
            case APPROVED:
                string = getString(R.string.now_you_are_pro);
                h.d(string, "getString(R.string.now_you_are_pro)");
                charSequence = string;
                break;
            case DECLINED:
                string = "*PRO_BADGE_ANCHOR*";
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.your_application_for_n1_declined, string));
                Drawable drawable = ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), R.drawable.ic_pro_badge);
                if (drawable == null) {
                    h.aXZ();
                }
                h.d(drawable, "drawable");
                e eVar = new e(drawable, getResources().getDimensionPixelSize(R.dimen.dp23), getResources().getDimensionPixelSize(R.dimen.dp10));
                charSequence = spannableStringBuilder;
                int a = v.a(charSequence, string, 0, false, 6, null);
                spannableStringBuilder.setSpan(eVar, a, string.length() + a, 17);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getString(R.string.learn_more));
                spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 17);
                spannableStringBuilder.append(" ");
                spannableStringBuilder.append(spannableStringBuilder2);
                break;
            default:
                at.bJ(ata());
                throw null;
        }
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        TextView textView = jhVar.bts;
        h.d(textView, "binding.proApplicationStatusText");
        textView.setText(charSequence);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public void ND() {
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(jhVar.btr, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator(2.5f));
        jh jhVar2 = this.ddN;
        if (jhVar2 == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jhVar2.btr, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        jh jhVar = this.ddN;
        if (jhVar == null) {
            h.lS("binding");
        }
        Animator c = com.iqoption.view.a.a.a.c(jhVar.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        jh jhVar2 = this.ddN;
        if (jhVar2 == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = jhVar2.btr;
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
}
