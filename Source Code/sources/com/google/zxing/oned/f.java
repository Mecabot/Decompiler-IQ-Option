package com.google.zxing.oned;

import com.jumio.analytics.MobileEvents;

/* compiled from: Code93Reader */
public final class f extends m {
    private static final char[] acm = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final int[] acn;
    private static final int acu;

    static {
        int[] iArr = new int[]{276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, MobileEvents.EVENTTYPE_SDKLIFECYCLE, 468, 466, 458, 366, 374, 430, 294, 474, 470, MobileEvents.EVENTTYPE_SDKPARAMETERS, 350};
        acn = iArr;
        acu = iArr[47];
    }
}
