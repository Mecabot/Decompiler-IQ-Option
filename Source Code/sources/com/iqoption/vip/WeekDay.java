package com.iqoption.vip;

import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/vip/WeekDay;", "", "mapValue", "", "nameId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getMapValue", "()Ljava/lang/String;", "getNameId", "()I", "MON", "TUE", "WED", "THU", "FRI", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WeekDay.kt */
public enum WeekDay {
    MON("1", R.string.short_week_day_mon),
    TUE("2", R.string.short_week_day_tue),
    WED("3", R.string.short_week_day_wed),
    THU("4", R.string.short_week_day_thu),
    FRI("5", R.string.short_week_day_fri);
    
    private final String mapValue;
    private final int nameId;

    protected WeekDay(String str, int i) {
        h.e(str, "mapValue");
        this.mapValue = str;
        this.nameId = i;
    }

    public final String getMapValue() {
        return this.mapValue;
    }

    public final int getNameId() {
        return this.nameId;
    }
}
