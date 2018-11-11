package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.util.bf;
import com.iqoption.x.R;

public class ChartTypeView extends FrameLayout {
    private TextView bhq;
    private ImageView bmu;
    private View dAG;

    public ChartTypeView(Context context) {
        super(context);
        init();
    }

    public ChartTypeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ChartTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public ChartTypeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.chart_type_button, this, true);
        this.bmu = (ImageView) findViewById(R.id.icon);
        this.bhq = (TextView) findViewById(R.id.text);
        this.dAG = findViewById(R.id.dot);
        setSelected(false);
    }

    public void setIsShowDot(boolean z) {
        this.dAG.setVisibility(z ? 0 : 8);
    }

    public void aB(int i, int i2) {
        setChartType(i);
        this.bhq.setText(bf.gI(i2));
    }

    private void setChartType(int i) {
        switch (i) {
            case 0:
                this.bmu.setImageResource(R.drawable.ic_icon_view2);
                return;
            case 1:
                this.bmu.setImageResource(R.drawable.ic_icon_view1);
                return;
            case 2:
                this.bmu.setImageResource(R.drawable.ic_icon_view3);
                return;
            case 3:
                this.bmu.setImageResource(R.drawable.ic_icon_view4);
                return;
            default:
                return;
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
    }
}
