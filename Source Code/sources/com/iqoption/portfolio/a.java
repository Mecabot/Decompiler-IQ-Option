package com.iqoption.portfolio;

/* compiled from: Calculation */
public class a {
    private double amZ;
    private double cXW;
    private double cXX;
    private double cXY;
    private double cXZ;
    private long cYa;
    private double value;

    public void e(double d, double d2, double d3) {
        this.amZ += d;
        this.cXW += d2;
        this.cXY += d3;
        update();
    }

    public void a(a aVar) {
        e(aVar.amZ, aVar.cXW, aVar.cXY);
    }

    public void a(double d, double d2, double d3, long j) {
        this.amZ = d;
        this.cXW = d2;
        this.cXY = d3;
        this.cYa = j;
        update();
    }

    public void reset() {
        a(0.0d, 0.0d, 0.0d, 0);
    }

    private void update() {
        if (this.amZ == 0.0d) {
            this.cXX = 0.0d;
            this.cXZ = 0.0d;
        } else {
            this.cXX = (this.cXW / this.amZ) * 100.0d;
            this.cXZ = (this.cXY / this.amZ) * 100.0d;
        }
        this.value = this.amZ + this.cXW;
    }

    public boolean avH() {
        return this.cYa > 0;
    }

    public long avI() {
        return this.cYa;
    }

    public double GN() {
        return this.amZ;
    }

    public double getSellPnl() {
        return this.cXW;
    }

    public double avJ() {
        return this.cXX;
    }

    public boolean avK() {
        return this.cXW > 0.0d;
    }

    public boolean avL() {
        return this.cXW < 0.0d;
    }

    public double getExpPnl() {
        return this.cXY;
    }

    public double avM() {
        return this.cXZ;
    }

    public boolean avN() {
        return this.cXY > 0.0d;
    }

    public boolean avO() {
        return this.cXY < 0.0d;
    }

    public double getValue() {
        return this.value;
    }
}
