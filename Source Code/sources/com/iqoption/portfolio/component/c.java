package com.iqoption.portfolio.component;

import android.view.ViewGroup;
import com.iqoption.d.aaa;
import com.iqoption.d.aac;
import com.iqoption.d.aak;
import com.iqoption.d.zi;
import com.iqoption.d.zm;
import com.iqoption.d.zo;
import com.iqoption.d.zu;
import com.iqoption.d.zw;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.b.f;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.b.h;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.viewholder.ai;
import com.iqoption.portfolio.component.viewholder.m;
import com.iqoption.portfolio.component.viewholder.n;
import com.iqoption.portfolio.component.viewholder.o;
import com.iqoption.portfolio.component.viewholder.p;
import com.iqoption.portfolio.component.viewholder.q;
import com.iqoption.portfolio.component.viewholder.r;
import com.iqoption.portfolio.component.viewholder.s;
import com.iqoption.portfolio.component.viewholder.v;
import com.iqoption.portfolio.component.viewholder.w;

/* compiled from: MicroOpenViewHolderCreatorBinder */
public final class c extends p<ai, f, n> {
    public c(n nVar) {
        super(nVar);
    }

    /* renamed from: a */
    public ai b(int i, ViewGroup viewGroup) {
        switch (i) {
            case -3:
                return new q(zw.V(getLayoutInflater(), viewGroup, false), (n) awL());
            case -2:
                return new w(aak.ab(getLayoutInflater(), viewGroup, false), (n) awL());
            case -1:
                return new v(getLayoutInflater(), viewGroup, (n) awL());
            case 1:
                return new m(zi.P(getLayoutInflater(), viewGroup, false), (n) awL());
            case 2:
                return new o(zo.R(getLayoutInflater(), viewGroup, false), (n) awL());
            case 3:
                return new n(zm.Q(getLayoutInflater(), viewGroup, false), (n) awL());
            case 4:
                return new p(zu.U(getLayoutInflater(), viewGroup, false), (n) awL());
            case 5:
                return new s(aac.X(getLayoutInflater(), viewGroup, false), (n) awL());
            case 6:
                return new r(aaa.W(getLayoutInflater(), viewGroup, false), (n) awL());
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
                ((q) aiVar).a((com.iqoption.portfolio.component.b.c) fVar);
                return;
            case -2:
                ((w) aiVar).a((e) fVar);
                return;
            case -1:
                return;
            case 1:
                ((m) aiVar).a((i) fVar);
                return;
            case 2:
                ((o) aiVar).a((i) fVar);
                return;
            case 3:
                ((n) aiVar).a((g) fVar);
                return;
            case 4:
                ((p) aiVar).a((i) fVar);
                return;
            case 5:
                ((s) aiVar).a((i) fVar);
                return;
            case 6:
                ((r) aiVar).a((h) fVar);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(aiVar.getItemViewType());
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
