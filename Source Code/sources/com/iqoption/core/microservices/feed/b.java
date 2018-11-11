package com.iqoption.core.microservices.feed;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/microservices/feed/FeedbackAction;", "", "documentId", "", "action", "(II)V", "getAction", "()I", "getDocumentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_release"})
/* compiled from: FeedRequests.kt */
final class b {
    @SerializedName("document_id")
    private final int aVO;
    @SerializedName("action")
    private final int action;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if ((this.aVO == bVar.aVO ? 1 : null) != null) {
                if ((this.action == bVar.action ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.aVO * 31) + this.action;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FeedbackAction(documentId=");
        stringBuilder.append(this.aVO);
        stringBuilder.append(", action=");
        stringBuilder.append(this.action);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(int i, int i2) {
        this.aVO = i;
        this.action = i2;
    }
}
