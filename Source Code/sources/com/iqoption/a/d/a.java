package com.iqoption.a.d;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.iqoption.util.bg;
import com.iqoption.view.ColorPickerView;
import com.iqoption.x.R;

/* compiled from: ColorPickerAdapter */
public class a extends Adapter<ViewHolder> {
    private final com.iqoption.a.b.a afB;
    private int mSelectedPosition = 0;

    /* compiled from: ColorPickerAdapter */
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

    public a(com.iqoption.a.b.a aVar) {
        this.afB = aVar;
    }

    public void cD(int i) {
        int i2 = this.mSelectedPosition;
        this.mSelectedPosition = i;
        if (i2 != -1) {
            notifyItemChanged(i2);
        }
        if (i != -1) {
            notifyItemChanged(i);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        i = viewGroup.getResources().getDimensionPixelOffset(R.dimen.dp15);
        int dimensionPixelOffset = viewGroup.getResources().getDimensionPixelOffset(R.dimen.dp10);
        int i2 = i + dimensionPixelOffset;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        dimensionPixelOffset /= 2;
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        bg.setBackground(frameLayout, ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.selecter_color_picker_item));
        View view = new View(viewGroup.getContext());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
        frameLayout.addView(view);
        return new a(frameLayout, view, this.afB);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(viewHolder.itemView.getContext(), R.drawable.color_picker_item);
        gradientDrawable.setColor(ColorPickerView.mF[i]);
        bg.setBackground(aVar.aiS, gradientDrawable);
        if (i == this.mSelectedPosition) {
            viewHolder.itemView.setSelected(true);
            aVar.aiS.setScaleX(0.7f);
            aVar.aiS.setScaleY(0.7f);
            return;
        }
        viewHolder.itemView.setSelected(false);
        aVar.aiS.setScaleX(1.0f);
        aVar.aiS.setScaleY(1.0f);
    }

    public int getItemCount() {
        return ColorPickerView.mF.length;
    }
}
