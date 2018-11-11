package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.d;
import org.threeten.bp.chrono.b;

final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        List arrayList = new ArrayList();
        int i = 0;
        while (i < jArr2.length) {
            int i2 = i + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i], zoneOffsetArr2[i], zoneOffsetArr2[i2]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.bDy());
                arrayList.add(zoneOffsetTransition.bDz());
            } else {
                arrayList.add(zoneOffsetTransition.bDz());
                arrayList.add(zoneOffsetTransition.bDy());
            }
            i = i2;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long a : this.standardTransitions) {
            Ser.a(a, dataOutput);
        }
        for (ZoneOffset a2 : this.standardOffsets) {
            Ser.a(a2, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long a3 : this.savingsInstantTransitions) {
            Ser.a(a3, dataOutput);
        }
        for (ZoneOffset a22 : this.wallOffsets) {
            Ser.a(a22, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule writeExternal : this.lastRules) {
            writeExternal.writeExternal(dataOutput);
        }
    }

    static StandardZoneRules t(DataInput dataInput) {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            jArr[i] = Ser.s(dataInput);
        }
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[(readInt + 1)];
        for (readInt = 0; readInt < zoneOffsetArr.length; readInt++) {
            zoneOffsetArr[readInt] = Ser.r(dataInput);
        }
        readInt = dataInput.readInt();
        long[] jArr2 = new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr2[i2] = Ser.s(dataInput);
        }
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[(readInt + 1)];
        for (readInt = 0; readInt < zoneOffsetArr2.length; readInt++) {
            zoneOffsetArr2[readInt] = Ser.r(dataInput);
        }
        byte readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        for (byte b = (byte) 0; b < readByte; b++) {
            zoneOffsetTransitionRuleArr[b] = ZoneOffsetTransitionRule.v(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0;
    }

    public ZoneOffset d(Instant instant) {
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length <= 0 || epochSecond <= this.savingsInstantTransitions[this.savingsInstantTransitions.length - 1]) {
            int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return this.wallOffsets[binarySearch + 1];
        }
        ZoneOffsetTransition[] nl = nl(a(epochSecond, this.wallOffsets[this.wallOffsets.length - 1]));
        ZoneOffsetTransition zoneOffsetTransition = null;
        for (ZoneOffsetTransition zoneOffsetTransition2 : nl) {
            if (epochSecond < zoneOffsetTransition2.toEpochSecond()) {
                return zoneOffsetTransition2.bDA();
            }
        }
        return zoneOffsetTransition2.bDB();
    }

    public List<ZoneOffset> d(LocalDateTime localDateTime) {
        Object f = f(localDateTime);
        if (f instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) f).bDD();
        }
        return Collections.singletonList((ZoneOffset) f);
    }

    public ZoneOffsetTransition e(LocalDateTime localDateTime) {
        Object f = f(localDateTime);
        return f instanceof ZoneOffsetTransition ? (ZoneOffsetTransition) f : null;
    }

    private Object f(LocalDateTime localDateTime) {
        int i = 0;
        if (this.lastRules.length <= 0 || !localDateTime.b(this.savingsLocalTransitions[this.savingsLocalTransitions.length - 1])) {
            int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
            if (binarySearch == -1) {
                return this.wallOffsets[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else if (binarySearch < this.savingsLocalTransitions.length - 1) {
                int i2 = binarySearch + 1;
                if (this.savingsLocalTransitions[binarySearch].equals(this.savingsLocalTransitions[i2])) {
                    binarySearch = i2;
                }
            }
            if ((binarySearch & 1) != 0) {
                return this.wallOffsets[(binarySearch / 2) + 1];
            }
            LocalDateTime localDateTime2 = this.savingsLocalTransitions[binarySearch];
            LocalDateTime localDateTime3 = this.savingsLocalTransitions[binarySearch + 1];
            binarySearch /= 2;
            ZoneOffset zoneOffset = this.wallOffsets[binarySearch];
            ZoneOffset zoneOffset2 = this.wallOffsets[binarySearch + 1];
            if (zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds()) {
                return new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2);
            }
            return new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
        }
        ZoneOffsetTransition[] nl = nl(localDateTime.getYear());
        Object obj = null;
        int length = nl.length;
        while (i < length) {
            ZoneOffsetTransition zoneOffsetTransition = nl[i];
            Object a = a(localDateTime, zoneOffsetTransition);
            if ((a instanceof ZoneOffsetTransition) || a.equals(zoneOffsetTransition.bDA())) {
                return a;
            }
            i++;
            obj = a;
        }
        return obj;
    }

    private Object a(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        b bDy = zoneOffsetTransition.bDy();
        if (zoneOffsetTransition.isGap()) {
            if (localDateTime.c(bDy)) {
                return zoneOffsetTransition.bDA();
            }
            if (localDateTime.c(zoneOffsetTransition.bDz())) {
                return zoneOffsetTransition;
            }
            return zoneOffsetTransition.bDB();
        } else if (localDateTime.c(bDy)) {
            return localDateTime.c(zoneOffsetTransition.bDz()) ? zoneOffsetTransition.bDA() : zoneOffsetTransition;
        } else {
            return zoneOffsetTransition.bDB();
        }
    }

    public boolean c(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return d(localDateTime).contains(zoneOffset);
    }

    private ZoneOffsetTransition[] nl(int i) {
        Integer valueOf = Integer.valueOf(i);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = (ZoneOffsetTransition[]) this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        Object obj = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i2 = 0; i2 < zoneOffsetTransitionRuleArr.length; i2++) {
            obj[i2] = zoneOffsetTransitionRuleArr[i2].nm(i);
        }
        if (i < 2100) {
            this.lastRulesCache.putIfAbsent(valueOf, obj);
        }
        return obj;
    }

    private int a(long j, ZoneOffset zoneOffset) {
        return LocalDate.dr(d.floorDiv(j + ((long) zoneOffset.getTotalSeconds()), 86400)).getYear();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!(Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) && Arrays.equals(this.lastRules, standardZoneRules.lastRules))) {
                z = false;
            }
            return z;
        } else if (!(obj instanceof Fixed)) {
            return false;
        } else {
            if (!(isFixedOffset() && d(Instant.fdB).equals(((Fixed) obj).d(Instant.fdB)))) {
                z = false;
            }
            return z;
        }
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StandardZoneRules[currentStandardOffset=");
        stringBuilder.append(this.standardOffsets[this.standardOffsets.length - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
