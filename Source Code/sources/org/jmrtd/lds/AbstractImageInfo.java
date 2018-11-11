package org.jmrtd.lds;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.io.c;

public abstract class AbstractImageInfo implements ImageInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2870092217269116309L;
    private transient c fco;
    private int height;
    private byte[] imageBytes;
    int imageLength;
    int imagePositionInInputStream;
    private String mimeType;
    private int type;
    private int width;

    public abstract void f(OutputStream outputStream);

    public abstract void q(InputStream inputStream);

    AbstractImageInfo() {
    }

    protected AbstractImageInfo(int i) {
        this.type = i;
    }

    protected AbstractImageInfo(int i, String str) {
        this(i);
        this.mimeType = str;
    }

    public int getType() {
        return this.type;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int bAG() {
        if (this.fco != null) {
            return this.imageLength;
        }
        if (this.imageBytes != null) {
            return this.imageBytes.length;
        }
        throw new IllegalStateException("Cannot get length of null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" [");
        stringBuilder.append("type: ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(typeToString(this.type));
        stringBuilder2.append(", ");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("size: ");
        stringBuilder.append(bAG());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return ((-591263623 + (this.type * 5)) + (((this.mimeType == null ? 1337 : this.mimeType.hashCode()) * 5) + 7)) + ((bAG() * 7) + 11);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            if (!obj.getClass().equals(getClass())) {
                return false;
            }
            AbstractImageInfo abstractImageInfo = (AbstractImageInfo) obj;
            if (Arrays.equals(bAI(), abstractImageInfo.bAI()) && (((this.mimeType == null && abstractImageInfo.mimeType == null) || (this.mimeType != null && this.mimeType.equals(abstractImageInfo.mimeType))) && this.type == abstractImageInfo.type)) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception");
            stringBuilder.append(e);
            logger.log(level, stringBuilder.toString());
            return false;
        }
    }

    public byte[] getEncoded() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }

    public InputStream bAH() {
        if (this.fco != null) {
            return this.fco.hI(this.imagePositionInInputStream);
        }
        if (this.imageBytes != null) {
            return new ByteArrayInputStream(this.imageBytes);
        }
        throw new IllegalStateException("DEBUG");
    }

    protected void a(InputStream inputStream, long j) {
        this.fco = null;
        this.imageBytes = new byte[((int) j)];
        new DataInputStream(inputStream).readFully(this.imageBytes);
    }

    protected void e(OutputStream outputStream) {
        outputStream.write(bAI());
    }

    protected final void setMimeType(String str) {
        this.mimeType = str;
    }

    protected final void setType(int i) {
        this.type = i;
    }

    protected final void setWidth(int i) {
        this.width = i;
    }

    protected final void setHeight(int i) {
        this.height = i;
    }

    private byte[] bAI() {
        byte[] bArr = new byte[bAG()];
        new DataInputStream(bAH()).readFully(bArr);
        return bArr;
    }

    private static String typeToString(int i) {
        switch (i) {
            case 0:
                return "Portrait";
            case 1:
                return "Signature or usual mark";
            case 2:
                return "Finger";
            case 3:
                return "Iris";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new NumberFormatException(stringBuilder.toString());
        }
    }
}
