package com.google.zxing;

/* compiled from: Dimension */
public final class a {
    private final int height;
    private final int width;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.width == aVar.width && this.height == aVar.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.width);
        stringBuilder.append("x");
        stringBuilder.append(this.height);
        return stringBuilder.toString();
    }
}
