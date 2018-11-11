package com.squareup.picasso;

import android.os.Build.VERSION;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements OnPreDrawListener {
    Object attachListener;
    Callback callback;
    final RequestCreator creator;
    final WeakReference<ImageView> target;

    static class HoneycombMr1ViewUtil {
        HoneycombMr1ViewUtil() {
        }

        static Object defer(View view, final DeferredRequestCreator deferredRequestCreator) {
            OnAttachStateChangeListener anonymousClass1 = new OnAttachStateChangeListener() {
                public void onViewDetachedFromWindow(View view) {
                }

                public void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    view.getViewTreeObserver().addOnPreDrawListener(deferredRequestCreator);
                    deferredRequestCreator.attachListener = null;
                }
            };
            view.addOnAttachStateChangeListener(anonymousClass1);
            return anonymousClass1;
        }

        static void cancel(View view, Object obj) {
            view.removeOnAttachStateChangeListener((OnAttachStateChangeListener) obj);
        }
    }

    @VisibleForTesting
    DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView) {
        this(requestCreator, imageView, null);
    }

    DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback) {
        this.creator = requestCreator;
        this.target = new WeakReference(imageView);
        this.callback = callback;
        if (VERSION.SDK_INT < 12 || imageView.getWindowToken() != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this);
        } else {
            this.attachListener = HoneycombMr1ViewUtil.defer(imageView, this);
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.target.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width <= 0 || height <= 0 || imageView.isLayoutRequested()) {
            return true;
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        this.target.clear();
        this.creator.unfit().resize(width, height).into(imageView, this.callback);
        return true;
    }

    void cancel() {
        this.creator.clearTag();
        this.callback = null;
        ImageView imageView = (ImageView) this.target.get();
        if (imageView != null) {
            this.target.clear();
            if (this.attachListener != null) {
                HoneycombMr1ViewUtil.cancel(imageView, this.attachListener);
                this.attachListener = null;
            } else {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
            }
        }
    }

    Object getTag() {
        return this.creator.getTag();
    }
}
