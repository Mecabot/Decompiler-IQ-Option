package com.iqoption.feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.app.managers.y;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.util.ba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/feed/FeedViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "instrumentSubscriptions", "", "Lcom/iqoption/core/data/model/InstrumentType;", "initialFeed", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/feed/FeedRepository$FeedItemsHolder;", "force", "", "loadMore", "from", "", "onCleared", "", "removeFromFeed", "Ljava/lang/Void;", "adapterItem", "Lcom/iqoption/feed/feedlist/FeedAdapterItem;", "sendClick", "id", "type", "", "subscribeInstruments", "instruments", "", "toggleLike", "feedItem", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "toggleLikeFeed", "item", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FeedViewModel.kt */
public final class FeedViewModel extends ViewModel {
    public static final a clo = new a();
    private final List<InstrumentType> cln = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/feed/FeedViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/feed/FeedViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final FeedViewModel P(Fragment fragment) {
            h.e(fragment, "fragment");
            return (FeedViewModel) ViewModelProviders.d(fragment).h(FeedViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedViewModel.kt */
    static final class b implements io.reactivex.c.a {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ com.iqoption.feed.feedlist.e clp;

        b(com.iqoption.feed.feedlist.e eVar, MutableLiveData mutableLiveData) {
            this.clp = eVar;
            this.$liveData = mutableLiveData;
        }

        public final void run() {
            a.cle.a(this.clp);
            this.$liveData.setValue(com.iqoption.util.ba.a.a(ba.dww, null, 1, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FeedViewModel.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData $liveData;

        c(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.$liveData.setValue(com.iqoption.util.ba.a.a(ba.dww, th, th.getMessage(), null, 4, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedViewModel.kt */
    static final class d implements io.reactivex.c.a {
        final /* synthetic */ int clq;

        d(int i) {
            this.clq = i;
        }

        public final void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("send click for feed with id ");
            stringBuilder.append(this.clq);
            com.iqoption.core.i.d(stringBuilder.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FeedViewModel.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ int clq;

        e(int i) {
            this.clq = i;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("send click for feed with id ");
            stringBuilder.append(this.clq);
            stringBuilder.append(" failed");
            com.iqoption.core.i.e("FEEDBACK", stringBuilder.toString(), th);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedViewModel.kt */
    static final class f implements io.reactivex.c.a {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ FeedViewModel clr;
        final /* synthetic */ com.iqoption.core.microservices.feed.response.a cls;

        f(FeedViewModel feedViewModel, com.iqoption.core.microservices.feed.response.a aVar, MutableLiveData mutableLiveData) {
            this.clr = feedViewModel;
            this.cls = aVar;
            this.$liveData = mutableLiveData;
        }

        public final void run() {
            this.clr.b(this.cls);
            this.$liveData.setValue(com.iqoption.util.ba.a.a(ba.dww, null, 1, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FeedViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData $liveData;

        g(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.$liveData.setValue(com.iqoption.util.ba.a.a(ba.dww, th, th.getMessage(), null, 4, null));
        }
    }

    public final LiveData<ba<com.iqoption.feed.a.a>> cL(boolean z) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        a.cle.a(mutableLiveData, z);
        return mutableLiveData;
    }

    public final LiveData<ba<com.iqoption.feed.a.a>> ep(int i) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.postValue(com.iqoption.util.ba.a.b(ba.dww, null, 1, null));
        a.cle.a(mutableLiveData, i);
        return mutableLiveData;
    }

    public final void h(int i, String str) {
        h.e(str, Param.TYPE);
        com.iqoption.core.microservices.feed.a.aVN.a(i, str, 0).b(com.iqoption.core.h.i.Yo()).a(new d(i), new e(i));
    }

    public final LiveData<ba<Void>> a(com.iqoption.core.microservices.feed.response.a aVar) {
        h.e(aVar, "feedItem");
        int i = aVar.VS() ? 2 : 1;
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(com.iqoption.util.ba.a.b(ba.dww, null, 1, null));
        com.iqoption.core.microservices.feed.a.aVN.a(aVar.getId(), aVar.getType(), i).b(com.iqoption.core.h.i.Yo()).a(com.iqoption.core.h.i.Yp()).a(new f(this, aVar, mutableLiveData), new g(mutableLiveData));
        return mutableLiveData;
    }

    public final LiveData<ba<Void>> b(com.iqoption.feed.feedlist.e eVar) {
        h.e(eVar, "adapterItem");
        com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(com.iqoption.util.ba.a.b(ba.dww, null, 1, null));
        com.iqoption.core.microservices.feed.a.aVN.a(ags.getId(), ags.getType(), 3).b(com.iqoption.core.h.i.Yo()).a(com.iqoption.core.h.i.Yp()).a(new b(eVar, mutableLiveData), new c(mutableLiveData));
        return mutableLiveData;
    }

    public final void E(Collection<? extends InstrumentType> collection) {
        h.e(collection, "instruments");
        for (InstrumentType instrumentType : collection) {
            if (!this.cln.contains(instrumentType)) {
                this.cln.add(instrumentType);
                y.a(true, instrumentType);
            }
        }
    }

    protected void onCleared() {
        for (InstrumentType a : this.cln) {
            y.a(false, a);
        }
        super.onCleared();
    }

    private final void b(com.iqoption.core.microservices.feed.response.a aVar) {
        boolean VS = aVar.VS();
        aVar.ch(VS ^ 1);
        new FeedViewModel$toggleLikeFeed$ratingChange$1(VS).invoke(aVar);
    }
}
