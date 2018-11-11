package com.iqoption.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.appsflyer.h;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.HitBuilders.ItemBuilder;
import com.google.android.gms.analytics.HitBuilders.TransactionBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.Functions;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.iqoption.analytics.EventManager;
import com.iqoption.analytics.f;
import com.iqoption.analytics.sla.Sla;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.core.connect.bus.IQBusState;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency.List;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.Feature.UpdateEvent;
import com.iqoption.dto.entity.init.AppInit.DepositStat;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.result.BalanceListResult;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.service.e.g;
import com.iqoption.service.e.j;
import com.iqoption.service.websocket.IQBusException;
import com.iqoption.system.IQFirebaseInstanceIDService;
import com.iqoption.util.Network;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import com.iqoption.util.k;
import io.reactivex.processors.PublishProcessor;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSocketHandler extends a implements com.iqoption.g.a {
    private static final String TAG = "com.iqoption.service.WebSocketHandler";
    private static final n<com.iqoption.g.a> dpP = Suppliers.a(h.ajD);
    private final com.iqoption.core.h.a<IQBusState> aMY = com.iqoption.core.h.a.bi(IQBusState.DISCONNECTED);
    private String dpE = "";
    private com.iqoption.mobbtech.connect.request.b dpH = null;
    private volatile ExecutorService dpI;
    private Handler dpJ;
    private volatile d dpK;
    private volatile boolean dpL;
    private c dpM = new c(this);
    private Queue<com.iqoption.service.websocket.a.b> dpN = new ConcurrentLinkedQueue();
    private com.iqoption.app.managers.b dpO = new com.iqoption.app.managers.b();
    @Nullable
    private volatile Future<?> dpQ;
    @NonNull
    private final AtomicInteger dpR = new AtomicInteger();
    @NonNull
    private final AtomicReference<Builder> dpS = new AtomicReference();
    private volatile State dpT = State.NONE;
    private volatile boolean dpU;
    private Builder dpV;
    final com.google.common.util.concurrent.n<List> dpW = new com.iqoption.system.c.a<List>() {
        /* renamed from: a */
        public void onSuccess(List list) {
            com.iqoption.app.a.Cw().z(list);
        }
    };
    final com.google.common.util.concurrent.n<List> dpX = new com.google.common.util.concurrent.n<List>() {
        /* renamed from: a */
        public void onSuccess(List list) {
            WebSocketHandler.this.dpW.onSuccess(list);
            WebSocketHandler.this.eP(true);
        }

        public void l(Throwable th) {
            WebSocketHandler.this.eP(false);
        }
    };
    private final Runnable dpY = new i(this);
    private final java.util.List<y<Void>> dpZ = new ArrayList();
    private volatile s<Void> dqa;
    private y<Object> dqb;
    private y<Object> dqc;
    private y<Object> dqd;
    private s<Void> dqe = y.wb();
    private final Set<Pair<Integer, InstrumentType>> dqf = Sets.uI();
    private final Set<Pair<Integer, Integer>> dqg = Sets.uI();
    private final ConcurrentHashMap<String, com.iqoption.service.websocket.a.b> dqh = new ConcurrentHashMap();
    private io.reactivex.processors.a<com.iqoption.core.connect.n> dqi = PublishProcessor.aXq().aXp();
    private io.reactivex.processors.a<String> dqj = PublishProcessor.aXq().aXp();
    private final Object lock = new Object();

    public enum State {
        NONE,
        RECONNECT,
        AUTHORIZED
    }

    private final class e extends Handler {
        private AtomicInteger dqu = new AtomicInteger();

        public e(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(IQApp.Dl().getClusterWebsocket());
                    stringBuilder.append("echo/websocket");
                    String stringBuilder2 = stringBuilder.toString();
                    final y wb = y.wb();
                    s sVar = wb;
                    f.Br().a(sVar, "echo/websocket", 60000, false, WebSocketHandler.aDm().aDz());
                    if (WebSocketHandler.this.dpK != null) {
                        WebSocketHandler.this.dpK.a(stringBuilder2, this.dqu.incrementAndGet(), new com.iqoption.service.d.a() {
                            public void gw(int i) {
                                wb.P(Boolean.TRUE);
                                WebSocketHandler.this.dpR.set(0);
                                String iK = WebSocketHandler.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("socket onOpen id=");
                                stringBuilder.append(i);
                                i.d(iK, stringBuilder.toString());
                                WebSocketHandler.this.aDx();
                                EventManager.Bm().a(WebSocketHandler.this.dpV.calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                                Builder builder = (Builder) WebSocketHandler.this.dpS.get();
                                if (builder != null) {
                                    EventManager.Bm().a(builder.calcDuration().setValue(Double.valueOf(1.0d)).build());
                                    WebSocketHandler.this.dpS.compareAndSet(builder, null);
                                }
                            }

                            public void a(int i, String str, StringReader stringReader) {
                                if (WebSocketHandler.this.dpU) {
                                    String iK = WebSocketHandler.TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("SocketMessage (socketId: ");
                                    stringBuilder.append(i);
                                    stringBuilder.append("):  ");
                                    stringBuilder.append(str);
                                    i.d(iK, stringBuilder.toString());
                                }
                                WebSocketHandler.this.a(str, stringReader);
                            }

                            public void a(int i, Throwable th, Response response) {
                                wb.h(th);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("connecting to socket error  (socketId: ");
                                stringBuilder.append(i);
                                stringBuilder.append(") Exception:");
                                stringBuilder.append(th == null ? "" : th.getMessage());
                                String stringBuilder2 = stringBuilder.toString();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("connecting to socket error Response:");
                                stringBuilder.append(response == null ? " " : response.toString());
                                String stringBuilder3 = stringBuilder.toString();
                                i.e(WebSocketHandler.TAG, stringBuilder2);
                                i.e(WebSocketHandler.TAG, stringBuilder3);
                                int i2 = e.this.dqu.get();
                                if (i != i2) {
                                    stringBuilder3 = WebSocketHandler.TAG;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("ignore onFailure for ");
                                    stringBuilder.append(i);
                                    stringBuilder.append(", current=");
                                    stringBuilder.append(i2);
                                    i.w(stringBuilder3, stringBuilder.toString());
                                } else if (WebSocketHandler.this.dpR.incrementAndGet() < 100) {
                                    WebSocketHandler.this.reconnect();
                                } else {
                                    WebSocketHandler.this.eP(false);
                                    Builder builder = (Builder) WebSocketHandler.this.dpS.get();
                                    if (builder != null) {
                                        EventManager.Bm().a(builder.calcDuration().setValue(Double.valueOf(0.0d)).build());
                                        WebSocketHandler.this.dpS.compareAndSet(builder, null);
                                    }
                                }
                            }

                            public void gx(int i) {
                                int i2 = e.this.dqu.get();
                                if (i == i2) {
                                    WebSocketHandler.this.aMY.e(IQBusState.DISCONNECTED);
                                    if (WebSocketHandler.this.dpL) {
                                        WebSocketHandler.this.aDy();
                                        WebSocketHandler.this.aDt();
                                        WebSocketHandler.this.dpT = State.NONE;
                                        return;
                                    }
                                    WebSocketHandler.this.aDw();
                                    return;
                                }
                                String iK = WebSocketHandler.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("ignore onClosed for ");
                                stringBuilder.append(i);
                                stringBuilder.append(", current=");
                                stringBuilder.append(i2);
                                i.w(iK, stringBuilder.toString());
                            }
                        });
                        break;
                    } else {
                        i.w(WebSocketHandler.TAG, "CONNECT_TO_WEB_SOCKET - delegate not initialized");
                        return;
                    }
                case 2:
                    WebSocketHandler.this.dpK.fV((String) message.obj);
                    break;
                case 3:
                    i.i(WebSocketHandler.TAG, "socket_trace handle close socket message");
                    WebSocketHandler.this.dpK.aDl();
                    break;
                case 4:
                    i.i(WebSocketHandler.TAG, "socket_trace disconnect socket message looper");
                    removeMessages(1);
                    removeMessages(2);
                    removeMessages(3);
                    WebSocketHandler.this.dpK = null;
                    getLooper().quit();
                    break;
            }
        }
    }

    private static class a extends com.iqoption.system.c.a<com.iqoption.microservice.quotes.history.response.d> {
        private final int activeId;
        private final int cJi;

        a(int i, int i2) {
            this.activeId = i;
            this.cJi = i2;
        }

        /* renamed from: a */
        public void bF(com.iqoption.microservice.quotes.history.response.d dVar) {
            if (dVar.cSD != null && dVar.cSD.length != 0) {
                com.iqoption.gl.b.aow().addCandleTimeUnsafeIds(dVar.cSD.length, this.activeId, this.cJi, dVar.cSD, dVar.cSB, dVar.cSC, dVar.cSE, dVar.cSF, dVar.cSH, dVar.cSG, dVar.cSI, dVar.cSJ);
            }
        }
    }

    private static class b extends com.iqoption.system.c.b<WebSocketHandler, Object> {
        /* synthetic */ b(WebSocketHandler webSocketHandler, AnonymousClass1 anonymousClass1) {
            this(webSocketHandler);
        }

        private b(WebSocketHandler webSocketHandler) {
            super(webSocketHandler, Object.class);
        }

        /* renamed from: a */
        public void z(@NonNull WebSocketHandler webSocketHandler, @NonNull Object obj) {
            i.d(WebSocketHandler.TAG, "configuration callback success");
            webSocketHandler.dpJ.sendEmptyMessage(1);
        }

        public void l(Throwable th) {
            i.d(WebSocketHandler.TAG, "configuration callback error", th);
        }
    }

    private static class c extends com.iqoption.system.a.e<WebSocketHandler> {
        public c(WebSocketHandler webSocketHandler) {
            super(webSocketHandler);
        }

        @com.google.common.b.e
        public void onFcmToken(com.iqoption.app.b.d.b bVar) {
            String iK = WebSocketHandler.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event=");
            stringBuilder.append(bVar);
            i.d(iK, stringBuilder.toString());
            com.iqoption.core.d.a.aSd.execute(new q(this));
        }

        final /* synthetic */ void aDE() {
            if (((WebSocketHandler) this.drU.get()) != null) {
                IQFirebaseInstanceIDService.aEo();
            }
        }

        @com.google.common.b.e
        public void onFeatureUpdateEvent(UpdateEvent updateEvent) {
            com.iqoption.core.d.a.aSd.execute(new r(this));
        }

        final /* synthetic */ void aDD() {
            WebSocketHandler webSocketHandler = (WebSocketHandler) this.drU.get();
            if (webSocketHandler != null) {
                com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
                int groupId = Cw.getGroupId();
                boolean Dh = Cw.Dh();
                if (com.iqoption.app.managers.feature.a.HH()) {
                    webSocketHandler.n(groupId, Dh);
                }
                if (com.iqoption.app.managers.feature.a.HK()) {
                    webSocketHandler.p(groupId, Dh);
                }
                if (com.iqoption.app.managers.feature.a.HL()) {
                    webSocketHandler.o(groupId, Dh);
                }
                if (com.iqoption.app.managers.feature.a.HM()) {
                    webSocketHandler.q(groupId, Dh);
                }
                if (com.iqoption.app.managers.feature.a.HI()) {
                    webSocketHandler.m(groupId, Cw.Dh());
                }
            }
        }

        @com.google.common.b.e
        public void onDebugShowWebSocketLogChanged(com.iqoption.app.b.d.a aVar) {
            WebSocketHandler webSocketHandler = (WebSocketHandler) this.drU.get();
            if (webSocketHandler != null) {
                webSocketHandler.dpU = ((Boolean) aVar.getValue()).booleanValue();
            }
        }
    }

    private static class d extends com.iqoption.system.c.a<com.iqoption.microservice.quotes.history.response.c> {
        private final int activeId;

        d(int i) {
            this.activeId = i;
        }

        /* renamed from: a */
        public void bF(@NonNull com.iqoption.microservice.quotes.history.response.c cVar) {
            if (cVar.cSD.length != 0) {
                com.iqoption.gl.b.aow().glchChartAddFirstCandlesUnsafe(cVar.cSD.length, this.activeId, cVar.cSD, cVar.cSB, cVar.cSC, cVar.cSE, cVar.cSF, cVar.cSH, cVar.cSG, cVar.cSI);
                com.iqoption.core.d.a.aSc.execute(new s(this, cVar));
            }
        }

        final /* synthetic */ void b(@NonNull com.iqoption.microservice.quotes.history.response.c cVar) {
            int min = Math.min(cVar.cSH.length, cVar.cSG.length);
            Set uI = Sets.uI();
            for (int i = 0; i < min; i++) {
                uI.add(Integer.valueOf((int) (cVar.cSC[i] - cVar.cSB[i])));
            }
            com.iqoption.app.managers.a.Gf().a(Integer.valueOf(this.activeId), uI);
        }
    }

    public static com.iqoption.g.a aDm() {
        return (com.iqoption.g.a) dpP.get();
    }

    public io.reactivex.e<IQBusState> RY() {
        return this.aMY;
    }

    public IQBusState RZ() {
        IQBusState iQBusState = (IQBusState) this.aMY.getValue();
        return iQBusState != null ? iQBusState : IQBusState.DISCONNECTED;
    }

    public boolean jF(String str) {
        return t(str, false);
    }

    public boolean t(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            i.r(new IllegalStateException("silent: try to send null message"));
            return true;
        } else if ((!z && this.dpT != State.AUTHORIZED) || this.dpJ == null) {
            return false;
        } else {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            this.dpJ.sendMessage(obtain);
            return true;
        }
    }

    @SuppressLint({"CheckResult"})
    public WebSocketHandler() {
        DH().c(new io.reactivex.c.e<Boolean>() {
            boolean dqo = false;

            /* renamed from: j */
            public void accept(Boolean bool) {
                if (bool != null && bool.booleanValue() != this.dqo) {
                    f.Br().g(Boolean.valueOf(this.dqo).booleanValue() ? "socket-connected" : "socket-disconnected", true);
                }
            }
        });
        this.dpM.register();
        this.dpU = af.DX().FB();
    }

    private void a(String str, StringReader stringReader) {
        try {
            JsonReader jsonReader = new JsonReader(stringReader);
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            Object obj = null;
            String str2 = null;
            int i = 2000;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("name")) {
                    str2 = jsonReader.nextString();
                } else if (nextName.equals("request_id")) {
                    obj = jsonReader.nextString();
                } else if (nextName.equals(NotificationCompat.CATEGORY_STATUS)) {
                    i = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            if (TextUtils.isEmpty(obj)) {
                synchronized (this.lock) {
                    if (this.dpI != null) {
                        this.dpI.execute(new k(this, str2, str));
                    }
                }
                return;
            }
            com.iqoption.core.d.a.aSd.execute(new j(this, obj, i, str));
        } catch (Throwable e) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onTextMessage error. ");
            stringBuilder.append(str);
            i.e(str3, stringBuilder.toString(), e);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Socket, onTextMessage error: ");
            stringBuilder2.append(str);
            k.log(stringBuilder2.toString());
            k.c(e);
        }
    }

    private void aDn() {
        synchronized (this.lock) {
            if (this.dpI != null) {
                this.dpI.shutdownNow();
            }
            this.dpI = Executors.newSingleThreadExecutor();
        }
    }

    private void aDo() {
        synchronized (this.lock) {
            if (this.dpI == null) {
                return;
            }
            this.dpI.shutdownNow();
            this.dpI = null;
        }
    }

    private boolean aDp() {
        synchronized (this.lock) {
            if (this.dpI == null) {
                return true;
            }
            boolean isShutdown = this.dpI.isShutdown();
            return isShutdown;
        }
    }

    private void d(String str, int i, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.iqoption.service.websocket.a.b jH = jH(str);
                if (jH == null) {
                    throw new NullPointerException("WebSocketEvents.RequestHandler == null");
                } else if (jH.dqx != null && jH.dqy != null) {
                    if (i < 0 || i >= ToastEntity.TOAST_DURATION) {
                        jH.dqy.h(new IQBusException(i, str2));
                        return;
                    }
                    try {
                        JsonReader jsonReader = new JsonReader(new StringReader(str2));
                        jsonReader.setLenient(true);
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.nextName().equals(NotificationCompat.CATEGORY_MESSAGE)) {
                                jH.dqy.P(jH.dqx.p(jsonReader));
                                break;
                            }
                            jsonReader.skipValue();
                        }
                        jsonReader.close();
                    } catch (Throwable e) {
                        jH.dqy.h(e);
                    }
                }
            }
        } catch (Throwable e2) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onTextMessage error. ");
            stringBuilder.append(str2);
            i.e(str3, stringBuilder.toString(), e2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Socket, onTextMessage error: ");
            stringBuilder2.append(str2);
            k.log(stringBuilder2.toString());
            k.c(e2);
        }
    }

    private void ay(String str, String str2) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str2));
            jsonReader.setLenient(true);
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(NotificationCompat.CATEGORY_MESSAGE)) {
                    b(str, jsonReader);
                    break;
                }
                jsonReader.skipValue();
            }
            jsonReader.close();
        } catch (Throwable e) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("_parseSocketResponse error. ");
            stringBuilder.append(str2);
            i.e(str3, stringBuilder.toString(), e);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Socket, _parseSocketResponse error: ");
            stringBuilder2.append(str2);
            k.log(stringBuilder2.toString());
            k.c(e);
        }
    }

    private JSONObject r(JsonReader jsonReader) {
        return new JSONObject(ah.aGi().parse(jsonReader).toString());
    }

    private JSONArray s(JsonReader jsonReader) {
        return new JSONArray(ah.aGi().parse(jsonReader).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:279:0x07e4 A:{Catch:{ Exception -> 0x0dc8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x07fa A:{Catch:{ Exception -> 0x0dc8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0808 A:{Catch:{ Exception -> 0x0dc8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x069e A:{Catch:{ Exception -> 0x0dc8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x069a A:{Catch:{ Exception -> 0x0dc8 }} */
    /* JADX WARNING: Missing block: B:171:0x03b3, code:
            r0 = r0.equals(r1);
     */
    private void b(java.lang.String r13, com.google.gson.stream.JsonReader r14) {
        /*
        r12 = this;
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r13.hashCode();	 Catch:{ Exception -> 0x0dc8 }
        r1 = 3;
        r2 = 2;
        r3 = -1;
        r4 = 1;
        r5 = 0;
        switch(r0) {
            case -2077379832: goto L_0x01da;
            case -2013495359: goto L_0x01cf;
            case -1916875860: goto L_0x01c4;
            case -1904237040: goto L_0x01b9;
            case -1848996403: goto L_0x01ae;
            case -1755879709: goto L_0x01a3;
            case -1718276641: goto L_0x0198;
            case -1635920301: goto L_0x018e;
            case -1401094566: goto L_0x0183;
            case -1170779926: goto L_0x0177;
            case -841665709: goto L_0x016b;
            case -823838745: goto L_0x015f;
            case -818154563: goto L_0x0153;
            case -682320075: goto L_0x0147;
            case -627183028: goto L_0x013b;
            case -595389697: goto L_0x012f;
            case -454420285: goto L_0x0124;
            case -343701767: goto L_0x0118;
            case -309425751: goto L_0x010d;
            case -189629463: goto L_0x0101;
            case -164809481: goto L_0x00f6;
            case -109686235: goto L_0x00ea;
            case 89921373: goto L_0x00de;
            case 97705513: goto L_0x00d3;
            case 163724294: goto L_0x00c7;
            case 200896764: goto L_0x00bb;
            case 245420141: goto L_0x00b0;
            case 271022332: goto L_0x00a4;
            case 323634397: goto L_0x0098;
            case 339144484: goto L_0x008c;
            case 608819105: goto L_0x0080;
            case 643209284: goto L_0x0075;
            case 849157253: goto L_0x0069;
            case 925957011: goto L_0x005d;
            case 1110373621: goto L_0x0051;
            case 1261262902: goto L_0x0045;
            case 1323755748: goto L_0x0039;
            case 1466823135: goto L_0x002d;
            case 2088265419: goto L_0x0021;
            case 2134311631: goto L_0x0015;
            default: goto L_0x0013;
        };	 Catch:{ Exception -> 0x0dc8 }
    L_0x0013:
        goto L_0x01e4;
    L_0x0015:
        r0 = "candle-generated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x001d:
        r0 = 8;
        goto L_0x01e5;
    L_0x0021:
        r0 = "signals";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0029:
        r0 = 21;
        goto L_0x01e5;
    L_0x002d:
        r0 = "instrument-quotes-generated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0035:
        r0 = 24;
        goto L_0x01e5;
    L_0x0039:
        r0 = "feature-updated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0041:
        r0 = 23;
        goto L_0x01e5;
    L_0x0045:
        r0 = "listInfoData";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x004d:
        r0 = 13;
        goto L_0x01e5;
    L_0x0051:
        r0 = "underlying-list-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0059:
        r0 = 28;
        goto L_0x01e5;
    L_0x005d:
        r0 = "user-emission-executed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0065:
        r0 = 36;
        goto L_0x01e5;
    L_0x0069:
        r0 = "last-quote";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0071:
        r0 = 26;
        goto L_0x01e5;
    L_0x0075:
        r0 = "user-loyalty";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x007d:
        r0 = 6;
        goto L_0x01e5;
    L_0x0080:
        r0 = "activeCommissionChange";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0088:
        r0 = 18;
        goto L_0x01e5;
    L_0x008c:
        r0 = "option-quote";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0094:
        r0 = 25;
        goto L_0x01e5;
    L_0x0098:
        r0 = "timeChange";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00a0:
        r0 = 9;
        goto L_0x01e5;
    L_0x00a4:
        r0 = "hf-signals";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00ac:
        r0 = 22;
        goto L_0x01e5;
    L_0x00b0:
        r0 = "buyback";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00b8:
        r0 = 1;
        goto L_0x01e5;
    L_0x00bb:
        r0 = "heartbeat";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00c3:
        r0 = 37;
        goto L_0x01e5;
    L_0x00c7:
        r0 = "traders-mood-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00cf:
        r0 = 16;
        goto L_0x01e5;
    L_0x00d3:
        r0 = "front";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00db:
        r0 = 2;
        goto L_0x01e5;
    L_0x00de:
        r0 = "feed-item-info-update";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00e6:
        r0 = 39;
        goto L_0x01e5;
    L_0x00ea:
        r0 = "feedTopTraders3";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00f2:
        r0 = 20;
        goto L_0x01e5;
    L_0x00f6:
        r0 = "balance-created";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x00fe:
        r0 = 4;
        goto L_0x01e5;
    L_0x0101:
        r0 = "top-assets-updated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0109:
        r0 = 33;
        goto L_0x01e5;
    L_0x010d:
        r0 = "profile";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0115:
        r0 = 5;
        goto L_0x01e5;
    L_0x0118:
        r0 = "tournamentChange";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0120:
        r0 = 14;
        goto L_0x01e5;
    L_0x0124:
        r0 = "balance-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x012c:
        r0 = 3;
        goto L_0x01e5;
    L_0x012f:
        r0 = "currency-updated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0137:
        r0 = 34;
        goto L_0x01e5;
    L_0x013b:
        r0 = "user-routed-to-trading-cluster";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0143:
        r0 = 32;
        goto L_0x01e5;
    L_0x0147:
        r0 = "order-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x014f:
        r0 = 30;
        goto L_0x01e5;
    L_0x0153:
        r0 = "deposited";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x015b:
        r0 = 17;
        goto L_0x01e5;
    L_0x015f:
        r0 = "socket-option-opened";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0167:
        r0 = 11;
        goto L_0x01e5;
    L_0x016b:
        r0 = "instruments-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0173:
        r0 = 27;
        goto L_0x01e5;
    L_0x0177:
        r0 = "socket-option-closed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x017f:
        r0 = 12;
        goto L_0x01e5;
    L_0x0183:
        r0 = "recconnect";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x018b:
        r0 = 15;
        goto L_0x01e5;
    L_0x018e:
        r0 = "spot-buyback-quote-generated";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x0196:
        r0 = 0;
        goto L_0x01e5;
    L_0x0198:
        r0 = "buyComplete";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01a0:
        r0 = 10;
        goto L_0x01e5;
    L_0x01a3:
        r0 = "expiration-list-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01ab:
        r0 = 29;
        goto L_0x01e5;
    L_0x01ae:
        r0 = "activeScheduleChange";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01b6:
        r0 = 19;
        goto L_0x01e5;
    L_0x01b9:
        r0 = "position-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01c1:
        r0 = 31;
        goto L_0x01e5;
    L_0x01c4:
        r0 = "commission-settings-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01cc:
        r0 = 35;
        goto L_0x01e5;
    L_0x01cf:
        r0 = "available-leverages-changed";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01d7:
        r0 = 38;
        goto L_0x01e5;
    L_0x01da:
        r0 = "timeSync";
        r0 = r13.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01e2:
        r0 = 7;
        goto L_0x01e5;
    L_0x01e4:
        r0 = -1;
    L_0x01e5:
        r6 = 0;
        switch(r0) {
            case 0: goto L_0x0d35;
            case 1: goto L_0x0d2c;
            case 2: goto L_0x0d0e;
            case 3: goto L_0x0c92;
            case 4: goto L_0x0c4b;
            case 5: goto L_0x0767;
            case 6: goto L_0x0752;
            case 7: goto L_0x0741;
            case 8: goto L_0x073c;
            case 9: goto L_0x06f8;
            case 10: goto L_0x06d5;
            case 11: goto L_0x06c0;
            case 12: goto L_0x06c0;
            case 13: goto L_0x06af;
            case 14: goto L_0x0664;
            case 15: goto L_0x064f;
            case 16: goto L_0x060f;
            case 17: goto L_0x05fe;
            case 18: goto L_0x05b5;
            case 19: goto L_0x059d;
            case 20: goto L_0x050f;
            case 21: goto L_0x04ed;
            case 22: goto L_0x04ed;
            case 23: goto L_0x04e1;
            case 24: goto L_0x04c0;
            case 25: goto L_0x04a2;
            case 26: goto L_0x048d;
            case 27: goto L_0x0440;
            case 28: goto L_0x0440;
            case 29: goto L_0x03fb;
            case 30: goto L_0x0316;
            case 31: goto L_0x02e3;
            case 32: goto L_0x02cc;
            case 33: goto L_0x02ad;
            case 34: goto L_0x0296;
            case 35: goto L_0x0277;
            case 36: goto L_0x0254;
            case 37: goto L_0x0235;
            case 38: goto L_0x0204;
            case 39: goto L_0x01ed;
            default: goto L_0x01e9;
        };	 Catch:{ Exception -> 0x0dc8 }
    L_0x01e9:
        r0 = com.iqoption.microservice.chat.d.cPG;	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0d3a;
    L_0x01ed:
        if (r14 == 0) goto L_0x0df6;
    L_0x01ef:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.microservices.feed.response.d.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.core.microservices.feed.response.d) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x01fd:
        r0 = com.iqoption.feed.a.cle;	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0204:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.microservices.tradingengine.response.b.b.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.core.microservices.tradingengine.response.b.b) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getInstrumentType();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.XL();	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r1 = new com.iqoption.service.e$e;	 Catch:{ Exception -> 0x0dc8 }
        r1.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getInstrumentType();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r1.setValue(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0.aE(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0235:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14.getAsLong();	 Catch:{ Exception -> 0x0dc8 }
        r2 = 0;
        r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r14 <= 0) goto L_0x0df6;
    L_0x0247:
        r14 = com.iqoption.app.managers.af.Hu();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.Hw();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.mobbtech.connect.request.api.f.r(r0, r2);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0254:
        r0 = com.iqoption.app.managers.feature.a.HD();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x025a:
        r0 = com.iqoption.app.managers.feature.a.HE();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x0260:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.event.OtnEmissionExecuted.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.event.OtnEmissionExecuted) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x026e:
        r0 = com.iqoption.app.managers.r.GT();	 Catch:{ Exception -> 0x0dc8 }
        r0.onEmissionExecuted(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0277:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.microservices.tradingengine.response.a.b.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.core.microservices.tradingengine.response.a.b) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x0285:
        r0 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getInstrumentType();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.XK();	 Catch:{ Exception -> 0x0dc8 }
        r0.b(r1, r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0296:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.Currencies.ConversionCurrency.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.Currencies.ConversionCurrency) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x02a4:
        r0 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r0.b(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x02ad:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.microservices.f.a.a.b.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.core.microservices.f.a.a.b) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x02bb:
        r0 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getInstrumentType();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.Xd();	 Catch:{ Exception -> 0x0dc8 }
        r0.b(r1, r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x02cc:
        r0 = com.iqoption.app.IQApp.Dl();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "tc";
        r14 = r14.optBoolean(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0.setTc(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x02e3:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.position.Position.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.position.Position) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.a.a.a.aMG;	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getActiveId();	 Catch:{ Exception -> 0x0dc8 }
        r1 = (long) r1;	 Catch:{ Exception -> 0x0dc8 }
        r3 = r14.getOrderIds();	 Catch:{ Exception -> 0x0dc8 }
        r4 = r14.getInstrumentType();	 Catch:{ Exception -> 0x0dc8 }
        r5 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r5 = r5.longValue();	 Catch:{ Exception -> 0x0dc8 }
        r7 = r14.getStatus();	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r1, r3, r4, r5, r7);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r0.e(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0316:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.position.Order.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.position.Order) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = "";
        r1 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r1.i(r14);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "market";
        r3 = r14.getType();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x034c;
    L_0x0337:
        r1 = com.iqoption.core.a.a.a.aMG;	 Catch:{ Exception -> 0x0dc8 }
        r3 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r6 = r3.longValue();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r14.getStatus();	 Catch:{ Exception -> 0x0dc8 }
        r8 = r14.getRejectStatus();	 Catch:{ Exception -> 0x0dc8 }
        r1.a(r6, r3, r8);	 Catch:{ Exception -> 0x0dc8 }
    L_0x034c:
        r1 = com.iqoption.dto.entity.position.Order.isMarketOrderFilled(r14);	 Catch:{ Exception -> 0x0dc8 }
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = 2131232270; // 0x7f08060e float:1.8080645E38 double:1.052968648E-314;
        if (r1 == 0) goto L_0x0399;
    L_0x0357:
        r1 = "show_error_position_price";
        r1 = com.iqoption.app.af.eM(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x03f0;
    L_0x035f:
        r8 = r14.getCount();	 Catch:{ Exception -> 0x0dc8 }
        r10 = r14.getAvgPrice();	 Catch:{ Exception -> 0x0dc8 }
        r8 = r8 * r10;
        r14 = com.iqoption.app.af.DX();	 Catch:{ Exception -> 0x0dc8 }
        r10 = r14.Ea();	 Catch:{ Exception -> 0x0dc8 }
        r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r14 >= 0) goto L_0x03f0;
    L_0x0375:
        r14 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        r0 = 2131821943; // 0x7f110577 float:1.9276643E38 double:1.053259985E-314;
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.util.q.I(r8);	 Catch:{ Exception -> 0x0dc8 }
        r1[r5] = r2;	 Catch:{ Exception -> 0x0dc8 }
        r2 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.util.l.v(r2);	 Catch:{ Exception -> 0x0dc8 }
        r1[r4] = r2;	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getString(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "show_error_position_price";
        com.iqoption.app.af.i(r0, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14;
        goto L_0x03f0;
    L_0x0399:
        r1 = "rejected";
        r2 = r14.getStatus();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x03f0;
    L_0x03a5:
        r0 = r14.getRejectStatus();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r0.hashCode();	 Catch:{ Exception -> 0x0dc8 }
        switch(r1) {
            case -1364918149: goto L_0x03cd;
            case -538734959: goto L_0x03ca;
            case -284840886: goto L_0x03c7;
            case -282863361: goto L_0x03c4;
            case 6908744: goto L_0x03c1;
            case 410402527: goto L_0x03be;
            case 688092859: goto L_0x03bb;
            case 1848962578: goto L_0x03b8;
            case 1919658633: goto L_0x03b1;
            default: goto L_0x03b0;
        };	 Catch:{ Exception -> 0x0dc8 }
    L_0x03b0:
        goto L_0x03d0;
    L_0x03b1:
        r1 = "internal_billing_exception";
    L_0x03b3:
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x03d0;
    L_0x03b8:
        r1 = "symbol_forbidden";
        goto L_0x03b3;
    L_0x03bb:
        r1 = "exceeds_limit";
        goto L_0x03b3;
    L_0x03be:
        r1 = "risk_exception";
        goto L_0x03b3;
    L_0x03c1:
        r1 = "instrument_price_not_found";
        goto L_0x03b3;
    L_0x03c4:
        r1 = "internal_billing_not_enough_balance";
        goto L_0x03b3;
    L_0x03c7:
        r1 = "unknown";
        goto L_0x03b3;
    L_0x03ca:
        r1 = "user_balance_not_found_or_wrong";
        goto L_0x03b3;
    L_0x03cd:
        r1 = "too_much_time_passed";
        goto L_0x03b3;
    L_0x03d0:
        r0 = "buy";
        r14 = r14.getSide();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.equals(r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x03e0;
    L_0x03dc:
        r14 = 2131822117; // 0x7f110625 float:1.9276996E38 double:1.053260071E-314;
        goto L_0x03e3;
    L_0x03e0:
        r14 = 2131822265; // 0x7f1106b9 float:1.9277297E38 double:1.053260144E-314;
    L_0x03e3:
        r0 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.getString(r14);	 Catch:{ Exception -> 0x0dc8 }
        r3 = 2131232271; // 0x7f08060f float:1.8080647E38 double:1.0529686484E-314;
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
    L_0x03f0:
        r14 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 != 0) goto L_0x0df6;
    L_0x03f6:
        com.iqoption.fragment.cr.a(r3, r0, r6);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x03fb:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.result.ExpirationsResult.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.result.ExpirationsResult) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0dc8 }
        r1.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r2 = "SPOTP EXPIRATION_LIST_CHANGED expirationsResult=";
        r1.append(r2);	 Catch:{ Exception -> 0x0dc8 }
        r1.append(r14);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.core.i.d(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.type;	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.underlying;	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.b(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.managers.a.k.HB();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.type;	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.n(r2);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x0435:
        if (r1 == 0) goto L_0x0df6;
    L_0x0437:
        r14 = r14.getExpirations();	 Catch:{ Exception -> 0x0dc8 }
        r1.b(r0, r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0440:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        r0 = "type";
        r0 = r14.get(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.getAsString();	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.data.model.InstrumentType.fromServerValue(r0);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "instruments";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x046d;
    L_0x0462:
        r1 = "instruments";
        r14 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r14.getAsJsonArray();	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x047f;
    L_0x046d:
        r1 = "underlying";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x047f;
    L_0x0475:
        r1 = "underlying";
        r14 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r14.getAsJsonArray();	 Catch:{ Exception -> 0x0dc8 }
    L_0x047f:
        if (r6 == 0) goto L_0x0df6;
    L_0x0481:
        r14 = com.iqoption.core.d.a.aSd;	 Catch:{ Exception -> 0x0dc8 }
        r1 = new com.iqoption.service.m;	 Catch:{ Exception -> 0x0dc8 }
        r1.<init>(r6, r0);	 Catch:{ Exception -> 0x0dc8 }
        r14.execute(r1);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x048d:
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.dto.entity.strike.Quote[].class;
        r14 = r1.fromJson(r14, r2);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.strike.Quote[]) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x04a2:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.strike.Quote.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.strike.Quote) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.analytics.sla.Sla.Ci();	 Catch:{ Exception -> 0x0dc8 }
        r0 = "quotes-digital";
        r14.ea(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x04c0:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.dto.entity.strike.Quote.parseQuotesGenerated(r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x04d2:
        r0 = r14.size();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 <= 0) goto L_0x0df6;
    L_0x04d8:
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r0.d(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x04e1:
        r0 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r1 = "FEATURE_UPDATED";
        com.iqoption.core.i.v(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.app.managers.feature.b.a(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x04ed:
        r0 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r1 = "signals";
        com.iqoption.core.i.d(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.dto.entity.iqbus.SignalLegacy$SignalsEvent;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.dto.entity.iqbus.SignalLegacy[].class;
        r14 = r1.fromJson(r14, r2);	 Catch:{ Exception -> 0x0dc8 }
        r0.setValue(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x050f:
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "exp_time";
        r0 = r14.optLong(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r2 = "feed";
        r14 = r14.getJSONObject(r2);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.toString();	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.iqoption.service.WebSocketHandler$2;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.getType();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r1.fromJson(r14, r2);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (java.util.HashMap) r14;	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.app.managers.a.Gf();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.Gi();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r1.Db();	 Catch:{ Exception -> 0x0dc8 }
        r1 = (int) r3;	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r2.contains(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0558;
    L_0x0555:
        r1 = "POST_USSR";
        goto L_0x055a;
    L_0x0558:
        r1 = "NOT_POST_USSR";
    L_0x055a:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 != 0) goto L_0x0567;
    L_0x0560:
        r14 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r14;
        r6 = (java.util.HashMap) r6;	 Catch:{ Exception -> 0x0dc8 }
    L_0x0567:
        r14 = new com.google.gson.JsonObject;	 Catch:{ Exception -> 0x0dc8 }
        r14.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r1 = "expTime";
        r14.addProperty(r1, r0);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "groupDict";
        r2 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r3 = new com.iqoption.service.WebSocketHandler$3;	 Catch:{ Exception -> 0x0dc8 }
        r3.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r3.getType();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.toJsonTree(r6, r3);	 Catch:{ Exception -> 0x0dc8 }
        r14.add(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.iqoption.service.e$k;	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.toString();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r0.longValue();	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>(r6, r14, r3);	 Catch:{ Exception -> 0x0dc8 }
        r1.aE(r2);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x059d:
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "turbo";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0dc8 }
        r12.a(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "binary";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0dc8 }
        r12.a(r14, r4);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x05b5:
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "active_id";
        r0 = r14.getInt(r0);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "option_type";
        r1 = r14.getInt(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.microservices.tradingengine.response.active.a.dQ(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = "commission";
        r14 = r14.getInt(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0dc8 }
        r3.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r4 = "ACTIVE_COMMISSION_CHANGE activeId=";
        r3.append(r4);	 Catch:{ Exception -> 0x0dc8 }
        r3.append(r0);	 Catch:{ Exception -> 0x0dc8 }
        r4 = ", instrumentType=";
        r3.append(r4);	 Catch:{ Exception -> 0x0dc8 }
        r3.append(r1);	 Catch:{ Exception -> 0x0dc8 }
        r4 = ", commission=";
        r3.append(r4);	 Catch:{ Exception -> 0x0dc8 }
        r3.append(r14);	 Catch:{ Exception -> 0x0dc8 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.core.i.d(r2, r3);	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0dc8 }
        r2.a(r1, r0, r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x05fe:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.init.AppInit.DepositStat.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.init.AppInit.DepositStat) r14;	 Catch:{ Exception -> 0x0dc8 }
        a(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x060f:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        r0 = "instrument";
        r0 = r14.get(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.util.i.i(r0);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "asset_id";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.g(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = "value";
        r14 = r14.get(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.core.util.i.e(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.gl.b.aow();	 Catch:{ Exception -> 0x0dc8 }
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 * r4;
        r2 = java.lang.Math.round(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = (int) r2;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.data.model.ActiveType.convertToActiveName(r0);	 Catch:{ Exception -> 0x0dc8 }
        r14.glchTradersMoodSetCallPercentage(r2, r1, r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x064f:
        r14 = "RECONNECT RECONNECT RECONNECT RECONNECT RECONNECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        com.iqoption.core.i.d(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$h;	 Catch:{ Exception -> 0x0dc8 }
        r1 = "socket-reconnect-msg";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0664:
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.entity.Tournament.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.entity.Tournament) r14;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.managers.a.Gf();	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.Gj();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r0.iterator();	 Catch:{ Exception -> 0x0dc8 }
    L_0x067c:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x0dc8 }
        if (r2 == 0) goto L_0x0697;
    L_0x0682:
        r2 = r1.next();	 Catch:{ Exception -> 0x0dc8 }
        r2 = (com.iqoption.dto.entity.Tournament) r2;	 Catch:{ Exception -> 0x0dc8 }
        r3 = r2.getId();	 Catch:{ Exception -> 0x0dc8 }
        r4 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0dc8 }
        if (r3 == 0) goto L_0x067c;
    L_0x0696:
        goto L_0x0698;
    L_0x0697:
        r2 = r6;
    L_0x0698:
        if (r2 != 0) goto L_0x069e;
    L_0x069a:
        r0.add(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x06a1;
    L_0x069e:
        r2.merge(r14);	 Catch:{ Exception -> 0x0dc8 }
    L_0x06a1:
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$o;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x06af:
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r12.s(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.mobbtech.connect.response.options.e.json2options(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0.c(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x06c0:
        r0 = com.iqoption.app.managers.c.Gn();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r1.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.mobbtech.connect.response.options.e.jsonElement2options(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0.f(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x06d5:
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = "isSuccessful";
        r0 = r14.optBoolean(r0, r4);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 != 0) goto L_0x0df6;
    L_0x06e1:
        r0 = "message";
        r0 = r14.has(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x06f3;
    L_0x06e9:
        r0 = "message";
        r14 = r14.getJSONArray(r0);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r14.getString(r5);	 Catch:{ Exception -> 0x0dc8 }
    L_0x06f3:
        r12.jG(r6);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x06f8:
        r0 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.getGroupId();	 Catch:{ Exception -> 0x0dc8 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.data.model.ActiveType.BINARY_ACTIVE;	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.getServerValue();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 == 0) goto L_0x0721;
    L_0x0714:
        r1 = r14.getJSONObject(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.getJSONObject(r0);	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.core.data.model.InstrumentType.BINARY_INSTRUMENT;	 Catch:{ Exception -> 0x0dc8 }
        r12.a(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0721:
        r1 = com.iqoption.core.data.model.ActiveType.TURBO_ACTIVE;	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1.getServerValue();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 == 0) goto L_0x0df6;
    L_0x072d:
        r14 = r14.getJSONObject(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getJSONObject(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.data.model.InstrumentType.TURBO_INSTRUMENT;	 Catch:{ Exception -> 0x0dc8 }
        r12.a(r14, r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x073c:
        r12.u(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0741:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14.getAsLong();	 Catch:{ Exception -> 0x0dc8 }
        r12.bV(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0752:
        r14 = com.iqoption.app.af.DX();	 Catch:{ Exception -> 0x0dc8 }
        r14.cL(r4);	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$f;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0767:
        r0 = "PROFILE";
        com.iqoption.core.i.d(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0c38;
    L_0x0776:
        r0 = r14.isJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0c38;
    L_0x077c:
        r14 = r14.getAsJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r1 = "id";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0824;
    L_0x078c:
        r1 = r0.getBalanceId();	 Catch:{ Exception -> 0x0dc8 }
        if (r1 != 0) goto L_0x0794;
    L_0x0792:
        r1 = 1;
        goto L_0x0795;
    L_0x0794:
        r1 = 0;
    L_0x0795:
        r2 = "balance_id";
        r2 = r14.has(r2);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 == 0) goto L_0x07df;
    L_0x079d:
        r2 = "balance_id";
        r2 = r14.get(r2);	 Catch:{ Exception -> 0x0dc8 }
        r6 = -1;
        r6 = com.iqoption.core.util.i.a(r2, r6);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r0.X(r6);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r0.d(r2);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r0.CC();	 Catch:{ Exception -> 0x0dc8 }
        if (r6 == 0) goto L_0x07df;
    L_0x07b7:
        if (r2 == 0) goto L_0x07bb;
    L_0x07b9:
        r7 = 1;
        goto L_0x07bc;
    L_0x07bb:
        r7 = 0;
    L_0x07bc:
        r8 = r7 ^ 1;
        if (r7 == 0) goto L_0x07cd;
    L_0x07c0:
        r9 = r2.currency;	 Catch:{ Exception -> 0x0dc8 }
        r10 = r6.currency;	 Catch:{ Exception -> 0x0dc8 }
        r9 = java.util.Objects.equals(r9, r10);	 Catch:{ Exception -> 0x0dc8 }
        if (r9 != 0) goto L_0x07cb;
    L_0x07ca:
        goto L_0x07cd;
    L_0x07cb:
        r9 = 0;
        goto L_0x07ce;
    L_0x07cd:
        r9 = 1;
    L_0x07ce:
        if (r7 == 0) goto L_0x07dd;
    L_0x07d0:
        r2 = r2.type;	 Catch:{ Exception -> 0x0dc8 }
        r6 = r6.type;	 Catch:{ Exception -> 0x0dc8 }
        r2 = java.util.Objects.equals(r2, r6);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 != 0) goto L_0x07db;
    L_0x07da:
        goto L_0x07dd;
    L_0x07db:
        r2 = 0;
        goto L_0x07e2;
    L_0x07dd:
        r2 = 1;
        goto L_0x07e2;
    L_0x07df:
        r2 = 0;
        r8 = 0;
        r9 = 0;
    L_0x07e2:
        if (r2 == 0) goto L_0x07f8;
    L_0x07e4:
        r2 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r6 = new com.iqoption.service.e$b;	 Catch:{ Exception -> 0x0dc8 }
        r6.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r7 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r6 = r6.setValue(r7);	 Catch:{ Exception -> 0x0dc8 }
        r2.aE(r6);	 Catch:{ Exception -> 0x0dc8 }
    L_0x07f8:
        if (r9 == 0) goto L_0x0806;
    L_0x07fa:
        r2 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r6 = new com.iqoption.service.e$c;	 Catch:{ Exception -> 0x0dc8 }
        r6.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r2.aE(r6);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0806:
        if (r8 == 0) goto L_0x0814;
    L_0x0808:
        r2 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r6 = new com.iqoption.service.e$a;	 Catch:{ Exception -> 0x0dc8 }
        r6.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r2.aE(r6);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0814:
        if (r1 != 0) goto L_0x0818;
    L_0x0816:
        if (r8 == 0) goto L_0x0824;
    L_0x0818:
        r1 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.iqoption.service.e$m;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r1.aE(r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0824:
        r1 = "kyc";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0937;
    L_0x082c:
        r1 = "kyc";
        r1 = r14.getAsJsonObject(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r0.akw;	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2 ^ r4;
        r0.akw = r4;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "status";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.g(r6);	 Catch:{ Exception -> 0x0dc8 }
        r0.kycStatus = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isRegulatedUser";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.aL(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isProfileNeeded";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akz = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isPhoneNeeded";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akA = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsNeeded";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akB = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsDeclined";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akC = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isProfileFilled";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akD = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isPhoneFilled";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akE = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsUploaded";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akF = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isPhoneConfirmationSkipped";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akG = r6;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isPhoneConfirmed";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.aJ(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsUploadSkipped";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r0.akI = r6;	 Catch:{ Exception -> 0x0dc8 }
        if (r2 == 0) goto L_0x08df;
    L_0x08cb:
        r2 = r0.akJ;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsApproved";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0dc8 }
        r2.bH(r6);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x08f2;
    L_0x08df:
        r2 = r0.akJ;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "isDocumentsApproved";
        r6 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r6 = com.iqoption.core.util.i.a(r6, r5);	 Catch:{ Exception -> 0x0dc8 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0dc8 }
        r2.bG(r6);	 Catch:{ Exception -> 0x0dc8 }
    L_0x08f2:
        r2 = r0.akx;	 Catch:{ Exception -> 0x0dc8 }
        r6 = "daysLeftToVerify";
        r1 = r1.get(r6);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.a(r1, r3);	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2.bG(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r3 = "kycStatus=";
        r2.append(r3);	 Catch:{ Exception -> 0x0dc8 }
        r3 = r0.kycStatus;	 Catch:{ Exception -> 0x0dc8 }
        r2.append(r3);	 Catch:{ Exception -> 0x0dc8 }
        r3 = ", daysLeftToVerify=";
        r2.append(r3);	 Catch:{ Exception -> 0x0dc8 }
        r3 = r0.akx;	 Catch:{ Exception -> 0x0dc8 }
        r3 = r3.getValue();	 Catch:{ Exception -> 0x0dc8 }
        r2.append(r3);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.core.i.v(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.iqoption.service.e$n;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r1.aE(r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0937:
        r1 = "user_id";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x097d;
    L_0x093f:
        r1 = "user_id";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.f(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.h(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.aP(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = "&uid";
        r6 = r0.getUserId();	 Catch:{ Exception -> 0x0dc8 }
        r3 = java.lang.Long.toString(r6);	 Catch:{ Exception -> 0x0dc8 }
        r1.set(r2, r3);	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.google.android.gms.analytics.HitBuilders$AppViewBuilder;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r3 = "&uid";
        r3 = r1.get(r3);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.setCustomDimension(r4, r3);	 Catch:{ Exception -> 0x0dc8 }
        r2 = (com.google.android.gms.analytics.HitBuilders.AppViewBuilder) r2;	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.build();	 Catch:{ Exception -> 0x0dc8 }
        r1.send(r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x097d:
        r1 = "birthdate";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0996;
    L_0x0985:
        r1 = "birthdate";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.f(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.g(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0996:
        r1 = "email";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x09ab;
    L_0x099e:
        r1 = "email";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.en(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x09ab:
        r1 = "new_email";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x09c0;
    L_0x09b3:
        r1 = "new_email";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.eo(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x09c0:
        r1 = "tin";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x09d5;
    L_0x09c8:
        r1 = "tin";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.em(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x09d5:
        r1 = "is_activated";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x09ea;
    L_0x09dd:
        r1 = "is_activated";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.h(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setActivated(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x09ea:
        r1 = "auth_two_factor";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x09ff;
    L_0x09f2:
        r1 = "auth_two_factor";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.h(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.aG(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x09ff:
        r1 = "first_name";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a14;
    L_0x0a07:
        r1 = "first_name";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setFirstName(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a14:
        r1 = "last_name";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a29;
    L_0x0a1c:
        r1 = "last_name";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setLastName(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a29:
        r1 = "messages";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a44;
    L_0x0a31:
        r1 = r0.akv;	 Catch:{ Exception -> 0x0dc8 }
        r2 = "messages";
        r2 = r14.get(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = com.iqoption.core.util.i.g(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0dc8 }
        r1.bG(r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a44:
        r1 = "group_id";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a59;
    L_0x0a4c:
        r1 = "group_id";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.g(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.cI(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a59:
        r1 = "locale";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a6e;
    L_0x0a61:
        r1 = "locale";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.er(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a6e:
        r1 = "deposit_count";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a83;
    L_0x0a76:
        r1 = "deposit_count";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.g(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.cJ(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a83:
        r1 = "flag";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0a98;
    L_0x0a8b:
        r1 = "flag";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setFlag(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0a98:
        r1 = "personal_data_policy";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0ab7;
    L_0x0aa0:
        r1 = "personal_data_policy";
        r1 = r14.getAsJsonObject(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r0.CS();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r2.e(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r2 != 0) goto L_0x0ab7;
    L_0x0ab4:
        r0.a(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0ab7:
        r1 = "forget_status";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0ad4;
    L_0x0abf:
        r1 = com.iqoption.util.ah.aGh();	 Catch:{ Exception -> 0x0dc8 }
        r2 = "forget_status";
        r2 = r14.get(r2);	 Catch:{ Exception -> 0x0dc8 }
        r3 = com.iqoption.core.microservices.busapi.response.a.class;
        r1 = r1.fromJson(r2, r3);	 Catch:{ Exception -> 0x0dc8 }
        r1 = (com.iqoption.core.microservices.busapi.response.a) r1;	 Catch:{ Exception -> 0x0dc8 }
        r0.c(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0ad4:
        r1 = "country_id";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0ae9;
    L_0x0adc:
        r1 = "country_id";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.f(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.Y(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0ae9:
        r1 = "phone";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b0e;
    L_0x0af1:
        r1 = "phone";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = " ";
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r1.length;	 Catch:{ Exception -> 0x0dc8 }
        if (r2 <= r4) goto L_0x0b0e;
    L_0x0b04:
        r2 = r1[r5];	 Catch:{ Exception -> 0x0dc8 }
        r0.setCountryCode(r2);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r1[r4];	 Catch:{ Exception -> 0x0dc8 }
        r0.setPhone(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b0e:
        r1 = "city";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b23;
    L_0x0b16:
        r1 = "city";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setCity(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b23:
        r1 = "address";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b38;
    L_0x0b2b:
        r1 = "address";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.setAddress(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b38:
        r1 = "postal_index";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b4d;
    L_0x0b40:
        r1 = "postal_index";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.el(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b4d:
        r1 = "gender";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b62;
    L_0x0b55:
        r1 = "gender";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.ek(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b62:
        r1 = "skey";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b77;
    L_0x0b6a:
        r1 = "skey";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.es(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b77:
        r1 = "user_group";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0b92;
    L_0x0b7f:
        r1 = "user_group";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.i(r1);	 Catch:{ Exception -> 0x0dc8 }
        r2 = "VIP";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0dc8 }
        r0.aI(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0b92:
        r1 = "client_category_id";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0baf;
    L_0x0b9a:
        r1 = "client_category_id";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.g(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.protrader.a.j(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0.a(r1);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0baf:
        r1 = "trial";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0bc6;
    L_0x0bb7:
        r1 = "trial";
        r1 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.core.util.i.h(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r0.aH(r1);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0bc7;
    L_0x0bc6:
        r1 = 0;
    L_0x0bc7:
        if (r1 == 0) goto L_0x0be4;
    L_0x0bc9:
        r1 = TAG;	 Catch:{ Exception -> 0x0dc8 }
        r2 = "BALANCE updateBalanceType - event";
        com.iqoption.core.i.d(r1, r2);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r2 = new com.iqoption.service.e$b;	 Catch:{ Exception -> 0x0dc8 }
        r2.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r3 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0dc8 }
        r2 = r2.setValue(r3);	 Catch:{ Exception -> 0x0dc8 }
        r1.aE(r2);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0be4:
        r0.aK(r4);	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        r0.aN(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = "ssid";
        r1 = r14.has(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0bff;
    L_0x0bf6:
        r1 = "ssid";
        r14 = r14.get(r1);	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.core.util.i.i(r14);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0bff:
        r14 = r0.getLocale();	 Catch:{ Exception -> 0x0dc8 }
        r14 = android.text.TextUtils.isEmpty(r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 != 0) goto L_0x0c21;
    L_0x0c09:
        r14 = r0.getLocale();	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.core.f.getLocale();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.equals(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 != 0) goto L_0x0c1c;
    L_0x0c17:
        r14 = r12.dpH;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 != 0) goto L_0x0c1c;
    L_0x0c1b:
        goto L_0x0c21;
    L_0x0c1c:
        r12.aDr();	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0c21:
        r14 = new com.iqoption.mobbtech.connect.request.b;	 Catch:{ Exception -> 0x0dc8 }
        r14.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r12.dpH = r14;	 Catch:{ Exception -> 0x0dc8 }
        r14 = r12.dpH;	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        r1 = new com.iqoption.service.l;	 Catch:{ Exception -> 0x0dc8 }
        r1.<init>(r12);	 Catch:{ Exception -> 0x0dc8 }
        r14.a(r0, r1);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0c38:
        r12.reconnect();	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$h;	 Catch:{ Exception -> 0x0dc8 }
        r1 = "empty-profile-msg";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0c4b:
        r14 = r12.c(r13, r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.Balance.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.Balance) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x0c5d:
        r0 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r0.Cz();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.id;	 Catch:{ Exception -> 0x0dc8 }
        r1.put(r2, r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.getBalanceId();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.id;	 Catch:{ Exception -> 0x0dc8 }
        r14 = java.util.Objects.equals(r0, r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0c84;
    L_0x0c76:
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$m;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0c84:
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$l;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0c92:
        r0 = "PROFILE - BALANCE_CHANGED";
        com.iqoption.core.i.d(r0);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r12.c(r13, r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0dc8 }
        r1 = com.iqoption.dto.BalanceChanged.class;
        r14 = r0.fromJson(r14, r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = (com.iqoption.dto.BalanceChanged) r14;	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0df6;
    L_0x0ca9:
        r0 = r14.getCurrentBalance();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x0caf:
        r0 = com.iqoption.app.a.Cw();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r1 = r0.d(r1);	 Catch:{ Exception -> 0x0dc8 }
        if (r1 == 0) goto L_0x0df6;
    L_0x0cc1:
        r1 = r1.index;	 Catch:{ Exception -> 0x0dc8 }
        r3 = r14.getCurrentBalance();	 Catch:{ Exception -> 0x0dc8 }
        r3 = r3.index;	 Catch:{ Exception -> 0x0dc8 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 > 0) goto L_0x0df6;
    L_0x0ccd:
        r1 = r0.Cz();	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0dc8 }
        r3 = r14.getCurrentBalance();	 Catch:{ Exception -> 0x0dc8 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r0.getBalanceId();	 Catch:{ Exception -> 0x0dc8 }
        r1 = r14.getId();	 Catch:{ Exception -> 0x0dc8 }
        r14 = java.lang.Long.valueOf(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = java.util.Objects.equals(r0, r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r14 == 0) goto L_0x0d00;
    L_0x0cf2:
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$m;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0d00:
        r14 = com.iqoption.app.IQApp.Dm();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$l;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0d0e:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsString();	 Catch:{ Exception -> 0x0dc8 }
        r12.dpE = r14;	 Catch:{ Exception -> 0x0dc8 }
        r14 = com.iqoption.app.IQApp.Dn();	 Catch:{ Exception -> 0x0dc8 }
        r0 = new com.iqoption.service.e$d;	 Catch:{ Exception -> 0x0dc8 }
        r1 = r12.dpE;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14.aE(r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0d2c:
        r14 = r12.r(r14);	 Catch:{ Exception -> 0x0dc8 }
        r12.n(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0d35:
        r12.t(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0d3a:
        r0 = r0.a(r13, r14);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0d41;
    L_0x0d40:
        return;
    L_0x0d41:
        r0 = com.iqoption.util.ah.aGi();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.parse(r14);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14.isJsonNull();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 != 0) goto L_0x0df6;
    L_0x0d4f:
        r0 = "question-shown";
        r0 = r0.equals(r13);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0d5c;
    L_0x0d57:
        r0 = com.iqoption.quiz.a.a.did;	 Catch:{ Exception -> 0x0dc8 }
        r0.gn(r5);	 Catch:{ Exception -> 0x0dc8 }
    L_0x0d5c:
        r0 = r12.dqi;	 Catch:{ Exception -> 0x0dc8 }
        r1 = new com.iqoption.core.connect.n;	 Catch:{ Exception -> 0x0dc8 }
        r2 = r14.toString();	 Catch:{ Exception -> 0x0dc8 }
        r1.<init>(r13, r2);	 Catch:{ Exception -> 0x0dc8 }
        r0.e(r1);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14.isJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0da5;
    L_0x0d70:
        r14 = r14.getAsJsonObject();	 Catch:{ Exception -> 0x0dc8 }
        r0 = "message";
        r0 = r14.has(r0);	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x0d7c:
        r0 = "message";
        r14 = r14.get(r0);	 Catch:{ Exception -> 0x0dc8 }
        r0 = r14.isJsonArray();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0d95;
    L_0x0d88:
        r14 = r14.getAsJsonArray();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.get(r5);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsString();	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0d99;
    L_0x0d95:
        r14 = r14.getAsString();	 Catch:{ Exception -> 0x0dc8 }
    L_0x0d99:
        r14 = r14.trim();	 Catch:{ Exception -> 0x0dc8 }
        r0 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.app.a.b.b(r14, r0);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0da5:
        r0 = r14.isJsonPrimitive();	 Catch:{ Exception -> 0x0dc8 }
        if (r0 == 0) goto L_0x0df6;
    L_0x0dab:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0dc8 }
        r0.<init>();	 Catch:{ Exception -> 0x0dc8 }
        r1 = "uncknow message = ";
        r0.append(r1);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsJsonPrimitive();	 Catch:{ Exception -> 0x0dc8 }
        r14 = r14.getAsString();	 Catch:{ Exception -> 0x0dc8 }
        r0.append(r14);	 Catch:{ Exception -> 0x0dc8 }
        r14 = r0.toString();	 Catch:{ Exception -> 0x0dc8 }
        com.iqoption.core.i.d(r14);	 Catch:{ Exception -> 0x0dc8 }
        goto L_0x0df6;
    L_0x0dc8:
        r14 = move-exception;
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "onTextMessage error. ";
        r1.append(r2);
        r1.append(r13);
        r1 = r1.toString();
        com.iqoption.core.i.e(r0, r1, r14);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Socket, onTextMessage error: ";
        r0.append(r1);
        r0.append(r13);
        r13 = r0.toString();
        com.iqoption.util.k.log(r13);
        com.iqoption.util.k.c(r14);
    L_0x0df6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.WebSocketHandler.b(java.lang.String, com.google.gson.stream.JsonReader):void");
    }

    @NonNull
    private String c(@NonNull String str, @NonNull JsonReader jsonReader) {
        String jsonElement = ah.aGi().parse(jsonReader).toString();
        this.dqi.e(new com.iqoption.core.connect.n(str, jsonElement));
        return jsonElement;
    }

    private void t(JsonReader jsonReader) {
        if (jsonReader != null) {
            com.iqoption.mobbtech.connect.response.d dVar = (com.iqoption.mobbtech.connect.response.d) ah.aGg().fromJson(jsonReader, (Type) com.iqoption.mobbtech.connect.response.d.class);
            if (dVar != null) {
                com.iqoption.app.managers.c.Gn().a(dVar);
                Sla.Ci().ea("pricing");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("buyback2 = ");
            stringBuilder.append(dVar.toString());
            i.d(stringBuilder.toString());
        }
    }

    private void n(JSONObject jSONObject) {
        com.iqoption.core.d.a.aSd.execute(new n(jSONObject));
    }

    private void a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            HashMap us = Maps.us();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                if (next instanceof String) {
                    String str = (String) next;
                    Integer valueOf = Integer.valueOf(Integer.parseInt(str));
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                        us.put(valueOf, new int[]{jSONArray2.getInt(0), jSONArray2.getInt(1)});
                    }
                }
            }
            com.iqoption.app.helpers.a.FI().a(us, com.iqoption.core.microservices.tradingengine.response.active.a.dQ(i));
        }
    }

    private void jG(String str) {
        com.iqoption.core.d.a.aSe.post(new o(str));
    }

    static final /* synthetic */ void jI(String str) {
        Context Dk = IQApp.Dk();
        if (TextUtils.isEmpty(str)) {
            com.iqoption.app.a.b.aT(Dk);
        } else {
            com.iqoption.app.a.b.b(str, Dk);
        }
    }

    private void bV(long j) {
        com.iqoption.app.managers.af.Hu().au(j);
    }

    private void u(com.google.gson.stream.JsonReader r33) {
        /*
        r32 = this;
        r33.beginObject();
        r0 = 0;
        r2 = 0;
        r3 = 0;
        r16 = r0;
        r18 = r16;
        r20 = r18;
        r9 = r3;
        r11 = r9;
        r22 = r11;
        r24 = r22;
        r26 = r24;
        r28 = r26;
        r30 = r28;
        r0 = 0;
        r15 = 0;
    L_0x001c:
        r1 = r33.hasNext();
        if (r1 == 0) goto L_0x0112;
    L_0x0022:
        r1 = r33.nextName();
        r3 = -1;
        r4 = r1.hashCode();
        switch(r4) {
            case -810883302: goto L_0x00a3;
            case 3123: goto L_0x0099;
            case 3355: goto L_0x008f;
            case 3707: goto L_0x0085;
            case 96889: goto L_0x007a;
            case 97533: goto L_0x006f;
            case 107876: goto L_0x0064;
            case 108114: goto L_0x005a;
            case 3151786: goto L_0x0050;
            case 3417674: goto L_0x0046;
            case 94756344: goto L_0x003b;
            case 204492020: goto L_0x0030;
            default: goto L_0x002e;
        };
    L_0x002e:
        goto L_0x00ae;
    L_0x0030:
        r4 = "active_id";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0038:
        r1 = 0;
        goto L_0x00af;
    L_0x003b:
        r4 = "close";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0043:
        r1 = 6;
        goto L_0x00af;
    L_0x0046:
        r4 = "open";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x004e:
        r1 = 5;
        goto L_0x00af;
    L_0x0050:
        r4 = "from";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0058:
        r1 = 3;
        goto L_0x00af;
    L_0x005a:
        r4 = "min";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0062:
        r1 = 7;
        goto L_0x00af;
    L_0x0064:
        r4 = "max";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x006c:
        r1 = 8;
        goto L_0x00af;
    L_0x006f:
        r4 = "bid";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0077:
        r1 = 9;
        goto L_0x00af;
    L_0x007a:
        r4 = "ask";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0082:
        r1 = 10;
        goto L_0x00af;
    L_0x0085:
        r4 = "to";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x008d:
        r1 = 4;
        goto L_0x00af;
    L_0x008f:
        r4 = "id";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x0097:
        r1 = 1;
        goto L_0x00af;
    L_0x0099:
        r4 = "at";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x00a1:
        r1 = 2;
        goto L_0x00af;
    L_0x00a3:
        r4 = "volume";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00ae;
    L_0x00ab:
        r1 = 11;
        goto L_0x00af;
    L_0x00ae:
        r1 = -1;
    L_0x00af:
        switch(r1) {
            case 0: goto L_0x010c;
            case 1: goto L_0x0105;
            case 2: goto L_0x00fd;
            case 3: goto L_0x00f5;
            case 4: goto L_0x00ed;
            case 5: goto L_0x00e5;
            case 6: goto L_0x00dd;
            case 7: goto L_0x00d5;
            case 8: goto L_0x00cd;
            case 9: goto L_0x00c6;
            case 10: goto L_0x00bf;
            case 11: goto L_0x00b7;
            default: goto L_0x00b2;
        };
    L_0x00b2:
        r33.skipValue();
        goto L_0x001c;
    L_0x00b7:
        r3 = r33.nextDouble();
        r30 = r3;
        goto L_0x001c;
    L_0x00bf:
        r3 = r33.nextDouble();
        r11 = r3;
        goto L_0x001c;
    L_0x00c6:
        r3 = r33.nextDouble();
        r9 = r3;
        goto L_0x001c;
    L_0x00cd:
        r3 = r33.nextDouble();
        r28 = r3;
        goto L_0x001c;
    L_0x00d5:
        r3 = r33.nextDouble();
        r26 = r3;
        goto L_0x001c;
    L_0x00dd:
        r3 = r33.nextDouble();
        r24 = r3;
        goto L_0x001c;
    L_0x00e5:
        r3 = r33.nextDouble();
        r22 = r3;
        goto L_0x001c;
    L_0x00ed:
        r3 = r33.nextLong();
        r20 = r3;
        goto L_0x001c;
    L_0x00f5:
        r3 = r33.nextLong();
        r18 = r3;
        goto L_0x001c;
    L_0x00fd:
        r3 = r33.nextLong();
        r16 = r3;
        goto L_0x001c;
    L_0x0105:
        r1 = r33.nextInt();
        r15 = r1;
        goto L_0x001c;
    L_0x010c:
        r0 = r33.nextInt();
        goto L_0x001c;
    L_0x0112:
        r33.endObject();
        r1 = r11 + r9;
        r3 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r1 = r1 / r3;
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r3 = r16 / r3;
        r13 = com.iqoption.gl.b.aow();
        r14 = r0;
        r13.addValueTimeId(r14, r15, r16, r18, r20, r22, r24, r26, r28, r30);
        r5 = com.iqoption.app.managers.c.Gn();
        r6 = r0;
        r7 = r1;
        r5.a(r6, r7, r9, r11);
        r5 = com.iqoption.app.managers.tab.a.Il();
        r5.b(r0, r1);
        r1 = com.iqoption.app.managers.af.Hu();
        r1.e(r0, r3);
        r0 = com.iqoption.analytics.sla.Sla.Ci();
        r1 = "quotes";
        r0.ea(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.WebSocketHandler.u(com.google.gson.stream.JsonReader):void");
    }

    private y<Object> aDq() {
        final y<Object> wb = y.wb();
        ag.a(com.iqoption.mobbtech.connect.request.a.a.b.A(BalanceListResult.class).ga("get-balances").Sa(), new com.iqoption.system.c.a<BalanceListResult>() {
            /* renamed from: a */
            public void bF(@NonNull BalanceListResult balanceListResult) {
                com.iqoption.app.a.Cw().a(balanceListResult.getMapBalance());
                wb.P(Boolean.valueOf(true));
            }

            public void N(Throwable th) {
                i.e(WebSocketHandler.TAG, "balance error", th);
                wb.h(th);
            }
        });
        return wb;
    }

    private void aDr() {
        if (this.dpT != State.AUTHORIZED) {
            if (this.dpT == State.NONE || this.dpT == State.RECONNECT) {
                this.dpT = State.AUTHORIZED;
                aDs();
                y aDq = aDq();
                com.iqoption.app.managers.feature.b.a(this.dqd);
                if (com.iqoption.app.a.Cw().CE()) {
                    ag.a(com.iqoption.mobbtech.connect.request.api.f.auz(), this.dpX);
                } else {
                    ag.a(com.iqoption.mobbtech.connect.request.api.f.auz(), this.dpW);
                    eP(true);
                }
                ag.a(o.a(this.dqc, this.dqd, aDq), new com.iqoption.system.c.a<java.util.List<Object>>() {
                    /* renamed from: B */
                    public void onSuccess(java.util.List<Object> list) {
                        WebSocketHandler.this.aDu();
                        i.i(WebSocketHandler.TAG, "subscription initialize(3!) success");
                        WebSocketHandler.this.dqb.P(Boolean.valueOf(true));
                        if (WebSocketHandler.this.dqa == null) {
                            f.Br().g("socket-connected", true);
                            WebSocketHandler.this.aMY.e(IQBusState.CONNECTED);
                        }
                        IQApp.Dm().aE(new g().setValue(new WeakReference(WebSocketHandler.this)));
                    }

                    public void l(Throwable th) {
                        super.l(th);
                        i.e(WebSocketHandler.TAG, "subscription initialize(3!) error", th);
                        WebSocketHandler.this.dqb.h(th);
                    }
                });
            }
            IQFirebaseInstanceIDService.aEo();
            ((com.iqoption.b.a) IQApp.Dk().akP.get()).ay(0);
        }
    }

    private void aDs() {
        aDt();
        this.dpQ = com.iqoption.core.d.a.aSc.i(new p(this));
    }

    final /* synthetic */ void aDC() {
        com.iqoption.service.websocket.a.b bVar = (com.iqoption.service.websocket.a.b) this.dpN.poll();
        while (bVar != null) {
            c(bVar);
            bVar = (com.iqoption.service.websocket.a.b) this.dpN.poll();
        }
    }

    private void aDt() {
        Future future = this.dpQ;
        if (future != null && !future.isCancelled() && !future.isDone()) {
            future.cancel(true);
        }
    }

    public void a(JSONObject jSONObject, InstrumentType instrumentType) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                if (next instanceof String) {
                    int parseInt = Integer.parseInt((String) next);
                    com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(parseInt), instrumentType);
                    if (a != null && (a instanceof com.iqoption.core.microservices.tradingengine.response.active.k)) {
                        com.iqoption.core.microservices.tradingengine.response.active.k kVar = (com.iqoption.core.microservices.tradingengine.response.active.k) a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(parseInt);
                        stringBuilder.append("");
                        JSONObject jSONObject2 = jSONObject.getJSONObject(stringBuilder.toString());
                        com.iqoption.core.microservices.tradingengine.response.active.k.d Xy = kVar.Xy();
                        Xy.c(Integer.valueOf(jSONObject2.getInt(OtnEmissionExecuted.COUNT)));
                        Xy.p(Long.valueOf(jSONObject2.getLong("start_time")));
                        Xy.o(Long.valueOf(jSONObject2.getLong("exp_time")));
                        if (jSONObject2.has("special") && (jSONObject2.get("special") instanceof JSONObject)) {
                            Xy.XE().putAll((HashMap) ah.aGg().fromJson(jSONObject2.getJSONObject("special").toString(), new TypeToken<HashMap<Long, com.iqoption.core.microservices.tradingengine.response.active.k.d.c>>() {
                            }.getType()));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void aDu() {
        i.d("socket, initSubscribs");
        d(new String[]{"deposited", "feedTopTraders3", "activeCommissionChange", "activeScheduleChange"});
        com.iqoption.app.managers.y.bu(true);
        synchronized (this.dqg) {
            this.dqg.clear();
        }
        a((com.iqoption.g.a) this);
        com.iqoption.mobbtech.connect.request.api.f.ix("user-loyalty");
        com.iqoption.mobbtech.connect.request.api.f.ix("socket-option-closed");
        com.iqoption.mobbtech.connect.request.api.f.ix("feature-updated");
        com.iqoption.mobbtech.connect.request.api.f.ix("currency-updated");
        com.iqoption.mobbtech.connect.request.api.f.at("feed-item-info-update", "2.0");
        if (com.iqoption.app.managers.feature.b.HT().fg("commission-popup")) {
            com.iqoption.mobbtech.connect.request.api.f.ix("commission-settings-changed");
        }
        if (com.iqoption.app.managers.feature.a.HD() && com.iqoption.app.managers.feature.a.HE()) {
            com.iqoption.mobbtech.connect.request.api.f.ix("user-emission-executed");
        }
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        int groupId = Cw.getGroupId();
        boolean Dh = Cw.Dh();
        n(groupId, Cw.Dh());
        p(groupId, Dh);
        o(groupId, Dh);
        q(groupId, Dh);
        m(groupId, Cw.Dh());
        com.iqoption.app.managers.y.Hp().Hq();
    }

    private void m(int i, boolean z) {
        if (com.iqoption.app.managers.feature.a.HI()) {
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz("underlying-list-changed").iA("2.0").m(Param.TYPE, InstrumentType.FX_INSTRUMENT).m("user_group_id", Integer.valueOf(i)).m("is_regulated", Boolean.valueOf(z)).iB("trading-instruments-fx-option").exec();
            HashMap hashMap = new HashMap();
            hashMap.put("instrument_type", InstrumentType.FX_INSTRUMENT);
            hashMap.put("user_group_id", Integer.valueOf(i));
            com.iqoption.mobbtech.connect.request.api.f.a("order-changed", "trading-fx-option", hashMap);
            com.iqoption.mobbtech.connect.request.api.f.a("position-changed", "trading-fx-option", hashMap);
        }
    }

    private void n(int i, boolean z) {
        if (com.iqoption.app.managers.feature.a.HH()) {
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz("underlying-list-changed").iA("2.0").m(Param.TYPE, InstrumentType.DIGITAL_INSTRUMENT).m("user_group_id", Integer.valueOf(i)).m("is_regulated", Boolean.valueOf(z)).exec();
            HashMap hashMap = new HashMap();
            hashMap.put("instrument_type", InstrumentType.DIGITAL_INSTRUMENT);
            hashMap.put("user_group_id", Integer.valueOf(i));
            com.iqoption.mobbtech.connect.request.api.f.a("order-changed", hashMap);
            com.iqoption.mobbtech.connect.request.api.f.a("position-changed", hashMap);
        }
    }

    private void o(int i, boolean z) {
        if (com.iqoption.app.managers.feature.a.HL()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.TYPE, InstrumentType.FOREX_INSTRUMENT);
            hashMap.put("user_group_id", Integer.valueOf(i));
            hashMap.put("is_regulated", Boolean.valueOf(z));
            com.iqoption.mobbtech.connect.request.api.f.a("instruments-changed", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("instrument_type", InstrumentType.FOREX_INSTRUMENT);
            hashMap2.put("user_group_id", Integer.valueOf(i));
            com.iqoption.mobbtech.connect.request.api.f.a("order-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.a("position-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz("available-leverages-changed").iA("2.0").g(hashMap2).exec();
        }
    }

    private void p(int i, boolean z) {
        if (com.iqoption.app.managers.feature.a.HK()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.TYPE, InstrumentType.CFD_INSTRUMENT);
            hashMap.put("user_group_id", Integer.valueOf(i));
            hashMap.put("is_regulated", Boolean.valueOf(z));
            com.iqoption.mobbtech.connect.request.api.f.a("instruments-changed", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("instrument_type", InstrumentType.CFD_INSTRUMENT);
            hashMap2.put("user_group_id", Integer.valueOf(i));
            com.iqoption.mobbtech.connect.request.api.f.a("order-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.a("position-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz("available-leverages-changed").iA("2.0").g(hashMap2).exec();
        }
    }

    private void q(int i, boolean z) {
        if (com.iqoption.app.managers.feature.a.HM()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Param.TYPE, InstrumentType.CRYPTO_INSTRUMENT);
            hashMap.put("user_group_id", Integer.valueOf(i));
            hashMap.put("is_regulated", Boolean.valueOf(z));
            com.iqoption.mobbtech.connect.request.api.f.a("instruments-changed", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("instrument_type", InstrumentType.CRYPTO_INSTRUMENT);
            hashMap2.put("user_group_id", Integer.valueOf(i));
            com.iqoption.mobbtech.connect.request.api.f.a("order-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.a("position-changed", hashMap2);
            com.iqoption.mobbtech.connect.request.api.f.iy("subscribeMessage").iz("available-leverages-changed").iA("2.0").g(hashMap2).exec();
        }
    }

    public static void a(DepositStat depositStat) {
        try {
            if (depositStat.platformId != null && depositStat.platformId.intValue() == 17) {
                com.iqoption.app.a aL = com.iqoption.app.a.aL(IQApp.Dk());
                Balance d = aL.d(depositStat.balanceId);
                int Cy = d == null ? aL.Cy() : d.type.intValue();
                if (!aL.CZ() && Cy == 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", "depositStatComplete");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("user_id", depositStat.userId);
                    jSONObject2.put("op_id", depositStat.opId);
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, jSONObject2);
                    aDm().jF(jSONObject.toString());
                    Bundle bundle = new Bundle();
                    bundle.putString("fb_order_id", depositStat.opId);
                    AppEventsLogger.T(IQApp.Dk()).a(new BigDecimal(depositStat.amount.doubleValue()), Currency.getInstance(depositStat.currency), bundle);
                    h.fA().ar(depositStat.currency);
                    Map hashMap = new HashMap();
                    hashMap.put("af_revenue", depositStat.amount);
                    hashMap.put("af_currency", depositStat.currency);
                    IQApp.a("af_purchase", hashMap);
                    Tracker aP = IQApp.aP(IQApp.Dk());
                    aP.send(((TransactionBuilder) ((TransactionBuilder) new TransactionBuilder().setTransactionId(depositStat.opId).setCustomMetric(1, (float) com.iqoption.app.a.aL(IQApp.Dk()).getUserId())).setAffiliation("Deposit").setRevenue(depositStat.amount.doubleValue()).setTax(0.0d).setShipping(0.0d).setCurrencyCode(depositStat.currency.toUpperCase()).setCustomDimension(2, aP.get("&cid"))).build());
                    aP.send(((ItemBuilder) ((ItemBuilder) new ItemBuilder().setTransactionId(depositStat.opId).setCustomMetric(1, (float) com.iqoption.app.a.aL(IQApp.Dk()).getUserId())).setName("Deposit").setSku("Deposit").setPrice(depositStat.amount.doubleValue()).setQuantity(1).setCurrencyCode(depositStat.currency.toUpperCase()).setCustomDimension(2, aP.get("&cid"))).build());
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "user_deposited").setValue(depositStat.amount).setParameters(com.iqoption.core.util.i.ZZ().l(com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY, depositStat.currency).l("amount", depositStat.amount).aab()).build());
                    EventManager.Bm().a(depositStat.amount, depositStat.currency.toUpperCase());
                    EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "M_Deposit").setValue(depositStat.amount).build());
                    EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "Anal_Deposit").setValue(depositStat.amount).build());
                    af aR = af.aR(IQApp.Dk());
                    if (!aR.EV()) {
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "M_First_Deposit").setValue(depositStat.amount).build());
                        aR.bb(true);
                    }
                    if (!aR.EX()) {
                        long EW = aR.EW();
                        long currentTimeMillis = System.currentTimeMillis() - EW;
                        if (EW > 0 && currentTimeMillis <= TimeUnit.HOURS.toMillis(72)) {
                            AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_rate");
                            EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, Event.MQL).build());
                            IQApp.a(Event.MQL, null);
                            aR.bc(true);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    final /* synthetic */ void aDB() {
        closeConnection();
        IQApp.Dm().aE(new e.i());
    }

    public boolean m(Object obj, int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("closeConnection by ");
        stringBuilder.append(obj);
        stringBuilder.append(", timeout=");
        stringBuilder.append(i);
        stringBuilder.append(", lockCounter=");
        stringBuilder.append(this.dpO.size() - 1);
        i.d(str, stringBuilder.toString());
        this.dpO.aZ(obj);
        if (!this.dpO.isEmpty()) {
            return false;
        }
        if (this.dpT == State.NONE) {
            return true;
        }
        if (this.dpJ == null || i <= 0) {
            closeConnection();
        } else {
            this.dpJ.removeCallbacks(this.dpY);
            this.dpJ.postDelayed(this.dpY, (long) i);
        }
        return true;
    }

    public void aiM() {
        i.d(TAG, "forceClose", new Throwable());
        closeConnection();
    }

    private void closeConnection() {
        if (this.dpO.isEmpty() || !aDp()) {
            i.i(TAG, "socket_trace closeConnection");
            this.dpO.clear();
            this.dpT = State.NONE;
            this.dpM.unregister();
            aDy();
            aDt();
            this.dpL = true;
            aDo();
            if (this.dpJ != null) {
                i.i(TAG, "socket_trace send close socket message");
                this.dpJ.removeCallbacks(this.dpY);
                this.dpJ.sendEmptyMessage(3);
                this.dpJ.sendEmptyMessage(4);
                this.dpJ = null;
            }
            synchronized (this.dqg) {
                this.dqg.clear();
            }
            this.dqf.clear();
            com.iqoption.app.managers.y.Hp().clear();
            com.iqoption.app.managers.af.Hu().clear();
            return;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SKIP closeConnection ");
        stringBuilder.append(this.dpO);
        i.d(str, stringBuilder.toString());
    }

    public s<Void> aDv() {
        if (isAuthorized()) {
            return o.aR(null);
        }
        synchronized (this.dpZ) {
            if (isAuthorized()) {
                s<Void> aR = o.aR(null);
                return aR;
            }
            s wb = y.wb();
            this.dpZ.add(wb);
            return wb;
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0019, code:
            if (r4 == false) goto L_0x0030;
     */
    /* JADX WARNING: Missing block: B:10:0x001b, code:
            r4 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:12:0x0023, code:
            if (r4.hasNext() == false) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:13:0x0025, code:
            ((com.google.common.util.concurrent.y) r4.next()).P(null);
     */
    /* JADX WARNING: Missing block: B:14:0x0030, code:
            r4 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:16:0x0038, code:
            if (r4.hasNext() == false) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:17:0x003a, code:
            ((com.google.common.util.concurrent.y) r4.next()).h(new java.lang.RuntimeException("socket not opened"));
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code:
            return;
     */
    private void eO(boolean r4) {
        /*
        r3 = this;
        r0 = r3.dpZ;
        monitor-enter(r0);
        r1 = r3.dpZ;	 Catch:{ all -> 0x004c }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        return;
    L_0x000d:
        r1 = r3.dpZ;	 Catch:{ all -> 0x004c }
        r1 = com.google.common.collect.ImmutableList.m(r1);	 Catch:{ all -> 0x004c }
        r2 = r3.dpZ;	 Catch:{ all -> 0x004c }
        r2.clear();	 Catch:{ all -> 0x004c }
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        if (r4 == 0) goto L_0x0030;
    L_0x001b:
        r4 = r1.iterator();
    L_0x001f:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x004b;
    L_0x0025:
        r0 = r4.next();
        r0 = (com.google.common.util.concurrent.y) r0;
        r1 = 0;
        r0.P(r1);
        goto L_0x001f;
    L_0x0030:
        r4 = r1.iterator();
    L_0x0034:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x004b;
    L_0x003a:
        r0 = r4.next();
        r0 = (com.google.common.util.concurrent.y) r0;
        r1 = new java.lang.RuntimeException;
        r2 = "socket not opened";
        r1.<init>(r2);
        r0.h(r1);
        goto L_0x0034;
    L_0x004b:
        return;
    L_0x004c:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.WebSocketHandler.eO(boolean):void");
    }

    public s<Void> bE(Object obj) {
        this.dpO.aY(obj);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("openConnection by ");
        stringBuilder.append(obj);
        stringBuilder.append(", lockCounter=");
        stringBuilder.append(this.dpO.size());
        i.d(str, stringBuilder.toString());
        if (this.dpJ != null) {
            this.dpJ.removeCallbacks(this.dpY);
        }
        if (isAuthorized()) {
            i.i(TAG, "socket is opened already");
            return o.aR(null);
        } else if (this.dqa == null || this.dqa.isDone() || this.dqa.isCancelled()) {
            if (this.dpK == null) {
                this.dpK = com.iqoption.app.managers.feature.b.HT().ff("ws-new-lib") ? new b() : new c();
            }
            this.dpV = Event.Builder(Event.CATEGORY_SYSTEM, "open-socket_request");
            this.dpM.register();
            this.dqc = y.wb();
            this.dqd = y.wb();
            this.dqb = y.wb();
            this.dpE = "";
            aDn();
            HandlerThread handlerThread = new HandlerThread("WebSocket Looper");
            handlerThread.start();
            this.dpJ = new e(handlerThread.getLooper());
            Context Dk = IQApp.Dk();
            IQApp.Dl().bA(Dk);
            s bz = IQApp.Dl().bz(Dk);
            i.d(TAG, "initialize config");
            ag.a(bz, new b(this, null));
            this.dpL = false;
            i.i(TAG, "Waiting for connect result(1!), future receive(2!), subscription initialize(3!) ");
            this.aMY.e(IQBusState.CONNECTING);
            this.dqa = ag.a(o.a(this.dqc, this.dqd, this.dqb), Functions.y(null));
            ag.a(this.dqa, new com.google.common.util.concurrent.n<Object>() {
                public void onSuccess(@Nullable Object obj) {
                    WebSocketHandler.this.dqa = null;
                    WebSocketHandler.this.aMY.e(IQBusState.CONNECTED);
                    WebSocketHandler.this.eO(true);
                }

                public void l(Throwable th) {
                    i.e(WebSocketHandler.TAG, "socket error", th);
                    WebSocketHandler.this.dqa = null;
                    WebSocketHandler.this.eO(false);
                }
            });
            return this.dqa;
        } else {
            i.i(TAG, "socket is opening");
            return this.dqa;
        }
    }

    private void eP(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setResultConnect ");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        if (this.dqc == null) {
            return;
        }
        if (z) {
            i.i(TAG, "connect result(1!) = success");
            this.dqc.P(Boolean.valueOf(true));
            return;
        }
        i.e(TAG, "connect result(1!) = failed");
        this.dqc.h(new Throwable("Socket not connecting"));
    }

    public boolean isAuthorized() {
        return this.dpT == State.AUTHORIZED;
    }

    private void aDw() {
        i.v(TAG, "onReconnect");
        if (!com.iqoption.app.a.Cw().isAuthorized()) {
            return;
        }
        if (com.iqoption.app.a.b.FF()) {
            if (Network.dwp.aGr()) {
                this.dpT = State.RECONNECT;
            } else {
                this.dpT = State.NONE;
            }
            reconnect();
            aDt();
            return;
        }
        aiM();
    }

    private void reconnect() {
        i.d("reconnect");
        if (this.dpS.get() == null) {
            this.dpS.compareAndSet(null, Event.Builder(Event.CATEGORY_SYSTEM, "socket-reconnect").setTechnicalLogs(Boolean.valueOf(true)));
        }
        this.dpT = State.RECONNECT;
        bW((long) ((new Random().nextInt(400) + 100) + 500));
        if (this.dpJ != null) {
            this.dpJ.sendEmptyMessage(1);
        }
        IQApp.Dn().aE(new j());
    }

    private void bW(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void d(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "subscribeOnly");
            JSONArray jSONArray = new JSONArray();
            for (Object put : strArr) {
                jSONArray.put(put);
            }
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, jSONArray);
            jF(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    @WorkerThread
    public static void a(com.iqoption.g.a aVar) {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        Collection Ir = Il.Ir();
        Set Is = Il.Is();
        synchronized (WebSocketHandler.class) {
            Set uI = Sets.uI();
            Iterator sI = com.iqoption.app.managers.c.Gn().Gl().iterator();
            while (sI.hasNext()) {
                uI.add(Pair.create(((Order) sI.next()).getInstrumentActiveId(), Integer.valueOf(1)));
            }
            sI = com.iqoption.app.managers.c.Gn().Gp().iterator();
            while (sI.hasNext()) {
                uI.add(Pair.create(((com.iqoption.mobbtech.connect.response.options.b) sI.next()).activeId, Integer.valueOf(1)));
            }
            uI.addAll(Ir);
            aVar.h(Is);
            aVar.g(uI);
        }
    }

    public void g(Set<Pair<Integer, Integer>> set) {
        i.d(TAG, "subscribeOnCandles");
        if (!com.iqoption.util.i.H(set)) {
            synchronized (this.dqg) {
                Iterator it = this.dqg.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    if (!set.contains(pair)) {
                        it.remove();
                        a("unsubscribeMessage", pair);
                    }
                }
                for (Pair pair2 : set) {
                    if (!this.dqg.contains(pair2)) {
                        this.dqg.add(pair2);
                        a("subscribeMessage", pair2);
                    }
                }
            }
        }
    }

    private void a(String str, Pair<Integer, Integer> pair) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("subscribeCandleGenerate: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(pair.toString());
        i.d(stringBuilder.toString());
        com.iqoption.mobbtech.connect.request.api.f.iy(str).iz("candle-generated").iA("1.0").m("active_id", pair.first).m("size", pair.second).exec();
        Sla.Ci().a("quotes", str.equalsIgnoreCase("subscribeMessage"), pair);
    }

    public void h(Set<Pair<Integer, InstrumentType>> set) {
        if (!com.iqoption.util.i.H(set)) {
            Iterator it = this.dqf.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!set.contains(pair)) {
                    it.remove();
                    b("unsubscribeMessage", pair);
                }
            }
            for (Pair pair2 : set) {
                if (!this.dqf.contains(pair2)) {
                    this.dqf.add(pair2);
                    b("subscribeMessage", pair2);
                }
            }
        }
    }

    private void b(String str, Pair<Integer, InstrumentType> pair) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("subscribeTradersMood: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(pair.toString());
        i.d(stringBuilder.toString());
        com.iqoption.mobbtech.connect.request.api.f.iy(str).iz("traders-mood-changed").iA("1.0").m("asset_id", pair.first).m("instrument", pair.second).exec();
    }

    private void aDx() {
        boolean z = false;
        while (!z) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", "ssid");
            jsonObject.addProperty(NotificationCompat.CATEGORY_MESSAGE, RequestManager.atO().atS());
            z = t(jsonObject.toString(), true);
            if (!z) {
                bW((long) (new Random().nextInt(400) + 100));
            }
        }
    }

    private void aDy() {
        ImmutableList m = ImmutableList.m(this.dqh.values());
        this.dqh.clear();
        Iterator sI = m.iterator();
        while (sI.hasNext()) {
            com.iqoption.service.websocket.a.b bVar = (com.iqoption.service.websocket.a.b) sI.next();
            if (bVar.dqy != null) {
                bVar.dqy.h(new Throwable("Socket close"));
            }
        }
    }

    @Nullable
    private com.iqoption.service.websocket.a.b jH(String str) {
        return (com.iqoption.service.websocket.a.b) this.dqh.remove(str);
    }

    private void a(com.iqoption.service.websocket.a.b bVar) {
        if (bVar != null && bVar.cPL != null) {
            this.dqh.put(bVar.cPL, bVar);
        }
    }

    private void b(com.iqoption.service.websocket.a.b bVar) {
        if (this.dpT != State.AUTHORIZED) {
            if (bVar.dqy != null) {
                bVar.dqy.h(new RuntimeException("Socket not authorized"));
            }
            return;
        }
        if (bVar.cPL != null) {
            a(bVar);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (bVar.cPL != null) {
                jSONObject.put("request_id", bVar.cPL);
            }
            jSONObject.put("name", bVar.aDF());
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, bVar.aDH());
            jF(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public boolean c(com.iqoption.service.websocket.a.b bVar) {
        if (this.dpT == State.AUTHORIZED) {
            com.iqoption.core.d.a.aSd.execute(new f(this, bVar));
            return true;
        }
        this.dpN.offer(bVar);
        return false;
    }

    public static boolean a(com.iqoption.g.a aVar, int i) {
        if (!aVar.isAuthorized()) {
            return false;
        }
        o.a(com.iqoption.microservice.quotes.history.a.fq(i), new d(i), com.iqoption.core.d.a.aSd);
        return true;
    }

    public static boolean a(com.iqoption.g.a aVar, int i, int i2, long j, long j2, int i3, int i4, int i5) {
        if (!aVar.isAuthorized()) {
            return false;
        }
        o.a(com.iqoption.microservice.quotes.history.a.a(i, j, j2, i2, i3, i4, i5), new a(i, i2), com.iqoption.core.d.a.aSd);
        if (!ae.b(IQApp.Dk(), 65536) && com.iqoption.app.managers.af.Hu().Hw() - (1000 * j) > 7200000) {
            ae.h(IQApp.Dk(), 65536);
        }
        return true;
    }

    public String aDz() {
        return this.dpE;
    }

    public io.reactivex.e<com.iqoption.core.connect.n> aDA() {
        return this.dqi;
    }

    public io.reactivex.e<Boolean> DH() {
        return this.aMY.d(g.dnG);
    }
}
