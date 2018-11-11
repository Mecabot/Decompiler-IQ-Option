package com.iqoption.portfolio.a;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.afb;
import com.iqoption.d.bo;
import com.iqoption.fragment.base.a;
import com.iqoption.portfolio.component.b.d;
import com.iqoption.portfolio.component.l;
import com.iqoption.portfolio.f;
import com.iqoption.portfolio.h;
import com.iqoption.portfolio.h.b;

/* compiled from: PortfolioFilterChooserBottomSheet */
public final class v extends a implements b {
    private f cYB;
    private bo dcR;
    private l dcS;

    public void awq() {
    }

    public void awr() {
    }

    public void aws() {
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("PortfolioFilterChooserBottomSheet") == null) {
            fragmentManager.beginTransaction().add(i, new v(), "PortfolioFilterChooserBottomSheet").addToBackStack(null).commit();
        }
    }

    protected View aeO() {
        return this.dcR.blD;
    }

    protected View aeP() {
        return this.dcR.blp;
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dcR = bo.f(layoutInflater, viewGroup, false);
        this.cYB = h.awd().awe();
        this.dcR.blD.setHasFixedSize(true);
        this.dcS = new l(d.bH(requireContext()), new w(this), new x(this));
        this.dcR.blD.setAdapter(this.dcS);
        return this.dcR.getRoot();
    }

    final /* synthetic */ com.iqoption.portfolio.component.viewholder.l p(ViewGroup viewGroup) {
        com.iqoption.portfolio.component.viewholder.l lVar = new com.iqoption.portfolio.component.viewholder.l(viewGroup);
        com.iqoption.core.ext.a.a(lVar.itemView, new y(this, lVar));
        return lVar;
    }

    final /* synthetic */ kotlin.l a(com.iqoption.portfolio.component.viewholder.l lVar) {
        d axv = lVar.axv();
        double value = this.cYB.fH(axv.avX()).getValue();
        if (value != 0.0d) {
            String mask = axv.getMask();
            if (mask != null) {
                ((afb) lVar.getBinding()).bns.setText(String.format(mask, new Object[]{com.iqoption.util.l.r(Double.valueOf(value))}));
            } else {
                ((afb) lVar.getBinding()).bns.setText(com.iqoption.util.l.r(Double.valueOf(value)));
            }
        } else {
            ((afb) lVar.getBinding()).bns.setText(null);
        }
        return null;
    }

    public void onStart() {
        super.onStart();
        h.awd().a((b) this);
    }

    public void onStop() {
        super.onStop();
        h.awd().b((b) this);
    }

    public void awo() {
        aye();
    }

    public void awp() {
        aye();
    }

    private void aye() {
        this.dcS.awG();
    }
}
