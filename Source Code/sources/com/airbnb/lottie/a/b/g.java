package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation */
public class g {
    private final List<a<h, Path>> lx;
    private final List<a<Integer, Integer>> ly;
    private final List<Mask> lz;

    public g(List<Mask> list) {
        this.lz = list;
        this.lx = new ArrayList(list.size());
        this.ly = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.lx.add(((Mask) list.get(i)).es().dW());
            this.ly.add(((Mask) list.get(i)).ec().dW());
        }
    }

    public List<Mask> dI() {
        return this.lz;
    }

    public List<a<h, Path>> dJ() {
        return this.lx;
    }

    public List<a<Integer, Integer>> dK() {
        return this.ly;
    }
}
