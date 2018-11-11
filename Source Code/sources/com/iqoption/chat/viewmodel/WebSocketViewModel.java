package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.ToastEntity;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.af;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/viewmodel/WebSocketViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isConnected", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isConnectedData", "Landroid/arch/lifecycle/MutableLiveData;", "webSocket", "Lcom/iqoption/socket/IqSocket;", "onCleared", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WebSocketViewModel.kt */
public final class WebSocketViewModel extends ViewModel {
    private static final String TAG = "WebSocketViewModel";
    public static final a aMd = new a();
    private final com.iqoption.g.a aMa;
    private final MutableLiveData<Boolean> aMb;
    private final LiveData<Boolean> aMc = this.aMb;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/viewmodel/WebSocketViewModel$Companion;", "", "()V", "TAG", "", "get", "Lcom/iqoption/chat/viewmodel/WebSocketViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WebSocketViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WebSocketViewModel h(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (WebSocketViewModel) ViewModelProviders.b(fragmentActivity).h(WebSocketViewModel.class);
        }
    }

    public WebSocketViewModel() {
        com.iqoption.g.a aDm = WebSocketHandler.aDm();
        h.d(aDm, "WebSocketHandler.instance()");
        this.aMa = aDm;
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Boolean.valueOf(this.aMa.isAuthorized()));
        s bE = this.aMa.bE(TAG);
        h.d(bE, "future");
        af.a(bE, new WebSocketViewModel$isConnectedData$1$1(mutableLiveData), null, null, null, 14, null);
        this.aMb = mutableLiveData;
    }

    static {
        h.d(WebSocketViewModel.class.getSimpleName(), "WebSocketViewModel::class.java.simpleName");
    }

    public final LiveData<Boolean> RH() {
        return this.aMc;
    }

    protected void onCleared() {
        super.onCleared();
        this.aMa.m(TAG, ToastEntity.ACTION_TOAST_DURATION);
    }
}
