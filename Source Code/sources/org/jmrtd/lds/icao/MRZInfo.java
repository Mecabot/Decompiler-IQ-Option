package org.jmrtd.lds.icao;

import android.support.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import net.sf.scuba.data.Gender;
import org.jmrtd.lds.AbstractLDSInfo;

public class MRZInfo extends AbstractLDSInfo {
    private static final long serialVersionUID = 7054965914471297804L;
    private char compositeCheckDigit;
    private String dateOfBirth;
    private char dateOfBirthCheckDigit;
    private String dateOfExpiry;
    private char dateOfExpiryCheckDigit;
    private String documentCode;
    private String documentNumber;
    private char documentNumberCheckDigit;
    @Deprecated
    private int documentType;
    private Gender gender;
    private String issuingState;
    private String mrzLine1;
    private String mrzLine2;
    private String mrzLine3;
    private String nationality;
    private String optionalData1;
    private String optionalData2;
    private String primaryIdentifier;
    private String secondaryIdentifier;

    /* renamed from: org.jmrtd.lds.icao.MRZInfo$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fcZ = new int[Gender.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:5:0x001f, code:
            return;
     */
        static {
            /*
            r0 = net.sf.scuba.data.Gender.values();
            r0 = r0.length;
            r0 = new int[r0];
            fcZ = r0;
            r0 = fcZ;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = net.sf.scuba.data.Gender.MALE;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = fcZ;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = net.sf.scuba.data.Gender.FEMALE;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.lds.icao.MRZInfo.1.<clinit>():void");
        }
    }

    public MRZInfo(InputStream inputStream, int i) {
        try {
            d(inputStream, i);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void d(InputStream inputStream, int i) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        inputStream.mark(i);
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(inputStream));
        char[] cArr = new char[i];
        inputStreamReader.read(cArr, 0, i);
        String str = new String(cArr);
        inputStream.reset();
        this.documentCode = b(dataInputStream, 2);
        this.documentType = nF(this.documentCode);
        if (i == 88) {
            this.documentType = 3;
        } else if (i != 90) {
            this.documentType = nF(this.documentCode);
        } else {
            this.documentType = 1;
        }
        if (this.documentType == 1) {
            this.issuingState = d(dataInputStream);
            this.documentNumber = a(dataInputStream, 9);
            this.documentNumberCheckDigit = (char) dataInputStream.readUnsignedByte();
            this.optionalData1 = b(dataInputStream, 15);
            if (this.documentNumberCheckDigit == '<') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.documentNumber);
                stringBuilder.append(this.optionalData1.substring(0, this.optionalData1.length() - 1));
                this.documentNumber = stringBuilder.toString();
                this.documentNumberCheckDigit = this.optionalData1.charAt(this.optionalData1.length() - 1);
                this.optionalData1 = null;
            }
            this.documentNumber = nG(this.documentNumber);
            this.dateOfBirth = f(dataInputStream);
            this.dateOfBirthCheckDigit = (char) dataInputStream.readUnsignedByte();
            this.gender = e(dataInputStream);
            this.dateOfExpiry = g(dataInputStream);
            this.dateOfExpiryCheckDigit = (char) dataInputStream.readUnsignedByte();
            this.nationality = d(dataInputStream);
            this.optionalData2 = a(dataInputStream, 11);
            this.compositeCheckDigit = (char) dataInputStream.readUnsignedByte();
            nD(a(dataInputStream, 30));
            this.mrzLine1 = str.substring(0, 30);
            this.mrzLine2 = str.substring(30, 60);
            this.mrzLine3 = str.substring(60, 90);
            return;
        }
        this.issuingState = d(dataInputStream);
        nD(a(dataInputStream, 39));
        this.documentNumber = nG(a(dataInputStream, 9));
        this.documentNumberCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.nationality = d(dataInputStream);
        this.dateOfBirth = f(dataInputStream);
        this.dateOfBirthCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.gender = e(dataInputStream);
        this.dateOfExpiry = g(dataInputStream);
        this.dateOfExpiryCheckDigit = (char) dataInputStream.readUnsignedByte();
        String b = b(dataInputStream, 14);
        char readUnsignedByte = (char) dataInputStream.readUnsignedByte();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(af(b, 14));
        stringBuilder2.append(readUnsignedByte);
        this.optionalData1 = stringBuilder2.toString();
        this.compositeCheckDigit = (char) dataInputStream.readUnsignedByte();
        i /= 2;
        this.mrzLine1 = str.substring(0, i);
        this.mrzLine2 = str.substring(i);
        this.mrzLine3 = null;
    }

    public void f(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        f(dataOutputStream);
        if (this.documentType == 1) {
            a(dataOutputStream);
            if (this.documentNumber.length() <= 9 || !bo(this.optionalData1, "")) {
                a(this.documentNumber, dataOutputStream, 9);
                dataOutputStream.write(this.documentNumberCheckDigit);
                a(this.optionalData1, dataOutputStream, 15);
            } else {
                a(this.documentNumber.substring(0, 9), dataOutputStream, 9);
                dataOutputStream.write(60);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.documentNumber.substring(9, this.documentNumber.length()));
                stringBuilder.append(this.documentNumberCheckDigit);
                stringBuilder.append("<");
                a(stringBuilder.toString(), dataOutputStream, 15);
            }
            d(dataOutputStream);
            dataOutputStream.write(this.dateOfBirthCheckDigit);
            c(dataOutputStream);
            b(dataOutputStream);
            dataOutputStream.write(this.dateOfExpiryCheckDigit);
            e(dataOutputStream);
            a(this.optionalData2, dataOutputStream, 11);
            dataOutputStream.write(this.compositeCheckDigit);
            a(dataOutputStream, 30);
            return;
        }
        a(dataOutputStream);
        a(dataOutputStream, 39);
        a(this.documentNumber, dataOutputStream, 9);
        dataOutputStream.write(this.documentNumberCheckDigit);
        e(dataOutputStream);
        d(dataOutputStream);
        dataOutputStream.write(this.dateOfBirthCheckDigit);
        c(dataOutputStream);
        b(dataOutputStream);
        dataOutputStream.write(this.dateOfExpiryCheckDigit);
        a(this.optionalData1, dataOutputStream, 15);
        dataOutputStream.write(this.compositeCheckDigit);
    }

    public String bAv() {
        return this.documentNumber;
    }

    public String bBy() {
        return this.issuingState;
    }

    public String bBz() {
        return this.primaryIdentifier;
    }

    public String bBA() {
        return this.secondaryIdentifier;
    }

    public String bBB() {
        return this.nationality;
    }

    public String getPersonalNumber() {
        if (this.optionalData1.length() > 14) {
            return nG(this.optionalData1.substring(0, 14));
        }
        return nG(this.optionalData1);
    }

    public String toString() {
        try {
            String str = new String(getEncoded(), "UTF-8");
            int length = str.length();
            StringBuilder stringBuilder;
            if (length == 88) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, 44));
                stringBuilder.append("\n");
                stringBuilder.append(str.substring(44, 88));
                stringBuilder.append("\n");
                return stringBuilder.toString();
            } else if (length != 90) {
                return str;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, 30));
                stringBuilder.append("\n");
                stringBuilder.append(str.substring(30, 60));
                stringBuilder.append("\n");
                stringBuilder.append(str.substring(60, 90));
                stringBuilder.append("\n");
                return stringBuilder.toString();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public int hashCode() {
        return (toString().hashCode() * 2) + 53;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MRZInfo mRZInfo = (MRZInfo) obj;
        if (((this.documentCode == null && mRZInfo.documentCode == null) || (this.documentCode != null && this.documentCode.equals(mRZInfo.documentCode))) && (((this.issuingState == null && mRZInfo.issuingState == null) || (this.issuingState != null && this.issuingState.equals(mRZInfo.issuingState))) && (((this.primaryIdentifier == null && mRZInfo.primaryIdentifier == null) || (this.primaryIdentifier != null && this.primaryIdentifier.equals(mRZInfo.primaryIdentifier))) && (((this.secondaryIdentifier == null && mRZInfo.secondaryIdentifier == null) || bo(this.secondaryIdentifier, mRZInfo.secondaryIdentifier)) && (((this.nationality == null && mRZInfo.nationality == null) || (this.nationality != null && this.nationality.equals(mRZInfo.nationality))) && (((this.documentNumber == null && mRZInfo.documentNumber == null) || (this.documentNumber != null && this.documentNumber.equals(mRZInfo.documentNumber))) && (((this.optionalData1 == null && mRZInfo.optionalData1 == null) || ((this.optionalData1 != null && this.optionalData1.equals(mRZInfo.optionalData1)) || getPersonalNumber().equals(mRZInfo.getPersonalNumber()))) && (((this.dateOfBirth == null && mRZInfo.dateOfBirth == null) || (this.dateOfBirth != null && this.dateOfBirth.equals(mRZInfo.dateOfBirth))) && (((this.gender == null && mRZInfo.gender == null) || (this.gender != null && this.gender.equals(mRZInfo.gender))) && (((this.dateOfExpiry == null && mRZInfo.dateOfExpiry == null) || (this.dateOfExpiry != null && this.dateOfExpiry.equals(mRZInfo.dateOfExpiry))) && ((this.optionalData2 == null && mRZInfo.optionalData2 == null) || (this.optionalData2 != null && bo(this.optionalData2, mRZInfo.optionalData2))))))))))))) {
            z = true;
        }
        return z;
    }

    public static char nC(String str) {
        return B(str, false);
    }

    private void nD(String str) {
        int indexOf = str.indexOf("<<");
        if (indexOf < 0) {
            this.primaryIdentifier = nG(str);
            this.secondaryIdentifier = "";
            return;
        }
        this.primaryIdentifier = nG(str.substring(0, indexOf));
        nE(str.substring(str.indexOf("<<") + 2));
    }

    private void nE(String str) {
        this.secondaryIdentifier = str;
    }

    private void a(String str, DataOutputStream dataOutputStream, int i) {
        dataOutputStream.write(af(str, i).getBytes("UTF-8"));
    }

    private void a(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.issuingState.getBytes("UTF-8"));
    }

    private void b(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.dateOfExpiry.getBytes("UTF-8"));
    }

    private void c(DataOutputStream dataOutputStream) {
        dataOutputStream.write(bBC().getBytes("UTF-8"));
    }

    private void d(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.dateOfBirth.getBytes("UTF-8"));
    }

    private void e(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.nationality.getBytes("UTF-8"));
    }

    private void a(DataOutputStream dataOutputStream, int i) {
        dataOutputStream.write(mx(i).getBytes("UTF-8"));
    }

    private void f(DataOutputStream dataOutputStream) {
        a(this.documentCode, dataOutputStream, 2);
    }

    private String bBC() {
        switch (AnonymousClass1.fcZ[this.gender.ordinal()]) {
            case 1:
                return "M";
            case 2:
                return "F";
            default:
                return "<";
        }
    }

    private String mx(int i) {
        String[] split = this.primaryIdentifier.split(" |<");
        String[] split2 = this.secondaryIdentifier.split(" |<");
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : split) {
            stringBuilder.append(append);
            stringBuilder.append('<');
        }
        for (String str : split2) {
            stringBuilder.append('<');
            stringBuilder.append(str);
        }
        return af(stringBuilder.toString(), i);
    }

    private String a(DataInputStream dataInputStream, int i) {
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        return new String(bArr).trim();
    }

    private String b(DataInputStream dataInputStream, int i) {
        return nG(a(dataInputStream, i));
    }

    private String d(DataInputStream dataInputStream) {
        return a(dataInputStream, 3);
    }

    private Gender e(DataInputStream dataInputStream) {
        String a = a(dataInputStream, 1);
        if ("M".equalsIgnoreCase(a)) {
            return Gender.MALE;
        }
        if ("F".equalsIgnoreCase(a)) {
            return Gender.FEMALE;
        }
        return Gender.UNKNOWN;
    }

    private String f(DataInputStream dataInputStream) {
        return a(dataInputStream, 6);
    }

    private String g(DataInputStream dataInputStream) {
        return a(dataInputStream, 6);
    }

    private static String af(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Attempting to MRZ format null");
        } else if (str.length() > i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument too wide (");
            stringBuilder.append(str.length());
            stringBuilder.append(" > ");
            stringBuilder.append(i);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            str = str.toUpperCase().trim();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if ("<0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(charAt) == -1) {
                    stringBuilder2.append('<');
                } else {
                    stringBuilder2.append(charAt);
                }
            }
            while (stringBuilder2.length() < i) {
                stringBuilder2.append("<");
            }
            return stringBuilder2.toString();
        }
    }

    public static boolean bo(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int max = Math.max(str.length(), str2.length());
        return af(str, max).equals(af(str2, max));
    }

    /* JADX WARNING: Missing block: B:20:0x003f, code:
            return 1;
     */
    private static int nF(java.lang.String r3) {
        /*
        if (r3 == 0) goto L_0x0040;
    L_0x0002:
        r0 = r3.length();
        r1 = 1;
        if (r0 < r1) goto L_0x0040;
    L_0x0009:
        r0 = r3.length();
        r2 = 2;
        if (r0 <= r2) goto L_0x0011;
    L_0x0010:
        goto L_0x0040;
    L_0x0011:
        r0 = "A";
        r0 = r3.startsWith(r0);
        if (r0 != 0) goto L_0x003f;
    L_0x0019:
        r0 = "C";
        r0 = r3.startsWith(r0);
        if (r0 != 0) goto L_0x003f;
    L_0x0021:
        r0 = "I";
        r0 = r3.startsWith(r0);
        if (r0 == 0) goto L_0x002a;
    L_0x0029:
        goto L_0x003f;
    L_0x002a:
        r0 = "V";
        r0 = r3.startsWith(r0);
        if (r0 == 0) goto L_0x0033;
    L_0x0032:
        return r1;
    L_0x0033:
        r0 = "P";
        r3 = r3.startsWith(r0);
        if (r3 == 0) goto L_0x003d;
    L_0x003b:
        r3 = 3;
        return r3;
    L_0x003d:
        r3 = 0;
        return r3;
    L_0x003f:
        return r1;
    L_0x0040:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Was expecting 1 or 2 digit document code, got ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.lds.icao.MRZInfo.nF(java.lang.String):int");
    }

    private static String nG(String str) {
        byte[] bytes = str.trim().getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == (byte) 60) {
                bytes[i] = (byte) 32;
            }
        }
        return new String(bytes).trim();
    }

    private static char B(String str, boolean z) {
        byte[] bArr;
        if (str == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable e) {
                throw new IllegalStateException("Error in computing check digit", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Error in computing check digit", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Error in computing check digit", e22);
            }
        }
        bArr = str.getBytes("UTF-8");
        int[] iArr = new int[]{7, 3, 1};
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i = (i + (iArr[i2 % 3] * d(bArr[i2]))) % 10;
        }
        str = Integer.toString(i);
        if (str.length() != 1) {
            throw new IllegalStateException("Error in computing check digit.");
        }
        char c = (char) str.getBytes("UTF-8")[0];
        return (z && c == '0') ? '<' : c;
    }

    /* JADX WARNING: Missing block: B:8:0x0038, code:
            return 35;
     */
    /* JADX WARNING: Missing block: B:10:0x003b, code:
            return 34;
     */
    /* JADX WARNING: Missing block: B:12:0x003e, code:
            return 33;
     */
    /* JADX WARNING: Missing block: B:14:0x0041, code:
            return 32;
     */
    /* JADX WARNING: Missing block: B:16:0x0044, code:
            return 31;
     */
    /* JADX WARNING: Missing block: B:18:0x0047, code:
            return 30;
     */
    /* JADX WARNING: Missing block: B:20:0x004a, code:
            return 29;
     */
    /* JADX WARNING: Missing block: B:22:0x004d, code:
            return 28;
     */
    /* JADX WARNING: Missing block: B:24:0x0050, code:
            return 27;
     */
    /* JADX WARNING: Missing block: B:26:0x0053, code:
            return 26;
     */
    /* JADX WARNING: Missing block: B:28:0x0056, code:
            return 25;
     */
    /* JADX WARNING: Missing block: B:30:0x0059, code:
            return 24;
     */
    /* JADX WARNING: Missing block: B:32:0x005c, code:
            return 23;
     */
    /* JADX WARNING: Missing block: B:34:0x005f, code:
            return 22;
     */
    /* JADX WARNING: Missing block: B:36:0x0062, code:
            return 21;
     */
    /* JADX WARNING: Missing block: B:38:0x0065, code:
            return 20;
     */
    /* JADX WARNING: Missing block: B:40:0x0068, code:
            return 19;
     */
    /* JADX WARNING: Missing block: B:42:0x006b, code:
            return 18;
     */
    /* JADX WARNING: Missing block: B:44:0x006e, code:
            return 17;
     */
    /* JADX WARNING: Missing block: B:46:0x0071, code:
            return 16;
     */
    /* JADX WARNING: Missing block: B:48:0x0074, code:
            return 15;
     */
    /* JADX WARNING: Missing block: B:50:0x0077, code:
            return 14;
     */
    /* JADX WARNING: Missing block: B:52:0x007a, code:
            return 13;
     */
    /* JADX WARNING: Missing block: B:54:0x007d, code:
            return 12;
     */
    /* JADX WARNING: Missing block: B:56:0x0080, code:
            return 11;
     */
    /* JADX WARNING: Missing block: B:58:0x0083, code:
            return 10;
     */
    private static int d(byte r3) {
        /*
        r0 = 60;
        if (r3 == r0) goto L_0x0098;
    L_0x0004:
        switch(r3) {
            case 48: goto L_0x0098;
            case 49: goto L_0x0096;
            case 50: goto L_0x0094;
            case 51: goto L_0x0092;
            case 52: goto L_0x0090;
            case 53: goto L_0x008e;
            case 54: goto L_0x008c;
            case 55: goto L_0x008a;
            case 56: goto L_0x0087;
            case 57: goto L_0x0084;
            default: goto L_0x0007;
        };
    L_0x0007:
        switch(r3) {
            case 65: goto L_0x0081;
            case 66: goto L_0x007e;
            case 67: goto L_0x007b;
            case 68: goto L_0x0078;
            case 69: goto L_0x0075;
            case 70: goto L_0x0072;
            case 71: goto L_0x006f;
            case 72: goto L_0x006c;
            case 73: goto L_0x0069;
            case 74: goto L_0x0066;
            case 75: goto L_0x0063;
            case 76: goto L_0x0060;
            case 77: goto L_0x005d;
            case 78: goto L_0x005a;
            case 79: goto L_0x0057;
            case 80: goto L_0x0054;
            case 81: goto L_0x0051;
            case 82: goto L_0x004e;
            case 83: goto L_0x004b;
            case 84: goto L_0x0048;
            case 85: goto L_0x0045;
            case 86: goto L_0x0042;
            case 87: goto L_0x003f;
            case 88: goto L_0x003c;
            case 89: goto L_0x0039;
            case 90: goto L_0x0036;
            default: goto L_0x000a;
        };
    L_0x000a:
        switch(r3) {
            case 97: goto L_0x0081;
            case 98: goto L_0x007e;
            case 99: goto L_0x007b;
            case 100: goto L_0x0078;
            case 101: goto L_0x0075;
            case 102: goto L_0x0072;
            case 103: goto L_0x006f;
            case 104: goto L_0x006c;
            case 105: goto L_0x0069;
            case 106: goto L_0x0066;
            case 107: goto L_0x0063;
            case 108: goto L_0x0060;
            case 109: goto L_0x005d;
            case 110: goto L_0x005a;
            case 111: goto L_0x0057;
            case 112: goto L_0x0054;
            case 113: goto L_0x0051;
            case 114: goto L_0x004e;
            case 115: goto L_0x004b;
            case 116: goto L_0x0048;
            case 117: goto L_0x0045;
            case 118: goto L_0x0042;
            case 119: goto L_0x003f;
            case 120: goto L_0x003c;
            case 121: goto L_0x0039;
            case 122: goto L_0x0036;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not decode MRZ character ";
        r1.append(r2);
        r1.append(r3);
        r2 = " ('";
        r1.append(r2);
        r3 = (char) r3;
        r3 = java.lang.Character.toString(r3);
        r1.append(r3);
        r3 = "')";
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0036:
        r3 = 35;
        return r3;
    L_0x0039:
        r3 = 34;
        return r3;
    L_0x003c:
        r3 = 33;
        return r3;
    L_0x003f:
        r3 = 32;
        return r3;
    L_0x0042:
        r3 = 31;
        return r3;
    L_0x0045:
        r3 = 30;
        return r3;
    L_0x0048:
        r3 = 29;
        return r3;
    L_0x004b:
        r3 = 28;
        return r3;
    L_0x004e:
        r3 = 27;
        return r3;
    L_0x0051:
        r3 = 26;
        return r3;
    L_0x0054:
        r3 = 25;
        return r3;
    L_0x0057:
        r3 = 24;
        return r3;
    L_0x005a:
        r3 = 23;
        return r3;
    L_0x005d:
        r3 = 22;
        return r3;
    L_0x0060:
        r3 = 21;
        return r3;
    L_0x0063:
        r3 = 20;
        return r3;
    L_0x0066:
        r3 = 19;
        return r3;
    L_0x0069:
        r3 = 18;
        return r3;
    L_0x006c:
        r3 = 17;
        return r3;
    L_0x006f:
        r3 = 16;
        return r3;
    L_0x0072:
        r3 = 15;
        return r3;
    L_0x0075:
        r3 = 14;
        return r3;
    L_0x0078:
        r3 = 13;
        return r3;
    L_0x007b:
        r3 = 12;
        return r3;
    L_0x007e:
        r3 = 11;
        return r3;
    L_0x0081:
        r3 = 10;
        return r3;
    L_0x0084:
        r3 = 9;
        return r3;
    L_0x0087:
        r3 = 8;
        return r3;
    L_0x008a:
        r3 = 7;
        return r3;
    L_0x008c:
        r3 = 6;
        return r3;
    L_0x008e:
        r3 = 5;
        return r3;
    L_0x0090:
        r3 = 4;
        return r3;
    L_0x0092:
        r3 = 3;
        return r3;
    L_0x0094:
        r3 = 2;
        return r3;
    L_0x0096:
        r3 = 1;
        return r3;
    L_0x0098:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.lds.icao.MRZInfo.d(byte):int");
    }

    @Nullable
    public String getMrzLine1() {
        return this.mrzLine1;
    }

    @Nullable
    public String getMrzLine2() {
        return this.mrzLine2;
    }

    @Nullable
    public String getMrzLine3() {
        return this.mrzLine3;
    }
}
