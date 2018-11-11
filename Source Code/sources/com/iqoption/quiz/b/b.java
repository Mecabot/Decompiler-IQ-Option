package com.iqoption.quiz.b;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iqoption.quiz.ae.c;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.widget.CustomVideoView;
import com.iqoption.quiz.widget.maxsize.MaxSizeFrameLayout;

/* compiled from: ActivityQuizBindingImpl */
public class b extends a {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(23);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"online_and_life_counter_layout"}, new int[]{4}, new int[]{e.online_and_life_counter_layout});
        awU.setIncludes(0, new String[]{"quiz_rules_layout", "quiz_question_language", "splash_layout", "email_layout", "error_layout"}, new int[]{9, 10, 11, 12, 13}, new int[]{e.quiz_rules_layout, e.quiz_question_language, e.splash_layout, e.email_layout, e.error_layout});
        awU.setIncludes(2, new String[]{"winners_layout", "question_layout", "answer_result_layout"}, new int[]{5, 6, 7}, new int[]{e.winners_layout, e.question_layout, e.answer_result_layout});
        awU.setIncludes(3, new String[]{"chat_layout"}, new int[]{8}, new int[]{e.chat_layout});
        awV.put(c.scroll, 14);
        awV.put(c.videoView, 15);
        awV.put(c.topControl, 16);
        awV.put(c.debug_text_view, 17);
        awV.put(c.controls_root, 18);
        awV.put(c.dialogContainer, 19);
        awV.put(c.badConnection, 20);
        awV.put(c.connectionLost, 21);
        awV.put(c.veil, 22);
    }

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, awU, awV));
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (c) objArr[7], (TextView) objArr[20], (MaxSizeFrameLayout) objArr[3], (e) objArr[8], (TextView) objArr[21], (LinearLayout) objArr[18], (TextView) objArr[17], (FrameLayout) objArr[19], (g) objArr[12], (i) objArr[13], (k) objArr[4], (FrameLayout) objArr[2], (s) objArr[10], (o) objArr[6], (u) objArr[9], (ConstraintLayout) objArr[1], (ScrollView) objArr[14], (w) objArr[11], (LinearLayout) objArr[16], (View) objArr[22], (CustomVideoView) objArr[15], (aa) objArr[5]);
        this.awW = -1;
        this.djS.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        this.dkb.setTag(null);
        this.dkf.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        this.dka.invalidateAll();
        this.dkk.invalidateAll();
        this.dkd.invalidateAll();
        this.djQ.invalidateAll();
        this.djT.invalidateAll();
        this.dke.invalidateAll();
        this.dkc.invalidateAll();
        this.dkh.invalidateAll();
        this.djY.invalidateAll();
        this.djZ.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.dka.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.dkk.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.dkd.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.djQ.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code:
            if (r5.djT.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:21:0x0039, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:23:0x0040, code:
            if (r5.dke.hasPendingBindings() == false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:24:0x0042, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:26:0x0049, code:
            if (r5.dkc.hasPendingBindings() == false) goto L_0x004c;
     */
    /* JADX WARNING: Missing block: B:27:0x004b, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:29:0x0052, code:
            if (r5.dkh.hasPendingBindings() == false) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:30:0x0054, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:32:0x005b, code:
            if (r5.djY.hasPendingBindings() == false) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:33:0x005d, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:35:0x0064, code:
            if (r5.djZ.hasPendingBindings() == false) goto L_0x0067;
     */
    /* JADX WARNING: Missing block: B:36:0x0066, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:38:0x0068, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0069 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0069 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0069 }
        r1 = r5.dka;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.dkk;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.dkd;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.djQ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r5.djT;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r5.dke;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0043;
    L_0x0042:
        return r0;
    L_0x0043:
        r1 = r5.dkc;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x004c;
    L_0x004b:
        return r0;
    L_0x004c:
        r1 = r5.dkh;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0055;
    L_0x0054:
        return r0;
    L_0x0055:
        r1 = r5.djY;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x005e;
    L_0x005d:
        return r0;
    L_0x005e:
        r1 = r5.djZ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0067;
    L_0x0066:
        return r0;
    L_0x0067:
        r0 = 0;
        return r0;
    L_0x0069:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0069 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.b.b.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.dka.setLifecycleOwner(lifecycleOwner);
        this.dkk.setLifecycleOwner(lifecycleOwner);
        this.dkd.setLifecycleOwner(lifecycleOwner);
        this.djQ.setLifecycleOwner(lifecycleOwner);
        this.djT.setLifecycleOwner(lifecycleOwner);
        this.dke.setLifecycleOwner(lifecycleOwner);
        this.dkc.setLifecycleOwner(lifecycleOwner);
        this.dkh.setLifecycleOwner(lifecycleOwner);
        this.djY.setLifecycleOwner(lifecycleOwner);
        this.djZ.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((k) obj, i2);
            case 1:
                return a((o) obj, i2);
            case 2:
                return a((i) obj, i2);
            case 3:
                return a((aa) obj, i2);
            case 4:
                return a((s) obj, i2);
            case 5:
                return a((u) obj, i2);
            case 6:
                return a((w) obj, i2);
            case 7:
                return a((c) obj, i2);
            case 8:
                return a((e) obj, i2);
            case 9:
                return a((g) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(k kVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(o oVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(i iVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    private boolean a(aa aaVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 8;
        }
        return true;
    }

    private boolean a(s sVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 16;
        }
        return true;
    }

    private boolean a(u uVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 32;
        }
        return true;
    }

    private boolean a(w wVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 64;
        }
        return true;
    }

    private boolean a(c cVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 128;
        }
        return true;
    }

    private boolean a(e eVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 256;
        }
        return true;
    }

    private boolean a(g gVar, int i) {
        if (i != com.iqoption.quiz.b.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 512;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.dka);
        ViewDataBinding.executeBindingsOn(this.dkk);
        ViewDataBinding.executeBindingsOn(this.dkd);
        ViewDataBinding.executeBindingsOn(this.djQ);
        ViewDataBinding.executeBindingsOn(this.djT);
        ViewDataBinding.executeBindingsOn(this.dke);
        ViewDataBinding.executeBindingsOn(this.dkc);
        ViewDataBinding.executeBindingsOn(this.dkh);
        ViewDataBinding.executeBindingsOn(this.djY);
        ViewDataBinding.executeBindingsOn(this.djZ);
    }
}
