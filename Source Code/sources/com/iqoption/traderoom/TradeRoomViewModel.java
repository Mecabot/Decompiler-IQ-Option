package com.iqoption.traderoom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import com.iqoption.app.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.result.BalanceListResult;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.protrader.dialog.ProTraderDialogType;
import com.iqoption.util.ag;
import com.iqoption.verify.NonVerifiedCardsViewModel;
import io.reactivex.o;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Pair;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u000389:B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00120\u001cH\u0002J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J$\u0010+\u001a\u00020#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u001a\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020!R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006;"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "action", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "getAction", "()Landroid/arch/lifecycle/LiveData;", "actionData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "localStatusRepository", "Lcom/iqoption/verify/VerifyLocalStatusesRepository;", "nonVerifiedCardsViewModel", "Lcom/iqoption/verify/NonVerifiedCardsViewModel;", "checkCardStatusChanges", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "cards", "getChangedStatuses", "localStatuses", "Lcom/iqoption/verify/VerifyStatus;", "actualCards", "getImportantProApplicationChanges", "Lcom/iqoption/microservice/regulators/response/StatusType;", "getLocalStatuses", "Lio/reactivex/Single;", "getProTraderNotification", "Lio/reactivex/Maybe;", "Lcom/iqoption/protrader/dialog/ProTraderDialogType;", "isCardVerificationFailed", "", "loadBalances", "", "onBalancesLoaded", "Lio/reactivex/functions/Action;", "openActive", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "activeId", "", "persistLocalStatuses", "local", "changed", "playVideo", "videoUrl", "", "revealRect", "Landroid/graphics/Rect;", "showIndicatorSettings", "input", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "showIndicatorsLibrary", "openLibrary", "Action", "Companion", "Open", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TradeRoomViewModel.kt */
public final class TradeRoomViewModel extends AndroidViewModel {
    private static final String TAG = "TradeRoomViewModel";
    public static final b dsq = new b();
    private final com.iqoption.core.data.b.b<a> cjI = new com.iqoption.core.data.b.b();
    private final LiveData<a> cjJ = this.cjI;
    private NonVerifiedCardsViewModel dso;
    private com.iqoption.verify.b dsp;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "", "()V", "OpenAsset", "PlayVideo", "ShowIndicatorSettings", "ShowIndicatorsLibrary", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action$ShowIndicatorSettings;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action$ShowIndicatorsLibrary;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action$OpenAsset;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action$PlayVideo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TradeRoomViewModel.kt */
    public static abstract class a {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Action$OpenAsset;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "activeId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "(ILcom/iqoption/core/data/model/InstrumentType;)V", "getActiveId", "()I", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: TradeRoomViewModel.kt */
        public static final class a extends a {
            private final int activeId;
            private final InstrumentType instrumentType;

            public a(int i, InstrumentType instrumentType) {
                kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
                super();
                this.activeId = i;
                this.instrumentType = instrumentType;
            }

            public final int getActiveId() {
                return this.activeId;
            }

