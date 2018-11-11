package com.iqoption.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.d.abu;
import com.iqoption.x.R;

public class NumPad extends FrameLayout {
    @Nullable
    private c dOH;
    @Nullable
    private a dOI;
    private abu dOJ;
    private int dOK = 0;
    private boolean dOL = false;
    private d dOM;

    public interface a {
        void eo(int i);
    }

    private class b implements OnClickListener {
        private final int value;

        private b(int i) {
            this.value = i;
        }

        public void onClick(View view) {
            if (NumPad.this.dOH != null) {
                NumPad.this.dOH.en(this.value);
            }
        }
    }

    public interface c {
        void en(int i);
    }

    private class d implements OnLongClickListener {
        private TextView bMR;
        private int value = 1;

        public d(TextView textView) {
            this.bMR = textView;
            aMH();
        }

        public boolean onLongClick(View view) {
            if (NumPad.this.dOI == null) {
                return false;
            }
            this.value = -this.value;
            NumPad.this.dOI.eo(this.value);
            aMH();
            return true;
        }

        private void aMH() {
            this.bMR.setText(this.value > 0 ? "-" : "+");
        }

        public void setSign(int i) {
            this.value = i > 0 ? 1 : -1;
            aMH();
        }

        public int getSign() {
            return this.value;
        }
    }

    public NumPad(@NonNull Context context) {
        super(context);
        initialize();
    }

    public NumPad(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        initialize();
    }

    public NumPad(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        initialize();
    }

    @RequiresApi(api = 21)
    public NumPad(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
        initialize();
    }

    public void setKeyListener(@Nullable c cVar) {
        this.dOH = cVar;
    }

    public void setChangeSignListener(@Nullable a aVar) {
        this.dOI = aVar;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.NumPad, 0, 0);
        try {
            this.dOK = obtainStyledAttributes.getInt(1, 0);
            this.dOL = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initialize() {
        this.dOJ = (abu) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.numpad, this, true);
        this.dOJ.bIK.setOnClickListener(new b(145));
        this.dOJ.bIV.setOnClickListener(new b(146));
        this.dOJ.bIS.setOnClickListener(new b(147));
        this.dOJ.bIC.setOnClickListener(new b(148));
        this.dOJ.bIB.setOnClickListener(new b(149));
        this.dOJ.bIQ.setOnClickListener(new b(150));
        this.dOJ.bIP.setOnClickListener(new b(151));
        this.dOJ.bIA.setOnClickListener(new b(152));
        this.dOJ.bIJ.setOnClickListener(new b(153));
        this.dOJ.bMS.setOnClickListener(new b(144));
        this.dOJ.bMM.setOnClickListener(new b(67));
        int i = 0;
        if (this.dOK != 0) {
            CharSequence charSequence;
            switch (this.dOK) {
                case 1:
                    i = 81;
                    charSequence = "+";
                    break;
                case 2:
                    i = 158;
                    charSequence = ".";
                    break;
                default:
                    charSequence = "";
                    break;
            }
            this.dOJ.bMN.setText(charSequence);
            this.dOJ.bMN.setOnClickListener(new b(i));
        } else {
            this.dOJ.bMN.setVisibility(4);
            this.dOJ.bMN.setClickable(false);
            this.dOJ.bMN.setFocusable(false);
        }
        if (this.dOL) {
            this.dOM = new d(this.dOJ.bMR);
            this.dOJ.bMS.setOnLongClickListener(this.dOM);
            this.dOM.aMH();
            return;
        }
        this.dOJ.bMR.setText(" ");
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        a(this.dOJ.buR, z);
        a(this.dOJ.bMO, z);
        a(this.dOJ.bMP, z);
        a(this.dOJ.bMQ, z);
    }

    private void a(LinearLayout linearLayout, boolean z) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setEnabled(z);
        }
    }

    public void setSign(int i) {
        if (this.dOM != null) {
            this.dOM.setSign(i);
        }
    }

    public int getSign() {
        return this.dOM != null ? this.dOM.getSign() : 1;
    }
}
