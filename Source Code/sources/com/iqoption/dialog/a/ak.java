package com.iqoption.dialog.a;

import com.google.common.base.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.mobbtech.connect.response.a;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.ag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: OptionsLoader */
public class ak {
    private s<ImmutableList<e>> Wk;
    private volatile ImmutableList<e> chm;
    private final long[] cho;
    private d<a, ImmutableList<e>> chp = new d<a, ImmutableList<e>>() {
        /* renamed from: a */
        public ImmutableList<e> apply(final a aVar) {
            if (aVar == null) {
                return null;
            }
            return i.c(aVar.cVv.auP()).b(new d<Long, e>() {
                /* renamed from: r */
                public e apply(Long l) {
                    return l == null ? null : e.betInfo2position(l.longValue(), aVar.cVv);
                }
            }).sA();
        }
    };

    public ak(long[] jArr) {
        this.cho = jArr;
    }

    public s<ImmutableList<e>> aeJ() {
        if (com.iqoption.app.a.Cw().getBalanceId().longValue() == 0) {
            return o.m(new IllegalStateException("balance id = 0"));
        }
        if (this.chm != null) {
            return o.aR(this.chm);
        }
        if (this.Wk != null && ag.j(this.Wk)) {
            return this.Wk;
        }
        Collection arrayList = new ArrayList();
        for (long valueOf : this.cho) {
            arrayList.add(Long.valueOf(valueOf));
        }
        this.Wk = o.a(Requests.a(IQApp.Dk(), arrayList), this.chp);
        o.a(this.Wk, new n<List<e>>() {
            /* renamed from: B */
            public void onSuccess(List<e> list) {
                com.iqoption.core.i.d("OptionsLoader", "Positions have been loaded");
                ak.this.chm = ImmutableList.m(list);
            }

            public void l(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Loading failed: ");
                stringBuilder.append(th.getMessage());
                com.iqoption.core.i.w("OptionsLoader", stringBuilder.toString(), th);
                ak.this.chm = null;
            }
        });
        return this.Wk;
    }
}
