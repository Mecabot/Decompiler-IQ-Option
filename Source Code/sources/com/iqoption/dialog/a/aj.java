package com.iqoption.dialog.a;

import com.google.common.base.d;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.mobbtech.connect.response.options.e;

/* compiled from: OptionToPositionTransformation */
final class aj implements d<e, Position> {
    aj() {
    }

    /* renamed from: n */
    public Position apply(e eVar) {
        return eVar instanceof Position ? (Position) eVar : null;
    }
}
