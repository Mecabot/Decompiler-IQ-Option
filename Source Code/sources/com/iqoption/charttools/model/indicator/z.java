package com.iqoption.charttools.model.indicator;

import android.os.Parcel;
import c.a.a.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/model/indicator/MetaIndicatorParceler;", "Lkotlinx/android/parcel/Parceler;", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class z implements a<x> {
    public static final z ayE = new z();

    private z() {
    }

    /* renamed from: D */
    public x E(Parcel parcel) {
        h.e(parcel, "parcel");
        String readString = parcel.readString();
        if (readString != null) {
            switch (readString.hashCode()) {
                case -2105129931:
                    if (readString.equals("Alligator")) {
                        return c.axZ;
                    }
                    break;
                case -1858828435:
                    if (readString.equals("WilliamsRange")) {
                        return ag.ayQ;
                    }
                    break;
                case -1846191635:
                    if (readString.equals("T-Line")) {
                        return q.ayv;
                    }
                    break;
                case -1788933333:
                    if (readString.equals("V-Line")) {
                        return r.ayw;
                    }
                    break;
                case -1719515127:
                    if (readString.equals("Stochastic")) {
                        return af.ayP;
                    }
                    break;
                case -1517311537:
                    if (readString.equals("MovingAverage")) {
                        return ab.ayH;
                    }
                    break;
                case -877554489:
                    if (readString.equals("Ichimoku")) {
                        return t.ayy;
                    }
                    break;
                case -296651592:
                    if (readString.equals("Momentum")) {
                        return aa.ayG;
                    }
                    break;
                case 2112:
                    if (readString.equals("BB")) {
                        return f.ayc;
                    }
                    break;
                case 64661:
                    if (readString.equals("ADX")) {
                        return a.axX;
                    }
                    break;
                case 65151:
                    if (readString.equals("ATR")) {
                        return b.axY;
                    }
                    break;
                case 66537:
                    if (readString.equals("CCI")) {
                        return g.ayd;
                    }
                    break;
                case 67907:
                    if (readString.equals("DPO")) {
                        return j.ayi;
                    }
                    break;
                case 74257:
                    if (readString.equals("KDJ")) {
                        return u.ayz;
                    }
                    break;
                case 81448:
                    if (readString.equals("RSI")) {
                        return ad.ayJ;
                    }
                    break;
                case 2358517:
                    if (readString.equals("MACD")) {
                        return w.ayD;
                    }
                    break;
                case 2368532:
                    if (readString.equals("Line")) {
                        return p.ayu;
                    }
                    break;
                case 702156550:
                    if (readString.equals("Fibonacci")) {
                        return m.ayr;
                    }
                    break;
                case 758524311:
                    if (readString.equals("FibonacciSpiral")) {
                        return n.ays;
                    }
                    break;
                case 991297035:
                    if (readString.equals("ParabolicSAR")) {
                        return ac.ayI;
                    }
                    break;
                case 1057116881:
                    if (readString.equals("Fractal")) {
                        return s.ayx;
                    }
                    break;
                case 1243960643:
                    if (readString.equals("AwesomeOscillator")) {
                        return d.aya;
                    }
                    break;
                case 1260906750:
                    if (readString.equals("BelkhayateTiming")) {
                        return e.ayb;
                    }
                    break;
                case 1455115628:
                    if (readString.equals("FibonacciArc")) {
                        return l.ayq;
                    }
                    break;
                case 2105225849:
                    if (readString.equals("H-Line")) {
                        return o.ayt;
                    }
                    break;
            }
        }
        return ae.CREATOR.createFromParcel(parcel);
    }

    public void a(x xVar, Parcel parcel, int i) {
        h.e(xVar, "$receiver");
        h.e(parcel, "parcel");
        parcel.writeString(xVar.getType());
        xVar.writeToParcel(parcel, i);
    }
}
