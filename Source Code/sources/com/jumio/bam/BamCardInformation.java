package com.jumio.bam;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.jumio.bam.enums.CreditCardType;
import java.util.Arrays;
import java.util.HashMap;
import jumio.bam.y;

public class BamCardInformation implements Parcelable {
    public static final Creator<BamCardInformation> CREATOR = new Creator<BamCardInformation>() {
        /* renamed from: a */
        public BamCardInformation createFromParcel(Parcel parcel) {
            return new BamCardInformation(parcel);
        }

        /* renamed from: a */
        public BamCardInformation[] newArray(int i) {
            return new BamCardInformation[i];
        }
    };
    protected char[] cardAccountNumber;
    protected boolean cardAccountNumberValid = false;
    protected char[] cardCvvCode;
    protected char[] cardExpiryDate;
    protected char[] cardExpiryDateMonth;
    protected char[] cardExpiryDateYear;
    protected char[] cardHolderName;
    protected char[] cardNumber;
    protected char[] cardNumberGrouped;
    protected char[] cardNumberMasked;
    protected char[] cardSortCode;
    protected boolean cardSortCodeValid = false;
    protected CreditCardType cardType = CreditCardType.UNKNOWN;
    protected HashMap<String, String> customFields = new HashMap();

    public int describeContents() {
        return 0;
    }

    protected BamCardInformation() {
    }

    public BamCardInformation(Parcel parcel) {
        boolean z = false;
        this.cardNumber = new char[parcel.readInt()];
        parcel.readCharArray(this.cardNumber);
        this.cardNumberGrouped = new char[parcel.readInt()];
        parcel.readCharArray(this.cardNumberGrouped);
        this.cardNumberMasked = new char[parcel.readInt()];
        parcel.readCharArray(this.cardNumberMasked);
        this.cardHolderName = new char[parcel.readInt()];
        parcel.readCharArray(this.cardHolderName);
        this.cardSortCode = new char[parcel.readInt()];
        parcel.readCharArray(this.cardSortCode);
        this.cardAccountNumber = new char[parcel.readInt()];
        parcel.readCharArray(this.cardAccountNumber);
        this.cardType = (CreditCardType) parcel.readSerializable();
        this.cardExpiryDateMonth = new char[parcel.readInt()];
        parcel.readCharArray(this.cardExpiryDateMonth);
        this.cardExpiryDateYear = new char[parcel.readInt()];
        parcel.readCharArray(this.cardExpiryDateYear);
        this.cardCvvCode = new char[parcel.readInt()];
        parcel.readCharArray(this.cardCvvCode);
        this.customFields = (HashMap) parcel.readSerializable();
        this.cardAccountNumberValid = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.cardSortCodeValid = z;
    }

    public void clear() {
        if (this.cardNumber != null) {
            Arrays.fill(this.cardNumber, 0);
            this.cardNumber = null;
        }
        if (this.cardNumberGrouped != null) {
            Arrays.fill(this.cardNumberGrouped, 0);
            this.cardNumberGrouped = null;
        }
        if (this.cardNumberMasked != null) {
            Arrays.fill(this.cardNumberMasked, 0);
            this.cardNumberMasked = null;
        }
        if (this.cardHolderName != null) {
            Arrays.fill(this.cardHolderName, 0);
            this.cardHolderName = null;
        }
        if (this.cardSortCode != null) {
            Arrays.fill(this.cardSortCode, 0);
            this.cardSortCode = null;
            this.cardSortCodeValid = false;
        }
        if (this.cardAccountNumber != null) {
            Arrays.fill(this.cardAccountNumber, 0);
            this.cardAccountNumber = null;
            this.cardAccountNumberValid = false;
        }
        if (this.cardExpiryDateMonth != null) {
            Arrays.fill(this.cardExpiryDateMonth, 0);
            this.cardExpiryDateMonth = null;
        }
        if (this.cardExpiryDateYear != null) {
            Arrays.fill(this.cardExpiryDateYear, 0);
            this.cardExpiryDateYear = null;
        }
        if (this.cardExpiryDate != null) {
            Arrays.fill(this.cardExpiryDate, 0);
            this.cardExpiryDate = null;
        }
        if (this.cardCvvCode != null) {
            Arrays.fill(this.cardCvvCode, 0);
            this.cardCvvCode = null;
        }
        this.cardType = CreditCardType.UNKNOWN;
    }

    public boolean isCleared() {
        return this.cardNumber == null || this.cardNumber.length == 0;
    }

    public char[] getCardNumber() {
        return this.cardNumber == null ? new char[0] : this.cardNumber;
    }

    public char[] getCardNumberGrouped() {
        return this.cardNumberGrouped == null ? new char[0] : this.cardNumberGrouped;
    }

    public char[] getCardNumberMasked() {
        return this.cardNumberMasked == null ? new char[0] : this.cardNumberMasked;
    }

    public char[] getCardHolderName() {
        return this.cardHolderName == null ? new char[0] : this.cardHolderName;
    }

    public char[] getCardSortCode() {
        return this.cardSortCode == null ? new char[0] : this.cardSortCode;
    }

