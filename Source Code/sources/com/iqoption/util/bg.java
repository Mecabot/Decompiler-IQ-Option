package com.iqoption.util;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Property;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.app.IQApp;

/* compiled from: ViewUtils */
public class bg {
    private static final String TAG = "com.iqoption.util.bg";
    private static int dwK = 1;
    public static final Property<ImageView, Integer> dwL = new Property<ImageView, Integer>(Integer.class, "imageAlpha") {
        /* renamed from: e */
        public Integer get(ImageView imageView) {
            return Integer.valueOf(imageView.getImageAlpha());
        }

        /* renamed from: a */
        public void set(ImageView imageView, Integer num) {
            imageView.setImageAlpha(num.intValue());
        }
    };

    /* compiled from: ViewUtils */
    private static class a extends LayoutTransition {
        public void addChild(ViewGroup viewGroup, View view) {
        }

        @Deprecated
        public void hideChild(ViewGroup viewGroup, View view) {
        }

        public void hideChild(ViewGroup viewGroup, View view, int i) {
        }

        public void removeChild(ViewGroup viewGroup, View view) {
        }

        @Deprecated
        public void showChild(ViewGroup viewGroup, View view) {
        }

        public void showChild(ViewGroup viewGroup, View view, int i) {
        }

        @TargetApi(16)
        public a() {
            disableTransitionType(0);
            disableTransitionType(2);
            disableTransitionType(1);
            disableTransitionType(3);
            enableTransitionType(4);
        }
    }

    public static LayoutTransition aGD() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setStartDelay(2, 0);
        layoutTransition.setStartDelay(0, 0);
        layoutTransition.setStartDelay(1, 0);
        layoutTransition.setStartDelay(3, 0);
        layoutTransition.setStagger(2, 0);
        layoutTransition.setStagger(0, 0);
        layoutTransition.setStagger(1, 0);
        layoutTransition.setStagger(3, 0);
        layoutTransition.setStagger(4, 0);
        layoutTransition.setStartDelay(4, 0);
        return layoutTransition;
    }

    public static LayoutTransition aGE() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setStartDelay(2, 0);
        layoutTransition.setStartDelay(0, 0);
        layoutTransition.setStartDelay(1, 0);
        layoutTransition.setStartDelay(3, 0);
        layoutTransition.setStagger(2, 0);
        layoutTransition.setStagger(0, 0);
        layoutTransition.setStagger(1, 0);
        layoutTransition.setStagger(3, 0);
        layoutTransition.setStagger(4, 0);
        layoutTransition.setStartDelay(4, 0);
        layoutTransition.enableTransitionType(4);
        return layoutTransition;
    }

    public static LayoutTransition aGF() {
        LayoutTransition aVar = new a();
        aVar.setStagger(4, 0);
        aVar.setStartDelay(4, 0);
        aVar.enableTransitionType(4);
        return aVar;
    }

    @NonNull
    public static void a(Context context, TextView textView, @ColorRes int i) {
        String charSequence = textView.getText().toString();
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence spannableString = new SpannableString(charSequence);
            if (charSequence.contains(" ")) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i)), 0, charSequence.indexOf(" "), 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i)), 0, charSequence.length(), 33);
            }
            textView.setText(spannableString);
        }
    }

    public static void a(String str, String str2, TextView textView, int i, boolean z) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            textView.setText(str);
            return;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), indexOf, str2.length() + indexOf, 33);
        if (z) {
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, str2.length() + indexOf, 33);
        }
        textView.setText(spannableStringBuilder);
    }

    public static boolean a(float f, float f2, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (f <= ((float) i) || f >= ((float) (i + view.getWidth())) || f2 <= ((float) i2) || f2 >= ((float) (i2 + view.getHeight()))) {
            return false;
        }
        return true;
    }

    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static float bT(View view) {
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int height = rect.height();
        return (!globalVisibleRect || height <= 0) ? 0.0f : ((float) height) / ((float) view.getHeight());
    }

    public static void e(EditText editText) {
        try {
            editText.setSelection(editText.getText().length());
        } catch (Exception unused) {
        }
    }

    public static void setDrawableLeft(@NonNull TextView textView, Drawable drawable) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    public static void setDrawableRight(@NonNull TextView textView, Drawable drawable) {
        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }

    public static void f(@NonNull TextView textView, @DrawableRes int i) {
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public static void g(@NonNull TextView textView, @DrawableRes int i) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }

    public static void p(@NonNull TextView textView) {
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public static void b(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(view.getWidth(), i), MeasureSpec.makeMeasureSpec(view.getHeight(), i2));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static void bU(View view) {
        b(view, Integer.MIN_VALUE, 0);
    }

    public static void a(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runnable.run();
            }
        });
    }

    public static void b(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                runnable.run();
                return false;
            }
        });
    }

    @Nullable
    public static Rect a(RecyclerView recyclerView, @IdRes int i, int i2) {
        int childCount = recyclerView.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = recyclerView.getChildAt(i3);
            if (recyclerView.getChildAdapterPosition(childAt) != i2) {
                i3++;
            } else if (i != -1) {
                return J(childAt.findViewById(i));
            } else {
                return J(childAt);
            }
        }
        return null;
    }

    public static Rect J(View view) {
        Rect rect = new Rect();
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        }
        return rect;
    }

    public static Point K(View view) {
        Point point = new Point();
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            point.set(iArr[0], iArr[1]);
        }
        return point;
    }

    @ColorInt
    public static int getColor(@ColorRes int i) {
        return ContextCompat.getColor(IQApp.Dk(), i);
    }

    public static void bV(@NonNull View view) {
        if (VERSION.SDK_INT >= 21) {
            view.setOnApplyWindowInsetsListener(bh.dwM);
        }
    }
}