            public final InstrumentType getInstrumentType() {
                return this.instrumentType;
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Action$PlayVideo;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "videoUrl", "", "revealRect", "Landroid/graphics/Rect;", "(Ljava/lang/String;Landroid/graphics/Rect;)V", "getRevealRect", "()Landroid/graphics/Rect;", "getVideoUrl", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: TradeRoomViewModel.kt */
        public static final class b extends a {
            private final String aBS;
            private final Rect cvZ;

            public b(String str, Rect rect) {
                kotlin.jvm.internal.h.e(str, "videoUrl");
                super();
                this.aBS = str;
                this.cvZ = rect;
            }

            public final String Mk() {
                return this.aBS;
            }

            public final Rect aEH() {
                return this.cvZ;
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Action$ShowIndicatorSettings;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "input", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "(Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;)V", "getInput", "()Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: TradeRoomViewModel.kt */
        public static final class c extends a {
            private final com.iqoption.charttools.constructor.c dsr;

            public c(com.iqoption.charttools.constructor.c cVar) {
                kotlin.jvm.internal.h.e(cVar, "input");
                super();
                this.dsr = cVar;
            }

            public final com.iqoption.charttools.constructor.c aEI() {
                return this.dsr;
            }
        }

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Action$ShowIndicatorsLibrary;", "Lcom/iqoption/traderoom/TradeRoomViewModel$Action;", "openLibrary", "", "(Z)V", "getOpenLibrary", "()Z", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: TradeRoomViewModel.kt */
        public static final class d extends a {
            private final boolean dss;

            public d(boolean z) {
                super();
                this.dss = z;
            }

            public final boolean aEJ() {
                return this.dss;
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/traderoom/TradeRoomViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/traderoom/TradeRoomViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TradeRoomViewModel.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final TradeRoomViewModel B(FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(TradeRoomViewModel.class);
            TradeRoomViewModel tradeRoomViewModel = (TradeRoomViewModel) h;
            tradeRoomViewModel.dso = NonVerifiedCardsViewModel.dxj.E(fragmentActivity);
            com.iqoption.verify.b.a aVar = com.iqoption.verify.b.dxt;
            Context applicationContext = fragmentActivity.getApplicationContext();
            kotlin.jvm.internal.h.d(applicationContext, "activity.applicationContext");
            tradeRoomViewModel.dsp = aVar.bU(applicationContext);
            kotlin.jvm.internal.h.d(h, "ViewModelProviders.of(ac…xt)\n                    }");
            return tradeRoomViewModel;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class l implements Runnable {
        public static final l dsz = new l();

        l() {
        }

        public final void run() {
            com.iqoption.core.i.i(TradeRoomViewModel.TAG, "card statuses updated");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0001\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003 \u0006*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002 \u0006*B\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003 \u0006*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/iqoption/verify/VerifyStatus;", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "kotlin.jvm.PlatformType", "remote", "apply"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, s<? extends R>> {
        final /* synthetic */ TradeRoomViewModel dst;

        c(TradeRoomViewModel tradeRoomViewModel) {
            this.dst = tradeRoomViewModel;
        }

        /* renamed from: bm */
        public final o<Pair<List<com.iqoption.verify.d>, List<q>>> apply(final List<q> list) {
            kotlin.jvm.internal.h.e(list, "remote");
            return this.dst.aEG().n(new io.reactivex.c.f<T, R>() {
                /* renamed from: bn */
                public final Pair<List<com.iqoption.verify.d>, List<q>> apply(List<com.iqoption.verify.d> list) {
                    kotlin.jvm.internal.h.e(list, "local");
                    return new Pair(list, list);
                }
            });
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/iqoption/verify/VerifyStatus;", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<Pair<? extends List<? extends com.iqoption.verify.d>, ? extends List<? extends q>>> {
        final /* synthetic */ TradeRoomViewModel dst;

        d(TradeRoomViewModel tradeRoomViewModel) {
            this.dst = tradeRoomViewModel;
        }

        /* renamed from: c */
        public final void accept(Pair<? extends List<com.iqoption.verify.d>, ? extends List<q>> pair) {
            List list = (List) pair.aXG();
            List list2 = (List) pair.aXH();
            TradeRoomViewModel tradeRoomViewModel = this.dst;
            kotlin.jvm.internal.h.d(list, "local");
            kotlin.jvm.internal.h.d(list2, "remote");
            tradeRoomViewModel.h(list, list2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001e\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/iqoption/verify/VerifyStatus;", "apply"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ TradeRoomViewModel dst;

        e(TradeRoomViewModel tradeRoomViewModel) {
            this.dst = tradeRoomViewModel;
        }

        /* renamed from: d */
        public final List<q> apply(Pair<? extends List<com.iqoption.verify.d>, ? extends List<q>> pair) {
            kotlin.jvm.internal.h.e(pair, "<name for destructuring parameter 0>");
            List list = (List) pair.aXG();
            List list2 = (List) pair.aXH();
            TradeRoomViewModel tradeRoomViewModel = this.dst;
            kotlin.jvm.internal.h.d(list, "local");
            return tradeRoomViewModel.g(list, list2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lkotlin/Pair;", "Lcom/iqoption/microservice/regulators/response/StatusType;", "new", "Lcom/iqoption/microservice/regulators/response/ProTraderApplicationStatus;", "apply"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ long $userId;
        final /* synthetic */ af dsv;

        f(af afVar, long j) {
            this.dsv = afVar;
            this.$userId = j;
        }

        /* renamed from: b */
        public final Pair<StatusType, StatusType> apply(com.iqoption.microservice.regulators.response.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "new");
            return new Pair(this.dsv.ak(this.$userId), aVar.ata());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0005*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/iqoption/microservice/regulators/response/StatusType;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<Pair<? extends StatusType, ? extends StatusType>> {
        final /* synthetic */ long $userId;
        final /* synthetic */ af dsv;

        g(af afVar, long j) {
            this.dsv = afVar;
            this.$userId = j;
        }

        /* renamed from: c */
        public final void accept(Pair<? extends StatusType, ? extends StatusType> pair) {
            this.dsv.a(this.$userId, (StatusType) pair.aXH());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/iqoption/microservice/regulators/response/StatusType;", "test"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class h<T> implements io.reactivex.c.k<Pair<? extends StatusType, ? extends StatusType>> {
        final /* synthetic */ long $userId;
        final /* synthetic */ af dsv;

        h(af afVar, long j) {
            this.dsv = afVar;
            this.$userId = j;
        }

        /* renamed from: e */
        public final boolean test(Pair<? extends StatusType, ? extends StatusType> pair) {
            kotlin.jvm.internal.h.e(pair, "<name for destructuring parameter 0>");
            StatusType statusType = (StatusType) pair.aXG();
            Object obj = (StatusType) pair.aXH();
            this.dsv.a(this.$userId, (StatusType) obj);
            if (!(statusType == null || statusType == obj)) {
                if (com.iqoption.core.ext.c.b(obj, StatusType.APPROVED, StatusType.DECLINED)) {
                    return true;
                }
            }
            return false;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/regulators/response/StatusType;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "apply"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class i<T, R> implements io.reactivex.c.f<T, R> {
        public static final i dsw = new i();

        i() {
        }

        /* renamed from: f */
        public final StatusType apply(Pair<? extends StatusType, ? extends StatusType> pair) {
            kotlin.jvm.internal.h.e(pair, "<name for destructuring parameter 0>");
            StatusType statusType = (StatusType) pair.aXH();
            if (statusType == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            return statusType;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/iqoption/protrader/dialog/ProTraderDialogType;", "kotlin.jvm.PlatformType", "notification", "Lcom/iqoption/microservice/regulators/response/ProTraderNotification;", "apply"})
    /* compiled from: TradeRoomViewModel.kt */
    static final class j<T, R> implements io.reactivex.c.f<T, io.reactivex.k<? extends R>> {
        final /* synthetic */ String dsx;

        j(String str) {
            this.dsx = str;
        }

        /* renamed from: a */
        public final io.reactivex.i<ProTraderDialogType> apply(com.iqoption.microservice.regulators.response.b bVar) {
            kotlin.jvm.internal.h.e(bVar, "notification");
            boolean atb = bVar.atb();
            if (atb && kotlin.jvm.internal.h.E(this.dsx, "pro-benefits")) {
                return io.reactivex.i.bZ(ProTraderDialogType.PRO_BENEFITS);
            }
            if (atb && kotlin.jvm.internal.h.E(this.dsx, "selected-reminder")) {
                return io.reactivex.i.bZ(ProTraderDialogType.PRO_SELECTED_REMINDER);
            }
            return io.reactivex.i.aWe();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, aXE = {"com/iqoption/traderoom/TradeRoomViewModel$loadBalances$1", "Lcom/iqoption/system/future/CheckFutureCallback;", "Lcom/iqoption/dto/entity/result/BalanceListResult;", "fail", "", "t", "", "ok", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TradeRoomViewModel.kt */
    public static final class k extends com.iqoption.system.c.a<BalanceListResult> {
        final /* synthetic */ io.reactivex.c.a dsy;

        k(io.reactivex.c.a aVar) {
            this.dsy = aVar;
        }

        /* renamed from: a */
        public void bF(BalanceListResult balanceListResult) {
            kotlin.jvm.internal.h.e(balanceListResult, "result");
            com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
            kotlin.jvm.internal.h.d(Cw, "IQAccount.instance()");
            Cw.a(balanceListResult.getMapBalance());
            this.dsy.run();
        }

        public void N(Throwable th) {
            kotlin.jvm.internal.h.e(th, "t");
            com.iqoption.core.i.e(TradeRoomViewModel.TAG, "balance error", th);
        }
    }

    public static final TradeRoomViewModel B(FragmentActivity fragmentActivity) {
        return dsq.B(fragmentActivity);
    }

    public TradeRoomViewModel(Application application) {
        kotlin.jvm.internal.h.e(application, "app");
        super(application);
    }

    public final LiveData<a> aeS() {
        return this.cjJ;
    }

    public final io.reactivex.e<List<q>> aEC() {
        return e(com.iqoption.verify.a.dxq.cn(com.iqoption.app.a.Cw().getUserId()));
    }

    public final io.reactivex.e<List<q>> e(io.reactivex.e<List<q>> eVar) {
        kotlin.jvm.internal.h.e(eVar, "cards");
        eVar = eVar.c((io.reactivex.c.f) new c(this)).a((io.reactivex.c.e) new d(this)).d((io.reactivex.c.f) new e(this)).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp());
        kotlin.jvm.internal.h.d(eVar, "cards.flatMapSingle { re…           .observeOn(ui)");
        return eVar;
    }

    public final LiveData<Boolean> aED() {
        NonVerifiedCardsViewModel nonVerifiedCardsViewModel = this.dso;
        if (nonVerifiedCardsViewModel == null) {
            kotlin.jvm.internal.h.lS("nonVerifiedCardsViewModel");
        }
        return nonVerifiedCardsViewModel.aED();
    }

    public final io.reactivex.i<ProTraderDialogType> aEE() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("pro-trader-notification");
        String str = fd != null ? fd.status : null;
        Application application = getApplication();
        kotlin.jvm.internal.h.d(application, "getApplication()");
        io.reactivex.i<ProTraderDialogType> aWe;
        if (!com.iqoption.protrader.f.b(application, null, 2, null) || kotlin.jvm.internal.h.E(str, "disabled")) {
            aWe = io.reactivex.i.aWe();
            kotlin.jvm.internal.h.d(aWe, "Maybe.empty()");
            return aWe;
        }
        aWe = com.iqoption.protrader.g.ddT.ayz().l(new j(str)).f(com.iqoption.core.h.i.Yo()).e(com.iqoption.core.h.i.Yp());
        kotlin.jvm.internal.h.d(aWe, "RegulatorsRepository.get…           .observeOn(ui)");
        return aWe;
    }

    public final io.reactivex.e<StatusType> aEF() {
        long userId = com.iqoption.app.a.aL((Context) getApplication()).getUserId();
        af aR = af.aR((Context) getApplication());
        io.reactivex.e<StatusType> aVU;
        if (aR.ak(userId) == StatusType.APPROVED) {
            aVU = io.reactivex.e.aVU();
            kotlin.jvm.internal.h.d(aVU, "Flowable.empty()");
            return aVU;
        }
        aVU = com.iqoption.protrader.g.ddT.bO(userId).d((io.reactivex.c.f) new f(aR, userId)).a((io.reactivex.c.e) new g(aR, userId)).a((io.reactivex.c.k) new h(aR, userId)).d((io.reactivex.c.f) i.dsw).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp());
        kotlin.jvm.internal.h.d(aVU, "RegulatorsRepository.get…           .observeOn(ui)");
        return aVU;
    }

    private final List<q> g(List<com.iqoption.verify.d> list, List<q> list2) {
        if (list2 == null) {
            return m.emptyList();
        }
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(Long.valueOf(((com.iqoption.verify.d) next).getId()), next);
        }
        Collection arrayList = new ArrayList();
        for (Object next2 : list2) {
            boolean z;
            q qVar = (q) next2;
            com.iqoption.verify.d dVar = (com.iqoption.verify.d) linkedHashMap.get(Long.valueOf(qVar.getId()));
            CardStatus auX = dVar != null ? dVar.auX() : null;
            if (auX == null || auX == qVar.auX()) {
                z = false;
            } else {
                z = b.dsA.contains(qVar.auX());
            }
            if (z) {
                arrayList.add(next2);
            }
        }
        return (List) arrayList;
    }

    private final o<List<com.iqoption.verify.d>> aEG() {
        com.iqoption.verify.b bVar = this.dsp;
        if (bVar == null) {
            kotlin.jvm.internal.h.lS("localStatusRepository");
        }
        o<List<com.iqoption.verify.d>> f = o.f((Future) bVar.aGM());
        kotlin.jvm.internal.h.d(f, "Single.fromFuture(localS…tory.getVerifyStatuses())");
        return f;
    }

    private final void h(List<com.iqoption.verify.d> list, List<q> list2) {
        Iterable<q> iterable = list2;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (q id : iterable) {
            arrayList.add(Long.valueOf(id.getId()));
        }
        Set Y = u.Y((List) arrayList);
        Collection arrayList2 = new ArrayList();
        for (Object next : list) {
            if ((Y.contains(Long.valueOf(((com.iqoption.verify.d) next).getId())) ^ 1) != 0) {
                arrayList2.add(next);
            }
        }
        arrayList2 = (List) arrayList2;
        Collection arrayList3 = new ArrayList(n.e(iterable, 10));
        for (q d : iterable) {
            arrayList3.add(com.iqoption.verify.d.dxx.d(d));
        }
        List b = u.b(arrayList2, (Iterable) (List) arrayList3);
        com.iqoption.verify.b bVar = this.dsp;
        if (bVar == null) {
            kotlin.jvm.internal.h.lS("localStatusRepository");
        }
        bVar.bt(b).a(l.dsz, com.iqoption.core.d.a.aSc);
    }

    public final void a(io.reactivex.c.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "onBalancesLoaded");
        ag.b(com.iqoption.mobbtech.connect.request.a.a.b.A(BalanceListResult.class).ga("get-balances").Sa(), new k(aVar));
    }

    public final void d(com.iqoption.charttools.constructor.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "input");
        this.cjI.setValue(new c(cVar));
    }

    public final void eY(boolean z) {
        this.cjI.setValue(new d(z));
    }

    public final void c(InstrumentType instrumentType, int i) {
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        this.cjI.setValue(new a(i, instrumentType));
    }

    public final void a(String str, Rect rect) {
        kotlin.jvm.internal.h.e(str, "videoUrl");
        this.cjI.setValue(new b(str, rect));
    }
}
