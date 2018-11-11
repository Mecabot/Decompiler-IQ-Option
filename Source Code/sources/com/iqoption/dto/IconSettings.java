package com.iqoption.dto;

import android.graphics.Point;
import android.support.annotation.DrawableRes;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lcom/iqoption/dto/IconSettings;", "", "icon", "", "size", "Landroid/graphics/Point;", "(ILandroid/graphics/Point;)V", "getIcon", "()I", "getSize", "()Landroid/graphics/Point;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ToastEntity.kt */
public final class IconSettings {
    private final int icon;
    private final Point size;

    public IconSettings() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ IconSettings copy$default(IconSettings iconSettings, int i, Point point, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iconSettings.icon;
        }
        if ((i2 & 2) != 0) {
            point = iconSettings.size;
        }
        return iconSettings.copy(i, point);
    }

    public final int component1() {
        return this.icon;
    }

    public final Point component2() {
        return this.size;
    }

    public final IconSettings copy(@DrawableRes int i, Point point) {
        return new IconSettings(i, point);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IconSettings) {
            IconSettings iconSettings = (IconSettings) obj;
            return (this.icon == iconSettings.icon ? 1 : null) != null && h.E(this.size, iconSettings.size);
        }
    }

    public int hashCode() {
        int i = this.icon * 31;
        Point point = this.size;
        return i + (point != null ? point.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IconSettings(icon=");
        stringBuilder.append(this.icon);
        stringBuilder.append(", size=");
        stringBuilder.append(this.size);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public IconSettings(@DrawableRes int i, Point point) {
        this.icon = i;
        this.size = point;
    }

    public final int getIcon() {
        return this.icon;
    }

    public /* synthetic */ IconSettings(int i, Point point, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            i = R.drawable.ic_toast_action;
        }
        if ((i2 & 2) != 0) {
            point = (Point) null;
        }
        this(i, point);
    }

    public final Point getSize() {
        return this.size;
    }
}
