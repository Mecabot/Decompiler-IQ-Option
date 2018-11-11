package com.iqoption.util;

import android.support.annotation.IntRange;
import android.support.annotation.StringRes;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, aXE = {"getTranslateDay", "", "day", "Lcom/iqoption/core/microservices/risks/response/overnightfee/Day;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DayUtil.kt */
public final class o {
    @StringRes
    public static final int gE(@IntRange(from = 1, to = 7) int i) {
        switch (i) {
            case 1:
                return R.string.short_week_day_sun;
            case 2:
                return R.string.short_week_day_mon;
            case 3:
                return R.string.short_week_day_tue;
            case 4:
                return R.string.short_week_day_wed;
            case 5:
                return R.string.short_week_day_thu;
            case 6:
                return R.string.short_week_day_fri;
            case 7:
                return R.string.short_week_day_sat;
            default:
                return R.string.n_a;
        }
    }
}
