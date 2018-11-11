package com.iqoption.charttools.tools.data;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0000R\u0014\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, aXE = {"Lcom/iqoption/charttools/tools/data/SettingItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "type", "Lcom/iqoption/charttools/tools/data/SettingType;", "isEnabled", "", "(Lcom/iqoption/charttools/tools/data/SettingType;Z)V", "id", "getId", "()Ljava/lang/Integer;", "()Z", "getType", "()Lcom/iqoption/charttools/tools/data/SettingType;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "toggle", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SettingType.kt */
public final class j implements d<Integer> {
    private final SettingType aBT;
    private final int id = this.aBT.ordinal();
    private final boolean isEnabled;

    public static /* bridge */ /* synthetic */ j a(j jVar, SettingType settingType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            settingType = jVar.aBT;
        }
        if ((i & 2) != 0) {
            z = jVar.isEnabled;
        }
        return jVar.a(settingType, z);
    }

    public final j a(SettingType settingType, boolean z) {
        h.e(settingType, Param.TYPE);
        return new j(settingType, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (h.E(this.aBT, jVar.aBT)) {
                if ((this.isEnabled == jVar.isEnabled ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        SettingType settingType = this.aBT;
        int hashCode = (settingType != null ? settingType.hashCode() : 0) * 31;
        int i = this.isEnabled;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SettingItem(type=");
        stringBuilder.append(this.aBT);
        stringBuilder.append(", isEnabled=");
        stringBuilder.append(this.isEnabled);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public j(SettingType settingType, boolean z) {
        h.e(settingType, Param.TYPE);
        this.aBT = settingType;
        this.isEnabled = z;
    }

    public final SettingType Og() {
        return this.aBT;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    /* renamed from: Je */
    public Integer Jf() {
        return Integer.valueOf(this.id);
    }

    public final j Of() {
        return a(this, null, this.isEnabled ^ true, 1, null);
    }
}
