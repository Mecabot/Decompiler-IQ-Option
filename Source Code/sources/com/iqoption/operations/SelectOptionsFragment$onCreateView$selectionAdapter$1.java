package com.iqoption.operations;

import com.iqoption.operations.OperationViewModel.FilterType;
import com.iqoption.operations.OperationViewModel.c;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "filterItem", "Lcom/iqoption/operations/OperationViewModel$FilterItem;", "invoke"})
/* compiled from: SelectOptionsFragment.kt */
final class SelectOptionsFragment$onCreateView$selectionAdapter$1 extends Lambda implements b<c, l> {
    final /* synthetic */ FilterType $filterType;
    final /* synthetic */ j this$0;

    SelectOptionsFragment$onCreateView$selectionAdapter$1(j jVar, FilterType filterType) {
        this.this$0 = jVar;
        this.$filterType = filterType;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        c((c) obj);
        return l.etX;
    }

    public final void c(c cVar) {
        h.e(cVar, "filterItem");
        j.a(this.this$0).a(cVar, this.$filterType);
    }
}
