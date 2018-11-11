package com.iqoption.portfolio.component;

import android.view.ViewGroup;
import com.iqoption.d.aff;
import com.iqoption.d.afh;
import com.iqoption.d.aft;
import com.iqoption.d.afv;
import com.iqoption.d.afz;
import com.iqoption.d.agb;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.viewholder.ad;
import com.iqoption.portfolio.component.viewholder.ae;
import com.iqoption.portfolio.component.viewholder.ak;
import com.iqoption.portfolio.component.viewholder.al;
import com.iqoption.portfolio.component.viewholder.am;
import com.iqoption.portfolio.component.viewholder.an;
import com.iqoption.portfolio.component.viewholder.ao;
import com.iqoption.portfolio.component.viewholder.ap;

/* compiled from: PendingViewHolderCreatorBinder */
public final class k extends p<ao, com.iqoption.portfolio.component.b.k, r> {
    public k(r rVar) {
        super(rVar);
    }

    /* renamed from: c */
    public ao b(int i, ViewGroup viewGroup) {
        switch (i) {
            case -2:
                return new am(afv.ax(getLayoutInflater(), viewGroup, false), (r) awL());
            case -1:
                return new ak(getLayoutInflater(), viewGroup, (r) awL());
            case 1:
                return new al(aft.aw(getLayoutInflater(), viewGroup, false), (r) awL());
            case 2:
                return new ap(agb.az(getLayoutInflater(), viewGroup, false), (r) awL());
            case 3:
                return new an(afz.ay(getLayoutInflater(), viewGroup, false), (r) awL());
            case 5:
                return new ae(afh.as(getLayoutInflater(), viewGroup, false), (r) awL());
            case 6:
                return new ad(aff.ar(getLayoutInflater(), viewGroup, false), (r) awL());
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    void a(int i, ao aoVar, com.iqoption.portfolio.component.b.k kVar) {
        switch (i) {
            case -2:
                ((am) aoVar).a((e) kVar);
                return;
            case -1:
                return;
            case 1:
                ((al) aoVar).a((l) kVar);
                return;
            case 2:
                ((ap) aoVar).a((l) kVar);
                return;
            case 3:
                ((an) aoVar).d((m) kVar);
                return;
            case 5:
                ((ae) aoVar).a((l) kVar);
                return;
            case 6:
                ((ad) aoVar).d((m) kVar);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
