package com.iqoption.core.a.a;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.gson.JsonObject;
import com.iqoption.core.connect.m;
import com.iqoption.core.data.model.InstrumentType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004789:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007J\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J9\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0015J(\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J6\u0010&\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J/\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\"\u0010.\u001a\u00020\n2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010/\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007J\u001a\u00100\u001a\u00020\n2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010\u000b\u001a\u00020\u001eJ\u001a\u00101\u001a\u00020\n2\n\u00102\u001a\u0006\u0012\u0002\b\u0003032\u0006\u0010\f\u001a\u00020\rJ$\u00104\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ$\u00105\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001a\u00106\u001a\u00020\n2\n\u00102\u001a\u0006\u0012\u0002\b\u0003032\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, aXE = {"Lcom/iqoption/core/analytics/sla/TradingSla;", "", "()V", "analytics", "Lcom/iqoption/core/analytics/IQAnalytics;", "sentCreatedPositions", "", "", "sentOrderCreated", "absentExpiration", "", "activeId", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "expirationPeriod", "createClosePositionEvent", "Lcom/iqoption/core/analytics/AnalyticsEvent;", "openPosition", "isBuy", "", "externalId", "", "balanceType", "orderCreated", "orderId", "status", "rejectStatus", "placeOrderTempErrorResponse", "error", "statusCode", "", "(JLjava/lang/String;Lcom/iqoption/core/data/model/InstrumentType;Ljava/lang/String;Ljava/lang/Integer;)V", "placeOrderTempResponse", "future", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/core/microservices/tradingengine/response/order/PlaceOrderResult;", "requestId", "placeOrderTempSuccessResponse", "positionCreated", "orderIds", "", "positionId", "sendClosePositionErrorEvent", "event", "(Lcom/iqoption/core/analytics/AnalyticsEvent;JLjava/lang/String;Ljava/lang/Integer;)V", "sendClosePositionSuccessEvent", "trackGetExpirationList", "type", "trackGetFirstCandles", "trackGetInstruments", "request", "Lio/reactivex/Single;", "trackGetSpotList", "trackGetStrikeList", "trackGetUnderlyingList", "DocumentTrack", "DocumentTrackInstrument", "DocumentTrackStrike", "DocumentTrackUnderlying", "core_release"})
/* compiled from: TradingSla.kt */
public final class a {
    private static final com.iqoption.core.a.e aMD = com.iqoption.core.f.RQ().Ds();
    private static final Set<Long> aME = new LinkedHashSet();
    private static final Set<Long> aMF = new LinkedHashSet();
    public static final a aMG = new a();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/analytics/sla/TradingSla$DocumentTrack;", "Lcom/google/common/util/concurrent/FutureCallback;", "", "eventName", "", "activeId", "", "(Ljava/lang/String;I)V", "getActiveId", "()I", "event", "Lcom/iqoption/core/analytics/AnalyticsPropertyEvent;", "onFailure", "", "t", "", "onSuccess", "result", "core_release"})
    /* compiled from: TradingSla.kt */
    private static final class a implements n<Object> {
        private final com.iqoption.core.a.b aMH;
        private final int activeId;

        public a(String str, int i) {
            kotlin.jvm.internal.h.e(str, "eventName");
            this.activeId = i;
            com.iqoption.core.a.b b = a.aMD.b(str, 0.0d, null, false);
            kotlin.jvm.internal.h.d(b, "analytics.createSystemEv…ntName, 0.0, null, false)");
            this.aMH = b;
        }

        public void onSuccess(Object obj) {
            com.iqoption.core.a.b bVar = this.aMH;
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("active-id", Integer.valueOf(this.activeId)).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(1));
            bVar.Bs();
        }

