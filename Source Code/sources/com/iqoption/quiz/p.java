package com.iqoption.quiz;

import android.arch.lifecycle.Observer;
import com.iqoption.core.ui.c;

final /* synthetic */ class p implements Observer {
    private final QuizActivity dgh;

    p(QuizActivity quizActivity) {
        this.dgh = quizActivity;
    }

    public void onChanged(Object obj) {
        this.dgh.d((c) obj);
    }
}
