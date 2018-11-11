package com.iqoption.quiz.c;

import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B%\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, aXE = {"Lcom/iqoption/quiz/util/DiffRequest;", "T", "Lcom/iqoption/quiz/util/Identifiable;", "", "old", "", "new", "(Ljava/util/List;Ljava/util/List;)V", "getNew", "()Ljava/util/List;", "getOld", "execute", "Lcom/iqoption/quiz/util/DiffResult;", "diffCallback", "Lcom/iqoption/quiz/util/DiffCallback;", "quiz_release"})
/* compiled from: DiffRequest.kt */
public final class c<T extends e<?>> {
    private final List<T> bgq;
    private final List<T> bgr;

    public c() {
        this(null, null, 3, null);
    }

    public c(List<? extends T> list, List<? extends T> list2) {
        h.e(list, "old");
        h.e(list2, "new");
        this.bgq = list;
        this.bgr = list2;
    }

    public /* synthetic */ c(List list, List list2, int i, f fVar) {
        if ((i & 1) != 0) {
            list = m.emptyList();
        }
        if ((i & 2) != 0) {
            list2 = m.emptyList();
        }
        this(list, list2);
    }

    public final List<T> ZP() {
        return this.bgq;
    }

    public final List<T> ZQ() {
        return this.bgr;
    }

    public final d<T> a(b<T> bVar) {
        d<T> dVar;
        h.e(bVar, "diffCallback");
        synchronized (bVar) {
            bVar.a(this);
            DiffResult calculateDiff = DiffUtil.calculateDiff(bVar);
            h.d(calculateDiff, "DiffUtil.calculateDiff(diffCallback)");
            dVar = new d(this, calculateDiff);
        }
        return dVar;
    }
}
