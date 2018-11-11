package com.jumio.commons.enums;

public enum ScreenAngle {
    PORTRAIT(0),
    LANDSCAPE(90),
    INVERTED_PORTRAIT(180),
    INVERTED_LANDSCAPE(270);
    
    private final int angle;

    private ScreenAngle(int i) {
        this.angle = i;
    }

    public int getValue() {
        return this.angle;
    }
}
