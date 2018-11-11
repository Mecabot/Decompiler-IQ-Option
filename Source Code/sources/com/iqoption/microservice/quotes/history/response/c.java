package com.iqoption.microservice.quotes.history.response;

/* compiled from: GetFirstCandles */
public final class c {
    public long[] cSB;
    public long[] cSC;
    public int[] cSD;
    public double[] cSE;
    public double[] cSF;
    public double[] cSG;
    public double[] cSH;
    public double[] cSI;

    private c() {
    }

    public c(int i) {
        this.cSB = new long[i];
        this.cSC = new long[i];
        this.cSD = new int[i];
        this.cSE = new double[i];
        this.cSF = new double[i];
        this.cSG = new double[i];
        this.cSH = new double[i];
        this.cSI = new double[i];
    }
}
