package com.iqoption.widget.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.iqoption.util.bg;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

public class ErrorBubbleHelper {
    private int dPc;
    private PopupWindow dPd;
    private int dPe;
    private int dPf;
    private int dp10;
    private LayoutInflater layoutInflater;
    private int textSize;

    public enum BubbleGravity {
        left,
        right,
        top,
        bottom
    }

    public ErrorBubbleHelper(Context context, LayoutInflater layoutInflater) {
        this.dPc = (int) context.getResources().getDimension(R.dimen.deposit_card_error_bubble_top_bubble_height);
        this.dPe = (int) context.getResources().getDimension(R.dimen.deposit_card_item_height);
        this.dPf = (int) context.getResources().getDimension(R.dimen.deposit_card_error_bubble_width);
        this.dp10 = (int) context.getResources().getDimension(R.dimen.dp10);
        this.textSize = context.getResources().getDimensionPixelSize(R.dimen.dp12);
        this.layoutInflater = layoutInflater;
    }

    public boolean e(Context context, View view) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if ((iArr[1] + view.getHeight()) + this.dPc <= displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public boolean a(View view, BubbleGravity bubbleGravity) {
        return a(view, bubbleGravity, null);
    }

    public boolean a(View view, BubbleGravity bubbleGravity, @Nullable String str) {
        akr();
        if ((bubbleGravity == BubbleGravity.top || bubbleGravity == BubbleGravity.bottom) && bg.bT(view) < 0.99f) {
            return false;
        }
        PopupWindow a = a(view.getContext(), view, bubbleGravity, str);
        View contentView = a.getContentView();
        contentView.setAlpha(0.0f);
        contentView.animate().alpha(1.0f);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        switch (bubbleGravity) {
            case right:
                i += view.getWidth();
                break;
            case left:
                i -= this.dPf;
                break;
            case top:
                i += (view.getWidth() / 2) - (this.dPf / 2);
                i2 -= this.dPc;
                break;
            case bottom:
                i += (view.getWidth() / 2) - (this.dPf / 2);
                i2 += view.getHeight();
                break;
        }
        a.showAtLocation(view, 0, i, i2);
        this.dPd = a;
        return true;
    }

    public void akr() {
        if (this.dPd != null) {
            this.dPd.dismiss();
            this.dPd = null;
        }
    }

    public void p(Context context, @DimenRes int i) {
        this.dPe = (int) context.getResources().getDimension(i);
    }

    public void q(Context context, @DimenRes int i) {
        this.dPf = (int) context.getResources().getDimension(i);
    }

    public void r(Context context, @DimenRes int i) {
        this.textSize = context.getResources().getDimensionPixelSize(i);
    }

    private View a(ViewGroup viewGroup, BubbleGravity bubbleGravity) {
        View inflate;
        switch (bubbleGravity) {
            case right:
                inflate = this.layoutInflater.inflate(R.layout.deposit_card_error_bubble_left, viewGroup, false);
                f(inflate, 16, this.dp10);
                return inflate;
            case left:
                inflate = this.layoutInflater.inflate(R.layout.deposit_card_error_bubble_right, viewGroup, false);
                f(inflate, 16, this.dp10);
                return inflate;
            case top:
                inflate = this.layoutInflater.inflate(R.layout.deposit_card_error_bubble_top, viewGroup, false);
                f(inflate, 17, 0);
                return inflate;
            case bottom:
                inflate = this.layoutInflater.inflate(R.layout.deposit_card_error_bubble_bottom, viewGroup, false);
                f(inflate, 17, 0);
                return inflate;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown gravity ");
                stringBuilder.append(bubbleGravity);
                throw new RuntimeException(stringBuilder.toString());
        }
    }

    private void f(View view, int i, int i2) {
        RobotoTextView robotoTextView = (RobotoTextView) view.findViewById(R.id.ic_deposit_error_text);
        robotoTextView.getLayoutParams().height = this.dPe;
        robotoTextView.getLayoutParams().width = this.dPf;
        robotoTextView.setGravity(i);
        robotoTextView.setPadding(i2, i2, i2, i2);
        robotoTextView.setTextSize(0, (float) this.textSize);
        robotoTextView.reinit();
    }

    private PopupWindow a(Context context, View view, BubbleGravity bubbleGravity, @Nullable String str) {
        final PopupWindow popupWindow = new PopupWindow(context);
        if (!(view instanceof ViewGroup)) {
            view = view.getParent();
        }
        final View a = a((ViewGroup) view, bubbleGravity);
        a.getLayoutParams().height = this.dPe;
        a.getLayoutParams().width = this.dPf;
        if (!(TextUtils.isEmpty(str) || a.findViewById(R.id.ic_deposit_error_text) == null)) {
            ((TextView) a.findViewById(R.id.ic_deposit_error_text)).setText(str);
        }
        popupWindow.setContentView(a);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setHeight(-2);
        a.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        popupWindow.dismiss();
                    }
                });
            }
        });
        return popupWindow;
    }
}
