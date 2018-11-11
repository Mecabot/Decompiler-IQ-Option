package com.iqoption.chat.fragment;

import com.iqoption.chat.viewmodel.c;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/viewmodel/FileItem;", "invoke", "com/iqoption/chat/fragment/FilePickerFragment$onCreateView$1$adapter$1"})
/* compiled from: FilePickerFragment.kt */
final class FilePickerFragment$onCreateView$$inlined$apply$lambda$1 extends Lambda implements b<c, l> {
    final /* synthetic */ k this$0;

    FilePickerFragment$onCreateView$$inlined$apply$lambda$1(k kVar) {
        this.this$0 = kVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        c((c) obj);
        return l.etX;
    }

    public final void c(c cVar) {
        h.e(cVar, "it");
        if (cVar.getFile().isDirectory()) {
            k.a(this.this$0).r(cVar.getFile());
        } else {
            this.this$0.q(cVar.getFile());
        }
    }
}
