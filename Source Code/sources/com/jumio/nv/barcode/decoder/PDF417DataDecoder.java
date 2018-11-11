package com.jumio.nv.barcode.decoder;

import android.annotation.SuppressLint;
import com.jumio.nv.barcode.decoder.exception.PDF417DecoderException;
import com.jumio.nv.barcode.enums.EyeColor;
import com.jumio.nv.enums.NVGender;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"SimpleDateFormat"})
public class PDF417DataDecoder {
    private static final String ADDRESS_CITY = "DAI";
    private static final String ADDRESS_CITY_2000 = "DAN";
    private static final String ADDRESS_STATE = "DAJ";
    private static final String ADDRESS_STATE_2000 = "DAO";
    private static final String ADDRESS_STREET_1 = "DAG";
    private static final String ADDRESS_STREET_1_2000 = "DAL";
    private static final String ADDRESS_STREET_2 = "DAH";
    private static final String ADDRESS_STREET_2_2000 = "DAM";
    private static final String ADDRESS_ZIP = "DAK";
    private static final String ADDRESS_ZIP_2000 = "DAP";
    private static final String COMPLIANCE_INDICATOR = "@";
    private static final int COMPLIANCE_INDICATOR_LENGTH = 1;
    private static final String DATE_OF_BIRTH = "DBB";
    private static final String ENDORSEMENT_CODES = "DCD";
    private static final String EXPIRY_DATE = "DBA";
    private static final String EYE_COLOR = "DAY";
    private static final String EYE_COLOR_BLACK = "BLK";
    private static final String EYE_COLOR_BLUE = "BLU";
    private static final String EYE_COLOR_BROWN = "BRO";
    private static final String EYE_COLOR_BROWN_LEGACY_1 = "BR";
    private static final String EYE_COLOR_BROWN_LEGACY_2 = "BRN";
    private static final String EYE_COLOR_DICHROMATIC = "DIC";
    private static final String EYE_COLOR_GRAY = "GRY";
    private static final String EYE_COLOR_GREEN = "GRN";
    private static final String EYE_COLOR_HAZEL = "HAZ";
    private static final String EYE_COLOR_HAZEL_LEGACY_1 = "HZL";
    private static final String EYE_COLOR_MAROON = "MAR";
    private static final String EYE_COLOR_PINK = "PNK";
    private static final String EYE_COLOR_UNKNOWN = "UNK";
    private static final String FALLBACK_RECORD_SEPARATOR = ",";
    private static final String FIRST_NAME = "DAC";
    private static final String GIVEN_NAME = "DCT";
    private static final String HEADER_REGEX = "@([\\x00-\\x1F\\x21-\\x40\\x5B-\\xFF]{2,3})[A-Z ]*([0-9]{6})([0-9]{2})[0-9]*";
    private static final String HEIGHT = "DAU";
    private static final String ID_NUMBER = "DAQ";
    private static final String IIN_COLORADO = "636020";
    private static final String ISSUE_DATE = "DBD";
    private static final String ISSUING_COUNTRY = "DCG";
    private static final String LAST_NAME = "DCS";
    private static final String LAST_NAME_2000 = "DAB";
    private static final int MAGSTRIPE_ADDRESS_MAX_LENGTH = 29;
    private static final int MAGSTRIPE_CDS_VERSION_LENGTH = 1;
    private static final int MAGSTRIPE_CITY_MAX_LENGTH = 13;
    private static final int MAGSTRIPE_CLASS_LENGTH = 2;
    private static final int MAGSTRIPE_DATE_OF_BIRTH_LENGTH = 8;
    private static final int MAGSTRIPE_ENDORSEMENTS_LENGTH = 4;
    private static final int MAGSTRIPE_EXPIRY_DATE_LENGTH = 4;
    private static final String MAGSTRIPE_FIELD_SEPERATOR = "^";
    private static final String MAGSTRIPE_IDNO_SEPERATOR = "=";
    private static final int MAGSTRIPE_IIN_LENGTH = 6;
    private static final int MAGSTRIPE_JURISDICATION_VERSION_LENGTH = 1;
    private static final String MAGSTRIPE_LINE_SEPERATOR = "\\$";
    private static final int MAGSTRIPE_NAME_MAX_LENGTH = 35;
    private static final int MAGSTRIPE_POSTAL_CODE_LENGTH = 11;
    private static final int MAGSTRIPE_RESTRICTION_LENGTH = 10;
    private static final int MAGSTRIPE_SEX_LENGTH = 1;
    private static final int MAGSTRIPE_STATE_LENGTH = 2;
    private static final String MAGSTRIPE_TRACK1_START = "%";
    private static final String MAGSTRIPE_TRACK2_START = ";";
    private static final String MAGSTRIPE_TRACK3_START = "%";
    private static final String MIDDLE_NAME = "DAD";
    private static final String NAME = "DAA";
    private static final String NAME_SUFFIX = "DCU";
    private static final String RESTRICTION_CODES = "DCB";
    private static final String SEX = "DBC";
    private static final String SUBFILE_DESIGNATOR_REGEX = "^((?:[A-Z]{2}[0-9]{8})*)";
    private static final String SUBFILE_TYPE_REGEX = "([A-Z]{2})";
    private static final String VEHICLE_CLASS = "DCA";
    private final String FORMAT_DDMM;
    private final String FORMAT_MMDD;
    private final String FORMAT_YYYY;
    private final String REGEX_DDMM;
    private final String REGEX_MMDD;
    private final String REGEX_YYYY;
    private int aamvaVersion;
    private PDF417Data data;
    private SimpleDateFormat dateFormat;
    private char[] delimiter;
    private int index;
    private String issuerIdentificationNumber;
    private String rawData;
    private ArrayList<String> subfiles;