    public boolean isCardSortCodeValid() {
        return this.cardSortCodeValid;
    }

    public char[] getCardAccountNumber() {
        return this.cardAccountNumber == null ? new char[0] : this.cardAccountNumber;
    }

    public boolean isCardAccountNumberValid() {
        return this.cardAccountNumberValid;
    }

    public CreditCardType getCardType() {
        return this.cardType;
    }

    public char[] getCardExpiryDate() {
        if (getCardExpiryDateMonth().length == 0 || getCardExpiryDateYear().length == 0) {
            return new char[0];
        }
        if (this.cardExpiryDate == null) {
            this.cardExpiryDate = new char[5];
        }
        System.arraycopy(getCardExpiryDateMonth(), 0, this.cardExpiryDate, 0, getCardExpiryDateMonth().length);
        this.cardExpiryDate[2] = '/';
        System.arraycopy(getCardExpiryDateYear(), 0, this.cardExpiryDate, 3, getCardExpiryDateYear().length);
        return this.cardExpiryDate;
    }

    public char[] getCardExpiryDateMonth() {
        return this.cardExpiryDateMonth == null ? new char[0] : this.cardExpiryDateMonth;
    }

    public char[] getCardExpiryDateYear() {
        return this.cardExpiryDateYear == null ? new char[0] : this.cardExpiryDateYear;
    }

    public char[] getCardCvvCode() {
        return this.cardCvvCode == null ? new char[0] : this.cardCvvCode;
    }

    public String getCustomField(String str) {
        return (String) this.customFields.get(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.cardNumber != null ? this.cardNumber.length : 0);
        parcel.writeCharArray(this.cardNumber != null ? this.cardNumber : new char[0]);
        parcel.writeInt(this.cardNumberGrouped != null ? this.cardNumberGrouped.length : 0);
        parcel.writeCharArray(this.cardNumberGrouped != null ? this.cardNumberGrouped : new char[0]);
        parcel.writeInt(this.cardNumberMasked != null ? this.cardNumberMasked.length : 0);
        parcel.writeCharArray(this.cardNumberMasked != null ? this.cardNumberMasked : new char[0]);
        parcel.writeInt(this.cardHolderName != null ? this.cardHolderName.length : 0);
        parcel.writeCharArray(this.cardHolderName != null ? this.cardHolderName : new char[0]);
        parcel.writeInt(this.cardSortCode != null ? this.cardSortCode.length : 0);
        parcel.writeCharArray(this.cardSortCode != null ? this.cardSortCode : new char[0]);
        parcel.writeInt(this.cardAccountNumber != null ? this.cardAccountNumber.length : 0);
        parcel.writeCharArray(this.cardAccountNumber != null ? this.cardAccountNumber : new char[0]);
        parcel.writeSerializable(this.cardType);
        parcel.writeInt(this.cardExpiryDateMonth != null ? this.cardExpiryDateMonth.length : 0);
        parcel.writeCharArray(this.cardExpiryDateMonth != null ? this.cardExpiryDateMonth : new char[0]);
        parcel.writeInt(this.cardExpiryDateYear != null ? this.cardExpiryDateYear.length : 0);
        parcel.writeCharArray(this.cardExpiryDateYear != null ? this.cardExpiryDateYear : new char[0]);
        parcel.writeInt(this.cardCvvCode != null ? this.cardCvvCode.length : 0);
        parcel.writeCharArray(this.cardCvvCode != null ? this.cardCvvCode : new char[0]);
        parcel.writeSerializable(this.customFields);
        parcel.writeInt(this.cardAccountNumberValid);
        parcel.writeInt(this.cardSortCodeValid);
    }

    protected static BamCardInformation create(y yVar) {
        BamCardInformation bamCardInformation = new BamCardInformation();
        bamCardInformation.cardNumber = copyField(yVar.cardNumber);
        bamCardInformation.cardNumberGrouped = copyField(yVar.cardNumberGrouped);
        bamCardInformation.cardNumberMasked = copyField(yVar.cardNumberMasked);
        bamCardInformation.cardExpiryDateMonth = copyField(yVar.cardExpiryDateMonth);
        bamCardInformation.cardExpiryDateYear = copyField(yVar.cardExpiryDateYear);
        bamCardInformation.cardCvvCode = copyField(yVar.cardCvvCode);
        bamCardInformation.cardHolderName = copyField(yVar.cardHolderName);
        bamCardInformation.cardSortCode = copyField(yVar.cardSortCode);
        bamCardInformation.cardAccountNumber = copyField(yVar.cardAccountNumber);
        bamCardInformation.cardType = yVar.cardType;
        bamCardInformation.customFields = (HashMap) yVar.customFields.clone();
        bamCardInformation.cardSortCodeValid = yVar.cardSortCodeValid;
        bamCardInformation.cardAccountNumberValid = yVar.cardAccountNumberValid;
        return bamCardInformation;
    }

    protected static char[] copyField(char[] cArr) {
        return cArr != null ? Arrays.copyOf(cArr, cArr.length) : null;
    }
}
