package com.google.zxing.qrcode.a;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.a;

/* compiled from: QRCode */
public final class f {
    private Mode adt;
    private ErrorCorrectionLevel adu;
    private a adv;
    private int adw = -1;
    private b adx;

    public static boolean cn(int i) {
        return i >= 0 && i < 8;
    }

    public b zs() {
        return this.adx;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.adt);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.adu);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.adv);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.adw);
        if (this.adx == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.adx);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }

    public void a(Mode mode) {
        this.adt = mode;
    }

    public void b(ErrorCorrectionLevel errorCorrectionLevel) {
        this.adu = errorCorrectionLevel;
    }

    public void a(a aVar) {
        this.adv = aVar;
    }

    public void cm(int i) {
        this.adw = i;
    }

    public void k(b bVar) {
        this.adx = bVar;
    }
}
