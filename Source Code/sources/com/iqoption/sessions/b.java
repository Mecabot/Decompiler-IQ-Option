package com.iqoption.sessions;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.iqoption.d.w;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsFragment;", "Landroid/support/v4/app/Fragment;", "()V", "binding", "Lcom/iqoption/databinding/ActiveSessionsFragmentBinding;", "sessionsAdapter", "Lcom/iqoption/sessions/ActiveSessionsAdapter;", "viewModel", "Lcom/iqoption/sessions/ActiveSessionsViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "terminateSessions", "", "sessions", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveSessionsFragment.kt */
public final class b extends Fragment {
    private static final String TAG = "javaClass";
    public static final a dqP = new a();
    private HashMap atz;
    private w dqM;
    private ActiveSessionsViewModel dqN;
    private a dqO;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsFragment$Companion;", "", "()V", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ActiveSessionsFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ b this$0;

        b(b bVar) {
            this.this$0 = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.this$0.zzakw();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Ljava/lang/Void;", "onChanged"})
    /* compiled from: ActiveSessionsFragment.kt */
    static final class c<T> implements Observer<com.iqoption.core.ui.c<Void>> {
        final /* synthetic */ b this$0;

        c(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<Void> cVar) {
            if (cVar != null) {
                FrameLayout frameLayout;
                switch (cVar.Yt()) {
                    case SUCCESS:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(8);
                        b.b(this.this$0).notifyDataSetChanged();
                        return;
                    case ERROR:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(8);
                        com.iqoption.app.a.b.FG();
                        return;
                    case LOADING:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/ui/Resource;", "Ljava/lang/Void;", "onChanged"})
    /* compiled from: ActiveSessionsFragment.kt */
    static final class d<T> implements Observer<com.iqoption.core.ui.c<Void>> {
        final /* synthetic */ b this$0;

        d(b bVar) {
            this.this$0 = bVar;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.core.ui.c<Void> cVar) {
            if (cVar != null) {
                FrameLayout frameLayout;
                switch (cVar.Yt()) {
                    case SUCCESS:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(8);
                        b.b(this.this$0).notifyDataSetChanged();
                        return;
                    case ERROR:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(8);
                        com.iqoption.app.a.b.FG();
                        return;
                    case LOADING:
                        frameLayout = b.a(this.this$0).bix;
                        h.d(frameLayout, "binding.progressLayout");
                        frameLayout.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
        }
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

    public static final /* synthetic */ w a(b bVar) {
        w wVar = bVar.dqM;
        if (wVar == null) {
            h.lS("binding");
        }
        return wVar;
    }

    public static final /* synthetic */ a b(b bVar) {
        a aVar = bVar.dqO;
        if (aVar == null) {
            h.lS("sessionsAdapter");
        }
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dqM = (w) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.active_sessions_fragment, viewGroup, false);
        w wVar = this.dqM;
        if (wVar == null) {
            h.lS("binding");
        }
        View view = wVar.biw;
        if (view != null) {
            view.setOnClickListener(new b(this));
        }
        com.iqoption.sessions.ActiveSessionsViewModel.a aVar = ActiveSessionsViewModel.dqU;
        FragmentActivity activity = zzakw();
        if (activity == null) {
            h.aXZ();
        }
        h.d(activity, "activity!!");
        this.dqN = aVar.z(activity);
        ActiveSessionsViewModel activeSessionsViewModel = this.dqN;
        if (activeSessionsViewModel == null) {
            h.lS("viewModel");
        }
        this.dqO = new a(activeSessionsViewModel.aDO(), new ActiveSessionsFragment$onCreateView$2(this));
        wVar = this.dqM;
        if (wVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = wVar.biy;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        Context context = recyclerView.getContext();
        h.d(context, "context");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp28), false, true));
        a aVar2 = this.dqO;
        if (aVar2 == null) {
            h.lS("sessionsAdapter");
        }
        recyclerView.setAdapter(aVar2);
        ActiveSessionsViewModel activeSessionsViewModel2 = this.dqN;
        if (activeSessionsViewModel2 == null) {
            h.lS("viewModel");
        }
        if (activeSessionsViewModel2.aDO().isEmpty()) {
            activeSessionsViewModel2 = this.dqN;
            if (activeSessionsViewModel2 == null) {
                h.lS("viewModel");
            }
            activeSessionsViewModel2.aDP().observe(this, new c(this));
        }
        w wVar2 = this.dqM;
        if (wVar2 == null) {
            h.lS("binding");
        }
        return wVar2.getRoot();
    }

    private final void bj(List<com.iqoption.core.microservices.a.a.b> list) {
        ActiveSessionsViewModel activeSessionsViewModel = this.dqN;
        if (activeSessionsViewModel == null) {
            h.lS("viewModel");
        }
        activeSessionsViewModel.bk(list).observe(this, new d(this));
    }
}
