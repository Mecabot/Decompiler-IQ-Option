package com.iqoption.charttools.constructor.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.charttools.model.indicator.i;
import com.iqoption.charttools.o.g;
import com.iqoption.charttools.o.h;

public class WidthPicker extends LinearLayout {
    private a awI;
    private TextView awJ;
    private ImageView[] awK;

    public interface a {
        void dl(int i);
    }

    private static int z(View view) {
        return Integer.parseInt((String) view.getTag());
    }

    public WidthPicker(Context context) {
        super(context);
        aY(context);
    }

    public WidthPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aY(context);
    }

    public WidthPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aY(context);
    }

    private void aY(Context context) {
        setOrientation(0);
        View inflate = LayoutInflater.from(context).inflate(h.indicator_constructor_layout_width_picker, this, true);
        ImageView imageView = (ImageView) inflate.findViewById(g.width1);
        ImageView imageView2 = (ImageView) inflate.findViewById(g.width3);
        ImageView imageView3 = (ImageView) inflate.findViewById(g.width5);
        imageView.setSelected(true);
        imageView.setOnTouchListener(new com.iqoption.core.ui.widget.b.a());
        imageView2.setOnTouchListener(new com.iqoption.core.ui.widget.b.a());
        imageView3.setOnTouchListener(new com.iqoption.core.ui.widget.b.a());
        OnClickListener anonymousClass1 = new com.iqoption.core.ext.g() {
            public void q(@NonNull View view) {
                WidthPicker.this.setSelectedWidth(WidthPicker.z(view));
            }
        };
        imageView.setOnClickListener(anonymousClass1);
        imageView2.setOnClickListener(anonymousClass1);
        imageView3.setOnClickListener(anonymousClass1);
        this.awK = new ImageView[]{imageView, imageView2, imageView3};
        this.awJ = (TextView) findViewById(g.title);
    }

    public void setOnWidthChangeListener(a aVar) {
        this.awI = aVar;
    }

    public int getSelectedWidth() {
        int i = 0;
        int i2 = i.ayh[0];
        while (i < this.awK.length) {
            View view = this.awK[i];
            if (view.isSelected()) {
                return z(view);
            }
            i++;
        }
        return i2;
    }

    public void setSelectedWidth(int i) {
        View view = null;
        View view2 = view;
        for (View view3 : this.awK) {
            if (z(view3) == i) {
                view = view3;
            }
            if (view3.isSelected()) {
                view2 = view3;
            }
        }
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrong width ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (view != view2) {
            view.setSelected(true);
            if (view2 != null) {
                view2.setSelected(false);
            }
            if (this.awI != null) {
                this.awI.dl(i);
            }
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.awJ.setText(charSequence);
    }
}
