package com.iqoption.charttools.tools;

import android.support.v4.app.NotificationCompat;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/tools/ShowToast;", "Lcom/iqoption/charttools/tools/Event;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ToolsViewModel.kt */
public final class b extends a {
    private final String abQ;

    public b(String str) {
        h.e(str, NotificationCompat.CATEGORY_MESSAGE);
        super();
        this.abQ = str;
    }

    public final String MY() {
        return this.abQ;
    }
}
