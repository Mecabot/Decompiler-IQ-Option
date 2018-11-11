package com.iqoption.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: ShortTimerIntervalAdapter */
public class s extends Adapter<ViewHolder> {
    private final boolean aib;
    private int aic = 0;
    private com.iqoption.a.b.a aie;
    List<ChartTimeInterval> aif;
    private int textColor;

    /* compiled from: ShortTimerIntervalAdapter */
    public static class a extends ViewHolder implements OnClickListener {
        TextView aig;
        View itemView;
        com.iqoption.a.b.a listener;

        a(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.itemView = view;
            this.itemView.setOnClickListener(this);
            this.aig = (TextView) view.findViewById(R.id.name);
            this.listener = aVar;
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.listener != null) {
                this.listener.a(view, adapterPosition);
            }
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean onFailedToRecycleView(ViewHolder viewHolder) {
        return true;
    }

    public s(Context context, int i, boolean z, com.iqoption.a.b.a aVar) {
        this.textColor = i;
        this.aif = ChartTimeInterval.getChartTimeIntervalTemplates(context);
        this.aie = aVar;
        this.aib = z;
    }

    public void cy(int i) {
        this.aic = i;
    }

    public int getItemCount() {
        return this.aif.size();
    }

    public List<ChartTimeInterval> getItems() {
        return this.aif;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_string_item, viewGroup, false), this.aie);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        ChartTimeInterval chartTimeInterval = (ChartTimeInterval) this.aif.get(i);
        aVar.aig.setText(bf.gI(chartTimeInterval.value));
        aVar.aig.setEnabled(chartTimeInterval.isActual);
        aVar.aig.setTextColor(this.textColor);
        if (this.aib) {
            aVar.aig.setTypeface(com.iqoption.core.ext.a.g(aVar.aig, R.font.bold));
        } else {
            aVar.aig.setTypeface(com.iqoption.core.ext.a.g(aVar.aig, R.font.light));
        }
        if (i < this.aic) {
            aVar.aig.setAlpha(0.5f);
            aVar.itemView.setEnabled(false);
        } else {
            aVar.aig.setAlpha(1.0f);
            aVar.itemView.setEnabled(true);
        }
        aVar.itemView.setTag(Integer.valueOf(i));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
