package com.iqoption.charttools.constructor;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.core.f;

/* compiled from: InputItemsDecoration */
public final class p extends ItemDecoration {
    private static final int[] auG = new int[]{65538, 131075, 65539, 196609, 196611};
    private static final int[] auH = new int[]{8, 16, 16, 28, 1};
    private static int[] auI;
    private final a auJ;

    /* compiled from: InputItemsDecoration */
    public interface a {
        int getItemViewType(int i);
    }

    private static int getType(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 3;
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

    public p(@NonNull a aVar) {
        this.auJ = aVar;
        if (auI == null) {
            auI = new int[auH.length];
            for (int i = 0; i < auI.length; i++) {
                auI[i] = com.iqoption.core.ext.a.b(f.RR(), (float) auH[i]);
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
                        rect.top = getOffset(this.auJ.getItemViewType(adapterPosition - 1), itemViewType);
                    }
                }
            }
        }
    }
}
