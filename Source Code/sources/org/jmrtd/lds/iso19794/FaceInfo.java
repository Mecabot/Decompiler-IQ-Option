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

public class FaceInfo extends AbstractListInfo<FaceImageInfo> implements BiometricDataBlock {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -6053206262773400725L;
    private StandardBiometricHeader sbh;

    public FaceInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) {
        this.sbh = standardBiometricHeader;
        q(inputStream);
    }

    public void q(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        StringBuilder stringBuilder;
        if (readInt != 1178682112) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("'FAC' marker expected! Found ");
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
        long readInt2 = (((long) dataInputStream.readInt()) & 4294967295L) - 14;
        long j = 0;
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int i = 0;
        while (i < readUnsignedShort) {
            Serializable faceImageInfo = new FaceImageInfo(inputStream);
            long bBD = j + faceImageInfo.bBD();
            add(faceImageInfo);
            i++;
            j = bBD;
        }
        if (readInt2 != j) {
            Logger logger = LOGGER;
            stringBuilder = new StringBuilder();
            stringBuilder.append("DEBUG: constructedDataLength and dataLength differ: dataLength = ");
            stringBuilder.append(readInt2);
            stringBuilder.append(", constructedDataLength = ");
            stringBuilder.append(j);
            logger.warning(stringBuilder.toString());
        }
    }

    public void f(OutputStream outputStream) {
        List<FaceImageInfo> bAC = bAC();
        long j = 0;
        for (FaceImageInfo bBD : bAC) {
            j += bBD.bBD();
        }
        long j2 = ((long) 14) + j;
        outputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        outputStream.writeInt(1178682112);
        outputStream.writeInt(808529920);
        outputStream.writeInt((int) (j2 & 4294967295L));
        outputStream.writeShort(bAC.size());
        for (FaceImageInfo f : bAC) {
            f.f(outputStream);
        }
    }

    public StandardBiometricHeader bAB() {
        if (this.sbh == null) {
            Object obj = new byte[]{2};
            Object obj2 = new byte[]{null};
            Object obj3 = new byte[]{(byte) 1, (byte) 1};
            Object obj4 = new byte[]{(byte) 0, (byte) 8};
            Map treeMap = new TreeMap();
            treeMap.put(Integer.valueOf(129), obj);
            treeMap.put(Integer.valueOf(130), obj2);
            treeMap.put(Integer.valueOf(135), obj3);
            treeMap.put(Integer.valueOf(136), obj4);
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public List<FaceImageInfo> bBM() {
        return bAC();
    }
}
