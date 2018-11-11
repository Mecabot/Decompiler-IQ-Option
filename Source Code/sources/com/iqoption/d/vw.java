package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeLinearLayout;
import com.iqoption.core.ui.widget.MaxSizeView;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.h;
import com.iqoption.x.R;

/* compiled from: IqkeyboardFragmentBindingImpl */
public class vw extends vv implements com.iqoption.e.a.a.a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bIY;
    private a bIZ;
    private b bJa;
    private c bJb;
    private d bJc;
    private e bJd;
    private f bJe;

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class a implements OnClickListener {
        private h bJf;

        public a b(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.cd(view);
        }
    }

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class b implements OnClickListener {
        private h bJf;

        public b c(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.bZ(view);
        }
    }

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class c implements OnClickListener {
        private h bJf;

        public c d(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.cb(view);
        }
    }

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class d implements OnClickListener {
        private h bJf;

        public d e(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.ca(view);
        }
    }

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class e implements OnClickListener {
        private h bJf;

        public e f(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.cc(view);
        }
    }

    /* compiled from: IqkeyboardFragmentBindingImpl */
    public static class f implements OnClickListener {
        private h bJf;

        public f g(h hVar) {
            this.bJf = hVar;
            return hVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bJf.bY(view);
        }
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.content, 17);
        awV.put(R.id.linearLayout, 18);
        awV.put(R.id.leftContainer, 19);
        awV.put(R.id.amountKeyboard, 20);
        awV.put(R.id.coefficientContainer, 21);
        awV.put(R.id.coefficient, 22);
        awV.put(R.id.space, 23);
        awV.put(R.id.rightContainer, 24);
        awV.put(R.id.allBalanceContainer, 25);
        awV.put(R.id.balanceTitle, 26);
        awV.put(R.id.balanceValue, 27);
        awV.put(R.id.titlePresetAmount, 28);
        awV.put(R.id.arrowPresetAmount, 29);
        awV.put(R.id.listContainer, 30);
        awV.put(R.id.preset, 31);
        awV.put(R.id.arrowLastAmount, 32);
        awV.put(R.id.titleLastAmount, 33);
        awV.put(R.id.hideKeyboard, 34);
    }

    public vw(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 35, awU, awV));
    }

    private vw(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[25], (RobotoEditText) objArr[20], (ImageView) objArr[32], (ImageView) objArr[29], (FrameLayout) objArr[12], (RobotoTextView) objArr[26], (RobotoTextView) objArr[27], (RobotoEditText) objArr[22], (LinearLayout) objArr[21], (FrameLayout) objArr[17], (ImageView) objArr[13], (TextView) objArr[8], (FrameLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[4], (ImageView) objArr[34], (RelativeLayout) objArr[16], (MaxSizeLinearLayout) objArr[19], (RelativeLayout) objArr[18], (FrameLayout) objArr[30], (ImageView) objArr[14], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[10], (RecyclerView) objArr[31], (RelativeLayout) objArr[15], (MaxSizeLinearLayout) objArr[24], (TextView) objArr[7], (TextView) objArr[6], (MaxSizeView) objArr[23], (TextView) objArr[3], (RobotoTextView) objArr[33], (RobotoTextView) objArr[28], (TextView) objArr[2], (TextView) objArr[11]);
        this.awW = -1;
        this.bIu.setTag(null);
        this.bIz.setTag(null);
        this.bIA.setTag("8");
        this.bjF.setTag(null);
        this.bIB.setTag("5");
        this.bIC.setTag("4");
        this.bIE.setTag(null);
        this.bII.setTag(null);
        this.bIJ.setTag("9");
        this.bIK.setTag("1");
        this.bIL.setTag(null);
        this.bIN.setTag(null);
        this.bIP.setTag("7");
        this.bIQ.setTag("6");
        this.bIS.setTag("3");
        this.bIV.setTag("2");
        this.bIW.setTag("0");
        setRootTag(view);
        this.bIY = new com.iqoption.e.a.a(this, 1);
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
        a((h) obj);
        return true;
    }

    public void a(@Nullable h hVar) {
        this.bIX = hVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        OnClickListener onClickListener;
        OnClickListener onClickListener2;
        OnClickListener onClickListener3;
        OnClickListener onClickListener4;
        OnClickListener onClickListener5;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        h hVar = this.bIX;
        long j2 = j & 3;
        OnClickListener onClickListener6 = null;
        if (j2 == 0 || hVar == null) {
            onClickListener = null;
            onClickListener2 = onClickListener;
            onClickListener3 = onClickListener2;
            onClickListener4 = onClickListener3;
            onClickListener5 = onClickListener4;
        } else {
            a aVar;
            b bVar;
            c cVar;
            d dVar;
            e eVar;
            f fVar;
            if (this.bIZ == null) {
                aVar = new a();
                this.bIZ = aVar;
            } else {
                aVar = this.bIZ;
            }
            a b = aVar.b(hVar);
            if (this.bJa == null) {
                bVar = new b();
                this.bJa = bVar;
            } else {
                bVar = this.bJa;
            }
            bVar = bVar.c(hVar);
            if (this.bJb == null) {
                cVar = new c();
                this.bJb = cVar;
            } else {
                cVar = this.bJb;
            }
            cVar = cVar.d(hVar);
            if (this.bJc == null) {
                dVar = new d();
                this.bJc = dVar;
            } else {
                dVar = this.bJc;
            }
            onClickListener4 = dVar.e(hVar);
            if (this.bJd == null) {
                eVar = new e();
                this.bJd = eVar;
            } else {
                eVar = this.bJd;
            }
            onClickListener5 = eVar.f(hVar);
            if (this.bJe == null) {
                fVar = new f();
                this.bJe = fVar;
            } else {
                fVar = this.bJe;
            }
            onClickListener = fVar.g(hVar);
            c cVar2 = cVar;
            onClickListener3 = bVar;
            onClickListener2 = b;
            onClickListener6 = cVar2;
        }
        if (j2 != 0) {
            this.bIu.setOnClickListener(onClickListener6);
            this.bIz.setOnClickListener(onClickListener);
            this.bIA.setOnClickListener(onClickListener5);
            this.bIB.setOnClickListener(onClickListener5);
            this.bIC.setOnClickListener(onClickListener5);
            this.bIE.setOnClickListener(onClickListener2);
            this.bII.setOnClickListener(onClickListener3);
            this.bIJ.setOnClickListener(onClickListener5);
            this.bIK.setOnClickListener(onClickListener5);
            this.bIL.setOnClickListener(onClickListener4);
            this.bIN.setOnClickListener(onClickListener2);
            this.bIP.setOnClickListener(onClickListener5);
            this.bIQ.setOnClickListener(onClickListener5);
            this.bIS.setOnClickListener(onClickListener5);
            this.bIV.setOnClickListener(onClickListener5);
            this.bIW.setOnClickListener(onClickListener5);
        }
        if ((j & 2) != 0) {
            this.bjF.setOnClickListener(this.bIY);
        }
    }

    public final void a(int i, View view) {
        h hVar = this.bIX;
        if ((hVar != null ? 1 : null) != null) {
            hVar.aN();
        }
    }
}
