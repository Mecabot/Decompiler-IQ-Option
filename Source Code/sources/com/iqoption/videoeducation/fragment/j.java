package com.iqoption.videoeducation.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.analytics.o;
import com.iqoption.core.util.r;
import com.iqoption.d.tr;
import com.iqoption.util.am;
import com.iqoption.util.bg;
import com.iqoption.videoeducation.VideoEducationViewModel;
import com.iqoption.videoeducation.m;
import com.iqoption.videoeducation.n;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0017"}, aXE = {"Lcom/iqoption/videoeducation/fragment/VideosFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVideoEducationVideosBinding;", "isCustomAnimationsEnabled", "", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEnterAnimation", "", "onExitAnimation", "onLayout", "viewModel", "Lcom/iqoption/videoeducation/VideoEducationViewModel;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideosFragment.kt */
public final class j extends com.iqoption.core.ui.fragment.b {
    public static final String TAG = "com.iqoption.videoeducation.fragment.j";
    public static final a dAa = new a();
    private HashMap atz;
    private tr dzZ;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/videoeducation/fragment/VideosFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release", "com/iqoption/videoeducation/fragment/VideosFragment$$special$$inlined$doOnLayout$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ j dAb;
        final /* synthetic */ VideoEducationViewModel dAc;
        final /* synthetic */ tr dAd;

        public d(View view, tr trVar, j jVar, VideoEducationViewModel videoEducationViewModel) {
            this.aGz = view;
            this.dAb = jVar;
            this.dAc = videoEducationViewModel;
            this.dAd = trVar;
        }

