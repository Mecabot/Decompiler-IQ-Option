package com.iqoption.quiz;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import com.iqoption.core.ui.c;

final /* synthetic */ class r implements Observer {
    private final LiveData ctF;
    private final QuizActivity dgh;

    r(QuizActivity quizActivity, LiveData liveData) {
        this.dgh = quizActivity;
        this.ctF = liveData;
    }

    public void onChanged(Object obj) {
        this.dgh.a(this.ctF, (c) obj);
    }
}
