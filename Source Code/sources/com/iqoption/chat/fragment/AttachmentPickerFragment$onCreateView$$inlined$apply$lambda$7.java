package com.iqoption.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.iqoption.chat.component.c;
import com.iqoption.chat.viewmodel.f;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/viewmodel/SelectEvent;", "kotlin.jvm.PlatformType", "invoke", "com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$7"})
/* compiled from: AttachmentPickerFragment.kt */
final class AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$7 extends Lambda implements b<f, l> {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ c $adapter;
    final /* synthetic */ Bundle $savedInstanceState$inlined;
    final /* synthetic */ a this$0;

    AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$7(c cVar, a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
        this.$adapter = cVar;
        this.this$0 = aVar;
        this.$activity$inlined = fragmentActivity;
        this.$savedInstanceState$inlined = bundle;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((f) obj);
        return l.etX;
    }

    public final void b(f fVar) {
        this.this$0.aFs = fVar.getTime();
        this.$adapter.b(fVar.Rw());
    }
}
