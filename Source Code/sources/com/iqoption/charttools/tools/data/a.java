package com.iqoption.charttools.tools.data;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/tools/data/ActiveIndicatorItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "title", "snippet", "snippetColor", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "(Ljava/lang/String;Ljava/lang/String;ILcom/iqoption/charttools/model/indicator/ChartIndicator;)V", "id", "getId", "()Ljava/lang/String;", "getIndicator", "()Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getSnippet", "getSnippetColor", "()I", "getTitle", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveIndicatorAdapterItems.kt */
public final class a implements d<String> {
    private final String aBL;
    private final int aBM;
    private final h arE;
    private final String id;
    private final String title;

    public a(String str, String str2, int i, h hVar) {
        kotlin.jvm.internal.h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        kotlin.jvm.internal.h.e(str2, "snippet");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        this.title = str;
        this.aBL = str2;
        this.aBM = i;
        this.arE = hVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("indicator:");
        stringBuilder.append(this.arE.KJ().getType());
        stringBuilder.append(':');
        stringBuilder.append(this.arE.getIndex());
        this.id = stringBuilder.toString();
    }

    public final String getTitle() {
        return this.title;
    }

    public final String Oc() {
        return this.aBL;
    }

    public final int Od() {
        return this.aBM;
    }

    public final h JS() {
        return this.arE;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
