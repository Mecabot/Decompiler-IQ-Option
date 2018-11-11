package jumio.nv.nfc;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Vector;
import jumio.nv.nfc.bw.a;
import jumio.nv.nfc.bw.b;
import jumio.nv.nfc.bw.c;
import jumio.nv.nfc.bw.d;
import jumio.nv.nfc.bw.f;
import jumio.nv.nfc.bw.g;
import jumio.nv.nfc.bw.h;
import jumio.nv.nfc.bw.i;

/* compiled from: HeaderDecoder */
public class cb {
    private static final String[][] e = ((String[][]) null);
    public int[] a;
    boolean b;
    public int c;
    public Vector d;
    private bw f;
    private String g = "";
    private int h;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int[][] o = ((int[][]) null);
    private Hashtable p = null;
    private int q;
    private int r = -1;
    private int s = -1;
    private cg t;
    private byte[][] u;
    private byte[][][][] v;
    private ByteArrayOutputStream[] w;

    public int a() {
        return this.f.a.b();
    }

    public int b() {
        return this.f.a.a();
    }

    public final int c() {
        return this.f.a.c - this.f.a.e;
    }

    public final int d() {
        return this.f.a.d - this.f.a.f;
    }

    public final int e() {
        return this.f.a.e;
    }

    public final int f() {
        return this.f.a.f;
    }

    public final int g() {
        return this.f.a.g;
    }

    public final int h() {
        return this.f.a.h;
    }

    public final cu a(cu cuVar) {
        if (cuVar == null) {
            return new cu(this.f.a.i, this.f.a.j);
        }
        cuVar.a = this.f.a.i;
        cuVar.b = this.f.a.j;
        return cuVar;
    }

    public final int a(int i) {
        return this.f.a.a(i);
    }

    public final int i() {
        return this.q;
    }

    public final int b(int i) {
        return this.f.a.m[i];
    }

    public final int c(int i) {
        return this.f.a.n[i];
    }

    public final dk a(dj djVar, int[] iArr, cg cgVar) {
        return new dm(djVar, iArr, cgVar);
    }

    public final int j() {
        return this.r;
    }

    public final int k() {
        return this.s;
    }

    public final boolean l() {
        return this.b;
    }

    private eh a(DataInputStream dataInputStream, int[] iArr) {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        iArr[0] = readUnsignedByte;
        if (readUnsignedByte >= 128) {
            throw new bs("Custom filters not supported");
        }
        switch (readUnsignedByte) {
            case 0:
                return new ej();
            case 1:
                return new el();
            default:
                throw new bv("Specified wavelet filter not JPEG 2000 part I compliant");
        }
    }

    public void a(DataInputStream dataInputStream, String str) {
        dataInputStream.available();
    }

    private void a(DataInputStream dataInputStream) {
        i a = this.f.a();
        this.f.a = a;
        a.a = dataInputStream.readUnsignedShort();
        a.b = dataInputStream.readUnsignedShort();
        if (a.b > 2) {
            throw new Error("Codestream capabiities not JPEG 2000 - Part I compliant");
        }
        a.c = dataInputStream.readInt();
        a.d = dataInputStream.readInt();
        if (a.c <= 0 || a.d <= 0) {
            throw new IOException("JJ2000 does not support images whose width and/or height not in the range: 1 -- (2^31)-1");
        }
        a.e = dataInputStream.readInt();
        a.f = dataInputStream.readInt();
        if (a.e < 0 || a.f < 0) {
            throw new IOException("JJ2000 does not support images offset not in the range: 0 -- (2^31)-1");
        }
        a.g = dataInputStream.readInt();
        a.h = dataInputStream.readInt();
        if (a.g <= 0 || a.h <= 0) {
            throw new IOException("JJ2000 does not support tiles whose width and/or height are not in  the range: 1 -- (2^31)-1");
        }
        a.i = dataInputStream.readInt();
        a.j = dataInputStream.readInt();
        if (a.i < 0 || a.j < 0) {
            throw new IOException("JJ2000 does not support tiles whose offset is not in  the range: 0 -- (2^31)-1");
        }
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        a.k = readUnsignedShort;
        this.q = readUnsignedShort;
        if (this.q < 1 || this.q > 16384) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Number of component out of range 1--16384: ");
            stringBuilder.append(this.q);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        a.l = new int[this.q];
        a.m = new int[this.q];
        a.n = new int[this.q];
        for (readUnsignedShort = 0; readUnsignedShort < this.q; readUnsignedShort++) {
            a.l[readUnsignedShort] = dataInputStream.readUnsignedByte();
            a.m[readUnsignedShort] = dataInputStream.readUnsignedByte();
            a.n[readUnsignedShort] = dataInputStream.readUnsignedByte();
        }
        a(dataInputStream, "SIZ marker");
        this.h = a.c();
        this.t = new cg(this.h, this.q);
    }

    private void b(DataInputStream dataInputStream) {
        d i = this.f.i();
        this.f.i = i;
        i.a = dataInputStream.readUnsignedShort();
        i.b = new int[this.q];
        i.c = new int[this.q];
        for (int i2 = 0; i2 < this.q; i2++) {
            i.b[i2] = dataInputStream.readUnsignedShort();
            i.c[i2] = dataInputStream.readUnsignedShort();
        }
        a(dataInputStream, "CRG marker");
    }

    private void a(DataInputStream dataInputStream, boolean z, int i, int i2) {
        c j = this.f.j();
        j.a = dataInputStream.readUnsignedShort();
        j.b = dataInputStream.readUnsignedShort();
        if (j.b != 1) {
            dataInputStream.skipBytes(j.a - 4);
        } else {
            j.c = new byte[(j.a - 4)];
            for (int i3 = 0; i3 < j.a - 4; i3++) {
                j.c[i3] = dataInputStream.readByte();
            }
        }
        Hashtable hashtable;
        if (z) {
            hashtable = this.f.j;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("main_");
            stringBuilder.append(i2);
            hashtable.put(stringBuilder.toString(), j);
        } else {
            hashtable = this.f.j;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("t");
            stringBuilder2.append(i);
            stringBuilder2.append("_");
            stringBuilder2.append(i2);
            hashtable.put(stringBuilder2.toString(), j);
        }
        a(dataInputStream, "COM marker");
    }

