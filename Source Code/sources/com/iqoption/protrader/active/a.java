package com.iqoption.protrader.active;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.d.qd;
import com.iqoption.dto.Event;
import com.iqoption.fragment.base.f;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/protrader/active/ProTraderActiveFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "activeType", "Lcom/iqoption/core/data/model/ActiveType;", "getActiveType", "()Lcom/iqoption/core/data/model/ActiveType;", "activeType$delegate", "Lkotlin/Lazy;", "binding", "Lcom/iqoption/databinding/FragmentProTraderActiveBinding;", "viewModel", "Lcom/iqoption/protrader/active/ProTraderActiveViewModel;", "learnMore", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "prepareText", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderActiveFragment.kt */
public final class a extends f {
    private static final String TAG = "com.iqoption.protrader.active.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "activeType", "getActiveType()Lcom/iqoption/core/data/model/ActiveType;"))};
    public static final a ddY = new a();
    private HashMap atz;
    private final d ddV = g.f(new ProTraderActiveFragment$activeType$2(this));
    private qd ddW;
    private ProTraderActiveViewModel ddX;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J(\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/protrader/active/ProTraderActiveFragment$Companion;", "", "()V", "ARG_ACTIVE_TYPE", "", "TAG", "kotlin.jvm.PlatformType", "findExistedFragment", "Landroid/support/v4/app/Fragment;", "fm", "Landroid/support/v4/app/FragmentManager;", "remove", "", "showIfNeeded", "activity", "Landroid/support/v4/app/FragmentActivity;", "containerId", "", "activeType", "Lcom/iqoption/core/data/model/ActiveType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderActiveFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, int i, ActiveType activeType) {
            h.e(fragmentActivity, "activity");
            h.e(fragmentManager, "fm");
            h.e(activeType, "activeType");
            if (ProTraderActiveViewModel.ddZ.t(fragmentActivity).ayC()) {
                a aVar = new a();
                Bundle bundle = new Bundle();
                bundle.putSerializable("ARG_ACTIVE_TYPE", activeType);
                aVar.setArguments(bundle);
                fragmentManager.beginTransaction().replace(i, aVar, a.TAG).commitAllowingStateLoss();
                return;
            }
            h(fragmentManager);
        }

        public final void h(FragmentManager fragmentManager) {
            h.e(fragmentManager, "fm");
            Fragment o = o(fragmentManager);
            if (o != null) {
                View view = o.getView();
                if (view != null) {
                    com.iqoption.core.ext.a.M(view);
                }
                fragmentManager.beginTransaction().remove(o).commitAllowingStateLoss();
            }
        }

        private final Fragment o(FragmentManager fragmentManager) {
            return fragmentManager.findFragmentByTag(a.TAG);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderActiveFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.ayw();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ProTraderActiveFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ a this$0;

        c(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "change-asset_become-pro-close"));
            a.b(this.this$0).ayD();
            com.iqoption.core.ext.a.p(this.this$0).beginTransaction().remove(this.this$0).commitNowAllowingStateLoss();
        }
    }

    public static final void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, int i, ActiveType activeType) {
        ddY.a(fragmentActivity, fragmentManager, i, activeType);
    }

    private final ActiveType getActiveType() {
        d dVar = this.ddV;
        j jVar = apP[0];
        return (ActiveType) dVar.getValue();
    }

    public static final void h(FragmentManager fragmentManager) {
        ddY.h(fragmentManager);
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

    public static final /* synthetic */ ProTraderActiveViewModel b(a aVar) {
        ProTraderActiveViewModel proTraderActiveViewModel = aVar.ddX;
        if (proTraderActiveViewModel == null) {
            h.lS("viewModel");
        }
        return proTraderActiveViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.ddW = (qd) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_pro_trader_active, viewGroup, false, 4, null);
        qd qdVar = this.ddW;
        if (qdVar == null) {
            h.lS("binding");
        }
        return qdVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ProTraderActiveViewModel t = ProTraderActiveViewModel.ddZ.t(com.iqoption.core.ext.a.n(this));
        h.d(t, "ProTraderActiveViewModel.create(act)");
        this.ddX = t;
        ayu();
        qd qdVar = this.ddW;
        if (qdVar == null) {
            h.lS("binding");
        }
        qdVar.bAz.setOnClickListener(new b(this));
        qdVar = this.ddW;
        if (qdVar == null) {
            h.lS("binding");
        }
        qdVar.bAy.setOnClickListener(new c(this));
    }

    private final void ayu() {
        String valueOf = String.valueOf(500);
        String e = com.iqoption.util.e.a.e(getActiveType());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.leverages_up_to_n1_available_n2, valueOf, e));
        spannableStringBuilder.append(" ");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getString(R.string.learn_more));
        Drawable drawable = ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), R.drawable.ic_arrow_forward_white_6);
        if (drawable == null) {
            h.aXZ();
        }
        h.d(drawable, "drawable");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 0);
        spannableStringBuilder2.append(" ");
        spannableStringBuilder2.setSpan(imageSpan, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 17);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(com.iqoption.core.ext.a.m(this), R.color.white)), 0, spannableStringBuilder2.length(), 17);
        spannableStringBuilder.append(spannableStringBuilder2);
        qd qdVar = this.ddW;
        if (qdVar == null) {
            h.lS("binding");
        }
        TextView textView = qdVar.bAA;
        h.d(textView, "binding.proActiveText");
        textView.setText(spannableStringBuilder);
    }

    private final void ayw() {
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "change-asset_become-pro-learn-more"));
        com.iqoption.protrader.dialog.a.ded.u(com.iqoption.core.ext.a.n(this));
    }
}
