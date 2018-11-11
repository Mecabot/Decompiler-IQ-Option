package org.jmrtd.lds;

import java.io.InputStream;
import java.io.OutputStream;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;

public class DisplayedImageInfo extends AbstractImageInfo {
    private static final long serialVersionUID = 3801320585294302721L;
    private int displayedImageTag;

    public DisplayedImageInfo(InputStream inputStream) {
        q(inputStream);
    }

    protected void q(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        this.displayedImageTag = tLVInputStream.readTag();
        if (this.displayedImageTag == 24384 || this.displayedImageTag == 24387) {
            int mr = mr(this.displayedImageTag);
            setType(mr);
            setMimeType(mp(mr));
            a(tLVInputStream, (long) tLVInputStream.readLength());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected tag 0x5F40 or 0x5F43, found ");
        stringBuilder.append(Integer.toHexString(this.displayedImageTag));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected void f(OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(mq(getType()));
        e(tLVOutputStream);
        tLVOutputStream.writeValueEnd();
    }

    int bAR() {
        return this.displayedImageTag;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.displayedImageTag;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.displayedImageTag != ((DisplayedImageInfo) obj).displayedImageTag) {
            z = false;
        }
        return z;
    }

    private static String mp(int i) {
        switch (i) {
            case 0:
                return "image/jpeg";
            case 1:
                return "image/jpeg";
            case 2:
                return "image/x-wsq";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new NumberFormatException(stringBuilder.toString());
        }
    }

    private static int mq(int i) {
        switch (i) {
            case 0:
                return 24384;
            case 1:
                return 24387;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown type: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new NumberFormatException(stringBuilder.toString());
        }
    }

    private static int mr(int i) {
        if (i == 24384) {
            return 0;
        }
        if (i == 24387) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown tag: ");
        stringBuilder.append(Integer.toHexString(i));
        throw new NumberFormatException(stringBuilder.toString());
    }
}
