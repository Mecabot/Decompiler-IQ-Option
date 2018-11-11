package com.iqoption.fragment.leftmenu.content;

import android.support.v4.app.NotificationCompat;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, aXE = {"Lcom/iqoption/fragment/leftmenu/content/ProTraderMenuItem;", "Lcom/iqoption/fragment/leftmenu/content/LeftMenuItem;", "status", "Lcom/iqoption/microservice/regulators/response/StatusType;", "(Lcom/iqoption/microservice/regulators/response/StatusType;)V", "getStatus", "()Lcom/iqoption/microservice/regulators/response/StatusType;", "analyticsEventName", "", "getChild", "index", "", "getChildCount", "getCollapseIcon", "", "getExpandIcon", "getIcon", "getNameToDisplay", "getSize", "isClickable", "", "isEnabled", "isInProgress", "isVisible", "layoutResId", "menuPriority", "name", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderMenuItem.kt */
public final class e implements a {
    private final StatusType cDe;

    public String analyticsEventName() {
        return "";
    }

    public a getChild(int i) {
        return null;
    }

    public int getChildCount() {
        return 0;
    }

    public int getSize() {
        return 1;
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isInProgress() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public int layoutResId() {
        return R.layout.left_menu_item_pro_trader;
    }

    public int menuPriority() {
        return 1;
    }

    public String name() {
        return "pro-trader";
    }

    public e(StatusType statusType) {
        h.e(statusType, NotificationCompat.CATEGORY_STATUS);
        this.cDe = statusType;
    }

    public final StatusType alY() {
        return this.cDe;
    }

    public /* synthetic */ int getCollapseIcon() {
        return ((Number) alX()).intValue();
    }

    public /* synthetic */ int getExpandIcon() {
        return ((Number) alW()).intValue();
    }

    public /* synthetic */ int getIcon() {
        return ((Number) alV()).intValue();
    }

    public /* synthetic */ int getNameToDisplay() {
        return ((Number) alU()).intValue();
    }

    public boolean isClickable() {
        return this.cDe != StatusType.PENDING;
    }

    public Void alU() {
        throw new IllegalStateException("Must not be used");
    }

    public Void alV() {
        throw new IllegalStateException("Must not be used");
    }

    public Void alW() {
        throw new IllegalStateException("Must not be used");
    }

    public Void alX() {
        throw new IllegalStateException("Must not be used");
    }
}
