package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.chat.repository.g;
import com.iqoption.util.af;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/viewmodel/UserInfoViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isReleased", "", "userInfo", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/chat/repository/UserInfo;", "getUserInfo", "()Landroid/arch/lifecycle/LiveData;", "userInfoData", "Landroid/arch/lifecycle/MutableLiveData;", "loadUserInfo", "", "userId", "", "countryId", "onCleared", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: UserInfoViewModel.kt */
public final class UserInfoViewModel extends ViewModel {
    private static final String TAG = "UserInfoViewModel";
    public static final a aLZ = new a();
    private boolean aLX;
    private final MutableLiveData<g> aLY = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/chat/viewmodel/UserInfoViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "create", "Lcom/iqoption/chat/viewmodel/UserInfoViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: UserInfoViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final UserInfoViewModel l(Fragment fragment) {
            h.e(fragment, "fragment");
            return (UserInfoViewModel) ViewModelProviders.d(fragment).h(UserInfoViewModel.class);
        }
    }

    public final LiveData<g> RG() {
        return this.aLY;
    }

    public final void o(long j, long j2) {
        af.a(com.iqoption.chat.repository.h.aJS.n(j, j2), new UserInfoViewModel$loadUserInfo$1(this), new UserInfoViewModel$loadUserInfo$2(this, j, j2), null, null, 12, null);
    }

    protected void onCleared() {
        super.onCleared();
        this.aLX = true;
    }
}
