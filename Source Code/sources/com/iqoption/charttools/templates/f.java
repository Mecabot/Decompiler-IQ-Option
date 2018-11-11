package com.iqoption.charttools.templates;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: InstrumentItemsDecoration */
final class f extends ItemDecoration {
    private static final int[] auG = new int[]{65538, 131074, 131073};
    private static final int[] auH = new int[]{0, 1, 16};
    private static int[] auI;
    private final a azm;

    /* compiled from: InstrumentItemsDecoration */
    public interface a {
        int getItemViewType(int i);
    }

    private static int getType(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return -1;
        }
    }

    private static int getOffset(int i, int i2) {
        i = (getType(i) << 16) | getType(i2);
        int i3 = 0;
        while (i3 < auG.length) {
            if (auG[i3] == i) {
                break;
            }
            i3++;
        }
        i3 = -1;
        if (i3 != -1) {
            return auI[i3];
        }
        return 0;
    }

    public f(@NonNull a aVar) {
        this.azm = aVar;
        if (auI == null) {
            auI = new int[auH.length];
            for (int i = 0; i < auI.length; i++) {
                auI[i] = com.iqoption.core.ext.a.b(com.iqoption.core.f.RR(), (float) auH[i]);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            int adapterPosition = childViewHolder.getAdapterPosition();
            if (adapterPosition != 0) {
                int itemViewType = childViewHolder.getItemViewType();
                view = recyclerView.getChildAt(recyclerView.indexOfChild(view) - 1);
                if (view != null) {
                    ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(view);
                    if (findContainingViewHolder != null) {
                        rect.top = getOffset(findContainingViewHolder.getItemViewType(), itemViewType);
                    }
                } else {
                    if (adapterPosition == -1) {
                        adapterPosition = childViewHolder.getOldPosition();
                    }
                    if (adapterPosition > 0) {
                        rect.top = getOffset(this.azm.getItemViewType(adapterPosition - 1), itemViewType);
                    }
                }
            }
        }
    }
}
