package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;

/* compiled from: LookupLocation.kt */
public final class Position implements Serializable {
    private static final Position eEt = new Position(-1, -1);
    public static final a eEu = new a();
    private final int column;
    private final int line;

    /* compiled from: LookupLocation.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Position bfv() {
            return Position.eEt;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            if ((this.line == position.line ? 1 : null) != null) {
                if ((this.column == position.column ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position(line=");
        stringBuilder.append(this.line);
        stringBuilder.append(", column=");
        stringBuilder.append(this.column);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }
}
