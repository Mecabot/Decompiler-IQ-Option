package com.iqoption.chat.component;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.do;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, aXE = {"Lcom/iqoption/chat/component/SimpleRoomBinding;", "Lcom/iqoption/chat/component/RoomBinding;", "binding", "Lcom/iqoption/databinding/ChatItemBinding;", "(Lcom/iqoption/databinding/ChatItemBinding;)V", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "lastMessage", "Landroid/widget/TextView;", "getLastMessage", "()Landroid/widget/TextView;", "lastMessageDate", "getLastMessageDate", "lastMessageUnreadIndicator", "getLastMessageUnreadIndicator", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "title", "getTitle", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomBindings.kt */
public final class al implements ah {
    private final ImageView aEt;
    private final TextView aEu;
    private final TextView aEv;
    private final ImageView aEw;
    private final TextView agA;
    private final View avl;

    public al(do doVar) {
        h.e(doVar, "binding");
        View root = doVar.getRoot();
        h.d(root, "binding.root");
        this.avl = root;
        ImageView imageView = doVar.aEt;
        h.d(imageView, "binding.image");
        this.aEt = imageView;
        TextView textView = doVar.agA;
        h.d(textView, "binding.title");
        this.agA = textView;
        textView = doVar.aEu;
        h.d(textView, "binding.lastMessage");
        this.aEu = textView;
        textView = doVar.aEv;
        h.d(textView, "binding.lastMessageDate");
        this.aEv = textView;
        ImageView imageView2 = doVar.bmM;
        h.d(imageView2, "binding.lastMessageStateIndicator");
        this.aEw = imageView2;
    }

    public View getRoot() {
        return this.avl;
    }

    public ImageView OZ() {
        return this.aEt;
    }

    public TextView Pa() {
        return this.agA;
    }

    public TextView Pb() {
        return this.aEu;
    }

    public TextView Pc() {
        return this.aEv;
    }

    public ImageView Pd() {
        return this.aEw;
    }
}
