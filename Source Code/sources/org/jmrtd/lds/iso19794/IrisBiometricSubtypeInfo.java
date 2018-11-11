package org.jmrtd.lds.iso19794;

import android.support.v4.internal.view.SupportMenu;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import org.jmrtd.lds.AbstractListInfo;

public class IrisBiometricSubtypeInfo extends AbstractListInfo<IrisImageInfo> {
    private static final long serialVersionUID = -6588640634764878039L;
    private int biometricSubtype;
    private int imageFormat;

    public IrisBiometricSubtypeInfo(InputStream inputStream, int i) {
        this.imageFormat = i;
        q(inputStream);
    }

    public void q(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.biometricSubtype = dataInputStream.readUnsignedByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            Serializable irisImageInfo = new IrisImageInfo(inputStream, this.imageFormat);
            irisImageInfo.bBD();
            add(irisImageInfo);
        }
    }

    public void f(OutputStream outputStream) {
        outputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        outputStream.writeByte(this.biometricSubtype & 255);
        List<IrisImageInfo> bAC = bAC();
        outputStream.writeShort(bAC.size() & SupportMenu.USER_MASK);
        for (IrisImageInfo f : bAC) {
            f.f(outputStream);
        }
    }

    public long bBD() {
        long j = 3;
        for (IrisImageInfo bBD : bAC()) {
            j += bBD.bBD();
        }
        return j;
    }

    public String toString() {
        List bAC = bAC();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IrisBiometricSubtypeInfo [biometric subtype: ");
        stringBuilder.append(mC(this.biometricSubtype));
        stringBuilder.append(", imageCount = ");
        stringBuilder.append(bAC.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int bBN() {
        return this.biometricSubtype;
    }

    private static String mC(int i) {
        switch (i) {
            case 0:
                return "Undefined";
            case 1:
                return "Right eye";
            case 2:
                return "Left eye";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown biometric subtype: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new NumberFormatException(stringBuilder.toString());
        }
    }
}
