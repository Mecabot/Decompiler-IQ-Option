package com.iqoption.chat.fragment;

import com.iqoption.chat.viewmodel.TransitionViewModel;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "invoke", "com/iqoption/chat/fragment/ImagePreviewSliderFragment$transition$2$2$2"})
/* compiled from: ImagePreviewSliderFragment.kt */
final class ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$2 extends Lambda implements a<l> {
    final /* synthetic */ ObjectRef $enterPreview$inlined;
    final /* synthetic */ ObjectRef $exitPreview$inlined;
    final /* synthetic */ ImagePreviewSliderFragment$transition$2 this$0;

    ImagePreviewSliderFragment$transition$2$$special$$inlined$apply$lambda$2(ImagePreviewSliderFragment$transition$2 imagePreviewSliderFragment$transition$2, ObjectRef objectRef, ObjectRef objectRef2) {
        this.this$0 = imagePreviewSliderFragment$transition$2;
        this.$enterPreview$inlined = objectRef;
        this.$exitPreview$inlined = objectRef2;
        super(0);
    }

    public final void invoke() {
        ObjectRef objectRef = this.$exitPreview$inlined;
        List d = this.this$0.this$0.aGC;
        Object value = this.this$0.this$0.aGD.getValue();
        if (value == null) {
            h.aXZ();
        }
        h.d(value, "current.value!!");
        objectRef.element = (com.iqoption.chat.viewmodel.a) d.get(((Number) value).intValue());
        Object obj = this.$enterPreview$inlined.element;
        if (obj == null) {
            h.lS("enterPreview");
        }
        com.iqoption.chat.viewmodel.a aVar = (com.iqoption.chat.viewmodel.a) obj;
        Object obj2 = this.$exitPreview$inlined.element;
        if (obj2 == null) {
            h.lS("exitPreview");
        }
        if ((h.E(aVar, (com.iqoption.chat.viewmodel.a) obj2) ^ 1) != 0) {
            TransitionViewModel m = this.this$0.this$0.PN();
            obj2 = this.$enterPreview$inlined.element;
            if (obj2 == null) {
                h.lS("enterPreview");
            }
            m.i((com.iqoption.chat.viewmodel.a) obj2);
            m = this.this$0.this$0.PN();
            obj2 = this.$exitPreview$inlined.element;
            if (obj2 == null) {
                h.lS("exitPreview");
            }
            m.h((com.iqoption.chat.viewmodel.a) obj2);
        }
    }
}
