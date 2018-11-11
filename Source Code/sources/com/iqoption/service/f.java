package com.iqoption.service;

import com.iqoption.service.websocket.a.b;

final /* synthetic */ class f implements Runnable {
    private final WebSocketHandler dqk;
    private final b dql;

    f(WebSocketHandler webSocketHandler, b bVar) {
        this.dqk = webSocketHandler;
        this.dql = bVar;
    }

    public void run() {
        this.dqk.d(this.dql);
    }
}
