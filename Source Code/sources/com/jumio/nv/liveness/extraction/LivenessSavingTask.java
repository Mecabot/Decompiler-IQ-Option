package com.jumio.nv.liveness.extraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import com.google.android.gms.vision.Frame;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LivenessSavingTask extends Thread {
    private boolean active;
    private LinkedList<String> cache = new LinkedList();
    private Rect extractionArea;
    private File folder;
    private boolean isPortrait;
    private int maxFrames;
    private int numberOfFrames;
    private PreviewProperties previewProperties;
    private Queue<Frame> queue = new ConcurrentLinkedQueue();
    private long timestamp;

    public LivenessSavingTask(Context context, int i, int i2) {
        this.folder = Environment.getDataDirectory(context);
        this.numberOfFrames = i;
        this.maxFrames = i2;
        reset();
    }

    public void init(PreviewProperties previewProperties, Rect rect, boolean z) {
        this.previewProperties = previewProperties;
        this.extractionArea = rect;
        this.isPortrait = z;
    }

    public void reset() {
        this.queue.clear();
        this.cache.clear();
        System.gc();
    }

    public void add(Frame frame) {
        try {
            if (this.numberOfFrames != 0 && this.previewProperties != null && this.extractionArea != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!isInterrupted() && currentTimeMillis - this.timestamp >= 500 && isActive()) {
                    this.timestamp = currentTimeMillis;
                    this.queue.add(frame);
                }
            }
        } catch (Throwable e) {
            this.queue.clear();
            Log.printStackTrace(e);
            System.gc();
        }
    }

    public String[] finish() {
        int i = 0;
        setActive(false);
        String[] strArr;
        if (this.cache.size() <= this.numberOfFrames) {
            strArr = new String[this.cache.size()];
            while (i < this.cache.size()) {
                strArr[(this.cache.size() - 1) - i] = (String) this.cache.get(i);
                i++;
            }
            return strArr;
        }
        int i2;
        strArr = new String[this.numberOfFrames];
        int i3 = this.numberOfFrames / 2;
        int i4 = this.numberOfFrames - 1;
        int i5 = 0;
        while (i5 < i3) {
            i2 = i4 - 1;
            strArr[i4] = (String) this.cache.get(i5);
            i5++;
            i4 = i2;
        }
        i3 = (this.numberOfFrames / 2) + (this.numberOfFrames % 2);
        i5 = ((this.cache.size() - 1) - i3) / i3;
        i4 = this.cache.size() - 1;
        while (i4 >= i3 && i < i3) {
            i2 = i + 1;
            strArr[i] = (String) this.cache.get(i4);
            i4 -= i5;
            i = i2;
        }
        return strArr;
    }

    public void run() {
        int i;
        Throwable e;
        int i2 = 0;
        while (!isInterrupted()) {
            Frame frame = (Frame) this.queue.poll();
            if (frame != null) {
                try {
                    String str = "tmp_%04d";
                    Object[] objArr = new Object[1];
                    i = i2 + 1;
                    try {
                        objArr[0] = Integer.valueOf(i2);
                        String format = String.format(str, objArr);
                        dumpBitmap(CameraUtils.yuv2bitmap(frame.getGrayscaleImageData().array(), this.isPortrait, this.previewProperties, this.extractionArea, 640), this.folder, format, CompressFormat.JPEG, 70);
                        LinkedList linkedList = this.cache;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.folder.getAbsolutePath());
                        stringBuilder.append("/");
                        stringBuilder.append(format);
                        linkedList.addFirst(stringBuilder.toString());
                        if (this.cache.size() > this.maxFrames) {
                            new File(this.folder, (String) this.cache.removeLast()).delete();
                        }
                        System.gc();
                    } catch (Exception e2) {
                        e = e2;
                        Log.printStackTrace(e);
                        i2 = i;
                    }
                } catch (Throwable e3) {
                    i = i2;
                    e = e3;
                    Log.printStackTrace(e);
                    i2 = i;
                }
                i2 = i;
            }
        }
        reset();
    }

    private void dumpBitmap(Bitmap bitmap, File file, String str, CompressFormat compressFormat, int i) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        dumpRawBuffer(byteArrayOutputStream.toByteArray(), file, str, false);
    }

    private void dumpRawBuffer(byte[] bArr, File file, String str, boolean z) {
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

    public synchronized boolean isActive() {
        return this.active;
    }

    public synchronized void setActive(boolean z) {
        this.active = z;
    }
}
