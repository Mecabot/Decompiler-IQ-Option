package com.iqoption.quiz.model;

import com.iqoption.quiz.ae.h;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, aXE = {"Lcom/iqoption/quiz/model/LeaderBoardFilter;", "", "label", "", "(Ljava/lang/String;II)V", "getLabel", "()I", "ALL", "LAST_GAME", "quiz_release"})
/* compiled from: LeaderBoardFilter.kt */
public enum LeaderBoardFilter {
    ALL(h.all_games),
    LAST_GAME(h.last_game);
    
    private final int label;

    protected LeaderBoardFilter(int i) {
        this.label = i;
    }

    public final int getLabel() {
        return this.label;
    }
}
