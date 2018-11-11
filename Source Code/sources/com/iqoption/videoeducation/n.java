package com.iqoption.videoeducation;

import com.iqoption.core.microservices.videoeducation.response.f;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, aXE = {"Lcom/iqoption/videoeducation/VideoTagItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "tag", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "isSelected", "", "(Lcom/iqoption/core/microservices/videoeducation/response/Tag;Z)V", "id", "getId", "()Ljava/lang/Long;", "()Z", "getTag", "()Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoTagItem.kt */
public final class n implements d<Long> {
    private final f dzi;
    private final boolean isSelected;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (h.E(this.dzi, nVar.dzi)) {
                if ((this.isSelected == nVar.isSelected ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        f fVar = this.dzi;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        int i = this.isSelected;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoTagItem(tag=");
        stringBuilder.append(this.dzi);
        stringBuilder.append(", isSelected=");
        stringBuilder.append(this.isSelected);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public n(f fVar, boolean z) {
        h.e(fVar, "tag");
        this.dzi = fVar;
        this.isSelected = z;
    }

    public final f aHO() {
        return this.dzi;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    /* renamed from: getId */
    public Long Jf() {
        return Long.valueOf(this.dzi.getId());
    }
}
