package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.PopupWindowCompat;
import android.util.AttributeSet;
import android.widget.PopupWindow;

public class IQListPopupWindow extends ListPopupWindow {
    public IQListPopupWindow(@NonNull Context context) {
        super(context);
    }

    public IQListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IQListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public IQListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public PopupWindow popupWindow() {
        return this.mPopup;
    }

    public void setOverlapAnchorPublic(boolean z) {
        PopupWindowCompat.setOverlapAnchor(this.mPopup, z);
    }
}
