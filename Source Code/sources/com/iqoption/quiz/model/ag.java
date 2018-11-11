package com.iqoption.quiz.model;

import io.reactivex.c.e;

final /* synthetic */ class ag implements e {
    private final TriviaViewModel dnF;

    ag(TriviaViewModel triviaViewModel) {
        this.dnF = triviaViewModel;
    }

    public void accept(Object obj) {
        this.dnF.c((com.iqoption.quiz.api.response.e) obj);
    }
}
