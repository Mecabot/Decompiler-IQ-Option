package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.portfolio.d;
import java.util.Iterator;

/* compiled from: OpenGroupItem */
public class i implements f {
    private final a aiJ;
    private final d daj;
    private final String dak;
    private final boolean dal;
    private ImmutableList<j> dam;
    private ImmutableList<f> dan;
    private double dao = -1.0d;

    public static String b(d dVar) {
        a Jg = dVar.Jg();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("group:");
        stringBuilder.append(dVar.getInstrumentType());
        stringBuilder.append(":");
        stringBuilder.append(Jg != null ? Jg.getActiveId() : 0);
        return stringBuilder.toString();
    }

    public i(d dVar) {
        this.daj = dVar;
        this.aiJ = dVar.Jg();
        this.dal = dVar.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT;
        this.dak = awY() ? axb().Ml() : b(dVar);
    }

    @NonNull
    public String Ml() {
        return this.dak;
    }

    public int getViewType() {
        if (avQ()) {
            return awY() ? 5 : 4;
        }
        return awY() ? 2 : 1;
    }

    private boolean avQ() {
        return this.daj.avQ();
    }

    @Nullable
    public String awV() {
        return this.aiJ != null ? this.aiJ.getImage() : null;
    }

    @Nullable
    public String getActiveName() {
        return this.aiJ != null ? com.iqoption.util.e.a.s(this.aiJ) : null;
    }

    @Nullable
    public String awW() {
        return this.aiJ != null ? com.iqoption.util.e.a.E(this.aiJ) : null;
    }

    public int avT() {
        return this.daj.size();
    }

    @NonNull
    public String awX() {
        return com.iqoption.util.e.a.O(this.daj.getInstrumentType());
    }

    public com.iqoption.portfolio.a avU() {
        return this.daj.avU();
    }

    public boolean isCall() {
        Iterator sI = axa().iterator();
        while (sI.hasNext()) {
            if (!((j) sI.next()).isCall()) {
                return false;
            }
        }
        return true;
    }

    public boolean awY() {
        return this.daj.size() == 1;
    }

    public ImmutableList<f> awZ() {
        if (this.dan == null) {
            ImmutableList axa = axa();
            ImmutableList.a aVar = new ImmutableList.a();
            long j = -1;
            Iterator sI = axa.iterator();
            while (sI.hasNext()) {
                j jVar = (j) sI.next();
                if (jVar.getViewType() == 6) {
                    long awU = ((h) jVar).awU();
                    if (j != awU) {
                        aVar.ae(new c(awU));
                        j = awU;
                    }
                }
                aVar.ae(jVar);
            }
            this.dan = aVar.sP();
        }
        return this.dan;
    }

    public ImmutableList<j> axa() {
        if (this.dam == null) {
            ImmutableList.a aVar = new ImmutableList.a();
            Iterator sI = this.daj.avS().iterator();
            while (sI.hasNext()) {
                e eVar = (e) sI.next();
                switch (eVar.getInstrumentType()) {
                    case BINARY_INSTRUMENT:
                    case TURBO_INSTRUMENT:
                    case DIGITAL_INSTRUMENT:
                    case FX_INSTRUMENT:
                        aVar.ae(new h(this, eVar));
                        break;
                    case CFD_INSTRUMENT:
                    case FOREX_INSTRUMENT:
                    case CRYPTO_INSTRUMENT:
                        aVar.ae(new g(this, (Position) eVar));
                        break;
                    default:
                        break;
                }
            }
            this.dam = aVar.sP();
        }
        return this.dam;
    }

    public j axb() {
        return (j) s.a(axa(), null);
    }

    public boolean awR() {
        return this.dal;
    }

    public long getId() {
        return this.daj.getId();
    }

    public String toString() {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GroupItem{, group=");
        stringBuilder.append(this.daj);
        stringBuilder.append(", active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", crypto=");
        stringBuilder.append(this.dal);
        stringBuilder.append(", size=");
        if (this.dam == null) {
            i = 0;
        } else {
            i = this.dam.size();
        }
        stringBuilder.append(i);
        stringBuilder.append(", quantity=");
        stringBuilder.append(this.dao);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