    private void b(DataInputStream dataInputStream, boolean z, int i, int i2) {
        int i3 = i;
        float[][] fArr = (float[][]) null;
        g f = this.f.f();
        f.a = dataInputStream.readUnsignedShort();
        f.b = dataInputStream.readUnsignedByte();
        int b = f.b();
        int a = f.a();
        if (z) {
            this.f.f.put("main", f);
            switch (a) {
                case 0:
                    this.t.c.a("reversible");
                    break;
                case 1:
                    this.t.c.a("derived");
                    break;
                case 2:
                    this.t.c.a("expounded");
                    break;
                default:
                    throw new bv("Unknown or unsupported quantization style in Sqcd field, QCD marker main header");
            }
        }
        Hashtable hashtable = this.f.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("t");
        stringBuilder.append(i3);
        hashtable.put(stringBuilder.toString(), f);
        switch (a) {
            case 0:
                this.t.c.b(i3, (Object) "reversible");
                break;
            case 1:
                this.t.c.b(i3, (Object) "derived");
                break;
            case 2:
                this.t.c.b(i3, (Object) "expounded");
                break;
            default:
                throw new bv("Unknown or unsupported quantization style in Sqcd field, QCD marker, tile header");
        }
        dn dnVar = new dn();
        int i4;
        int[][] iArr;
        int i5;
        if (a == 0) {
            if (z) {
                a = ((Integer) this.t.g.b()).intValue();
            } else {
                a = ((Integer) this.t.g.d(i3)).intValue();
            }
            i4 = a + 1;
            iArr = new int[i4][];
            dnVar.a = iArr;
            f.c = (int[][]) Array.newInstance(int.class, new int[]{i4, 4});
            for (i5 = 0; i5 <= a; i5++) {
                int i6;
                if (i5 == 0) {
                    i4 = 1;
                    i6 = 0;
                } else {
                    i4 = a - i5;
                    i4 = 1 > i4 ? 1 - i4 : 1;
                    i6 = 1 << ((i4 - 1) << 1);
                    i4 = 1 << (i4 << 1);
                }
                iArr[i5] = new int[i4];
                for (i6 = 
/*
Method generation error in method: jumio.nv.nfc.cb.b(java.io.DataInputStream, boolean, int, int):void, dex: classes3.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r12_4 'i6' int) = (r12_0 'i6' int), (r12_3 'i6' int) binds: {(r12_0 'i6' int)=B:24:0x00d7, (r12_3 'i6' int)=B:29:0x00e2} in method: jumio.nv.nfc.cb.b(java.io.DataInputStream, boolean, int, int):void, dex: classes3.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:189)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 25 more

*/

    private void c(DataInputStream dataInputStream, boolean z, int i, int i2) {
        int readUnsignedByte;
        int i3 = i;
        float[][] fArr = (float[][]) null;
        f g = this.f.g();
        g.a = dataInputStream.readUnsignedShort();
        if (this.q < InputDeviceCompat.SOURCE_KEYBOARD) {
            readUnsignedByte = dataInputStream.readUnsignedByte();
            g.b = readUnsignedByte;
        } else {
            readUnsignedByte = dataInputStream.readUnsignedShort();
            g.b = readUnsignedByte;
        }
        if (readUnsignedByte >= this.q) {
            throw new bv("Invalid component index in QCC marker");
        }
        g.c = dataInputStream.readUnsignedByte();
        int b = g.b();
        int a = g.a();
        Hashtable hashtable;
        StringBuilder stringBuilder;
        if (z) {
            hashtable = this.f.g;
            stringBuilder = new StringBuilder();
            stringBuilder.append("main_c");
            stringBuilder.append(readUnsignedByte);
            hashtable.put(stringBuilder.toString(), g);
            switch (a) {
                case 0:
                    this.t.c.a(readUnsignedByte, (Object) "reversible");
                    break;
                case 1:
                    this.t.c.a(readUnsignedByte, (Object) "derived");
                    break;
                case 2:
                    this.t.c.a(readUnsignedByte, (Object) "expounded");
                    break;
                default:
                    throw new bv("Unknown or unsupported quantization style in Sqcd field, QCD marker, main header");
            }
        }
        hashtable = this.f.g;
        stringBuilder = new StringBuilder();
        stringBuilder.append("t");
        stringBuilder.append(i3);
        stringBuilder.append("_c");
        stringBuilder.append(readUnsignedByte);
        hashtable.put(stringBuilder.toString(), g);
        switch (a) {
            case 0:
                this.t.c.a(i3, readUnsignedByte, "reversible");
                break;
            case 1:
                this.t.c.a(i3, readUnsignedByte, "derived");
                break;
            case 2:
                this.t.c.a(i3, readUnsignedByte, "expounded");
                break;
            default:
                throw new bv("Unknown or unsupported quantization style in Sqcd field, QCD marker, main header");
        }
        dn dnVar = new dn();
        int i4;
        int i5;
        if (a == 0) {
            if (z) {
                a = ((Integer) this.t.g.c(readUnsignedByte)).intValue();
            } else {
                a = ((Integer) this.t.g.a(i3, readUnsignedByte)).intValue();
            }
            i4 = a + 1;
            int[][] iArr = new int[i4][];
            dnVar.a = iArr;
            g.d = (int[][]) Array.newInstance(int.class, new int[]{i4, 4});
            for (i5 = 0; i5 <= a; i5++) {
                int i6;
                if (i5 == 0) {
                    i4 = 1;
                    i6 = 0;
                } else {
                    i4 = a - i5;
                    i4 = 1 > i4 ? 1 - i4 : 1;
                    i6 = 1 << ((i4 - 1) << 1);
                    i4 = 1 << (i4 << 1);
                }
                iArr[i5] = new int[i4];
                for (i6 = 
/*
Method generation error in method: jumio.nv.nfc.cb.c(java.io.DataInputStream, boolean, int, int):void, dex: classes3.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r13_4 'i6' int) = (r13_0 'i6' int), (r13_3 'i6' int) binds: {(r13_0 'i6' int)=B:32:0x010c, (r13_3 'i6' int)=B:37:0x0117} in method: jumio.nv.nfc.cb.c(java.io.DataInputStream, boolean, int, int):void, dex: classes3.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:189)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 29 more

*/

    private void d(DataInputStream dataInputStream, boolean z, int i, int i2) {
        b c = this.f.c();
        c.a = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        c.b = readUnsignedByte;
        if ((readUnsignedByte & 1) != 0) {
            this.b = true;
            readUnsignedByte &= -2;
        } else {
            this.b = false;
        }
        if (z) {
            this.f.c.put("main", c);
            if ((readUnsignedByte & 2) != 0) {
                this.t.o.a(new Boolean("true"));
                readUnsignedByte &= -3;
            } else {
                this.t.o.a(new Boolean("false"));
            }
        } else {
            Hashtable hashtable = this.f.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("t");
            stringBuilder.append(i);
            hashtable.put(stringBuilder.toString(), c);
            if ((readUnsignedByte & 2) != 0) {
                this.t.o.b(i, new Boolean("true"));
                readUnsignedByte &= -3;
            } else {
                this.t.o.b(i, new Boolean("false"));
            }
        }
        if (z) {
            if ((readUnsignedByte & 4) != 0) {
                this.t.p.a(new Boolean("true"));
                readUnsignedByte &= -5;
            } else {
                this.t.p.a(new Boolean("false"));
            }
        } else if ((readUnsignedByte & 4) != 0) {
            this.t.p.b(i, new Boolean("true"));
            readUnsignedByte &= -5;
        } else {
            this.t.p.b(i, new Boolean("false"));
        }
        if ((readUnsignedByte & 8) != 0) {
            if (this.r == -1 || this.r != 0) {
                this.r = 1;
                readUnsignedByte &= -9;
            } else {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
        } else if (this.r == -1 || this.r != 1) {
            this.r = 0;
        } else {
            throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
        }
        if ((readUnsignedByte & 16) != 0) {
            if (this.s == -1 || this.s != 0) {
                this.s = 1;
            } else {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
        } else if (this.s == -1 || this.s != 1) {
            this.s = 0;
        } else {
            throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
        }
        c.c = dataInputStream.readUnsignedByte();
        c.d = dataInputStream.readUnsignedShort();
        if (c.d <= 0 || c.d > SupportMenu.USER_MASK) {
            throw new bv("Number of layers out of range: 1--65535");
        }
        c.e = dataInputStream.readUnsignedByte();
        readUnsignedByte = dataInputStream.readUnsignedByte();
        c.f = readUnsignedByte;
        if (readUnsignedByte > 32) {
            throw new bv("Number of decomposition levels out of range: 0--32");
        }
        r4 = new Integer[2];
        c.g = dataInputStream.readUnsignedByte();
        r4[0] = new Integer(1 << (c.g + 2));
        if (r4[0].intValue() < 4 || r4[0].intValue() > 1024) {
            throw new bv("Non-valid code-block width in SPcod field, COD marker");
        }
        c.h = dataInputStream.readUnsignedByte();
        r4[1] = new Integer(1 << (c.h + 2));
        if (r4[1].intValue() < 4 || r4[1].intValue() > 1024) {
            throw new bv("Non-valid code-block height in SPcod field, COD marker");
        } else if (r4[0].intValue() * r4[1].intValue() > 4096) {
            throw new bv("Non-valid code-block area in SPcod field, COD marker");
        } else {
            if (z) {
                this.t.q.a(r4);
            } else {
                this.t.q.b(i, r4);
            }
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            c.i = readUnsignedByte2;
            if ((readUnsignedByte2 & -64) != 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unknown \"code-block style\" in SPcod field, COD marker: 0x");
                stringBuilder2.append(Integer.toHexString(readUnsignedByte2));
                throw new bv(stringBuilder2.toString());
            }
            eh[] ehVarArr = new eh[]{a(dataInputStream, c.j)};
            ehVarArr[0] = new eh[1][0];
            Object obj = new eh[][]{r5, ehVarArr};
            Object obj2 = new Vector[]{new Vector(), new Vector()};
            if (this.b) {
                c.k = new int[(readUnsignedByte + 1)];
                for (int i3 = readUnsignedByte; i3 >= 0; i3--) {
                    int[] iArr = c.k;
                    int i4 = readUnsignedByte - i3;
                    int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                    iArr[i4] = readUnsignedByte3;
                    obj2[0].insertElementAt(new Integer(1 << (readUnsignedByte3 & 15)), 0);
                    obj2[1].insertElementAt(new Integer(1 << ((readUnsignedByte3 & 240) >> 4)), 0);
                }
            } else {
                obj2[0].addElement(new Integer(32768));
                obj2[1].addElement(new Integer(32768));
            }
            if (z) {
                this.t.n.a(obj2);
            } else {
                this.t.n.b(i, obj2);
            }
            this.b = true;
            a(dataInputStream, "COD marker");
            if (z) {
                this.t.f.a(obj);
                this.t.g.a(new Integer(readUnsignedByte));
                this.t.j.a(new Integer(readUnsignedByte2));
                this.t.k.a(new Integer(c.e));
                this.t.h.a(new Integer(c.d));
                this.t.i.a(new Integer(c.c));
                return;
            }
            this.t.f.b(i, obj);
            this.t.g.b(i, (Object) new Integer(readUnsignedByte));
            this.t.j.b(i, new Integer(readUnsignedByte2));
            this.t.k.b(i, (Object) new Integer(c.e));
            this.t.h.b(i, (Object) new Integer(c.d));
            this.t.i.b(i, (Object) new Integer(c.c));
        }
    }

    private void e(DataInputStream dataInputStream, boolean z, int i, int i2) {
        int readUnsignedByte;
        DataInputStream dataInputStream2 = dataInputStream;
        int i3 = i;
        a d = this.f.d();
        d.a = dataInputStream.readUnsignedShort();
        if (this.q < InputDeviceCompat.SOURCE_KEYBOARD) {
            readUnsignedByte = dataInputStream.readUnsignedByte();
            d.b = readUnsignedByte;
        } else {
            readUnsignedByte = dataInputStream.readUnsignedShort();
            d.b = readUnsignedByte;
        }
        if (readUnsignedByte >= this.q) {
            throw new bv("Invalid component index in QCC marker");
        }
        int readUnsignedByte2 = dataInputStream.readUnsignedByte();
        d.c = readUnsignedByte2;
        if ((readUnsignedByte2 & 1) != 0) {
            this.b = true;
        } else {
            this.b = false;
        }
        readUnsignedByte2 = dataInputStream.readUnsignedByte();
        d.d = readUnsignedByte2;
        r10 = new Integer[2];
        d.e = dataInputStream.readUnsignedByte();
        r10[0] = new Integer(1 << (d.e + 2));
        if (r10[0].intValue() < 4 || r10[0].intValue() > 1024) {
            throw new bv("Non-valid code-block width in SPcod field, COC marker");
        }
        d.f = dataInputStream.readUnsignedByte();
        r10[1] = new Integer(1 << (d.f + 2));
        if (r10[1].intValue() < 4 || r10[1].intValue() > 1024) {
            throw new bv("Non-valid code-block height in SPcod field, COC marker");
        } else if (r10[0].intValue() * r10[1].intValue() > 4096) {
            throw new bv("Non-valid code-block area in SPcod field, COC marker");
        } else {
            if (z) {
                this.t.q.a(readUnsignedByte, r10);
            } else {
                this.t.q.a(i3, readUnsignedByte, r10);
            }
            int readUnsignedByte3 = dataInputStream.readUnsignedByte();
            d.g = readUnsignedByte3;
            StringBuilder stringBuilder;
            if ((readUnsignedByte3 & -64) != 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown \"code-block context\" in SPcoc field, COC marker: 0x");
                stringBuilder.append(Integer.toHexString(readUnsignedByte3));
                throw new bv(stringBuilder.toString());
            }
            eh[] ehVarArr = new eh[]{a(dataInputStream2, d.h)};
            ehVarArr[0] = new eh[1][0];
            Object obj = new eh[][]{r11, ehVarArr};
            Object obj2 = new Vector[]{new Vector(), new Vector()};
            if (this.b) {
                d.i = new int[(readUnsignedByte2 + 1)];
                for (int i4 = readUnsignedByte2; i4 >= 0; i4--) {
                    int[] iArr = d.i;
                    int readUnsignedByte4 = dataInputStream.readUnsignedByte();
                    iArr[i4] = readUnsignedByte4;
                    obj2[0].insertElementAt(new Integer(1 << (readUnsignedByte4 & 15)), 0);
                    obj2[1].insertElementAt(new Integer(1 << ((readUnsignedByte4 & 240) >> 4)), 0);
                }
            } else {
                obj2[0].addElement(new Integer(32768));
                obj2[1].addElement(new Integer(32768));
            }
            if (z) {
                this.t.n.a(readUnsignedByte, obj2);
            } else {
                this.t.n.a(i3, readUnsignedByte, obj2);
            }
            this.b = true;
            a(dataInputStream2, "COD marker");
            Hashtable hashtable;
            if (z) {
                hashtable = this.f.d;
                stringBuilder = new StringBuilder();
                stringBuilder.append("main_c");
                stringBuilder.append(readUnsignedByte);
                hashtable.put(stringBuilder.toString(), d);
                this.t.f.a(readUnsignedByte, obj);
                this.t.g.a(readUnsignedByte, (Object) new Integer(readUnsignedByte2));
                this.t.j.a(readUnsignedByte, new Integer(readUnsignedByte3));
                return;
            }
            hashtable = this.f.d;
            stringBuilder = new StringBuilder();
            stringBuilder.append("t");
            stringBuilder.append(i3);
            stringBuilder.append("_c");
            stringBuilder.append(readUnsignedByte);
            hashtable.put(stringBuilder.toString(), d);
            this.t.f.a(i3, readUnsignedByte, obj);
            this.t.g.a(i3, readUnsignedByte, new Integer(readUnsignedByte2));
            this.t.j.a(i3, readUnsignedByte, new Integer(readUnsignedByte3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01f0  */
    private void f(java.io.DataInputStream r19, boolean r20, int r21, int r22) {
        /*
        r18 = this;
        r0 = r18;
        r2 = r21;
        r3 = r22;
        r4 = r0.q;
        r7 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r4 < r7) goto L_0x000e;
    L_0x000c:
        r4 = 1;
        goto L_0x000f;
    L_0x000e:
        r4 = 0;
    L_0x000f:
        if (r20 != 0) goto L_0x004c;
    L_0x0011:
        r7 = r0.f;
        r7 = r7.h;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "t";
        r8.append(r9);
        r8.append(r2);
        r8 = r8.toString();
        r7 = r7.get(r8);
        if (r7 != 0) goto L_0x002d;
    L_0x002c:
        goto L_0x004c;
    L_0x002d:
        r7 = r0.f;
        r7 = r7.h;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "t";
        r8.append(r9);
        r8.append(r2);
        r8 = r8.toString();
        r7 = r7.get(r8);
        r7 = (jumio.nv.nfc.bw.e) r7;
        r8 = r7.b;
        r8 = r8.length;
        goto L_0x0053;
    L_0x004c:
        r7 = r0.f;
        r7 = r7.h();
        r8 = 0;
    L_0x0053:
        r9 = r19.readUnsignedShort();
        r7.a = r9;
        r9 = r7.a;
        r10 = 2;
        r9 = r9 - r10;
        if (r4 == 0) goto L_0x0061;
    L_0x005f:
        r12 = 4;
        goto L_0x0062;
    L_0x0061:
        r12 = 2;
    L_0x0062:
        r13 = 5;
        r12 = r12 + r13;
        r9 = r9 / r12;
        r12 = r8 + r9;
        r14 = 6;
        if (r8 == 0) goto L_0x00cb;
    L_0x006a:
        r9 = new int[]{r12, r14};
        r14 = int.class;
        r9 = java.lang.reflect.Array.newInstance(r14, r9);
        r9 = (int[][]) r9;
        r14 = new int[r12];
        r15 = new int[r12];
        r13 = new int[r12];
        r11 = new int[r12];
        r10 = new int[r12];
        r6 = new int[r12];
        r5 = r0.t;
        r5 = r5.l;
        r5 = r5.d(r2);
        r5 = (int[][]) r5;
        r1 = 0;
    L_0x008d:
        if (r1 >= r8) goto L_0x00be;
    L_0x008f:
        r16 = r5[r1];
        r9[r1] = r16;
        r17 = r5;
        r5 = r7.b;
        r5 = r5[r1];
        r14[r1] = r5;
        r5 = r7.c;
        r5 = r5[r1];
        r15[r1] = r5;
        r5 = r7.d;
        r5 = r5[r1];
        r13[r1] = r5;
        r5 = r7.e;
        r5 = r5[r1];
        r11[r1] = r5;
        r5 = r7.f;
        r5 = r5[r1];
        r10[r1] = r5;
        r5 = r7.g;
        r5 = r5[r1];
        r6[r1] = r5;
        r1 = r1 + 1;
        r5 = r17;
        goto L_0x008d;
    L_0x00be:
        r7.b = r14;
        r7.c = r15;
        r7.d = r13;
        r7.e = r11;
        r7.f = r10;
        r7.g = r6;
        goto L_0x00f0;
    L_0x00cb:
        r1 = new int[]{r9, r14};
        r5 = int.class;
        r1 = java.lang.reflect.Array.newInstance(r5, r1);
        r1 = (int[][]) r1;
        r5 = new int[r9];
        r7.b = r5;
        r5 = new int[r9];
        r7.c = r5;
        r5 = new int[r9];
        r7.d = r5;
        r5 = new int[r9];
        r7.e = r5;
        r5 = new int[r9];
        r7.f = r5;
        r5 = new int[r9];
        r7.g = r5;
        r9 = r1;
    L_0x00f0:
        if (r8 >= r12) goto L_0x01e7;
    L_0x00f2:
        r1 = r9[r8];
        r5 = r7.b;
        r6 = r19.readUnsignedByte();
        r5[r8] = r6;
        r5 = 0;
        r1[r5] = r6;
        if (r4 == 0) goto L_0x010f;
    L_0x0101:
        r1 = r9[r8];
        r5 = r7.c;
        r6 = r19.readUnsignedShort();
        r5[r8] = r6;
        r5 = 1;
        r1[r5] = r6;
        goto L_0x011c;
    L_0x010f:
        r5 = 1;
        r1 = r9[r8];
        r6 = r7.c;
        r10 = r19.readUnsignedByte();
        r6[r8] = r10;
        r1[r5] = r10;
    L_0x011c:
        r1 = r9[r8];
        r6 = r7.d;
        r10 = r19.readUnsignedShort();
        r6[r8] = r10;
        r6 = 2;
        r1[r6] = r10;
        r1 = r9[r8];
        r1 = r1[r6];
        if (r1 >= r5) goto L_0x014e;
    L_0x012f:
        r1 = new jumio.nv.nfc.bv;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "LYEpoc value must be greater than 1 in POC marker segment of tile ";
        r4.append(r5);
        r4.append(r2);
        r2 = ", tile-part ";
        r4.append(r2);
        r4.append(r3);
        r2 = r4.toString();
        r1.<init>(r2);
        throw r1;
    L_0x014e:
        r1 = r9[r8];
        r5 = r7.e;
        r10 = r19.readUnsignedByte();
        r5[r8] = r10;
        r5 = 3;
        r1[r5] = r10;
        r1 = r9[r8];
        r1 = r1[r5];
        r5 = r9[r8];
        r10 = 0;
        r5 = r5[r10];
        if (r1 > r5) goto L_0x0185;
    L_0x0166:
        r1 = new jumio.nv.nfc.bv;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "REpoc value must be greater than RSpoc in POC marker segment of tile ";
        r4.append(r5);
        r4.append(r2);
        r2 = ", tile-part ";
        r4.append(r2);
        r4.append(r3);
        r2 = r4.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0185:
        if (r4 == 0) goto L_0x0196;
    L_0x0187:
        r1 = r9[r8];
        r5 = r7.f;
        r10 = r19.readUnsignedShort();
        r5[r8] = r10;
        r5 = 4;
        r1[r5] = r10;
        r11 = 0;
        goto L_0x01ac;
    L_0x0196:
        r5 = 4;
        r1 = r7.f;
        r10 = r19.readUnsignedByte();
        r1[r8] = r10;
        if (r10 != 0) goto L_0x01a7;
    L_0x01a1:
        r1 = r9[r8];
        r11 = 0;
        r1[r5] = r11;
        goto L_0x01ac;
    L_0x01a7:
        r11 = 0;
        r1 = r9[r8];
        r1[r5] = r10;
    L_0x01ac:
        r1 = r9[r8];
        r1 = r1[r5];
        r10 = r9[r8];
        r13 = 1;
        r10 = r10[r13];
        if (r1 > r10) goto L_0x01d6;
    L_0x01b7:
        r1 = new jumio.nv.nfc.bv;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "CEpoc value must be greater than CSpoc in POC marker segment of tile ";
        r4.append(r5);
        r4.append(r2);
        r2 = ", tile-part ";
        r4.append(r2);
        r4.append(r3);
        r2 = r4.toString();
        r1.<init>(r2);
        throw r1;
    L_0x01d6:
        r1 = r9[r8];
        r10 = r7.g;
        r14 = r19.readUnsignedByte();
        r10[r8] = r14;
        r10 = 5;
        r1[r10] = r14;
        r8 = r8 + 1;
        goto L_0x00f0;
    L_0x01e7:
        r1 = "POC marker";
        r3 = r19;
        r0.a(r3, r1);
        if (r20 == 0) goto L_0x0201;
    L_0x01f0:
        r1 = r0.f;
        r1 = r1.h;
        r2 = "main";
        r1.put(r2, r7);
        r1 = r0.t;
        r1 = r1.l;
        r1.a(r9);
        goto L_0x0220;
    L_0x0201:
        r1 = r0.f;
        r1 = r1.h;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "t";
        r3.append(r4);
        r3.append(r2);
        r3 = r3.toString();
        r1.put(r3, r7);
        r1 = r0.t;
        r1 = r1.l;
        r1.b(r2, r9);
    L_0x0220:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.cb.f(java.io.DataInputStream, boolean, int, int):void");
    }

    private void g(DataInputStream dataInputStream, boolean z, int i, int i2) {
        int readUnsignedByte;
        h e = this.f.e();
        e.a = dataInputStream.readUnsignedShort();
        if (this.q < InputDeviceCompat.SOURCE_KEYBOARD) {
            readUnsignedByte = dataInputStream.readUnsignedByte();
        } else {
            readUnsignedByte = dataInputStream.readUnsignedShort();
        }
        e.b = readUnsignedByte;
        if (readUnsignedByte >= this.q) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid component index in RGN marker");
            stringBuilder.append(readUnsignedByte);
            throw new bv(stringBuilder.toString());
        }
        e.c = dataInputStream.readUnsignedByte();
        if (e.c != 0) {
            throw new bv("Unknown or unsupported Srgn parameter in ROI marker");
        }
        if (this.t.b == null) {
            this.t.b = new do(this.h, this.q, (byte) 2);
        }
        e.d = dataInputStream.readUnsignedByte();
        Hashtable hashtable;
        if (z) {
            hashtable = this.f.e;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("main_c");
            stringBuilder2.append(readUnsignedByte);
            hashtable.put(stringBuilder2.toString(), e);
            this.t.b.a(readUnsignedByte, (Object) new Integer(e.d));
        } else {
            hashtable = this.f.e;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("t");
            stringBuilder3.append(i);
            stringBuilder3.append("_c");
            stringBuilder3.append(readUnsignedByte);
            hashtable.put(stringBuilder3.toString(), e);
            this.t.b.a(i, readUnsignedByte, new Integer(e.d));
        }
        a(dataInputStream, "RGN marker");
    }

    private void c(DataInputStream dataInputStream) {
        if (this.u == null) {
            this.u = new byte[this.n][];
            this.d = new Vector();
            this.t.r.a(new Boolean(true));
        }
        int readUnsignedShort = dataInputStream.readUnsignedShort() - 3;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        this.u[readUnsignedByte] = new byte[readUnsignedShort];
        dataInputStream.read(this.u[readUnsignedByte], 0, readUnsignedShort);
        a(dataInputStream, "PPM marker");
    }

    private void a(DataInputStream dataInputStream, int i, int i2) {
        if (this.v == null) {
            this.v = new byte[this.h][][][];
        }
        if (this.v[i] == null) {
            this.v[i] = new byte[this.a[i]][][];
        }
        if (this.v[i][i2] == null) {
            this.v[i][i2] = new byte[this.o[i][i2]][];
        }
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[(readUnsignedShort - 3)];
        dataInputStream.read(bArr);
        this.v[i][i2][readUnsignedByte] = bArr;
        a(dataInputStream, "PPT marker");
        this.t.r.b(i, new Boolean(true));
    }

    private void a(short s, df dfVar) {
        StringBuilder stringBuilder;
        if (this.i != 0 || s == (short) -175) {
            String str = "";
            if (this.p == null) {
                this.p = new Hashtable();
            }
            if (s != (short) -171) {
                if (s != (short) -112) {
                    if (s == (short) -109) {
                        throw new bv("SOD found in main header");
                    } else if (s != (short) -39) {
                        int i;
                        switch (s) {
                            case (short) -175:
                                if ((this.i & 1) == 0) {
                                    this.i |= 1;
                                    str = "SIZ";
                                    break;
                                }
                                throw new bv("More than one SIZ marker segment found in main header");
                            case (short) -174:
                                if ((this.i & 2) == 0) {
                                    this.i |= 2;
                                    str = "COD";
                                    break;
                                }
                                throw new bv("More than one COD marker found in main header");
                            case (short) -173:
                                this.i |= 4;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("COC");
                                i = this.j;
                                this.j = i + 1;
                                stringBuilder.append(i);
                                str = stringBuilder.toString();
                                break;
                            default:
                                switch (s) {
                                    case (short) -169:
                                        if ((this.i & 32) == 0) {
                                            this.i |= 32;
                                            str = "PLM";
                                            break;
                                        }
                                        throw new bv("More than one PLM marker found in main header");
                                    case (short) -168:
                                        throw new bv("PLT found in main header");
                                    default:
                                        switch (s) {
                                            case (short) -164:
                                                if ((this.i & 8) == 0) {
                                                    this.i |= 8;
                                                    str = "QCD";
                                                    break;
                                                }
                                                throw new bv("More than one QCD marker found in main header");
                                            case (short) -163:
                                                this.i |= 256;
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append("QCC");
                                                i = this.k;
                                                this.k = i + 1;
                                                stringBuilder.append(i);
                                                str = stringBuilder.toString();
                                                break;
                                            case (short) -162:
                                                this.i |= 512;
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append("RGN");
                                                i = this.m;
                                                this.m = i + 1;
                                                stringBuilder.append(i);
                                                str = stringBuilder.toString();
                                                break;
                                            case (short) -161:
                                                if ((this.i & 1024) == 0) {
                                                    this.i |= 1024;
                                                    str = "POC";
                                                    break;
                                                }
                                                throw new bv("More than one POC marker segment found in main header");
                                            case (short) -160:
                                                this.i |= 16384;
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append("PPM");
                                                i = this.n;
                                                this.n = i + 1;
                                                stringBuilder.append(i);
                                                str = stringBuilder.toString();
                                                break;
                                            case (short) -159:
                                                throw new bv("PPT found in main header");
                                            default:
                                                switch (s) {
                                                    case (short) -157:
                                                        if ((this.i & 65536) == 0) {
                                                            this.i |= 65536;
                                                            str = "CRG";
                                                            break;
                                                        }
                                                        throw new bv("More than one CRG marker found in main header");
                                                    case (short) -156:
                                                        this.i |= 2048;
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append("COM");
                                                        i = this.l;
                                                        this.l = i + 1;
                                                        stringBuilder.append(i);
                                                        str = stringBuilder.toString();
                                                        break;
                                                    default:
                                                        str = "UNKNOWN";
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        throw new bv("EOC found in main header");
                    }
                } else if ((this.i & 64) != 0) {
                    throw new bv("More than one SOT marker found right after main or tile header");
                } else {
                    this.i |= 64;
                    return;
                }
            } else if ((this.i & 16) != 0) {
                throw new bv("More than one TLM marker found in main header");
            } else {
                this.i |= 16;
            }
            if (s < (short) -208 || s > (short) -193) {
                int b = dfVar.b();
                Object obj = new byte[b];
                obj[0] = (byte) ((b >> 8) & 255);
                obj[1] = (byte) (b & 255);
                dfVar.a(obj, 2, b - 2);
                if (!str.equals("UNKNOWN")) {
                    this.p.put(str, obj);
                }
            }
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("First marker after SOC must be SIZ ");
        stringBuilder.append(Integer.toHexString(s));
        throw new bv(stringBuilder.toString());
    }

    public void a(short s, df dfVar, int i, int i2) {
        if (this.p == null) {
            this.p = new Hashtable();
        }
        if (s == (short) -171) {
            throw new bv("TLM found in tile-part header");
        } else if (s == (short) -112) {
            throw new bv("Second SOT marker segment found in tile-part header");
        } else if (s == (short) -109) {
            this.i |= 8192;
        } else if (s != (short) -39) {
            String str;
            StringBuilder stringBuilder;
            switch (s) {
                case (short) -175:
                    throw new bv("SIZ found in tile-part header");
                case (short) -174:
                    if ((this.i & 2) == 0) {
                        this.i |= 2;
                        str = "COD";
                        break;
                    }
                    throw new bv("More than one COD marker found in tile-part header");
                case (short) -173:
                    this.i |= 4;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("COC");
                    i = this.j;
                    this.j = i + 1;
                    stringBuilder.append(i);
                    str = stringBuilder.toString();
                    break;
                default:
                    switch (s) {
                        case (short) -169:
                            throw new bv("PLM found in tile-part header");
                        case (short) -168:
                            if ((this.i & 32) == 0) {
                                str = "UNKNOWN";
                                break;
                            }
                            throw new bv("PLT marker found eventhough PLM marker found in main header");
                        default:
                            switch (s) {
                                case (short) -164:
                                    if ((this.i & 8) == 0) {
                                        this.i |= 8;
                                        str = "QCD";
                                        break;
                                    }
                                    throw new bv("More than one QCD marker found in tile-part header");
                                case (short) -163:
                                    this.i |= 256;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("QCC");
                                    i = this.k;
                                    this.k = i + 1;
                                    stringBuilder.append(i);
                                    str = stringBuilder.toString();
                                    break;
                                case (short) -162:
                                    this.i |= 512;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("RGN");
                                    i = this.m;
                                    this.m = i + 1;
                                    stringBuilder.append(i);
                                    str = stringBuilder.toString();
                                    break;
                                case (short) -161:
                                    if ((this.i & 1024) == 0) {
                                        this.i |= 1024;
                                        str = "POC";
                                        break;
                                    }
                                    throw new bv("More than one POC marker segment found in tile-part header");
                                case (short) -160:
                                    throw new bv("PPM found in tile-part header");
                                case (short) -159:
                                    this.i |= 32768;
                                    if (this.o == null) {
                                        this.o = new int[this.h][];
                                    }
                                    if (this.o[i] == null) {
                                        this.o[i] = new int[this.a[i]];
                                    }
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("PPT");
                                    int[] iArr = this.o[i];
                                    int i3 = iArr[i2];
                                    iArr[i2] = i3 + 1;
                                    stringBuilder.append(i3);
                                    str = stringBuilder.toString();
                                    break;
                                default:
                                    switch (s) {
                                        case (short) -157:
                                            throw new bv("CRG marker found in tile-part header");
                                        case (short) -156:
                                            this.i |= 2048;
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("COM");
                                            i = this.l;
                                            this.l = i + 1;
                                            stringBuilder.append(i);
                                            str = stringBuilder.toString();
                                            break;
                                        default:
                                            str = "UNKNOWN";
                                            break;
                                    }
                            }
                    }
            }
            i = dfVar.b();
            Object obj = new byte[i];
            obj[0] = (byte) ((i >> 8) & 255);
            obj[1] = (byte) (i & 255);
            dfVar.a(obj, 2, i - 2);
            if (!str.equals("UNKNOWN")) {
                this.p.put(str, obj);
            }
        } else {
            throw new bv("EOC found in tile-part header");
        }
    }

    private void q() {
        int i;
        Hashtable hashtable;
        StringBuilder stringBuilder;
        if ((this.i & 1) != 0) {
            a(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("SIZ"))));
        }
        int i2 = 0;
        if ((this.i & 2048) != 0) {
            for (i = 0; i < this.l; i++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("COM");
                stringBuilder.append(i);
                a(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), true, 0, i);
            }
        }
        if ((this.i & 65536) != 0) {
            b(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("CRG"))));
        }
        if ((this.i & 2) != 0) {
            d(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("COD"))), true, 0, 0);
        }
        if ((this.i & 4) != 0) {
            for (i = 0; i < this.j; i++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("COC");
                stringBuilder.append(i);
                e(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), true, 0, 0);
            }
        }
        if ((this.i & 512) != 0) {
            for (i = 0; i < this.m; i++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("RGN");
                stringBuilder.append(i);
                g(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), true, 0, 0);
            }
        }
        if ((this.i & 8) != 0) {
            b(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("QCD"))), true, 0, 0);
        }
        if ((this.i & 256) != 0) {
            for (i = 0; i < this.k; i++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("QCC");
                stringBuilder.append(i);
                c(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), true, 0, 0);
            }
        }
        if ((this.i & 1024) != 0) {
            f(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("POC"))), true, 0, 0);
        }
        if ((this.i & 16384) != 0) {
            while (i2 < this.n) {
                Hashtable hashtable2 = this.p;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("PPM");
                stringBuilder2.append(i2);
                c(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable2.get(stringBuilder2.toString()))));
                i2++;
            }
        }
        this.p = null;
    }

    public void a(int i, int i2) {
        int i3;
        Hashtable hashtable;
        StringBuilder stringBuilder;
        int i4 = 0;
        if ((this.i & 2) != 0) {
            d(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("COD"))), false, i, i2);
        }
        if ((this.i & 4) != 0) {
            for (i3 = 0; i3 < this.j; i3++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("COC");
                stringBuilder.append(i3);
                e(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), false, i, i2);
            }
        }
        if ((this.i & 512) != 0) {
            for (i3 = 0; i3 < this.m; i3++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("RGN");
                stringBuilder.append(i3);
                g(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), false, i, i2);
            }
        }
        if ((this.i & 8) != 0) {
            b(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("QCD"))), false, i, i2);
        }
        if ((this.i & 256) != 0) {
            for (i3 = 0; i3 < this.k; i3++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("QCC");
                stringBuilder.append(i3);
                c(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), false, i, i2);
            }
        }
        if ((this.i & 1024) != 0) {
            f(new DataInputStream(new ByteArrayInputStream((byte[]) this.p.get("POC"))), false, i, i2);
        }
        if ((this.i & 2048) != 0) {
            for (i3 = 0; i3 < this.l; i3++) {
                hashtable = this.p;
                stringBuilder = new StringBuilder();
                stringBuilder.append("COM");
                stringBuilder.append(i3);
                a(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable.get(stringBuilder.toString()))), false, i, i3);
            }
        }
        if ((this.i & 32768) != 0) {
            while (i4 < this.o[i][i2]) {
                Hashtable hashtable2 = this.p;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("PPT");
                stringBuilder2.append(i4);
                a(new DataInputStream(new ByteArrayInputStream((byte[]) hashtable2.get(stringBuilder2.toString()))), i, i2);
                i4++;
            }
        }
        this.p = null;
    }

    public cg m() {
        return this.t;
    }

    public cb(df dfVar, dt dtVar, bw bwVar) {
        this.f = bwVar;
        dtVar.a('H', dt.a(e));
        this.c = dfVar.e();
        if (dfVar.a() != (short) -177) {
            throw new bv("SOC marker segment not  found at the beginning of the codestream.");
        }
        this.i = 0;
        do {
            a(dfVar.a(), dfVar);
        } while ((this.i & 64) == 0);
        dfVar.a(dfVar.e() - 2);
        q();
    }

    public co a(cm cmVar, dt dtVar) {
        dtVar.a('C', dt.a(co.a()));
        return new cq(cmVar, this.t, dtVar.b("Cer"), false, dtVar.c("m_quit"));
    }

    public cs a(cs csVar, y yVar) {
        return aa.b(csVar, yVar);
    }

    public cs b(cs csVar, y yVar) {
        return x.a(csVar, yVar);
    }

    public cs c(cs csVar, y yVar) {
        return ac.a(csVar, yVar);
    }

    public cs d(cs csVar, y yVar) {
        return ad.a(csVar, yVar);
    }

    public dp a(dj djVar, dt dtVar, cg cgVar) {
        return dp.a(djVar, dtVar, cgVar);
    }

    public void n() {
        this.i &= 16416;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
    }

    public static String[][] o() {
        return e;
    }

    public ByteArrayInputStream d(int i) {
        if (this.w == null) {
            int i2;
            this.w = new ByteArrayOutputStream[this.h];
            for (i2 = this.h - 1; i2 >= 0; i2--) {
                this.w[i2] = new ByteArrayOutputStream();
            }
            int i3;
            int intValue;
            if (this.n != 0) {
                i2 = this.d.size();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (i3 = 0; i3 < this.n; i3++) {
                    byteArrayOutputStream.write(this.u[i3]);
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                for (int i4 = 0; i4 < i2; i4++) {
                    intValue = ((Integer) this.d.elementAt(i4)).intValue();
                    byte[] bArr = new byte[((((byteArrayInputStream.read() << 24) | (byteArrayInputStream.read() << 16)) | (byteArrayInputStream.read() << 8)) | byteArrayInputStream.read())];
                    byteArrayInputStream.read(bArr);
                    this.w[intValue].write(bArr);
                }
            } else {
                for (i2 = this.h - 1; i2 >= 0; i2--) {
                    for (intValue = 0; intValue < this.a[i2]; intValue++) {
                        for (i3 = 0; i3 < this.o[i2][intValue]; i3++) {
                            this.w[i2].write(this.v[i2][intValue][i3]);
                        }
                    }
                }
            }
        }
        return new ByteArrayInputStream(this.w[i].toByteArray());
    }

    public void e(int i) {
        if (this.n != 0) {
            this.d.addElement(new Integer(i));
        }
    }

    public int p() {
        return this.i;
    }
}