        public void onGlobalLayout() {
            this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.dAb.a(this.dAd, this.dAc);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/videoeducation/fragment/VideosFragment$onCreateView$1$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class b extends com.iqoption.core.ext.g {
        final /* synthetic */ j dAb;
        final /* synthetic */ VideoEducationViewModel dAc;

        b(j jVar, VideoEducationViewModel videoEducationViewModel) {
            this.dAb = jVar;
            this.dAc = videoEducationViewModel;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            int id = view.getId();
            if (id == R.id.btnBack) {
                this.dAc.aHK();
            } else if (id == R.id.btnCloseSearch) {
                this.dAc.aHL();
            } else if (id == R.id.btnSearch) {
                this.dAc.Rv();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/videoeducation/fragment/VideosFragment$onCreateView$1$1", "Lcom/iqoption/core/util/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class c extends r {
        final /* synthetic */ j dAb;
        final /* synthetic */ VideoEducationViewModel dAc;

        c(j jVar, VideoEducationViewModel videoEducationViewModel) {
            this.dAb = jVar;
            this.dAc = videoEducationViewModel;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "s");
            super.afterTextChanged(editable);
            this.dAc.D(editable);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "catalog", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "onChanged"})
    /* compiled from: VideosFragment.kt */
    static final class e<T> implements Observer<com.iqoption.videoeducation.b.a> {
        final /* synthetic */ tr dAe;

        e(tr trVar) {
            this.dAe = trVar;
        }

        /* renamed from: d */
        public final void onChanged(com.iqoption.videoeducation.b.a aVar) {
            if (aVar != null) {
                TextView textView = this.dAe.agA;
                kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                textView.setText(aVar.aHW().Mi());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, aXE = {"com/iqoption/videoeducation/fragment/VideosFragment$onLayout$1$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class f extends SpanSizeLookup {
        final /* synthetic */ com.iqoption.videoeducation.a.i dAf;
        final /* synthetic */ int dAg;

        f(com.iqoption.videoeducation.a.i iVar, int i) {
            this.dAf = iVar;
            this.dAg = i;
        }

        public int getSpanSize(int i) {
            if (this.dAf.getItemCount() == 1 && this.dAf.getItemViewType(0) == -1) {
                return this.dAg;
            }
            return 1;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isShown", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: VideosFragment.kt */
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ j dAb;
        final /* synthetic */ tr dAe;

        g(j jVar, tr trVar) {
            this.dAb = jVar;
            this.dAe = trVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            LinearLayout linearLayout;
            TextView textView;
            ImageView imageView;
            if (bool.booleanValue()) {
                linearLayout = this.dAe.bFL;
                kotlin.jvm.internal.h.d(linearLayout, "searchLayout");
                com.iqoption.core.ext.a.L(linearLayout);
                textView = this.dAe.bFJ;
                kotlin.jvm.internal.h.d(textView, "btnCloseSearch");
                com.iqoption.core.ext.a.L(textView);
                imageView = this.dAe.bFK;
                kotlin.jvm.internal.h.d(imageView, "btnSearch");
                com.iqoption.core.ext.a.M(imageView);
                textView = this.dAe.agA;
                kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                com.iqoption.core.ext.a.M(textView);
                this.dAe.bmL.requestFocus();
                am.b((Context) this.dAb.zzakw(), (View) this.dAe.bmL);
                return;
            }
            EditText editText = this.dAe.bmL;
            kotlin.jvm.internal.h.d(editText, "searchInput");
            editText.setText((CharSequence) null);
            linearLayout = this.dAe.bFL;
            kotlin.jvm.internal.h.d(linearLayout, "searchLayout");
            com.iqoption.core.ext.a.M(linearLayout);
            textView = this.dAe.bFJ;
            kotlin.jvm.internal.h.d(textView, "btnCloseSearch");
            com.iqoption.core.ext.a.M(textView);
            imageView = this.dAe.bFK;
            kotlin.jvm.internal.h.d(imageView, "btnSearch");
            com.iqoption.core.ext.a.L(imageView);
            textView = this.dAe.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            com.iqoption.core.ext.a.L(textView);
            am.n(this.dAb.zzakw());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "items", "", "Lcom/iqoption/videoeducation/VideoAdapterItem;", "onChanged"})
    /* compiled from: VideosFragment.kt */
    static final class h<T> implements Observer<List<? extends com.iqoption.videoeducation.d>> {
        final /* synthetic */ com.iqoption.videoeducation.a.i dAh;

        h(com.iqoption.videoeducation.a.i iVar) {
            this.dAh = iVar;
        }

        /* renamed from: L */
        public final void onChanged(List<? extends com.iqoption.videoeducation.d> list) {
            if (list != null) {
                com.iqoption.core.ui.widget.recyclerview.adapter.a.a(this.dAh, list, null, 2, null);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "items", "", "Lcom/iqoption/videoeducation/VideoTagItem;", "onChanged"})
    /* compiled from: VideosFragment.kt */
    static final class i<T> implements Observer<List<? extends n>> {
        final /* synthetic */ tr dAe;
        final /* synthetic */ com.iqoption.videoeducation.a.b dAi;

        i(tr trVar, com.iqoption.videoeducation.a.b bVar) {
            this.dAe = trVar;
            this.dAi = bVar;
        }

        /* renamed from: L */
        public final void onChanged(List<n> list) {
            if (list != null) {
                com.iqoption.core.ui.widget.recyclerview.adapter.a.a(this.dAi, list, null, 2, null);
                RecyclerView recyclerView;
                if ((list.isEmpty() ^ 1) != 0) {
                    recyclerView = this.dAe.bFM;
                    kotlin.jvm.internal.h.d(recyclerView, "tagsList");
                    com.iqoption.core.ext.a.L(recyclerView);
                    return;
                }
                recyclerView = this.dAe.bFM;
                kotlin.jvm.internal.h.d(recyclerView, "tagsList");
                com.iqoption.core.ext.a.M(recyclerView);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/videoeducation/fragment/VideosFragment$onLayout$tagItemsAdapter$1", "Lcom/iqoption/videoeducation/component/TagItemsAdapter$Callbacks;", "onItemClick", "", "item", "Lcom/iqoption/videoeducation/VideoTagItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class j implements com.iqoption.videoeducation.a.b.a {
        final /* synthetic */ VideoEducationViewModel dAj;

        j(VideoEducationViewModel videoEducationViewModel) {
            this.dAj = videoEducationViewModel;
        }

        public void a(n nVar) {
            kotlin.jvm.internal.h.e(nVar, "item");
            this.dAj.a(nVar.aHO());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, aXE = {"com/iqoption/videoeducation/fragment/VideosFragment$onLayout$videoItemsAdapter$1", "Lcom/iqoption/videoeducation/component/VideoItemsAdapter$Callbacks;", "onItemClick", "", "item", "Lcom/iqoption/videoeducation/VideoItem;", "position", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideosFragment.kt */
    public static final class k implements com.iqoption.videoeducation.a.i.a {
        final /* synthetic */ j dAb;

        k(j jVar) {
            this.dAb = jVar;
        }

        public void a(m mVar, int i) {
            kotlin.jvm.internal.h.e(mVar, "item");
            com.iqoption.core.microservices.videoeducation.response.g aHM = mVar.aHM();
            if (aHM.XU() != null) {
                this.dAb.requireFragmentManager().beginTransaction().add(this.dAb.getId(), g.a(aHM.getId(), bg.a(j.a(this.dAb).bFI, (int) R.id.image, i)), g.TAG).addToBackStack(g.TAG).commit();
                o.a(aHM.getId(), aHM.Kj(), aHM.XX());
            }
        }
    }

    public boolean KE() {
        return true;
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ tr a(j jVar) {
        tr trVar = jVar.dzZ;
        if (trVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return trVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        this.dzZ = (tr) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_video_education_videos, viewGroup, false, 4, null);
        VideoEducationViewModel H = VideoEducationViewModel.dzf.H(com.iqoption.core.ext.a.n(this));
        tr trVar = this.dzZ;
        if (trVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        OnClickListener bVar = new b(this, H);
        trVar.awN.setOnClickListener(bVar);
        trVar.bFK.setOnClickListener(bVar);
        trVar.bFJ.setOnClickListener(bVar);
        FrameLayout frameLayout = trVar.brj;
        kotlin.jvm.internal.h.d(frameLayout, "headerLayout");
        frameLayout.setLayoutTransition(bg.aGD());
        frameLayout = trVar.bFN;
        kotlin.jvm.internal.h.d(frameLayout, "titleLayout");
        frameLayout.setLayoutTransition(bg.aGD());
        trVar.bFI.setHasFixedSize(true);
        trVar.bFM.setHasFixedSize(true);
        trVar.bmL.addTextChangedListener(new c(this, H));
        H.aHG().observe(this, new e(trVar));
        View root = trVar.getRoot();
        kotlin.jvm.internal.h.d(root, "root");
        root.getViewTreeObserver().addOnGlobalLayoutListener(new d(root, trVar, this, H));
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof com.iqoption.core.ui.navigation.a)) {
            parentFragment = null;
        }
        com.iqoption.core.ui.navigation.a aVar = (com.iqoption.core.ui.navigation.a) parentFragment;
        if (aVar == null) {
            FragmentActivity activity = zzakw();
            if (!(activity instanceof com.iqoption.core.ui.navigation.a)) {
                activity = null;
            }
            aVar = (com.iqoption.core.ui.navigation.a) activity;
        }
        if (aVar != null) {
            getLifecycle().a(new VideosFragment$onCreateView$$inlined$let$lambda$1(aVar, aVar, this, H));
        }
        tr trVar2 = this.dzZ;
        if (trVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return trVar2.getRoot();
    }

    private final void a(tr trVar, VideoEducationViewModel videoEducationViewModel) {
        f fVar = new f();
        fVar.i(trVar.bFI);
        int spanCount = fVar.getSpanCount();
        int aHR = fVar.aHR();
        com.iqoption.core.graphics.b aHS = fVar.aHS();
        kotlin.jvm.internal.h.d(aHS, "imageSize");
        ViewDataBinding viewDataBinding = trVar;
        com.iqoption.videoeducation.a.i iVar = new com.iqoption.videoeducation.a.i(aHS, com.iqoption.core.ext.a.c(viewDataBinding, (int) R.dimen.dp6), new k(this));
        RecyclerView recyclerView = trVar.bFI;
        kotlin.jvm.internal.h.d(recyclerView, "videosList");
        recyclerView.setAdapter(iVar);
        recyclerView = trVar.bFI;
        kotlin.jvm.internal.h.d(recyclerView, "videosList");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(com.iqoption.core.ext.a.m(this), spanCount);
        gridLayoutManager.setSpanSizeLookup(new f(iVar, spanCount));
        recyclerView.setLayoutManager(gridLayoutManager);
        trVar.bFI.addItemDecoration(new com.iqoption.widget.c(spanCount, aHR, false));
        trVar.bFM.addItemDecoration(new com.iqoption.widget.h(com.iqoption.core.ext.a.c(viewDataBinding, (int) R.dimen.dp8)));
        com.iqoption.videoeducation.a.b bVar = new com.iqoption.videoeducation.a.b(new j(videoEducationViewModel));
        RecyclerView recyclerView2 = trVar.bFM;
        kotlin.jvm.internal.h.d(recyclerView2, "tagsList");
        recyclerView2.setAdapter(bVar);
        LiveData aHH = videoEducationViewModel.aHH();
        if (aHH != null) {
            aHH.observe(this, new g(this, trVar));
        }
        aHH = videoEducationViewModel.aHI();
        if (aHH != null) {
            aHH.observe(this, new h(iVar));
        }
        LiveData aHJ = videoEducationViewModel.aHJ();
        if (aHJ != null) {
            aHJ.observe(this, new i(trVar, bVar));
        }
    }

    public void KF() {
        super.KF();
        tr trVar = this.dzZ;
        if (trVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View root = trVar.getRoot();
        kotlin.jvm.internal.h.d(root, Promotion.ACTION_VIEW);
        root.setAlpha(0.0f);
        root.setTranslationX(-com.iqoption.core.ext.a.b((Fragment) this, (int) R.dimen.dp48));
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
        kotlin.jvm.internal.h.d(ofPropertyValuesHolder, "animator");
        com.iqoption.core.ext.a.a((Animator) ofPropertyValuesHolder, Yw());
        ofPropertyValuesHolder.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ofPropertyValuesHolder.start();
    }

    public void KG() {
        super.KG();
        tr trVar = this.dzZ;
        if (trVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View root = trVar.getRoot();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{-com.iqoption.core.ext.a.b((Fragment) this, (int) R.dimen.dp48)});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(root, propertyValuesHolderArr);
        kotlin.jvm.internal.h.d(ofPropertyValuesHolder, "animator");
        com.iqoption.core.ext.a.a((Animator) ofPropertyValuesHolder, Yx());
        ofPropertyValuesHolder.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ofPropertyValuesHolder.start();
    }
}
