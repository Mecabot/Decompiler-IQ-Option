package com.iqoption.gl;

final /* synthetic */ class i implements Runnable {
    private final String alY;
    private final double cFb;

    i(String str, double d) {
        this.alY = str;
        this.cFb = d;
    }

    public void run() {
        NativeHandler.lambda$onAnalyticsEventButtonPressed$16$NativeHandler(this.alY, this.cFb);
    }
}
