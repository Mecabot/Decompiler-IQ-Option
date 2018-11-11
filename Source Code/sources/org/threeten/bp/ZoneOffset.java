package org.threeten.bp;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.b;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.e;
import org.threeten.bp.temporal.f;
import org.threeten.bp.temporal.g;
import org.threeten.bp.zone.ZoneRules;

public final class ZoneOffset extends ZoneId implements Serializable, Comparable<ZoneOffset>, b, c {
    public static final g<ZoneOffset> FROM = new g<ZoneOffset>() {
        /* renamed from: y */
        public ZoneOffset b(b bVar) {
            return ZoneOffset.x(bVar);
        }
    };
    private static final ConcurrentMap<Integer, ZoneOffset> fdX = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> fdY = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset fdZ = mP(0);
    public static final ZoneOffset fea = mP(-64800);
    public static final ZoneOffset feb = mP(64800);
    private static final long serialVersionUID = 2357656521762053153L;
    private final transient String id;
    private final int totalSeconds;

    private static int J(int i, int i2, int i3) {
        return ((i * ChartTimeInterval.CANDLE_1H) + (i2 * 60)) + i3;
    }

    /* JADX WARNING: Missing block: B:12:0x007c, code:
            r0 = a(r6, 1, false);
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:13:0x0081, code:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0082, code:
            r3 = r6.charAt(0);
     */
    /* JADX WARNING: Missing block: B:15:0x008a, code:
            if (r3 == '+') goto L_0x00a5;
     */
    /* JADX WARNING: Missing block: B:16:0x008c, code:
            if (r3 == '-') goto L_0x00a5;
     */
    /* JADX WARNING: Missing block: B:17:0x008e, code:
            r1 = new java.lang.StringBuilder();
            r1.append("Invalid ID for ZoneOffset, plus/minus not found when expected: ");
            r1.append(r6);
     */
    /* JADX WARNING: Missing block: B:18:0x00a4, code:
            throw new org.threeten.bp.DateTimeException(r1.toString());
     */
    /* JADX WARNING: Missing block: B:19:0x00a5, code:
            if (r3 != '-') goto L_0x00af;
     */
    /* JADX WARNING: Missing block: B:21:0x00ae, code:
            return H(-r0, -r1, -r2);
     */
    /* JADX WARNING: Missing block: B:23:0x00b3, code:
            return H(r0, r1, r2);
     */
    public static org.threeten.bp.ZoneOffset nM(java.lang.String r6) {
        /*
        r0 = "offsetId";
        org.threeten.bp.a.d.requireNonNull(r6, r0);
        r0 = fdY;
        r0 = r0.get(r6);
        r0 = (org.threeten.bp.ZoneOffset) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r6.length();
        r1 = 3;
        r2 = 4;
        r3 = 1;
        r4 = 0;
        switch(r0) {
            case 2: goto L_0x0060;
            case 3: goto L_0x007c;
            case 4: goto L_0x001b;
            case 5: goto L_0x0057;
            case 6: goto L_0x004e;
            case 7: goto L_0x0040;
            case 8: goto L_0x001b;
            case 9: goto L_0x0032;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid ID for ZoneOffset, invalid format: ";
        r1.append(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0032:
        r0 = a(r6, r3, r4);
        r1 = a(r6, r2, r3);
        r2 = 7;
        r2 = a(r6, r2, r3);
        goto L_0x0082;
    L_0x0040:
        r0 = a(r6, r3, r4);
        r1 = a(r6, r1, r4);
        r2 = 5;
        r2 = a(r6, r2, r4);
        goto L_0x0082;
    L_0x004e:
        r0 = a(r6, r3, r4);
        r1 = a(r6, r2, r3);
        goto L_0x0081;
    L_0x0057:
        r0 = a(r6, r3, r4);
        r1 = a(r6, r1, r4);
        goto L_0x0081;
    L_0x0060:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.charAt(r4);
        r0.append(r1);
        r1 = "0";
        r0.append(r1);
        r6 = r6.charAt(r3);
        r0.append(r6);
        r6 = r0.toString();
    L_0x007c:
        r0 = a(r6, r3, r4);
        r1 = 0;
    L_0x0081:
        r2 = 0;
    L_0x0082:
        r3 = r6.charAt(r4);
        r4 = 43;
        r5 = 45;
        if (r3 == r4) goto L_0x00a5;
    L_0x008c:
        if (r3 == r5) goto L_0x00a5;
    L_0x008e:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: ";
        r1.append(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x00a5:
        if (r3 != r5) goto L_0x00af;
    L_0x00a7:
        r6 = -r0;
        r0 = -r1;
        r1 = -r2;
        r6 = H(r6, r0, r1);
        return r6;
    L_0x00af:
        r6 = H(r0, r1, r2);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.nM(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    private static int a(CharSequence charSequence, int i, boolean z) {
        StringBuilder stringBuilder;
        if (!z || charSequence.charAt(i - 1) == ':') {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                return ((charAt - 48) * 10) + (charAt2 - 48);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for ZoneOffset, non numeric characters found: ");
            stringBuilder.append(charSequence);
            throw new DateTimeException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid ID for ZoneOffset, colon not found when expected: ");
        stringBuilder.append(charSequence);
        throw new DateTimeException(stringBuilder.toString());
    }

    public static ZoneOffset H(int i, int i2, int i3) {
        I(i, i2, i3);
        return mP(J(i, i2, i3));
    }

    public static ZoneOffset x(b bVar) {
        ZoneOffset zoneOffset = (ZoneOffset) bVar.query(f.bDu());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain ZoneOffset from TemporalAccessor: ");
        stringBuilder.append(bVar);
        stringBuilder.append(", type ");
        stringBuilder.append(bVar.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    private static void I(int i, int i2, int i3) {
        StringBuilder stringBuilder;
        if (i < -18 || i > 18) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Zone offset hours not in valid range: value ");
            stringBuilder.append(i);
            stringBuilder.append(" is not in the range -18 to 18");
            throw new DateTimeException(stringBuilder.toString());
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i2) > 59) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Zone offset minutes not in valid range: abs(value) ");
            stringBuilder.append(Math.abs(i2));
            stringBuilder.append(" is not in the range 0 to 59");
            throw new DateTimeException(stringBuilder.toString());
        } else if (Math.abs(i3) > 59) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Zone offset seconds not in valid range: abs(value) ");
            stringBuilder2.append(Math.abs(i3));
            stringBuilder2.append(" is not in the range 0 to 59");
            throw new DateTimeException(stringBuilder2.toString());
        } else if (Math.abs(i) != 18) {
        } else {
            if (Math.abs(i2) > 0 || Math.abs(i3) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    public static ZoneOffset mP(int i) {
        if (Math.abs(i) > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % ChartTimeInterval.CANDLE_15m != 0) {
            return new ZoneOffset(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            ZoneOffset zoneOffset = (ZoneOffset) fdX.get(valueOf);
            if (zoneOffset == null) {
                fdX.putIfAbsent(valueOf, new ZoneOffset(i));
                zoneOffset = (ZoneOffset) fdX.get(valueOf);
                fdY.putIfAbsent(zoneOffset.getId(), zoneOffset);
            }
            return zoneOffset;
        }
    }

    private ZoneOffset(int i) {
        this.totalSeconds = i;
        this.id = mQ(i);
    }

    private static String mQ(int i) {
        if (i == 0) {
            return "Z";
        }
        int abs = Math.abs(i);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = abs / ChartTimeInterval.CANDLE_1H;
        int i3 = (abs / 60) % 60;
        stringBuilder.append(i < 0 ? "-" : "+");
        stringBuilder.append(i2 < 10 ? "0" : "");
        stringBuilder.append(i2);
        stringBuilder.append(i3 < 10 ? ":0" : ":");
        stringBuilder.append(i3);
        abs %= 60;
        if (abs != 0) {
            stringBuilder.append(abs < 10 ? ":0" : ":");
            stringBuilder.append(abs);
        }
        return stringBuilder.toString();
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    public String getId() {
        return this.id;
    }

    public ZoneRules bCz() {
        return ZoneRules.h(this);
    }

    public boolean isSupported(e eVar) {
        boolean z = false;
        if (eVar instanceof ChronoField) {
            if (eVar == ChronoField.OFFSET_SECONDS) {
                z = true;
            }
            return z;
        }
        if (eVar != null && eVar.isSupportedBy(this)) {
            z = true;
        }
        return z;
    }

    public ValueRange range(e eVar) {
        if (eVar == ChronoField.OFFSET_SECONDS) {
            return eVar.range();
        }
        if (!(eVar instanceof ChronoField)) {
            return eVar.rangeRefinedBy(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public int get(e eVar) {
        if (eVar == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(eVar instanceof ChronoField)) {
            return range(eVar).b(getLong(eVar), eVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public long getLong(e eVar) {
        if (eVar == ChronoField.OFFSET_SECONDS) {
            return (long) this.totalSeconds;
        }
        if (!(eVar instanceof ChronoField)) {
            return eVar.getFrom(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(eVar);
        throw new DateTimeException(stringBuilder.toString());
    }

    public <R> R query(g<R> gVar) {
        if (gVar == f.bDu() || gVar == f.bDt()) {
            return this;
        }
        return (gVar == f.bDv() || gVar == f.bDw() || gVar == f.bDs() || gVar == f.bDr() || gVar == f.bDq()) ? null : gVar.b(this);
    }

    public a adjustInto(a aVar) {
        return aVar.b(ChronoField.OFFSET_SECONDS, (long) this.totalSeconds);
    }

    /* renamed from: d */
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneOffset)) {
            return false;
        }
        if (this.totalSeconds != ((ZoneOffset) obj).totalSeconds) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.totalSeconds;
    }

    public String toString() {
        return this.id;
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void write(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    void writeExternal(DataOutput dataOutput) {
        int i = this.totalSeconds;
        int i2 = i % ChartTimeInterval.CANDLE_15m == 0 ? i / ChartTimeInterval.CANDLE_15m : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    static ZoneOffset l(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? mP(dataInput.readInt()) : mP(readByte * ChartTimeInterval.CANDLE_15m);
    }
}
