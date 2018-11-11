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

public class IrisInfo extends AbstractListInfo<IrisBiometricSubtypeInfo> implements BiometricDataBlock {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -3415309711643815511L;
    private int boundaryExtraction;
    private int captureDeviceId;
    private byte[] deviceUniqueId;
    private int horizontalOrientation;
    private int imageFormat;
    private int imageTransformation;
    private int intensityDepth;
    private int irisDiameter;
    private int irisOcclusion;
    private int occlusionFilling;
    private int rawImageHeight;
    private int rawImageWidth;
    private long recordLength;
    private StandardBiometricHeader sbh;
    private int scanType;
    private int verticalOrientation;

    public IrisInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) {
        this.sbh = standardBiometricHeader;
        q(inputStream);
    }

    public void q(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        StringBuilder stringBuilder;
        if (readInt != 1229541888) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("'IIR' marker expected! Found ");
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
        this.recordLength = (long) dataInputStream.readInt();
        long j = this.recordLength - 45;
        this.captureDeviceId = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (((long) readUnsignedShort) != 45) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected header length ");
            stringBuilder.append(45);
            stringBuilder.append(", found ");
            stringBuilder.append(readUnsignedShort);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        readInt = dataInputStream.readUnsignedShort();
        this.horizontalOrientation = readInt & 3;
        this.verticalOrientation = (readInt & 12) >> 2;
        this.scanType = (readInt & 112) >> 4;
        this.irisOcclusion = (readInt & 128) >> 7;
        this.occlusionFilling = (readInt & 256) >> 8;
        this.boundaryExtraction = (readInt & 512) >> 9;
        this.irisDiameter = dataInputStream.readUnsignedShort();
        this.imageFormat = dataInputStream.readUnsignedShort();
        this.rawImageWidth = dataInputStream.readUnsignedShort();
        this.rawImageHeight = dataInputStream.readUnsignedShort();
        this.intensityDepth = dataInputStream.readUnsignedByte();
        this.imageTransformation = dataInputStream.readUnsignedByte();
        this.deviceUniqueId = new byte[16];
        dataInputStream.readFully(this.deviceUniqueId);
        long j2 = 0;
        int i = 0;
        while (i < readUnsignedByte) {
            Serializable irisBiometricSubtypeInfo = new IrisBiometricSubtypeInfo(inputStream, this.imageFormat);
            long bBD = j2 + irisBiometricSubtypeInfo.bBD();
            add(irisBiometricSubtypeInfo);
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
        List<IrisBiometricSubtypeInfo> bAC = bAC();
        int i = 0;
        for (IrisBiometricSubtypeInfo bBD : bAC) {
            i = (int) (((long) i) + bBD.bBD());
        }
        i += 45;
        DataOutputStream dataOutputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        dataOutputStream.writeInt(1229541888);
        dataOutputStream.writeInt(808529920);
        dataOutputStream.writeInt(i);
        dataOutputStream.writeShort(this.captureDeviceId);
        dataOutputStream.writeByte(bAC.size());
        dataOutputStream.writeShort(45);
        dataOutputStream.writeShort(((((((this.horizontalOrientation & 3) | 0) | ((this.verticalOrientation << 2) & 12)) | ((this.scanType << 4) & 112)) | ((this.irisOcclusion << 7) & 128)) | ((this.occlusionFilling << 8) & 256)) | ((this.boundaryExtraction << 9) & 512));
        dataOutputStream.writeShort(this.irisDiameter);
        dataOutputStream.writeShort(this.imageFormat);
        dataOutputStream.writeShort(this.rawImageWidth);
        dataOutputStream.writeShort(this.rawImageHeight);
        dataOutputStream.writeByte(this.intensityDepth);
        dataOutputStream.writeByte(this.imageTransformation);
        dataOutputStream.write(this.deviceUniqueId);
        for (IrisBiometricSubtypeInfo f : bAC) {
            f.f(outputStream);
        }
    }

    public StandardBiometricHeader bAB() {
        if (this.sbh == null) {
            Object obj = new byte[]{(byte) 8};
            Object obj2 = new byte[]{(byte) bBN()};
            Object obj3 = new byte[]{(byte) 1, (byte) 1};
            Object obj4 = new byte[]{(byte) 0, (byte) 9};
            Map treeMap = new TreeMap();
            treeMap.put(Integer.valueOf(129), obj);
            treeMap.put(Integer.valueOf(130), obj2);
            treeMap.put(Integer.valueOf(135), obj3);
            treeMap.put(Integer.valueOf(136), obj4);
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IrisInfo [");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private int bBN() {
        int i = 0;
        for (IrisBiometricSubtypeInfo bBN : bAC()) {
            i &= bBN.bBN();
        }
        return i;
    }
}
