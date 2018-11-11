package com.iqoption.newsandupdates;

import android.support.annotation.StringRes;
import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, aXE = {"Lcom/iqoption/newsandupdates/NewsAndUpdatesItem;", "", "type", "Lcom/iqoption/newsandupdates/Type;", "title", "", "description", "checked", "", "(Lcom/iqoption/newsandupdates/Type;IIZ)V", "getChecked", "()Z", "getDescription", "()I", "getTitle", "getType", "()Lcom/iqoption/newsandupdates/Type;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NewsAndUpdatesItem.kt */
public final class f {
    private final Type cXe;
    private final boolean cXf;
    private final int description;
    private final int title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (h.E(this.cXe, fVar.cXe)) {
                if ((this.title == fVar.title ? 1 : null) != null) {
                    if ((this.description == fVar.description ? 1 : null) != null) {
                        if ((this.cXf == fVar.cXf ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Type type = this.cXe;
        int hashCode = (((((type != null ? type.hashCode() : 0) * 31) + this.title) * 31) + this.description) * 31;
        int i = this.cXf;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NewsAndUpdatesItem(type=");
        stringBuilder.append(this.cXe);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", checked=");
        stringBuilder.append(this.cXf);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(Type type, @StringRes int i, @StringRes int i2, boolean z) {
        h.e(type, Param.TYPE);
        this.cXe = type;
        this.title = i;
        this.description = i2;
        this.cXf = z;
    }

    public final Type avn() {
        return this.cXe;
    }

    public final int avo() {
        return this.title;
    }

    public final int avp() {
        return this.description;
    }

    public final boolean getChecked() {
        return this.cXf;
    }
}
