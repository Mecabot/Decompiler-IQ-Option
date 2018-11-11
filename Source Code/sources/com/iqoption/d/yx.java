package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.feed.feedlist.TagLayout;
import com.iqoption.x.R;

/* compiled from: MacroVideoFeedBindingImpl */
public class yx extends yw {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(10);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"feed_title", "feed_bottom_panel"}, new int[]{1, 2}, new int[]{R.layout.feed_title, R.layout.feed_bottom_panel});
        awV.put(R.id.video_content, 3);
        awV.put(R.id.video_preview, 4);
        awV.put(R.id.play_button, 5);
        awV.put(R.id.video_title, 6);
        awV.put(R.id.main_topic, 7);
        awV.put(R.id.topics_container, 8);
        awV.put(R.id.time_text, 9);
    }

    public yx(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private yx(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (kr) objArr[2], (kv) objArr[1], (TextView) objArr[7], (ImageView) objArr[5], (TextView) objArr[9], (TagLayout) objArr[8], (FrameLayout) objArr[3], (ConstraintLayout) objArr[0], (ImageView) objArr[4], (TextView) objArr[6]);
        this.awW = -1;
        this.bLe.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 4;
        }
        this.bKR.invalidateAll();
        this.bKQ.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bKR.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bKQ.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0020, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0021 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        r1 = r5.bKR;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bKQ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r0 = 0;
        return r0;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.yx.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bKR.setLifecycleOwner(lifecycleOwner);
        this.bKQ.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((kr) obj, i2);
            case 1:
                return a((kv) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(kr krVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(kv kvVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bKR);
        ViewDataBinding.executeBindingsOn(this.bKQ);
    }
}
