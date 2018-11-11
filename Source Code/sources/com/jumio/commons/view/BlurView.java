package com.jumio.commons.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.jumio.commons.utils.MutableBitmap;
import java.lang.reflect.Array;

public class BlurView extends View {
    private static final int ANIMATION_DURATION = 500;
    private static final int BLUR_RADIUS = 12;
    private static final int BLUR_SCALE = 3;
    private int actionBarHeight = 0;
    private Bitmap bitmap = null;
    private boolean blurOrientationPortrait = false;
    private boolean currentOrientationPortrait = false;
    private boolean isBlurred = false;
    private Matrix matrix = null;
    private RelativeLayout rootRelativeLayout;
    private int textureHeight;
    private Matrix textureMatrix = null;
    private int textureWidth;

    public BlurView(Context context) {
        super(context);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRootRelativeLayout(RelativeLayout relativeLayout) {
        this.rootRelativeLayout = relativeLayout;
    }

    public void setActionBarHeight(int i) {
        this.actionBarHeight = i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bitmap != null) {
            canvas.drawBitmap(this.bitmap, this.matrix, null);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.bitmap == null) {
            return;
        }
        if (this.blurOrientationPortrait == this.currentOrientationPortrait) {
            calculateMatrix(this.textureWidth, this.textureHeight, this.textureMatrix);
        } else {
            calculateMatrix(i, i2, null);
        }
    }

    private void calculateMatrix(int i, int i2, Matrix matrix) {
        if (this.rootRelativeLayout != null && matrix == null) {
            i2 += this.rootRelativeLayout.getRootView().getHeight() - this.rootRelativeLayout.getHeight();
            if (this.currentOrientationPortrait) {
                i2 -= this.actionBarHeight;
            }
        }
        this.matrix = new Matrix();
        float f = 90.0f;
        Matrix matrix2;
        if (this.blurOrientationPortrait) {
            matrix2 = this.matrix;
            if (this.currentOrientationPortrait) {
                f = 0.0f;
            }
            matrix2.postRotate(f, 0.0f, 0.0f);
            if (this.currentOrientationPortrait) {
                this.matrix.postScale(((float) i) / ((float) this.bitmap.getWidth()), ((float) i2) / ((float) this.bitmap.getHeight()));
            } else {
                this.matrix.postTranslate((float) this.bitmap.getHeight(), 0.0f);
                this.matrix.postScale(((float) i) / ((float) this.bitmap.getHeight()), ((float) i2) / ((float) this.bitmap.getWidth()));
            }
        } else {
            matrix2 = this.matrix;
            if (!this.currentOrientationPortrait) {
                f = 0.0f;
            }
            matrix2.postRotate(f, 0.0f, 0.0f);
            if (this.currentOrientationPortrait) {
                this.matrix.postTranslate((float) this.bitmap.getHeight(), 0.0f);
                this.matrix.postScale(((float) i) / ((float) this.bitmap.getHeight()), ((float) i2) / ((float) this.bitmap.getWidth()));
            } else {
                this.matrix.postScale(((float) i) / ((float) this.bitmap.getWidth()), ((float) i2) / ((float) this.bitmap.getHeight()));
            }
        }
        if (matrix != null) {
            this.matrix.postConcat(matrix);
        }
    }

    public void clearBlur() {
        MutableBitmap.delete(this.bitmap);
        this.bitmap = null;
        invalidate();
        setVisibility(8);
        this.isBlurred = false;
    }

    public void changeRotation(boolean z) {
        if (this.isBlurred && this.matrix != null) {
            this.currentOrientationPortrait = z;
        }
    }

