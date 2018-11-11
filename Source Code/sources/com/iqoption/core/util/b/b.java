package com.iqoption.core.util.b;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/util/thread/NullHandler;", "Landroid/os/Handler;", "()V", "dispatchMessage", "", "msg", "Landroid/os/Message;", "getMessageName", "", "message", "handleMessage", "sendMessageAtTime", "", "uptimeMillis", "", "core_release"})
/* compiled from: NullHandler.kt */
public final class b extends Handler {
    public static final b bhz = new b();

    public void dispatchMessage(Message message) {
        h.e(message, NotificationCompat.CATEGORY_MESSAGE);
    }

    public String getMessageName(Message message) {
        h.e(message, "message");
        return "";
    }

    public void handleMessage(Message message) {
        h.e(message, NotificationCompat.CATEGORY_MESSAGE);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        h.e(message, NotificationCompat.CATEGORY_MESSAGE);
        return false;
    }

    private b() {
    }
}
