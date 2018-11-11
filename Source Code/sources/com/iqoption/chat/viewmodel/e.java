package com.iqoption.chat.viewmodel;

import android.support.v4.app.NotificationCompat;
import com.iqoption.app.a;
import com.iqoption.microservice.chat.ChatMessageType;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/viewmodel/MessageFilter;", "Lkotlin/Function1;", "Lcom/iqoption/microservice/chat/ChatMessage;", "", "()V", "userId", "", "filter", "", "messages", "invoke", "msg", "(Lcom/iqoption/microservice/chat/ChatMessage;)Ljava/lang/Boolean;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageFilter.kt */
public final class e implements b<g, Boolean> {
    private final long userId = a.Cw().getUserId();

    /* renamed from: f */
    public Boolean invoke(g gVar) {
        h.e(gVar, NotificationCompat.CATEGORY_MESSAGE);
        boolean z = !gVar.aru() && ((!gVar.arv() || gVar.aro() == this.userId) && (gVar.arl() != ChatMessageType.RATE || gVar.arh().arF()));
        return Boolean.valueOf(z);
    }
}
