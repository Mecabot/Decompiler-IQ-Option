package org.jmrtd.lds.iso19794;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.jmrtd.cbeff.BiometricDataBlock;
import org.jmrtd.cbeff.StandardBiometricHeader;
import org.jmrtd.lds.AbstractListInfo;

public class FingerInfo extends AbstractListInfo<FingerImageInfo> implements BiometricDataBlock {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 5808625058034008176L;
    private int acquisitionLevel;
    private int captureDeviceId;
    private int compressionAlgorithm;
    private int depth;
    private int imageResolutionHorizontal;
    private int imageResolutionVertical;
    private StandardBiometricHeader sbh;
    private int scaleUnits;
    private int scanResolutionHorizontal;
    private int scanResolutionVertical;

    static String my(int i) {
        switch (i) {
            case 0:
                return "image/raw";
            case 1:
                return "image/raw";
            case 2:
                return "image/x-wsq";
            case 3:
                return "image/jpeg";
            case 4:
                return "image/jpeg2000";
            case 5:
                return "image/png";
            default:
                return null;
        }
    }

    public FingerInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) {
        this.sbh = standardBiometricHeader;
        q(inputStream);
    }

    public void q(InputStream inputStream) {
        InputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        StringBuilder stringBuilder;
        if (readInt != 1179210240) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("'FIR' marker expected! Found ");
            stringBuilder.append(Integer.toHexString(readInt));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        readInt = dataInputStream.readInt();
        if (readInt != 808529920) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("'010' version number expected! Found ");
            stringBuilder.append(Integer.toHexString(readInt));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long e = e(dataInputStream, 6);
        this.captureDeviceId = dataInputStream.readUnsignedShort();
        this.acquisitionLevel = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        this.scaleUnits = dataInputStream.readUnsignedByte();
        this.scanResolutionHorizontal = dataInputStream.readUnsignedShort();
        this.scanResolutionVertical = dataInputStream.readUnsignedShort();
        this.imageResolutionHorizontal = dataInputStream.readUnsignedShort();
        this.imageResolutionVertical = dataInputStream.readUnsignedShort();
        this.depth = dataInputStream.readUnsignedByte();
        this.compressionAlgorithm = dataInputStream.readUnsignedByte();
        dataInputStream.readUnsignedShort();
        long j = e - 32;
        long j2 = 0;
        int i = 0;
        while (i < readUnsignedByte) {
            Serializable fingerImageInfo = new FingerImageInfo(inputStream, this.compressionAlgorithm);
            long bBD = j2 + fingerImageInfo.bBD();
            add(fingerImageInfo);
            i++;
            j2 = bBD;
        }
        if (j != j2) {
            Logger logger = LOGGER;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DEBUG: constructedDataLength and dataLength differ: dataLength = ");
            stringBuilder2.append(j);
            stringBuilder2.append(", constructedDataLength = ");
            stringBuilder2.append(j2);
            logger.warning(stringBuilder2.toString());
        }
    }

    public void f(OutputStream outputStream) {
        List<FingerImageInfo> bAC = bAC();
        long j = 0;
        for (FingerImageInfo bBD : bAC) {
            j += bBD.bBD();
        }
        long j2 = j + 32;
        outputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        outputStream.writeInt(1179210240);
        outputStream.writeInt(808529920);
        a(j2, outputStream, 6);
        outputStream.writeShort(this.captureDeviceId);
        outputStream.writeShort(this.acquisitionLevel);
        outputStream.writeByte(bAC.size());
        outputStream.writeByte(this.scaleUnits);
        outputStream.writeShort(this.scanResolutionHorizontal);
        outputStream.writeShort(this.scanResolutionVertical);
        outputStream.writeShort(this.imageResolutionHorizontal);
        outputStream.writeShort(this.imageResolutionVertical);
        outputStream.writeByte(this.depth);
        outputStream.writeByte(this.compressionAlgorithm);
        outputStream.writeShort(0);
        for (FingerImageInfo f : bAC) {
            f.f(outputStream);
        }
    }

    public int hashCode() {
        return (((((((((((((((((((super.hashCode() * 31) + this.acquisitionLevel) * 31) + this.captureDeviceId) * 31) + this.compressionAlgorithm) * 31) + this.depth) * 31) + this.imageResolutionHorizontal) * 31) + this.imageResolutionVertical) * 31) + (this.sbh == null ? 0 : this.sbh.hashCode())) * 31) + this.scaleUnits) * 31) + this.scanResolutionHorizontal) * 31) + this.scanResolutionVertical;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        FingerInfo fingerInfo = (FingerInfo) obj;
        if (!(this.acquisitionLevel == fingerInfo.acquisitionLevel && this.captureDeviceId == fingerInfo.captureDeviceId && this.compressionAlgorithm == fingerInfo.compressionAlgorithm && this.depth == fingerInfo.depth && this.imageResolutionHorizontal == fingerInfo.imageResolutionHorizontal && this.imageResolutionVertical == fingerInfo.imageResolutionVertical && this.scaleUnits == fingerInfo.scaleUnits && this.scanResolutionHorizontal == fingerInfo.scanResolutionHorizontal && this.scanResolutionVertical == fingerInfo.scanResolutionVertical)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FingerInfo [");
        for (FingerImageInfo fingerImageInfo : bAC()) {
            stringBuilder.append(fingerImageInfo.toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public StandardBiometricHeader bAB() {
        if (this.sbh == null) {
            Object obj = new byte[]{(byte) 8};
            Object obj2 = new byte[]{(byte) bBN()};
            Object obj3 = new byte[]{(byte) 1, (byte) 1};
            Object obj4 = new byte[]{(byte) 0, (byte) 7};
            Map treeMap = new TreeMap();
            treeMap.put(Integer.valueOf(129), obj);
            treeMap.put(Integer.valueOf(130), obj2);
            treeMap.put(Integer.valueOf(135), obj3);
            treeMap.put(Integer.valueOf(136), obj4);
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    private static long e(InputStream inputStream, int i) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        long j = 0;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            j = (j << 8) + ((long) (bArr[i2] & 255));
        }
        return j;
    }

    private static void a(long j, OutputStream outputStream, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i - 8; i2++) {
                outputStream.write(0);
            }
            if (i > 8) {
                i = 8;
            }
            for (i--; i >= 0; i--) {
                int i3 = i * 8;
                outputStream.write((byte) ((int) ((j & (255 << i3)) >> i3)));
            }
        }
    }

    private int bBN() {
        Object obj = 1;
        int i = 0;
        for (FingerImageInfo bBN : bAC()) {
            int bBN2 = bBN.bBN();
            if (obj != null) {
                i = bBN2;
                obj = null;
            } else {
                i &= bBN2;
            }
        }
        return i;
    }
}
