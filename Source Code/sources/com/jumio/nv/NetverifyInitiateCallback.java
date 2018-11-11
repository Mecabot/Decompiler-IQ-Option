package com.jumio.nv;

public interface NetverifyInitiateCallback {
    void onNetverifyInitiateError(int i, int i2, String str, boolean z);

    void onNetverifyInitiateSuccess();
}
