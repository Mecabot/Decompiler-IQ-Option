package org.jmrtd.lds.icao;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import net.sf.scuba.util.Hex;
import org.jmrtd.lds.DataGroup;

public class DG12File extends DataGroup {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -1979367459379125674L;
    private String dateAndTimeOfPersonalization;
    private String dateOfIssue;
    private String endorsementsAndObservations;
    private byte[] imageOfFront;
    private byte[] imageOfRear;
    private String issuingAuthority;
    private List<String> namesOfOtherPersons;
    private String personalizationSystemSerialNumber;
    private List<Integer> tagPresenceList;
    private String taxOrExitRequirements;

    public int getTag() {
        return 108;
    }

    public DG12File(InputStream inputStream) {
        super(108, inputStream);
    }

    protected void r(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (tLVInputStream.readTag() != 92) {
            throw new IllegalArgumentException("Expected tag list in DG12");
        }
        int readLength = tLVInputStream.readLength();
        int i = 0;
        int i2 = readLength / 2;
        InputStream byteArrayInputStream = new ByteArrayInputStream(tLVInputStream.readValue());
        List<Integer> arrayList = new ArrayList(i2 + 1);
        while (i < readLength) {
            i2 = new TLVInputStream(byteArrayInputStream).readTag();
            i += TLVUtil.getTagLength(i2);
            arrayList.add(Integer.valueOf(i2));
        }
        for (Integer intValue : arrayList) {
            a(intValue.intValue(), tLVInputStream);
        }
    }

    public List<Integer> bBb() {
        if (this.tagPresenceList != null) {
            return this.tagPresenceList;
        }
        this.tagPresenceList = new ArrayList(10);
        if (this.issuingAuthority != null) {
            this.tagPresenceList.add(Integer.valueOf(24345));
        }
        if (this.dateOfIssue != null) {
            this.tagPresenceList.add(Integer.valueOf(24358));
        }
        if (!(this.namesOfOtherPersons == null || this.namesOfOtherPersons.isEmpty())) {
            this.tagPresenceList.add(Integer.valueOf(24346));
        }
        if (this.endorsementsAndObservations != null) {
            this.tagPresenceList.add(Integer.valueOf(24347));
        }
        if (this.taxOrExitRequirements != null) {
            this.tagPresenceList.add(Integer.valueOf(24348));
        }
        if (this.imageOfFront != null) {
            this.tagPresenceList.add(Integer.valueOf(24349));
        }
        if (this.imageOfRear != null) {
            this.tagPresenceList.add(Integer.valueOf(24350));
        }
        if (this.dateAndTimeOfPersonalization != null) {
            this.tagPresenceList.add(Integer.valueOf(24405));
        }
        if (this.personalizationSystemSerialNumber != null) {
            this.tagPresenceList.add(Integer.valueOf(24406));
        }
        return this.tagPresenceList;
    }

    private void a(int i, TLVInputStream tLVInputStream) {
        int readTag = tLVInputStream.readTag();
        StringBuilder stringBuilder;
        byte[] readValue;
        StringBuilder stringBuilder2;
        if (readTag == 160) {
            tLVInputStream.readLength();
            i = tLVInputStream.readTag();
            if (i != 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Expected ");
                stringBuilder.append(Integer.toHexString(2));
                stringBuilder.append(", found ");
                stringBuilder.append(Integer.toHexString(i));
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            i = tLVInputStream.readLength();
            StringBuilder stringBuilder3;
            if (i != 1) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Expected length 1 count length, found ");
                stringBuilder3.append(i);
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
            readValue = tLVInputStream.readValue();
            if (readValue == null || readValue.length != 1) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Number of content specific fields should be encoded in single byte, found ");
                stringBuilder3.append(Arrays.toString(readValue));
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
            readTag = 0;
            i = readValue[0] & 255;
            while (readTag < i) {
                int readTag2 = tLVInputStream.readTag();
                if (readTag2 != 24346) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Expected ");
                    stringBuilder2.append(Integer.toHexString(24346));
                    stringBuilder2.append(", found ");
                    stringBuilder2.append(Integer.toHexString(readTag2));
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
                tLVInputStream.readLength();
                aF(tLVInputStream.readValue());
                readTag++;
            }
        } else if (readTag != i) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(", but found ");
            stringBuilder.append(Integer.toHexString(readTag));
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            tLVInputStream.readLength();
            readValue = tLVInputStream.readValue();
            if (readTag != 24358) {
                switch (readTag) {
                    case 24345:
                        aH(readValue);
                        return;
                    case 24346:
                        aF(readValue);
                        return;
                    case 24347:
                        aE(readValue);
                        return;
                    case 24348:
                        aD(readValue);
                        return;
                    case 24349:
                        aB(readValue);
                        return;
                    case 24350:
                        aC(readValue);
                        return;
                    default:
                        switch (readTag) {
                            case 24405:
                                aA(readValue);
                                return;
                            case 24406:
                                az(readValue);
                                return;
                            default:
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Unknown field tag in DG12: ");
                                stringBuilder2.append(Integer.toHexString(readTag));
                                throw new IllegalArgumentException(stringBuilder2.toString());
                        }
                }
            }
            aG(readValue);
        }
    }

    private void az(byte[] bArr) {
        try {
            this.personalizationSystemSerialNumber = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.personalizationSystemSerialNumber = new String(bArr).trim();
        }
    }

