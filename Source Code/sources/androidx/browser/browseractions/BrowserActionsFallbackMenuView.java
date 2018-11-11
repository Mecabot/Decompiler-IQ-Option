package androidx.browser.browseractions;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.customtabs.R;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int dD = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
    private final int dE = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.dD * 2), this.dE), 1073741824), i2);
    }
}
