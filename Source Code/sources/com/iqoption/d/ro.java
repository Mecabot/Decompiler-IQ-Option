package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.TextureVideoView;
import com.iqoption.x.R;

/* compiled from: FragmentQuizOnAirDelegateBindingImpl */
public class ro extends rn {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(13);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"fragment_quiz_question_language"}, new int[]{7}, new int[]{R.layout.fragment_quiz_question_language});
        awV.put(R.id.title, 6);
        awV.put(R.id.video, 8);
        awV.put(R.id.btnExpand, 9);
        awV.put(R.id.chatList, 10);
        awV.put(R.id.btnJoinGuideline, 11);
        awV.put(R.id.divider, 12);
    }

    public ro(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private ro(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[9], (TextView) objArr[3], (Space) objArr[11], (ImageView) objArr[2], (RecyclerView) objArr[10], (View) objArr[12], (TextView) objArr[5], (rr) objArr[7], (View) objArr[6], (FrameLayout) objArr[1], (TextureVideoView) objArr[8], (TextView) objArr[4]);
        this.awW = -1;
        this.bBt.setTag(null);
        this.bBv.setTag(null);
        this.bBx.setTag(null);
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
        this.bBz.setTag(null);
        this.bBB.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bBy.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bBy.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x0017, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0018 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        r1 = r5.bBy;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = 0;
        return r0;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.ro.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bBy.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((rr) obj, i2);
    }

    private boolean a(rr rrVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 2) != 0) {
            a.f(this.bBt, this.bBt.getResources().getDimension(R.dimen._dp2));
            a.f(this.bBv, this.bBv.getResources().getDimension(R.dimen._dp4));
            TextViewBindingAdapter.setDrawableStart(this.bBx, ViewDataBinding.getDrawableFromResource(this.bBx, R.drawable.ic_heart_dp16));
            TextViewBindingAdapter.setDrawableStart(this.bBB, ViewDataBinding.getDrawableFromResource(this.bBB, R.drawable.ic_eye_counter_white_16dp));
        }
        ViewDataBinding.executeBindingsOn(this.bBy);
    }
}
