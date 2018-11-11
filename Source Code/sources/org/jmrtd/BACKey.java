package org.jmrtd;

import com.jumio.analytics.MobileEvents;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BACKey implements BACKeySpec {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -1059774581180524710L;
    private String dateOfBirth;
    private String dateOfExpiry;
    private String documentNumber;

    protected BACKey() {
    }

    public BACKey(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal document number");
        } else if (str2 == null || str2.length() != 6) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal date: ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (str3 == null || str3.length() != 6) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Illegal date: ");
            stringBuilder2.append(str3);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            while (str.length() < 9) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append("<");
                str = stringBuilder3.toString();
            }
            this.documentNumber = str.trim();
            this.dateOfBirth = str2;
            this.dateOfExpiry = str3;
        }
    }

    public BACKey(String str, Date date, Date date2) {
        this(str, i(date), i(date2));
    }

    public String bAv() {
        return this.documentNumber;
    }

    public String bAw() {
        return this.dateOfBirth;
    }

    public String bAx() {
        return this.dateOfExpiry;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.documentNumber);
        stringBuilder.append(", ");
        stringBuilder.append(this.dateOfBirth);
        stringBuilder.append(", ");
        stringBuilder.append(this.dateOfExpiry);
        return stringBuilder.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((MobileEvents.EVENTTYPE_EXCEPTION + (this.documentNumber == null ? 0 : this.documentNumber.hashCode())) * 61) + (this.dateOfBirth == null ? 0 : this.dateOfBirth.hashCode())) * 61;
        if (this.dateOfExpiry != null) {
            i = this.dateOfExpiry.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        BACKey bACKey = (BACKey) obj;
        if (this.documentNumber.equals(bACKey.documentNumber) && this.dateOfBirth.equals(bACKey.dateOfBirth) && this.dateOfExpiry.equals(bACKey.dateOfExpiry)) {
            z = true;
        }
        return z;
    }

    private static synchronized String i(Date date) {
        String format;
        synchronized (BACKey.class) {
            format = new SimpleDateFormat("yyMMdd").format(date);
        }
        return format;
    }
}
