package com.jumio.commons.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class ImageSwitcherView extends RelativeLayout implements OnClickListener {
    private static final int ANIMATION_DURATION_IN = 160;
    private static final int ANIMATION_DURATION_OUT = 130;
    private static final int IMAGE_VIEW_POOL_SIZE = 2;
    private ArrayList<Bitmap> bitmaps;
    private int currentBitmapIndex;
    private int currentImagePoolIndex;
    private OnImageSwitchedListener externalListener;
    private ImageView[] imagesPool;

    public interface OnImageSwitchedListener {
        void onImageSwitchFinished(ImageSwitcherView imageSwitcherView);

        void onImageSwitchStarted(ImageSwitcherView imageSwitcherView);
    }

    public ImageSwitcherView(Context context) {
        super(context);
        this.imagesPool = new ImageView[2];
        this.currentBitmapIndex = 0;
        this.currentImagePoolIndex = 0;
        init(context);
    }

    public ImageSwitcherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imagesPool = new ImageView[2];
        this.currentBitmapIndex = 0;
        this.currentImagePoolIndex = 0;
        init(context);
    }

    public ImageSwitcherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imagesPool = new ImageView[2];
        this.currentBitmapIndex = 0;
        this.currentImagePoolIndex = 0;
        init(context);
    }

    private void init(Context context) {
        setOnClickListener(this);
    }

    public void onClick(View view) {
        this.externalListener.onImageSwitchStarted(this);
        startSwitchAnimation();
    }

    private void startSwitchAnimation() {
        ImageView imageView = this.imagesPool[this.currentImagePoolIndex];
        int i = 0;
        this.currentBitmapIndex = this.currentBitmapIndex < this.bitmaps.size() - 1 ? this.currentBitmapIndex + 1 : 0;
        if (this.currentImagePoolIndex < 1) {
            i = this.currentImagePoolIndex + 1;
        }
        this.currentImagePoolIndex = i;
        ImageView imageView2 = this.imagesPool[this.currentImagePoolIndex];
        Bitmap bitmap = (Bitmap) this.bitmaps.get(this.currentBitmapIndex);
        int floor = (int) Math.floor((double) bitmap.getHeight());
        imageView2.setImageBitmap(bitmap);
        new Handler(Looper.getMainLooper()).post(getAnimatorTask(imageView, imageView2, floor, this));
    }

    private Runnable getAnimatorTask(ImageView imageView, ImageView imageView2, int i, ImageSwitcherView imageSwitcherView) {
        final ImageView imageView3 = imageView;
        final int i2 = i;
        final ImageView imageView4 = imageView2;
        final ImageSwitcherView imageSwitcherView2 = imageSwitcherView;
        return new Runnable() {
            public void run() {
                ObjectAnimator.ofFloat(imageView3, "alpha", new float[]{255.0f, 0.0f}).setDuration(130);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, "translationY", new float[]{0.0f, (float) i2});
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.setDuration(130);
                ObjectAnimator.ofFloat(imageView4, "alpha", new float[]{0.0f, 255.0f}).setDuration(160);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView4, "translationY", new float[]{(float) (-i2), 0.0f});
                ofFloat.setInterpolator(new AccelerateInterpolator());
                ofFloat2.setDuration(160);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ofFloat, r0, ofFloat2, r3});
                animatorSet.addListener(new AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        ImageSwitcherView.this.externalListener.onImageSwitchFinished(imageSwitcherView2);
                    }
                });
                animatorSet.start();
            }
        };
    }

    public ImageSwitcherView setImages(ArrayList<Bitmap> arrayList) {
        this.bitmaps = arrayList;
        this.currentBitmapIndex = 0;
        this.currentImagePoolIndex = 0;
        Bitmap bitmap = (Bitmap) arrayList.get(this.currentBitmapIndex);
        int height = bitmap.getHeight() / 2;
        for (int i = 0; i < 2; i++) {
            View imageView = new ImageView(getContext());
            imageView.setPadding(0, height, 0, height);
            addView(imageView);
            this.imagesPool[i] = imageView;
        }
        this.imagesPool[this.currentImagePoolIndex].setImageBitmap(bitmap);
        return this;
    }

    public void switchToImageWithIndex(int i) {
        if (i < this.bitmaps.size()) {
            this.currentBitmapIndex = i;
            this.imagesPool[this.currentImagePoolIndex].setImageBitmap((Bitmap) this.bitmaps.get(this.currentBitmapIndex));
        }
    }

    public void setOnImageSwitchedListener(OnImageSwitchedListener onImageSwitchedListener) {
        this.externalListener = onImageSwitchedListener;
    }
}
