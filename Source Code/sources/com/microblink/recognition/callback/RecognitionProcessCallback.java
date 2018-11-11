package com.microblink.recognition.callback;

import android.support.annotation.Keep;
import com.microblink.a.a;
import com.microblink.a.b;
import com.microblink.a.d;
import com.microblink.a.e;
import com.microblink.a.f;
import com.microblink.detectors.DetectorResult;
import com.microblink.geometry.c;
import com.microblink.image.Image;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.secured.i;

/* compiled from: line */
public final class RecognitionProcessCallback {
    private long IlIllIlIIl = 0;
    private d dUd = null;
    private e dVp = null;
    private boolean dVq = true;
    private NativeRecognizerWrapper dVr;

    private native long nativeConstruct(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i);

    private static native void nativeDestruct(long j);

    private static native void nativeSetMirrorType(long j, int i);

    private static native void nativeSetPaused(long j, boolean z);

    private static native void nativeSetScanningRegion(long j, float f, float f2, float f3, float f4);

    public RecognitionProcessCallback(e eVar, d dVar, c cVar, int i) {
        e eVar2;
        d dVar2 = dVar;
        if (eVar == null || dVar2 == null) {
            eVar2 = new e();
        } else {
            eVar2 = eVar;
        }
        this.dVp = eVar2;
        this.dUd = dVar2;
        this.IlIllIlIIl = nativeConstruct(this.dVp.aOP(), this.dVp.aOR(), this.dVp.aOS(), this.dVp.aOT(), this.dVp.aOU().aOV(), this.dVp.aOU().aOW(), this.dVp.aOU().aOX(), this.dVp.aOU().aOY().aPa(), this.dVp.aOU().aOY().aOZ(), this.dVp.aOU().aOY().aOW(), this.dVp.aOU().aOY().aPb(), i);
        a(cVar);
    }

    @Keep
    public final void onDetectionFailed() {
        this.dUd.a(new a(null));
    }

    public final long getNativeContext() {
        return this.IlIllIlIIl;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            cVar = c.aOF();
        }
        nativeSetScanningRegion(this.IlIllIlIIl, cVar.getX(), cVar.getY(), cVar.getWidth(), cVar.getHeight());
    }

    public final void a(NativeRecognizerWrapper nativeRecognizerWrapper) {
        this.dVr = nativeRecognizerWrapper;
    }

    @Keep
    public final void onMetadataAvailable(int i, Object obj) {
        com.microblink.a.c bVar;
        if (i == 4) {
            if (this.dVr != null) {
                this.dVr.IIlIlllIIl();
            }
            if (this.dVp == null || !this.dVp.aOQ()) {
                return;
            }
        }
        if (i != 3) {
            switch (i) {
                case 0:
                    bVar = new b((Image) obj);
                    break;
                case 1:
                    bVar = new f((String) obj);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Internal error: Cannot build metadata for type ");
                    stringBuilder.append(obj.getClass().getName());
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        bVar = new a((DetectorResult) obj);
        this.dUd.a(bVar);
        if (i == 0) {
            ((Image) obj).dispose();
        }
    }

    public final void fK(boolean z) {
        this.dVq = z;
        nativeSetPaused(this.IlIllIlIIl, z);
    }

    public final boolean isPaused() {
        return this.dVq;
    }

    public final void dispose() {
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
            this.IlIllIlIIl = 0;
        }
    }

    protected final void finalize() {
        super.finalize();
        dispose();
    }

    static {
        i.aPu();
    }
}
