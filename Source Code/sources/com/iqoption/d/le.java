package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.x.R;

/* compiled from: FragmentAccountSecurityPasscodeBindingImpl */
public class le extends ld implements a {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(15);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bwH;

    static {
        awU.setIncludes(2, new String[]{"dialpad_dot", "dialpad_dot", "dialpad_dot", "dialpad_dot", "dialpad_dot", "dialpad_dot"}, new int[]{4, 5, 6, 7, 8, 9}, new int[]{R.layout.dialpad_dot, R.layout.dialpad_dot, R.layout.dialpad_dot, R.layout.dialpad_dot, R.layout.dialpad_dot, R.layout.dialpad_dot});
        awU.setIncludes(1, new String[]{"dialpad"}, new int[]{10}, new int[]{R.layout.dialpad});
        awV.put(R.id.passcodeTitleLayout, 11);
        awV.put(R.id.passcodeTitleText, 12);
        awV.put(R.id.passcodeVerificationTitleLayout, 13);
        awV.put(R.id.enterPasscodeOrUseTouchIdText, 14);
    }

    public le(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, awU, awV));
    }

    private le(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[3], (kb) objArr[10], (kd) objArr[4], (kd) objArr[5], (kd) objArr[6], (kd) objArr[7], (kd) objArr[8], (kd) objArr[9], (LinearLayout) objArr[2], (TextView) objArr[14], (LinearLayout) objArr[1], (FrameLayout) objArr[0], (FrameLayout) objArr[11], (TextSwitcher) objArr[12], (LinearLayout) objArr[13]);
        this.awW = -1;
        this.bwu.setTag(null);
        this.bwd.setTag(null);
        this.aOX.setTag(null);
        this.bwt.setTag(null);
        setRootTag(view);
        this.bwH = new com.iqoption.e.a.a(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 256;
        }
        this.bww.invalidateAll();
        this.bwx.invalidateAll();
        this.bwy.invalidateAll();
        this.bwz.invalidateAll();
        this.bwA.invalidateAll();
        this.bwB.invalidateAll();
        this.bwv.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bww.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bwx.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bwy.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.bwz.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code:
            if (r5.bwA.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:21:0x0039, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:23:0x0040, code:
            if (r5.bwB.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:24:0x0042, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:26:0x0049, code:
            if (r5.bwv.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Missing block: B:27:0x004b, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:29:0x004d, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x004e }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x004e }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x004e }
        r1 = r5.bww;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bwx;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bwy;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.bwz;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r5.bwA;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r5.bwB;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0043;
    L_0x0042:
        return r0;
    L_0x0043:
        r1 = r5.bwv;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x004c;
    L_0x004b:
        return r0;
    L_0x004c:
        r0 = 0;
        return r0;
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x004e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.le.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 != i) {
            return false;
        }
        a((PasscodeFragment) obj);
        return true;
    }

    public void a(@Nullable PasscodeFragment passcodeFragment) {
        this.bwG = passcodeFragment;
        synchronized (this) {
            this.awW |= 128;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bww.setLifecycleOwner(lifecycleOwner);
        this.bwx.setLifecycleOwner(lifecycleOwner);
        this.bwy.setLifecycleOwner(lifecycleOwner);
        this.bwz.setLifecycleOwner(lifecycleOwner);
        this.bwA.setLifecycleOwner(lifecycleOwner);
        this.bwB.setLifecycleOwner(lifecycleOwner);
        this.bwv.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((kd) obj, i2);
            case 1:
                return b((kd) obj, i2);
            case 2:
                return a((kb) obj, i2);
            case 3:
                return c((kd) obj, i2);
            case 4:
                return d((kd) obj, i2);
            case 5:
                return e((kd) obj, i2);
            case 6:
                return f((kd) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean b(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(kb kbVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    private boolean c(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 8;
        }
        return true;
    }

    private boolean d(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 16;
        }
        return true;
    }

    private boolean e(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 32;
        }
        return true;
    }

    private boolean f(kd kdVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 64;
        }
        return true;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        PasscodeFragment passcodeFragment = this.bwG;
        if ((j & 256) != 0) {
            this.bwu.setOnClickListener(this.bwH);
        }
        ViewDataBinding.executeBindingsOn(this.bww);
        ViewDataBinding.executeBindingsOn(this.bwx);
        ViewDataBinding.executeBindingsOn(this.bwy);
        ViewDataBinding.executeBindingsOn(this.bwz);
        ViewDataBinding.executeBindingsOn(this.bwA);
        ViewDataBinding.executeBindingsOn(this.bwB);
        ViewDataBinding.executeBindingsOn(this.bwv);
    }

    public final void a(int i, View view) {
        PasscodeFragment passcodeFragment = this.bwG;
        if ((passcodeFragment != null ? 1 : null) != null) {
            passcodeFragment.ahJ();
        }
    }
}
