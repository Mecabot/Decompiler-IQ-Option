package com.facebook.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/* compiled from: NativeAppCallAttachmentStore */
public final class r {
    private static File Ed = null;
    private static final String TAG = "com.facebook.internal.r";

    private r() {
    }

    public static void b(UUID uuid) {
        File a = a(uuid, false);
        if (a != null) {
            w.deleteDirectory(a);
        }
    }

    public static File a(UUID uuid, String str) {
        if (w.bc(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return a(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    static File a(UUID uuid, boolean z) {
        if (Ed == null) {
            return null;
        }
        File file = new File(Ed, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static File a(UUID uuid, String str, boolean z) {
        File a = a(uuid, z);
        if (a == null) {
            return null;
        }
        try {
            return new File(a, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
