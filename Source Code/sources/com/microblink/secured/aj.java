package com.microblink.secured;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.Log;

/* compiled from: line */
public final class aj extends ViewGroup {
    private boolean dVQ;
    private Matrix dYv;
    private Orientation dYw;
    private Orientation dYx;
    private int dYy;
    private int dYz;

    /* compiled from: line */
    class a extends Animation {
        private float dYA;
        private float dYB;
        private float dYC;
        private float dYD;
        private float dYE;
        private float dYF;

        public a(float f, float f2, float f3, float f4, boolean z) {
            this.dYA = f;
            this.dYB = f2;
            if (z) {
                this.dYC = (f3 - f4) * 0.5f;
                this.dYD = (f4 - f3) * 0.5f;
            } else {
                this.dYC = 0.0f;
                this.dYD = 0.0f;
            }
            if (z) {
                this.dYE = f4 * 0.5f;
                this.dYF = f3 * 0.5f;
                return;
            }
            this.dYE = f3 * 0.5f;
            this.dYF = f4 * 0.5f;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            transformation.getMatrix().preTranslate(this.dYC, this.dYD);
            transformation.getMatrix().preRotate(this.dYA + (f * (this.dYB - this.dYA)), this.dYE, this.dYF);
        }
    }

    public final void setAnimateRotation(boolean z) {
        this.dVQ = z;
    }

    public final void setAnimationDuration(int i) {
        this.dYy = i;
    }

    public final void setInitialOrientation(Orientation orientation) {
        this.dYx = orientation;
        this.dYw = a(this.dYx);
    }

    public final void setHostActivityOrientation(int i) {
        this.dYz = i;
        setOrientation(this.dYx);
    }

    private Orientation a(Orientation orientation) {
        int ordinal = orientation.ordinal();
        int i = this.dYz;
        if (i != 0) {
            switch (i) {
                case 8:
                    i = 1;
                    break;
                case 9:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
        }
        i = 3;
        Log.a(this, "Normalized orientation {} to {}", orientation, Orientation.values()[(ordinal + i) % 4]);
        return Orientation.values()[(ordinal + i) % 4];
    }

    protected final void onMeasure(int i, int i2) {
        i = resolveSize(getSuggestedMinimumWidth(), i);
        i2 = resolveSize(getSuggestedMinimumHeight(), i2);
        if (this.dYw.isHorizontal()) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        Log.a(this, "Measured dimension: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        setMeasuredDimension(i, i2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Log.a(this, "Rotatable view group ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(childCount), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        int width = getWidth();
        int height = getHeight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(getChildDrawingOrder(childCount, i5));
            if (this.dYw.isHorizontal()) {
                childAt.measure(MeasureSpec.makeMeasureSpec(height, 1073741824), MeasureSpec.makeMeasureSpec(width, 1073741824));
                Log.f(this, "Horizontal layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), Integer.valueOf(0), Integer.valueOf(width), Integer.valueOf(0), Integer.valueOf(height));
                childAt.layout(0, 0, height, width);
            } else {
                childAt.measure(MeasureSpec.makeMeasureSpec(width, 1073741824), MeasureSpec.makeMeasureSpec(height, 1073741824));
                Log.f(this, "Vertical layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), Integer.valueOf(0), Integer.valueOf(height), Integer.valueOf(0), Integer.valueOf(width));
                childAt.layout(0, 0, width, height);
            }
        }
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.a(this, "[RotatableViewGroup] size changed from {}x{} to {}x{}", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        if (i != i3 || i2 != i4) {
            Animation a = a(Orientation.ORIENTATION_PORTRAIT, this.dYw);
            if (a != null) {
                a.setFillEnabled(true);
                a.setDuration(0);
                a.setFillAfter(true);
                a.setFillBefore(true);
                setLayoutAnimation(new LayoutAnimationController(a));
                startLayoutAnimation();
            }
            aPX();
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent = MotionEvent.obtain(motionEvent);
        float[] fArr = new float[]{motionEvent.getRawX(), motionEvent.getRawY()};
        Log.a(this, "Tap coordinate: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Log.a(this, "Location on screen: ({}, {})", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        fArr[0] = fArr[0] - ((float) iArr[0]);
        fArr[1] = fArr[1] - ((float) iArr[1]);
        Log.a(this, "View-normalized tap coordinate: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        this.dYv.mapPoints(fArr);
        Log.a(this, "Mapped tap coordinate: ({} {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }

    private Animation a(Orientation orientation, Orientation orientation2) {
        Log.a(this, "Creating animation from {} to {}", orientation, orientation2);
        Log.a(this, "Width: {},  heigth: {}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        if (orientation == Orientation.ORIENTATION_PORTRAIT) {
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
                return new a(0.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
            } else if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return new a(0.0f, -90.0f, (float) getWidth(), (float) getHeight(), true);
            } else if (orientation2 != Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return null;
            } else {
                return new a(0.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
            }
        } else if (orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
            if (orientation2 == Orientation.ORIENTATION_PORTRAIT) {
                return new a(90.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return new a(90.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 != Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return null;
            } else {
                return new a(90.0f, -90.0f, (float) getWidth(), (float) getHeight(), true);
            }
        } else if (orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
                return new a(180.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
            } else if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return new a(180.0f, 270.0f, (float) getWidth(), (float) getHeight(), true);
            } else if (orientation2 != Orientation.ORIENTATION_PORTRAIT) {
                return null;
            } else {
                return new a(180.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
            }
        } else if (orientation != Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            return null;
        } else {
            if (orientation2 == Orientation.ORIENTATION_PORTRAIT) {
                return new a(-90.0f, 0.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return new a(270.0f, 180.0f, (float) getWidth(), (float) getHeight(), false);
            } else if (orientation2 != Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
                return null;
            } else {
                return new a(-90.0f, 90.0f, (float) getWidth(), (float) getHeight(), true);
            }
        }
    }

    private void aPX() {
        int width = getWidth();
        int height = getHeight();
        Matrix matrix = new Matrix();
        if (this.dYw == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
            matrix.preTranslate((float) width, 0.0f);
            matrix.preRotate(90.0f);
        } else if (this.dYw == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            matrix.preTranslate(0.0f, (float) height);
            matrix.preRotate(-90.0f);
        } else if (this.dYw != Orientation.ORIENTATION_PORTRAIT && this.dYw == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
            matrix.preTranslate((float) width, (float) height);
            matrix.preRotate(180.0f);
        }
        matrix.invert(this.dYv);
    }

    public final void setOrientation(Orientation orientation) {
        invalidate();
        this.dYx = orientation;
        orientation = a(this.dYx);
        Animation a = a(this.dYw, orientation);
        if (a != null) {
            a.setFillAfter(true);
            if (this.dVQ) {
                a.setDuration((long) this.dYy);
            } else {
                a.setDuration(0);
            }
            setLayoutAnimation(new LayoutAnimationController(a));
            startLayoutAnimation();
        } else {
            requestLayout();
        }
        this.dYw = orientation;
        aPX();
        StringBuilder stringBuilder = new StringBuilder("Set orientation: ");
        stringBuilder.append(this.dYw);
        Log.a(this, stringBuilder.toString(), new Object[0]);
    }
}
