package com.iqoption.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.iqoption.d.fq;
import com.iqoption.view.d.d;
import com.iqoption.x.R;

public class ConfirmDialogView extends LinearLayout {
    private fq dBg;
    private OnClickListener dBh;
    private OnClickListener dBi;

    public ConfirmDialogView(Context context) {
        this(context, null);
    }

    public ConfirmDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConfirmDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dBg = (fq) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.confirm_dialog_view, this, true);
        setOrientation(1);
        this.dBg.bob.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ConfirmDialogView.this.dBh != null) {
                    ConfirmDialogView.this.dBh.onClick(view);
                }
            }
        });
        this.dBg.bob.setOnTouchListener(new d(0.5f));
        this.dBg.boc.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ConfirmDialogView.this.dBi != null) {
                    ConfirmDialogView.this.dBi.onClick(view);
                }
            }
        });
        this.dBg.boc.setOnTouchListener(new d(0.5f));
    }

    public void setExpiration(String str) {
        this.dBg.bod.setText(str);
    }

    public void setLevel(String str) {
        this.dBg.boe.setText(str);
    }

    public void setType(boolean z) {
        this.dBg.bog.setImageResource(z ? R.drawable.arrow_green : R.drawable.arrow_red);
    }

    public void setConfirmListener(OnClickListener onClickListener) {
        this.dBh = onClickListener;
    }

    public void setCancelListener(OnClickListener onClickListener) {
        this.dBi = onClickListener;
    }
}
