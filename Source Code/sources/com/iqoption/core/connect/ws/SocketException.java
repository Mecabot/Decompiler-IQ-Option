package com.iqoption.core.connect.ws;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/connect/ws/SocketException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "core_release"})
/* compiled from: SocketException.kt */
public final class SocketException extends RuntimeException {
    public SocketException() {
        this(null, null, 3, null);
    }

    public /* synthetic */ SocketException(String str, Throwable th, int i, f fVar) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        if ((i & 2) != 0) {
            th = (Throwable) null;
        }
        this(str, th);
    }

    public SocketException(String str, Throwable th) {
        super(str, th);
    }
}
