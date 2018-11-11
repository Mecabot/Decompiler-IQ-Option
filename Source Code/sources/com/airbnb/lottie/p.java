package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

/* compiled from: LottieImageAsset */
public class p {
    private final String fileName;
    private final int height;
    private final String id;
    private final String jM;
    private final int width;

    @RestrictTo({Scope.LIBRARY})
    public p(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.jM = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }
}
