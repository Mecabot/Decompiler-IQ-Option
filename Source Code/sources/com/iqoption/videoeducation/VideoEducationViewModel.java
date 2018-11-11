package com.iqoption.videoeducation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import com.iqoption.analytics.o;
import com.iqoption.core.f;
import com.iqoption.x.R;
import io.reactivex.c.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u001cH\u0007J\b\u0010\u001e\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0010H\u0007J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020\u001cH\u0007J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0007R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u001f\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0005\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, aXE = {"Lcom/iqoption/videoeducation/VideoEducationViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "catalogItems", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/videoeducation/VideoCatalogAdapterItem;", "getCatalogItems", "()Landroid/arch/lifecycle/LiveData;", "catalogItemsData", "Landroid/arch/lifecycle/MutableLiveData;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "isSearchShown", "", "openedCatalog", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "getOpenedCatalog", "openedCatalogData", "tagItems", "Lcom/iqoption/videoeducation/VideoTagItem;", "getTagItems", "videoItems", "Lcom/iqoption/videoeducation/VideoAdapterItem;", "getVideoItems", "videosHelper", "Lcom/iqoption/videoeducation/VideosHelper;", "closeCatalog", "", "hideSearch", "onCleared", "openCatalog", "catalog", "setTextQuery", "constraint", "", "startSearch", "toggleTag", "tag", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoEducationViewModel.kt */
public final class VideoEducationViewModel extends ViewModel {
    private static final String TAG = "VideoEducationViewModel";
    public static final a dzf = new a();
    private final io.reactivex.disposables.a bco = new io.reactivex.disposables.a();
    private final MutableLiveData<List<e>> dza = new MutableLiveData();
    private final LiveData<List<e>> dzb = this.dza;
    private final MutableLiveData<com.iqoption.videoeducation.b.a> dzc = new MutableLiveData();
    private final LiveData<com.iqoption.videoeducation.b.a> dzd = this.dzc;
    private o dze;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/videoeducation/VideoEducationViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/videoeducation/VideoEducationViewModel;", "a", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideoEducationViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return VideoEducationViewModel.TAG;
        }

        public final VideoEducationViewModel H(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            Factory factory = (Factory) null;
            ViewModelProvider b = ViewModelProviders.b(fragmentActivity);
            h.d(b, "ViewModelProviders.of(a)");
            ViewModel h = b.h(VideoEducationViewModel.class);
            h.d(h, "if (factory != null) {\n …f(a)\n    }[T::class.java]");
            return (VideoEducationViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "catalogs", "", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: VideoEducationViewModel.kt */
    /* renamed from: com.iqoption.videoeducation.VideoEducationViewModel$1 */
    static final class AnonymousClass1<T> implements e<List<? extends com.iqoption.videoeducation.b.a>> {
        final /* synthetic */ VideoEducationViewModel dzg;

        AnonymousClass1(VideoEducationViewModel videoEducationViewModel) {
            this.dzg = videoEducationViewModel;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.videoeducation.b.a> list) {
            MutableLiveData a = this.dzg.dza;
            h.d(list, "catalogs");
            Collection arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                String str = null;
                if (!it.hasNext()) {
                    break;
                }
                Object obj;
                com.iqoption.videoeducation.b.a aVar = (com.iqoption.videoeducation.b.a) it.next();
                if (aVar.aHD().isEmpty()) {
                    obj = null;
                } else {
                    String stringBuilder;
                    String Mi = aVar.aHW().Mi();
                    String XQ = aVar.aHW().XQ();
                    int aHU = aVar.aHU();
                    if (aHU > 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(aHU);
                        stringBuilder2.append(' ');
                        stringBuilder2.append(f.getString(R.string.video));
                        stringBuilder = stringBuilder2.toString();
                    } else {
                        stringBuilder = null;
                    }
                    aHU = aVar.aHV();
                    if (aHU > 0) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(aHU);
                        stringBuilder3.append(' ');
                        stringBuilder3.append(f.ac(R.plurals.new_video, aHU));
                        str = stringBuilder3.toString();
                    }
                    g gVar = new g(aVar, XQ, Mi, stringBuilder, str);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            Object obj2 = (List) arrayList;
            if ((((Collection) obj2).isEmpty() ^ 1) == 0) {
                obj2 = null;
            }
            if (obj2 == null) {
                obj2 = l.cr(new f());
            }
            a.postValue(obj2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: VideoEducationViewModel.kt */
    /* renamed from: com.iqoption.videoeducation.VideoEducationViewModel$2 */
    static final class AnonymousClass2<T> implements e<Throwable> {
        final /* synthetic */ VideoEducationViewModel dzg;

        AnonymousClass2(VideoEducationViewModel videoEducationViewModel) {
            this.dzg = videoEducationViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(VideoEducationViewModel.dzf.Ll(), "Could not load video categories", th);
            this.dzg.dza.postValue(l.cr(new f()));
        }
    }

    public static final VideoEducationViewModel H(FragmentActivity fragmentActivity) {
        return dzf.H(fragmentActivity);
    }

    public VideoEducationViewModel() {
        this.dza.setValue(l.cr(new h()));
        this.bco.e(j.dyP.aHB().d(com.iqoption.core.h.i.Yo()).a((e) new AnonymousClass1(this), (e) new AnonymousClass2(this)));
    }

    public final LiveData<List<e>> aHF() {
        return this.dzb;
    }

    public final LiveData<com.iqoption.videoeducation.b.a> aHG() {
        return this.dzd;
    }

    public final LiveData<Boolean> aHH() {
        o oVar = this.dze;
        return oVar != null ? oVar.aHH() : null;
    }

    public final LiveData<List<d>> aHI() {
        o oVar = this.dze;
        return oVar != null ? oVar.aHI() : null;
    }

    public final LiveData<List<n>> aHJ() {
        o oVar = this.dze;
        return oVar != null ? oVar.aHJ() : null;
    }

    protected void onCleared() {
        super.onCleared();
        this.bco.clear();
    }

    @MainThread
    public final void a(com.iqoption.videoeducation.b.a aVar) {
        h.e(aVar, "catalog");
        this.dzc.setValue(aVar);
        this.dze = new o(aVar.aHW().getId());
        o.R(aVar.aHW().getId());
    }

    @MainThread
    public final void aHK() {
        this.dzc.setValue(null);
        o oVar = this.dze;
        if (oVar != null) {
            oVar.dispose();
        }
        this.dze = (o) null;
        o.Bg();
    }

    @MainThread
    public final void Rv() {
        o oVar = this.dze;
        if (oVar != null) {
            oVar.aHP();
        }
    }

    @MainThread
    public final void aHL() {
        o oVar = this.dze;
        if (oVar != null) {
            oVar.aHL();
        }
    }

    @MainThread
    public final void D(CharSequence charSequence) {
        h.e(charSequence, "constraint");
        o oVar = this.dze;
        if (oVar != null) {
            oVar.r(charSequence);
        }
    }

    @MainThread
    public final void a(com.iqoption.core.microservices.videoeducation.response.f fVar) {
        h.e(fVar, "tag");
        o oVar = this.dze;
        if (oVar != null) {
            oVar.a(fVar);
        }
    }
}
