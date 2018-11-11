package org.threeten.bp.format;

public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    boolean parse(boolean z, boolean z2, boolean z3) {
        int ordinal = ordinal();
        if (ordinal != 4) {
            boolean z4 = false;
            switch (ordinal) {
                case 0:
                    if (!(z && z2)) {
                        z4 = true;
                    }
                    return z4;
                case 1:
                    break;
                default:
                    if (!(z2 || z3)) {
                        z4 = true;
                    }
                    return z4;
            }
        }
        return true;
    }
}
