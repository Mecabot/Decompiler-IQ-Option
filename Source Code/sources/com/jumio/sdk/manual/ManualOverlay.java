package com.jumio.sdk.manual;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.overlay.Overlay;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import com.jumio.sdk.view.fragment.BaseScanFragment;

public class ManualOverlay implements Overlay {
    private int height;
    private ImageView mShutterButton;
    private int width;

    public void doDraw(Canvas canvas) {
    }

    public ManualOverlay(Context context) {
        this.mShutterButton = new ImageView(context);
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        this.width = rect.width();
        this.height = rect.height();
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
        this.mShutterButton.setImageDrawable(BaseScanFragment.createShutterButton(viewGroup.getContext()));
        this.mShutterButton.setAdjustViewBounds(true);
        this.mShutterButton.setLayoutParams(new LayoutParams(-2, -2));
        this.mShutterButton.setVisibility(0);
        this.mShutterButton.setContentDescription("Shutter");
        this.mShutterButton.setClickable(true);
        viewGroup.addView(this.mShutterButton);
    }

    public void setVisible(int i) {
        this.mShutterButton.setVisibility(i);
    }

    public Rect getOverlayBounds() {
        return new Rect(0, 0, this.width, this.height);
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        LayoutParams layoutParams = (LayoutParams) this.mShutterButton.getLayoutParams();
        int dipToPx = (int) ScreenUtil.dipToPx(this.mShutterButton.getContext(), 4.0f);
        if (z2) {
            layoutParams.addRule(14, 1);
            layoutParams.addRule(15, 0);
            this.mShutterButton.setTranslationX(0.0f);
            this.mShutterButton.setTranslationY((float) ((this.height - this.mShutterButton.getHeight()) - dipToPx));
            return;
        }
        layoutParams.addRule(14, 0);
        layoutParams.addRule(15, 1);
        this.mShutterButton.setTranslationX((float) ((this.width - this.mShutterButton.getWidth()) - dipToPx));
        this.mShutterButton.setTranslationY(0.0f);
    }

    public void update(ExtractionUpdate extractionUpdate) {
        if (extractionUpdate.getState() == ExtractionUpdateState.receiveClickListener) {
            this.mShutterButton.setOnClickListener((OnClickListener) extractionUpdate.getData());
        }
    }
}
