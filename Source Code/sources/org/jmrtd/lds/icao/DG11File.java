package org.jmrtd.lds.icao;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import net.sf.scuba.util.Hex;
import org.jmrtd.lds.DataGroup;

public class DG11File extends DataGroup {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 8566312538928662937L;
    private String custodyInformation;
    private String fullDateOfBirth;
    private String nameOfHolder;
    private List<String> otherNames;
    private List<String> otherValidTDNumbers;
    private List<String> permanentAddress;
    private String personalNumber;
    private String personalSummary;
    private List<String> placeOfBirth;
    private String profession;
    private byte[] proofOfCitizenship;
    private List<Integer> tagPresenceList;
    private String telephone;
    private String title;

    public int getTag() {
        return 107;
    }

    public DG11File(InputStream inputStream) {
        super(107, inputStream);
    }

    protected void r(InputStream inputStream) {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (tLVInputStream.readTag() != 92) {
            throw new IllegalArgumentException("Expected tag list in DG11");
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
                if (readTag2 != 24335) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Expected ");
                    stringBuilder2.append(Integer.toHexString(24335));
                    stringBuilder2.append(", found ");
                    stringBuilder2.append(Integer.toHexString(readTag2));
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
                tLVInputStream.readLength();
                aw(tLVInputStream.readValue());
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
            if (readTag == 24363) {
                av(readValue);
            } else if (readTag != 24386) {
                switch (readTag) {
                    case 24334:
                        ay(readValue);
                        return;
                    case 24335:
                        aw(readValue);
                        return;
                    case 24336:
                        ax(readValue);
                        return;
                    case 24337:
                        au(readValue);
                        return;
                    case 24338:
                        as(readValue);
                        return;
                    case 24339:
                        ar(readValue);
                        return;
                    case 24340:
                        aq(readValue);
                        return;
                    case 24341:
                        ap(readValue);
                        return;
                    case 24342:
                        ao(readValue);
                        return;
                    case 24343:
                        an(readValue);
                        return;
                    case 24344:
                        am(readValue);
                        return;
                    default:
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Unknown field tag in DG11: ");
                        stringBuilder2.append(Integer.toHexString(readTag));
                        throw new IllegalArgumentException(stringBuilder2.toString());
                }
            } else {
                at(readValue);
            }
        }
    }

    private void am(byte[] bArr) {
        try {
            this.custodyInformation = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.custodyInformation = new String(bArr).trim();
        }
    }

    private void an(byte[] bArr) {
        String trim = new String(bArr).trim();
        try {
            trim = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        this.otherValidTDNumbers = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(trim, "<");
        while (stringTokenizer.hasMoreTokens()) {
            this.otherValidTDNumbers.add(stringTokenizer.nextToken().trim());
        }
    }

    private void ao(byte[] bArr) {
        this.proofOfCitizenship = bArr;
    }

    private void ap(byte[] bArr) {
        try {
            this.personalSummary = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.personalSummary = new String(bArr).trim();
        }
    }

    private void aq(byte[] bArr) {
        try {
            this.title = new String(bArr, "UTF-8").trim();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.title = new String(bArr).trim();
        }
    }

    private void ar(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        this.profession = str.trim();
    }

    private void as(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        this.telephone = str.replace("<", " ").trim();
    }

    private void at(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
        this.permanentAddress = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            this.permanentAddress.add(stringTokenizer.nextToken().trim());
        }
    }

