package com.crashlytics.android.ndk;

import android.content.res.AssetManager;

class JniNativeApi implements d {
    private native boolean nativeInit(String str, Object obj);

    JniNativeApi() {
    }

    static {
        System.loadLibrary("crashlytics");
    }

    public boolean a(String str, AssetManager assetManager) {
        return nativeInit(str, assetManager);
    }
}
