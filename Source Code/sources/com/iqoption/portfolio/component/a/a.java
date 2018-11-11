package com.iqoption.portfolio.component.a;

import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.iqoption.core.util.p;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.util.bc;

/* compiled from: CalculationBinder */
public class a {
    private final o cYW;

    public a(n nVar) {
        this.cYW = nVar.axx();
    }

    public void a(TextView textView, TextView textView2, com.iqoption.portfolio.a aVar) {
        textView.setText(this.cYW.B(aVar.getValue()));
        if (aVar.avK()) {
            textView2.setText(String.format(this.cYW.cZR, new Object[]{p.gX(this.cYW.B(aVar.getSellPnl())), p.o(aVar.avJ())}));
            textView2.setTextColor(this.cYW.ahg);
        } else if (aVar.avL()) {
            textView2.setText(String.format(this.cYW.cZR, new Object[]{p.gY(this.cYW.B(Math.abs(aVar.getSellPnl()))), p.o(Math.abs(aVar.avJ()))}));
            textView2.setTextColor(this.cYW.ahh);
        } else {
            textView2.setText(null);
        }
    }

    public void b(TextView textView, TextView textView2, com.iqoption.portfolio.a aVar) {
        textView.setTextColor(this.cYW.ahi);
        if (aVar.avK()) {
            textView.setText(p.gX(this.cYW.B(aVar.getSellPnl())));
            textView2.setTextColor(this.cYW.ahg);
            textView2.setText(p.b(Double.valueOf(aVar.avJ())));
        } else if (aVar.avL()) {
            textView.setText(p.gY(this.cYW.B(Math.abs(aVar.getSellPnl()))));
            textView2.setTextColor(this.cYW.ahh);
            textView2.setText(p.c(Double.valueOf(Math.abs(aVar.avJ()))));
        } else {
            textView.setText(null);
            textView2.setText(null);
        }
    }

    public void a(TextView textView, com.iqoption.portfolio.a aVar) {
        if (aVar.avK()) {
            textView.setText(a(p.gX(this.cYW.B(aVar.getSellPnl())), p.b(Double.valueOf(aVar.avJ())), this.cYW.daa));
        } else if (aVar.avL()) {
            textView.setText(a(p.gY(this.cYW.B(Math.abs(aVar.getSellPnl()))), p.c(Double.valueOf(Math.abs(aVar.avJ()))), this.cYW.dab));
        } else {
            textView.setText(this.cYW.B(0.0d));
        }
    }

    public void b(TextView textView, com.iqoption.portfolio.a aVar) {
        String B = this.cYW.B(aVar.getValue());
        if (aVar.avK()) {
            textView.setText(a(B, p.b(Double.valueOf(aVar.avJ())), this.cYW.daa));
        } else if (aVar.avL()) {
            textView.setText(a(B, p.c(Double.valueOf(Math.abs(aVar.avJ()))), this.cYW.dab));
        } else {
            textView.setText(B);
        }
    }

    public void c(TextView textView, com.iqoption.portfolio.a aVar) {
        if (aVar.avN()) {
            textView.setText(p.gX(this.cYW.B(aVar.getExpPnl())));
        } else if (aVar.avO()) {
            textView.setText(p.gY(this.cYW.B(Math.abs(aVar.getExpPnl()))));
        } else {
            textView.setText(null);
        }
    }

    private static CharSequence a(String str, String str2, ForegroundColorSpan foregroundColorSpan) {
        return new bc().jO(str).jO(" ").bM(foregroundColorSpan).jO(str2).aCT();
    }
}
