package com.jumio.nv;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.jumio.commons.utils.DrawingUtil;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.overlay.Overlay;
import com.jumio.nv.gui.TextOverlayView;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class NVOverlay implements Overlay {
    private static final int FONT_ALPHA = 178;
    private static final int TEXT_OVERLAY_SIZE_IN_DP = 18;
    protected static final int TEXT_OVERLAY_TOP_MARGIN_IN_DP = 30;
    protected Paint backgroundPaint;
    private Path backgroundPath;
    protected Paint borderPaint;
    private Path borderPath;
    protected int h = 0;
    protected int leftOffset = 0;
    protected Context mContext;
    private boolean mInitialized = false;
    protected TextOverlayView mTextOverlayView;
    protected final AtomicInteger mVisibility = new AtomicInteger();
    protected int overlayBottomMargin = 0;
    protected int overlayBottomPixel = 0;
    protected int overlayHeight = 0;
    protected int overlayLeftMargin = 0;
    protected int overlayLeftPixel = 0;
    protected int overlayRightMargin = 0;
    protected int overlayRightPixel = 0;
    protected int overlayTopMargin = 0;
    protected int overlayTopPixel = 0;
    protected int overlayWidth = 0;
    protected int topOffset = 0;
    protected int w = 0;

    public class NVOverlayConfig {
        public int bottomLeftCornerRadius;
        public int bottomRightCornerRadius;
        public boolean dimBackground;
        public boolean drawBrackets;
        public int topLeftCornerRadius;
        public int topRightCornerRadius;
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
    }

    public abstract NVOverlayConfig getNetverifyOverlayConfiguration(Context context);

    public NVOverlay(Context context) {
        this.mContext = context;
        this.mTextOverlayView = new TextOverlayView();
        this.mTextOverlayView.setColor(-1);
        this.mTextOverlayView.setDropShadow(ViewCompat.MEASURED_STATE_MASK);
        this.mTextOverlayView.setStyle(Style.FILL);
        this.mTextOverlayView.setAlpha(FONT_ALPHA);
        this.mTextOverlayView.setTextSize(ScreenUtil.dipToPx(context, 18.0f));
        this.mTextOverlayView.setTypeface(Typeface.defaultFromStyle(3));
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        this.w = rect.width();
        this.h = rect.height();
        if ((((float) this.w) / ((float) this.h) >= 1.3333334f ? 1 : null) != null) {
            this.overlayHeight = this.h;
            this.overlayWidth = (this.overlayHeight * 4) / 3;
            this.topOffset = rect.top;
            this.leftOffset = ((this.w - this.overlayWidth) / 2) + rect.left;
        } else {
            this.overlayWidth = this.w;
            this.overlayHeight = (this.overlayWidth * 3) / 4;
            this.topOffset = ((this.h - this.overlayHeight) / 2) + rect.top;
            this.leftOffset = rect.left;
        }
        this.overlayLeftMargin = documentFormat.getOverlayLeftInPx(this.overlayWidth);
        this.overlayRightMargin = documentFormat.getOverlayRightInPx(this.overlayWidth);
        this.overlayTopMargin = documentFormat.getOverlayTopInPx(this.overlayHeight);
        this.overlayBottomMargin = documentFormat.getOverlayBottomInPx(this.overlayHeight);
        this.overlayRightPixel = this.w - (this.overlayRightMargin + this.leftOffset);
        this.overlayBottomPixel = this.h - (this.overlayBottomMargin + this.topOffset);
        this.overlayLeftPixel = this.overlayLeftMargin + this.leftOffset;
        this.overlayTopPixel = this.overlayTopMargin + this.topOffset;
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        NVOverlayConfig netverifyOverlayConfiguration = getNetverifyOverlayConfiguration(this.mContext);
        TypedValue typedValue = new TypedValue();
        Theme theme = this.mContext.getTheme();
        theme.resolveAttribute(R.attr.netverify_scanOverlay, typedValue, true);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(typedValue.data);
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setDither(true);
        this.borderPaint.setStrokeJoin(Join.ROUND);
        this.borderPaint.setStrokeCap(Cap.ROUND);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx(this.mContext, 2));
        theme.resolveAttribute(R.attr.netverify_scanBackground, typedValue, true);
        this.backgroundPaint = new Paint();
        this.backgroundPaint.setColor(typedValue.data);
        this.backgroundPaint.setStyle(Style.FILL);
        this.backgroundPaint.setDither(true);
        this.backgroundPaint.setStrokeJoin(Join.ROUND);
        this.backgroundPaint.setStrokeCap(Cap.ROUND);
        this.backgroundPaint.setAntiAlias(true);
        if (netverifyOverlayConfiguration.drawBrackets) {
            this.borderPath = DrawingUtil.createRectWithRoundedCornersAsPath(getOverlayBounds(), netverifyOverlayConfiguration.topLeftCornerRadius, netverifyOverlayConfiguration.topRightCornerRadius, netverifyOverlayConfiguration.bottomLeftCornerRadius, netverifyOverlayConfiguration.bottomRightCornerRadius);
        }
        if (netverifyOverlayConfiguration.dimBackground) {
            this.backgroundPath = new Path();
            this.backgroundPath.setFillType(FillType.EVEN_ODD);
            this.backgroundPath.addRect(0.0f, 0.0f, (float) this.w, (float) this.h, Direction.CW);
            this.backgroundPath.addPath(this.borderPath);
        }
        this.mInitialized = true;
    }

    public Rect getOverlayBounds() {
        return new Rect(this.overlayLeftPixel, this.overlayTopPixel, this.overlayRightPixel, this.overlayBottomPixel);
    }

    public void setVisible(int i) {
        this.mVisibility.set(i);
    }

    public void doDraw(Canvas canvas) {
        if (this.mVisibility.get() == 0 && this.mInitialized) {
            if (this.borderPath != null) {
                canvas.drawPath(this.borderPath, this.borderPaint);
            }
            if (this.backgroundPath != null) {
                canvas.drawPath(this.backgroundPath, this.backgroundPaint);
            }
        }
    }
}