    private void au(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
        this.placeOfBirth = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            this.placeOfBirth.add(stringTokenizer.nextToken().trim());
        }
    }

    private void av(byte[] bArr) {
        String bytesToHexString;
        if (bArr.length == 4) {
            bytesToHexString = Hex.bytesToHexString(bArr);
        } else {
            String str = new String(bArr);
            try {
                bytesToHexString = new String(bArr, "UTF-8");
            } catch (Throwable e) {
                LOGGER.log(Level.WARNING, "Exception", e);
                bytesToHexString = str;
            }
        }
        this.fullDateOfBirth = bytesToHexString;
    }

    private synchronized void aw(byte[] bArr) {
        if (this.otherNames == null) {
            this.otherNames = new ArrayList();
        }
        try {
            this.otherNames.add(new String(bArr, "UTF-8").trim());
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            this.otherNames.add(new String(bArr).trim());
        }
        return;
    }

    private void ax(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        this.personalNumber = str.trim();
    }

    private void ay(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        this.nameOfHolder = str.trim();
    }

    public List<Integer> bBb() {
        if (this.tagPresenceList != null) {
            return this.tagPresenceList;
        }
        this.tagPresenceList = new ArrayList(12);
        if (this.nameOfHolder != null) {
            this.tagPresenceList.add(Integer.valueOf(24334));
        }
        if (!(this.otherNames == null || this.otherNames.isEmpty())) {
            this.tagPresenceList.add(Integer.valueOf(24335));
        }
        if (this.personalNumber != null) {
            this.tagPresenceList.add(Integer.valueOf(24336));
        }
        if (this.fullDateOfBirth != null) {
            this.tagPresenceList.add(Integer.valueOf(24363));
        }
        if (!(this.placeOfBirth == null || this.placeOfBirth.isEmpty())) {
            this.tagPresenceList.add(Integer.valueOf(24337));
        }
        if (!(this.permanentAddress == null || this.permanentAddress.isEmpty())) {
            this.tagPresenceList.add(Integer.valueOf(24386));
        }
        if (this.telephone != null) {
            this.tagPresenceList.add(Integer.valueOf(24338));
        }
        if (this.profession != null) {
            this.tagPresenceList.add(Integer.valueOf(24339));
        }
        if (this.title != null) {
            this.tagPresenceList.add(Integer.valueOf(24340));
        }
        if (this.personalSummary != null) {
            this.tagPresenceList.add(Integer.valueOf(24341));
        }
        if (this.proofOfCitizenship != null) {
            this.tagPresenceList.add(Integer.valueOf(24342));
        }
        if (!(this.otherValidTDNumbers == null || this.otherValidTDNumbers.isEmpty())) {
            this.tagPresenceList.add(Integer.valueOf(24343));
        }
        if (this.custodyInformation != null) {
            this.tagPresenceList.add(Integer.valueOf(24344));
        }
        return this.tagPresenceList;
    }

    public String bBc() {
        return this.nameOfHolder;
    }

    public List<String> bBd() {
        return this.otherNames == null ? new ArrayList() : new ArrayList(this.otherNames);
    }

    public String getPersonalNumber() {
        return this.personalNumber;
    }

    public String bBe() {
        return this.fullDateOfBirth;
    }

    public List<String> bBf() {
        return this.placeOfBirth;
    }

    public List<String> bBg() {
        return this.permanentAddress;
    }

    public String bBh() {
        return this.telephone;
    }

    public String bBi() {
        return this.profession;
    }

    public String getTitle() {
        return this.title;
    }

    public String bBj() {
        return this.personalSummary;
    }

    public byte[] bBk() {
        return this.proofOfCitizenship;
    }

    public List<String> bBl() {
        return this.otherValidTDNumbers;
    }

    public String bBm() {
        return this.custodyInformation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DG11File [");
        stringBuilder.append(this.nameOfHolder == null ? "" : this.nameOfHolder);
        stringBuilder.append(", ");
        Object obj = (this.otherNames == null || this.otherNames.isEmpty()) ? "[]" : this.otherNames;
        stringBuilder.append(obj);
        stringBuilder.append(", ");
        stringBuilder.append(this.personalNumber == null ? "" : this.personalNumber);
        stringBuilder.append(", ");
        stringBuilder.append(this.fullDateOfBirth == null ? "" : this.fullDateOfBirth);
        stringBuilder.append(", ");
        String obj2 = (this.placeOfBirth == null || this.placeOfBirth.isEmpty()) ? "[]" : this.placeOfBirth.toString();
        stringBuilder.append(obj2);
        stringBuilder.append(", ");
        obj2 = (this.permanentAddress == null || this.permanentAddress.isEmpty()) ? "[]" : this.permanentAddress.toString();
        stringBuilder.append(obj2);
        stringBuilder.append(", ");
        stringBuilder.append(this.telephone == null ? "" : this.telephone);
        stringBuilder.append(", ");
        stringBuilder.append(this.profession == null ? "" : this.profession);
        stringBuilder.append(", ");
        stringBuilder.append(this.title == null ? "" : this.title);
        stringBuilder.append(", ");
        stringBuilder.append(this.personalSummary == null ? "" : this.personalSummary);
        stringBuilder.append(", ");
        if (this.proofOfCitizenship == null) {
            obj2 = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("image (");
            stringBuilder2.append(this.proofOfCitizenship.length);
            stringBuilder2.append(")");
            obj2 = stringBuilder2.toString();
        }
        stringBuilder.append(obj2);
        stringBuilder.append(", ");
        obj2 = (this.otherValidTDNumbers == null || this.otherValidTDNumbers.isEmpty()) ? "[]" : this.otherValidTDNumbers.toString();
        stringBuilder.append(obj2);
        stringBuilder.append(", ");
        stringBuilder.append(this.custodyInformation == null ? "" : this.custodyInformation);
        stringBuilder.append("]");
        return stringBuilder.toString();
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
        return toString().equals(((DG11File) obj).toString());
    }

    public int hashCode() {
        return (toString().hashCode() * 13) + 111;
    }

    protected void g(OutputStream outputStream) {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(92);
        DataOutputStream dataOutputStream = new DataOutputStream(tLVOutputStream);
        List<Integer> bBb = bBb();
        for (Integer intValue : bBb) {
            dataOutputStream.writeShort(intValue.intValue());
        }
        dataOutputStream.flush();
        tLVOutputStream.writeValueEnd();
        for (Integer intValue2 : bBb) {
            int intValue3 = intValue2.intValue();
            if (intValue3 != 24363) {
                Object obj = 1;
                if (intValue3 != 24386) {
                    switch (intValue3) {
                        case 24334:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.nameOfHolder.trim().getBytes("UTF-8"));
                            break;
                        case 24335:
                            if (this.otherNames == null) {
                                this.otherNames = new ArrayList();
                            }
                            tLVOutputStream.writeTag(160);
                            tLVOutputStream.writeTag(2);
                            tLVOutputStream.write(this.otherNames.size());
                            tLVOutputStream.writeValueEnd();
                            for (String str : this.otherNames) {
                                tLVOutputStream.writeTag(24335);
                                tLVOutputStream.writeValue(str.trim().getBytes("UTF-8"));
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case 24336:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.personalNumber.trim().getBytes("UTF-8"));
                            break;
                        case 24337:
                            tLVOutputStream.writeTag(intValue3);
                            for (String str2 : this.placeOfBirth) {
                                if (str2 != null) {
                                    if (obj != null) {
                                        obj = null;
                                    } else {
                                        tLVOutputStream.write(60);
                                    }
                                    tLVOutputStream.write(str2.trim().getBytes("UTF-8"));
                                }
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case 24338:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.telephone.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case 24339:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.profession.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case 24340:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.title.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case 24341:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.personalSummary.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case 24342:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.proofOfCitizenship);
                            break;
                        case 24343:
                            tLVOutputStream.writeTag(intValue3);
                            for (String str3 : this.otherValidTDNumbers) {
                                if (str3 != null) {
                                    if (obj != null) {
                                        obj = null;
                                    } else {
                                        tLVOutputStream.write(60);
                                    }
                                    tLVOutputStream.write(str3.trim().replace(' ', '<').getBytes("UTF-8"));
                                }
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case 24344:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.custodyInformation.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown tag in DG11: ");
                            stringBuilder.append(Integer.toHexString(intValue3));
                            throw new IllegalStateException(stringBuilder.toString());
                    }
                }
                tLVOutputStream.writeTag(intValue3);
                for (String str22 : this.permanentAddress) {
                    if (str22 != null) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            tLVOutputStream.write(60);
                        }
                        tLVOutputStream.write(str22.trim().getBytes("UTF-8"));
                    }
                }
                tLVOutputStream.writeValueEnd();
            } else {
                tLVOutputStream.writeTag(intValue3);
                tLVOutputStream.writeValue(this.fullDateOfBirth.getBytes("UTF-8"));
            }
        }
    }
}
