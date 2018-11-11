package com.microblink.secured;

/* compiled from: line */
public final class h {
    ae dVY = null;
    ae dVZ = null;
    boolean dWa = false;
    boolean dWb = true;
    boolean dWc = true;

    public h(String str) {
        if (str == null || str.length() == 0) {
            throw new NullPointerException("Interval expression cannot be null nor empty!");
        }
        str = str.trim();
        if ("*".equals(str)) {
            this.dWa = true;
            return;
        }
        StringBuilder stringBuilder;
        if (str.charAt(0) == '[') {
            this.dWb = true;
        } else if (str.charAt(0) == '<') {
            this.dWb = false;
        } else {
            stringBuilder = new StringBuilder("Invalid version interval: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int length = str.length() - 1;
        if (str.charAt(length) == ']') {
            this.dWc = true;
        } else if (str.charAt(length) == '>') {
            this.dWc = false;
        } else {
            stringBuilder = new StringBuilder("Invalid version interval: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        String[] split = str.substring(1, length).split(",");
        if (split.length != 2) {
            stringBuilder = new StringBuilder("Invalid version interval: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (!"*".equals(split[0])) {
            this.dVY = new ae(split[0]);
        }
        if (!"*".equals(split[1])) {
            this.dVZ = new ae(split[1]);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.dWa) {
            stringBuilder.append('*');
        } else {
            if (this.dWb) {
                stringBuilder.append('[');
            } else {
                stringBuilder.append('<');
            }
            if (this.dVY != null) {
                stringBuilder.append(this.dVY.toString());
            } else {
                stringBuilder.append('*');
            }
            stringBuilder.append(',');
            if (this.dVZ != null) {
                stringBuilder.append(this.dVZ.toString());
            } else {
                stringBuilder.append('*');
            }
            if (this.dWc) {
                stringBuilder.append(']');
            } else {
                stringBuilder.append('>');
            }
        }
        return stringBuilder.toString();
    }
}
