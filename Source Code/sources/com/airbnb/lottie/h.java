package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.c.t;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.model.layer.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: LottieDrawable */
public class h extends Drawable implements Animatable, Callback {
    private static final String TAG = "h";
    private int alpha = 255;
    @Nullable
    b jA;
    @Nullable
    w jB;
    private boolean jC;
    @Nullable
    private c jD;
    private boolean jE;
    private g ja;
    @Nullable
    private String ji;
    private final com.airbnb.lottie.d.c jt = new com.airbnb.lottie.d.c();
    private float ju = 1.0f;
    private final Set<Object> jv = new HashSet();
    private final ArrayList<a> jw = new ArrayList();
    @Nullable
    private b jx;
    @Nullable
    private c jy;
    @Nullable
    private com.airbnb.lottie.b.a jz;
    private final Matrix matrix = new Matrix();

    /* compiled from: LottieDrawable */
    private interface a {
        void e(g gVar);
    }

    public int getOpacity() {
        return -3;
    }

    public h() {
        this.jt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.jD != null) {
                    h.this.jD.setProgress(h.this.jt.fh());
                }
            }
        });
    }

    public boolean dh() {
        return this.jC;
    }

    public void v(boolean z) {
        if (VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.jC = z;
        if (this.ja != null) {
            di();
        }
    }

    public void aa(@Nullable String str) {
        this.ji = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.ji;
    }

    public void recycleBitmaps() {
        if (this.jx != null) {
            this.jx.recycleBitmaps();
        }
    }

    public boolean b(g gVar) {
        if (this.ja == gVar) {
            return false;
        }
        cX();
        this.ja = gVar;
        di();
        this.jt.setComposition(gVar);
        a(this.jt.getAnimatedFraction());
        setScale(this.ju);
        dm();
        Iterator it = new ArrayList(this.jw).iterator();
        while (it.hasNext()) {
            ((a) it.next()).e(gVar);
            it.remove();
        }
        this.jw.clear();
        gVar.setPerformanceTrackingEnabled(this.jE);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.jE = z;
        if (this.ja != null) {
            this.ja.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public s getPerformanceTracker() {
        return this.ja != null ? this.ja.getPerformanceTracker() : null;
    }

    private void di() {
        this.jD = new c(this, t.g(this.ja), this.ja.dc(), this.ja);
    }

    public void cX() {
        recycleBitmaps();
        if (this.jt.isRunning()) {
            this.jt.cancel();
        }
        this.ja = null;
        this.jD = null;
        this.jx = null;
        this.jt.cX();
        invalidateSelf();
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.alpha = i;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void draw(@NonNull Canvas canvas) {
        d.beginSection("Drawable#draw");
        if (this.jD != null) {
            float f = this.ju;
            float d = d(canvas);
            if (f > d) {
                f = this.ju / d;
            } else {
                d = f;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = ((float) this.ja.getBounds().width()) / 2.0f;
                float height = ((float) this.ja.getBounds().height()) / 2.0f;
                float f2 = width * d;
                float f3 = height * d;
                canvas.translate((getScale() * width) - f2, (getScale() * height) - f3);
                canvas.scale(f, f, f2, f3);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.jD.a(canvas, this.matrix, this.alpha);
            d.X("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void start() {
        d();
    }

    public void stop() {
        dj();
    }

    public boolean isRunning() {
        return isAnimating();
    }

    /* renamed from: cT */
    public void d() {
        if (this.jD == null) {
            this.jw.add(new i(this));
        } else {
            this.jt.cT();
        }
    }

    public void dj() {
        this.jw.clear();
        this.jt.dj();
    }

    /* renamed from: cU */
    public void c() {
        if (this.jD == null) {
            this.jw.add(new j(this));
        } else {
            this.jt.cU();
        }
    }

    public void setMinFrame(int i) {
        this.jt.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.jt.getMinFrame();
    }

    /* renamed from: setMinProgress */
    public void c(float f) {
        if (this.ja == null) {
            this.jw.add(new k(this, f));
        } else {
            setMinFrame((int) e.lerp(this.ja.da(), this.ja.db(), f));
        }
    }

    public void setMaxFrame(int i) {
        this.jt.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.jt.getMaxFrame();
    }

    /* renamed from: setMaxProgress */
    public void b(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.ja == null) {
            this.jw.add(new l(this, f));
        } else {
            setMaxFrame((int) e.lerp(this.ja.da(), this.ja.db(), f));
        }
    }

    public void setSpeed(float f) {
        this.jt.setSpeed(f);
    }

    public float getSpeed() {
        return this.jt.getSpeed();
    }

    public void a(AnimatorListener animatorListener) {
        this.jt.addListener(animatorListener);
    }

    public void b(AnimatorListener animatorListener) {
        this.jt.removeListener(animatorListener);
    }

    /* renamed from: setFrame */
    public void a(int i) {
        if (this.ja == null) {
            this.jw.add(new m(this, i));
        } else {
            this.jt.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.jt.fi();
    }

    /* renamed from: setProgress */
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.ja == null) {
            this.jw.add(new n(this, f));
        } else {
            a((int) e.lerp(this.ja.da(), this.ja.db(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.jt.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.jt.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.jt.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.jt.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.jt.isRunning();
    }

    public void setScale(float f) {
        this.ju = f;
        dm();
    }

    public void setImageAssetDelegate(c cVar) {
        this.jy = cVar;
        if (this.jx != null) {
            this.jx.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.jA = bVar;
        if (this.jz != null) {
            this.jz.a(bVar);
        }
    }

    public void setTextDelegate(w wVar) {
        this.jB = wVar;
    }

    @Nullable
    public w dk() {
        return this.jB;
    }

    public boolean dl() {
        return this.jB == null && this.ja.dd().size() > 0;
    }

    public float getScale() {
        return this.ju;
    }

    public g getComposition() {
        return this.ja;
    }

    private void dm() {
        if (this.ja != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (((float) this.ja.getBounds().width()) * scale), (int) (((float) this.ja.getBounds().height()) * scale));
        }
    }

    public void cV() {
        this.jw.clear();
        this.jt.cancel();
    }

    public void cW() {
        this.jw.clear();
        this.jt.cW();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.jt.fh();
    }

    public int getIntrinsicWidth() {
        return this.ja == null ? -1 : (int) (((float) this.ja.getBounds().width()) * getScale());
    }

    public int getIntrinsicHeight() {
        return this.ja == null ? -1 : (int) (((float) this.ja.getBounds().height()) * getScale());
    }

    public List<com.airbnb.lottie.model.e> a(com.airbnb.lottie.model.e eVar) {
        if (this.jD == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        List<com.airbnb.lottie.model.e> arrayList = new ArrayList();
        this.jD.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void a(com.airbnb.lottie.model.e eVar, T t, com.airbnb.lottie.e.c<T> cVar) {
        if (this.jD == null) {
            this.jw.add(new o(this, eVar, t, cVar));
            return;
        }
        int i = 1;
        if (eVar.dU() != null) {
            eVar.dU().a(t, cVar);
        } else {
            List a = a(eVar);
            for (int i2 = 0; i2 < a.size(); i2++) {
                ((com.airbnb.lottie.model.e) a.get(i2)).dU().a(t, cVar);
            }
            i = 1 ^ a.isEmpty();
        }
        if (i != 0) {
            invalidateSelf();
            if (t == q.kj) {
                a(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap ab(String str) {
        b dn = dn();
        return dn != null ? dn.ae(str) : null;
    }

    private b dn() {
        if (getCallback() == null) {
            return null;
        }
        if (!(this.jx == null || this.jx.l(getContext()))) {
            this.jx.recycleBitmaps();
            this.jx = null;
        }
        if (this.jx == null) {
            this.jx = new b(getCallback(), this.ji, this.jy, this.ja.df());
        }
        return this.jx;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a aVar = do();
        return aVar != null ? aVar.g(str, str2) : null;
    }

    private com.airbnb.lottie.b.a do() {
        if (getCallback() == null) {
            return null;
        }
        if (this.jz == null) {
            this.jz = new com.airbnb.lottie.b.a(getCallback(), this.jA);
        }
        return this.jz;
    }

    @Nullable
    private Context getContext() {
        Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private float d(@NonNull Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.ja.getBounds().width()), ((float) canvas.getHeight()) / ((float) this.ja.getBounds().height()));
    }
}
