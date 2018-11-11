package com.iqoption.menu;

import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/menu/PersonalInfoTab;", "", "view", "Landroid/view/View;", "visible", "", "(Landroid/view/View;Z)V", "getView", "()Landroid/view/View;", "getVisible", "()Z", "setVisible", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PersonalInfoTab.kt */
public final class a {
    private final View view;
    private boolean visible;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.view, aVar.view)) {
                if ((this.visible == aVar.visible ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        View view = this.view;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        int i = this.visible;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersonalInfoTab(view=");
        stringBuilder.append(this.view);
        stringBuilder.append(", visible=");
        stringBuilder.append(this.visible);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(View view, boolean z) {
        h.e(view, Promotion.ACTION_VIEW);
        this.view = view;
        this.visible = z;
    }

    public final boolean aqT() {
        return this.visible;
    }

    public final View getView() {
        return this.view;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }
}
