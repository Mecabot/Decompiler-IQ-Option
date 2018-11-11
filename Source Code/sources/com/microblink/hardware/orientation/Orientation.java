package com.microblink.hardware.orientation;

/* compiled from: line */
public enum Orientation {
    ORIENTATION_PORTRAIT(0, true, false),
    ORIENTATION_LANDSCAPE_RIGHT(1, false, true),
    ORIENTATION_PORTRAIT_UPSIDE(2, true, false),
    ORIENTATION_LANDSCAPE_LEFT(3, false, true),
    ORIENTATION_UNKNOWN(4, false, false);
    
    private int IIIIlIllIl;
    private boolean IIIIlIllIl;
    private boolean IlIIIlIIIl;

    private Orientation(int i, boolean z, boolean z2) {
        this.IIIIlIllIl = i;
        this.IlIIIlIIIl = z;
        this.IIIIlIllIl = z2;
    }

    public final int intValue() {
        return this.IIIIlIllIl;
    }

    public final boolean isVertical() {
        return this.IlIIIlIIIl;
    }

    public final boolean isHorizontal() {
        return this.IIIIlIllIl;
    }

    public final Orientation rotate90Clockwise() {
        return fromInt((this.IIIIlIllIl + 3) % 4);
    }

    public final Orientation rotate90CounterClockwise() {
        return fromInt((this.IIIIlIllIl + 1) % 4);
    }

    public final Orientation rotate180() {
        return fromInt((this.IIIIlIllIl + 2) % 4);
    }

    public final String toString() {
        switch (this.IIIIlIllIl) {
            case 0:
                return "Portrait";
            case 1:
                return "Landscape right";
            case 2:
                return "Inverse portrait";
            case 3:
                return "Landscape left";
            default:
                return "Unknown";
        }
    }

    public static Orientation fromInt(int i) {
        switch (i) {
            case 0:
                return ORIENTATION_PORTRAIT;
            case 1:
                return ORIENTATION_LANDSCAPE_RIGHT;
            case 2:
                return ORIENTATION_PORTRAIT_UPSIDE;
            case 3:
                return ORIENTATION_LANDSCAPE_LEFT;
            default:
                return ORIENTATION_UNKNOWN;
        }
    }

    public static Orientation fromActivityInfoCode(int i) {
        switch (i) {
            case 0:
                return ORIENTATION_LANDSCAPE_RIGHT;
            case 1:
                return ORIENTATION_PORTRAIT;
            case 8:
                return ORIENTATION_LANDSCAPE_LEFT;
            case 9:
                return ORIENTATION_PORTRAIT_UPSIDE;
            default:
                return ORIENTATION_PORTRAIT;
        }
    }
}
