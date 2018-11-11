package com.iqoption.gl;

final /* synthetic */ class s implements Runnable {
    private final String alY;
    private final double apk;
    private final String arb;
    private final double cFb;

    s(String str, double d, double d2, String str2) {
        this.alY = str;
        this.cFb = d;
        this.apk = d2;
        this.arb = str2;
    }

    public void run() {
        NativeHandler.lambda$onChangeTPSL$8$NativeHandler(this.alY, this.cFb, this.apk, this.arb);
    }
}
