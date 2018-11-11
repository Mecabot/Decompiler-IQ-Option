package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/chat/viewmodel/SearchRoomViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "searchText", "Landroid/arch/lifecycle/LiveData;", "", "getSearchText", "()Landroid/arch/lifecycle/LiveData;", "searchTextData", "Landroid/arch/lifecycle/MutableLiveData;", "search", "", "text", "startSearch", "stopSearch", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SearchRoomViewModel.kt */
public final class SearchRoomViewModel extends ViewModel {
    public static final a aLG = new a();
    private final MutableLiveData<CharSequence> aLE = new MutableLiveData();
    private final LiveData<CharSequence> aLF = this.aLE;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/viewmodel/SearchRoomViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/chat/viewmodel/SearchRoomViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SearchRoomViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final SearchRoomViewModel f(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (SearchRoomViewModel) ViewModelProviders.b(fragmentActivity).h(SearchRoomViewModel.class);
        }
    }

    public final LiveData<CharSequence> Ru() {
        return this.aLF;
    }

    public final void r(CharSequence charSequence) {
        h.e(charSequence, "text");
        this.aLE.setValue(charSequence);
    }

    public final void Rv() {
        this.aLE.setValue("");
    }

    public final void stopSearch() {
        this.aLE.setValue(null);
    }
}
