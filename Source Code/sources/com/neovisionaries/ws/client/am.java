package com.neovisionaries.ws.client;

import android.support.v4.internal.view.SupportMenu;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: WebSocketOutputStream */
class am extends FilterOutputStream {
    public am(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(String str) {
        write(p.kK(str));
    }

    public void G(aj ajVar) {
        H(ajVar);
        I(ajVar);
        J(ajVar);
        byte[] ih = p.ih(4);
        write(ih);
        a(ajVar, ih);
    }

    private void H(aj ajVar) {
        int i = 0;
        int i2 = ((ajVar.aRj() ? 128 : 0) | (ajVar.aRk() ? 64 : 0)) | (ajVar.aRl() ? 32 : 0);
        if (ajVar.aRm()) {
            i = 16;
        }
        write((ajVar.getOpcode() & 15) | (i2 | i));
    }

    private void I(aj ajVar) {
        int payloadLength = ajVar.getPayloadLength();
        payloadLength = payloadLength <= 125 ? payloadLength | 128 : payloadLength <= SupportMenu.USER_MASK ? 254 : 255;
        write(payloadLength);
    }

    private void J(aj ajVar) {
        int payloadLength = ajVar.getPayloadLength();
        if (payloadLength > 125) {
            if (payloadLength <= SupportMenu.USER_MASK) {
                write((payloadLength >> 8) & 255);
                write(payloadLength & 255);
                return;
            }
            write(0);
            write(0);
            write(0);
            write(0);
            write((payloadLength >> 24) & 255);
            write((payloadLength >> 16) & 255);
            write((payloadLength >> 8) & 255);
            write(payloadLength & 255);
        }
    }

    private void a(aj ajVar, byte[] bArr) {
        byte[] payload = ajVar.getPayload();
        if (payload != null) {
            for (int i = 0; i < payload.length; i++) {
                write((payload[i] ^ bArr[i % 4]) & 255);
            }
        }
    }
}
