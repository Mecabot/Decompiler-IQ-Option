package com.neovisionaries.ws.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: WritingThread */
class ao extends an {
    private boolean eam;
    private aj ean;
    private final s eap;
    private final LinkedList<aj> ebx = new LinkedList();
    private boolean eby;
    private boolean mStopped;

    public ao(af afVar) {
        super("WritingThread", afVar, ThreadType.WRITING_THREAD);
        this.eap = afVar.aRg();
    }

    public void aQh() {
        try {
            aQz();
        } catch (Throwable th) {
            WebSocketError webSocketError = WebSocketError.UNEXPECTED_ERROR_IN_WRITING_THREAD;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("An uncaught throwable was detected in the writing thread: ");
            stringBuilder.append(th.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), th);
            o aQX = this.dpy.aQX();
            aQX.a(webSocketException);
            aQX.b(webSocketException);
        }
        synchronized (this) {
            this.mStopped = true;
            notifyAll();
        }
        aQC();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:14:?, code:
            fX(true);
     */
    private void aQz() {
        /*
        r3 = this;
        r0 = r3.dpy;
        r0.aRa();
    L_0x0005:
        r0 = r3.aRD();
        r1 = 1;
        if (r0 != r1) goto L_0x000d;
    L_0x000c:
        goto L_0x001d;
    L_0x000d:
        r2 = 3;
        if (r0 != r2) goto L_0x0014;
    L_0x0010:
        r3.aRC();
        goto L_0x0005;
    L_0x0014:
        r2 = 2;
        if (r0 != r2) goto L_0x0018;
    L_0x0017:
        goto L_0x0005;
    L_0x0018:
        r0 = 0;
        r3.fX(r0);	 Catch:{ WebSocketException -> 0x001d }
        goto L_0x0005;
    L_0x001d:
        r3.fX(r1);	 Catch:{ WebSocketException -> 0x0020 }
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.ao.aQz():void");
    }

    public void requestStop() {
        synchronized (this) {
            this.eam = true;
            notifyAll();
        }
    }

    public boolean K(aj ajVar) {
        synchronized (this) {
            while (true) {
                try {
                } catch (InterruptedException unused) {
                    if (this.mStopped) {
                        return false;
                    }
                    if (!this.eam && this.ean == null && !ajVar.aRt()) {
                        int aQO = this.dpy.aQO();
                        if (aQO != 0 && this.ebx.size() >= aQO) {
                            wait();
                        }
                    }
                    if (L(ajVar)) {
                        M(ajVar);
                    } else {
                        this.ebx.addLast(ajVar);
                    }
                    notifyAll();
                    return true;
                }
            }
        }
    }

    private static boolean L(aj ajVar) {
        return ajVar.aRr() || ajVar.aRs();
    }

    private void M(aj ajVar) {
        Iterator it = this.ebx.iterator();
        int i = 0;
        while (it.hasNext() && L((aj) it.next())) {
            i++;
        }
        this.ebx.add(i, ajVar);
    }

    private void aRC() {
        try {
            flush();
        } catch (IOException unused) {
        }
    }

    private void flush() {
        this.dpy.aQV().flush();
    }

    private int aRD() {
        synchronized (this) {
            if (this.eam) {
                return 1;
            } else if (this.ean != null) {
                return 1;
            } else {
                if (this.ebx.size() == 0) {
                    if (this.eby) {
                        this.eby = false;
                        return 3;
                    }
                    wait();
                }
                try {
                } catch (InterruptedException unused) {
                    if (this.eam) {
                        return 1;
                    }
                    if (this.ebx.size() != 0) {
                        return 0;
                    }
                    if (!this.eby) {
                        return 2;
                    }
                    this.eby = false;
                    return 3;
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code:
            if (fY(r5) == false) goto L_?;
     */
    /* JADX WARNING: Missing block: B:8:0x0019, code:
            doFlush();
     */
    /* JADX WARNING: Missing block: B:11:0x001e, code:
            N(r2);
     */
    /* JADX WARNING: Missing block: B:12:0x0025, code:
            if (r2.aRr() != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:14:0x002b, code:
            if (r2.aRs() == false) goto L_0x002e;
     */
    /* JADX WARNING: Missing block: B:16:0x0032, code:
            if (fY(r5) != false) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:18:0x0035, code:
            r0 = cH(r0);
     */
    /* JADX WARNING: Missing block: B:19:0x003a, code:
            doFlush();
            r0 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Missing block: B:33:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:34:?, code:
            return;
     */
    private void fX(boolean r5) {
        /*
        r4 = this;
        r0 = java.lang.System.currentTimeMillis();
    L_0x0004:
        monitor-enter(r4);
        r2 = r4.ebx;	 Catch:{ all -> 0x0042 }
        r2 = r2.poll();	 Catch:{ all -> 0x0042 }
        r2 = (com.neovisionaries.ws.client.aj) r2;	 Catch:{ all -> 0x0042 }
        r4.notifyAll();	 Catch:{ all -> 0x0042 }
        if (r2 != 0) goto L_0x001d;
    L_0x0012:
        monitor-exit(r4);	 Catch:{ all -> 0x0042 }
        r5 = r4.fY(r5);
        if (r5 == 0) goto L_0x001c;
    L_0x0019:
        r4.doFlush();
    L_0x001c:
        return;
    L_0x001d:
        monitor-exit(r4);	 Catch:{ all -> 0x0042 }
        r4.N(r2);
        r3 = r2.aRr();
        if (r3 != 0) goto L_0x003a;
    L_0x0027:
        r2 = r2.aRs();
        if (r2 == 0) goto L_0x002e;
    L_0x002d:
        goto L_0x003a;
    L_0x002e:
        r2 = r4.fY(r5);
        if (r2 != 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0004;
    L_0x0035:
        r0 = r4.cH(r0);
        goto L_0x0004;
    L_0x003a:
        r4.doFlush();
        r0 = java.lang.System.currentTimeMillis();
        goto L_0x0004;
    L_0x0042:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0042 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.ao.fX(boolean):void");
    }

    private boolean fY(boolean z) {
        return z || this.dpy.aQM() || this.eby || this.ean != null;
    }

    private long cH(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (1000 >= currentTimeMillis - j) {
            return j;
        }
        doFlush();
        return currentTimeMillis;
    }

    private void doFlush() {
        try {
            flush();
            synchronized (this) {
                this.eby = false;
            }
        } catch (Throwable e) {
            WebSocketError webSocketError = WebSocketError.FLUSH_ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Flushing frames to the server failed: ");
            stringBuilder.append(e.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), e);
            o aQX = this.dpy.aQX();
            aQX.a(webSocketException);
            aQX.b(webSocketException, null);
            throw webSocketException;
        }
    }

    private void N(aj ajVar) {
        Object obj;
        ajVar = aj.a(ajVar, this.eap);
        this.dpy.aQX().h(ajVar);
        if (this.ean != null) {
            obj = 1;
        } else {
            if (ajVar.aRq()) {
                this.ean = ajVar;
            }
            obj = null;
        }
        if (obj != null) {
            this.dpy.aQX().j(ajVar);
            return;
        }
        if (ajVar.aRq()) {
            aRE();
        }
        try {
            this.dpy.aQV().G(ajVar);
            this.dpy.aQX().i(ajVar);
        } catch (Throwable e) {
            WebSocketError webSocketError = WebSocketError.IO_ERROR_IN_WRITING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("An I/O error occurred when a frame was tried to be sent: ");
            stringBuilder.append(e.getMessage());
            WebSocketException webSocketException = new WebSocketException(webSocketError, stringBuilder.toString(), e);
            o aQX = this.dpy.aQX();
            aQX.a(webSocketException);
            aQX.b(webSocketException, ajVar);
            throw webSocketException;
        }
    }

    private void aRE() {
        Object obj;
        StateManager aQW = this.dpy.aQW();
        synchronized (aQW) {
            WebSocketState aQK = aQW.aQK();
            if (aQK == WebSocketState.CLOSING || aQK == WebSocketState.CLOSED) {
                obj = null;
            } else {
                aQW.a(CloseInitiator.CLIENT);
                obj = 1;
            }
        }
        if (obj != null) {
            this.dpy.aQX().a(WebSocketState.CLOSING);
        }
    }

    private void aQC() {
        this.dpy.F(this.ean);
    }
}
