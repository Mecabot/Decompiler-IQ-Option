package com.neovisionaries.ws.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/* compiled from: WebSocket */
public class af {
    private final ab eaK;
    private final StateManager eaL;
    private l eaM;
    private final o eaN;
    private final v eaO;
    private final w eaP;
    private final Object eaQ = new Object();
    private ak eaR;
    private am eaS;
    private z eaT;
    private ao eaU;
    private Map<String, List<String>> eaV;
    private List<ah> eaW;
    private String eaX;
    private boolean eaY;
    private boolean eaZ = true;
    private final ai eai;
    private boolean eba = true;
    private int ebb;
    private int ebc;
    private boolean ebd;
    private Object ebe = new Object();
    private boolean ebf;
    private boolean ebg;
    private boolean ebh;
    private boolean ebi;
    private aj ebj;
    private aj ebk;
    private s ebl;

    af(ai aiVar, boolean z, String str, String str2, String str3, ab abVar) {
        this.eai = aiVar;
        this.eaK = abVar;
        this.eaL = new StateManager();
        this.eaM = new l(z, str, str2, str3);
        this.eaN = new o(this);
        this.eaO = new v(this, new d());
        this.eaP = new w(this, new d());
    }

    protected void finalize() {
        if (c(WebSocketState.CREATED)) {
            finish();
        }
        super.finalize();
    }

    public boolean isOpen() {
        return c(WebSocketState.OPEN);
    }

    private boolean c(WebSocketState webSocketState) {
        boolean z;
        synchronized (this.eaL) {
            z = this.eaL.aQK() == webSocketState;
        }
        return z;
    }

    public af kP(String str) {
        this.eaM.kH(str);
        return this;
    }

    public af aO(String str, String str2) {
        this.eaM.addHeader(str, str2);
        return this;
    }

    public boolean isExtended() {
        return this.eaY;
    }

    public boolean aQM() {
        return this.eaZ;
    }

    public boolean aQN() {
        return this.eba;
    }

    public int aQO() {
        return this.ebb;
    }

    public af b(al alVar) {
        this.eaN.a(alVar);
        return this;
    }

    public Socket getSocket() {
        return this.eaK.getSocket();
    }

    public af aQP() {
        aQQ();
        try {
            this.eaK.connect();
            this.eaV = aQR();
            this.ebl = aRf();
            this.eaL.b(WebSocketState.OPEN);
            this.eaN.a(WebSocketState.OPEN);
            aQT();
            return this;
        } catch (WebSocketException e) {
            this.eaK.aQJ();
            this.eaL.b(WebSocketState.CLOSED);
            this.eaN.a(WebSocketState.CLOSED);
            throw e;
        }
    }

    public af j(int i, String str) {
        return b(i, str, 10000);
    }

