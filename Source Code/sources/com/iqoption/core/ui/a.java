package com.iqoption.core.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.core.graphics.a.a.d;
import com.iqoption.core.graphics.a.a.e;
import com.iqoption.core.ui.widget.b.c;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001aE\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0018H\u0007\u001a\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007\u001aE\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010!\u001a\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001eH\u0007\u001a\"\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u0010%\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007\u001a\u001a\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a*\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001eH\u0007\u001a\u0018\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0018H\u0007\u001a \u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000bH\u0007\u001a\u001a\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002002\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\"\u00101\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u00102\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u001eH\u0007\u001a\u0018\u00104\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u00105\u001a\u00020\u001eH\u0007\u001aE\u00106\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003H\u0007¢\u0006\u0002\u00108\u001a \u00109\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u001eH\u0007\u001a\"\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u0010%\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010<\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007\u001a\u001a\u0010<\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010=\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0007\u001aE\u0010A\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010!\u001a\u001c\u0010B\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DH\u0007\u001a \u0010B\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0007\u001a\u0018\u0010G\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u000bH\u0007\u001a\u0018\u0010H\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u000bH\u0007\u001a\u0018\u0010I\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u00102\u001a\u00020\u000bH\u0007\u001a\u0010\u0010J\u001a\u0004\u0018\u00010K*\u0004\u0018\u00010LH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006M"}, aXE = {"EMPTY_BACKGROUND", "Landroid/graphics/drawable/ColorDrawable;", "ON_TOUCH_SPEC", "", "", "[[I", "setAlphaOnTouch", "", "v", "Landroid/view/View;", "alphaOnTouch", "", "setBackgroundAlphaSpecs", "specs", "alphas", "Landroid/content/res/TypedArray;", "durations", "", "interpolators", "Landroid/animation/TimeInterpolator;", "(Landroid/view/View;[[ILandroid/content/res/TypedArray;[J[Landroid/animation/TimeInterpolator;)V", "setBackgroundColorSpecs", "colors", "setBackgroundTint", "Landroid/content/res/ColorStateList;", "color", "", "setDisableChangeAnimations", "Landroid/support/v7/widget/RecyclerView;", "disable", "", "setDrawableStartSpecs", "Landroid/widget/TextView;", "(Landroid/widget/TextView;[[ILandroid/content/res/TypedArray;[J[Landroid/animation/TimeInterpolator;)V", "setEatTouches", "eat", "setEndDrawableSizeColor", "size", "setEndDrawableTint", "setEndDrawableWidthHeightColor", "width", "height", "setFixedSize", "enabled", "setInputBackground", "Landroid/widget/EditText;", "lineWidth", "setProgressTint", "Landroid/widget/ProgressBar;", "setScaleOnTouch", "pixels", "isVertical", "setShowKeyboardOnFocus", "show", "setSourceSpecs", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;[[ILandroid/content/res/TypedArray;[J[Landroid/animation/TimeInterpolator;)V", "setSpacingItemDecoration", "includeEdge", "setStartDrawableSizeColor", "setStartDrawableTint", "setSwitchFont", "Landroid/support/v7/widget/SwitchCompat;", "font", "Landroid/graphics/Typeface;", "setTextColorSpecs", "setTouchAlphaAndScaleEffect", "params", "Ljava/lang/Void;", "alpha", "scale", "setTouchEffect", "setTouchScaleEffect", "setTouchScalePixelsEffect", "findGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/Drawable;", "core_release"})
/* compiled from: BindingAdapters.kt */
public final class a {
    private static final int[][] baM;
    private static final ColorDrawable baN = new ColorDrawable(0);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ View baQ;
        final /* synthetic */ float[] baR;
        final /* synthetic */ boolean baS;
        final /* synthetic */ float baT;
        final /* synthetic */ Drawable baU;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\f¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/BindingAdaptersKt$setScaleOnTouch$1$controller$1", "Lcom/iqoption/core/graphics/drawable/stateanimator/AnimatorController;", "init", "", "specIndex", "", "onCreate", "Landroid/animation/ObjectAnimator;", "fromSpecIndex", "toSpecIndex", "onPrepare", "animator", "core_release"})
        /* compiled from: BindingAdapters.kt */
        public static final class a extends com.iqoption.core.graphics.a.a.a {
            final /* synthetic */ b baV;

            a(int i, b bVar) {
                this.baV = bVar;
                super(i);
            }

            public void init(int i) {
                com.iqoption.core.ext.a.c(this.baV.baQ, this.baV.baR[i]);
            }

            public ObjectAnimator ah(int i, int i2) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setTarget(this.baV.baQ);
                objectAnimator.setDuration(200);
                objectAnimator.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
                return objectAnimator;
            }

            public void a(ObjectAnimator objectAnimator, int i, int i2) {
                h.e(objectAnimator, "animator");
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
                propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{this.baV.baR[i], this.baV.baR[i2]});
                propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{this.baV.baR[i], this.baV.baR[i2]});
                objectAnimator.setValues(propertyValuesHolderArr);
            }
        }

        public b(View view, View view2, float[] fArr, boolean z, float f, Drawable drawable) {
            this.aGz = view;
            this.baQ = view2;
            this.baR = fArr;
            this.baS = z;
            this.baT = f;
            this.baU = drawable;
        }

        public void onGlobalLayout() {
            this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            float measuredWidth = (float) this.baQ.getMeasuredWidth();
            float measuredHeight = (float) this.baQ.getMeasuredHeight();
            if (measuredWidth != 0.0f && measuredHeight != 0.0f) {
                this.baQ.setBackground((Drawable) null);
                float[] fArr = this.baR;
                if (this.baS) {
                    measuredWidth = (measuredHeight - this.baT) / measuredHeight;
                } else {
                    measuredWidth = (measuredWidth - this.baT) / measuredWidth;
                }
                fArr[0] = measuredWidth;
                a aVar = new a(((Object[]) a.baM).length, this);
                this.baQ.setBackground(new d(this.baU, a.baM, aVar));
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\f"}, aXE = {"com/iqoption/core/ui/BindingAdaptersKt$setAlphaOnTouch$controller$1", "Lcom/iqoption/core/graphics/drawable/stateanimator/AnimatorController;", "init", "", "specIndex", "", "onCreate", "Landroid/animation/ObjectAnimator;", "fromSpecIndex", "toSpecIndex", "onPrepare", "animator", "core_release"})
    /* compiled from: BindingAdapters.kt */
    public static final class a extends com.iqoption.core.graphics.a.a.a {
        final /* synthetic */ View baO;
        final /* synthetic */ float[] baP;

        a(View view, float[] fArr, int i) {
            this.baO = view;
            this.baP = fArr;
            super(i);
        }

        public void init(int i) {
            this.baO.setAlpha(this.baP[i]);
        }

        public ObjectAnimator ah(int i, int i2) {
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(this.baO);
            objectAnimator.setDuration(200);
            objectAnimator.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            return objectAnimator;
        }

        public void a(ObjectAnimator objectAnimator, int i, int i2) {
            h.e(objectAnimator, "animator");
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{this.baP[i], this.baP[i2]});
            objectAnimator.setValues(propertyValuesHolderArr);
        }
    }

    @BindingAdapter({"progressTint"})
    public static final void a(ProgressBar progressBar, @ColorInt int i) {
        h.e(progressBar, "v");
        progressBar.getIndeterminateDrawable().setColorFilter(i, Mode.SRC_IN);
    }

    @BindingAdapter({"bgTint"})
    public static final void j(View view, int i) {
        h.e(view, "v");
        Drawable background = view.getBackground();
        h.d(background, "v.background");
        view.setBackground(com.iqoption.core.ext.a.a(background, i));
    }

    @BindingAdapter({"inputBgColor", "inputBgWidth"})
    public static final void a(EditText editText, ColorStateList colorStateList, float f) {
        h.e(editText, "v");
        h.e(colorStateList, "colors");
        editText.setBackground(new com.iqoption.core.graphics.a.d(colorStateList, f));
    }

    @BindingAdapter({"startDrawableTint"})
    public static final void c(TextView textView, @ColorInt int i) {
        h.e(textView, "v");
        Drawable g = com.iqoption.core.ext.a.g(textView);
        if (g != null) {
            com.iqoption.core.ext.a.c(textView, com.iqoption.core.ext.a.a(g, i));
        }
    }

    @BindingAdapter({"endDrawableTint"})
    public static final void d(TextView textView, @ColorInt int i) {
        h.e(textView, "v");
        Drawable h = com.iqoption.core.ext.a.h(textView);
        if (h != null) {
            com.iqoption.core.ext.a.d(textView, com.iqoption.core.ext.a.a(h, i));
        }
    }

    @BindingAdapter({"endDrawableSize", "endDrawableTint"})
    public static final void a(TextView textView, float f, @ColorInt int i) {
        h.e(textView, "v");
        Drawable h = com.iqoption.core.ext.a.h(textView);
        if (h != null) {
            Drawable a = com.iqoption.core.ext.a.a(h, i);
            int i2 = (int) f;
            a.setBounds(0, 0, i2, i2);
            com.iqoption.core.ext.a.d(textView, a);
        }
    }

    @BindingAdapter({"startDrawableSize", "startDrawableTint"})
    public static final void b(TextView textView, float f, @ColorInt int i) {
        h.e(textView, "v");
        Drawable g = com.iqoption.core.ext.a.g(textView);
        if (g != null) {
            Drawable a = com.iqoption.core.ext.a.a(g, i);
            int i2 = (int) f;
            a.setBounds(0, 0, i2, i2);
            com.iqoption.core.ext.a.c(textView, a);
        }
    }

    @BindingAdapter({"touchEffect"})
    public static final void d(View view, float f) {
        h.e(view, "v");
        view.setOnTouchListener(new com.iqoption.core.ui.widget.b.b(f));
    }

    @BindingAdapter({"scaleTouchEffect"})
    public static final void e(View view, float f) {
        h.e(view, "v");
        view.setOnTouchListener(new c(f));
    }

    @BindingAdapter({"scalePixelsTouchEffect"})
    public static final void f(View view, float f) {
        h.e(view, "v");
        view.setOnTouchListener(new com.iqoption.core.ui.widget.b.d(f));
    }

    @BindingAdapter({"alphascaleTouchEffect"})
    public static final void a(View view, Void voidR) {
        h.e(view, "v");
        view.setOnTouchListener(new com.iqoption.core.ui.widget.b.a(0.0f, 0.0f, 3, null));
    }

    @BindingAdapter(requireAll = false, value = {"itemSpacing", "includeEdge"})
    public static final void a(RecyclerView recyclerView, float f, boolean z) {
        h.e(recyclerView, "v");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            recyclerView.addItemDecoration(new com.iqoption.core.ui.widget.recyclerview.a(((GridLayoutManager) layoutManager).getSpanCount(), Math.round(f), z));
        } else if (!(layoutManager instanceof LinearLayoutManager)) {
        } else {
            if (layoutManager.canScrollVertically()) {
                recyclerView.addItemDecoration(new com.iqoption.core.ui.widget.recyclerview.c(c.ae(f)));
            } else {
                recyclerView.addItemDecoration(new com.iqoption.core.ui.widget.recyclerview.b(c.ae(f)));
            }
        }
    }

    @BindingAdapter({"disableChangeAnimations"})
    public static final void a(RecyclerView recyclerView, boolean z) {
        h.e(recyclerView, "v");
        if (z) {
            com.iqoption.core.ext.a.b(recyclerView);
        }
    }

    @BindingAdapter(requireAll = false, value = {"bgSpecStates", "bgSpecAlphas", "bgDurations", "bgInterpolators"})
    public static final void a(View view, int[][] iArr, TypedArray typedArray, long[] jArr, TimeInterpolator[] timeInterpolatorArr) {
        h.e(view, "v");
        h.e(iArr, "specs");
        h.e(typedArray, "alphas");
        Drawable background = view.getBackground();
        background = background != null ? background.mutate() : null;
        if (background != null) {
            int length;
            int i;
            view.setBackground((Drawable) null);
            int[] a = b.a(typedArray);
            if (jArr == null) {
                jArr = new long[((Object[]) iArr).length];
                length = jArr.length;
                for (i = 0; i < length; i++) {
                    jArr[i] = 200;
                }
            }
            if (timeInterpolatorArr == null) {
                timeInterpolatorArr = new TimeInterpolator[((Object[]) iArr).length];
                length = timeInterpolatorArr.length;
                for (i = 0; i < length; i++) {
                    timeInterpolatorArr[i] = com.iqoption.core.graphics.animation.i.TI();
                }
            }
            com.iqoption.core.graphics.a.a.b bVar = new com.iqoption.core.graphics.a.a.b(background, a, jArr, timeInterpolatorArr);
            view.setBackground(new d(background, iArr, bVar));
        }
    }

    @BindingAdapter(requireAll = false, value = {"bgSpecStates", "bgSpecColors", "bgDurations", "bgInterpolators"})
    public static final void b(View view, int[][] iArr, TypedArray typedArray, long[] jArr, TimeInterpolator[] timeInterpolatorArr) {
        h.e(view, "v");
        h.e(iArr, "specs");
        h.e(typedArray, "colors");
        Drawable background = view.getBackground();
        GradientDrawable c = c(background);
        if (background != null && c != null) {
            int length;
            int i;
            view.setBackground((Drawable) null);
            int[] b = b.b(typedArray);
            if (jArr == null) {
                jArr = new long[((Object[]) iArr).length];
                length = jArr.length;
                for (i = 0; i < length; i++) {
                    jArr[i] = 200;
                }
            }
            if (timeInterpolatorArr == null) {
                timeInterpolatorArr = new TimeInterpolator[((Object[]) iArr).length];
                length = timeInterpolatorArr.length;
                for (i = 0; i < length; i++) {
                    timeInterpolatorArr[i] = com.iqoption.core.graphics.animation.i.TI();
                }
            }
            com.iqoption.core.graphics.a.a.c cVar = new com.iqoption.core.graphics.a.a.c(c, b, jArr, timeInterpolatorArr);
            view.setBackground(new d(background, iArr, cVar));
        }
    }

    private static final GradientDrawable c(Drawable drawable) {
        while (!(drawable instanceof GradientDrawable)) {
            if (!(drawable instanceof com.iqoption.core.graphics.a.b)) {
                return null;
            }
            drawable = ((com.iqoption.core.graphics.a.b) drawable).Uc();
        }
        drawable = drawable.mutate();
        if (drawable != null) {
            return (GradientDrawable) drawable;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    @BindingAdapter(requireAll = false, value = {"textColorSpecStates", "textColorSpecValues", "textColorDurations", "textColorInterpolators"})
    public static final void a(TextView textView, int[][] iArr, TypedArray typedArray, long[] jArr, TimeInterpolator[] timeInterpolatorArr) {
        int length;
        int i;
        h.e(textView, "v");
        h.e(iArr, "specs");
        h.e(typedArray, "colors");
        Drawable background = textView.getBackground();
        if (background != null) {
            textView.setBackground((Drawable) null);
        } else {
            background = new ColorDrawable(0);
        }
        int[] b = b.b(typedArray);
        if (jArr == null) {
            jArr = new long[((Object[]) iArr).length];
            length = jArr.length;
            for (i = 0; i < length; i++) {
                jArr[i] = 200;
            }
        }
        if (timeInterpolatorArr == null) {
            timeInterpolatorArr = new TimeInterpolator[((Object[]) iArr).length];
            length = timeInterpolatorArr.length;
            for (i = 0; i < length; i++) {
                timeInterpolatorArr[i] = com.iqoption.core.graphics.animation.i.TI();
            }
        }
        e eVar = new e(textView, b, jArr, timeInterpolatorArr);
        textView.setBackground(new d(background, iArr, eVar));
    }

    static {
        r0 = new int[2][];
        r0[0] = new int[]{16842919};
        r0[1] = com.iqoption.core.ext.c.SU();
        baM = r0;
    }

    @BindingAdapter(requireAll = false, value = {"scaleOnTouch", "sotIsVertical"})
    public static final void a(View view, float f, boolean z) {
        h.e(view, "v");
        float[] fArr = new float[]{1.0f, view.getScaleX()};
        Drawable background = view.getBackground();
        if (background == null) {
            background = baN;
        }
        Drawable drawable = background;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, view, fArr, z, com.iqoption.core.ext.a.a(view, f), drawable));
    }

    @BindingAdapter({"alphaOnTouch"})
    public static final void g(View view, float f) {
        h.e(view, "v");
        float[] fArr = new float[]{f, view.getAlpha()};
        Drawable background = view.getBackground();
        if (background == null) {
            background = baN;
        }
        a aVar = new a(view, fArr, ((Object[]) baM).length);
        view.setBackground(new d(background, baM, aVar));
    }

    @BindingAdapter({"switchFont"})
    public static final void a(SwitchCompat switchCompat, Typeface typeface) {
        h.e(switchCompat, "v");
        h.e(typeface, "font");
        switchCompat.setTypeface(typeface);
    }
}
