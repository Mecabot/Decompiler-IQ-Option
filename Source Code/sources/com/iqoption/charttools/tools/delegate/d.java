package com.iqoption.charttools.tools.delegate;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.tools.ToolsViewModel;
import com.iqoption.charttools.tools.data.h;
import com.iqoption.charttools.tools.data.m;
import com.iqoption.d.ako;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0006\u0007\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/IndicatorsDelegate;", "Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "Lcom/iqoption/databinding/ToolsContentIndicatorsBinding;", "context", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "(Lcom/iqoption/charttools/tools/delegate/DelegateContext;)V", "Callback", "CategoryAdapterCallbacks", "ViewPagerAdapter", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorsDelegate.kt */
public final class d extends b<ako> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/IndicatorsDelegate$Callback;", "", "onOpenIndicatorSettings", "", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "onOpenVideoPlayer", "videoUrl", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorsDelegate.kt */
    public interface a {
        void d(x xVar);

        void fH(String str);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/IndicatorsDelegate$ViewPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "lifecycleOwner", "Landroid/arch/lifecycle/LifecycleOwner;", "callbacks", "Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "viewModel", "Lcom/iqoption/charttools/tools/ToolsViewModel;", "items", "", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "(Landroid/arch/lifecycle/LifecycleOwner;Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;Lcom/iqoption/charttools/tools/ToolsViewModel;Ljava/util/List;)V", "getCallbacks", "()Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "getItems", "()Ljava/util/List;", "getLifecycleOwner", "()Landroid/arch/lifecycle/LifecycleOwner;", "getViewModel", "()Lcom/iqoption/charttools/tools/ToolsViewModel;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "Entry", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorsDelegate.kt */
    private static final class c extends PagerAdapter {
        private final ToolsViewModel aAA;
        private final com.iqoption.charttools.tools.delegate.c.a aAE;
        private final LifecycleOwner aCg;
        private final List<com.iqoption.charttools.tools.data.c> nj;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/IndicatorsDelegate$ViewPagerAdapter$Entry;", "", "item", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "observer", "Landroid/arch/lifecycle/Observer;", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "view", "Landroid/view/View;", "(Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;Landroid/arch/lifecycle/Observer;Landroid/view/View;)V", "getItem", "()Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "getObserver", "()Landroid/arch/lifecycle/Observer;", "getView", "()Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: IndicatorsDelegate.kt */
        private static final class a {
            private final com.iqoption.charttools.tools.data.c aCh;
            private final Observer<List<h>> aCi;
            private final View view;

            public a(com.iqoption.charttools.tools.data.c cVar, Observer<List<h>> observer, View view) {
                kotlin.jvm.internal.h.e(cVar, "item");
                kotlin.jvm.internal.h.e(observer, "observer");
                kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
                this.aCh = cVar;
                this.aCi = observer;
                this.view = view;
            }

            public final com.iqoption.charttools.tools.data.c Om() {
                return this.aCh;
            }

            public final Observer<List<h>> On() {
                return this.aCi;
            }

            public final View getView() {
                return this.view;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "onChanged"})
        /* compiled from: IndicatorsDelegate.kt */
        static final class b<T> implements Observer<List<? extends h>> {
            final /* synthetic */ com.iqoption.charttools.tools.a.b aCj;

            b(com.iqoption.charttools.tools.a.b bVar) {
                this.aCj = bVar;
            }

            /* renamed from: L */
            public final void onChanged(List<? extends h> list) {
                if (list != null) {
                    com.iqoption.core.ui.widget.recyclerview.adapter.a.a(this.aCj, list, null, 2, null);
                }
            }
        }

        public c(LifecycleOwner lifecycleOwner, com.iqoption.charttools.tools.delegate.c.a aVar, ToolsViewModel toolsViewModel, List<? extends com.iqoption.charttools.tools.data.c> list) {
            kotlin.jvm.internal.h.e(lifecycleOwner, "lifecycleOwner");
            kotlin.jvm.internal.h.e(aVar, "callbacks");
            kotlin.jvm.internal.h.e(toolsViewModel, "viewModel");
            kotlin.jvm.internal.h.e(list, "items");
            this.aCg = lifecycleOwner;
            this.aAE = aVar;
            this.aAA = toolsViewModel;
            this.nj = list;
        }

        public boolean isViewFromObject(View view, Object obj) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            kotlin.jvm.internal.h.e(obj, "object");
            Object obj2 = null;
            if (!(obj instanceof a)) {
                obj = null;
            }
            a aVar = (a) obj;
            if (aVar != null) {
                obj2 = aVar.getView();
            }
            return kotlin.jvm.internal.h.E(view, obj2);
        }

        public int getCount() {
            return this.nj.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            kotlin.jvm.internal.h.e(viewGroup, "container");
            com.iqoption.charttools.tools.data.c cVar = (com.iqoption.charttools.tools.data.c) this.nj.get(i);
            com.iqoption.charttools.tools.a.b bVar = new com.iqoption.charttools.tools.a.b(new b(this.aAE, this.aAA, cVar));
            Observer bVar2 = new b(bVar);
            this.aAA.a(cVar).observe(this.aCg, bVar2);
            RecyclerView recyclerView = new RecyclerView(viewGroup.getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setClipToPadding(false);
            recyclerView.setOverScrollMode(2);
            View view = recyclerView;
            recyclerView.setPadding(0, com.iqoption.core.ext.a.f(view, R.dimen.dp8), 0, com.iqoption.core.ext.a.f(view, R.dimen.dp8));
            recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
            com.iqoption.core.ext.a.b(recyclerView);
            recyclerView.setAdapter(bVar);
            viewGroup.addView(view);
            return new a(cVar, bVar2, view);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            kotlin.jvm.internal.h.e(viewGroup, "container");
            kotlin.jvm.internal.h.e(obj, "object");
            a aVar = (a) obj;
            this.aAA.a(aVar.Om()).removeObserver(aVar.On());
            viewGroup.removeView(aVar.getView());
        }

        public CharSequence getPageTitle(int i) {
            return ((com.iqoption.charttools.tools.data.c) this.nj.get(i)).getTitle();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/IndicatorsDelegate$CategoryAdapterCallbacks;", "Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter$Callbacks;", "callbacks", "Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "viewModel", "Lcom/iqoption/charttools/tools/ToolsViewModel;", "categoryAdapterItem", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "(Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;Lcom/iqoption/charttools/tools/ToolsViewModel;Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;)V", "onItemClick", "", "item", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "onItemFavoriteButtonClick", "onItemInfoButtonClick", "onItemVideoLinkClick", "Lcom/iqoption/charttools/tools/data/InfoIndicatorItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorsDelegate.kt */
    private static final class b implements com.iqoption.charttools.tools.a.b.a {
        private final ToolsViewModel aAA;
        private final com.iqoption.charttools.tools.delegate.c.a aAE;
        private final com.iqoption.charttools.tools.data.c aBv;

        public b(com.iqoption.charttools.tools.delegate.c.a aVar, ToolsViewModel toolsViewModel, com.iqoption.charttools.tools.data.c cVar) {
            kotlin.jvm.internal.h.e(aVar, "callbacks");
            kotlin.jvm.internal.h.e(toolsViewModel, "viewModel");
            kotlin.jvm.internal.h.e(cVar, "categoryAdapterItem");
            this.aAE = aVar;
            this.aAA = toolsViewModel;
            this.aBv = cVar;
        }

        public void c(m mVar) {
            kotlin.jvm.internal.h.e(mVar, "item");
            this.aAE.d(mVar.KJ());
        }

        public void d(m mVar) {
            kotlin.jvm.internal.h.e(mVar, "item");
            this.aAA.a(this.aBv, mVar);
        }

        public void e(m mVar) {
            kotlin.jvm.internal.h.e(mVar, "item");
            this.aAA.a(mVar);
        }

        public void a(com.iqoption.charttools.tools.data.i iVar) {
            kotlin.jvm.internal.h.e(iVar, "item");
            String Mk = iVar.Mk();
            if (Mk != null) {
                this.aAE.fH(Mk);
            }
        }
    }

    public d(final c cVar) {
        kotlin.jvm.internal.h.e(cVar, "context");
        super(R.layout.tools_content_indicators, cVar);
        ((ako) getBinding()).bPJ.setupWithViewPager(((ako) getBinding()).bmI);
        Nv().NM().observe(this, new Observer<List<? extends com.iqoption.charttools.tools.data.c>>(this) {
            final /* synthetic */ d aCe;

            /* renamed from: L */
            public final void onChanged(List<? extends com.iqoption.charttools.tools.data.c> list) {
                if (list != null) {
                    ViewPager viewPager = ((ako) this.aCe.getBinding()).bmI;
                    kotlin.jvm.internal.h.d(viewPager, "binding.pager");
                    viewPager.setAdapter(new c(cVar, this.aCe.Nz(), this.aCe.Nv(), list));
                }
            }
        });
    }
}
