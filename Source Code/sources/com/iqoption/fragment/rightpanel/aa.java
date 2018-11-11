package com.iqoption.fragment.rightpanel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.app.a;
import com.iqoption.core.i;
import com.iqoption.core.util.p;
import com.iqoption.d.aii;
import com.iqoption.view.d.b;
import com.iqoption.x.R;

/* compiled from: DigitalRightPanelCallPutDelegate */
public final class aa implements at {
    private static final String TAG = "aa";
    @Nullable
    private OnClickListener cEw;
    @Nullable
    private OnClickListener cEx;
    private final aii cGw;
    private boolean cGx;
    private boolean cGy;
    private boolean cGz;

    public aa(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.cGw = (aii) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_digital_call_put, viewGroup, false);
        this.cGw.bSp.setOnClickListener(new b() {
            public void q(View view) {
                if (aa.this.cEw != null) {
                    aa.this.cEw.onClick(view);
                }
            }
        });
        this.cGw.bSt.setOnClickListener(new b() {
            public void q(View view) {
                if (aa.this.cEx != null) {
                    aa.this.cEx.onClick(view);
                }
            }
        });
    }

    public void a(OnClickListener onClickListener) {
        this.cEw = onClickListener;
    }

    public void b(OnClickListener onClickListener) {
        this.cEx = onClickListener;
    }

    public View getView() {
        return this.cGw.getRoot();
    }

    public void amD() {
        bn(this.cGw.bSp);
        if (this.cGy) {
            anR();
        }
    }

    public void amE() {
        bo(this.cGw.bSp);
    }

    public void amF() {
        bn(this.cGw.bSt);
        if (this.cGz) {
            anS();
        }
    }

    public void amG() {
        bo(this.cGw.bSt);
    }

    private void bn(View view) {
        if (this.cGx) {
            view.setEnabled(true);
            view.animate().cancel();
            view.setAlpha(1.0f);
            return;
        }
        au.bn(view);
    }

    private void bo(View view) {
        if (this.cGx) {
            view.setEnabled(false);
            view.animate().cancel();
            view.setAlpha(0.7f);
            return;
        }
        au.bo(view);
    }

    public void dE(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setTransitionAnimationInProgress to ");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        if (z != this.cGx) {
            this.cGx = z;
            if (!z) {
                if (this.cGy) {
                    anR();
                }
                if (this.cGz) {
                    anS();
                }
            }
        }
    }

    public void g(double d, int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCallProfit value=");
        stringBuilder.append(d);
        stringBuilder.append(", percent=");
        stringBuilder.append(i);
        i.v(str, stringBuilder.toString());
        this.cGy = false;
        this.cGw.bSB.f(p.af(a.Cw().CD(), "%.2f"), d);
        this.cGw.bSA.S("%s%%", i);
    }

    public void anR() {
        i.v(TAG, "clearCallProfit");
        this.cGy = true;
        if (!this.cGx) {
            i.v(TAG, "clearCallProfit");
            this.cGw.bSB.clear();
            this.cGw.bSA.clear();
        }
    }

    public void h(double d, int i) {
        this.cGz = false;
        this.cGw.bSJ.f(p.af(a.Cw().CD(), "%.2f"), d);
        this.cGw.bSI.S("%s%%", i);
    }

    public void anS() {
        this.cGz = true;
        if (!this.cGx) {
            this.cGw.bSJ.clear();
            this.cGw.bSI.clear();
        }
    }
}
