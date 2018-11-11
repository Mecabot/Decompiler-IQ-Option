package jumio.nv.nfc;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.lang.reflect.Array;
import java.util.Vector;

/* compiled from: PktDecoder */
public class cc {
    private int A;
    private int B;
    private int C;
    private boolean D;
    private by a;
    private boolean b = false;
    private ByteArrayInputStream c;
    private cg d;
    private cb e;
    private final int f = 3;
    private cd g;
    private df h;
    private cu[][] i;
    private int j;
    private bx[][][] k;
    private int[][][][][] l;
    private ce[][][][] m;
    private ce[][][][] n;
    private int o = 0;
    private int p;
    private boolean q = false;
    private boolean r = false;
    private int s;
    private Vector[] t;
    private int u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public cc(cg cgVar, cb cbVar, df dfVar, by byVar, boolean z, int i) {
        this.d = cgVar;
        this.e = cbVar;
        this.h = dfVar;
        this.D = z;
        this.g = new cd(dfVar);
        this.a = byVar;
        this.u = 0;
        this.w = false;
        this.v = i;
    }

    public bz[][][][][] a(int i, int[] iArr, int i2, bz[][][][][] bzVarArr, boolean z, ByteArrayInputStream byteArrayInputStream) {
        int i3 = i;
        this.p = i3;
        this.o = i2;
        this.j = this.a.d();
        this.b = z;
        this.c = byteArrayInputStream;
        this.q = ((Boolean) this.d.o.d(this.j)).booleanValue();
        this.s = 0;
        this.r = ((Boolean) this.d.p.d(this.j)).booleanValue();
        bz[][][][][] bzVarArr2 = new bz[i3][][][][];
        this.l = new int[i3][][][][];
        this.m = new ce[i3][][][];
        this.n = new ce[i3][][][];
        this.i = new cu[i3][];
        this.k = new bx[i3][][];
        int a = this.a.a();
        int b = this.a.b();
        int i4 = 0;
        while (i4 < i3) {
            int i5 = 1;
            bzVarArr2[i4] = new bz[(iArr[i4] + 1)][][][];
            this.l[i4] = new int[(iArr[i4] + 1)][][][];
            this.m[i4] = new ce[(iArr[i4] + 1)][][];
            this.n[i4] = new ce[(iArr[i4] + 1)][][];
            this.i[i4] = new cu[(iArr[i4] + 1)];
            this.k[i4] = new bx[(iArr[i4] + 1)][];
            int c = this.a.c(i4, iArr[i4]);
            int d = this.a.d(i4, iArr[i4]);
            int a2 = this.a.a(this.j, i4, iArr[i4]) + c;
            int b2 = this.a.b(this.j, i4, iArr[i4]) + d;
            int i6 = 0;
            while (i6 <= iArr[i4]) {
                double d2;
                int ceil = (int) Math.ceil(((double) c) / ((double) (i5 << (iArr[i4] - i6))));
                i5 = d;
                int i7 = c;
                int i8 = i5;
                c = (int) Math.ceil(((double) i5) / ((double) (1 << (iArr[i4] - i6))));
                i5 = (int) Math.ceil(((double) a2) / ((double) (1 << (iArr[i4] - i6))));
                int i9 = a2;
                d = (int) Math.ceil(((double) b2) / ((double) (1 << (iArr[i4] - i6))));
                double a3 = (double) a(this.j, i4, i6);
                int i10 = b2;
                double b3 = (double) b(this.j, i4, i6);
                this.i[i4][i6] = new cu();
                if (i5 > ceil) {
                    d2 = b3;
                    this.i[i4][i6].a = ((int) Math.ceil(((double) (i5 - a)) / a3)) - ((int) Math.floor(((double) (ceil - a)) / a3));
                } else {
                    d2 = b3;
                    this.i[i4][i6].a = 0;
                }
                if (d > c) {
                    this.i[i4][i6].b = ((int) Math.ceil(((double) (d - b)) / d2)) - ((int) Math.floor(((double) (c - b)) / d2));
                } else {
                    this.i[i4][i6].b = 0;
                }
                i5 = i6 == 0 ? 1 : 4;
                ceil = this.i[i4][i6].a * this.i[i4][i6].b;
                d = i5 + 1;
                this.m[i4][i6] = (ce[][]) Array.newInstance(ce.class, new int[]{ceil, d});
                this.n[i4][i6] = (ce[][]) Array.newInstance(ce.class, new int[]{ceil, d});
                bzVarArr2[i4][i6] = new bz[d][][];
                this.l[i4][i6] = new int[d][][];
                this.k[i4][i6] = new bx[ceil];
                d(i4, i6, iArr[i4]);
                eg e = this.a.e(this.j, i4);
                for (i3 = i6 == 0 ? 0 : 1; i3 < i5; i3++) {
                    cu cuVar = ((eg) e.a(i6, i3)).e;
                    bzVarArr2[i4][i6][i3] = (bz[][]) Array.newInstance(bz.class, new int[]{cuVar.b, cuVar.a});
                    this.l[i4][i6][i3] = (int[][]) Array.newInstance(int.class, new int[]{cuVar.b, cuVar.a});
                    for (d = cuVar.b - 1; d >= 0; d--) {
                        dq.a(this.l[i4][i6][i3][d], 3);
                    }
                }
                i6++;
                c = i7;
                d = i8;
                a2 = i9;
                b2 = i10;
                i3 = i;
                i5 = 1;
            }
            i4++;
            i3 = i;
        }
        return bzVarArr2;
    }

