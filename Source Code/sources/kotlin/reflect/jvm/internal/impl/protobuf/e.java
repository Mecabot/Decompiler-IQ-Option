package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CodedInputStream */
public final class e {
    private final byte[] buffer;
    private int bufferSize;
    private int eNA;
    private final boolean eNB;
    private int eNC;
    private int eND;
    private boolean eNE;
    private int eNF;
    private int eNG;
    private int eNH;
    private int eNI;
    private int eNJ;
    private a eNK;
    private final InputStream input;

    /* compiled from: CodedInputStream */
    private interface a {
        void buC();
    }

    public static long cZ(long j) {
        return (j >>> 1) ^ (-(j & 1));
    }

    public static int lu(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static e m(InputStream inputStream) {
        return new e(inputStream);
    }

    static e a(m mVar) {
        e eVar = new e(mVar);
        try {
            eVar.lv(mVar.size());
            return eVar;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int bue() {
        if (buA()) {
            this.eND = 0;
            return 0;
        }
        this.eND = but();
        if (WireFormat.lQ(this.eND) != 0) {
            return this.eND;
        }
        throw InvalidProtocolBufferException.bva();
    }

    public void lt(int i) {
        if (this.eND != i) {
            throw InvalidProtocolBufferException.bvb();
        }
    }

    public boolean a(int i, CodedOutputStream codedOutputStream) {
        long bug;
        switch (WireFormat.lP(i)) {
            case 0:
                bug = bug();
                codedOutputStream.C(i);
                codedOutputStream.n(bug);
                return true;
            case 1:
                bug = bux();
                codedOutputStream.C(i);
                codedOutputStream.db(bug);
                return true;
            case 2:
                d bum = bum();
                codedOutputStream.C(i);
                codedOutputStream.b(bum);
                return true;
            case 3:
                codedOutputStream.C(i);
                b(codedOutputStream);
                i = WireFormat.q(WireFormat.lQ(i), 4);
                lt(i);
                codedOutputStream.C(i);
                return true;
            case 4:
                return false;
            case 5:
                int buw = buw();
                codedOutputStream.C(i);
                codedOutputStream.lE(buw);
                return true;
            default:
                throw InvalidProtocolBufferException.bvc();
        }
    }

    public void b(CodedOutputStream codedOutputStream) {
        int bue;
        do {
            bue = bue();
            if (bue == 0) {
                return;
            }
        } while (a(bue, codedOutputStream));
    }

    public double readDouble() {
        return Double.longBitsToDouble(bux());
    }

    public float readFloat() {
        return Float.intBitsToFloat(buw());
    }

    public long buf() {
        return buu();
    }

    public long bug() {
        return buu();
    }

    public int buh() {
        return but();
    }

    public long bui() {
        return bux();
    }

    public int buj() {
        return buw();
    }

    public boolean buk() {
        return buu() != 0;
    }

    public String readString() {
        int but = but();
        if (but <= this.bufferSize - this.eNA && but > 0) {
            String str = new String(this.buffer, this.eNA, but, "UTF-8");
            this.eNA += but;
            return str;
        } else if (but == 0) {
            return "";
        } else {
            return new String(lA(but), "UTF-8");
        }
    }

    public String bul() {
        byte[] bArr;
        int but = but();
        int i = this.eNA;
        if (but <= this.bufferSize - i && but > 0) {
            bArr = this.buffer;
            this.eNA = i + but;
        } else if (but == 0) {
            return "";
        } else {
            bArr = lA(but);
            i = 0;
        }
        if (u.n(bArr, i, i + but)) {
            return new String(bArr, i, but, "UTF-8");
        }
        throw InvalidProtocolBufferException.bvf();
    }

    public void a(int i, kotlin.reflect.jvm.internal.impl.protobuf.n.a aVar, f fVar) {
        if (this.eNH >= this.eNI) {
            throw InvalidProtocolBufferException.bvd();
        }
        this.eNH++;
        aVar.f(this, fVar);
        lt(WireFormat.q(i, 4));
        this.eNH--;
    }

    public void a(kotlin.reflect.jvm.internal.impl.protobuf.n.a aVar, f fVar) {
        int but = but();
        if (this.eNH >= this.eNI) {
            throw InvalidProtocolBufferException.bvd();
        }
        but = lv(but);
        this.eNH++;
        aVar.f(this, fVar);
        lt(0);
        this.eNH--;
        lw(but);
    }

    public <T extends n> T a(p<T> pVar, f fVar) {
        int but = but();
        if (this.eNH >= this.eNI) {
            throw InvalidProtocolBufferException.bvd();
        }
        but = lv(but);
        this.eNH++;
        n nVar = (n) pVar.b(this, fVar);
        lt(0);
        this.eNH--;
        lw(but);
        return nVar;
    }

    public d bum() {
        int but = but();
        if (but <= this.bufferSize - this.eNA && but > 0) {
            d cVar = (this.eNB && this.eNE) ? new c(this.buffer, this.eNA, but) : d.l(this.buffer, this.eNA, but);
            this.eNA += but;
            return cVar;
        } else if (but == 0) {
            return d.eNx;
        } else {
            return new m(lA(but));
        }
    }

    public int bun() {
        return but();
    }

    public int buo() {
        return but();
    }

    public int bup() {
        return buw();
    }

    public long buq() {
        return bux();
    }

    public int bur() {
        return lu(but());
    }

    public long bus() {
        return cZ(buu());
    }

    /* JADX WARNING: Missing block: B:29:0x0081, code:
            if (r1[r2] < (byte) 0) goto L_0x0083;
     */
    public int but() {
        /*
        r10 = this;
        r0 = r10.eNA;
        r1 = r10.bufferSize;
        if (r1 != r0) goto L_0x0008;
    L_0x0006:
        goto L_0x0083;
    L_0x0008:
        r1 = r10.buffer;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0013;
    L_0x0010:
        r10.eNA = r2;
        return r0;
    L_0x0013:
        r3 = r10.bufferSize;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 >= r4) goto L_0x001b;
    L_0x001a:
        goto L_0x0083;
    L_0x001b:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        r4 = (long) r0;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x002f;
    L_0x0029:
        r0 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r6 = r4 ^ r0;
        r0 = (int) r6;
        goto L_0x0089;
    L_0x002f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        r3 = (long) r0;
        r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x0042;
    L_0x003b:
        r0 = 16256; // 0x3f80 float:2.278E-41 double:8.0315E-320;
        r5 = r3 ^ r0;
        r0 = (int) r5;
    L_0x0040:
        r3 = r2;
        goto L_0x0089;
    L_0x0042:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        r4 = (long) r0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0055;
    L_0x004e:
        r0 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r6 = r4 ^ r0;
        r0 = (int) r6;
        goto L_0x0089;
    L_0x0055:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = (long) r0;
        r6 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r8 = r4 ^ r6;
        r0 = (int) r8;
        if (r3 >= 0) goto L_0x0040;
    L_0x0065:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x0089;
    L_0x006b:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x0040;
    L_0x0071:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x0089;
    L_0x0077:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x0040;
    L_0x007d:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 >= 0) goto L_0x0089;
    L_0x0083:
        r0 = r10.buv();
        r0 = (int) r0;
        return r0;
    L_0x0089:
        r10.eNA = r3;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.but():int");
    }

    public static int a(int i, InputStream inputStream) {
        if ((i & 128) == 0) {
            return i;
        }
        int read;
        i &= 127;
        int i2 = 7;
        while (i2 < 32) {
            read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.buX();
            }
            i |= (read & 127) << i2;
            if ((read & 128) == 0) {
                return i;
            }
            i2 += 7;
        }
        while (i2 < 64) {
            read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.buX();
            } else if ((read & 128) == 0) {
                return i;
            } else {
                i2 += 7;
            }
        }
        throw InvalidProtocolBufferException.buZ();
    }

    /* JADX WARNING: Missing block: B:33:0x00cb, code:
            if (((long) r1[r0]) < 0) goto L_0x00cd;
     */
    public long buu() {
        /*
        r12 = this;
        r0 = r12.eNA;
        r1 = r12.bufferSize;
        if (r1 != r0) goto L_0x0008;
    L_0x0006:
        goto L_0x00cd;
    L_0x0008:
        r1 = r12.buffer;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0014;
    L_0x0010:
        r12.eNA = r2;
        r0 = (long) r0;
        return r0;
    L_0x0014:
        r3 = r12.bufferSize;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 >= r4) goto L_0x001d;
    L_0x001b:
        goto L_0x00cd;
    L_0x001d:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        r4 = (long) r0;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0031;
    L_0x002b:
        r0 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r6 = r4 ^ r0;
        goto L_0x00d4;
    L_0x0031:
        r0 = r3 + 1;
        r2 = r1[r3];
        r2 = r2 << 14;
        r2 = (long) r2;
        r8 = r4 ^ r2;
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x0045;
    L_0x003e:
        r1 = 16256; // 0x3f80 float:2.278E-41 double:8.0315E-320;
        r6 = r8 ^ r1;
    L_0x0042:
        r3 = r0;
        goto L_0x00d4;
    L_0x0045:
        r3 = r0 + 1;
        r0 = r1[r0];
        r0 = r0 << 21;
        r4 = (long) r0;
        r10 = r8 ^ r4;
        r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0059;
    L_0x0052:
        r0 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r6 = r10 ^ r0;
        goto L_0x00d4;
    L_0x0059:
        r0 = r3 + 1;
        r2 = r1[r3];
        r2 = (long) r2;
        r4 = 28;
        r2 = r2 << r4;
        r4 = r10 ^ r2;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x006d;
    L_0x0067:
        r1 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r6 = r4 ^ r1;
        goto L_0x0042;
    L_0x006d:
        r3 = r0 + 1;
        r0 = r1[r0];
        r8 = (long) r0;
        r0 = 35;
        r8 = r8 << r0;
        r10 = r4 ^ r8;
        r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0083;
    L_0x007b:
        r0 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
        r6 = r10 ^ r0;
        goto L_0x00d4;
    L_0x0083:
        r0 = r3 + 1;
        r2 = r1[r3];
        r2 = (long) r2;
        r4 = 42;
        r2 = r2 << r4;
        r4 = r10 ^ r2;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x0099;
    L_0x0091:
        r1 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        r6 = r4 ^ r1;
        goto L_0x0042;
    L_0x0099:
        r3 = r0 + 1;
        r0 = r1[r0];
        r8 = (long) r0;
        r0 = 49;
        r8 = r8 << r0;
        r10 = r4 ^ r8;
        r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x00af;
    L_0x00a7:
        r0 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        r6 = r10 ^ r0;
        goto L_0x00d4;
    L_0x00af:
        r0 = r3 + 1;
        r2 = r1[r3];
        r2 = (long) r2;
        r4 = 56;
        r2 = r2 << r4;
        r4 = r10 ^ r2;
        r2 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r8 = r4 ^ r2;
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x00d2;
    L_0x00c4:
        r3 = r0 + 1;
        r0 = r1[r0];
        r0 = (long) r0;
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x00d3;
    L_0x00cd:
        r0 = r12.buv();
        return r0;
    L_0x00d2:
        r3 = r0;
    L_0x00d3:
        r6 = r8;
    L_0x00d4:
        r12.eNA = r3;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.buu():long");
    }

    long buv() {
        long j = 0;
        int i = 0;
        while (i < 64) {
            byte buB = buB();
            long j2 = j | (((long) (buB & 127)) << i);
            if ((buB & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw InvalidProtocolBufferException.buZ();
    }

    public int buw() {
        int i = this.eNA;
        if (this.bufferSize - i < 4) {
            ly(4);
            i = this.eNA;
        }
        byte[] bArr = this.buffer;
        this.eNA = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    public long bux() {
        int i = this.eNA;
        if (this.bufferSize - i < 8) {
            ly(8);
            i = this.eNA;
        }
        byte[] bArr = this.buffer;
        this.eNA = i + 8;
        return (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48)) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private e(InputStream inputStream) {
        this.eNE = false;
        this.eNG = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.eNI = 64;
        this.eNJ = 67108864;
        this.eNK = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.eNA = 0;
        this.eNF = 0;
        this.input = inputStream;
        this.eNB = false;
    }

    private e(m mVar) {
        this.eNE = false;
        this.eNG = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.eNI = 64;
        this.eNJ = 67108864;
        this.eNK = null;
        this.buffer = mVar.bytes;
        this.eNA = mVar.btT();
        this.bufferSize = this.eNA + mVar.size();
        this.eNF = -this.eNA;
        this.input = null;
        this.eNB = true;
    }

    public int lv(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.buY();
        }
        i += this.eNF + this.eNA;
        int i2 = this.eNG;
        if (i > i2) {
            throw InvalidProtocolBufferException.buX();
        }
        this.eNG = i;
        buy();
        return i2;
    }

    private void buy() {
        this.bufferSize += this.eNC;
        int i = this.eNF + this.bufferSize;
        if (i > this.eNG) {
            this.eNC = i - this.eNG;
            this.bufferSize -= this.eNC;
            return;
        }
        this.eNC = 0;
    }

    public void lw(int i) {
        this.eNG = i;
        buy();
    }

    public int buz() {
        if (this.eNG == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.eNG - (this.eNF + this.eNA);
    }

    public boolean buA() {
        return this.eNA == this.bufferSize && !lz(1);
    }

    private void lx(int i) {
        if (this.bufferSize - this.eNA < i) {
            ly(i);
        }
    }

    private void ly(int i) {
        if (!lz(i)) {
            throw InvalidProtocolBufferException.buX();
        }
    }

    private boolean lz(int i) {
        StringBuilder stringBuilder;
        if (this.eNA + i <= this.bufferSize) {
            stringBuilder = new StringBuilder(77);
            stringBuilder.append("refillBuffer() called when ");
            stringBuilder.append(i);
            stringBuilder.append(" bytes were already available in buffer");
            throw new IllegalStateException(stringBuilder.toString());
        } else if ((this.eNF + this.eNA) + i > this.eNG) {
            return false;
        } else {
            if (this.eNK != null) {
                this.eNK.buC();
            }
            if (this.input != null) {
                int i2 = this.eNA;
                if (i2 > 0) {
                    if (this.bufferSize > i2) {
                        System.arraycopy(this.buffer, i2, this.buffer, 0, this.bufferSize - i2);
                    }
                    this.eNF += i2;
                    this.bufferSize -= i2;
                    this.eNA = 0;
                }
                i2 = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
                if (i2 == 0 || i2 < -1 || i2 > this.buffer.length) {
                    stringBuilder = new StringBuilder(102);
                    stringBuilder.append("InputStream#read(byte[]) returned invalid result: ");
                    stringBuilder.append(i2);
                    stringBuilder.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (i2 > 0) {
                    this.bufferSize += i2;
                    if ((this.eNF + i) - this.eNJ > 0) {
                        throw InvalidProtocolBufferException.bve();
                    }
                    buy();
                    return this.bufferSize >= i ? true : lz(i);
                }
            }
            return false;
        }
    }

    public byte buB() {
        if (this.eNA == this.bufferSize) {
            ly(1);
        }
        byte[] bArr = this.buffer;
        int i = this.eNA;
        this.eNA = i + 1;
        return bArr[i];
    }

    private byte[] lA(int i) {
        int i2;
        if (i <= 0) {
            if (i == 0) {
                return h.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.buY();
        } else if ((this.eNF + this.eNA) + i > this.eNG) {
            lB((this.eNG - this.eNF) - this.eNA);
            throw InvalidProtocolBufferException.buX();
        } else if (i < 4096) {
            Object obj = new byte[i];
            i2 = this.bufferSize - this.eNA;
            System.arraycopy(this.buffer, this.eNA, obj, 0, i2);
            this.eNA = this.bufferSize;
            i -= i2;
            lx(i);
            System.arraycopy(this.buffer, 0, obj, i2, i);
            this.eNA = i;
            return obj;
        } else {
            i2 = this.eNA;
            int i3 = this.bufferSize;
            this.eNF += this.bufferSize;
            this.eNA = 0;
            this.bufferSize = 0;
            i3 -= i2;
            int i4 = i - i3;
            List<byte[]> arrayList = new ArrayList();
            while (i4 > 0) {
                Object obj2 = new byte[Math.min(i4, 4096)];
                int i5 = 0;
                while (i5 < obj2.length) {
                    int read = this.input == null ? -1 : this.input.read(obj2, i5, obj2.length - i5);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.buX();
                    }
                    this.eNF += read;
                    i5 += read;
                }
                i4 -= obj2.length;
                arrayList.add(obj2);
            }
            Object obj3 = new byte[i];
            System.arraycopy(this.buffer, i2, obj3, 0, i3);
            for (byte[] bArr : arrayList) {
                System.arraycopy(bArr, 0, obj3, i3, bArr.length);
                i3 += bArr.length;
            }
            return obj3;
        }
    }

    public void lB(int i) {
        if (i > this.bufferSize - this.eNA || i < 0) {
            lC(i);
        } else {
            this.eNA += i;
        }
    }

    private void lC(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.buY();
        } else if ((this.eNF + this.eNA) + i > this.eNG) {
            lB((this.eNG - this.eNF) - this.eNA);
            throw InvalidProtocolBufferException.buX();
        } else {
            int i2 = this.bufferSize - this.eNA;
            this.eNA = this.bufferSize;
            ly(1);
            while (true) {
                int i3 = i - i2;
                if (i3 > this.bufferSize) {
                    i2 += this.bufferSize;
                    this.eNA = this.bufferSize;
                    ly(1);
                } else {
                    this.eNA = i3;
                    return;
                }
            }
        }
    }
}
