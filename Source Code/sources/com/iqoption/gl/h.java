package com.iqoption.gl;

final /* synthetic */ class h implements Runnable {
    private final boolean bVC;
    private final NativeHandler cIK;
    private final double cIL;
    private final String je;

    h(NativeHandler nativeHandler, boolean z, String str, double d) {
        this.cIK = nativeHandler;
        this.bVC = z;
        this.je = str;
        this.cIL = d;
    }

    public void run() {
        this.cIK.lambda$onAnalyticsEventPopupServed$15$NativeHandler(this.bVC, this.je, this.cIL);
    }
}
