package com.iqoption.portfolio.component;

import android.view.ViewGroup;
import com.iqoption.d.aae;
import com.iqoption.d.aag;
import com.iqoption.d.aau;
import com.iqoption.d.aay;
import com.iqoption.d.aba;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.k;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.viewholder.aa;
import com.iqoption.portfolio.component.viewholder.ac;
import com.iqoption.portfolio.component.viewholder.ao;
import com.iqoption.portfolio.component.viewholder.u;
import com.iqoption.portfolio.component.viewholder.x;
import com.iqoption.portfolio.component.viewholder.y;
import com.iqoption.portfolio.component.viewholder.z;

/* compiled from: MicroPendingViewHolderCreatorBinder */
public final class d extends p<ao, k, r> {
    public d(r rVar) {
        super(rVar);
    }

    /* renamed from: c */
    public ao b(int i, ViewGroup viewGroup) {
        switch (i) {
            case -1:
                return new x(getLayoutInflater(), viewGroup, (r) awL());
            case 1:
                return new y(aau.ad(getLayoutInflater(), viewGroup, false), (r) awL());
            case 2:
                return new ac(aba.af(getLayoutInflater(), viewGroup, false), (r) awL());
            case 3:
                return new z(aay.ae(getLayoutInflater(), viewGroup, false), (r) awL());
            case 5:
                return new aa(aag.Z(getLayoutInflater(), viewGroup, false), (r) awL());
            case 6:
                return new u(aae.Y(getLayoutInflater(), viewGroup, false), (r) awL());
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    void a(int i, ao aoVar, k kVar) {
        switch (i) {
            case -1:
                return;
            case 1:
                ((y) aoVar).a((l) kVar);
                return;
            case 2:
                ((ac) aoVar).a((l) kVar);
                return;
            case 3:
                ((z) aoVar).d((m) kVar);
                return;
            case 5:
                ((aa) aoVar).a((l) kVar);
                return;
            case 6:
                ((u) aoVar).d((m) kVar);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
