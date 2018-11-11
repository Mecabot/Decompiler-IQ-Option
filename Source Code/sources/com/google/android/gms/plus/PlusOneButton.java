package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzcb;
import com.google.android.gms.plus.internal.zzm;

@Deprecated
public final class PlusOneButton extends FrameLayout {
    @Deprecated
    public static final int ANNOTATION_BUBBLE = 1;
    @Deprecated
    public static final int ANNOTATION_INLINE = 2;
    @Deprecated
    public static final int ANNOTATION_NONE = 0;
    @Deprecated
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    @Deprecated
    public static final int SIZE_MEDIUM = 1;
    @Deprecated
    public static final int SIZE_SMALL = 0;
    @Deprecated
    public static final int SIZE_STANDARD = 3;
    @Deprecated
    public static final int SIZE_TALL = 2;
    private View mContentView;
    private int mSize;
    private String zzag;
    private int zzkhm;
    private int zzkhn;
    private OnPlusOneClickListener zzkho;

    @Deprecated
    public interface OnPlusOneClickListener {
        @Deprecated
        void onPlusOneClick(Intent intent);
    }

    @Deprecated
    public class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzkhp;

        @Deprecated
        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.zzkhp = onPlusOneClickListener;
        }

        @Deprecated
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.mContentView.getTag();
            if (this.zzkhp != null) {
                this.zzkhp.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        @Deprecated
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.zzkhn);
            }
        }
    }

    @Deprecated
    public PlusOneButton(Context context) {
        this(context, null);
    }

    @Deprecated
    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.zzkhm = getAnnotation(context, attributeSet);
        this.zzkhn = -1;
        zzef(getContext());
        if (isInEditMode()) {
        }
    }

    @Deprecated
    protected static int getAnnotation(Context context, AttributeSet attributeSet) {
        String zza = zzcb.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(zza) ? 2 : "NONE".equalsIgnoreCase(zza) ? 0 : 1;
    }

    @Deprecated
    protected static int getSize(Context context, AttributeSet attributeSet) {
        String zza = zzcb.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(zza) ? 0 : "MEDIUM".equalsIgnoreCase(zza) ? 1 : "TALL".equalsIgnoreCase(zza) ? 2 : 3;
    }

    private final void zzef(Context context) {
        if (this.mContentView != null) {
            removeView(this.mContentView);
        }
        this.mContentView = zzm.zza(context, this.mSize, this.zzkhm, this.zzag, this.zzkhn);
        setOnPlusOneClickListener(this.zzkho);
        addView(this.mContentView);
    }

    @Deprecated
    public final void initialize(String str, int i) {
        zzbq.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzag = str;
        this.zzkhn = i;
        zzef(getContext());
    }

    @Deprecated
    public final void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.zzag = str;
        this.zzkhn = 0;
        zzef(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    @Hide
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, i3 - i, i4 - i2);
    }

    @Hide
    protected final void onMeasure(int i, int i2) {
        View view = this.mContentView;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Deprecated
    public final void plusOneClick() {
        this.mContentView.performClick();
    }

    @Deprecated
    public final void setAnnotation(int i) {
        this.zzkhm = i;
        zzef(getContext());
    }

    @Deprecated
    public final void setIntent(Intent intent) {
        this.mContentView.setTag(intent);
    }

    @Deprecated
    public final void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zzkho = onPlusOneClickListener;
        this.mContentView.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    @Deprecated
    public final void setSize(int i) {
        this.mSize = i;
        zzef(getContext());
    }
}
