package com.iqoption.quiz;

import android.arch.lifecycle.Observer;

final /* synthetic */ class q implements Observer {
    private final QuizActivity dgh;

    q(QuizActivity quizActivity) {
        this.dgh = quizActivity;
    }

    public void onChanged(Object obj) {
        this.dgh.r((Boolean) obj);
    }
}
