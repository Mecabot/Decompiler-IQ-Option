package com.jumio.nv.liveness.eyetracking.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.ScanSide;
import com.jumio.nv.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState;
import com.jumio.nv.liveness.eyetracking.a.b;
import com.jumio.nv.liveness.overlay.LivenessOverlay;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;

/* compiled from: EyeTrackingOverlay */
public class a extends LivenessOverlay {
    private EyeTrackingTarget a;
    private TextView b;
    private AnimatorSet c;
    private final Object d = new Object();
    private boolean e = false;

    public a(Context context) {
        super(context);
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
        super.addViews(viewGroup);
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(R.attr.netverify_scanOverlayLivenessText, typedValue, true);
        int dpToPx = ScreenUtil.dpToPx(this.context, 60);
        this.a = new EyeTrackingTarget(this.context);
        this.a.setLayoutParams(new LayoutParams(dpToPx, dpToPx));
        this.a.setVisibility(4);
        viewGroup.addView(this.a);
        this.b = new TextView(this.context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.b.setLayoutParams(layoutParams);
        this.b.setTextSize(2, 17.0f);
        this.b.setText(Strings.getExternalString(this.context, NVStrings.SCANVIEW_LIVENESS_FOLLOW_HINT));
        this.b.setTextColor(typedValue.data);
        this.b.setVisibility(4);
        viewGroup.addView(this.b);
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        super.prepareDraw(scanSide, z, z2);
        int width = this.a.getWidth() / 2;
        int i = (this.overlayBounds.top - (width * 2)) - (width / 5);
        this.a.setTranslationX((float) ((this.w / 2) - width));
        this.a.setTranslationY((float) i);
        this.a.setBorderScale(0.0f);
        this.a.setPercent(0.0f);
        this.a.setTargetScale(0.0f);
        this.b.setY((float) (i - this.b.getHeight()));
        this.b.setAlpha(0.0f);
    }

    public void update(ExtractionUpdate extractionUpdate) {
        Throwable th;
        super.update(extractionUpdate);
        if (extractionUpdate.getState() == b.b) {
            this.e = ((Boolean) extractionUpdate.getData()).booleanValue();
        } else if (!this.e) {
            Builder play;
            if (extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentOutOfBounds || extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentInvalid) {
                if (this.a.getBorderScale() == 1.0f) {
                    synchronized (this.d) {
                        try {
                            if (this.c != null && this.c.isRunning()) {
                                this.c.end();
                            }
                            this.c = new AnimatorSet();
                            this.c.setInterpolator(new AccelerateDecelerateInterpolator());
                            this.c.setDuration(100);
                            play = this.c.play(ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{1.0f, 0.0f}));
                            play.with(ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f}));
                            if (this.a.getTargetScale() > 0.0f) {
                                play.with(ObjectAnimator.ofFloat(this.a, "targetScale", new float[]{0.34f, 0.0f}));
                            }
                            this.c.addListener(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    a.this.a.setVisibility(4);
                                    a.this.b.setVisibility(4);
                                }
                            });
                            this.c.start();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            } else if (extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentValid) {
                if (this.a.getBorderScale() == 0.0f) {
                    this.a.setPercent(0.0f);
                    this.a.setTargetScale(0.0f);
                    synchronized (this.d) {
                        try {
                            if (this.c != null && this.c.isRunning()) {
                                this.c.end();
                            }
                            this.c = new AnimatorSet();
                            this.c.setInterpolator(new AccelerateDecelerateInterpolator());
                            this.c.setDuration(150);
                            this.c.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f})});
                            this.c.addListener(new AnimatorListenerAdapter() {
                                public void onAnimationStart(Animator animator) {
                                    a.this.a.setVisibility(0);
                                    a.this.b.setVisibility(0);
                                }
                            });
                            this.c.start();
                        } catch (Throwable th22) {
                            th = th22;
                        }
                    }
                }
            } else if (extractionUpdate.getState() == b.a) {
                Bundle bundle = (Bundle) extractionUpdate.getData();
                int i = bundle.getInt("x");
                int i2 = bundle.getInt("y");
                int i3 = bundle.getInt("step");
                float f = 1.0f / ((float) bundle.getInt("max_steps"));
                Object obj = (i == -1 && i2 == -1) ? 1 : null;
                Object obj2 = (i == -2 && i2 == -2) ? 1 : null;
                synchronized (this.d) {
                    try {
                        if (this.c != null && this.c.isRunning()) {
                            this.c.end();
                        }
                        this.c = new AnimatorSet();
                        this.c.setInterpolator(new AccelerateDecelerateInterpolator());
                        int width = this.a.getWidth() / 2;
                        int i4 = i2;
                        int i5;
                        Animator ofFloat;
                        Animator ofFloat2;
                        Animator ofFloat3;
                        Animator ofFloat4;
                        if (obj != null) {
                            this.a.setPercent(0.0f);
                            this.a.setTargetScale(0.0f);
                            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.a, "targetScale", new float[]{0.0f, 0.34f});
                            ofFloat5.setDuration(150);
                            ofFloat5.setStartDelay(350);
                            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.a, "percent", new float[]{0.0f, f});
                            ofFloat6.setDuration(500);
                            ofFloat6.setStartDelay(500);
                            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{1.0f, 0.0f});
                            ofFloat7.setDuration(100);
                            ofFloat7.setStartDelay(1300);
                            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f});
                            ofFloat8.setDuration(100);
                            ofFloat8.setStartDelay(1300);
                            this.c.playTogether(new Animator[]{ofFloat5, ofFloat6, ofFloat7, ofFloat8});
                            this.a.setVisibility(0);
                        } else if (obj2 != null) {
                            i = (this.w / 2) - width;
                            i5 = (this.overlayBounds.top - (width * 2)) - (width / 5);
                            ofFloat = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{this.a.getX(), (float) i});
                            ofFloat.setDuration(300);
                            ofFloat2 = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{this.a.getY(), (float) i5});
                            ofFloat2.setDuration(300);
                            ofFloat3 = ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{0.0f, 1.0f});
                            ofFloat3.setDuration(150);
                            ofFloat4 = ObjectAnimator.ofFloat(this.a, "percent", new float[]{f * ((float) i3), 1.0f});
                            ofFloat4.setDuration(500);
                            ofFloat4.setStartDelay(150);
                            play = this.c.play(ofFloat);
                            play.with(ofFloat2);
                            play.before(ofFloat3);
                            play.before(ofFloat4);
                        } else {
                            int i6 = width * 2;
                            i5 = ((this.w * i) + width) - ((this.a.getWidth() + i6) * i);
                            i = ((this.h * i4) + width) - ((this.a.getHeight() + i6) * i4);
                            ofFloat2 = ObjectAnimator.ofFloat(this.a, "translationX", new float[]{this.a.getX(), (float) i5});
                            ofFloat2.setDuration(300);
                            ofFloat = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{this.a.getY(), (float) i});
                            ofFloat.setDuration(300);
                            ofFloat3 = ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{0.0f, 1.0f});
                            ofFloat3.setDuration(150);
                            ofFloat4 = ObjectAnimator.ofFloat(this.a, "percent", new float[]{((float) i3) * f, f * ((float) (i3 + 1))});
                            ofFloat4.setDuration(500);
                            ofFloat4.setStartDelay(150);
                            Animator ofFloat9 = ObjectAnimator.ofFloat(this.a, "borderScale", new float[]{1.0f, 0.0f});
                            ofFloat9.setDuration(100);
                            ofFloat9.setStartDelay(650);
                            Animator ofFloat10 = ObjectAnimator.ofFloat(this.a, "targetScale", new float[]{0.34f, 1.0f});
                            ofFloat10.setDuration(600);
                            ofFloat10.setStartDelay(150);
                            Animator ofFloat11 = ObjectAnimator.ofFloat(this.a, "targetScale", new float[]{1.0f, 0.34f});
                            ofFloat11.setDuration(100);
                            ofFloat11.setStartDelay(200);
                            Builder play2 = this.c.play(ofFloat2);
                            play2.with(ofFloat);
                            ofFloat = new AnimatorSet();
                            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                            Builder play3 = ofFloat.play(ofFloat10);
                            play3.with(ofFloat4).with(ofFloat9);
                            play3.after(ofFloat3);
                            play3.before(ofFloat11);
                            play2.before(ofFloat);
                        }
                        this.c.start();
                    } catch (Throwable th222) {
                        Throwable th3 = th222;
                    }
                }
            }
        }
    }
}
