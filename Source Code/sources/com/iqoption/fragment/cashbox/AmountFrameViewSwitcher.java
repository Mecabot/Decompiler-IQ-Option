package com.iqoption.fragment.cashbox;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewAnimator;
import com.iqoption.x.R;

public class AmountFrameViewSwitcher extends ViewAnimator {
    private BorderType cwm;

    public enum BorderType {
        transparentBorder,
        greenBorder,
        redBorder,
        orangeBorder
    }

    public AmountFrameViewSwitcher(Context context) {
        super(context);
        initialize(context);
    }

    public AmountFrameViewSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public void a(BorderType borderType) {
        if (this.cwm != borderType) {
            setDisplayedChild(borderType.ordinal());
            this.cwm = borderType;
        }
    }

    private void initialize(Context context) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.long_fade_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.long_fade_out);
        setInAnimation(loadAnimation);
        setOutAnimation(loadAnimation2);
        au(R.drawable.textfield_registartion_dialog, BorderType.transparentBorder.ordinal());
        au(R.drawable.deposit_amount_green_border_for_switch, BorderType.greenBorder.ordinal());
        au(R.drawable.deposit_amount_red_border_for_switch, BorderType.redBorder.ordinal());
        au(R.drawable.deposit_amount_orange_border_for_switch, BorderType.orangeBorder.ordinal());
        this.cwm = BorderType.values()[0];
    }

    private void au(@DrawableRes int i, int i2) {
        View view = new View(getContext());
        view.setBackgroundResource(i);
        addView(view, i2, new LayoutParams(-1, -1));
    }
}
