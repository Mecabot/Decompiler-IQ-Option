package com.iqoption.kyc;

import android.content.Context;
import com.iqoption.app.a;

/* compiled from: KycUtils */
public final class h {
    public static boolean bv(Context context) {
        a aL = a.aL(context);
        return aL.Dh() && !aL.CZ() && aL.CB() > 0.0d && ((aL.akz && !aL.akD) || !(!aL.akB || aL.akI || aL.akF));
    }
}
