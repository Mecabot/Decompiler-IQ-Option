package com.iqoption.app.b;

/* compiled from: AppForegroundEvent */
public class a {
    public final boolean alu;

    public a(boolean z) {
        this.alu = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppForegroundEvent{isForeground=");
        stringBuilder.append(this.alu);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
