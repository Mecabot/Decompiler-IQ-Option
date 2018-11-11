package org.jmrtd.lds;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CVCAFile extends AbstractLDSFile {
    private static final long serialVersionUID = -1100904058684365703L;
    private String altCaReference;
    private String caReference;
    private short fid;

    public CVCAFile(InputStream inputStream) {
        this((short) 284, inputStream);
    }

    public CVCAFile(short s, InputStream inputStream) {
        this.caReference = null;
        this.altCaReference = null;
        this.fid = s;
        q(inputStream);
    }

    public short bAO() {
        return this.fid;
    }

    protected void q(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int read = dataInputStream.read();
        if (read != 66) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrong tag, expected ");
            stringBuilder.append(Integer.toHexString(66));
            stringBuilder.append(", found ");
            stringBuilder.append(Integer.toHexString(read));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        read = dataInputStream.read();
        if (read > 16) {
            throw new IllegalArgumentException("Wrong length");
        }
        byte[] bArr = new byte[read];
        dataInputStream.readFully(bArr);
        this.caReference = new String(bArr);
        read = dataInputStream.read();
        if (!(read == 0 || read == -1)) {
            if (read != 66) {
                throw new IllegalArgumentException("Wrong tag");
            }
            read = dataInputStream.read();
            if (read > 16) {
                throw new IllegalArgumentException("Wrong length");
            }
            bArr = new byte[read];
            dataInputStream.readFully(bArr);
            this.altCaReference = new String(bArr);
            read = dataInputStream.read();
        }
        while (read != -1) {
            if (read != 0) {
                throw new IllegalArgumentException("Bad file padding");
            }
            read = dataInputStream.read();
        }
    }

    protected void f(OutputStream outputStream) {
        Object obj = new byte[36];
        obj[0] = 66;
        obj[1] = (byte) this.caReference.length();
        System.arraycopy(this.caReference.getBytes(), 0, obj, 2, obj[1]);
        if (this.altCaReference != null) {
            int i = obj[1] + 2;
            obj[i] = 66;
            int i2 = i + 1;
            obj[i2] = (byte) this.altCaReference.length();
            System.arraycopy(this.altCaReference.getBytes(), 0, obj, i + 2, obj[i2]);
        }
        outputStream.write(obj);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("CA reference: \"");
        stringBuilder2.append(this.caReference);
        stringBuilder2.append("\"");
        if (this.altCaReference != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(", Alternative CA reference: ");
            stringBuilder3.append(this.altCaReference);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        CVCAFile cVCAFile = (CVCAFile) obj;
        if (this.caReference.equals(cVCAFile.caReference) && ((this.altCaReference == null && cVCAFile.altCaReference == null) || (this.altCaReference != null && this.altCaReference.equals(cVCAFile.altCaReference)))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((this.caReference.hashCode() * 11) + (this.altCaReference != null ? this.altCaReference.hashCode() * 13 : 0)) + 5;
    }
}
