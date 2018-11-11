package com.facebook.share.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.a;
import com.facebook.common.a.g;
import com.facebook.f;

@Deprecated
/* compiled from: LikeButton */
public class c extends f {
    protected int getDefaultRequestCode() {
        return 0;
    }

    @Deprecated
    public c(Context context, boolean z) {
        super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        setSelected(z);
    }

    @Deprecated
    public void setSelected(boolean z) {
        super.setSelected(z);
        oh();
    }

    protected void a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.a(context, attributeSet, i, i2);
        oh();
    }

    protected int getDefaultStyleResource() {
        return g.com_facebook_button_like;
    }

    private void oh() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(com.facebook.common.a.c.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(a.f.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(com.facebook.common.a.c.com_facebook_button_icon, 0, 0, 0);
        setText(getResources().getString(a.f.com_facebook_like_button_not_liked));
    }
}
