package com.neovisionaries.ws.client;

public class WebSocketException extends Exception {
    private static final long serialVersionUID = 1;
    private final WebSocketError mError;

    public WebSocketException(WebSocketError webSocketError, String str) {
        super(str);
        this.mError = webSocketError;
    }

    public WebSocketException(WebSocketError webSocketError, String str, Throwable th) {
        super(str, th);
        this.mError = webSocketError;
    }

    public WebSocketError aRh() {
        return this.mError;
    }
}
