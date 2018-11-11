package com.microblink.hardware;

import com.microblink.secured.aa;
import com.microblink.secured.u;

/* compiled from: line */
public class NativeDeviceManager {
    public long IlIllIlIIl = 0;

    private static native long nativeConstruct(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2);

    private static native void nativeDestruct(long j);

    public NativeDeviceManager(aa aaVar) {
        boolean z;
        boolean z2;
        String aPK = aa.aPK();
        String manufacturer = aa.getManufacturer();
        String model = aa.getModel();
        String aPJ = aa.aPJ();
        int aPL = aa.aPL();
        int aPM = aa.aPM();
        u aPG = aaVar.aPG();
        if (aPG == null) {
            z = false;
        } else {
            z = aaVar.a(aPG.dXp);
        }
        aPG = aaVar.aPG();
        if (aPG == null) {
            z2 = false;
        } else {
            z2 = aaVar.a(aPG.dXq);
        }
        this.IlIllIlIIl = nativeConstruct(aPK, manufacturer, model, aPJ, aPL, aPM, z, z2);
    }

    protected void finalize() {
        super.finalize();
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
        }
    }
}
