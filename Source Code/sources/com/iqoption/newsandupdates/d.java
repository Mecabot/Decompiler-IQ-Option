package com.iqoption.newsandupdates;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.ov;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.g;
import com.iqoption.util.af;
import com.iqoption.util.ar;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J!\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0)H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/newsandupdates/NewsAndUpdatesFragment;", "Lcom/iqoption/fragment/base/IQMenuFragment;", "Lcom/iqoption/newsandupdates/Listener;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "adapter", "Lcom/iqoption/newsandupdates/NewsAndUpdatesAdapter;", "binding", "Lcom/iqoption/databinding/FragmentNewsAndUpdatesBinding;", "viewModel", "Lcom/iqoption/newsandupdates/NewsAndUpdatesViewModel;", "getContentView", "Landroid/view/View;", "getEventName", "", "onClose", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSettingCheckChanged", "", "item", "Lcom/iqoption/newsandupdates/NewsAndUpdatesItem;", "checked", "onViewCreated", "view", "reportAnalyticsButtonPressed", "eventName", "value", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "savePolicy", "policy", "Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "setData", "data", "", "showError", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NewsAndUpdatesFragment.kt */
public final class d extends g implements b, com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.newsandupdates.d";
    public static final a cXa = new a();
    private HashMap atz;
    private ov cWX;
    private c cWY;
    private NewsAndUpdatesViewModel cWZ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, aXE = {"Lcom/iqoption/newsandupdates/NewsAndUpdatesFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "show", "", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "containerId", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NewsAndUpdatesFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        public final void a(FragmentManager fragmentManager, int i) {
            h.e(fragmentManager, "fragmentManager");
            d dVar = new d();
            a aVar = this;
            if (fragmentManager.findFragmentByTag(aVar.Ll()) == null) {
                fragmentManager.beginTransaction().add(i, dVar, aVar.Ll()).addToBackStack(aVar.Ll()).commit();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: NewsAndUpdatesFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ d cXb;

        c(d dVar) {
            this.cXb = dVar;
        }

        public final void onClick(View view) {
            d.a(this.cXb, "news-updates_back", null, 2, null);
            this.cXb.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "settings", "", "Lcom/iqoption/newsandupdates/NewsAndUpdatesItem;", "onChanged"})
    /* compiled from: NewsAndUpdatesFragment.kt */
    static final class b<T> implements Observer<List<? extends f>> {
        final /* synthetic */ d cXb;

        b(d dVar) {
            this.cXb = dVar;
        }

        /* renamed from: L */
        public final void onChanged(List<f> list) {
            if (list != null) {
                this.cXb.aR(list);
            } else {
                this.cXb.zy();
            }
        }
    }

    public static final void a(FragmentManager fragmentManager, int i) {
        cXa.a(fragmentManager, i);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public String gF() {
        return "news-updates_show";
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (d.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cWX = (ov) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_news_and_updates, viewGroup, false, 4, null);
        ov ovVar = this.cWX;
        if (ovVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = ovVar.bzh;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        h.d(recyclerView, "recycler");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.cWY = new c(com.iqoption.core.ext.a.m(this), this);
        c cVar = this.cWY;
        if (cVar == null) {
            h.lS("adapter");
        }
        recyclerView.setAdapter(cVar);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.cWZ = NewsAndUpdatesViewModel.cXg.r(com.iqoption.core.ext.a.n(this));
        NewsAndUpdatesViewModel newsAndUpdatesViewModel = this.cWZ;
        if (newsAndUpdatesViewModel == null) {
            h.lS("viewModel");
        }
        ar.a(newsAndUpdatesViewModel.avq(), (Fragment) this, (Observer) new b(this));
        ov ovVar = this.cWX;
        if (ovVar == null) {
            h.lS("binding");
        }
        ovVar.bwe.setOnClickListener(new c(this));
    }

    public void a(f fVar, boolean z) {
        String str;
        h.e(fVar, "item");
        com.iqoption.core.microservices.busapi.response.b bVar;
        com.iqoption.core.microservices.busapi.response.b bVar2;
        switch (e.aoS[fVar.avn().ordinal()]) {
            case 1:
                bVar = new com.iqoption.core.microservices.busapi.response.b(null, Boolean.valueOf(z), null, null, null, 29, null);
                break;
            case 2:
                bVar2 = new com.iqoption.core.microservices.busapi.response.b(null, null, Boolean.valueOf(z), null, null, 27, null);
                break;
            case 3:
                bVar = new com.iqoption.core.microservices.busapi.response.b(null, null, null, Boolean.valueOf(z), null, 23, null);
                break;
            case 4:
                bVar2 = new com.iqoption.core.microservices.busapi.response.b(null, null, null, null, Boolean.valueOf(z), 15, null);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        c(r1);
        switch (e.auk[fVar.avn().ordinal()]) {
            case 1:
                str = "news-updates_email-notifications";
                break;
            case 2:
                str = "news-updates_push-notifications";
                break;
            case 3:
                str = "news-updates_phone-calls-notifications";
                break;
            case 4:
                str = "news-updates_thirdparty-notifications";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        a(str, Double.valueOf(z ? 1.0d : 0.0d));
    }

    private final void c(com.iqoption.core.microservices.busapi.response.b bVar) {
        NewsAndUpdatesViewModel newsAndUpdatesViewModel = this.cWZ;
        if (newsAndUpdatesViewModel == null) {
            h.lS("viewModel");
        }
        af.a(newsAndUpdatesViewModel.b(bVar), NewsAndUpdatesFragment$savePolicy$1.cXc, NewsAndUpdatesFragment$savePolicy$2.cXd, null, 4, null);
    }

    public View getContentView() {
        ov ovVar = this.cWX;
        if (ovVar == null) {
            h.lS("binding");
        }
        return ovVar.getRoot();
    }

    private final void zy() {
        com.iqoption.app.a.b.FG();
    }

    private final void aR(List<f> list) {
        c cVar = this.cWY;
        if (cVar == null) {
            h.lS("adapter");
        }
        cVar.aR(list);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }

    static /* bridge */ /* synthetic */ void a(d dVar, String str, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = (Double) null;
        }
        dVar.a(str, d);
    }

    private final void a(String str, Double d) {
        Builder Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str);
        if (d != null) {
            Builder.setValue(Double.valueOf(d.doubleValue()));
        }
        EventManager.Bm().a(Builder.build());
    }
}
