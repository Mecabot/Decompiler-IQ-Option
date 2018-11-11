package com.iqoption.deposit;

final /* synthetic */ class o implements Runnable {
    private final boolean bVC;
    private final l bVw;

    o(l lVar, boolean z) {
        this.bVw = lVar;
        this.bVC = z;
    }

    public void run() {
        this.bVw.cr(this.bVC);
    }
}
