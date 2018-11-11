package com.iqoption.welcomeonboarding;

import android.graphics.Rect;

final /* synthetic */ class d implements Runnable {
    private final Rect cFR;
    private final WelcomeOnboardingActivity dLI;

    d(WelcomeOnboardingActivity welcomeOnboardingActivity, Rect rect) {
        this.dLI = welcomeOnboardingActivity;
        this.cFR = rect;
    }

    public void run() {
        this.dLI.h(this.cFR);
    }
}
