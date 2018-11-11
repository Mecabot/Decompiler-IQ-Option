package com.iqoption.core.microservices.videoeducation.response;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: Category.kt */
final class Category$localizedImage$2 extends Lambda implements a<String> {
    final /* synthetic */ a this$0;

    Category$localizedImage$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: PM */
    public final String invoke() {
        b bVar = (b) c.aZH.am(this.this$0.aZE);
        return bVar != null ? bVar.getUrl() : null;
    }
}
