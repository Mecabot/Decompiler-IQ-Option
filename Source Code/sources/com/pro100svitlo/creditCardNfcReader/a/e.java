package com.pro100svitlo.creditCardNfcReader.a;

import com.pro100svitlo.creditCardNfcReader.exception.TlvException;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.ITag;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.b;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.a;

/* compiled from: TlvUtil */
public final class e {
    private static ITag V(byte[] bArr) {
        return b.H(bArr);
    }

    public static byte[] a(ByteArrayInputStream byteArrayInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte read = (byte) byteArrayInputStream.read();
        byteArrayOutputStream.write(read);
        if ((read & 31) == 31) {
            while (true) {
                int read2 = byteArrayInputStream.read();
                if (read2 >= 0) {
                    read = (byte) read2;
                    byteArrayOutputStream.write(read);
                    if (!b.a.a.b.aL(read, 7) || (b.a.a.b.aL(read, 7) && (read & 127) == 0)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int b(ByteArrayInputStream byteArrayInputStream) {
        int read = byteArrayInputStream.read();
        if (read < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Negative length: ");
            stringBuilder.append(read);
            throw new TlvException(stringBuilder.toString());
        } else if (read <= 127 || read == 128) {
            return read;
        } else {
            read &= 127;
            int i = 0;
            for (int i2 = 0; i2 < read; i2++) {
                int read2 = byteArrayInputStream.read();
                if (read2 < 0) {
                    throw new TlvException("EOS when reading length bytes");
                }
                i = (i << 8) | read2;
            }
            return i;
        }
    }

    public static d c(ByteArrayInputStream byteArrayInputStream) {
        StringBuilder stringBuilder;
        if (byteArrayInputStream.available() < 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error parsing data. Available bytes < 2 . Length=");
            stringBuilder.append(byteArrayInputStream.available());
            throw new TlvException(stringBuilder.toString());
        }
        byteArrayInputStream.mark(0);
        int read = byteArrayInputStream.read();
        while (true) {
            byte b = (byte) read;
            if (read == -1 || !(b == (byte) -1 || b == (byte) 0)) {
                byteArrayInputStream.reset();
            } else {
                byteArrayInputStream.mark(0);
                read = byteArrayInputStream.read();
            }
        }
        byteArrayInputStream.reset();
        if (byteArrayInputStream.available() < 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error parsing data. Available bytes < 2 . Length=");
            stringBuilder.append(byteArrayInputStream.available());
            throw new TlvException(stringBuilder.toString());
        }
        byte[] a = a(byteArrayInputStream);
        byteArrayInputStream.mark(0);
        read = byteArrayInputStream.available();
        int b2 = b(byteArrayInputStream);
        int available = byteArrayInputStream.available();
        byteArrayInputStream.reset();
        byte[] bArr = new byte[(read - available)];
        if (bArr.length < 1 || bArr.length > 4) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Number of length bytes must be from 1 to 4. Found ");
            stringBuilder2.append(bArr.length);
            throw new TlvException(stringBuilder2.toString());
        }
        byte[] bArr2;
        byteArrayInputStream.read(bArr, 0, bArr.length);
        available = b.a.a.b.X(bArr);
        ITag V = V(a);
        if (available == 128) {
            byteArrayInputStream.mark(0);
            b2 = 0;
            available = 1;
            while (true) {
                b2++;
                int read2 = byteArrayInputStream.read();
                if (read2 >= 0) {
                    if (available == 0 && read2 == 0) {
                        b2 -= 2;
                        bArr2 = new byte[b2];
                        byteArrayInputStream.reset();
                        byteArrayInputStream.read(bArr2, 0, b2);
                        break;
                    }
                    available = read2;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error parsing data. TLV length byte indicated indefinite length, but EOS was reached before 0x0000 was found");
                    stringBuilder.append(byteArrayInputStream.available());
                    throw new TlvException(stringBuilder.toString());
                }
            }
        } else if (byteArrayInputStream.available() < b2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Length byte(s) indicated ");
            stringBuilder.append(b2);
            stringBuilder.append(" value bytes, but only ");
            stringBuilder.append(byteArrayInputStream.available());
            stringBuilder.append(" ");
            stringBuilder.append(byteArrayInputStream.available() > 1 ? "are" : "is");
            stringBuilder.append(" available");
            throw new TlvException(stringBuilder.toString());
        } else {
            bArr2 = new byte[b2];
            byteArrayInputStream.read(bArr2, 0, b2);
        }
        byteArrayInputStream.mark(0);
        int read3 = byteArrayInputStream.read();
        byte b3 = (byte) read3;
        while (read3 != -1 && (b3 == (byte) -1 || b3 == (byte) 0)) {
            byteArrayInputStream.mark(0);
            read3 = byteArrayInputStream.read();
            b3 = (byte) read3;
        }
        byteArrayInputStream.reset();
        return new d(V, b2, bArr, bArr2);
    }

    public static List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> W(byte[] bArr) {
        List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> arrayList = new ArrayList();
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            while (byteArrayInputStream.available() > 0) {
                if (byteArrayInputStream.available() < 2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Data length < 2 : ");
                    stringBuilder.append(byteArrayInputStream.available());
                    throw new TlvException(stringBuilder.toString());
                }
                arrayList.add(new com.pro100svitlo.creditCardNfcReader.iso7816emv.e(V(a(byteArrayInputStream)), b(byteArrayInputStream)));
            }
        }
        return arrayList;
    }

    public static List<d> a(byte[] bArr, ITag... iTagArr) {
        List<d> arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() > 0) {
            d c = c(byteArrayInputStream);
            if (a.b((Object[]) iTagArr, c.aRJ())) {
                arrayList.add(c);
            } else if (c.aRJ().isConstructed()) {
                arrayList.addAll(a(c.aRK(), iTagArr));
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, ITag... iTagArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            while (byteArrayInputStream.available() > 0) {
                d c = c(byteArrayInputStream);
                if (a.b((Object[]) iTagArr, c.aRJ())) {
                    return c.aRK();
                }
                if (c.aRJ().isConstructed()) {
                    bArr2 = b(c.aRK(), iTagArr);
                    if (bArr2 != null) {
                        break;
                    }
                }
            }
        }
        return bArr2;
    }

    public static int bM(List<com.pro100svitlo.creditCardNfcReader.iso7816emv.e> list) {
        int i = 0;
        if (list != null) {
            for (com.pro100svitlo.creditCardNfcReader.iso7816emv.e length : list) {
                i += length.getLength();
            }
        }
        return i;
    }
}
