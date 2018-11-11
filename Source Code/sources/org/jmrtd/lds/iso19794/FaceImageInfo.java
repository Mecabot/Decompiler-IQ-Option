package org.jmrtd.lds.iso19794;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import net.sf.scuba.data.Gender;
import org.jmrtd.lds.AbstractImageInfo;

public class FaceImageInfo extends AbstractImageInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -1751069410327594067L;
    private int colorSpace;
    private int deviceType;
    private int expression;
    private EyeColor eyeColor;
    private int faceImageType;
    private int featureMask;
    private FeaturePoint[] featurePoints;
    private Gender gender;
    private int hairColor;
    private int imageDataType;
    private int[] poseAngle;
    private int[] poseAngleUncertainty;
    private int quality;
    private long recordLength;
    private int sourceType;

    public enum EyeColor {
        UNSPECIFIED {
            public int toInt() {
                return 0;
            }
        },
        BLACK {
            public int toInt() {
                return 1;
            }
        },
        BLUE {
            public int toInt() {
                return 2;
            }
        },
        BROWN {
            public int toInt() {
                return 3;
            }
        },
        GRAY {
            public int toInt() {
                return 4;
            }
        },
        GREEN {
            public int toInt() {
                return 5;
            }
        },
        MULTI_COLORED {
            public int toInt() {
                return 6;
            }
        },
        PINK {
            public int toInt() {
                return 7;
            }
        },
        UNKNOWN {
            public int toInt() {
                return 8;
            }
        };

        public abstract int toInt();

        static EyeColor toEyeColor(int i) {
            for (EyeColor eyeColor : values()) {
                if (eyeColor.toInt() == i) {
                    return eyeColor;
                }
            }
            return UNKNOWN;
        }
    }

    public static class FeaturePoint implements Serializable {
        private static final long serialVersionUID = -4209679423938065215L;
        private int majorCode;
        private int minorCode;
        private int type;
        private int x;
        private int y;

        public FeaturePoint(int i, int i2, int i3, int i4, int i5) {
            this.type = i;
            this.majorCode = i2;
            this.minorCode = i3;
            this.x = i4;
            this.y = i5;
        }

        FeaturePoint(int i, byte b, int i2, int i3) {
            this(i, (b & 240) >> 4, b & 15, i2, i3);
        }

        public int bBK() {
            return this.majorCode;
        }

        public int bBL() {
            return this.minorCode;
        }

        public int getType() {
            return this.type;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("( point: ");
            stringBuilder.append(bBK());
            stringBuilder.append(".");
            stringBuilder.append(bBL());
            stringBuilder.append(", ");
            stringBuilder.append("type: ");
            stringBuilder.append(Integer.toHexString(this.type));
            stringBuilder.append(", ");
            stringBuilder.append("(");
            stringBuilder.append(this.x);
            stringBuilder.append(", ");
            stringBuilder.append(this.y);
            stringBuilder.append(")");
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public FaceImageInfo(InputStream inputStream) {
        super(0);
        q(inputStream);
    }

    protected void q(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.recordLength = ((long) dataInputStream.readInt()) & 4294967295L;
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        this.gender = Gender.getInstance(dataInputStream.readUnsignedByte());
        this.eyeColor = EyeColor.toEyeColor(dataInputStream.readUnsignedByte());
        this.hairColor = dataInputStream.readUnsignedByte();
        this.featureMask = dataInputStream.readUnsignedByte();
        this.featureMask = (this.featureMask << 16) | dataInputStream.readUnsignedShort();
        this.expression = dataInputStream.readShort();
        this.poseAngle = new int[3];
        int i = 0;
        this.poseAngle[0] = dataInputStream.readUnsignedByte();
        this.poseAngle[1] = dataInputStream.readUnsignedByte();
        this.poseAngle[2] = dataInputStream.readUnsignedByte();
        this.poseAngleUncertainty = new int[3];
        this.poseAngleUncertainty[0] = dataInputStream.readUnsignedByte();
        this.poseAngleUncertainty[1] = dataInputStream.readUnsignedByte();
        this.poseAngleUncertainty[2] = dataInputStream.readUnsignedByte();
        this.featurePoints = new FeaturePoint[readUnsignedShort];
        while (i < readUnsignedShort) {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte readByte = dataInputStream.readByte();
            int readUnsignedShort2 = dataInputStream.readUnsignedShort();
            int readUnsignedShort3 = dataInputStream.readUnsignedShort();
            for (long j = 0; j < 2; j += dataInputStream.skip(2)) {
            }
            this.featurePoints[i] = new FeaturePoint(readUnsignedByte, readByte, readUnsignedShort2, readUnsignedShort3);
            i++;
        }
        this.faceImageType = dataInputStream.readUnsignedByte();
        this.imageDataType = dataInputStream.readUnsignedByte();
        setWidth(dataInputStream.readUnsignedShort());
        setHeight(dataInputStream.readUnsignedShort());
        this.colorSpace = dataInputStream.readUnsignedByte();
        this.sourceType = dataInputStream.readUnsignedByte();
        this.deviceType = dataInputStream.readUnsignedShort();
        this.quality = dataInputStream.readUnsignedShort();
        if (getWidth() <= 0) {
            setWidth(800);
        }
        if (getHeight() <= 0) {
            setHeight(600);
        }
        setMimeType(my(this.imageDataType));
        a(inputStream, ((this.recordLength - 20) - ((long) (readUnsignedShort * 8))) - 12);
    }

    public void f(OutputStream outputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i(byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        long length = ((long) toByteArray.length) + 4;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt((int) length);
        dataOutputStream.write(toByteArray);
        dataOutputStream.flush();
    }

    public long bBD() {
        return this.recordLength;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Image size: ");
        stringBuilder.append(getWidth());
        stringBuilder.append(" x ");
        stringBuilder.append(getHeight());
        stringBuilder.append("\n");
        stringBuilder.append("Gender: ");
        stringBuilder.append(this.gender == null ? Gender.UNSPECIFIED : this.gender);
        stringBuilder.append("\n");
        stringBuilder.append("Eye color: ");
        stringBuilder.append(this.eyeColor == null ? EyeColor.UNSPECIFIED : this.eyeColor);
        stringBuilder.append("\n");
        stringBuilder.append("Hair color: ");
        stringBuilder.append(bBE());
        stringBuilder.append("\n");
        stringBuilder.append("Feature mask: ");
        stringBuilder.append(bBF());
        stringBuilder.append("\n");
        stringBuilder.append("Expression: ");
        stringBuilder.append(bBG());
        stringBuilder.append("\n");
        stringBuilder.append("Pose angle: ");
        stringBuilder.append(bBH());
        stringBuilder.append("\n");
        stringBuilder.append("Face image type: ");
        stringBuilder.append(bBI());
        stringBuilder.append("\n");
        stringBuilder.append("Source type: ");
        stringBuilder.append(bBJ());
        stringBuilder.append("\n");
        stringBuilder.append("Feature points: ");
        stringBuilder.append("\n");
        if (this.featurePoints == null || this.featurePoints.length == 0) {
            stringBuilder.append("   (none)\n");
        } else {
            for (FeaturePoint featurePoint : this.featurePoints) {
                stringBuilder.append("   ");
                stringBuilder.append(featurePoint.toString());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((super.hashCode() * 31) + this.colorSpace) * 31) + this.deviceType) * 31) + this.expression) * 31) + (this.eyeColor == null ? 0 : this.eyeColor.hashCode())) * 31) + this.faceImageType) * 31) + this.featureMask) * 31) + Arrays.hashCode(this.featurePoints)) * 31;
        if (this.gender != null) {
            i = this.gender.hashCode();
        }
        return ((((((((((((((hashCode + i) * 31) + this.hairColor) * 31) + this.imageDataType) * 31) + Arrays.hashCode(this.poseAngle)) * 31) + Arrays.hashCode(this.poseAngleUncertainty)) * 31) + this.quality) * 31) + ((int) (this.recordLength ^ (this.recordLength >>> 32)))) * 31) + this.sourceType;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        FaceImageInfo faceImageInfo = (FaceImageInfo) obj;
        if (!(this.colorSpace == faceImageInfo.colorSpace && this.deviceType == faceImageInfo.deviceType && this.expression == faceImageInfo.expression && this.eyeColor == faceImageInfo.eyeColor && this.faceImageType == faceImageInfo.faceImageType && this.featureMask == faceImageInfo.featureMask && Arrays.equals(this.featurePoints, faceImageInfo.featurePoints) && this.gender == faceImageInfo.gender && this.hairColor == faceImageInfo.hairColor && this.imageDataType == faceImageInfo.imageDataType && Arrays.equals(this.poseAngle, faceImageInfo.poseAngle) && Arrays.equals(this.poseAngleUncertainty, faceImageInfo.poseAngleUncertainty) && this.quality == faceImageInfo.quality && this.recordLength == faceImageInfo.recordLength && this.sourceType == faceImageInfo.sourceType)) {
            z = false;
        }
        return z;
    }

    private void i(OutputStream outputStream) {
        int i;
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeShort(this.featurePoints.length);
        dataOutputStream.writeByte((this.gender == null ? Gender.UNSPECIFIED : this.gender).toInt());
        dataOutputStream.writeByte((this.eyeColor == null ? EyeColor.UNSPECIFIED : this.eyeColor).toInt());
        dataOutputStream.writeByte(this.hairColor);
        dataOutputStream.writeByte((byte) ((int) ((((long) this.featureMask) & 16711680) >> 16)));
        dataOutputStream.writeByte((byte) ((int) ((((long) this.featureMask) & 65280) >> 8)));
        dataOutputStream.writeByte((byte) ((int) (((long) this.featureMask) & 255)));
        dataOutputStream.writeShort(this.expression);
        for (i = 0; i < 3; i++) {
            dataOutputStream.writeByte(this.poseAngle[i]);
        }
        for (i = 0; i < 3; i++) {
            dataOutputStream.writeByte(this.poseAngleUncertainty[i]);
        }
        for (FeaturePoint featurePoint : this.featurePoints) {
            dataOutputStream.writeByte(featurePoint.getType());
            dataOutputStream.writeByte((featurePoint.bBK() << 4) | featurePoint.bBL());
            dataOutputStream.writeShort(featurePoint.getX());
            dataOutputStream.writeShort(featurePoint.getY());
            dataOutputStream.writeShort(0);
        }
        dataOutputStream.writeByte(this.faceImageType);
        dataOutputStream.writeByte(this.imageDataType);
        dataOutputStream.writeShort(getWidth());
        dataOutputStream.writeShort(getHeight());
        dataOutputStream.writeByte(this.colorSpace);
        dataOutputStream.writeByte(this.sourceType);
        dataOutputStream.writeShort(this.deviceType);
        dataOutputStream.writeShort(this.quality);
        e(dataOutputStream);
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    private String bBE() {
        switch (this.hairColor) {
            case 0:
                return "unspecified";
            case 1:
                return "bald";
            case 2:
                return "black";
            case 3:
                return "blonde";
            case 4:
                return "brown";
            case 5:
                return "gray";
            case 6:
                return "white";
            case 7:
                return "red";
            case 8:
                return "green";
            case 9:
                return "blue";
            default:
                return "unknown";
        }
    }

    private String bBF() {
        if ((this.featureMask & 1) == 0) {
            return "";
        }
        Collection arrayList = new ArrayList();
        if ((this.featureMask & 2) != 0) {
            arrayList.add("glasses");
        }
        if ((this.featureMask & 4) != 0) {
            arrayList.add("moustache");
        }
        if ((this.featureMask & 8) != 0) {
            arrayList.add("beard");
        }
        if ((this.featureMask & 16) != 0) {
            arrayList.add("teeth visible");
        }
        if ((this.featureMask & 32) != 0) {
            arrayList.add("blink");
        }
        if ((this.featureMask & 64) != 0) {
            arrayList.add("mouth open");
        }
        if ((this.featureMask & 128) != 0) {
            arrayList.add("left eye patch");
        }
        if ((this.featureMask & 256) != 0) {
            arrayList.add("right eye patch");
        }
        if ((this.featureMask & 512) != 0) {
            arrayList.add("dark glasses");
        }
        if ((this.featureMask & 1024) != 0) {
            arrayList.add("distorting medical condition (which could impact feature point detection)");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    private String bBG() {
        switch (this.expression) {
            case 0:
                return "unspecified";
            case 1:
                return "neutral (non-smiling) with both eyes open and mouth closed";
            case 2:
                return "a smile where the inside of the mouth and/or teeth is not exposed (closed jaw)";
            case 3:
                return "a smile where the inside of the mouth and/or teeth is exposed";
            case 4:
                return "raised eyebrows";
            case 5:
                return "eyes looking away from the camera";
            case 6:
                return "squinting";
            case 7:
                return "frowning";
            default:
                return "unknown";
        }
    }

    private String bBH() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append("y: ");
        stringBuilder.append(this.poseAngle[0]);
        if (this.poseAngleUncertainty[0] != 0) {
            stringBuilder.append(" (");
            stringBuilder.append(this.poseAngleUncertainty[0]);
            stringBuilder.append(")");
        }
        stringBuilder.append(", ");
        stringBuilder.append("p:");
        stringBuilder.append(this.poseAngle[1]);
        if (this.poseAngleUncertainty[1] != 0) {
            stringBuilder.append(" (");
            stringBuilder.append(this.poseAngleUncertainty[1]);
            stringBuilder.append(")");
        }
        stringBuilder.append(", ");
        stringBuilder.append("r: ");
        stringBuilder.append(this.poseAngle[2]);
        if (this.poseAngleUncertainty[2] != 0) {
            stringBuilder.append(" (");
            stringBuilder.append(this.poseAngleUncertainty[2]);
            stringBuilder.append(")");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private String bBI() {
        switch (this.faceImageType) {
            case 0:
                return "basic";
            case 1:
                return "full frontal";
            case 2:
                return "token frontal";
            default:
                return "unknown";
        }
    }

    private String bBJ() {
        switch (this.sourceType) {
            case 0:
                return "unspecified";
            case 1:
                return "static photograph from an unknown source";
            case 2:
                return "static photograph from a digital still-image camera";
            case 3:
                return "static photograph from a scanner";
            case 4:
                return "single video frame from an unknown source";
            case 5:
                return "single video frame from an analogue camera";
            case 6:
                return "single video frame from a digital camera";
            default:
                return "unknown";
        }
    }

    private static String my(int i) {
        Logger logger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DEBUG: Image type: ");
        stringBuilder.append(i);
        logger.info(stringBuilder.toString());
        switch (i) {
            case 0:
                return "image/jpeg";
            case 1:
                return "image/jp2";
            default:
                logger = LOGGER;
                stringBuilder = new StringBuilder();
                stringBuilder.append("DEBUG: Unknown image type: ");
                stringBuilder.append(i);
                logger.info(stringBuilder.toString());
                return null;
        }
    }
}
