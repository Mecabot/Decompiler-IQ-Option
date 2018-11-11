package com.umoove.all;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressLint({"NewApi"})
/* compiled from: UmooveEngine */
public class g {
    private static boolean d = false;
    private static c ejr = null;
    private static b ejt = null;
    private static g ejw = null;
    private static boolean q = false;
    private static int s = -1;
    private static boolean t = false;
    private SharedPreferences ejq;
    private d ejs;
    private Context eju;
    private h ejv;
    private a ejx;
    private f ejy;
    private e ejz;
    private int g = -1;
    private int h = -1;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private int x;
    private int y;

    /* compiled from: UmooveEngine */
    private class a extends AsyncTask<int[], Void, String> {
        /* renamed from: a */
        protected String doInBackground(int[]... iArr) {
            return "";
        }

        /* renamed from: a */
        protected void onPostExecute(String str) {
        }

        private a() {
        }
    }

    public static g a(Context context, Display display, int i, int i2, float f, float f2, h hVar, int i3) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        } else if (display == null) {
            throw new NullPointerException("Display cannot be null");
        } else if (hVar == null) {
            throw new NullPointerException("UmooveListener cannot be null");
        } else {
            int i4 = i;
            if (i4 >= 1) {
                int i5 = i2;
                if (i5 >= 1) {
                    if (f < 1.0f || f2 < 1.0f) {
                        throw new IllegalArgumentException("FOV value is Illegal");
                    }
                    int i6 = i3;
                    if (i6 < 1000000) {
                        throw new IllegalArgumentException("Key value is Illegal");
                    }
                    if (ejw == null) {
                        ejw = new g(context, display, i4, i5, f, f2, hVar, i6);
                        s = display.getRotation();
                    }
                    return ejw;
                }
            }
            throw new IllegalArgumentException("Frame size value is Illegal");
        }
    }

    g(Context context, Display display, int i, int i2, float f, float f2, h hVar, int i3) {
        int i4;
        int i5;
        IllegalArgumentException illegalArgumentException;
        int[] iArr;
        IllegalAccessException illegalAccessException;
        InvocationTargetException invocationTargetException;
        NoSuchMethodException noSuchMethodException;
        Context context2 = context;
        Display display2 = display;
        int i6 = i;
        int i7 = i2;
        h hVar2 = hVar;
        int i8 = i3;
        if (context2 == null) {
            throw new NullPointerException("Context cannot be null");
        } else if (display2 == null) {
            throw new NullPointerException("Display cannot be null");
        } else if (hVar2 == null) {
            throw new NullPointerException("UmooveListener cannot be null");
        } else if (i6 < 1 || i7 < 1) {
            throw new IllegalArgumentException("Frame size value is Illegal");
        } else if (f < 1.0f || f2 < 1.0f) {
            throw new IllegalArgumentException("FOV value is Illegal");
        } else if (i8 < 1000000) {
            throw new IllegalArgumentException("Key value is Illegal");
        } else {
            this.eju = context2;
            this.ejq = PreferenceManager.getDefaultSharedPreferences(context);
            this.x = i6;
            this.y = i7;
            if (!t) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                int i9 = displayMetrics.widthPixels;
                int i10 = displayMetrics.heightPixels;
                if (VERSION.SDK_INT >= 16) {
                    display2.getRealMetrics(displayMetrics);
                    i9 = displayMetrics.widthPixels;
                    i4 = displayMetrics.heightPixels;
                    i5 = i9;
                } else {
                    try {
                        Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                        int intValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(display2, new Object[0])).intValue();
                        try {
                            i4 = ((Integer) method.invoke(display2, new Object[0])).intValue();
                            i5 = intValue;
                        } catch (IllegalArgumentException e) {
                            illegalArgumentException = e;
                            i9 = intValue;
                            illegalArgumentException.printStackTrace();
                            i5 = i9;
                            i4 = i10;
                            t = true;
                            this.ejv = hVar2;
                            a(display2, i5, i4, i6, i7, f, f2);
                            e();
                            d(i5, i4, i6, i7, i8);
                            iArr = new int[]{i5, i4, i6, i7, i8};
                            new a().execute(new int[][]{iArr});
                        } catch (IllegalAccessException e2) {
                            illegalAccessException = e2;
                            i9 = intValue;
                            illegalAccessException.printStackTrace();
                            i5 = i9;
                            i4 = i10;
                            t = true;
                            this.ejv = hVar2;
                            a(display2, i5, i4, i6, i7, f, f2);
                            e();
                            d(i5, i4, i6, i7, i8);
                            iArr = new int[]{i5, i4, i6, i7, i8};
                            new a().execute(new int[][]{iArr});
                        } catch (InvocationTargetException e3) {
                            invocationTargetException = e3;
                            i9 = intValue;
                            invocationTargetException.printStackTrace();
                            i5 = i9;
                            i4 = i10;
                            t = true;
                            this.ejv = hVar2;
                            a(display2, i5, i4, i6, i7, f, f2);
                            e();
                            d(i5, i4, i6, i7, i8);
                            iArr = new int[]{i5, i4, i6, i7, i8};
                            new a().execute(new int[][]{iArr});
                        } catch (NoSuchMethodException e4) {
                            noSuchMethodException = e4;
                            i9 = intValue;
                            noSuchMethodException.printStackTrace();
                            i5 = i9;
                            i4 = i10;
                            t = true;
                            this.ejv = hVar2;
                            a(display2, i5, i4, i6, i7, f, f2);
                            e();
                            d(i5, i4, i6, i7, i8);
                            iArr = new int[]{i5, i4, i6, i7, i8};
                            new a().execute(new int[][]{iArr});
                        }
                    } catch (IllegalArgumentException e5) {
                        illegalArgumentException = e5;
                        illegalArgumentException.printStackTrace();
                        i5 = i9;
                        i4 = i10;
                        t = true;
                        this.ejv = hVar2;
                        a(display2, i5, i4, i6, i7, f, f2);
                        e();
                        d(i5, i4, i6, i7, i8);
                        iArr = new int[]{i5, i4, i6, i7, i8};
                        new a().execute(new int[][]{iArr});
                    } catch (IllegalAccessException e22) {
                        illegalAccessException = e22;
                        illegalAccessException.printStackTrace();
                        i5 = i9;
                        i4 = i10;
                        t = true;
                        this.ejv = hVar2;
                        a(display2, i5, i4, i6, i7, f, f2);
                        e();
                        d(i5, i4, i6, i7, i8);
                        iArr = new int[]{i5, i4, i6, i7, i8};
                        new a().execute(new int[][]{iArr});
                    } catch (InvocationTargetException e32) {
                        invocationTargetException = e32;
                        invocationTargetException.printStackTrace();
                        i5 = i9;
                        i4 = i10;
                        t = true;
                        this.ejv = hVar2;
                        a(display2, i5, i4, i6, i7, f, f2);
                        e();
                        d(i5, i4, i6, i7, i8);
                        iArr = new int[]{i5, i4, i6, i7, i8};
                        new a().execute(new int[][]{iArr});
                    } catch (NoSuchMethodException e42) {
                        noSuchMethodException = e42;
                        noSuchMethodException.printStackTrace();
                        i5 = i9;
                        i4 = i10;
                        t = true;
                        this.ejv = hVar2;
                        a(display2, i5, i4, i6, i7, f, f2);
                        e();
                        d(i5, i4, i6, i7, i8);
                        iArr = new int[]{i5, i4, i6, i7, i8};
                        new a().execute(new int[][]{iArr});
                    }
                }
                t = true;
                this.ejv = hVar2;
                a(display2, i5, i4, i6, i7, f, f2);
                e();
                d(i5, i4, i6, i7, i8);
                iArr = new int[]{i5, i4, i6, i7, i8};
                new a().execute(new int[][]{iArr});
            }
        }
    }

    private void d(int i, int i2, int i3, int i4, int i5) {
        ejr.a(this, i3, i4);
        e(i, i2, i3, i4, i5);
        d = true;
        t = false;
        this.h = 0;
        this.g = 0;
    }

    private void e() {
        ejr = new c(80);
        ejr.start();
    }

    private void a(Display display, int i, int i2, int i3, int i4, float f, float f2) {
        ejt = new b(this.eju, display, i, i2, i3, i4, f, f2);
        ejt.a();
    }

    public void a(int i) {
        ejt.a(i);
        if (i != 0) {
            b();
            a();
            this.h = 0;
            this.g = 0;
            s = (s + i) % 4;
        }
    }

    private void e(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        d dVar = new d(0);
        dVar.a = i3;
        dVar.b = i4;
        if (i6 > i7) {
            dVar.c = i7;
            dVar.d = i6;
        } else {
            dVar.c = i6;
            dVar.d = i7;
        }
        dVar.g = ejt.aTo();
        dVar.h = ejt.aTp();
        dVar.o = ejt.aTq();
        dVar.i = (s + ejt.c()) % 4;
        dVar.j = ejt.b();
        dVar.ejf = (double) ejt.aTm();
        dVar.ejg = (double) ejt.aTn();
        dVar.m = this.ejq.getFloat("driftFixX", 0.0f);
        dVar.n = this.ejq.getFloat("driftFixY", 0.0f);
        dVar.p = i5;
        UMNativeCore.InitNative(dVar.a, dVar.b, dVar.c, dVar.d, dVar.o, dVar.e, dVar.f, dVar.g, dVar.h, dVar.i, dVar.ejf, dVar.ejg, dVar.m, dVar.n, dVar.p);
    }

    public void l(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("Data byte array cannot be null");
        } else if (bArr.length < this.x * this.y) {
            throw new ArrayIndexOutOfBoundsException("Data byte array out of bounds");
        } else if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Orientation value is Illegal");
        } else {
            i = (i + ejt.c()) % 4;
            if (i != s) {
                b();
                a();
                this.h = 0;
                this.g = 0;
                this.ejv.a(3);
                s = i;
            }
            if (d) {
                ejr.l(bArr, i);
            }
        }
    }

    void f(float[] fArr) {
        this.h = (int) fArr[1];
        int i = this.h;
        if (i == 0) {
            if (this.g == 2 || this.g == 3) {
                this.ejv.a(2);
            }
            if (this.g == 4) {
                this.ejv.a(3);
            }
        } else if (i == 2) {
            this.ejv.a(2);
        } else if (i == 4 && q) {
            if (this.h != this.g) {
                this.ejv.a(1);
            }
            this.ejy = new f();
            this.ejz = new e();
            this.ejx = new a();
            this.ejx.eiX = new PointF(fArr[10], fArr[11]);
            this.ejx.eiY = new PointF(fArr[13], fArr[14]);
            this.ejx.c = (int) fArr[12];
            if (this.m) {
                this.ejy.eiX.x = fArr[20];
                this.ejy.eiX.y = fArr[21];
            }
            if (this.n) {
                this.ejy.eiY.x = fArr[22];
                this.ejy.eiY.y = fArr[23];
            }
            if (this.j) {
                this.ejz.ejn.x = fArr[32];
                this.ejz.ejn.y = fArr[33];
                this.ejz.ejo.x = fArr[34];
                this.ejz.ejo.y = fArr[35];
            }
            if (this.k) {
                this.ejz.ejl.x = fArr[24];
                this.ejz.ejl.y = fArr[25];
                this.ejz.ejm.x = fArr[26];
                this.ejz.ejm.y = fArr[27];
                this.ejz.g = fArr[55];
                this.ejz.a = (int) fArr[36];
                this.ejz.b = (int) fArr[37];
            }
            if (this.j || this.k) {
                this.ejz.ejj.x = fArr[56];
                this.ejz.ejj.y = fArr[57];
                this.ejz.ejk.x = fArr[58];
                this.ejz.ejk.y = fArr[59];
            }
            if (this.o) {
                this.ejz.j = (int) fArr[38];
                this.ejz.ejp.x = fArr[52];
                this.ejz.ejp.y = fArr[53];
            }
            if (this.l) {
                this.ejv.b((int) fArr[40]);
            }
            this.ejz.l = fArr[60];
            this.ejz.m = fArr[61];
            this.ejv.a(d(), this.ejy, this.ejz);
        }
        this.g = this.h;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b(boolean z) {
        this.j = z;
        if (z) {
            this.ejs = new d(10);
            ejr.a(this.ejs);
        }
    }

    public void c(boolean z) {
        this.k = z;
        if (z) {
            this.ejs = new d(10);
            ejr.a(this.ejs);
        }
    }

    public void d(boolean z) {
        this.o = z;
        if (z) {
            this.ejs = new d(7);
            ejr.a(this.ejs);
        }
    }

    public void e(boolean z) {
        this.p = z;
        if (d) {
            this.ejs = new d(2);
            this.ejs.q = this.p;
            ejr.a(this.ejs);
            this.g = 2;
            q = true;
        }
    }

    public void a() {
        this.ejs = new d(1);
        ejr.a(this.ejs);
    }

    public void b() {
        q = false;
        if (ejr != null) {
            this.ejs = new d(3);
            ejr.a(this.ejs);
        }
    }

    public void c() {
        d = false;
        this.eju = null;
        ejr = null;
        ejt = null;
        ejw = null;
    }

    public int d() {
        if (!q && this.h == 4) {
            return 5;
        }
        if (this.h == 3) {
            return 2;
        }
        return this.h;
    }

    public void a(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("displayWindowWidth value is Illegal");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("displayWindowHeight value is Illegal");
        } else {
            d dVar = new d(4);
            dVar.c = i;
            dVar.d = i2;
            ejr.a(dVar);
        }
    }
}
