package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.widget.MediaController.MediaPlayerControl;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.a.a;

/* compiled from: GifDrawable */
public class b extends Drawable implements Animatable, MediaPlayerControl {
    final GifInfoHandle fkA;
    final ConcurrentLinkedQueue<a> fkB;
    final boolean fkC;
    final f fkD;
    private final j fkE;
    private final Rect fkF;
    ScheduledFuture<?> fkG;
    private int fkH;
    private int fkI;
    private a fkJ;
    final ScheduledThreadPoolExecutor fkw;
    volatile boolean fkx;
    long fky;
    final Bitmap fkz;
    private final Rect mDstRect;
    protected final Paint mPaint;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private Mode mTintMode;

    public boolean canPause() {
        return true;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public b(@NonNull Resources resources, @RawRes @DrawableRes int i) {
        this(resources.openRawResourceFd(i));
        float a = e.a(resources, i);
        this.fkI = (int) (((float) this.fkA.getHeight()) * a);
        this.fkH = (int) (((float) this.fkA.getWidth()) * a);
    }

    public b(@NonNull AssetFileDescriptor assetFileDescriptor) {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public b(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
        this(GifInfoHandle.a(contentResolver, uri), null, null, true);
    }

    b(GifInfoHandle gifInfoHandle, b bVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.fkx = true;
        this.fky = Long.MIN_VALUE;
        this.mDstRect = new Rect();
        this.mPaint = new Paint(6);
        this.fkB = new ConcurrentLinkedQueue();
        this.fkE = new j(this);
        this.fkC = z;
        if (scheduledThreadPoolExecutor == null) {
            scheduledThreadPoolExecutor = c.bFK();
        }
        this.fkw = scheduledThreadPoolExecutor;
        this.fkA = gifInfoHandle;
        Bitmap bitmap = null;
        if (bVar != null) {
            synchronized (bVar.fkA) {
                if (!bVar.fkA.isRecycled() && bVar.fkA.getHeight() >= this.fkA.getHeight() && bVar.fkA.getWidth() >= this.fkA.getWidth()) {
                    bVar.shutdown();
                    Bitmap bitmap2 = bVar.fkz;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.fkz = Bitmap.createBitmap(this.fkA.getWidth(), this.fkA.getHeight(), Config.ARGB_8888);
        } else {
            this.fkz = bitmap;
        }
        this.fkz.setHasAlpha(gifInfoHandle.isOpaque() ^ true);
        this.fkF = new Rect(0, 0, this.fkA.getWidth(), this.fkA.getHeight());
        this.fkD = new f(this);
        this.fkE.doWork();
        this.fkH = this.fkA.getWidth();
        this.fkI = this.fkA.getHeight();
    }

    private void shutdown() {
        this.fkx = false;
        this.fkD.removeMessages(-1);
        this.fkA.recycle();
    }

    public boolean isRecycled() {
        return this.fkA.isRecycled();
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        bFD();
    }

    public int getIntrinsicHeight() {
        return this.fkI;
    }

    public int getIntrinsicWidth() {
        return this.fkH;
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return (!this.fkA.isOpaque() || this.mPaint.getAlpha() < 255) ? -2 : -1;
    }

    public void start() {
        synchronized (this) {
            if (this.fkx) {
                return;
            }
            this.fkx = true;
            el(this.fkA.bFG());
        }
    }

    void el(long j) {
        if (this.fkC) {
            this.fky = 0;
            this.fkD.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        bFC();
        this.fkG = this.fkw.schedule(this.fkE, Math.max(j, 0), TimeUnit.MILLISECONDS);
    }

    public void reset() {
        this.fkw.execute(new k(this) {
            public void doWork() {
                if (b.this.fkA.reset()) {
                    b.this.start();
                }
            }
        });
    }

    public void stop() {
        synchronized (this) {
            if (this.fkx) {
                this.fkx = false;
                bFC();
                this.fkA.bFH();
                return;
            }
        }
    }

    private void bFC() {
        if (this.fkG != null) {
            this.fkG.cancel(false);
        }
        this.fkD.removeMessages(-1);
    }

    public boolean isRunning() {
        return this.fkx;
    }

    public void setLoopCount(@IntRange(from = 0, to = 65535) int i) {
        this.fkA.setLoopCount(i);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.fkA.getWidth()), Integer.valueOf(this.fkA.getHeight()), Integer.valueOf(this.fkA.getNumberOfFrames()), Integer.valueOf(this.fkA.bFI())});
    }

    public int getNumberOfFrames() {
        return this.fkA.getNumberOfFrames();
    }

    public void pause() {
        stop();
    }

    public int getDuration() {
        return this.fkA.getDuration();
    }

    public int getCurrentPosition() {
        return this.fkA.getCurrentPosition();
    }

    public void seekTo(@IntRange(from = 0, to = 2147483647L) final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.fkw.execute(new k(this) {
            public void doWork() {
                b.this.fkA.a(i, b.this.fkz);
                this.fkX.fkD.sendEmptyMessageAtTime(-1, 0);
            }
        });
    }

    public boolean isPlaying() {
        return this.fkx;
    }

    public boolean canSeekBackward() {
        return getNumberOfFrames() > 1;
    }

    public boolean canSeekForward() {
        return getNumberOfFrames() > 1;
    }

    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
        if (this.fkJ != null) {
            this.fkJ.onBoundsChange(rect);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        Object obj;
        if (this.mTintFilter == null || this.mPaint.getColorFilter() != null) {
            obj = null;
        } else {
            this.mPaint.setColorFilter(this.mTintFilter);
            obj = 1;
        }
        if (this.fkJ == null) {
            canvas.drawBitmap(this.fkz, this.fkF, this.mDstRect, this.mPaint);
        } else {
            this.fkJ.a(canvas, this.mPaint, this.fkz);
        }
        if (obj != null) {
            this.mPaint.setColorFilter(null);
        }
    }

    private void bFD() {
        if (this.fkC && this.fkx && this.fky != Long.MIN_VALUE) {
            long max = Math.max(0, this.fky - SystemClock.uptimeMillis());
            this.fky = Long.MIN_VALUE;
            this.fkw.remove(this.fkE);
            this.fkG = this.fkw.schedule(this.fkE, max, TimeUnit.MILLISECONDS);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    @Deprecated
    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = a(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    public void setTintMode(@NonNull Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = a(this.mTint, mode);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.mTint == null || this.mTintMode == null) {
            return false;
        }
        this.mTintFilter = a(this.mTint, this.mTintMode);
        return true;
    }

    public boolean isStateful() {
        return super.isStateful() || (this.mTint != null && this.mTint.isStateful());
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.fkC) {
            if (z) {
                if (z2) {
                    reset();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public int bFE() {
        return this.fkA.bFE();
    }

    public int bFF() {
        int bFF = this.fkA.bFF();
        return (bFF == 0 || bFF < this.fkA.getLoopCount()) ? bFF : bFF - 1;
    }
}
