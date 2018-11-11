package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.h;

public class Mask {
    private final MaskMode mS;
    private final h mT;
    private final d mz;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, h hVar, d dVar) {
        this.mS = maskMode;
        this.mT = hVar;
        this.mz = dVar;
    }

    public MaskMode er() {
        return this.mS;
    }

    public h es() {
        return this.mT;
    }

    public d ec() {
        return this.mz;
    }
}
