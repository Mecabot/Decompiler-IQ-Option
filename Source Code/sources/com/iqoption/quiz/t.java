package com.iqoption.quiz;

import kotlin.i;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class t {
    public static final /* synthetic */ int[] aoS = new int[QuizState.values().length];

    static {
        aoS[QuizState.QuizOnAir.ordinal()] = 1;
        aoS[QuizState.QuizOffAirSplashPager.ordinal()] = 2;
        aoS[QuizState.QuizError.ordinal()] = 3;
        aoS[QuizState.QuizPromoCode.ordinal()] = 4;
        aoS[QuizState.QuizUpdate.ordinal()] = 5;
    }
}