    public PDF417DataDecoder() {
        this.REGEX_YYYY = "^(?:(?:19|20)\\d{2})$";
        this.REGEX_MMDD = "^(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01])$";
        this.REGEX_DDMM = "^(?:0[1-9]|[12][0-9]|3[01])(?:0[1-9]|1[0-2])$";
        this.FORMAT_YYYY = "yyyy";
        this.FORMAT_MMDD = "MMdd";
        this.FORMAT_DDMM = "ddMM";
        this.dateFormat = null;
        this.rawData = "";
        this.issuerIdentificationNumber = "";
        this.aamvaVersion = -1;
        this.index = 0;
        this.data = null;
        this.dateFormat = new SimpleDateFormat();
        this.subfiles = new ArrayList();
    }

    @SuppressLint({"NewApi"})
    public PDF417Data decode(byte[] bArr, Charset charset) {
        return decode(new String(bArr, charset));
    }

    public PDF417Data decode(String str) {
        if (str == null) {
            throw new PDF417DecoderException("Empty data");
        }
        this.rawData = str;
        if (str.substring(this.index, this.index + 1).equals(COMPLIANCE_INDICATOR)) {
            this.index++;
            parseHeader();
            parseSubfileDesignator();
            parseBarcode();
        } else {
            parseMagstripe();
        }
        manipulateData();
        return this.data;
    }

    private void parseHeader() {
        Matcher matcher = Pattern.compile(HEADER_REGEX).matcher(this.rawData);
        if (matcher.find()) {
            String group = matcher.group(1);
            this.delimiter = new char[group.length()];
            group.getChars(0, group.length(), this.delimiter, 0);
            this.issuerIdentificationNumber = matcher.group(2);
            this.aamvaVersion = Integer.parseInt(matcher.group(3));
        }
        this.rawData = this.rawData.replaceAll(HEADER_REGEX, "");
        this.index = 0;
    }

    private void parseSubfileDesignator() {
        Matcher matcher = Pattern.compile(SUBFILE_DESIGNATOR_REGEX).matcher(this.rawData);
        this.subfiles.clear();
        if (matcher.find()) {
            matcher = Pattern.compile(SUBFILE_TYPE_REGEX).matcher(matcher.group(1));
            while (matcher.find()) {
                this.subfiles.add(matcher.group(1));
            }
        }
        this.rawData = this.rawData.replaceAll(SUBFILE_DESIGNATOR_REGEX, "");
        this.index = 0;
    }

    private int getNearestSeparator() {
        if (this.delimiter == null || this.rawData == null) {
            throw new PDF417DecoderException("Delimiter or rawdata not set");
        } else if (this.index >= this.rawData.length()) {
            return -1;
        } else {
            int length = this.rawData.length();
            for (char indexOf : this.delimiter) {
                int indexOf2 = this.rawData.indexOf(indexOf, this.index);
                if (indexOf2 < length && indexOf2 != -1) {
                    length = indexOf2;
                }
            }
            return length;
        }
    }

