package com.iqoption.chat.component;

import android.databinding.ViewDataBinding;
import kotlin.e.a;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/component/AttachmentViewHolder;", "T", "Landroid/databinding/ViewDataBinding;", "Lcom/iqoption/chat/component/MessageViewHolder;", "binding", "(Landroid/databinding/ViewDataBinding;)V", "<set-?>", "Lcom/iqoption/microservice/chat/ChatAttachment;", "attachment", "getAttachment", "()Lcom/iqoption/microservice/chat/ChatAttachment;", "setAttachment", "(Lcom/iqoption/microservice/chat/ChatAttachment;)V", "attachment$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageViewHolders.kt */
public class d<T extends ViewDataBinding> extends ab<T> {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "attachment", "getAttachment()Lcom/iqoption/microservice/chat/ChatAttachment;"))};
    private final kotlin.e.d aDb = a.euA.aYg();

    public final com.iqoption.microservice.chat.a Oy() {
        return (com.iqoption.microservice.chat.a) this.aDb.b(this, apP[0]);
    }

    public final void a(com.iqoption.microservice.chat.a aVar) {
        h.e(aVar, "<set-?>");
        this.aDb.a(this, apP[0], aVar);
    }

    public d(T t) {
        h.e(t, "binding");
        super(t);
    }
}
