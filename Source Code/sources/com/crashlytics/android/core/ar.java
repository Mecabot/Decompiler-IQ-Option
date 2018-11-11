package com.crashlytics.android.core;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: Sha1FileIdStrategy */
class ar implements a {
    ar() {
    }

    public String d(File file) {
        return bl(file.getPath());
    }

    private static String bl(String str) {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                str = CommonUtils.i(bufferedInputStream);
                CommonUtils.closeQuietly(bufferedInputStream);
                return str;
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedInputStream;
                CommonUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeQuietly(closeable);
            throw th;
        }
    }
}
