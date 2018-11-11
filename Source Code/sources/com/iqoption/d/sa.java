package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.chat.fragment.BadgeView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentRoomBindingImpl */
public class sa extends rz {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.messagesLayout, 2);
        awV.put(R.id.messageList, 3);
        awV.put(R.id.dateBadge, 4);
        awV.put(R.id.topBar, 5);
        awV.put(R.id.btnBack, 6);
        awV.put(R.id.topBarLayout, 7);
        awV.put(R.id.bottomBarLayout, 8);
    }

    public sa(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private sa(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[8], (ImageView) objArr[6], (FrameLayout) objArr[1], (BadgeView) objArr[4], (RecyclerView) objArr[3], (FrameLayout) objArr[2], (LinearLayout) objArr[5], (FrameLayout) objArr[7]);
        this.awW = -1;
        this.bBP.setTag(null);
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.awW != 0) {
                return true;
            }
            return false;
        }
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.j(this.bBP, ViewDataBinding.getColorFromResource(this.bBP, R.color.chat_return_button_bg_tint));
        }
    }
}
