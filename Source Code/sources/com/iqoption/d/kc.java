package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.x.R;

/* compiled from: DialpadBindingImpl */
public class kc extends kb {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(17);
    @Nullable
    private static final SparseIntArray awV = null;
    private long awW;
    @NonNull
    private final LinearLayout buZ;
    @NonNull
    private final LinearLayout bva;
    @NonNull
    private final LinearLayout bvb;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(2, new String[]{"dialpad_key", "dialpad_key", "dialpad_key"}, new int[]{8, 9, 10}, new int[]{R.layout.dialpad_key, R.layout.dialpad_key, R.layout.dialpad_key});
        awU.setIncludes(3, new String[]{"dialpad_key", "dialpad_key", "dialpad_key"}, new int[]{11, 12, 13}, new int[]{R.layout.dialpad_key, R.layout.dialpad_key, R.layout.dialpad_key});
        awU.setIncludes(4, new String[]{"dialpad_key_touchid", "dialpad_key_zero", "dialpad_key_back"}, new int[]{14, 15, 16}, new int[]{R.layout.dialpad_key_touchid, R.layout.dialpad_key_zero, R.layout.dialpad_key_back});
        awU.setIncludes(1, new String[]{"dialpad_key", "dialpad_key", "dialpad_key"}, new int[]{5, 6, 7}, new int[]{R.layout.dialpad_key, R.layout.dialpad_key, R.layout.dialpad_key});
    }

    public kc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private kc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (kf) objArr[16], (LinearLayout) objArr[0], (kh) objArr[12], (kj) objArr[14], (kh) objArr[9], (kh) objArr[8], (LinearLayout) objArr[1], (kh) objArr[13], (kh) objArr[5], (kh) objArr[11], (kh) objArr[10], (kh) objArr[7], (kh) objArr[6], (kl) objArr[15]);
        this.awW = -1;
        this.buM.setTag(null);
        this.buR.setTag(null);
        this.buZ = (LinearLayout) objArr[2];
        this.buZ.setTag(null);
        this.bva = (LinearLayout) objArr[3];
        this.bva.setTag(null);
        this.bvb = (LinearLayout) objArr[4];
        this.bvb.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        this.buT.invalidateAll();
        this.buX.invalidateAll();
        this.buW.invalidateAll();
        this.buQ.invalidateAll();
        this.buP.invalidateAll();
        this.buV.invalidateAll();
        this.buU.invalidateAll();
        this.buN.invalidateAll();
        this.buS.invalidateAll();
        this.buO.invalidateAll();
        this.buY.invalidateAll();
        this.buL.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.buT.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.buX.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.buW.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.buQ.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code:
            if (r5.buP.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:21:0x0039, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:23:0x0040, code:
            if (r5.buV.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:24:0x0042, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:26:0x0049, code:
            if (r5.buU.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Missing block: B:27:0x004b, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:29:0x0052, code:
            if (r5.buN.hasPendingBindings() == false) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:30:0x0054, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:32:0x005b, code:
            if (r5.buS.hasPendingBindings() == false) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:33:0x005d, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:35:0x0064, code:
            if (r5.buO.hasPendingBindings() == false) goto L_0x0067;
     */
    /* JADX WARNING: Missing block: B:36:0x0066, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:38:0x006d, code:
            if (r5.buY.hasPendingBindings() == false) goto L_0x0070;
     */
    /* JADX WARNING: Missing block: B:39:0x006f, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:41:0x0076, code:
            if (r5.buL.hasPendingBindings() == false) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:42:0x0078, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:44:0x007a, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x007b }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x007b }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x007b }
        r1 = r5.buT;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.buX;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.buW;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.buQ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r5.buP;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r5.buV;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0043;
    L_0x0042:
        return r0;
    L_0x0043:
        r1 = r5.buU;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x004c;
    L_0x004b:
        return r0;
    L_0x004c:
        r1 = r5.buN;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0055;
    L_0x0054:
        return r0;
    L_0x0055:
        r1 = r5.buS;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x005e;
    L_0x005d:
        return r0;
    L_0x005e:
        r1 = r5.buO;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0067;
    L_0x0066:
        return r0;
    L_0x0067:
        r1 = r5.buY;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0070;
    L_0x006f:
        return r0;
    L_0x0070:
        r1 = r5.buL;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0079;
    L_0x0078:
        return r0;
    L_0x0079:
        r0 = 0;
        return r0;
    L_0x007b:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x007b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.kc.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.buT.setLifecycleOwner(lifecycleOwner);
        this.buX.setLifecycleOwner(lifecycleOwner);
        this.buW.setLifecycleOwner(lifecycleOwner);
        this.buQ.setLifecycleOwner(lifecycleOwner);
        this.buP.setLifecycleOwner(lifecycleOwner);
        this.buV.setLifecycleOwner(lifecycleOwner);
        this.buU.setLifecycleOwner(lifecycleOwner);
        this.buN.setLifecycleOwner(lifecycleOwner);
        this.buS.setLifecycleOwner(lifecycleOwner);
        this.buO.setLifecycleOwner(lifecycleOwner);
        this.buY.setLifecycleOwner(lifecycleOwner);
        this.buL.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((kh) obj, i2);
            case 1:
                return b((kh) obj, i2);
            case 2:
                return a((kl) obj, i2);
            case 3:
                return c((kh) obj, i2);
            case 4:
                return d((kh) obj, i2);
            case 5:
                return e((kh) obj, i2);
            case 6:
                return f((kh) obj, i2);
            case 7:
                return g((kh) obj, i2);
            case 8:
                return h((kh) obj, i2);
            case 9:
                return a((kj) obj, i2);
            case 10:
                return a((kf) obj, i2);
            case 11:
                return i((kh) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean b(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(kl klVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    private boolean c(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 8;
        }
        return true;
    }

    private boolean d(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 16;
        }
        return true;
    }

    private boolean e(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 32;
        }
        return true;
    }

    private boolean f(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 64;
        }
        return true;
    }

    private boolean g(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 128;
        }
        return true;
    }

    private boolean h(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 256;
        }
        return true;
    }

    private boolean a(kj kjVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 512;
        }
        return true;
    }

    private boolean a(kf kfVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean i(kh khVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.buT);
        ViewDataBinding.executeBindingsOn(this.buX);
        ViewDataBinding.executeBindingsOn(this.buW);
        ViewDataBinding.executeBindingsOn(this.buQ);
        ViewDataBinding.executeBindingsOn(this.buP);
        ViewDataBinding.executeBindingsOn(this.buV);
        ViewDataBinding.executeBindingsOn(this.buU);
        ViewDataBinding.executeBindingsOn(this.buN);
        ViewDataBinding.executeBindingsOn(this.buS);
        ViewDataBinding.executeBindingsOn(this.buO);
        ViewDataBinding.executeBindingsOn(this.buY);
        ViewDataBinding.executeBindingsOn(this.buL);
    }
}
