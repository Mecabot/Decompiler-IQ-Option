package jumio.nv.nfc;

import java.util.Hashtable;

/* compiled from: HeaderInfo */
public class bw implements Cloneable {
    public i a;
    public Hashtable b = new Hashtable();
    public Hashtable c = new Hashtable();
    public Hashtable d = new Hashtable();
    public Hashtable e = new Hashtable();
    public Hashtable f = new Hashtable();
    public Hashtable g = new Hashtable();
    public Hashtable h = new Hashtable();
    public d i;
    public Hashtable j = new Hashtable();
    private int k = 0;

    /* compiled from: HeaderInfo */
    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int[] h = new int[1];
        public int[] i;
    }

    /* compiled from: HeaderInfo */
    public class b implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int[] j = new int[1];
        public int[] k;
    }

    /* compiled from: HeaderInfo */
    public class c {
        public int a;
        public int b;
        public byte[] c;
    }

    /* compiled from: HeaderInfo */
    public class d {
        public int a;
        public int[] b;
        public int[] c;
    }

    /* compiled from: HeaderInfo */
    public class e {
        public int a;
        public int[] b;
        public int[] c;
        public int[] d;
        public int[] e;
        public int[] f;
        public int[] g;
    }

    /* compiled from: HeaderInfo */
    public class f {
        public int a;
        public int b;
        public int c;
        public int[][] d;
        private int f = -1;
        private int g = -1;

        public int a() {
            if (this.f == -1) {
                this.f = this.c & -225;
            }
            return this.f;
        }

        public int b() {
            if (this.g == -1) {
                this.g = (this.c >> 5) & 7;
            }
            return this.g;
        }
    }

    /* compiled from: HeaderInfo */
    public class g {
        public int a;
        public int b;
        public int[][] c;
        private int e = -1;
        private int f = -1;

        public int a() {
            if (this.e == -1) {
                this.e = this.b & -225;
            }
            return this.e;
        }

        public int b() {
            if (this.f == -1) {
                this.f = (this.b >> 5) & 7;
            }
            return this.f;
        }
    }

    /* compiled from: HeaderInfo */
    public class h {
        public int a;
        public int b;
        public int c;
        public int d;
    }

    /* compiled from: HeaderInfo */
    public class i implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int[] l;
        public int[] m;
        public int[] n;
        private int[] p = null;
        private int q = -1;
        private int[] r = null;
        private int s = -1;
        private int t = -1;
        private boolean[] u = null;
        private int[] v = null;

        public int a() {
            if (this.p == null) {
                this.p = new int[this.k];
                for (int i = 0; i < this.k; i++) {
                    this.p[i] = (int) (Math.ceil(((double) this.c) / ((double) this.m[i])) - Math.ceil(((double) this.e) / ((double) this.m[i])));
                }
            }
            if (this.q == -1) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    if (this.p[i2] > this.q) {
                        this.q = this.p[i2];
                    }
                }
            }
            return this.q;
        }

        public int b() {
            if (this.r == null) {
                this.r = new int[this.k];
                for (int i = 0; i < this.k; i++) {
                    this.r[i] = (int) (Math.ceil(((double) this.d) / ((double) this.n[i])) - Math.ceil(((double) this.f) / ((double) this.n[i])));
                }
            }
            if (this.s == -1) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    if (this.r[i2] != this.s) {
                        this.s = this.r[i2];
                    }
                }
            }
            return this.s;
        }

        public int c() {
            if (this.t == -1) {
                this.t = ((((this.c - this.i) + this.g) - 1) / this.g) * ((((this.d - this.j) + this.h) - 1) / this.h);
            }
            return this.t;
        }

        public int a(int i) {
            if (this.v == null) {
                this.v = new int[this.k];
                for (int i2 = 0; i2 < this.k; i2++) {
                    this.v[i2] = (this.l[i2] & 127) + 1;
                }
            }
            return this.v[i];
        }
    }

    /* compiled from: HeaderInfo */
    public class j {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
    }

    public i a() {
        return new i();
    }

    public j b() {
        return new j();
    }

    public b c() {
        return new b();
    }

    public a d() {
        return new a();
    }

    public h e() {
        return new h();
    }

    public g f() {
        return new g();
    }

    public f g() {
        return new f();
    }

    public e h() {
        return new e();
    }

    public d i() {
        return new d();
    }

    public c j() {
        this.k++;
        return new c();
    }
}
