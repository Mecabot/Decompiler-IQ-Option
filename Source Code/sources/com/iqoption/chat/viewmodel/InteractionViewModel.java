package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import kotlin.Pair;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u000b\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/chat/viewmodel/InteractionViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isRoomOpened", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isUpdateChatListRequested", "isUpdateChatRequested", "Lkotlin/Pair;", "", "openRoom", "Landroid/arch/lifecycle/MutableLiveData;", "updateChatListRequested", "updateChatRequested", "closeRoom", "", "notifyUpdateChatCompleted", "notifyUpdateChatListCompleted", "requestUpdateChat", "roomId", "requestUpdateChatList", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: InteractionViewModel.kt */
public final class InteractionViewModel extends ViewModel {
    public static final a aKE = new a();
    private final MutableLiveData<Boolean> aKA = new MutableLiveData();
    private final LiveData<Boolean> aKB = this.aKy;
    private final LiveData<Pair<Boolean, String>> aKC = this.aKz;
    private final LiveData<Boolean> aKD = this.aKA;
    private final MutableLiveData<Boolean> aKy = new MutableLiveData();
    private final MutableLiveData<Pair<Boolean, String>> aKz = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/viewmodel/InteractionViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/chat/viewmodel/InteractionViewModel;", "f", "Landroid/support/v4/app/Fragment;", "a", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: InteractionViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final InteractionViewModel e(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            return (InteractionViewModel) ViewModelProviders.b(fragmentActivity).h(InteractionViewModel.class);
        }
    }

    public final LiveData<Boolean> QQ() {
        return this.aKB;
    }

    public final LiveData<Pair<Boolean, String>> QR() {
        return this.aKC;
    }

    public final LiveData<Boolean> QS() {
        return this.aKD;
    }

    public final void QT() {
        this.aKy.setValue(Boolean.valueOf(false));
    }

    public final void fP(String str) {
        h.e(str, "roomId");
        this.aKz.setValue(j.D(Boolean.valueOf(true), str));
    }

    /* JADX WARNING: Missing block: B:3:0x0015, code:
            if (r2 != null) goto L_0x001a;
     */
    public final void QU() {
        /*
        r3 = this;
        r0 = r3.aKz;
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);
        r2 = r0.getValue();
        r2 = (kotlin.Pair) r2;
        if (r2 == 0) goto L_0x0018;
    L_0x000f:
        r2 = r2.aXF();
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x0018;
    L_0x0017:
        goto L_0x001a;
    L_0x0018:
        r2 = "";
    L_0x001a:
        r1 = kotlin.j.D(r1, r2);
        r0.setValue(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.viewmodel.InteractionViewModel.QU():void");
    }

    public final void QV() {
        this.aKA.setValue(Boolean.valueOf(true));
    }

    public final void QW() {
        this.aKA.setValue(Boolean.valueOf(false));
    }
}
