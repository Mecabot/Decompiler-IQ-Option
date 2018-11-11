package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.model.e;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = "LottieAnimationView";
    public static final CacheStrategy iM = CacheStrategy.Weak;
    private static final SparseArray<g> iN = new SparseArray();
    private static final SparseArray<WeakReference<g>> iO = new SparseArray();
    private static final Map<String, g> iP = new HashMap();
    private static final Map<String, WeakReference<g>> iQ = new HashMap();
    private final r iR = new r() {
        public void a(@Nullable g gVar) {
            if (gVar != null) {
                LottieAnimationView.this.setComposition(gVar);
            }
            LottieAnimationView.this.iZ = null;
        }
    };
    private final h iS = new h();
    private CacheStrategy iT;
    private String iU;
    @RawRes
    private int iV;
    private boolean iW = false;
    private boolean iX = false;
    private boolean iY = false;
    @Nullable
    private a iZ;
    @Nullable
    private g ja;

    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    private static class a extends BaseSavedState {
        public static final Creator<a> CREATOR = new Creator<a>() {
            /* renamed from: b */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            /* renamed from: p */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        String iU;
        int iV;
        float jg;
        boolean jh;
        String ji;
        int repeatCount;
        int repeatMode;

        /* synthetic */ a(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.iU = parcel.readString();
            this.jg = parcel.readFloat();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jh = z;
            this.ji = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.iU);
            parcel.writeFloat(this.jg);
            parcel.writeInt(this.jh);
            parcel.writeString(this.ji);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.airbnb.lottie.u.a.LottieAnimationView);
        this.iT = CacheStrategy.values()[obtainStyledAttributes.getInt(com.airbnb.lottie.u.a.LottieAnimationView_lottie_cacheStrategy, iM.ordinal())];
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_fileName);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(com.airbnb.lottie.u.a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = obtainStyledAttributes.getString(com.airbnb.lottie.u.a.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            }
        }
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.u.a.LottieAnimationView_lottie_autoPlay, false)) {
            this.iW = true;
            this.iX = true;
        }
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.u.a.LottieAnimationView_lottie_loop, false)) {
            this.iS.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(com.airbnb.lottie.u.a.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(com.airbnb.lottie.u.a.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(com.airbnb.lottie.u.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(com.airbnb.lottie.u.a.LottieAnimationView_lottie_progress, 0.0f));
        v(obtainStyledAttributes.getBoolean(com.airbnb.lottie.u.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_colorFilter)) {
            v vVar = new v(obtainStyledAttributes.getColor(com.airbnb.lottie.u.a.LottieAnimationView_lottie_colorFilter, 0));
            a(new e("**"), q.kk, new c(vVar));
        }
        if (obtainStyledAttributes.hasValue(com.airbnb.lottie.u.a.LottieAnimationView_lottie_scale)) {
            this.iS.setScale(obtainStyledAttributes.getFloat(com.airbnb.lottie.u.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        cY();
    }

    public void setImageResource(int i) {
        recycleBitmaps();
        cS();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        a(drawable, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.iS) {
            recycleBitmaps();
        }
        cS();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cS();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.iS) {
            super.invalidateDrawable(this.iS);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable aVar = new a(super.onSaveInstanceState());
        aVar.iU = this.iU;
        aVar.iV = this.iV;
        aVar.jg = this.iS.getProgress();
        aVar.jh = this.iS.isAnimating();
        aVar.ji = this.iS.getImageAssetsFolder();
        aVar.repeatMode = this.iS.getRepeatMode();
        aVar.repeatCount = this.iS.getRepeatCount();
        return aVar;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            super.onRestoreInstanceState(aVar.getSuperState());
            this.iU = aVar.iU;
            if (!TextUtils.isEmpty(this.iU)) {
                setAnimation(this.iU);
            }
            this.iV = aVar.iV;
            if (this.iV != 0) {
                setAnimation(this.iV);
            }
            setProgress(aVar.jg);
            if (aVar.jh) {
                cT();
            }
            this.iS.aa(aVar.ji);
            setRepeatMode(aVar.repeatMode);
            setRepeatCount(aVar.repeatCount);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.iX && this.iW) {
            cT();
        }
    }

    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cV();
            this.iW = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void recycleBitmaps() {
        if (this.iS != null) {
            this.iS.recycleBitmaps();
        }
    }

    public void v(boolean z) {
        this.iS.v(z);
    }

    public boolean getUseHardwareAcceleration() {
        return this.iY;
    }

    public void setAnimation(@RawRes int i) {
        a(i, this.iT);
    }

    public void a(@RawRes int i, CacheStrategy cacheStrategy) {
        this.iV = i;
        this.iU = null;
        if (iO.indexOfKey(i) > 0) {
            g gVar = (g) ((WeakReference) iO.get(i)).get();
            if (gVar != null) {
                setComposition(gVar);
                return;
            }
        } else if (iN.indexOfKey(i) > 0) {
            setComposition((g) iN.get(i));
            return;
        }
        cX();
        cS();
        this.iZ = com.airbnb.lottie.g.a.a(getContext(), i, new e(this, cacheStrategy, i));
    }

    public void setAnimation(String str) {
        a(str, this.iT);
    }

    public void a(String str, CacheStrategy cacheStrategy) {
        this.iU = str;
        this.iV = 0;
        if (iQ.containsKey(str)) {
            g gVar = (g) ((WeakReference) iQ.get(str)).get();
            if (gVar != null) {
                setComposition(gVar);
                return;
            }
        } else if (iP.containsKey(str)) {
            setComposition((g) iP.get(str));
            return;
        }
        cX();
        cS();
        this.iZ = com.airbnb.lottie.g.a.a(getContext(), str, new f(this, cacheStrategy, str));
    }

    @Deprecated
    public void setAnimation(JSONObject jSONObject) {
        setAnimation(new JsonReader(new StringReader(jSONObject.toString())));
    }

    public void setAnimationFromJson(String str) {
        setAnimation(new JsonReader(new StringReader(str)));
    }

    public void setAnimation(JsonReader jsonReader) {
        cX();
        cS();
        this.iZ = com.airbnb.lottie.g.a.a(jsonReader, this.iR);
    }

    private void cS() {
        if (this.iZ != null) {
            this.iZ.cancel();
            this.iZ = null;
        }
    }

    public void setComposition(@NonNull g gVar) {
        this.iS.setCallback(this);
        this.ja = gVar;
        boolean b = this.iS.b(gVar);
        cY();
        if (getDrawable() != this.iS || b) {
            setImageDrawable(null);
            setImageDrawable(this.iS);
            requestLayout();
        }
    }

    @Nullable
    public g getComposition() {
        return this.ja;
    }

    public void cT() {
        this.iS.d();
        cY();
    }

    public void cU() {
        this.iS.c();
        cY();
    }

    public void setMinFrame(int i) {
        this.iS.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.iS.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.iS.c(f);
    }

    public void setMaxFrame(int i) {
        this.iS.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.iS.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.iS.b(f);
    }

    public void setSpeed(float f) {
        this.iS.setSpeed(f);
    }

    public float getSpeed() {
        return this.iS.getSpeed();
    }

    public void a(AnimatorListener animatorListener) {
        this.iS.a(animatorListener);
    }

    public void b(AnimatorListener animatorListener) {
        this.iS.b(animatorListener);
    }

    @Deprecated
    public void w(boolean z) {
        this.iS.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.iS.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.iS.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.iS.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.iS.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.iS.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.iS.aa(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.iS.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.iS.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.iS.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(w wVar) {
        this.iS.setTextDelegate(wVar);
    }

    public <T> void a(e eVar, T t, c<T> cVar) {
        this.iS.a(eVar, t, cVar);
    }

    public void setScale(float f) {
        this.iS.setScale(f);
        if (getDrawable() == this.iS) {
            a(null, false);
            a(this.iS, false);
        }
    }

    public float getScale() {
        return this.iS.getScale();
    }

    public void cV() {
        this.iS.cV();
        cY();
    }

    public void cW() {
        this.iS.cW();
        cY();
    }

    public void setFrame(int i) {
        this.iS.a(i);
    }

    public int getFrame() {
        return this.iS.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.iS.a(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.iS.getProgress();
    }

    public long getDuration() {
        return this.ja != null ? (long) this.ja.cZ() : 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.iS.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public s getPerformanceTracker() {
        return this.iS.getPerformanceTracker();
    }

    private void cX() {
        this.ja = null;
        this.iS.cX();
    }

    private void cY() {
        int i = 1;
        Object obj = (this.iY && this.iS.isAnimating()) ? 1 : null;
        if (obj != null) {
            i = 2;
        }
        setLayerType(i, null);
    }
}
