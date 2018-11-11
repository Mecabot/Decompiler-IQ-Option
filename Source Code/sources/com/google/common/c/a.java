package com.google.common.c;

/* compiled from: DoubleMath */
public final class a {
    private static final double UE = Math.log(2.0d);
    static final double[] UF = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static boolean b(double d, double d2, double d3) {
        d.a("tolerance", d3);
        return Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (Double.isNaN(d) && Double.isNaN(d2));
    }

    public static int c(double d, double d2, double d3) {
        if (b(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return com.google.common.primitives.a.compare(Double.isNaN(d), Double.isNaN(d2));
    }
}
