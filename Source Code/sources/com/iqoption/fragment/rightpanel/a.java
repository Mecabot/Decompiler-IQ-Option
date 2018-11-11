package com.iqoption.fragment.rightpanel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.core.util.p;
import com.iqoption.d.aiq;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.d.b;
import com.iqoption.x.R;
import java.text.DecimalFormat;

/* compiled from: BinaryRightPanelCallPutDelegate */
public final class a implements at {
    private final aiq cEv;
    @Nullable
    private OnClickListener cEw;
    @Nullable
    private OnClickListener cEx;
    private final DecimalFormat cEy = q.I("#", 2);

    public void h(double d, int i) {
    }

    public a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.cEv = (aiq) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_turbo_binary_call_put, viewGroup, false);
        this.cEv.bSY.setOnClickListener(new b() {
            public void q(View view) {
                if (a.this.cEw != null) {
                    a.this.cEw.onClick(view);
                }
            }
        });
        this.cEv.bSZ.setOnClickListener(new b() {
            public void q(View view) {
                if (a.this.cEx != null) {
                    a.this.cEx.onClick(view);
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
        return this.cEv.getRoot();
    }

    public void amD() {
        au.bn(this.cEv.bSY);
    }

    public void amE() {
        au.bo(this.cEv.bSY);
    }

    public void amF() {
        au.bn(this.cEv.bSZ);
    }

    public void amG() {
        au.bo(this.cEv.bSZ);
    }

    public void g(double d, int i) {
        this.cEv.bEa.setText(l.a(d, this.cEy));
        this.cEv.bTc.setText(p.o((double) i));
    }
}
