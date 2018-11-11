package com.iqoption.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.x.R;

public class DepositItem extends FrameLayout {
    private long dBE;
    private double dBF;
    private long dBG;
    private TextView dBH;
    private TextView dBI;
    private TextView dBJ;
    private View dBK;
    private int dBL;

    private void c(AttributeSet attributeSet) {
    }

    public DepositItem(Context context) {
        this(context, null);
    }

    public DepositItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DepositItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dBL = 0;
        c(attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.deposit_item, this, true);
        this.dBH = (TextView) findViewById(R.id.deposit);
        this.dBI = (TextView) findViewById(R.id.bonus);
        this.dBJ = (TextView) findViewById(R.id.result);
        this.dBK = findViewById(R.id.selector);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        this.dBK.setSelected(z);
    }

    public void setBonusVisibility(int i) {
        this.dBL = i;
        aIi();
    }

    private void aIi() {
        if (this.dBL == 0) {
            this.dBJ.setVisibility(0);
            this.dBI.setVisibility(0);
        } else if (this.dBL == 4 || this.dBL == 8) {
            this.dBJ.setVisibility(4);
            this.dBI.setVisibility(4);
        }
    }

    public double getDeposit() {
        return (double) this.dBE;
    }

    public double getBonus() {
        return this.dBF;
    }

    public double getResult() {
        return (double) this.dBG;
    }
}
