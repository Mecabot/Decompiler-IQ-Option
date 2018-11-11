package com.iqoption.quiz;

import android.arch.lifecycle.Observer;

final /* synthetic */ class n implements Observer {
    static final Observer dgg = new n();

    private n() {
    }

    public void onChanged(Object obj) {
        QuizActivity.bz(obj);
    }
}
