package com.iqoption.portfolio.component;

import android.view.ViewGroup;
import com.iqoption.d.ady;
import com.iqoption.d.aec;
import com.iqoption.d.aee;
import com.iqoption.d.aen;
import com.iqoption.d.aep;
import com.iqoption.d.aet;
import com.iqoption.d.aev;
import com.iqoption.d.afl;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.b.f;
import com.iqoption.portfolio.component.viewholder.ag;
import com.iqoption.portfolio.component.viewholder.ah;
import com.iqoption.portfolio.component.viewholder.ai;
import com.iqoption.portfolio.component.viewholder.b;
import com.iqoption.portfolio.component.viewholder.c;
import com.iqoption.portfolio.component.viewholder.d;
import com.iqoption.portfolio.component.viewholder.h;
import com.iqoption.portfolio.component.viewholder.i;
import com.iqoption.portfolio.component.viewholder.j;

/* compiled from: OpenViewHolderCreatorBinder */
public final class g extends p<ai, f, n> {
    public g(n nVar) {
        super(nVar);
    }

    /* renamed from: a */
    public ai b(int i, ViewGroup viewGroup) {
        switch (i) {
            case -3:
                return new h(aep.ao(getLayoutInflater(), viewGroup, false), (n) awL());
            case -2:
                return new ah(afl.au(getLayoutInflater(), viewGroup, false), (n) awL());
            case -1:
                return new ag(getLayoutInflater(), viewGroup, (n) awL());
            case 1:
                return new b(ady.ak(getLayoutInflater(), viewGroup, false), (n) awL());
            case 2:
                return new d(aee.am(getLayoutInflater(), viewGroup, false), (n) awL());
            case 3:
                return new c(aec.al(getLayoutInflater(), viewGroup, false), (n) awL());
            case 4:
                return new com.iqoption.portfolio.component.viewholder.g(aen.an(getLayoutInflater(), viewGroup, false), (n) awL());
            case 5:
                return new j(aev.aq(getLayoutInflater(), viewGroup, false), (n) awL());
            case 6:
                return new i(aet.ap(getLayoutInflater(), viewGroup, false), (n) awL());
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void a(int i, ai aiVar, f fVar) {
        switch (i) {
            case -3:
                ((h) aiVar).a((com.iqoption.portfolio.component.b.c) fVar);
                return;
            case -2:
                ((ah) aiVar).a((e) fVar);
                return;
            case -1:
                return;
            case 1:
                ((b) aiVar).a((com.iqoption.portfolio.component.b.i) fVar);
                return;
            case 2:
                ((d) aiVar).a((com.iqoption.portfolio.component.b.i) fVar);
                return;
            case 3:
                ((c) aiVar).a((com.iqoption.portfolio.component.b.g) fVar);
                return;
            case 4:
                ((com.iqoption.portfolio.component.viewholder.g) aiVar).a((com.iqoption.portfolio.component.b.i) fVar);
                return;
            case 5:
                ((j) aiVar).a((com.iqoption.portfolio.component.b.i) fVar);
                return;
            case 6:
                ((i) aiVar).a((com.iqoption.portfolio.component.b.h) fVar);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
