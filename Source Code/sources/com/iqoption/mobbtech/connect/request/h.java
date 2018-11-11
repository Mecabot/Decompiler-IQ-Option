package com.iqoption.mobbtech.connect.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.j;
import com.iqoption.core.microservices.tradingengine.response.active.l;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.dto.entity.init.AppInit;
import com.iqoption.dto.entity.init.AppInit.DepositStat;
import com.iqoption.dto.entity.result.AvatarResult;
import com.iqoption.fragment.cr;
import com.iqoption.launcher.LauncherActivity;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.k;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.util.be;
import com.iqoption.vip.VipManagerViewModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: QueueInitializedRequests */
public class h {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.h";
    private final WeakReference<cr> cUn;
    private WeakReference<TradeRoomActivity> cUo = new WeakReference(null);
    private boolean initialized;

    /* compiled from: QueueInitializedRequests */
    private static class a extends com.iqoption.system.c.b<h, com.iqoption.core.microservices.tradingengine.response.active.e.a> {
        public a(h hVar) {
            super((Object) hVar);
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull com.iqoption.core.microservices.tradingengine.response.active.e.a aVar) {
            com.iqoption.app.helpers.a.FI().a(aVar);
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.app.helpers.a.FI().a(null);
        }
    }

    /* compiled from: QueueInitializedRequests */
    private static class b extends com.iqoption.system.c.b<h, Void> {
        public b(h hVar) {
            super((Object) hVar);
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull Void voidR) {
            hVar.auh();
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            hVar.auh();
        }
    }

    /* compiled from: QueueInitializedRequests */
    private static class c extends com.iqoption.system.c.b<h, com.iqoption.core.microservices.tradingengine.response.a.b> {
        private final InstrumentType type;

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
        }

