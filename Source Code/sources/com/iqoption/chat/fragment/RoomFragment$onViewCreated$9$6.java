package com.iqoption.chat.fragment;

import java.text.SimpleDateFormat;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"formatSubTitle", "", "sender", "date", "", "invoke"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$9$6 extends Lambda implements m<String, Long, String> {
    final /* synthetic */ SimpleDateFormat $dateFormatter;

    RoomFragment$onViewCreated$9$6(SimpleDateFormat simpleDateFormat) {
        this.$dateFormatter = simpleDateFormat;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return g((String) obj, ((Number) obj2).longValue());
    }

    public final String g(String str, long j) {
        h.e(str, "sender");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(this.$dateFormatter.format(Long.valueOf(j)));
        return stringBuilder.toString();
    }
}
