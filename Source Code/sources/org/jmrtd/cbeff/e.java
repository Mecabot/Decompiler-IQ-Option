package org.jmrtd.cbeff;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVUtil;

/* compiled from: ISO781611Decoder */
public class e {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private a<?> fcb;

    public e(a<?> aVar) {
        this.fcb = aVar;
    }

    public d n(InputStream inputStream) {
        return o(inputStream);
    }

    private d o(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag == 32609) {
            return a(readTag, tLVInputStream.readLength(), inputStream);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected tag ");
        stringBuilder.append(Integer.toHexString(32609));
        stringBuilder.append(", found ");
        stringBuilder.append(Integer.toHexString(readTag));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private d a(int i, int i2, InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        d dVar = new d();
        StringBuilder stringBuilder;
        if (i != 32609) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected tag ");
            stringBuilder.append(Integer.toHexString(32609));
            stringBuilder.append(", found ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        i = tLVInputStream.readTag();
        if (i != 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected tag BIOMETRIC_INFO_COUNT_TAG (");
            stringBuilder.append(Integer.toHexString(2));
            stringBuilder.append(") in CBEFF structure, found ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        i = tLVInputStream.readLength();
        if (i != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BIOMETRIC_INFO_COUNT should have length 1, found length ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] readValue = tLVInputStream.readValue();
        i2 = 0;
        i = readValue[0] & 255;
        while (i2 < i) {
            dVar.a(c(inputStream, i2));
            i2++;
        }
        return dVar;
    }

    private c c(InputStream inputStream, int i) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        return a(tLVInputStream.readTag(), tLVInputStream.readLength(), inputStream, i);
    }

    private c a(int i, int i2, InputStream inputStream, int i3) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        StringBuilder stringBuilder;
        if (i != 32608) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected tag BIOMETRIC_INFORMATION_TEMPLATE_TAG (");
            stringBuilder.append(Integer.toHexString(32608));
            stringBuilder.append("), found ");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(", index is ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        i = tLVInputStream.readTag();
        i2 = tLVInputStream.readLength();
        if (i == 125) {
            b(inputStream, i, i2, i3);
            return null;
        } else if ((i & 160) == 160) {
            return new g(a(inputStream, a(inputStream, i, i2, i3), i3));
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported template tag: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private StandardBiometricHeader a(InputStream inputStream, int i, int i2, int i3) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (i != 161) {
            Logger logger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected tag ");
            stringBuilder.append(Integer.toHexString(161));
            stringBuilder.append(", found ");
            stringBuilder.append(Integer.toHexString(i));
            logger.warning(stringBuilder.toString());
        }
        Map hashMap = new HashMap();
        i3 = 0;
        while (i3 < i2) {
            int readTag = tLVInputStream.readTag();
            i3 = (i3 + TLVUtil.getTagLength(readTag)) + TLVUtil.getLengthLength(tLVInputStream.readLength());
            Object readValue = tLVInputStream.readValue();
            i3 += readValue.length;
            hashMap.put(Integer.valueOf(readTag), readValue);
        }
        return new StandardBiometricHeader(hashMap);
    }

    private void b(InputStream inputStream, int i, int i2, int i3) {
        InputStream tLVInputStream = new TLVInputStream(new ByteArrayInputStream(p(inputStream)));
        try {
            a(new ByteArrayInputStream(p(inputStream)), a(tLVInputStream, tLVInputStream.readTag(), tLVInputStream.readLength(), i3), i3);
        } finally {
            tLVInputStream.close();
        }
    }

    private byte[] p(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        int readLength = tLVInputStream.readLength();
        if (readTag == 129) {
            return tLVInputStream.readValue();
        }
        if (readTag != 133) {
            long j = 0;
            long j2;
            if (readTag == 142) {
                while (true) {
                    j2 = (long) readLength;
                    if (j >= j2) {
                        return null;
                    }
                    j += tLVInputStream.skip(j2);
                }
            } else if (readTag != 158) {
                Logger logger = LOGGER;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported data object tag ");
                stringBuilder.append(Integer.toHexString(readTag));
                logger.info(stringBuilder.toString());
                return null;
            } else {
                while (true) {
                    j2 = (long) readLength;
                    if (j >= j2) {
                        return null;
                    }
                    j += tLVInputStream.skip(j2);
                }
            }
        } else {
            throw new AccessControlException("Access denied. Biometric Information Template is statically protected.");
        }
    }

    private BiometricDataBlock a(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag == 24366 || readTag == 32558) {
            return this.fcb.a(inputStream, standardBiometricHeader, i, tLVInputStream.readLength());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected tag BIOMETRIC_DATA_BLOCK_TAG (");
        stringBuilder.append(Integer.toHexString(24366));
        stringBuilder.append(") or BIOMETRIC_DATA_BLOCK_TAG_ALT (");
        stringBuilder.append(Integer.toHexString(32558));
        stringBuilder.append("), found ");
        stringBuilder.append(Integer.toHexString(readTag));
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
