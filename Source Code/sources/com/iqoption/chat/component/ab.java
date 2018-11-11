package com.iqoption.chat.component;

import android.databinding.ViewDataBinding;
import com.iqoption.microservice.chat.g;
import kotlin.e.a;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, aXE = {"Lcom/iqoption/chat/component/MessageViewHolder;", "T", "Landroid/databinding/ViewDataBinding;", "Lcom/iqoption/chat/component/ViewHolder;", "binding", "(Landroid/databinding/ViewDataBinding;)V", "<set-?>", "Lcom/iqoption/microservice/chat/ChatMessage;", "message", "getMessage", "()Lcom/iqoption/microservice/chat/ChatMessage;", "setMessage", "(Lcom/iqoption/microservice/chat/ChatMessage;)V", "message$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageViewHolders.kt */
public class ab<T extends ViewDataBinding> extends ax<T> {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(ab.class), "message", "getMessage()Lcom/iqoption/microservice/chat/ChatMessage;"))};
    private final d aDB = a.euA.aYg();

    public final g OR() {
        return (g) this.aDB.b(this, apP[0]);
    }

    public final void a(g gVar) {
        h.e(gVar, "<set-?>");
        this.aDB.a(this, apP[0], gVar);
    }

    public ab(T t) {
        h.e(t, "binding");
        super(t);
    }
}
