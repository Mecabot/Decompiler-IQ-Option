package com.jumio.nv.liveness.overlay;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.internal.view.SupportMenu;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.Log.LogLevel;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.SVGImageView;
import com.jumio.commons.view.SVGParser;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.overlay.Overlay;
import com.jumio.nv.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import java.util.ArrayList;
import java.util.Stack;

public class LivenessOverlay implements Overlay {
    private static final String SVG_LIVENESS_FACE_SILOUETTE = "M129.750958,0.857667941 C129.668068,0.856927808 129.585054,0.856557377 129.501916,0.856557377 C44.9277868,0.856557377 3.03365272e-15,76.7295082 0,120.864754 C0,165 1.49425287,217.565574 3.48659004,241.864754 C4.26227615,251.32527 6.47509579,278.065574 23.4099617,303.356557 C40.2303881,328.476634 89.7830524,383.439256 129.196952,384.180942 C129.298651,384.185993 129.4003,384.188525 129.501916,384.188525 C129.584883,384.188525 129.667898,384.18828 129.750958,384.187792 C129.834018,384.18828 129.917032,384.188525 130,384.188525 C130.101615,384.188525 130.203263,384.185993 130.304942,384.180943 C169.718853,383.439267 219.271526,328.476637 236.091954,303.356557 C253.02682,278.065574 255.23964,251.32527 256.015326,241.864754 C258.007663,217.565574 259.501916,165 259.501916,120.864754 C259.501916,76.7295082 214.574129,0.856557377 130,0.856557377 C129.916861,0.856557377 129.833847,0.856927808 129.750958,0.857667941 Z";
    private static final Stack<String> SVG_LIVENESS_ROTATE_IMAGE = new Stack<String>() {
        {
            add("M222 4341 c-61 -21 -114 -61 -159 -120 -65 -84 -63 -47 -63 -1092 0 -683 3 -962 12 -998 21 -93 125 -199 232 -237 47 -17 100 -19 768 -22 l718 -3 0 -742 c0 -796 0 -799 51 -899 30 -58 119 -150 177 -180 26 -14 72 -31 102 -38 82 -17 1980 -10 2033 8 108 37 233 178 256 288 9 46 11 484 9 1934 l-3 1875 -28 56 c-32 66 -99 132 -165 162 l-47 22 -1920 2 c-1839 2 -1922 2 -1973 -16z m348 -1216 l0 -1075 -116 0 c-64 0 -135 6 -158 12 -52 16 -108 72 -124 124 -9 31 -12 261 -12 946 l0 904 28 55 c22 45 36 59 81 82 51 25 63 27 178 27 l123 0 0 -1075z m3050 0 l0 -1075 -1440 0 -1440 0 0 1075 0 1075 1440 0 1440 0 0 -1075z m471 1048 c45 -23 59 -37 82 -82 l27 -55 0 -904 c0 -685 -3 -915 -12 -946 -16 -52 -72 -108 -124 -124 -23 -6 -94 -12 -158 -12 l-116 0 0 1075 0 1075 123 0 c115 0 127 -2 178 -27z m109 -2838 l0 -595 -1150 0 -1150 0 0 565 0 565 1043 0 c670 0 1065 4 1106 11 35 5 80 18 100 29 20 11 39 19 44 20 4 0 7 -268 7 -595z m0 -848 c0 -120 -21 -180 -84 -244 -88 -88 -26 -84 -1087 -81 l-924 3 -51 27 c-101 53 -143 131 -151 279 l-6 99 1152 0 1151 0 0 -83z");
            add("M312 3335 l-32 -27 0 -109 c0 -103 1 -111 25 -134 33 -34 80 -33 117 2 27 26 28 30 28 129 0 92 -2 105 -22 128 -35 40 -78 43 -116 11z");
            add("M311 2604 c-44 -37 -44 -91 1 -129 84 -71 186 48 109 126 -36 36 -70 37 -110 3z");
            add("M3935 4054 c-25 -26 -25 -30 -25 -202 l0 -176 27 -28 c35 -37 84 -38 118 -3 25 24 25 26 25 205 0 179 0 181 -25 205 -34 35 -88 34 -120 -1z");
            add("M3939 2601 l-29 -29 0 -177 c0 -173 0 -176 25 -200 35 -36 96 -35 124 1 19 25 21 40 21 206 l0 179 -26 24 c-37 34 -78 33 -115 -4z");
            add("M2919 421 c-36 -36 -37 -70 -3 -110 l26 -31 109 0 c103 0 111 1 134 25 34 33 33 80 -2 117 -26 27 -30 28 -131 28 -101 0 -104 -1 -133 -29z");
            add("M3649 421 c-80 -81 33 -199 116 -121 37 35 35 90 -6 124 -40 34 -74 33 -110 -3z");
            add("M155 1578 c-27 -32 -27 -34 -21 -131 29 -418 299 -779 701 -936 103 -41 273 -81 342 -81 70 0 68 -11 -17 -95 -71 -71 -80 -84 -80 -116 0 -29 7 -43 31 -63 57 -48 67 -43 256 147 146 146 173 177 173 202 0 25 -27 58 -171 205 -155 158 -173 174 -204 174 -48 0 -85 -36 -85 -84 0 -32 10 -48 77 -120 l77 -83 -59 7 c-388 47 -702 283 -817 616 -29 84 -39 136 -48 245 -7 90 -11 102 -35 122 -39 35 -87 31 -120 -9z");
        }
    };
    private Paint backgroundPaint;
    private Path backgroundPath;
    private int borderColor;
    private Paint borderPaint;
    private Path borderPath;
    protected Context context;
    private TextView descriptionTextView;
    private ArrayList<String> faceDetails;
    private Paint faceDetailsPaint;
    private int faceFoundColor;
    private Paint facePaint;
    private Paint facePositionPaint;
    private RectF facePositionRect;
    protected int h = 0;
    private TextView hintTextView;
    private int noFaceFoundColor;
    protected Rect overlayBounds;
    private Paint validAlignmentPaint;
    private RectF validAlignmentRect;
    private boolean visible = true;
    protected int w = 0;

