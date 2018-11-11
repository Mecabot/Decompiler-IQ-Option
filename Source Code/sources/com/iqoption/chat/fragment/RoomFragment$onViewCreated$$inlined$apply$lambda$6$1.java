package com.iqoption.chat.fragment;

import com.iqoption.chat.fragment.x.j;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, aXE = {"<anonymous>", "", "comment", "", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$4$onRatingChanged$1$f$1", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$4$onRatingChanged$$inlined$commitNow$lambda$1"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$6$1 extends Lambda implements b<String, l> {
    final /* synthetic */ g $message$inlined;
    final /* synthetic */ int $rating$inlined;
    final /* synthetic */ j this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$6$1(j jVar, int i, g gVar) {
        this.this$0 = jVar;
        this.$rating$inlined = i;
        this.$message$inlined = gVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        fB((String) obj);
        return l.etX;
    }

    public final void fB(String str) {
        h.e(str, "comment");
        x.c(this.this$0.this$0).b(this.$message$inlined.getId(), this.$rating$inlined, str);
    }
}
