package com.iqoption.chat.component;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/component/ResultEvent;", "", "time", "", "success", "", "error", "", "(JZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "getTime", "()J", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ResultEvent.kt */
public class ag {
    private final String error;
    private final boolean success;
    private final long time;

    public ag(long j, boolean z, String str) {
        this.time = j;
        this.success = z;
        this.error = str;
    }

    public final boolean Pg() {
        return this.success;
    }

    public final String getError() {
        return this.error;
    }

    public final long getTime() {
        return this.time;
    }
}