    private void aA(byte[] bArr) {
        try {
            this.dateAndTimeOfPersonalization = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
    }

    private void aB(byte[] bArr) {
        this.imageOfFront = bArr;
    }

    private void aC(byte[] bArr) {
        this.imageOfRear = bArr;
    }

    private void aD(byte[] bArr) {
        try {
            this.taxOrExitRequirements = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.taxOrExitRequirements = new String(bArr).trim();
        }
    }

    private void aE(byte[] bArr) {
        try {
            this.endorsementsAndObservations = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.endorsementsAndObservations = new String(bArr).trim();
        }
    }

    private synchronized void aF(byte[] bArr) {
        if (this.namesOfOtherPersons == null) {
            this.namesOfOtherPersons = new ArrayList();
        }
        try {
            this.namesOfOtherPersons.add(new String(bArr, "UTF-8").trim());
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.namesOfOtherPersons.add(new String(bArr).trim());
        }
        return;
    }

    private void aG(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Wrong date format");
        }
        if (bArr.length == 8) {
            try {
                this.dateOfIssue = new String(bArr, "UTF-8").trim();
                return;
            } catch (Throwable e) {
                LOGGER.log(Level.WARNING, "Exception", e);
            }
        }
        LOGGER.warning("DG12 date of issue is not in expected ccyymmdd ASCII format");
        if (bArr.length == 4) {
            this.dateOfIssue = Hex.bytesToHexString(bArr).trim();
            return;
        }
        throw new IllegalArgumentException("Wrong date format");
    }

    private void aH(byte[] bArr) {
        try {
            this.issuingAuthority = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.issuingAuthority = new String(bArr).trim();
        }
    }

    public String bBn() {
        return this.issuingAuthority;
    }

    public String bBo() {
        return this.dateOfIssue;
    }

    public List<String> bBp() {
        return this.namesOfOtherPersons;
    }

    public String bBq() {
        return this.endorsementsAndObservations;
    }

    public byte[] bBr() {
        return this.imageOfFront;
    }

    public byte[] bBs() {
        return this.imageOfRear;
    }

    public String bBt() {
        return this.dateAndTimeOfPersonalization;
    }

    public String bBu() {
        return this.personalizationSystemSerialNumber;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("DG12File [");
        stringBuilder2.append(this.issuingAuthority == null ? "" : this.issuingAuthority);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.dateOfIssue == null ? "" : this.dateOfIssue);
        stringBuilder2.append(", ");
        Object obj = (this.namesOfOtherPersons == null || this.namesOfOtherPersons.isEmpty()) ? "" : this.namesOfOtherPersons;
        stringBuilder2.append(obj);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.endorsementsAndObservations == null ? "" : this.endorsementsAndObservations);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.taxOrExitRequirements == null ? "" : this.taxOrExitRequirements);
        stringBuilder2.append(", ");
        if (this.imageOfFront == null) {
            str = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("image (");
            stringBuilder.append(this.imageOfFront.length);
            stringBuilder.append(")");
            str = stringBuilder.toString();
        }
        stringBuilder2.append(str);
        stringBuilder2.append(", ");
        if (this.imageOfRear == null) {
            str = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("image (");
            stringBuilder.append(this.imageOfRear.length);
            stringBuilder.append(")");
            str = stringBuilder.toString();
        }
        stringBuilder2.append(str);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.dateAndTimeOfPersonalization == null ? "" : this.dateAndTimeOfPersonalization);
        stringBuilder2.append(", ");
        stringBuilder2.append(this.personalizationSystemSerialNumber == null ? "" : this.personalizationSystemSerialNumber);
        stringBuilder2.append("]");
        return stringBuilder2.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        return toString().equals(((DG12File) obj).toString());
    }

    public int hashCode() {
        return (toString().hashCode() * 13) + 112;
    }

    protected void g(OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(92);
        List<Integer> bBb = bBb();
        DataOutputStream dataOutputStream = new DataOutputStream(tLVOutputStream);
        for (Integer intValue : bBb) {
            dataOutputStream.writeShort(intValue.intValue());
        }
        dataOutputStream.flush();
        tLVOutputStream.writeValueEnd();
        for (Integer intValue2 : bBb) {
            int intValue3 = intValue2.intValue();
            if (intValue3 != 24358) {
                switch (intValue3) {
                    case 24345:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.issuingAuthority.trim().getBytes("UTF-8"));
                        break;
                    case 24346:
                        if (this.namesOfOtherPersons == null) {
                            this.namesOfOtherPersons = new ArrayList();
                        }
                        tLVOutputStream.writeTag(160);
                        tLVOutputStream.writeTag(2);
                        tLVOutputStream.write(this.namesOfOtherPersons.size());
                        tLVOutputStream.writeValueEnd();
                        for (String str : this.namesOfOtherPersons) {
                            tLVOutputStream.writeTag(24346);
                            tLVOutputStream.writeValue(str.trim().getBytes("UTF-8"));
                        }
                        tLVOutputStream.writeValueEnd();
                        break;
                    case 24347:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.endorsementsAndObservations.trim().getBytes("UTF-8"));
                        break;
                    case 24348:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.taxOrExitRequirements.trim().getBytes("UTF-8"));
                        break;
                    case 24349:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.imageOfFront);
                        break;
                    case 24350:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.imageOfRear);
                        break;
                    default:
                        switch (intValue3) {
                            case 24405:
                                tLVOutputStream.writeTag(intValue3);
                                tLVOutputStream.writeValue(this.dateAndTimeOfPersonalization.getBytes("UTF-8"));
                                break;
                            case 24406:
                                tLVOutputStream.writeTag(intValue3);
                                tLVOutputStream.writeValue(this.personalizationSystemSerialNumber.trim().getBytes("UTF-8"));
                                break;
                            default:
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Unknown field tag in DG12: ");
                                stringBuilder.append(Integer.toHexString(intValue3));
                                throw new IllegalArgumentException(stringBuilder.toString());
                        }
                }
            }
            tLVOutputStream.writeTag(intValue3);
            tLVOutputStream.writeValue(this.dateOfIssue.getBytes("UTF-8"));
        }
    }
}
