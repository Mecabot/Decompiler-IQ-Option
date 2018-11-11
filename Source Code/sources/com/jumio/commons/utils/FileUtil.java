package com.jumio.commons.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileUtil {
    public static byte[] readFile(String str) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            long length = randomAccessFile.length();
            int i = (int) length;
            if (((long) i) != length) {
                throw new IOException("File size >= 2 GB");
            }
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            return bArr;
        } finally {
            randomAccessFile.close();
        }
    }

    public static byte[] mergeBitmaps(String str, String str2, CompressFormat compressFormat, int i) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Bitmap decodeFile2 = BitmapFactory.decodeFile(str2);
        int width = decodeFile.getWidth() + decodeFile2.getWidth();
        int height = decodeFile.getHeight();
        if (decodeFile2.getHeight() > height) {
            height = decodeFile2.getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(decodeFile, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeFile2, (float) decodeFile.getWidth(), 0.0f, null);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(compressFormat, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        return file.exists() ? file.delete() : false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019  */
    public static boolean saveToFile(byte[] r3, java.io.File r4) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x001d, all -> 0x0016 }
        r2.<init>(r4, r0);	 Catch:{ IOException -> 0x001d, all -> 0x0016 }
        r2.write(r3);	 Catch:{ IOException -> 0x0014, all -> 0x0011 }
        if (r2 == 0) goto L_0x000f;
    L_0x000c:
        com.jumio.commons.utils.IOUtils.closeQuietly(r2);
    L_0x000f:
        r0 = 1;
        goto L_0x0022;
    L_0x0011:
        r3 = move-exception;
        r1 = r2;
        goto L_0x0017;
    L_0x0014:
        r1 = r2;
        goto L_0x001d;
    L_0x0016:
        r3 = move-exception;
    L_0x0017:
        if (r1 == 0) goto L_0x001c;
    L_0x0019:
        com.jumio.commons.utils.IOUtils.closeQuietly(r1);
    L_0x001c:
        throw r3;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        com.jumio.commons.utils.IOUtils.closeQuietly(r1);
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.FileUtil.saveToFile(byte[], java.io.File):boolean");
    }
}
