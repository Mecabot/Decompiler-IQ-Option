package com.crashlytics.android.core;

import io.fabric.sdk.android.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProcMapEntryParser */
final class al {
    private static final Pattern vI = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    public static ak bj(String str) {
        Matcher matcher = vI.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long longValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new ak(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
        } catch (Exception unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not parse map entry: ");
            stringBuilder.append(str);
            c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            return null;
        }
    }
}
