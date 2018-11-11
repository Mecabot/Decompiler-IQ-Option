package com.neovisionaries.ws.client;

class StateManager {
    private WebSocketState eaG = WebSocketState.CREATED;
    private CloseInitiator eaH = CloseInitiator.NONE;

    enum CloseInitiator {
        NONE,
        SERVER,
        CLIENT
    }

    public WebSocketState aQK() {
        return this.eaG;
    }

    public void b(WebSocketState webSocketState) {
        this.eaG = webSocketState;
    }

    public void a(CloseInitiator closeInitiator) {
        this.eaG = WebSocketState.CLOSING;
        if (this.eaH == CloseInitiator.NONE) {
            this.eaH = closeInitiator;
        }
    }

    public boolean aQL() {
        return this.eaH == CloseInitiator.SERVER;
    }
}
