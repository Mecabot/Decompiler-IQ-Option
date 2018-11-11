package jumio.nv.nfc;

import java.io.EOFException;
import java.io.IOException;
import java.util.Vector;

/* compiled from: FileFormatReader */
public class cr {
    public boolean a;
    private df b;
    private Vector c;
    private Vector d;

    public void a(int i) {
    }

    public void b(int i) {
    }

    public void c(int i) {
    }

    public void d(int i) {
    }

    public cr(df dfVar) {
        this.b = dfVar;
    }

    public void a() {
        try {
            boolean z = false;
            if (this.b.c() == 12 && this.b.c() == 1783636000 && this.b.c() == 218793738) {
                this.a = true;
                if (b()) {
                    Object obj = null;
                    while (!z) {
                        int f;
                        boolean z2;
                        int e = this.b.e();
                        int c = this.b.c();
                        if (e + c == this.b.f()) {
                            z = true;
                        }
                        int c2 = this.b.c();
                        if (c == 0) {
                            f = this.b.f() - this.b.e();
                            z2 = true;
                        } else if (c == 1) {
                            this.b.d();
                            throw new IOException("File too long.");
                        } else {
                            z2 = z;
                            f = c;
                        }
                        switch (c2) {
                            case 1685074537:
                                a(f);
                                break;
                            case 1785737827:
                                if (obj != null) {
                                    b((long) e, f, 0);
                                    break;
                                }
                                throw new Error("Invalid JP2 file: JP2Header box not found before Contiguous codestream box ");
                            case 1785737832:
                                if (obj == null) {
                                    a((long) e, f, 0);
                                    obj = 1;
                                    break;
                                }
                                throw new Error("Invalid JP2 file: Multiple JP2Header boxes found");
                            case 1969843814:
                                d(f);
                                break;
                            case 1970628964:
                                c(f);
                                break;
                            case 2020437024:
                                b(f);
                                break;
                        }
                        if (!z2) {
                            this.b.a(e + f);
                        }
                        z = z2;
                    }
                    if (this.c.size() == 0) {
                        throw new Error("Invalid JP2 file: Contiguous codestream box missing");
                    }
                    return;
                }
                throw new Error("Invalid JP2 file: File Type box missing");
            }
            this.b.a(0);
            if (this.b.a() != (short) -177) {
                throw new Error("File is neither valid JP2 file nor valid JPEG 2000 codestream");
            }
            this.a = false;
            this.b.a(0);
        } catch (EOFException unused) {
            throw new Error("EOF reached before finding Contiguous Codestream Box");
        }
    }

    public boolean b() {
        this.b.e();
        int c = this.b.c();
        if (c == 0) {
            throw new Error("Zero-length of Profile Box");
        } else if (this.b.c() != 1718909296) {
            return false;
        } else {
            if (c == 1) {
                this.b.d();
                throw new IOException("File too long.");
            }
            this.b.c();
            this.b.c();
            Object obj = null;
            for (c = (c - 16) / 4; c > 0; c--) {
                if (this.b.c() == 1785737760) {
                    obj = 1;
                }
            }
            return obj != null;
        }
    }

    public boolean a(long j, int i, long j2) {
        if (i != 0) {
            return true;
        }
        throw new Error("Zero-length of JP2Header Box");
    }

    public boolean b(long j, int i, long j2) {
        int e = this.b.e();
        if (this.c == null) {
            this.c = new Vector();
        }
        this.c.addElement(new Integer(e));
        if (this.d == null) {
            this.d = new Vector();
        }
        this.d.addElement(new Integer(i));
        return true;
    }

    public int c() {
        return ((Integer) this.c.elementAt(0)).intValue();
    }
}
