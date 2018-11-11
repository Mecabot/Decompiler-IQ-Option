package com.iqoption.kyc.fragment.gdpr;

import com.iqoption.view.text.l;
import com.iqoption.view.text.q;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/view/text/Link;", "invoke"})
/* compiled from: KycGdprFragment.kt */
final class KycGdprFragment$gdprLink$2 extends Lambda implements a<l> {
    final /* synthetic */ a this$0;

    KycGdprFragment$gdprLink$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aqe */
    public final l invoke() {
        String string = this.this$0.getString(R.string.privacy_policy);
        h.d(string, "getString(R.string.privacy_policy)");
        return new l(string, q.cc(com.iqoption.core.ext.a.m(this.this$0)));
    }
}
