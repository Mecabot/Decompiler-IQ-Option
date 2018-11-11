package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;

public class OpeningHandshakeException extends WebSocketException {
    private static final long serialVersionUID = 1;
    private final byte[] mBody;
    private final Map<String, List<String>> mHeaders;
    private final ad mStatusLine;

    OpeningHandshakeException(WebSocketError webSocketError, String str, ad adVar, Map<String, List<String>> map) {
        this(webSocketError, str, adVar, map, null);
    }

    OpeningHandshakeException(WebSocketError webSocketError, String str, ad adVar, Map<String, List<String>> map, byte[] bArr) {
        super(webSocketError, str);
        this.mStatusLine = adVar;
        this.mHeaders = map;
        this.mBody = bArr;
    }
}
