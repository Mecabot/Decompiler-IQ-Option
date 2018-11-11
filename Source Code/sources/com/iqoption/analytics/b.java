package com.iqoption.analytics;

import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0012 \u0006*\b\u0018\u00010\u0004R\u00020\u00050\u0004R\u00020\u0005J\u0016\u0010\u0007\u001a\u0012 \u0006*\b\u0018\u00010\u0004R\u00020\u00050\u0004R\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0004R\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0012\u0010\u000f\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0004R\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0013"}, aXE = {"Lcom/iqoption/analytics/ChatsEventHelper;", "", "()V", "createMainPage", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "kotlin.jvm.PlatformType", "createQuestionSignPopup", "sendMainPage", "", "builder", "sendOpenRoom", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "sendQuestionSign", "sendQuestionSignPopup", "sendReturn", "sendSearchChat", "sendSendMessage", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatsEventHelper.kt */
public final class b {
    public static final b aiV = new b();

    private b() {
    }

    public final Builder Bf() {
        return Event.Builder(Event.CATEGORY_SCREEN_OPENED, "chat_main-page");
    }

    public final void a(Builder builder) {
        h.e(builder, "builder");
        EventManager.Bm().a(builder.calcDuration().build());
    }

    public final void Bg() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "chat_return").build());
    }

    public final void Bh() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "chat_search-chat").build());
    }

    public final void a(n nVar) {
        h.e(nVar, "room");
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "chat_open-room").setParameters(com.iqoption.core.util.i.ZZ().l("room_id", nVar.getId()).l("room_locale", nVar.getLocale()).l("room_is_regulated", Boolean.valueOf(nVar.Dh())).l("room_is_public", Boolean.valueOf(nVar.isPublic())).l("room_type", nVar.Qh().name()).aab()).build());
    }

    public final void b(n nVar) {
        h.e(nVar, "room");
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "chat_send-message").setParameters(com.iqoption.core.util.i.ZZ().l("room_id", nVar.getId()).l("room_locale", nVar.getLocale()).l("room_is_regulated", Boolean.valueOf(nVar.Dh())).l("room_is_public", Boolean.valueOf(nVar.isPublic())).l("room_type", nVar.Qh().name()).aab()).build());
    }

    public final void Bi() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "chat_question-sign").build());
    }

    public final Builder Bj() {
        return Event.Builder(Event.CATEGORY_POPUP_SERVED, "chat_question-sign-popup");
    }

    public final void b(Builder builder) {
        h.e(builder, "builder");
        EventManager.Bm().a(builder.calcDuration().build());
    }
}
