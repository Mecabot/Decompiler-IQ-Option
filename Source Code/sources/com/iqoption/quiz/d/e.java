package com.iqoption.quiz.d;

import android.support.v7.widget.RecyclerView;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/quiz/winners/WinnersAnimatorController;", "", "list", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/support/v7/widget/RecyclerView;)V", "value", "", "isRunning", "setRunning", "(Z)V", "isStopped", "getList", "()Landroid/support/v7/widget/RecyclerView;", "scrollCommand", "com/iqoption/quiz/winners/WinnersAnimatorController$scrollCommand$1", "Lcom/iqoption/quiz/winners/WinnersAnimatorController$scrollCommand$1;", "scrollStep", "", "start", "", "stop", "quiz_release"})
/* compiled from: WinnersAnimatorController.kt */
public final class e {
    private boolean Fs;
    private final RecyclerView axw;
    private final int dpn = this.axw.getResources().getDimensionPixelSize(com.iqoption.quiz.ae.a.dp1);
    private final a dpp = new a(this);
    private boolean dpq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/quiz/winners/WinnersAnimatorController$scrollCommand$1", "Ljava/lang/Runnable;", "run", "", "quiz_release"})
    /* compiled from: WinnersAnimatorController.kt */
    public static final class a implements Runnable {
        final /* synthetic */ e dpr;

        a(e eVar) {
            this.dpr = eVar;
        }

        public void run() {
            if (this.dpr.Fs) {
                this.dpr.aDk().scrollBy(this.dpr.dpn, 0);
                this.dpr.aDk().postOnAnimation(this);
            }
        }
    }

    public e(RecyclerView recyclerView) {
        h.e(recyclerView, "list");
        this.axw = recyclerView;
    }

    public final RecyclerView aDk() {
        return this.axw;
    }

    private final void eN(boolean z) {
        if ((!this.dpq || this.Fs) && this.Fs != z) {
            if (z) {
                this.axw.postOnAnimation(this.dpp);
            }
            this.Fs = z;
        }
    }

    public final void start() {
        eN(true);
    }

    public final void stop() {
        eN(false);
        this.dpq = true;
    }
}