    private void parseBarcode() {
        this.data = new PDF417Data();
        int nearestSeparator = getNearestSeparator();
        while (nearestSeparator != -1) {
            String substring = this.rawData.substring(this.index, nearestSeparator);
            for (int i = 0; i < this.subfiles.size(); i++) {
                if (substring.startsWith((String) this.subfiles.get(i))) {
                    substring = substring.substring(((String) this.subfiles.get(i)).length());
                    break;
                }
            }
            if (substring.startsWith(NAME)) {
                substring = substring.substring(NAME.length());
                int i2 = 2;
                String[] split;
                if (substring.contains(FALLBACK_RECORD_SEPARATOR)) {
                    split = substring.split(FALLBACK_RECORD_SEPARATOR);
                    if (this.aamvaVersion == 1 && IIN_COLORADO.equals(this.issuerIdentificationNumber)) {
                        if (split.length > 0) {
                            this.data.setFirstName(split[0]);
                        }
                        if (split.length > 2) {
                            this.data.setMiddleName(split[1]);
                        }
                        if (split.length > 1) {
                            this.data.setLastName(split[split.length - 1]);
                        }
                    } else {
                        if (split.length > 0) {
                            this.data.setLastName(split[0]);
                        }
                        if (split.length > 1) {
                            this.data.setFirstName(split[1]);
                        }
                        if (split.length > 2) {
                            this.data.setMiddleName(split[2]);
                        }
                    }
                } else {
                    split = substring.split(" ");
                    if (split.length > 0) {
                        if (split.length == 1) {
                            this.data.setLastName(split[0]);
                        } else if (split.length == 2) {
                            this.data.setFirstName(split[0]);
                            this.data.setLastName(split[1]);
                        } else {
                            this.data.setFirstName(split[0]);
                            this.data.setMiddleName(split[1]);
                            StringBuilder stringBuilder = new StringBuilder();
                            while (i2 < split.length) {
                                stringBuilder.append(split[i2]);
                                stringBuilder.append(" ");
                                i2++;
                            }
                            this.data.setLastName(stringBuilder.toString());
                        }
                    }
                }
            } else if (substring.startsWith(FIRST_NAME)) {
                this.data.setFirstName(substring.substring(FIRST_NAME.length()));
            } else if (substring.startsWith(GIVEN_NAME)) {
                this.data.setFirstName(substring.substring(GIVEN_NAME.length()).replaceAll(FALLBACK_RECORD_SEPARATOR, " "));
            } else if (substring.startsWith(LAST_NAME) || substring.startsWith(LAST_NAME_2000)) {
                this.data.setLastName(substring.substring(LAST_NAME.length()));
            } else if (substring.startsWith(MIDDLE_NAME)) {
                this.data.setMiddleName(substring.substring(MIDDLE_NAME.length()));
            } else if (substring.startsWith(NAME_SUFFIX)) {
                this.data.setNameSuffix(substring.substring(NAME_SUFFIX.length()));
            } else if (substring.startsWith(SEX)) {
                substring = substring.substring(SEX.length());
                if ("M".equals(substring) || "1".equals(substring)) {
                    this.data.setGender(NVGender.M);
                } else if ("F".equals(substring) || "2".equals(substring)) {
                    this.data.setGender(NVGender.F);
                }
            } else if (substring.startsWith(DATE_OF_BIRTH)) {
                this.data.setDateOfBirth(parseDate(substring.substring(DATE_OF_BIRTH.length()), true));
            } else if (substring.startsWith(EYE_COLOR)) {
                substring = substring.substring(EYE_COLOR.length());
                if (substring.equals(EYE_COLOR_BLACK)) {
                    this.data.setEyeColor(EyeColor.BLACK);
                } else if (substring.equals(EYE_COLOR_BLUE)) {
                    this.data.setEyeColor(EyeColor.BLUE);
                } else if (substring.equals(EYE_COLOR_BROWN) || substring.equals(EYE_COLOR_BROWN_LEGACY_1) || substring.equals(EYE_COLOR_BROWN_LEGACY_2)) {
                    this.data.setEyeColor(EyeColor.BROWN);
                } else if (substring.equals(EYE_COLOR_GRAY)) {
                    this.data.setEyeColor(EyeColor.GRAY);
                } else if (substring.equals(EYE_COLOR_GREEN)) {
                    this.data.setEyeColor(EyeColor.GREEN);
                } else if (substring.equals(EYE_COLOR_HAZEL) || substring.equals(EYE_COLOR_HAZEL_LEGACY_1)) {
                    this.data.setEyeColor(EyeColor.HAZEL);
                } else if (substring.equals(EYE_COLOR_MAROON)) {
                    this.data.setEyeColor(EyeColor.MAROON);
                } else if (substring.equals(EYE_COLOR_PINK)) {
                    this.data.setEyeColor(EyeColor.PINK);
                } else if (substring.equals(EYE_COLOR_DICHROMATIC)) {
                    this.data.setEyeColor(EyeColor.DICHROMATIC);
                } else if (substring.equals(EYE_COLOR_UNKNOWN)) {
                    this.data.setEyeColor(EyeColor.UNKNOWN);
                }
            } else if (substring.startsWith(HEIGHT)) {
                this.data.setHeight(substring.substring(HEIGHT.length()));
            } else if (substring.startsWith(ADDRESS_STREET_1) || substring.startsWith(ADDRESS_STREET_1_2000)) {
                this.data.setAddressStreet1(substring.substring(ADDRESS_STREET_1.length()));
            } else if (substring.startsWith(ADDRESS_STREET_2) || substring.startsWith(ADDRESS_STREET_2_2000)) {
                this.data.setAddressStreet2(substring.substring(ADDRESS_STREET_2.length()));
            } else if (substring.startsWith(ADDRESS_CITY) || substring.startsWith(ADDRESS_CITY_2000)) {
                this.data.setAddressCity(substring.substring(ADDRESS_CITY.length()));
            } else if (substring.startsWith(ADDRESS_STATE) || substring.startsWith(ADDRESS_STATE_2000)) {
                this.data.setAddressState(substring.substring(ADDRESS_CITY.length()));
            } else if (substring.startsWith(ADDRESS_ZIP) || substring.startsWith(ADDRESS_ZIP_2000)) {
                this.data.setAddressZip(substring.substring(ADDRESS_ZIP.length()));
            } else if (substring.startsWith(ID_NUMBER)) {
                this.data.setIdNumber(substring.substring(ID_NUMBER.length()));
            } else if (substring.startsWith(ISSUING_COUNTRY)) {
                this.data.setIssuingCountry(substring.substring(ISSUING_COUNTRY.length()));
            } else if (substring.startsWith(ISSUE_DATE)) {
                this.data.setIssueDate(parseDate(substring.substring(ISSUE_DATE.length()), true));
            } else if (substring.startsWith(EXPIRY_DATE)) {
                this.data.setExpiryDate(parseDate(substring.substring(EXPIRY_DATE.length()), false));
            } else if (substring.startsWith(VEHICLE_CLASS)) {
                this.data.setVehicleClass(substring.substring(VEHICLE_CLASS.length()));
            } else if (substring.startsWith(RESTRICTION_CODES)) {
                this.data.setRestrictionCodes(substring.substring(RESTRICTION_CODES.length()));
            } else if (substring.startsWith(ENDORSEMENT_CODES)) {
                this.data.setEndorsementCodes(substring.substring(ENDORSEMENT_CODES.length()));
            } else {
                this.data.addUnparsedData(substring, "\n");
            }
            this.index = nearestSeparator + 1;
            nearestSeparator = getNearestSeparator();
        }
    }

