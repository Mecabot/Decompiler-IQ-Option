package com.iqoption.dialog.a;

import com.google.common.base.d;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.a;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.position.result.PositionResult;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.util.ag;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PositionsLoader */
public final class al {
    private s<List<Position>> Wk;
    private final long[] cho;
    private volatile List<Position> cht;
    private InstrumentType instrumentType;

    public al(long[] jArr, InstrumentType instrumentType) {
        this.cho = jArr;
        this.instrumentType = instrumentType;
    }

    public s<List<Position>> aeJ() {
        if (a.Cw().getBalanceId().longValue() == 0) {
            return o.m(new IllegalStateException("balance id = 0"));
        }
        if (this.cht != null) {
            return o.aR(this.cht);
        }
        if (this.Wk != null && ag.j(this.Wk)) {
            return this.Wk;
        }
        Iterable arrayList = new ArrayList();
        d anonymousClass1 = new d<PositionResult, Position>() {
            /* renamed from: a */
            public Position apply(PositionResult positionResult) {
                return positionResult.position;
            }
        };
        for (long p : this.cho) {
            arrayList.add(o.a(f.p(p, this.instrumentType), anonymousClass1));
        }
        this.Wk = o.E(arrayList);
        o.a(this.Wk, new n<List<Position>>() {
            /* renamed from: B */
            public void onSuccess(List<Position> list) {
                i.d("PositionsLoader", "Positions have been loaded");
                al.this.cht = list;
            }

            public void l(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Loading failed: ");
                stringBuilder.append(th.getMessage());
                i.w("PositionsLoader", stringBuilder.toString(), th);
                al.this.cht = null;
            }
        });
        return this.Wk;
    }
}
