package com.jumio.commons.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CompatibilityLayer {
    @SuppressLint({"NewApi"})
    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @SuppressLint({"NewApi"})
    public static ObjectAnimator getImageViewAlphaObjectAnimator(ImageView imageView, int i, int i2) {
        if (VERSION.SDK_INT >= 16) {
            return ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{i, i2});
        }
        return ObjectAnimator.ofFloat(imageView, "alpha", new float[]{((float) i) / 255.0f, ((float) i2) / 255.0f});
    }

    @SuppressLint({"NewApi"})
    public static float getImageViewAlpha(ImageView imageView) {
        return VERSION.SDK_INT >= 16 ? (float) imageView.getImageAlpha() : imageView.getAlpha();
    }

    @SuppressLint({"NewApi"})
    public static void setImageViewAlpha(ImageView imageView, int i) {
        if (VERSION.SDK_INT >= 16) {
            imageView.setImageAlpha(i);
        } else {
            imageView.setAlpha(((float) i) / 255.0f);
        }
    }

    @SuppressLint({"NewApi"})
    public static void setTextAppearance(TextView textView, int i) {
        if (VERSION.SDK_INT >= 16) {
            textView.setTextAppearance(textView.getContext(), i);
        } else {
            textView.setTextAppearance(i);
        }
    }

    @SuppressLint({"NewApi"})
    public static Drawable getDrawable(Resources resources, int i) {
        return VERSION.SDK_INT >= 16 ? resources.getDrawable(i) : resources.getDrawable(i, null);
    }
}
