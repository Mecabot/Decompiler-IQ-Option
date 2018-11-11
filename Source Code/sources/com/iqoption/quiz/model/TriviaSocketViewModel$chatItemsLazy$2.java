package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import com.iqoption.quiz.chat.b;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/quiz/chat/ChatItem;", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$chatItemsLazy$2 extends Lambda implements a<LiveData<List<? extends b>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    TriviaSocketViewModel$chatItemsLazy$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aBu */
    public final LiveData<List<b>> invoke() {
        return this.this$0.aBP();
    }
}
