package com.iqoption.gl;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.position.Position;

final /* synthetic */ class ac implements Runnable {
    private final String afd;
    private final Position cIY;
    private final InstrumentType cIZ;
    private final double cJa;
    private final double cqe;
    private final String je;

    ac(Position position, String str, String str2, InstrumentType instrumentType, double d, double d2) {
        this.cIY = position;
        this.afd = str;
        this.je = str2;
        this.cIZ = instrumentType;
        this.cqe = d;
        this.cJa = d2;
    }

    public void run() {
        i.a(this.cIY, this.afd, this.je, this.cIZ, this.cqe, this.cJa);
    }
}
