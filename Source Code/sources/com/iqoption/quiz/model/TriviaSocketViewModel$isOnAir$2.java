package com.iqoption.quiz.model;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import com.iqoption.core.ui.Status;
import com.iqoption.core.ui.c;
import com.iqoption.quiz.api.response.k;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Landroid/arch/lifecycle/MediatorLiveData;", "Lcom/iqoption/core/ui/Resource;", "", "invoke"})
/* compiled from: TriviaSocketViewModel.kt */
final class TriviaSocketViewModel$isOnAir$2 extends Lambda implements a<MediatorLiveData<c<Boolean>>> {
    final /* synthetic */ TriviaSocketViewModel this$0;

    TriviaSocketViewModel$isOnAir$2(TriviaSocketViewModel triviaSocketViewModel) {
        this.this$0 = triviaSocketViewModel;
        super(0);
    }

    /* renamed from: aCi */
    public final MediatorLiveData<c<Boolean>> invoke() {
        final MediatorLiveData<c<Boolean>> mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.a(this.this$0.aBO(), new Observer<S>() {
            /* renamed from: a */
            public final void onChanged(c<k> cVar) {
                if (cVar != null) {
                    MediatorLiveData mediatorLiveData = mediatorLiveData;
                    Status Yt = cVar.Yt();
                    k kVar = (k) cVar.getData();
                    mediatorLiveData.setValue(new c(Yt, kVar != null ? Boolean.valueOf(kVar.aAv()) : null, null, null, 12, null));
                }
            }
        });
        return mediatorLiveData;
    }
}
