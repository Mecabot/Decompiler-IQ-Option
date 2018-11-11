package io.fabric.sdk.android.services.common;

/* compiled from: Crash */
public abstract class i {
    private final String emT;
    private final String uQ;

    /* compiled from: Crash */
    public static class a extends i {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* compiled from: Crash */
    public static class b extends i {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public i(String str, String str2) {
        this.uQ = str;
        this.emT = str2;
    }

    public String FC() {
        return this.uQ;
    }

    public String getExceptionName() {
        return this.emT;
    }
}