    private PDF417Data parseMagstripe() {
        try {
            int i;
            this.data = new PDF417Data();
            this.index = 0;
            if (this.rawData.startsWith("%")) {
                this.index++;
            }
            this.data.setAddressState(this.rawData.substring(this.index, this.index + 2));
            this.index += 2;
            int indexOf = this.rawData.indexOf(MAGSTRIPE_FIELD_SEPERATOR, this.index) - this.index;
            int i2 = indexOf < 13 ? 1 : 0;
            if (i2 != 0) {
                i = (13 - indexOf) + 0;
            } else {
                indexOf = 13;
                i = 0;
            }
            this.data.setAddressCity(this.rawData.substring(this.index, this.index + indexOf));
            this.index += indexOf + i2;
            indexOf = this.rawData.indexOf(MAGSTRIPE_FIELD_SEPERATOR, this.index) - this.index;
            i2 = indexOf < this.index + 35 ? 1 : 0;
            if (i2 != 0) {
                i += 35 - indexOf;
            } else {
                indexOf = 35;
            }
            String[] split = this.rawData.substring(this.index, this.index + indexOf).split(MAGSTRIPE_LINE_SEPERATOR);
            this.data.setLastName(split[0].replaceAll("[^A-Za-z\\- \\']", ""));
            if (split.length > 1) {
                this.data.setFirstName(split[1].replaceAll("[^A-Za-z\\- \\']", ""));
            }
            if (split.length > 2) {
                this.data.setMiddleName(split[2].replaceAll("[^A-Za-z\\- \\']", ""));
            }
            this.index += indexOf + i2;
            indexOf = this.rawData.indexOf(MAGSTRIPE_FIELD_SEPERATOR, this.index) - this.index;
            if (indexOf < 0 || indexOf > i + 29) {
                indexOf = i + 29;
                i = 0;
            } else {
                i = 1;
            }
            String[] split2 = this.rawData.substring(this.index, this.index + indexOf).split(MAGSTRIPE_LINE_SEPERATOR);
            this.data.setAddressStreet1(split2[0]);
            if (split2.length > 1) {
                this.data.setAddressStreet2(split2[1]);
            }
            this.index += indexOf + i;
            if (this.rawData.startsWith(MAGSTRIPE_FIELD_SEPERATOR, this.index)) {
                this.index++;
            }
            if (this.rawData.startsWith(MAGSTRIPE_TRACK2_START, this.index)) {
                this.index++;
            }
            this.issuerIdentificationNumber = this.rawData.substring(this.index, this.index + 6);
            this.index += 6;
            int indexOf2 = this.rawData.indexOf(MAGSTRIPE_IDNO_SEPERATOR, this.index) - this.index;
            this.data.setIdNumber(this.rawData.substring(this.index, this.index + indexOf2));
            this.index += indexOf2 + 1;
            this.dateFormat.applyPattern("yyMM");
            Date parse = this.dateFormat.parse(this.rawData.substring(this.index, this.index + 4));
            this.index += 4;
            this.dateFormat.applyPattern("yyyyMMdd");
            Date parse2 = this.dateFormat.parse(this.rawData.substring(this.index, this.index + 8));
            this.data.setDateOfBirth(parse2);
            this.index += 8;
            Calendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(parse2);
            i2 = gregorianCalendar.get(5);
            gregorianCalendar.setTime(parse);
            gregorianCalendar.set(5, i2);
            this.data.setExpiryDate(gregorianCalendar.getTime());
            if (this.rawData.indexOf("%", this.index) != -1) {
                this.index = this.rawData.indexOf("%", this.index) + "%".length();
            }
            this.index++;
            this.index++;
            this.data.setAddressZip(this.rawData.substring(this.index, this.index + 11));
            this.index += 11;
            this.index += 2;
            this.index += 10;
            this.index += 4;
            String substring = this.rawData.substring(this.index, this.index + 1);
            if ("1".equals(substring) || "M".equals(substring)) {
                this.data.setGender(NVGender.M);
            } else if ("2".equals(substring) || "F".equals(substring)) {
                this.data.setGender(NVGender.F);
            }
            return this.data;
        } catch (Exception e) {
            throw new PDF417DecoderException(e, "Incompatible magstripe structure");
        }
    }

