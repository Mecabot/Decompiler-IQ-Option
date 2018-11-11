package com.iqoption.view.blurtextureview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.iqoption.util.f;
import com.iqoption.x.R;

/* compiled from: BlurRenderSimpleImpl */
public class c extends b {
    public c(View view) {
        super(view);
        this.dEZ = aIP();
        this.dEY = 1;
    }

    public void destroy() {
        if (this.dEZ != null) {
            this.dEZ.recycle();
        }
    }

    private Bitmap aIP() {
        Resources resources = this.mView.getResources();
        return f.a(resources, R.drawable.blur_background, resources.getDisplayMetrics().widthPixels, resources.getDisplayMetrics().heightPixels);
    }
}
