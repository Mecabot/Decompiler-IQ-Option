package com.iqoption.marginaddon;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: MarginAddOnInfoDialog.kt */
final class MarginAddOnInfoDialog$rightOffset$2 extends Lambda implements a<Integer> {
    final /* synthetic */ a this$0;

    MarginAddOnInfoDialog$rightOffset$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    public /* synthetic */ Object invoke() {
        return Integer.valueOf(aqI());
    }

    public final int aqI() {
        return com.iqoption.core.ext.a.o(this.this$0).getInt("ARG_RIGHT_OFFSET");
    }
}