    private void d(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (this.k[i4][i5].length != 0) {
            int i7;
            cu a = this.a.a(null);
            cu b = this.a.b(null);
            int h = this.a.h();
            int i8 = this.a.i();
            int j = this.a.j();
            int k = this.a.k();
            int e = this.e.e();
            int f = this.e.f();
            this.e.c();
            this.e.d();
            if (a.a != 0) {
                e = (a.a * j) + h;
            }
            int i9 = e;
            if (a.b != 0) {
                f = i8 + (a.b * k);
            }
            int i10 = f;
            if (a.a != b.a - 1) {
                h = a.a;
            }
            if (a.b != b.b - 1) {
                i7 = a.b;
            }
            int b2 = this.e.b(i4);
            int c = this.e.c(i4);
            i7 = this.a.c(i4, i6);
            int d = this.a.d(i4, i6);
            h = this.a.a(this.j, i4, i6) + i7;
            i8 = this.a.b(this.j, i4, i6) + d;
            i6 -= i5;
            double d2 = (double) (1 << i6);
            i7 = (int) Math.ceil(((double) i7) / d2);
            d = (int) Math.ceil(((double) d) / d2);
            h = (int) Math.ceil(((double) h) / d2);
            i8 = (int) Math.ceil(((double) i8) / d2);
            int a2 = this.a.a();
            f = this.a.b();
            double a3 = (double) a(this.j, i4, i5);
            int i11 = i9;
            int i12 = i10;
            double b3 = (double) b(this.j, i4, i5);
            int i13 = i6;
            int i14 = i7;
            j = (int) (a3 / 2.0d);
            i7 = (int) (b3 / 2.0d);
            i6 = this.k[i4][i5].length;
            d -= f;
            int i15 = i7;
            int i16 = j;
            j = (int) Math.floor(((double) ((i8 - 1) - f)) / b3);
            i8 = i14 - a2;
            int floor = (int) Math.floor(((double) d) / b3);
            i7 = (int) Math.floor(((double) i8) / a3);
            int i17 = d;
            h = (int) Math.floor(((double) ((h - 1) - a2)) / a3);
            i6 = (int) a3;
            int i18 = i6 << i13;
            int i19 = (int) b3;
            int i20 = i19 << i13;
            eg e2 = this.a.e(this.j, i4);
            d = floor;
            i13 = 0;
            while (d <= j) {
                int i21;
                int i22;
                double d3;
                int i23;
                double d4;
                int i24;
                int i25;
                int i26 = j;
                j = i7;
                while (j <= h) {
                    eg egVar;
                    if (j != i7 || i8 % (b2 * i6) == 0) {
                        i14 = a2 + ((j * b2) * i18);
                        i21 = i7;
                    } else {
                        i21 = i7;
                        i14 = i11;
                    }
                    i7 = floor;
                    if (d != i7 || i17 % (c * i19) == 0) {
                        floor = f + ((d * c) * i20);
                        i22 = i6;
                    } else {
                        i22 = i6;
                        floor = i12;
                    }
                    int i27 = h;
                    h = (int) (((double) a2) + (((double) j) * a3));
                    int i28 = j;
                    int i29 = i21;
                    i21 = i7;
                    d3 = b3;
                    eg egVar2 = e2;
                    int i30 = d;
                    i10 = i27;
                    i23 = i8;
                    eg egVar3 = egVar2;
                    int i31 = i28;
                    d4 = a3;
                    i14 = f;
                    floor = a2;
                    this.k[i4][i5][i13] = new bx(i5, h, (int) (((double) f) + (((double) d) * b3)), i22, i19, i14, floor, i18, i20);
                    eg egVar4;
                    double d5;
                    bt btVar;
                    if (i5 == 0) {
                        a2 = floor + (i31 * i22);
                        i6 = a2 + i22;
                        f = i14 + (i30 * i19);
                        i7 = f + i19;
                        egVar4 = (eg) egVar3.a(0, 0);
                        if (a2 < egVar4.h) {
                            a2 = egVar4.h;
                        }
                        if (i6 > egVar4.h + egVar4.l) {
                            i6 = egVar4.h + egVar4.l;
                        }
                        if (f < egVar4.i) {
                            f = egVar4.i;
                        }
                        if (i7 > egVar4.i + egVar4.m) {
                            i7 = egVar4.i + egVar4.m;
                        }
                        d = egVar4.n;
                        i8 = egVar4.o;
                        i24 = i10;
                        i25 = i19;
                        d5 = (double) i8;
                        k = (int) Math.floor(((double) (f - i14)) / d5);
                        int i32 = i8;
                        int floor2 = (int) Math.floor(((double) (egVar4.i - i14)) / d5);
                        eg egVar5 = egVar4;
                        int floor3 = (int) Math.floor(((double) ((i7 - 1) - i14)) / d5);
                        double d6 = (double) d;
                        j = (int) Math.floor(((double) (egVar4.h - floor)) / d6);
                        e = (int) Math.floor(((double) (a2 - floor)) / d6);
                        h = (int) Math.floor(((double) ((i6 - 1) - floor)) / d6);
                        if (i6 - a2 <= 0 || i7 - f <= 0) {
                            this.k[i4][i5][i13].k[0] = 0;
                            this.m[i4][i5][i13][0] = new ce(0, 0);
                            this.n[i4][i5][i13][0] = new ce(0, 0);
                            i8 = i5;
                            egVar = egVar3;
                            j = i31 + 1;
                            i13++;
                            i5 = i8;
                            f = i14;
                            a2 = floor;
                            d = i30;
                            i8 = i23;
                            floor = i21;
                            i6 = i22;
                            i7 = i29;
                            a3 = d4;
                            b3 = d3;
                            i19 = i25;
                            h = i24;
                            e2 = egVar;
                        } else {
                            i8 = (floor3 - k) + 1;
                            a2 = (h - e) + 1;
                            this.m[i4][i5][i13][0] = new ce(i8, a2);
                            this.n[i4][i5][i13][0] = new ce(i8, a2);
                            this.k[i4][i5][i13].j[0] = (bt[][]) Array.newInstance(bt.class, new int[]{i8, a2});
                            this.k[i4][i5][i13].k[0] = i8 * a2;
                            i6 = floor3;
                            for (i7 = k; i7 <= i6; i7++) {
                                eg egVar6;
                                int i33;
                                int i34;
                                int i35;
                                int i36;
                                i8 = e;
                                while (i8 <= h) {
                                    btVar = new bt(i7 - floor2, i8 - j);
                                    if (i8 == j) {
                                        egVar6 = egVar5;
                                        btVar.b = egVar6.j;
                                    } else {
                                        egVar6 = egVar5;
                                        btVar.b = (egVar6.j + (i8 * d)) - (egVar6.h - floor);
                                    }
                                    i10 = floor2;
                                    if (i7 == i10) {
                                        btVar.c = egVar6.k;
                                        i33 = i6;
                                    } else {
                                        i33 = i6;
                                        btVar.c = (egVar6.k + (i7 * i32)) - (egVar6.i - i14);
                                    }
                                    i6 = floor + (i8 * d);
                                    if (i6 <= egVar6.h) {
                                        i6 = egVar6.h;
                                    }
                                    i19 = i8 + 1;
                                    i34 = d;
                                    d = floor + (i19 * d);
                                    i35 = h;
                                    i36 = j;
                                    if (d > egVar6.h + egVar6.l) {
                                        d = egVar6.h + egVar6.l;
                                    }
                                    btVar.d = d - i6;
                                    i6 = i14 + (i7 * i32);
                                    if (i6 <= egVar6.i) {
                                        i6 = egVar6.i;
                                    }
                                    d = i14 + ((i7 + 1) * i32);
                                    if (d > egVar6.i + egVar6.m) {
                                        d = egVar6.i + egVar6.m;
                                    }
                                    btVar.e = d - i6;
                                    this.k[i4][i5][i13].j[0][i7 - k][i8 - e] = btVar;
                                    egVar5 = egVar6;
                                    floor2 = i10;
                                    i8 = i19;
                                    i6 = i33;
                                    d = i34;
                                    h = i35;
                                    j = i36;
                                }
                                i33 = i6;
                                i34 = d;
                                i35 = h;
                                i36 = j;
                                i10 = floor2;
                                egVar6 = egVar5;
                            }
                            i8 = i5;
                            egVar = egVar3;
                        }
                    } else {
                        i24 = i10;
                        i25 = i19;
                        j = i31 * i16;
                        i6 = j + 0;
                        i7 = i6 + i16;
                        d = i30 * i15;
                        f = i14 + d;
                        h = f + i15;
                        eg egVar7 = (eg) egVar3.a(i5, 1);
                        i8 = i6 < egVar7.h ? egVar7.h : i6;
                        e = i7 > egVar7.h + egVar7.l ? egVar7.h + egVar7.l : i7;
                        if (f < egVar7.i) {
                            f = egVar7.i;
                        }
                        if (h > egVar7.i + egVar7.m) {
                            h = egVar7.i + egVar7.m;
                        }
                        a2 = egVar7.n;
                        i10 = egVar7.o;
                        int i37 = i6;
                        int i38 = i7;
                        eg egVar8 = egVar3;
                        double d7 = (double) i10;
                        i6 = (int) Math.floor(((double) (egVar7.i - i14)) / d7);
                        int i39 = d;
                        i7 = (int) Math.floor(((double) (f - i14)) / d7);
                        int i40 = i10;
                        d = (int) Math.floor(((double) ((h - 1) - i14)) / d7);
                        d5 = (double) a2;
                        int i41 = j;
                        eg egVar9 = egVar7;
                        j = (int) Math.floor(((double) (i8 + 0)) / d5);
                        int i42 = a2;
                        int floor4 = (int) Math.floor(((double) (egVar7.h - 0)) / d5);
                        k = (int) Math.floor(((double) ((e - 1) - 0)) / d5);
                        if (e - i8 <= 0 || h - f <= 0) {
                            i8 = i2;
                            this.k[i4][i8][i13].k[1] = 0;
                            this.m[i4][i8][i13][1] = new ce(0, 0);
                            this.n[i4][i8][i13][1] = new ce(0, 0);
                        } else {
                            i8 = i2;
                            f = (d - i7) + 1;
                            i5 = (k - j) + 1;
                            this.m[i4][i8][i13][1] = new ce(f, i5);
                            this.n[i4][i8][i13][1] = new ce(f, i5);
                            this.k[i4][i8][i13].j[1] = (bt[][]) Array.newInstance(bt.class, new int[]{f, i5});
                            this.k[i4][i8][i13].k[1] = f * i5;
                            for (h = i7; h <= d; h++) {
                                eg egVar10;
                                int i43;
                                int i44;
                                e = j;
                                while (e <= k) {
                                    btVar = new bt(h - i6, e - floor4);
                                    a2 = floor4;
                                    if (e == a2) {
                                        egVar10 = egVar9;
                                        btVar.b = egVar10.j;
                                    } else {
                                        egVar10 = egVar9;
                                        btVar.b = (egVar10.j + (e * i42)) - (egVar10.h - 0);
                                    }
                                    if (h == i6) {
                                        btVar.c = egVar10.k;
                                    } else {
                                        btVar.c = (egVar10.k + (h * i40)) - (egVar10.i - i14);
                                    }
                                    i9 = (e * i42) + 0;
                                    if (i9 <= egVar10.h) {
                                        i9 = egVar10.h;
                                    }
                                    i19 = e + 1;
                                    i43 = i6;
                                    i6 = 0 + (i19 * i42);
                                    i44 = d;
                                    if (i6 > egVar10.h + egVar10.l) {
                                        i6 = egVar10.h + egVar10.l;
                                    }
                                    btVar.d = i6 - i9;
                                    i6 = i14 + (h * i40);
                                    if (i6 <= egVar10.i) {
                                        i6 = egVar10.i;
                                    }
                                    d = i14 + ((h + 1) * i40);
                                    if (d > egVar10.i + egVar10.m) {
                                        d = egVar10.i + egVar10.m;
                                    }
                                    btVar.e = d - i6;
                                    this.k[i4][i8][i13].j[1][h - i7][e - j] = btVar;
                                    floor4 = a2;
                                    egVar9 = egVar10;
                                    e = i19;
                                    i6 = i43;
                                    d = i44;
                                }
                                i43 = i6;
                                i44 = d;
                                egVar10 = egVar9;
                                a2 = floor4;
                            }
                        }
                        a2 = floor + i41;
                        j = a2 + i16;
                        d = i39 + 0;
                        i7 = d + i15;
                        egVar4 = egVar8;
                        egVar7 = (eg) egVar4.a(i8, 2);
                        if (a2 < egVar7.h) {
                            a2 = egVar7.h;
                        }
                        if (j > egVar7.h + egVar7.l) {
                            j = egVar7.h + egVar7.l;
                        }
                        e = d < egVar7.i ? egVar7.i : d;
                        f = i7 > egVar7.i + egVar7.m ? egVar7.i + egVar7.m : i7;
                        i5 = egVar7.n;
                        i9 = egVar7.o;
                        int i45 = i7;
                        double d8 = (double) i9;
                        int i46 = d;
                        eg egVar11 = egVar4;
                        d = (int) Math.floor(((double) (e + 0)) / d8);
                        int i47 = i9;
                        int floor5 = (int) Math.floor(((double) (egVar7.i - 0)) / d8);
                        int floor6 = (int) Math.floor(((double) ((f - 1) - 0)) / d8);
                        d8 = (double) i5;
                        h = (int) Math.floor(((double) (egVar7.h - floor)) / d8);
                        i9 = (int) Math.floor(((double) (a2 - floor)) / d8);
                        i6 = (int) Math.floor(((double) ((j - 1) - floor)) / d8);
                        if (j - a2 <= 0 || f - e <= 0) {
                            this.k[i4][i8][i13].k[2] = 0;
                            this.m[i4][i8][i13][2] = new ce(0, 0);
                            this.n[i4][i8][i13][2] = new ce(0, 0);
                        } else {
                            e = (floor6 - d) + 1;
                            a2 = (i6 - i9) + 1;
                            this.m[i4][i8][i13][2] = new ce(e, a2);
                            this.n[i4][i8][i13][2] = new ce(e, a2);
                            this.k[i4][i8][i13].j[2] = (bt[][]) Array.newInstance(bt.class, new int[]{e, a2});
                            this.k[i4][i8][i13].k[2] = e * a2;
                            i7 = floor6;
                            for (j = d; j <= i7; j++) {
                                int i48;
                                int i49;
                                int i50;
                                e = i9;
                                while (e <= i6) {
                                    btVar = new bt(j - floor5, e - h);
                                    if (e == h) {
                                        btVar.b = egVar7.j;
                                    } else {
                                        btVar.b = (egVar7.j + (e * i5)) - (egVar7.h - floor);
                                    }
                                    a2 = floor5;
                                    if (j == a2) {
                                        btVar.c = egVar7.k;
                                    } else {
                                        btVar.c = (egVar7.k + (j * i47)) - (egVar7.i + 0);
                                    }
                                    i10 = floor + (e * i5);
                                    if (i10 <= egVar7.h) {
                                        i10 = egVar7.h;
                                    }
                                    i19 = e + 1;
                                    i48 = i6;
                                    i6 = floor + (i19 * i5);
                                    i49 = i7;
                                    i50 = h;
                                    if (i6 > egVar7.h + egVar7.l) {
                                        i6 = egVar7.h + egVar7.l;
                                    }
                                    btVar.d = i6 - i10;
                                    i6 = (j * i47) + 0;
                                    if (i6 <= egVar7.i) {
                                        i6 = egVar7.i;
                                    }
                                    h = ((j + 1) * i47) + 0;
                                    if (h > egVar7.i + egVar7.m) {
                                        h = egVar7.m + egVar7.i;
                                    }
                                    btVar.e = h - i6;
                                    this.k[i4][i8][i13].j[2][j - d][e - i9] = btVar;
                                    floor5 = a2;
                                    e = i19;
                                    i6 = i48;
                                    i7 = i49;
                                    h = i50;
                                }
                                i48 = i6;
                                i49 = i7;
                                i50 = h;
                                a2 = floor5;
                            }
                        }
                        eg egVar12 = egVar11;
                        eg egVar13 = (eg) egVar12.a(i8, 3);
                        j = i37;
                        h = j < egVar13.h ? egVar13.h : j;
                        k = i38;
                        j = k > egVar13.h + egVar13.l ? egVar13.h + egVar13.l : k;
                        e = i46;
                        k = e < egVar13.i ? egVar13.i : e;
                        f = i45;
                        if (f > egVar13.i + egVar13.m) {
                            f = egVar13.i + egVar13.m;
                        }
                        e = egVar13.n;
                        a2 = egVar13.o;
                        d5 = (double) a2;
                        egVar = egVar12;
                        i6 = (int) Math.floor(((double) (k + 0)) / d5);
                        int i51 = a2;
                        int floor7 = (int) Math.floor(((double) (egVar13.i - 0)) / d5);
                        i7 = (int) Math.floor(((double) ((f - 1) - 0)) / d5);
                        b3 = (double) e;
                        int floor8 = (int) Math.floor(((double) (egVar13.h - 0)) / b3);
                        int floor9 = (int) Math.floor(((double) (h + 0)) / b3);
                        a2 = (int) Math.floor(((double) ((j - 1) - 0)) / b3);
                        if (j - h <= 0 || f - k <= 0) {
                            this.k[i4][i8][i13].k[3] = 0;
                            this.m[i4][i8][i13][3] = new ce(0, 0);
                            this.n[i4][i8][i13][3] = new ce(0, 0);
                            j = i31 + 1;
                            i13++;
                            i5 = i8;
                            f = i14;
                            a2 = floor;
                            d = i30;
                            i8 = i23;
                            floor = i21;
                            i6 = i22;
                            i7 = i29;
                            a3 = d4;
                            b3 = d3;
                            i19 = i25;
                            h = i24;
                            e2 = egVar;
                        } else {
                            k = (i7 - i6) + 1;
                            i5 = (a2 - floor9) + 1;
                            this.m[i4][i8][i13][3] = new ce(k, i5);
                            this.n[i4][i8][i13][3] = new ce(k, i5);
                            this.k[i4][i8][i13].j[3] = (bt[][]) Array.newInstance(bt.class, new int[]{k, i5});
                            this.k[i4][i8][i13].k[3] = k * i5;
                            for (h = i6; h <= i7; h++) {
                                int i52;
                                int i53;
                                j = floor9;
                                while (j <= a2) {
                                    int i54;
                                    bt btVar2 = new bt(h - floor7, j - floor8);
                                    i5 = floor8;
                                    if (j == i5) {
                                        btVar2.b = egVar13.j;
                                    } else {
                                        btVar2.b = (egVar13.j + (j * e)) - (egVar13.h - 0);
                                    }
                                    i9 = floor7;
                                    if (h == i9) {
                                        btVar2.c = egVar13.k;
                                        i54 = 0;
                                    } else {
                                        i54 = 0;
                                        btVar2.c = (egVar13.k + (h * i51)) - (egVar13.i + 0);
                                    }
                                    i10 = i54 + (j * e);
                                    if (i10 <= egVar13.h) {
                                        i10 = egVar13.h;
                                    }
                                    i19 = j + 1;
                                    f = i54 + (i19 * e);
                                    i52 = i7;
                                    i53 = e;
                                    if (f > egVar13.h + egVar13.l) {
                                        f = egVar13.h + egVar13.l;
                                    }
                                    btVar2.d = f - i10;
                                    i7 = (h * i51) + 0;
                                    if (i7 <= egVar13.i) {
                                        i7 = egVar13.i;
                                    }
                                    f = ((h + 1) * i51) + 0;
                                    if (f > egVar13.i + egVar13.m) {
                                        f = egVar13.m + egVar13.i;
                                    }
                                    btVar2.e = f - i7;
                                    this.k[i4][i8][i13].j[3][h - i6][j - floor9] = btVar2;
                                    floor8 = i5;
                                    floor7 = i9;
                                    j = i19;
                                    i7 = i52;
                                    e = i53;
                                }
                                i52 = i7;
                                i53 = e;
                                i9 = floor7;
                                i5 = floor8;
                            }
                        }
                    }
                    j = i31 + 1;
                    i13++;
                    i5 = i8;
                    f = i14;
                    a2 = floor;
                    d = i30;
                    i8 = i23;
                    floor = i21;
                    i6 = i22;
                    i7 = i29;
                    a3 = d4;
                    b3 = d3;
                    i19 = i25;
                    h = i24;
                    e2 = egVar;
                }
                i22 = i6;
                i24 = h;
                i23 = i8;
                d4 = a3;
                i14 = f;
                i8 = i5;
                d3 = b3;
                i25 = i19;
                i21 = floor;
                floor = a2;
                d++;
                i8 = i23;
                j = i26;
                floor = i21;
                i7 = i7;
                e2 = e2;
            }
        }
    }

