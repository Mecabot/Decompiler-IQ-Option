package com.iqoption.gl;

final /* synthetic */ class p implements Runnable {
    private final boolean aoe;

    p(boolean z) {
        this.aoe = z;
    }

    public void run() {
        NativeHandler.lambda$onSetStrikesAutoSelectionState$5$NativeHandler(this.aoe);
    }
}