        public c(h hVar, InstrumentType instrumentType) {
            super((Object) hVar);
            this.type = instrumentType;
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull com.iqoption.core.microservices.tradingengine.response.a.b bVar) {
            com.iqoption.app.helpers.a.FI().b(this.type, bVar.XK());
        }
    }

    /* compiled from: QueueInitializedRequests */
    private static class d extends com.iqoption.system.c.b<h, j> {
        private final InstrumentType type;

        public d(h hVar, InstrumentType instrumentType) {
            super((Object) hVar);
            this.type = instrumentType;
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull j jVar) {
            com.iqoption.app.helpers.a.FI().a(this.type, jVar.cj(com.iqoption.app.managers.feature.a.eW("cfd-expiration")));
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.app.helpers.a.FI().a(this.type, null);
        }
    }

    /* compiled from: QueueInitializedRequests */
    public static class e extends com.iqoption.system.a.c<Boolean> {
    }

    /* compiled from: QueueInitializedRequests */
    private static class f extends com.iqoption.system.c.b<h, com.iqoption.core.microservices.tradingengine.response.b.b> {
        private final InstrumentType type;

        public f(h hVar, InstrumentType instrumentType) {
            super((Object) hVar);
            this.type = instrumentType;
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull com.iqoption.core.microservices.tradingengine.response.b.b bVar) {
            com.iqoption.app.helpers.a.FI().a(this.type, bVar.XL());
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.app.helpers.a.FI().a(this.type, null);
            com.iqoption.app.helpers.a.FI().a(this.type, null);
        }
    }

    /* compiled from: QueueInitializedRequests */
    private static class g extends com.iqoption.system.c.b<h, InstrumentType> {
        private final InstrumentType type;

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull InstrumentType instrumentType) {
        }

        public g(h hVar, InstrumentType instrumentType) {
            super((Object) hVar);
            this.type = instrumentType;
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.app.helpers.a.FI().a(this.type, null);
        }
    }

    /* compiled from: QueueInitializedRequests */
    private static class h extends com.iqoption.system.c.b<h, l> {
        private final InstrumentType type;

        public h(h hVar, InstrumentType instrumentType) {
            super((Object) hVar);
            this.type = instrumentType;
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull l lVar) {
            com.iqoption.app.helpers.a.FI().a(this.type, lVar.XF());
        }

        /* renamed from: a */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.app.helpers.a.FI().a(this.type, null);
        }
    }

    static final /* synthetic */ void aun() {
    }

    public h(cr crVar) {
        this.cUn = new WeakReference(crVar);
    }

    public void g(TradeRoomActivity tradeRoomActivity) {
        this.cUo = new WeakReference(tradeRoomActivity);
    }

    public void aua() {
        if (this.initialized) {
            aue();
        } else {
            aub();
        }
    }

    private void aub() {
        if (aud()) {
            com.iqoption.mobbtech.connect.request.a.a.b.b iF = com.iqoption.mobbtech.connect.request.a.a.b.B(com.iqoption.mobbtech.connect.response.f.class).iF(IQApp.Dl().getClusterApi());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("api/lang/json/");
            stringBuilder.append(LocalizationUtil.SD());
            ag.a(iF.iG(stringBuilder.toString()).auF(), new n<com.iqoption.mobbtech.connect.response.f>() {
                /* renamed from: a */
                public void onSuccess(com.iqoption.mobbtech.connect.response.f fVar) {
                    if (!(fVar == null || !fVar.isSuccessful() || fVar.auR() == null || fVar.auR().isJsonNull())) {
                        String jsonElement = fVar.auR().toString();
                        if (!(TextUtils.isEmpty(jsonElement) || jsonElement.equalsIgnoreCase("null"))) {
                            LocalizationUtil.aa(fVar.getVersion(), jsonElement);
                        }
                    }
                    aup();
                }

                public void l(Throwable th) {
                    aup();
                }

                private void aup() {
                    LocalizationUtil.init();
                    h.this.aue();
                }
            });
        }
    }

    private void auc() {
        com.iqoption.core.d.a.aSe.execute(new Runnable() {
            public void run() {
                TradeRoomActivity tradeRoomActivity = (TradeRoomActivity) h.this.cUo.get();
                if (tradeRoomActivity == null || tradeRoomActivity.zJ()) {
                    be.aGB();
                    return;
                }
                tradeRoomActivity.zB();
                com.iqoption.app.a.b.aT(IQApp.Dk());
                h.this.p(tradeRoomActivity);
            }
        });
    }

    private void p(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().getBoolean("RESTARTED")) {
            intent = new Intent(activity.getApplicationContext(), LauncherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("RESTARTED", true);
            intent.putExtras(bundle);
            be.l(activity, intent);
            return;
        }
        be.aGB();
    }

    private boolean aud() {
        cr crVar = (cr) this.cUn.get();
        if (crVar != null && crVar.isAdded()) {
            return true;
        }
        be.aGB();
        return false;
    }

    private void aue() {
        if (aud()) {
            String clusterApi = IQApp.Dl().getClusterApi();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(clusterApi);
            stringBuilder.append("api/appinit");
            new com.iqoption.mobbtech.connect.request.a.a.h(AppInit.class, RequestManager.a(stringBuilder.toString(), null, IQApp.Dk()), new com.iqoption.mobbtech.connect.a.b<AppInit>() {
                /* renamed from: a */
                public void onSuccess(AppInit appInit) {
                    if (h.this.cUn.get() == null || !((cr) h.this.cUn.get()).isAdded() || appInit == null) {
                        a(null);
                        return;
                    }
                    if (appInit.pushSettings != null) {
                        com.iqoption.app.managers.a.Gf().x(appInit.pushSettings);
                    }
                    if (appInit.feedTopTradersPostUssrCountries != null) {
                        com.iqoption.app.managers.a.Gf().y(appInit.feedTopTradersPostUssrCountries);
                    }
                    if (appInit.depositStats != null) {
                        Iterator it = appInit.depositStats.iterator();
                        while (it.hasNext()) {
                            WebSocketHandler.a((DepositStat) it.next());
                        }
                    }
                    h.this.aui();
                    h.this.auf();
                    h.this.auk();
                    h.this.aug();
                }

                public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                    h.this.auc();
                }
            }, "api/appinit").auG();
        }
    }

    private void auf() {
        if (aud()) {
            ag.a(com.iqoption.app.helpers.a.FI().FZ(), new b(this));
        }
    }

    private void aug() {
        com.iqoption.core.d.a.aSe.execute(new i(this));
    }

    final /* synthetic */ void auo() {
        TradeRoomActivity tradeRoomActivity = (TradeRoomActivity) this.cUo.get();
        if (tradeRoomActivity != null && !tradeRoomActivity.zJ()) {
            VipManagerViewModel.dLy.J(tradeRoomActivity).initialize();
        }
    }

    private void auh() {
        if (aud()) {
            boolean fg = com.iqoption.app.managers.feature.b.HT().fg("commission-popup");
            boolean HG = com.iqoption.app.managers.feature.a.HG();
            if (com.iqoption.app.managers.feature.a.HH()) {
                ag.a(com.iqoption.mobbtech.connect.request.api.f.I(InstrumentType.DIGITAL_INSTRUMENT), new h(this, InstrumentType.DIGITAL_INSTRUMENT));
                com.iqoption.app.helpers.a.FI().k(InstrumentType.DIGITAL_INSTRUMENT);
            }
            if (com.iqoption.app.managers.feature.a.HI()) {
                ag.a(com.iqoption.mobbtech.connect.request.api.f.I(InstrumentType.FX_INSTRUMENT), new h(this, InstrumentType.FX_INSTRUMENT));
                com.iqoption.app.helpers.a.FI().k(InstrumentType.FX_INSTRUMENT);
            }
            if (com.iqoption.app.managers.feature.a.HK()) {
                ag.a(com.iqoption.mobbtech.connect.request.api.f.J(InstrumentType.CFD_INSTRUMENT), new d(this, InstrumentType.CFD_INSTRUMENT));
                ag.a(com.iqoption.mobbtech.connect.request.api.f.K(InstrumentType.CFD_INSTRUMENT), new f(this, InstrumentType.CFD_INSTRUMENT));
                ag.a(com.iqoption.app.managers.b.b.aoQ.o(InstrumentType.CFD_INSTRUMENT), new g(this, InstrumentType.CFD_INSTRUMENT));
                if (fg) {
                    ag.a(com.iqoption.mobbtech.connect.request.api.f.L(InstrumentType.CFD_INSTRUMENT), new c(this, InstrumentType.CFD_INSTRUMENT));
                }
                com.iqoption.app.helpers.a.FI().k(InstrumentType.CFD_INSTRUMENT);
            }
            if (com.iqoption.app.managers.feature.a.HL()) {
                ag.a(com.iqoption.mobbtech.connect.request.api.f.J(InstrumentType.FOREX_INSTRUMENT), new d(this, InstrumentType.FOREX_INSTRUMENT));
                ag.a(com.iqoption.mobbtech.connect.request.api.f.K(InstrumentType.FOREX_INSTRUMENT), new f(this, InstrumentType.FOREX_INSTRUMENT));
                ag.a(com.iqoption.app.managers.b.b.aoQ.o(InstrumentType.FOREX_INSTRUMENT), new g(this, InstrumentType.FOREX_INSTRUMENT));
                if (fg) {
                    ag.a(com.iqoption.mobbtech.connect.request.api.f.L(InstrumentType.FOREX_INSTRUMENT), new c(this, InstrumentType.FOREX_INSTRUMENT));
                }
                com.iqoption.app.helpers.a.FI().k(InstrumentType.FOREX_INSTRUMENT);
            }
            if (com.iqoption.app.managers.feature.a.HM()) {
                ag.a(com.iqoption.mobbtech.connect.request.api.f.J(InstrumentType.CRYPTO_INSTRUMENT), new d(this, InstrumentType.CRYPTO_INSTRUMENT));
                ag.a(com.iqoption.mobbtech.connect.request.api.f.K(InstrumentType.CRYPTO_INSTRUMENT), new f(this, InstrumentType.CRYPTO_INSTRUMENT));
                ag.a(com.iqoption.app.managers.b.b.aoQ.o(InstrumentType.CRYPTO_INSTRUMENT), new g(this, InstrumentType.CRYPTO_INSTRUMENT));
                if (fg) {
                    ag.a(com.iqoption.mobbtech.connect.request.api.f.L(InstrumentType.CRYPTO_INSTRUMENT), new c(this, InstrumentType.CRYPTO_INSTRUMENT));
                }
                com.iqoption.app.helpers.a.FI().k(InstrumentType.CRYPTO_INSTRUMENT);
            }
            if (HG || com.iqoption.app.managers.feature.a.HJ()) {
                ag.a(com.iqoption.core.h.g.a(com.iqoption.core.microservices.tradingengine.a.aYp.Xe()), new a(this));
                com.iqoption.app.helpers.a.FI().k(InstrumentType.BINARY_INSTRUMENT);
                com.iqoption.app.helpers.a.FI().k(InstrumentType.TURBO_INSTRUMENT);
            }
            if (!this.initialized) {
                auj();
            }
            this.initialized = true;
        }
    }

    private void aui() {
        if (aud()) {
            String avatarsApi = IQApp.Dl().getAvatarsApi();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(avatarsApi);
            stringBuilder.append("api/v1/avatars/current");
            new com.iqoption.mobbtech.connect.request.a.a.h(AvatarResult.class, RequestManager.a(stringBuilder.toString(), null, IQApp.Dk()), new com.iqoption.mobbtech.connect.a.b<AvatarResult>() {
                /* renamed from: a */
                public void onSuccess(AvatarResult avatarResult) {
                    if (avatarResult != null && avatarResult.getAvatar() != null) {
                        com.iqoption.app.a.Cw().a(avatarResult.getAvatar());
                    }
                }

                public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                    i.w("Getting avatar", gVar.toString());
                }
            }, "api/v1/avatars/current").auF();
        }
    }

    public void auj() {
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/getcontactinfo");
        new com.iqoption.mobbtech.connect.request.a.a.h(BackCall.class, RequestManager.a(stringBuilder.toString(), null, IQApp.Dk()), new com.iqoption.mobbtech.connect.a.b<BackCall>() {
            public void a(com.iqoption.mobbtech.connect.response.g gVar) {
            }

            /* renamed from: c */
            public void onSuccess(BackCall backCall) {
                if (h.this.cUn.get() != null && ((cr) h.this.cUn.get()).isAdded() && backCall != null) {
                    com.iqoption.app.managers.a.Gf().a(backCall);
                }
            }
        }, "api/getcontactinfo").auG();
    }

    private void auk() {
        if (aud()) {
            com.iqoption.core.g.b.bab.Ya().b(com.iqoption.core.h.i.Yo()).a(j.cqT, k.cpR);
        }
    }

    public static s<k> aul() {
        s<k> aR;
        if (af.DX().EB()) {
            boolean Dh = af.DX().Dh();
            if (Dh) {
                RequestManager.atO().atU();
            }
            aR = o.aR(k.ee(Dh));
        } else {
            aR = null;
        }
        return aR != null ? aR : o.b(ag.a(l.ajD, "api/regulation"), m.$instance, com.iqoption.core.d.a.aSe);
    }

    static final /* synthetic */ s aum() {
        Context Dk = IQApp.Dk();
        String in = IQApp.Dl().in("api/regulation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(in);
        stringBuilder.append("api/regulation");
        return new com.iqoption.mobbtech.connect.request.a.a.b(k.class, RequestManager.a(stringBuilder.toString(), null, Dk), "api/regulation").auF();
    }
}
