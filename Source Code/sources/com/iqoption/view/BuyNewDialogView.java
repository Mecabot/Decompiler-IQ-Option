package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.iqoption.d.bs;
import com.iqoption.x.R;

public class BuyNewDialogView extends LinearLayout {
    private bs dAD;
    private OnClickListener dAE;

    public BuyNewDialogView(Context context) {
        super(context);
        init();
    }

    public BuyNewDialogView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BuyNewDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public BuyNewDialogView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        this.dAD = (bs) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.buy_new_dialog_view, this, true);
        setOrientation(1);
        setGravity(17);
        this.dAD.blK.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (BuyNewDialogView.this.dAE != null) {
                    BuyNewDialogView.this.dAE.onClick(view);
                }
            }
        });
    }

    public void setTimeToClose(String str) {
        this.dAD.blL.setText(str);
    }

    public void setBuyNewListener(OnClickListener onClickListener) {
        this.dAE = onClickListener;
    }
}
