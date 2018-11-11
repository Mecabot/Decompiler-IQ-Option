package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.a.d;

public abstract class ZoneRules {

    static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;
        private final ZoneOffset offset;

        public ZoneOffsetTransition e(LocalDateTime localDateTime) {
            return null;
        }

        public boolean isFixedOffset() {
            return true;
        }

        Fixed(ZoneOffset zoneOffset) {
            this.offset = zoneOffset;
        }

        public ZoneOffset d(Instant instant) {
            return this.offset;
        }

        public List<ZoneOffset> d(LocalDateTime localDateTime) {
            return Collections.singletonList(this.offset);
        }

        public boolean c(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.offset.equals(zoneOffset);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.offset.equals(((Fixed) obj).offset);
            }
            if (!(obj instanceof StandardZoneRules)) {
                return false;
            }
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!(standardZoneRules.isFixedOffset() && this.offset.equals(standardZoneRules.d(Instant.fdB)))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return ((((this.offset.hashCode() + 31) ^ 1) ^ 1) ^ (this.offset.hashCode() + 31)) ^ 1;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FixedRules:");
            stringBuilder.append(this.offset);
            return stringBuilder.toString();
        }
    }

    public abstract boolean c(LocalDateTime localDateTime, ZoneOffset zoneOffset);

    public abstract List<ZoneOffset> d(LocalDateTime localDateTime);

    public abstract ZoneOffset d(Instant instant);

    public abstract ZoneOffsetTransition e(LocalDateTime localDateTime);

    public abstract boolean isFixedOffset();

    public static ZoneRules h(ZoneOffset zoneOffset) {
        d.requireNonNull(zoneOffset, "offset");
        return new Fixed(zoneOffset);
    }

    ZoneRules() {
    }
}
