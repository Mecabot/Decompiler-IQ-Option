package com.iqoption.quiz.c;

import android.support.v7.util.DiffUtil.DiffResult;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/quiz/util/DiffResult;", "T", "Lcom/iqoption/quiz/util/Identifiable;", "", "request", "Lcom/iqoption/quiz/util/DiffRequest;", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "(Lcom/iqoption/quiz/util/DiffRequest;Landroid/support/v7/util/DiffUtil$DiffResult;)V", "getDiff", "()Landroid/support/v7/util/DiffUtil$DiffResult;", "getRequest", "()Lcom/iqoption/quiz/util/DiffRequest;", "quiz_release"})
/* compiled from: DiffResult.kt */
public final class d<T extends e<?>> {
    private final DiffResult bgt;
    private final c<T> doq;

    public d(c<T> cVar, DiffResult diffResult) {
        h.e(cVar, "request");
        h.e(diffResult, "diff");
        this.doq = cVar;
        this.bgt = diffResult;
    }

    public final DiffResult ZS() {
        return this.bgt;
    }
}
