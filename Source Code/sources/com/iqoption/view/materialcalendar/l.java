package com.iqoption.view.materialcalendar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.widget.ImageView;

/* compiled from: DirectionButton */
class l extends ImageView {
    public l(Context context) {
        super(context);
        setBackgroundResource(bX(context));
    }

    public void setColor(int i) {
        setColorFilter(i, Mode.SRC_ATOP);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.1f);
    }

    private static int bX(Context context) {
        int identifier = context.getResources().getIdentifier("selectableItemBackgroundBorderless", "attr", context.getPackageName());
        if (identifier == 0) {
            identifier = VERSION.SDK_INT >= 21 ? 16843868 : 16843534;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(identifier, typedValue, true);
        return typedValue.resourceId;
    }
}
