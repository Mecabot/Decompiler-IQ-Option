package com.microblink.secured;

import android.content.res.AssetManager;
import com.microblink.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: line */
public class ai {
    public static boolean a(AssetManager assetManager, String str, String str2) {
        try {
            File file = new File(str2);
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                Log.a("Copy", file.toString(), new Object[0]);
                InputStream open = assetManager.open(str);
                OutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                open.close();
            }
            return true;
        } catch (Exception unused) {
            Log.a(ai.class, "File copy failed!", new Object[0]);
            return false;
        }
    }

    public static void v(File file) {
        if (file.isDirectory()) {
            for (File v : file.listFiles()) {
                v(v);
            }
        }
        try {
            Log.a("Delete", file.toString(), new Object[0]);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            Log.a(ai.class, "Failed to delete file", e.getMessage());
        }
    }
}
