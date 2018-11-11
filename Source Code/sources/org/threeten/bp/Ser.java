package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        a(this.type, this.object, objectOutput);
    }

    static void a(byte b, Object obj, DataOutput dataOutput) {
        dataOutput.writeByte(b);
        if (b != (byte) 64) {
            switch (b) {
                case (byte) 1:
                    ((Duration) obj).writeExternal(dataOutput);
                    return;
                case (byte) 2:
                    ((Instant) obj).writeExternal(dataOutput);
                    return;
                case (byte) 3:
                    ((LocalDate) obj).writeExternal(dataOutput);
                    return;
                case (byte) 4:
                    ((LocalDateTime) obj).writeExternal(dataOutput);
                    return;
                case (byte) 5:
                    ((LocalTime) obj).writeExternal(dataOutput);
                    return;
                case (byte) 6:
                    ((ZonedDateTime) obj).writeExternal(dataOutput);
                    return;
                case (byte) 7:
                    ((ZoneRegion) obj).writeExternal(dataOutput);
                    return;
                case (byte) 8:
                    ((ZoneOffset) obj).writeExternal(dataOutput);
                    return;
                default:
                    switch (b) {
                        case (byte) 66:
                            ((OffsetTime) obj).writeExternal(dataOutput);
                            return;
                        case (byte) 67:
                            ((Year) obj).writeExternal(dataOutput);
                            return;
                        case (byte) 68:
                            ((YearMonth) obj).writeExternal(dataOutput);
                            return;
                        case (byte) 69:
                            ((OffsetDateTime) obj).writeExternal(dataOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        }
        ((MonthDay) obj).writeExternal(dataOutput);
    }

    public void readExternal(ObjectInput objectInput) {
        this.type = objectInput.readByte();
        this.object = a(this.type, objectInput);
    }

    static Object i(DataInput dataInput) {
        return a(dataInput.readByte(), dataInput);
    }

    private static Object a(byte b, DataInput dataInput) {
        if (b == (byte) 64) {
            return MonthDay.f(dataInput);
        }
        switch (b) {
            case (byte) 1:
                return Duration.a(dataInput);
            case (byte) 2:
                return Instant.b(dataInput);
            case (byte) 3:
                return LocalDate.c(dataInput);
            case (byte) 4:
                return LocalDateTime.d(dataInput);
            case (byte) 5:
                return LocalTime.e(dataInput);
            case (byte) 6:
                return ZonedDateTime.n(dataInput);
            case (byte) 7:
                return ZoneRegion.m(dataInput);
            case (byte) 8:
                return ZoneOffset.l(dataInput);
            default:
                switch (b) {
                    case (byte) 66:
                        return OffsetTime.h(dataInput);
                    case (byte) 67:
                        return Year.j(dataInput);
                    case (byte) 68:
                        return YearMonth.k(dataInput);
                    case (byte) 69:
                        return OffsetDateTime.g(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.object;
    }
}
