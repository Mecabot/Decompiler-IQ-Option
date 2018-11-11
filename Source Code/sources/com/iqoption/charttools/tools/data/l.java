package com.iqoption.charttools.tools.data;

import com.iqoption.charttools.model.a.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/charttools/tools/data/TemplateItem;", "Lcom/iqoption/charttools/tools/data/TemplateAdapterItem;", "template", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "indicators", "", "isApplied", "", "(Lcom/iqoption/charttools/model/template/ChartTemplate;Ljava/lang/String;Z)V", "id", "getId", "()Ljava/lang/String;", "getIndicators", "()Z", "getTemplate", "()Lcom/iqoption/charttools/model/template/ChartTemplate;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplateAdapterItems.kt */
public final class l extends k {
    private final String aBU;
    private final boolean aBV;
    private final a atq;
    private final String id;

    public l(a aVar, String str, boolean z) {
        h.e(aVar, "template");
        h.e(str, "indicators");
        super();
        this.atq = aVar;
        this.aBU = str;
        this.aBV = z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("template:");
        stringBuilder.append(this.atq.getId());
        this.id = stringBuilder.toString();
    }

    public final a Oh() {
        return this.atq;
    }

    public final String Oi() {
        return this.aBU;
    }

    public final boolean Oj() {
        return this.aBV;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
