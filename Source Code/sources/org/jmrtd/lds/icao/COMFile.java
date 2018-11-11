package org.jmrtd.lds.icao;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.lds.AbstractTaggedLDSFile;
import org.jmrtd.lds.a;

public class COMFile extends AbstractTaggedLDSFile {
    private static final long serialVersionUID = 2002455279067170063L;
    private String majorVersionUnicode;
    private String minorVersionUnicode;
    private String releaseLevelUnicode;
    private List<Integer> tagList;
    private String updateLevelLDS;
    private String versionLDS;

    public COMFile(InputStream inputStream) {
        super(96, inputStream);
    }

    protected void r(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        StringBuilder stringBuilder;
        if (readTag != 24321) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Excepected VERSION_LDS_TAG (");
            stringBuilder.append(Integer.toHexString(24321));
            stringBuilder.append("), found ");
            stringBuilder.append(Integer.toHexString(readTag));
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (tLVInputStream.readLength() != 4) {
            throw new IllegalArgumentException("Wrong length of LDS version object");
        } else {
            byte[] readValue = tLVInputStream.readValue();
            int i = 0;
            this.versionLDS = new String(readValue, 0, 2);
            this.updateLevelLDS = new String(readValue, 2, 2);
            readTag = tLVInputStream.readTag();
            if (readTag != 24374) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Expected VERSION_UNICODE_TAG (");
                stringBuilder2.append(Integer.toHexString(24374));
                stringBuilder2.append("), found ");
                stringBuilder2.append(Integer.toHexString(readTag));
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else if (tLVInputStream.readLength() != 6) {
                throw new IllegalArgumentException("Wrong length of LDS version object");
            } else {
                readValue = tLVInputStream.readValue();
                this.majorVersionUnicode = new String(readValue, 0, 2);
                this.minorVersionUnicode = new String(readValue, 2, 2);
                this.releaseLevelUnicode = new String(readValue, 4, 2);
                readTag = tLVInputStream.readTag();
                if (readTag != 92) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected TAG_LIST_TAG (");
                    stringBuilder.append(Integer.toHexString(92));
                    stringBuilder.append("), found ");
                    stringBuilder.append(Integer.toHexString(readTag));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                tLVInputStream.readLength();
                byte[] readValue2 = tLVInputStream.readValue();
                this.tagList = new ArrayList();
                readTag = readValue2.length;
                while (i < readTag) {
                    this.tagList.add(Integer.valueOf(readValue2[i] & 255));
                    i++;
                }
            }
        }
    }

    public int[] bBa() {
        int[] iArr = new int[this.tagList.size()];
        int i = 0;
        for (Integer intValue : this.tagList) {
            int i2 = i + 1;
            iArr[i] = intValue.intValue();
            i = i2;
        }
        return iArr;
    }

    protected void g(OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(24321);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.versionLDS);
        stringBuilder.append(this.updateLevelLDS);
        tLVOutputStream.writeValue(stringBuilder.toString().getBytes());
        tLVOutputStream.writeTag(24374);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.majorVersionUnicode);
        stringBuilder.append(this.minorVersionUnicode);
        stringBuilder.append(this.releaseLevelUnicode);
        tLVOutputStream.writeValue(stringBuilder.toString().getBytes());
        tLVOutputStream.writeTag(92);
        tLVOutputStream.writeLength(this.tagList.size());
        for (Integer intValue : this.tagList) {
            tLVOutputStream.write((byte) intValue.intValue());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("COMFile ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("LDS ");
        stringBuilder2.append(this.versionLDS);
        stringBuilder2.append(".");
        stringBuilder2.append(this.updateLevelLDS);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(", ");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unicode ");
        stringBuilder2.append(this.majorVersionUnicode);
        stringBuilder2.append(".");
        stringBuilder2.append(this.minorVersionUnicode);
        stringBuilder2.append(".");
        stringBuilder2.append(this.releaseLevelUnicode);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(", ");
        stringBuilder.append("[");
        int size = this.tagList.size();
        int i = 0;
        for (Integer intValue : this.tagList) {
            int intValue2 = intValue.intValue();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("DG");
            stringBuilder3.append(a.mt(intValue2));
            stringBuilder.append(stringBuilder3.toString());
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        COMFile cOMFile = (COMFile) obj;
        if (this.versionLDS.equals(cOMFile.versionLDS) && this.updateLevelLDS.equals(cOMFile.updateLevelLDS) && this.majorVersionUnicode.equals(cOMFile.majorVersionUnicode) && this.minorVersionUnicode.equals(cOMFile.minorVersionUnicode) && this.releaseLevelUnicode.equals(cOMFile.releaseLevelUnicode) && this.tagList.equals(cOMFile.tagList)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (((((this.versionLDS.hashCode() * 3) + (this.updateLevelLDS.hashCode() * 5)) + (this.majorVersionUnicode.hashCode() * 7)) + (this.minorVersionUnicode.hashCode() * 11)) + (this.releaseLevelUnicode.hashCode() * 13)) + (this.tagList.hashCode() * 17);
    }
}
