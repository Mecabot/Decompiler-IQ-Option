package com.iqoption.charttools.constructor;

import com.iqoption.charttools.model.indicator.constructor.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/constructor/InputGroupTitle;", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "id", "", "text", "", "isExpandable", "", "isExpanded", "group", "Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "(ILjava/lang/String;ZZLcom/iqoption/charttools/model/indicator/constructor/InputGroup;)V", "getGroup", "()Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "()Z", "setExpanded", "(Z)V", "getText", "()Ljava/lang/String;", "techtools_release"})
/* compiled from: InputAdapterItems.kt */
public final class l extends d {
    private final c aus;
    private final boolean isExpandable;
    private boolean isExpanded;
    private final String text;

    public final String getText() {
        return this.text;
    }

    public final boolean Lg() {
        return this.isExpandable;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public final c Lh() {
        return this.aus;
    }

    public l(int i, String str, boolean z, boolean z2, c cVar) {
        h.e(str, "text");
        h.e(cVar, "group");
        super(i, null);
        this.text = str;
        this.isExpandable = z;
        this.isExpanded = z2;
        this.aus = cVar;
    }
}
