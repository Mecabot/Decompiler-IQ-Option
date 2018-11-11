package com.iqoption.trading.history.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.util.p;
import com.iqoption.d.fm;
import com.iqoption.trading.history.b.b;
import com.squareup.picasso.Picasso;
import java.util.Calendar;

/* compiled from: ClosedPortfolioViewHolder */
public class a extends ViewHolder implements OnClickListener {
    private final c dsB;
    private final com.iqoption.trading.history.a.b.a dsC;
    private final fm dsD;
    private b dsE;

    public a(fm fmVar, com.iqoption.trading.history.a.b.a aVar, c cVar) {
        super(fmVar.getRoot());
        this.dsC = aVar;
        this.dsB = cVar;
        this.dsD = fmVar;
        this.dsD.bmK.setOnClickListener(this);
    }

    public void a(b bVar, b bVar2) {
        if (bVar == null) {
            aEL();
            return;
        }
        String image;
        CharSequence s;
        String O;
        this.dsE = bVar;
        Context context = getContext();
        if (bVar2 == null || !l(bVar.getCloseTime(), bVar2.getCloseTime())) {
            this.dsD.bnM.setVisibility(0);
            this.dsD.bnM.setText(this.dsB.bM(bVar.getCloseTime()));
        } else {
            this.dsD.bnM.setVisibility(8);
        }
        com.iqoption.core.microservices.tradingengine.response.active.a Jg = bVar.Jg();
        if (Jg != null) {
            image = Jg.getImage();
            s = com.iqoption.util.e.a.s(Jg);
            O = com.iqoption.util.e.a.O(Jg.getInstrumentType());
        } else {
            O = null;
            image = O;
            s = image;
        }
        if (!TextUtils.isEmpty(image)) {
            Picasso.with(context).load(image).into(this.dsD.afU);
        }
        if (s != null) {
            this.dsD.bnL.setText(s);
        } else {
            this.dsD.bnL.setText(null);
        }
        if (O != null) {
            this.dsD.bnN.setText(a(O, bVar.amZ, bVar.aEM()));
        }
        double aEP = bVar.aEP();
        if (aEP > 0.0d) {
            this.dsD.bnP.setText(p.gX(this.dsB.B(aEP)));
            this.dsD.bnP.setTextColor(this.dsB.ahg);
            this.dsD.bnQ.setText(p.b(Double.valueOf(bVar.aEQ())));
        } else if (aEP < 0.0d) {
            this.dsD.bnP.setText(p.gY(this.dsB.B(Math.abs(aEP))));
            this.dsD.bnP.setTextColor(this.dsB.ahh);
            this.dsD.bnQ.setText(p.c(Double.valueOf(Math.abs(bVar.aEQ()))));
        } else {
            this.dsD.bnP.setText(this.dsB.B(aEP));
            this.dsD.bnP.setTextColor(this.dsB.ahi);
            this.dsD.bnQ.setText(p.o(bVar.aEQ()));
        }
        this.dsD.bnO.setVisibility(8);
        this.dsD.bmK.setEnabled(true);
    }

    private void aEL() {
        this.dsD.bmK.setEnabled(false);
        this.dsD.bnM.setVisibility(8);
        this.dsD.bnO.setVisibility(0);
    }

    private String a(String str, double d, Integer num) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(',');
        stringBuilder.append(' ');
        stringBuilder.append(String.format(this.dsB.cZE, new Object[]{this.dsB.B(d)}));
        if (num != null) {
            stringBuilder.append(' ');
            stringBuilder.append('x');
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
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

    private Context getContext() {
        return this.dsD.getRoot().getContext();
    }

    public void onClick(View view) {
        if (this.dsE != null && this.dsC != null) {
            this.dsC.a(this.dsE);
        }
    }
}
