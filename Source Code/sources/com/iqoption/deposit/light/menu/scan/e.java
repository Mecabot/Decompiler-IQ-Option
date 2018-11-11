package com.iqoption.deposit.light.menu.scan;

import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] aoS = new int[ScanItem.values().length];

    static {
        aoS[ScanItem.CAMERA.ordinal()] = 1;
        aoS[ScanItem.NFC.ordinal()] = 2;
    }
}
