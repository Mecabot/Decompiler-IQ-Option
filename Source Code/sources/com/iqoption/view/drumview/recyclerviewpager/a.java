package com.iqoption.view.drumview.recyclerviewpager;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: ViewUtils */
public class a {
    public static View j(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (b(recyclerView, childAt)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static int k(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (b(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static View l(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (c(recyclerView, childAt)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static int m(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (c(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static boolean b(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int width = iArr[0] + (recyclerView.getWidth() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            if (iArr2[0] <= width && iArr2[0] + view.getWidth() >= width) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int height = iArr[1] + (recyclerView.getHeight() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            if (iArr2[1] <= height && iArr2[1] + view.getHeight() >= height) {
                return true;
            }
        }
        return false;
    }
}