        /* JADX WARNING: Missing block: B:13:0x001e, code:
            if (r6 != null) goto L_0x0023;
     */
        public void l(java.lang.Throwable r6) {
            /*
            r5 = this;
            r0 = r6 instanceof com.iqoption.core.connect.m;
            r1 = 0;
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            r2 = r1;
            goto L_0x0008;
        L_0x0007:
            r2 = r6;
        L_0x0008:
            r2 = (com.iqoption.core.connect.m) r2;
            r3 = 0;
            if (r2 == 0) goto L_0x0012;
        L_0x000d:
            r2 = r2.getCode();
            goto L_0x0013;
        L_0x0012:
            r2 = 0;
        L_0x0013:
            if (r0 != 0) goto L_0x0016;
        L_0x0015:
            r6 = r1;
        L_0x0016:
            r6 = (com.iqoption.core.connect.m) r6;
            if (r6 == 0) goto L_0x0021;
        L_0x001a:
            r6 = r6.getMessage();
            if (r6 == 0) goto L_0x0021;
        L_0x0020:
            goto L_0x0023;
        L_0x0021:
            r6 = "";
        L_0x0023:
            r0 = r5.aMH;
            r1 = com.iqoption.core.util.i.ZZ();
            r4 = "error";
            r6 = r1.l(r4, r6);
            r1 = "status-code";
            r2 = java.lang.Integer.valueOf(r2);
            r6 = r6.l(r1, r2);
            r1 = "active-id";
            r2 = r5.activeId;
            r2 = java.lang.Integer.valueOf(r2);
            r6 = r6.l(r1, r2);
            r6 = r6.aab();
            r1 = "JsonUtils.createJsonBuil…                 .build()";
            kotlin.jvm.internal.h.d(r6, r1);
            r0.a(r6);
            r6 = java.lang.Integer.valueOf(r3);
            r6 = (java.lang.Number) r6;
            r0.a(r6);
            r0.Bs();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.a.a.a.a.l(java.lang.Throwable):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/analytics/sla/TradingSla$DocumentTrackInstrument;", "Lcom/google/common/util/concurrent/FutureCallback;", "", "eventName", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "(Ljava/lang/String;Lcom/iqoption/core/data/model/InstrumentType;)V", "event", "Lcom/iqoption/core/analytics/AnalyticsPropertyEvent;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "onFailure", "", "t", "", "onSuccess", "result", "core_release"})
    /* compiled from: TradingSla.kt */
    private static final class b implements n<Object> {
        private final com.iqoption.core.a.b aMH;
        private final InstrumentType instrumentType;

        public b(String str, InstrumentType instrumentType) {
            kotlin.jvm.internal.h.e(str, "eventName");
            kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
            this.instrumentType = instrumentType;
            com.iqoption.core.a.b b = a.aMD.b(str, 0.0d, null, false);
            kotlin.jvm.internal.h.d(b, "analytics.createSystemEv…ntName, 0.0, null, false)");
            this.aMH = b;
        }

        public void onSuccess(Object obj) {
            com.iqoption.core.a.b bVar = this.aMH;
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("instrument-type", this.instrumentType).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(1));
            bVar.Bs();
        }

        /* JADX WARNING: Missing block: B:13:0x001e, code:
            if (r6 != null) goto L_0x0023;
     */
        public void l(java.lang.Throwable r6) {
            /*
            r5 = this;
            r0 = r6 instanceof com.iqoption.core.connect.m;
            r1 = 0;
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            r2 = r1;
            goto L_0x0008;
        L_0x0007:
            r2 = r6;
        L_0x0008:
            r2 = (com.iqoption.core.connect.m) r2;
            r3 = 0;
            if (r2 == 0) goto L_0x0012;
        L_0x000d:
            r2 = r2.getCode();
            goto L_0x0013;
        L_0x0012:
            r2 = 0;
        L_0x0013:
            if (r0 != 0) goto L_0x0016;
        L_0x0015:
            r6 = r1;
        L_0x0016:
            r6 = (com.iqoption.core.connect.m) r6;
            if (r6 == 0) goto L_0x0021;
        L_0x001a:
            r6 = r6.getMessage();
            if (r6 == 0) goto L_0x0021;
        L_0x0020:
            goto L_0x0023;
        L_0x0021:
            r6 = "";
        L_0x0023:
            r0 = r5.aMH;
            r1 = com.iqoption.core.util.i.ZZ();
            r4 = "error";
            r6 = r1.l(r4, r6);
            r1 = "status-code";
            r2 = java.lang.Integer.valueOf(r2);
            r6 = r6.l(r1, r2);
            r1 = "instrument-type";
            r2 = r5.instrumentType;
            r6 = r6.l(r1, r2);
            r6 = r6.aab();
            r1 = "JsonUtils.createJsonBuil…                 .build()";
            kotlin.jvm.internal.h.d(r6, r1);
            r0.a(r6);
            r6 = java.lang.Integer.valueOf(r3);
            r6 = (java.lang.Number) r6;
            r0.a(r6);
            r0.Bs();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.a.a.a.b.l(java.lang.Throwable):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0017\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, aXE = {"Lcom/iqoption/core/analytics/sla/TradingSla$DocumentTrackStrike;", "Lcom/google/common/util/concurrent/FutureCallback;", "", "eventName", "", "activeId", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "(Ljava/lang/String;JLcom/iqoption/core/data/model/InstrumentType;)V", "getActiveId", "()J", "event", "Lcom/iqoption/core/analytics/AnalyticsPropertyEvent;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "onFailure", "", "t", "", "onSuccess", "period", "(Ljava/lang/Long;)V", "core_release"})
    /* compiled from: TradingSla.kt */
    private static final class c implements n<Long> {
        private final com.iqoption.core.a.b aMH;
        private final long aMI;
        private final InstrumentType instrumentType;

        public c(String str, long j, InstrumentType instrumentType) {
            kotlin.jvm.internal.h.e(str, "eventName");
            kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
            this.aMI = j;
            this.instrumentType = instrumentType;
            com.iqoption.core.a.b b = a.aMD.b(str, 0.0d, null, false);
            kotlin.jvm.internal.h.d(b, "analytics.createSystemEv…ntName, 0.0, null, false)");
            this.aMH = b;
        }

        /* renamed from: m */
        public void onSuccess(Long l) {
            com.iqoption.core.a.b bVar = this.aMH;
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(this.aMI)).l("instrument-type", this.instrumentType).l("period", l).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(1));
            bVar.Bs();
        }

        /* JADX WARNING: Missing block: B:13:0x001e, code:
            if (r7 != null) goto L_0x0023;
     */
        public void l(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = r7 instanceof com.iqoption.core.connect.m;
            r1 = 0;
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            r2 = r1;
            goto L_0x0008;
        L_0x0007:
            r2 = r7;
        L_0x0008:
            r2 = (com.iqoption.core.connect.m) r2;
            r3 = 0;
            if (r2 == 0) goto L_0x0012;
        L_0x000d:
            r2 = r2.getCode();
            goto L_0x0013;
        L_0x0012:
            r2 = 0;
        L_0x0013:
            if (r0 != 0) goto L_0x0016;
        L_0x0015:
            r7 = r1;
        L_0x0016:
            r7 = (com.iqoption.core.connect.m) r7;
            if (r7 == 0) goto L_0x0021;
        L_0x001a:
            r7 = r7.getMessage();
            if (r7 == 0) goto L_0x0021;
        L_0x0020:
            goto L_0x0023;
        L_0x0021:
            r7 = "";
        L_0x0023:
            r0 = r6.aMH;
            r1 = com.iqoption.core.util.i.ZZ();
            r4 = "error";
            r7 = r1.l(r4, r7);
            r1 = "status-code";
            r2 = java.lang.Integer.valueOf(r2);
            r7 = r7.l(r1, r2);
            r1 = "active-id";
            r4 = r6.aMI;
            r2 = java.lang.Long.valueOf(r4);
            r7 = r7.l(r1, r2);
            r1 = "instrument-type";
            r2 = r6.instrumentType;
            r7 = r7.l(r1, r2);
            r7 = r7.aab();
            r1 = "JsonUtils.createJsonBuil…                 .build()";
            kotlin.jvm.internal.h.d(r7, r1);
            r0.a(r7);
            r7 = java.lang.Integer.valueOf(r3);
            r7 = (java.lang.Number) r7;
            r0.a(r7);
            r0.Bs();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.a.a.a.c.l(java.lang.Throwable):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/core/analytics/sla/TradingSla$DocumentTrackUnderlying;", "Lcom/google/common/util/concurrent/FutureCallback;", "", "eventName", "", "activeId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "(Ljava/lang/String;JLcom/iqoption/core/data/model/InstrumentType;)V", "getActiveId", "()J", "event", "Lcom/iqoption/core/analytics/AnalyticsPropertyEvent;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "onFailure", "", "t", "", "onSuccess", "result", "core_release"})
    /* compiled from: TradingSla.kt */
    private static final class d implements n<Object> {
        private final com.iqoption.core.a.b aMH;
        private final long aMI;
        private final InstrumentType instrumentType;

        public d(String str, long j, InstrumentType instrumentType) {
            kotlin.jvm.internal.h.e(str, "eventName");
            kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
            this.aMI = j;
            this.instrumentType = instrumentType;
            com.iqoption.core.a.b b = a.aMD.b(str, 0.0d, null, false);
            kotlin.jvm.internal.h.d(b, "analytics.createSystemEv…ntName, 0.0, null, false)");
            this.aMH = b;
        }

        public void onSuccess(Object obj) {
            com.iqoption.core.a.b bVar = this.aMH;
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(this.aMI)).l("instrument-type", this.instrumentType).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(1));
            bVar.Bs();
        }

        /* JADX WARNING: Missing block: B:13:0x001e, code:
            if (r7 != null) goto L_0x0023;
     */
        public void l(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = r7 instanceof com.iqoption.core.connect.m;
            r1 = 0;
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            r2 = r1;
            goto L_0x0008;
        L_0x0007:
            r2 = r7;
        L_0x0008:
            r2 = (com.iqoption.core.connect.m) r2;
            r3 = 0;
            if (r2 == 0) goto L_0x0012;
        L_0x000d:
            r2 = r2.getCode();
            goto L_0x0013;
        L_0x0012:
            r2 = 0;
        L_0x0013:
            if (r0 != 0) goto L_0x0016;
        L_0x0015:
            r7 = r1;
        L_0x0016:
            r7 = (com.iqoption.core.connect.m) r7;
            if (r7 == 0) goto L_0x0021;
        L_0x001a:
            r7 = r7.getMessage();
            if (r7 == 0) goto L_0x0021;
        L_0x0020:
            goto L_0x0023;
        L_0x0021:
            r7 = "";
        L_0x0023:
            r0 = r6.aMH;
            r1 = com.iqoption.core.util.i.ZZ();
            r4 = "error";
            r7 = r1.l(r4, r7);
            r1 = "status-code";
            r2 = java.lang.Integer.valueOf(r2);
            r7 = r7.l(r1, r2);
            r1 = "active-id";
            r4 = r6.aMI;
            r2 = java.lang.Long.valueOf(r4);
            r7 = r7.l(r1, r2);
            r1 = "instrument-type";
            r2 = r6.instrumentType;
            r7 = r7.l(r1, r2);
            r7 = r7.aab();
            r1 = "JsonUtils.createJsonBuil…                 .build()";
            kotlin.jvm.internal.h.d(r7, r1);
            r0.a(r7);
            r7 = java.lang.Integer.valueOf(r3);
            r7 = (java.lang.Number) r7;
            r0.a(r7);
            r0.Bs();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.a.a.a.d.l(java.lang.Throwable):void");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, aXE = {"com/iqoption/core/analytics/sla/TradingSla$placeOrderTempResponse$1", "Lcom/google/common/util/concurrent/FutureCallback;", "Lcom/iqoption/core/microservices/tradingengine/response/order/PlaceOrderResult;", "onFailure", "", "t", "", "onSuccess", "result", "core_release"})
    /* compiled from: TradingSla.kt */
    public static final class e implements n<com.iqoption.core.microservices.tradingengine.response.c.a> {
        final /* synthetic */ long aMJ;
        final /* synthetic */ String aMK;
        final /* synthetic */ InstrumentType aqa;

        e(long j, String str, InstrumentType instrumentType) {
            this.aMJ = j;
            this.aMK = str;
            this.aqa = instrumentType;
        }

        /* renamed from: a */
        public void onSuccess(com.iqoption.core.microservices.tradingengine.response.c.a aVar) {
            if (aVar != null) {
                a aVar2 = a.aMG;
                long j = this.aMJ;
                String str = this.aMK;
                InstrumentType instrumentType = this.aqa;
                Long id = aVar.getId();
                aVar2.a(j, str, instrumentType, id != null ? id.longValue() : 0);
            }
        }

        public void l(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof m) {
                m mVar = (m) th2;
                a.aMG.a(this.aMJ, this.aMK, this.aqa, mVar.getMessage(), Integer.valueOf(mVar.getCode()));
                return;
            }
            a.aMG.a(this.aMJ, this.aMK, this.aqa, "", Integer.valueOf(0));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradingSla.kt */
    static final class f<T> implements io.reactivex.c.e<Object> {
        final /* synthetic */ b aML;

        f(b bVar) {
            this.aML = bVar;
        }

        public final void accept(Object obj) {
            this.aML.onSuccess(obj);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradingSla.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ b aML;

        g(b bVar) {
            this.aML = bVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.aML.l(th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradingSla.kt */
    static final class h<T> implements io.reactivex.c.e<Object> {
        final /* synthetic */ b aML;

        h(b bVar) {
            this.aML = bVar;
        }

        public final void accept(Object obj) {
            this.aML.onSuccess(obj);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TradingSla.kt */
    static final class i<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ b aML;

        i(b bVar) {
            this.aML = bVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.aML.l(th);
        }
    }

    private a() {
    }

    public final void a(boolean z, long j, String str, InstrumentType instrumentType, long j2) {
        kotlin.jvm.internal.h.e(str, "externalId");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        aMD.a("open-position", z ? 1.0d : 0.0d, com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("external-id", str).l("instrument-type", instrumentType).l("balance-type", Long.valueOf(j2)).aab(), false);
    }

    public final void a(long j, String str, String str2) {
        if (!aME.contains(Long.valueOf(j))) {
            aME.add(Long.valueOf(j));
            aMD.a("order-created", 0.0d, com.iqoption.core.util.i.ZZ().l("order-id", Long.valueOf(j)).l(NotificationCompat.CATEGORY_STATUS, str).l("reject-status", str2).aab(), false);
        }
    }

    public final void a(s<com.iqoption.core.microservices.tradingengine.response.c.a> sVar, InstrumentType instrumentType, long j, String str) {
        kotlin.jvm.internal.h.e(sVar, "future");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        kotlin.jvm.internal.h.e(str, "requestId");
        o.a(sVar, new e(j, str, instrumentType), MoreExecutors.vV());
    }

    private final void a(long j, String str, InstrumentType instrumentType, long j2) {
        aMD.a("place-order-temp-response", 1.0d, com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("external-id", str).l("order-id", Long.valueOf(j2)).l("instrument-type", instrumentType).aab(), false);
    }

    private final void a(long j, String str, InstrumentType instrumentType, String str2, Integer num) {
        aMD.a("place-order-temp-response", 0.0d, com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("external-id", str).l("instrument-type", instrumentType).l("error", str2).l("status-code", num).aab(), false);
    }

    public final void a(long j, List<Long> list, InstrumentType instrumentType, long j2, String str) {
        kotlin.jvm.internal.h.e(list, "orderIds");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        if (!aMF.contains(Long.valueOf(j2))) {
            aMF.add(Long.valueOf(j2));
            aMD.a("position-created", 1.0d, com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).c("order-ids", list).l("instrument-type", instrumentType).l("position-id", Long.valueOf(j2)).l(NotificationCompat.CATEGORY_STATUS, str).aab(), false);
        }
    }

    public final com.iqoption.core.a.a RV() {
        com.iqoption.core.a.b b = aMD.b("close-position", 0.0d, null, false);
        kotlin.jvm.internal.h.d(b, "analytics.createSystemEv…ition\", 0.0, null, false)");
        return b;
    }

    public final void a(com.iqoption.core.a.a aVar, long j, long j2) {
        kotlin.jvm.internal.h.e(aVar, "event");
        if (!(aVar instanceof com.iqoption.core.a.b)) {
            aVar = null;
        }
        com.iqoption.core.a.b bVar = (com.iqoption.core.a.b) aVar;
        if (bVar != null) {
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("position-id", Long.valueOf(j2)).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(1));
            bVar.Bs();
        }
    }

    public final void a(com.iqoption.core.a.a aVar, long j, String str, Integer num) {
        kotlin.jvm.internal.h.e(aVar, "event");
        if (!(aVar instanceof com.iqoption.core.a.b)) {
            aVar = null;
        }
        com.iqoption.core.a.b bVar = (com.iqoption.core.a.b) aVar;
        if (bVar != null) {
            JsonObject aab = com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("error", str).l("status-code", num).aab();
            kotlin.jvm.internal.h.d(aab, "JsonUtils.createJsonBuil…                 .build()");
            bVar.a(aab);
            bVar.a((Number) Integer.valueOf(0));
            bVar.Bs();
        }
    }

    public final void a(s<?> sVar, InstrumentType instrumentType, long j) {
        kotlin.jvm.internal.h.e(sVar, "future");
        kotlin.jvm.internal.h.e(instrumentType, Param.TYPE);
        o.a(sVar, new d("get-expiration-list", j, instrumentType), MoreExecutors.vV());
    }

    public final void a(long j, InstrumentType instrumentType, long j2) {
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        aMD.a("absent-expiration", 0.0d, com.iqoption.core.util.i.ZZ().l("active-id", Long.valueOf(j)).l("instrument-type", instrumentType).l("expiration-period", Long.valueOf(j2)).aab(), false);
    }

    public final void a(s<Long> sVar, long j, InstrumentType instrumentType) {
        kotlin.jvm.internal.h.e(sVar, "future");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        o.a(sVar, new c("get-strike-list", j, instrumentType), MoreExecutors.vV());
    }

    public final void b(s<Long> sVar, long j, InstrumentType instrumentType) {
        kotlin.jvm.internal.h.e(sVar, "future");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        o.a(sVar, new c("get-spot-list", j, instrumentType), MoreExecutors.vV());
    }

    public final void a(s<?> sVar, int i) {
        kotlin.jvm.internal.h.e(sVar, "future");
        o.a(sVar, new a("get-first-candles", i), MoreExecutors.vV());
    }

    public final void a(io.reactivex.o<?> oVar, InstrumentType instrumentType) {
        kotlin.jvm.internal.h.e(oVar, "request");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        b bVar = new b("get-underlying-list", instrumentType);
        oVar.h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new h(bVar), (io.reactivex.c.e) new i(bVar));
    }

    public final void b(io.reactivex.o<?> oVar, InstrumentType instrumentType) {
        kotlin.jvm.internal.h.e(oVar, "request");
        kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
        b bVar = new b("get-instruments", instrumentType);
        oVar.h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new f(bVar), (io.reactivex.c.e) new g(bVar));
    }
}
