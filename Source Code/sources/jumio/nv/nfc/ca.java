package jumio.nv.nfc;

import com.iqoption.dto.ToastEntity;
import java.io.EOFException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import jumio.nv.nfc.bw.j;

/* compiled from: FileBitstreamReaderAgent */
public class ca extends by {
    public cc D;
    private boolean E = true;
    private dt F;
    private df G;
    private int[][] H;
    private int[] I;
    private int[] J;
    private int[][] K;
    private int[] L;
    private int[] M;
    private int N;
    private double O;
    private int P;
    private int Q = 0;
    private int[][] R;
    private Vector S;
    private boolean T;
    private int U;
    private int[] V;
    private int W = 0;
    private int[] X;
    private int Y;
    private int[][] Z;
    private boolean aa = false;
    private bw ab;
    private bz[][][][][] ac;
    private int ad;
    private boolean ae = false;

    public ca(cb cbVar, df dfVar, cg cgVar, dt dtVar, boolean z, bw bwVar) {
        StringBuilder stringBuilder;
        EOFException eOFException;
        cb cbVar2 = cbVar;
        cg cgVar2 = cgVar;
        dt dtVar2 = dtVar;
        super(cbVar2, cgVar2);
        this.F = dtVar2;
        this.ab = bwVar;
        this.ae = dtVar2.b("poc_quit");
        dtVar2.b("parsing");
        try {
            this.C = dtVar2.d("rate");
            if (this.C == -1.0f) {
                this.C = Float.MAX_VALUE;
            }
            try {
                this.A = dtVar2.c("nbytes");
                if ((((float) this.A) != dtVar.a().d("nbytes") ? 1 : null) != null) {
                    this.C = ((((float) this.A) * 8.0f) / ((float) cbVar.b())) / ((float) cbVar.a());
                } else {
                    this.A = ((int) ((this.C * ((float) cbVar.b())) * ((float) cbVar.a()))) / 8;
                }
                this.T = dtVar2.b("parsing") ^ true;
                try {
                    int c = dtVar2.c("ncb_quit");
                    if (c == -1 || this.T) {
                        try {
                            this.ad = dtVar2.c("l_quit");
                            df dfVar2 = dfVar;
                            this.G = dfVar2;
                            cc ccVar = r1;
                            int i = -1;
                            cc ccVar2 = new cc(cgVar2, cbVar2, dfVar2, this, this.T, c);
                            this.D = ccVar;
                            this.X = new int[this.w];
                            this.L = new int[this.w];
                            this.K = new int[this.w][];
                            this.Z = new int[this.w][];
                            this.H = new int[this.w][];
                            this.V = new int[this.w];
                            this.M = new int[this.w];
                            this.R = new int[this.w][];
                            this.I = new int[this.w];
                            this.J = new int[this.w];
                            cbVar2.a = new int[this.w];
                            int i2 = cbVar2.c;
                            this.P = this.G.e() - i2;
                            this.Q = this.P;
                            if (c == -1) {
                                this.B = this.P;
                            } else {
                                this.B = 0;
                            }
                            if (this.B > this.A) {
                                throw new Error("Requested bitrate is too small.");
                            }
                            Object obj;
                            this.O = 0.0d;
                            this.U = this.w;
                            int i3 = this.w;
                            i3 = 0;
                            int i4 = 0;
                            while (this.U != 0) {
                                int e = this.G.e();
                                int m;
                                try {
                                    m = m();
                                    try {
                                        if (this.aa) {
                                            break;
                                        }
                                        i3 = this.V[m];
                                        try {
                                            if (this.E) {
                                                this.K[m][i3] = (this.G.f() - 2) - e;
                                            }
                                            try {
                                                i4 = this.G.e();
                                                if (this.T && c == i && i4 - i2 > this.A) {
                                                    this.H[m][i3] = this.G.f();
                                                } else {
                                                    this.H[m][i3] = i4;
                                                    this.R[m][i3] = i4 - e;
                                                    int[] iArr = this.L;
                                                    iArr[m] = iArr[m] + this.K[m][i3];
                                                    iArr = this.M;
                                                    iArr[m] = iArr[m] + this.R[m][i3];
                                                    int i5 = c;
                                                    this.O += (double) this.K[m][i3];
                                                    if (this.T) {
                                                        if (this.B + this.K[m][i3] > this.A) {
                                                            this.B += this.R[m][i3];
                                                            this.Q += this.R[m][i3];
                                                            int[] iArr2 = this.I;
                                                            iArr2[m] = iArr2[m] + (this.A - this.B);
                                                        } else {
                                                            this.B += this.R[m][i3];
                                                            this.Q += this.R[m][i3];
                                                            iArr = this.I;
                                                            iArr[m] = iArr[m] + (this.K[m][i3] - this.R[m][i3]);
                                                        }
                                                    } else if (this.B + this.R[m][i3] > this.A) {
                                                        break;
                                                    } else {
                                                        this.B += this.R[m][i3];
                                                        this.Q += this.R[m][i3];
                                                    }
                                                    if (null == null) {
                                                        this.N = this.R[m][i3];
                                                    }
                                                    iArr = this.V;
                                                    iArr[m] = iArr[m] + 1;
                                                    this.G.a(e + this.K[m][i3]);
                                                    this.U--;
                                                    int i6 = 0 + 1;
                                                    if (this.E) {
                                                        break;
                                                    }
                                                    i4 = i3;
                                                    i3 = m;
                                                    c = i5;
                                                    i = -1;
                                                }
                                                obj = 1;
                                                break;
                                            } catch (EOFException unused) {
                                                i2 = 0;
                                                i3 = this.G.f();
                                                if (i3 < this.A) {
                                                    this.A = i3;
                                                    this.C = ((((float) this.A) * 8.0f) / ((float) cbVar.b())) / ((float) cbVar.a());
                                                }
                                                if (!this.T) {
                                                    l();
                                                }
                                                if (dtVar2.a("res") == null) {
                                                    this.g = cgVar2.g.a();
                                                } else {
                                                    this.g = dtVar2.c("res");
                                                    if (this.g < 0) {
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append("Specified negative resolution level index: ");
                                                        stringBuilder.append(this.g);
                                                        throw new IllegalArgumentException(stringBuilder.toString());
                                                    }
                                                }
                                                i3 = cgVar2.g.a();
                                                if (this.g > i3) {
                                                    this.g = i3;
                                                }
                                                while (i2 < this.w) {
                                                    this.J[i2] = this.I[i2];
                                                    i2++;
                                                }
                                                return;
                                            } catch (NumberFormatException unused2) {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append("Invalid resolution level index ('-res' option) ");
                                                stringBuilder.append(dtVar2.a("res"));
                                                throw new IllegalArgumentException(stringBuilder.toString());
                                            }
                                        } catch (EOFException e2) {
                                            eOFException = e2;
                                            this.H[m][i3] = this.G.f();
                                            throw eOFException;
                                        }
                                    } catch (EOFException e22) {
                                        eOFException = e22;
                                        i3 = i4;
                                        this.H[m][i3] = this.G.f();
                                        throw eOFException;
                                    }
                                } catch (EOFException e222) {
                                    eOFException = e222;
                                    m = i3;
                                }
                            }
                            obj = null;
                            i2 = 0;
                            this.U = 0;
                            if (dtVar2.a("res") == null) {
                                this.g = cgVar2.g.a();
                            } else {
                                try {
                                    this.g = dtVar2.c("res");
                                    if (this.g < 0) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("Specified negative resolution level index: ");
                                        stringBuilder.append(this.g);
                                        throw new IllegalArgumentException(stringBuilder.toString());
                                    }
                                } catch (NumberFormatException unused3) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid resolution level index ('-res' option) ");
                                    stringBuilder.append(dtVar2.a("res"));
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                }
                            }
                            i3 = cgVar2.g.a();
                            if (this.g > i3) {
                                this.g = i3;
                            }
                            if (!(this.aa || this.E || obj != null)) {
                                try {
                                    if (!this.E) {
                                        this.G.a();
                                    }
                                } catch (EOFException unused4) {
                                    if (!this.T) {
                                        l();
                                    } else if (this.G.e() >= this.A) {
                                        this.B += 2;
                                    }
                                    while (i2 < this.w) {
                                        this.J[i2] = this.I[i2];
                                        i2++;
                                    }
                                    return;
                                }
                            }
                        } catch (NumberFormatException unused5) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid value in 'l_quit' option: ");
                            stringBuilder.append(dtVar2.a("l_quit"));
                            throw new Error(stringBuilder.toString());
                        } catch (IllegalArgumentException unused6) {
                            throw new Error("'l_quit' option is missing");
                        }
                    }
                    throw new Error("Cannot use -parsing and -ncb_quit condition at the same time.");
                } catch (NumberFormatException unused7) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid value in 'ncb_quit' option: ");
                    stringBuilder.append(dtVar2.a("ncb_quit"));
                    throw new Error(stringBuilder.toString());
                } catch (IllegalArgumentException unused8) {
                    throw new Error("'ncb_quit' option is missing");
                }
            } catch (NumberFormatException unused9) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid value in 'nbytes' option: ");
                stringBuilder.append(dtVar2.a("nbytes"));
                throw new Error(stringBuilder.toString());
            } catch (IllegalArgumentException unused10) {
                throw new Error("'nbytes' option is missing");
            }
        } catch (NumberFormatException unused11) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value in 'rate' option: ");
            stringBuilder.append(dtVar2.a("rate"));
            throw new Error(stringBuilder.toString());
        } catch (IllegalArgumentException unused12) {
            throw new Error("'rate' option is missing");
        }
    }

    private void l() {
        int i = this.A;
        this.B += 2;
        if (this.B > i) {
            throw new Error("Requested bitrate is too small for parsing");
        }
        i -= this.B;
        int i2 = i;
        for (int i3 = this.w - 1; i3 > 0; i3--) {
            int i4 = (int) (((double) i) * (((double) this.L[i3]) / this.O));
            this.I[i3] = i4;
            i2 -= i4;
        }
        this.I[0] = i2;
    }

    private int m() {
        j b = this.ab.b();
        short a = this.G.a();
        if (a == (short) -112) {
            int i = 0;
            this.aa = false;
            int b2 = this.G.b();
            b.a = b2;
            StringBuilder stringBuilder;
            if (b2 != 10) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Wrong length for SOT marker segment: ");
                stringBuilder.append(b2);
                throw new bv(stringBuilder.toString());
            }
            b2 = this.G.b();
            b.b = b2;
            if (b2 > 65534) {
                throw new bv("Tile index too high in tile-part.");
            }
            int c = this.G.c();
            b.c = c;
            this.E = c == 0;
            if (c < 0) {
                throw new bs("Tile length larger than maximum supported");
            }
            int g = this.G.g();
            b.d = g;
            if (g != this.V[b2] || g < 0 || g > 254) {
                throw new bv("Out of order tile-part");
            }
            int i2;
            int g2 = this.G.g();
            b.e = g2;
            Hashtable hashtable = this.ab.b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("t");
            stringBuilder2.append(b2);
            stringBuilder2.append("_tp");
            stringBuilder2.append(g);
            hashtable.put(stringBuilder2.toString(), b);
            int[] iArr;
            int i3;
            if (g2 == 0) {
                int i4;
                if (this.X[b2] == 0 || this.X[b2] == this.K.length) {
                    i2 = 2;
                    this.U++;
                } else {
                    i2 = 1;
                }
                int[] iArr2 = this.X;
                iArr2[b2] = iArr2[b2] + i2;
                g2 = this.X[b2];
                int[] iArr3 = this.K[b2];
                this.K[b2] = new int[g2];
                int i5 = 0;
                while (true) {
                    i4 = g2 - i2;
                    if (i5 >= i4) {
                        break;
                    }
                    this.K[b2][i5] = iArr3[i5];
                    i5++;
                }
                iArr = this.Z[b2];
                this.Z[b2] = new int[g2];
                for (i3 = 0; i3 < i4; i3++) {
                    this.Z[b2][i3] = iArr[i3];
                }
                iArr = this.H[b2];
                this.H[b2] = new int[g2];
                for (i3 = 0; i3 < i4; i3++) {
                    this.H[b2][i3] = iArr[i3];
                }
                iArr = this.R[b2];
                this.R[b2] = new int[g2];
                while (i < i4) {
                    this.R[b2][i] = iArr[i];
                    i++;
                }
            } else if (this.X[b2] == 0) {
                this.U += g2 - 1;
                this.X[b2] = g2;
                this.K[b2] = new int[g2];
                this.Z[b2] = new int[g2];
                this.H[b2] = new int[g2];
                this.R[b2] = new int[g2];
            } else if (this.X[b2] > g2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid number of tile-parts in tile ");
                stringBuilder.append(b2);
                stringBuilder.append(": ");
                stringBuilder.append(g2);
                throw new bv(stringBuilder.toString());
            } else {
                this.U += g2 - this.X[b2];
                if (this.X[b2] != g2) {
                    iArr = this.K[b2];
                    this.K[b2] = new int[g2];
                    for (i3 = 0; i3 < this.X[b2] - 1; i3++) {
                        this.K[b2][i3] = iArr[i3];
                    }
                    iArr = this.Z[b2];
                    this.Z[b2] = new int[g2];
                    for (i3 = 0; i3 < this.X[b2] - 1; i3++) {
                        this.Z[b2][i3] = iArr[i3];
                    }
                    iArr = this.H[b2];
                    this.H[b2] = new int[g2];
                    for (i3 = 0; i3 < this.X[b2] - 1; i3++) {
                        this.H[b2][i3] = iArr[i3];
                    }
                    iArr = this.R[b2];
                    this.R[b2] = new int[g2];
                    while (i < this.X[b2] - 1) {
                        this.R[b2][i] = iArr[i];
                        i++;
                    }
                }
            }
            this.z.n();
            this.z.a[b2] = g2;
            do {
                this.z.a(this.G.a(), this.G, b2, g);
                i2 = this.z.p();
                cb cbVar = this.z;
            } while ((i2 & 8192) == 0);
            this.z.a(b2, g);
            this.K[b2][g] = c;
            this.Z[b2][g] = this.W;
            this.W++;
            this.z.e(b2);
            return b2;
        } else if (a == (short) -39) {
            this.aa = true;
            return -1;
        } else {
            throw new bv("SOT tag not found in tile-part start");
        }
    }

    private boolean a(int[][] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i3;
        int i8 = i5;
        int i9 = i4;
        int i10 = ToastEntity.ALERT_TOAST_DURATION;
        while (i9 < i8) {
            if (i9 < this.e.length) {
                i6 = i10;
                i10 = i2;
                while (i10 < i7) {
                    if (iArr[i9] != null && i10 < iArr[i9].length && iArr[i9][i10] < i6) {
                        i6 = iArr[i9][i10];
                    }
                    i10++;
                }
                i10 = i6;
            }
            i9++;
        }
        i9 = d();
        i6 = ((this.H[i9][this.Y] + this.K[i9][this.Y]) - 1) - this.R[i9][this.Y];
        int intValue = ((Integer) this.a.h.d(i9)).intValue();
        boolean booleanValue = ((Boolean) this.a.r.d(i9)).booleanValue();
        while (i10 < i) {
            int i11;
            int i12 = i6;
            i6 = i2;
            while (i6 < i7) {
                int i13;
                int i14 = i4;
                while (i14 < i8) {
                    if (i14 < this.e.length && i6 < iArr[i14].length && i6 <= this.e[i14] && i10 >= iArr[i14][i6] && i10 < intValue) {
                        int a = this.D.a(i14, i6);
                        int i15 = i12;
                        int i16 = 0;
                        while (i16 < a) {
                            int i17;
                            int i18;
                            int i19;
                            i12 = this.G.e();
                            if (booleanValue) {
                                cc ccVar = this.D;
                                i8 = i12;
                                cc ccVar2 = ccVar;
                                i17 = i15;
                                i18 = i16;
                                i19 = a;
                                i11 = intValue;
                                intValue = i14;
                                ccVar2.a(i10, i6, i14, i18, this.ac[i14][i6], this.I);
                            } else {
                                i11 = intValue;
                                i8 = i12;
                                i17 = i15;
                                i18 = i16;
                                i19 = a;
                                intValue = i14;
                            }
                            if (i8 > i17 && this.Y < this.H[i9].length - 1) {
                                this.Y++;
                                this.G.a(this.H[i9][this.Y]);
                                i17 = ((this.G.e() + this.K[i9][this.Y]) - 1) - this.R[i9][this.Y];
                            }
                            i13 = i18;
                            boolean a2 = this.D.a(this.I, i13, intValue, i6);
                            if (a2) {
                                return true;
                            }
                            if (booleanValue) {
                                i18 = i13;
                            } else {
                                i18 = i13;
                                a2 = this.D.a(i10, i6, intValue, i13, this.ac[intValue][i6], this.I);
                            }
                            if (a2) {
                                return true;
                            }
                            this.S.addElement(new Integer(this.G.e() - i8));
                            a2 = this.D.b(i10, i6, intValue, i18, this.ac[intValue][i6], this.I);
                            this.G.e();
                            if (a2) {
                                return true;
                            }
                            i16 = i18 + 1;
                            i13 = i;
                            i15 = i17;
                            i14 = intValue;
                            a = i19;
                            intValue = i11;
                            i7 = i3;
                            i8 = i5;
                        }
                        i11 = intValue;
                        intValue = i14;
                        i12 = i15;
                    } else {
                        i11 = intValue;
                        intValue = i14;
                    }
                    i14 = intValue + 1;
                    i13 = i;
                    intValue = i11;
                    i7 = i3;
                    i8 = i5;
                }
                i11 = intValue;
                i6++;
                i13 = i;
                i7 = i3;
                i8 = i5;
            }
            i11 = intValue;
            i10++;
            i6 = i12;
            i7 = i3;
            i8 = i5;
        }
        return false;
    }

    private boolean b(int[][] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i3;
        int i7 = i5;
        int d = d();
        int i8 = ((this.H[d][this.Y] + this.K[d][this.Y]) - 1) - this.R[d][this.Y];
        int i9 = i4;
        int i10 = ToastEntity.ALERT_TOAST_DURATION;
        while (i9 < i7) {
            if (i9 < this.e.length) {
                int i11 = i10;
                i10 = i2;
                while (i10 < i6) {
                    if (i10 <= this.e[i9] && iArr[i9] != null && i10 < iArr[i9].length && iArr[i9][i10] < i11) {
                        i11 = iArr[i9][i10];
                    }
                    i10++;
                }
                i10 = i11;
            }
            i9++;
        }
        i9 = ((Integer) this.a.h.d(d)).intValue();
        boolean booleanValue = ((Boolean) this.a.r.d(d)).booleanValue();
        int i12 = i8;
        i8 = i2;
        while (i8 < i6) {
            int i13;
            int i14 = i;
            int i15 = i10;
            while (i15 < i14) {
                int i16 = i4;
                while (i16 < i7) {
                    if (i16 < this.e.length && i8 <= this.e[i16] && i8 < iArr[i16].length && i15 >= iArr[i16][i8] && i15 < i9) {
                        int a = this.D.a(i16, i8);
                        int i17 = 0;
                        while (i17 < a) {
                            int i18;
                            int i19;
                            int i20;
                            int i21;
                            int e = this.G.e();
                            if (booleanValue) {
                                cc ccVar = this.D;
                                i13 = i9;
                                i9 = i12;
                                cc ccVar2 = ccVar;
                                i18 = i17;
                                i19 = a;
                                i20 = i16;
                                i21 = i15;
                                ccVar2.a(i15, i8, i16, i18, this.ac[i16][i8], this.I);
                            } else {
                                i13 = i9;
                                i9 = i12;
                                i18 = i17;
                                i19 = a;
                                i20 = i16;
                                i21 = i15;
                            }
                            if (e > i9 && this.Y < this.H[d].length - 1) {
                                this.Y++;
                                this.G.a(this.H[d][this.Y]);
                                i9 = ((this.G.e() + this.K[d][this.Y]) - 1) - this.R[d][this.Y];
                            }
                            i14 = i20;
                            boolean a2 = this.D.a(this.I, i18, i14, i8);
                            if (a2) {
                                return true;
                            }
                            if (booleanValue) {
                                i20 = i14;
                            } else {
                                i20 = i14;
                                a2 = this.D.a(i21, i8, i14, i18, this.ac[i14][i8], this.I);
                            }
                            if (a2) {
                                return true;
                            }
                            this.S.addElement(new Integer(this.G.e() - e));
                            a2 = this.D.b(i21, i8, i20, i18, this.ac[i20][i8], this.I);
                            this.G.e();
                            if (a2) {
                                return true;
                            }
                            i17 = i18 + 1;
                            i14 = i;
                            i12 = i9;
                            i9 = i13;
                            a = i19;
                            i16 = i20;
                            i15 = i21;
                            i6 = i3;
                            i7 = i5;
                        }
                        i13 = i9;
                        i9 = i12;
                    } else {
                        i13 = i9;
                    }
                    i16++;
                    i14 = i;
                    i9 = i13;
                    i15 = i15;
                    i6 = i3;
                    i7 = i5;
                }
                i13 = i9;
                i15++;
                i14 = i;
                i6 = i3;
                i7 = i5;
            }
            i13 = i9;
            i8++;
            i6 = i3;
            i7 = i5;
        }
        return false;
    }

    private boolean c(int[][] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[][] iArr2;
        int i7;
        int i8;
        int i9 = i3;
        int i10 = i5;
        cu b = b(null);
        cu a = a(null);
        int e = this.z.e();
        int f = this.z.f();
        int c = this.z.c() + e;
        int d = this.z.d() + f;
        int h = h();
        int i11 = i();
        int j = j();
        int k = k();
        if (a.a != 0) {
            e = (a.a * j) + h;
        }
        if (a.b != 0) {
            f = (a.b * k) + i11;
        }
        if (a.a != b.a - 1) {
            c = ((a.a + 1) * j) + h;
        }
        if (a.b != b.b - 1) {
            d = i11 + ((a.b + 1) * k);
        }
        int d2 = d();
        int[][] iArr3 = new int[i10][];
        int i12 = e;
        h = f;
        int i13 = c;
        j = d;
        d = 0;
        k = 0;
        int i14 = 0;
        int i15 = 100000;
        c = i4;
        while (c < i10) {
            i11 = i15;
            i15 = i13;
            i13 = d;
            d = i2;
            while (d < i9) {
                i6 = h;
                if (c < this.e.length && d <= this.e[c]) {
                    iArr3[c] = new int[(this.e[c] + 1)];
                    if (iArr[c] != null && d < iArr[c].length && iArr[c][d] < i11) {
                        i11 = iArr[c][d];
                    }
                    h = this.D.a(c, d) - 1;
                    iArr2 = iArr3;
                    int i16 = i11;
                    i11 = j;
                    i7 = i12;
                    j = i14;
                    i12 = i15;
                    i8 = i6;
                    while (h >= 0) {
                        bx c2 = this.D.c(c, d, h);
                        if (c2.a != e) {
                            if (c2.a < i12) {
                                i12 = c2.a;
                            }
                            if (c2.a > i7) {
                                i7 = c2.a;
                            }
                        }
                        if (c2.b != f) {
                            if (c2.b < i11) {
                                i11 = c2.b;
                            }
                            if (c2.b > i8) {
                                i8 = c2.b;
                            }
                        }
                        if (i13 == 0) {
                            i9 = c2.c;
                            i10 = c2.d;
                        } else {
                            i9 = ds.a(j, c2.c);
                            i10 = ds.a(k, c2.d);
                        }
                        j = i9;
                        k = i10;
                        i13++;
                        h--;
                        i9 = i3;
                        i10 = i5;
                    }
                    h = i8;
                    i14 = j;
                    i15 = i12;
                    i12 = i7;
                    j = i11;
                    i11 = i16;
                } else {
                    iArr2 = iArr3;
                    h = i6;
                }
                d++;
                iArr3 = iArr2;
                i9 = i3;
                i10 = i5;
            }
            iArr2 = iArr3;
            i6 = h;
            c++;
            d = i13;
            i13 = i15;
            i9 = i3;
            i10 = i5;
            i15 = i11;
        }
        iArr2 = iArr3;
        if (d == 0) {
            throw new Error("Image cannot have no precinct");
        }
        h = ((h - j) / k) + 1;
        i12 = ((i12 - i13) / i14) + 1;
        i7 = ((this.H[d2][this.Y] + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
        i9 = ((Integer) this.a.h.d(d2)).intValue();
        boolean booleanValue = ((Boolean) this.a.r.d(d2)).booleanValue();
        i8 = i2;
        c = i7;
        while (i8 < i3) {
            int i17;
            int i18;
            int i19;
            int i20;
            d = e;
            i11 = f;
            i6 = c;
            c = 0;
            while (c <= h) {
                int i21;
                i7 = d;
                d = 0;
                while (d <= i12) {
                    int i22;
                    i17 = e;
                    i18 = f;
                    e = i5;
                    f = i4;
                    while (f < e) {
                        if (f < this.e.length && i8 <= this.e[f]) {
                            i19 = j;
                            if (iArr2[f][i8] < this.D.a(f, i8)) {
                                bx c3 = this.D.c(f, i8, iArr2[f][i8]);
                                if (c3.a == i7 && c3.b == i11) {
                                    e = i;
                                    i21 = i7;
                                    j = i15;
                                    i7 = i6;
                                    while (j < e) {
                                        if (i8 < iArr[f].length && j >= iArr[f][i8] && j < i9) {
                                            e = this.G.e();
                                            if (booleanValue) {
                                                i20 = i9;
                                                i22 = i11;
                                                this.D.a(j, i8, f, iArr2[f][i8], this.ac[f][i8], this.I);
                                            } else {
                                                i20 = i9;
                                                i22 = i11;
                                            }
                                            if (e > i7 && this.Y < this.H[d2].length - 1) {
                                                this.Y++;
                                                this.G.a(this.H[d2][this.Y]);
                                                i7 = ((this.G.e() + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
                                            }
                                            int i23 = i7;
                                            boolean a2 = this.D.a(this.I, iArr2[f][i8], f, i8);
                                            if (a2) {
                                                return true;
                                            }
                                            if (!booleanValue) {
                                                a2 = this.D.a(j, i8, f, iArr2[f][i8], this.ac[f][i8], this.I);
                                            }
                                            if (a2) {
                                                return true;
                                            }
                                            this.S.addElement(new Integer(this.G.e() - e));
                                            a2 = this.D.b(j, i8, f, iArr2[f][i8], this.ac[f][i8], this.I);
                                            this.G.e();
                                            if (a2) {
                                                return true;
                                            }
                                            i7 = i23;
                                        } else {
                                            i20 = i9;
                                            i22 = i11;
                                        }
                                        j++;
                                        i9 = i20;
                                        i11 = i22;
                                        e = i;
                                    }
                                    i20 = i9;
                                    i22 = i11;
                                    int[] iArr4 = iArr2[f];
                                    iArr4[i8] = iArr4[i8] + 1;
                                    i6 = i7;
                                }
                            }
                            i21 = i7;
                            i20 = i9;
                            i22 = i11;
                        } else {
                            i21 = i7;
                            i20 = i9;
                            i22 = i11;
                            i19 = j;
                        }
                        f++;
                        j = i19;
                        i7 = i21;
                        i9 = i20;
                        i11 = i22;
                        e = i5;
                    }
                    i20 = i9;
                    i22 = i11;
                    i19 = j;
                    i7 = d != i12 ? i13 + (d * i14) : i17;
                    d++;
                    e = i17;
                    f = i18;
                    j = i19;
                    i9 = i20;
                    i11 = i22;
                }
                i21 = i7;
                i20 = i9;
                i17 = e;
                i18 = f;
                i19 = j;
                i11 = c != h ? i19 + (c * k) : i18;
                c++;
                e = i17;
                f = i18;
                j = i19;
                d = i21;
                i9 = i20;
                i7 = i3;
            }
            i20 = i9;
            i17 = e;
            i18 = f;
            i19 = j;
            i8++;
            c = i6;
        }
        return false;
    }

    private boolean d(int[][] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[][] iArr2;
        int i7;
        int i8;
        int i9 = i3;
        int i10 = i5;
        cu b = b(null);
        cu a = a(null);
        int e = this.z.e();
        int f = this.z.f();
        int c = this.z.c() + e;
        int d = this.z.d() + f;
        int h = h();
        int i11 = i();
        int j = j();
        int k = k();
        if (a.a != 0) {
            e = (a.a * j) + h;
        }
        if (a.b != 0) {
            f = (a.b * k) + i11;
        }
        if (a.a != b.a - 1) {
            c = ((a.a + 1) * j) + h;
        }
        if (a.b != b.b - 1) {
            d = i11 + ((a.b + 1) * k);
        }
        int d2 = d();
        int[][] iArr3 = new int[i10][];
        int i12 = e;
        h = f;
        int i13 = c;
        j = d;
        d = 0;
        k = 0;
        int i14 = 0;
        int i15 = 100000;
        c = i4;
        while (c < i10) {
            i11 = i15;
            i15 = i13;
            i13 = d;
            d = i2;
            while (d < i9) {
                i6 = h;
                if (c < this.e.length && d <= this.e[c]) {
                    iArr3[c] = new int[(this.e[c] + 1)];
                    if (iArr[c] != null && d < iArr[c].length && iArr[c][d] < i11) {
                        i11 = iArr[c][d];
                    }
                    h = this.D.a(c, d) - 1;
                    iArr2 = iArr3;
                    int i16 = i11;
                    i11 = j;
                    i7 = i12;
                    j = i14;
                    i12 = i15;
                    i8 = i6;
                    while (h >= 0) {
                        bx c2 = this.D.c(c, d, h);
                        if (c2.a != e) {
                            if (c2.a < i12) {
                                i12 = c2.a;
                            }
                            if (c2.a > i7) {
                                i7 = c2.a;
                            }
                        }
                        if (c2.b != f) {
                            if (c2.b < i11) {
                                i11 = c2.b;
                            }
                            if (c2.b > i8) {
                                i8 = c2.b;
                            }
                        }
                        if (i13 == 0) {
                            i10 = c2.c;
                            i9 = c2.d;
                        } else {
                            i10 = ds.a(j, c2.c);
                            i9 = ds.a(k, c2.d);
                        }
                        k = i9;
                        j = i10;
                        i13++;
                        h--;
                        i9 = i3;
                        i10 = i5;
                    }
                    h = i8;
                    i14 = j;
                    i15 = i12;
                    i12 = i7;
                    j = i11;
                    i11 = i16;
                } else {
                    iArr2 = iArr3;
                    h = i6;
                }
                d++;
                iArr3 = iArr2;
                i9 = i3;
                i10 = i5;
            }
            iArr2 = iArr3;
            i6 = h;
            c++;
            d = i13;
            i13 = i15;
            i9 = i3;
            i10 = i5;
            i15 = i11;
        }
        iArr2 = iArr3;
        if (d == 0) {
            throw new Error("Image cannot have no precinct");
        }
        h = ((h - j) / k) + 1;
        i12 = ((i12 - i13) / i14) + 1;
        i7 = ((this.H[d2][this.Y] + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
        i9 = ((Integer) this.a.h.d(d2)).intValue();
        boolean booleanValue = ((Boolean) this.a.r.d(d2)).booleanValue();
        d = i7;
        i8 = e;
        c = f;
        i7 = 0;
        while (i7 <= h) {
            int i17;
            int i18;
            int i19;
            int i20;
            int i21;
            int i22;
            i11 = d;
            d = i8;
            i8 = 0;
            while (i8 <= i12) {
                int i23;
                i17 = e;
                i6 = i11;
                i11 = i5;
                e = i4;
                while (e < i11) {
                    i18 = f;
                    if (e < this.e.length) {
                        i11 = i2;
                        while (i11 < i3) {
                            if (i11 > this.e[e]) {
                                i19 = i9;
                                i20 = d2;
                                i23 = c;
                                i21 = d;
                                i22 = j;
                            } else {
                                i22 = j;
                                if (iArr2[e][i11] < this.D.a(e, i11)) {
                                    bx c3 = this.D.c(e, i11, iArr2[e][i11]);
                                    if (c3.a == d && c3.b == c) {
                                        f = i;
                                        i23 = c;
                                        j = i15;
                                        c = i6;
                                        while (j < f) {
                                            if (i11 < iArr[e].length && j >= iArr[e][i11] && j < i9) {
                                                f = this.G.e();
                                                if (booleanValue) {
                                                    i19 = i9;
                                                    i21 = d;
                                                    this.D.a(j, i11, e, iArr2[e][i11], this.ac[e][i11], this.I);
                                                } else {
                                                    i19 = i9;
                                                    i21 = d;
                                                }
                                                if (f > c && this.Y < this.H[d2].length - 1) {
                                                    this.Y++;
                                                    this.G.a(this.H[d2][this.Y]);
                                                    c = ((this.G.e() + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
                                                }
                                                i20 = d2;
                                                boolean a2 = this.D.a(this.I, iArr2[e][i11], e, i11);
                                                if (a2) {
                                                    return true;
                                                }
                                                if (!booleanValue) {
                                                    a2 = this.D.a(j, i11, e, iArr2[e][i11], this.ac[e][i11], this.I);
                                                }
                                                if (a2) {
                                                    return true;
                                                }
                                                this.S.addElement(new Integer(this.G.e() - f));
                                                a2 = this.D.b(j, i11, e, iArr2[e][i11], this.ac[e][i11], this.I);
                                                this.G.e();
                                                if (a2) {
                                                    return true;
                                                }
                                            } else {
                                                i19 = i9;
                                                i20 = d2;
                                                i21 = d;
                                            }
                                            j++;
                                            i9 = i19;
                                            d = i21;
                                            d2 = i20;
                                            f = i;
                                        }
                                        i19 = i9;
                                        i20 = d2;
                                        i21 = d;
                                        int[] iArr4 = iArr2[e];
                                        iArr4[i11] = iArr4[i11] + 1;
                                        i6 = c;
                                    }
                                }
                                i19 = i9;
                                i20 = d2;
                                i23 = c;
                                i21 = d;
                            }
                            i11++;
                            j = i22;
                            c = i23;
                            i9 = i19;
                            d = i21;
                            d2 = i20;
                        }
                    }
                    e++;
                    f = i18;
                    j = j;
                    c = c;
                    i9 = i9;
                    d = d;
                    d2 = d2;
                    i11 = i5;
                }
                i19 = i9;
                i20 = d2;
                i18 = f;
                i23 = c;
                i22 = j;
                d = i8 != i12 ? i13 + (i8 * i14) : i17;
                i8++;
                i11 = i6;
                e = i17;
                f = i18;
                j = i22;
                c = i23;
                i9 = i19;
                d2 = i20;
            }
            i19 = i9;
            i20 = d2;
            i17 = e;
            i18 = f;
            i21 = d;
            i22 = j;
            c = i7 != h ? i22 + (i7 * k) : i18;
            i7++;
            d = i11;
            e = i17;
            f = i18;
            j = i22;
            i9 = i19;
            i8 = i21;
            d2 = i20;
        }
        return false;
    }

    private boolean e(int[][] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[][] iArr2;
        int i7;
        int i8;
        int i9 = i3;
        int i10 = i5;
        cu b = b(null);
        cu a = a(null);
        int e = this.z.e();
        int f = this.z.f();
        int c = this.z.c() + e;
        int d = this.z.d() + f;
        int h = h();
        int i11 = i();
        int j = j();
        int k = k();
        if (a.a != 0) {
            e = (a.a * j) + h;
        }
        if (a.b != 0) {
            f = (a.b * k) + i11;
        }
        if (a.a != b.a - 1) {
            c = ((a.a + 1) * j) + h;
        }
        if (a.b != b.b - 1) {
            d = i11 + ((a.b + 1) * k);
        }
        int d2 = d();
        int[][] iArr3 = new int[i10][];
        int i12 = e;
        h = f;
        int i13 = c;
        j = d;
        d = 0;
        k = 0;
        int i14 = 0;
        int i15 = 100000;
        c = i4;
        while (c < i10) {
            i11 = i15;
            i15 = i13;
            i13 = d;
            d = i2;
            while (d < i9) {
                i6 = h;
                if (c < this.e.length && d <= this.e[c]) {
                    iArr3[c] = new int[(this.e[c] + 1)];
                    if (iArr[c] != null && d < iArr[c].length && iArr[c][d] < i11) {
                        i11 = iArr[c][d];
                    }
                    h = this.D.a(c, d) - 1;
                    iArr2 = iArr3;
                    int i16 = i11;
                    i11 = j;
                    i7 = i12;
                    j = i14;
                    i12 = i15;
                    i8 = i6;
                    while (h >= 0) {
                        bx c2 = this.D.c(c, d, h);
                        if (c2.a != e) {
                            if (c2.a < i12) {
                                i12 = c2.a;
                            }
                            if (c2.a > i7) {
                                i7 = c2.a;
                            }
                        }
                        if (c2.b != f) {
                            if (c2.b < i11) {
                                i11 = c2.b;
                            }
                            if (c2.b > i8) {
                                i8 = c2.b;
                            }
                        }
                        if (i13 == 0) {
                            i10 = c2.c;
                            i9 = c2.d;
                        } else {
                            i10 = ds.a(j, c2.c);
                            i9 = ds.a(k, c2.d);
                        }
                        k = i9;
                        j = i10;
                        i13++;
                        h--;
                        i9 = i3;
                        i10 = i5;
                    }
                    h = i8;
                    i14 = j;
                    i15 = i12;
                    i12 = i7;
                    j = i11;
                    i11 = i16;
                } else {
                    iArr2 = iArr3;
                    h = i6;
                }
                d++;
                iArr3 = iArr2;
                i9 = i3;
                i10 = i5;
            }
            iArr2 = iArr3;
            i6 = h;
            c++;
            d = i13;
            i13 = i15;
            i9 = i3;
            i10 = i5;
            i15 = i11;
        }
        iArr2 = iArr3;
        if (d == 0) {
            throw new Error("Image cannot have no precinct");
        }
        h = ((h - j) / k) + 1;
        i12 = ((i12 - i13) / i14) + 1;
        i7 = ((this.H[d2][this.Y] + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
        ((Integer) this.a.h.d(d2)).intValue();
        boolean booleanValue = ((Boolean) this.a.r.d(d2)).booleanValue();
        i10 = i4;
        i8 = i7;
        while (i10 < i5) {
            int i17;
            int i18;
            int i19;
            int i20;
            if (i10 >= this.e.length) {
                i17 = d2;
                i18 = e;
                i19 = f;
                i20 = j;
            } else {
                i11 = i8;
                c = e;
                d = f;
                i8 = 0;
                while (i8 <= h) {
                    int i21;
                    i6 = i11;
                    i11 = c;
                    c = 0;
                    while (c <= i12) {
                        int i22;
                        i18 = e;
                        i7 = i3;
                        e = i2;
                        while (e < i7) {
                            if (e > this.e[i10]) {
                                i17 = d2;
                                i19 = f;
                            } else {
                                i19 = f;
                                if (iArr2[i10][e] < this.D.a(i10, e)) {
                                    bx c3 = this.D.c(i10, e, iArr2[i10][e]);
                                    if (c3.a == i11 && c3.b == d) {
                                        i7 = i;
                                        i22 = d;
                                        f = i15;
                                        d = i6;
                                        while (f < i7) {
                                            if (e < iArr[i10].length && f >= iArr[i10][e]) {
                                                i7 = this.G.e();
                                                if (booleanValue) {
                                                    i21 = i11;
                                                    i20 = j;
                                                    this.D.a(f, e, i10, iArr2[i10][e], this.ac[i10][e], this.I);
                                                } else {
                                                    i21 = i11;
                                                    i20 = j;
                                                }
                                                if (i7 > d && this.Y < this.H[d2].length - 1) {
                                                    this.Y++;
                                                    this.G.a(this.H[d2][this.Y]);
                                                    d = ((this.G.e() + this.K[d2][this.Y]) - 1) - this.R[d2][this.Y];
                                                }
                                                i17 = d2;
                                                boolean a2 = this.D.a(this.I, iArr2[i10][e], i10, e);
                                                if (a2) {
                                                    return true;
                                                }
                                                if (!booleanValue) {
                                                    a2 = this.D.a(f, e, i10, iArr2[i10][e], this.ac[i10][e], this.I);
                                                }
                                                if (a2) {
                                                    return true;
                                                }
                                                this.S.addElement(new Integer(this.G.e() - i7));
                                                boolean b2 = this.D.b(f, e, i10, iArr2[i10][e], this.ac[i10][e], this.I);
                                                this.G.e();
                                                if (b2) {
                                                    return true;
                                                }
                                            } else {
                                                i17 = d2;
                                                i21 = i11;
                                                i20 = j;
                                            }
                                            f++;
                                            i11 = i21;
                                            j = i20;
                                            d2 = i17;
                                            i7 = i;
                                        }
                                        i17 = d2;
                                        i21 = i11;
                                        i20 = j;
                                        int[] iArr4 = iArr2[i10];
                                        iArr4[e] = iArr4[e] + 1;
                                        i6 = d;
                                        e++;
                                        f = i19;
                                        d = i22;
                                        i11 = i21;
                                        j = i20;
                                        d2 = i17;
                                        i7 = i3;
                                    }
                                }
                                i17 = d2;
                            }
                            i22 = d;
                            i21 = i11;
                            i20 = j;
                            e++;
                            f = i19;
                            d = i22;
                            i11 = i21;
                            j = i20;
                            d2 = i17;
                            i7 = i3;
                        }
                        i17 = d2;
                        i19 = f;
                        i22 = d;
                        i20 = j;
                        i11 = c != i12 ? i13 + (c * i14) : i18;
                        c++;
                        e = i18;
                        f = i19;
                        d = i22;
                        j = i20;
                        d2 = i17;
                        i7 = i5;
                    }
                    i17 = d2;
                    i18 = e;
                    i19 = f;
                    i21 = i11;
                    i20 = j;
                    d = i8 != h ? i20 + (i8 * k) : i19;
                    i8++;
                    i11 = i6;
                    e = i18;
                    f = i19;
                    c = i21;
                    j = i20;
                    d2 = i17;
                    i7 = i5;
                }
                i17 = d2;
                i18 = e;
                i19 = f;
                i20 = j;
                i8 = i11;
            }
            i10++;
            e = i18;
            f = i19;
            j = i20;
            d2 = i17;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0215  */
    private void g(int r33) {
        /*
        r32 = this;
        r8 = r32;
        r9 = r33;
        r1 = new java.util.Vector;
        r1.<init>();
        r8.S = r1;
        r1 = r8.a;
        r1 = r1.h;
        r1 = r1.d(r9);
        r1 = (java.lang.Integer) r1;
        r7 = r1.intValue();
        r1 = r8.a;
        r1 = r1.r;
        r1 = r1.d(r9);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0040;
    L_0x0029:
        r1 = r8.z;
        r16 = r1.d(r9);
        r10 = r8.D;
        r11 = r8.f;
        r12 = r8.e;
        r14 = r8.ac;
        r15 = 1;
        r13 = r7;
        r1 = r10.a(r11, r12, r13, r14, r15, r16);
        r8.ac = r1;
        goto L_0x0052;
    L_0x0040:
        r10 = r8.D;
        r11 = r8.f;
        r12 = r8.e;
        r14 = r8.ac;
        r15 = 0;
        r16 = 0;
        r13 = r7;
        r1 = r10.a(r11, r12, r13, r14, r15, r16);
        r8.ac = r1;
    L_0x0052:
        r1 = r8.a;
        r1 = r1.l;
        r1 = r1.d(r9);
        r1 = (int[][]) r1;
        r10 = 1;
        if (r1 != 0) goto L_0x0061;
    L_0x005f:
        r11 = 1;
        goto L_0x0063;
    L_0x0061:
        r2 = r1.length;
        r11 = r2;
    L_0x0063:
        r2 = 6;
        r2 = new int[]{r11, r2};
        r3 = int.class;
        r2 = java.lang.reflect.Array.newInstance(r3, r2);
        r12 = r2;
        r12 = (int[][]) r12;
        r13 = 0;
        r2 = r12[r13];
        r2[r10] = r13;
        r14 = 5;
        r15 = 4;
        r16 = 3;
        r17 = 2;
        if (r1 != 0) goto L_0x00b0;
    L_0x007e:
        r1 = r12[r13];
        r2 = r8.a;
        r2 = r2.i;
        r2 = r2.d(r9);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r1[r13] = r2;
        r1 = r12[r13];
        r1[r10] = r7;
        r1 = r12[r13];
        r1[r17] = r13;
        r1 = r12[r13];
        r2 = r8.a;
        r2 = r2.g;
        r2 = r2.b(r9);
        r2 = r2 + r10;
        r1[r16] = r2;
        r1 = r12[r13];
        r1[r15] = r13;
        r1 = r12[r13];
        r2 = r8.f;
        r1[r14] = r2;
        goto L_0x00e6;
    L_0x00b0:
        r2 = 0;
    L_0x00b1:
        if (r2 >= r11) goto L_0x00e6;
    L_0x00b3:
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r14];
        r3[r13] = r4;
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r17];
        r3[r10] = r4;
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r13];
        r3[r17] = r4;
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r16];
        r3[r16] = r4;
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r10];
        r3[r15] = r4;
        r3 = r12[r2];
        r4 = r1[r2];
        r4 = r4[r15];
        r3[r14] = r4;
        r2 = r2 + 1;
        goto L_0x00b1;
    L_0x00e6:
        r1 = r8.T;	 Catch:{ EOFException -> 0x049e }
        if (r1 == 0) goto L_0x00ee;
    L_0x00ea:
        r1 = r8.H;	 Catch:{ EOFException -> 0x049e }
        if (r1 == 0) goto L_0x00f4;
    L_0x00ee:
        r1 = r8.H;	 Catch:{ EOFException -> 0x049e }
        r1 = r1[r9];	 Catch:{ EOFException -> 0x049e }
        if (r1 != 0) goto L_0x00f5;
    L_0x00f4:
        return;
    L_0x00f5:
        r1 = r8.G;	 Catch:{ EOFException -> 0x049e }
        r2 = r8.H;	 Catch:{ EOFException -> 0x049e }
        r2 = r2[r9];	 Catch:{ EOFException -> 0x049e }
        r2 = r2[r13];	 Catch:{ EOFException -> 0x049e }
        r1.a(r2);	 Catch:{ EOFException -> 0x049e }
        r8.Y = r13;
        r1 = r8.I;
        r18 = r1[r9];
        r1 = r8.f;
        r6 = new int[r1][];
        r1 = 0;
    L_0x010b:
        r2 = r8.f;
        if (r1 >= r2) goto L_0x0125;
    L_0x010f:
        r2 = r8.a;
        r2 = r2.g;
        r2 = r2.a(r9, r1);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r2 = r2 + r10;
        r2 = new int[r2];
        r6[r1] = r2;
        r1 = r1 + 1;
        goto L_0x010b;
    L_0x0125:
        r1 = 0;
        r5 = 0;
    L_0x0127:
        if (r5 >= r11) goto L_0x0210;
    L_0x0129:
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r19 = r1[r10];	 Catch:{ EOFException -> 0x020d }
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r20 = r1[r17];	 Catch:{ EOFException -> 0x020d }
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r4 = r1[r16];	 Catch:{ EOFException -> 0x020d }
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r21 = r1[r15];	 Catch:{ EOFException -> 0x020d }
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r3 = r1[r14];	 Catch:{ EOFException -> 0x020d }
        r1 = r12[r5];	 Catch:{ EOFException -> 0x020d }
        r1 = r1[r13];	 Catch:{ EOFException -> 0x020d }
        switch(r1) {
            case 0: goto L_0x01b5;
            case 1: goto L_0x019a;
            case 2: goto L_0x017f;
            case 3: goto L_0x0163;
            case 4: goto L_0x0148;
            default: goto L_0x0144;
        };	 Catch:{ EOFException -> 0x020d }
    L_0x0144:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ EOFException -> 0x020d }
        goto L_0x0207;
    L_0x0148:
        r1 = r8;
        r2 = r6;
        r22 = r3;
        r3 = r19;
        r23 = r4;
        r4 = r20;
        r24 = r5;
        r5 = r23;
        r25 = r6;
        r6 = r21;
        r14 = r7;
        r7 = r22;
        r1 = r1.e(r2, r3, r4, r5, r6, r7);	 Catch:{ EOFException -> 0x020d }
        goto L_0x01cf;
    L_0x0163:
        r22 = r3;
        r23 = r4;
        r24 = r5;
        r25 = r6;
        r14 = r7;
        r1 = r8;
        r2 = r25;
        r3 = r19;
        r4 = r20;
        r5 = r23;
        r6 = r21;
        r7 = r22;
        r1 = r1.d(r2, r3, r4, r5, r6, r7);	 Catch:{ EOFException -> 0x020d }
        goto L_0x01cf;
    L_0x017f:
        r22 = r3;
        r23 = r4;
        r24 = r5;
        r25 = r6;
        r14 = r7;
        r1 = r8;
        r2 = r25;
        r3 = r19;
        r4 = r20;
        r5 = r23;
        r6 = r21;
        r7 = r22;
        r1 = r1.c(r2, r3, r4, r5, r6, r7);	 Catch:{ EOFException -> 0x020d }
        goto L_0x01cf;
    L_0x019a:
        r22 = r3;
        r23 = r4;
        r24 = r5;
        r25 = r6;
        r14 = r7;
        r1 = r8;
        r2 = r25;
        r3 = r19;
        r4 = r20;
        r5 = r23;
        r6 = r21;
        r7 = r22;
        r1 = r1.b(r2, r3, r4, r5, r6, r7);	 Catch:{ EOFException -> 0x020d }
        goto L_0x01cf;
    L_0x01b5:
        r22 = r3;
        r23 = r4;
        r24 = r5;
        r25 = r6;
        r14 = r7;
        r1 = r8;
        r2 = r25;
        r3 = r19;
        r4 = r20;
        r5 = r23;
        r6 = r21;
        r7 = r22;
        r1 = r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ EOFException -> 0x020d }
    L_0x01cf:
        r3 = r21;
        r2 = r22;
    L_0x01d3:
        if (r3 >= r2) goto L_0x01f7;
    L_0x01d5:
        r4 = r25;
        r5 = r4.length;	 Catch:{ EOFException -> 0x020d }
        if (r3 < r5) goto L_0x01dd;
    L_0x01da:
        r5 = r23;
        goto L_0x01f0;
    L_0x01dd:
        r6 = r20;
        r5 = r23;
    L_0x01e1:
        if (r6 >= r5) goto L_0x01f0;
    L_0x01e3:
        r7 = r4[r3];	 Catch:{ EOFException -> 0x020d }
        r7 = r7.length;	 Catch:{ EOFException -> 0x020d }
        if (r6 < r7) goto L_0x01e9;
    L_0x01e8:
        goto L_0x01ed;
    L_0x01e9:
        r7 = r4[r3];	 Catch:{ EOFException -> 0x020d }
        r7[r6] = r19;	 Catch:{ EOFException -> 0x020d }
    L_0x01ed:
        r6 = r6 + 1;
        goto L_0x01e1;
    L_0x01f0:
        r3 = r3 + 1;
        r25 = r4;
        r23 = r5;
        goto L_0x01d3;
    L_0x01f7:
        r4 = r25;
        if (r1 != 0) goto L_0x0211;
    L_0x01fb:
        r2 = r8.ae;	 Catch:{ EOFException -> 0x020d }
        if (r2 == 0) goto L_0x0200;
    L_0x01ff:
        goto L_0x0211;
    L_0x0200:
        r5 = r24 + 1;
        r6 = r4;
        r7 = r14;
        r14 = 5;
        goto L_0x0127;
    L_0x0207:
        r2 = "Not recognized progression type";
        r1.<init>(r2);	 Catch:{ EOFException -> 0x020d }
        throw r1;	 Catch:{ EOFException -> 0x020d }
    L_0x020d:
        r0 = move-exception;
        r1 = r0;
        throw r1;
    L_0x0210:
        r14 = r7;
    L_0x0211:
        r2 = r8.T;
        if (r2 == 0) goto L_0x0229;
    L_0x0215:
        r2 = r8.B;
        r3 = r8.I;
        r3 = r3[r9];
        r18 = r18 - r3;
        r2 = r2 + r18;
        r8.B = r2;
        if (r1 == 0) goto L_0x049d;
    L_0x0223:
        r1 = r8.I;
        r1[r9] = r13;
        goto L_0x049d;
    L_0x0229:
        r1 = r8.I;
        r1 = r1[r9];
        r2 = r8.L;
        r2 = r2[r9];
        r3 = r8.M;
        r3 = r3[r9];
        r2 = r2 - r3;
        if (r1 >= r2) goto L_0x0470;
    L_0x0238:
        r1 = r8.S;
        r1 = r1.size();
        r1 = new int[r1];
        r2 = r8.S;
        r2 = r2.size();
        r2 = r2 - r10;
    L_0x0247:
        if (r2 < 0) goto L_0x025a;
    L_0x0249:
        r3 = r8.S;
        r3 = r3.elementAt(r2);
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        r1[r2] = r3;
        r2 = r2 + -1;
        goto L_0x0247;
    L_0x025a:
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x025d:
        if (r2 >= r14) goto L_0x049d;
    L_0x025f:
        r5 = r8.ac;
        if (r5 != 0) goto L_0x0267;
    L_0x0263:
        r16 = 0;
        goto L_0x046a;
    L_0x0267:
        r5 = r8.ac;
        r5 = r5.length;
        r6 = 0;
        r7 = 0;
    L_0x026c:
        if (r6 >= r5) goto L_0x0283;
    L_0x026e:
        r11 = r8.ac;
        r11 = r11[r6];
        if (r11 == 0) goto L_0x0280;
    L_0x0274:
        r11 = r8.ac;
        r11 = r11[r6];
        r11 = r11.length;
        if (r11 <= r7) goto L_0x0280;
    L_0x027b:
        r7 = r8.ac;
        r7 = r7[r6];
        r7 = r7.length;
    L_0x0280:
        r6 = r6 + 1;
        goto L_0x026c;
    L_0x0283:
        r6 = r4;
        r4 = r3;
        r3 = 0;
    L_0x0286:
        if (r3 >= r7) goto L_0x0466;
    L_0x0288:
        r11 = 0;
        r12 = 0;
    L_0x028a:
        if (r11 >= r5) goto L_0x02ad;
    L_0x028c:
        r15 = r8.ac;
        r15 = r15[r11];
        if (r15 == 0) goto L_0x02aa;
    L_0x0292:
        r15 = r8.ac;
        r15 = r15[r11];
        r15 = r15[r3];
        if (r15 == 0) goto L_0x02aa;
    L_0x029a:
        r15 = r8.ac;
        r15 = r15[r11];
        r15 = r15[r3];
        r15 = r15.length;
        if (r15 <= r12) goto L_0x02aa;
    L_0x02a3:
        r12 = r8.ac;
        r12 = r12[r11];
        r12 = r12[r3];
        r12 = r12.length;
    L_0x02aa:
        r11 = r11 + 1;
        goto L_0x028a;
    L_0x02ad:
        r11 = r6;
        r6 = r4;
        r4 = 0;
    L_0x02b0:
        if (r4 >= r12) goto L_0x0458;
    L_0x02b2:
        if (r3 != 0) goto L_0x02b7;
    L_0x02b4:
        if (r4 == 0) goto L_0x02b7;
    L_0x02b6:
        goto L_0x02bb;
    L_0x02b7:
        if (r3 == 0) goto L_0x02c5;
    L_0x02b9:
        if (r4 != 0) goto L_0x02c5;
    L_0x02bb:
        r28 = r5;
        r26 = r7;
        r30 = r12;
        r16 = 0;
        goto L_0x044c;
    L_0x02c5:
        r10 = 0;
        r15 = 0;
    L_0x02c7:
        if (r15 >= r5) goto L_0x02f9;
    L_0x02c9:
        r13 = r8.ac;
        r13 = r13[r15];
        if (r13 == 0) goto L_0x02f5;
    L_0x02cf:
        r13 = r8.ac;
        r13 = r13[r15];
        r13 = r13[r3];
        if (r13 == 0) goto L_0x02f5;
    L_0x02d7:
        r13 = r8.ac;
        r13 = r13[r15];
        r13 = r13[r3];
        r13 = r13[r4];
        if (r13 == 0) goto L_0x02f5;
    L_0x02e1:
        r13 = r8.ac;
        r13 = r13[r15];
        r13 = r13[r3];
        r13 = r13[r4];
        r13 = r13.length;
        if (r13 <= r10) goto L_0x02f5;
    L_0x02ec:
        r10 = r8.ac;
        r10 = r10[r15];
        r10 = r10[r3];
        r10 = r10[r4];
        r10 = r10.length;
    L_0x02f5:
        r15 = r15 + 1;
        r13 = 0;
        goto L_0x02c7;
    L_0x02f9:
        r13 = r11;
        r11 = r6;
        r6 = 0;
    L_0x02fc:
        if (r6 >= r10) goto L_0x0442;
    L_0x02fe:
        r26 = r7;
        r7 = 0;
        r15 = 0;
    L_0x0302:
        if (r15 >= r5) goto L_0x0347;
    L_0x0304:
        r27 = r10;
        r10 = r8.ac;
        r10 = r10[r15];
        if (r10 == 0) goto L_0x0342;
    L_0x030c:
        r10 = r8.ac;
        r10 = r10[r15];
        r10 = r10[r3];
        if (r10 == 0) goto L_0x0342;
    L_0x0314:
        r10 = r8.ac;
        r10 = r10[r15];
        r10 = r10[r3];
        r10 = r10[r4];
        if (r10 == 0) goto L_0x0342;
    L_0x031e:
        r10 = r8.ac;
        r10 = r10[r15];
        r10 = r10[r3];
        r10 = r10[r4];
        r10 = r10[r6];
        if (r10 == 0) goto L_0x0342;
    L_0x032a:
        r10 = r8.ac;
        r10 = r10[r15];
        r10 = r10[r3];
        r10 = r10[r4];
        r10 = r10[r6];
        r10 = r10.length;
        if (r10 <= r7) goto L_0x0342;
    L_0x0337:
        r7 = r8.ac;
        r7 = r7[r15];
        r7 = r7[r3];
        r7 = r7[r4];
        r7 = r7[r6];
        r7 = r7.length;
    L_0x0342:
        r15 = r15 + 1;
        r10 = r27;
        goto L_0x0302;
    L_0x0347:
        r27 = r10;
        r10 = 0;
    L_0x034a:
        if (r10 >= r7) goto L_0x0434;
    L_0x034c:
        r15 = r13;
        r13 = r11;
        r11 = 0;
    L_0x034f:
        if (r11 >= r5) goto L_0x0423;
    L_0x0351:
        r28 = r5;
        r5 = r8.ac;
        r5 = r5[r11];
        if (r5 == 0) goto L_0x040f;
    L_0x0359:
        r5 = r8.ac;
        r5 = r5[r11];
        r5 = r5[r3];
        if (r5 == 0) goto L_0x040f;
    L_0x0361:
        r5 = r8.ac;
        r5 = r5[r11];
        r5 = r5[r3];
        r5 = r5[r4];
        if (r5 == 0) goto L_0x040f;
    L_0x036b:
        r5 = r8.ac;
        r5 = r5[r11];
        r5 = r5[r3];
        r5 = r5[r4];
        r5 = r5[r6];
        if (r5 == 0) goto L_0x040f;
    L_0x0377:
        r5 = r8.ac;
        r5 = r5[r11];
        r5 = r5[r3];
        r5 = r5[r4];
        r5 = r5[r6];
        r5 = r5[r10];
        if (r5 != 0) goto L_0x0387;
    L_0x0385:
        goto L_0x040f;
    L_0x0387:
        r5 = r8.ac;
        r5 = r5[r11];
        r5 = r5[r3];
        r5 = r5[r4];
        r5 = r5[r6];
        r5 = r5[r10];
        if (r13 != 0) goto L_0x03cd;
    L_0x0395:
        r29 = r7;
        r7 = r8.I;
        r7 = r7[r9];
        r30 = r12;
        r12 = r5.k;
        r12 = r12[r2];
        r12 = r1[r12];
        if (r7 >= r12) goto L_0x03a9;
    L_0x03a5:
        r15 = 1;
        r31 = 1;
        goto L_0x03d3;
    L_0x03a9:
        if (r15 != 0) goto L_0x03d1;
    L_0x03ab:
        r7 = r8.I;
        r12 = r7[r9];
        r31 = r13;
        r13 = r5.k;
        r13 = r13[r2];
        r13 = r1[r13];
        r12 = r12 - r13;
        r7[r9] = r12;
        r7 = r8.B;
        r12 = r5.k;
        r12 = r12[r2];
        r12 = r1[r12];
        r7 = r7 + r12;
        r8.B = r7;
        r7 = r5.k;
        r7 = r7[r2];
        r12 = 0;
        r1[r7] = r12;
        goto L_0x03d3;
    L_0x03cd:
        r29 = r7;
        r30 = r12;
    L_0x03d1:
        r31 = r13;
    L_0x03d3:
        r7 = r5.f;
        r7 = r7[r2];
        if (r7 != 0) goto L_0x03da;
    L_0x03d9:
        goto L_0x03fa;
    L_0x03da:
        r7 = r5.f;
        r7 = r7[r2];
        r12 = r8.I;
        r12 = r12[r9];
        if (r7 >= r12) goto L_0x03ff;
    L_0x03e4:
        if (r31 != 0) goto L_0x03ff;
    L_0x03e6:
        r7 = r8.I;
        r12 = r7[r9];
        r13 = r5.f;
        r13 = r13[r2];
        r12 = r12 - r13;
        r7[r9] = r12;
        r7 = r8.B;
        r5 = r5.f;
        r5 = r5[r2];
        r7 = r7 + r5;
        r8.B = r7;
    L_0x03fa:
        r13 = r31;
        r16 = 0;
        goto L_0x0419;
    L_0x03ff:
        r7 = r5.f;
        r12 = r5.g;
        r5 = r5.h;
        r16 = 0;
        r5[r2] = r16;
        r12[r2] = r16;
        r7[r2] = r16;
        r13 = 1;
        goto L_0x0419;
    L_0x040f:
        r29 = r7;
        r30 = r12;
        r31 = r13;
        r16 = 0;
        r13 = r31;
    L_0x0419:
        r11 = r11 + 1;
        r5 = r28;
        r7 = r29;
        r12 = r30;
        goto L_0x034f;
    L_0x0423:
        r28 = r5;
        r29 = r7;
        r30 = r12;
        r31 = r13;
        r16 = 0;
        r10 = r10 + 1;
        r13 = r15;
        r11 = r31;
        goto L_0x034a;
    L_0x0434:
        r28 = r5;
        r30 = r12;
        r16 = 0;
        r6 = r6 + 1;
        r7 = r26;
        r10 = r27;
        goto L_0x02fc;
    L_0x0442:
        r28 = r5;
        r26 = r7;
        r30 = r12;
        r16 = 0;
        r6 = r11;
        r11 = r13;
    L_0x044c:
        r4 = r4 + 1;
        r7 = r26;
        r5 = r28;
        r12 = r30;
        r10 = 1;
        r13 = 0;
        goto L_0x02b0;
    L_0x0458:
        r28 = r5;
        r26 = r7;
        r16 = 0;
        r3 = r3 + 1;
        r4 = r6;
        r6 = r11;
        r10 = 1;
        r13 = 0;
        goto L_0x0286;
    L_0x0466:
        r16 = 0;
        r3 = r4;
        r4 = r6;
    L_0x046a:
        r2 = r2 + 1;
        r10 = 1;
        r13 = 0;
        goto L_0x025d;
    L_0x0470:
        r1 = r8.B;
        r2 = r8.L;
        r2 = r2[r9];
        r3 = r8.M;
        r3 = r3[r9];
        r2 = r2 - r3;
        r1 = r1 + r2;
        r8.B = r1;
        r1 = r32.e();
        r2 = 1;
        r1 = r1 - r2;
        if (r9 >= r1) goto L_0x049d;
    L_0x0486:
        r1 = r8.I;
        r2 = r9 + 1;
        r3 = r1[r2];
        r4 = r8.I;
        r4 = r4[r9];
        r5 = r8.L;
        r5 = r5[r9];
        r6 = r8.M;
        r6 = r6[r9];
        r5 = r5 - r6;
        r4 = r4 - r5;
        r3 = r3 + r4;
        r1[r2] = r3;
    L_0x049d:
        return;
    L_0x049e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.ca.g(int):void");
    }

    public void f(int i, int i2) {
        if (i < 0 || i2 < 0 || i >= this.u || i2 >= this.v) {
            throw new IllegalArgumentException();
        }
        int i3;
        int i4 = (this.u * i2) + i;
        if (i4 == 0) {
            this.B = this.Q;
            if (!this.T) {
                this.B += 2;
            }
            for (i3 = 0; i3 < this.w; i3++) {
                this.I[i3] = this.J[i3];
            }
        }
        this.x = i;
        this.y = i2;
        i3 = i == 0 ? this.k : this.m + (this.s * i);
        int i5 = i2 == 0 ? this.l : this.n + (this.t * i2);
        for (int i6 = this.f - 1; i6 >= 0; i6--) {
            this.q[i6] = ((this.z.b(i6) + i3) - 1) / this.z.b(i6);
            this.r[i6] = ((this.z.c(i6) + i5) - 1) / this.z.c(i6);
            this.o[i6] = (((this.m + (this.s * i)) + this.z.b(i6)) - 1) / this.z.b(i6);
            this.p[i6] = (((this.n + (this.t * i2)) + this.z.c(i6)) - 1) / this.z.c(i6);
        }
        this.h = new eg[this.f];
        this.e = new int[this.f];
        this.b = new boolean[this.f];
        this.d = new dn[this.f];
        this.c = new int[this.f];
        for (int i7 = 0; i7 < this.f; i7++) {
            this.b[i7] = this.a.c.c(i4, i7);
            this.d[i7] = (dn) this.a.d.a(i4, i7);
            this.c[i7] = ((Integer) this.a.e.a(i4, i7)).intValue();
            this.e[i7] = ((Integer) this.a.g.a(i4, i7)).intValue();
            this.h[i7] = new eg(a(i4, i7, this.e[i7]), b(i4, i7, this.e[i7]), c(i7, this.e[i7]), d(i7, this.e[i7]), this.e[i7], this.a.f.c(i4, i7), this.a.f.d(i4, i7));
            a(i7, this.h[i7]);
        }
        try {
            g(i4);
        } catch (IOException e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IO Error when reading tile ");
            stringBuilder.append(i);
            stringBuilder.append(" x ");
            stringBuilder.append(i2);
            throw new Error(stringBuilder.toString());
        }
    }

    public cn a(int i, int i2, int i3, eg egVar, int i4, int i5, cn cnVar) {
        StringBuilder stringBuilder;
        ca caVar = this;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        eg egVar2 = egVar;
        int i9 = i4;
        int d = d();
        int i10 = egVar2.d;
        int i11 = egVar2.g;
        int intValue = ((Integer) caVar.a.h.d(d)).intValue();
        int intValue2 = ((Integer) caVar.a.j.a(d, i6)).intValue();
        int i12 = i5 < 0 ? (intValue - i9) + 1 : i5;
        if (caVar.ad != -1 && i9 + i12 > caVar.ad) {
            i12 = caVar.ad - i9;
        }
        if (i10 > (caVar.g + caVar.e(d, i6).d) - caVar.a.g.a()) {
            throw new Error("JJ2000 error: requesting a code-block disallowed by the '-res' option.");
        }
        try {
            bz bzVar = caVar.ac[i6][i10][i11][i7][i8];
            if (i9 >= 1 && i9 <= intValue) {
                i12 = (i12 + i9) - 1;
                if (i12 <= intValue) {
                    cn cnVar2 = cnVar == null ? new cn() : cnVar;
                    cnVar2.b = i7;
                    cnVar2.a = i8;
                    cnVar2.k = 0;
                    cnVar2.i = 0;
                    cnVar2.m = 0;
                    if (bzVar == null) {
                        cnVar2.c = 0;
                        cnVar2.j = false;
                        cnVar2.f = 0;
                        cnVar2.e = 0;
                        cnVar2.h = 0;
                        cnVar2.g = 0;
                        return cnVar2;
                    }
                    int i13;
                    cnVar2.c = bzVar.e;
                    cnVar2.e = bzVar.a;
                    cnVar2.f = bzVar.b;
                    cnVar2.g = bzVar.c;
                    cnVar2.h = bzVar.d;
                    cnVar2.l = 0;
                    i8 = 0;
                    while (i8 < bzVar.f.length && bzVar.f[i8] == 0) {
                        cnVar2.l += bzVar.h[i8];
                        i8++;
                    }
                    i8 = i9 - 1;
                    for (i11 = i8; i11 < i12; i11++) {
                        cnVar2.k++;
                        cnVar2.i += bzVar.f[i11];
                        cnVar2.m += bzVar.h[i11];
                    }
                    i11 = intValue2 & 4;
                    if (i11 != 0) {
                        d = cnVar2.m - cnVar2.l;
                    } else if ((intValue2 & 1) == 0 || cnVar2.m <= 10) {
                        d = 1;
                    } else {
                        i10 = 1;
                        for (d = cnVar2.l; d < cnVar2.m; d++) {
                            if (d >= 9) {
                                i13 = (d + 2) % 3;
                                if (i13 == 1 || i13 == 2) {
                                    i10++;
                                }
                            }
                        }
                        d = i10;
                    }
                    if (cnVar2.d == null || cnVar2.d.length < cnVar2.i) {
                        cnVar2.d = new byte[cnVar2.i];
                    }
                    if (d > 1 && (cnVar2.n == null || cnVar2.n.length < d)) {
                        cnVar2.n = new int[d];
                    } else if (d > 1 && (intValue2 & 5) == 1) {
                        dq.a(cnVar2.n, 0);
                    }
                    i10 = cnVar2.l;
                    intValue2 = cnVar2.l;
                    int i14 = 0;
                    int i15 = -1;
                    while (i8 < i12) {
                        intValue2 += bzVar.h[i8];
                        if (bzVar.f[i8] != 0) {
                            try {
                                caVar.G.a(bzVar.g[i8]);
                                caVar.G.a(cnVar2.d, i15 + 1, bzVar.f[i8]);
                                i15 += bzVar.f[i8];
                                if (d != 1) {
                                    int i16;
                                    if (i11 != 0) {
                                        i7 = 0;
                                        while (i10 < intValue2) {
                                            if (bzVar.j[i8] != null) {
                                                i16 = i14 + 1;
                                                cnVar2.n[i14] = bzVar.j[i8][i7];
                                            } else {
                                                i16 = i14 + 1;
                                                cnVar2.n[i14] = bzVar.f[i8];
                                            }
                                            i14 = i16;
                                            i7++;
                                            i10++;
                                        }
                                    } else {
                                        i7 = 0;
                                        while (i10 < intValue2) {
                                            if (i10 >= 9 && (i10 + 2) % 3 != 0) {
                                                if (bzVar.j[i8] != null) {
                                                    int[] iArr = cnVar2.n;
                                                    i13 = i14 + 1;
                                                    int i17 = i7 + 1;
                                                    iArr[i14] = iArr[i14] + bzVar.j[i8][i7];
                                                    int[] iArr2 = bzVar.f;
                                                    iArr2[i8] = iArr2[i8] - bzVar.j[i8][i17 - 1];
                                                    i14 = i13;
                                                    i7 = i17;
                                                } else {
                                                    int[] iArr3 = cnVar2.n;
                                                    i16 = i14 + 1;
                                                    iArr3[i14] = iArr3[i14] + bzVar.f[i8];
                                                    bzVar.f[i8] = 0;
                                                    i14 = i16;
                                                }
                                            }
                                            i10++;
                                        }
                                        int[] iArr4;
                                        if (bzVar.j[i8] != null && i7 < bzVar.j[i8].length) {
                                            iArr4 = cnVar2.n;
                                            iArr4[i14] = iArr4[i14] + bzVar.j[i8][i7];
                                            iArr4 = bzVar.f;
                                            iArr4[i8] = iArr4[i8] - bzVar.j[i8][i7];
                                        } else if (i14 < d) {
                                            iArr4 = cnVar2.n;
                                            iArr4[i14] = iArr4[i14] + bzVar.f[i8];
                                            bzVar.f[i8] = 0;
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                                throw new Error(e);
                            }
                        }
                        i8++;
                        caVar = this;
                    }
                    if (d == 1 && cnVar2.n != null) {
                        cnVar2.n[0] = cnVar2.i;
                    }
                    if (i12 < intValue - 1) {
                        for (i12++; i12 < intValue; i12++) {
                            if (bzVar.f[i12] != 0) {
                                cnVar2.j = true;
                            }
                        }
                    }
                    return cnVar2;
                }
            }
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException unused) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Code-block (t:");
            stringBuilder.append(d);
            stringBuilder.append(", c:");
            stringBuilder.append(i6);
            stringBuilder.append(", r:");
            stringBuilder.append(i10);
            stringBuilder.append(", s:");
            stringBuilder.append(i11);
            stringBuilder.append(", ");
            stringBuilder.append(i7);
            stringBuilder.append("x");
            stringBuilder.append(i8);
            stringBuilder.append(") not found in codestream");
            throw new IllegalArgumentException(stringBuilder.toString());
        } catch (NullPointerException unused2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Code-block (t:");
            stringBuilder.append(d);
            stringBuilder.append(", c:");
            stringBuilder.append(i6);
            stringBuilder.append(", r:");
            stringBuilder.append(i10);
            stringBuilder.append(", s:");
            stringBuilder.append(i11);
            stringBuilder.append(", ");
            stringBuilder.append(i7);
            stringBuilder.append("x");
            stringBuilder.append(i8);
            stringBuilder.append(") not found in bit stream");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
