package com.iqoption.core.gl;

import android.support.annotation.Keep;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@Keep
@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\t\n\u0002\b&\bg\u0018\u0000 ^2\u00020\u0001:\u0001^J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001H\u0016¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J0\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\fH\u0016J(\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0005H\u0016J \u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0015H\u0016J(\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0015H\u0016J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J \u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0016J0\u0010A\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00152\u0006\u0010B\u001a\u0002092\u0006\u00105\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u000fH\u0016J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0005H\u0016J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J@\u0010H\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020\u00152\u0006\u0010N\u001a\u00020\u0015H\u0016J\u0010\u0010O\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0015H\u0016J\u0010\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u000fH\u0016J\u0018\u0010R\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u0005H\u0016J\b\u0010T\u001a\u00020\u0003H\u0016J\b\u0010U\u001a\u00020\u0003H\u0016J\b\u0010V\u001a\u00020\u0003H\u0016J\b\u0010W\u001a\u00020\u0003H\u0016J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0015H\u0016J(\u0010[\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u0015H\u0016¨\u0006_"}, aXE = {"Lcom/iqoption/core/gl/GraphCallback;", "", "logCall", "", "name", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onAnalyticsEventButtonPressed", "eventName", "value", "", "onAnalyticsEventPopupServed", "isOpen", "", "onAskForSellingTradingPosition", "splitPositionId", "onBestActivePushed", "tabIndex", "idActive", "", "onCancelSelectChartQuote", "onChangeLimitOrderValue", "isCall", "onChangeStrikesDisplayMode", "displayMode", "onChangeTPSL", "takeProfitId", "stopLoseId", "takeProfitValue", "stopLoseValue", "onChangeVisibleTimeDelta", "time", "onClickSmallDealView", "optionType", "bets", "toptrader", "indxOpenTopDeals", "onClickTradersMoodView", "onCloseInstrument", "idx", "onCrossedReferenceTimeOnTimeScaleBar", "onEnlargeSellControl", "onFeeInfoPressed", "onFlagImageRequested", "country", "onImageByUrlRequested", "url", "onLineInstrumentEditEnd", "json", "onLiveDealsRequestedForExpiration", "activeId", "finInstrument", "expirationPeriodSec", "onLiveDealsRequestedForInterval", "fromSec", "", "toSec", "onNeedVibrate", "milliseconds", "onRequestMarginCall", "onSelectChartQuote", "quoteValue", "quoteVolume", "onSelectStrike", "expiration", "id", "isSpot", "onSelectTradingPosition", "positionId", "onSellTradingPosition", "onSendCandleRequest", "candleTime", "timestampFrom", "timestampTo", "fromId", "toId", "count", "onSendRequestForFirstCandles", "onSetStrikesAutoSelectionState", "enabled", "onSignalPressed", "typeId", "onTapChartTypeChangeButton", "onTapInstrumentsButton", "onTapRotationButton", "onTapTimeScaleBar", "onUpdateInstrumentParams", "onUserWeekPlaceAndProfitRequested", "userId", "onVisibleCandlesSizeChanged", "isSuccessful", "type", "Companion", "core_release"})
/* compiled from: GraphCallback.kt */
public interface GraphCallback {
    public static final a Companion = a.aQC;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/gl/GraphCallback$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "core_release"})
    /* compiled from: GraphCallback.kt */
    public static final class a {
        private static final String TAG = GraphCallback.class.getSimpleName();
        static final /* synthetic */ a aQC = new a();

        private a() {
        }
    }

    @i(aXC = {1, 1, 11})
    /* compiled from: GraphCallback.kt */
    public static final class b {
        public static void a(GraphCallback graphCallback, String str, Object... objArr) {
            h.e(str, "name");
            h.e(objArr, "args");
            if (f.Dp().DJ()) {
                if ((objArr.length == 0 ? 1 : null) != null) {
                    com.iqoption.core.i.d(a.TAG, str);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("(");
                    Object obj = null;
                    for (Object obj2 : objArr) {
                        if (obj != null) {
                            stringBuilder.append(", ");
                        } else {
                            obj = 1;
                        }
                        stringBuilder.append(obj2.toString());
                    }
                    stringBuilder.append(")");
                    String a = a.TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder = stringBuilder.insert(0, "(");
                    stringBuilder.append(")");
                    stringBuilder2.append(stringBuilder.toString());
                    com.iqoption.core.i.d(a, stringBuilder2.toString());
                }
            }
        }

        public static void a(GraphCallback graphCallback, int i) {
            graphCallback.logCall("sendRequestForFirstCandles", Integer.valueOf(i));
        }

        public static void a(GraphCallback graphCallback, int i, int i2, long j, long j2, int i3, int i4, int i5) {
            graphCallback.logCall("sendCandleRequest", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }

        public static void a(GraphCallback graphCallback, double d) {
            graphCallback.logCall("onChangeVisibleTimeDelta", Double.valueOf(d));
        }

        public static void b(GraphCallback graphCallback, double d) {
            graphCallback.logCall("onCrossedReferenceTimeOnTimeScaleBar", Double.valueOf(d));
        }

        public static void a(GraphCallback graphCallback, double d, double d2, double d3) {
            graphCallback.logCall("onSelectChartQuote", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
        }

        public static void a(GraphCallback graphCallback) {
            graphCallback.logCall("onCancelSelectChartQuote", new Object[0]);
        }

        public static void b(GraphCallback graphCallback) {
            graphCallback.logCall("onTapTimeScaleBar", new Object[0]);
        }

        public static void a(GraphCallback graphCallback, boolean z) {
            graphCallback.logCall("onSetStrikesAutoSelectionState", Boolean.valueOf(z));
        }

        public static void a(GraphCallback graphCallback, String str) {
            h.e(str, "splitPositionId");
            graphCallback.logCall("onRequestMarginCall", str);
        }

        public static void b(GraphCallback graphCallback, String str) {
            h.e(str, "splitPositionId");
            graphCallback.logCall("onFeeInfoPressed", str);
        }

        public static void a(GraphCallback graphCallback, double d, int i) {
            graphCallback.logCall("onChangeLimitOrderValue", Double.valueOf(d), Integer.valueOf(i));
        }

        public static void a(GraphCallback graphCallback, String str, String str2, String str3, double d, double d2) {
            h.e(str, "splitPositionId");
            h.e(str2, "takeProfitId");
            h.e(str3, "stopLoseId");
            graphCallback.logCall("onChangeTPSL", str, str2, str3, Double.valueOf(d), Double.valueOf(d2));
        }

        public static void b(GraphCallback graphCallback, int i) {
            graphCallback.logCall("onNeedVibrate", Integer.valueOf(i));
        }

        public static void c(GraphCallback graphCallback, int i) {
            graphCallback.logCall("onUpdateInstrumentParams", Integer.valueOf(i));
        }

        public static void d(GraphCallback graphCallback, int i) {
            graphCallback.logCall("onCloseInstrument", Integer.valueOf(i));
        }

        public static void c(GraphCallback graphCallback, String str) {
            h.e(str, "splitPositionId");
            graphCallback.logCall("onSellTradingPosition", str);
        }

        public static void d(GraphCallback graphCallback, String str) {
            h.e(str, "positionId");
            graphCallback.logCall("onSelectTradingPosition", str);
        }

        public static void c(GraphCallback graphCallback) {
            graphCallback.logCall("onEnlargeSellControl", new Object[0]);
        }

        public static void e(GraphCallback graphCallback, String str) {
            h.e(str, "json");
            graphCallback.logCall("onLineInstrumentEditEnd", str);
        }

        public static void a(GraphCallback graphCallback, int i, long j, String str, String str2, boolean z) {
            h.e(str, "finInstrument");
            h.e(str2, "id");
            graphCallback.logCall("onSelectStrike", Integer.valueOf(i), Long.valueOf(j), str, str2, Boolean.valueOf(z));
        }

        public static void a(GraphCallback graphCallback, String str, int i, boolean z, int i2) {
            h.e(str, "tabIndex");
            graphCallback.logCall("onVisibleCandlesSizeChanged", str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        }

        public static void a(GraphCallback graphCallback, String str, String str2, String str3, int i) {
            h.e(str, "optionType");
            h.e(str2, "bets");
            h.e(str3, "toptrader");
            graphCallback.logCall("onClickSmallDealView", str, str2, str3, Integer.valueOf(i));
        }

        public static void d(GraphCallback graphCallback) {
            graphCallback.logCall("onClickTradersMoodView", new Object[0]);
        }

        public static void a(GraphCallback graphCallback, String str, int i) {
            h.e(str, "tabIndex");
            graphCallback.logCall("onBestActivePushed", str, Integer.valueOf(i));
        }

        public static void a(GraphCallback graphCallback, int i, String str) {
            h.e(str, "typeId");
            graphCallback.logCall("onSignalPressed", Integer.valueOf(i), str);
        }

        public static void a(GraphCallback graphCallback, String str, boolean z, double d) {
            h.e(str, "eventName");
            graphCallback.logCall("onAnalyticsEventPopupServed", str, Boolean.valueOf(z), Double.valueOf(d));
        }

        public static void a(GraphCallback graphCallback, String str, double d) {
            h.e(str, "eventName");
            graphCallback.logCall("onAnalyticsEventButtonPressed", str, Double.valueOf(d));
        }

        public static void e(GraphCallback graphCallback) {
            graphCallback.logCall("onTapRotationButton", new Object[0]);
        }

        public static void f(GraphCallback graphCallback) {
            graphCallback.logCall("onTapInstrumentsButton", new Object[0]);
        }

        public static void g(GraphCallback graphCallback) {
            graphCallback.logCall("onTapChartTypeChangeButton", new Object[0]);
        }

        public static void e(GraphCallback graphCallback, int i) {
            graphCallback.logCall("onChangeStrikesDisplayMode", Integer.valueOf(i));
        }

        public static void a(GraphCallback graphCallback, int i, String str, long j, long j2) {
            h.e(str, "finInstrument");
            graphCallback.logCall("onLiveDealsRequestedForInterval", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2));
        }

        public static void a(GraphCallback graphCallback, int i, String str, int i2) {
            h.e(str, "finInstrument");
            graphCallback.logCall("onLiveDealsRequestedForExpiration", Integer.valueOf(i), str, Integer.valueOf(i2));
        }

        public static void f(GraphCallback graphCallback, String str) {
            h.e(str, "country");
            graphCallback.logCall("onFlagImageRequested", str);
        }

        public static void f(GraphCallback graphCallback, int i) {
            graphCallback.logCall("onUserWeekPlaceAndProfitRequested", Integer.valueOf(i));
        }

        public static void g(GraphCallback graphCallback, String str) {
            h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
            graphCallback.logCall("onImageByUrlRequested", str);
        }

        public static void h(GraphCallback graphCallback, String str) {
            h.e(str, "splitPositionId");
            graphCallback.logCall("onAskForSellingTradingPosition", str);
        }
    }

    void logCall(String str, Object... objArr);

    void onAnalyticsEventButtonPressed(String str, double d);

    void onAnalyticsEventPopupServed(String str, boolean z, double d);

    void onAskForSellingTradingPosition(String str);

    void onBestActivePushed(String str, int i);

    void onCancelSelectChartQuote();

    void onChangeLimitOrderValue(double d, int i);

    void onChangeStrikesDisplayMode(int i);

    void onChangeTPSL(String str, String str2, String str3, double d, double d2);

    void onChangeVisibleTimeDelta(double d);

    void onClickSmallDealView(String str, String str2, String str3, int i);

    void onClickTradersMoodView();

    void onCloseInstrument(int i);

    void onCrossedReferenceTimeOnTimeScaleBar(double d);

    void onEnlargeSellControl();

    void onFeeInfoPressed(String str);

    void onFlagImageRequested(String str);

    void onImageByUrlRequested(String str);

    void onLineInstrumentEditEnd(String str);

    void onLiveDealsRequestedForExpiration(int i, String str, int i2);

    void onLiveDealsRequestedForInterval(int i, String str, long j, long j2);

    void onNeedVibrate(int i);

    void onRequestMarginCall(String str);

    void onSelectChartQuote(double d, double d2, double d3);

    void onSelectStrike(int i, long j, String str, String str2, boolean z);

    void onSelectTradingPosition(String str);

    void onSellTradingPosition(String str);

    void onSendCandleRequest(int i, int i2, long j, long j2, int i3, int i4, int i5);

    void onSendRequestForFirstCandles(int i);

    void onSetStrikesAutoSelectionState(boolean z);

    void onSignalPressed(int i, String str);

    void onTapChartTypeChangeButton();

    void onTapInstrumentsButton();

    void onTapRotationButton();

    void onTapTimeScaleBar();

    void onUpdateInstrumentParams(int i);

    void onUserWeekPlaceAndProfitRequested(int i);

    void onVisibleCandlesSizeChanged(String str, int i, boolean z, int i2);
}
