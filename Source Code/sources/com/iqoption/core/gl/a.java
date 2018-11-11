package com.iqoption.core.gl;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.gl.GraphCallback.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/core/gl/DefaultGraphCallback;", "Lcom/iqoption/core/gl/GraphCallback;", "()V", "core_release"})
/* compiled from: DefaultGraphCallback.kt */
public class a implements GraphCallback {
    public void logCall(String str, Object... objArr) {
        h.e(str, "name");
        h.e(objArr, "args");
        b.a((GraphCallback) this, str, objArr);
    }

    public void onAnalyticsEventButtonPressed(String str, double d) {
        h.e(str, "eventName");
        b.a((GraphCallback) this, str, d);
    }

    public void onAnalyticsEventPopupServed(String str, boolean z, double d) {
        h.e(str, "eventName");
        b.a((GraphCallback) this, str, z, d);
    }

    public void onAskForSellingTradingPosition(String str) {
        h.e(str, "splitPositionId");
        b.h(this, str);
    }

    public void onBestActivePushed(String str, int i) {
        h.e(str, "tabIndex");
        b.a((GraphCallback) this, str, i);
    }

    public void onCancelSelectChartQuote() {
        b.a(this);
    }

    public void onChangeLimitOrderValue(double d, int i) {
        b.a((GraphCallback) this, d, i);
    }

    public void onChangeStrikesDisplayMode(int i) {
        b.e((GraphCallback) this, i);
    }

    public void onChangeTPSL(String str, String str2, String str3, double d, double d2) {
        h.e(str, "splitPositionId");
        h.e(str2, "takeProfitId");
        h.e(str3, "stopLoseId");
        b.a((GraphCallback) this, str, str2, str3, d, d2);
    }

    public void onChangeVisibleTimeDelta(double d) {
        b.a((GraphCallback) this, d);
    }

    public void onClickSmallDealView(String str, String str2, String str3, int i) {
        h.e(str, "optionType");
        h.e(str2, "bets");
        h.e(str3, "toptrader");
        b.a((GraphCallback) this, str, str2, str3, i);
    }

    public void onClickTradersMoodView() {
        b.d(this);
    }

    public void onCloseInstrument(int i) {
        b.d((GraphCallback) this, i);
    }

    public void onCrossedReferenceTimeOnTimeScaleBar(double d) {
        b.b((GraphCallback) this, d);
    }

    public void onEnlargeSellControl() {
        b.c(this);
    }

    public void onFeeInfoPressed(String str) {
        h.e(str, "splitPositionId");
        b.b((GraphCallback) this, str);
    }

    public void onFlagImageRequested(String str) {
        h.e(str, "country");
        b.f((GraphCallback) this, str);
    }

    public void onImageByUrlRequested(String str) {
        h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
        b.g(this, str);
    }

    public void onLineInstrumentEditEnd(String str) {
        h.e(str, "json");
        b.e((GraphCallback) this, str);
    }

    public void onLiveDealsRequestedForExpiration(int i, String str, int i2) {
        h.e(str, "finInstrument");
        b.a((GraphCallback) this, i, str, i2);
    }

    public void onLiveDealsRequestedForInterval(int i, String str, long j, long j2) {
        h.e(str, "finInstrument");
        b.a((GraphCallback) this, i, str, j, j2);
    }

    public void onNeedVibrate(int i) {
        b.b((GraphCallback) this, i);
    }

    public void onRequestMarginCall(String str) {
        h.e(str, "splitPositionId");
        b.a((GraphCallback) this, str);
    }

    public void onSelectChartQuote(double d, double d2, double d3) {
        b.a((GraphCallback) this, d, d2, d3);
    }

    public void onSelectStrike(int i, long j, String str, String str2, boolean z) {
        h.e(str, "finInstrument");
        h.e(str2, "id");
        b.a((GraphCallback) this, i, j, str, str2, z);
    }

    public void onSelectTradingPosition(String str) {
        h.e(str, "positionId");
        b.d((GraphCallback) this, str);
    }

    public void onSellTradingPosition(String str) {
        h.e(str, "splitPositionId");
        b.c((GraphCallback) this, str);
    }

    public void onSendCandleRequest(int i, int i2, long j, long j2, int i3, int i4, int i5) {
        b.a(this, i, i2, j, j2, i3, i4, i5);
    }

    public void onSendRequestForFirstCandles(int i) {
        b.a((GraphCallback) this, i);
    }

    public void onSetStrikesAutoSelectionState(boolean z) {
        b.a((GraphCallback) this, z);
    }

    public void onSignalPressed(int i, String str) {
        h.e(str, "typeId");
        b.a((GraphCallback) this, i, str);
    }

    public void onTapChartTypeChangeButton() {
        b.g(this);
    }

    public void onTapInstrumentsButton() {
        b.f(this);
    }

    public void onTapRotationButton() {
        b.e(this);
    }

    public void onTapTimeScaleBar() {
        b.b(this);
    }

    public void onUpdateInstrumentParams(int i) {
        b.c((GraphCallback) this, i);
    }

    public void onUserWeekPlaceAndProfitRequested(int i) {
        b.f((GraphCallback) this, i);
    }

    public void onVisibleCandlesSizeChanged(String str, int i, boolean z, int i2) {
        h.e(str, "tabIndex");
        b.a((GraphCallback) this, str, i, z, i2);
    }
}
