package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.v4.internal.view.SupportMenu;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class GifInfoHandle {
    private volatile long fkM;

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    static native long openByteArray(byte[] bArr);

    static native long openDirectByteBuffer(ByteBuffer byteBuffer);

    static native long openFd(FileDescriptor fileDescriptor, long j);

    static native long openFile(String str);

    static native long openStream(InputStream inputStream);

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    static {
        g.cU(null);
    }

    GifInfoHandle() {
    }

    GifInfoHandle(String str) {
        this.fkM = openFile(str);
    }

    GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.fkM = openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused2) {
                throw th;
            }
        }
    }

    static GifInfoHandle a(ContentResolver contentResolver, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        return new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    synchronized long c(Bitmap bitmap) {
        return renderFrame(this.fkM, bitmap);
    }

    synchronized void recycle() {
        free(this.fkM);
        this.fkM = 0;
    }

    synchronized long bFG() {
        return restoreRemainder(this.fkM);
    }

    synchronized boolean reset() {
        return reset(this.fkM);
    }

    synchronized void bFH() {
        saveRemainder(this.fkM);
    }

    synchronized int getLoopCount() {
        return getLoopCount(this.fkM);
    }

    void setLoopCount(@IntRange(from = 0, to = 65535) int i) {
        if (i < 0 || i > SupportMenu.USER_MASK) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.fkM, (char) i);
        }
    }

    synchronized int bFI() {
        return getNativeErrorCode(this.fkM);
    }

    synchronized int getDuration() {
        return getDuration(this.fkM);
    }

    synchronized int getCurrentPosition() {
        return getCurrentPosition(this.fkM);
    }

    synchronized int bFE() {
        return getCurrentFrameIndex(this.fkM);
    }

    synchronized int bFF() {
        return getCurrentLoop(this.fkM);
    }

    synchronized void a(@IntRange(from = 0, to = 2147483647L) int i, Bitmap bitmap) {
        seekToTime(this.fkM, i, bitmap);
    }

    synchronized boolean isRecycled() {
        return this.fkM == 0;
    }

    protected void finalize() {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    synchronized long[] bFJ() {
        return getSavedState(this.fkM);
    }

    synchronized int a(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.fkM, jArr, bitmap);
    }

    synchronized int getWidth() {
        return getWidth(this.fkM);
    }

    synchronized int getHeight() {
        return getHeight(this.fkM);
    }

    synchronized int getNumberOfFrames() {
        return getNumberOfFrames(this.fkM);
    }

    synchronized boolean isOpaque() {
        return isOpaque(this.fkM);
    }
}
