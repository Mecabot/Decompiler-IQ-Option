package com.google.android.gms.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzfhg extends zzfgr {
    private static final Logger logger = Logger.getLogger(zzfhg.class.getName());
    private static final boolean zzpop = zzfkq.zzdcd();
    zzfhi zzpoq = this;

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf), th);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static abstract class zza extends zzfhg {
        final byte[] buffer;
        final int limit;
        int position;
        int zzpor;

        zza(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.buffer = new byte[Math.max(i, 20)];
            this.limit = this.buffer.length;
        }

        final void zzak(int i, int i2) {
            zzmg((i << 3) | i2);
        }

        final void zzc(byte b) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
            this.zzpor++;
        }

        public final int zzcyw() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void zzdd(long j) {
            byte[] bArr;
            int i;
            if (zzfhg.zzpop) {
                long j2 = (long) this.position;
                while ((j & -128) != 0) {
                    bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    zzfkq.zza(bArr, (long) i2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                zzfkq.zza(bArr, (long) i, (byte) ((int) j));
                this.zzpor += (int) (((long) this.position) - j2);
                return;
            }
            while ((j & -128) != 0) {
                bArr = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr[i3] = (byte) ((((int) j) & 127) | 128);
                this.zzpor++;
                j >>>= 7;
            }
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) j);
            this.zzpor++;
        }

        final void zzde(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) ((j >> 8) & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) ((j >> 16) & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) ((j >> 24) & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 32));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 40));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 48));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 56));
            this.zzpor += 8;
        }

        final void zzmg(int i) {
            if (zzfhg.zzpop) {
                byte[] bArr;
                int i2;
                long j = (long) this.position;
                while ((i & -128) != 0) {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    zzfkq.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                zzfkq.zza(bArr, (long) i2, (byte) i);
                this.zzpor += (int) (((long) this.position) - j);
                return;
            }
            byte[] bArr2;
            int i3;
            while ((i & -128) != 0) {
                bArr2 = this.buffer;
                i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) ((i & 127) | 128);
                this.zzpor++;
                i >>>= 7;
            }
            bArr2 = this.buffer;
            i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            this.zzpor++;
        }

        final void zzmh(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = i >> 24;
            this.zzpor += 4;
        }
    }

    static class zzb extends zzfhg {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if (((i | i2) | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i3;
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(int i, long j) {
            zzac(i, 0);
            zzcu(j);
        }

        public final void zza(int i, zzfgs zzfgs) {
            zzac(i, 2);
            zzay(zzfgs);
        }

        public final void zza(int i, zzfjc zzfjc) {
            zzac(i, 2);
            zze(zzfjc);
        }

        public final void zzac(int i, int i2) {
            zzlt((i << 3) | i2);
        }

        public final void zzad(int i, int i2) {
            zzac(i, 0);
            zzls(i2);
        }

        public final void zzae(int i, int i2) {
            zzac(i, 0);
            zzlt(i2);
        }

        public final void zzaf(int i, int i2) {
            zzac(i, 5);
            zzlv(i2);
        }

        public final void zzay(zzfgs zzfgs) {
            zzlt(zzfgs.size());
            zzfgs.zza(this);
        }

        public final void zzb(byte b) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzb(int i, long j) {
            zzac(i, 1);
            zzcw(j);
        }

        public final void zzb(int i, zzfgs zzfgs) {
            zzac(1, 3);
            zzae(2, i);
            zza(3, zzfgs);
            zzac(1, 4);
        }

        public final void zzb(int i, zzfjc zzfjc) {
            zzac(1, 3);
            zzae(2, i);
            zza(3, zzfjc);
            zzac(1, 4);
        }

        public final void zzcu(long j) {
            byte[] bArr;
            int i;
            int i2;
            if (!zzfhg.zzpop || zzcyw() < 10) {
                while ((j & -128) != 0) {
                    bArr = this.buffer;
                    i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((int) j);
                    return;
                } catch (Throwable e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            }
            while ((j & -128) != 0) {
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                zzfkq.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zzfkq.zza(bArr, (long) i2, (byte) ((int) j));
        }

        public final void zzcw(long j) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final int zzcyw() {
            return this.limit - this.position;
        }

        public final void zze(zzfjc zzfjc) {
            zzlt(zzfjc.zzhs());
            zzfjc.zza(this);
        }

        public final void zze(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzj(byte[] bArr, int i, int i2) {
            zzlt(i2);
            write(bArr, 0, i2);
        }

        public final void zzl(int i, boolean z) {
            zzac(i, 0);
            zzb((byte) z);
        }

        public final void zzls(int i) {
            if (i >= 0) {
                zzlt(i);
            } else {
                zzcu((long) i);
            }
        }

        public final void zzlt(int i) {
            byte[] bArr;
            int i2;
            if (!zzfhg.zzpop || zzcyw() < 10) {
                while ((i & -128) != 0) {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) i;
                    return;
                } catch (Throwable e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            }
            while ((i & -128) != 0) {
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                zzfkq.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zzfkq.zza(bArr, (long) i2, (byte) i);
        }

        public final void zzlv(int i) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = i >> 24;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzp(int i, String str) {
            zzac(i, 2);
            zztw(str);
        }

        public final void zztw(String str) {
            int i = this.position;
            try {
                int zzly = zzfhg.zzly(str.length() * 3);
                int zzly2 = zzfhg.zzly(str.length());
                if (zzly2 == zzly) {
                    this.position = i + zzly2;
                    zzly = zzfks.zza(str, this.buffer, this.position, zzcyw());
                    this.position = i;
                    zzlt((zzly - i) - zzly2);
                    this.position = zzly;
                    return;
                }
                zzlt(zzfks.zzd(str));
                this.position = zzfks.zza(str, this.buffer, this.position, zzcyw());
            } catch (zzfkv e) {
                this.position = i;
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            }
        }
    }

    static final class zzd extends zza {
        private final OutputStream out;

        zzd(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private final void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private final void zzmi(int i) {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        public final void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        public final void write(byte[] bArr, int i, int i2) {
            if (this.limit - this.position >= i2) {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } else {
                int i3 = this.limit - this.position;
                System.arraycopy(bArr, i, this.buffer, this.position, i3);
                i += i3;
                i2 -= i3;
                this.position = this.limit;
                this.zzpor += i3;
                doFlush();
                if (i2 <= this.limit) {
                    System.arraycopy(bArr, i, this.buffer, 0, i2);
                    this.position = i2;
                } else {
                    this.out.write(bArr, i, i2);
                }
            }
            this.zzpor += i2;
        }

        public final void zza(int i, long j) {
            zzmi(20);
            zzak(i, 0);
            zzdd(j);
        }

        public final void zza(int i, zzfgs zzfgs) {
            zzac(i, 2);
            zzay(zzfgs);
        }

        public final void zza(int i, zzfjc zzfjc) {
            zzac(i, 2);
            zze(zzfjc);
        }

        public final void zzac(int i, int i2) {
            zzlt((i << 3) | i2);
        }

        public final void zzad(int i, int i2) {
            zzmi(20);
            zzak(i, 0);
            if (i2 >= 0) {
                zzmg(i2);
            } else {
                zzdd((long) i2);
            }
        }

        public final void zzae(int i, int i2) {
            zzmi(20);
            zzak(i, 0);
            zzmg(i2);
        }

        public final void zzaf(int i, int i2) {
            zzmi(14);
            zzak(i, 5);
            zzmh(i2);
        }

        public final void zzay(zzfgs zzfgs) {
            zzlt(zzfgs.size());
            zzfgs.zza(this);
        }

        public final void zzb(byte b) {
            if (this.position == this.limit) {
                doFlush();
            }
            zzc(b);
        }

        public final void zzb(int i, long j) {
            zzmi(18);
            zzak(i, 1);
            zzde(j);
        }

        public final void zzb(int i, zzfgs zzfgs) {
            zzac(1, 3);
            zzae(2, i);
            zza(3, zzfgs);
            zzac(1, 4);
        }

        public final void zzb(int i, zzfjc zzfjc) {
            zzac(1, 3);
            zzae(2, i);
            zza(3, zzfjc);
            zzac(1, 4);
        }

        public final void zzcu(long j) {
            zzmi(10);
            zzdd(j);
        }

        public final void zzcw(long j) {
            zzmi(8);
            zzde(j);
        }

        public final void zze(zzfjc zzfjc) {
            zzlt(zzfjc.zzhs());
            zzfjc.zza(this);
        }

        public final void zze(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzj(byte[] bArr, int i, int i2) {
            zzlt(i2);
            write(bArr, 0, i2);
        }

        public final void zzl(int i, boolean z) {
            zzmi(11);
            zzak(i, 0);
            zzc((byte) z);
        }

        public final void zzls(int i) {
            if (i >= 0) {
                zzlt(i);
            } else {
                zzcu((long) i);
            }
        }

        public final void zzlt(int i) {
            zzmi(10);
            zzmg(i);
        }

        public final void zzlv(int i) {
            zzmi(4);
            zzmh(i);
        }

        public final void zzp(int i, String str) {
            zzac(i, 2);
            zztw(str);
        }

        public final void zztw(String str) {
            int i;
            try {
                int length = str.length() * 3;
                int zzly = zzfhg.zzly(length);
                i = zzly + length;
                if (i > this.limit) {
                    byte[] bArr = new byte[length];
                    length = zzfks.zza(str, bArr, 0, length);
                    zzlt(length);
                    zze(bArr, 0, length);
                    return;
                }
                int i2;
                if (i > this.limit - this.position) {
                    doFlush();
                }
                length = zzfhg.zzly(str.length());
                i = this.position;
                if (length == zzly) {
                    this.position = i + length;
                    zzly = zzfks.zza(str, this.buffer, this.position, this.limit - this.position);
                    this.position = i;
                    i2 = (zzly - i) - length;
                    zzmg(i2);
                    this.position = zzly;
                } else {
                    i2 = zzfks.zzd(str);
                    zzmg(i2);
                    this.position = zzfks.zza(str, this.buffer, this.position, i2);
                }
                this.zzpor += i2;
            } catch (zzfkv e) {
                this.zzpor -= this.position - i;
                this.position = i;
                throw e;
            } catch (Throwable e2) {
                throw new zzc(e2);
            } catch (zzfkv e3) {
                zza(str, e3);
            }
        }
    }

    private zzfhg() {
    }

    /* synthetic */ zzfhg(zzfhh zzfhh) {
        this();
    }

    public static int zza(int i, zzfik zzfik) {
        i = zzlw(i);
        int zzhs = zzfik.zzhs();
        return i + (zzly(zzhs) + zzhs);
    }

    public static int zza(zzfik zzfik) {
        int zzhs = zzfik.zzhs();
        return zzly(zzhs) + zzhs;
    }

    public static int zzag(int i, int i2) {
        return zzlw(i) + zzlx(i2);
    }

    public static int zzah(int i, int i2) {
        return zzlw(i) + zzly(i2);
    }

    public static int zzai(int i, int i2) {
        return zzlw(i) + 4;
    }

    public static int zzaj(int i, int i2) {
        return zzlw(i) + zzlx(i2);
    }

    public static int zzaz(zzfgs zzfgs) {
        int size = zzfgs.size();
        return zzly(size) + size;
    }

    public static int zzb(int i, double d) {
        return zzlw(i) + 8;
    }

    public static int zzb(int i, zzfik zzfik) {
        return ((zzlw(1) << 1) + zzah(2, i)) + zza(3, zzfik);
    }

    public static zzfhg zzb(OutputStream outputStream, int i) {
        return new zzd(outputStream, i);
    }

    public static zzfhg zzbc(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    public static int zzbd(byte[] bArr) {
        int length = bArr.length;
        return zzly(length) + length;
    }

    public static int zzc(int i, long j) {
        return zzlw(i) + zzcy(j);
    }

    public static int zzc(int i, zzfgs zzfgs) {
        i = zzlw(i);
        int size = zzfgs.size();
        return i + (zzly(size) + size);
    }

    public static int zzc(int i, zzfjc zzfjc) {
        return zzlw(i) + zzf(zzfjc);
    }

    public static int zzcx(long j) {
        return zzcy(j);
    }

    public static int zzcy(long j) {
        if ((j & -128) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i;
        if ((j & -34359738368L) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((j & -2097152) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzcz(long j) {
        return zzcy(zzdc(j));
    }

    public static int zzd(int i, long j) {
        return zzlw(i) + zzcy(j);
    }

    public static int zzd(int i, zzfgs zzfgs) {
        return ((zzlw(1) << 1) + zzah(2, i)) + zzc(3, zzfgs);
    }

    public static int zzd(int i, zzfjc zzfjc) {
        return ((zzlw(1) << 1) + zzah(2, i)) + zzc(3, zzfjc);
    }

    public static int zzda(long j) {
        return 8;
    }

    public static int zzdb(long j) {
        return 8;
    }

    private static long zzdc(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzdm(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzlw(i) + 8;
    }

    public static int zzf(zzfjc zzfjc) {
        int zzhs = zzfjc.zzhs();
        return zzly(zzhs) + zzhs;
    }

    public static int zzg(float f) {
        return 4;
    }

    @Deprecated
    public static int zzg(zzfjc zzfjc) {
        return zzfjc.zzhs();
    }

    public static zzfhg zzi(byte[] bArr, int i, int i2) {
        return new zzb(bArr, i, i2);
    }

    static int zzlr(int i) {
        return i > 4096 ? 4096 : i;
    }

    public static int zzlw(int i) {
        return zzly(i << 3);
    }

    public static int zzlx(int i) {
        return i >= 0 ? zzly(i) : 10;
    }

    public static int zzly(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzlz(int i) {
        return zzly(zzme(i));
    }

    public static int zzm(int i, boolean z) {
        return zzlw(i) + 1;
    }

    public static int zzma(int i) {
        return 4;
    }

    public static int zzmb(int i) {
        return 4;
    }

    public static int zzmc(int i) {
        return zzlx(i);
    }

    static int zzmd(int i) {
        return zzly(i) + i;
    }

    private static int zzme(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzmf(int i) {
        return zzly(i);
    }

    public static int zzo(double d) {
        return 8;
    }

    public static int zzq(int i, String str) {
        return zzlw(i) + zztx(str);
    }

    public static int zztx(String str) {
        int zzd;
        try {
            zzd = zzfks.zzd(str);
        } catch (zzfkv unused) {
            zzd = str.getBytes(zzfhz.UTF_8).length;
        }
        return zzly(zzd) + zzd;
    }

    public abstract void flush();

    public abstract void write(byte[] bArr, int i, int i2);

    public final void zza(int i, double d) {
        zzb(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzfgs zzfgs);

    public abstract void zza(int i, zzfjc zzfjc);

    final void zza(String str, zzfkv zzfkv) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzfkv);
        byte[] bytes = str.getBytes(zzfhz.UTF_8);
        try {
            zzlt(bytes.length);
            zze(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    public abstract void zzac(int i, int i2);

    public abstract void zzad(int i, int i2);

    public abstract void zzae(int i, int i2);

    public abstract void zzaf(int i, int i2);

    public abstract void zzay(zzfgs zzfgs);

    public abstract void zzb(byte b);

    public abstract void zzb(int i, long j);

    public abstract void zzb(int i, zzfgs zzfgs);

    public abstract void zzb(int i, zzfjc zzfjc);

    public abstract void zzcu(long j);

    public final void zzcv(long j) {
        zzcu(zzdc(j));
    }

    public abstract void zzcw(long j);

    public abstract int zzcyw();

    public final void zzcyx() {
        if (zzcyw() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzdl(boolean z) {
        zzb((byte) z);
    }

    @Deprecated
    public final void zze(int i, zzfjc zzfjc) {
        zzac(i, 3);
        zzfjc.zza(this);
        zzac(i, 4);
    }

    public abstract void zze(zzfjc zzfjc);

    public final void zzf(float f) {
        zzlv(Float.floatToRawIntBits(f));
    }

    abstract void zzj(byte[] bArr, int i, int i2);

    public abstract void zzl(int i, boolean z);

    public abstract void zzls(int i);

    public abstract void zzlt(int i);

    public final void zzlu(int i) {
        zzlt(zzme(i));
    }

    public abstract void zzlv(int i);

    public final void zzn(double d) {
        zzcw(Double.doubleToRawLongBits(d));
    }

    public abstract void zzp(int i, String str);

    public abstract void zztw(String str);
}
