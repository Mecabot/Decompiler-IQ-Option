package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.a.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.e;

public final class JapaneseEra extends a implements Serializable {
    public static final JapaneseEra feY = new JapaneseEra(-1, LocalDate.F(1868, 9, 8), "Meiji");
    public static final JapaneseEra feZ = new JapaneseEra(0, LocalDate.F(1912, 7, 30), "Taisho");
    public static final JapaneseEra ffa = new JapaneseEra(1, LocalDate.F(1926, 12, 25), "Showa");
    public static final JapaneseEra ffb = new JapaneseEra(2, LocalDate.F(1989, 1, 8), "Heisei");
    private static final AtomicReference<JapaneseEra[]> ffc = new AtomicReference(new JapaneseEra[]{feY, feZ, ffa, ffb});
    private static final long serialVersionUID = 1466499369062886794L;
    private final int eraValue;
    private final transient LocalDate ffd;
    private final transient String name;

    private static int nh(int i) {
        return i + 1;
    }

    private JapaneseEra(int i, LocalDate localDate, String str) {
        this.eraValue = i;
        this.ffd = localDate;
        this.name = str;
    }

    private Object readResolve() {
        try {
            return ng(this.eraValue);
        } catch (Throwable e) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e);
            throw invalidObjectException;
        }
    }

    public static JapaneseEra ng(int i) {
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) ffc.get();
        if (i >= feY.eraValue && i <= japaneseEraArr[japaneseEraArr.length - 1].eraValue) {
            return japaneseEraArr[nh(i)];
        }
        throw new DateTimeException("japaneseEra is invalid");
    }

    public static JapaneseEra[] bCN() {
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) ffc.get();
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    static JapaneseEra e(LocalDate localDate) {
        if (localDate.c(feY.ffd)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Date too early: ");
            stringBuilder.append(localDate);
            throw new DateTimeException(stringBuilder.toString());
        }
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) ffc.get();
        for (int length = japaneseEraArr.length - 1; length >= 0; length--) {
            JapaneseEra japaneseEra = japaneseEraArr[length];
            if (localDate.compareTo(japaneseEra.ffd) >= 0) {
                return japaneseEra;
            }
        }
        return null;
    }

    LocalDate bCO() {
        return this.ffd;
    }

    LocalDate bCP() {
        int nh = nh(this.eraValue);
        JapaneseEra[] bCN = bCN();
        if (nh >= bCN.length - 1) {
            return LocalDate.fdH;
        }
        return bCN[nh + 1].bCO().dx(1);
    }

    public int getValue() {
        return this.eraValue;
    }

    public ValueRange range(e eVar) {
        if (eVar == ChronoField.ERA) {
            return JapaneseChronology.feS.a(ChronoField.ERA);
        }
        return super.range(eVar);
    }

    public String toString() {
        return this.name;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(getValue());
    }

    static JapaneseEra q(DataInput dataInput) {
        return ng(dataInput.readByte());
    }
}
