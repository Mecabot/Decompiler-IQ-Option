package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView.CacheStrategy;

final /* synthetic */ class f implements r {
    private final LottieAnimationView jb;
    private final CacheStrategy jc;
    private final String je;

    f(LottieAnimationView lottieAnimationView, CacheStrategy cacheStrategy, String str) {
        this.jb = lottieAnimationView;
        this.jc = cacheStrategy;
        this.je = str;
    }

    public void a(g gVar) {
        this.jb.a(this.jc, this.je, gVar);
    }
}
