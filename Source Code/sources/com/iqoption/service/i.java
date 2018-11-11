package com.iqoption.service;

final /* synthetic */ class i implements Runnable {
    private final WebSocketHandler dqk;

    i(WebSocketHandler webSocketHandler) {
        this.dqk = webSocketHandler;
    }

    public void run() {
        this.dqk.aDB();
    }
}
