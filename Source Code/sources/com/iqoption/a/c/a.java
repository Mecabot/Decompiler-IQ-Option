package com.iqoption.a.c;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.app.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: KeyboardPresetAdapter */
public class a extends Adapter {
    private com.iqoption.a.b.a afB = null;
    private ArrayList<String> aiO = new ArrayList();
    private ArrayList<String> aiP = new ArrayList();
    private double[] aiQ = new double[]{0.01d, 0.02d, 0.04d, 0.05d, 0.1d, 0.2d, 0.25d, 0.4d, 0.5d, 1.0d};
    private double[] aiR = new double[]{0.005d, 0.01d, 0.02d, 0.04d, 0.08d, 0.1d, 0.2d, 0.3d, 0.4d, 0.5d};
    private int type;

    /* compiled from: KeyboardPresetAdapter */
    public static class a extends ViewHolder implements OnClickListener {
        TextView aip;
        com.iqoption.a.b.a listener;

        a(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.aip = (TextView) view;
            this.listener = aVar;
            if (this.listener != null) {
                this.aip.setOnClickListener(this);
            }
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.listener != null && adapterPosition >= 0) {
                this.listener.a(view, adapterPosition);
            }
        }
    }

    public a(Context context, int i, @Nullable InstrumentType instrumentType, com.iqoption.a.b.a aVar) {
        this.type = i;
        this.afB = aVar;
        af aR = af.aR(context);
        for (Double a : aR.Eb()) {
            this.aiP.add(a(a));
        }
        if (this.aiP.size() > 3) {
            this.type = 1000;
        }
        double[] N = l.N(instrumentType);
        int i2 = 0;
        double d = N[0];
        if (d <= 0.0d) {
            d = 1.0d;
        }
        double DZ = aR.DZ();
        if (DZ == 0.0d) {
            DZ = d;
        }
        int intValue = com.iqoption.app.a.aL(context).Cx().intValue();
        double d2 = N[1];
        int i3 = (int) (100.0d * d);
        intValue = (intValue / i3) * i3;
        if (intValue < i3) {
            intValue = i3;
        }
        double d3 = (double) intValue;
        if (d3 > d2) {
            d3 = d2;
        }
        intValue = (int) d3;
        double d4 = (double) intValue;
        double[] dArr = (DZ > 0.2d * d4 || intValue <= i3) ? this.aiQ : this.aiR;
        while (i2 < dArr.length) {
            DZ = dArr[i2] * d4;
            if (DZ < d) {
                DZ = 1.0d;
            }
            if (DZ < d2) {
                this.aiO.add(Integer.toString((int) DZ));
            }
            i2++;
        }
        setHasStableIds(true);
    }

    private String a(Double d) {
        if (d == null) {
            return "0";
        }
        Locale locale;
        String str;
        Object[] objArr;
        if (Math.abs(d.doubleValue() - ((double) d.intValue())) > 0.001d) {
            locale = Locale.US;
            str = "%1.2f";
            objArr = new Object[]{d};
        } else {
            locale = Locale.US;
            str = "%1.0f";
            objArr = new Object[]{d};
        }
        return String.format(locale, str, objArr);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.keyboard_string_item, viewGroup, false), this.afB);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Object CD = com.iqoption.app.a.aL(viewHolder.itemView.getContext()).CD();
        CharSequence item = getItem(i);
        if (!TextUtils.isEmpty(CD)) {
            item = String.format(Locale.US, CD, new Object[]{item});
        }
        ((a) viewHolder).aip.setText(item);
    }

    public void Bd() {
        int i = 2000;
        if (this.type == 2000) {
            i = 1000;
        }
        this.type = i;
        notifyDataSetChanged();
    }

    public int Be() {
        return this.type;
    }

    public String getItem(int i) {
        return (String) (this.type == 2000 ? this.aiO : this.aiP).get(i);
    }

    public long getItemId(int i) {
        return (long) (i + this.type);
    }

    public int getItemCount() {
        if (this.type == 1000) {
            return this.aiP.size();
        }
        return this.type == 2000 ? this.aiO.size() : 0;
    }
}
