package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.iqoption.welcomeonboarding.b.i;
import com.iqoption.x.R;

/* compiled from: FragmentWelcomeLoginBindingImpl */
public class uc extends ub {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(13);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    private a bGl;
    private b bGm;
    private c bGn;
    @NonNull
    private final LinearLayout biX;

    /* compiled from: FragmentWelcomeLoginBindingImpl */
    public static class a implements OnClickListener {
        private i bGo;

        public a b(i iVar) {
            this.bGo = iVar;
            return iVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bGo.cp(view);
        }
    }

    /* compiled from: FragmentWelcomeLoginBindingImpl */
    public static class b implements OnClickListener {
        private i bGo;

        public b c(i iVar) {
            this.bGo = iVar;
            return iVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bGo.cm(view);
        }
    }

    /* compiled from: FragmentWelcomeLoginBindingImpl */
    public static class c implements OnClickListener {
        private i bGo;

        public c d(i iVar) {
            this.bGo = iVar;
            return iVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bGo.co(view);
        }
    }

    static {
        awU.setIncludes(1, new String[]{"layout_welcome_social"}, new int[]{7}, new int[]{R.layout.layout_welcome_social});
        awV.put(R.id.title, 8);
        awV.put(R.id.emailInput, 9);
        awV.put(R.id.emailEdit, 10);
        awV.put(R.id.passwordInput, 11);
        awV.put(R.id.passwordEdit, 12);
    }

    public uc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private uc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[2], (TextView) objArr[5], (FrameLayout) objArr[0], (TextInputEditText) objArr[10], (TextInputLayout) objArr[9], (TextView) objArr[4], (TextInputEditText) objArr[12], (TextInputLayout) objArr[11], (ToggleButton) objArr[3], (ContentLoadingProgressBar) objArr[6], (TextView) objArr[8], (xf) objArr[7]);
        this.awW = -1;
        this.aOU.setTag(null);
        this.bnd.setTag(null);
        this.blV.setTag(null);
        this.bGh.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.bER.setTag(null);
        this.bnn.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 4;
        }
        this.bGj.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bGj.hasPendingBindings() == false) goto L_0x0016;
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
        r1 = r5.bGj;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.uc.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (4 != i) {
            return false;
        }
        a((i) obj);
        return true;
    }

    public void a(@Nullable i iVar) {
        this.bGk = iVar;
        synchronized (this) {
            this.awW |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bGj.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((xf) obj, i2);
    }

    private boolean a(xf xfVar, int i) {
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
        OnClickListener onClickListener;
        OnClickListener onClickListener2;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        i iVar = this.bGk;
        long j2 = j & 6;
        OnClickListener onClickListener3 = null;
        if (j2 == 0 || iVar == null) {
            onClickListener = null;
            onClickListener2 = onClickListener;
        } else {
            a aVar;
            b bVar;
            c cVar;
            if (this.bGl == null) {
                aVar = new a();
                this.bGl = aVar;
            } else {
                aVar = this.bGl;
            }
            onClickListener3 = aVar.b(iVar);
            if (this.bGm == null) {
                bVar = new b();
                this.bGm = bVar;
            } else {
                bVar = this.bGm;
            }
            onClickListener2 = bVar.c(iVar);
            if (this.bGn == null) {
                cVar = new c();
                this.bGn = cVar;
            } else {
                cVar = this.bGn;
            }
            onClickListener = cVar.d(iVar);
        }
        if (j2 != 0) {
            this.aOU.setOnClickListener(onClickListener2);
            this.bnd.setOnClickListener(onClickListener);
            this.bGh.setOnClickListener(onClickListener3);
        }
        if ((j & 4) != 0) {
            com.iqoption.core.ui.a.d(this.bGh, 0.5f);
            com.iqoption.core.ui.a.d(this.bER, 0.5f);
            com.iqoption.core.ui.a.a(this.bnn, ViewDataBinding.getColorFromResource(this.bnn, R.color.white));
        }
        ViewDataBinding.executeBindingsOn(this.bGj);
    }
}
