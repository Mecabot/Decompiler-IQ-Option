package com.iqoption.core.microservices.videoeducation.response;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"})
/* compiled from: Video.kt */
final class Video$localizedDuration$2 extends Lambda implements a<Integer> {
    final /* synthetic */ g this$0;

    Video$localizedDuration$2(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: XY */
    public final Integer invoke() {
        h c = this.this$0.XS();
        return c != null ? Integer.valueOf(c.getDuration()) : null;
    }
}
