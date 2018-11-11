package com.iqoption.verify.status;

import android.os.Parcelable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/verify/status/CardHintData;", "invoke"})
/* compiled from: VerifyHintBottomSheetFragment.kt */
final class VerifyHintBottomSheetFragment$cardHintData$2 extends Lambda implements a<e> {
    final /* synthetic */ j this$0;

    VerifyHintBottomSheetFragment$cardHintData$2(j jVar) {
        this.this$0 = jVar;
        super(0);
    }

    /* renamed from: aHp */
    public final e invoke() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_CARD_HINT_DATA");
        if (parcelable != null) {
            return (e) parcelable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.verify.status.CardHintData");
    }
}