    private void manipulateData() {
        if ("CAN".equals(this.data.getIssuingCountry()) && "BC".equals(this.data.getAddressState()) && this.data.getIdNumber() != null && this.data.getIdNumber().length() > 7 && this.data.getIdNumber().startsWith("28")) {
            this.data.setIdNumber(this.data.getIdNumber().substring(2));
        }
    }

    /* JADX WARNING: Missing block: B:28:0x00c1, code:
            if (r8.after(r9.parse(r9.format(new java.util.Date()))) != false) goto L_0x00c3;
     */
    private java.util.Date parseDate(java.lang.String r8, boolean r9) {
        /*
        r7 = this;
        r0 = r8.isEmpty();
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "\\D";
        r2 = "";
        r8 = r8.replaceAll(r0, r2);	 Catch:{ Exception -> 0x00c3 }
        r0 = 0;
        r2 = 4;
        r0 = r8.substring(r0, r2);	 Catch:{ Exception -> 0x00c3 }
        r2 = r8.substring(r2);	 Catch:{ Exception -> 0x00c3 }
        r3 = "^(?:(?:19|20)\\d{2})$";
        r3 = java.util.regex.Pattern.compile(r3);	 Catch:{ Exception -> 0x00c3 }
        r4 = "^(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01])$";
        r4 = java.util.regex.Pattern.compile(r4);	 Catch:{ Exception -> 0x00c3 }
        r5 = "^(?:0[1-9]|[12][0-9]|3[01])(?:0[1-9]|1[0-2])$";
        r5 = java.util.regex.Pattern.compile(r5);	 Catch:{ Exception -> 0x00c3 }
        r6 = r3.matcher(r0);	 Catch:{ Exception -> 0x00c3 }
        r6 = r6.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r6 == 0) goto L_0x0049;
    L_0x0036:
        r6 = r4.matcher(r2);	 Catch:{ Exception -> 0x00c3 }
        r6 = r6.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r6 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r7.dateFormat;	 Catch:{ Exception -> 0x00c3 }
        r2 = "yyyyMMdd";
        r0.applyPattern(r2);	 Catch:{ Exception -> 0x00c3 }
        goto L_0x009d;
    L_0x0049:
        r6 = r3.matcher(r0);	 Catch:{ Exception -> 0x00c3 }
        r6 = r6.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r6 == 0) goto L_0x0066;
    L_0x0053:
        r6 = r5.matcher(r2);	 Catch:{ Exception -> 0x00c3 }
        r6 = r6.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r6 == 0) goto L_0x0066;
    L_0x005d:
        r0 = r7.dateFormat;	 Catch:{ Exception -> 0x00c3 }
        r2 = "yyyyddMM";
        r0.applyPattern(r2);	 Catch:{ Exception -> 0x00c3 }
        goto L_0x009d;
    L_0x0066:
        r4 = r4.matcher(r0);	 Catch:{ Exception -> 0x00c3 }
        r4 = r4.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r4 == 0) goto L_0x0082;
    L_0x0070:
        r4 = r3.matcher(r2);	 Catch:{ Exception -> 0x00c3 }
        r4 = r4.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r4 == 0) goto L_0x0082;
    L_0x007a:
        r0 = r7.dateFormat;	 Catch:{ Exception -> 0x00c3 }
        r2 = "MMddyyyy";
        r0.applyPattern(r2);	 Catch:{ Exception -> 0x00c3 }
        goto L_0x009d;
    L_0x0082:
        r0 = r5.matcher(r0);	 Catch:{ Exception -> 0x00c3 }
        r0 = r0.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r0 == 0) goto L_0x009d;
    L_0x008c:
        r0 = r3.matcher(r2);	 Catch:{ Exception -> 0x00c3 }
        r0 = r0.matches();	 Catch:{ Exception -> 0x00c3 }
        if (r0 == 0) goto L_0x009d;
    L_0x0096:
        r0 = r7.dateFormat;	 Catch:{ Exception -> 0x00c3 }
        r2 = "ddMMyyyy";
        r0.applyPattern(r2);	 Catch:{ Exception -> 0x00c3 }
    L_0x009d:
        r0 = r7.dateFormat;	 Catch:{ Exception -> 0x00c3 }
        r8 = r0.parse(r8);	 Catch:{ Exception -> 0x00c3 }
        if (r9 == 0) goto L_0x00c4;
    L_0x00a5:
        r9 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x00c4 }
        r0 = "dd/MM/yyyy";
        r2 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x00c4 }
        r9.<init>(r0, r2);	 Catch:{ Exception -> 0x00c4 }
        r0 = new java.util.Date;	 Catch:{ Exception -> 0x00c4 }
        r0.<init>();	 Catch:{ Exception -> 0x00c4 }
        r0 = r9.format(r0);	 Catch:{ Exception -> 0x00c4 }
        r9 = r9.parse(r0);	 Catch:{ Exception -> 0x00c4 }
        r9 = r8.after(r9);	 Catch:{ Exception -> 0x00c4 }
        if (r9 == 0) goto L_0x00c4;
    L_0x00c3:
        r8 = r1;
    L_0x00c4:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.barcode.decoder.PDF417DataDecoder.parseDate(java.lang.String, boolean):java.util.Date");
    }
}
