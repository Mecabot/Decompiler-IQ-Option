package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalTime;
import org.threeten.bp.a.d;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.h;

public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Long[] feA = new Long[334];
    private static final Integer[] feB = new Integer[feq.length];
    private static final Integer[] feC = new Integer[fer.length];
    private static final Integer[] feD = new Integer[fes.length];
    private static final Integer[] feE = new Integer[fem.length];
    private static final Integer[] feF = new Integer[fen.length];
    private static final Integer[] feG = new Integer[feo.length];
    private static final Integer[] feH = new Integer[fep.length];
    private static final Integer[] feI = new Integer[fet.length];
    private static final int[] fem = new int[]{0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    private static final int[] fen = new int[]{0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    private static final int[] feo = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    private static final int[] fep = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    private static final int[] feq = new int[]{0, 1, 0, 1, 0, 1, 1};
    private static final int[] fer = new int[]{1, 9999, 11, 51, 5, 29, 354};
    private static final int[] fes = new int[]{1, 9999, 11, 52, 6, 30, 355};
    private static final int[] fet = new int[]{0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    private static final char feu = File.separatorChar;
    private static final String fev = File.pathSeparator;
    private static final String few;
    private static final HashMap<Integer, Integer[]> fex = new HashMap();
    private static final HashMap<Integer, Integer[]> fey = new HashMap();
    private static final HashMap<Integer, Integer[]> fez = new HashMap();
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient HijrahEra feJ;
    private final transient int feK;
    private final transient int feL;
    private final transient int feM;
    private final transient int feN;
    private final transient DayOfWeek feO;
    private final transient boolean feP = isLeapYear((long) this.feK);
    private final long gregorianEpochDay;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x018e A:{RETURN, Splitter: B:36:0x018b, ExcHandler: java.io.IOException (unused java.io.IOException)} */
    /* JADX WARNING: Missing block: B:38:0x018e, code:
            return;
     */
    static {
        /*
        r0 = 12;
        r1 = new int[r0];
        r1 = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
        fem = r1;
        r1 = new int[r0];
        r1 = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
        fen = r1;
        r1 = new int[r0];
        r1 = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
        feo = r1;
        r0 = new int[r0];
        r0 = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
        fep = r0;
        r0 = 7;
        r1 = new int[r0];
        r1 = {0, 1, 0, 1, 0, 1, 1};
        feq = r1;
        r1 = new int[r0];
        r1 = {1, 9999, 11, 51, 5, 29, 354};
        fer = r1;
        r0 = new int[r0];
        r0 = {1, 9999, 11, 52, 6, 30, 355};
        fes = r0;
        r0 = 30;
        r0 = new int[r0];
        r0 = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
        fet = r0;
        r0 = java.io.File.separatorChar;
        feu = r0;
        r0 = java.io.File.pathSeparator;
        fev = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "org";
        r0.append(r1);
        r1 = feu;
        r0.append(r1);
        r1 = "threeten";
        r0.append(r1);
        r1 = feu;
        r0.append(r1);
        r1 = "bp";
        r0.append(r1);
        r1 = feu;
        r0.append(r1);
        r1 = "chrono";
        r0.append(r1);
        r0 = r0.toString();
        few = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        fex = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        fey = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        fez = r0;
        r0 = fem;
        r0 = r0.length;
        r0 = new java.lang.Integer[r0];
        feE = r0;
        r0 = 0;
        r1 = 0;
    L_0x0091:
        r2 = fem;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x00a6;
    L_0x0096:
        r2 = feE;
        r3 = new java.lang.Integer;
        r4 = fem;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x0091;
    L_0x00a6:
        r1 = fen;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feF = r1;
        r1 = 0;
    L_0x00ae:
        r2 = fen;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x00c3;
    L_0x00b3:
        r2 = feF;
        r3 = new java.lang.Integer;
        r4 = fen;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x00ae;
    L_0x00c3:
        r1 = feo;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feG = r1;
        r1 = 0;
    L_0x00cb:
        r2 = feo;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x00e0;
    L_0x00d0:
        r2 = feG;
        r3 = new java.lang.Integer;
        r4 = feo;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x00cb;
    L_0x00e0:
        r1 = fep;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feH = r1;
        r1 = 0;
    L_0x00e8:
        r2 = fep;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x00fd;
    L_0x00ed:
        r2 = feH;
        r3 = new java.lang.Integer;
        r4 = fep;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x00e8;
    L_0x00fd:
        r1 = fet;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feI = r1;
        r1 = 0;
    L_0x0105:
        r2 = fet;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x011a;
    L_0x010a:
        r2 = feI;
        r3 = new java.lang.Integer;
        r4 = fet;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x0105;
    L_0x011a:
        r1 = 334; // 0x14e float:4.68E-43 double:1.65E-321;
        r1 = new java.lang.Long[r1];
        feA = r1;
        r1 = 0;
    L_0x0121:
        r2 = feA;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x0135;
    L_0x0126:
        r2 = feA;
        r3 = new java.lang.Long;
        r4 = r1 * 10631;
        r4 = (long) r4;
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x0121;
    L_0x0135:
        r1 = feq;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feB = r1;
        r1 = 0;
    L_0x013d:
        r2 = feq;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x0152;
    L_0x0142:
        r2 = feB;
        r3 = new java.lang.Integer;
        r4 = feq;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x013d;
    L_0x0152:
        r1 = fer;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feC = r1;
        r1 = 0;
    L_0x015a:
        r2 = fer;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x016f;
    L_0x015f:
        r2 = feC;
        r3 = new java.lang.Integer;
        r4 = fer;
        r4 = r4[r1];
        r3.<init>(r4);
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x015a;
    L_0x016f:
        r1 = fes;
        r1 = r1.length;
        r1 = new java.lang.Integer[r1];
        feD = r1;
    L_0x0176:
        r1 = fes;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x018b;
    L_0x017b:
        r1 = feD;
        r2 = new java.lang.Integer;
        r3 = fes;
        r3 = r3[r0];
        r2.<init>(r3);
        r1[r0] = r2;
        r0 = r0 + 1;
        goto L_0x0176;
    L_0x018b:
        bCI();	 Catch:{ IOException -> 0x018e, IOException -> 0x018e }
    L_0x018e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.<clinit>():void");
    }

    public static HijrahDate L(int i, int i2, int i3) {
        return i >= 1 ? a(HijrahEra.AH, i, i2, i3) : a(HijrahEra.BEFORE_AH, 1 - i, i2, i3);
    }

    static HijrahDate a(HijrahEra hijrahEra, int i, int i2, int i3) {
        d.requireNonNull(hijrahEra, "era");
        mT(i);
        mV(i2);
        mW(i3);
        return new HijrahDate(N(hijrahEra.prolepticYear(i), i2, i3));
    }

    private static void mT(int i) {
        if (i < 1 || i > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
    }

    private static void mU(int i) {
        if (i < 1 || i > bCH()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
    }

    private static void mV(int i) {
        if (i < 1 || i > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
    }

    private static void mW(int i) {
        if (i < 1 || i > bCG()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid day of month of Hijrah date, day ");
            stringBuilder.append(i);
            stringBuilder.append(" greater than ");
            stringBuilder.append(bCG());
            stringBuilder.append(" or less than 1");
            throw new DateTimeException(stringBuilder.toString());
        }
    }

    static HijrahDate dU(long j) {
        return new HijrahDate(j);
    }

    private HijrahDate(long j) {
        int[] dY = dY(j);
        mT(dY[1]);
        mV(dY[2]);
        mW(dY[3]);
        mU(dY[4]);
        this.feJ = HijrahEra.of(dY[0]);
        this.feK = dY[1];
        this.feL = dY[2];
        this.feM = dY[3];
        this.feN = dY[4];
        this.feO = DayOfWeek.of(dY[5]);
        this.gregorianEpochDay = j;
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    /* renamed from: bCE */
    public HijrahChronology bCs() {
        return HijrahChronology.fei;
    }

    /* renamed from: bCF */
    public HijrahEra bCp() {
        return this.feJ;
    }

    public ValueRange range(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        if (isSupported(eVar)) {
            ChronoField chronoField = (ChronoField) eVar;
            switch (chronoField) {
                case DAY_OF_MONTH:
                    return ValueRange.G(1, (long) lengthOfMonth());
                case DAY_OF_YEAR:
                    return ValueRange.G(1, (long) lengthOfYear());
                case ALIGNED_WEEK_OF_MONTH:
                    return ValueRange.G(1, 5);
                case YEAR_OF_ERA:
                    return ValueRange.G(1, 1000);
                default:
                    return bCs().a(chronoField);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public long getLong(e eVar) {
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        switch ((ChronoField) eVar) {
            case DAY_OF_MONTH:
                return (long) this.feM;
            case DAY_OF_YEAR:
                return (long) this.feN;
            case ALIGNED_WEEK_OF_MONTH:
                return (long) (((this.feM - 1) / 7) + 1);
            case YEAR_OF_ERA:
                return (long) this.feK;
            case DAY_OF_WEEK:
                return (long) this.feO.getValue();
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return (long) (((this.feM - 1) % 7) + 1);
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return (long) (((this.feN - 1) % 7) + 1);
            case EPOCH_DAY:
                return toEpochDay();
            case ALIGNED_WEEK_OF_YEAR:
                return (long) (((this.feN - 1) / 7) + 1);
            case MONTH_OF_YEAR:
                return (long) this.feL;
            case YEAR:
                return (long) this.feK;
            case ERA:
                return (long) this.feJ.getValue();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    /* renamed from: o */
    public HijrahDate d(c cVar) {
        return (HijrahDate) super.b(cVar);
    }

    /* renamed from: o */
    public HijrahDate d(e eVar, long j) {
        if (!(eVar instanceof ChronoField)) {
            return (HijrahDate) eVar.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) eVar;
        chronoField.checkValidValue(j);
        int i = (int) j;
        switch (chronoField) {
            case DAY_OF_MONTH:
                return M(this.feK, this.feL, i);
            case DAY_OF_YEAR:
                i--;
                return M(this.feK, (i / 30) + 1, (i % 30) + 1);
            case ALIGNED_WEEK_OF_MONTH:
                return dO((j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
            case YEAR_OF_ERA:
                if (this.feK < 1) {
                    i = 1 - i;
                }
                return M(i, this.feL, this.feM);
            case DAY_OF_WEEK:
                return dO(j - ((long) this.feO.getValue()));
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return dO(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return dO(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case EPOCH_DAY:
                return new HijrahDate((long) i);
            case ALIGNED_WEEK_OF_YEAR:
                return dO((j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
            case MONTH_OF_YEAR:
                return M(this.feK, i, this.feM);
            case YEAR:
                return M(i, this.feL, this.feM);
            case ERA:
                return M(1 - this.feK, this.feL, this.feM);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(eVar);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private static HijrahDate M(int i, int i2, int i3) {
        int bs = bs(i2 - 1, i);
        if (i3 > bs) {
            i3 = bs;
        }
        return L(i, i2, i3);
    }

    /* renamed from: C */
    public HijrahDate h(long j, h hVar) {
        return (HijrahDate) super.h(j, hVar);
    }

    /* renamed from: D */
    public HijrahDate g(long j, h hVar) {
        return (HijrahDate) super.c(j, hVar);
    }

    public final b<HijrahDate> b(LocalTime localTime) {
        return super.b(localTime);
    }

    public long toEpochDay() {
        return N(this.feK, this.feL, this.feM);
    }

    public boolean isLeapYear() {
        return this.feP;
    }

    /* renamed from: dV */
    HijrahDate dM(long j) {
        if (j == 0) {
            return this;
        }
        return a(this.feJ, d.bv(this.feK, (int) j), this.feL, this.feM);
    }

    /* renamed from: dW */
    HijrahDate dN(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.feL - 1) + ((int) j);
        int i2 = i / 12;
        i %= 12;
        while (i < 0) {
            i += 12;
            i2 = d.bw(i2, 1);
        }
        return a(this.feJ, d.bv(this.feK, i2), i + 1, this.feM);
    }

    /* renamed from: dX */
    HijrahDate dO(long j) {
        return new HijrahDate(this.gregorianEpochDay + j);
    }

    private static int[] dY(long j) {
        int dZ;
        int i;
        int z;
        int P;
        int value;
        long j2 = j - -492148;
        if (j2 >= 0) {
            dZ = dZ(j2);
            i = i(j2, dZ);
            z = z(dZ, (long) i);
            i = O(dZ, i, z);
            dZ = ((dZ * 30) + z) + 1;
            z = br(i, dZ);
            P = P(i, z, dZ) + 1;
            value = HijrahEra.AH.getValue();
        } else {
            dZ = (int) j2;
            i = dZ / 10631;
            dZ %= 10631;
            if (dZ == 0) {
                dZ = -10631;
                i++;
            }
            z = z(i, (long) dZ);
            dZ = O(i, dZ, z);
            i = 1 - ((i * 30) - z);
            dZ = isLeapYear((long) i) ? dZ + 355 : dZ + 354;
            z = br(dZ, i);
            P = P(dZ, z, i) + 1;
            value = HijrahEra.BEFORE_AH.getValue();
            int i2 = i;
            i = dZ;
            dZ = i2;
        }
        int i3 = (int) ((j2 + 5) % 7);
        i3 += i3 <= 0 ? 7 : 0;
        return new int[]{value, dZ, z + 1, P, i + 1, i3};
    }

    private static long N(int i, int i2, int i3) {
        return (mX(i) + ((long) bs(i2 - 1, i))) + ((long) i3);
    }

    private static long mX(int i) {
        Long l;
        i--;
        int i2 = i / 30;
        i %= 30;
        int intValue = mY(i2)[Math.abs(i)].intValue();
        if (i < 0) {
            intValue = -intValue;
        }
        try {
            l = feA[i2];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l = null;
        }
        if (l == null) {
            l = new Long((long) (i2 * 10631));
        }
        return ((l.longValue() + ((long) intValue)) - 492148) - 1;
    }

    private static int dZ(long j) {
        int i;
        Long[] lArr = feA;
        int i2 = 0;
        while (i2 < lArr.length) {
            try {
                if (j < lArr[i2].longValue()) {
                    return i2 - 1;
                }
                i2++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                i = ((int) j) / 10631;
            }
        }
        i = ((int) j) / 10631;
        return i;
    }

    private static int i(long j, int i) {
        Long l;
        try {
            l = feA[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l = null;
        }
        if (l == null) {
            l = new Long((long) (i * 10631));
        }
        return (int) (j - l.longValue());
    }

    private static int z(int i, long j) {
        Integer[] mY = mY(i);
        int i2 = 0;
        if (j == 0) {
            return 0;
        }
        if (j > 0) {
            while (i2 < mY.length) {
                if (j < ((long) mY[i2].intValue())) {
                    return i2 - 1;
                }
                i2++;
            }
            return 29;
        }
        j = -j;
        while (i2 < mY.length) {
            if (j <= ((long) mY[i2].intValue())) {
                return i2 - 1;
            }
            i2++;
        }
        return 29;
    }

    private static Integer[] mY(int i) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) fez.get(new Integer(i));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? feI : numArr;
    }

    private static Integer[] mZ(int i) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) fex.get(new Integer(i));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i)) {
            return feF;
        }
        return feE;
    }

    private static Integer[] na(int i) {
        Integer[] numArr;
        try {
            numArr = (Integer[]) fey.get(new Integer(i));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i)) {
            return feH;
        }
        return feG;
    }

    private static int O(int i, int i2, int i3) {
        Integer[] mY = mY(i);
        if (i2 > 0) {
            return i2 - mY[i3].intValue();
        }
        return mY[i3].intValue() + i2;
    }

    private static int br(int i, int i2) {
        Integer[] mZ = mZ(i2);
        int i3 = 0;
        if (i >= 0) {
            while (i3 < mZ.length) {
                if (i < mZ[i3].intValue()) {
                    return i3 - 1;
                }
                i3++;
            }
            return 11;
        }
        i = isLeapYear((long) i2) ? i + 355 : i + 354;
        while (i3 < mZ.length) {
            if (i < mZ[i3].intValue()) {
                return i3 - 1;
            }
            i3++;
        }
        return 11;
    }

    private static int P(int i, int i2, int i3) {
        Integer[] mZ = mZ(i3);
        if (i >= 0) {
            return i2 > 0 ? i - mZ[i2].intValue() : i;
        } else {
            i = isLeapYear((long) i3) ? i + 355 : i + 354;
            return i2 > 0 ? i - mZ[i2].intValue() : i;
        }
    }

    static boolean isLeapYear(long j) {
        if (j <= 0) {
            j = -j;
        }
        return ((j * 11) + 14) % 30 < 11;
    }

    private static int bs(int i, int i2) {
        return mZ(i2)[i].intValue();
    }

    static int bt(int i, int i2) {
        return na(i2)[i].intValue();
    }

    public int lengthOfMonth() {
        return bt(this.feL - 1, this.feK);
    }

    static int nb(int i) {
        Integer[] numArr;
        int i2 = i - 1;
        int i3 = i2 / 30;
        try {
            numArr = (Integer[]) fez.get(Integer.valueOf(i3));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            i2 %= 30;
            if (i2 == 29) {
                return (feA[i3 + 1].intValue() - feA[i3].intValue()) - numArr[i2].intValue();
            }
            return numArr[i2 + 1].intValue() - numArr[i2].intValue();
        }
        return isLeapYear((long) i) ? 355 : 354;
    }

    public int lengthOfYear() {
        return nb(this.feK);
    }

    static int bCG() {
        return feD[5].intValue();
    }

    static int bCH() {
        return feD[6].intValue();
    }

    private static void f(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (i6 < 1) {
            throw new IllegalArgumentException("startYear < 1");
        } else if (i8 < 1) {
            throw new IllegalArgumentException("endYear < 1");
        } else if (i7 < 0 || i7 > 11) {
            throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
        } else if (i9 < 0 || i9 > 11) {
            throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
        } else if (i8 > 9999) {
            throw new IllegalArgumentException("endYear > 9999");
        } else if (i8 < i6) {
            throw new IllegalArgumentException("startYear > endYear");
        } else if (i8 != i6 || i9 >= i7) {
            int i11;
            int i12;
            int i13;
            int i14;
            Integer[] numArr;
            int i15;
            boolean isLeapYear = isLeapYear((long) i6);
            Integer[] numArr2 = (Integer[]) fex.get(new Integer(i6));
            if (numArr2 == null) {
                if (isLeapYear) {
                    numArr2 = new Integer[fen.length];
                    for (i11 = 0; i11 < fen.length; i11++) {
                        numArr2[i11] = new Integer(fen[i11]);
                    }
                } else {
                    numArr2 = new Integer[fem.length];
                    for (i11 = 0; i11 < fem.length; i11++) {
                        numArr2[i11] = new Integer(fem[i11]);
                    }
                }
            }
            Object obj = new Integer[numArr2.length];
            for (i12 = 0; i12 < 12; i12++) {
                if (i12 > i7) {
                    obj[i12] = new Integer(numArr2[i12].intValue() - i10);
                } else {
                    obj[i12] = new Integer(numArr2[i12].intValue());
                }
            }
            fex.put(new Integer(i6), obj);
            numArr2 = (Integer[]) fey.get(new Integer(i6));
            if (numArr2 == null) {
                if (isLeapYear) {
                    numArr2 = new Integer[fep.length];
                    for (i13 = 0; i13 < fep.length; i13++) {
                        numArr2[i13] = new Integer(fep[i13]);
                    }
                } else {
                    numArr2 = new Integer[feo.length];
                    for (i13 = 0; i13 < feo.length; i13++) {
                        numArr2[i13] = new Integer(feo[i13]);
                    }
                }
            }
            Object obj2 = new Integer[numArr2.length];
            for (i11 = 0; i11 < 12; i11++) {
                if (i11 == i7) {
                    obj2[i11] = new Integer(numArr2[i11].intValue() - i10);
                } else {
                    obj2[i11] = new Integer(numArr2[i11].intValue());
                }
            }
            fey.put(new Integer(i6), obj2);
            if (i6 != i8) {
                int i16;
                i13 = i6 - 1;
                int i17 = i13 / 30;
                i13 %= 30;
                Integer[] numArr3 = (Integer[]) fez.get(new Integer(i17));
                if (numArr3 == null) {
                    numArr3 = new Integer[fet.length];
                    for (i12 = 0; i12 < numArr3.length; i12++) {
                        numArr3[i12] = new Integer(fet[i12]);
                    }
                }
                for (i13++; i13 < fet.length; i13++) {
                    numArr3[i13] = new Integer(numArr3[i13].intValue() - i10);
                }
                fez.put(new Integer(i17), numArr3);
                i13 = i8 - 1;
                i11 = i13 / 30;
                if (i17 != i11) {
                    i17++;
                    while (i17 < feA.length) {
                        i16 = i11;
                        feA[i17] = new Long(feA[i17].longValue() - ((long) i10));
                        i17++;
                        i11 = i16;
                    }
                    i16 = i11;
                    i11 = i16 + 1;
                    while (i11 < feA.length) {
                        feA[i11] = new Long(feA[i11].longValue() + ((long) i10));
                        i11++;
                        i6 = i;
                        i7 = i2;
                    }
                } else {
                    i16 = i11;
                }
                i13 %= 30;
                i14 = i16;
                numArr = (Integer[]) fez.get(new Integer(i14));
                if (numArr == null) {
                    numArr = new Integer[fet.length];
                    for (i7 = 0; i7 < numArr.length; i7++) {
                        numArr[i7] = new Integer(fet[i7]);
                    }
                }
                for (i13++; i13 < fet.length; i13++) {
                    numArr[i13] = new Integer(numArr[i13].intValue() + i10);
                }
                fez.put(new Integer(i14), numArr);
            }
            boolean isLeapYear2 = isLeapYear((long) i8);
            Integer[] numArr4 = (Integer[]) fex.get(new Integer(i8));
            if (numArr4 == null) {
                if (isLeapYear2) {
                    numArr4 = new Integer[fen.length];
                    for (i14 = 0; i14 < fen.length; i14++) {
                        numArr4[i14] = new Integer(fen[i14]);
                    }
                } else {
                    numArr4 = new Integer[fem.length];
                    for (i14 = 0; i14 < fem.length; i14++) {
                        numArr4[i14] = new Integer(fem[i14]);
                    }
                }
            }
            Object obj3 = new Integer[numArr4.length];
            for (i15 = 0; i15 < 12; i15++) {
                if (i15 > i9) {
                    obj3[i15] = new Integer(numArr4[i15].intValue() + i10);
                } else {
                    obj3[i15] = new Integer(numArr4[i15].intValue());
                }
            }
            fex.put(new Integer(i8), obj3);
            numArr4 = (Integer[]) fey.get(new Integer(i8));
            if (numArr4 == null) {
                if (isLeapYear2) {
                    numArr4 = new Integer[fep.length];
                    for (i6 = 0; i6 < fep.length; i6++) {
                        numArr4[i6] = new Integer(fep[i6]);
                    }
                } else {
                    numArr4 = new Integer[feo.length];
                    for (i6 = 0; i6 < feo.length; i6++) {
                        numArr4[i6] = new Integer(feo[i6]);
                    }
                }
            }
            Object obj4 = new Integer[numArr4.length];
            for (i14 = 0; i14 < 12; i14++) {
                if (i14 == i9) {
                    obj4[i14] = new Integer(numArr4[i14].intValue() + i10);
                } else {
                    obj4[i14] = new Integer(numArr4[i14].intValue());
                }
            }
            fey.put(new Integer(i8), obj4);
            i10 = i;
            numArr = (Integer[]) fey.get(new Integer(i10));
            numArr4 = (Integer[]) fey.get(new Integer(i8));
            Integer[] numArr5 = (Integer[]) fex.get(new Integer(i10));
            Integer[] numArr6 = (Integer[]) fex.get(new Integer(i8));
            i14 = numArr[i2].intValue();
            i9 = numArr4[i9].intValue();
            i10 = numArr5[11].intValue() + numArr[11].intValue();
            i6 = numArr6[11].intValue() + numArr4[11].intValue();
            i7 = feD[5].intValue();
            i15 = feC[5].intValue();
            if (i7 < i14) {
                i7 = i14;
            }
            if (i7 < i9) {
                i7 = i9;
            }
            feD[5] = new Integer(i7);
            if (i15 <= i14) {
                i14 = i15;
            }
            if (i14 <= i9) {
                i9 = i14;
            }
            feC[5] = new Integer(i9);
            i7 = feD[6].intValue();
            i9 = feC[6].intValue();
            if (i7 < i10) {
                i7 = i10;
            }
            if (i7 < i6) {
                i7 = i6;
            }
            feD[6] = new Integer(i7);
            if (i9 > i10) {
                i9 = i10;
            }
            if (i9 <= i6) {
                i6 = i9;
            }
            feC[6] = new Integer(i6);
        } else {
            throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    private static void bCI() {
        /*
        r0 = bCJ();
        if (r0 == 0) goto L_0x0032;
    L_0x0006:
        r1 = 0;
        r2 = new java.io.BufferedReader;	 Catch:{ all -> 0x002b }
        r3 = new java.io.InputStreamReader;	 Catch:{ all -> 0x002b }
        r3.<init>(r0);	 Catch:{ all -> 0x002b }
        r2.<init>(r3);	 Catch:{ all -> 0x002b }
        r0 = 0;
    L_0x0012:
        r1 = r2.readLine();	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0022;
    L_0x0018:
        r0 = r0 + 1;
        r1 = r1.trim();	 Catch:{ all -> 0x0028 }
        ag(r1, r0);	 Catch:{ all -> 0x0028 }
        goto L_0x0012;
    L_0x0022:
        if (r2 == 0) goto L_0x0032;
    L_0x0024:
        r2.close();
        goto L_0x0032;
    L_0x0028:
        r0 = move-exception;
        r1 = r2;
        goto L_0x002c;
    L_0x002b:
        r0 = move-exception;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();
    L_0x0031:
        throw r0;
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.HijrahDate.bCI():void");
    }

    private static void ag(String str, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            str = stringTokenizer.nextToken();
            int indexOf = str.indexOf(58);
            StringBuilder stringBuilder;
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, str.length()));
                    int indexOf2 = str.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = str.substring(0, indexOf2);
                        str = str.substring(indexOf2 + 1, indexOf);
                        indexOf2 = substring.indexOf(47);
                        indexOf = str.indexOf(47);
                        if (indexOf2 != -1) {
                            String substring2 = substring.substring(0, indexOf2);
                            String substring3 = substring.substring(indexOf2 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring2);
                                try {
                                    indexOf2 = Integer.parseInt(substring3);
                                    if (indexOf != -1) {
                                        String substring4 = str.substring(0, indexOf);
                                        str = str.substring(indexOf + 1, str.length());
                                        try {
                                            indexOf = Integer.parseInt(substring4);
                                            try {
                                                int parseInt3 = Integer.parseInt(str);
                                                if (parseInt2 == -1 || indexOf2 == -1 || indexOf == -1 || parseInt3 == -1) {
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Unknown error at line ");
                                                    stringBuilder.append(i);
                                                    stringBuilder.append(".");
                                                    throw new ParseException(stringBuilder.toString(), i);
                                                }
                                                f(parseInt2, indexOf2, indexOf, parseInt3, parseInt);
                                            } catch (NumberFormatException unused) {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append("End month is not properly set at line ");
                                                stringBuilder.append(i);
                                                stringBuilder.append(".");
                                                throw new ParseException(stringBuilder.toString(), i);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("End year is not properly set at line ");
                                            stringBuilder.append(i);
                                            stringBuilder.append(".");
                                            throw new ParseException(stringBuilder.toString(), i);
                                        }
                                    }
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("End year/month has incorrect format at line ");
                                    stringBuilder.append(i);
                                    stringBuilder.append(".");
                                    throw new ParseException(stringBuilder.toString(), i);
                                } catch (NumberFormatException unused3) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Start month is not properly set at line ");
                                    stringBuilder.append(i);
                                    stringBuilder.append(".");
                                    throw new ParseException(stringBuilder.toString(), i);
                                }
                            } catch (NumberFormatException unused4) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Start year is not properly set at line ");
                                stringBuilder.append(i);
                                stringBuilder.append(".");
                                throw new ParseException(stringBuilder.toString(), i);
                            }
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Start year/month has incorrect format at line ");
                        stringBuilder.append(i);
                        stringBuilder.append(".");
                        throw new ParseException(stringBuilder.toString(), i);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Start and end year/month has incorrect format at line ");
                    stringBuilder.append(i);
                    stringBuilder.append(".");
                    throw new ParseException(stringBuilder.toString(), i);
                } catch (NumberFormatException unused5) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Offset is not properly set at line ");
                    stringBuilder.append(i);
                    stringBuilder.append(".");
                    throw new ParseException(stringBuilder.toString(), i);
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Offset has incorrect format at line ");
            stringBuilder.append(i);
            stringBuilder.append(".");
            throw new ParseException(stringBuilder.toString(), i);
        }
    }

    private static InputStream bCJ() {
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = "hijrah_deviation.cfg";
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (property2 != null) {
            if (!(property2.length() == 0 && property2.endsWith(System.getProperty("file.separator")))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(property2);
                stringBuilder.append(System.getProperty("file.separator"));
                property2 = stringBuilder.toString();
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(property2);
            stringBuilder2.append(feu);
            stringBuilder2.append(property);
            File file = new File(stringBuilder2.toString());
            if (!file.exists()) {
                return null;
            }
            try {
                return new FileInputStream(file);
            } catch (IOException e) {
                throw e;
            }
        }
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), fev);
        while (stringTokenizer.hasMoreTokens()) {
            property2 = stringTokenizer.nextToken();
            File file2 = new File(property2);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(property2);
                    stringBuilder3.append(feu);
                    stringBuilder3.append(few);
                    if (new File(stringBuilder3.toString(), property).exists()) {
                        try {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(property2);
                            stringBuilder.append(feu);
                            stringBuilder.append(few);
                            stringBuilder.append(feu);
                            stringBuilder.append(property);
                            return new FileInputStream(stringBuilder.toString());
                        } catch (IOException e2) {
                            throw e2;
                        }
                    }
                } else {
                    ZipFile zipFile;
                    try {
                        zipFile = new ZipFile(file2);
                    } catch (IOException unused) {
                        zipFile = null;
                    }
                    if (zipFile != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(few);
                        stringBuilder2.append(feu);
                        stringBuilder2.append(property);
                        String stringBuilder4 = stringBuilder2.toString();
                        ZipEntry entry = zipFile.getEntry(stringBuilder4);
                        if (entry == null) {
                            if (feu == '/') {
                                stringBuilder4 = stringBuilder4.replace('/', '\\');
                            } else if (feu == '\\') {
                                stringBuilder4 = stringBuilder4.replace('\\', '/');
                            }
                            entry = zipFile.getEntry(stringBuilder4);
                        }
                        if (entry != null) {
                            try {
                                return zipFile.getInputStream(entry);
                            } catch (IOException e22) {
                                throw e22;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static a p(DataInput dataInput) {
        return HijrahChronology.fei.K(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
