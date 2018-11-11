package com.iqoption.quiz.d;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, aXE = {"Lcom/iqoption/quiz/winners/WinnerDiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "()V", "newList", "", "Lcom/iqoption/quiz/winners/WinnerInfo;", "getNewList", "()Ljava/util/List;", "setNewList", "(Ljava/util/List;)V", "oldList", "getOldList", "setOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "reset", "", "quiz_release"})
/* compiled from: WinnerDiffCallback.kt */
public final class a extends Callback {
    private List<b> aLp = m.emptyList();
    private List<b> aLq = m.emptyList();

    public final void aa(List<b> list) {
        h.e(list, "<set-?>");
        this.aLp = list;
    }

    public final void ab(List<b> list) {
        h.e(list, "<set-?>");
        this.aLq = list;
    }

    public int getOldListSize() {
        return this.aLp.size();
    }

    public int getNewListSize() {
        return this.aLq.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return ((b) this.aLp.get(i)).getId() == ((b) this.aLq.get(i2)).getId();
    }

    public boolean areContentsTheSame(int i, int i2) {
        return h.E((b) this.aLp.get(i), (b) this.aLq.get(i2));
    }

    public final void reset() {
        this.aLp = m.emptyList();
        this.aLq = m.emptyList();
    }
}
