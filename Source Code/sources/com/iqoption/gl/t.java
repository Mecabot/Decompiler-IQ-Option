package com.iqoption.gl;

final /* synthetic */ class t implements Runnable {
    private final int csi;

    t(int i) {
        this.csi = i;
    }

    public void run() {
        NativeHandler.vibrate((long) this.csi);
    }
}
