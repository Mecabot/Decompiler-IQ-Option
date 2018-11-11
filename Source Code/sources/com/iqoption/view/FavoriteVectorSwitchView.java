package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.iqoption.x.R;

public class FavoriteVectorSwitchView extends ImageView {
    private boolean dAm = false;

    public FavoriteVectorSwitchView(Context context) {
        super(context);
    }

    public FavoriteVectorSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public FavoriteVectorSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public FavoriteVectorSwitchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        setSwitched(this.dAm);
    }

    public boolean aHX() {
        return this.dAm;
    }

    public void setSwitched(boolean z) {
        this.dAm = z;
        if (this.dAm) {
            setImageResource(R.drawable.ic_asset_favorite_switched);
        } else {
            setImageResource(R.drawable.ic_asset_favorite);
        }
    }
}
