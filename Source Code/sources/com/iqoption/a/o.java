package com.iqoption.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.dto.PaymentSystem;
import com.iqoption.util.ay;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: PaysystemAdapter */
public class o extends ArrayAdapter {
    private int ahq;
    private int ahr;
    private List<PaymentSystem> ahs;
    private int iconId;
    private Context mContext;

    public int getCount() {
        return this.ahs.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(this.ahq, null);
            view.setMinimumHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.dp48));
        }
        PaymentSystem paymentSystem = (PaymentSystem) this.ahs.get(i);
        ((TextView) view.findViewById(this.ahr)).setText(paymentSystem.toString());
        ((ImageView) view.findViewById(this.iconId)).setImageResource(ay.jN(paymentSystem.className));
        return view;
    }

    /* renamed from: cu */
    public PaymentSystem getItem(int i) {
        return (PaymentSystem) this.ahs.get(i);
    }
}
