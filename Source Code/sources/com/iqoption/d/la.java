package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.AccountSecurityFragment;
import com.iqoption.view.SmoothViewPager;
import com.iqoption.x.R;

/* compiled from: FragmentAccountSecurityBindingImpl */
public class la extends kz implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bwo;
    @Nullable
    private final OnClickListener bwp;
    @Nullable
    private final OnClickListener bwq;
    @Nullable
    private final OnClickListener bwr;
    @Nullable
    private final OnClickListener bws;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.main_content, 6);
        awV.put(R.id.securityTitle, 7);
        awV.put(R.id.securityTabs, 8);
        awV.put(R.id.viewPager, 9);
        awV.put(R.id.dots, 10);
        awV.put(R.id.dot1, 11);
        awV.put(R.id.dot2, 12);
        awV.put(R.id.dot3, 13);
        awV.put(R.id.dot4, 14);
        awV.put(R.id.iqBackground, 15);
    }

    public la(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, awU, awV));
    }

    private la(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (ImageView) objArr[11], (ImageView) objArr[12], (ImageView) objArr[13], (ImageView) objArr[14], (LinearLayout) objArr[10], (ImageView) objArr[1], (ImageView) objArr[15], (ImageView) objArr[2], (LinearLayout) objArr[6], (ImageView) objArr[3], (LinearLayout) objArr[8], (FrameLayout) objArr[7], (ImageView) objArr[4], (ImageView) objArr[5], (SmoothViewPager) objArr[9]);
        this.awW = -1;
        this.bvY.setTag(null);
        this.bwe.setTag(null);
        this.bwg.setTag(null);
        this.bwh.setTag(null);
        this.bwk.setTag(null);
        this.bwl.setTag(null);
        setRootTag(view);
        this.bwo = new com.iqoption.e.a.a(this, 2);
        this.bwp = new com.iqoption.e.a.a(this, 1);
        this.bwq = new com.iqoption.e.a.a(this, 3);
        this.bwr = new com.iqoption.e.a.a(this, 4);
        this.bws = new com.iqoption.e.a.a(this, 5);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
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

    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 != i) {
            return false;
        }
        a((AccountSecurityFragment) obj);
        return true;
    }

    public void a(@Nullable AccountSecurityFragment accountSecurityFragment) {
        this.bwn = accountSecurityFragment;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        AccountSecurityFragment accountSecurityFragment = this.bwn;
        if ((j & 2) != 0) {
            this.bwe.setOnClickListener(this.bwp);
            this.bwg.setOnClickListener(this.bwo);
            this.bwh.setOnClickListener(this.bwq);
            this.bwk.setOnClickListener(this.bwr);
            this.bwl.setOnClickListener(this.bws);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        AccountSecurityFragment accountSecurityFragment;
        switch (i) {
            case 1:
                accountSecurityFragment = this.bwn;
                if (accountSecurityFragment != null) {
                    obj = 1;
                }
                if (obj != null) {
                    accountSecurityFragment.ahJ();
                    return;
                }
                return;
            case 2:
                accountSecurityFragment = this.bwn;
                if (accountSecurityFragment != null) {
                    obj = 1;
                }
                if (obj != null) {
                    accountSecurityFragment.aW(view);
                    return;
                }
                return;
            case 3:
                accountSecurityFragment = this.bwn;
                if (accountSecurityFragment != null) {
                    obj = 1;
                }
                if (obj != null) {
                    accountSecurityFragment.aW(view);
                    return;
                }
                return;
            case 4:
                accountSecurityFragment = this.bwn;
                if (accountSecurityFragment != null) {
                    obj = 1;
                }
                if (obj != null) {
                    accountSecurityFragment.aW(view);
                    return;
                }
                return;
            case 5:
                accountSecurityFragment = this.bwn;
                if (accountSecurityFragment != null) {
                    obj = 1;
                }
                if (obj != null) {
                    accountSecurityFragment.aW(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
