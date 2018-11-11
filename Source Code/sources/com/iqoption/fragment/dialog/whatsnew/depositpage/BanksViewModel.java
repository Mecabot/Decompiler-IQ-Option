package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.util.ah;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BanksViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "banks", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BankItem;", "getBanks", "()Landroid/arch/lifecycle/LiveData;", "banksData", "Landroid/arch/lifecycle/MutableLiveData;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "onCleared", "", "parseBanks", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BanksViewModel.kt */
public final class BanksViewModel extends ViewModel {
    public static final a cBY = new a();
    private final io.reactivex.disposables.a asp = new io.reactivex.disposables.a();
    private final MutableLiveData<List<BankItem>> cBW = new MutableLiveData();
    private final LiveData<List<BankItem>> cBX = this.cBW;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BanksViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/fragment/dialog/whatsnew/depositpage/BanksViewModel;", "f", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BanksViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final BanksViewModel R(Fragment fragment) {
            h.e(fragment, "f");
            ViewModel h = ViewModelProviders.d(fragment).h(BanksViewModel.class);
            h.d(h, "ViewModelProviders.of(f)…nksViewModel::class.java)");
            return (BanksViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/fragment/dialog/whatsnew/depositpage/BanksViewModel$parseBanks$1$1"})
    /* compiled from: BanksViewModel.kt */
    static final class b implements Runnable {
        final /* synthetic */ com.iqoption.core.microservices.popupserver.response.a cBZ;
        final /* synthetic */ BanksViewModel cCa;

        b(com.iqoption.core.microservices.popupserver.response.a aVar, BanksViewModel banksViewModel) {
            this.cBZ = aVar;
            this.cCa = banksViewModel;
        }

        public final void run() {
            this.cCa.cBW.postValue(ah.aGh().fromJson((String) this.cBZ.Ws().get("banks"), BankItem.List.class));
        }
    }

    public static final BanksViewModel R(Fragment fragment) {
        return cBY.R(fragment);
    }

    public final LiveData<List<BankItem>> alA() {
        return this.cBX;
    }

    public final void k(com.iqoption.core.microservices.popupserver.response.a aVar) {
        if (aVar != null) {
            this.asp.e(com.iqoption.core.h.i.Yo().q(new b(aVar, this)));
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.asp.clear();
    }
}
