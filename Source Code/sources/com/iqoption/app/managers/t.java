package com.iqoption.app.managers;

import com.google.common.b.e;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.StockRate;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.system.a.d;
import com.iqoption.util.ag;
import java.lang.ref.WeakReference;

/* compiled from: OtnStockRateManager */
public class t implements com.iqoption.view.a.b.a {
    private final a ans;
    private volatile boolean ant = true;
    private final b anu = new b();
    private final boolean anv;
    private final boolean anw;

    /* compiled from: OtnStockRateManager */
    public interface a {
        void a(Double d, Double d2);
    }

    /* compiled from: OtnStockRateManager */
    private final class b extends d {
        private b() {
        }

        @e
        public void onUpdateActiveSpreadEvent(com.iqoption.app.helpers.a.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new w(t.this));
        }
    }

    public t(a aVar) {
        boolean z = true;
        this.ans = aVar;
        com.iqoption.app.managers.feature.b HT = com.iqoption.app.managers.feature.b.HT();
        this.anw = HT.ff("coinmarketcap");
        if (this.anw || !HT.ff("show-otn-withdrawal-rate")) {
            z = false;
        }
        this.anv = z;
    }

    public boolean isEnabled() {
        return this.anw || this.anv;
    }

    public void onResume() {
        this.ant = false;
        if (this.anv) {
            this.anu.register();
            y.a(true, InstrumentType.CRYPTO_INSTRUMENT);
        }
        if (this.anw) {
            com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this, Integer.valueOf(150));
        }
    }

    public void onPause() {
        this.ant = true;
        if (this.anv) {
            this.anu.unregister();
            y.a(false, InstrumentType.CRYPTO_INSTRUMENT);
        }
        if (this.anw) {
            com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        }
    }

    private void a(Double d, Double d2) {
        if (!this.ant && this.ans != null) {
            this.ans.a(d, d2);
        }
    }

    public void Ho() {
        Double d = null;
        if (this.anw) {
            WeakReference weakReference = new WeakReference(this);
            ag.a(new com.iqoption.mobbtech.connect.request.a.a.b(StockRate[].class, RequestManager.a("https://api.coinmarketcap.com/v1/ticker/open-trading-network/", null, IQApp.Dk()), "https://api.coinmarketcap.com/v1/ticker/open-trading-network/").auF(), new u(weakReference), new v(weakReference));
        } else if (this.anv) {
            Double d2;
            com.iqoption.core.microservices.f.a.a.a a = com.iqoption.app.helpers.a.FI().a(833, InstrumentType.CRYPTO_INSTRUMENT);
            if (a == null) {
                d2 = null;
            } else {
                d2 = com.iqoption.core.microservices.f.a.a.a.h(a.WZ());
            }
            if (a != null) {
                d = com.iqoption.core.microservices.f.a.a.a.h(a.WY());
            }
            a(d2, d);
        }
    }

    static final /* synthetic */ void b(WeakReference weakReference, Throwable th) {
        t tVar = (t) weakReference.get();
        if (tVar != null) {
            tVar.a(null, null);
        }
    }

    public void onTick(long j) {
        Ho();
    }
}
