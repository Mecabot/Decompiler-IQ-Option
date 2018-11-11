package com.iqoption.service;

final /* synthetic */ class j implements Runnable {
    private final String afd;
    private final String arb;
    private final WebSocketHandler dqk;
    private final int jd;

    j(WebSocketHandler webSocketHandler, String str, int i, String str2) {
        this.dqk = webSocketHandler;
        this.afd = str;
        this.jd = i;
        this.arb = str2;
    }

    public void run() {
        this.dqk.e(this.afd, this.jd, this.arb);
    }
}
