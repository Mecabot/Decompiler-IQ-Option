package com.iqoption.charttools.tools.data;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/tools/data/EmptyTemplateItem;", "Lcom/iqoption/charttools/tools/data/TemplateAdapterItem;", "()V", "id", "", "getId", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplateAdapterItems.kt */
public final class f extends k {
    public static final f aBQ;
    private static final String id;

    static {
        f fVar = new f();
        aBQ = fVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("empty:");
        stringBuilder.append(fVar.getClass().getSimpleName());
        id = stringBuilder.toString();
    }

    private f() {
        super();
    }

    /* renamed from: getId */
    public String Jf() {
        return id;
    }
}
