package com.iqoption.fragment.cashbox.a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: ExtraParamBaseView */
public abstract class b extends LinearLayout implements h {
    private final int bbU;
    private final int cta;
    private final int textSize;

    public b(Context context) {
        super(context);
        this.textSize = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_text_size);
        this.bbU = (int) context.getResources().getDimension(R.dimen.deposit_payment_constructor_vertical_padding);
        this.cta = ContextCompat.getColor(context, R.color.deposit_constructor_field_title);
    }

    protected TextView v(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setTextColor(this.cta);
        setTypeface(textView);
        textView.setTextSize(0, (float) this.textSize);
        textView.setPadding(0, this.bbU, 0, this.bbU);
        textView.setAllCaps(true);
        textView.setText(str);
        return textView;
    }

    private void setTypeface(TextView textView) {
        Typeface create = Typeface.create("sans-serif-medium", 0);
        if (create != null) {
            textView.setTypeface(create);
        }
    }
}
