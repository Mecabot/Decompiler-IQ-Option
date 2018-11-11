package org.threeten.bp.zone;

import com.iqoption.dto.ChartTimeInterval;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

final class Ser implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        a(this.type, this.object, objectOutput);
    }

    private static void a(byte b, Object obj, DataOutput dataOutput) {
        dataOutput.writeByte(b);
        switch (b) {
            case (byte) 1:
                ((StandardZoneRules) obj).writeExternal(dataOutput);
                return;
            case (byte) 2:
                ((ZoneOffsetTransition) obj).writeExternal(dataOutput);
                return;
            case (byte) 3:
                ((ZoneOffsetTransitionRule) obj).writeExternal(dataOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public void readExternal(ObjectInput objectInput) {
        this.type = objectInput.readByte();
        this.object = a(this.type, (DataInput) objectInput);
    }

    static Object i(DataInput dataInput) {
        return a(dataInput.readByte(), dataInput);
    }

    private static Object a(byte b, DataInput dataInput) {
        switch (b) {
            case (byte) 1:
                return StandardZoneRules.t(dataInput);
            case (byte) 2:
                return ZoneOffsetTransition.u(dataInput);
            case (byte) 3:
                return ZoneOffsetTransitionRule.v(dataInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }

    static void a(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i = totalSeconds % ChartTimeInterval.CANDLE_15m == 0 ? totalSeconds / ChartTimeInterval.CANDLE_15m : 127;
        dataOutput.writeByte(i);
        if (i == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    static ZoneOffset r(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.mP(dataInput.readInt()) : ZoneOffset.mP(readByte * ChartTimeInterval.CANDLE_15m);
    }

    static void a(long j, DataOutput dataOutput) {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
            return;
        }
        int i = (int) ((j + 4575744000L) / 900);
        dataOutput.writeByte((i >>> 16) & 255);
        dataOutput.writeByte((i >>> 8) & 255);
        dataOutput.writeByte(i & 255);
    }

    static long s(DataInput dataInput) {
        int readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }
}