    /* JADX WARNING: Missing block: B:8:0x0025, code:
            r3.eaN.a(com.neovisionaries.ws.client.WebSocketState.CLOSING);
     */
    /* JADX WARNING: Missing block: B:9:0x0030, code:
            if (r6 >= 0) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:10:0x0032, code:
            r6 = 10000;
     */
    /* JADX WARNING: Missing block: B:11:0x0034, code:
            cF(r6);
     */
    /* JADX WARNING: Missing block: B:12:0x0037, code:
            return r3;
     */
    public com.neovisionaries.ws.client.af b(int r4, java.lang.String r5, long r6) {
        /*
        r3 = this;
        r0 = r3.eaL;
        monitor-enter(r0);
        r1 = com.neovisionaries.ws.client.af.AnonymousClass1.ebm;	 Catch:{ all -> 0x003e }
        r2 = r3.eaL;	 Catch:{ all -> 0x003e }
        r2 = r2.aQK();	 Catch:{ all -> 0x003e }
        r2 = r2.ordinal();	 Catch:{ all -> 0x003e }
        r1 = r1[r2];	 Catch:{ all -> 0x003e }
        switch(r1) {
            case 1: goto L_0x0038;
            case 2: goto L_0x0016;
            default: goto L_0x0014;
        };	 Catch:{ all -> 0x003e }
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        goto L_0x003d;
    L_0x0016:
        r1 = r3.eaL;	 Catch:{ all -> 0x003e }
        r2 = com.neovisionaries.ws.client.StateManager.CloseInitiator.CLIENT;	 Catch:{ all -> 0x003e }
        r1.a(r2);	 Catch:{ all -> 0x003e }
        r4 = com.neovisionaries.ws.client.aj.l(r4, r5);	 Catch:{ all -> 0x003e }
        r3.C(r4);	 Catch:{ all -> 0x003e }
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        r4 = r3.eaN;
        r5 = com.neovisionaries.ws.client.WebSocketState.CLOSING;
        r4.a(r5);
        r4 = 0;
        r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x0034;
    L_0x0032:
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
    L_0x0034:
        r3.cF(r6);
        return r3;
    L_0x0038:
        r3.aRe();	 Catch:{ all -> 0x003e }
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        return r3;
    L_0x003d:
        return r3;
    L_0x003e:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.af.b(int, java.lang.String, long):com.neovisionaries.ws.client.af");
    }

    /* JADX WARNING: Missing block: B:12:0x0017, code:
            r0 = r3.eaU;
     */
    /* JADX WARNING: Missing block: B:13:0x0019, code:
            if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Missing block: B:14:0x001b, code:
            return r3;
     */
    /* JADX WARNING: Missing block: B:15:0x001c, code:
            r1 = D(r4);
     */
    /* JADX WARNING: Missing block: B:16:0x0020, code:
            if (r1 != null) goto L_0x0026;
     */
    /* JADX WARNING: Missing block: B:17:0x0022, code:
            r0.K(r4);
     */
    /* JADX WARNING: Missing block: B:18:0x0026, code:
            r4 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:20:0x002e, code:
            if (r4.hasNext() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:21:0x0030, code:
            r0.K((com.neovisionaries.ws.client.aj) r4.next());
     */
    /* JADX WARNING: Missing block: B:22:0x003a, code:
            return r3;
     */
    public com.neovisionaries.ws.client.af C(com.neovisionaries.ws.client.aj r4) {
        /*
        r3 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return r3;
    L_0x0003:
        r0 = r3.eaL;
        monitor-enter(r0);
        r1 = r3.eaL;	 Catch:{ all -> 0x003b }
        r1 = r1.aQK();	 Catch:{ all -> 0x003b }
        r2 = com.neovisionaries.ws.client.WebSocketState.OPEN;	 Catch:{ all -> 0x003b }
        if (r1 == r2) goto L_0x0016;
    L_0x0010:
        r2 = com.neovisionaries.ws.client.WebSocketState.CLOSING;	 Catch:{ all -> 0x003b }
        if (r1 == r2) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        return r3;
    L_0x0016:
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        r0 = r3.eaU;
        if (r0 != 0) goto L_0x001c;
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = r3.D(r4);
        if (r1 != 0) goto L_0x0026;
    L_0x0022:
        r0.K(r4);
        goto L_0x003a;
    L_0x0026:
        r4 = r1.iterator();
    L_0x002a:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x003a;
    L_0x0030:
        r1 = r4.next();
        r1 = (com.neovisionaries.ws.client.aj) r1;
        r0.K(r1);
        goto L_0x002a;
    L_0x003a:
        return r3;
    L_0x003b:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.af.C(com.neovisionaries.ws.client.aj):com.neovisionaries.ws.client.af");
    }

    private List<aj> D(aj ajVar) {
        return aj.a(ajVar, this.ebc, this.ebl);
    }

    public af kQ(String str) {
        return C(aj.kY(str));
    }

    private void aQQ() {
        synchronized (this.eaL) {
            if (this.eaL.aQK() != WebSocketState.CREATED) {
                throw new WebSocketException(WebSocketError.NOT_IN_CREATED_STATE, "The current state of the WebSocket is not CREATED.");
            }
            this.eaL.b(WebSocketState.CONNECTING);
        }
        this.eaN.a(WebSocketState.CONNECTING);
    }

    private Map<String, List<String>> aQR() {
        Socket socket = this.eaK.getSocket();
        ak b = b(socket);
        am c = c(socket);
        String aQS = aQS();
        a(c, aQS);
        Map<String, List<String>> a = a(b, aQS);
        this.eaR = b;
        this.eaS = c;
        return a;
    }

    private ak b(Socket socket) {
        try {
            return new ak(new BufferedInputStream(socket.getInputStream()));
        } catch (Throwable e) {
            WebSocketError webSocketError = WebSocketError.SOCKET_INPUT_STREAM_FAILURE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get the input stream of the raw socket: ");
            stringBuilder.append(e.getMessage());
            throw new WebSocketException(webSocketError, stringBuilder.toString(), e);
        }
    }

    private am c(Socket socket) {
        try {
            return new am(new BufferedOutputStream(socket.getOutputStream()));
        } catch (Throwable e) {
            WebSocketError webSocketError = WebSocketError.SOCKET_OUTPUT_STREAM_FAILURE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get the output stream from the raw socket: ");
            stringBuilder.append(e.getMessage());
            throw new WebSocketException(webSocketError, stringBuilder.toString(), e);
        }
    }

    private static String aQS() {
        byte[] bArr = new byte[16];
        p.w(bArr);
        return b.encode(bArr);
    }

    private void a(am amVar, String str) {
        this.eaM.setKey(str);
        str = this.eaM.aQl();
        List aQm = this.eaM.aQm();
        String d = l.d(str, aQm);
        this.eaN.e(str, aQm);
        try {
            amVar.write(d);
            amVar.flush();
        } catch (Throwable e) {
            WebSocketError webSocketError = WebSocketError.OPENING_HAHDSHAKE_REQUEST_FAILURE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to send an opening handshake request to the server: ");
            stringBuilder.append(e.getMessage());
            throw new WebSocketException(webSocketError, stringBuilder.toString(), e);
        }
    }

    private Map<String, List<String>> a(ak akVar, String str) {
        return new m(this).a(akVar, str);
    }

    private void aQT() {
        z zVar = new z(this);
        ao aoVar = new ao(this);
        synchronized (this.eaQ) {
            this.eaT = zVar;
            this.eaU = aoVar;
        }
        zVar.aRB();
        aoVar.aRB();
        zVar.start();
        aoVar.start();
    }

    private void cF(long j) {
        z zVar;
        ao aoVar;
        synchronized (this.eaQ) {
            zVar = this.eaT;
            aoVar = this.eaU;
            this.eaT = null;
            this.eaU = null;
        }
        if (zVar != null) {
            zVar.cE(j);
        }
        if (aoVar != null) {
            aoVar.requestStop();
        }
    }

    ak aQU() {
        return this.eaR;
    }

    am aQV() {
        return this.eaS;
    }

    StateManager aQW() {
        return this.eaL;
    }

    o aQX() {
        return this.eaN;
    }

    l aQY() {
        return this.eaM;
    }

    void bJ(List<ah> list) {
        this.eaW = list;
    }

    void kR(String str) {
        this.eaX = str;
    }

    void aQZ() {
        boolean z;
        synchronized (this.eaQ) {
            this.ebf = true;
            z = this.ebg;
        }
        aRb();
        if (z) {
            aRc();
        }
    }

    void aRa() {
        boolean z;
        synchronized (this.eaQ) {
            this.ebg = true;
            z = this.ebf;
        }
        aRb();
        if (z) {
            aRc();
        }
    }

    private void aRb() {
        synchronized (this.ebe) {
            if (this.ebd) {
                return;
            }
            this.ebd = true;
            this.eaN.I(this.eaV);
        }
    }

    private void aRc() {
        this.eaO.start();
        this.eaP.start();
    }

    void E(aj ajVar) {
        synchronized (this.eaQ) {
            this.ebh = true;
            this.ebj = ajVar;
            if (this.ebi) {
                aRd();
                return;
            }
        }
    }

    void F(aj ajVar) {
        synchronized (this.eaQ) {
            this.ebi = true;
            this.ebk = ajVar;
            if (this.ebh) {
                aRd();
                return;
            }
        }
    }

    private void aRd() {
        finish();
    }

    void finish() {
        this.eaO.stop();
        this.eaP.stop();
        try {
            this.eaK.getSocket().close();
        } catch (Throwable unused) {
            synchronized (this.eaL) {
                this.eaL.b(WebSocketState.CLOSED);
                this.eaN.a(WebSocketState.CLOSED);
                this.eaN.a(this.ebj, this.ebk, this.eaL.aQL());
            }
        }
    }

    private void aRe() {
        an iVar = new i(this);
        iVar.aRB();
        iVar.start();
    }

    private s aRf() {
        if (this.eaW == null) {
            return null;
        }
        for (ah ahVar : this.eaW) {
            if (ahVar instanceof s) {
                return (s) ahVar;
            }
        }
        return null;
    }

    s aRg() {
        return this.ebl;
    }
}
