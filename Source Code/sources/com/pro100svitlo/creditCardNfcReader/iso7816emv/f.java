package com.pro100svitlo.creditCardNfcReader.iso7816emv;

import com.pro100svitlo.creditCardNfcReader.a.a;
import java.util.Arrays;

/* compiled from: TerminalTransactionQualifiers */
public class f {
    private byte[] data = new byte[4];

    public void fZ(boolean z) {
        this.data[0] = a.a(this.data[0], 5, z);
    }

    public void ga(boolean z) {
        this.data[0] = a.a(this.data[0], 3, z);
    }

    public byte[] getBytes() {
        return Arrays.copyOf(this.data, this.data.length);
    }
}
