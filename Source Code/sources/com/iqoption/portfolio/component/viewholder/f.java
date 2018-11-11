package com.iqoption.portfolio.component.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.analytics.k;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.d.zs;
import com.iqoption.portfolio.b;
import com.iqoption.portfolio.component.n;
import java.util.Calendar;

/* compiled from: ClosedGroupViewHolder */
public class f extends ViewHolder implements OnClickListener {
    private final n cYT;
    private final zs daK;
    private b daL;

    public f(zs zsVar, n nVar) {
        super(zsVar.getRoot());
        zsVar.bjl.setOnClickListener(this);
        this.cYT = nVar;
        this.daK = zsVar;
    }

    public void b(b bVar, b bVar2) {
        String image;
        CharSequence E;
        CharSequence O;
        this.daL = bVar;
        if (bVar2 == null || !l(bVar.getCloseTime(), bVar2.getCloseTime())) {
            this.daK.bnM.setVisibility(0);
            this.daK.bnM.setText(this.cYT.axx().bM(bVar.getCloseTime()));
        } else {
            this.daK.bnM.setVisibility(8);
        }
        a Jg = bVar.Jg();
        if (Jg != null) {
            image = Jg.getImage();
            E = com.iqoption.util.e.a.E(Jg);
            O = com.iqoption.util.e.a.O(Jg.getInstrumentType());
        } else {
            O = null;
            image = O;
            E = image;
        }
        this.cYT.axC().a(this.daK.afU, image);
        if (E == null) {
            this.daK.btN.setText(null);
        } else if (bVar.avT() > 1) {
            this.daK.btN.setText(String.format(this.cYT.axx().cZL, new Object[]{E, Integer.valueOf(bVar.avT())}));
        } else {
            this.daK.btN.setText(E);
        }
        this.daK.bnN.setText(O);
        this.cYT.axB().b(this.daK.agQ, this.daK.brz, bVar.avU());
    }

    private boolean l(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        instance.setTimeInMillis(j2);
        int i3 = instance.get(6);
        if (i == instance.get(1) && i2 == i3) {
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (this.daL != null) {
            this.cYT.c(this.daL);
            k.a(this.daL);
        }
    }
}
