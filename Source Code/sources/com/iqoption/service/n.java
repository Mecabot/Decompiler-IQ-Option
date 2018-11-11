package com.iqoption.service;

import org.json.JSONObject;

final /* synthetic */ class n implements Runnable {
    private final JSONObject dqn;

    n(JSONObject jSONObject) {
        this.dqn = jSONObject;
    }

    public void run() {
        WebSocketHandler.o(this.dqn);
    }
}