    public void enableBlur(Bitmap bitmap, Matrix matrix, boolean z) {
        if (!this.isBlurred && bitmap != null) {
            this.isBlurred = true;
            this.blurOrientationPortrait = z;
            this.currentOrientationPortrait = z;
            Bitmap createScaledBitmap = MutableBitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 3, bitmap.getHeight() / 3);
            if (VERSION.SDK_INT > 16) {
                createScaledBitmap = blurRenderScript(createScaledBitmap);
            } else {
                blurFallback(createScaledBitmap);
            }
            this.bitmap = MutableBitmap.copy(createScaledBitmap);
            this.textureMatrix = matrix;
            this.textureWidth = bitmap.getWidth();
            this.textureHeight = bitmap.getHeight();
            calculateMatrix(this.textureWidth, this.textureHeight, this.textureMatrix);
            MutableBitmap.delete(createScaledBitmap);
        }
    }

    public void showBlur() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        setAnimation(alphaAnimation);
        setVisibility(0);
    }

    @SuppressLint({"NewApi"})
    private Bitmap blurRenderScript(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        RenderScript create = RenderScript.create(getContext());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, MipmapControl.MIPMAP_NONE, 4);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(10.0f);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        MutableBitmap.delete(bitmap);
        return createBitmap;
    }

    private void blurFallback(Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i9 = width * height;
        int[] iArr = new int[i9];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i10 = width - 1;
        int i11 = height - 1;
        int[] iArr2 = new int[i9];
        int[] iArr3 = new int[i9];
        int[] iArr4 = new int[i9];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[43264];
        for (i = 0; i < 43264; i++) {
            iArr6[i] = i / 169;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(int.class, new int[]{25, 3});
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i12 >= height) {
                break;
            }
            i9 = -12;
            int i15 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            int i16 = 0;
            int i17 = 0;
            for (i = 12; i9 <= i; i = 12) {
                i8 = height;
                height = iArr[Math.min(i10, Math.max(i9, 0)) + i13];
                int[] iArr8 = iArr7[i9 + 12];
                iArr8[0] = (height & 16711680) >> 16;
                iArr8[1] = (height & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = height & 255;
                height = 13 - Math.abs(i9);
                i15 += iArr8[0] * height;
                i2 += iArr8[1] * height;
                i3 += iArr8[2] * height;
                if (i9 > 0) {
                    i4 += iArr8[0];
                    i5 += iArr8[1];
                    i6 += iArr8[2];
                } else {
                    i7 += iArr8[0];
                    i16 += iArr8[1];
                    i17 += iArr8[2];
                }
                i9++;
                height = i8;
            }
            i8 = height;
            int i18 = 12;
            for (height = 0; height < width; height++) {
                iArr2[i13] = iArr6[i15];
                iArr3[i13] = iArr6[i2];
                iArr4[i13] = iArr6[i3];
                i15 -= i7;
                i2 -= i16;
                i3 -= i17;
                int[] iArr9 = iArr7[((i18 - 12) + 25) % 25];
                i7 -= iArr9[0];
                i16 -= iArr9[1];
                i17 -= iArr9[2];
                if (i12 == 0) {
                    iArr5[height] = Math.min((height + 12) + 1, i10);
                }
                i = iArr[iArr5[height] + i14];
                iArr9[0] = (i & 16711680) >> 16;
                iArr9[1] = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i & 255;
                i4 += iArr9[0];
                i5 += iArr9[1];
                i6 += iArr9[2];
                i15 += i4;
                i2 += i5;
                i3 += i6;
                i18 = (i18 + 1) % 25;
                iArr9 = iArr7[i18 % 25];
                i7 += iArr9[0];
                i16 += iArr9[1];
                i17 += iArr9[2];
                i4 -= iArr9[0];
                i5 -= iArr9[1];
                i6 -= iArr9[2];
                i13++;
            }
            i14 += width;
            i12++;
            height = i8;
        }
        i8 = height;
        i10 = 0;
        while (i10 < width) {
            int i19;
            int[] iArr10;
            int[] iArr11 = iArr5;
            i9 = width * -12;
            height = -12;
            i = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            for (i19 = 12; height <= i19; i19 = 12) {
                i7 = Math.max(0, i9) + i10;
                iArr10 = iArr7[height + 12];
                iArr10[0] = iArr2[i7];
                iArr10[1] = iArr3[i7];
                iArr10[2] = iArr4[i7];
                i19 = 13 - Math.abs(height);
                i += iArr2[i7] * i19;
                i12 += iArr3[i7] * i19;
                i13 += iArr4[i7] * i19;
                if (height > 0) {
                    i14 += iArr10[0];
                    i2 += iArr10[1];
                    i3 += iArr10[2];
                } else {
                    i4 += iArr10[0];
                    i5 += iArr10[1];
                    i6 += iArr10[2];
                }
                if (height < i11) {
                    i9 += width;
                }
                height++;
            }
            i9 = i10;
            i7 = i3;
            height = i8;
            i19 = 0;
            i3 = i2;
            i2 = i14;
            i14 = 12;
            while (i19 < height) {
                int[] iArr12;
                iArr[i9] = (((iArr[i9] & ViewCompat.MEASURED_STATE_MASK) | (iArr6[i] << 16)) | (iArr6[i12] << 8)) | iArr6[i13];
                i -= i4;
                i12 -= i5;
                i13 -= i6;
                iArr10 = iArr7[((i14 - 12) + 25) % 25];
                i4 -= iArr10[0];
                i5 -= iArr10[1];
                i6 -= iArr10[2];
                if (i10 == 0) {
                    iArr12 = iArr6;
                    iArr11[i19] = Math.min(i19 + 13, i11) * width;
                } else {
                    iArr12 = iArr6;
                }
                int i20 = iArr11[i19] + i10;
                iArr10[0] = iArr2[i20];
                iArr10[1] = iArr3[i20];
                iArr10[2] = iArr4[i20];
                i2 += iArr10[0];
                i3 += iArr10[1];
                i7 += iArr10[2];
                i += i2;
                i12 += i3;
                i13 += i7;
                i14 = (i14 + 1) % 25;
                int[] iArr13 = iArr7[i14];
                i4 += iArr13[0];
                i5 += iArr13[1];
                i6 += iArr13[2];
                i2 -= iArr13[0];
                i3 -= iArr13[1];
                i7 -= iArr13[2];
                i9 += width;
                i19++;
                iArr6 = iArr12;
            }
            i10++;
            i8 = height;
            iArr5 = iArr11;
            iArr6 = iArr6;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i8);
    }
}
