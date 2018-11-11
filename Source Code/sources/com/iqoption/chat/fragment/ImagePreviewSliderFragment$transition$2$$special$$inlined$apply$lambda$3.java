package com.iqoption.chat.fragment;

import android.view.View;
import com.iqoption.chat.viewmodel.TransitionViewModel;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "invoke", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$transition$2$2$3"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$3 extends Lambda implements a<l> {
    final /* synthetic */ ObjectRef $enterPreview$inlined;
    final /* synthetic */ ObjectRef $exitPreview$inlined;
    final /* synthetic */ ImagePreviewSliderFragment$transition$2 this$0;

    ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$3(ImagePreviewSliderFragment$transition$2 imagePreviewSliderFragment$transition$2, ObjectRef objectRef, ObjectRef objectRef2) {
        this.this$0 = imagePreviewSliderFragment$transition$2;
        this.$enterPreview$inlined = objectRef;
        this.$exitPreview$inlined = objectRef2;
        super(0);
    }

    public final void invoke() {
        View root = m.l(this.this$0.this$0).getRoot();
        h.d(root, "binding.root");
        root.setAlpha(0.0f);
        TransitionViewModel m = this.this$0.this$0.PN();
        Object obj = this.$exitPreview$inlined.element;
        if (obj == null) {
            h.lS("exitPreview");
        }
        m.i((com.iqoption.chat.viewmodel.a) obj);
    }
}
