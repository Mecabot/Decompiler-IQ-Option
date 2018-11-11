package com.iqoption.deposit.pro;

import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "invoke"})
/* compiled from: ProDepositActivity.kt */
final class ProDepositActivity$defaultPreset$2 extends Lambda implements a<ArrayList<com.iqoption.core.c.c.a>> {
    final /* synthetic */ b this$0;

    ProDepositActivity$defaultPreset$2(b bVar) {
        this.this$0 = bVar;
        super(0);
    }

    /* renamed from: acC */
    public final ArrayList<com.iqoption.core.c.c.a> invoke() {
        return this.this$0.getIntent().getParcelableArrayListExtra("ARG_DEFAULT_PRESET");
    }
}
