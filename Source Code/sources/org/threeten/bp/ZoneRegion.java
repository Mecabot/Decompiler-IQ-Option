package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.a.d;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.c;

final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern fdA = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private static final long serialVersionUID = 8386373296231747096L;
    private final transient ZoneRules fec;
    private final String id;

    private static ZoneRegion nN(String str) {
        StringBuilder stringBuilder;
        if (str.equals("Z") || str.startsWith("+") || str.startsWith("-")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for region-based ZoneId, invalid format: ");
            stringBuilder.append(str);
            throw new DateTimeException(stringBuilder.toString());
        } else if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
            return new ZoneRegion(str, ZoneOffset.fdZ.bCz());
        } else {
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                ZoneOffset nM = ZoneOffset.nM(str.substring(3));
                if (nM.getTotalSeconds() == 0) {
                    return new ZoneRegion(str.substring(0, 3), nM.bCz());
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str.substring(0, 3));
                stringBuilder2.append(nM.getId());
                return new ZoneRegion(stringBuilder2.toString(), nM.bCz());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return C(str, false);
            } else {
                ZoneOffset nM2 = ZoneOffset.nM(str.substring(2));
                if (nM2.getTotalSeconds() == 0) {
                    return new ZoneRegion("UT", nM2.bCz());
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("UT");
                stringBuilder.append(nM2.getId());
                return new ZoneRegion(stringBuilder.toString(), nM2.bCz());
            }
        }
    }

    static ZoneRegion C(String str, boolean z) {
        d.requireNonNull(str, "zoneId");
        if (str.length() < 2 || !fdA.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for region-based ZoneId, invalid format: ");
            stringBuilder.append(str);
            throw new DateTimeException(stringBuilder.toString());
        }
        ZoneRules zoneRules = null;
        try {
            zoneRules = c.E(str, true);
        } catch (ZoneRulesException e) {
            if (str.equals("GMT0")) {
                zoneRules = ZoneOffset.fdZ.bCz();
            } else if (z) {
                throw e;
            }
        }
        return new ZoneRegion(str, zoneRules);
    }

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.id = str;
        this.fec = zoneRules;
    }

    public String getId() {
        return this.id;
    }

    public ZoneRules bCz() {
        return this.fec != null ? this.fec : c.E(this.id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void write(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        writeExternal(dataOutput);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeUTF(this.id);
    }

    static ZoneId m(DataInput dataInput) {
        return nN(dataInput.readUTF());
    }
}
