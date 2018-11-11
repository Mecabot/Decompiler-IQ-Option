package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentQuizOffAirDelegateBindingImpl */
public class rk extends rj {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(12);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"fragment_quiz_off_air_title"}, new int[]{2}, new int[]{R.layout.fragment_quiz_off_air_title});
        awV.put(R.id.nextGameLabel, 3);
        awV.put(R.id.nextGameTime, 4);
        awV.put(R.id.btnNotifications, 5);
        awV.put(R.id.nextGameDate, 6);
        awV.put(R.id.prizeFundLabel, 7);
        awV.put(R.id.prizeFund, 8);
        awV.put(R.id.extraLifesLabel, 9);
        awV.put(R.id.heartsCount, 10);
        awV.put(R.id.hearts, 11);
    }

    public rk(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private rk(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1], (ImageView) objArr[5], (TextView) objArr[9], (ImageView) objArr[11], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[7], (rl) objArr[2]);
        this.awW = -1;
        this.bBg.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bBq.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bBq.hasPendingBindings() == false) goto L_0x0016;
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
        r1 = r5.bBq;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.rk.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bBq.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((rl) obj, i2);
    }

    private boolean a(rl rlVar, int i) {
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
            TextViewBindingAdapter.setDrawableEnd(this.bBg, ViewDataBinding.getDrawableFromResource(this.bBg, R.drawable.ic_heart_dp16));
            a.d(this.bBg, ViewDataBinding.getColorFromResource(this.bBg, R.color.orange_accent));
        }
        ViewDataBinding.executeBindingsOn(this.bBq);
    }
}
