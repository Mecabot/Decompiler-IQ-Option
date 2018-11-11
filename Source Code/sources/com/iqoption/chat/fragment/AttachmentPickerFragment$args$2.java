package com.iqoption.chat.fragment;

import android.os.Bundle;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/os/Bundle;", "invoke"})
/* compiled from: AttachmentPickerFragment.kt */
final class AttachmentPickerFragment$args$2 extends Lambda implements a<Bundle> {
    final /* synthetic */ a this$0;

    AttachmentPickerFragment$args$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: Px */
    public final Bundle invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