    public LivenessOverlay(Context context) {
        this.context = context;
        TypedValue typedValue = new TypedValue();
        Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.netverify_scanOverlayLivenessInvalid, typedValue, true);
        this.noFaceFoundColor = typedValue.data;
        theme.resolveAttribute(R.attr.netverify_scanOverlayLivenessValid, typedValue, true);
        this.faceFoundColor = typedValue.data;
        theme.resolveAttribute(R.attr.netverify_scanOverlay, typedValue, true);
        this.borderColor = typedValue.data;
        this.borderPaint = new Paint();
        this.borderPaint.setColor(this.borderColor);
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setDither(true);
        this.borderPaint.setStrokeJoin(Join.ROUND);
        this.borderPaint.setStrokeCap(Cap.ROUND);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx(context, 2));
        this.facePaint = new Paint();
        this.facePaint.setColor(0);
        this.facePaint.setStyle(Style.FILL);
        this.facePaint.setDither(true);
        this.facePaint.setAntiAlias(true);
        theme.resolveAttribute(R.attr.netverify_scanOverlayLivenessBackground, typedValue, true);
        this.backgroundPaint = new Paint();
        this.backgroundPaint.setColor(typedValue.data);
        this.backgroundPaint.setStyle(Style.FILL);
        this.backgroundPaint.setDither(true);
        this.backgroundPaint.setStrokeJoin(Join.ROUND);
        this.backgroundPaint.setStrokeCap(Cap.ROUND);
        this.backgroundPaint.setAntiAlias(true);
        if (Log.isLogEnabledForLevel(LogLevel.DEBUG)) {
            this.facePositionPaint = new Paint();
            this.facePositionPaint.setColor(SupportMenu.CATEGORY_MASK);
            this.facePositionPaint.setStyle(Style.STROKE);
            this.facePositionPaint.setDither(true);
            this.facePositionPaint.setAntiAlias(true);
            this.validAlignmentPaint = new Paint();
            this.validAlignmentPaint.setColor(-16711936);
            this.validAlignmentPaint.setStyle(Style.STROKE);
            this.validAlignmentPaint.setDither(true);
            this.validAlignmentPaint.setAntiAlias(true);
            this.faceDetailsPaint = new Paint();
            this.faceDetailsPaint.setColor(SupportMenu.CATEGORY_MASK);
            this.faceDetailsPaint.setTextSize(48.0f);
            this.faceDetailsPaint.setDither(true);
            this.faceDetailsPaint.setAntiAlias(true);
        }
        this.overlayBounds = new Rect();
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        this.w = rect.width();
        this.h = rect.height();
        int height = (int) (((float) rect.height()) * 0.7f);
        int i = (int) ((((float) height) * 2.0f) / 3.0f);
        if (i > ((int) (((float) rect.width()) * 0.65f))) {
            i = (int) (((float) rect.width()) * 0.6f);
            height = (int) (((float) i) * 1.5f);
        }
        this.overlayBounds.left = (rect.width() - i) / 2;
        this.overlayBounds.right = this.overlayBounds.left + i;
        this.overlayBounds.top = (int) (((float) rect.height()) * 0.2f);
        this.overlayBounds.bottom = this.overlayBounds.top + height;
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
        TypedValue typedValue = new TypedValue();
        Theme theme = this.context.getTheme();
        theme.resolveAttribute(R.attr.netverify_scanOverlayLivenessText, typedValue, true);
        int dpToPx = ScreenUtil.dpToPx(this.context, 10);
        this.descriptionTextView = new TextView(this.context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        this.descriptionTextView.setTextColor(typedValue.data);
        this.descriptionTextView.setTextSize(2, 17.0f);
        this.descriptionTextView.setGravity(1);
        this.descriptionTextView.setLayoutParams(layoutParams);
        this.descriptionTextView.setText(Strings.getExternalString(this.context, NVStrings.SCANVIEW_LIVENESS_DESCRIPTION));
        viewGroup.addView(this.descriptionTextView);
        dpToPx = ScreenUtil.dpToPx(this.context, 9);
        this.hintTextView = new TextView(this.context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        int i = dpToPx * 2;
        this.hintTextView.setPadding(i, dpToPx, i, dpToPx);
        this.hintTextView.setTextColor(typedValue.data);
        theme.resolveAttribute(R.attr.netverify_scanOverlayLivenessBackground, typedValue, true);
        this.hintTextView.setBackgroundColor(typedValue.data);
        this.hintTextView.setTextSize(2, 17.0f);
        this.hintTextView.setGravity(1);
        this.hintTextView.setLayoutParams(layoutParams);
        this.hintTextView.setVisibility(4);
        viewGroup.addView(this.hintTextView);
    }

    public static RelativeLayout getRotationLayout(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.nv_helpview_land, null);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.netverify_helpImage, typedValue, true);
        int dpToPx = ScreenUtil.dpToPx(context, 170);
        View sVGImageView = new SVGImageView(context);
        sVGImageView.setLayoutParams(new RelativeLayout.LayoutParams(dpToPx, dpToPx));
        sVGImageView.setMaxWidth(dpToPx);
        sVGImageView.setMaxHeight(dpToPx);
        sVGImageView.setPaintColor(typedValue.data);
        sVGImageView.setPathStringStack(SVG_LIVENESS_ROTATE_IMAGE);
        ((LinearLayout) relativeLayout.findViewById(R.id.doctype_container)).addView(sVGImageView);
        ((TextView) relativeLayout.findViewById(R.id.helpview_doctype_title)).setText(Html.fromHtml(Strings.getExternalString(context, NVStrings.SCANVIEW_LIVENESS_LANDSCAPE_HEADER)));
        ((TextView) relativeLayout.findViewById(R.id.helpview_scan_instructions)).setText(Strings.getExternalString(context, NVStrings.SCANVIEW_LIVENESS_LANDSCAPE_DESCRIPTION));
        relativeLayout.findViewById(R.id.helpview_progress_info).setVisibility(4);
        relativeLayout.findViewById(R.id.helpview_fallback_button).setVisibility(4);
        relativeLayout.findViewById(R.id.help_background).setBackgroundColor(0);
        return relativeLayout;
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        this.descriptionTextView.setTranslationY((float) this.overlayBounds.bottom);
        this.hintTextView.setY((float) (this.overlayBounds.top + ScreenUtil.dpToPx(this.context, 100)));
        this.backgroundPath = new Path();
        this.backgroundPath.setFillType(FillType.EVEN_ODD);
        this.backgroundPath.addRect(0.0f, 0.0f, (float) this.w, (float) this.h, Direction.CW);
        this.borderPath = null;
        RectF rectF = new RectF();
        this.borderPath = SVGParser.createPathFromSvgString(SVG_LIVENESS_FACE_SILOUETTE);
        this.borderPath.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, new RectF(this.overlayBounds), ScaleToFit.CENTER);
        this.borderPath.transform(matrix);
        this.backgroundPath.addPath(this.borderPath);
        if (Log.isLogEnabledForLevel(LogLevel.DEBUG)) {
            this.facePositionRect = new RectF();
            this.validAlignmentRect = new RectF();
            this.faceDetails = new ArrayList();
        }
    }

    public void doDraw(Canvas canvas) {
        if (this.visible) {
            if (!(this.borderPath == null || this.borderPaint == null)) {
                canvas.drawPath(this.borderPath, this.borderPaint);
            }
            if (!(this.borderPath == null || this.facePaint == null)) {
                canvas.drawPath(this.borderPath, this.facePaint);
            }
            if (!(this.backgroundPath == null || this.backgroundPaint == null)) {
                canvas.drawPath(this.backgroundPath, this.backgroundPaint);
            }
            if (Log.isLogEnabledForLevel(LogLevel.DEBUG)) {
                if (!(this.facePositionRect == null || this.facePositionPaint == null)) {
                    canvas.drawRect(this.facePositionRect, this.facePositionPaint);
                }
                if (!(this.validAlignmentRect == null || this.validAlignmentPaint == null)) {
                    canvas.drawRect(this.validAlignmentRect, this.validAlignmentPaint);
                }
                if (!(this.faceDetails == null || this.faceDetailsPaint == null)) {
                    for (int i = 0; i < this.faceDetails.size(); i++) {
                        canvas.drawText((String) this.faceDetails.get(i), this.facePositionRect.centerX(), this.facePositionRect.centerY() + ((float) (i * 48)), this.faceDetailsPaint);
                    }
                }
            }
        }
    }

    public void update(ExtractionUpdate extractionUpdate) {
        if (extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentOutOfBounds) {
            this.borderPaint.setColor(this.borderColor);
            this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx(this.context, 2));
            this.facePaint.setColor(0);
            this.descriptionTextView.setVisibility(0);
        } else if (extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentValid) {
            this.borderPaint.setColor(this.faceFoundColor);
            this.borderPaint.setStrokeWidth((float) (ScreenUtil.dpToPx(this.context, 2) * 3));
            this.hintTextView.setVisibility(4);
        } else if (extractionUpdate.getState() == LivenessExtractionUpdateState.faceAlignmentInvalid) {
            this.borderPaint.setColor(this.noFaceFoundColor);
            this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx(this.context, 2));
            Bundle bundle = (Bundle) extractionUpdate.getData();
            if (bundle == null) {
                return;
            }
            if (bundle.getBoolean(LivenessExtractionUpdateState.faceAlignmentInvalid_small, false)) {
                this.hintTextView.setText(Strings.getExternalString(this.context, NVStrings.SCANVIEW_LIVENESS_MOVE_CLOSER));
                this.hintTextView.setVisibility(0);
            } else if (bundle.getBoolean(LivenessExtractionUpdateState.faceAlignmentInvalid_big, false)) {
                this.hintTextView.setText(Strings.getExternalString(this.context, NVStrings.SCANVIEW_LIVENESS_MOVE_BACK));
                this.hintTextView.setVisibility(0);
            } else {
                this.hintTextView.setVisibility(4);
            }
        } else if (extractionUpdate.getState() == LivenessExtractionUpdateState.onStartedCaptureLiveness) {
            this.borderPaint.setColor(0);
            this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx(this.context, 2));
            this.descriptionTextView.setVisibility(4);
        } else if (Log.isLogEnabledForLevel(LogLevel.DEBUG) && extractionUpdate.getState() == LivenessExtractionUpdateState.facePosition) {
            this.facePositionRect.set((RectF) extractionUpdate.getData());
        } else if (Log.isLogEnabledForLevel(LogLevel.DEBUG) && extractionUpdate.getState() == LivenessExtractionUpdateState.validAlignmentFrame) {
            this.validAlignmentRect.set((RectF) extractionUpdate.getData());
        } else if (Log.isLogEnabledForLevel(LogLevel.DEBUG) && extractionUpdate.getState() == LivenessExtractionUpdateState.faceDetails) {
            this.faceDetails.clear();
            this.faceDetails.addAll((ArrayList) extractionUpdate.getData());
        }
    }

    public void setVisible(int i) {
        float f = 0.0f;
        this.descriptionTextView.setAlpha(i == 0 ? 1.0f : 0.0f);
        TextView textView = this.hintTextView;
        if (i == 0) {
            f = 1.0f;
        }
        textView.setAlpha(f);
        this.visible = i == 0;
    }

    public Rect getOverlayBounds() {
        return this.overlayBounds;
    }
}