    public int a(int i, int i2) {
        return this.i[i][i2].a * this.i[i][i2].b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x025f A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0239 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0290 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x028a A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02ce A:{LOOP_END, Catch:{ EOFException -> 0x0405 }, LOOP:7: B:143:0x02c8->B:145:0x02ce} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0304 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e8 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0239 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x025f A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x028a A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0290 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02ce A:{LOOP_END, Catch:{ EOFException -> 0x0405 }, LOOP:7: B:143:0x02c8->B:145:0x02ce} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e8 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0304 A:{Catch:{ EOFException -> 0x0405 }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03a8 A:{Catch:{ EOFException -> 0x0405 }} */
    public boolean a(int r38, int r39, int r40, int r41, jumio.nv.nfc.bz[][][] r42, int[] r43) {
        /*
        r37 = this;
        r0 = r37;
        r1 = r38;
        r2 = r39;
        r3 = r40;
        r4 = r41;
        r7 = r0.h;
        r7 = r7.e();
        r8 = r0.h;
        r8 = r8.f();
        r9 = 1;
        if (r7 < r8) goto L_0x001a;
    L_0x0019:
        return r9;
    L_0x001a:
        r8 = r0.a;
        r8 = r8.d();
        r10 = r0.a;
        r10 = r10.e(r8, r3);
        r11 = r0.b;
        if (r11 == 0) goto L_0x0032;
    L_0x002a:
        r11 = new jumio.nv.nfc.cd;
        r12 = r0.c;
        r11.<init>(r12);
        goto L_0x0034;
    L_0x0032:
        r11 = r0.g;
    L_0x0034:
        r12 = 0;
        if (r2 != 0) goto L_0x0039;
    L_0x0037:
        r13 = 0;
        goto L_0x003a;
    L_0x0039:
        r13 = 1;
    L_0x003a:
        if (r2 != 0) goto L_0x003e;
    L_0x003c:
        r14 = 1;
        goto L_0x003f;
    L_0x003e:
        r14 = 4;
    L_0x003f:
        r15 = r13;
        r16 = 0;
    L_0x0042:
        if (r15 >= r14) goto L_0x0053;
    L_0x0044:
        r9 = r0.k;
        r9 = r9[r3];
        r9 = r9[r2];
        r9 = r9.length;
        if (r4 >= r9) goto L_0x004f;
    L_0x004d:
        r16 = 1;
    L_0x004f:
        r15 = r15 + 1;
        r9 = 1;
        goto L_0x0042;
    L_0x0053:
        if (r16 != 0) goto L_0x0056;
    L_0x0055:
        return r12;
    L_0x0056:
        r9 = r0.k;
        r9 = r9[r3];
        r9 = r9[r2];
        r9 = r9[r4];
        r11.b();
        r15 = r11.a();
        r12 = -1;
        if (r15 != 0) goto L_0x00a8;
    L_0x0068:
        r1 = r14 + 1;
        r1 = new java.util.Vector[r1];
        r0.t = r1;
    L_0x006e:
        if (r13 >= r14) goto L_0x007c;
    L_0x0070:
        r1 = r0.t;
        r2 = new java.util.Vector;
        r2.<init>();
        r1[r13] = r2;
        r13 = r13 + 1;
        goto L_0x006e;
    L_0x007c:
        r1 = r0.s;
        r2 = 1;
        r1 = r1 + r2;
        r0.s = r1;
        r1 = r0.D;
        if (r1 == 0) goto L_0x009f;
    L_0x0086:
        r1 = r0.v;
        if (r1 != r12) goto L_0x009f;
    L_0x008a:
        r1 = r0.h;
        r1 = r1.e();
        r1 = r1 - r7;
        r2 = r43[r8];
        if (r1 <= r2) goto L_0x009a;
    L_0x0095:
        r2 = 0;
        r43[r8] = r2;
        r1 = 1;
        return r1;
    L_0x009a:
        r2 = r43[r8];
        r2 = r2 - r1;
        r43[r8] = r2;
    L_0x009f:
        r1 = r0.r;
        if (r1 == 0) goto L_0x00a6;
    L_0x00a3:
        r0.a(r11);
    L_0x00a6:
        r1 = 0;
        return r1;
    L_0x00a8:
        r15 = r0.t;
        if (r15 == 0) goto L_0x00b3;
    L_0x00ac:
        r15 = r0.t;
        r15 = r15.length;
        r12 = r14 + 1;
        if (r15 >= r12) goto L_0x00b9;
    L_0x00b3:
        r12 = r14 + 1;
        r12 = new java.util.Vector[r12];
        r0.t = r12;
    L_0x00b9:
        if (r13 >= r14) goto L_0x0464;
    L_0x00bb:
        r12 = r0.t;
        r12 = r12[r13];
        if (r12 != 0) goto L_0x00cb;
    L_0x00c1:
        r12 = r0.t;
        r15 = new java.util.Vector;
        r15.<init>();
        r12[r13] = r15;
        goto L_0x00d2;
    L_0x00cb:
        r12 = r0.t;
        r12 = r12[r13];
        r12.removeAllElements();
    L_0x00d2:
        r12 = r10.a(r2, r13);
        r12 = (jumio.nv.nfc.eg) r12;
        r15 = r9.k;
        r15 = r15[r13];
        if (r15 != 0) goto L_0x00ed;
    L_0x00de:
        r21 = r7;
        r34 = r9;
        r17 = r10;
        r18 = r14;
    L_0x00e6:
        r36 = r3;
        r3 = r2;
        r2 = r36;
        goto L_0x0451;
    L_0x00ed:
        r15 = r0.m;
        r15 = r15[r3];
        r15 = r15[r2];
        r15 = r15[r4];
        r15 = r15[r13];
        r17 = r10;
        r10 = r0.n;
        r10 = r10[r3];
        r10 = r10[r2];
        r10 = r10[r4];
        r10 = r10[r13];
        r4 = r9.j;
        r4 = r4[r13];
        if (r4 != 0) goto L_0x010b;
    L_0x0109:
        r4 = 0;
        goto L_0x0110;
    L_0x010b:
        r4 = r9.j;
        r4 = r4[r13];
        r4 = r4.length;
    L_0x0110:
        r18 = r14;
        r14 = 0;
    L_0x0113:
        if (r14 >= r4) goto L_0x044b;
    L_0x0115:
        r19 = r4;
        r4 = r9.j;
        r4 = r4[r13];
        r4 = r4[r14];
        if (r4 != 0) goto L_0x0121;
    L_0x011f:
        r4 = 0;
        goto L_0x0128;
    L_0x0121:
        r4 = r9.j;
        r4 = r4[r13];
        r4 = r4[r14];
        r4 = r4.length;
    L_0x0128:
        r6 = 0;
    L_0x0129:
        if (r6 >= r4) goto L_0x0431;
    L_0x012b:
        r20 = r4;
        r4 = r9.j;
        r4 = r4[r13];
        r4 = r4[r14];
        r4 = r4[r6];
        r4 = r4.a;
        r21 = r7;
        r7 = r4.a;
        r7 = r4.b;
        r7 = r12.e;
        r7 = r7.a;
        r7 = r42[r13];
        r22 = r12;
        r12 = r4.b;
        r7 = r7[r12];
        r12 = r4.a;
        r7 = r7[r12];
        if (r7 == 0) goto L_0x016c;
    L_0x014f:
        r12 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        if (r12 != 0) goto L_0x0154;
    L_0x0153:
        goto L_0x016c;
    L_0x0154:
        r12 = r7.k;	 Catch:{ EOFException -> 0x0405 }
        r2 = r0.s;	 Catch:{ EOFException -> 0x0405 }
        r12[r1] = r2;	 Catch:{ EOFException -> 0x0405 }
        r2 = r11.a();	 Catch:{ EOFException -> 0x0405 }
        r12 = 1;
        if (r2 == r12) goto L_0x0165;
    L_0x0161:
        r31 = r9;
        goto L_0x01dc;
    L_0x0165:
        r2 = r3;
        r31 = r9;
    L_0x0168:
        r3 = r39;
        goto L_0x0231;
    L_0x016c:
        if (r7 != 0) goto L_0x01c8;
    L_0x016e:
        r2 = r42[r13];	 Catch:{ EOFException -> 0x01c4 }
        r12 = r4.b;	 Catch:{ EOFException -> 0x01c4 }
        r2 = r2[r12];	 Catch:{ EOFException -> 0x01c4 }
        r12 = r4.a;	 Catch:{ EOFException -> 0x01c4 }
        r16 = new jumio.nv.nfc.bz;	 Catch:{ EOFException -> 0x01c4 }
        r29 = r7;
        r7 = r9.j;	 Catch:{ EOFException -> 0x01c0 }
        r7 = r7[r13];	 Catch:{ EOFException -> 0x01c0 }
        r7 = r7[r14];	 Catch:{ EOFException -> 0x01c0 }
        r7 = r7[r6];	 Catch:{ EOFException -> 0x01c0 }
        r7 = r7.b;	 Catch:{ EOFException -> 0x01c0 }
        r5 = r9.j;	 Catch:{ EOFException -> 0x01c0 }
        r5 = r5[r13];	 Catch:{ EOFException -> 0x01c0 }
        r5 = r5[r14];	 Catch:{ EOFException -> 0x01c0 }
        r5 = r5[r6];	 Catch:{ EOFException -> 0x01c0 }
        r5 = r5.c;	 Catch:{ EOFException -> 0x01c0 }
        r30 = r4;
        r4 = r9.j;	 Catch:{ EOFException -> 0x01bc }
        r4 = r4[r13];	 Catch:{ EOFException -> 0x01bc }
        r4 = r4[r14];	 Catch:{ EOFException -> 0x01bc }
        r4 = r4[r6];	 Catch:{ EOFException -> 0x01bc }
        r4 = r4.d;	 Catch:{ EOFException -> 0x01bc }
        r3 = r9.j;	 Catch:{ EOFException -> 0x01bc }
        r3 = r3[r13];	 Catch:{ EOFException -> 0x01bc }
        r3 = r3[r14];	 Catch:{ EOFException -> 0x01bc }
        r3 = r3[r6];	 Catch:{ EOFException -> 0x01bc }
        r3 = r3.e;	 Catch:{ EOFException -> 0x01bc }
        r31 = r9;
        r9 = r0.o;	 Catch:{ EOFException -> 0x01bc }
        r23 = r16;
        r24 = r7;
        r25 = r5;
        r26 = r4;
        r27 = r3;
        r28 = r9;
        r23.<init>(r24, r25, r26, r27, r28);	 Catch:{ EOFException -> 0x01bc }
        r2[r12] = r16;	 Catch:{ EOFException -> 0x01bc }
        r7 = r16;
        goto L_0x01ce;
    L_0x01bc:
        r7 = r29;
        goto L_0x0403;
    L_0x01c0:
        r7 = r29;
        goto L_0x0405;
    L_0x01c4:
        r29 = r7;
        goto L_0x0405;
    L_0x01c8:
        r30 = r4;
        r29 = r7;
        r31 = r9;
    L_0x01ce:
        r2 = r7.k;	 Catch:{ EOFException -> 0x0403 }
        r3 = r0.s;	 Catch:{ EOFException -> 0x0403 }
        r2[r1] = r3;	 Catch:{ EOFException -> 0x0403 }
        r2 = r1 + 1;
        r2 = r15.a(r14, r6, r2, r11);	 Catch:{ EOFException -> 0x0403 }
        if (r2 <= r1) goto L_0x01e9;
    L_0x01dc:
        r9 = r6;
        r32 = r10;
        r35 = r15;
        r34 = r31;
        r2 = r40;
        r3 = r39;
        goto L_0x03ed;
    L_0x01e9:
        r2 = 1;
        r3 = 1;
    L_0x01eb:
        if (r2 < r3) goto L_0x01f4;
    L_0x01ed:
        r2 = r10.a(r14, r6, r3, r11);	 Catch:{ EOFException -> 0x0403 }
        r3 = r3 + 1;
        goto L_0x01eb;
    L_0x01f4:
        r3 = r3 + -2;
        r7.e = r3;	 Catch:{ EOFException -> 0x0403 }
        r2 = 0;
        r7.a(r1, r2);	 Catch:{ EOFException -> 0x0403 }
        r2 = r0.u;	 Catch:{ EOFException -> 0x0403 }
        r3 = 1;
        r2 = r2 + r3;
        r0.u = r2;	 Catch:{ EOFException -> 0x0403 }
        r2 = r0.v;	 Catch:{ EOFException -> 0x0403 }
        r3 = -1;
        if (r2 == r3) goto L_0x022b;
    L_0x0207:
        r2 = r0.w;	 Catch:{ EOFException -> 0x0403 }
        if (r2 != 0) goto L_0x022b;
    L_0x020b:
        r2 = r0.u;	 Catch:{ EOFException -> 0x0403 }
        r3 = r0.v;	 Catch:{ EOFException -> 0x0403 }
        if (r2 != r3) goto L_0x022b;
    L_0x0211:
        r2 = 1;
        r0.w = r2;	 Catch:{ EOFException -> 0x0403 }
        r0.x = r8;	 Catch:{ EOFException -> 0x0403 }
        r2 = r40;
        r0.y = r2;	 Catch:{ EOFException -> 0x0403 }
        r0.z = r13;	 Catch:{ EOFException -> 0x0403 }
        r3 = r39;
        r0.A = r3;	 Catch:{ EOFException -> 0x0403 }
        r4 = r30;
        r5 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r0.B = r5;	 Catch:{ EOFException -> 0x0405 }
        r5 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r0.C = r5;	 Catch:{ EOFException -> 0x0405 }
        goto L_0x0231;
    L_0x022b:
        r4 = r30;
        r2 = r40;
        goto L_0x0168;
    L_0x0231:
        r5 = r11.a();	 Catch:{ EOFException -> 0x0405 }
        r12 = 2;
        r9 = 1;
        if (r5 != r9) goto L_0x025f;
    L_0x0239:
        r5 = r11.a();	 Catch:{ EOFException -> 0x0405 }
        if (r5 != r9) goto L_0x025d;
    L_0x023f:
        r5 = r11.a(r12);	 Catch:{ EOFException -> 0x0405 }
        r9 = 3;
        r16 = r9 + r5;
        if (r5 != r9) goto L_0x025a;
    L_0x0248:
        r5 = 5;
        r5 = r11.a(r5);	 Catch:{ EOFException -> 0x0405 }
        r9 = r16 + r5;
        r12 = 31;
        if (r5 != r12) goto L_0x0260;
    L_0x0253:
        r5 = 7;
        r5 = r11.a(r5);	 Catch:{ EOFException -> 0x0405 }
        r9 = r9 + r5;
        goto L_0x0260;
    L_0x025a:
        r9 = r16;
        goto L_0x0260;
    L_0x025d:
        r9 = 2;
        goto L_0x0260;
    L_0x025f:
        r9 = 1;
    L_0x0260:
        r7.a(r1, r9);	 Catch:{ EOFException -> 0x0405 }
        r5 = r0.t;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r13];	 Catch:{ EOFException -> 0x0405 }
        r32 = r10;
        r12 = r31;
        r10 = r12.j;	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r13];	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r14];	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r6];	 Catch:{ EOFException -> 0x0405 }
        r5.addElement(r10);	 Catch:{ EOFException -> 0x0405 }
        r5 = r0.d;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5.j;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5.a(r8, r2);	 Catch:{ EOFException -> 0x0405 }
        r5 = (java.lang.Integer) r5;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5.intValue();	 Catch:{ EOFException -> 0x0405 }
        r10 = r5 & 4;
        r33 = r6;
        if (r10 == 0) goto L_0x0290;
    L_0x028a:
        r6 = r9;
        r34 = r12;
        r35 = r15;
        goto L_0x02c8;
    L_0x0290:
        r5 = r5 & 1;
        if (r5 == 0) goto L_0x02c3;
    L_0x0294:
        r5 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r6 = 10;
        if (r5 > r6) goto L_0x029b;
    L_0x029a:
        goto L_0x02c3;
    L_0x029b:
        r5 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5 - r9;
        r34 = r12;
        r6 = 1;
    L_0x02a1:
        r12 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r35 = r15;
        r15 = 1;
        r12 = r12 - r15;
        if (r5 >= r12) goto L_0x02c8;
    L_0x02a9:
        r12 = 9;
        if (r5 < r12) goto L_0x02bd;
    L_0x02ad:
        r12 = r5 + 2;
        r16 = 3;
        r12 = r12 % 3;
        if (r12 == r15) goto L_0x02b9;
    L_0x02b5:
        r15 = 2;
        if (r12 != r15) goto L_0x02be;
    L_0x02b8:
        goto L_0x02ba;
    L_0x02b9:
        r15 = 2;
    L_0x02ba:
        r6 = r6 + 1;
        goto L_0x02be;
    L_0x02bd:
        r15 = 2;
    L_0x02be:
        r5 = r5 + 1;
        r15 = r35;
        goto L_0x02a1;
    L_0x02c3:
        r34 = r12;
        r35 = r15;
        r6 = 1;
    L_0x02c8:
        r5 = r11.a();	 Catch:{ EOFException -> 0x0405 }
        if (r5 == 0) goto L_0x02e5;
    L_0x02ce:
        r5 = r0.l;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r2];	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r3];	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r13];	 Catch:{ EOFException -> 0x0405 }
        r12 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r12];	 Catch:{ EOFException -> 0x0405 }
        r12 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r15 = r5[r12];	 Catch:{ EOFException -> 0x0405 }
        r16 = 1;
        r15 = r15 + 1;
        r5[r12] = r15;	 Catch:{ EOFException -> 0x0405 }
        goto L_0x02c8;
    L_0x02e5:
        r5 = 1;
        if (r6 != r5) goto L_0x0304;
    L_0x02e8:
        r5 = r0.l;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r2];	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r3];	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r13];	 Catch:{ EOFException -> 0x0405 }
        r6 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r6];	 Catch:{ EOFException -> 0x0405 }
        r6 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5[r6];	 Catch:{ EOFException -> 0x0405 }
        r6 = jumio.nv.nfc.ds.a(r9);	 Catch:{ EOFException -> 0x0405 }
        r5 = r5 + r6;
        r5 = r11.a(r5);	 Catch:{ EOFException -> 0x0405 }
        r9 = r5;
        goto L_0x03a0;
    L_0x0304:
        r5 = r7.j;	 Catch:{ EOFException -> 0x0405 }
        r6 = new int[r6];	 Catch:{ EOFException -> 0x0405 }
        r5[r1] = r6;	 Catch:{ EOFException -> 0x0405 }
        if (r10 == 0) goto L_0x0335;
    L_0x030c:
        r5 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5 - r9;
        r6 = 0;
        r9 = 0;
    L_0x0311:
        r10 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        if (r5 >= r10) goto L_0x03a0;
    L_0x0315:
        r10 = r0.l;	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r2];	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r3];	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r13];	 Catch:{ EOFException -> 0x0405 }
        r12 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r12];	 Catch:{ EOFException -> 0x0405 }
        r12 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r10 = r10[r12];	 Catch:{ EOFException -> 0x0405 }
        r10 = r11.a(r10);	 Catch:{ EOFException -> 0x0405 }
        r12 = r7.j;	 Catch:{ EOFException -> 0x0405 }
        r12 = r12[r1];	 Catch:{ EOFException -> 0x0405 }
        r12[r6] = r10;	 Catch:{ EOFException -> 0x0405 }
        r9 = r9 + r10;
        r5 = r5 + 1;
        r6 = r6 + 1;
        goto L_0x0311;
    L_0x0335:
        r5 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5 - r9;
        r6 = 1;
        r5 = r5 - r6;
        r10 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r10 = r10 - r9;
        r9 = 0;
        r12 = 0;
    L_0x033f:
        r15 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r15 = r15 - r6;
        if (r10 >= r15) goto L_0x037d;
    L_0x0344:
        r6 = 9;
        if (r10 < r6) goto L_0x0377;
    L_0x0348:
        r15 = r10 + 2;
        r16 = 3;
        r15 = r15 % 3;
        if (r15 != 0) goto L_0x0351;
    L_0x0350:
        goto L_0x0379;
    L_0x0351:
        r15 = r0.l;	 Catch:{ EOFException -> 0x0405 }
        r15 = r15[r2];	 Catch:{ EOFException -> 0x0405 }
        r15 = r15[r3];	 Catch:{ EOFException -> 0x0405 }
        r15 = r15[r13];	 Catch:{ EOFException -> 0x0405 }
        r6 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r6 = r15[r6];	 Catch:{ EOFException -> 0x0405 }
        r15 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r15];	 Catch:{ EOFException -> 0x0405 }
        r5 = r10 - r5;
        r5 = jumio.nv.nfc.ds.a(r5);	 Catch:{ EOFException -> 0x0405 }
        r6 = r6 + r5;
        r5 = r11.a(r6);	 Catch:{ EOFException -> 0x0405 }
        r6 = r7.j;	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r1];	 Catch:{ EOFException -> 0x0405 }
        r6[r12] = r5;	 Catch:{ EOFException -> 0x0405 }
        r9 = r9 + r5;
        r12 = r12 + 1;
        r5 = r10;
        goto L_0x0379;
    L_0x0377:
        r16 = 3;
    L_0x0379:
        r10 = r10 + 1;
        r6 = 1;
        goto L_0x033f;
    L_0x037d:
        r6 = r0.l;	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r2];	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r3];	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r13];	 Catch:{ EOFException -> 0x0405 }
        r15 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r15];	 Catch:{ EOFException -> 0x0405 }
        r15 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r6 = r6[r15];	 Catch:{ EOFException -> 0x0405 }
        r10 = r10 - r5;
        r5 = jumio.nv.nfc.ds.a(r10);	 Catch:{ EOFException -> 0x0405 }
        r6 = r6 + r5;
        r5 = r11.a(r6);	 Catch:{ EOFException -> 0x0405 }
        r6 = r9 + r5;
        r9 = r7.j;	 Catch:{ EOFException -> 0x0405 }
        r9 = r9[r1];	 Catch:{ EOFException -> 0x0405 }
        r9[r12] = r5;	 Catch:{ EOFException -> 0x0405 }
        r9 = r6;
    L_0x03a0:
        r5 = r7.f;	 Catch:{ EOFException -> 0x0405 }
        r5[r1] = r9;	 Catch:{ EOFException -> 0x0405 }
        r5 = r0.D;	 Catch:{ EOFException -> 0x0405 }
        if (r5 == 0) goto L_0x03eb;
    L_0x03a8:
        r5 = r0.v;	 Catch:{ EOFException -> 0x0405 }
        r6 = -1;
        if (r5 != r6) goto L_0x03eb;
    L_0x03ad:
        r5 = r0.h;	 Catch:{ EOFException -> 0x0405 }
        r5 = r5.e();	 Catch:{ EOFException -> 0x0405 }
        r5 = r5 - r21;
        r9 = r33;
        r10 = r43[r8];	 Catch:{ EOFException -> 0x0405 }
        if (r5 <= r10) goto L_0x03ed;
    L_0x03bb:
        r5 = 0;
        r43[r8] = r5;	 Catch:{ EOFException -> 0x0405 }
        if (r1 != 0) goto L_0x03cd;
    L_0x03c0:
        r2 = r42[r13];	 Catch:{ EOFException -> 0x0405 }
        r3 = r4.b;	 Catch:{ EOFException -> 0x0405 }
        r2 = r2[r3];	 Catch:{ EOFException -> 0x0405 }
        r3 = r4.a;	 Catch:{ EOFException -> 0x0405 }
        r6 = 0;
        r2[r3] = r6;	 Catch:{ EOFException -> 0x0405 }
    L_0x03cb:
        r1 = 1;
        goto L_0x03ea;
    L_0x03cd:
        r2 = r7.g;	 Catch:{ EOFException -> 0x0405 }
        r3 = r7.f;	 Catch:{ EOFException -> 0x0405 }
        r6 = 0;
        r3[r1] = r6;	 Catch:{ EOFException -> 0x0405 }
        r2[r1] = r6;	 Catch:{ EOFException -> 0x0405 }
        r2 = r7.i;	 Catch:{ EOFException -> 0x0405 }
        r3 = r7.h;	 Catch:{ EOFException -> 0x0405 }
        r3 = r3[r1];	 Catch:{ EOFException -> 0x0405 }
        r2 = r2 - r3;
        r7.i = r2;	 Catch:{ EOFException -> 0x0405 }
        r2 = r7.h;	 Catch:{ EOFException -> 0x0405 }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ EOFException -> 0x0405 }
        r2 = r7.k;	 Catch:{ EOFException -> 0x0405 }
        r3 = -1;
        r2[r1] = r3;	 Catch:{ EOFException -> 0x0405 }
        goto L_0x03cb;
    L_0x03ea:
        return r1;
    L_0x03eb:
        r9 = r33;
    L_0x03ed:
        r4 = r9 + 1;
        r6 = r4;
        r4 = r20;
        r7 = r21;
        r12 = r22;
        r10 = r32;
        r9 = r34;
        r15 = r35;
        r36 = r3;
        r3 = r2;
        r2 = r36;
        goto L_0x0129;
    L_0x0403:
        r4 = r30;
    L_0x0405:
        if (r1 != 0) goto L_0x0414;
    L_0x0407:
        r1 = r42[r13];
        r2 = r4.b;
        r1 = r1[r2];
        r2 = r4.a;
        r3 = 0;
        r1[r2] = r3;
    L_0x0412:
        r1 = 1;
        goto L_0x0430;
    L_0x0414:
        r2 = r7.g;
        r3 = r7.f;
        r4 = 0;
        r3[r1] = r4;
        r2[r1] = r4;
        r2 = r7.i;
        r3 = r7.h;
        r3 = r3[r1];
        r2 = r2 - r3;
        r7.i = r2;
        r2 = r7.h;
        r2[r1] = r4;
        r2 = r7.k;
        r3 = -1;
        r2[r1] = r3;
        goto L_0x0412;
    L_0x0430:
        return r1;
    L_0x0431:
        r21 = r7;
        r34 = r9;
        r32 = r10;
        r22 = r12;
        r35 = r15;
        r36 = r3;
        r3 = r2;
        r2 = r36;
        r14 = r14 + 1;
        r4 = r19;
        r36 = r3;
        r3 = r2;
        r2 = r36;
        goto L_0x0113;
    L_0x044b:
        r21 = r7;
        r34 = r9;
        goto L_0x00e6;
    L_0x0451:
        r13 = r13 + 1;
        r10 = r17;
        r14 = r18;
        r7 = r21;
        r9 = r34;
        r4 = r41;
        r36 = r3;
        r3 = r2;
        r2 = r36;
        goto L_0x00b9;
    L_0x0464:
        r21 = r7;
        r1 = r0.r;
        if (r1 == 0) goto L_0x046d;
    L_0x046a:
        r0.a(r11);
    L_0x046d:
        r1 = r0.s;
        r2 = 1;
        r1 = r1 + r2;
        r0.s = r1;
        r1 = r0.D;
        if (r1 == 0) goto L_0x0494;
    L_0x0477:
        r1 = r0.v;
        r2 = -1;
        if (r1 != r2) goto L_0x0494;
    L_0x047c:
        r1 = r0.h;
        r1 = r1.e();
        r1 = r1 - r21;
        r2 = r43[r8];
        if (r1 <= r2) goto L_0x048d;
    L_0x0488:
        r2 = 0;
        r43[r8] = r2;
        r1 = 1;
        return r1;
    L_0x048d:
        r2 = 0;
        r3 = r43[r8];
        r3 = r3 - r1;
        r43[r8] = r3;
        goto L_0x0495;
    L_0x0494:
        r2 = 0;
    L_0x0495:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.cc.a(int, int, int, int, jumio.nv.nfc.bz[][][], int[]):boolean");
    }

    public boolean b(int i, int i2, int i3, int i4, bz[][][] bzVarArr, int[] iArr) {
        int i5;
        int i6 = i2;
        int i7 = i3;
        int e = this.h.e();
        int d = this.a.d();
        int i8 = i6 == 0 ? 0 : 1;
        int i9 = i6 == 0 ? 1 : 4;
        Object obj = null;
        for (i5 = i8; i5 < i9; i5++) {
            if (i4 < this.k[i7][i6].length) {
                obj = 1;
            }
        }
        if (obj == null) {
            return false;
        }
        Object obj2 = null;
        while (i8 < i9) {
            obj = obj2;
            i5 = e;
            while (0 < this.t[i8].size()) {
                cu cuVar = ((bt) this.t[i8].elementAt(0)).a;
                bz bzVar = bzVarArr[i8][cuVar.b][cuVar.a];
                bzVar.g[i] = i5;
                i5 += bzVar.f[i];
                try {
                    this.h.a(i5);
                    if (this.D) {
                        if (obj != null || bzVar.f[i] > iArr[d]) {
                            if (i == 0) {
                                bzVarArr[i8][cuVar.b][cuVar.a] = null;
                            } else {
                                int[] iArr2 = bzVar.g;
                                bzVar.f[i] = 0;
                                iArr2[i] = 0;
                                bzVar.i -= bzVar.h[i];
                                bzVar.h[i] = 0;
                                bzVar.k[i] = -1;
                            }
                            obj = 1;
                        }
                        if (obj == null) {
                            iArr[d] = iArr[d] - bzVar.f[i];
                        }
                    }
                    Object obj3 = obj;
                    if (this.w && i6 == this.A && i8 == this.z && cuVar.a == this.B && cuVar.b == this.C && d == this.x && i7 == this.y) {
                        bzVarArr[i8][cuVar.b][cuVar.a] = null;
                        obj = 1;
                    } else {
                        obj = obj3;
                    }
                    e = 0 + 1;
                } catch (EOFException unused) {
                    if (i == 0) {
                        bzVarArr[i8][cuVar.b][cuVar.a] = null;
                    } else {
                        int[] iArr3 = bzVar.g;
                        bzVar.f[i] = 0;
                        iArr3[i] = 0;
                        bzVar.i -= bzVar.h[i];
                        bzVar.h[i] = 0;
                        bzVar.k[i] = -1;
                    }
                    throw new EOFException();
                }
            }
            i8++;
            e = i5;
            obj2 = obj;
        }
        this.h.a(e);
        return obj2 != null;
    }

    public final int a(int i, int i2, int i3) {
        return this.d.n.a(i, i2, i3);
    }

    public final int b(int i, int i2, int i3) {
        return this.d.n.b(i, i2, i3);
    }

    public boolean a(int[] iArr, int i, int i2, int i3) {
        byte[] bArr = new byte[6];
        int d = this.a.d();
        int i4 = i3 == 0 ? 1 : 4;
        Object obj = null;
        for (int i5 = i3 == 0 ? 0 : 1; i5 < i4; i5++) {
            if (i < this.k[i2][i3].length) {
                obj = 1;
            }
        }
        if (obj == null || !this.q) {
            return false;
        }
        i = this.h.e();
        if (((short) ((this.h.g() << 8) | this.h.g())) != (short) -111) {
            this.h.a(i);
            return false;
        }
        this.h.a(i);
        if (iArr[d] < 6) {
            return true;
        }
        iArr[d] = iArr[d] - 6;
        this.h.a(bArr, 0, 6);
        if (((bArr[0] << 8) | bArr[1]) != -111) {
            throw new Error("Corrupted Bitstream: Could not parse SOP marker !");
        } else if ((((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 4) {
            throw new Error("Corrupted Bitstream: Corrupted SOP marker !");
        } else {
            int i6 = ((bArr[4] & 255) << 8) | (bArr[5] & 255);
            if (!this.b && i6 != this.s) {
                throw new Error("Corrupted Bitstream: SOP marker out of sequence !");
            } else if (!this.b || i6 == this.s - 1) {
                return false;
            } else {
                throw new Error("Corrupted Bitstream: SOP marker out of sequence !");
            }
        }
    }

    public void a(cd cdVar) {
        byte[] bArr = new byte[2];
        if (cdVar.c) {
            cdVar.b.read(bArr, 0, 2);
        } else {
            cdVar.a.a(bArr, 0, 2);
        }
        if (((bArr[0] << 8) | bArr[1]) != -110) {
            throw new Error("Corrupted Bitstream: Could not parse EPH marker ! ");
        }
    }

    public bx c(int i, int i2, int i3) {
        return this.k[i][i2][i3];
    }
}
