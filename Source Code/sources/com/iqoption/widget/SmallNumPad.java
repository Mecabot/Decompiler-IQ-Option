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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.d.ajm;
import com.iqoption.view.d.c;
import com.iqoption.x.R;

public class SmallNumPad extends FrameLayout {
    private int dOK = 0;
    @Nullable
    private b dOX;
    private ajm dOY;

    private class a implements OnClickListener {
        private final int value;

        /* synthetic */ a(SmallNumPad smallNumPad, int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        private a(int i) {
            this.value = i;
        }

        public void onClick(View view) {
            if (SmallNumPad.this.dOX != null) {
                SmallNumPad.this.dOX.en(this.value);
            }
        }
    }

    public interface b {
        void en(int i);
    }

    public SmallNumPad(@NonNull Context context) {
        super(context);
        initialize();
    }

    public SmallNumPad(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        initialize();
    }

    public SmallNumPad(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        initialize();
    }

    @RequiresApi(api = 21)
    public SmallNumPad(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        b(context, attributeSet);
        initialize();
    }

    public void setKeyListener(@Nullable b bVar) {
        this.dOX = bVar;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.SmallNumPad, 0, 0);
        try {
            this.dOK = obtainStyledAttributes.getInt(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void aMI() {
        if (this.dOX != null) {
            this.dOX.en(67);
        }
    }

    private void initialize() {
        this.dOY = (ajm) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.small_numpad, this, true);
        this.dOY.bIK.setOnClickListener(new a(this, 145, null));
        this.dOY.bIV.setOnClickListener(new a(this, 146, null));
        this.dOY.bIS.setOnClickListener(new a(this, 147, null));
        this.dOY.bIC.setOnClickListener(new a(this, 148, null));
        this.dOY.bIB.setOnClickListener(new a(this, 149, null));
        this.dOY.bIQ.setOnClickListener(new a(this, 150, null));
        this.dOY.bIP.setOnClickListener(new a(this, 151, null));
        this.dOY.bIA.setOnClickListener(new a(this, 152, null));
        this.dOY.bIJ.setOnClickListener(new a(this, 153, null));
        this.dOY.bIW.setOnClickListener(new a(this, 144, null));
        new com.iqoption.view.text.r.a().ck(this.dOY.bMM).a(new c()).a(new com.iqoption.view.text.r.b() {
            public void aQ(View view) {
                SmallNumPad.this.aMI();
            }
        }).aJN();
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
            this.dOY.bMN.setText(charSequence);
            this.dOY.bMN.setOnClickListener(new a(this, i, null));
            return;
        }
        this.dOY.bMN.setText("");
        this.dOY.bMN.setClickable(false);
        this.dOY.bMN.setFocusable(false);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        a(this.dOY.buR, z);
        a(this.dOY.bMO, z);
        a(this.dOY.bMP, z);
        a(this.dOY.bMQ, z);
    }

    private void a(LinearLayout linearLayout, boolean z) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setEnabled(z);
        }
    }
}
