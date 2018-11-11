package com.iqoption.verify.details;

import android.os.Parcelable;
import com.iqoption.mobbtech.connect.response.q;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "invoke"})
/* compiled from: VerifyDetailsFragment.kt */
final class VerifyDetailsFragment$card$2 extends Lambda implements a<q> {
    final /* synthetic */ a this$0;

    VerifyDetailsFragment$card$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aGR */
    public final q invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_CARD");
        if (parcelable != null) {
            return (q) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.mobbtech.connect.response.VerifyCard");
    }
}
