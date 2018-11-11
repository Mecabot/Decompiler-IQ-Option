package com.iqoption.chat.fragment;

import android.net.Uri;
import java.io.File;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Ljava/io/File;", "invoke", "com/iqoption/chat/fragment/AttachmentPickerFragment$takeFile$1$f$1"})
/* compiled from: AttachmentPickerFragment.kt */
final class AttachmentPickerFragment$takeFile$$inlined$commitNow$lambda$1 extends Lambda implements b<File, l> {
    final /* synthetic */ a this$0;

    AttachmentPickerFragment$takeFile$$inlined$commitNow$lambda$1(a aVar) {
        this.this$0 = aVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        p((File) obj);
        return l.etX;
    }

    public final void p(File file) {
        h.e(file, "it");
        a.a(this.this$0, l.cr(Uri.fromFile(file)), false, 2, null);
    }
}
