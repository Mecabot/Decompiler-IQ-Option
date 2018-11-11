package com.iqoption.dialog.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.position.Position;

final /* synthetic */ class c implements am {
    private final Position amQ;
    private final a cgf;
    private final ImmutableList cgg;
    private final c cgh;

    c(a aVar, Position position, ImmutableList immutableList, c cVar) {
        this.cgf = aVar;
        this.amQ = position;
        this.cgg = immutableList;
        this.cgh = cVar;
    }

    public View d(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return b.a(this.cgf, this.amQ, this.cgg, this.cgh, layoutInflater, viewGroup);
    }
}
