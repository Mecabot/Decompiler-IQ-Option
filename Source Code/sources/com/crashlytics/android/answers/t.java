package com.crashlytics.android.answers;

/* compiled from: PredefinedEvent */
public abstract class t<T extends t> extends d<T> {
    final c sG;

    abstract String gn();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{type:\"");
        stringBuilder.append(gn());
        stringBuilder.append('\"');
        stringBuilder.append(", predefinedAttributes:");
        stringBuilder.append(this.sG);
        stringBuilder.append(", customAttributes:");
        stringBuilder.append(this.rQ);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
