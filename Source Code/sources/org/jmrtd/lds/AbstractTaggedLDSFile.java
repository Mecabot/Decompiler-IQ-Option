package org.jmrtd.lds;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.io.c;

public abstract class AbstractTaggedLDSFile extends AbstractLDSFile {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -4761360877353069639L;
    private int length;
    private int tag;

    public abstract void g(OutputStream outputStream);

    public abstract void r(InputStream inputStream);

    protected AbstractTaggedLDSFile(int i, InputStream inputStream) {
        this.tag = i;
        q(inputStream);
    }

    protected void q(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag != this.tag) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Was expecting tag ");
            stringBuilder.append(Integer.toHexString(this.tag));
            stringBuilder.append(", found ");
            stringBuilder.append(Integer.toHexString(readTag));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.length = tLVInputStream.readLength();
        r(new c(inputStream, this.length));
    }

    protected void f(OutputStream outputStream) {
        int i;
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        int tag = getTag();
        if (this.tag != tag) {
            this.tag = tag;
        }
        tLVOutputStream.writeTag(tag);
        byte[] bAJ = bAJ();
        if (bAJ == null) {
            i = 0;
        } else {
            i = bAJ.length;
        }
        if (this.length != i) {
            this.length = i;
        }
        tLVOutputStream.writeValue(bAJ);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaggedLDSFile [");
        stringBuilder.append(Integer.toHexString(getTag()));
        stringBuilder.append(" (");
        stringBuilder.append(getLength());
        stringBuilder.append(")]");
        return stringBuilder.toString();
    }

    public int getTag() {
        return this.tag;
    }

    private byte[] bAJ() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e) {
                LOGGER.log(Level.FINE, "Error closing stream", e);
            }
            return toByteArray;
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not get DG content", e2);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
        }
    }

    public int getLength() {
        if (this.length <= 0) {
            this.length = bAJ().length;
        }
        return this.length;
    }
}
