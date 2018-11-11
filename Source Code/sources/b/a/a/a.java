package b.a.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.b;
import org.slf4j.c;

/* compiled from: BitUtils */
public final class a {
    private static final b egK = c.nJ(a.class.getName());
    private static final Charset ejB = Charset.forName("ASCII");
    private final byte[] ejC;
    private int ejD;
    private final int size;

    public byte aR(int i, int i2) {
        byte b = (byte) ((((byte) (-1 << i)) & 255) >> i);
        i = 8 - (i2 + i);
        return i > 0 ? (byte) (((byte) (b >> i)) << i) : b;
    }

    public a(byte[] bArr) {
        this.ejC = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.ejC, 0, bArr.length);
        this.size = bArr.length * 8;
    }

    public void iG(int i) {
        this.ejD += i;
        if (this.ejD < 0) {
            this.ejD = 0;
        }
    }

    public boolean aTr() {
        return iJ(1) == 1;
    }

    public byte[] y(int i, boolean z) {
        Object obj = new byte[((int) Math.ceil((double) (((float) i) / 8.0f)))];
        int i2 = 0;
        if (this.ejD % 8 != 0) {
            int i3 = this.ejD + i;
            while (this.ejD < i3) {
                int i4 = this.ejD % 8;
                int i5 = i2 % 8;
                int min = Math.min(i3 - this.ejD, Math.min(8 - i4, 8 - i5));
                int aR = (byte) (this.ejC[this.ejD / 8] & aR(i4, min));
                if (z || i % 8 == 0) {
                    aR = i4 != 0 ? (byte) (aR << Math.min(i4, 8 - min)) : (byte) ((aR & 255) >> i5);
                }
                i4 = i2 / 8;
                obj[i4] = (byte) (obj[i4] | aR);
                this.ejD += min;
                i2 += min;
            }
            if (!(z || i % 8 == 0)) {
                obj[obj.length - 1] = (byte) (aR(((i3 - i) - 1) % 8, 8) & obj[obj.length - 1]);
            }
        } else {
            System.arraycopy(this.ejC, this.ejD / 8, obj, 0, obj.length);
            int i6 = i % 8;
            if (i6 == 0) {
                i6 = 8;
            }
            obj[obj.length - 1] = (byte) (aR(this.ejD % 8, i6) & obj[obj.length - 1]);
            this.ejD += i;
        }
        return obj;
    }

    public Date m(int i, String str) {
        return a(i, str, false);
    }

    public Date a(int i, String str, boolean z) {
        String iH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (z) {
            iH = iH(i);
        } else {
            iH = iK(i);
        }
        try {
            return simpleDateFormat.parse(iH);
        } catch (Throwable e) {
            b bVar = egK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parsing date error. date:");
            stringBuilder.append(iH);
            stringBuilder.append(" pattern:");
            stringBuilder.append(str);
            bVar.error(stringBuilder.toString(), e);
            return null;
        }
    }

    public String iH(int i) {
        return b.Y(y(i, true));
    }

    public long iI(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        int i2 = this.ejD + i;
        long j = 0;
        while (this.ejD < i2) {
            int i3 = this.ejD % 8;
            long min = (j << Math.min(i, 8)) | (((((long) ((this.ejC[this.ejD / 8] & aR(i3, i)) & 255)) & 255) >>> Math.max(8 - (i3 + i), 0)) & 255);
            int i4 = 8 - i3;
            i -= i4;
            this.ejD = Math.min(this.ejD + i4, i2);
            j = min;
        }
        allocate.putLong(j);
        allocate.rewind();
        return allocate.getLong();
    }

    public int iJ(int i) {
        return (int) iI(i);
    }

    public String iK(int i) {
        return a(i, ejB);
    }

    public String a(int i, Charset charset) {
        return new String(y(i, true), charset);
    }
}
