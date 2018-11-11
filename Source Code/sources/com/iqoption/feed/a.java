package com.iqoption.feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.s;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.feed.FeedFetcher;
import com.iqoption.core.feed.j;
import com.iqoption.core.microservices.feed.response.FeedItem;
import com.iqoption.util.ba;
import com.iqoption.util.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000fJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u00180%J.\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*\u0018\u00010\u00132\u0006\u0010,\u001a\u00020\u0006H\u0002J(\u0010-\u001a\u00020\u001c2\u0016\b\u0002\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*\u0018\u00010\u00132\b\b\u0002\u0010,\u001a\u00020\u0006J\"\u0010.\u001a\u00020\u001c2\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0\u00132\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020\u001cH\u0002J\u000e\u00102\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0014J\u0006\u00105\u001a\u00020\u001cJ\u0006\u00106\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u00180\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, aXE = {"Lcom/iqoption/feed/FeedRepository;", "", "()V", "FETCH_UPDATE_PERIOD", "", "NOTIFY_UPDATE_PERIOD", "", "firstInstruments", "", "Lcom/iqoption/core/data/model/InstrumentType;", "firstItems", "", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "pendingUpdateEventMap", "", "Lcom/iqoption/core/microservices/feed/response/FeedItemUpdateEvent;", "prefetchingFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "removeItemLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/feed/feedlist/FeedAdapterItem;", "getRemoveItemLiveData", "()Landroid/arch/lifecycle/MutableLiveData;", "updateEventLiveData", "", "updateExecutor", "Lcom/iqoption/util/SparseUiExecutor;", "applyChangeEvent", "", "item", "event", "collectInstrumentTypes", "", "items", "", "Lcom/iqoption/core/microservices/feed/response/FeedItem;", "getEventsLiveData", "Landroid/arch/lifecycle/LiveData;", "handleFeed", "feedResponse", "Lcom/iqoption/core/microservices/feed/response/FeedListResponse;", "liveData", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/feed/FeedRepository$FeedItemsHolder;", "from", "loadFeed", "loadInitialFeed", "force", "", "notifyFeedUpdateEvents", "onFeedUpdateEvent", "onItemRemoved", "feedAdapterItem", "startPrefetch", "stopPrefetch", "FeedItemsHolder", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FeedRepository.kt */
public final class a {
    private static s<?> ckW;
    private static final List<com.iqoption.core.microservices.feed.response.a> ckX = new ArrayList();
    private static final MutableLiveData<com.iqoption.feed.feedlist.e> ckY = new MutableLiveData();
    private static final Set<InstrumentType> ckZ = new LinkedHashSet();
    private static final MutableLiveData<Map<Integer, com.iqoption.core.microservices.feed.response.d>> clb = new MutableLiveData();
    private static final Map<Integer, com.iqoption.core.microservices.feed.response.d> clc = new LinkedHashMap();
    private static final bd cld = new bd(FeedRepository$updateExecutor$1.clm, 5000);
    public static final a cle = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, aXE = {"Lcom/iqoption/feed/FeedRepository$FeedItemsHolder;", "", "count", "", "hasMore", "", "items", "", "Lcom/iqoption/core/microservices/feed/response/CommonFeedItem;", "instrumentTypes", "", "Lcom/iqoption/core/data/model/InstrumentType;", "(IZLjava/util/List;Ljava/util/Collection;)V", "getCount", "()I", "getHasMore", "()Z", "getInstrumentTypes", "()Ljava/util/Collection;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FeedRepository.kt */
    public static final class a {
        private final boolean aWg;
        private final Collection<InstrumentType> clf;
        private final int count;
        private final List<com.iqoption.core.microservices.feed.response.a> nj;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if ((this.count == aVar.count ? 1 : null) != null) {
                    return (this.aWg == aVar.aWg ? 1 : null) != null && h.E(this.nj, aVar.nj) && h.E(this.clf, aVar.clf);
                }
            }
        }

        public int hashCode() {
            int i = this.count * 31;
            int i2 = this.aWg;
            if (i2 != 0) {
                i2 = 1;
            }
            i = (i + i2) * 31;
            List list = this.nj;
            int i3 = 0;
            i = (i + (list != null ? list.hashCode() : 0)) * 31;
            Collection collection = this.clf;
            if (collection != null) {
                i3 = collection.hashCode();
            }
            return i + i3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FeedItemsHolder(count=");
            stringBuilder.append(this.count);
            stringBuilder.append(", hasMore=");
            stringBuilder.append(this.aWg);
            stringBuilder.append(", items=");
            stringBuilder.append(this.nj);
            stringBuilder.append(", instrumentTypes=");
            stringBuilder.append(this.clf);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(int i, boolean z, List<com.iqoption.core.microservices.feed.response.a> list, Collection<? extends InstrumentType> collection) {
            h.e(list, "items");
            h.e(collection, "instrumentTypes");
            this.count = i;
            this.aWg = z;
            this.nj = list;
            this.clf = collection;
        }

        public final int getCount() {
            return this.count;
        }

        public final boolean VW() {
            return this.aWg;
        }

        public final List<com.iqoption.core.microservices.feed.response.a> getItems() {
            return this.nj;
        }

        public final Collection<InstrumentType> afL() {
            return this.clf;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedRepository.kt */
    static final class b implements Runnable {
        final /* synthetic */ int clh;
        final /* synthetic */ List cli;
        final /* synthetic */ List clj;
        final /* synthetic */ Set clk;

        b(int i, List list, List list2, Set set) {
            this.clh = i;
            this.cli = list;
            this.clj = list2;
            this.clk = set;
        }

        public final void run() {
            if (this.clh == 0) {
                List<j> g = u.g(this.cli, 16);
                a.ckX.clear();
                a.ckX.addAll(this.clj);
                a.ckZ.addAll(this.clk);
                for (j a : g) {
                    com.iqoption.core.feed.a.aPQ.a(a);
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedRepository.kt */
    static final class e implements Runnable {
        final /* synthetic */ MutableLiveData $liveData;

        e(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        public final void run() {
            a.a(a.cle, this.$liveData, 0, 2, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedRepository.kt */
    static final class f implements Runnable {
        public static final f cll = new f();

        f() {
        }

        public final void run() {
            a.a(a.cle, null, 0, 3, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "feedResponse", "Lcom/iqoption/core/microservices/feed/response/FeedListResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FeedRepository.kt */
    static final class c<T> implements io.reactivex.c.e<com.iqoption.core.microservices.feed.response.e> {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ int clh;

        c(MutableLiveData mutableLiveData, int i) {
            this.$liveData = mutableLiveData;
            this.clh = i;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.core.microservices.feed.response.e eVar) {
            a aVar = a.cle;
            h.d(eVar, "feedResponse");
            aVar.a(eVar, this.$liveData, this.clh);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FeedRepository.kt */
    static final class d<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData $liveData;

        d(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            MutableLiveData mutableLiveData = this.$liveData;
            if (mutableLiveData != null) {
                mutableLiveData.postValue(com.iqoption.util.ba.a.a(ba.dww, th, th.getMessage(), null, 4, null));
            }
        }
    }

    private a() {
    }

    public final MutableLiveData<com.iqoption.feed.feedlist.e> afG() {
        return ckY;
    }

    public final void a(com.iqoption.core.microservices.feed.response.d dVar) {
        h.e(dVar, "event");
        synchronized (this) {
            clc.put(Integer.valueOf(dVar.getId()), dVar);
            l lVar = l.etX;
        }
        cld.execute();
    }

    public final void afH() {
        s sVar = ckW;
        if (sVar != null) {
            sVar.cancel(true);
        }
        ckW = com.iqoption.core.d.a.aSc.a(f.cll, 0, 5, TimeUnit.MINUTES);
    }

    public final void afI() {
        s sVar = ckW;
        if (sVar != null) {
            sVar.cancel(true);
        }
        ckW = (s) null;
    }

    public final LiveData<Map<Integer, com.iqoption.core.microservices.feed.response.d>> afJ() {
        return clb;
    }

    public final void a(MutableLiveData<ba<a>> mutableLiveData, boolean z) {
        h.e(mutableLiveData, "liveData");
        if (ckX.isEmpty()) {
            mutableLiveData.postValue(com.iqoption.util.ba.a.b(ba.dww, null, 1, null));
        } else {
            List arrayList = new ArrayList();
            arrayList.addAll(ckX);
            mutableLiveData.setValue(ba.dww.bK(new a(arrayList.size(), false, arrayList, ckZ)));
        }
        if (ckX.isEmpty() || z) {
            a(this, mutableLiveData, 0, 2, null);
        } else {
            com.iqoption.core.d.a.aSe.postDelayed(new e(mutableLiveData), 1000);
        }
    }

    public static /* bridge */ /* synthetic */ void a(a aVar, MutableLiveData mutableLiveData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = (MutableLiveData) null;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        aVar.a(mutableLiveData, i);
    }

    public final void a(MutableLiveData<ba<a>> mutableLiveData, int i) {
        if (com.iqoption.app.managers.feature.a.eW("smart-feed")) {
            com.iqoption.core.microservices.feed.a.a(com.iqoption.core.microservices.feed.a.aVN, i, 0, null, 6, null).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new c(mutableLiveData, i), (io.reactivex.c.e) new d(mutableLiveData));
        }
    }

    private final void a(com.iqoption.core.microservices.feed.response.e eVar, MutableLiveData<ba<a>> mutableLiveData, int i) {
        Iterable<FeedItem> items = eVar.getItems();
        Collection arrayList = new ArrayList(n.e(items, 10));
        for (FeedItem feedItem : items) {
            FeedItem feedItem2;
            if (!(feedItem2 instanceof com.iqoption.core.microservices.feed.response.a)) {
                feedItem2 = null;
            }
            arrayList.add((com.iqoption.core.microservices.feed.response.a) feedItem2);
        }
        List W = u.W(u.S((List) arrayList));
        Iterable<com.iqoption.core.microservices.feed.response.a> iterable = W;
        Collection arrayList2 = new ArrayList(n.e(iterable, 10));
        for (com.iqoption.core.microservices.feed.response.a a : iterable) {
            arrayList2.add(FeedFetcher.aQo.a((FeedItem) a));
        }
        List list = (List) arrayList2;
        FeedFetcher.aQo.aj(list);
        Set ax = ax(W);
        if (mutableLiveData != null) {
            mutableLiveData.postValue(ba.dww.bK(new a(W.size(), eVar.VW(), W, ax)));
        }
        com.iqoption.core.d.a.aSe.post(new b(i, list, W, ax));
    }

    private final Set<InstrumentType> ax(List<? extends FeedItem> list) {
        return m.h(m.e(m.f(u.ac(list), FeedRepository$collectInstrumentTypes$1.clg)));
    }

    private final void afK() {
        Map linkedHashMap = new LinkedHashMap();
        synchronized (this) {
            linkedHashMap.putAll(clc);
            clc.clear();
            l lVar = l.etX;
        }
        for (com.iqoption.core.microservices.feed.response.a aVar : ckX) {
            com.iqoption.core.microservices.feed.response.d dVar = (com.iqoption.core.microservices.feed.response.d) linkedHashMap.get(Integer.valueOf(aVar.getId()));
            if (dVar != null) {
                cle.a(aVar, dVar);
            }
        }
        if ((linkedHashMap.isEmpty() ^ 1) != 0) {
            clb.postValue(linkedHashMap);
        }
    }

    public final void a(com.iqoption.feed.feedlist.e eVar) {
        h.e(eVar, "feedAdapterItem");
        ckX.remove(eVar.ags());
        ckY.postValue(eVar);
    }

    public final void a(com.iqoption.core.microservices.feed.response.a aVar, com.iqoption.core.microservices.feed.response.d dVar) {
        h.e(aVar, "item");
        h.e(dVar, "event");
        if (dVar.getUserId() != com.iqoption.app.a.Cw().getUserId()) {
            aVar.setRating(dVar.getRating());
        }
        aVar.dN(dVar.VV());
    }
}
