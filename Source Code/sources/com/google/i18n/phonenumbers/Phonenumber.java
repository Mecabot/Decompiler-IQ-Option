package com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber {

    public static class PhoneNumber implements Serializable {
        private static final long serialVersionUID = 1;
        private CountryCodeSource countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
        private int countryCode_ = 0;
        private String extension_ = "";
        private boolean hasCountryCode;
        private boolean hasCountryCodeSource;
        private boolean hasExtension;
        private boolean hasItalianLeadingZero;
        private boolean hasNationalNumber;
        private boolean hasNumberOfLeadingZeros;
        private boolean hasPreferredDomesticCarrierCode;
        private boolean hasRawInput;
        private boolean italianLeadingZero_ = false;
        private long nationalNumber_ = 0;
        private int numberOfLeadingZeros_ = 1;
        private String preferredDomesticCarrierCode_ = "";
        private String rawInput_ = "";

        public enum CountryCodeSource {
            FROM_NUMBER_WITH_PLUS_SIGN,
            FROM_NUMBER_WITH_IDD,
            FROM_NUMBER_WITHOUT_PLUS_SIGN,
            FROM_DEFAULT_COUNTRY,
            UNSPECIFIED
        }

        public boolean yc() {
            return this.hasCountryCode;
        }

        public int xE() {
            return this.countryCode_;
        }

        public PhoneNumber bK(int i) {
            this.hasCountryCode = true;
            this.countryCode_ = i;
            return this;
        }

        public boolean yd() {
            return this.hasNationalNumber;
        }

        public long ye() {
            return this.nationalNumber_;
        }

        public PhoneNumber N(long j) {
            this.hasNationalNumber = true;
            this.nationalNumber_ = j;
            return this;
        }

        public boolean yf() {
            return this.hasExtension;
        }

        public String getExtension() {
            return this.extension_;
        }

        public PhoneNumber dE(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasExtension = true;
            this.extension_ = str;
            return this;
        }

        public boolean yg() {
            return this.hasItalianLeadingZero;
        }

        public boolean yh() {
            return this.italianLeadingZero_;
        }

        public PhoneNumber an(boolean z) {
            this.hasItalianLeadingZero = true;
            this.italianLeadingZero_ = z;
            return this;
        }

        public boolean yi() {
            return this.hasNumberOfLeadingZeros;
        }

        public int yj() {
            return this.numberOfLeadingZeros_;
        }

        public PhoneNumber bL(int i) {
            this.hasNumberOfLeadingZeros = true;
            this.numberOfLeadingZeros_ = i;
            return this;
        }

        public boolean yk() {
            return this.hasRawInput;
        }

        public String yl() {
            return this.rawInput_;
        }

        public PhoneNumber dF(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasRawInput = true;
            this.rawInput_ = str;
            return this;
        }

        public boolean ym() {
            return this.hasCountryCodeSource;
        }

        public CountryCodeSource yn() {
            return this.countryCodeSource_;
        }

        public PhoneNumber a(CountryCodeSource countryCodeSource) {
            if (countryCodeSource == null) {
                throw new NullPointerException();
            }
            this.hasCountryCodeSource = true;
            this.countryCodeSource_ = countryCodeSource;
            return this;
        }

        public PhoneNumber yo() {
            this.hasCountryCodeSource = false;
            this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
            return this;
        }

        public boolean yp() {
            return this.hasPreferredDomesticCarrierCode;
        }

        public String yq() {
            return this.preferredDomesticCarrierCode_;
        }

        public PhoneNumber dG(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasPreferredDomesticCarrierCode = true;
            this.preferredDomesticCarrierCode_ = str;
            return this;
        }

        public boolean d(PhoneNumber phoneNumber) {
            boolean z = false;
            if (phoneNumber == null) {
                return false;
            }
            if (this == phoneNumber) {
                return true;
            }
            if (this.countryCode_ == phoneNumber.countryCode_ && this.nationalNumber_ == phoneNumber.nationalNumber_ && this.extension_.equals(phoneNumber.extension_) && this.italianLeadingZero_ == phoneNumber.italianLeadingZero_ && this.numberOfLeadingZeros_ == phoneNumber.numberOfLeadingZeros_ && this.rawInput_.equals(phoneNumber.rawInput_) && this.countryCodeSource_ == phoneNumber.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(phoneNumber.preferredDomesticCarrierCode_) && yp() == phoneNumber.yp()) {
                z = true;
            }
            return z;
        }

        public boolean equals(Object obj) {
            return (obj instanceof PhoneNumber) && d((PhoneNumber) obj);
        }

        public int hashCode() {
            int i = 1237;
            int xE = (((((((((((((((2173 + xE()) * 53) + Long.valueOf(ye()).hashCode()) * 53) + getExtension().hashCode()) * 53) + (yh() ? 1231 : 1237)) * 53) + yj()) * 53) + yl().hashCode()) * 53) + yn().hashCode()) * 53) + yq().hashCode()) * 53;
            if (yp()) {
                i = 1231;
            }
            return xE + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country Code: ");
            stringBuilder.append(this.countryCode_);
            stringBuilder.append(" National Number: ");
            stringBuilder.append(this.nationalNumber_);
            if (yg() && yh()) {
                stringBuilder.append(" Leading Zero(s): true");
            }
            if (yi()) {
                stringBuilder.append(" Number of leading zeros: ");
                stringBuilder.append(this.numberOfLeadingZeros_);
            }
            if (yf()) {
                stringBuilder.append(" Extension: ");
                stringBuilder.append(this.extension_);
            }
            if (ym()) {
                stringBuilder.append(" Country Code Source: ");
                stringBuilder.append(this.countryCodeSource_);
            }
            if (yp()) {
                stringBuilder.append(" Preferred Domestic Carrier Code: ");
                stringBuilder.append(this.preferredDomesticCarrierCode_);
            }
            return stringBuilder.toString();
        }
    }
}
