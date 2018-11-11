package com.iqoption.fragment.rightpanel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.ahi;
import com.iqoption.util.bf;
import com.iqoption.view.a.b;
import com.iqoption.view.a.b.a;
import com.squareup.picasso.Picasso;

/* compiled from: ClosedRightPanelDelegate */
public final class v extends au implements a {
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private ahi cGp;

    v(RightPanelFragment rightPanelFragment, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super(rightPanelFragment);
        x(aVar);
        b.aIK().a((a) this);
    }

    public void onTick(long j) {
        bv(j);
    }

    public boolean amH() {
        throw new UnsupportedOperationException("This delegate does not implement the method");
    }

    public void amI() {
        throw new UnsupportedOperationException("This delegate does not implement the method");
    }

    public void amJ() {
        throw new UnsupportedOperationException("This delegate does not implement the method");
    }

    public boolean amK() {
        throw new UnsupportedOperationException("This delegate does not implement the method");
    }

    public double UO() {
        throw new UnsupportedOperationException("This delegate does not implement the method");
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.cGp = ahi.f(layoutInflater);
        anQ();
        return this.cGp.getRoot();
    }

    void w(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super.w(aVar);
        x(aVar);
    }

    void destroy() {
        super.destroy();
        b.aIK().b((a) this);
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.aiJ != null ? this.aiJ.instrumentType : null;
    }

    private void x(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        this.aiJ = aVar;
        if (this.cGp != null) {
            anQ();
        }
    }

    private void anQ() {
        Picasso.with(getContext()).load(this.aiJ.getImage()).into(this.cGp.bQI);
        bv(af.Hu().Hw());
    }

    private void bv(long j) {
        if (this.aiJ.ba(j)) {
            b.aIK().b((a) this);
            amU().resetDelegate();
            return;
        }
        long bb = this.aiJ.bb(j);
        if (bb == Long.MAX_VALUE) {
            this.cGp.bQJ.setVisibility(4);
            return;
        }
        this.cGp.bQJ.setVisibility(0);
        this.cGp.bQJ.setText(bf.t(j, bb));
    }
}
