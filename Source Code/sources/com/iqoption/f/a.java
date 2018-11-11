package com.iqoption.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.microservices.livedeals.ExpirationType;
import com.squareup.picasso.Picasso;
import io.reactivex.o;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001fH\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0007J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0018H\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, aXE = {"Lcom/iqoption/livedeals/LiveDealsHelper;", "", "()V", "LIVE_DEALS_REQUEST_COUNT", "", "TAG", "", "kotlin.jvm.PlatformType", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposeSubscriptions", "", "getBitmap", "Lio/reactivex/Maybe;", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "onLiveDealsRequestedForExpiration", "activeId", "finInstrument", "expirationPeriodSec", "onLiveDealsRequestedForInterval", "fromInSec", "", "toInSec", "onLiveDealsUpdateReceived", "liveDeal", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "onTopDealsLoaded", "liveDeals", "", "performFlagImageLoading", "country", "performImageLoading", "performUserWeekPlaceAndProfitLoading", "userId", "requestTopDeals", "Lio/reactivex/disposables/Disposable;", "params", "Lcom/iqoption/core/microservices/livedeals/params/LiveDealsParams;", "subscribeOnUpdates", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LiveDealsHelper.kt */
public final class a {
    private static final String TAG = "com.iqoption.f.a";
    private static io.reactivex.disposables.a bWG = new io.reactivex.disposables.a();
    public static final a cNO = new a();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/graphics/Bitmap;", "call"})
    /* compiled from: LiveDealsHelper.kt */
    static final class a<V> implements Callable<T> {
        final /* synthetic */ Context aCM;
        final /* synthetic */ String aZY;

        a(String str, Context context) {
            this.aZY = str;
            this.aCM = context;
        }

        /* renamed from: aqF */
        public final Bitmap call() {
            return this.aZY != null ? Picasso.with(this.aCM).load(this.aZY).get() : null;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "accept", "com/iqoption/livedeals/LiveDealsHelper$performFlagImageLoading$1$disposable$1"})
    /* compiled from: LiveDealsHelper.kt */
    static final class b<T> implements io.reactivex.c.e<Bitmap> {
        final /* synthetic */ String cNP;

        b(String str) {
            this.cNP = str;
        }

        /* renamed from: b */
        public final void accept(Bitmap bitmap) {
            com.iqoption.gl.b.aow().setRawImageByUrl(this.cNP, bitmap);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        public static final c cNQ = new c();

        c() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to load flag", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class d<T> implements io.reactivex.c.e<Bitmap> {
        final /* synthetic */ String aZY;

        d(String str) {
            this.aZY = str;
        }

        /* renamed from: b */
        public final void accept(Bitmap bitmap) {
            com.iqoption.gl.b.aow().setRawImageByUrl(this.aZY, bitmap);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        public static final e cNR = new e();

        e() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to load image", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "userInfo", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfo;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class f<T> implements io.reactivex.c.e<com.iqoption.core.microservices.c.a.a> {
        public static final f cNS = new f();

        f() {
        }

        /* renamed from: a */
        public final void accept(com.iqoption.core.microservices.c.a.a aVar) {
            com.iqoption.gl.b.aow().setUserWeekPlace(aVar.getUserId(), aVar.getPosition());
            com.iqoption.gl.b.aow().setUserWeekProfit(aVar.getUserId(), (int) aVar.Wb());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        public static final g cNT = new g();

        g() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("error", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "liveDeals", "", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class h<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.livedeals.response.a>> {
        public static final h cNU = new h();

        h() {
        }

        /* renamed from: C */
        public final void accept(List<? extends com.iqoption.core.microservices.livedeals.response.a> list) {
            a.cNO.aM(list);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class i<T> implements io.reactivex.c.e<Throwable> {
        public static final i cNV = new i();

        i() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Unable to load top deals", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "liveDeal", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class j<T> implements io.reactivex.c.e<com.iqoption.core.microservices.livedeals.response.a> {
        public static final j cNW = new j();

        j() {
        }

        /* renamed from: b */
        public final void accept(com.iqoption.core.microservices.livedeals.response.a aVar) {
            a aVar2 = a.cNO;
            kotlin.jvm.internal.h.d(aVar, "liveDeal");
            aVar2.a(aVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveDealsHelper.kt */
    static final class k<T> implements io.reactivex.c.e<Throwable> {
        public static final k cNX = new k();

        k() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.e("Fail during live deals subscription", th);
        }
    }

    private a() {
    }

    public static final void onLiveDealsRequestedForInterval(int i, String str, long j, long j2) {
        kotlin.jvm.internal.h.e(str, "finInstrument");
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLiveDealsRequestedForInterval activeId=");
        stringBuilder.append(i);
        stringBuilder.append("; instrumentType=");
        stringBuilder.append(str);
        stringBuilder.append("; fromInSec=");
        stringBuilder.append(j);
        stringBuilder.append("; toInSec=");
        stringBuilder.append(j2);
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        bWG.clear();
        com.iqoption.core.microservices.livedeals.a.c bVar = new com.iqoption.core.microservices.livedeals.a.b(i, InstrumentType.Companion.fromServerValue(str), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(300));
        bWG.e(cNO.i(bVar));
        bWG.e(cNO.j(bVar));
    }

    public static final void onLiveDealsRequestedForExpiration(int i, String str, int i2) {
        ExpirationType expirationType;
        kotlin.jvm.internal.h.e(str, "finInstrument");
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLiveDealsRequestedForExpiration activeId=");
        stringBuilder.append(i);
        stringBuilder.append("; instrumentType=");
        stringBuilder.append(str);
        stringBuilder.append("; expirationPeriodSec=");
        stringBuilder.append(i2);
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        bWG.clear();
        Object fromServerValue = InstrumentType.Companion.fromServerValue(str);
        if (!com.iqoption.core.ext.c.b(fromServerValue, InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT, InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.FX_INSTRUMENT)) {
            expirationType = null;
        } else if (((long) i2) <= TimeUnit.MINUTES.toSeconds(1)) {
            expirationType = ExpirationType.PT1M;
        } else {
            expirationType = ExpirationType.PT5M;
        }
        com.iqoption.core.microservices.livedeals.a.c aVar = new com.iqoption.core.microservices.livedeals.a.a(i, fromServerValue, expirationType);
        bWG.e(cNO.i(aVar));
        bWG.e(cNO.j(aVar));
    }

    public static final void id(String str) {
        kotlin.jvm.internal.h.e(str, "country");
        String aA = com.iqoption.core.util.f.bgP.aA(str);
        if (aA != null) {
            bWG.e(cNO.A(com.iqoption.core.f.RR(), aA).f(com.iqoption.core.h.i.Yo()).e(com.iqoption.core.h.i.Yr()).a(new b(str), c.cNQ));
        }
    }

    public static final void ie(String str) {
        kotlin.jvm.internal.h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
        bWG.e(cNO.A(com.iqoption.core.f.RR(), str).f(com.iqoption.core.h.i.Yo()).e(com.iqoption.core.h.i.Yr()).a(new d(str), e.cNR));
    }

    public static final void bB(long j) {
        bWG.e(com.iqoption.core.microservices.c.a.aWv.aX(j).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yr()).a((io.reactivex.c.e) f.cNS, (io.reactivex.c.e) g.cNT));
    }

    public static final void aqE() {
        bWG.clear();
    }

    private final io.reactivex.disposables.b i(com.iqoption.core.microservices.livedeals.a.c cVar) {
        o c;
        switch (b.aoS[cVar.getInstrumentType().ordinal()]) {
            case 1:
            case 2:
                c = com.iqoption.core.microservices.livedeals.a.aWC.c(cVar);
                break;
            case 3:
                c = com.iqoption.core.microservices.livedeals.a.aWC.e(cVar);
                break;
            case 4:
                c = com.iqoption.core.microservices.livedeals.a.aWC.g(cVar);
                break;
            default:
                c = com.iqoption.core.microservices.livedeals.a.aWC.a(cVar);
                break;
        }
        io.reactivex.disposables.b a = c.h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yr()).a((io.reactivex.c.e) h.cNU, (io.reactivex.c.e) i.cNV);
        kotlin.jvm.internal.h.d(a, "command\n                …rror) }\n                )");
        return a;
    }

    private final void aM(List<? extends com.iqoption.core.microservices.livedeals.response.a> list) {
        if (list != null) {
            boolean z = true;
            if ((list.isEmpty() ^ 1) == 1) {
                Graph aow = com.iqoption.gl.b.aow();
                aow.startLiveDealBatchInsertion();
                for (com.iqoption.core.microservices.livedeals.response.a aVar : list) {
                    long userId = aVar.getUserId();
                    double UO = aVar.UO();
                    long Wh = aVar.Wh();
                    int activeId = aVar.getActiveId();
                    String optionActiveOrInstrumentValue = aVar.getInstrumentType().getOptionActiveOrInstrumentValue();
                    boolean E = kotlin.jvm.internal.h.E(aVar.Wk(), Boolean.valueOf(z));
                    com.iqoption.core.microservices.livedeals.response.a aVar2 = aVar;
                    aow.addLiveDealUnsafe(userId, UO, Wh, 0.0d, activeId, optionActiveOrInstrumentValue, E, aVar.isCall());
                    String name = aVar2.getName();
                    if (name == null) {
                        name = "";
                    }
                    String str = name;
                    name = aVar2.Wj();
                    if (name == null) {
                        name = "";
                    }
                    String str2 = name;
                    aow.setUserMainInfo(aVar2.getUserId(), aVar2.getFlag(), aVar2.Wi(), str, str2);
                    z = true;
                }
                aow.finishLiveDealBatchInsertion();
            }
        }
    }

    private final io.reactivex.disposables.b j(com.iqoption.core.microservices.livedeals.a.c cVar) {
        io.reactivex.e d;
        switch (b.auk[cVar.getInstrumentType().ordinal()]) {
            case 1:
            case 2:
                d = com.iqoption.core.microservices.livedeals.a.aWC.d(cVar);
                break;
            case 3:
                d = com.iqoption.core.microservices.livedeals.a.aWC.f(cVar);
                break;
            case 4:
                d = com.iqoption.core.microservices.livedeals.a.aWC.h(cVar);
                break;
            default:
                d = com.iqoption.core.microservices.livedeals.a.aWC.b(cVar);
                break;
        }
        io.reactivex.disposables.b a = d.d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yr()).a((io.reactivex.c.e) j.cNW, (io.reactivex.c.e) k.cNX);
        kotlin.jvm.internal.h.d(a, "updates\n                …rror) }\n                )");
        return a;
    }

    private final void a(com.iqoption.core.microservices.livedeals.response.a aVar) {
        Graph aow = com.iqoption.gl.b.aow();
        aow.addNewLiveDeal(aVar.getUserId(), aVar.UO(), aVar.Wh(), 0.0d, aVar.getActiveId(), aVar.getInstrumentType().getOptionActiveOrInstrumentValue(), kotlin.jvm.internal.h.E(aVar.Wk(), Boolean.valueOf(true)), aVar.isCall());
        String name = aVar.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        name = aVar.Wj();
        if (name == null) {
            name = "";
        }
        String str2 = name;
        aow.setUserMainInfo(aVar.getUserId(), aVar.getFlag(), aVar.Wi(), str, str2);
    }

    private final io.reactivex.i<Bitmap> A(Context context, String str) {
        io.reactivex.i<Bitmap> f = io.reactivex.i.f((Callable) new a(str, context));
        kotlin.jvm.internal.h.d(f, "Maybe.fromCallable<Bitma…)\n            }\n        }");
        return f;
    }
}
