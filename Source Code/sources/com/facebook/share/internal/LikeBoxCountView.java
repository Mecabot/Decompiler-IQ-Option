package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.a.a;
import com.facebook.common.a.b;

@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private TextView IG;
    private LikeBoxCountViewCaretPosition IH = LikeBoxCountViewCaretPosition.LEFT;
    private float II;
    private float IJ;
    private int IK;
    private int IP;
    private Paint borderPaint;
    private float borderRadius;

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        initialize(context);
    }

    @Deprecated
    public void setText(String str) {
        this.IG.setText(str);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.IH = likeBoxCountViewCaretPosition;
        switch (likeBoxCountViewCaretPosition) {
            case LEFT:
                b(this.IP, 0, 0, 0);
                return;
            case TOP:
                b(0, this.IP, 0, 0);
                return;
            case RIGHT:
                b(0, 0, this.IP, 0);
                return;
            case BOTTOM:
                b(0, 0, 0, this.IP);
                return;
            default:
                return;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        switch (this.IH) {
            case LEFT:
                paddingLeft = (int) (((float) paddingLeft) + this.II);
                break;
            case TOP:
                paddingTop = (int) (((float) paddingTop) + this.II);
                break;
            case RIGHT:
                width = (int) (((float) width) - this.II);
                break;
            case BOTTOM:
                height = (int) (((float) height) - this.II);
                break;
        }
        a(canvas, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.II = getResources().getDimension(b.com_facebook_likeboxcountview_caret_height);
        this.IJ = getResources().getDimension(b.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(b.com_facebook_likeboxcountview_border_radius);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(a.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(b.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Style.STROKE);
        ao(context);
        addView(this.IG);
        setCaretPosition(this.IH);
    }

    private void ao(Context context) {
        this.IG = new TextView(context);
        this.IG.setLayoutParams(new LayoutParams(-1, -1));
        this.IG.setGravity(17);
        this.IG.setTextSize(0, getResources().getDimension(b.com_facebook_likeboxcountview_text_size));
        this.IG.setTextColor(getResources().getColor(a.com_facebook_likeboxcountview_text_color));
        this.IK = getResources().getDimensionPixelSize(b.com_facebook_likeboxcountview_text_padding);
        this.IP = getResources().getDimensionPixelSize(b.com_facebook_likeboxcountview_caret_height);
    }

    private void b(int i, int i2, int i3, int i4) {
        this.IG.setPadding(this.IK + i, this.IK + i2, this.IK + i3, this.IK + i4);
    }

    private void a(Canvas canvas, float f, float f2, float f3, float f4) {
        float f5;
        Path path = new Path();
        float f6 = this.borderRadius * 2.0f;
        float f7 = f + f6;
        float f8 = f2 + f6;
        path.addArc(new RectF(f, f2, f7, f8), -180.0f, 90.0f);
        if (this.IH == LikeBoxCountViewCaretPosition.TOP) {
            f5 = f3 - f;
            path.lineTo(((f5 - this.IJ) / 2.0f) + f, f2);
            path.lineTo((f5 / 2.0f) + f, f2 - this.II);
            path.lineTo(((f5 + this.IJ) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.borderRadius, f2);
        float f9 = f3 - f6;
        path.addArc(new RectF(f9, f2, f3, f8), -90.0f, 90.0f);
        if (this.IH == LikeBoxCountViewCaretPosition.RIGHT) {
            f5 = f4 - f2;
            path.lineTo(f3, ((f5 - this.IJ) / 2.0f) + f2);
            path.lineTo(this.II + f3, (f5 / 2.0f) + f2);
            path.lineTo(f3, ((f5 + this.IJ) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.borderRadius);
        f6 = f4 - f6;
        path.addArc(new RectF(f9, f6, f3, f4), 0.0f, 90.0f);
        if (this.IH == LikeBoxCountViewCaretPosition.BOTTOM) {
            f3 -= f;
            path.lineTo(((this.IJ + f3) / 2.0f) + f, f4);
            path.lineTo((f3 / 2.0f) + f, this.II + f4);
            path.lineTo(((f3 - this.IJ) / 2.0f) + f, f4);
        }
        path.lineTo(this.borderRadius + f, f4);
        path.addArc(new RectF(f, f6, f7, f4), 90.0f, 90.0f);
        if (this.IH == LikeBoxCountViewCaretPosition.LEFT) {
            f4 -= f2;
            path.lineTo(f, ((this.IJ + f4) / 2.0f) + f2);
            path.lineTo(f - this.II, (f4 / 2.0f) + f2);
            path.lineTo(f, ((f4 - this.IJ) / 2.0f) + f2);
        }
        path.lineTo(f, f2 + this.borderRadius);
        canvas.drawPath(path, this.borderPaint);
    }
}
