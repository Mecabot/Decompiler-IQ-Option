package com.iqoption.service;

final /* synthetic */ class k implements Runnable {
    private final String afd;
    private final WebSocketHandler dqk;
    private final String je;

    k(WebSocketHandler webSocketHandler, String str, String str2) {
        this.dqk = webSocketHandler;
        this.afd = str;
        this.je = str2;
    }

    public void run() {
        this.dqk.az(this.afd, this.je);
    }
}
