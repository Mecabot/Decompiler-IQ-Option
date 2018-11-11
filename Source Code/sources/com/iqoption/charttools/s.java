package com.iqoption.charttools;

import com.iqoption.charttools.r.b;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/TemplateRemoved;", "Lcom/iqoption/charttools/TemplateEvent;", "id", "", "(J)V", "getId", "()J", "asUpdate", "Lcom/iqoption/charttools/TemplateManager$TemplatesUpdate;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "techtools_release"})
/* compiled from: TemplateManager.kt */
public final class s extends q {
    private final long id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            if ((this.id == ((s) obj).id ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateRemoved(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public s(long j) {
        super();
        this.id = j;
    }

    public b Ks() {
        return new b(null, Long.valueOf(this.id), null, null, 13, null);
    }
}
