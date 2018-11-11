package com.jumio.commons.log;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileAppender {
    public static final String NEW_LINE = "\r\n";
    public static final String TAG = "JumioMobileSDK";
    private StringBuffer fileLog = null;
    private Context mContext;

    public FileAppender(Context context) {
        this.mContext = context;
    }

    public void destroy() {
        clearFileLog();
    }

    public synchronized void logString(String str, File file, String str2) {
        if (this.fileLog == null) {
            this.fileLog = new StringBuffer();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        if (str.equals("\r\n")) {
            this.fileLog.append(str);
        } else {
            StringBuffer stringBuffer = this.fileLog;
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append("\r\n");
            stringBuffer.append(str);
            stringBuffer.append("\r\n");
        }
        dumpRawBuffer(this.fileLog.toString().getBytes(), file, str2, true);
        clearFileLog();
    }

    public synchronized void dumpStringToFile(String str, File file, String str2) {
        dumpRawBuffer(str.getBytes(), file, str2, true);
    }

    private synchronized void clearFileLog() {
        if (this.fileLog != null) {
            this.fileLog.delete(0, this.fileLog.length());
        }
    }

    public synchronized void dumpBitmap(Bitmap bitmap, File file, String str, CompressFormat compressFormat, int i) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        dumpRawBuffer(byteArrayOutputStream.toByteArray(), file, str, false);
    }

    public synchronized void dumpRawBuffer(byte[] bArr, File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2, z);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Throwable e) {
            Log.printStackTrace(e);
        } catch (Throwable e2) {
            Log.printStackTrace(e2);
        } catch (Throwable th) {
            fileOutputStream.close();
        }
    }
}
