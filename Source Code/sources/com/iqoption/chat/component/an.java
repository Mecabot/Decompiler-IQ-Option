package com.iqoption.chat.component;

import com.iqoption.d.em;
import kotlin.e.a;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/component/SuggestionViewHolder;", "Lcom/iqoption/chat/component/ViewHolder;", "Lcom/iqoption/databinding/ChatSuggestionMessageItemBinding;", "binding", "(Lcom/iqoption/databinding/ChatSuggestionMessageItemBinding;)V", "<set-?>", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "suggestion", "getSuggestion", "()Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "setSuggestion", "(Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;)V", "suggestion$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageViewHolders.kt */
public final class an extends ax<em> {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(an.class), "suggestion", "getSuggestion()Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;"))};
    private final d aFj = a.euA.aYg();

    public final com.iqoption.core.microservices.b.a.a Ps() {
        return (com.iqoption.core.microservices.b.a.a) this.aFj.b(this, apP[0]);
    }

    public final void a(com.iqoption.core.microservices.b.a.a aVar) {
        h.e(aVar, "<set-?>");
        this.aFj.a(this, apP[0], aVar);
    }

    public an(em emVar) {
        h.e(emVar, "binding");
        super(emVar);
    }
}
