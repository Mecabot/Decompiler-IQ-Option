package com.google.i18n.phonenumbers;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.i18n.phonenumbers.NumberParseException.ErrorType;
import com.google.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import com.google.i18n.phonenumbers.internal.a;
import com.google.i18n.phonenumbers.internal.b;
import com.google.i18n.phonenumbers.internal.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    static final Pattern aaA = Pattern.compile("[\\\\/] *x");
    static final Pattern aaB = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    private static final Pattern aaC = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String aaD;
    private static final String aaE;
    static final String aaF;
    private static final Pattern aaG;
    private static final Pattern aaH;
    static final Pattern aaI = Pattern.compile("(\\D+)");
    private static final Pattern aaJ = Pattern.compile("(\\$\\d)");
    private static final Pattern aaK = Pattern.compile("\\(?\\$1\\)?");
    private static PhoneNumberUtil aaL;
    private static final Map<Integer, String> aan;
    private static final Set<Integer> aao;
    private static final Set<Integer> aap;
    private static final Map<Character, Character> aaq;
    private static final Map<Character, Character> aar;
    private static final Map<Character, Character> aas;
    private static final Map<Character, Character> aat;
    private static final Pattern aau = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final String aav;
    static final Pattern aaw = Pattern.compile("[+＋]+");
    private static final Pattern aax = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern aay = Pattern.compile("(\\p{Nd})");
    private static final Pattern aaz = Pattern.compile("[+＋\\p{Nd}]");
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final f aaM;
    private final Map<Integer, List<String>> aaN;
    private final a aaO = b.ys();
    private final Set<String> aaP = new HashSet(35);
    private final Set<String> aaQ = new HashSet(320);
    private final Set<Integer> aaR = new HashSet();
    private final c aad = new c(100);

    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aaS = new int[CountryCodeSource.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:25:?, code:
            aaU[com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOICEMAIL.ordinal()] = 11;
     */
        /* JADX WARNING: Missing block: B:34:?, code:
            aaT[com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL.ordinal()] = 4;
     */
        /* JADX WARNING: Missing block: B:43:?, code:
            aaS[com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
     */
        static {
            /*
            r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.values();
            r0 = r0.length;
            r0 = new int[r0];
            aaU = r0;
            r0 = 1;
            r1 = aaU;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = aaU;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.TOLL_FREE;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = aaU;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4;
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = 5;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x004b }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.SHARED_COST;	 Catch:{ NoSuchFieldError -> 0x004b }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r6 = 6;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOIP;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r6 = 7;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r6 = 8;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x006e }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PAGER;	 Catch:{ NoSuchFieldError -> 0x006e }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x006e }
            r6 = 9;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x006e }
        L_0x006e:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x007a }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UAN;	 Catch:{ NoSuchFieldError -> 0x007a }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x007a }
            r6 = 10;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x007a }
        L_0x007a:
            r4 = aaU;	 Catch:{ NoSuchFieldError -> 0x0086 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOICEMAIL;	 Catch:{ NoSuchFieldError -> 0x0086 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
            r6 = 11;
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0086 }
        L_0x0086:
            r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.values();
            r4 = r4.length;
            r4 = new int[r4];
            aaT = r4;
            r4 = aaT;	 Catch:{ NoSuchFieldError -> 0x0099 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164;	 Catch:{ NoSuchFieldError -> 0x0099 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0099 }
            r4[r5] = r0;	 Catch:{ NoSuchFieldError -> 0x0099 }
        L_0x0099:
            r4 = aaT;	 Catch:{ NoSuchFieldError -> 0x00a3 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL;	 Catch:{ NoSuchFieldError -> 0x00a3 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x00a3 }
            r4[r5] = r1;	 Catch:{ NoSuchFieldError -> 0x00a3 }
        L_0x00a3:
            r4 = aaT;	 Catch:{ NoSuchFieldError -> 0x00ad }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.RFC3966;	 Catch:{ NoSuchFieldError -> 0x00ad }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ad }
            r4[r5] = r2;	 Catch:{ NoSuchFieldError -> 0x00ad }
        L_0x00ad:
            r4 = aaT;	 Catch:{ NoSuchFieldError -> 0x00b7 }
            r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL;	 Catch:{ NoSuchFieldError -> 0x00b7 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b7 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x00b7 }
        L_0x00b7:
            r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.values();
            r4 = r4.length;
            r4 = new int[r4];
            aaS = r4;
            r4 = aaS;	 Catch:{ NoSuchFieldError -> 0x00ca }
            r5 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;	 Catch:{ NoSuchFieldError -> 0x00ca }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ca }
            r4[r5] = r0;	 Catch:{ NoSuchFieldError -> 0x00ca }
        L_0x00ca:
            r0 = aaS;	 Catch:{ NoSuchFieldError -> 0x00d4 }
            r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;	 Catch:{ NoSuchFieldError -> 0x00d4 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x00d4 }
            r0[r4] = r1;	 Catch:{ NoSuchFieldError -> 0x00d4 }
        L_0x00d4:
            r0 = aaS;	 Catch:{ NoSuchFieldError -> 0x00de }
            r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN;	 Catch:{ NoSuchFieldError -> 0x00de }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00de }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00de }
        L_0x00de:
            r0 = aaS;	 Catch:{ NoSuchFieldError -> 0x00e8 }
            r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;	 Catch:{ NoSuchFieldError -> 0x00e8 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00e8 }
            r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x00e8 }
        L_0x00e8:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.1.<clinit>():void");
        }
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), "1");
        hashMap.put(Integer.valueOf(54), "9");
        aan = Collections.unmodifiableMap(hashMap);
        Collection hashSet = new HashSet();
        hashSet.add(Integer.valueOf(86));
        aao = Collections.unmodifiableSet(hashSet);
        Set hashSet2 = new HashSet();
        hashSet2.add(Integer.valueOf(52));
        hashSet2.add(Integer.valueOf(54));
        hashSet2.add(Integer.valueOf(55));
        hashSet2.add(Integer.valueOf(62));
        hashSet2.addAll(hashSet);
        aap = Collections.unmodifiableSet(hashSet2);
        hashMap = new HashMap();
        hashMap.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('9'), Character.valueOf('9'));
        Map hashMap2 = new HashMap(40);
        hashMap2.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap2.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap2.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap2.put(Character.valueOf('Z'), Character.valueOf('9'));
        aar = Collections.unmodifiableMap(hashMap2);
        Map hashMap3 = new HashMap(100);
        hashMap3.putAll(aar);
        hashMap3.putAll(hashMap);
        aas = Collections.unmodifiableMap(hashMap3);
        hashMap3 = new HashMap();
        hashMap3.putAll(hashMap);
        hashMap3.put(Character.valueOf('+'), Character.valueOf('+'));
        hashMap3.put(Character.valueOf('*'), Character.valueOf('*'));
        hashMap3.put(Character.valueOf('#'), Character.valueOf('#'));
        aaq = Collections.unmodifiableMap(hashMap3);
        hashMap3 = new HashMap();
        for (Character charValue : aar.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap3.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap3.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap3.putAll(hashMap);
        hashMap3.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(65293), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8208), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8209), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8210), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8211), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8212), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8213), Character.valueOf('-'));
        hashMap3.put(Character.valueOf(8722), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(65295), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap3.put(Character.valueOf(12288), Character.valueOf(' '));
        hashMap3.put(Character.valueOf(8288), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap3.put(Character.valueOf(65294), Character.valueOf('.'));
        aat = Collections.unmodifiableMap(hashMap3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Arrays.toString(aar.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        stringBuilder.append(Arrays.toString(aar.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        aav = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*");
        stringBuilder.append(aav);
        stringBuilder.append("\\p{Nd}");
        stringBuilder.append("]*");
        aaD = stringBuilder.toString();
        String str = "xｘ#＃~～";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(",;");
        stringBuilder2.append(str);
        aaE = dk(stringBuilder2.toString());
        aaF = dk(str);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(?:");
        stringBuilder.append(aaE);
        stringBuilder.append(")$");
        aaG = Pattern.compile(stringBuilder.toString(), 66);
        stringBuilder = new StringBuilder();
        stringBuilder.append(aaD);
        stringBuilder.append("(?:");
        stringBuilder.append(aaE);
        stringBuilder.append(")?");
        aaH = Pattern.compile(stringBuilder.toString(), 66);
    }

    private static String dk(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[");
        stringBuilder.append(str);
        stringBuilder.append("]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*");
        stringBuilder.append("(\\p{Nd}{1,7})");
        stringBuilder.append("#?|[- ]+(");
        stringBuilder.append("\\p{Nd}");
        stringBuilder.append("{1,5})#");
        return stringBuilder.toString();
    }

    PhoneNumberUtil(f fVar, Map<Integer, List<String>> map) {
        this.aaM = fVar;
        this.aaN = map;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.aaR.add(entry.getKey());
            } else {
                this.aaQ.addAll(list);
            }
        }
        if (this.aaQ.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.aaP.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    static CharSequence d(CharSequence charSequence) {
        Matcher matcher = aaz.matcher(charSequence);
        if (!matcher.find()) {
            return "";
        }
        charSequence = charSequence.subSequence(matcher.start(), charSequence.length());
        matcher = aaB.matcher(charSequence);
        if (matcher.find()) {
            charSequence = charSequence.subSequence(0, matcher.start());
        }
        matcher = aaA.matcher(charSequence);
        if (matcher.find()) {
            charSequence = charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    static boolean e(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return aaH.matcher(charSequence).matches();
    }

    static StringBuilder k(StringBuilder stringBuilder) {
        if (aaC.matcher(stringBuilder).matches()) {
            stringBuilder.replace(0, stringBuilder.length(), a((CharSequence) stringBuilder, aas, true));
        } else {
            stringBuilder.replace(0, stringBuilder.length(), f(stringBuilder));
        }
        return stringBuilder;
    }

    public static String f(CharSequence charSequence) {
        return a(charSequence, false).toString();
    }

    static StringBuilder a(CharSequence charSequence, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                stringBuilder.append(digit);
            } else if (z) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder;
    }

    private static String a(CharSequence charSequence, Map<Character, Character> map, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                stringBuilder.append(ch);
            } else if (!z) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    static synchronized void a(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            aaL = phoneNumberUtil;
        }
    }

    private static boolean a(PhoneNumberDesc phoneNumberDesc) {
        return (phoneNumberDesc.xX() == 1 && phoneNumberDesc.bJ(0) == -1) ? false : true;
    }

    public static synchronized PhoneNumberUtil xo() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (aaL == null) {
                a(a(e.aae));
            }
            phoneNumberUtil = aaL;
        }
        return phoneNumberUtil;
    }

    public static PhoneNumberUtil a(d dVar) {
        if (dVar != null) {
            return a(new g(dVar));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static PhoneNumberUtil a(f fVar) {
        if (fVar != null) {
            return new PhoneNumberUtil(fVar, c.xm());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    static boolean dl(String str) {
        return str.length() == 0 || aaK.matcher(str).matches();
    }

    private boolean dm(String str) {
        return str != null && this.aaQ.contains(str);
    }

    private boolean bF(int i) {
        return this.aaN.containsKey(Integer.valueOf(i));
    }

    public String a(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.ye() == 0 && phoneNumber.yk()) {
            String yl = phoneNumber.yl();
            if (yl.length() > 0) {
                return yl;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        a(phoneNumber, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    public void a(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int xE = phoneNumber.xE();
        String a = a(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            stringBuilder.append(a);
            a(xE, PhoneNumberFormat.E164, stringBuilder);
        } else if (bF(xE)) {
            PhoneMetadata e = e(xE, bG(xE));
            stringBuilder.append(a(a, e, phoneNumberFormat));
            a(phoneNumber, e, phoneNumberFormat, stringBuilder);
            a(xE, phoneNumberFormat, stringBuilder);
        } else {
            stringBuilder.append(a);
        }
    }

    private PhoneMetadata e(int i, String str) {
        if ("001".equals(str)) {
            return bD(i);
        }
        return de(str);
    }

    public String a(PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.yh() && phoneNumber.yj() > 0) {
            char[] cArr = new char[phoneNumber.yj()];
            Arrays.fill(cArr, '0');
            stringBuilder.append(new String(cArr));
        }
        stringBuilder.append(phoneNumber.ye());
        return stringBuilder.toString();
    }

    private void a(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        switch (phoneNumberFormat) {
            case E164:
                stringBuilder.insert(0, i).insert(0, '+');
                return;
            case INTERNATIONAL:
                stringBuilder.insert(0, " ").insert(0, i).insert(0, '+');
                return;
            case RFC3966:
                stringBuilder.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
                return;
            default:
                return;
        }
    }

    private String a(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return a(str, phoneMetadata, phoneNumberFormat, null);
    }

    private String a(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        List xN;
        if (phoneMetadata.xP().size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
            xN = phoneMetadata.xN();
        } else {
            xN = phoneMetadata.xP();
        }
        NumberFormat b = b(xN, str);
        return b == null ? str : a(str, b, phoneNumberFormat, charSequence);
    }

    NumberFormat b(List<NumberFormat> list, String str) {
        for (NumberFormat numberFormat : list) {
            int xp = numberFormat.xp();
            if ((xp == 0 || this.aad.dH(numberFormat.bH(xp - 1)).matcher(str).lookingAt()) && this.aad.dH(numberFormat.getPattern()).matcher(str).matches()) {
                return numberFormat;
            }
        }
        return null;
    }

    private String a(String str, NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        CharSequence replaceAll;
        Object format = numberFormat.getFormat();
        Matcher matcher = this.aad.dH(numberFormat.getPattern()).matcher(str);
        if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || charSequence == null || charSequence.length() <= 0 || numberFormat.xs().length() <= 0) {
            String xq = numberFormat.xq();
            if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || xq == null || xq.length() <= 0) {
                replaceAll = matcher.replaceAll(format);
            } else {
                replaceAll = matcher.replaceAll(aaJ.matcher(format).replaceFirst(xq));
            }
        } else {
            replaceAll = matcher.replaceAll(aaJ.matcher(format).replaceFirst(numberFormat.xs().replace("$CC", charSequence)));
        }
        if (phoneNumberFormat != PhoneNumberFormat.RFC3966) {
            return replaceAll;
        }
        Matcher matcher2 = aax.matcher(replaceAll);
        if (matcher2.lookingAt()) {
            replaceAll = matcher2.replaceFirst("");
        }
        return matcher2.reset(replaceAll).replaceAll("-");
    }

    public PhoneNumber a(String str, PhoneNumberType phoneNumberType) {
        if (dm(str)) {
            PhoneNumberDesc a = a(de(str), phoneNumberType);
            try {
                if (a.ya()) {
                    return b(a.yb(), str);
                }
            } catch (NumberParseException e) {
                logger.log(Level.SEVERE, e.toString());
            }
            return null;
        }
        Logger logger = logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid or unknown region code provided: ");
        stringBuilder.append(str);
        logger.log(level, stringBuilder.toString());
        return null;
    }

    private void a(PhoneNumber phoneNumber, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        if (phoneNumber.yf() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                stringBuilder.append(";ext=");
                stringBuilder.append(phoneNumber.getExtension());
            } else if (phoneMetadata.xH()) {
                stringBuilder.append(phoneMetadata.xI());
                stringBuilder.append(phoneNumber.getExtension());
            } else {
                stringBuilder.append(" ext. ");
                stringBuilder.append(phoneNumber.getExtension());
            }
        }
    }

    PhoneNumberDesc a(PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (phoneNumberType) {
            case PREMIUM_RATE:
                return phoneMetadata.xx();
            case TOLL_FREE:
                return phoneMetadata.xw();
            case MOBILE:
                return phoneMetadata.xv();
            case FIXED_LINE:
            case FIXED_LINE_OR_MOBILE:
                return phoneMetadata.xu();
            case SHARED_COST:
                return phoneMetadata.xy();
            case VOIP:
                return phoneMetadata.xA();
            case PERSONAL_NUMBER:
                return phoneMetadata.xz();
            case PAGER:
                return phoneMetadata.xB();
            case UAN:
                return phoneMetadata.xC();
            case VOICEMAIL:
                return phoneMetadata.xD();
            default:
                return phoneMetadata.xt();
        }
    }

    private PhoneNumberType a(String str, PhoneMetadata phoneMetadata) {
        if (!a(str, phoneMetadata.xt())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (a(str, phoneMetadata.xx())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (a(str, phoneMetadata.xw())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (a(str, phoneMetadata.xy())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (a(str, phoneMetadata.xA())) {
            return PhoneNumberType.VOIP;
        }
        if (a(str, phoneMetadata.xz())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (a(str, phoneMetadata.xB())) {
            return PhoneNumberType.PAGER;
        }
        if (a(str, phoneMetadata.xC())) {
            return PhoneNumberType.UAN;
        }
        if (a(str, phoneMetadata.xD())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (a(str, phoneMetadata.xu())) {
            if (phoneMetadata.xM()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (a(str, phoneMetadata.xv())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (phoneMetadata.xM() || !a(str, phoneMetadata.xv())) {
            return PhoneNumberType.UNKNOWN;
        } else {
            return PhoneNumberType.MOBILE;
        }
    }

    PhoneMetadata de(String str) {
        if (dm(str)) {
            return this.aaM.de(str);
        }
        return null;
    }

    PhoneMetadata bD(int i) {
        if (this.aaN.containsKey(Integer.valueOf(i))) {
            return this.aaM.bD(i);
        }
        return null;
    }

    boolean a(String str, PhoneNumberDesc phoneNumberDesc) {
        int length = str.length();
        List xW = phoneNumberDesc.xW();
        if (xW.size() <= 0 || xW.contains(Integer.valueOf(length))) {
            return this.aaO.a(str, phoneNumberDesc, false);
        }
        return false;
    }

    public boolean b(PhoneNumber phoneNumber) {
        return a(phoneNumber, c(phoneNumber));
    }

    public boolean a(PhoneNumber phoneNumber, String str) {
        int xE = phoneNumber.xE();
        PhoneMetadata e = e(xE, str);
        boolean z = false;
        if (e == null || (!"001".equals(str) && xE != do(str))) {
            return false;
        }
        if (a(a(phoneNumber), e) != PhoneNumberType.UNKNOWN) {
            z = true;
        }
        return z;
    }

    public String c(PhoneNumber phoneNumber) {
        int xE = phoneNumber.xE();
        List list = (List) this.aaN.get(Integer.valueOf(xE));
        if (list == null) {
            Logger logger = logger;
            Level level = Level.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing/invalid country_code (");
            stringBuilder.append(xE);
            stringBuilder.append(")");
            logger.log(level, stringBuilder.toString());
            return null;
        } else if (list.size() == 1) {
            return (String) list.get(0);
        } else {
            return a(phoneNumber, list);
        }
    }

    private String a(PhoneNumber phoneNumber, List<String> list) {
        String a = a(phoneNumber);
        for (String str : list) {
            PhoneMetadata de = de(str);
            if (de.xR()) {
                if (this.aad.dH(de.xS()).matcher(a).lookingAt()) {
                    return str;
                }
            } else if (a(a, de) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public String bG(int i) {
        List list = (List) this.aaN.get(Integer.valueOf(i));
        if (list == null) {
            return "ZZ";
        }
        return (String) list.get(0);
    }

    public int dn(String str) {
        if (dm(str)) {
            return do(str);
        }
        Logger logger = logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        stringBuilder.append(str);
        stringBuilder.append(") provided.");
        logger.log(level, stringBuilder.toString());
        return 0;
    }

    private int do(String str) {
        PhoneMetadata de = de(str);
        if (de != null) {
            return de.xE();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid region code: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private ValidationResult a(CharSequence charSequence, PhoneMetadata phoneMetadata) {
        return a(charSequence, phoneMetadata, PhoneNumberType.UNKNOWN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    private com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult a(java.lang.CharSequence r4, com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata r5, com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType r6) {
        /*
        r3 = this;
        r0 = r3.a(r5, r6);
        r1 = r0.xW();
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0017;
    L_0x000e:
        r1 = r5.xt();
        r1 = r1.xW();
        goto L_0x001b;
    L_0x0017:
        r1 = r0.xW();
    L_0x001b:
        r0 = r0.xY();
        r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE;
        if (r6 != r2) goto L_0x0080;
    L_0x0023:
        r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE;
        r6 = r3.a(r5, r6);
        r6 = a(r6);
        if (r6 != 0) goto L_0x0036;
    L_0x002f:
        r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE;
        r4 = r3.a(r4, r5, r6);
        return r4;
    L_0x0036:
        r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE;
        r6 = r3.a(r5, r6);
        r2 = a(r6);
        if (r2 == 0) goto L_0x0080;
    L_0x0042:
        r2 = new java.util.ArrayList;
        r2.<init>(r1);
        r1 = r6.xW();
        r1 = r1.size();
        if (r1 != 0) goto L_0x005a;
    L_0x0051:
        r5 = r5.xt();
        r5 = r5.xW();
        goto L_0x005e;
    L_0x005a:
        r5 = r6.xW();
    L_0x005e:
        r2.addAll(r5);
        java.util.Collections.sort(r2);
        r5 = r0.isEmpty();
        if (r5 == 0) goto L_0x006f;
    L_0x006a:
        r0 = r6.xY();
        goto L_0x0081;
    L_0x006f:
        r5 = new java.util.ArrayList;
        r5.<init>(r0);
        r6 = r6.xY();
        r5.addAll(r6);
        java.util.Collections.sort(r5);
        r0 = r5;
        goto L_0x0081;
    L_0x0080:
        r2 = r1;
    L_0x0081:
        r5 = 0;
        r6 = r2.get(r5);
        r6 = (java.lang.Integer) r6;
        r6 = r6.intValue();
        r1 = -1;
        if (r6 != r1) goto L_0x0092;
    L_0x008f:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH;
        return r4;
    L_0x0092:
        r4 = r4.length();
        r6 = java.lang.Integer.valueOf(r4);
        r6 = r0.contains(r6);
        if (r6 == 0) goto L_0x00a3;
    L_0x00a0:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        return r4;
    L_0x00a3:
        r5 = r2.get(r5);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        if (r5 != r4) goto L_0x00b2;
    L_0x00af:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE;
        return r4;
    L_0x00b2:
        if (r5 <= r4) goto L_0x00b7;
    L_0x00b4:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_SHORT;
        return r4;
    L_0x00b7:
        r5 = r2.size();
        r6 = 1;
        r5 = r5 - r6;
        r5 = r2.get(r5);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        if (r5 >= r4) goto L_0x00cc;
    L_0x00c9:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_LONG;
        return r4;
    L_0x00cc:
        r5 = r2.size();
        r5 = r2.subList(r6, r5);
        r4 = java.lang.Integer.valueOf(r4);
        r4 = r5.contains(r4);
        if (r4 == 0) goto L_0x00e1;
    L_0x00de:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE;
        goto L_0x00e3;
    L_0x00e1:
        r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH;
    L_0x00e3:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.a(java.lang.CharSequence, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata, com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType):com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult");
    }

    public b dp(String str) {
        return new b(str);
    }

    int a(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int length = stringBuilder.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(stringBuilder.substring(0, i));
            if (this.aaN.containsKey(Integer.valueOf(parseInt))) {
                stringBuilder2.append(stringBuilder.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }

    int a(CharSequence charSequence, PhoneMetadata phoneMetadata, StringBuilder stringBuilder, boolean z, PhoneNumber phoneNumber) {
        if (charSequence.length() == 0) {
            return 0;
        }
        CharSequence stringBuilder2 = new StringBuilder(charSequence);
        String str = "NonMatch";
        if (phoneMetadata != null) {
            str = phoneMetadata.xF();
        }
        CountryCodeSource a = a((StringBuilder) stringBuilder2, str);
        if (z) {
            phoneNumber.a(a);
        }
        int xE;
        if (a == CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (phoneMetadata != null) {
                xE = phoneMetadata.xE();
                String valueOf = String.valueOf(xE);
                String stringBuilder3 = stringBuilder2.toString();
                if (stringBuilder3.startsWith(valueOf)) {
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder3.substring(valueOf.length()));
                    PhoneNumberDesc xt = phoneMetadata.xt();
                    a(stringBuilder4, phoneMetadata, null);
                    if ((!this.aaO.a(stringBuilder2, xt, false) && this.aaO.a(stringBuilder4, xt, false)) || a(stringBuilder2, phoneMetadata) == ValidationResult.TOO_LONG) {
                        stringBuilder.append(stringBuilder4);
                        if (z) {
                            phoneNumber.a(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.bK(xE);
                        return xE;
                    }
                }
            }
            phoneNumber.bK(0);
            return 0;
        } else if (stringBuilder2.length() <= 2) {
            throw new NumberParseException(ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        } else {
            xE = a((StringBuilder) stringBuilder2, stringBuilder);
            if (xE != 0) {
                phoneNumber.bK(xE);
                return xE;
            }
            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
    }

    private boolean a(Pattern pattern, StringBuilder stringBuilder) {
        Matcher matcher = pattern.matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = aay.matcher(stringBuilder.substring(end));
        if (matcher2.find() && f(matcher2.group(1)).equals("0")) {
            return false;
        }
        stringBuilder.delete(0, end);
        return true;
    }

    CountryCodeSource a(StringBuilder stringBuilder, String str) {
        if (stringBuilder.length() == 0) {
            return CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = aaw.matcher(stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            k(stringBuilder);
            return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern dH = this.aad.dH(str);
        k(stringBuilder);
        return a(dH, stringBuilder) ? CountryCodeSource.FROM_NUMBER_WITH_IDD : CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean a(StringBuilder stringBuilder, PhoneMetadata phoneMetadata, StringBuilder stringBuilder2) {
        int length = stringBuilder.length();
        String xK = phoneMetadata.xK();
        if (length == 0 || xK.length() == 0) {
            return false;
        }
        Matcher matcher = this.aad.dH(xK).matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        PhoneNumberDesc xt = phoneMetadata.xt();
        boolean a = this.aaO.a(stringBuilder, xt, false);
        int groupCount = matcher.groupCount();
        String xL = phoneMetadata.xL();
        if (xL != null && xL.length() != 0 && matcher.group(groupCount) != null) {
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder);
            stringBuilder3.replace(0, length, matcher.replaceFirst(xL));
            if (a && !this.aaO.a(stringBuilder3.toString(), xt, false)) {
                return false;
            }
            if (stringBuilder2 != null && groupCount > 1) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
            return true;
        } else if (a && !this.aaO.a(stringBuilder.substring(matcher.end()), xt, false)) {
            return false;
        } else {
            if (!(stringBuilder2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.delete(0, matcher.end());
            return true;
        }
    }

    String l(StringBuilder stringBuilder) {
        Matcher matcher = aaG.matcher(stringBuilder);
        if (matcher.find() && e(stringBuilder.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    stringBuilder.delete(matcher.start(), stringBuilder.length());
                    return group;
                }
            }
        }
        return "";
    }

    private boolean a(CharSequence charSequence, String str) {
        return dm(str) || !(charSequence == null || charSequence.length() == 0 || !aaw.matcher(charSequence).lookingAt());
    }

    public PhoneNumber b(CharSequence charSequence, String str) {
        PhoneNumber phoneNumber = new PhoneNumber();
        a(charSequence, str, phoneNumber);
        return phoneNumber;
    }

    public void a(CharSequence charSequence, String str, PhoneNumber phoneNumber) {
        a(charSequence, str, false, true, phoneNumber);
    }

    static void a(CharSequence charSequence, PhoneNumber phoneNumber) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '0') {
            phoneNumber.an(true);
            int i = 1;
            while (i < charSequence.length() - 1 && charSequence.charAt(i) == '0') {
                i++;
            }
            if (i != 1) {
                phoneNumber.bL(i);
            }
        }
    }

    private void a(CharSequence charSequence, String str, boolean z, boolean z2, PhoneNumber phoneNumber) {
        int a;
        if (charSequence == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (charSequence.length() > Callback.DEFAULT_SWIPE_ANIMATION_DURATION) {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        } else {
            CharSequence stringBuilder = new StringBuilder();
            String charSequence2 = charSequence.toString();
            a(charSequence2, (StringBuilder) stringBuilder);
            if (!e(stringBuilder)) {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z2 || a(stringBuilder, str)) {
                if (z) {
                    phoneNumber.dF(charSequence2);
                }
                charSequence2 = l(stringBuilder);
                if (charSequence2.length() > 0) {
                    phoneNumber.dE(charSequence2);
                }
                PhoneMetadata de = de(str);
                CharSequence stringBuilder2 = new StringBuilder();
                try {
                    a = a(stringBuilder, de, (StringBuilder) stringBuilder2, z, phoneNumber);
                } catch (NumberParseException e) {
                    Matcher matcher = aaw.matcher(stringBuilder);
                    if (e.xn() == ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                        a = a(stringBuilder.substring(matcher.end()), de, (StringBuilder) stringBuilder2, z, phoneNumber);
                        if (a == 0) {
                            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    throw new NumberParseException(e.xn(), e.getMessage());
                }
                if (a != 0) {
                    String bG = bG(a);
                    if (!bG.equals(str)) {
                        de = e(a, bG);
                    }
                } else {
                    stringBuilder2.append(k(stringBuilder));
                    if (str != null) {
                        phoneNumber.bK(de.xE());
                    } else if (z) {
                        phoneNumber.yo();
                    }
                }
                if (stringBuilder2.length() < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                if (de != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    CharSequence stringBuilder4 = new StringBuilder(stringBuilder2);
                    a((StringBuilder) stringBuilder4, de, stringBuilder3);
                    ValidationResult a2 = a(stringBuilder4, de);
                    if (!(a2 == ValidationResult.TOO_SHORT || a2 == ValidationResult.IS_POSSIBLE_LOCAL_ONLY || a2 == ValidationResult.INVALID_LENGTH)) {
                        if (z && stringBuilder3.length() > 0) {
                            phoneNumber.dG(stringBuilder3.toString());
                        }
                        stringBuilder2 = stringBuilder4;
                    }
                }
                int length = stringBuilder2.length();
                if (length < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                } else if (length > 17) {
                    throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                } else {
                    a(stringBuilder2, phoneNumber);
                    phoneNumber.N(Long.parseLong(stringBuilder2.toString()));
                }
            } else {
                throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        }
    }

    private void a(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf >= 0) {
            int length = ";phone-context=".length() + indexOf;
            if (length < str.length() - 1 && str.charAt(length) == '+') {
                int indexOf2 = str.indexOf(59, length);
                if (indexOf2 > 0) {
                    stringBuilder.append(str.substring(length, indexOf2));
                } else {
                    stringBuilder.append(str.substring(length));
                }
            }
            length = str.indexOf("tel:");
            stringBuilder.append(str.substring(length >= 0 ? length + "tel:".length() : 0, indexOf));
        } else {
            stringBuilder.append(d(str));
        }
        int indexOf3 = stringBuilder.indexOf(";isub=");
        if (indexOf3 > 0) {
            stringBuilder.delete(indexOf3, stringBuilder.length());
        }
    }
}
