package com.iqoption.a.d;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.iqoption.util.bg;
import com.iqoption.view.WidthPickerView;
import com.iqoption.x.R;

/* compiled from: WidthPickerAdapter */
public class b extends Adapter<ViewHolder> {
    private final com.iqoption.a.b.a afB;
    private int mSelectedPosition = 0;

    /* compiled from: WidthPickerAdapter */
    public static class a extends ViewHolder implements OnClickListener {
        private View aiS;
        private com.iqoption.a.b.a listener;

        a(View view, View view2, com.iqoption.a.b.a aVar) {
            super(view);
            this.aiS = view2;
            this.itemView.setOnClickListener(this);
            this.listener = aVar;
        }

        public void onClick(View view) {
            if (this.listener != null) {
                this.listener.a(view, getAdapterPosition());
            }
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public b(com.iqoption.a.b.a aVar) {
        this.afB = aVar;
    }

    public void cD(int i) {
        int i2 = this.mSelectedPosition;
        this.mSelectedPosition = i;
        notifyItemChanged(i2);
        notifyItemChanged(i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        i = viewGroup.getResources().getDimensionPixelOffset(R.dimen.dp180) / 4;
        int dimensionPixelOffset = viewGroup.getResources().getDimensionPixelOffset(R.dimen.dp10);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -1);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        bg.setBackground(frameLayout, ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.selecter_color_picker_item));
        View view = new View(viewGroup.getContext());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 1);
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(-1);
        frameLayout.addView(view);
        return new a(frameLayout, view, this.afB);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        aVar.aiS.getLayoutParams().height = (int) WidthPickerView.dEx[i];
        if (i == this.mSelectedPosition) {
            viewHolder.itemView.setSelected(true);
        } else {
            viewHolder.itemView.setSelected(false);
        }
        ViewCompat.postInvalidateOnAnimation(aVar.aiS);
    }

    public int getItemCount() {
        return WidthPickerView.dEx.length;
    }
}
