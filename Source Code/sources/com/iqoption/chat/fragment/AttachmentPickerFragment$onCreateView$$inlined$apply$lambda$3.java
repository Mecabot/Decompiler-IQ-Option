package com.iqoption.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.iqoption.app.a.b;
import com.iqoption.chat.viewmodel.a;
import com.iqoption.d.by;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/iqoption/databinding/ChatAttachmentImageItemBinding;", "preview", "Lcom/iqoption/chat/viewmodel/AttachmentPreview;", "invoke", "com/iqoption/chat/fragment/AttachmentPickerFragment$onCreateView$1$adapter$1"})
/* compiled from: AttachmentPickerFragment.kt */
final class AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$3 extends Lambda implements m<by, a, Boolean> {
    final /* synthetic */ FragmentActivity $activity$inlined;
    final /* synthetic */ Bundle $savedInstanceState$inlined;
    final /* synthetic */ a this$0;

    AttachmentPickerFragment$onCreateView$$inlined$apply$lambda$3(a aVar, FragmentActivity fragmentActivity, Bundle bundle) {
        this.this$0 = aVar;
        this.$activity$inlined = fragmentActivity;
        this.$savedInstanceState$inlined = bundle;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Boolean.valueOf(a((by) obj, (a) obj2));
    }

    public final boolean a(by byVar, a aVar) {
        h.e(byVar, "<anonymous parameter 0>");
        h.e(aVar, "preview");
        Integer num = (Integer) a.b(this.this$0).QC().getValue();
        if (num == null || num.intValue() != 3 || aVar.isSelected()) {
            a.b(this.this$0).g(aVar);
            return true;
        }
        b.eQ(this.this$0.getString(R.string.you_can_send_maximum));
        return false;
    }
}
