package com.iqoption.core.util;

import com.iqoption.dto.ChartTimeInterval;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006*"}, aXE = {"Lcom/iqoption/core/util/TimeUtil;", "", "()V", "FORMAT_DAYS_CANDLY", "", "FORMAT_HOURS_CANDLY", "FORMAT_MINUTES_CANDLY", "FORMAT_MONTH_CANDLY", "FORMAT_SEKEND_CANDLY", "FORMAT_WEEK_CANDLY", "SECOND_IN_DAYS", "", "SECOND_IN_HOURS", "SECOND_IN_MINUTES", "SECOND_IN_MONTH", "SECOND_IN_WEEK", "UTC", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "hoursDurationFormat", "Ljava/text/SimpleDateFormat;", "getHoursDurationFormat", "()Ljava/text/SimpleDateFormat;", "setHoursDurationFormat", "(Ljava/text/SimpleDateFormat;)V", "minutesDurationFormat", "getMinutesDurationFormat", "setMinutesDurationFormat", "timeFormat", "getTimeFormat", "setTimeFormat", "timeSecondsFormat", "getTimeSecondsFormat", "setTimeSecondsFormat", "formatAssetTime", "timeSync", "", "schedule", "seconds", "", "formatCandleSize", "formatDuration", "core_release"})
/* compiled from: TimeUtil.kt */
public final class s {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static SimpleDateFormat aDM = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static SimpleDateFormat bhg = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    private static SimpleDateFormat bhh;
    private static SimpleDateFormat bhi;
    public static final s bhj = new s();

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(UTC);
        bhh = simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(UTC);
        bhi = simpleDateFormat;
    }

    private s() {
    }

    public final String ec(int i) {
        StringBuilder stringBuilder;
        if (i >= ChartTimeInterval.CANDLE_1M) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i / ChartTimeInterval.CANDLE_1M);
            stringBuilder.append('M');
            return stringBuilder.toString();
        } else if (i >= ChartTimeInterval.CANDLE_1W) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i / ChartTimeInterval.CANDLE_1W);
            stringBuilder.append('W');
            return stringBuilder.toString();
        } else if (i >= ChartTimeInterval.CANDLE_1D) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i / ChartTimeInterval.CANDLE_1D);
            stringBuilder.append('D');
            return stringBuilder.toString();
        } else if (i >= ChartTimeInterval.CANDLE_1H) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i / ChartTimeInterval.CANDLE_1H);
            stringBuilder.append('H');
            return stringBuilder.toString();
        } else if (i >= 60) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i / 60);
            stringBuilder.append('m');
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append('s');
            return stringBuilder2.toString();
        }
    }
}
