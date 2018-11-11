package com.iqoption.charttools.templates;

import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, aXE = {"Lcom/iqoption/charttools/templates/TitleItem;", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "text", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getText", "equals", "", "other", "", "hashCode", "", "techtools_release"})
/* compiled from: InstrumentItems.kt */
public final class o extends d {
    private final String id;
    private final String text;

    public final String getText() {
        return this.text;
    }

    public /* synthetic */ o(String str, String str2, int i, f fVar) {
        if ((i & 2) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("title:");
            stringBuilder.append(str);
            str2 = stringBuilder.toString();
        }
        this(str, str2);
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }

    public o(String str, String str2) {
        h.e(str, "text");
        h.e(str2, "id");
        super();
        this.text = str;
        this.id = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.templates.TitleItem");
        }
        if ((h.E(Jf(), ((o) obj).Jf()) ^ 1) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Jf().hashCode();
    }
}
