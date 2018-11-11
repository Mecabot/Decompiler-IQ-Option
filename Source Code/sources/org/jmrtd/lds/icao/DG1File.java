package org.jmrtd.lds.icao;

import java.io.InputStream;
import java.io.OutputStream;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.lds.DataGroup;

public class DG1File extends DataGroup {
    private static final long serialVersionUID = 5091606125728809058L;
    private MRZInfo mrzInfo;

    public DG1File(InputStream inputStream) {
        super(97, inputStream);
    }

    protected void r(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        tLVInputStream.skipToTag(24351);
        this.mrzInfo = new MRZInfo(tLVInputStream, tLVInputStream.readLength());
    }

    public MRZInfo bBw() {
        return this.mrzInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DG1File ");
        stringBuilder.append(this.mrzInfo.toString().replaceAll("\n", "").trim());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return this.mrzInfo.equals(((DG1File) obj).mrzInfo);
    }

    public int hashCode() {
        return (this.mrzInfo.hashCode() * 3) + 57;
    }

    protected void g(OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(24351);
        tLVOutputStream.writeValue(this.mrzInfo.getEncoded());
    }
}
