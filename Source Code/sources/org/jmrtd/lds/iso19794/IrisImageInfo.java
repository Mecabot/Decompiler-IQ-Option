package org.jmrtd.lds.iso19794;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.jmrtd.lds.AbstractImageInfo;

public class IrisImageInfo extends AbstractImageInfo {
    private static final long serialVersionUID = 833541246115625112L;
    private int imageFormat;
    private int imageNumber;
    private int quality;
    private int rotationAngle;
    private int rotationAngleUncertainty;

    private static String mD(int i) {
        return (i == 2 || i == 4) ? "image/x-wsq" : (i == 6 || i == 8 || i == 10 || i == 12) ? "image/jpeg" : (i == 14 || i == 16) ? "image/jp2" : null;
    }

    IrisImageInfo(InputStream inputStream, int i) {
        super(3);
        this.imageFormat = i;
        setMimeType(mD(i));
        q(inputStream);
    }

    public long bBD() {
        return ((long) bAG()) + 11;
    }

    public int hashCode() {
        return (((((((((super.hashCode() * 31) + this.imageFormat) * 31) + this.imageNumber) * 31) + this.quality) * 31) + this.rotationAngle) * 31) + this.rotationAngleUncertainty;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisImageInfo irisImageInfo = (IrisImageInfo) obj;
        if (!(this.imageFormat == irisImageInfo.imageFormat && this.imageNumber == irisImageInfo.imageNumber && this.quality == irisImageInfo.quality && this.rotationAngle == irisImageInfo.rotationAngle && this.rotationAngleUncertainty == irisImageInfo.rotationAngleUncertainty)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IrisImageInfo [");
        stringBuilder.append("image number: ");
        stringBuilder.append(this.imageNumber);
        stringBuilder.append(", ");
        stringBuilder.append("quality: ");
        stringBuilder.append(this.quality);
        stringBuilder.append(", ");
        stringBuilder.append("image: ");
        stringBuilder.append(getWidth());
        stringBuilder.append(" x ");
        stringBuilder.append(getHeight());
        stringBuilder.append("mime-type: ");
        stringBuilder.append(mD(this.imageFormat));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected void q(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.imageNumber = dataInputStream.readUnsignedShort();
        this.quality = dataInputStream.readUnsignedByte();
        this.rotationAngle = dataInputStream.readShort();
        this.rotationAngleUncertainty = dataInputStream.readUnsignedShort();
        a(inputStream, ((long) dataInputStream.readInt()) & 4294967295L);
    }

    protected void f(OutputStream outputStream) {
        outputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        outputStream.writeShort(this.imageNumber);
        outputStream.writeByte(this.quality);
        outputStream.writeShort(this.rotationAngle);
        outputStream.writeShort(this.rotationAngleUncertainty);
        outputStream.writeInt(bAG());
        e(outputStream);
    }
}
