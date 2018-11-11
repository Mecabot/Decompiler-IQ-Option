package com.neovisionaries.ws.client;

import android.support.v4.view.PointerIconCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ReadingThread */
class z extends an {
    private boolean eam;
    private aj ean;
    private List<aj> eao = new ArrayList();
    private final s eap;
    private Object eaq = new Object();
    private Timer ear;
    private a eas;
    private long eat;
    private boolean eau;

    /* compiled from: ReadingThread */
    private class a extends TimerTask {
        private a() {
        }

        public void run() {
            try {
                z.this.dpy.getSocket().close();
            } catch (Throwable unused) {
            }
        }
    }

    public z(af afVar) {
        super("ReadingThread", afVar, ThreadType.READING_THREAD);
        this.eap = afVar.aRg();
    }

    public void aQh() {
        try {
            aQz();
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.UNEXPECTED_ERROR_IN_READING_THREAD;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("An uncaught throwable was detected in the reading thread: ");
            stringBuilder.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), th);
            o aQX = this.dpy.aQX();
            aQX.a(webSocketException);
            aQX.b(webSocketException);
        }
        aQC();
    }

    private void aQz() {
        this.dpy.aQZ();
        aj aQA;
        do {
            synchronized (this) {
                if (this.eam) {
                    break;
                }
                aQA = aQA();
                if (aQA == null) {
                    break;
                }
            }
        } while (u(aQA));
        aQB();
        aQF();
    }

    void cE(long j) {
        synchronized (this) {
            if (this.eam) {
                return;
            }
            this.eam = true;
            interrupt();
            this.eat = j;
            aQD();
        }
    }

    private void a(aj ajVar) {
        this.dpy.aQX().a(ajVar);
    }

    private void b(aj ajVar) {
        this.dpy.aQX().b(ajVar);
    }

    private void c(aj ajVar) {
        this.dpy.aQX().c(ajVar);
    }

    private void d(aj ajVar) {
        this.dpy.aQX().d(ajVar);
    }

    private void e(aj ajVar) {
        this.dpy.aQX().e(ajVar);
    }

    private void f(aj ajVar) {
        this.dpy.aQX().f(ajVar);
    }

    private void g(aj ajVar) {
        this.dpy.aQX().g(ajVar);
    }

    private void B(byte[] bArr) {
        try {
            kJ(p.v(bArr));
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.TEXT_MESSAGE_CONSTRUCTION_ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to convert payload data into a string: ");
            stringBuilder.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), th);
            a(webSocketException);
            b(webSocketException, bArr);
        }
    }

    private void kJ(String str) {
        this.dpy.aQX().kJ(str);
    }

    private void u(byte[] bArr) {
        this.dpy.aQX().u(bArr);
    }

    private void a(WebSocketException webSocketException) {
        this.dpy.aQX().a(webSocketException);
    }

    private void a(WebSocketException webSocketException, aj ajVar) {
        this.dpy.aQX().a(webSocketException, ajVar);
    }

    private void a(WebSocketException webSocketException, List<aj> list) {
        this.dpy.aQX().a(webSocketException, (List) list);
    }

    private void a(WebSocketException webSocketException, byte[] bArr) {
        this.dpy.aQX().a(webSocketException, bArr);
    }

    private void b(WebSocketException webSocketException, byte[] bArr) {
        this.dpy.aQX().b(webSocketException, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    private com.neovisionaries.ws.client.aj aQA() {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.dpy;	 Catch:{ InterruptedIOException -> 0x0043, IOException -> 0x0019, WebSocketException -> 0x0015 }
        r1 = r1.aQU();	 Catch:{ InterruptedIOException -> 0x0043, IOException -> 0x0019, WebSocketException -> 0x0015 }
        r1 = r1.aQA();	 Catch:{ InterruptedIOException -> 0x0043, IOException -> 0x0019, WebSocketException -> 0x0015 }
        r7.k(r1);	 Catch:{ InterruptedIOException -> 0x0013, IOException -> 0x0011, WebSocketException -> 0x000f }
        return r1;
    L_0x000f:
        r2 = move-exception;
        goto L_0x0017;
    L_0x0011:
        r2 = move-exception;
        goto L_0x001b;
    L_0x0013:
        r2 = move-exception;
        goto L_0x0045;
    L_0x0015:
        r2 = move-exception;
        r1 = r0;
    L_0x0017:
        r3 = r2;
        goto L_0x0066;
    L_0x0019:
        r2 = move-exception;
        r1 = r0;
    L_0x001b:
        r3 = r7.eam;
        if (r3 == 0) goto L_0x0026;
    L_0x001f:
        r3 = r7.isInterrupted();
        if (r3 == 0) goto L_0x0026;
    L_0x0025:
        return r0;
    L_0x0026:
        r3 = new com.neovisionaries.ws.client.WebSocketException;
        r4 = com.neovisionaries.ws.client.WebSocketError.IO_ERROR_IN_READING;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "An I/O error occurred while a frame was being read from the web socket: ";
        r5.append(r6);
        r6 = r2.getMessage();
        r5.append(r6);
        r5 = r5.toString();
        r3.<init>(r4, r5, r2);
        goto L_0x0066;
    L_0x0043:
        r2 = move-exception;
        r1 = r0;
    L_0x0045:
        r3 = r7.eam;
        if (r3 == 0) goto L_0x004a;
    L_0x0049:
        return r0;
    L_0x004a:
        r3 = new com.neovisionaries.ws.client.WebSocketException;
        r4 = com.neovisionaries.ws.client.WebSocketError.INTERRUPTED_IN_READING;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Interruption occurred while a frame was being read from the web socket: ";
        r5.append(r6);
        r6 = r2.getMessage();
        r5.append(r6);
        r5 = r5.toString();
        r3.<init>(r4, r5, r2);
    L_0x0066:
        r2 = r3 instanceof com.neovisionaries.ws.client.NoMoreFrameException;
        r4 = 1;
        if (r2 == 0) goto L_0x0076;
    L_0x006b:
        r7.eau = r4;
        r2 = r7.dpy;
        r2 = r2.aQN();
        if (r2 == 0) goto L_0x0076;
    L_0x0075:
        r4 = 0;
    L_0x0076:
        if (r4 == 0) goto L_0x007e;
    L_0x0078:
        r7.a(r3);
        r7.a(r3, r1);
    L_0x007e:
        r1 = r7.c(r3);
        r2 = r7.dpy;
        r2.C(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.z.aQA():com.neovisionaries.ws.client.aj");
    }

    private void k(aj ajVar) {
        l(ajVar);
        q(ajVar);
        r(ajVar);
        s(ajVar);
        t(ajVar);
    }

    private void l(aj ajVar) {
        if (!this.dpy.isExtended()) {
            m(ajVar);
            o(ajVar);
            p(ajVar);
        }
    }

    private void m(aj ajVar) {
        if ((this.eap == null || !n(ajVar)) && ajVar.aRk()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV1 bit of a frame is set unexpectedly.");
        }
    }

    private boolean n(aj ajVar) {
        return ajVar.aRo() || ajVar.aRp();
    }

    private void o(aj ajVar) {
        if (ajVar.aRl()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV2 bit of a frame is set unexpectedly.");
        }
    }

    private void p(aj ajVar) {
        if (ajVar.aRm()) {
            throw new WebSocketException(WebSocketError.UNEXPECTED_RESERVED_BIT, "The RSV3 bit of a frame is set unexpectedly.");
        }
    }

    private void q(aj ajVar) {
        int opcode = ajVar.getOpcode();
        switch (opcode) {
            case 0:
            case 1:
            case 2:
                break;
            default:
                switch (opcode) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        if (!this.dpy.isExtended()) {
                            WebSocketError webSocketError = WebSocketError.UNKNOWN_OPCODE;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("A frame has an unknown opcode: 0x");
                            stringBuilder.append(Integer.toHexString(ajVar.getOpcode()));
                            throw new WebSocketException(webSocketError, stringBuilder.toString());
                        }
                        return;
                }
        }
    }

    private void r(aj ajVar) {
        if (ajVar.aRu()) {
            throw new WebSocketException(WebSocketError.FRAME_MASKED, "A frame from the server is masked.");
        }
    }

    private void s(aj ajVar) {
        if (!ajVar.aRt()) {
            Object obj = this.eao.size() != 0 ? 1 : null;
            if (ajVar.aRn()) {
                if (obj == null) {
                    throw new WebSocketException(WebSocketError.UNEXPECTED_CONTINUATION_FRAME, "A continuation frame was detected although a continuation had not started.");
                }
            } else if (obj != null) {
                throw new WebSocketException(WebSocketError.CONTINUATION_NOT_CLOSED, "A non-control frame was detected although the existing continuation had not been closed.");
            }
        } else if (!ajVar.aRj()) {
            throw new WebSocketException(WebSocketError.FRAGMENTED_CONTROL_FRAME, "A control frame is fragmented.");
        }
    }

    private void t(aj ajVar) {
        if (ajVar.aRt()) {
            byte[] payload = ajVar.getPayload();
            if (payload != null && 125 < payload.length) {
                WebSocketError webSocketError = WebSocketError.TOO_LONG_CONTROL_FRAME_PAYLOAD;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The payload size of a control frame exceeds the maximum size (125 bytes): ");
                stringBuilder.append(payload.length);
                throw new WebSocketException(webSocketError, stringBuilder.toString());
            }
        }
    }

    private aj c(WebSocketException webSocketException) {
        int i = 1002;
        switch (webSocketException.aRh()) {
            case INSUFFICENT_DATA:
            case INVALID_PAYLOAD_LENGTH:
            case NO_MORE_FRAME:
            case NON_ZERO_RESERVED_BITS:
            case UNEXPECTED_RESERVED_BIT:
            case UNKNOWN_OPCODE:
            case FRAME_MASKED:
            case FRAGMENTED_CONTROL_FRAME:
            case UNEXPECTED_CONTINUATION_FRAME:
            case CONTINUATION_NOT_CLOSED:
            case TOO_LONG_CONTROL_FRAME_PAYLOAD:
                break;
            case TOO_LONG_PAYLOAD:
            case INSUFFICIENT_MEMORY_FOR_PAYLOAD:
                i = PointerIconCompat.TYPE_VERTICAL_TEXT;
                break;
            default:
                i = PointerIconCompat.TYPE_TEXT;
                break;
        }
        return aj.l(i, webSocketException.getMessage());
    }

    private boolean u(aj ajVar) {
        a(ajVar);
        int opcode = ajVar.getOpcode();
        switch (opcode) {
            case 0:
                return v(ajVar);
            case 1:
                return x(ajVar);
            case 2:
                return y(ajVar);
            default:
                switch (opcode) {
                    case 8:
                        return z(ajVar);
                    case 9:
                        return A(ajVar);
                    case 10:
                        return B(ajVar);
                    default:
                        return true;
                }
        }
    }

    private boolean v(aj ajVar) {
        b(ajVar);
        this.eao.add(ajVar);
        if (!ajVar.aRj()) {
            return true;
        }
        byte[] bH = bH(this.eao);
        if (bH == null) {
            return false;
        }
        if (((aj) this.eao.get(0)).aRo()) {
            B(bH);
        } else {
            u(bH);
        }
        this.eao.clear();
        return true;
    }

    private byte[] bH(List<aj> list) {
        byte[] bI = bI(this.eao);
        if (bI == null) {
            return null;
        }
        if (this.eap != null && ((aj) list.get(0)).aRk()) {
            bI = x(bI);
        }
        return bI;
    }

    private byte[] bI(List<aj> list) {
        Throwable e;
        WebSocketError webSocketError;
        StringBuilder stringBuilder;
        WebSocketException webSocketException;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (aj payload : list) {
                byte[] payload2 = payload.getPayload();
                if (payload2 != null) {
                    if (payload2.length != 0) {
                        byteArrayOutputStream.write(payload2);
                    }
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e = e2;
            webSocketError = WebSocketError.MESSAGE_CONSTRUCTION_ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to concatenate payloads of multiple frames to construct a message: ");
            stringBuilder.append(e.getMessage());
            webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), e);
            a(webSocketException);
            a(webSocketException, (List) list);
            this.dpy.C(aj.l(PointerIconCompat.TYPE_VERTICAL_TEXT, webSocketException.getMessage()));
            return null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            webSocketError = WebSocketError.MESSAGE_CONSTRUCTION_ERROR;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to concatenate payloads of multiple frames to construct a message: ");
            stringBuilder.append(e.getMessage());
            webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), e);
            a(webSocketException);
            a(webSocketException, (List) list);
            this.dpy.C(aj.l(PointerIconCompat.TYPE_VERTICAL_TEXT, webSocketException.getMessage()));
            return null;
        }
    }

    private byte[] w(aj ajVar) {
        byte[] payload = ajVar.getPayload();
        return (this.eap == null || !ajVar.aRk()) ? payload : x(payload);
    }

    private byte[] x(byte[] bArr) {
        try {
            return this.eap.x(bArr);
        } catch (WebSocketException e) {
            a(e);
            a(e, bArr);
            this.dpy.C(aj.l(PointerIconCompat.TYPE_HELP, e.getMessage()));
            return null;
        }
    }

    private boolean x(aj ajVar) {
        c(ajVar);
        if (ajVar.aRj()) {
            B(w(ajVar));
            return true;
        }
        this.eao.add(ajVar);
        return true;
    }

    private boolean y(aj ajVar) {
        d(ajVar);
        if (ajVar.aRj()) {
            u(w(ajVar));
            return true;
        }
        this.eao.add(ajVar);
        return true;
    }

    private boolean z(aj ajVar) {
        Object obj;
        StateManager aQW = this.dpy.aQW();
        this.ean = ajVar;
        synchronized (aQW) {
            WebSocketState aQK = aQW.aQK();
            if (aQK == WebSocketState.CLOSING || aQK == WebSocketState.CLOSED) {
                obj = null;
            } else {
                aQW.a(CloseInitiator.SERVER);
                this.dpy.C(ajVar);
                obj = 1;
            }
        }
        if (obj != null) {
            this.dpy.aQX().a(WebSocketState.CLOSING);
        }
        e(ajVar);
        return false;
    }

    private boolean A(aj ajVar) {
        f(ajVar);
        this.dpy.C(aj.F(ajVar.getPayload()));
        return true;
    }

    private boolean B(aj ajVar) {
        g(ajVar);
        return true;
    }

    private void aQB() {
        if (!this.eau && this.ean == null) {
            aQD();
            do {
                try {
                    aj aQA = this.dpy.aQU().aQA();
                    if (aQA.aRq()) {
                        this.ean = aQA;
                    }
                } catch (Throwable unused) {
                    return;
                }
            } while (!isInterrupted());
        }
    }

    private void aQC() {
        this.dpy.E(this.ean);
    }

    private void aQD() {
        synchronized (this.eaq) {
            aQG();
            aQE();
        }
    }

    private void aQE() {
        this.eas = new a();
        this.ear = new Timer("ReadingThreadCloseTimer");
        this.ear.schedule(this.eas, this.eat);
    }

    private void aQF() {
        synchronized (this.eaq) {
            aQG();
        }
    }

    private void aQG() {
        if (this.ear != null) {
            this.ear.cancel();
            this.ear = null;
        }
        if (this.eas != null) {
            this.eas.cancel();
            this.eas = null;
        }
    }
}
