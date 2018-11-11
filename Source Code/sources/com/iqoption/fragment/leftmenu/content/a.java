package com.iqoption.fragment.leftmenu.content;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import com.google.common.base.j;

/* compiled from: LeftMenuItem */
public interface a {
    public static final j<a> cDc = c.$instance;
    public static final j<a> cDd = d.$instance;

    String analyticsEventName();

    a getChild(int i);

    int getChildCount();

    @DrawableRes
    int getCollapseIcon();

    @DrawableRes
    int getExpandIcon();

    @DrawableRes
    int getIcon();

    @StringRes
    int getNameToDisplay();

    int getSize();

    boolean isClickable();

    boolean isEnabled();

    boolean isInProgress();

    boolean isVisible();

    @LayoutRes
    int layoutResId();

    int menuPriority();

    String name();
}
