package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.portfolio.e;
import java.util.Iterator;

/* compiled from: PendingGroupItem */
public class l implements k {
    private final a aiJ;
    private final String dak;
    private ImmutableList<m> dam;
    private double dao = -1.0d;
    private final e dar;
    private double das = -1.0d;

    public static String b(e eVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pendingGroup:");
        stringBuilder.append(eVar.getId());
        return stringBuilder.toString();
    }

    public l(e eVar) {
        this.dar = eVar;
        this.aiJ = eVar.Jg();
        this.dak = awY() ? axn().Ml() : b(eVar);
    }

    @NonNull
    public String Ml() {
        return this.dak;
    }

    public int getViewType() {
        int i = 1;
        if (Order.ON_MKT_OPEN.equals(axn().axr().getType())) {
            if (awY()) {
                i = 5;
            }
            return i;
        }
        if (awY()) {
            i = 2;
        }
        return i;
    }

    @NonNull
    public a Jg() {
        return this.aiJ;
    }

    public ImmutableList<m> axa() {
        if (this.dam == null) {
            ImmutableList.a aVar = new ImmutableList.a();
            Iterator sI = this.dar.Gm().iterator();
            while (sI.hasNext()) {
                aVar.ae(new m(this, (Order) sI.next()));
            }
            this.dam = aVar.sP();
        }
        return this.dam;
    }

    public boolean awY() {
        return this.dar.size() == 1;
    }

    public double axe() {
        if (this.dao == -1.0d) {
            this.dao = 0.0d;
            Iterator sI = axa().iterator();
            while (sI.hasNext()) {
                m mVar = (m) sI.next();
                if (!mVar.isCall()) {
                    this.dao = 0.0d;
                    break;
                }
                this.dao += mVar.axe();
            }
        }
        return this.dao;
    }

    public int axm() {
        return this.dar.size();
    }

    public m axn() {
        return (m) s.a(axa(), null);
    }

    public boolean awR() {
        return this.aiJ.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT;
    }

    public boolean axo() {
        Iterator sI = axa().iterator();
        while (sI.hasNext()) {
            if (!((m) sI.next()).isCall()) {
                return false;
            }
        }
        return true;
    }

    public String Xg() {
        return com.iqoption.util.e.a.E(this.aiJ);
    }

    public double getInvestment() {
        if (this.das == -1.0d) {
            this.das = 0.0d;
            Iterator sI = axa().iterator();
            while (sI.hasNext()) {
                this.das += ((m) sI.next()).getInvestment();
            }
        }
        return this.das;
    }
}
