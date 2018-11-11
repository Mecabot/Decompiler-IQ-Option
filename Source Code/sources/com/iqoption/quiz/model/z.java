package com.iqoption.quiz.model;

import com.iqoption.quiz.api.response.q;
import io.reactivex.c.e;

final /* synthetic */ class z implements e {
    private final TriviaViewModel dnF;

    z(TriviaViewModel triviaViewModel) {
        this.dnF = triviaViewModel;
    }

    public void accept(Object obj) {
        this.dnF.c((q) obj);
    }
}
