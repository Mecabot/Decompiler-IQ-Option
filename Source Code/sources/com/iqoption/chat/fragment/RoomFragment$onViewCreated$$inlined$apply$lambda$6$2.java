package com.iqoption.chat.fragment;

import com.iqoption.chat.fragment.x.j;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, aXE = {"<anonymous>", "", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$4$onRatingChanged$1$f$2", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$4$onRatingChanged$$inlined$commitNow$lambda$2"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$6$2 extends Lambda implements a<l> {
    final /* synthetic */ g $message$inlined;
    final /* synthetic */ int $rating$inlined;
    final /* synthetic */ j this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$6$2(j jVar, int i, g gVar) {
        this.this$0 = jVar;
        this.$rating$inlined = i;
        this.$message$inlined = gVar;
        super(0);
    }

    public final void invoke() {
        x.j(this.this$0.this$0).fJ(this.$message$inlined.getId());
    }
}
