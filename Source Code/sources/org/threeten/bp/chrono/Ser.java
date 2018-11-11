package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    private static final long serialVersionUID = 7857518227608961174L;
    private Object object;
    private byte type;

    Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        a(this.type, this.object, objectOutput);
    }

    private static void a(byte b, Object obj, ObjectOutput objectOutput) {
        objectOutput.writeByte(b);
        switch (b) {
            case (byte) 1:
                ((JapaneseDate) obj).writeExternal(objectOutput);
                return;
            case (byte) 2:
                ((JapaneseEra) obj).writeExternal(objectOutput);
                return;
            case (byte) 3:
                ((HijrahDate) obj).writeExternal(objectOutput);
                return;
            case (byte) 4:
                ((HijrahEra) obj).writeExternal(objectOutput);
                return;
            case (byte) 5:
                ((MinguoDate) obj).writeExternal(objectOutput);
                return;
            case (byte) 6:
                ((MinguoEra) obj).writeExternal(objectOutput);
                return;
            case (byte) 7:
                ((ThaiBuddhistDate) obj).writeExternal(objectOutput);
                return;
            case (byte) 8:
                ((ThaiBuddhistEra) obj).writeExternal(objectOutput);
                return;
            case (byte) 11:
                ((e) obj).writeExternal(objectOutput);
                return;
            case (byte) 12:
                ((ChronoLocalDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            case (byte) 13:
                ((ChronoZonedDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public void readExternal(ObjectInput objectInput) {
        this.type = objectInput.readByte();
        this.object = a(this.type, objectInput);
    }

    private static Object a(byte b, ObjectInput objectInput) {
        switch (b) {
            case (byte) 1:
                return JapaneseDate.p((DataInput) objectInput);
            case (byte) 2:
                return JapaneseEra.q(objectInput);
            case (byte) 3:
                return HijrahDate.p(objectInput);
            case (byte) 4:
                return HijrahEra.readExternal(objectInput);
            case (byte) 5:
                return MinguoDate.p(objectInput);
            case (byte) 6:
                return MinguoEra.readExternal(objectInput);
            case (byte) 7:
                return ThaiBuddhistDate.p(objectInput);
            case (byte) 8:
                return ThaiBuddhistEra.readExternal(objectInput);
            case (byte) 11:
                return e.o(objectInput);
            case (byte) 12:
                return ChronoLocalDateTimeImpl.a(objectInput);
            case (byte) 13:
                return ChronoZonedDateTimeImpl.b(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }
}
