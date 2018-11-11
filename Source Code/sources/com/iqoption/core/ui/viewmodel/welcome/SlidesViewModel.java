package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.ViewModel;
import com.iqoption.core.data.b.c;
import com.iqoption.core.f;
import com.iqoption.core.microservices.core.a.b;
import io.reactivex.c.e;
import java.util.concurrent.TimeUnit;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/SlidesViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "enabledDebugMenu", "", "getEnabledDebugMenu", "()Z", "onlineLiveData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "", "getOnlineLiveData", "()Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "onCleared", "", "Companion", "core_release"})
/* compiled from: SlidesViewModel.kt */
public final class SlidesViewModel extends ViewModel {
    private static final String TAG = "SlidesViewModel";
    private static final int bcT = (f.Dp().DJ() ? 1 : 5000);
    public static final a bcU = new a();
    private final io.reactivex.disposables.a asp = new io.reactivex.disposables.a();
    private final c<Integer> bcR;
    private final boolean bcS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/SlidesViewModel$Companion;", "", "()V", "MIN_ONLINE", "", "getMIN_ONLINE", "()I", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/SlidesViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "core_release"})
    /* compiled from: SlidesViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return SlidesViewModel.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/core/response/OnlineCountResponses;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: SlidesViewModel.kt */
    /* renamed from: com.iqoption.core.ui.viewmodel.welcome.SlidesViewModel$1 */
    static final class AnonymousClass1<T> implements e<b> {
        final /* synthetic */ SlidesViewModel bcV;

        AnonymousClass1(SlidesViewModel slidesViewModel) {
            this.bcV = slidesViewModel;
        }

        /* renamed from: a */
        public final void accept(b bVar) {
            this.bcV.Zf().setValue(Integer.valueOf(bVar.VJ()));
        }
    }

    public SlidesViewModel() {
        boolean z = false;
        this.bcR = new c(Integer.valueOf(0));
        if (f.Dp().DJ() || u.m(f.Dp().getAppId(), "com.iqoption.dev", true)) {
            z = true;
        }
        this.bcS = z;
        this.asp.e(com.iqoption.core.microservices.core.a.aVw.VG().g((io.reactivex.c.f) new com.iqoption.core.h.f(3, TimeUnit.SECONDS)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((e) new AnonymousClass1(this), (e) AnonymousClass2.bcW));
    }

    public final c<Integer> Zf() {
        return this.bcR;
    }

    protected void onCleared() {
        super.onCleared();
        this.asp.clear();
    }
}
