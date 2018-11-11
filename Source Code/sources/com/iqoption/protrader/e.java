package com.iqoption.protrader;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.qf;
import com.iqoption.dto.Event;
import com.iqoption.fragment.base.f;
import com.iqoption.protrader.web.ProTraderWebActivity;
import com.iqoption.protrader.web.ProTraderWebType;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/protrader/ProTraderMoreFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentProTraderMoreBinding;", "applyNow", "", "learnMore", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "prepareText", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderMoreFragment.kt */
public final class e extends f {
    private static final String TAG = "com.iqoption.protrader.e";
    public static final a ddQ = new a();
    private HashMap atz;
    private qf ddP;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/protrader/ProTraderMoreFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "remove", "", "fm", "Landroid/support/v4/app/FragmentManager;", "show", "containerId", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderMoreFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentManager fragmentManager, int i) {
            h.e(fragmentManager, "fm");
            fragmentManager.beginTransaction().replace(i, new e(), e.TAG).commitAllowingStateLoss();
        }

        public final void h(FragmentManager fragmentManager) {
            h.e(fragmentManager, "fm");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(e.TAG);
            if (findFragmentByTag != null) {
                View view = findFragmentByTag.getView();
                if (view != null) {
                    com.iqoption.core.ext.a.M(view);
                }
                fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderMoreFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ e ddR;

        b(e eVar) {
            this.ddR = eVar;
        }

        public final void onClick(View view) {
            this.ddR.ayw();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderMoreFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ e ddR;

        c(e eVar) {
            this.ddR = eVar;
        }

        public final void onClick(View view) {
            this.ddR.ayx();
        }
    }

    public static final void a(FragmentManager fragmentManager, int i) {
        ddQ.a(fragmentManager, i);
    }

    public static final void h(FragmentManager fragmentManager) {
        ddQ.h(fragmentManager);
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.ddP = (qf) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_pro_trader_more, viewGroup, false, 4, null);
        qf qfVar = this.ddP;
        if (qfVar == null) {
            h.lS("binding");
        }
        return qfVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ayu();
        String valueOf = String.valueOf(500);
        qf qfVar = this.ddP;
        if (qfVar == null) {
            h.lS("binding");
        }
        TextView textView = qfVar.bAC;
        h.d(textView, "binding.proMoreAccessToLeverages");
        textView.setText(getString(R.string.access_to_higher_leverages_n1, valueOf));
        qf qfVar2 = this.ddP;
        if (qfVar2 == null) {
            h.lS("binding");
        }
        qfVar2.bAE.setOnClickListener(new b(this));
        qfVar2 = this.ddP;
        if (qfVar2 == null) {
            h.lS("binding");
        }
        qfVar2.bAD.setOnClickListener(new c(this));
    }

    private final void ayw() {
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "change-asset_more-learn-more"));
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.MOR_INFO);
    }

    private final void ayx() {
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "change-asset_more-apply-now"));
        ProTraderWebActivity.dek.a(com.iqoption.core.ext.a.n(this), ProTraderWebType.APPLY);
    }

    private final void ayu() {
        String str = "*PRO_BADGE_ANCHOR*";
        String string = getString(R.string.this_feature_available_for_our_professional_n1, str);
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        Drawable drawable = ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), R.drawable.ic_pro_badge);
        if (drawable == null) {
            h.aXZ();
        }
        h.d(drawable, "drawable");
        com.iqoption.view.text.e eVar = new com.iqoption.view.text.e(drawable, getResources().getDimensionPixelSize(R.dimen.dp32), getResources().getDimensionPixelSize(R.dimen.dp14));
        h.d(string, "text");
        int a = v.a(charSequence, str, 0, false, 6, null);
        spannableString.setSpan(eVar, a, str.length() + a, 17);
        qf qfVar = this.ddP;
        if (qfVar == null) {
            h.lS("binding");
        }
        TextView textView = qfVar.bAF;
        h.d(textView, "binding.proMoreText");
        textView.setText(spannableString);
    }
}
