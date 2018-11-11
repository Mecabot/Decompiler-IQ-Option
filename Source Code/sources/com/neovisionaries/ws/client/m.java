package com.neovisionaries.ws.client;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: HandshakeReader */
class m {
    private final af dpy;

    public m(af afVar) {
        this.dpy = afVar;
    }

    public Map<String, List<String>> a(ak akVar, String str) {
        ad a = a(akVar);
        Map b = b(akVar);
        a(a, b, akVar);
        a(a, b);
        b(a, b);
        a(a, b, str);
        c(a, b);
        d(a, b);
        return b;
    }

    private ad a(ak akVar) {
        WebSocketError webSocketError;
        StringBuilder stringBuilder;
        try {
            String readLine = akVar.readLine();
            if (readLine == null || readLine.length() == 0) {
                throw new WebSocketException(WebSocketError.STATUS_LINE_EMPTY, "The status line of the opening handshake response is empty.");
            }
            try {
                return new ad(readLine);
            } catch (Exception unused) {
                webSocketError = WebSocketError.STATUS_LINE_BAD_FORMAT;
                stringBuilder = new StringBuilder();
                stringBuilder.append("The status line of the opening handshake response is badly formatted. The status line is: ");
                stringBuilder.append(readLine);
                throw new WebSocketException(webSocketError, stringBuilder.toString());
            }
        } catch (Throwable e) {
            webSocketError = WebSocketError.OPENING_HANDSHAKE_RESPONSE_FAILURE;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read an opening handshake response from the server: ");
            stringBuilder.append(e.getMessage());
            throw new WebSocketException(webSocketError, stringBuilder.toString(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> b(com.neovisionaries.ws.client.ak r6) {
        /*
        r5 = this;
        r0 = new java.util.TreeMap;
        r1 = java.lang.String.CASE_INSENSITIVE_ORDER;
        r0.<init>(r1);
        r1 = 0;
    L_0x0008:
        r2 = r6.readLine();	 Catch:{ IOException -> 0x004b }
        if (r2 == 0) goto L_0x0041;
    L_0x000e:
        r3 = r2.length();
        if (r3 != 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0041;
    L_0x0015:
        r3 = 0;
        r3 = r2.charAt(r3);
        r4 = 32;
        if (r3 == r4) goto L_0x0032;
    L_0x001e:
        r4 = 9;
        if (r3 != r4) goto L_0x0023;
    L_0x0022:
        goto L_0x0032;
    L_0x0023:
        if (r1 == 0) goto L_0x002c;
    L_0x0025:
        r1 = r1.toString();
        r5.b(r0, r1);
    L_0x002c:
        r1 = new java.lang.StringBuilder;
        r1.<init>(r2);
        goto L_0x0008;
    L_0x0032:
        if (r1 != 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0008;
    L_0x0035:
        r3 = "^[ \t]+";
        r4 = " ";
        r2 = r2.replaceAll(r3, r4);
        r1.append(r2);
        goto L_0x0008;
    L_0x0041:
        if (r1 == 0) goto L_0x004a;
    L_0x0043:
        r6 = r1.toString();
        r5.b(r0, r6);
    L_0x004a:
        return r0;
    L_0x004b:
        r6 = move-exception;
        r0 = new com.neovisionaries.ws.client.WebSocketException;
        r1 = com.neovisionaries.ws.client.WebSocketError.HTTP_HEADER_FAILURE;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "An error occurred while HTTP header section was being read: ";
        r2.append(r3);
        r3 = r6.getMessage();
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r1, r2, r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.m.b(com.neovisionaries.ws.client.ak):java.util.Map<java.lang.String, java.util.List<java.lang.String>>");
    }

    private void b(Map<String, List<String>> map, String str) {
        String[] split = str.split(":", 2);
        if (split.length >= 2) {
            String trim = split[0].trim();
            str = split[1].trim();
            List list = (List) map.get(trim);
            if (list == null) {
                list = new ArrayList();
                map.put(trim, list);
            }
            list.add(str);
        }
    }

    private void a(ad adVar, Map<String, List<String>> map, ak akVar) {
        if (adVar.getStatusCode() != 101) {
            byte[] a = a((Map) map, akVar);
            WebSocketError webSocketError = WebSocketError.NOT_SWITCHING_PROTOCOLS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The status code of the opening handshake response is not '101 Switching Protocols'. The status line is: ");
            stringBuilder.append(adVar);
            throw new OpeningHandshakeException(webSocketError, stringBuilder.toString(), adVar, map, a);
        }
    }

    private byte[] a(Map<String, List<String>> map, ak akVar) {
        int H = H(map);
        if (H <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[H];
            akVar.k(bArr, H);
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int H(Map<String, List<String>> map) {
        try {
            return Integer.parseInt((String) ((List) map.get("Content-Length")).get(0));
        } catch (Exception unused) {
            return -1;
        }
    }

    private void a(ad adVar, Map<String, List<String>> map) {
        List<String> list = (List) map.get("Upgrade");
        if (list == null || list.size() == 0) {
            throw new OpeningHandshakeException(WebSocketError.NO_UPGRADE_HEADER, "The opening handshake response does not contain 'Upgrade' header.", adVar, map);
        }
        for (String split : list) {
            String[] split2 = split.split("\\s*,\\s*");
            int length = split2.length;
            int i = 0;
            while (i < length) {
                if (!"websocket".equalsIgnoreCase(split2[i])) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new OpeningHandshakeException(WebSocketError.NO_WEBSOCKET_IN_UPGRADE_HEADER, "'websocket' was not found in 'Upgrade' header.", adVar, map);
    }

    private void b(ad adVar, Map<String, List<String>> map) {
        List<String> list = (List) map.get("Connection");
        if (list == null || list.size() == 0) {
            throw new OpeningHandshakeException(WebSocketError.NO_CONNECTION_HEADER, "The opening handshake response does not contain 'Connection' header.", adVar, map);
        }
        for (String split : list) {
            String[] split2 = split.split("\\s*,\\s*");
            int length = split2.length;
            int i = 0;
            while (i < length) {
                if (!"Upgrade".equalsIgnoreCase(split2[i])) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new OpeningHandshakeException(WebSocketError.NO_UPGRADE_IN_CONNECTION_HEADER, "'Upgrade' was not found in 'Connection' header.", adVar, map);
    }

    private void a(ad adVar, Map<String, List<String>> map, String str) {
        List list = (List) map.get("Sec-WebSocket-Accept");
        if (list == null) {
            throw new OpeningHandshakeException(WebSocketError.NO_SEC_WEBSOCKET_ACCEPT_HEADER, "The opening handshake response does not contain 'Sec-WebSocket-Accept' header.", adVar, map);
        }
        String str2 = (String) list.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        try {
            if (!b.encode(MessageDigest.getInstance("SHA-1").digest(p.kK(stringBuilder.toString()))).equals(str2)) {
                throw new OpeningHandshakeException(WebSocketError.UNEXPECTED_SEC_WEBSOCKET_ACCEPT_HEADER, "The value of 'Sec-WebSocket-Accept' header is different from the expected one.", adVar, map);
            }
        } catch (Exception unused) {
        }
    }

    private void c(ad adVar, Map<String, List<String>> map) {
        List<String> list = (List) map.get("Sec-WebSocket-Extensions");
        if (list != null && list.size() != 0) {
            List arrayList = new ArrayList();
            for (String split : list) {
                String[] split2 = split.split("\\s*,\\s*");
                int length = split2.length;
                int i = 0;
                while (i < length) {
                    String str = split2[i];
                    ah kS = ah.kS(str);
                    WebSocketError webSocketError;
                    StringBuilder stringBuilder;
                    if (kS == null) {
                        webSocketError = WebSocketError.EXTENSION_PARSE_ERROR;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The value in 'Sec-WebSocket-Extensions' failed to be parsed: ");
                        stringBuilder.append(str);
                        throw new OpeningHandshakeException(webSocketError, stringBuilder.toString(), adVar, map);
                    }
                    str = kS.getName();
                    if (this.dpy.aQY().kI(str)) {
                        kS.validate();
                        arrayList.add(kS);
                        i++;
                    } else {
                        webSocketError = WebSocketError.UNSUPPORTED_EXTENSION;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The extension contained in the Sec-WebSocket-Extensions header is not supported: ");
                        stringBuilder.append(str);
                        throw new OpeningHandshakeException(webSocketError, stringBuilder.toString(), adVar, map);
                    }
                }
            }
            a(adVar, (Map) map, arrayList);
            this.dpy.bJ(arrayList);
        }
    }

    private void a(ad adVar, Map<String, List<String>> map, List<ah> list) {
        ah ahVar = null;
        for (ah ahVar2 : list) {
            if (ahVar2 instanceof s) {
                if (ahVar == null) {
                    ahVar = ahVar2;
                } else {
                    throw new OpeningHandshakeException(WebSocketError.EXTENSIONS_CONFLICT, String.format("'%s' extension and '%s' extension conflict with each other.", new Object[]{ahVar.getName(), ahVar2.getName()}), adVar, map);
                }
            }
        }
    }

    private void d(ad adVar, Map<String, List<String>> map) {
        List list = (List) map.get("Sec-WebSocket-Protocol");
        if (list != null) {
            String str = (String) list.get(0);
            if (str != null && str.length() != 0) {
                if (this.dpy.aQY().kG(str)) {
                    this.dpy.kR(str);
                    return;
                }
                WebSocketError webSocketError = WebSocketError.UNSUPPORTED_PROTOCOL;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The protocol contained in the Sec-WebSocket-Protocol header is not supported: ");
                stringBuilder.append(str);
                throw new OpeningHandshakeException(webSocketError, stringBuilder.toString(), adVar, map);
            }
        }
    }
}
