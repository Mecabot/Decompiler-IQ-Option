package com.iqoption.chat.viewmodel;

import com.iqoption.chat.repository.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/repository/UserInfo;", "invoke"})
/* compiled from: UserInfoViewModel.kt */
final class UserInfoViewModel$loadUserInfo$1 extends Lambda implements b<g, l> {
    final /* synthetic */ UserInfoViewModel this$0;

    UserInfoViewModel$loadUserInfo$1(UserInfoViewModel userInfoViewModel) {
        this.this$0 = userInfoViewModel;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((g) obj);
        return l.etX;
    }

    public final void b(g gVar) {
        this.this$0.aLY.postValue(gVar);
    }
}
